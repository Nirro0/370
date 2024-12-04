public class main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        HistoryManager history = new HistoryManager();

        // Initial state
        editor.appendText("Hello ");
        history.saveState(editor.saveState()); // Save state after initial append

        // New state
        editor.appendText("World!");
        history.saveState(editor.saveState()); // Save state after adding more text

        // Display current text
        System.out.println("Current Text: " + editor.getText()); // Output: Hello World!

        // Undo operation
        editor.restoreState(history.undo());
        System.out.println("After Undo: " + editor.getText()); // Output: Hello 

        // Redo operation
        editor.restoreState(history.redo());
        System.out.println("After Redo: " + editor.getText()); // Output: Hello World!
    }
}
