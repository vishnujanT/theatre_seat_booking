

public class Ticket {
    int Seat;
    int Row;
    double price;
    Person person;

    public double getPrice() {
        return price;
    }
    public Ticket(Person person,int Seat,int Row,double price){
        this.person=person;
        this.Seat=Seat;
        this.Row=Row;
        this.price=price;

    }

    public void print() {
        System.out.println("name :" + person.getName());
        System.out.println("surame  :" + person.getSurname());
        System.out.println("email :" + person.getEmail());
        System.out.println("Row :" + Row);
        System.out.println("Seat :" + Seat);
        System.out.println("Price :" + price);
        System.out.println("");


    }

}
