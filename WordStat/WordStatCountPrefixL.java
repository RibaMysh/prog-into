import java.io.*;
import java.util.*;

public class WordStatCountPrefixL {
    public static void main(String[] args) {

        StringBuilder s;
        char ch;
        String str, line;
        Map<String, Integer> dict = new  LinkedHashMap<>();

        try {
            BufferedReader reader = new BufferedReader( 
                    new InputStreamReader(new FileInputStream(args[0]), "utf8")
            );

            try {
                while (true) {
                    line = reader.readLine();
                    if (line != null) {
                        line = line.toLowerCase();
                    } else {
                        break;
                    }

                    s = new StringBuilder();

                    for (int i = 0; i < line.length(); i++) {
                        ch = line.charAt(i);
                        if (Character.isLetter(ch) || ch == '\'' || Character.getType(ch) == Character.DASH_PUNCTUATION) {
                            s.append(ch);
                        } else {
                            str = s.toString();
                            if ( str.length() >= 3) {
                                dict.put(str.substring(0, 3), dict.getOrDefault(str.substring(0, 3), 0) + 1);
                            }
                            s = new StringBuilder();
                        }
                    }

                    str = s.toString();
                    if ( str.length() >= 3) {
                        dict.put(str.substring(0, 3), dict.getOrDefault(str.substring(0, 3), 0) + 1);
                    }
                }
            } finally {
                reader.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        try {
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream (args[1]), "utf8") );
            try{
                ArrayList<Integer> lstV = new ArrayList<>(dict.values());

                Integer curV, v;
                String k;
                Collections.sort(lstV);

                while (lstV.size() != 0) {
                    curV = lstV.get(0);
                    for (Map.Entry<String, Integer> entry : dict.entrySet()) {
                        k = entry.getKey();
                        v = entry.getValue();
                        if (curV.equals(v)) {
                            writer.write(k + " " + v + "\n");
                            dict.remove(k);
                            lstV.remove(0);
                            break;
                        }
                    }
                }
            } finally {
                writer.close();
            }
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } 
    }
}

