package bookcontact;

public class TwoFour {

    NodeTwoFour roott = new NodeTwoFour();// make root node
    QueueTwoFour queueTwoFour ;
    QueueTwoFour queueTwoFourSearch ;
    private int height=0;

    // insert a NodeData
    public void insert(String Name, String Phonenumber, String Address, String EmailAddress) {
        NodeTwoFour curNode = roott;
        NodeData tempItem = new NodeData(Name, Phonenumber, Address, EmailAddress);

        while (true) {
            if (curNode.isFull()) // if node full,
            {
                split(curNode); // split it
                curNode = curNode.getParent(); // back up
                // search once
                curNode = getNextChild(curNode, tempItem.data);
            } // end if(node is full)
            else if (curNode.isLeaf()) // if node is leaf,
            {
                break; // go insert
            } // node is not full, not a leaf; so go to lower level
            else {
                curNode = getNextChild(curNode, tempItem.data);
            }
        } // end while

        curNode.insertItem(tempItem); // insert new NodeData
    } // end insert()

    public void split(NodeTwoFour thisNode) // split the node
    {
        // assumes node is full
        NodeData itemB, itemC;

        NodeTwoFour parent;
        NodeTwoFour child2, child3;
        int itemIndex;

        itemC = thisNode.removeItem(); // remove items from
        itemB = thisNode.removeItem(); // this node
        child2 = thisNode.disconnectChild(2); // remove children
        child3 = thisNode.disconnectChild(3); // from this node

        NodeTwoFour newRight = new NodeTwoFour(); // make new node

        if (thisNode == roott) // if this is the root,
        {
            roott = new NodeTwoFour(); // make new root
            parent = roott; // root is our parent
            roott.connectChild(0, thisNode); // connect to parent
        } else // this node not the root
        {
            parent = thisNode.getParent(); // get parent
        }
        // deal with parent
        itemIndex = parent.insertItem(itemB); // item B to parent
        int n = parent.getNumItems(); // total items?

        for (int j = n - 1; j > itemIndex; j--) // move parent's        when we enter value betwenn or smaller than th values that already exist
        { // connections
            NodeTwoFour temp = parent.disconnectChild(j); // one child
            parent.connectChild(j + 1, temp); // to the right
        }
        // connect newRight to parent
        parent.connectChild(itemIndex + 1, newRight);

        // deal with newRight
        newRight.insertItem(itemC); // item C to newRight
        newRight.connectChild(0, child2); // connect to 0 and 1
        newRight.connectChild(1, child3); // on newRight
    } // end split()

    // gets appropriate child of node during search for value
    public NodeTwoFour getNextChild(NodeTwoFour theNode, String theValue) {

        // Should be able to do this w/o a loop, since we should know
        // index of correct child already
        int j;
        // assumes node is not empty, not full, not a leaf
        int numItems = theNode.getNumItems();
        for (j = 0; j < numItems; j++) // for each item in node
        { // are we less?
            if (theValue.compareTo(theNode.getItem(j).data) < 0) {
                return theNode.getChild(j); // return left child
            }
        } // end for // we're greater, so
       
        return theNode.getChild(j); // return right child
    }
    
    
    public QueueTwoFour getNewQueue(){
        queueTwoFour =  new QueueTwoFour() ; 
        getNewQueueValue(roott, 0, 0);
        return  queueTwoFour ;
    } 
    
    
        private void getNewQueueValue(NodeTwoFour thisNode, int level, int childNumber) {

        for (int i = 0; i < thisNode.getNumItems() ; i++) {
            queueTwoFour.enqueue(thisNode.getItem(i));
        }
        // call ourselves for each child of this node
        int numItems = thisNode.getNumItems();
        for (int j = 0; j < numItems + 1; j++) {
            NodeTwoFour nextNode = thisNode.getChild(j);
            if (nextNode != null) {
                getNewQueueValue(nextNode, level + 1, j);
            } else {
                return;
            }

        }
    }

