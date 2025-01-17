package net.woyaoqushang.liam_chocolate.painting;

import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.woyaoqushang.liam_chocolate.MoreChocolateMain;

public class ModPaintings {
    public static final DeferredRegister<PaintingVariant> PAINTING_VARIANTS =
            DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, MoreChocolateMain.MOD_ID);

    public static final RegistryObject<PaintingVariant> FRUIT_TOAST =
            PAINTING_VARIANTS.register(
                    "fruit_toast",
                    () -> new PaintingVariant(16,16)
            );
    public static final RegistryObject<PaintingVariant> AUTUMN_STATION =
            PAINTING_VARIANTS.register(
                    "autumn_station",
                    () -> new PaintingVariant(16,32)
            );
    public static final RegistryObject<PaintingVariant> SKY_ROCK =
            PAINTING_VARIANTS.register(
                    "sky_rock",
                    () -> new PaintingVariant(16,32)
            );
    public static final RegistryObject<PaintingVariant> CHECKMATE =
            PAINTING_VARIANTS.register(
                    "checkmate",
                    () -> new PaintingVariant(48,32)
            );


    public static void register(IEventBus eventBus)
    {
        PAINTING_VARIANTS.register(eventBus);
    }

}
