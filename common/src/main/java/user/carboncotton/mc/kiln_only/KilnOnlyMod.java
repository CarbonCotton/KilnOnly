package user.carboncotton.mc.kiln_only;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SimpleCookingSerializer;
import net.minecraft.world.level.block.entity.BlastFurnaceBlockEntity;

public final class KilnOnlyMod {
    public static final String MOD_ID = "kiln_only";

    private static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(
            KilnOnlyMod.MOD_ID,
            Registries.RECIPE_TYPE
    );

    private static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(
            KilnOnlyMod.MOD_ID,
            Registries.RECIPE_SERIALIZER
    );


    public static RegistrySupplier<RecipeType<FiringRecipe>> FIRING_RECIPE_TYPE;
    public static RegistrySupplier<RecipeSerializer<FiringRecipe>> FIRING_RECIPE_SERIALIZER;


    public static void init() {
        // Write common init code here.

        FIRING_RECIPE_TYPE = RECIPE_TYPES.register(
        "firing",
            () -> new RecipeType<FiringRecipe>() {
                @Override
                public String toString() { return "firing"; }
            }
        );

        FIRING_RECIPE_SERIALIZER = RECIPE_SERIALIZERS.register(
        "firing",
            () -> new SimpleCookingSerializer<FiringRecipe>(FiringRecipe::new, 100)
        );

        RECIPE_TYPES.register();
        RECIPE_SERIALIZERS.register();
    }
}
