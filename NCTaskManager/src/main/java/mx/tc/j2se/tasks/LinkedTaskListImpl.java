package mx.tc.j2se.tasks;

/**
 * No pude terminarla ya que en la plataforma me marca nullpointer, pero no se por que surgia ese error :(
 */
public class LinkedTaskListImpl implements LinkedTaskList{
    private Node head;
    private static int counter;
    public LinkedTaskListImpl(){}
    @Override
    public void add(Task task) {
        if(task==null){
            throw new IllegalArgumentException("Task can't be null");
        }
        Node node = new Node(task);
        if(head == null){
            head= node;
        }else{
            Node currentNode=head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next=node;
        }
        counter++;
    }

    @Override
    public boolean remove(Task task) {
        Node currentNode=head;
        if(task==null){
            throw new IllegalArgumentException("Task can't be null");
        }
        if(head!=null) {
            while (currentNode.task.getTitle() != task.getTitle()) {
                if(currentNode.next==null){
                    return false;
                }
                currentNode=currentNode.next;
            }
            currentNode.next=currentNode.next.next;
            counter--;
            return true;
        }

        return false;
    }

    @Override
    public int size() {
        return counter;
    }

    @Override
    public Task getTask(int index) {
        if(size()-1<index){
            throw new IndexOutOfBoundsException("Index is not a position on the list");
        }
        if(index<0) return null;
        Node currentNode;
        if(head!=null){
            currentNode=head.next;
            for (int i=0;i<index;i++){
                if(currentNode.next==null)
                    return null;
                currentNode=currentNode.next;
            }
            return currentNode.task;
        }
        return null;
    }

    @Override
    public LinkedTaskList incoming(int from, int to) {
        LinkedTaskListImpl auxtask=new LinkedTaskListImpl();
        Node currNode=head;
        if(from>to || to<0 || from<0){
            throw new IllegalArgumentException("to and from can't be negative or from can not more than to");
        }
        while (currNode != null){
            if (currNode.task.isActive()) {
                if (currNode.task.isRepeated()) {
                    if (currNode.task.getStartTime() < to && currNode.task.getEndTime() > from) {
                        auxtask.add(currNode.task);
                    }
                } else {
                    if (currNode.task.getTime() > from && currNode.task.getTime() < to) {
                        auxtask.add(currNode.task);
                    }
                }
            }
            currNode=currNode.next;
        }
        return auxtask;
    }
//cambiar clase
    private static class Node {

        Task task;
        Node next;
        Node(Task task) {
            this.task = task;
            next = null;
        }
        public void setNext(Node nextNode){
            next=nextNode;
        }
    }
}