    public QueueTwoFour SearchByFirst(String value){
        queueTwoFourSearch =  new QueueTwoFour() ; 
        serachByFirst(roott, value);
        return  queueTwoFourSearch ;
    } 
        
        
        
     private void serachByFirst(NodeTwoFour thisNode , String value) {
         
        for (int i = 0; i < thisNode.getNumItems() ; i++) {
            if (thisNode.getItem(i).getFirstName().contentEquals(value)) {
                queueTwoFourSearch.enqueue(thisNode.getItem(i));
            }
        }
        // call ourselves for each child of this node
        int numItems = thisNode.getNumItems();
        for (int j = 0; j < numItems + 1; j++) {
            NodeTwoFour nextNode = thisNode.getChild(j);
            if (nextNode != null) {
                serachByFirst(nextNode ,value);
            } else {
                return;
            }

        }
    }      
     
     
     
   public QueueTwoFour SearchByLast(String value){
        queueTwoFourSearch =  new QueueTwoFour() ; 
         serachByLast(roott, value);
        return  queueTwoFourSearch ;
    } 
        
        
        
     private void serachByLast(NodeTwoFour thisNode , String value) {
         
        for (int i = 0; i < thisNode.getNumItems() ; i++) {
            
            if (thisNode.getItem(i).getLastName().contentEquals(value)) {
                
                queueTwoFourSearch.enqueue(thisNode.getItem(i));
            }
        }
        // call ourselves for each child of this node
        int numItems = thisNode.getNumItems();
        for (int j = 0; j < numItems + 1; j++) {
            NodeTwoFour nextNode = thisNode.getChild(j);
            if (nextNode != null) {
                serachByLast(nextNode ,value);
            } else {
                return;
            }

        }
    }
     
     
     
      
     
   public QueueTwoFour SearchByPart(String value){
        queueTwoFourSearch =  new QueueTwoFour() ; 
         serachByPart(roott, value);
        return  queueTwoFourSearch ;
    } 
        
        
        
     private void serachByPart(NodeTwoFour thisNode , String value) {
         
        for (int i = 0; i < thisNode.getNumItems() ; i++) {
            if ( thisNode.getItem(i).getName().contains(value) ) {
                queueTwoFourSearch.enqueue(thisNode.getItem(i));
            }
        }
        // call ourselves for each child of this node
        int numItems = thisNode.getNumItems();
        for (int j = 0; j < numItems + 1; j++) {
            NodeTwoFour nextNode = thisNode.getChild(j);
            if (nextNode != null) {
                serachByPart(nextNode ,value);
            } else {
                return;
            }

        }
    }        
     
     
        
        
        
    

    public void displayTree(int i) {
        if (i == 0) {
            recDisplayTree(roott, 0, 0);
        } else {
            inorderdisplay(roott, 0, 0);
        }
        System.out.println();
    }

    private void recDisplayTree(NodeTwoFour thisNode, int level, int childNumber) {
        System.out.println("level=" + level + " child=" + childNumber + " ");
        thisNode.displayNode(); // display this node
        System.out.println();
        // call ourselves for each child of this node
        int numItems = thisNode.getNumItems();
        for (int j = 0; j < numItems + 1; j++) {
            NodeTwoFour nextNode = thisNode.getChild(j);
            if (nextNode != null) {
                recDisplayTree(nextNode, level + 1, j);
            } else {
                return;
            }
        }
    } // end recDisplayTree()

    public void inorderdisplay(NodeTwoFour thisNode, int level, int childNumber) {
        int numItems = thisNode.getNumItems();
        for (int j = 0; j < numItems + 1; j++) {
            NodeTwoFour nextNode = thisNode.getChild(j);
            if (nextNode != null) {
                inorderdisplay(nextNode, level + 1, j);
            } else {
                thisNode.displayNode();
                return;
            }
            if (j < thisNode.getNumItems()) {
                thisNode.displayvalue(j);
            }
        }
    }

