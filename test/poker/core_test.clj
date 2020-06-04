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
    (doseq [f [poker/diamond? poker/heart? poker/spade? poker/club?]]
      (is (= 13 (count (filter #(f %) cards)))
          (str "The deck contains 13 cards of suit " f)))
    (doseq [rank [:A :2 :3 :4 :5 :6 :7 :8 :9 :10 :J :Q :K]]
      (is (= 4 (count (filter #(= rank (poker/rank %)) cards)))
          (str "The deck contains 4 cards of rank " rank)))))
