package mx.tc.j2se.tasks;

/**
 * This class create a simple task with some properties
 * @author Adrian Ramos Nieves
 * @version 21/06/2022
 */
public interface Task {

    String getTitle();

    void setTitle(String title);

    boolean isActive();

    void setActive(boolean active);

    int getTime();

    void setTime(int time);

    int getStartTime();

    int getEndTime();

    int getRepeatInterval();

    void setTime(int start, int end, int interval);

    boolean isRepeated();

    int nextTimeAfter (int current);
}