    public NodeData findData(String value) {
        NodeTwoFour nodeTwoFour = find(value);

        for (int i = 0; i < nodeTwoFour.getNumItems(); i++) {
            if (nodeTwoFour.getItem(i).data.contentEquals(value)) {
                return nodeTwoFour.getItem(i);
            }
        }

        return null;
    }

    public NodeTwoFour find(String theValue) {

        return (findvalue(roott, theValue));
    }

    private NodeTwoFour findvalue(NodeTwoFour theNode, String theValue) {

// Should be able to do this w/o a loop, since we should know
        // index of correct child already
        NodeTwoFour l = null;
        // assumes node is not empty, not full, not a leaf
        int numItems = theNode.getNumItems();
        // System.out.println(numItems+"-------"+theNode.getItem(0).dData);
        for (int j = 0; j < numItems; j++) // for each item in node
        { // are we less?
            // System.out.println(theNode.getItem(j).dData);
            if (theValue.compareTo(theNode.getItem(j).data) == 0) {
                l = theNode;

                break;
            } else if ((theValue.compareTo(theNode.getItem(j).data) < 0 && !theNode.isLeaf())) {
                l = findvalue(theNode.getChild(j), theValue); // return left
                // child
                break;
            } else if ((theValue.compareTo(theNode.getItem(j).data) > 0 && !theNode.isLeaf())) {
                l = findvalue(theNode.getChild(j + 1), theValue); // return
                // right
                // child

            }
        }
        return l;
    }

    public NodeTwoFour delete(NodeTwoFour currnode, String theValue) {
        NodeTwoFour y = null;

        if (currnode.isLeaf()) {
            if (currnode.getNumItems() > 1) {
                currnode.deleteNodeItem(theValue);
                return currnode;
            } else {
                y = deleteLeafCases(currnode, theValue);
                return y;
            }
        } else {
            // delete interior nodes
            //boolean x = false;

            NodeTwoFour n = getNextChild(currnode, theValue);
            NodeTwoFour c = getinordernode(n);
            NodeData d = c.getItem(0);
            String k = d.data;
            delete(c, d.data);

            NodeTwoFour found = find(theValue);
            for (int i = 0; i < found.getNumItems(); i++) {
                if (found.getItem(i).data.compareTo(theValue) == 0) {
                    found.getItem(i).data = k;
                }
            }
            return found;

        }
    }

