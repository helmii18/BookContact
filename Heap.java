
package bookcontact;

public abstract class Heap implements IHeap{

 Node[] heaps ;
 int position  =  -1; 
 int numberOfNodes ; 

 
 public Heap (){
     heaps =  new Node[2] ; 
 }
  
 public int getPos(){
     return position  ; 
 }
 
 public Node getNode(int index){
     return heaps[index] ; 
 }

    @Override
    public void insert(String name, String phone, String email, String adress) {
        if (isFull()) {
            resize(2 * heaps.length);
        }
        boolean isThere = false;
        Node node = new Node(name, phone, email, adress);
        for (int i = 0; i <= position; i++) {
            if (node.getData().contentEquals(heaps[i].getData())) {
                isThere = true;
                break;
            }

        }

        if (isThere) {
            System.out.println("there is contact already with this name");
        } else {
            heaps[++position] = node;
            
            fixUpward();
            numberOfNodes++ ;
            System.out.println("contact is added successfully");
        }

    }

    @Override
    public void insertAll(String name, String phone, String email, String adress) {
   if (isFull()) {
         resize(2* heaps.length);
     }
     boolean isThere = false ; 
     Node node = new Node(name, phone, email, adress) ; 
     for (int i = 0; i <= position; i++) {
       if( node.getData().contentEquals(heaps[i].getData()) ) {
           isThere = true ; 
           break;
       }
       
     }
    
     if (isThere) {
         System.out.println("there is contact already with this name");
     }else{
      heaps[++position] = node  ; 
    numberOfNodes++ ;
 
     fixUpward();

     }
  

    }

    @Override
    public void delete(String name) {
        for (int i = 0; i <= position; i++) {
            if (heaps[i].getData().contentEquals(name)) {
                for (int j = i; j < position; j++) {
                heaps[j] = heaps[j+1] ;
                
                }
                position-- ;
                numberOfNodes-- ;

                System.out.println("contact deleted successfully");
                return;
            }
        
        }
        
        System.out.println("there is no contact with this name\n");


    }
    
    
 
 
 
    
 private boolean isFull(){
     return position == (heaps.length-1)  ; 
 }
 
 protected boolean isEmpty(){
     return heaps.length == 0; 
 }
 
 private void resize (int capcity){
     System.arraycopy(heaps, 0,  heaps =  new Node[capcity] , 0, position+1)   ;
 }
 
 
 protected abstract void fixUpward() ; 
 
  protected abstract void fixDownward(int endIndex); 
 
 protected void swap (int firstIndex , int seconedIndex){
     Node temp = heaps[firstIndex] ; 
     heaps[firstIndex] = heaps[seconedIndex] ; 
     heaps[seconedIndex] = temp ; 
     
     
 }

    @Override
    public Node getRoot() {
        if (isEmpty()) {
            return null ; 
        }else{
            return heaps[0] ; 
        }
     
    }
    
    
    public void print(){
        
        sort();
        for (int i = 0; i <= position; i++ ) {
                System.out.println("first name : " + heaps[i].getFirstName()
                        +" , last name : "+heaps[i].getLastName()
                        +" , email : "+heaps[i].getEmail()
                        +" , phone : "+heaps[i].getPhone()
                        +" , adress : "+heaps[i].getAddress()
                );
        
        System.out.println("**********************************");
    }
    
    }

    
}