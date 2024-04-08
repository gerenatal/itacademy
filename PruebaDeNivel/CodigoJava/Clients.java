public class Clients {
    private String name;
    private String address;

    public Clients(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
