package com.blackmoss.averylooongmodname.data;

import com.blackmoss.averylooongmodname.AVeryLooongModName;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.data.PackOutput;
import org.jspecify.annotations.NonNull;

public class ModModelProvider extends ModelProvider {
    public ModModelProvider(PackOutput output) {
        super(output, AVeryLooongModName.MODID);
    }

    @Override
    protected void registerModels(@NonNull BlockModelGenerators blockModels, @NonNull ItemModelGenerators itemModels) {
    }

    @Override
    public @NonNull String getName() {
        return "XXX Models";
    }
}
