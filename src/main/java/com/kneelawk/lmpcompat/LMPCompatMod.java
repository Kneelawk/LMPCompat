package com.kneelawk.lmpcompat;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LMPCompatMod implements ModInitializer {
    public static final String MOD_ID = "lmp-compat";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOG.info("LMPCompat Loading...");

        if (FabricLoader.getInstance().isModLoaded("create")) {
            LOG.info("LMPCompat Loading Create-LMP compatibility");
        }
    }
}
