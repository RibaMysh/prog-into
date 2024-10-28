import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;


public class Wspp {
    public static void main(String[] args) throws Exception{

        StringBuilder s;
        String str, line;
        LinkedHashMap<String, ArrayList<Integer>> dict = new LinkedHashMap<>();
        File f = new File(args[0]);
        ArrayList<Integer> lst = new ArrayList<>();
        int currentWord = 0, count, in, last;

        try {
            Scanner reader = new Scanner(f);

            try {
                while (reader.hasNextLine()) {
                    while (reader.hasNext()) {
                        
                        str = reader.next().toLowerCase();
                        reader.isItEOL();

                        if (!str.isEmpty()) {
                            currentWord++;
    


                            lst = dict.getOrDefault(str, new ArrayList<Integer>());
                            if (lst.isEmpty()) {
                                lst.add(1);
                            } else {
                                lst.set(0, lst.get(0) + 1);
                            }

                            lst.add(currentWord);

                            dict.put(str, lst);
                        }
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
            for (Map.Entry<String, ArrayList<Integer>> entry : dict.entrySet()) {
                s = new StringBuilder();
                String key = entry.getKey();
                ArrayList<Integer> value = entry.getValue();

                s.append(key + " ");
                for (Integer num : value) {
                    s.append(num + " ");
                }
                line = s.toString();
                line = line.trim() + System.lineSeparator();

                writer.write(line);

            }
        } finally {
            writer.close();
        }

    } catch (IOException e) {
        System.out.println(e.getMessage());
    }
    }
}

