# Parts of this Problem
## Problem 1 (Random Numbers)
###### **In this part of the problem, an instantiable Random class has been programmed for generating random numbers. The methods which have been created in the Random class include:**
1. public Random(int p1, int p2, int m): Set up a random number generator with the given constants. 
2. public void setSeed(int seed): Set the seed of the random number generator.
3. public int getMaximum(): Return the value of M for this random number generator.
4. public int random(): Use the sequential random number algorithm to generate the rnew value and return it. 
5. public int randomInteger(int lower, int upper): Return a random integer in the range lower to upper.
6. public boolean randomBoolean(): Randomly return true or false. This should simulate a 50% chance.
7. public double randomDouble(double lower, double upper): Get a random double in the range lower to upper.
8. A main method: The main method should demonstrate sufficient testing to prove that each of the methods work.
## Problem 2 (Quadratic Functions)
###### **In this part of the problem, a Quadratic class for dealing with quadratic functions has been programmed. A quadratic function is a function of the form ax2 +bx+c. The methods which have been created in the Quadratic class include:**
1. public Quadratic(float a, float b, float c) Set up a quadratic function with the given coefficients.
2. public Quadratic add(Quadratic other): This method should add other to the current quadratic function and return the result as a new Quadratic.
3. public Quadratic subtract(Quadratic other): This method should subtract other from the current quadratic function and return the result as a new Quadratic.
4. public Roots findRoots(): This method should use the quadratic formula to find the roots of the current quadratic function, returning an instance of the Roots class containing those roots. You must write the Roots class on your own - more details are given below.
5. public String toString(): This method should return a String representation of the cur- rent quadratic function, e.g. 9x2 − 4x + 1
6. public boolean equals(Object other): This method should return true if the current quadratic function is equal to other and false otherwise.
7.  A main method: Like the previous class to demonstrate that all the methods work via well- documented, well-formatted tests. 
# How to compile and run the programs
1. compile by this command:  **javac Random.java**
2. run by this command:      **java Random**
