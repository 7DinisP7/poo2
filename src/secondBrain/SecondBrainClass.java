package secondBrain;

import secondBrain.exceptions.*;

import java.time.DateTimeException;
import java.util.*;
import java.time.LocalDate;

public class SecondBrainClass implements SecondBrainApp {
    private Map<String, Note> allNotes;
    private List<Note> permanentNotes;
    private List<Note> literaryNotes;
    private Map<String, Note> tags;
    private LocalDate currentSystemDate;

    public SecondBrainClass() {
        allNotes = new HashMap<>();
        permanentNotes = new ArrayList<>();
        literaryNotes = new ArrayList<>();
        tags = new HashMap<>();
        currentSystemDate = LocalDate.MIN;
    }

    @Override
    public void createPermanentNote(String type, int year, int month, int day, String id, String content) throws
            DateTimeException, DatePreceedsException, NoteAlreadyExistsException {
        LocalDate date = LocalDate.of(year, month, day);
        if(date.isBefore(currentSystemDate)) {
            throw new DatePreceedsException();
        }
        if(allNotes.containsKey(id)) {
            throw new NoteAlreadyExistsException();
        }
        currentSystemDate = date;
        Note newNote = new PermanentNoteClass(type, date, id, content);
        allNotes.put(id, newNote);
        permanentNotes.add(newNote);
    }

    @Override
    public void createLiteraryNote(String type, int year, int month, int day, String id, String content, String author,
                                   int docYear, int docMonth, int docDay, String url, String quote)
            throws DateTimeException, DatePreceedsException, NoteAlreadyExistsException,
            DocDateExceedsException {
        LocalDate date = LocalDate.of(year, month, day);
        LocalDate docDate = LocalDate.of(docYear, docMonth, docDay);
        if(date.isBefore(currentSystemDate)) {
            throw new DatePreceedsException();
        }
        if(allNotes.containsKey(id)) {
            throw new NoteAlreadyExistsException();
        }
        if(docDate.isAfter(currentSystemDate)){
            throw new DocDateExceedsException();
        }
        currentSystemDate = date;
        Note newNote = new LiteraryNoteClass(type, date, id, content, author, docDate, url, quote);
        allNotes.put(id, newNote);
        literaryNotes.add(newNote);
    }

    @Override
    public Note getNoteByID(String noteID) throws NoteDoesntExistException{
        return ;
    }


    @Override
    public Iterator<Note> permanentIterator() {
        return permanentNotes.iterator();
    }


}
