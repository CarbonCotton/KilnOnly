package user.carboncotton.mc.kiln_only.content;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.BlastFurnaceBlock;
import net.minecraft.world.level.block.FurnaceBlock;
import net.minecraft.world.level.block.SmokerBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class KilnFurnaceBlock extends AbstractFurnaceBlock {

    public static final MapCodec<KilnFurnaceBlock> CODEC = simpleCodec(KilnFurnaceBlock::new);

    public MapCodec<KilnFurnaceBlock> codec() {
        return CODEC;
    }

    public KilnFurnaceBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new KilnFurnaceBlockEntity(blockPos, blockState);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> blockEntityType) {
        return createFurnaceTicker(level, blockEntityType, AllObjects.KILN_FURNACE_BLOCK_ENTITY.get());
    }


    protected void openContainer(Level level, BlockPos blockPos, Player player) {
        BlockEntity blockEntity = level.getBlockEntity(blockPos);
        if (blockEntity instanceof KilnFurnaceBlockEntity) {
            player.openMenu((MenuProvider)blockEntity);


            player.awardStat(AllObjects.INTERACT_WITH_KILN.get());
        }
    }

    public void animateTick(BlockState blockState, Level level, BlockPos blockPos, RandomSource random) {
        if ((Boolean)blockState.getValue(LIT)) {
            // fetch coordinates
            double x = blockPos.getX();
            double y = blockPos.getY();
            double z = blockPos.getZ();

            // play sound
            if (random.nextDouble() < 0.1) {
                level.playLocalSound(x, y, z, AllObjects.KILN_FIRING_SOUND.get(), SoundSource.BLOCKS, 1.0F, 1.0F, false);
            }


            // create specific cords for front and top particles
            double topX = (x + 0.5) + (random.nextDouble() * 0.25 - 0.125);
            double topY = (y + 1.1);
            double topZ = (z + 0.5) + (random.nextDouble() * 0.25 - 0.125);

            double frontX = (x + 0.5) + (random.nextDouble() * 0.4 - 0.2);
            double frontY = (y + 0.2);
            double frontZ = (z + 0.0);


            // generate said particles

            level.addParticle(ParticleTypes.FLAME, frontX, frontY, frontZ, 0.0, 0.0, 0.0);
            if (random.nextDouble() < 0.5) {
                level.addParticle(ParticleTypes.FLAME, topX, topY, topZ, 0.0, 0.0, 0.0);
            }
        }
    }
}
