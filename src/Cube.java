// 3/4/24
//madison davis
//builds a rubiks cube, takes user input and outputs moves to solve
//worked on it with Nate

//package com.example.project;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.lang.Math;

public class Cube {

    // A Cube in the correct format for the ultimate submission
    static String[][] Cube = {
            {
                    "r", "r", "r",
                    "r", "r", "r",
                    "r", "r", "r",
            },
            {
                    "b", "b", "b",
                    "b", "b", "b",
                    "b", "b", "b",
            },
            {
                    "o", "o", "o",
                    "o", "o", "o",
                    "o", "o", "o",
            },
            {
                    "g", "g", "g",
                    "g", "g", "g",
                    "g", "g", "g",
            },
            {
                    "y", "y", "y",
                    "y", "y", "y",
                    "y", "y", "y",
            },
            {
                    "w", "w", "w",
                    "w", "w", "w",
                    "w", "w", "w",
            },
    };

    // A Cube with numbers to test rotation.
    static String[][] numCube = {
            {
                    "r1", "r2", "r3",
                    "r4", "r5", "r6",
                    "r7", "r8", "r9",
            },
            {
                    "b1", "b2", "b3",
                    "b4", "b5", "b6",
                    "b7", "b8", "b9",
            },
            {
                    "o1", "o2", "o3",
                    "o4", "o5", "o6",
                    "o7", "o8", "o9",
            },
            {
                    "g1", "g2", "g3",
                    "g4", "g5", "g6",
                    "g7", "g8", "g9",
            },
            {
                    "y1", "y2", "y3",
                    "y4", "y5", "y6",
                    "y7", "y8", "y9",
            },
            {
                    "w1", "w2", "w3",
                    "w4", "w5", "w6",
                    "w7", "w8", "w9",
            },
    };

    // rotates counterclockwise
    static void f_rotation(String[][] Cube, int face) {
        String temp = null;

        // top corners rotation
        temp = Cube[face][0];
        Cube[face][0] = Cube[face][6];
        Cube[face][6] = Cube[face][8];
        Cube[face][8] = Cube[face][2];
        Cube[face][2] = temp;

        // top insides rotations
        temp = Cube[face][1];
        Cube[face][1] = Cube[face][3];
        Cube[face][3] = Cube[face][7];
        Cube[face][7] = Cube[face][5];
        Cube[face][5] = temp;

        /*
         * 1 -> 2 -> 3
         * /\ \/
         * 4 5 6
         * /\ \/
         * 7 <- 8 <- 9
         * 
         * Clockwise Rotation
         *
         */
        // edge rotations
        temp = Cube[face - 3][2];
        Cube[face - 3][2] = Cube[face + 2][2];
        Cube[face + 2][2] = Cube[face - 1][2];
        Cube[face - 1][2] = Cube[face + 1][2];
        Cube[face + 1][2] = temp;

        temp = Cube[face - 3][1];
        Cube[face - 3][1] = Cube[face + 2][1];
        Cube[face + 2][1] = Cube[face - 1][1];
        Cube[face - 1][1] = Cube[face + 1][1];
        Cube[face + 1][1] = temp;

        temp = Cube[face - 3][0];
        Cube[face - 3][0] = Cube[face + 2][0];
        Cube[face + 2][0] = Cube[face - 1][0];
        Cube[face - 1][0] = Cube[face + 1][0];
        Cube[face + 1][0] = temp;
    }

