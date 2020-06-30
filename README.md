#Build image
docker build -t belomx/datomic-pro .

#Run container
docker run -d --name datomic-db belomx/datomic-pro 

or you can map the ports to access by localhost

docker run -d --name datomic-db -p 8090:8090 -p 8999:8999 belomx/datomic-pro

#To create a database
docker exec -it datomic-db bin/repl
(require '[datomic.api :as d])
(def db-uri "datomic:dev://localhost:4334/charizard-project")
(d/create-database db-uri)

#To start datomic console
docker exec -it datomic-db bin/console -p 8090 dev datomic:dev://localhost:4334/

#To create peer server
docker exec -it datomic-db bin/run -m datomic.peer-server -h 172.17.0.3 -p 8999 -a 123,123 -d charizard-project,datomic:dev://localhost:4334/charizard-project

#To test datomic client
(require '[datomic.client.api :as d])

(def cfg {:server-type :peer-server
                 :validate-hostnames false
                 :access-key "123"
                 :secret "123"
                 :endpoint "localhost:8999"})
				 
(def client (d/client cfg))

(def conn (d/connect client {:db-name "charizard-project"}))

(d/transact conn {:tx-data [{:db/doc "pikachu"}]})
