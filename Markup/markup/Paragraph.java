package markup;

import java.util.List;

public class Paragraph {
    private final List<Marks> elements;

    public Paragraph(List<Marks> lst) {
        this.elements = lst;
    }

    public void toMarkdown(StringBuilder s) {
        for (Marks el : elements) {
            el.toMarkdown(s);
        }
    }

    public void toBBCode(StringBuilder s) {
        for (Marks el : elements) {
            el.toBBCode(s);
        }
    }
}
