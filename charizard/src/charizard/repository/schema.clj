(ns charizard.repository.schema
  (:require [datomic.client.api :as d]))

(def addressSchema [{
                     :db/ident :address/id
                  :db/valueType :db.type/bigint
                  :db/cardinality :db.cardinality/one
                  :db/doc "Address Identifier"}
                 {:db/ident :address/street
                  :db/valueType :db.type/string
                  :db/cardinality :db.cardinality/one
                  :db/doc "Address Street"}
                 {:db/ident :address/zipcode
                  :db/valueType :db.type/string
                  :db/cardinality :db.cardinality/one
                  :db/doc "Zipcode"}
               ])

(def userSchema [{:db/ident :user/id
                  :db/valueType :db.type/bigint
                  :db/cardinality :db.cardinality/one
                  :db/doc "User Identifier"
                  }
                 {:db/ident :user/name
                  :db/valueType :db.type/string
                  :db/cardinality :db.cardinality/one
                  :db/doc "User Name"}
                 {:db/ident :user/lastname
                  :db/valueType :db.type/string
                  :db/cardinality :db.cardinality/one
                  :db/doc "User Last Name"}
                 {:db/ident :user/email
                  :db/valueType :db.type/string
                  :db/cardinality :db.cardinality/one
                  :db/doc "EmailAddress"}
                 {
                  :db/ident :user/address
                  :db/valueType :db.type/ref
                  :db/cardinality :db.cardinality/one
                  :db/doc "Address"}
                 ])
;; => #'charizard.repository.schema/userSchema
