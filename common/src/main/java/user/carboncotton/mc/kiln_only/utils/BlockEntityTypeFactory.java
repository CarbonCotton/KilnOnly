package user.carboncotton.mc.kiln_only.utils;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.Arrays;
import java.util.function.Supplier;

@FunctionalInterface
public interface BlockEntityTypeFactory {

    <T extends BlockEntity> BlockEntityType<T> create(
        BlockEntityType.BlockEntitySupplier<T> blockEntityConstructor,
        Block[] entityBlocks
    );



    @SafeVarargs
    static Block[] resolveBlocks(Supplier<? extends Block>... blocks) {
        return Arrays.stream(blocks)
            .map(Supplier::get)
            .toArray(Block[]::new);
    }

}


/*
BlockEntityTypeFactory fabricFactory = new BlockEntityTypeFactory() {
    @Override
    public <T extends BlockEntity> BlockEntityType<T> create(
            BlockEntityType.BlockEntitySupplier<T> blockEntityConstructor,
            Block[] entityBlocks
    ) {
        return BlockEntityType.Builder.of(blockEntityConstructor, entityBlocks).build(null);
    }
};


BlockEntityTypeFactory forgeFactory = new BlockEntityTypeFactory() {
    @Override
    public <T extends BlockEntity> BlockEntityType<T> create(
            BlockEntityType.BlockEntitySupplier<T> blockEntityConstructor,
            Block[] entityBlocks
    ) {
        return BlockEntityType.Builder.of(blockEntityConstructor, entityBlocks).build(null);
    }
};
*/