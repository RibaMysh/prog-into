public class SumDouble {
    public static void main(String[] args) {
        Double sm = 0.0;
        StringBuilder s;
        for (String str : args) {
            s = new StringBuilder("");
            for (int i = 0; i < str.length(); i ++) {
                if (!Character.isWhitespace(str.charAt(i))) {

                    s.append(str.charAt(i));
                } else {
                    if (! s.toString().isEmpty()) {
                        sm += Double.parseDouble(s.toString());
                    }
                    s = new StringBuilder("");
                }
            }
            if (! s.toString().isEmpty()) {
                sm += Double.parseDouble(s.toString());
            }
        }
        System.out.println(sm);
    }
}
