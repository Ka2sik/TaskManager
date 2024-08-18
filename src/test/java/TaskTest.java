import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    public void shouldFindMatchesInASimpleTask() {
        SimpleTask task = new SimpleTask(1, "Сходить в магазин");

        boolean actual = task.matches("магазин");

        Assertions.assertTrue(actual);
    }

    @Test
    public void shouldNotFindMatchesInASimpleTask() {
        SimpleTask task = new SimpleTask(1, "Сходить в магазин");

        boolean actual = task.matches("Позвонить");

        Assertions.assertFalse(actual);
    }

    @Test
    public void shouldFindMatchesInEpic() {
        String[] subtasks = {"Мясо", "Сыр", "Молоко"};
        Epic epic = new Epic(22, subtasks);

        boolean actual = epic.matches("Сыр");

        Assertions.assertTrue(actual);
    }

    @Test
    public void shouldNotFindMatchesInEpic() {
        String[] subtasks = {"Мясо", "Сыр", "Молоко"};
        Epic epic = new Epic(22, subtasks);

        boolean actual = epic.matches("Кефир");

        Assertions.assertFalse(actual);
    }

    @Test
    public void shouldFindMatchesInMeetingTopic() {
        Meeting meeting = new Meeting(
                123,
                "Встреча с руководством",
                "Новая волна",
                "В 11 утра в среду");

        boolean actual = meeting.matches("Встреча");

        Assertions.assertTrue(actual);
    }

    @Test
    public void shouldFindMatchesInMeetingProject() {
        Meeting meeting = new Meeting(
                123,
                "Встреча с руководством",
                "Новая волна",
                "В 11 утра в среду");

        boolean actual = meeting.matches("волна");

        Assertions.assertTrue(actual);
    }

    @Test
    public void shouldNotFindMatchesInMeeting() {
        Meeting meeting = new Meeting(
                123,
                "Встреча с руководством",
                "Новая волна",
                "В 11 утра в среду");

        boolean actual = meeting.matches("Совещание");

        Assertions.assertFalse(actual);
    }
}