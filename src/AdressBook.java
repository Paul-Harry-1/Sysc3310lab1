import java.util.ArrayList;
import java.util.List;

public class AddressBook {
    List<BuddyInfo> books = new ArrayList<>();

    public void addBuddy(BuddyInfo info){
        books.add(info);
    }

    public void removeBuddy(BuddyInfo info){
        books.remove(info);
    }

    public static void main(String[] args){
        BuddyInfo buddy = new BuddyInfo("Tom", "Carleton", "613");
        AddressBook adressBook = new AddressBook();
        adressBook.addBuddy(buddy);
        adressBook.removeBuddy(buddy);
    }


}
