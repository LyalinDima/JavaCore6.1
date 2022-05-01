import java.io.*;

//Класс содержит правильные результаты поворота матриц
public class RotateTest implements Serializable {
    int[][] initMatrix;
    int[][] rotateMatrix;
    int angle;

    public RotateTest(int[][] initMatrix, int[][] rotateMatrix, int angle) {
        this.initMatrix = initMatrix;
        this.rotateMatrix = rotateMatrix;
        this.angle = angle;
    }

    public RotateTest(String path) {
        loadTest(path);
    }

    //сохранение в файл
    public void saveTest(String path) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(path);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //загрузка из файла
    public void loadTest(String filePath) {
        RotateTest rotateTest = null;
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            rotateTest = (RotateTest) objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.initMatrix = rotateTest.initMatrix;
            this.rotateMatrix = rotateTest.rotateMatrix;
            this.angle = rotateTest.angle;
        }
    }

}
