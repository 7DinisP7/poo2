package secondBrain;

import java.time.LocalDate;

public abstract class NoteClass implements Note {
    String noteId;
    String type;
    String content;
    LocalDate date;

    public NoteClass(String type, LocalDate date, String noteId, String content) {
        this.noteId = noteId;
        this.content = content;
        this.date = date;
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
