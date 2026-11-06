package com.blackmoss.averylooongmodname.data.tag;

import com.blackmoss.averylooongmodname.AVeryLooongModName;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ItemTagsProvider;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public final class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(
            PackOutput output,
            CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, AVeryLooongModName.MODID);
    }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider provider) {
    }

    @Override
    public @NonNull String getName() {
        return "XXX Item Tags";
    }
}
