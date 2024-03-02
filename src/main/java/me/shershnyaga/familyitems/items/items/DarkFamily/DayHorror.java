package me.shershnyaga.familyitems.items.items.DarkFamily;

import me.shershnyaga.familyitems.items.items.FamilySword;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;

public class DayHorror extends FamilySword {
    public DayHorror(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack itemStack, LivingEntity target, LivingEntity attacker) {
        target.setFireTicks(100);
        return super.postHit(itemStack, target, attacker);
    }
}
