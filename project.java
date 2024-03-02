import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;
public class project{
    Scanner sc = new Scanner(System.in);
    String name , department , bloodGroup , address , mobileNumber , id;
    int age , yearOfJoining ;
    void display()
    {
        System.out.println("Enter Your Details For Making Id-Card:\n");
        System.out.print("Name              : ");
        name = sc.nextLine();
        System.out.print("Age               : ");
        age = sc.nextInt();
        sc.nextLine(); // Consume newline
        System.out.print("Department        : ");
        department = sc.nextLine();
        System.out.print("Year of Joining   : ");
        yearOfJoining = sc.nextInt();
        sc.nextLine(); // Consume newline
        System.out.print("Blood Group       : ");
        bloodGroup = sc.nextLine();
        System.out.print("Address           : ");
        address = sc.nextLine();
        System.out.print("Mobile Number     : ");
        mobileNumber = sc.nextLine();
    }
    void generateID() {
        Random random = new Random();
        id = String.format("%06d", random.nextInt(1000000));
    }
    void declare()
    {
        System.out.println("\n\n");
        System.out.println("Your Id-Card was Ready\n\n");

        System.out.println("---------------------------------------");
        System.out.println("| ID            : " + String.format("%-20s", id)           + "|");
        System.out.println("| Name          : " + String.format("%-20s", name)          + "|");
        System.out.println("| Age           : " + String.format("%-20s", age)           + "|");
        System.out.println("| Department    : " + String.format("%-20s", department)    + "|");
        System.out.println("| Joining Year  : " + String.format("%-20s", yearOfJoining) + "|");
        System.out.println("| Blood Group   : " + String.format("%-20s", bloodGroup)    + "|");
        System.out.println("| Address       : " + String.format("%-20s", address)       + "|");
        System.out.println("| Contact       : " + String.format("%-20s", mobileNumber)  + "|");
        System.out.println("---------------------------------------");
    }
    void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("id_card.txt", true))) {
            writer.println("-------------------------------------------------");
            writer.println("| ID             : " + String.format("%-20s", id) + " |");
            writer.println("| Name           : " + String.format("%-20s", name) + " |");
            writer.println("| Age            : " + String.format("%-20s", age) + " |");
            writer.println("| Department     : " + String.format("%-20s", department) + " |");
            writer.println("| Joining Year   : " + String.format("%-20s", yearOfJoining) + " |");
            writer.println("| Blood Group    : " + String.format("%-20s", bloodGroup) + " |");
            writer.println("| Address        : " + String.format("%-20s", address) + " |");
            writer.println("| Contact        : " + String.format("%-20s", mobileNumber) + " |");
            writer.println("-------------------------------------------------");
            writer.println();
            System.out.println(" Your Id-card was saved to file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the ID card to file.");
            e.printStackTrace();
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        project me = new project();
        String choice;
        do{
        me.display();
        me.generateID();
        me.declare();
        me.saveToFile();
        System.out.println("\nDo you want to generate another Id-Card ? (YES/NO):");
        choice =  sc.nextLine();
        }while(choice.equals("YES"));
        sc.close();
    }
}
