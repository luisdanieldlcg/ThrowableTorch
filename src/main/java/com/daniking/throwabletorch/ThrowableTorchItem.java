package com.daniking.throwabletorch;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class ThrowableTorchItem extends Item {

    final EntityType<? extends ThrownItemEntity> entityType;

    public ThrowableTorchItem(Settings settings, EntityType<? extends ThrownItemEntity> entityType) {
        super(settings);
        this.entityType = entityType;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        final ItemStack stack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 1.0F, 1.0F);
        if (!user.isCreative()) {
            stack.decrement(1);
        }
        if (!world.isClient()) {
            final ThrowableTorchEntity entity = new ThrowableTorchEntity(entityType, user, world);
            entity.setItem(stack);
            entity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 0.0F);
            world.spawnEntity(entity);
        }
        return TypedActionResult.success(stack, world.isClient());
    }
}
