package secondBrain;

import java.time.LocalDate;

public class ReferenceClass extends NoteClass{

    private final String TYPE = "tag";

    public ReferenceClass(String type, LocalDate date, String noteID, String content) {
        super(type, date, noteID, content);
        super.type = TYPE;
    }

    @Override
    public String getType() {
        return type;
    }
}
