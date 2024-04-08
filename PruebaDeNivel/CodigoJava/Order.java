import java.util.List;
public class Order {
    private int idPrimaryKey = 0;
    private Clients client;
    private List<Product> products;
    private DeliveryGuy deliveryGuy;
    private double totalPrice;
    private String vehicle;

    public Order(Clients client, List<Product> products, DeliveryGuy deliveryGuy) throws Exception {
        if (client == null || products.isEmpty()) {
            throw new Exception("Can't have an order without client nor product");
        }

        this.idPrimaryKey = ++this.idPrimaryKey;
        this.client = client;
        this.products = products;
        this.deliveryGuy = deliveryGuy;
        deliveryGuy.setAvailable(false);
        totalPrice = priceWithVehicle(sumPartialPrice(this.products), this.vehicle);
        this.vehicle = vehicle;
    }

    public void setAsDelivered() {
        deliveryGuy.setAvailable(true);
    }

    public int getId() {
        return idPrimaryKey;
    }

    public double sumPartialPrice(List<Product> products) {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    public double priceWithVehicle(double partial, String vehicle){
        double total = partial;
        switch(vehicle.toLowerCase()){
            case "motorcycle":
                total = total*1.02;
                break;
            case "byke":
                total = total*1.01;
                break;
        }
        return total;
    }

    public Clients getClient() {
        return client;
    }


    public List<Product> getProducts() {
        return products;
    }

    public DeliveryGuy getDeliveryGuy() {
        return deliveryGuy;
    }

    public void setVehicle(String vehicle){
        this.vehicle = vehicle;
    }
}
