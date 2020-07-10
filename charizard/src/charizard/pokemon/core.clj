(ns charizard.pokemon.core
  (:require [datomic.client.api :as d])
  (:require [charizard.pokemon.domain.pokemon :as pokemon])
  (:require [charizard.pokemon.repository.schema])
  (:require [charizard.pokemon.repository.query])
  (:require [charizard.pokemon.repository.mapper])
  (:require [charizard.pokemon.repository.clojure])
  (:gen-class))

(def start 
  (do charizard.pokemon.repository.clojure/init 
      (-> (pokemon/->PokemonEntity (bigint 6) "Charmander" (bigint 1))
          charizard.pokemon.repository.mapper/toEntity
          charizard.pokemon.repository.clojure/transact)) 
  )

(def query
  (charizard.pokemon.repository.clojure/query (pokemon/find-id (charizard.pokemon.repository.query/->Pokemon (bigint 6) "Charmander")))
  
  )

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

