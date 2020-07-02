(ns charizard.domain.user
(:require [datomic.client.api :as d]) )


(defrecord UserEntity [id name lastname email])
