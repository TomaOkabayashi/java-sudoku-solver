# Sudoku Solver

This Java program is designed to solve Sudoku puzzles using a backtracking recursion algorithm. It takes a partially filled Sudoku grid as input and fills in the missing numbers such that the grid satisfies the rules of Sudoku - each row, column, and 3x3 subgrid must contain all digits from 1 to 9 without repetition.

## How to Run

1. Compile the SudokuSolver.java file

`javac SudokuSolver.java`

2. Execute compiled program

`java SudokuSolver`

## Game Instructions

- Input: The Sudoku grid to be solved is represented as a 2D array of integers in the main method
- Replace the zeros with the known numbers in the puzzle, and the program will attempt to solve it.
- Output: The program will print the original Sudoku grid, attempt to solve it, and then print the solved grid if successful.

## Approach

- Backtracking Algorithm: The program utilises a recursive backtracking algorithm to systematically explore all possible solutions to the Sudoku puzzle.
- Valid Placement Check: Before placing a number in a cell, the program checks if it violates any Sudoku rules (e.g., if the same number is already present in the same row, column, or 3x3 subgrid).
- Optimisation: The algorithm efficiently prunes the search space by backtracking as soon as it encounters an invalid configuration, minimising unnecessary computations.

## Context

Early Java project. Comments are bad as they are 'what' type comments and not 'why' comments. However does clarify the backtracking algorithm so was useful when going through it again. Very interesting backtracking recursive algorithm, as a normal human solving a Sudoku would never think of attempting to solve using this method. Frankly impossible for a human.
A nightmare way to solve a Sudoku, but for a computer, able to try millions and billions of numbers very fast, it is very efficient. Very fun.
