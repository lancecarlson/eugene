(use 'eugene.core)

(def functions '[+ - / *])
(def terminals '[1 2 3 4 5 6 7 8 9])
(def max-depth 2)
(def method :grow)
(def iterations 10000)
(def instruction-function '(germinate functions terminals max-depth method 2))
(defn fitness-function 
  [instruction output n]
  (if (= output 42) (print-instruction instruction output n)))
    
(evolve iterations instruction-function fitness-function)