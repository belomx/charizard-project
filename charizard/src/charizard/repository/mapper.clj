(ns charizard.repository.mapper
  (:require [datomic.client.api :as d]
            [charizard.domain.user :as u]))

(defmulti toEntity class)

(defmethod toEntity charizard.domain.user.UserEntity
  [entity] [{
             :user/id (:id entity)
             :user/name (:name entity)
             :user/lastname (:lastname entity)
             :user/email (:email entity)
             :user/address (toEntity (:address entity))
             }])

(defmethod toEntity charizard.domain.user.UserAddress
  [entity]
  {:db/id (bigint (rand-int 100))
   :address/id (:id entity)
   :address/street (:street entity)
   :address/zipcode (:zipcode entity)
   }
  )

 