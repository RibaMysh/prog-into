

import java.io.*;
import java.util.Objects;

public class Scanner {
    boolean flag = false;
    Reader reader;
    int countRead = 1024, id;
    Integer fullness;
    char[] block = new char[countRead];

    public Scanner(InputStream s) throws IOException {
        this.reader = new BufferedReader(
                new InputStreamReader(s, "utf8"));
        fullness = reader.read(block);
        this.id = 0;
    }

    public Scanner(String text) throws IOException {
        this.reader = new StringReader(text);
        fullness = reader.read(block);
        this.id = 0;
    }

    public Scanner(File file) throws IOException {
        this.reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(file), "utf8"));
        fullness = reader.read(block);
        id = 0;
    }
    public void tryToRefresh() throws Exception {
        if (id >= fullness) {
            fullness = reader.read(block);
            if(fullness.equals(-1)) {
                block = new char[1024];
            }
            id = 0;
        }
    }

    private String isLineSep() throws Exception{

        if(block[id] == System.lineSeparator().charAt(0)){
            StringBuilder sep = new StringBuilder();
            for(int i = 0; i < System.lineSeparator().length(); i++){
                sep.append(block[id]);
                if(sep.toString().equals(System.lineSeparator())){
                    return sep.toString();
                }
                id++;
                tryToRefresh();
            }
        }
        return String.valueOf(block[id]);
    }
    public boolean hasNextInt() throws Exception{
        tryToRefresh();

        while (!fullness.equals(-1)) {
            if (block[id] == '-' || Character.isDigit(block[id])) {
                return true;
            }
            id++;
            tryToRefresh();
        }

        return false;
    }
    public int nextInt () throws Exception {

        tryToRefresh();
        StringBuilder n = new StringBuilder();

        while (!Character.isSpaceChar(block[id]) && !Objects.equals(isLineSep(), System.lineSeparator()) && !fullness.equals(-1)) {

            n.append(block[id]);
            id++;
            tryToRefresh();
        }

        return Integer.parseInt(n.toString());
    }

    public boolean hasNextLine() throws Exception{
        tryToRefresh();
        if(fullness.equals(-1)) {
            return false;
        }
        return true;
    }

    public String nextLine() throws Exception{
        tryToRefresh();
        StringBuilder line = new StringBuilder();
        while (!Objects.equals(isLineSep(), System.lineSeparator())) {
            line.append(block[id]);
            id++;
            tryToRefresh();
        }
        id++;
        return line.toString();
    }

    public boolean hasNextAlpha() throws Exception{

        tryToRefresh();

        while (!fullness.equals(-1)) {
            if (Character.isAlphabetic(block[id]) || block[id] == '-') {
                return true;
            }
            id++;
            tryToRefresh();
        }
        return false;
    }
    public String nextAlpha () throws Exception {

        tryToRefresh();
        StringBuilder s = new StringBuilder();

        while (!Character.isSpaceChar(block[id]) && !fullness.equals(-1)) {

            s.append(block[id]);
            id++;
            tryToRefresh();
        }

        return s.toString();
    }
    public String next() throws Exception{
        tryToRefresh();
        StringBuilder s = new StringBuilder();

        while(!fullness.equals(-1) && !Character.isSpaceChar(block[id]) ) {

            if(Character.isLetter(block[id]) || block[id] == '\'' || Character.getType(block[id]) == Character.DASH_PUNCTUATION){
                s.append(block[id]);

            } else if(isLineSep().equals(System.lineSeparator())) {
                return s.toString();

            } else {
                id++;
                tryToRefresh();
                return s.toString();
            }
            id++;
            tryToRefresh();
        }
        return s.toString();
    }
    public boolean hasNext() throws Exception{
        while (!fullness.equals(-1)) {
            if (!Character.isSpaceChar(block[id]) || isLineSep().equals(System.lineSeparator())){
                return true;
            }
            
            id++;
            tryToRefresh();
        }
        return false;
    }
    public boolean isItEOL() throws Exception{
        if(isLineSep().equals(System.lineSeparator())) {
            id++;
            tryToRefresh();
            return true;
        }
        return false;
    }
    public void close() throws Exception{
        reader.close();
    }
}