package user.carboncotton.mc.kiln_only.fabric;

import net.fabricmc.api.ModInitializer;

import net.minecraft.world.level.block.entity.BlastFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import user.carboncotton.mc.kiln_only.KilnOnlyMod;
import user.carboncotton.mc.kiln_only.content.AllObjects;
import user.carboncotton.mc.kiln_only.content.KilnFurnaceBlockEntity;

public final class KilnOnlyFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        KilnOnlyMod.init();


        AllObjects.registerKilnFurnaceBlockEntity(
            () -> BlockEntityType.Builder
                .of(KilnFurnaceBlockEntity::new, AllObjects.KILN_FURNACE_BLOCK.get())
                .build()
        );

        AllObjects.writeRegister();
    }
}
