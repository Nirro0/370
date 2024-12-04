import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TextEditorTest {

    @Test
    public void testUndoFunctionality() {
        // Arrange
        TextEditor editor = new TextEditor();
        HistoryManager history = new HistoryManager();

        editor.appendText("Happy");
        history.saveState(editor.saveState());

        editor.appendText("Birthday");
        history.saveState(editor.saveState());

        // Act
        editor.restoreState(history.undo());

        // Assert
        assertEquals("Hello ", editor.getText());
    }

    @Test
    public void testRedoFunctionality() {
        // Arrange
        TextEditor editor = new TextEditor();
        HistoryManager history = new HistoryManager();

        editor.appendText("Hello ");
        history.saveState(editor.saveState());

        editor.appendText("World!");
        history.saveState(editor.saveState());

        // Perform undo first
        editor.restoreState(history.undo());

        // Act
        editor.restoreState(history.redo());

        // Assert
        assertEquals("Hello World!", editor.getText());
    }
}
