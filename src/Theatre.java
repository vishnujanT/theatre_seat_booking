import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.*;
public class Theatre {
    static ArrayList<Ticket> tickets = new ArrayList<>();

    /**
     *
     * @param x the array of 1st row
     * @param y the array of 2nd row
     * @param z the array of 3rd row
     */
    public static void buy_ticket(int[] x, int[] y, int[] z) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter person information:");
        System.out.print("Name: ");
        String name = input.nextLine();
        System.out.print("Surname: ");
        String surname = input.nextLine();
        System.out.print("Email: ");
        String email = input.nextLine();


        //takings inputs to demostrate the seats
        System.out.println("Input row number");
        int row = input.nextInt();

        if (row> 0 && row<4){

        System.out.println("Input seat number");
        int seat = input.nextInt();
        System.out.println("|--------------|");
        System.out.println("| 1st row= $50 |");
        System.out.println("| 2nd row= $20 |");
        System.out.println("| 3rd row= $10 |");
        System.out.println("|--------------|");
        System.out.print("Price $: ");
        double price = input.nextDouble();

        if (row == 1) {
            if (x[seat-1] == 1){
                System.out.println("Seat already occupied");
            }else{
                x[seat-1] = 1;
                System.out.println("Seat reserved successfully....");

                Ticket ticket = new Ticket(new Person(name, surname, email),seat,row,price);
                tickets.add(ticket);
            } //to select first seat
        } else if (row == 2) {
            if (y[seat-1] == 1){
                System.out.println("Seat already occupied");
            }else{
                y[seat-1] = 1;
                System.out.println("Seat reserved successfully..");
                Ticket ticket = new Ticket(new Person(name, surname, email),seat,row,price);
                tickets.add(ticket);
            }
        } else if (row == 3) {
            if (z[seat-1] == 1){
                System.out.println("Seat already occupied");
            }else{
                z[seat-1] = 1;
                System.out.println("Seat reserved successfully...");
                Ticket ticket = new Ticket(new Person(name, surname, email),seat,row,price);
                tickets.add(ticket);
            }
        }
        } else {
            System.out.println("Invalid Row");

    }
    }

    /**
     *
     * @param x pass the rows through perameters
     */
    public static void print_seating_area(int[] x) {   //The method View the seating when its called
        if (x.length == 12) {
            System.out.print("    ");   //takes the space
        } else if (x.length == 16) {
            System.out.print("  ");
        }

        for (int i = 0; i < x.length; i++) {
            if (x[i] == 0) {
                System.out.print("o");  //available seats
            } else {
                System.out.print("x");  //booked seats
            }
            if (i + 1 == x.length / 2) {
                System.out.print(" ");
            }
        }

        System.out.println();
    }

    /**
     *
     * @param x the array of 1st row
     * @param y the array of 2st row
     * @param z the array of 3st row
     */
    public static void cancel_ticket(int[] x, int[] y, int[] z) {   //The method delete the seating when its called
        Scanner input = new Scanner(System.in);

        System.out.println("Input row number");
        int row = input.nextInt();

        if (row > 0 && row < 4) {

            System.out.println("Input seat number");
            int seat = input.nextInt();


            if (row == 1) {
                if (x[seat - 1] == 0) {
                    System.out.println("Seat not occupied");
                } else {
                    x[seat - 1] = 0;
                    System.out.println("Seat cancelled successfully");
                    for (Ticket ticket:tickets){
                        if(ticket.Row==row && ticket.Seat==seat){
                            tickets.remove(ticket);
                            break;
                        }
                    }

                } //to select first seat
            } else if (row == 2) {
                if (y[seat - 1] == 0) {
                    System.out.println("Seat not occupied");
                } else {
                    y[seat - 1] = 0;
                    System.out.println("Seat cancelled successfully");
                    for (Ticket ticket:tickets){
                        if(ticket.Row==row && ticket.Seat==seat){
                            tickets.remove(ticket);
                            break;
                        }
                    }
                }

                } else if (row == 3) {
                    if (z[seat - 1] == 0) {
                        System.out.println("Seat not occupied");
                    } else {
                        z[seat - 1] = 0;
                        System.out.println("Seat cancelled successfully");
                        for (Ticket ticket:tickets){
                            if(ticket.Row==row && ticket.Seat==seat){
                                tickets.remove(ticket);
                                break;
                            }
                        }

                    }

            } else {
                System.out.println("Invalid Row");

            }
        }
    }

    /**
     *
     * @param x rows will be called
     * @param num
     */
    public static void show_available(int[] x, int num) {  //The method View the available seat by numbers when called

        System.out.print("seats available in row " + num + " : ");

        for (int i = 0; i < x.length; i++) {
            if (x[i] == 0) {
                System.out.print(i + 1);
            }
            System.out.print(",");
        }
        System.out.println("");


    }

    /**
     *
     * @param x the array of 1st row
     * @param y the array of 2st row
     * @param z the array of 3st row
     * @param textfile the arrays will save on text file.
     */
    public static void save(int[] x, int[] y, int[] z, String textfile) { //The method save the seat when called and prints on txt file
        try {
            FileWriter file = new FileWriter(textfile);

            for (int i = 0; i < x.length; i++) {   //write the row 1 in txt_file
                file.write(String.valueOf(x[i]));
            }
            file.write("\n");

            for (int i = 0; i < y.length; i++) {    //write the row 2 in txt_file
                file.write(String.valueOf(y[i]));
            }
            file.write("\n");

            for (int i = 0; i < z.length; i++) {    //write the row 3 in txt_file
                file.write(String.valueOf(z[i]));
            }

            file.close();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    /**
     *
     * @param row1 load the array of 1st row
     * @param row2 load the array of 2st row
     * @param row3 load the array of 3st row
     */
    public static void load(int[] row1, int[] row2, int[] row3) {  //The method return the data from array when called
        int count_r2 = 0;
        int count_r3 = 0;
        int count=0;

        try {
            File file = new File("textfile.txt");
            Scanner file_reader = new Scanner(file);

            while (file_reader.hasNextLine()) {
                count+=1;
                String text = file_reader.nextLine();

                for (int i = 0; i < text.length(); i++) {

                    String re = String.valueOf(text.charAt(i));  //read the each charecters

                    int rows = Integer.parseInt(re);
                    if (count==1) {
                        row1[i] = rows;
                    } else if (count==2) {
                        row2[i] = rows;

                    } else {
                        row3[i] = rows;
                    }
                }
            }
            file_reader.close();

        } catch (IOException e) {
            System.out.println("Error while reading a file.");
        }
    }

    /**
     *
     * @param tickets the saved tickets and informations will lord from here.
     */
    public static void show_ticket_info(ArrayList<Ticket> tickets) {  //The method View the available seat details when called
            int  i =0;
            double total_amount = 0.0;
            for (Ticket ticket : tickets) {

                System.out.println("Ticket #" + (i+1) + " info:");
                ticket.print();
                total_amount += ticket.getPrice();
                i++;
            }
            System.out.println("Total price of all tickets: £" + total_amount );


    }

    /**
     *
     * @param tickets the tickets will sorted through this method
     */

    public static void Sort_tickets(ArrayList<Ticket> tickets) {
        int count=0;
        if (tickets.size()>1) {
            while(count<tickets.size()) {

                for (int differentiate = 1; differentiate <= tickets.size() - 1; differentiate++) {
                    Ticket first = (Ticket) tickets.get(differentiate - 1);
                    Ticket secound = (Ticket) tickets.get(differentiate);
                    if ((first.getPrice()) > secound.getPrice()) {

                        tickets.set(differentiate - 1, secound);
                        tickets.set(differentiate, first);
                    }
                }count++;
            }show_ticket_info(tickets);
        }
    }

    /**
     *
     * @param args main menu for the program
     */

    public static void main (String[]args) {
        Scanner input = new Scanner(System.in);


        Scanner scanner = new Scanner(System.in);

        System.out.println("    WELCOME TO THE NEW THEATRE    ");
        int[] row1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] row2 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] row3 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int option = -1;
        try {
            while (option != 0) {

                //main menu for the program
                System.out.println("\n==================================================");
                System.out.println("\n**************** MOVIE BOOKING *****************");
                System.out.println("\n==================================================\n");
                System.out.println("1 : Buy a ticket");
                System.out.println("2 : Print seat area ");
                System.out.println("3 : Cancel ticket");
                System.out.println("4 : List of available seat");
                System.out.println("5 : Save to file");
                System.out.println("6 : load from file");
                System.out.println("7 : print ticket information and total price");
                System.out.println("8 : Sort ticket by price");
                System.out.println("0 : Quit");

                System.out.println("==================================================\n");
                System.out.println("Enter option:");

                option = input.nextInt();

                switch (option) {
                    case 1:
                        buy_ticket(row1, row2, row3);
                        break;
                    case 2:
                        //Treater view
                        System.out.println("    ************");
                        System.out.println("    *   STAGE  *");
                        System.out.println("    ************");
                        System.out.print("\n");

                        print_seating_area(row1);
                        print_seating_area(row2);
                        print_seating_area(row3);
                        break;
                    case 3:
                        cancel_ticket(row1, row2, row3);
                        break;
                    case 4:
                        show_available(row1, 1);
                        show_available(row2, 2);
                        show_available(row3, 3);
                        break;
                    case 5:
                        try {
                            FileWriter fileWriter = new FileWriter("textfile.txt"); //create new text_file
                        } catch (IOException e) {
                            System.out.println("Error");
                        }
                        System.out.println("Saved to file successfully..");
                        save(row1, row2, row3, ("textfile.txt"));


                        break;

                    case 6:
                        load(row1, row2, row3);   //reverse the data from saved array
                        break;
                    case 7:
                        show_ticket_info(tickets);
                        break;
                    case 8:
                        Sort_tickets(tickets);
                        break;

                    case 0:
                        System.out.println("Thank you for using..");
                        break;
                    default:
                        System.out.println("Invalid option Please select from the menu"); //this will ask user menu option again
                }

            }

        }catch (Exception e) {
            System.out.println("invalid option ");} //display invalid option and this will terminate program
    }
}



















