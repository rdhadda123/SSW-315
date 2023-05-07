public class LLPriorityQueue<E>{
    private Node<E> head; 
    private Node<E> tail;
    private int size;

    static class Node<E> {
        int data;
        int priority;
        Node<E> prev, next;

        public Node(int data, int priority){
            this.data = data;
            this.priority = priority;
        }
    }
 
    public LLPriorityQueue(Node<E> head, Node<E> tail){
        this.head = head;
        this.tail = tail;
        if (head != null && tail != null){
            enqueue(head);
            enqueue(tail);
            this.size = getSize() + 2;
        }
        else if (head != null && tail == null){
            enqueue(head);
            this.size = getSize() + 1;
        }
    }

    public void enqueue(Node<E> list)
    {
        // If linked list is empty
        if (head == null) {
            head = list;
            tail = list;
            list.next = null;
            size++;
        }
        else {
            // If priority is greater, then insert at head
            if (list.priority >= head.priority) {
                list.next = head;
                head.prev = list.next;
                head = list;
                size++;
            }
 
            // If priority is less, then insert at tail
            else if (list.priority < tail.priority) {
                list.next = null;
                tail.next = list;
                list.prev = tail.next;
                tail = list;
                size++;
            }
 
            else {
                Node<E> start = head.next;
                while (start.priority > list.priority)
                    start = start.next;
                (start.prev).next = list;
                list.next = start.prev;
                list.prev = (start.prev).next;
                start.prev = list.next;
                size++;
            }
        }
    }

    public void dequeue(){
        Node<E> temp = head;
        if (head == null){
            System.out.println("The list is empty");
        }
        else{
            temp = head;
            head = head.next;
            if (head == null)
                tail = null;
            else 
                head.prev = null;
            
            size--;
        }
    }

    public int getSize(){
        return size;
    }

    public Node<E> getHead() {
    	return head;
    }
    
    public Node<E> getTail() {
    	return tail;
    }
}