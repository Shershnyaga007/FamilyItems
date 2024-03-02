package me.shershnyaga.familyitems.items.items;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class FamilySwordTool implements ToolMaterial {
    private final int damage;
    public FamilySwordTool(int damage) {
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
