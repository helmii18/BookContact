package bookcontact;

public class MinHeap extends Heap{

    @Override
    protected void fixUpward() {
        int index = position;
        int parentIndex = (index - 1) / 2;

        while (parentIndex >= 0 && heaps[index].getData().compareTo(heaps[parentIndex].getData()) < 0) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }

    }

  
        @Override
    public boolean isSorted(){
        boolean flage = false ;
        for (int i = 0; i < position; i++) {
            if (heaps[i].getData().compareTo(heaps[i+1].getData()) > 0) {
                flage = true ; 
            }else{
                flage = false ; 
            }
            
        }
        return flage ; 
    }
    
    
  @Override
    public void sort() {
        if (isSorted()) {
          
      }else{
           for (int i = 0; i <= position; i++) {
            swap(0, position - i );
            fixDownward(position - i - 1);
        } 
        }
        
        
    }
    
    
    @Override
    public Node deleteRoot() {
     if (isEmpty()) {
            return null;
        }
        Node result = heaps[0];
        heaps[0] = heaps[position--];
        heaps[position + 1] = null;
        fixDownward(position);
        return result;
    }

    @Override
    protected void fixDownward(int endIndex) {
 if (endIndex == -1) return;
        int index = 0;
        while (index <= endIndex) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            if (leftChildIndex > endIndex) break;

            int childToSwap = rightChildIndex > endIndex
                    ? leftChildIndex
                    : heaps[leftChildIndex].getData().compareTo(heaps[rightChildIndex].getData()) < 0
                        ? leftChildIndex
                        : rightChildIndex;

            if (heaps[index].getData().compareTo(heaps[childToSwap].getData()) < 0) break;
            swap(index, childToSwap);
            index = childToSwap;
        }

    }

   @Override
    public Queue searchByKey(String data) {
        Queue q =  new Queue(); 
        sort();
        for (int i = 0; i <= position; i++) {
            

            if (heaps[i].getData().contains(data) ) {
               q.enqueue(heaps[i]); 
            }
            
            if (heaps[i].getData().compareTo(data) < 0) {
                break;
            }
   
        
        }
        
        return q ; 

    }

    @Override
    public Queue searchByFirst(String data) {
     Queue q=  new Queue(); 
    sort();
        for (int i = 0; i <= position; i++) {
          if (heaps[i].getData().split(" ")[0].contentEquals(data) ) {
                q.enqueue(heaps[i]);
            }  
            
            
        }
        
        return q ; 
    
    }

    @Override
    public Queue searchByLast(String data) {
    Queue q=  new Queue(); 
    sort();
        for (int i = 0; i <= position; i++) {
          if (heaps[i].getData().split(" ")[1].contentEquals(data) ) {
                q.enqueue(heaps[i]);
            }  
            
            
        }
        
        return q ; 
    
    }

    @Override
    public Queue searchByPart(String data) {
     Queue q=  new Queue(); 
    sort();
        for (int i = 0; i <= position; i++) {
          if (heaps[i].getData().contains(data) ) {
                q.enqueue(heaps[i]);
            }  
            
            
        }
        
        return q ; 
    
    
    }
    
    
        @Override
    public Queue getNewQueue() {
      Queue q =  new Queue(); 
        Node node ; 
        for (int i = 0; i <= position; i++) {
            node = heaps[i] ; 
            q.enqueue(node);
            
        }

        return q ; 
    }

    
    
    
    
}