package mx.tc.j2se.tasks;

public class TaskImpl implements Task {
    private String title;
    private boolean active,repetitive;
    private int time,start,end,interval;

    /**
     * Empty Constructor
     */
    public TaskImpl(){
    }

    /**
     * Constructor for non-repetitive task
     * @param title Define the name of the task
     * @param time  Define the time of the task as an integer
     */
    public TaskImpl(String title,int time){
        this.title=title;
        this.time=time;
    }

    /**
     * Constructor for repetitive task
     * @param title Define the name of the task
     * @param start initialize the variable start of when the task begin
     * @param end Define the end of the task
     * @param interval An integer that shows the interval of when is going to be the next time of the task
     */
    public TaskImpl(String title,int start, int end, int interval){
        this.title=title;
        this.start=start;
        this.end=end;
        this.interval=interval;
    }

    /**
     * Method that returns the title of the task
     * @return the name of the task
     */
    @Override
    public String getTitle() {
        return title;
    }

    /**
     * Method that set the proprieties of title
     * @param title set the name of the task
     */
    @Override
    public void setTitle(String title) {
        this.title=title;
    }

    /**
     * Method where returns a boolean to determinate if the task is active or not
     * @return boolean with true if the task is active or false if is inactive
     */
    @Override
    public boolean isActive() {
        return active;
    }

    /**
     * Method that set the properties of the active task
     * @param active boolean to set the task active or inactive
     */
    @Override
    public void setActive(boolean active) {
        this.active=active;
    }

    /**
     * Method that return the start time if the task is repeated or just the time for non-repetitive
     * @return the start time or the time, depending on if the task is repeated
     */
    @Override
    public int getTime() {
        if (isRepeated()){
            return start;
        }else {
            return time;
        }

    }

    /**
     * Method where set the time if the task is non-repetitive, but if is repeated it makes it non-repetitive
     * @param time set the time of the task
     */
    @Override
    public void setTime(int time) {
        if (isRepeated()){
            repetitive=false;
        }
        this.time=time;
    }

    /**
     * Method where get the start time for repetitive task, but it changes if is non-repetitive
     * @return start time or the time of the task
     */
    @Override
    public int getStartTime() {
        if(isRepeated()){
            return start;
        }else {
            return time;
        }
    }

    /**
     * Method where get the end time for repetitive task, but it returns time if is non-repetitive
     * @return end time or the time of the task
     */
    @Override
    public int getEndTime() {
        if(isRepeated()){
            return end;
        }else {
            return time;
        }
    }

    /**
     * Method that get the interval of the task or if is non-repetitive returns 0
     * @return return the interval or 0
     */
    @Override
    public int getRepeatInterval() {
        if(isRepeated()){
            return interval;
        }else{
            return 0;
        }
    }

    /**
     * Method that set the start,end and interval from non-repetitive to  repetitive task
     * @param start the time when  begin the task
     * @param end the time when the task ends
     * @param interval  An integer that shows the interval of when is going to be the next time of the task
     */
    @Override
    public void setTime(int start, int end, int interval) {
        if (!isRepeated()){
            repetitive=true;
        }
        this.start=start;
        this.end=end;
        this.interval=interval;
    }

    /**
     * Method that return a boolean to know if a task is repetitive or not
     * @return boolean with true if is repetitive task or false if is non-repetitive
     */
    @Override
    public boolean isRepeated() {
        return repetitive;
    }

    /**
     * Method that return the next time of the task
     * @param current the current time when you check your task
     * @return the time of the next task or -1 if the task has already finished.
     */
    @Override
    public int nextTimeAfter(int current) {
        if(isActive()) {
            if (isRepeated()) {
                int result=start;
                while(result<end){
                if (current<result) {
                    return result;
                    }
                    result=result+interval;
                }
            } else {
                if (current < time) {
                    return time;
                }
            }
        }
        return -1;
    }
}
