import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MatrixTest {

    //Тест на совпадение размеров исходной матрицы и повёрнутой
    @ParameterizedTest
    @ValueSource(ints = {90, 180, 270})
    public void testSize(int angle) {
        int sizeBefore = 8;
        int[][] testMatrix = Matrix.randomMatrix(sizeBefore);
        int[][] rotateMatrix = Matrix.rotateMatrix(testMatrix, angle);
        int sizeAfter = rotateMatrix.length;
        Assertions.assertEquals(sizeBefore, sizeAfter);
    }

    //Тест на возникновение ошибки при вводе неправильного угла
    @Test
    public void testAngle() {
        int testAngle = 123;
        int[][] testMatrix = Matrix.randomMatrix(8);
        Assertions.assertThrows(RotateAngleError.class, () -> Matrix.rotateMatrix(testMatrix, testAngle));
    }

    //Тест на правильность поворота, в файлах содержатся классы RotateTest с правильными данными (исходная матрица, повёрнутая матрица, угол)
    @ParameterizedTest
    @MethodSource("testRotateMatrixSource")
    public void testRotateMatrix(RotateTest rotateTest) {
        int[][] testMatrix = rotateTest.initMatrix;
        int[][] rotateMatrix = Matrix.rotateMatrix(testMatrix, rotateTest.angle);
        Assertions.assertArrayEquals(rotateTest.rotateMatrix, rotateMatrix);
    }

    //Перебираем файлы в папке tests и возвращаем в виде стрима RotateTest
    private Stream<Arguments> testRotateMatrixSource() {
        List<Arguments> arguments = new ArrayList<>();
        File[] listFiles = new File("tests").listFiles();
        for (File f : listFiles) {
            RotateTest rotateTest = new RotateTest(f.getAbsolutePath());
            arguments.add(Arguments.of(rotateTest));
        }
        return arguments.stream();
    }

}
