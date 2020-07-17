(ns charizard.repository.clojure
  (:require [datomic.client.api :as d])
  (:require [charizard.repository.schema])
  (:gen-class)
  )

(def cfg {:server-type :peer-server
          :access-key "myaccesskey"
          :secret "mysecret"
          :endpoint "localhost:8998"
          :validate-hostnames false})
;; => #'charizard.repository.clojure/cfg


(def client (d/client cfg))

(def conn (d/connect client {:db-name "charizard-db"}))



(def database (d/db conn))




(defn transact
 [entities]
 
  (d/transact conn  {:tx-data entities})
  )
  
(def init  (do (transact charizard.repository.schema/userSchema) 
               (transact charizard.repository.schema/addressSchema)
               )
)

(defn query [criteria] (d/q criteria database))