package me.shershnyaga.familyitems.items.items.DarkFamily;

import me.shershnyaga.familyitems.FamilyItemsMod;
import me.shershnyaga.familyitems.items.items.FamilySword;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.apache.logging.log4j.core.jmx.Server;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class NightHorror extends FamilySword {
    public NightHorror(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (user.isSneaking()) {

            Vec3d pos = user.getPos();

            TntEntity tnt = new TntEntity(world, pos.getX(), pos.getY(), pos.getZ(), user);
            tnt.setFuse(30);
            BlockPos blockPos = user.getBlockPos();

            if (!world.isClient) {
                spawnWhiteParticles((ServerWorld) user.getWorld(), blockPos);
                world.spawnEntity(tnt);

                user.getItemCooldownManager().set(this, 600);

                user.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 100));
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 600, 2));
            }

            Vec3d lookDirection = user.getRotationVector();
            lookDirection = lookDirection.add(0, -lookDirection.y + 0.3f, 0).multiply(6);
            user.setVelocity(lookDirection);
            return new TypedActionResult<>(ActionResult.SUCCESS, user.getStackInHand(hand));
        }

        return new TypedActionResult<>(ActionResult.SUCCESS, user.getStackInHand(hand));
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("darkfamily.night_horror.lore.1"));
        tooltip.add(Text.translatable("darkfamily.night_horror.lore.2"));
        tooltip.add(Text.translatable("darkfamily.night_horror.lore.3"));
        tooltip.add(Text.translatable("darkfamily.night_horror.lore.4"));
        super.appendTooltip(stack, world, tooltip, context);
    }

    private void spawnWhiteParticles(ServerWorld world, BlockPos blockPos) {
        double x = blockPos.getX() + 0.5;
        double y = blockPos.getY() + 0.5;
        double z = blockPos.getZ() + 0.5;
        world.spawnParticles(ParticleTypes.BUBBLE, x, y,
                z, 250, 0.5, 0.5, 0.5, 2);
        world.spawnParticles(ParticleTypes.EXPLOSION, x, y,
                z, 250, 0.5, 0.5, 0.5, 2);
        world.spawnParticles(ParticleTypes.EXPLOSION_EMITTER, x, y,
                z, 20, 2, 2, 2, 0.5);
    }
}
