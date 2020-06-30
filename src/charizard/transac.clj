(require '[datomic.client.api :as d])

(def cfg {:server-type :peer-server
                 :validate-hostnames false
                 :access-key "123"
                 :secret "123"
                 :endpoint "172.17.0.3:8999"})

(def client (d/client cfg))

(def conn (d/connect client {:db-name "charizard-project"}))
						
						
(d/transact conn
    {:tx-data
     [{
       :db/ident :pokemon/name
       :db/valueType :db.type/string
       :db/unique :db.unique/identity
       :db/cardinality :db.cardinality/one},
	   {
       :db/ident :pokemon/type
       :db/valueType :db.type/string
       :db/unique :db.unique/identity
       :db/cardinality :db.cardinality/one},
	   {
       :db/ident :pokemon/generation
       :db/valueType :db.type/long
       :db/unique :db.unique/identity
       :db/cardinality :db.cardinality/one}]})
						
(def result (d/transact conn {:tx-data [[:db/add "4" :pokemon/name "charmander"
                                                     :pokemon/type "fire"
                                                     :pokemon/generation 1]]}))

(def result (d/transact conn {:tx-data [{:db/id "5"
                                         :pokemon/name "charmilion"
                                         :pokemon/type "fire"
                                         :pokemon/generation 1}]}))
										 
(-> result :tempids (get "4"))
