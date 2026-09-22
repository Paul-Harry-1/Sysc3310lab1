public class BuddyInfo {

    private String name;
    private String address;
    private int number;

    public BuddyInfo(String name, String address, int number) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }



    public static void main(String[] args) {
        BuddyInfo b1 = new BuddyInfo("Homer", "", 1);
        System.out.println("Hello world!");
        System.out.println("Hello " + b1.getName() );
    }
}
