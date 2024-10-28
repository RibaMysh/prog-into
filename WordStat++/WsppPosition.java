import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class WsppPosition {
    public static void main(String[] args) {

        File f = new File(args[0]);
        String word, line;
        StringBuilder s;
        Map<String, List<Integer>> dict = new LinkedHashMap<>();
        List<Integer> lst;
        List<String> words = new ArrayList<>();
        int currentWordIndex, lineCount = 1;

        try {
            Scanner reader = new Scanner(f);

            try {

                while (reader.hasNext()) {
                    word = reader.next().toLowerCase();
                    if (!word.isEmpty()) {
                        words.add(word);
                        lst = dict.getOrDefault(word, new ArrayList<>());
                        if (lst.isEmpty()) {
                            lst.add(1);
                        } else {
                            lst.set(0, lst.get(0) + 1);
                        }
                        dict.put(word, lst);
                    }
                    if (reader.isItEOL()) {
                        currentWordIndex = words.size();
                        for (String currentWord : words) {
                            lst = dict.get(currentWord);
                            lst.add(lineCount);
                            lst.add(currentWordIndex);
                            currentWordIndex--;
                        }
                        words = new ArrayList<>();
                        lineCount++;
                    }

                }
                currentWordIndex = words.size();
                for (String currentWord : words) {
                    lst = dict.get(currentWord);
                    lst.add(lineCount);
                    lst.add(currentWordIndex);
                    currentWordIndex--;
                }
            } catch (Exception e) {
                // IOException
                throw new IOException(e);
                // print e.getMessage();

            } finally {
                //try catch
                reader.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(args[1]), "utf8"));
            try {
                for (Map.Entry<String, List<Integer>> entry : dict.entrySet()) {
                    s = new StringBuilder();
                    String key = entry.getKey();
                    List<Integer> value = entry.getValue();

                    s.append(key + " " + value.get(0) + " ");
                    for (int i = 1; i < value.size(); i += 2) {
                        s.append(value.get(i) + ":" + value.get(i + 1) + " ");
                    }
                    line = s.toString();
                    line = line.trim() + System.lineSeparator();

                    writer.write(line);

                }
            } finally {
                // try catch
                writer.close();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }
}

