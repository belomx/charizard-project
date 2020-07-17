(ns charizard.core
  (:require [datomic.client.api :as d])
  (:require [charizard.domain.user :as user])
  (:require [charizard.repository.schema])
  (:require [charizard.repository.query])
  (:require [charizard.repository.mapper])
  (:require [charizard.repository.clojure])
  (:gen-class))

  

 (def start 
  (do charizard.repository.clojure/init 
      (-> (charizard.domain.user/->UserEntity (bigint 1) "Rodrigo" "Fudissaku" "rodrigofudissaku@gmail.com"
                                              (charizard.domain.user/->UserAddress (bigint 1) "Manoel" "06020194"))

          charizard.repository.mapper/toEntity
          charizard.repository.clojure/transact)) 
 )

(def query
  (charizard.repository.clojure/query 
   (user/find-id 
    (charizard.repository.query/map->User {:id (bigint 3) :name "Rodrigo"})))
  
  )

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

