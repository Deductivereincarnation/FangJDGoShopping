package cart.eventbus;

/**
 * Create by ren on 2017/12/12 21:29
 */

public class PriceAndCountEvent {

    private int price;
    private int count;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
