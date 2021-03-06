(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (let [awards (get book :awards)]
    (contains? awards award)))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [books-awards (get book :awards)]
    (every? books-awards awards)))

(defn my-some [pred a-seq]
  (first (filter boolean (map pred a-seq))))


(defn my-every? [pred a-seq]
  (let [filtered-seq (filter pred a-seq)]
    (if (== (count filtered-seq) (count a-seq)) true false)))

(defn prime? [n]
  (let [middle-numbers (range 2 n)
        apu (fn [x] (if (== (mod n x) 0) true false))]
    (if (some apu middle-numbers) false true)))
;^^

