package user.carboncotton.mc.kiln_only.content;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractFurnaceMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.RecipeBookType;


public class KilnFurnaceMenu extends AbstractFurnaceMenu {

    public KilnFurnaceMenu(int id, Inventory playerInventory) {
        super(AllObjects.KILN_MENU_TYPE.get(), AllObjects.FIRING_RECIPE_TYPE.get(), RecipeBookType.FURNACE, id, playerInventory);
    }

    public KilnFurnaceMenu(int id, Inventory playerInventory, Container container, ContainerData containerData) {
        super(AllObjects.KILN_MENU_TYPE.get(), AllObjects.FIRING_RECIPE_TYPE.get(), RecipeBookType.FURNACE, id, playerInventory, container, containerData);
    }
}


