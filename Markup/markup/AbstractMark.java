package markup;

import java.util.List;

public abstract class AbstractMark implements Marks {
    protected List<Marks> elements;
    protected String markdownTag;
    protected String bbCodeTag;

    public AbstractMark(List<Marks> lst, String tag, String bb) {
        this.elements = lst;
        this.markdownTag = tag;
        this.bbCodeTag = bb;
    }

    public void toBBCode(StringBuilder s) {
        s.append("[").append(bbCodeTag).append("]");
        for (Marks mark : elements) {
            mark.toBBCode(s);
        }
        s.append("[/").append(bbCodeTag).append("]");
    }

    public void toMarkdown(StringBuilder s) {
        s.append(markdownTag);
        for (Marks mark : elements) {
            mark.toMarkdown(s);
        }
        s.append(markdownTag);
    }
}
