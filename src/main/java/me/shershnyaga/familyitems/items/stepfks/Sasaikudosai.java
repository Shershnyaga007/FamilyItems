package me.shershnyaga.familyitems.items.stepfks;

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

public class Sasaikudosai extends FamilySword {
    public Sasaikudosai(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("stepfks.sasai_kudosai.lore.1"));
        tooltip.add(Text.translatable("stepfks.sasai_kudosai.lore.2"));
        tooltip.add(Text.translatable("stepfks.sasai_kudosai.lore.3"));
        tooltip.add(Text.translatable("stepfks.sasai_kudosai.lore.4"));
        tooltip.add(Text.translatable("stepfks.sasai_kudosai.lore.5"));
        tooltip.add(Text.translatable("stepfks.sasai_kudosai.lore.6"));
        tooltip.add(Text.translatable("stepfks.sasai_kudosai.lore.7"));
        super.appendTooltip(stack, world, tooltip, context);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 40, 2));

        return super.postHit(stack, target, attacker);
    }
}
