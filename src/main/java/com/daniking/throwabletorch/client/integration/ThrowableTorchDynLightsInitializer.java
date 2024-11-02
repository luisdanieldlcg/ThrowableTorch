package com.daniking.throwabletorch.client.integration;

import com.daniking.throwabletorch.ObjectRegistry;
import com.daniking.throwabletorch.ThrowableTorch;
import com.daniking.throwabletorch.ThrowableTorchEntity;
import dev.lambdaurora.lambdynlights.api.DynamicLightHandler;
import dev.lambdaurora.lambdynlights.api.DynamicLightHandlers;
import dev.lambdaurora.lambdynlights.api.DynamicLightsInitializer;
import dev.lambdaurora.lambdynlights.api.item.ItemLightSource;
import dev.lambdaurora.lambdynlights.api.item.ItemLightSourceManager;
import net.minecraft.entity.EntityType;

public class ThrowableTorchDynLightsInitializer implements DynamicLightsInitializer {

    public static final int TORCH_LUMINANCE = 14;
//    public static final ItemLightSource THROWABLE_SLIME_TORCH_LIGHT_SOURCE = createLightSource("throwable_slime_torch", ObjectRegistry.THROWABLE_SLIME_TORCH_ITEM);
//    public static final ItemLightSource THROWABLE_CLAY_TORCH_LIGHT_SOURCE = createLightSource("throwable_clay_torch", ObjectRegistry.THROWABLE_CLAY_TORCH_ITEM);
//    public static final ItemLightSource THROWABLE_MAGMA_TORCH_LIGHT_SOURCE = createLightSource("throwable_magma_torch", ObjectRegistry.THROWABLE_MAGMA_TORCH_ITEM);
//    public static final ItemLightSource THROWABLE_HONEYCOMB_TORCH_LIGHT_SOURCE = createLightSource("throwable_honeycomb_torch", ObjectRegistry.THROWABLE_HONEYCOMB_TORCH_ITEM);

    @Override
    public void onInitializeDynamicLights(ItemLightSourceManager itemLightSourceManager) {
        registerHandler(ObjectRegistry.THROWABLE_SLIME_TORCH_ENTITY);
        registerHandler(ObjectRegistry.THROWABLE_CLAY_TORCH_ENTITY);
        registerHandler(ObjectRegistry.THROWABLE_MAGMA_TORCH_ENTITY);
        registerHandler(ObjectRegistry.THROWABLE_HONEYCOMB_TORCH_ENTITY);
//        DynamicLightHandlers.registerDynamicLightHandler();
//        ItemLightSources.registerItemLightSource(THROWABLE_SLIME_TORCH_LIGHT_SOURCE);
//        ItemLightSources.registerItemLightSource(THROWABLE_CLAY_TORCH_LIGHT_SOURCE);
//        ItemLightSources.registerItemLightSource(THROWABLE_MAGMA_TORCH_LIGHT_SOURCE);
//        ItemLightSources.registerItemLightSource(THROWABLE_HONEYCOMB_TORCH_LIGHT_SOURCE);
    }
    static void registerHandler(EntityType<ThrowableTorchEntity> type) {
        DynamicLightHandlers.registerDynamicLightHandler(type, new DynamicLightHandler<>() {
            @Override
            public int getLuminance(ThrowableTorchEntity lightSource) {
                return TORCH_LUMINANCE;
            }
            @Override
            public boolean isWaterSensitive(ThrowableTorchEntity lightSource) {
                return true;
            }
        });
    }

//    static ItemLightSource createLightSource(String path, Item item) {
//        return new ItemLightSource.StaticItemLightSource(Identifier.of(ThrowableTorch.MOD_ID, path), item, TORCH_LUMINANCE, true);
//    }


}
