import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Task2 {
    public static void main(String[] args) {
        float[] circle = getCircle(args[0]);
        ArrayList<float[]> points = getPoint(args[1]);
        for (float[] point : points) {
            float left = (circle[0] - point[0]) * (circle[0] - point[0]) + (circle[1] - point[1]) * (circle[1] - point[1]);
            float square_rad = circle[2] * circle[2];
            if (left < square_rad) {
                System.out.println("1 - точка внутри");
            } else if (left == square_rad) {
                System.out.println("0 - точка лежит на окружности");
            } else {
                System.out.println("2 - точка снаружи");
            }
        }
    }
    private static float[] getCircle(String file) {
        float[] circle = new float[3];
        try {
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String[] _circle = reader.readLine().split(" ");
            circle[0] = Float.parseFloat(_circle[0]);
            circle[1] = Float.parseFloat(_circle[1]);
            circle[2] = Float.parseFloat(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return circle;
    }
    private static ArrayList<float[]> getPoint(String fileName) {
        ArrayList<float[]> points = new ArrayList<>();
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                String[] _circle = line.split(" ");
                float[] point = new float[2];
                point[0] = Float.parseFloat(_circle[0]);
                point[1] = Float.parseFloat(_circle[1]);
                points.add(point);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return points;
    }
}