Daniel Gelfand
APCS2 pd2
HW12 -- __+3R|\/|1|\|4|_  1|_|_|\|3$$__
2018-03-01

1) "We can put multiple classes in 1 file!". Allows you to see all your code in one place.
2) Uses the array of strings in the main method. String[] args.
3) The recursion is needed to reach the number of views provided.
4) Board of numbers with some numbers updating.
5) It depends on the delay and moves provided.
6) American National Standards Institute. "Oversees the development of voluntary consensus standards for products, services, processes, systems, and personnel in the United States." - wikipedia
7) My expectations seemed to match the output.
8) We can ask for an 8x8 board and make the moves in an L shape until all stops have a number
besides 0.

Algorithm
1) Choose a random square for the knight.

2) Move to a possible location.

3) Repeat until there are no more possible moves.

  3a) If all possible squares are visited then print the solution.

  3b) Else, backtrack and try alternative squares.

4) If after trying alternatives not all squares are visited, there is no solution.
