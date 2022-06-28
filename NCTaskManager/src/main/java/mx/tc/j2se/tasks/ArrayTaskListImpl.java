package mx.tc.j2se.tasks;

import java.util.*;

import static java.lang.System.arraycopy;

public class ArrayTaskListImpl implements ArrayTaskList{
    private Task[] arrayTask=new Task[0];

    /**
     * Empty constructor
     */
    public ArrayTaskListImpl(){
    }

    /**
     * The method add to the task's array the next position of the new task, creating a new space on the memory
     * @param task Variable the type Task
     */
    @Override
    public void add(Task task) {
        int n=arrayTask.length;
        arrayTask = Arrays.copyOf(arrayTask, n + 1);
        arrayTask[n]=task;
//        Task[] auxTask=new Task[n+1];
//        arraycopy(arrayTask,0,auxTask,0, auxTask.length);
//        arrayTask=auxTask;
//        arrayTask[n]=task;
    }

    /**
     * Method that look for a task in the class' array and remove it, finally it return a true or false
     * @param task variable of type task
     * @return True or false if the removing was successfully
     */
    @Override
    public boolean remove(Task task) {
        int aux=0;
        Task[]copyTask=new Task[arrayTask.length];
        arraycopy(arrayTask,0,copyTask,0,copyTask.length);
        for(int i=0;i<arrayTask.length;i++){
            Task[] auxTask=new Task[copyTask.length-1];
            if(Objects.equals(arrayTask[i].getTitle(), task.getTitle())){
                aux+=1;
                arraycopy(copyTask,0,auxTask,0,i);
                arraycopy(copyTask,i+1,auxTask,i,copyTask.length-i-1);
                copyTask=auxTask;
            }
        }
        arrayTask=copyTask;
        return aux > 0;
    }

    /**
     * Method that check the size of the array
     * @return an integer with the array's length
     */
    @Override
    public int size() {
        return arrayTask.length;
    }

    /**
     * Method that look for the task with the index parameter, and return the task in that position
     * @param index position of the task to look for
     * @return a specific task
     */
    @Override
    public Task getTask(int index) {
        return arrayTask[index];
    }

    /**
     * Method that make a subset of task, with a range between for and to.
     * @param from  range start
     * @param to    range end
     * @return an object of the class ArrayTaskList
     */
    @Override
    public ArrayTaskList incoming(int from, int to) {
        ArrayTaskListImpl auxArrayTask = new ArrayTaskListImpl();
        for (Task task : arrayTask) {
            if (task.isActive()) {
                if (task.isRepeated()) {
                    if (task.getStartTime() < to && task.getEndTime() > from) {
                        auxArrayTask.add(task);
                    }
                } else {
                    if (task.getTime() > from && task.getTime() < to) {
                        auxArrayTask.add(task);
                    }
                }
            }
        }
        return auxArrayTask;
    }
}
