
import java.util.Scanner;

public class Main {
    public static final int MATRIX_SIZE = 8; //Размер матрицы

    public static void main(String[] args) {
        int[][] colors = Matrix.randomMatrix(MATRIX_SIZE);
        System.out.println("Введите угол поворота 90/180/270: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Matrix.printMatrix("Матрица", colors);
        Matrix.printMatrix("Повёрнутая матрица", Matrix.rotateMatrix(colors, Integer.parseInt(input)));
    }
}