    public NodeTwoFour deleteLeafCases(NodeTwoFour thisNode, String theValue) {
        String sibling_side = "l";
        NodeTwoFour p = thisNode.getParent();
        NodeTwoFour sibling = thisNode.getsibiling(theValue);
        if (sibling == null) {
            sibling_side = "r";
            sibling = p.getChild(1);
        }

        if (sibling.getNumItems() == 1) {
            for (int i = 0; i <= p.getNumItems(); i++) {
                if (p.getChild(i) == sibling && sibling_side == "l") {

//     System.out.println("Sibling is on left side & Data is "
//       + sibling.getItem(0).dData);
                    thisNode.setItem(thisNode.getNumItems() - 1, null);
                    thisNode.setNumItems(thisNode.getNumItems() - 1);
                    NodeData d = p.getItem(i);
                    sibling.insertItem(d);
                    p.disconnectChild(i + 1);
                    for (int j = i; j < p.getNumItems(); j++) {
                        if (j + 1 < p.getNumItems()) {
                            p.setItem(j, p.getItem(j + 1));
                            if (j + 2 <= p.getNumItems()) {
                                p.connectChild(j + 1, p.disconnectChild(j + 2));
                            }
                        }
                    }
                    p.setItem(p.getNumItems() - 1, null);
                    p.setNumItems(p.getNumItems() - 1);

                    // Check if parent is null
                    if (p.getNumItems() == 0) {
//      System.out
//        .println("Parent became null; Now Tree is Re-Balancing");
                        if (p != roott) {
                            p = balancetree(p);
                        } else {
                            roott = sibling;
                        }
                    }

                    return p;

                } else if (p.getChild(i) == sibling && sibling_side == "r") {

//     System.out.println("Sibling is on right side & Data is "
//       + sibling.getItem(0).dData);
                    thisNode.setItem(thisNode.getNumItems() - 1, null);
                    thisNode.setNumItems(thisNode.getNumItems() - 1);
                    NodeData d = p.getItem(i - 1);
                    sibling.insertItem(d);
                    p.disconnectChild(0);
                    p.connectChild(0, p.disconnectChild(1));

                    for (int j = i; j < p.getNumItems(); j++) {
                        p.setItem(j - 1, p.getItem(j));
                        if (j + 1 <= p.getNumItems()) {
                            p.connectChild(j, p.disconnectChild(j + 1));
                        }
                    }
                    p.setItem(p.getNumItems() - 1, null);
                    p.setNumItems(p.getNumItems() - 1);

                    // Check if parent is null
                    if (p.getNumItems() == 0) {
//      System.out
//        .println("Parent became null; Now Tree is Re-Balancing");
                        if (p != roott) {
                            p = balancetree(p);
                        } else {
                            roott = sibling;
                        }
                    }
                    return p;

                }
            }
        } else if (sibling.getNumItems() > 1) {
            int f = 0;
            if (sibling_side == "r") {
                f = 0;
            } else {
                f = sibling.getNumItems() - 1;
            }

            for (int i = 0; i <= p.getNumItems(); i++) {
                if (p.getChild(i) == sibling && sibling_side == "l") {
                    thisNode.getItem(0).data = p.getItem(i).data;
                    p.getItem(i).data = sibling.getItem(f).data;
                    sibling.deleteNodeItem(sibling.getItem(f).data);
                    return p;
                }

                if (p.getChild(i) == sibling && sibling_side == "r") {
                    thisNode.getItem(0).data = p.getItem(i - 1).data;
                    p.getItem(i - 1).data = sibling.getItem(f).data;
                    sibling.deleteNodeItem(sibling.getItem(f).data);
                    return p;
                }
            }
        }

        return null;
    }

