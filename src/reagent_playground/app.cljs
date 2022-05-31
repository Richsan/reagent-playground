(ns reagent-playground.app (:require [reagent.core :as r]
                                     [reagent.dom :as r.dom]
                                     [reagent-mui.components :as mui.comp]
                                     [reagent-mui.colors :as mui.colors]
                                     [reagent-mui.icons.menu :as mui.icons.menu]
                                     [reagent-mui.styles :as mui.styles]))

(defn counting-component []
  (let [click-count (r/atom 0)]
    (fn []
      [:div [mui.comp/app-bar {:position "static"
                               :sx {:my 3}}
             [mui.comp/toolbar
              [mui.icons.menu/menu {:sx {:mx 1}}]
              [mui.comp/typography {:variant "h4" :component "h1"} "Reagent"]]]
       [mui.comp/container {:sx {:background-color (mui.colors/blue 50)}
                            :maxWidth "xg"}
        [mui.comp/typography {:variant "h5" :component "h2"}
         "The atom " [:code "click-count"] " has value: "
         @click-count ". "
         [mui.comp/button {:variant  "contained"
                           :on-click #(swap! click-count inc)}
          "Click On Me!"]]]])))

(defn init []
      (r.dom/render
            [counting-component]
            (.getElementById js/document "root")))
