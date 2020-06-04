(ns poker.core
  (:gen-class))

(def suits #{:hearts :diamonds :spades :clubs})
(def ranks #{:A :2 :3 :4 :5 :6 :7 :8 :9 :10 :J :Q :K})

(defn card?
  [card]
  (vector? card))

(defn- suit?
  [card suit]
  {:pre [(card? card)]}

  (= suit (second card)))

(defn rank
  [card]
  {:pre [(card? card)]}

  (first card))

(defn diamond?
  [card]
  (suit? card :diamonds))

(defn heart?
  [card]
  (suit? card :hearts))

(defn spade?
  [card]
  (suit? card :spades))

(defn club?
  [card]
  (suit? card :clubs))

(defn deck []
  (mapcat (fn [suit]
            (map (fn [number]
                   [number suit])
                 ranks))
          suits))
