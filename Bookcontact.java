package bookcontact;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Bookcontact {
    
   static CodeTimer codeTimer =  new CodeTimer(); 
    
    //var for the while loop

    static Scanner s = new Scanner(System.in);
    static boolean flage = true;
    static int menu;

    //var for case 1 (cvs upload_
    static String line = "";
    static String splitBy = ",";
    static String dir;
    static Queue q = new Queue() ;
    static Node node;

    //var for case 2 (avl tree)
    static AVL avl = new AVL();
    static int case2Menu;
    static boolean flageCase2 = true;
    //var add
    static String fname, lname, name, phone, email, address;
    static Node nodeToAdd;
    //var search 
    static boolean flageCase2Search = true;
    static int case2MenuSearch;
    //*************************************************************************************8

    //var for case 3 (heap)
    static Heap heap;
    static boolean flagecase3 = true;
    static int case3Menu;
    //var for max
    static int case3MaxMenu;
    static boolean flageCase3Max = true;
    //var for max search 
    static int case3MaxSearchMenu;
    static boolean flageCase3MaxSearch = true;

    //var for min
    static int case3MinMenu;
    static boolean flageCase3Min = true;
    //var for max search 
    static int case3MinSearchMenu;
    static boolean flageCase3MinSearch = true;
    
    
    
    static QueueTwoFour queueTwoFour = new QueueTwoFour() ; 
    static NodeData nodeDataToAdd  ; 
    static TwoFour twoFour = new TwoFour() ; 
    static boolean flageCase4 ;
    static int case4Menu ;
    static boolean flageCase4Search = true;
    static int case4MenuSearch;
    
    
    
    

    public static void main(String[] args) {

        while (flage) {

            System.out.println(
                    "****Main Menu****"
                    + "\nEnter 1 to upload the cvs contact file "
                    + "\nEnter 2 to use AVL tree "
                    + "\nEnter 3 to use heap tree"
                    + "\nEnter 4 to use 2-4 tree"        
                    + "\nEnter 5 to save"
                    + "\nEnter 6 to exit"
                    + "\n########################### ");

            try {

                menu = s.nextInt();
                s.nextLine();
            } catch (Exception e) {
                s.nextLine();
                System.out.println("Enter a number !!!!!");
                continue;
            }

            switch (menu) {
                case 1:
                    codeTimer.Start();
                    case1();
                    codeTimer.Stop();
                    break;

                case 2:
                    if (q.isEmpty()) {
                        System.out.println("Enter cvs file first !!!\n ");
                        break;
                    }
                    case2();
                    break;

                case 3:
                    if (q.isEmpty()) {
                        System.out.println("Enter cvs file first !!!\n ");
                        break;
                    }
                    case3();

                    break;
                    
                case 4 : 
                    if (q.isEmpty()) {
                        System.out.println("Enter cvs file first !!!\n ");
                        break;
                    }
                    case4() ; 
                    
                    break;

                case 5:
                    save();
                    break;

                case 6:
                    System.out.println("may you liked our project !! ");
                    flage = false;
                    break;
                default:
                    System.out.println("Wrong number ");

            }

        }
       
    }

    public static void case1() {
        q= new Queue() ; 
        
        System.out.println("Enter the name of the file ");
        dir = s.nextLine();

        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Kimo Store\\Downloads\\" + dir + ".cvs"));
            while ((line = br.readLine()) != null) {

                String[] arr = line.toLowerCase().split(splitBy);

                node = new Node(arr[0], arr[1], arr[2], arr[3]);
                nodeDataToAdd =  new NodeData(arr[0], arr[1], arr[2], arr[3]) ; 

                q.enqueue(node);
                queueTwoFour.enqueue(nodeDataToAdd);
            }
        } catch (IOException e) {
            System.out.println("there is no file with this name  !!!!!\n");
        }
    }

    public static void case2() {

        for (int i = q.getFront(); i <= q.getRear(); i++) {

            Node node = q.getNode(i);
            avl.insertAll(node.getName(), node.getPhone(), node.getEmail(), node.getAddress());

        }

       
        flageCase2 = true;
        while (flageCase2) {

            System.out.println(
                    "****AVL Menu****"
                    + "\nEnter 1 to add contact"
                    + "\nEnter 2 to delete "
                    + "\nEnter 3 to search"
                    + "\nEnter 4 to display  "
                    + "\nEnter 5 to show tree info"        
                    + "\nEnter 6 to back"
                    + "\n########################### ");
            try {
                case2Menu = s.nextInt();
                s.nextLine();
            } catch (Exception e) {
                s.nextLine();
                System.out.println("Enter a number !!!!!");
                continue;
            }

            switch (case2Menu) {
                case 1:
                    
                    case2Add();
                    
                    break;
                case 2:
                    case2Delete();
                    break;
                case 3:
                    case2Search();
                    break;
                case 4:
                  case2Display()  ;
                    break;
                    
                case 5 :
                    System.out.println("number of nodes : "+avl.numOfNodes);
                    System.out.println("the height of the tree : "+avl.root.height);
                    break;
                    
                case 6:
                    queueTwoFour =  new QueueTwoFour() ; 
                    for (int i = q.getFront(); i <= q.getRear(); i++) {
                        Node node = q.getNode(i) ; 
                        NodeData nodeData =  new NodeData(node.getName(), node.getPhone(), node.getEmail(), node.getAddress()) ; 
                        
                        queueTwoFour.enqueue(nodeData);
                        
                    }
                    
                    flageCase2 = false;
                    break;

                default:
                    System.out.println("wrong number !!!");
            }

        }

    }

    public static void case2Add() {

        System.out.println("Enter first name : ");
        fname = s.nextLine();
        fname = fname.strip().toLowerCase();
        System.out.println("Enter last name : ");
        lname = s.nextLine();
        lname = lname.strip().toLowerCase();
        System.out.println("Enter phone : ");
        phone = s.next();
        s.nextLine();
        phone = phone.strip().toLowerCase();
        System.out.println("Enter email : ");
        email = s.next();
        s.nextLine();
        email = email.strip().toLowerCase();
        System.out.println("Enter adrees : ");
        address = s.nextLine();
        address = address.strip().toLowerCase();
        name = fname + " " + lname;

        nodeToAdd = new Node(name, phone, email, address);
        avl.insert(name, phone, email, address);
        q = avl.getNewQueue();

    }

    public static void case2Delete() {
        System.out.println("Enter the full name to delete");
        name = s.nextLine().toLowerCase();
        avl.delete(name);
        System.out.println("contact is deleted successfuly");
        q = avl.getNewQueue();

    }

    public static void case2Search() {

        flageCase2Search = true;
        while (flageCase2Search) {
            System.out.println(
                    "****AVL Search Menu****"
                    + "\nEnter 1 to search by first and last name"
                    + "\nEnter 2 to search by first name "
                    + "\nEnter 3 to search by last name"
                    + "\nEnter 4 to part"
                    + "\nEnter 5 to exit"
                    + "\n########################### ");
            try {
                case2MenuSearch = s.nextInt();
                s.nextLine();

            } catch (Exception e) {
                s.nextLine();
                System.out.println("Enter a number !!!!!");
                continue;

            }

            switch (case2MenuSearch) {
                case 1:
                    System.out.println("Enter full name to search");
                    name = s.nextLine().toLowerCase().strip();
                    Node node = avl.searchByDataKey(name);

                    if (node != null) {
                        System.out.println("first name : " + node.getFirstName()
                                + " , last name : " + node.getLastName()
                                + " , email : " + node.getEmail()
                                + " , phone : " + node.getPhone()
                                + " , adress : " + node.getAddress()
                        );
                    } else {
                        System.out.println("no contact with this name");
                    }
                    break;

                case 2:
                    System.out.println("Enter first name to search");
                    name = s.next().toLowerCase().strip();
                    s.nextLine();
                    avl.searchByFirst(name).display();

                    break;

                case 3:
                    System.out.println("Enter last name to search");
                    name = s.next().toLowerCase().strip();
                    s.nextLine();
                    avl.searchByLast(name).display();
                    break;

                case 4:
                    System.out.println("Enter part of the name to search");
                    name = s.next().toLowerCase().strip();

                    avl.searchByPart(name).display();
                    break;

                case 5:
                    flageCase2Search = false;

                    break;

                default:
                    System.out.println("wrong number !!!");
            }
        }

    }
    
    public static void case2Display() {

        boolean flageDisplay = true;
        int displayMenu = 0;
        while (flageDisplay) {
            System.out.println("Enter 1 to display from root "
                    + "\nEnter 2 to display certain from Node"
                    + "\nEnter 3 to back");
            
             try {
                displayMenu = s.nextInt();
                s.nextLine();

            } catch (Exception e) {
                s.nextLine();
                System.out.println("Enter a number !!!!!");
                continue;

            }


            switch (displayMenu) {
                case 1:
                    AVL.print(avl.root);
                    break;
                case 2 : 
                    System.out.println("Enter full name of the node you want to start from");
                    name = s.nextLine().toLowerCase().strip();
                    Node node = avl.searchByDataKey(name);
                    AVL.print(node);
                    break; 
                case 3 :
                    flageDisplay = false ; 
                    break;
                    
                default:
                            System.out.println("Wrong number !!!!!");;
            }

        }

    }

   
   
   

    public static void case3() {
        flagecase3 = true;
        while (flagecase3) {

            System.out.println(
                    "****Heap Menu****"
                    + "\nEnter 1 for max heap"
                    + "\nEnter 2 for min heap"
                    + "\nEnter 3 to back"
                    + "\n###############################");

            try {
                case3Menu = s.nextInt();
                s.nextLine();
            } catch (Exception e) {
                s.nextLine();
                System.out.println("Enter a number !!!!");
                continue;
            }

            switch (case3Menu) {
                case 1:
                    case3MaxHeap();
                    break;

                case 2:
                    case3MinHeap();
                    break;

                case 3:
                    flagecase3 = false;
                    break;

                default:

                    System.out.println("wrong number !!!!!\n");

            }

        }

    }

    public static void case3MaxHeap() {

        heap = new MaxHeap();

        for (int i = q.getFront(); i <= q.getRear(); i++) {
            Node node = q.getNode(i);
            heap.insertAll(node.getName(), node.getPhone(), node.getEmail(), node.getAddress());

        }

        flageCase3Max = true;
        while (flageCase3Max) {
            System.out.println(
                    "****Max Heap Menu****"
                    + "\nEnter 1 to add contact"
                    + "\nEnter 2 to delete "
                    + "\nEnter 3 to search"
                    + "\nEnter 4 to display  "
                    + "\nEnter 5 to show info "        
                    + "\nEnter 6 to back"
                    + "\n########################### ");

            try {
                case3MaxMenu = s.nextInt();
                s.nextLine();
            } catch (Exception e) {
                s.nextLine();
                System.out.println("Enter a number !!!!");
                continue;
            }

            switch (case3MaxMenu) {
                case 1:
                    case3MaxAdd();
                    break;
                case 2:
                    case3MaxDelete();
                    break;
                case 3:
                    case3MaxSearch();
                    break;

                case 4:
                    heap.print();
                    break;
                case 5:
                    int n = q.getRear()+1 ; 
                    System.out.println("number of nodes : " + (q.getRear() + 1) );
                   int height =  (int) (Math.ceil(Math.log(n)/Math.log(2)));
                    System.out.println("the height : "+height);
                    break;

                case 6:
                    
                    queueTwoFour =  new QueueTwoFour() ; 
                    for (int i = q.getFront(); i <= q.getRear(); i++) {
                        Node node = q.getNode(i) ; 
                        NodeData nodeData =  new NodeData(node.getName(), node.getPhone(), node.getEmail(), node.getAddress()) ; 
                        
                        queueTwoFour.enqueue(nodeData);
                        
                    }
                    
                    flageCase3Max = false;
                    break;

                default:
                    throw new AssertionError();
            }
        }

    }

    static public void case3MaxAdd() {

        System.out.println("Enter first name : ");
        fname = s.nextLine();
        fname = fname.strip().toLowerCase();
        System.out.println("Enter last name : ");
        lname = s.nextLine();
        lname = lname.strip().toLowerCase();
        System.out.println("Enter phone : ");
        phone = s.next();
        s.nextLine();
        phone = phone.strip().toLowerCase();
        System.out.println("Enter email : ");
        email = s.next();
        s.nextLine();
        email = email.strip().toLowerCase();
        System.out.println("Enter adrees : ");
        address = s.nextLine();
        address = address.strip().toLowerCase();
        name = fname + " " + lname;

        nodeToAdd = new Node(name, phone, email, address);
        heap.insert(name, phone, email, address);
        q = heap.getNewQueue();

    }

    public static void case3MaxDelete() {

        System.out.println("Enter the full name to delete");
        name = s.nextLine().toLowerCase().trim();
        heap.delete(name);
        q = heap.getNewQueue();

    }

    public static void case3MaxSearch() {
        flageCase3MaxSearch = true;
        while (flageCase3MaxSearch) {
            System.out.println(
                    "****Max Heap Search Menu****"
                    + "\nEnter 1 to search by first and last name"
                    + "\nEnter 2 to search by first name "
                    + "\nEnter 3 to search by last name"
                    + "\nEnter 4 to part"
                    + "\nEnter 5 to exit"
                    + "\n########################### ");
            try {
                case3MaxSearchMenu = s.nextInt();
                s.nextLine();

            } catch (Exception e) {
                s.nextLine();
                System.out.println("Enter a number !!!!!");
                continue;

            }

            switch (case3MaxSearchMenu) {
                case 1:
                    System.out.println("Enter full name to search");
                    name = s.nextLine().toLowerCase().trim();
                    heap.searchByKey(name).display();
                    ;

                    break;

                case 2:
                    System.out.println("Enter first name to search");
                    name = s.next().toLowerCase().trim();
                    s.nextLine();
                    heap.searchByFirst(name).display();

                    break;

                case 3:
                    System.out.println("Enter last name to search");
                    name = s.next().toLowerCase().trim();
                    s.nextLine();
                    heap.searchByLast(name);
                    break;

                case 4:
                    System.out.println("Enter part of the name to search");
                    name = s.next().toLowerCase();

                    heap.searchByPart(name).display();
                    break;
              
                case 5:
                    flageCase3MaxSearch = false;

                    break;

                default:
                    System.out.println("wrong number !!!");
            }
        }
    }

    public static void case3MinHeap() {

        heap = new MinHeap();

        for (int i = q.getFront(); i <= q.getRear(); i++) {
            Node node = q.getNode(i);
            heap.insertAll(node.getName(), node.getPhone(), node.getEmail(), node.getAddress());

        }

        flageCase3Min = true;
        while (flageCase3Min) {
            System.out.println(
                    "****Min Heap Menu****"
                    + "\nEnter 1 to add contact"
                    + "\nEnter 2 to delete "
                    + "\nEnter 3 to search"
                    + "\nEnter 4 to display all "
                    + "\nEnter 5 to show info "        
                    + "\nEnter 6 to back"
                    + "\n########################### ");

            try {
                case3MinMenu = s.nextInt();
                s.nextLine();
            } catch (Exception e) {
                s.nextLine();
                System.out.println("Enter a number !!!!");
                continue;
            }

            switch (case3MinMenu) {
                case 1:
                    case3MinAdd();
                    break;
                case 2:
                    case3MinDelete();
                    break;
                case 3:
                    case3MinSearch();
                    break;

                case 4:
                    heap.print();
                    break;
                case 5:
                   int n = q.getRear()+1 ; 
                    System.out.println("number of nodes : " + (q.getRear() + 1) );
                   int height =  (int) (Math.ceil(Math.log(n +1)/Math.log(2))- 1);
                    System.out.println("the height : "+height);
                    break;
                case 6:
                    
                    queueTwoFour =  new QueueTwoFour() ; 
                    for (int i = q.getFront(); i <= q.getRear(); i++) {
                        Node node = q.getNode(i) ; 
                        NodeData nodeData =  new NodeData(node.getName(), node.getPhone(), node.getEmail(), node.getAddress()) ; 
                        
                        queueTwoFour.enqueue(nodeData);
                        
                    }
                    
                    flageCase3Min = false;
                    break;

                default:
                    throw new AssertionError();
            }
        }

    }

    static public void case3MinAdd() {

        System.out.println("Enter first name : ");
        fname = s.nextLine();
        fname = fname.strip().toLowerCase();
        System.out.println("Enter last name : ");
        lname = s.nextLine();
        lname = lname.strip().toLowerCase();
        System.out.println("Enter phone : ");
        phone = s.next();
        s.nextLine();
        phone = phone.strip().toLowerCase();
        System.out.println("Enter email : ");
        email = s.next();
        s.nextLine();
        email = email.strip().toLowerCase();
        System.out.println("Enter adrees : ");
        address = s.nextLine();
        address = address.strip().toLowerCase();
        name = fname + " " + lname;

        nodeToAdd = new Node(name, phone, email, address);
        heap.insert(name, phone, email, address);
        q = heap.getNewQueue();

    }

    public static void case3MinDelete() {

        System.out.println("Enter the full name to delete");
        name = s.nextLine().toLowerCase().trim();
        heap.delete(name);
        q = heap.getNewQueue();

    }

    public static void case3MinSearch() {
        flageCase3MinSearch = true;
        while (flageCase3MinSearch) {
            System.out.println(
                    "****Min Heap Search Menu****"
                    + "\nEnter 1 to search by first and last name"
                    + "\nEnter 2 to search by first name "
                    + "\nEnter 3 to search by last name"
                    + "\nEnter 4 to part"
                    + "\nEnter 5 to exit"
                    + "\n########################### ");
            try {
                case3MaxSearchMenu = s.nextInt();
                s.nextLine();

            } catch (Exception e) {
                s.nextLine();
                System.out.println("Enter a number !!!!!");
                continue;

            }

            switch (case3MaxSearchMenu) {
                case 1:
                    System.out.println("Enter full name to search");
                    name = s.nextLine().toLowerCase().trim();
                    heap.searchByKey(name).display();
                    ;

                    break;

                case 2:
                    System.out.println("Enter first name to search");
                    name = s.next().toLowerCase().trim();
                    s.nextLine();
                    heap.searchByFirst(name).display();

                    break;

                case 3:
                    System.out.println("Enter last name to search");
                    name = s.next().toLowerCase().trim();
                    s.nextLine();
                    heap.searchByLast(name);
                    break;

                case 4:
                    System.out.println("Enter part of the name to search");
                    name = s.next().toLowerCase();

                    heap.searchByPart(name).display();
                    break;

                case 5:
                    flageCase3MinSearch = false;

                    break;

                default:
                    System.out.println("wrong number !!!");
            }
        }
    }
    
    
    

    public static void save() {
        System.out.println("Enter the name of the file ");
        dir = s.nextLine();

        try {
            BufferedWriter br = new BufferedWriter(new FileWriter("C:\\Users\\Kimo Store\\Downloads\\" + dir + ".cvs"));
            while (!q.isEmpty()) {

                node = q.dequeue();
                String line = node.getName() + "," + node.getPhone() + "," + node.getEmail() + "," + node.getAddress();
         
                br.write(line + "\n");

            }

            br.close();
        } catch (IOException e) {
            System.out.println("there is no file with this name  !!!!!\n");
        }

    }
    
  public  static void case4(){
  for (int i = queueTwoFour.getFront(); i <= queueTwoFour.getRear(); i++) {

            NodeData nodeData = queueTwoFour.getNode(i);
            twoFour.insert(nodeData.getName(), nodeData.getPhone(), nodeData.getEmail(), nodeData.getAddress());

        }

        flageCase4 = true;
        while (flageCase4) {

            System.out.println(
                    "****Two Four Menu****"
                    + "\nEnter 1 to add contact"
                    + "\nEnter 2 to delete "
                    + "\nEnter 3 to search"
                    + "\nEnter 4 to display  "
                    + "\nEnter 5 to show info  "        
                    + "\nEnter 6 to back"
                    + "\n########################### ");
            try {
                case4Menu = s.nextInt();
                s.nextLine();
            } catch (Exception e) {
                s.nextLine();
                System.out.println("Enter a number !!!!!");
                continue;
            }

            switch (case4Menu) {
                case 1:
                    case4Add();
                    break;
                case 2:
                    case4Delete();
                    break;
                case 3:
                    case4Search();
                    break;
                case 4:
                    twoFour.displayTree(0);
                    break;
                case 5 : 
                   
                    System.out.println("height is "+(int)(twoFour.HeightTree(0)+1));
                    System.out.println("number of contacts : "+ (q.getRear()+1) ) ;
                   
                    break;
                    
                case 6:
                    
                    
                    
                    q =  new Queue(); 
                    for (int i = queueTwoFour.getFront(); i <= queueTwoFour.getRear(); i++) {
                        NodeData nodeData = queueTwoFour.getNode(i) ; 
                        Node node =  new Node(nodeData.getName(), nodeData.getPhone(), nodeData.getEmail(), nodeData.getAddress()) ; 
                        
                        q.enqueue(node);
                        
                    }
                    
                    flageCase4 = false;
                    break;

                default:
                    System.out.println("wrong number !!!");
            }

        }    
      
  }
  
  
   public static void case4Add() {

        System.out.println("Enter first name : ");
        fname = s.nextLine();
        fname = fname.strip().toLowerCase();
        System.out.println("Enter last name : ");
        lname = s.nextLine();
        lname = lname.strip().toLowerCase();
        System.out.println("Enter phone : ");
        phone = s.next();
        s.nextLine();
        phone = phone.strip().toLowerCase();
        System.out.println("Enter email : ");
        email = s.next();
        s.nextLine();
        email = email.strip().toLowerCase();
        System.out.println("Enter adrees : ");
        address = s.nextLine();
        address = address.strip().toLowerCase();
        name = fname + " " + lname;

        nodeDataToAdd = new NodeData(name, phone, email, address);
        twoFour.insert(name, phone, email, address);
        queueTwoFour = twoFour.getNewQueue() ;

    }

    public static void case4Delete() {
        System.out.println("Enter the full name to delete");
        name = s.nextLine().toLowerCase();
        twoFour.delete(twoFour.find(name), name) ;
        queueTwoFour = twoFour.getNewQueue();

    }

    public static void case4Search() {

        flageCase4Search = true;
        while (flageCase4Search) {
            System.out.println(
                    "****Two Four Search Menu****"
                    + "\nEnter 1 to search by first and last name"
                    + "\nEnter 2 to search by first name "
                    + "\nEnter 3 to search by last name"
                    + "\nEnter 4 to part"
                    + "\nEnter 5 to exit"
                    + "\n########################### ");
            try {
                case4MenuSearch = s.nextInt();
                s.nextLine();

            } catch (Exception e) {
                s.nextLine();
                System.out.println("Enter a number !!!!!");
                continue;

            }

            switch (case4MenuSearch) {
                case 1:
                    System.out.println("Enter full name to search");
                    name = s.nextLine().toLowerCase().strip();
                    NodeData nodeData = twoFour.findData(name) ; 

                    if (nodeData != null) {
                        System.out.println("first name : " + node.getFirstName()
                                + " , last name : " + node.getLastName()
                                + " , email : " + node.getEmail()
                                + " , phone : " + node.getPhone()
                                + " , adress : " + node.getAddress()
                        );
                    } else {
                        System.out.println("no contact with this name");
                    }
                    break;

                case 2:
                    System.out.println("Enter first name to search");
                    name = s.next().toLowerCase().strip() ; 
                    s.nextLine();
                    twoFour.SearchByFirst(name).display(); ; 

                    break;

                case 3:
                    System.out.println("Enter last name to search");
                    name = s.next().toLowerCase().strip();
                    s.nextLine();
                    twoFour.SearchByLast(name).display(); ; 
                    break;

                case 4:
                    System.out.println("Enter part of the name to search");
                    name = s.next().toLowerCase().trim();

                    twoFour.SearchByPart(name).display();
                    break;

                case 5:
                    flageCase4Search = false;

                    break;

                default:
                    System.out.println("wrong number !!!");
            }
        }

    }
  
}