(ns charizard.pokemon.domain.pokemon
(:require [datomic.client.api :as d]) )


(defrecord PokemonEntity [id name number])

(defprotocol Repository
  "Protocol for query pokemons"
  (find-id [this] "Find Users per id")
  (find-by-name [this] "Find pokemon by name")
  (find-by-number [this] "Find users by number"))

