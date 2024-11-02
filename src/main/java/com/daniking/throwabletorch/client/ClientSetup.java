package com.daniking.throwabletorch.client;

import com.daniking.throwabletorch.ObjectRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

@Environment(EnvType.CLIENT)
public class ClientSetup implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        registerRenderers();
    }

    public static void registerRenderers() {
        EntityRendererRegistry.register(ObjectRegistry.THROWABLE_SLIME_TORCH_ENTITY, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ObjectRegistry.THROWABLE_CLAY_TORCH_ENTITY, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ObjectRegistry.THROWABLE_MAGMA_TORCH_ENTITY, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ObjectRegistry.THROWABLE_HONEYCOMB_TORCH_ENTITY, FlyingItemEntityRenderer::new);
    }

}
