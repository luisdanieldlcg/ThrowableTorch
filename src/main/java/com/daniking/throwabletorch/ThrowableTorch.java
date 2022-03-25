package com.daniking.throwabletorch;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThrowableTorch implements ModInitializer {

    public static final String MOD_ID = "throwabletorch";
    public static final Logger LOGGER = LoggerFactory.getLogger(ThrowableTorch.class);

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing...");
        ObjectRegistry.registerItems();
        LOGGER.info("Initialized!");
    }


}


