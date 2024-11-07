package com.crebsthecoder.skwasp.api.event.bound;

import com.crebsthecoder.skwasp.api.bound.Bound;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

/**
 * Called when a player enters a bound
 */
public class BoundEnterEvent extends BoundEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private final Player player;
    private boolean cancelled = false;

    public BoundEnterEvent(Bound bound, Player player) {
        super(bound);
        this.player = player;
    }

    @SuppressWarnings("unused")
    public static HandlerList getHandlerList() {
        return handlers;
    }

    /**
     * The player that entered the bound
     *
     * @return Player that entered the bound
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Check if this event is cancelled
     *
     * @return True if event is cancelled
     */
    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    /**
     * Cancel this event
     *
     * @param cancelled Whether this event should be cancelled or not
     */
    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

}
