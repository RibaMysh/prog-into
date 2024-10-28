package md2html;

import java.util.Map;

public class Wrapper {
    protected String s;

    public Wrapper(String s) {
        this.s = s;
    }

    Map<String, String> dictMarks = Map.of(
            "*", "em",
            "**", "strong",
            "_", "em",
            "__", "strong",
            "--", "s",
            "`", "code",
            "''", "q");
    Map<Character, String> symbols = Map.of(
            '&', "&amp;",
            '>', "&gt;",
            '<', "&lt;");

    private String coverToHtml(String s) {
        if (s.charAt(0) == '#') {
            return coverToHash(s);
        }
        return coverToParagraph(s);
    }

    private String coverToHash(String s) {
        int countHash = 0;
        while (s.charAt(countHash) == '#') {
            countHash++;
        }
        if (!(s.charAt(countHash) == ' ')) {
            return coverToParagraph(s);
        }
        s = s.substring(countHash).trim();
        return ("<h" + countHash + ">" + s + "</h" + countHash + ">");
    }

    private String coverToParagraph(String s) {
        return "<p>" + s + "</p>";
    }

    private String ToMarkDown(String s) {
        StringBuilder total = new StringBuilder(), subS = new StringBuilder();
        String ch, mark = null, potentialMark;
        boolean flag = false;
        boolean ignore = false;
        boolean isItDouble = false;
        for (int i = 0; i < s.length(); i++) {
            ch = Character.toString(s.charAt(i));
            try {
                potentialMark = s.substring(i, i + 2);
            } catch (IndexOutOfBoundsException e) {
                potentialMark = "";
            }
            if (ch.equals("\\")) {
                ignore = true;
                continue;
            }
            if ((dictMarks.containsKey(ch) || dictMarks.containsKey(potentialMark)) && !ignore) {
                if (!flag) {
                    flag = true;
                    isItDouble = dictMarks.containsKey(potentialMark);
                    if (isItDouble) {
                        mark = potentialMark;
                        subS.append(potentialMark);
                        i++;
                        continue;
                    }
                    mark = ch;
                } else if (mark.contains(ch)) {
                    if (isItDouble) {
                        try {
                            potentialMark = s.substring(i, i + 2);
                        } catch (IndexOutOfBoundsException e) {
                            potentialMark = "";
                        }
                        if (potentialMark.equals(mark)) {
                            total.append(ToMarkDown(subS.substring(2), mark));
                            subS = new StringBuilder();
                            flag = false;
                            i++;
                            continue;
                        }
                    } else {
                        if (dictMarks.containsKey(potentialMark)) {
                            subS.append(potentialMark);
                            i++;
                            continue;
                        }
                        total.append(ToMarkDown(subS.substring(1), mark));
                        subS = new StringBuilder();
                        flag = false;
                        continue;
                    }
                }
            }
            if (flag) {
                subS.append(ch);
            } else {
                total.append(ch);
            }
            ignore = false;
        }
        if (!subS.isEmpty()) {
            total.append(subS.charAt(0)).append(ToMarkDown(subS.substring(1)));
        }
        return total.toString();
    }

    private String ToMarkDown(String s, String mark) {
        return "<" + dictMarks.get(mark) + ">" + ToMarkDown(s) + "</" + dictMarks.get(mark) + ">";
    }

    private String replaceThing(String s) {
        StringBuilder total = new StringBuilder();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (symbols.containsKey(ch)) {
                total.append(symbols.get(ch));
            } else {
                total.append(ch);
            }
        }
        return total.toString();

    }

    public String wrap() {
        return ToMarkDown(coverToHtml(replaceThing(s)));
    }

}
