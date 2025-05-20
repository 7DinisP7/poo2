package secondBrain;

import java.time.LocalDate;

public interface Note {
    String getType();
    LocalDate getDate();
    String getNoteId();
    String getContent();
}
