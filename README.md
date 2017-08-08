ABSTRACT:

AustrianLotto is a program designed to solve Austrian Lotto "6 aus 45" problem. In the Austrian Lotto "6 aus 45" (6 out of 45), 
six distinct numbers between 1 and 45, inclusive, are selected as the winning numbers in a drawing. Prior to the drawing, 
lotto players pick six distinct numbers from the same range. The number of matches between their numbers and the winning numbers 
determines the prize that they win.

REQUIREMENTS:

Programming Language: Java Version 1.8
Framework: Maven
Libraries: For normal execution, no external library required
Testing: For testing, “junit” framework was used

DESIGN:

The program contains four classes, two for normal execution (AustrianLotto, AustrianLottoDriver) and two for testing (AustrianLottoTest,
AustrianLottoTestMain). In normal execution, “AustrianLotto” provides “evaluate” method which is the main method to solve the scenario 
problem. “AustrianLottoDriver” class, is a driver class that execute the program. For testing, “junit” framework was used. 
“AustrianLottoTest” class contains different testing scenarios(methods). “AustrianLottoTestMain” class is a driver class that run and 
demonstrate the testing results.  

INSTRUCTION:

AustrianLotto program was developed using Maven framework (Netbeans Project). When running AustrianLottoDriver class, the program will 
automatically generate the game’s draw. It than promote user to press any key to start the program or enter “Exit” to terminate the 
program. It than ask user to enter pick input. By default, user input is disabled and program automatically select the picks (Random
generator). The program eventually will print out the result to user.

PROBLEM STATEMENT:

(Gathered from https://community.topcoder.com/stat?c=problem_statement&pm=1934 on 18/07/2017)
In the Austrian Lotto "6 aus 45" (6 out of 45), six distinct numbers between 1 and 45, inclusive, are selected as the winning numbers 
in a drawing. Prior to the drawing, lotto players pick six distinct numbers from the same range. The number of matches between their 
numbers and the winning numbers determines the prize that they win. An addicted gambler who plays multiple times in a single drawing 
faces a lot of work when comparing all of his picks to the winning numbers.
Given a String drawing, the result of the current drawing, and a String[] picks, the picks made by a gambler, return a int[] which 
represents a breakdown of the gambler's success rate. The int[] should contain exactly seven elements. The 0th element is the number 
of picks in which there are no matches between the gambler's numbers and the drawn numbers, and the 1st to 6th elements are the number 
of picks in which there are 1 to 6 matches, respectively. drawing and each element of picks contains exactly 6 distinct integers between
1 and 45, inclusive, each separated by a single space, e.g. "3 12 13 17 32 45" (quotes for clarity).

DEFINITION:

Class:	 AustrianLotto

Method: 	 evaluate

Parameters: String, String[]

Returns:	 int[]

Method signature: int[] evaluate(String drawing, String[] picks)

(be sure your method is public)
    
CONSTRAINTS:
- picks contains between 1 and 50 elements, inclusive.
- drawing and each element of picks contains exactly 6 distinct integers between 1 and 45, inclusive, each separated by exactly one 
single space, e.g. "3 12 13 17 32 45" (quotes for clarity). Integers have no leading zeros.
- drawing and each element of picks contains between 11 and 17 characters, inclusive, and no leading or trailing spaces.
 
EXAMPLES:

0)
"3 11 18 23 37 45"
{"4 7 14 30 33 35", "1 11 12 25 37 38", "11 18 19 20 21 22"}
Returns: { 1,  0,  2,  0,  0,  0,  0 }
In the first pick, no numbers are correct. In the second pick, the two numbers 11 and 37 are correct. In the third pick, there are also
two correct numbers: 11 and 18.

1)
"3 18 23 11 37 45"
{"3 11 18 23 37 45"}
Returns: { 0,  0,  0,  0,  0,  0,  1 }
Here all six numbers are correct.

2)
"42 26 33 2 13 14"
{"13 4 36 42 26 12"}
Returns: { 0,  0,  0,  1,  0,  0,  0 }
Here three numbers are correct: 13, 26 and 42.
