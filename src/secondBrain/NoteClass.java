package secondBrain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class NoteClass implements Note {
    String noteId;
    String type;
    String content;
    LocalDate date;
    List<String> links;
    List<String> tags;  //!

    public NoteClass(String type, LocalDate date, String noteId, String content) {
        this.noteId = noteId;
        this.content = content;
        this.date = date;
        links = new ArrayList<>();
        tags = new ArrayList<>();  //!
    }

    public abstract String getType();

    public String getNoteId() {
        return noteId;
    }

    public String getContent() {
        return content;
    }
    public LocalDate getDate() {
        return date;
    }

}
