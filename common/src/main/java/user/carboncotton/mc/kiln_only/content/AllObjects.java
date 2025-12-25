package user.carboncotton.mc.kiln_only.content;

import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SimpleCookingSerializer;
import net.minecraft.world.level.block.BlastFurnaceBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FurnaceBlock;
import net.minecraft.world.level.block.entity.BlastFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import user.carboncotton.mc.kiln_only.KilnOnlyMod;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public class AllObjects {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(
        KilnOnlyMod.MOD_ID,
        Registries.BLOCK
    );

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(
        KilnOnlyMod.MOD_ID,
        Registries.ITEM
    );


    private static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(
        KilnOnlyMod.MOD_ID,
        Registries.RECIPE_TYPE
    );

    private static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(
        KilnOnlyMod.MOD_ID,
        Registries.RECIPE_SERIALIZER
    );

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(
        KilnOnlyMod.MOD_ID,
        Registries.BLOCK_ENTITY_TYPE
    );

    private static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(
        KilnOnlyMod.MOD_ID,
        Registries.CREATIVE_MODE_TAB
    );

    public static RegistrySupplier<CreativeModeTab> KILN_ONLY_TAB;

    public static RegistrySupplier<Block> KILN_FURNACE_BLOCK;
    public static RegistrySupplier<Item> KILN_FURNACE_BLOCKITEM;

    public static RegistrySupplier<BlockEntityType<KilnFurnaceBlockEntity>> KILN_FURNACE_BLOCK_ENTITY;

    public static RegistrySupplier<RecipeType<FiringRecipe>> FIRING_RECIPE_TYPE;
    public static RegistrySupplier<RecipeSerializer<FiringRecipe>> FIRING_RECIPE_SERIALIZER;


    public static <T extends BlockEntityType<?>> RegistrySupplier<T> registerBlockEntity(String name, Supplier<T> blockEntity){
        return BLOCK_ENTITIES.register(name, blockEntity);
    };


    public static void registerKilnFurnaceBlockEntity(Supplier<BlockEntityType<KilnFurnaceBlockEntity>> blockEntity) {
        KILN_FURNACE_BLOCK_ENTITY = BLOCK_ENTITIES.register("kiln", blockEntity);
    }

    public static Block getRawKilnFurnaceBlock() {
        return KILN_FURNACE_BLOCK.get();
    }

    public static void writeRegister() {
        BLOCK_ENTITIES.register();
    }

    public static void init(String modId) {
        final String kilnId = "kiln";


        KILN_ONLY_TAB = TABS.register(
        "kiln_only_tab",
            () -> CreativeTabRegistry.create(
                Component.translatable("kiln_only.itemGroup.main_tab"),
                () -> new ItemStack(KILN_FURNACE_BLOCKITEM)
            )
        );

        KILN_FURNACE_BLOCK = BLOCKS.register(
            kilnId,
            () -> new KilnFurnaceBlock(
                BlockBehaviour.Properties.ofFullCopy(Blocks.FURNACE)
            )
        );

        KILN_FURNACE_BLOCKITEM = ITEMS.register(
            kilnId,
            () -> new BlockItem( KILN_FURNACE_BLOCK.get(), new Item.Properties().arch$tab(KILN_ONLY_TAB) )
        );

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

        TABS.register();
        BLOCKS.register();
        ITEMS.register();
        RECIPE_TYPES.register();
        RECIPE_SERIALIZERS.register();
    }


}