    static void u_rotation(String[][] Cube, int face) {
        String temp = null;

        // top corners
        temp = Cube[face - 3][0];
        Cube[face - 3][0] = Cube[face - 3][2];
        Cube[face - 3][2] = Cube[face - 3][8];
        Cube[face - 3][8] = Cube[face - 3][6];
        Cube[face - 3][6] = temp;

        // top insides
        temp = Cube[face - 3][1];
        Cube[face - 3][1] = Cube[face - 3][5];
        Cube[face - 3][5] = Cube[face - 3][7];
        Cube[face - 3][7] = Cube[face - 3][3];
        Cube[face - 3][3] = temp;

        // edge rotations
        temp = Cube[face][0];
        Cube[face][0] = Cube[face + 1][2];
        Cube[face + 1][2] = Cube[face - 2][0];
        Cube[face - 2][0] = Cube[face + 2][6];
        Cube[face + 2][6] = temp;

        temp = Cube[face][1];
        Cube[face][1] = Cube[face + 1][5];
        Cube[face + 1][5] = Cube[face - 2][1];
        Cube[face - 2][1] = Cube[face + 2][3];
        Cube[face + 2][3] = temp;

        temp = Cube[face][2];
        Cube[face][2] = Cube[face + 1][8];
        Cube[face + 1][8] = Cube[face - 2][2];
        Cube[face - 2][2] = Cube[face + 2][0];
        Cube[face + 2][0] = temp;

    }

    static void r_rotation(String[][] Cube, int face) {
        String temp = null;

        // side rotation
        temp = Cube[face + 1][0];
        Cube[face + 1][0] = Cube[face + 1][6];
        Cube[face + 1][6] = Cube[face + 1][8];
        Cube[face + 1][8] = Cube[face + 1][2];
        Cube[face + 1][2] = temp;

        // sides insides rotation
        temp = Cube[face + 1][1];
        Cube[face + 1][1] = Cube[face + 1][3];
        Cube[face + 1][3] = Cube[face + 1][7];
        Cube[face + 1][7] = Cube[face + 1][5];
        Cube[face + 1][5] = temp;

        // edge rotations
        temp = Cube[face][2];
        Cube[face][2] = Cube[face - 1][2];
        Cube[face - 1][2] = Cube[face - 2][6];
        Cube[face - 2][6] = Cube[face - 3][6];
        Cube[face - 3][6] = temp;

        temp = Cube[face][5];
        Cube[face][5] = Cube[face - 1][5];
        Cube[face - 1][5] = Cube[face - 2][3];
        Cube[face - 2][3] = Cube[face - 3][3];
        Cube[face - 3][3] = temp;

        temp = Cube[face][8];
        Cube[face][8] = Cube[face - 1][8];
        Cube[face - 1][8] = Cube[face - 2][0];
        Cube[face - 2][0] = Cube[face - 3][0];
        Cube[face - 3][0] = temp;
    }

    static void b_rotation(String[][] Cube, int face) {
        String temp = null;

        // back corners
        temp = Cube[face - 2][0];
        Cube[face - 2][0] = Cube[face - 2][6];
        Cube[face - 2][6] = Cube[face - 2][8];
        Cube[face - 2][8] = Cube[face - 2][2];
        Cube[face - 2][2] = temp;

        // back insides
        temp = Cube[face - 2][1];
        Cube[face - 2][1] = Cube[face - 2][3];
        Cube[face - 2][3] = Cube[face - 2][7];
        Cube[face - 2][7] = Cube[face - 2][5];
        Cube[face - 2][5] = temp;

        // edge rotation
        temp = Cube[face + 1][6];
        Cube[face + 1][6] = Cube[face - 1][6];
        Cube[face - 1][6] = Cube[face + 2][6];
        Cube[face + 2][6] = Cube[face - 3][6];
        Cube[face - 3][6] = temp;

        temp = Cube[face + 1][7];
        Cube[face + 1][7] = Cube[face - 1][7];
        Cube[face - 1][7] = Cube[face + 2][7];
        Cube[face + 2][7] = Cube[face - 3][7];
        Cube[face - 3][7] = temp;

        temp = Cube[face + 1][8];
        Cube[face + 1][8] = Cube[face - 1][8];
        Cube[face - 1][8] = Cube[face + 2][8];
        Cube[face + 2][8] = Cube[face - 3][8];
        Cube[face - 3][8] = temp;
    }

