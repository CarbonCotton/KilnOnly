package user.carboncotton.mc.kiln_only.neoforge;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.fml.common.Mod;

import user.carboncotton.mc.kiln_only.KilnOnlyMod;
import user.carboncotton.mc.kiln_only.content.AllObjects;
import user.carboncotton.mc.kiln_only.content.KilnFurnaceBlockEntity;
import user.carboncotton.mc.kiln_only.utils.BlockEntityTypeFactory;


@Mod(KilnOnlyMod.MOD_ID)
public final class KilnOnlyNeoForge {
    public KilnOnlyNeoForge() {
        // Run our common setup.
        KilnOnlyMod.init();


        BlockEntityTypeFactory forgeFactory = new BlockEntityTypeFactory() {
            @Override
            public <T extends BlockEntity> BlockEntityType<T> create(
                    BlockEntityType.BlockEntitySupplier<T> blockEntityConstructor,
                    Block[] entityBlocks
            ) {
                return BlockEntityType.Builder.of(blockEntityConstructor, entityBlocks).build(null);
            }
        };

        AllObjects.registerAllBlockEntities(forgeFactory);
    }
}
