package com.daniking.throwabletorch.client.integration;

import com.daniking.throwabletorch.ObjectRegistry;
import com.daniking.throwabletorch.ThrowableTorchEntity;
import dev.lambdaurora.lambdynlights.api.DynamicLightHandler;
import dev.lambdaurora.lambdynlights.api.DynamicLightHandlers;
import dev.lambdaurora.lambdynlights.api.DynamicLightsInitializer;
import dev.lambdaurora.lambdynlights.api.item.ItemLightSourceManager;
import net.minecraft.entity.EntityType;

public class ThrowableTorchDynLightsInitializer implements DynamicLightsInitializer {

    @Override
    public void onInitializeDynamicLights(ItemLightSourceManager itemLightSourceManager) {
        registerHandler(ObjectRegistry.THROWABLE_SLIME_TORCH_ENTITY);
        registerHandler(ObjectRegistry.THROWABLE_CLAY_TORCH_ENTITY);
        registerHandler(ObjectRegistry.THROWABLE_MAGMA_TORCH_ENTITY);
        registerHandler(ObjectRegistry.THROWABLE_HONEYCOMB_TORCH_ENTITY);
    }

    static void registerHandler(EntityType<ThrowableTorchEntity> type) {
        DynamicLightHandlers.registerDynamicLightHandler(type, DynamicLightHandler.makeHandler(luminance -> 14, waterSensitive -> true));
    }
}
