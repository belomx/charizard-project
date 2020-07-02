(ns charizard.repository.mapper
  (:require [datomic.client.api :as d]
            [charizard.domain.user :as u]))

(defn thanks [] (charizard.domain.user.UserEntity. "A" "B" "C"))

(defmulti toEntity class)

(defmethod toEntity charizard.domain.user.UserEntity
  [entity] {:user/id (:id entity)
            :user/name (:name entity)
            :user/lastname (:lastname entity)
            :user/email (:email entity)})

