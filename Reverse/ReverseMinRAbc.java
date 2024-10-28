import java.util.ArrayList;
import java.util.HashMap;

public class ReverseMinRAbc  {

    static HashMap<Character, Character> lettersInt = new HashMap<>();
    static HashMap<Character, Character> intLetters = new HashMap<>();

    public static int alphaToInt (String alpha){

        StringBuilder n = new StringBuilder();

        for ( int i = 0; i < alpha.length(); i++ ){
            n.append(lettersInt.get(alpha.charAt(i)));
        }

        return Integer.parseInt(n.toString());
    }

    public static String intToAlpha (int n){
        StringBuilder s = new StringBuilder();

        String ns = String.valueOf(n);
        for (int i = 0; i < ns.length(); i++){
            s.append(intLetters.get(ns.charAt(i)));
        }

        return s.toString();
    }

    public static void main(String[] args) throws Exception{

        char[] letters = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};
        for(int i = 0; i < letters.length; i++){
            intLetters.put((char)(i+'0'), letters[i]);
            lettersInt.put(letters[i], (char)(i+'0'));
        }
        lettersInt.put('-', '-');
        intLetters.put('-', '-');

        Scanner sc = new Scanner(System.in);
        ArrayList <int[]> array = new ArrayList <>();
        int[] arrayInt;
        int n, mn, i;
        String s;

        while(sc.hasNextLine()) {

            mn = Integer.MAX_VALUE;
            Scanner scLine = new Scanner(sc.nextLine());
            arrayInt = new int[100];
            i = 1;

            while (scLine.hasNextAlpha()) {
                s = scLine.nextAlpha();
                n = alphaToInt(s);
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
        sc.close();

        for (i = 0; i < array.size(); i++) {
            for (int j = 1; j < array.get(i)[0]; j++) {
                System.out.print(intToAlpha(array.get(i)[j]) + " ");
            }
            System.out.println();
        }

    }
}