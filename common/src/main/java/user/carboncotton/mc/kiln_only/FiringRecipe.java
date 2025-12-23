package user.carboncotton.mc.kiln_only;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.block.Blocks;
import org.intellij.lang.annotations.Identifier;
import org.jetbrains.annotations.NotNull;

public class FiringRecipe extends AbstractCookingRecipe {

    public FiringRecipe(String string, CookingBookCategory cookingBookCategory, Ingredient ingredient, ItemStack itemStack, float f, int i) {
        super(KilnOnlyMod.FIRING_RECIPE_TYPE.get(), string, cookingBookCategory, ingredient, itemStack, f, i);
    }

    @Override
    public @NotNull ItemStack getToastSymbol() {
        // TODO: Add kiln block when it is added
        return new ItemStack(Blocks.BEACON);
    }

    @Override
    public @NotNull RecipeSerializer<?> getSerializer() {
        return KilnOnlyMod.FIRING_RECIPE_SERIALIZER.get();
    }
}
