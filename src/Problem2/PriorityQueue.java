package Problem2;

public class PriorityQueue {

    private int sizeOfQueue;
    private int[] queue;

    private int itemCount;

    public PriorityQueue(int size) {
        //passing size and adjusting queue and its size
        this.sizeOfQueue=size;
        this.queue = new  int[this.sizeOfQueue];
        this.itemCount = 0;
    }

    public void insert(int key){
        int i=0;
        for(i=this.itemCount-1; i>=0; i--){
            if(this.queue[itemCount-1]>key){
                this.queue[i+1] = this.queue[i];
            }
        }
        this.queue[i+1] = key;
        this.itemCount++;
    }

    public int remove(){
        return this.queue[--this.itemCount];
    }


}
