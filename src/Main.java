import secondBrain.exceptions.*;
import secondBrain.*;

import java.time.DateTimeException;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    //Commands
    public static final String HELP = "help";
    public static final String EXIT = "exit";
    public static final String CREATE = "create";
    public static final String READ = "read";
    public static final String UPDATE = "update";
    public static final String DELETE = "delete";
    public static final String LINKS = "links";
    public static final String TAG = "tag";
    public static final String UNTAG = "untag";
    public static final String TAGS = "tags";
    public static final String TAGGED = "tagged";
    public static final String TRENDING = "trending";
    public static final String NOTES = "notes";

    //Output messages
    public static final String UNKNOWN = "Unknown command. Type help to see available commands.";
    public static final String BYE = "Bye!";
    private static final String INVALID_DATE = "Invalid date!";
    private static final String TIME_TRAVEL = "No time travelling!";
    private static final String NOTE_EXISTS = "%s already exists!";
    private static final String NOTE_ADDED = "Note %s was created successfully with links to %d notes.\n";
    private static final String NOTE_CONTENT = "%s: %s - %d links. %s tags.\n";
    private static final String NOTE_NOT_EXISTS = "Note %s does not exist!\n";
    private static final String INVALID_DOC_DATE = "Invalid document date!";
    private static final String TIME_TRAVEL_FUTURE = "No time traveling to the future!";

    private static final String PERMANENT = "permanent";
    private static final String LITERARY = "literary";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SecondBrainApp scApp = new SecondBrainAppClass();
        executeCommand(sc, scApp);
        sc.close();
    }

    public static void executeCommand(Scanner in, SecondBrainApp scApp) {
        String command;
        do{
            command = in.next().toLowerCase();

            switch (command) {
                case EXIT -> {
                    System.out.println(BYE);
                }
                case HELP -> executeHelp();
                case CREATE -> executeCreate(in, scApp);
                case READ -> executeRead(in, scApp);
                case NOTES -> listPermanentNotes(in, scApp);
                case TAG -> executeTag(in, scApp);
                default -> System.out.println(UNKNOWN);
            }

        }while(!command.equals(EXIT));
    }

    /**
     * Executes the command help.
     */
    public static void executeHelp() {
        for (Commands c : Commands.values()) {
            System.out.println(c.name().toLowerCase() + " "+"-"+" " + c.getDescription());
        }
    }

    public static void executeCreate(Scanner in, SecondBrainApp scApp ) {
        String type = in.next().toLowerCase();
        switch(type){
            case PERMANENT -> createPermanentNote(in, scApp, type);
            case LITERARY -> createLiteraryNote(in, scApp, type);
        }
    }

    /**
     * Creates a new literary note.
     * @param in the scanner to read the user input.
     * @param scApp the system class.
     * @param type the type of note (in this case, literary).
     */
    private static void createLiteraryNote(Scanner in, SecondBrainApp scApp, String type) {
        int year = in.nextInt();
        int month = in.nextInt();
        int day = in.nextInt();
        in.nextLine();
        String noteID = in.nextLine().trim();
        String content = in.nextLine().trim();
        String author = in.nextLine().trim();
        int docYear = in.nextInt();
        int docMonth = in.nextInt();
        int docDay = in.nextInt();
        in.nextLine();
        String url = in.nextLine().trim();
        String quote = in.nextLine().trim();
        try{
            scApp.createLiteraryNote(type, year, month, day, noteID, content, author, docYear, docMonth,
                    docDay, url, quote);
            System.out.printf(NOTE_ADDED,noteID, 0);
        } catch (DateTimeException e){
            System.out.println(INVALID_DATE);
        } catch(InvalidDocDateException e){
            System.out.println(INVALID_DOC_DATE);
        } catch (DatePreceedsException e){
            System.out.println(TIME_TRAVEL);
        } catch (NoteAlreadyExistsException e){
            System.out.println(NOTE_EXISTS);
        } catch (DocDateExceedsException e){
            System.out.println(TIME_TRAVEL_FUTURE);
        }
    }

    /**
     * Creates a new permanent note.
     * @param in the scanner to read the user input.
     * @param scApp the system class.
     * @param type the type of note (in this case, permanent).
     */
    private static void createPermanentNote(Scanner in, SecondBrainApp scApp, String type) {
        int year = in.nextInt();
        int month = in.nextInt();
        int day = in.nextInt();
        in.nextLine();
        String id = in.nextLine().trim();
        String content = in.nextLine().trim();
        try{
            scApp.createPermanentNote(type, year, month, day, id, content);
            System.out.printf(NOTE_ADDED, id, 0);
        } catch(DateTimeException e){
            System.out.println(INVALID_DATE);
        } catch (DatePreceedsException e) {
            System.out.println(TIME_TRAVEL);
        } catch (NoteAlreadyExistsException e) {
            System.out.printf(NOTE_EXISTS, id);
        }
    }

    /**
     * Executes the command "read".
     * @param in the scanner to read the user input.
     * @param scApp the system class.
     */
    private static void executeRead(Scanner in, SecondBrainApp scApp) {
        String noteId = in.nextLine().trim();
        try{
            System.out.printf(NOTE_CONTENT, noteId, scApp.getNoteContent(noteId), 0, 0);
        } catch (NoteDoesntExistException e) {
            System.out.printf(NOTE_NOT_EXISTS, noteId);
        }
    }

    /**
     * Lists all permanent notes.
     * @param in the scanner to read the user input
     * @param scApp the system call
     */
    private static void listPermanentNotes(Scanner in, SecondBrainApp scApp) {
        String type = in.nextLine().trim().toLowerCase();
        int year1 = in.nextInt();
        int month1 = in.nextInt();
        int day1 = in.nextInt();
        in.nextLine();
        int year2 = in.nextInt();
        int month2 = in.nextInt();
        int day2 = in.nextInt();
        in.nextLine();
        Iterator<Note> it = scApp.permanentIterator();
        while(it.hasNext()){
            Note note = it.next();
            System.out.println(note.getType());
        }
    }

   private static void executeTag(Scanner in, SecondBrainApp scApp) {
       String noteId = in.nextLine().trim();




    }


}
