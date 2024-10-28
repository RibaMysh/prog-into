package md2html;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;


public class Md2Html {
    public Md2Html(File input, File output) { // :NOTE: Utility class
        String s, sbString;
        StringBuilder sb = new StringBuilder();
        List<String> lst = new ArrayList<>();
        try {
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(input), StandardCharsets.UTF_8))) {
                while (true) {
                    s = reader.readLine();
                    if (s == null) {
                        break;
                    }
                    if (!s.isEmpty()) {
                        sb.append(s).append(System.lineSeparator());
                    } else {
                        sbString = sb.toString();
                        if (!sbString.isEmpty()) {
                            Wrapper wr = new Wrapper(sbString.substring(0, sb.length() - System.lineSeparator().length()));
                            lst.add(wr.wrap());
                        }
                        sb = new StringBuilder();
                    }
                }
                sbString = sb.toString();
                if (!sbString.isEmpty()) {
                    Wrapper wr = new Wrapper(sbString.substring(0, sb.length() - System.lineSeparator().length()));
                    lst.add(wr.wrap());
                }

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            try (BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(output), StandardCharsets.UTF_8))) {
                for (int i = 0; i + 1 < lst.size(); i++) {
                    writer.write(lst.get(i) + System.lineSeparator());
                }
                writer.write(lst.get(lst.size() - 1));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        // :NOTE: args != null && args.length == 2 && args[0] != null && args[1] != null

        File arg1 = new File(args[0]);
        File arg2 = new File(args[1]);
        new Md2Html(arg1, arg2);
    }
}
