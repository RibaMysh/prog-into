package markup;

import java.util.List;

public class Strikeout extends AbstractMark {
    public Strikeout(List<Marks> lst) {
        super(lst, "~", "s");
//        this.markdownTag = "~";
//        this.bbCodeTag = "s";
    }
}
