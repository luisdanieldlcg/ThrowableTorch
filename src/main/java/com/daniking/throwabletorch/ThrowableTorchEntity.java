package com.daniking.throwabletorch;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.WallTorchBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.Packet;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class ThrowableTorchEntity extends ThrownItemEntity {


    public ThrowableTorchEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);

    }

    public ThrowableTorchEntity(EntityType<? extends ThrownItemEntity> entityType, LivingEntity livingEntity, World world) {
        super(entityType, livingEntity, world);
    }

    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket() {
        return super.createSpawnPacket();
    }

    @Override
    protected Item getDefaultItem() {
        return null;
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);
        if (!world.isClient()) {
            final Direction dir = blockHitResult.getSide();
            final BlockPos sidePos = blockHitResult.getBlockPos().offset(dir);
            if (world.getBlockState(sidePos).isAir()) {
                switch (dir) {
                    case UP -> {
                        final BlockState torch = Blocks.TORCH.getDefaultState();
                        if (torch.canPlaceAt(world, sidePos)) {
                            world.setBlockState(sidePos, torch);
                        } else {
                            onFailed();
                        }
                    }
                    case DOWN -> onFailed();
                    default -> {
                        final BlockState state = Blocks.WALL_TORCH.getDefaultState().with(WallTorchBlock.FACING, dir);
                        if (state.canPlaceAt(world, sidePos)) {
                            world.setBlockState(sidePos, state);
                        } else {
                            onFailed();
                        }
                    }
                }
            } else {
                onFailed();
            }
        }
    }

    void onFailed() {
        drop();
    }
    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        super.discard();
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        entityHitResult.getEntity().damage(DamageSource.thrownProjectile(this, this.getOwner()), 1.0F);
        if (getStack().isOf(ObjectRegistry.THROWABLE_MAGMA_TORCH_ITEM)) {
            if (!entityHitResult.getEntity().isFireImmune()) {
                entityHitResult.getEntity().setOnFireFor(5);
            }
        }
        onFailed();
    }

    private void drop() {
        world.spawnEntity(new ItemEntity(world, getX(), getY(), getZ(), new ItemStack(Items.TORCH)));
    }
}
