(ns charizard.repository.clojure
  (:require [datomic.client.api :as d])
)

(def cfg {:server-type :peer-server
          :access-key "myaccesskey"
          :secret "mysecret"
          :endpoint "localhost:8998"
          :validate-hostnames false})

(def client (d/client cfg))

(def conn (d/connect client {:db-name "charizard-db"}))

(def db (d/db conn)) 



(defn transact
 [entities]
  (d/transact conn  {:tx-data entities})
  )
  