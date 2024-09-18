package com.shanebeestudios.skbee.elements.other.effects;

import ch.njol.skript.Skript;
import ch.njol.skript.doc.Description;
import ch.njol.skript.doc.Examples;
import ch.njol.skript.doc.Name;
import ch.njol.skript.doc.Since;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;
import org.bukkit.EntityEffect;
import org.bukkit.entity.Entity;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Name("Entity Effect")
@Description({"Play different EntityEffects on entities.",
        "\nNote: Some effects will only play on certain entities, ex: `wolf_shake` will only play on a wolf."})
@Examples({"play entity effect break_equipment_main_hand on player",
        "play entity effect death on all mobs"})
@Since("3.0.0")
public class EffEntityEffect extends Effect {

    static {
        Skript.registerEffect(EffEntityEffect.class, "play entity effect %entityeffect% on %entities%");
    }

    private Expression<EntityEffect> entityEffect;
    private Expression<Entity> entities;

    @SuppressWarnings({"unchecked", "NullableProblems"})
    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parseResult) {
        this.entityEffect = (Expression<EntityEffect>) exprs[0];
        this.entities = (Expression<Entity>) exprs[1];
        return true;
    }

    @SuppressWarnings("NullableProblems")
    @Override
    protected void execute(Event event) {
        EntityEffect entityEffect = this.entityEffect.getSingle(event);
        if (entityEffect == null) return;

        Class<? extends Entity> applicable = entityEffect.getApplicable();
        for (Entity entity : this.entities.getArray(event)) {
            if (applicable.isAssignableFrom(entity.getClass())) {
                entity.playEffect(entityEffect);
            }
        }
    }

    @Override
    public @NotNull String toString(@Nullable Event e, boolean d) {
        return "play entity effect " + this.entityEffect.toString(e, d) + " on " + this.entities.toString(e, d);
    }

}