    static void l_rotation(String[][] Cube, int face) {
        String temp = null;

        // side corners
        temp = Cube[face + 2][0];
        Cube[face + 2][0] = Cube[face + 2][6];
        Cube[face + 2][6] = Cube[face + 2][8];
        Cube[face + 2][8] = Cube[face + 2][2];
        Cube[face + 2][2] = temp;

        // side insides
        temp = Cube[face + 2][1];
        Cube[face + 2][1] = Cube[face + 2][3];
        Cube[face + 2][3] = Cube[face + 2][7];
        Cube[face + 2][7] = Cube[face + 2][5];
        Cube[face + 2][5] = temp;

        // edge rotations
        temp = Cube[face - 3][8];
        Cube[face - 3][8] = Cube[face - 2][8];
        Cube[face - 2][8] = Cube[face - 1][0];
        Cube[face - 1][0] = Cube[face][0];
        Cube[face][0] = temp;

        temp = Cube[face - 3][5];
        Cube[face - 3][5] = Cube[face - 2][5];
        Cube[face - 2][5] = Cube[face - 1][3];
        Cube[face - 1][3] = Cube[face][3];
        Cube[face][3] = temp;

        temp = Cube[face - 3][2];
        Cube[face - 3][2] = Cube[face - 2][2];
        Cube[face - 2][2] = Cube[face - 1][6];
        Cube[face - 1][6] = Cube[face][6];
        Cube[face][6] = temp;
    }

    static void d_rotation(String[][] Cube, int face) {
        String temp = null;

        // bottom corners
        temp = Cube[face - 1][0];
        Cube[face - 1][0] = Cube[face - 1][6];
        Cube[face - 1][6] = Cube[face - 1][8];
        Cube[face - 1][8] = Cube[face - 1][2];
        Cube[face - 1][2] = temp;

        // edge rotation
        temp = Cube[face][6];
        Cube[face][6] = Cube[face + 2][8];
        Cube[face + 2][8] = Cube[face - 2][6];
        Cube[face - 2][6] = Cube[face + 1][0];
        Cube[face + 1][0] = temp;

        temp = Cube[face][7];
        Cube[face][7] = Cube[face + 2][5];
        Cube[face + 2][5] = Cube[face - 2][7];
        Cube[face - 2][7] = Cube[face + 1][3];
        Cube[face + 1][3] = temp;

        temp = Cube[face][8];
        Cube[face][8] = Cube[face + 2][2];
        Cube[face + 2][2] = Cube[face - 2][8];
        Cube[face - 2][8] = Cube[face + 1][6];
        Cube[face + 1][6] = temp;
    }

    static void r_prime_rotation(String[][] Cube, int face) {
        String temp = null;

        // side corners
        temp = Cube[face + 1][0];
        Cube[face + 1][0] = Cube[face + 1][2];
        Cube[face + 1][2] = Cube[face + 1][8];
        Cube[face + 1][8] = Cube[face + 1][6];
        Cube[face + 1][6] = temp;

        // side insides rotation
        temp = Cube[face + 1][1];
        Cube[face + 1][1] = Cube[face + 1][5];
        Cube[face + 1][5] = Cube[face + 1][7];
        Cube[face + 1][7] = Cube[face + 1][3];
        Cube[face + 1][3] = temp;

        // edge rotations
        temp = Cube[face - 3][0];
        Cube[face - 3][0] = Cube[face - 2][0];
        Cube[face - 2][0] = Cube[face - 1][8];
        Cube[face - 1][8] = Cube[face][8];
        Cube[face][8] = temp;

        temp = Cube[face - 3][3];
        Cube[face - 3][3] = Cube[face - 2][3];
        Cube[face - 2][3] = Cube[face - 1][5];
        Cube[face - 1][5] = Cube[face][5];
        Cube[face][5] = temp;

        temp = Cube[face - 3][6];
        Cube[face - 3][6] = Cube[face - 2][6];
        Cube[face - 2][6] = Cube[face - 1][2];
        Cube[face - 1][2] = Cube[face][2];
        Cube[face][2] = temp;
    }

