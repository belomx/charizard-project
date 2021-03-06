(ns charizard.domain.user
(:require [datomic.client.api :as d]) )

(defrecord UserAddress [id street zipcode])

(defrecord UserEntity [id name lastname email address])

(defprotocol Repository
  "Protocol for query Users"
  (find-id [this] "Find Users per id")
  (find-by-fulllname [this] "Find Users by their full name")
  (find-by-email [this] "Find users by email")
  )
