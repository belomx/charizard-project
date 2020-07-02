(defproject charizard "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [com.datomic/client-pro "0.9.57"]
                 [org.clojure/test.check "0.9.0"]
                 ]
  :main ^:skip-aot charizard.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}}
  :plugins [[lein-git-deps "0.0.1-SNAPSHOT"]]
  :git-dependencies [["https://github.com/tobyhede/monger.git"]]
  
  )

