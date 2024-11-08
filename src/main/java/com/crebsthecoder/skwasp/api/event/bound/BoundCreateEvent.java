package com.crebsthecoder.skwasp.api.event.bound;

import com.crebsthecoder.skwasp.api.bound.Bound;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

// Fake event used in Skript sections
public class BoundCreateEvent extends BoundEvent {

    public BoundCreateEvent(Bound bound) {
        super(bound);
    }

    @Override
    @NotNull
    public HandlerList getHandlers() {
        throw new IllegalStateException();
    }

}
