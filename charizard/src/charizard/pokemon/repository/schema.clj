(ns charizard.repository.schema
  (:require [datomic.client.api :as d]))

(def pokemonSchema [{:db/ident :user/id
                  :db/valueType :db.type/bigint
                  :db/cardinality :db.cardinality/one
                  :db/doc "Pokemon Identifier"
                  }
                 {:db/ident :user/name
                  :db/valueType :db.type/string
                  :db/cardinality :db.cardinality/one
                  :db/doc "Pokemon Name"}
                 {:db/ident :user/nnumber
                  :db/valueType :db.type/bigint
                  :db/cardinality :db.cardinality/one
                  :db/doc "Pokemon Number"}
                 ])
