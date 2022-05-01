import java.util.Random;

public class Matrix {

    //Поворот матрицы
    public static int[][] rotateMatrix(int[][] matrix, int angle) {
        int matrixSize = matrix.length;
        int[][] rotatedMatrix = new int[matrixSize][matrixSize];
        int dr = 0; //расчётная строка исходной матрицы
        int dc = 0; //расчётный столбец исходной матрицы
        for (int r = 0; r < matrixSize; r++) {
            for (int c = 0; c < matrixSize; c++) {
                //в зависимости от угла расчитываем строку и столбец исходной матрицы
                switch (angle) {
                    case 90:
                        dr = matrixSize - 1 - c;
                        dc = r;
                        break;
                    case 180:
                        dr = matrixSize - 1 - r;
                        dc = matrixSize - 1 - c;
                        break;
                    case 270:
                        dr = c;
                        dc = matrixSize - 1 - r;
                        break;
                    default:
                        throw new RotateAngleError();
                }
                rotatedMatrix[r][c] = matrix[dr][dc];
            }
        }
        return rotatedMatrix;
    }

    //Вывод матрицы
    public static void printMatrix(String name, int[][] matrix) {
        int matrixSize = matrix.length;
        System.out.println("\n" + name);
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                System.out.format("%4d", matrix[i][j]);
            }
            System.out.println();
        }
    }

    //Вывод матрицы
    public static void printMatrix(int[][] matrix) {
        int matrixSize = matrix.length;
        String line = "";
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                line += matrix[i][j] + ",";
            }
            System.out.println("{" + line.substring(0, line.length() - 1) + "},");
            line = "";
        }
    }

    public static int[][] randomMatrix(int size) {
        int[][] result = new int[size][size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result[i][j] = random.nextInt(256);
            }
        }
        return result;
    }
}
