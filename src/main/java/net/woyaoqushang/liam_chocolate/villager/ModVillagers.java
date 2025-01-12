package net.woyaoqushang.liam_chocolate.villager;

import com.google.common.collect.ImmutableSet;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.woyaoqushang.liam_chocolate.MoreChocolateMain;
import net.woyaoqushang.liam_chocolate.block.ModBlocks;

import java.lang.reflect.InvocationTargetException;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, MoreChocolateMain.MOD_ID);

    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, MoreChocolateMain.MOD_ID);

    public static final RegistryObject<PoiType> COFFEE_GROUNDS_BLOCK_POI = POI_TYPES.register(
            "coffee_grounds_block_poi",
            () -> new PoiType(ImmutableSet.copyOf(
                    ModBlocks.COFFEE_GROUND_BLOCK.get().getStateDefinition().getPossibleStates()
            ), 1, 1)
    );

    public static final RegistryObject<VillagerProfession> COFFEE_MASTER =
            VILLAGER_PROFESSIONS.register(
                    "coffee_master",
                    () -> new VillagerProfession(
                            "coffee_master",
                            x -> x.get() == COFFEE_GROUNDS_BLOCK_POI.get(),
                            x -> x.get() == COFFEE_GROUNDS_BLOCK_POI.get(),
                            ImmutableSet.of(),
                            ImmutableSet.of(),
                            SoundEvents.VILLAGER_WORK_LIBRARIAN
                    )
            );


    public static void registerPOIS()
    {
        try
        {
            ObfuscationReflectionHelper.findMethod(PoiType.class, "registerBlockStates", PoiType.class)
                    .invoke(null, COFFEE_GROUNDS_BLOCK_POI.get());
        }
        catch (InvocationTargetException | IllegalAccessException exception)
        {
            exception.printStackTrace();
        }
    }


    public static void register(IEventBus eventBus)
    {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }

}
