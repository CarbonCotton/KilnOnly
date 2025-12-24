package user.carboncotton.mc.kiln_only.neoforge;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.fml.common.Mod;

import user.carboncotton.mc.kiln_only.KilnOnlyMod;
import user.carboncotton.mc.kiln_only.content.AllObjects;
import user.carboncotton.mc.kiln_only.content.KilnFurnaceBlockEntity;


@Mod(KilnOnlyMod.MOD_ID)
public final class KilnOnlyNeoForge {
    public KilnOnlyNeoForge() {
        // Run our common setup.
        KilnOnlyMod.init();




        AllObjects.registerKilnFurnaceBlockEntity(
                () -> BlockEntityType.Builder.of(
                    KilnFurnaceBlockEntity::new,
                    AllObjects.getRawKilnFurnaceBlock()
                ).build(null)
        );

        AllObjects.writeRegister();
    }
}
