package com.shanebeestudios.skbee.elements.other.expressions;

import ch.njol.skript.Skript;
import ch.njol.skript.aliases.ItemType;
import ch.njol.skript.doc.Description;
import ch.njol.skript.doc.Examples;
import ch.njol.skript.doc.Name;
import ch.njol.skript.doc.Since;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.parser.ParserInstance;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Name("Entity Shoot Bow - Consumable")
@Description("Get the Item to be consumed in an entity shoot bow event (if any).")
@Examples({"on entity shoot bow:",
        "\tif consumed item is not an arrow:",
        "\t\tcancel event"})
@Since("2.16.0")
public class ExprShootBowConsumable extends SimpleExpression<ItemType> {

    static {
        Skript.registerExpression(ExprShootBowConsumable.class, ItemType.class, ExpressionType.SIMPLE,
                "consumed item");
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parseResult) {
        if (!ParserInstance.get().isCurrentEvent(EntityShootBowEvent.class)) {
            Skript.error("'" + parseResult.expr + "' can only be used in the entity shoot bow event.");
            return false;
        }
        return true;
    }

    @SuppressWarnings("NullableProblems")
    @Override
    protected @Nullable ItemType[] get(Event event) {
        if (event instanceof EntityShootBowEvent shootBowEvent) {
            ItemStack consumable = shootBowEvent.getConsumable();
            if (consumable != null) return new ItemType[]{new ItemType(consumable)};
        }
        return null;
    }

    @Override
    public boolean isSingle() {
        return true;
    }

    @Override
    public @NotNull Class<? extends ItemType> getReturnType() {
        return ItemType.class;
    }

    @Override
    public @NotNull String toString(@Nullable Event e, boolean debug) {
        return "consumed item";
    }

}
