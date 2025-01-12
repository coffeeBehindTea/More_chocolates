package net.woyaoqushang.liam_chocolate.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.woyaoqushang.liam_chocolate.MoreChocolateMain;
import net.woyaoqushang.liam_chocolate.item.ModItems;
import net.woyaoqushang.liam_chocolate.villager.ModVillagers;

import java.util.List;

@Mod.EventBusSubscriber(modid = MoreChocolateMain.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event)
    {
        if (event.getType() == VillagerProfession.ARMORER)
        {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.BLUEBERRY.get(), 1);
            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader,rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 3),stack, 10, 8, 0.02F));
        }

        if (event.getType() == ModVillagers.COFFEE_MASTER.get())
        {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.BLUEBERRY.get(), 1);
            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader,rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 3), stack, 10, 8, 0.02F));
        }

    }

}
