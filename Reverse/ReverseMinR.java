import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class ReverseMinR  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList <int[]> array = new ArrayList <>();
        int[] arrayInt;
        int n, mn, i;

        while(sc.hasNextLine()) {

            mn = Integer.MAX_VALUE;
            Scanner scLine = new Scanner(sc.nextLine());
            arrayInt = new int[100];
            i = 1;

            while (scLine.hasNextInt()) {
                n = scLine.nextInt();
                mn = Math.min(n, mn);
                if (i == (arrayInt.length - 1) ) {
                    int[] cop = new int[arrayInt.length * 2];
                    System.arraycopy(arrayInt, 0, cop, 0, arrayInt.length);
                    arrayInt = cop;
                }
                arrayInt[i] = mn;
                i++;
            }
            arrayInt[0] = i;
            array.add(arrayInt);
        }
        for (i = 0; i < array.size(); i++) {
            for (int j = 1; j < array.get(i)[0]; j++) {
                System.out.print(array.get(i)[j] + " ");
            }
            System.out.println();
        }
    }
}
