import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Task4 {

    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.out.println("");
            return;
        }
        ArrayList<Integer>arrayList=readIntsFromFile(args[0]);
        Integer[] array = arrayList.toArray(new Integer[arrayList.size()]);
        Arrays.sort(array);
        int mediana = findMedianaInSortedArray(array);
        int steps = countSteps(mediana, array);
        System.out.println(steps);
    }
    private static ArrayList<Integer> readIntsFromFile(String filename) throws IOException {
        ArrayList<Integer> arrayList = new ArrayList<>();
        FileReader fileReader = new FileReader(filename);
        Scanner scanner = new Scanner(fileReader);
        while (scanner.hasNextInt()) {
            arrayList.add(scanner.nextInt());
        }
        return arrayList;
    }
    private static int findMedianaInSortedArray(Integer[] sortedArr) {
        if (sortedArr.length < 1)
            return 0;
        if (sortedArr.length % 2 == 0) {
            return (sortedArr[sortedArr.length / 2 - 1] + sortedArr[sortedArr.length / 2]) / 2;
        } else
            return sortedArr[sortedArr.length / 2 ];
    }
    private static int countSteps(int mediana, Integer[] sortedArray) {
        int count = 0;
        for (int i :
                sortedArray) {
            while (i < mediana) {
                i++;
                count++;
            }
            while (i > mediana) {
                i--;
                count++;
            }
        }
        return count;
    }
}