package me.shershnyaga.familyitems.items.items.DarkFamily;

import me.shershnyaga.familyitems.FamilyItemsMod;
import me.shershnyaga.familyitems.items.items.FamilySword;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.apache.logging.log4j.core.jmx.Server;

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
            spawnWhiteParticles(user.getWorld(), blockPos);
            world.spawnEntity(tnt);

            Vec3d lookDirection = user.getRotationVector();
            lookDirection = lookDirection.add(0, -lookDirection.y + 0.3f, 0).multiply(6);
            user.setVelocity(lookDirection);

            user.getItemCooldownManager().set(this, 600);

            user.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 100));
            return new TypedActionResult<>(ActionResult.SUCCESS, user.getStackInHand(hand));
        }

        return new TypedActionResult<>(ActionResult.SUCCESS, user.getStackInHand(hand));
    }

    private void spawnWhiteParticles(World world, BlockPos blockPos) {
        for (int i = 0; i < 200; i++) {
            double offsetX = world.random.nextGaussian() * 0.3f;
            double offsetY = world.random.nextGaussian() * 0.3f;
            double offsetZ = world.random.nextGaussian() * 0.3f;
            if (offsetY < 0)
                offsetY = Math.abs(offsetY);
            double x = blockPos.getX() + 0.5 + offsetX;
            double y = blockPos.getY() + 0.5 + offsetY;
            double z = blockPos.getZ() + 0.5 + offsetZ;

            world.addParticle(ParticleTypes.CLOUD,
                    x, y, z, offsetX, offsetY, offsetZ);
        }

        for (int i = 0; i < 200; i++) {
            double offsetX = world.random.nextGaussian() * 0.3f;
            double offsetY = world.random.nextGaussian() * 0.3f;
            double offsetZ = world.random.nextGaussian() * 0.3f;
            if (offsetY < 0)
                offsetY = Math.abs(offsetY);
            double x = blockPos.getX() + 0.5 + offsetX;
            double y = blockPos.getY() + 0.5 + offsetY;
            double z = blockPos.getZ() + 0.5 + offsetZ;

            world.addParticle(ParticleTypes.EXPLOSION,
                    x, y, z, offsetX, offsetY, offsetZ);
        }

        for (int i = 0; i < 10; i++) {
            double offsetX = world.random.nextGaussian() * 0.3f;
            double offsetY = world.random.nextGaussian() * 0.3f;
            double offsetZ = world.random.nextGaussian() * 0.3f;
            if (offsetY < 0)
                offsetY = Math.abs(offsetY);
            double x = blockPos.getX() + 0.5 + offsetX;
            double y = blockPos.getY() + 0.5 + offsetY;
            double z = blockPos.getZ() + 0.5 + offsetZ;

            world.addParticle(ParticleTypes.EXPLOSION_EMITTER,
                    x, y, z, offsetX, offsetY, offsetZ);
        }
    }
}