    static void f_prime_rotation(String[][] Cube, int face) {
        String temp = null;

        // face = 2 (green)
        temp = Cube[face][0];
        Cube[face][0] = Cube[face][2];
        Cube[face][2] = Cube[face][8];
        Cube[face][8] = Cube[face][6];
        Cube[face][6] = temp;

        temp = Cube[face][1];
        Cube[face][1] = Cube[face][5];
        Cube[face][5] = Cube[face][7];
        Cube[face][7] = Cube[face][3];
        Cube[face][3] = temp;

        /*
         * 3 -> 6 -> 9
         * /\ \/
         * 2 5 8
         * /\ \/
         * 1 <- 4 <- 7
         * 
         * counter clockwise Rotation
         *
         */

        // edge rotations
        temp = Cube[face - 3][2];
        Cube[face - 3][2] = Cube[face + 1][2];
        Cube[face + 1][2] = Cube[face - 1][2];
        Cube[face - 1][2] = Cube[face + 2][2];
        Cube[face + 2][2] = temp;

        temp = Cube[face - 3][1];
        Cube[face - 3][1] = Cube[face + 1][1];
        Cube[face + 1][1] = Cube[face - 1][1];
        Cube[face - 1][1] = Cube[face + 2][1];
        Cube[face + 2][1] = temp;

        temp = Cube[face - 3][0];
        Cube[face - 3][0] = Cube[face + 1][0];
        Cube[face + 1][0] = Cube[face - 1][0];
        Cube[face - 1][0] = Cube[face + 2][0];
        Cube[face + 2][0] = temp;
    }

    static void u_prime_rotation(String[][] Cube, int face) {
        String temp = null;

        // top corners
        temp = Cube[face - 3][0];
        Cube[face - 3][0] = Cube[face - 3][6];
        Cube[face - 3][6] = Cube[face - 3][8];
        Cube[face - 3][8] = Cube[face - 3][2];
        Cube[face - 3][2] = temp;

        // top insides
        temp = Cube[face - 3][1];
        Cube[face - 3][1] = Cube[face - 3][3];
        Cube[face - 3][3] = Cube[face - 3][7];
        Cube[face - 3][7] = Cube[face - 3][5];
        Cube[face - 3][5] = temp;

        // edge rotation
        temp = Cube[face][0];
        Cube[face][0] = Cube[face + 2][6];
        Cube[face + 2][6] = Cube[face - 2][0];
        Cube[face - 2][0] = Cube[face + 1][2];
        Cube[face + 1][2] = temp;

        temp = Cube[face][1];
        Cube[face][1] = Cube[face + 2][3];
        Cube[face + 2][3] = Cube[face - 2][1];
        Cube[face - 2][1] = Cube[face + 1][5];
        Cube[face + 1][5] = temp;

        temp = Cube[face][2];
        Cube[face][2] = Cube[face + 2][0];
        Cube[face + 2][0] = Cube[face - 2][2];
        Cube[face - 2][2] = Cube[face + 1][8];
        Cube[face + 1][8] = temp;
    }

