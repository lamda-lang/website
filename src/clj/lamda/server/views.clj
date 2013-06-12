(ns lamda.server.views
  (:use cssgen
        [hiccup.core :only [html]]
        [hiccup.page :only [html5 include-js]]
        [hiccup.element :only [javascript-tag]]))

(defn- run-clojurescript [path init]
  (list
   (include-js path)
   (javascript-tag init)))

(def header-height (px 150))
(def default-font "Open Sans")
(def header-font-size (pt 16))
(def header-font-color (rgb :#F27E18))
(def default-background-color (rgb :#242424))

(defn body-css []
  ["body,html"
   :font-family default-font
   :font-size header-font-size
   :margin 0])

(defn header-css []
  ["#header"
   :background default-background-color
   :color header-font-color
   :margin 0
   :text-align :center
   [:h1
    :margin 0]
   [:p
    :margin 0]])

(defn nav-sub-css []
  ["#nav > li.sub"
   :position :relative
   ["& ul"
    :width (em 10)
    :margin 0
    :padding [(em 0.5) 0]
    :list-style :none
    :background default-background-color
    :position :absolute
    :top (em -1000)
    ["& li"
     :width (% 90)
     :margin [0 :auto (em 0.3) :auto]
     ["& a"
      :height (% 100)
      :display :block
      :padding (em 0.4)
      :color (rgb :#fff)
      :font-weight :bold
      :text-decoration :none
      ["&:hover"
       :background (rgb :#c60)
       :text-decoration :none]]]]
   ["&:hover ul"
    :top (em 3)]])


(defn nav-css []
  ["#nav"
   :margin 0
   :padding [0 (em 1)]
   :background default-background-color
   :height (em 3)
   :text-decoration :none
   :list-style :none
   ["& > li"
    :float :left
    :margin-right (em 0.5)
    :padding [0 (em 1)]
    ["& > a"
     :float :left
     :color (rgb :#c60)
     :text-decoration :none
     :line-height 3
     :fint-weight :bold
     :text-transform :uppercase
     ["&:hover"
      :color header-font-color
      :text-decoration :none]]]])

(defn default-css []
  (css
   (body-css)
   (header-css)
   (nav-css)
   (nav-sub-css)))


(defn menu-html []
  [:ul {:id "nav"}
   [:li [:a {:href "#"} "Home"]]
   [:li {:class "sub"} [:a {:href "#"} "Explore"]
    [:ul
     [:li [:a {:href "#"} "live repl"]]
     [:li [:a {:href "#"} "Documentation"]]
     [:li [:a {:href "#"} "Github"]]]]
   [:li {:class "sub"} [:a {:href "#"} "About"]
    [:ul
     [:li [:a {:href "#"} "Us"]]
     [:li [:a {:href "#"} "Other Work"]]]]])


(defn index-page []
  (html5
   [:head
    [:title "Lamda Language"]
    [:style {:type "text/css"} (default-css)]]
   [:body
    [:div {:id "wrap"}
     [:div {:id "header"}
      [:h1 "The Lamda Language"]
      [:p "Go functional!"]]
     [:div {:id "menu"} (menu-html)]
     ]]))

;; write to static html file
(spit "resources/public/index.html" (index-page))
