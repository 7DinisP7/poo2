package secondBrain;

import secondBrain.exceptions.*;
import java.time.DateTimeException;
import java.util.Iterator;

public interface SecondBrainApp {
    /**
     * Creates a new permanent note.
     * @param type the type of note (permanent)
     * @param year the year of creation of the note
     * @param month the month of creation of the note
     * @param day the day of creation of the note
     * @param id the id of the note
     * @param content the content of the note
     * @throws DateTimeException If the date is invalid
     * @throws DatePreceedsException if the date is before the current date of the system
     * @throws NoteAlreadyExistsException if already exists another note with the same name
     */
    void createPermanentNote(String type, int year, int month, int day, String id, String content) throws
            DateTimeException, DatePreceedsException, NoteAlreadyExistsException;

    void createLiteraryNote(String type, int year, int month, int day, String id, String content,
                            String author, int docYear, int docMonth, int docDay, String url, String quote)
            throws DateTimeException, InvalidDocDateException, DatePreceedsException, NoteAlreadyExistsException,
            DocDateExceedsException;

    /**
     * Gets a note´s content by its ID
     * @param noteID the ID of the note
     * @return the note´s content
     */
    String getNoteContent(String noteID) throws NoteDoesntExistException;

    /**
     * The iterator for all permanent notes.
     */
    Iterator<Note> permanentIterator();

    /**
     * Adds tag to a note
     * @param noteId  The note that is going to be tagged
     * @param tagId   Tag to be added
     * @throws NoteDoesntExistException  If note doesn't exist
     * @throws NoteAlreadyTaggedException  If note is already tagged
     */
    void createTag(String noteId, String tagId) throws NoteDoesntExistException, NoteAlreadyTaggedException;

}
