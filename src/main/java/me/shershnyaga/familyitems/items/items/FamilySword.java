package me.shershnyaga.familyitems.items.items;

import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class FamilySword extends SwordItem {
    public FamilySword(int attackDamage, float attackSpeed, Settings settings) {
        super(new FamilySwordTool(attackDamage), attackDamage, attackSpeed, settings);
    }
}
