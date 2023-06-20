package com.kneelawk.lmpcompat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class LMPCompatMod implements ModInitializer {
    public static final String MOD_ID = "lmp-compat";
    public static final String MOD_VERSION =
        FabricLoader.getInstance().getModContainer(MOD_ID).get().getMetadata().getVersion().getFriendlyString();
    public static final Logger LOG = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOG.info("LMPCompat {} Loading...", MOD_VERSION);

        if (FabricLoader.getInstance().isModLoaded("create")) {
            LOG.info("LMPCompat Loading Create-LMP compatibility");
        }
    }
}
