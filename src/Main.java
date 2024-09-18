import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static int checkMove(String[][] board, int typeMove, int x, int y) {

        int posX = x - 1;
        int posY = y - 1;

        if (!board[posX][posY].equals(".")) {
            return -1;
        }
        board[posX][posY] = typeMove == 1 ? "x" : "o";

        String type = typeMove == 1 ? "x" : "o";
        String opponent = typeMove == 0 ? "x" : "o";

        int count = 0;

        boolean cod1 = false;
        boolean cod2 = false;

        //ngang
        while(posX < 10 && posX >= 0 && posY < 10 && posY >= 0) {
            if (board[posX][posY].equals(type)) {
                count += 1;
                posY += 1;
                if (board[(posX >= 0 && posX < 10) ? posX : x - 1][(posY >= 0 && posY < 10) ? posY : y - 1].equals(opponent)) {
                    cod1 = true;
                }
                if (count != 5)
                    continue;

            }
            if (count == 5) {
                if (cod1) {
                    count--;
                    posX = x - 1;
                    posY = y - 1;
                    break;

                }
                System.out.println("step1 ngang success");
                return 1;
            } else {
                count--;
                posX = x - 1;
                posY = y - 1;
                break;
            }
        }
        System.out.println(count);
        while(posX < 10 && posX >= 0 && posY < 10 && posY >= 0) {
            if (board[posX][posY].equals(type)) {
                count += 1;
                posY -= 1;
                if (board[(posX >= 0 && posX < 10) ? posX : x - 1][(posY >= 0 && posY < 10) ? posY : y - 1].equals(opponent)) {
                    cod2 = true;
                }
                if (count != 5)
                    continue;
            }

            if (count == 5) {
                if (cod1 && cod2) {
                    count = 0;
                    posX = x - 1;
                    posY = y - 1;
                    cod1 = false;
                    cod2 = false;
                    break;
                }
                System.out.println("step2 ngang success");
                return 1;
            } else {
                count = 0;
                posX = x - 1;
                posY = y - 1;
                cod1 = false;
                cod2 = false;

                break;
            }
        }

        //doc
        while(posX < 10 && posX >= 0 && posY < 10 && posY >= 0) {
            if (board[posX][posY].equals(type)) {
                count += 1;
                posX += 1;
                if (board[(posX >= 0 && posX < 10) ? posX : x - 1][(posY >= 0 && posY < 10) ? posY : y - 1].equals(opponent)) {
                    cod1 = true;
                }
                if (count != 5)
                    continue;

            }
            if (count == 5) {
                if (cod1) {
                    if(board[x-2][posY].equals(opponent)) {
                        return 0;
                    }
                }
                System.out.println("step1 doc success");
                return 1;
            } else {
                count--;
                posX = x - 1;
                posY = y - 1;
                break;
            }

        }
        System.out.println(count);
        while(posX < 10 && posX >= 0 && posY < 10 && posY >= 0) {
            if (board[posX][posY].equals(type) ) {
                count += 1;
                posX -= 1;
                if (board[(posX >= 0 && posX < 10) ? posX : x - 1][(posY >= 0 && posY < 10) ? posY : y - 1].equals(opponent)) {

                    cod2 = true;
                }
                if (count != 5)
                    continue;

            }


            if (count == 5) {
                if (cod1 && cod2) {
                    count = 0;
                    posX = x - 1;
                    posY = y - 1;
                    cod1 = false;
                    cod2 = false;
                    break;
                }
                System.out.println("step2 doc success");
                return 1;
            } else {
                count = 0;
                posX = x - 1;
                posY = y - 1;
                break;
            }
        }

        //xien 1
        while(posX < 10 && posX >= 0 && posY < 10 && posY >= 0) {
            if (board[posX][posY].equals(type)) {
                count += 1;
                posX -= 1;
                posY += 1;
                if (board[(posX >= 0 && posX < 10) ? posX : x - 1][(posY >= 0 && posY < 10) ? posY : y - 1].equals(opponent)) {
                    cod1 = true;
                }

                if (count != 5) continue;
            }
            if (count == 5) {
                if (cod1) {
                    if(board[x][y-2].equals(opponent)) {
                        return 0;
                    }
                }
                System.out.println("step1 xien 1 success");
                return 1;
            } else {
                count--;
                posX = x - 1;
                posY = y - 1;
                break;
            }

        }
        System.out.println(count);
        while(posX < 10 && posX >= 0 && posY < 10 && posY >= 0) {
            if (board[posX][posY].equals(type)) {
                count += 1;
                posX += 1;
                posY -= 1;
                if (board[(posX >= 0 && posX < 10) ? posX : x - 1][(posY >= 0 && posY < 10) ? posY : y - 1].equals(opponent)) {

                    cod2 = true;
                }
                if (count != 5) continue;

            }


            if (count == 5) {
                if (cod1 && cod2) {
                    count = 0;
                    posX = x - 1;
                    posY = y - 1;
                    cod1 = false;
                    cod2 = false;
                    break;

                }
                System.out.println("step2 xien 2 success");
                return 1;
            } else {
                count = 0;
                posX = x - 1;
                posY = y - 1;
                break;
            }
        }

        //xien 2
        while(posX < 10 && posX >= 0 && posY < 10 && posY >= 0) {
            if (board[posX][posY].equals(type) ) {
                count += 1;
                posX += 1;
                posY += 1;
                if (board[(posX >= 0 && posX < 10) ? posX : x - 1][(posY >= 0 && posY < 10) ? posY : y - 1].equals(opponent)) {
                    cod1 = true;
                }
                if (count != 5) continue;

            }

            if (count == 5) {
                if (cod1) {
                    if(board[x-2][y-2].equals(opponent)) {
                        return 0;
                    }
                }
                System.out.println("step1 xien 1 success");
                return 1;
            } else {
                count--;
                posX = x - 1;
                posY = y - 1;
                break;
            }

        }
        System.out.println(count);
        while(posX < 10 && posX >= 0 && posY < 10 && posY >= 0) {
            if (board[posX][posY].equals(type)) {
                count += 1;
                posX -= 1;
                posY -= 1;
                if (board[(posX >= 0 && posX < 10) ? posX : x - 1][(posY >= 0 && posY < 10) ? posY : y - 1].equals(opponent)) {
                    cod2 = true;
                }
                if (count != 5) continue;

            }


            if (count == 5) {
                if (cod1 && cod2) {
                    count = 0;
                    posX = x - 1;
                    posY = y - 1;
                    cod1 = false;
                    cod2 = false;
                    break;

                }
                System.out.println("step2 xien 2 success");
                return 1;
            } else {
                count = 0;
                posX = x - 1;
                posY = y - 1;
                break;
            }
        }

        //case bth
        return 0;
    }

    public static void main(String[] args) {
        String[][] board = {
                {".", ".", ".", ".", ".", ".", ".", ".", ".", "."},
                {".", ".", ".", ".", ".", ".", ".", ".", ".", "."},
                {".", ".", ".", ".", ".", ".", ".", ".", ".", "."},
                {".", ".", ".", ".", ".", ".", ".", ".", ".", "."},
                {".", ".", ".", ".", ".", ".", ".", ".", ".", "."},
                {".", ".", ".", ".", ".", ".", ".", ".", ".", "."},
                {".", ".", ".", ".", ".", ".", ".", ".", ".", "."},
                {".", ".", ".", ".", ".", ".", ".", ".", ".", "."},
                {".", ".", ".", ".", ".", ".", ".", ".", ".", "."},
                {".", ".", ".", ".", ".", ".", ".", ".", ".", "."}

        };

        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.print(i);
                System.out.print(" ");
                System.out.print(j);
                System.out.print(" ");
            }
        }

        //win = 1
        //k hop le = -1
        //ok 0
        // move X = 1
        //move O = 0



        //System.out.println(checkMove(board, 1, 5, 6));

        System.out.print(" ");
        for (int i = 1 ; i<= 10; i++) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.print(i + 1);
            for (int j = 0 ; j < 10; j++) {

                System.out.print(board[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

        Scanner sc = new Scanner(System.in);

        int turn = 1; //x goes first
        String player = "";
        int typeMove = 0;
        int turnNum = 0;
        //game start
        while (true) {
            if (turnNum == 50) {
                System.out.println("Its a draw!");
                break;
            }

            if (turn % 2 == 1) {
                player = "X";
                typeMove = 1;
            } else {
                player = "O";
                typeMove = 0;
            }
            System.out.println(player + " turn!");

            System.out.println("position x: ");
            int xpos = sc.nextInt();
            System.out.println("position y: ");
            int ypos = sc.nextInt();

            int res = 0;
            try {
                res = checkMove(board , typeMove, xpos, ypos);
            } catch (ArithmeticException e) {
                System.out.println("invalid input");
                continue;
            }

            if (res == 0) {
                turnNum++;
                turn += 1;
            } else if (res == -1) {
                System.out.println("invalid move!");
                continue;

            } else if (res == 1) {

                System.out.println("congrats " + player + " on winning this game!");
            }


            System.out.println(" ");
            for (int i = 1 ; i<= 10; i++) {
                System.out.print(i);
                System.out.print(" ");
            }
            System.out.println();
            for (int i = 0; i < 10; i++) {
                System.out.print(i + 1);
                for (int j = 0 ; j < 10; j++) {

                    System.out.print(board[i][j]);
                    System.out.print(" ");
                }
                System.out.println();
            }
            if (res == 1) break;
        }
        System.out.println("game over");
    }
}