(ns lamda.server.views
  (:require
    [hiccup
      [page :refer [html5]]
      [element :refer [javascript-tag]]
     [page :refer [include-js]]]
    [garden.core :refer [css]]))

(defn- run-clojurescript [path init]
  (list
   (include-js path)
   (javascript-tag init)))

(def html-background-color "#e5e5e5")
(def background-color "#1a1a1a")
(def hover-background-color "#8C0806")


(defn header-css []
  [:#header
   {:background background-color
    :color "#ffffff"
    :margin "0"
    :text-align "center"
    :font-size "large"
    :height "150px"}
   [:h1
    {:padding "0px"
     :margin "0"}]])


(defn body-css []
  [:body :html
    {:font "16px sans-serif"
     :margin "0"
     :padding "0"
     :color "#000000"
     :background html-background-color}])


(defn default-css []
  (css
   (body-css)
   (header-css)))


(defn index-page []
  (html5
   [:head
    [:title "Lamda Language"]
    [:style {:type "text/css"} (default-css)]]
   [:body
    [:div {:id "header"}
     [:h1 "The Lamda Language"]
     [:p "Das ist doch Unsinn!"]]
    ]))


#_(run-clojurescript
     "js/cljs.js"
     "metis.repl.connect()")
