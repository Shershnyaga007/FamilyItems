package me.shershnyaga.familyitems.items.templates;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class FamilySwordDefaultTool implements ToolMaterial {
    private final int damage;
    public FamilySwordDefaultTool(int damage) {
        this.damage = damage;
    }

    @Override
    public int getDurability() {
        return 0;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 0;
    }

    @Override
    public float getAttackDamage() {
        return damage;
    }

    @Override
    public int getMiningLevel() {
        return 0;
    }

    @Override
    public int getEnchantability() {
        return 0;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }
}
