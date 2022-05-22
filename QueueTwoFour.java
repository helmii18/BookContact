package bookcontact;

public class QueueTwoFour {
    
   private int max = 10000;
   private  int rear;
   private int front;
   private int size;
   private NodeData Array[];

    public QueueTwoFour() {
        this.rear = -1;
        this.front = -1;
        this.size = this.max;
        this.Array = new NodeData[this.size];

    }

    public QueueTwoFour(int size) {
        this.rear = -1;
        this.front = -1;

        if (size > this.max) {
            System.out.println("the size can not be more than 10 \nset default size 10");
            this.size = this.max;
            this.Array = new NodeData[this.size];
        } else {

            this.size = size;
            this.Array = new NodeData[this.size];
        }

    }

    public boolean isEmpty() {
        if (this.front == -1) {
            return true;
        } else {
            return false;
        }
    }
    
    public NodeData getNode(int index){
        
        
       return  Array[index] ; 
    }

    public boolean isFull() {
        if (this.front == 0 && this.rear == (this.size - 1)) {
            return true;
        }
        return false;

    }

    public void enqueue(NodeData element) {
        if (isFull()) {
            System.out.println("the queue is full");
        } else {

            if (this.front == -1) {
                this.front = 0;
            }
            this.rear = (this.rear + 1) ;
            Array[this.rear] = element;
            
        }

    }
    

 

    public NodeData dequeue() {
        NodeData element;
        if (isEmpty()) {
            System.out.println("queue is empty ");
            return null;
        } else {
            element = this.Array[this.front];
            
            if (this.front == this.rear) {
                this.front = -1;
                this.rear = -1;
            } else {
                this.front = (this.front + 1);
            }
            return element;

        }
    }

 

    public void display() {
        int i;
        if (isEmpty()) {
            System.out.println("No result !!!");
        } else {
            for (i = this.front; i <= this.rear; i++ ) {
                System.out.println("first name : " + this.Array[i].getFirstName()
                        +" , last name : "+this.Array[i].getLastName()
                        +" , email : "+this.Array[i].getEmail()
                        +" , phone : "+this.Array[i].getPhone()
                        +" , adress : "+this.Array[i].getAddress()
                );
            }
          
        }

        System.out.println("******************************************");
    }
    
    
    public Object returnRear(){
        if(isEmpty()){
            return  null ;
        }else{
        return this.Array[this.rear] ;     
        }
    }
    
    
      
    public Object returnFront(){
        if(isEmpty()){
            return  null ;
        }else{
        return this.Array[this.front] ;     
        }
    }
    


 public int getRear(){
        return this.rear ; 
    }
 
 public int getFront(){
        return this.front ; 
    }
 
 
 
}
 