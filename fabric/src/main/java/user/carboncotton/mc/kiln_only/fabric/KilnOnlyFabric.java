package user.carboncotton.mc.kiln_only.fabric;

import net.fabricmc.api.ModInitializer;

import user.carboncotton.mc.kiln_only.KilnOnlyMod;

public final class KilnOnlyFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        KilnOnlyMod.init();


        /*
        KilnOnlyMod.KILN_FURNACE_BLOCK_ENTITY = KilnOnlyMod.BLOCK_ENTITIES.register(
            KilnOnlyMod.MOD_ID,
            () -> BlockEntityType.Builder.of(KilnFurnaceBlockEntity::new, null).build()
        );
        */

    }
}
