package com.shanebeestudios.skbee.elements.other.expressions;

import ch.njol.skript.doc.Description;
import ch.njol.skript.doc.Examples;
import ch.njol.skript.doc.Name;
import ch.njol.skript.doc.Since;
import ch.njol.skript.expressions.base.SimplePropertyExpression;
import ch.njol.skript.util.EnchantmentType;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;

@Name("Enchantment Level")
@Description("Get the enchantment level from an Enchantment Type.")
@Examples({"loop enchantments of player's tool:",
        "\tset {_level} to enchantment level of loop-value",
        "\tset {_enchant} to enchantment of loop-value"})
@Since("1.16.0")
public class ExprEnchantmentLevel extends SimplePropertyExpression<EnchantmentType, Number> {

    static {
        register(ExprEnchantmentLevel.class, Number.class, "enchantment level", "enchantmenttypes");
    }

    @Override
    public @Nullable Number convert(EnchantmentType enchantmentType) {
        return enchantmentType.getLevel();
    }

    @Override
    public @NotNull Class<? extends Number> getReturnType() {
        return Number.class;
    }

    @Override
    protected @NotNull String getPropertyName() {
        return "enchantment level";
    }

}
