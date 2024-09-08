package collision_detetion;

/**
 * indicate that objects that implement it send notifications when they are
 * being hit.
 *
 * @author Dana Danilenko 211538863
 * @version 1
 * @since 12-05-2022
 */

public interface HitNotifier {

    /**
     * Add hl as a listener to hit events.
     *
     * @param hl listen to hit events
     */
    void addHitListener(HitListener hl);

    /**
     * Remove hl from the list of listeners to hit events.
     *
     * @param hl listen to hit events
     */
    void removeHitListener(HitListener hl);
}
