package net.woyaoqushang.liam_chocolate.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.woyaoqushang.liam_chocolate.MoreChocolateMain;
import net.woyaoqushang.liam_chocolate.block.ModBlocks;
import net.woyaoqushang.liam_chocolate.item.custom.diceItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MoreChocolateMain.MOD_ID);


    public static final RegistryObject<Item> BLACK_CHOCOLATE = ITEMS.register("black_chocolate",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHOCOLATE_TAB).food(Foods.BLACK_CHOCOLATE)));

    public static final RegistryObject<Item> COFFEE_GROUNDS = ITEMS.register("coffee_grounds",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHOCOLATE_TAB)));

    public static final RegistryObject<Item> DICE = ITEMS.register("dice",
            () -> new diceItem(new Item.Properties()
                    .tab(ModCreativeModeTab.CHOCOLATE_TAB)
                    .stacksTo(1)
            ));
    public static final RegistryObject<Item> BLUEBERRY_SEEDS = ITEMS.register("blueberry_seeds",
            () -> new ItemNameBlockItem(ModBlocks.BLUEBERRY_CROP.get(),
                    new Item.Properties()
                    .tab(ModCreativeModeTab.CHOCOLATE_TAB)
            ));

    public static final RegistryObject<Item> BLUEBERRY = ITEMS.register("blueberry",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CHOCOLATE_TAB).food(Foods.BLUEBERRY_FOOD)));


    public static class Foods
    {
        public static final FoodProperties BLACK_CHOCOLATE = new FoodProperties.Builder()
                .nutrition(10)
                .saturationMod(1.0f)
                .build();

        public static final FoodProperties BLUEBERRY_FOOD = new FoodProperties.Builder()
                .nutrition(2)
                .saturationMod(0.1f)
                .fast()
                .build();
    }

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }

}
