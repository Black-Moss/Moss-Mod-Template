package com.blackmoss.averylooongmodname.data;

import com.blackmoss.averylooongmodname.registry.ALMNBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import org.jspecify.annotations.NonNull;

import java.util.Set;

public class ModBlockLootSubProvider extends BlockLootSubProvider {
    public ModBlockLootSubProvider(HolderLookup.Provider lookupProvider) {
        super(Set.of(), FeatureFlags.DEFAULT_FLAGS, lookupProvider);
    }

    @Override
    protected @NonNull Iterable<Block> getKnownBlocks() {
        return ALMNBlocks.BLOCKS.getEntries().stream().map(holder -> (Block) holder.value()).toList();
    }

    @Override
    protected void generate() {
    }
}
