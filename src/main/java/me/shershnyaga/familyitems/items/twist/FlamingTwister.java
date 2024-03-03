package me.shershnyaga.familyitems.items.twist;

import me.shershnyaga.familyitems.items.templates.FamilySword;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;

import java.util.Random;

public class FlamingTwister extends FamilySword {
    public FlamingTwister(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack itemStack, LivingEntity target, LivingEntity attacker) {
        target.setOnFireFor(40);
        if (getRandomIntInRange(1, 20) == 20)
            target.setYaw(target.getYaw() + 180);
        return super.postHit(itemStack, target, attacker);
    }

    private static int getRandomIntInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("Invalid range: min must be less than max");
        }
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}
