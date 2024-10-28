public class Sum {
    public static void main(String[] args) {
        int sm = 0;
        StringBuilder s;
        for (String str : args) {
            s = new StringBuilder("");
            for (char symbol : str.toCharArray()) {
                if (!Character.isWhitespace(symbol)) {

                    s.append(symbol);
                } else {
                    if (! s.toString().equals("")) {
                        sm += Integer.parseInt(s.toString());
                    }
                    s = new StringBuilder("");
                }
            }
            if (! s.toString().equals("")) {
                sm += Integer.parseInt(s.toString());
            }
        }
        System.out.println(sm);
    }
}