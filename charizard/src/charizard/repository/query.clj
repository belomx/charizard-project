(ns charizard.repository.query
  (:require [charizard.domain.user :as user-domain])
  )

(defrecord User [id name lastname email] 
  charizard.domain.user/Repository
  (user-domain/find-id [this] '[:find  ?name ?lastname ?email
                        :where [?e :user/id (:id this)]
                        [?e :user/name ?name]
                        [?e :user/lastname ?lastname]
                        [?e :user/email ?email]
                        ])
  
  (user-domain/find-by-fulllname [this] '[:find ?id ?name ?lastname ?email
                                             :where [?e :user/id ?id]
                                             [?e :user/name (:name this)]
                                             [?e :user/lastname (:lastname this)]
                                             [?e :user/email ?email]])
  
  (user-domain/find-by-email [this] '[:find ?id ?name ?lastname ?email
                                 :where [?e :user/id ?id]
                                 [?e :user/name ?name]
                                 [?e :user/lastname ?lastname]
                                 [?e :user/email (:email this)]])
  )