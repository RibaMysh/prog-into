import java.util.ArrayList;

import java.util.Scanner;


public class Reverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList> array = new ArrayList<ArrayList>();
        ArrayList<Integer> arrayInt;
        String s;
        while (sc.hasNextLine()){

            s = sc.nextLine();
            Scanner scLine = new Scanner(s);
            arrayInt = new ArrayList<>();

            while ( scLine.hasNextInt() ) {
                arrayInt.add(scLine.nextInt());
            }

            array.add(arrayInt);
        }
        for (int i = array.size() - 1 ; i >= 0; i -- ){

            for (int j = array.get(i).size() - 1; j >= 0; j --){

                System.out.print(array.get(i).get(j) + " ");
            }

            System.out.print("\n");
        }
    }
}
