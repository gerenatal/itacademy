public class Product {
    private String name;
    private double price;
    public Product(String name) {
        this.name = name;
        this.price = setPrice(name);
    }

    private double setPrice(String name){
        double price = 0;
        switch(name.toLowerCase()){
            case "sandwich":
                price = 8.9;
                break;
            case "burritos":
                price = 6.5;
                break;
            case "kebab":
                price = 4.5;
                break;
            case "pizza":
                price = 7.9;
                break;
        }
        return price;
    }
    public String getName() {
        return name;
    }

    public double getPrice(){
        return price;
    }
}
