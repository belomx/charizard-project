(ns charizard.repository.schema
  (:require [datomic.client.api :as d]))

(def userSchema [{:db/ident :user/id
                  :db/valueType :db.type/int
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
                 ])