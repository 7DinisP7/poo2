package secondBrain;

import java.time.LocalDate;

public interface LiteraryNote extends Note {
    String getAuthor();
    LocalDate getDocDate();
    String getURL();
    String getQuote();

}
