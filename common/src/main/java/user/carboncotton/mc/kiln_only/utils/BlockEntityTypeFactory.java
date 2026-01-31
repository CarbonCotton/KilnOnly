package user.carboncotton.mc.kiln_only.utils;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.Arrays;
import java.util.function.Supplier;

@FunctionalInterface
public interface BlockEntityTypeFactory {


    BlockEntityType<? extends BlockEntity> create(
            BlockEntityType.BlockEntitySupplier<? extends BlockEntity> constructor,
            Block[] blocks
    );



    @SafeVarargs
    static Block[] resolveBlocks(Supplier<? extends Block>... blocks) {
        return Arrays.stream(blocks)
            .map(Supplier::get)
            .toArray(Block[]::new);
    }


    @SuppressWarnings("unchecked")
    static <T extends BlockEntity> BlockEntityType<T> safeCreate(
        BlockEntityTypeFactory factory,
        BlockEntityType.BlockEntitySupplier<T> constructor,
        Block[] blocks
    ){
        return (BlockEntityType<T>) factory.create(constructor, blocks);
    }

}