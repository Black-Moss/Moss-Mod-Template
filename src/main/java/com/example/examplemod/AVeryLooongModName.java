package com.example.examplemod;

import com.mojang.logging.LogUtils;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(AVeryLooongModName.MODID)
public class AVeryLooongModName {
    public static final String MODID = "averylooongmodname";
    private static final Logger LOGGER = LogUtils.getLogger();

    public AVeryLooongModName(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();
    }
}
