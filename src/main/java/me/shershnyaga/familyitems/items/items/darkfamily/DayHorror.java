package me.shershnyaga.familyitems.items.items.darkfamily;

import me.shershnyaga.familyitems.items.items.FamilySword;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DayHorror extends FamilySword {
    private static final List<StatusEffect> EFFECTS = new ArrayList<>() {{
        add(StatusEffects.INSTANT_DAMAGE);
        add(StatusEffects.POISON);
        add(StatusEffects.WITHER);
        add(StatusEffects.SLOWNESS);
        add(StatusEffects.WEAKNESS);
        add(StatusEffects.BLINDNESS);
        add(StatusEffects.NAUSEA);
    }};
    private static final List<StatusEffect> UNDEAD_EFFECTS = new ArrayList<>() {{
        add(StatusEffects.INSTANT_HEALTH);
        add(StatusEffects.REGENERATION);
        add(StatusEffects.SLOWNESS);
        add(StatusEffects.WEAKNESS);
        add(StatusEffects.BLINDNESS);
    }};
    public DayHorror(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack itemStack, LivingEntity target, LivingEntity attacker) {
        int random = getRandomIntInRange(0, 1000);
        if (random < 5) {
            Vec3d position = target.getPos();

            LightningEntity lightning = new LightningEntity(EntityType.LIGHTNING_BOLT, target.getWorld());
            lightning.setPosition(position);
            target.getWorld().spawnEntity(lightning);
        }
        if (random > 500) {
            StatusEffect effect;
            if (target.isUndead()) {
                effect = UNDEAD_EFFECTS.get(getRandomIntInRange(0, UNDEAD_EFFECTS.size() - 1));
            }
            else {
                effect = EFFECTS.get(getRandomIntInRange(0, EFFECTS.size() - 1));
            }

            int strength = getRandomIntInRange(1, 6);
            int duration = getRandomIntInRange(80, 160);

            if (!target.isDead()) {
                target.addStatusEffect(new StatusEffectInstance(effect, duration, strength));
            }
        }

        return super.postHit(itemStack, target, attacker);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("darkfamily.day_horror.lore.1"));
        tooltip.add(Text.translatable("darkfamily.day_horror.lore.2"));
        tooltip.add(Text.translatable("darkfamily.day_horror.lore.3"));
        tooltip.add(Text.translatable("darkfamily.day_horror.lore.4"));
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
