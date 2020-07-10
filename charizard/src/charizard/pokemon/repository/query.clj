(ns charizard.pokemon.repository.query
  (:require [charizard.pokemon.domain.pokemon :as pokemon-domain])
  )

(defrecord Pokemon [id name number] 
  charizard.pokemon.domain.pokemon/Repository
  (pokemon-domain/find-id [this] '[:find ?id ?name ?number
                        :where [?e :pokemon/id (:id this)]
                        [?e :pokemon/name ?name]
                        [?e :pokemon/number ?lastname]
                        ])
  
  (pokemon-domain/find-by-name [this] '[:find ?id ?name ?number
                                             :where [?e :pokemon/id ?id]
                                             [?e :pokemon/name (:name this)]
                                             [?e :pokemon/number (:number this)]])
  
  (pokemon-domain/find-by-number [this] '[:find ?id ?name ?number
                                 :where [?e :pokemon/id ?id]
                                 [?e :pokemon/name ?name]
                                 [?e :pokemon/number ?number]]))
