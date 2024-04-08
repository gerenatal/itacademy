import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Delivery delivery = new Delivery();
        List<Product> product = new ArrayList<>();
        product.add(new Product("Burrito"));
        product.add(new Product("Sandwich"));
        product.add(new Product("Kebab"));
        product.add(new Product("Pizza"));

        Clients client1 = new Clients("Maria Aparecida", "Calle Las Escuelas 13");
        List<Product> productsForClient1 = new ArrayList<>();
        productsForClient1.add(product.get(1));
        productsForClient1.add(product.get(3));

        try {
            delivery.newOrder(client1, productsForClient1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Clients client2 = new Clients("Italo Jacobino", "Calle Corsega 182");
        List<Product> productForClient2 = new ArrayList<>();
        productForClient2.add(product.get(0));
        productForClient2.add(product.get(3));

        try {
            delivery.newOrder(client2, productForClient2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        ongoingOrdersMethod(delivery);
        delivery.setOrderAsDelivered(1);
        deliveredOrdersMethod(delivery);
    }

    static void ongoingOrdersMethod(Delivery delivery){
        for (Order order : delivery.listOngoingOrders()) {
            System.out.println(order.getId());
        }
    }

    static void deliveredOrdersMethod(Delivery delivery){
        for (Order order : delivery.listDeliveredOrders()) {
            System.out.println(order.getId());
        }
    }
 }