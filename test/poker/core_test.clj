(ns poker.core-test
  (:require [clojure.test :refer [deftest is]]
            [poker.core :as poker]))

(deftest identify-a-diamond-suit
  (is (poker/diamond? [:K :diamonds])
      "returns true for a card that is a diamond")
  (is (not (poker/diamond? [:K :spades]))
      "return false for a card that is not a diamond"))

(deftest create-a-deck-of-cards
  (let [cards (poker/deck)]
    (is (= 52 (count cards))
        "A deck has 52 cards")
    (is (= 13 (count (filter (fn [card]
                               (poker/diamond? card))
                             cards))))))
