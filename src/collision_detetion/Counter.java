package collision_detetion;

/**
 * class has count. increase decrease count and return it.
 *
 * @author Dana Danilenko 211538863
 * @version 1
 * @since 13-05-2022
 */

public class Counter {

    private int count;

    /**
     * constructor.
     */
    public Counter() {
        this.count = 0;
    }

    /**
     * constructor.
     * @param count counter
     */
    public Counter(int count) {
        this.count = count;
    }

    /**
     * add number to current count.
     *
     * @param number number
     */
    public void increase(int number) {
        count = count + number;
    }

    /**
     * subtract number from current count.
     *
     * @param number number
     */
    void decrease(int number) {
        count = count - number;
    }

    /**
     * get current count.
     *
     * @return count
     */
    public int getValue() {
        return count;
    }
}
