public enum Commands {
    CREATE("creates a new note"),
    READ("reads a note"),
    UPDATE("updates a note"),
    LINKS("lists all links to a note"),
    TAG("tags a note"),
    UNTAG("untags a note"),
    TAGS("Lists all the students in the community"),
    TAGGED("lists all notes with a specific tag"),
    TRENDING("lists the most popular tags"),
    NOTES("lists all notes of a given type last edited within a given time interval"),
    DELETE("deletes a note"),
    HELP("shows the available commands"),
    EXIT("terminates the execution of the program");

    private final String description;

    Commands(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
