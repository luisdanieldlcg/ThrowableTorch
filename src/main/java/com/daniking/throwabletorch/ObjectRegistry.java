package com.daniking.throwabletorch;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ObjectRegistry {
    // Entities
    public static final EntityType<ThrowableTorchEntity> THROWABLE_SLIME_TORCH_ENTITY = registerThrowableTorch("throwable_slime_torch");
    public static final EntityType<ThrowableTorchEntity> THROWABLE_CLAY_TORCH_ENTITY = registerThrowableTorch("throwable_clay_torch");
    public static final EntityType<ThrowableTorchEntity> THROWABLE_MAGMA_TORCH_ENTITY = registerThrowableTorch("throwable_magma_torch");
    public static final EntityType<ThrowableTorchEntity> THROWABLE_HONEYCOMB_TORCH_ENTITY = registerThrowableTorch("throwable_honeycomb_torch");

    private static final RegistryKey<Item> SLIME_TORCH_REGISTRY_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ThrowableTorch.MOD_ID, "throwable_slime_torch"));
    private static final RegistryKey<Item> CLAY_TORCH_REGISTRY_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ThrowableTorch.MOD_ID, "throwable_clay_torch"));
    private static final RegistryKey<Item> MAGMA_TORCH_REGISTRY_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ThrowableTorch.MOD_ID, "throwable_magma_torch"));
    private static final RegistryKey<Item> HONEYCOMB_TORCH_REGISTRY_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ThrowableTorch.MOD_ID, "throwable_honeycomb_torch"));

    // Items
    public static final Item THROWABLE_SLIME_TORCH_ITEM = new ThrowableTorchItem(new Item.Settings().registryKey(SLIME_TORCH_REGISTRY_KEY), THROWABLE_SLIME_TORCH_ENTITY);
    public static final Item THROWABLE_CLAY_TORCH_ITEM = new ThrowableTorchItem(new Item.Settings().registryKey(CLAY_TORCH_REGISTRY_KEY), THROWABLE_CLAY_TORCH_ENTITY);
    public static final Item THROWABLE_MAGMA_TORCH_ITEM = new ThrowableTorchItem(new Item.Settings().registryKey(MAGMA_TORCH_REGISTRY_KEY), THROWABLE_MAGMA_TORCH_ENTITY);
    public static final Item THROWABLE_HONEYCOMB_TORCH_ITEM = new ThrowableTorchItem(new Item.Settings().registryKey(HONEYCOMB_TORCH_REGISTRY_KEY), THROWABLE_HONEYCOMB_TORCH_ENTITY);

    private static EntityType<ThrowableTorchEntity> registerThrowableTorch(final String id) {
        return Registry.register(Registries.ENTITY_TYPE, Identifier.of(ThrowableTorch.MOD_ID, id),
                EntityType.Builder.<ThrowableTorchEntity>create(ThrowableTorchEntity::new, SpawnGroup.MISC)
                        .dimensions(0.25F, 0.25F)
                        .maxTrackingRange(4)
                        .trackingTickInterval(10)
                        .build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(ThrowableTorch.MOD_ID, id)))
        );

    }

    public static void registerItems() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> entries.add(THROWABLE_SLIME_TORCH_ITEM));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> entries.add(THROWABLE_CLAY_TORCH_ITEM));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> entries.add(THROWABLE_MAGMA_TORCH_ITEM));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> entries.add(THROWABLE_HONEYCOMB_TORCH_ITEM));

        Registry.register(Registries.ITEM, SLIME_TORCH_REGISTRY_KEY, THROWABLE_SLIME_TORCH_ITEM);
        Registry.register(Registries.ITEM, CLAY_TORCH_REGISTRY_KEY, THROWABLE_CLAY_TORCH_ITEM);
        Registry.register(Registries.ITEM, MAGMA_TORCH_REGISTRY_KEY, THROWABLE_MAGMA_TORCH_ITEM);
        Registry.register(Registries.ITEM, HONEYCOMB_TORCH_REGISTRY_KEY, THROWABLE_HONEYCOMB_TORCH_ITEM);
    }
}
