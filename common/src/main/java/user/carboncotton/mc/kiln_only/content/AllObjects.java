package user.carboncotton.mc.kiln_only.content;

import dev.architectury.event.events.client.ClientLifecycleEvent;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.menu.MenuRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.client.gui.screens.inventory.BlastFurnaceScreen;
import net.minecraft.client.gui.screens.inventory.FurnaceScreen;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.stats.StatFormatter;
import net.minecraft.stats.Stats;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.inventory.MenuType;
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
import user.carboncotton.mc.kiln_only.content.client.KilnFurnaceScreen;
import user.carboncotton.mc.kiln_only.utils.BlockEntityTypeFactory;

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

    private static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(
        KilnOnlyMod.MOD_ID,
        Registries.MENU
    );

    private static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(
        KilnOnlyMod.MOD_ID,
        Registries.SOUND_EVENT
    );

    private static final DeferredRegister<ResourceLocation> STATISTICS = DeferredRegister.create(
        KilnOnlyMod.MOD_ID,
        Registries.CUSTOM_STAT
    );



    public static RegistrySupplier<CreativeModeTab> KILN_ONLY_TAB;

    public static RegistrySupplier<Block> KILN_FURNACE_BLOCK;
    public static RegistrySupplier<Item> KILN_FURNACE_BLOCKITEM;

    public static RegistrySupplier<BlockEntityType<KilnFurnaceBlockEntity>> KILN_FURNACE_BLOCK_ENTITY;

    public static RegistrySupplier<RecipeType<FiringRecipe>> FIRING_RECIPE_TYPE;
    public static RegistrySupplier<RecipeSerializer<FiringRecipe>> FIRING_RECIPE_SERIALIZER;

    public static RegistrySupplier<MenuType<KilnFurnaceMenu>> KILN_MENU_TYPE;

    public static RegistrySupplier<SoundEvent> KILN_FIRING_SOUND;

    public static RegistrySupplier<ResourceLocation> INTERACT_WITH_KILN;



    public static void registerAllBlockEntities(BlockEntityTypeFactory factory) {

        KILN_FURNACE_BLOCK_ENTITY = BLOCK_ENTITIES.register("kiln", () -> {
            return factory.create(
                KilnFurnaceBlockEntity::new,
                BlockEntityTypeFactory.resolveBlocks(KILN_FURNACE_BLOCK)
            );
        });

        BLOCK_ENTITIES.register();
    }



    public static MenuType<KilnFurnaceMenu> getRawKilnMenuType() {
        return KILN_MENU_TYPE.get();
    }


    public static void init() {
        final String kilnId = "kiln";



        KILN_ONLY_TAB = TABS.register(
        "kiln_only_tab",
            () -> CreativeTabRegistry.create(
                Component.translatable("itemGroup.kiln_only.main_tab"),
                () -> new ItemStack(KILN_FURNACE_BLOCKITEM.get())
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


        KILN_MENU_TYPE = MENU_TYPES.register(
        "kiln_menu",
           () -> new MenuType<>(KilnFurnaceMenu::new, FeatureFlagSet.of())
        );

        KILN_FIRING_SOUND = SOUNDS.register(
        "block.kiln.fire",
           () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(KilnOnlyMod.MOD_ID, "block.kiln.fire"))
        );

        INTERACT_WITH_KILN = STATISTICS.register(
         "interact_with_kiln",
            () -> ResourceLocation.fromNamespaceAndPath(KilnOnlyMod.MOD_ID, "interact_with_kiln")
        );




        TABS.register();
        BLOCKS.register();
        ITEMS.register();
        RECIPE_TYPES.register();
        RECIPE_SERIALIZERS.register();
        MENU_TYPES.register();
        SOUNDS.register();
        STATISTICS.register();

        Stats.CUSTOM.get(INTERACT_WITH_KILN.get(), StatFormatter.DEFAULT);

        ClientLifecycleEvent.CLIENT_STARTED.register(client -> {
            MenuRegistry.registerScreenFactory(
                    AllObjects.KILN_MENU_TYPE.get(),
                    KilnFurnaceScreen::new
            );
        });
    }


}
