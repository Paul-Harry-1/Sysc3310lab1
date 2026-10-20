public class BuddyInfo {

    private String name;
    private String address;
    private int number;

    public BuddyInfo(String name, String address, int number) {

        this.name = name;
        this.address = address;
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
    @Override
    public String toString(){
        return name + " - " + address + " - " + number;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if(!(o instanceof BuddyInfo)) return false;
        BuddyInfo b = (BuddyInfo) o;
        return number == b.number && name.equals(b.name) && address.equals(b.address);
    }

    @Override
    public int hashCode(){
        return 31 * (31 * name.hashCode() + address.hashCode()) + number;
    }

    public static void main(String[] args) {
        BuddyInfo b1 = new BuddyInfo("Homer", "scity", 1);
        System.out.println("Hello world!");
        System.out.println("Hello " + b1.getName() );
    }
}
