public class TextEditor {
    private String text;

    public TextEditor() {
        this.text = "";
    }

    public void appendText(String newText) {
        this.text += newText;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public TextState saveState() {
        return new TextState(this.text);
    }

    public void restoreState(TextState memento) {
        if (memento != null) {
            this.text = memento.getText();
        }
    }
}
