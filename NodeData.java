package bookcontact;


public class NodeData {
 public String data,name,firstName,lastName,address,email,phone;

    
    public NodeData(String name, String phone, String email, String adress) {
        this.name = name;
        this.firstName = name.toLowerCase().split(" ")[0];
        this.lastName = name.toLowerCase().split(" ")[1];
        this.email = email;
        this.phone = phone;
        this.address = adress;
        this.data = name.toLowerCase();

    }
        


    public void setData(String data) {
        this.data = (String)  data;
    }

   

    public String getData() {
        return (String) this.data;
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
        return address;
    }

    public String getName() {
        return this.name;
    }
     public void displayItem() 
 {
  System.out.println("NodeData{" + "FirstName=" + firstName + ", LastName=" + lastName + ", Address=" + address + ", EmailAddress=" + email + ", Phonenumber=" + phone + '}');
 }

}