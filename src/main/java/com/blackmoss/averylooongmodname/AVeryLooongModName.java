package com.blackmoss.averylooongmodname;

import com.blackmoss.averylooongmodname.data.ModBlockLootSubProvider;
import com.blackmoss.averylooongmodname.data.ModRecipeProvider;
import com.blackmoss.averylooongmodname.data.lang.EnUsProvider;
import com.blackmoss.averylooongmodname.data.lang.ZhCnProvider;
import com.blackmoss.averylooongmodname.data.lang.ZhTwProvider;
import com.blackmoss.averylooongmodname.data.tag.ModBlockTagsProvider;
import com.blackmoss.averylooongmodname.data.tag.ModItemTagsProvider;
import com.blackmoss.averylooongmodname.registry.ALMNBlocks;
import com.mojang.logging.LogUtils;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.slf4j.Logger;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = AVeryLooongModName.MODID)
@Mod(AVeryLooongModName.MODID)
public class AVeryLooongModName {
    public static final String MODID = "averylooongmodname";
    public static final Logger LOGGER = LogUtils.getLogger();

    public AVeryLooongModName(IEventBus modEventBus, ModContainer modContainer) {
        ALMNBlocks.BLOCKS.register(modEventBus);
    }

    public static ResourceLocation identifier(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }

    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper helper = event.getExistingFileHelper();
        RegistrySetBuilder registrySetBuilder = new RegistrySetBuilder();
        DatapackBuiltinEntriesProvider datapackProvider = new DatapackBuiltinEntriesProvider(output, event.getLookupProvider(), registrySetBuilder, Set.of(AVeryLooongModName.MODID));
        CompletableFuture<HolderLookup.Provider> lookupProvider = datapackProvider.getRegistryProvider();

        event.createProvider(EnUsProvider::new);
        event.createProvider(ZhCnProvider::new);
        event.createProvider(ZhTwProvider::new);

        event.createProvider(ModRecipeProvider::new);

        ModBlockTagsProvider blockTags = new ModBlockTagsProvider(output, lookupProvider, helper);
        generator.addProvider(event.includeServer(), blockTags);
        generator.addProvider(event.includeServer(), new ModItemTagsProvider(output, lookupProvider, blockTags.contentsGetter(), helper));
        generator.addProvider(event.includeServer(), new LootTableProvider(output, Collections.emptySet(), List.of(
                new LootTableProvider.SubProviderEntry(ModBlockLootSubProvider::new, LootContextParamSets.BLOCK)
        ), lookupProvider));
    }
}
