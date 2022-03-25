package com.daniking.throwabletorch;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ObjectRegistry {
    // Entities
    public static final EntityType<ThrowableTorchEntity> THROWABLE_SLIME_TORCH_ENTITY = registerThrowableTorch("throwable_slime_torch");
    public static final EntityType<ThrowableTorchEntity> THROWABLE_CLAY_TORCH_ENTITY = registerThrowableTorch("throwable_clay_torch");
    public static final EntityType<ThrowableTorchEntity> THROWABLE_MAGMA_TORCH_ENTITY = registerThrowableTorch("throwable_magma_torch");
    public static final EntityType<ThrowableTorchEntity> THROWABLE_HONEYCOMB_TORCH_ENTITY = registerThrowableTorch("throwable_honeycomb_torch");
    // Items
    public static final Item THROWABLE_SLIME_TORCH_ITEM = new ThrowableTorchItem(new Item.Settings().group(ItemGroup.DECORATIONS), THROWABLE_SLIME_TORCH_ENTITY);
    public static final Item THROWABLE_CLAY_TORCH_ITEM = new ThrowableTorchItem(new Item.Settings().group(ItemGroup.DECORATIONS), THROWABLE_CLAY_TORCH_ENTITY);
    public static final Item THROWABLE_MAGMA_TORCH_ITEM = new ThrowableTorchItem(new Item.Settings().group(ItemGroup.DECORATIONS), THROWABLE_MAGMA_TORCH_ENTITY);
    public static final Item THROWABLE_HONEYCOMB_TORCH_ITEM = new ThrowableTorchItem(new Item.Settings().group(ItemGroup.DECORATIONS), THROWABLE_HONEYCOMB_TORCH_ENTITY);

    private static EntityType<ThrowableTorchEntity> registerThrowableTorch(final String id) {
        return Registry.register(Registry.ENTITY_TYPE, new Identifier(ThrowableTorch.MOD_ID, id),
                FabricEntityTypeBuilder.<ThrowableTorchEntity>create(SpawnGroup.MISC, ThrowableTorchEntity::new)
                .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                .trackRangeBlocks(4)
                .trackedUpdateRate(10)
                .build());
    }

    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier(ThrowableTorch.MOD_ID, "throwable_slime_torch"), THROWABLE_SLIME_TORCH_ITEM);
        Registry.register(Registry.ITEM, new Identifier(ThrowableTorch.MOD_ID, "throwable_clay_torch"), THROWABLE_CLAY_TORCH_ITEM);
        Registry.register(Registry.ITEM, new Identifier(ThrowableTorch.MOD_ID, "throwable_magma_torch"), THROWABLE_MAGMA_TORCH_ITEM);
        Registry.register(Registry.ITEM, new Identifier(ThrowableTorch.MOD_ID, "throwable_honeycomb_torch"), THROWABLE_HONEYCOMB_TORCH_ITEM);
    }

    @Environment(EnvType.CLIENT)
    public static void registerRenderers() {
        EntityRendererRegistry.register(THROWABLE_SLIME_TORCH_ENTITY, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(THROWABLE_CLAY_TORCH_ENTITY, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(THROWABLE_MAGMA_TORCH_ENTITY, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(THROWABLE_HONEYCOMB_TORCH_ENTITY, FlyingItemEntityRenderer::new);
    }

}
