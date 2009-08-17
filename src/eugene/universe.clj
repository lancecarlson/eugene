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

; Sample run:
; $ clj eugene/universe.clj 
; 95 (* 6 7) -> 42
; 118 (* 7 6) -> 42
; #<CompilerException java.lang.ArithmeticException: Divide by zero (universe.clj:13)>
; #<CompilerException java.lang.ArithmeticException: Divide by zero (universe.clj:13)>
; 926 (* 6 7) -> 42
; #<CompilerException java.lang.ArithmeticException: Divide by zero (universe.clj:13)>
; 2555 (* 6 7) -> 42
; 3024 (* 7 6) -> 42
; 3636 (* 6 7) -> 42
; 4640 (* (/ 6 3) (* 7 3)) -> 42
; 5861 (* 6 7) -> 42
; #<CompilerException java.lang.ArithmeticException: Divide by zero (universe.clj:13)>
; 6888 (* 7 6) -> 42
; #<CompilerException java.lang.ArithmeticException: Divide by zero (universe.clj:13)>
; 7386 (* 6 7) -> 42
; 7417 (* 6 7) -> 42
; 7696 (* 6 7) -> 42
; 8292 (* 7 6) -> 42
; 8443 (* 6 7) -> 42
; 8458 (/ (/ 6 1) (/ 1 7)) -> 42
; 8579 (* 7 6) -> 42
; #<CompilerException java.lang.ArithmeticException: Divide by zero (universe.clj:13)>
; 8733 (* 7 6) -> 42
; 9208 (* 7 6) -> 42