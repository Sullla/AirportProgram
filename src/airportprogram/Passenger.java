package airportprogram;

public class Passenger {

    private String firstName,
            lastName;
    int sum;

    public void fullname(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getfirstName() {
        return firstName;

    }

    public void setlastName(String lastName) {
        this.lastName = lastName;
    }

    public String getlastName() {
        return lastName;
    }

    public String fullName() {

        return firstName + " " + lastName;

    } 

    public void setSecondsInQueue(int sum) {
      
        this.sum = sum + sum;
    }

   public int getSecondsInQueue() {

        return sum;

    }
   
   

}
