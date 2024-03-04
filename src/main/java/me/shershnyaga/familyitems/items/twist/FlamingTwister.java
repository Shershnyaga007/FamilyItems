package me.shershnyaga.familyitems.items.twist;

import me.shershnyaga.familyitems.items.templates.FamilySword;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
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

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("twist.flaming_twister.lore.1"));
        tooltip.add(Text.translatable("twist.flaming_twister.lore.2"));
        tooltip.add(Text.translatable("twist.flaming_twister.lore.3"));
        tooltip.add(Text.translatable("twist.flaming_twister.lore.4"));
        tooltip.add(Text.translatable("twist.flaming_twister.lore.5"));
        tooltip.add(Text.translatable("twist.flaming_twister.lore.6"));
        super.appendTooltip(stack, world, tooltip, context);
    }

    private static int getRandomIntInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("Invalid range: min must be less than max");
        }
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}
