package net.woyaoqushang.liam_chocolate.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.woyaoqushang.liam_chocolate.MoreChocolateMain;
import net.woyaoqushang.liam_chocolate.block.custom.BlueberryCropBlock;
import net.woyaoqushang.liam_chocolate.block.custom.fertileSoilBlock;
import net.woyaoqushang.liam_chocolate.item.ModCreativeModeTab;
import net.woyaoqushang.liam_chocolate.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MoreChocolateMain.MOD_ID);

    public static final RegistryObject<Block> COFFEE_GROUND = registerBlock(
            "coffee_grounds_block",
            () -> new Block(BlockBehaviour.Properties
                    .of(Material.DIRT)
                    .sound(SoundType.ROOTED_DIRT)
                    .requiresCorrectToolForDrops()
            ),
            ModCreativeModeTab.CHOCOLATE_TAB
    );
    public static final RegistryObject<Block> FERTILE_SOIL_BLOCK = registerBlock(
            "fertile_soil_block",
            () -> new fertileSoilBlock(BlockBehaviour.Properties
                    .of(Material.DIRT)
                    .sound(SoundType.MUD)
                    .requiresCorrectToolForDrops()
            ),
            ModCreativeModeTab.CHOCOLATE_TAB
    );
    public static final RegistryObject<Block> BLUEBERRY_CROP = BLOCKS.register(
            "blueberry_crop",
            () -> new BlueberryCropBlock(BlockBehaviour.Properties
                    .copy(Blocks.WHEAT)
            )
    );



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab)
    {
        return ModItems.ITEMS.register(name,
                () -> new BlockItem(block.get(), new Item.Properties().tab(tab))
                );
    }



    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }


}
