import javax.swing.DefaultListModel;


public class AddressBook extends DefaultListModel<BuddyInfo> {
    //List<BuddyInfo> books = new ArrayList<>();

    public void addBuddy(BuddyInfo b){

        addElement(b);
    }

    public void removeBuddy(BuddyInfo b){

        removeElement(b);
    }

    public BuddyInfo getBuddy(int i){
        return getElementAt(i);
    }

}
