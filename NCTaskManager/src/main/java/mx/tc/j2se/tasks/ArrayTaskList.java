package mx.tc.j2se.tasks;

/**
 * This class use the Task class to create an Arraylist of tasks
 * @author Adrian Ramos Nieves
 * @version 28/06/2022
 */
public interface ArrayTaskList {
    void add (Task task);
    boolean remove(Task task);
    int size();
    Task getTask(int index);
    ArrayTaskList incoming(int from, int to);
}
