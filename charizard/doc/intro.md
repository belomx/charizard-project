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
# Install datomic
sudo bin/run -m datomic.peer-server -h localhost -p 8998 -a myaccesskey,mysecret -d charizard-db,datomic:mem://charizard-db