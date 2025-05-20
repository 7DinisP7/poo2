package secondBrain;

import java.time.LocalDate;

public class PermanentNoteClass extends NoteClass {

    private final String TYPE = "permanent";

    public PermanentNoteClass(String type, LocalDate date, String noteID, String content) {
        super(type, date, noteID, content);
        type = TYPE;
    }

    @Override
    public String getType() {
        return TYPE;
    }
}
