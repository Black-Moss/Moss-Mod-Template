package com.blackmoss.averylooongmodname;

import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

@Mod(AVeryLooongModName.MODID)
public class AVeryLooongModName {
    public static final String MODID = "averylooongmodname";
    public static final Logger LOGGER = LogUtils.getLogger();

    public AVeryLooongModName(IEventBus modEventBus, ModContainer modContainer) {
    }

    public static ResourceLocation identifier(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }
}
