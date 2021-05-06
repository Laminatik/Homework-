package home.work;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final int SIZE = 3;
    private static final int DOTS_TO_WIN = 3;

    private static final char DOT_EMPTY = '•';
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';

    private static final char[][] map = new char[SIZE][SIZE];


    public static void main(String[] args) {
        initMap();
        printMap();

        while (true) {
            humanTurn();
            printMap();
            if (isWin(DOT_X)) {
                System.out.println("Человек победил!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья!");
                break;
            }

            computerTurn();
            printMap();
            if (isWin(DOT_O)) {
                System.out.println("Компьютер победил!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья!");
                break;
            }
        }
    }

    private static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }


    private static boolean isWin(char symbol) {
        if (VandH(symbol)) {
            return true;
        } else {
            return Diagonal(symbol);
        }
    }

    private static boolean VandH(char symbol) {
        for (int i = 0; i < SIZE; i++) {
            int H = 0;
            int V = 0;
            for (int j = 0; j < SIZE; j++) {
                H = (map[i][j] == symbol) ? H + 1 : 0;
                V = (map[j][i] == symbol) ? V + 1 : 0;
                if (H == DOTS_TO_WIN || V == DOTS_TO_WIN) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean Diagonal(char symbol) {
        int oneD  = 0;
        int twoD = 0;
        for (int i = 0; i < SIZE; i++) {
            oneD = (map[i][i] == symbol) ? oneD + 1 : 0;
            twoD = (map[i][map.length - 1 - i] == symbol) ? twoD + 1 : 0;
            if (oneD == DOTS_TO_WIN || twoD == DOTS_TO_WIN) {
                return true;
            }
        }
        return false;
    }

    private static void printMap() {
        printHeader();
        printBody();
        System.out.println();
    }

    private static void computerTurn() {
        int x;
        int y;
        Random random = new Random();

        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (map[x][y] != DOT_EMPTY);

        map[x][y] = DOT_O;
    }

    private static void humanTurn() {
        int x;
        int y;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Введите координаты в формате X Y");
            x = readInt(scanner) - 1;
            y = readInt(scanner) - 1;

            if (x == -1 || y == -1) {
                System.out.println("Координаты должны быть числом!");
                scanner.nextLine();
            } else if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
                System.out.println("Данные введены некорректно!");
            } else if (map[x][y] != DOT_EMPTY) {
                System.out.println("Клетка уже занята!");
            } else {
                break;
            }
        } while (true);

        map[x][y] = DOT_X;
    }

    private static int readInt(Scanner scanner) {
        return scanner.hasNextInt() ? scanner.nextInt() : -1;
    }

    private static void printBody() {
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void printHeader() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void initMap() {
        for (int i = 0; i < SIZE; i++) {
            Arrays.fill(map[i], DOT_EMPTY);
        }

    }
}
