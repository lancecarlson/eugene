; This example isn't working because of lack of sex. Sad day :(
(use 'eugene.core)

(def functions '[str])
(def terminals '["h" "e" "l" "o" "w" "r" "d"])
(def max-depth 2)
(def method :grow)
(def iterations 100000)
(def instruction-function '(germinate functions terminals (rand-int 3) method (rand-int 7)))
(defn fitness-function 
  [instruction output n]
  (if (= output "hello") 
    (print-instruction instruction output n)
    (print-instruction instruction output n)
    ))
    
(evolve iterations instruction-function fitness-function)