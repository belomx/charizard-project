
# Introduction to charizard

TODO: write [great documentation](http://jacobian.org/writing/what-to-write/)

# Go to folder
cd
cd datomic-pro-1.0.6165/

# Grant access to +rwx
cd bin
chmod +rwx classpath

# Grant access to +rwx
chmod +rwx run

cd ..

# run transactor
setup license 
 https://docs.datomic.com/on-prem/dev-setup.html


# Install datomic
sudo bin/run -m datomic.peer-server -h localhost -p 8998 -a myaccesskey,mysecret -d charizard-db,datomic:mem://charizard-db


sudo bin/run -m datomic.peer-server -h localhost -p 8998 -a myaccesskey,mysecret -d charizard-db,datomic:dev://localhost:4334/charizard-db

# console 
sudo chmod +rwx bin/console
bin/console -p 8080 dev datomic:dev://localhost:4334/


bin/transactor config/samples/dev-transactor-template.properties

#run console
bin/console -p 8080 charizard datomic:dev://localhost:4334/