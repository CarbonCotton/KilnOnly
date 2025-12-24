package user.carboncotton.mc.kiln_only;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.BlastingRecipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BlastFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class KilnFurnaceBlockEntity extends AbstractFurnaceBlockEntity {

    protected KilnFurnaceBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(KilnOnlyMod.KILN_FURNACE_BLOCK_ENTITY.get(), blockPos, blockState, KilnOnlyMod.FIRING_RECIPE_TYPE.get());
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("kiln_only.container.kiln_furnace");
    }

    @Override
    protected int getBurnDuration(ItemStack itemStack) {
        return super.getBurnDuration(itemStack) / 2;
    }

    @Override
    protected AbstractContainerMenu createMenu(int i, Inventory inventory) {
        return null;
    }
}
