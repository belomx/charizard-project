(ns charizard.core
  (:require [datomic.client.api :as d])
  (:require [charizard.repository.schema])
  (:require [charizard.repository.mapper])
  (:require [charizard.repository.clojure])
  (:gen-class))

(defn start []
 (do charizard.repository.clojure/init 
     (-> (charizard.domain.user/->UserEntity (bigint 3) "Rodrigo" "Fudissaku" "mari@gmail.com")
         charizard.repository.mapper/toEntity
         charizard.repository.clojure/transact)) 
  )

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

