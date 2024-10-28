import java.io.*;
import java.util.*;

public class WordStatInput {
    public static void main(String[] args) throws Exception{

        StringBuilder s;
        char ch;
        String str, line;
        Map<String, Integer> dict = new  LinkedHashMap<String, Integer>();
        BufferedReader reader = new BufferedReader(
                new InputStreamReader( new FileInputStream( args[0]),  "utf8") );


        try {

            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream (args[1]), "utf8") );

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
                            if (!s.toString().isEmpty()) {
                                str = s.toString();
                                dict.put(str, dict.getOrDefault(str, 0) + 1);
                            }
                            s = new StringBuilder();
                        }
                    }

                    if (!s.toString().isEmpty()) {
                        str = s.toString();
                        dict.put(str, dict.getOrDefault(str, 0) + 1);
                    }

                }

            } finally {
                for (Map.Entry<String, Integer> entry : dict.entrySet()) {
                    writer.write(entry.getKey() + " " + entry.getValue() + "\n");
                }
                writer.close();
            }
        } finally {
            reader.close();
        }
    }
}