    public NodeTwoFour balancetree(NodeTwoFour currnode) { // Argument is empty node.
        String sibling_side = "l";
        NodeTwoFour p = currnode.getParent();
        NodeTwoFour sibling = currnode.getsibiling("z");
        if (sibling == null) {
            sibling_side = "r";
            sibling = p.getChild(1);
        }

        if (sibling.getNumItems() == 1) {
            for (int i = 0; i <= p.getNumItems(); i++) {
                if (p.getChild(i) == sibling && sibling_side == "l") {
                    // merge parent and child and remove parent

//     System.out.println("Sibling is on left side & Data is "
//       + sibling.getItem(0).dData);
                    NodeData d = p.getItem(i);
                    sibling.insertItem(d);
                    // p.connectChild(i, newnode);
                    sibling.connectChild(sibling.getNumItems(),
                            currnode.disconnectChild(0));
                    p.disconnectChild(i + 1);
                    for (int j = i; j < p.getNumItems(); j++) {
                        if (j + 1 < p.getNumItems()) {
                            p.setItem(j, p.getItem(j + 1));
                            if (j + 2 <= p.getNumItems()) {
                                p.connectChild(j + 1, p.disconnectChild(j + 2));
                            }
                        }
                    }
                    p.setItem(p.getNumItems() - 1, null);
                    p.setNumItems(p.getNumItems() - 1);

                    // Check if parent is null
                    if (p.getNumItems() == 0) {
//      System.out
//        .println("Parent became null; Now Tree is Re-Balancing");
                        if (p != roott) {
                            p = balancetree(p);
                        } else {
                            roott = sibling;
                        }
                    }
                    return p;
                } else if (p.getChild(i) == sibling && sibling_side == "r") {

//     System.out.println("Sibling is on right side & Data is "
//       + sibling.getItem(0).dData);
                    NodeData d = p.getItem(i - 1);
                    sibling.insertFront(d);
                    sibling.connectChild(0, currnode.disconnectChild(0));
                    p.disconnectChild(0);
                    p.connectChild(0, p.disconnectChild(1));

                    for (int j = i; j < p.getNumItems(); j++) {
                        p.setItem(j - 1, p.getItem(j));
                        if (j + 1 <= p.getNumItems()) {
                            p.connectChild(j, p.disconnectChild(j + 1));
                        }
                    }
                    p.setItem(p.getNumItems() - 1, null);
                    p.setNumItems(p.getNumItems() - 1);

                    // Check if parent is null
                    if (p.getNumItems() == 0) {
//      System.out
//        .println("Parent became null; Now Tree is Re-Balancing");
                        if (p != roott) {
                            p = balancetree(p);
                        } else {
                            roott = sibling;
                        }
                    }
                    return p;
                }

            }

        } else if (sibling.getNumItems() > 1) {
            int f = 0;
            if (sibling_side == "r") {
                f = 0;
            } else {
                f = sibling.getNumItems() - 1;
            }
            for (int i = 0; i <= p.getNumItems(); i++) {
                if (p.getChild(i) == sibling && sibling_side == "l") {

//     System.out.println("Sibling is on left side & Data is "
//       + sibling.getItem(sibling.getNumItems() - 1).dData);
                    currnode.setNumItems(currnode.getNumItems() + 1);
                    currnode.connectChild(1, currnode.disconnectChild(0));
                    currnode.connectChild(0,
                            sibling.disconnectChild(sibling.getNumItems()));
                    currnode.setItem(0, p.getItem(i));
//     currnode.getItem(0).dData = p.getItem(i).dData;
                    p.setItem(i, sibling.getItem(f));
//     p.getItem(i).dData = sibling.getItem(f).dData;
                    sibling.setItem(sibling.getNumItems() - 1, null);
                    sibling.setNumItems(sibling.getNumItems() - 1);
                    return p;
                }

                if (p.getChild(i) == sibling && sibling_side == "r") {

//     System.out
//       .println("Sibling is on right side & Data is ---- "
//         + sibling.getItem(0).dData);
                    currnode.setNumItems(currnode.getNumItems() + 1);
                    currnode.setItem(0, p.getItem(i - 1));
//     System.out.println("Current node value: "
//       + currnode.getItem(0).dData);
//     System.out.println("Sibling going to parent: "
//       + sibling.getItem(f).dData);
                    p.setItem(i - 1, sibling.getItem(f));
//     System.out.println("Parent Changed to: "
//       + p.getItem(i - 1).dData);

                    currnode.connectChild(1, sibling.disconnectChild(f));
//     System.out.println("Current node right child value"
//       + currnode.getChild(1).getItem(0).dData);

                    for (int j = 0; j < sibling.getNumItems(); j++) {
                        if (j + 1 < sibling.getNumItems()) {
                            sibling.setItem(j, sibling.getItem(j + 1));
                        }
                        sibling.connectChild(j, sibling.disconnectChild(j + 1));
                    }
//     System.out.println("Sibling first value"
//       + sibling.getItem(0).dData);
                    sibling.setItem(sibling.getNumItems() - 1, null);
                    sibling.setNumItems(sibling.getNumItems() - 1);
                    //System.out.println(currnode.getItem(0).dData);
                    return p;
                }
            }
        }
        return null;
    }

    public NodeTwoFour getinordernode(NodeTwoFour thisNode) {
        NodeTwoFour c = null;
        if (thisNode.isLeaf()) {
            c = thisNode;
        } else {
            c = getinordernode(thisNode.getChild(0));
        }
        return c;
    }
    
    
    
    public int HeightTree(int i) {
        
            HeightTree(roott, 0, 0);
            return height;
         
    }

    private void HeightTree(NodeTwoFour thisNode, int level, int childNumber) {
        
        
        int numItems = thisNode.getNumItems();
        for (int j = 0; j < numItems + 1; j++) {
            NodeTwoFour nextNode = thisNode.getChild(j);
            if (nextNode != null) {
                HeightTree(nextNode, level + 1, j);
                 if(height==0||height-1<level){
                height=level+1;
                }
            } else {
                return;
            }
        }
        
    }
    

}