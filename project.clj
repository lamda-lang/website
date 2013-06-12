(defproject lamda "0.1.0-SNAPSHOT"
  :description "lamda-lang homepage n stuff"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  ;; CLJ source code path
  :source-paths ["src/clj"]
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [ring/ring-jetty-adapter "1.1.0"]
                 [com.cemerick/piggieback "0.0.4"]
                 [hiccup "1.0.3"]
                 [compojure "1.1.5"]
                 [cssgen "0.3.0-SNAPSHOT"]]

  :ring {:handler lamda.server.routes/app}

  :plugins [[lein-ring "0.8.3"]]
)
