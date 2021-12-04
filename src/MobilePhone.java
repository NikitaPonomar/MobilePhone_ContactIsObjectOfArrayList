import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();
    }

    public boolean addNewContact (Contact contact) {
        if (findContact(contact.getName())>=0) return false;
        this.myContacts.add(contact);
        return true;
    }

    public boolean updateContact (Contact oldRecord, Contact newRecord) {
        if (findContact(newRecord)>=0) return false;
        int position=findContact(oldRecord);
        if(position<0) return false;
        this.myContacts.set(position,newRecord);
        return true;
    }

    public boolean removeContact(Contact contact){
        if (findContact(contact)<0) return false;
        this.myContacts.remove(contact);
        return true;
    }

    private int findContact(Contact contact) {
        return this.myContacts.indexOf(contact);
    }

    private int findContact(String name) {
        for (int i=0; i<this.myContacts.size(); i++){
            if (this.myContacts.get(i).getName().equals(name)) return i ;
        }
        return -1;
    }

    public Contact queryContact (String name) {
        int position=findContact(name);
        if (position>=0) return this.myContacts.get(position);
        return null;
    }

    public void printContacts(){
        System.out.println("Contact List:");
        for (int i=0; i<this.myContacts.size();i++){
            System.out.println((i+1)+". "+this.myContacts.get(i).getName()+" -> "+this.myContacts.get(i).getPhoneNumber());
        }
    }

}
