package me.shershnyaga.familyitems.items.deylan;

import me.shershnyaga.familyitems.items.templates.FamilySword;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class VoidSword extends FamilySword {
    public VoidSword(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("deylan.void_sword.lore.1"));
        tooltip.add(Text.translatable("deylan.void_sword.lore.2"));
        tooltip.add(Text.translatable("deylan.void_sword.lore.3"));
        tooltip.add(Text.translatable("deylan.void_sword.lore.4"));
        tooltip.add(Text.translatable("deylan.void_sword.lore.5"));
        tooltip.add(Text.translatable("deylan.void_sword.lore.6"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
