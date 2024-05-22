public class Person {
    private String name;
    private String Surname;
    private String email;

    public Person(String name,String Surname,String email) {
        this.name = name;
        this.Surname = Surname;
        this.email = email;
    }


    public String getSurname() {
        return Surname;
    }

    public String getName() {
        return name;
    }

    // Getter and setter methods for the email attribute
    public String getEmail() {
        return email;
    }
}
