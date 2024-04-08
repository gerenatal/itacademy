import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Delivery {

    private List<DeliveryGuy> deliveryteam;
    private List<Order> ongoingOrders;
    private List<Order> deliveredOrders;
    private Random random;

    public Delivery() {
        deliveryteam = new ArrayList<>();
        deliveryteam.add(new DeliveryGuy("Jonas"));
        deliveryteam.add(new DeliveryGuy("Pedro"));
        deliveryteam.add(new DeliveryGuy("Lucas"));
        ongoingOrders = new ArrayList<>();
        deliveredOrders = new ArrayList<>();
        random = new Random();
    }

    public void newOrder(Clients client, List<Product> products) throws Exception {
        DeliveryGuy randomDeliveryGuy = getAvailableDeliveryGuy();
        if (randomDeliveryGuy == null) {
            throw new Exception("No personal available at the moment.");
        }
        Order newOrder = new Order(client, products, randomDeliveryGuy);
        ongoingOrders.add(newOrder);
    }

    private DeliveryGuy getAvailableDeliveryGuy() {
        List<DeliveryGuy> available = new ArrayList<>();
        for (DeliveryGuy deliveryGuy : deliveryteam) {
            if (deliveryGuy.isAvailable()) {
                available.add(deliveryGuy);
            }
        }
        if (available.isEmpty()) {
            return null;
        }
        return available.get(random.nextInt(available.size()));
    }

    public void setOrderAsDelivered(int idPrimaryKey) {
        Order order = searchOrder(idPrimaryKey, ongoingOrders);
        if (order != null) {
            ongoingOrders.remove(order);
            order.setAsDelivered();
            deliveredOrders.add(order);
        }
    }

    public List<Order> listOngoingOrders() {
        return ongoingOrders;
    }

    public List<Order> listDeliveredOrders() {
        return deliveredOrders;
    }

    private Order searchOrder(int idPrimaryKey, List<Order> orderList) {
        Order order = null;
        for (Order orderFound : orderList) {
            if (order.getId() == idPrimaryKey) {
                order = orderFound;
            }
        }
        return order;
    }
}
