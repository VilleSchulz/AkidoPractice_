import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AkidoTrainerTest {
    AkidoTrainer akidoTrainer;

    @BeforeEach
    void setUp() {
        akidoTrainer = new AkidoTrainer("John");
    }

    @Test
    void addSession() {
        akidoTrainer.addSession(new Date(), 60);
        assertEquals(1, akidoTrainer.getTotalSessions());
        akidoTrainer.addSession(new Date(), 60);
        assertEquals(2, akidoTrainer.getTotalSessions());
        akidoTrainer.addSession(new Date(), 60);
        akidoTrainer.addSession(new Date(), 60);
        assertEquals(4, akidoTrainer.getTotalSessions());
    }

    @Test
    void getTotalSessions() {
        assertEquals(0, akidoTrainer.getTotalSessions());
        akidoTrainer.addSession(new Date(), 60);
        assertEquals(1, akidoTrainer.getTotalSessions());
        akidoTrainer.addSession(new Date(), 60);
    }

    @Test
    void checkGraduation() {
        Calendar calendar = Calendar.getInstance();
        assertEquals(false, akidoTrainer.checkGraduation());
        for (int i = 0; i < 100; i++) {
            akidoTrainer.addSession(new Date(), 60);
        }
        assertEquals(true, akidoTrainer.checkGraduation());

        calendar.add(Calendar.MONTH, 6);
        Date date = calendar.getTime();
        System.out.println(date);
        AkidoTrainer akidoTrainer2 = new AkidoTrainer("Jane");
        akidoTrainer2.addSession(new Date(), 60);
        assertEquals(false, akidoTrainer2.checkGraduation());
        akidoTrainer2.addSession(date, 60);

        assertEquals(true, akidoTrainer2.checkGraduation());
    }
}