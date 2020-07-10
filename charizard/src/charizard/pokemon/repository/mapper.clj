(ns charizard.repository.mapper
  (:require [datomic.client.api :as d]
            [charizard.pokemon.domain.pokemon :as u]))

(defmulti toEntity class)

(defmethod toEntity charizard.pokemon.domain.pokemon.PokemonEntity
  [entity] [{:pokemon/id (:id entity)
             :pokemon/name (:name entity)
             :pokemon/number (:number entity)}])

