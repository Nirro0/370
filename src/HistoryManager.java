import java.util.Stack;

public class HistoryManager {
    private final Stack<TextState> undoStack = new Stack<>();
    private final Stack<TextState> redoStack = new Stack<>();

    public void saveState(TextState state) {
        undoStack.push(state);
        redoStack.clear(); // Clear redoStack because new changes invalidate redo history
    }

    public TextState undo() {
        if (!undoStack.isEmpty()) {
            TextState currentState = undoStack.pop(); // Get the current state
            redoStack.push(currentState); // Push it to the redo stack
            return undoStack.isEmpty() ? new TextState("") : undoStack.peek(); // Return the previous state
        }
        return new TextState(""); // Return an empty state if undoStack is empty
    }

    public TextState redo() {
        if (!redoStack.isEmpty()) {
            TextState currentState = redoStack.pop(); // Get the next state
            undoStack.push(currentState); // Push it back to the undo stack
            return currentState; // Return the next state
        }
        return null; // Return null if redoStack is empty
    }
}
