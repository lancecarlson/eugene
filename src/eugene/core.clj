; http://www.genetic-programming.com/gpanimatedtutorial.html
; The five major preparatory steps for the basic version of genetic programming require the human user to specify

; (1) the set of terminals (e.g., the independent variables of the problem, zero-argument functions, and random constants) for each branch of the to-be-evolved computer program,
; (2) the set of primitive functions for each branch of the to-be-evolved computer program,
; (3) the fitness measure (for explicitly or implicitly measuring the fitness of candidate individuals in the population),
; (4) certain parameters for controlling the run, and
; (5) a termination criterion and method for designating the result of the run.

; Another way to describe the steps:
; 1. Generate an initial population of programs
; 2. Take the n best programs of the current population
; 3. Create Children from the best programs by mating and mutating them
; 4. Replace the current population with the n-best and the children programs
; 5. Repeat from 2 until satisfied
; http://www.lulu.com/items/volume_63/2167000/2167025/2/print/book.pdf
(ns eugene.core)

(defn rand-item 
  "Randomly selects an item from a list"
  [items]
  (items (rand-int (count items))))

(defn germinate 
  "Generates a random instruction set for evaluation.
   functions: a list of all the possible functions to iterate through (ie +, *, -, /). Functions must have closure.
   terminals: variables, constants, and functions with side effects (ie, 3, y, x, rand()).
   max-depth: the maximum depth to pursue tree generation. Said another way, when functions can no longer nest, or become leaves of the tree.
   method: either full or grow. When full, terminals are not allowed to terminate trees. When grow, terminals can terminate trees"
  ([functions terminals max-depth method] (germinate functions terminals max-depth method 2))
  ([functions terminals max-depth method arity]
    (if (or (zero? max-depth) (and (= method :grow) (< (rand) (/ (count terminals) (+ (count terminals) (count functions))))))
      (rand-item terminals)
      (cons 
        (rand-item functions) 
        (take arity 
          (repeatedly #(germinate functions terminals (dec max-depth) method arity)))))))

(defn print-instruction 
  "Prints out the instruction in a semi-pretty format."
  ([instruction output] (print-instruction instruction ""))
  ([instruction output n]
    (println 
      (inc n)
      instruction
      "->"
      output)))
      
(defn evolve
  "Evolve your programs!
   iterations: the number of cycles to go through in this generation before terminating.
   instruction-function: at the moment the only function you can use is generate-rand-instruction"
  [iterations germination-strategy fitness-strategy]
  (dotimes [n iterations] 
    (def instruction (eval germination-strategy))
    (try 
      (def output (eval instruction))
      (catch Exception e
        (println e)))
    (fitness-strategy instruction output n)))