import java.util.ArrayList;
import java.util.List;

public class AdressBook {
    List<BuddyInfo> books = new ArrayList<>();

    public void addBuddy(BuddyInfo info){
        books.add(info);
    }

    public void removeBuddy(BuddyInfo info){
        books.remove(info);
    }

    public static void main(String[] args){
        Sytem.out.println("Adress book");
    }


}
