package mx.tc.j2se.tasks;

public class TaskImpl implements Task {
    private String title;
    private boolean active,repetitive;
    private int time,start,end,interval;
    public TaskImpl(){
    }
    public TaskImpl(String title,int time){
        this.title=title;
        this.time=time;
    }
    public TaskImpl(String title,int start, int end, int interval){
        this.title=title;
        this.start=start;
        this.end=end;
        this.interval=interval;
    }
    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title=title;
    }

    @Override
    public boolean isActive() {
        return active;
    }

    @Override
    public void setActive(boolean active) {
        this.active=active;
    }

    @Override
    public int getTime() {
        if (isRepeated()){
            return start;
        }else {
            return time;
        }

    }

    @Override
    public void setTime(int time) {
        if (isRepeated()){
            repetitive=false;
        }
        this.time=time;
    }

    @Override
    public int getStartTime() {
        if(isRepeated()){
            return start;
        }else {
            return time;
        }
    }

    @Override
    public int getEndTime() {
        if(isRepeated()){
            return end;
        }else {
            return time;
        }
    }

    @Override
    public int getRepeatInterval() {
        if(isRepeated()){
            return interval;
        }else{
            return 0;
        }
    }

    @Override
    public void setTime(int start, int end, int interval) {
        if (!isRepeated()){
            repetitive=true;
        }
        this.start=start;
        this.end=end;
        this.interval=interval;
    }

    @Override
    public boolean isRepeated() {
        return repetitive;
    }

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