    static void d_prime_rotation(String[][] Cube, int face) {
        String temp = null;

        // bottom corners
        temp = Cube[face - 1][0];
        Cube[face - 1][0] = Cube[face - 1][2];
        Cube[face - 1][2] = Cube[face - 1][8];
        Cube[face - 1][8] = Cube[face - 1][6];
        Cube[face - 1][6] = temp;

        // bottom insides
        temp = Cube[face - 1][1];
        Cube[face - 1][1] = Cube[face - 1][5];
        Cube[face - 1][5] = Cube[face - 1][7];
        Cube[face - 1][7] = Cube[face - 1][3];
        Cube[face - 1][3] = temp;

        // edge rotations
        temp = Cube[face + 1][0];
        Cube[face + 1][0] = Cube[face - 2][6];
        Cube[face - 2][6] = Cube[face + 2][8];
        Cube[face + 2][8] = Cube[face][6];
        Cube[face][6] = temp;

        temp = Cube[face + 1][3];
        Cube[face + 1][3] = Cube[face - 2][7];
        Cube[face - 2][7] = Cube[face + 2][5];
        Cube[face + 2][5] = Cube[face][7];
        Cube[face][7] = temp;

        temp = Cube[face + 1][6];
        Cube[face + 1][6] = Cube[face - 2][8];
        Cube[face - 2][8] = Cube[face + 2][2];
        Cube[face + 2][2] = Cube[face][8];
        Cube[face][8] = temp;
    }

    static void b_prime_rotation(String[][] Cube, int face) {
        String temp = null;

        // back corners
        temp = Cube[face - 2][0];
        Cube[face - 2][0] = Cube[face - 2][2];
        Cube[face - 2][2] = Cube[face - 2][8];
        Cube[face - 2][8] = Cube[face - 2][6];
        Cube[face - 2][6] = temp;

        // back insides
        temp = Cube[face - 2][1];
        Cube[face - 2][1] = Cube[face - 2][5];
        Cube[face - 2][5] = Cube[face - 2][7];
        Cube[face - 2][7] = Cube[face - 2][3];
        Cube[face - 2][3] = temp;

        // edge rotations
        temp = Cube[face + 2][6];
        Cube[face + 2][6] = Cube[face - 1][6];
        Cube[face - 1][6] = Cube[face + 1][6];
        Cube[face + 1][6] = Cube[face - 3][6];
        Cube[face - 3][6] = temp;

        temp = Cube[face + 2][7];
        Cube[face + 2][7] = Cube[face - 1][7];
        Cube[face - 1][7] = Cube[face + 1][7];
        Cube[face + 1][7] = Cube[face - 3][7];
        Cube[face - 3][7] = temp;

        temp = Cube[face + 2][8];
        Cube[face + 2][8] = Cube[face - 1][8];
        Cube[face - 1][8] = Cube[face + 1][8];
        Cube[face + 1][8] = Cube[face - 3][8];
        Cube[face - 3][8] = temp;
    }

    static void l_prime_rotation(String[][] Cube, int face) {
        String temp = null;

        // side corners
        temp = Cube[face + 2][0];
        Cube[face + 2][0] = Cube[face + 2][2];
        Cube[face + 2][2] = Cube[face + 2][8];
        Cube[face + 2][8] = Cube[face + 2][6];
        Cube[face + 2][6] = temp;

        // side insides
        temp = Cube[face + 2][1];
        Cube[face + 2][1] = Cube[face + 2][5];
        Cube[face + 2][5] = Cube[face + 2][7];
        Cube[face + 2][7] = Cube[face + 2][3];
        Cube[face + 2][3] = temp;

        // edge rotations
        temp = Cube[face - 1][0];
        Cube[face - 1][0] = Cube[face - 2][8];
        Cube[face - 2][8] = Cube[face - 3][8];
        Cube[face - 3][8] = Cube[face][0];
        Cube[face][0] = temp;

        temp = Cube[face - 1][3];
        Cube[face - 1][3] = Cube[face - 2][5];
        Cube[face - 2][5] = Cube[face - 3][5];
        Cube[face - 3][5] = Cube[face][3];
        Cube[face][3] = temp;

        temp = Cube[face - 1][6];
        Cube[face - 1][6] = Cube[face - 2][2];
        Cube[face - 2][2] = Cube[face - 3][2];
        Cube[face - 3][2] = Cube[face][6];
        Cube[face][6] = temp;
    }

    static void printCube(String[][] theCube) {
        for (int x = 0; x < 6; x++) {
            int z = -1;
            for (int y = 0; y < 3; y++) {
                z++;
                System.out.print(theCube[x][z]);
                System.out.print("|");
                z++;
                System.out.print(theCube[x][z]);
                System.out.print("|");
                z++;
                System.out.print(theCube[x][z]);
                System.out.println("");
            }
            System.out.println("");
        }
    }

