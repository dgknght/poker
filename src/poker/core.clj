(ns poker.core
  (:gen-class))

(def suits #{:hearts :diamonds :spades :clubs})

(defn diamond?
  [card]
  {:pre [(vector? card)]}

  (= :diamonds (second card)))

(defn deck []
  (mapcat (fn [suit]
            (map (fn [number]
                   [number suit])
                 (range 13)))
          suits))
