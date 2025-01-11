package net.woyaoqushang.liam_chocolate.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab CHOCOLATE_TAB = new CreativeModeTab("liam_chocolate_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.BLACK_CHOCOLATE.get());
        }
    };
}
