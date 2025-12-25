package user.carboncotton.mc.kiln_only.content;

import com.mojang.datafixers.TypeRewriteRule;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BlastFurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import user.carboncotton.mc.kiln_only.KilnOnlyMod;

public class KilnFurnaceBlockEntity extends AbstractFurnaceBlockEntity {

    public KilnFurnaceBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(AllObjects.KILN_FURNACE_BLOCK_ENTITY.get(), blockPos, blockState, AllObjects.FIRING_RECIPE_TYPE.get());
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("container.kiln_only.kiln_furnace");
    }

    @Override
    protected int getBurnDuration(ItemStack itemStack) {
        return super.getBurnDuration(itemStack) / 2;
    }

    @Override
    protected @NotNull AbstractContainerMenu createMenu(int id, Inventory inventory) {
        return new KilnFurnaceMenu(id, inventory, this, this.dataAccess);
    }
}
