import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Calendar;
import java.time.ZoneId;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class AkidoTrainer {
     List<PracticeSession> trainingLog = new ArrayList<>();
    private String name;
    private final Date startDate;

    public AkidoTrainer(String name) {
        this.name = name;
        this.startDate = new Date();
        System.out.println("Welcome to the Aikido training program, " + name);
        System.out.println("Your training starts now!");
        System.out.println("Starting date: " + startDate);
    }

    public void addSession(Date date, int duration) {
        PracticeSession practiceSession = new PracticeSession(date, duration);
        trainingLog.add(practiceSession);
        System.out.printf("Training session %d is completed\n", trainingLog.size());
    }

    public int getTotalSessions() {
        return trainingLog.size();
    }

    public boolean checkGraduation() {
        if (trainingLog.isEmpty()) {
            return false;
        }

        Date today = trainingLog.get(trainingLog.size() - 1).getDate();
        long monthsTrained = ChronoUnit.MONTHS.between(
                convertToLocalDate(startDate), convertToLocalDate(today));

        return monthsTrained >= 6 || trainingLog.size() >= 100;
    }

    private LocalDate convertToLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
