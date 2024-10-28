package markup;

import java.util.List;

public class Emphasis extends AbstractMark {
    public Emphasis(List<Marks> lst) {
        super(lst, "*", "i");
//        this.markdownTag = "*";
//        this.bbCodeTag = "i";
    }
}
