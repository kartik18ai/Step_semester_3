public class Problem5_ShoppingCart {
    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);

        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("Cart ID: " + cart.getCartId());
        System.out.println("Total: " + cart.getTotal());
        System.out.println("Item count: " + cart.getItemCount());
    }
}

class Cart {
    private final double[] prices;
    private final String cartId;
    private int itemCount;

    public Cart(String cartId, int maximumItems) {
        if (maximumItems < 0) {
            throw new IllegalArgumentException("Maximum items cannot be negative.");
        }
        this.cartId = cartId;
        this.prices = new double[maximumItems];
        this.itemCount = 0;
    }

    public void addItem(double price) {
        if (price < 0) {
            System.out.println("Item not added: price cannot be negative.");
            return;
        }

        if (itemCount >= prices.length) {
            System.out.println("Item not added: cart is full.");
            return;
        }

        prices[itemCount] = price;
        itemCount++;
    }

    public double getTotal() {
        double total = 0;
        for (int i = 0; i < itemCount; i++) {
            total += prices[i];
        }
        return total;
    }

    public int getItemCount() {
        return itemCount;
    }

    public String getCartId() {
        return cartId;
    }
}