    public static void moveCube(char direction, String[][] numCube) {
        // assuming 3 is front
        switch (direction) {
            case 'U':
                u_rotation(numCube, 3);
                break;
            case 'D':
                d_rotation(numCube, 3);
                break;
            case 'F':
                f_rotation(numCube, 3);
                break;
            case 'B':
                b_rotation(numCube, 3);
                break;
            case 'L':
                l_rotation(numCube, 3);
                break;
            case 'R':
                r_rotation(numCube, 3);
                break;
            case 'u':
                u_prime_rotation(numCube, 3);
                break;
            case 'd':
                d_prime_rotation(numCube, 3);
                break;
            case 'f':
                f_prime_rotation(numCube, 3);
                break;
            case 'b':
                b_prime_rotation(numCube, 3);
                break;
            case 'l':
                l_prime_rotation(numCube, 3);
                break;
            case 'r':
                r_prime_rotation(numCube, 3);
                break;
        }
    }

    public static void main(final String[] args) {

        Scanner user_input = new Scanner(System.in);
        ArrayList<String> moves = new ArrayList<String>();

        System.out.println("Uppercase for normal and lowercase for prime");
        System.out.println();

        boolean condition = true;
        while (condition) {
            System.out.println("Please enter the move you would like to perform (q to quit)(z to randomize): ");
            String input = user_input.nextLine();
            moveCube(input.charAt(0), Cube);

            // prints solution to each possibility
            switch (input) {
                case "U":
                    System.out.println("Solution: u");
                    moves.add("U");
                    break;
                case "D":
                    System.out.println("Solution: d");
                    moves.add("D");
                    break;
                case "R":
                    System.out.println("Solution: r");
                    moves.add("R");
                    break;
                case "L":
                    System.out.println("Solution: l");
                    moves.add("L");
                    break;
                case "F":
                    System.out.println("Solution: f");
                    moves.add("F");
                    break;
                case "B":
                    System.out.println("Solution: b");
                    moves.add("B");
                    break;
                case "u":
                    System.out.println("Solution: U");
                    moves.add("u");
                    break;
                case "d":
                    System.out.println("Solution: D");
                    moves.add("d");
                    break;
                case "r":
                    System.out.println("Solution: R");
                    moves.add("r");
                    break;
                case "l":
                    System.out.println("Solution: L");
                    moves.add("l");
                    break;
                case "f":
                    System.out.println("Solution: F");
                    moves.add("f");
                    break;
                case "b":
                    System.out.println("Solution: B");
                    moves.add("b");
                    break;
                case "q":
                    condition = false;
                    break;
                case "z":
                    // randomize
                    break;
                default:
                    System.out.println("That is not a valid move please choose from: ");
                    System.out.println("U D R L F B u d r l f b");
                    break;
            }

            // print(numCube);
            // System.out.println(moves);

            // print cube
            System.out.println("--------------------------------");
            printCube(Cube);
            System.out.println("--------------------------------");

            ;
        }
        int max = 4;
        int min = 0;
        int range = max - min + 1;
        ArrayList<String> num_arr = new ArrayList<String>();

        // each move assigned a number
        for (int i = 0; i < moves.size(); i++) {
            int rand = (int) (Math.random() * range) + min;

            // System.out.println(rand);

            // doesnt work
            switch (rand) {
                case 0:
                    // 0 is U movement
                    num_arr.add("u");
                    break;
                case 1:
                    num_arr.add("d");
                    break;
                case 2:
                    num_arr.add("r");
                    break;
                case 3:
                    num_arr.add("l");
                    break;

            }
            System.out.println(num_arr);

            // ArrayList of moves made by user
            // System.out.println(moves);

        }
    }
}
// 👻
