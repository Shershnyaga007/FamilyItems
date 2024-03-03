package me.shershnyaga.familyitems.items.neonub;

import me.shershnyaga.familyitems.items.templates.FamilySword;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FrostySorrow extends FamilySword {
    public FrostySorrow(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("neonubfamily.frosty_sorrow.lore.1"));
        tooltip.add(Text.translatable("neonubfamily.frosty_sorrow.lore.2"));
        tooltip.add(Text.translatable("neonubfamily.frosty_sorrow.lore.3"));
        tooltip.add(Text.translatable("neonubfamily.frosty_sorrow.lore.4"));
        tooltip.add(Text.translatable("neonubfamily.frosty_sorrow.lore.5"));
        super.appendTooltip(stack, world, tooltip, context);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 40, 1));
        attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 40, 2));
        return super.postHit(stack, target, attacker);
    }
}
