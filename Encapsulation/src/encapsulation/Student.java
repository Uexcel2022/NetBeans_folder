package encapsulation;

public class Student {
    
    private String firstName;
    private String lastName;
    private String phone;
    private String title;

    public Student(String firstName, String lastName, String phone, String title) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

   
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

   
    public String getLastName() {
        return lastName;
    }

  
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    
    public String getPhone() {
        return phone;
    }

   
    public void setPhone(String phone) {
        this.phone = phone;
    }

   
    public String getTitle() {
        return title;
    }

  
    public void setTitle(String title) {
        this.title = title;
    }
    
    @Override
   public String  toString(){      
       return ("First name: "+ firstName + "\nLast name: "+lastName+
               "\nTite: "+title + "\nPhone: "+ phone);
   }
                
}
