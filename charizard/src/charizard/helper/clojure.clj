(ns charizard.helper.clojure )

(defn make-idents
  [x]
  (mapv #(hash-map :db/ident %) x))