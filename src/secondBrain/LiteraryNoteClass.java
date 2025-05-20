package secondBrain;

import java.time.LocalDate;

public class LiteraryNoteClass extends NoteClass implements LiteraryNote{

    private final String TYPE = "literary";

    private String author;
    private LocalDate docDate;
    private String url;
    private String quote;

    public LiteraryNoteClass(String type, LocalDate date, String noteID, String content, String author,
                             LocalDate docDate, String url, String quote) {
        super(type, date, noteID, content);
        super.type = TYPE;
        this.author = author;
        this.docDate = docDate;
        this.url = url;
        this.quote = quote;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public LocalDate getDocDate() {
        return docDate;
    }

    @Override
    public String getURL() {
        return url;
    }

    @Override
    public String getQuote() {
        return quote;
    }
}
