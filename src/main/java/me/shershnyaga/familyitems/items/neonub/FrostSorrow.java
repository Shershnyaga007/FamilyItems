package me.shershnyaga.familyitems.items.neonub;

import me.shershnyaga.familyitems.items.templates.FamilySword;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FrostSorrow extends FamilySword {
    public FrostSorrow(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 40, 3));
        return super.postHit(stack, target, attacker);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("neonubfamily.frost_sorrow.1"));
        tooltip.add(Text.translatable("neonubfamily.frost_sorrow.2"));
        tooltip.add(Text.translatable("neonubfamily.frost_sorrow.3"));
        tooltip.add(Text.translatable("neonubfamily.frost_sorrow.4"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
