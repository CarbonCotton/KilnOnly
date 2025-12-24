package user.carboncotton.mc.kiln_only;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SimpleCookingSerializer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import user.carboncotton.mc.kiln_only.content.AllObjects;
import user.carboncotton.mc.kiln_only.content.FiringRecipe;
import user.carboncotton.mc.kiln_only.content.KilnFurnaceBlockEntity;

public final class KilnOnlyMod {
    public static final String MOD_ID = "kiln_only";



    public static void init() {
        AllObjects.init(MOD_ID);
    }
}
