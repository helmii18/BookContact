package bookcontact;

public class Node {

    private String data, name, firstName, lastName, email, phone, adress;
    private Node leftChild;
    private Node rightChild;
    int height = 1;
    int level ; 



    public Node(String name, String phone, String email, String adress) {
        this.name = name;
        this.firstName = name.toLowerCase().split(" ")[0];
        this.lastName = name.toLowerCase().split(" ")[1];
        this.email = email;
        this.phone = phone;
        this.adress = adress;
        this.data = name.toLowerCase();

    }

   
    public void setLeftChild(Node node) {
        leftChild = node;
    }

    public void setRightChild(Node node) {
        rightChild = node;
    }

    public void setData(String[] dataArr) {
        this.data = (String)  dataArr[0];
        this.name = this.data;
        this.firstName = data.toLowerCase().split(" ")[0];
        this.lastName = data.toLowerCase().split(" ")[1];
        this.phone = dataArr[1] ; 
        this.email = dataArr[2] ; 
        this.adress = dataArr[3] ; 
        
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public String getData() {
        return (String) this.data;
    }

    public int getHeight() {
        return height;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return adress;
    }

    public String getName() {
        return this.name;
    }

   
  

}