package markup;

public class Text implements Marks {
    protected String text;

    public Text(String text) {
        this.text = text;
    }

    @Override
    public void toMarkdown(StringBuilder s) {
        s.append(text);
    }

    @Override
    public void toBBCode(StringBuilder s) {
        s.append(text);
    }
}
