import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone myMobilePhone = new MobilePhone("2323");
    public static void main(String[] args) {



        boolean flag = false;
        while (!flag) {
            printMenu();
            //Checking that input is integer number
            while (!scanner.hasNextInt()) {
                System.out.println("Wrong value, Please input integer number");
                scanner.nextLine(); //to avoid endless loop
            }
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Exit");
                    flag = true;
                    break;
                case 2:
                    printListOfContacts();
                    break;
                case 3:
                    addNewContact();
                    break;
                case 4:
                    updateExistingContact();
                    break;
                case 5:
                    removeContact();
                    break;
                case 6:
                    findContact();
                    break;
                default:
                    System.out.println("Unknown command");
                    flag = true;
                    break;
            }
        }


        scanner.close();
    }

    public static void printMenu() {
        System.out.println("----------------MENU----------------");
        System.out.println("\t 1 - Quit");
        System.out.println("\t 2 - Print list of contact");
        System.out.println("\t 3 - Add new contact");
        System.out.println("\t 4 - Update existing contact");
        System.out.println("\t 5 - Remove contact");
        System.out.println("\t 6 - Search/find contact");
    }

    public static void addNewContact() {
        System.out.println("Input the contact name");
        String name = scanner.nextLine();

        if (myMobilePhone.queryContact(name)==null) {
            System.out.println("Input the phone number");
            String phone = scanner.nextLine();
            Contact contact=Contact.createContact(name,phone);
            myMobilePhone.addNewContact(contact);
            System.out.println("Contact was added");

        } else System.out.println("Not added, cause this contact is in your list already");
        System.out.println("Press any key to continue");
        scanner.nextLine();

    }

    public static void printListOfContacts() {
        System.out.println("There are next contacts in mobile phone");
        myMobilePhone.printContacts();
        System.out.println("Press any key to continue");
        scanner.nextLine();
    }

    public static void findContact() {
        System.out.println("Input the name you want to find in contact list");
        String name = scanner.nextLine();
        Contact contact = myMobilePhone.queryContact(name);
        if (contact==null){
            System.out.println("This name is not in your contact list");
        } else {
            System.out.println("Was found " + contact.getName() + " -> "+contact.getPhoneNumber());
        }
        System.out.println("Press any key to continue");
        scanner.nextLine();

    }
    public static void updateExistingContact(){
        System.out.println("Enter the contact you want to update");
        String name= scanner.nextLine();
        Contact contact = myMobilePhone.queryContact(name);
        if (contact==null){
            System.out.println("This name is not in your contact list");
        } else {
            System.out.println("Input new name");
            name = scanner.nextLine();
            System.out.println("Input new phone");
            String phone = scanner.nextLine();
            Contact newContact=Contact.createContact(name,phone);
            myMobilePhone.updateContact(contact,newContact);
            System.out.println("Contact updated");
        }

        System.out.println("Press any key to continue");
        scanner.nextLine();
    }
    public static void removeContact(){
        System.out.println("Input the name of the contact you want to delete");
        String name= scanner.nextLine();
        Contact contact=myMobilePhone.queryContact(name);
        if (contact==null) System.out.println("This name is not in your contact list");
        else {
            myMobilePhone.removeContact(contact);
            System.out.println("Contact removed");
        }

    }
}

