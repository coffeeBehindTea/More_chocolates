package net.woyaoqushang.liam_chocolate.item.custom;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class diceItem extends Item {
    public diceItem(Properties properties)
    {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {

        if (!level.isClientSide() && hand == InteractionHand.MAIN_HAND)
        {
            // get the random number and output it.
            outputRandomNumber(player);

            // also set a cool down
            player.getCooldowns().addCooldown(this,20);

        }

        return super.use(level, player, hand);
    }

    private void outputRandomNumber(Player player)
    {
        var player1 = Minecraft.getInstance().player;
        var deltaX = player1.getX() - player1.xOld;
        var deltaY = player1.getY() - player1.yOld;
        var deltaZ = player1.getZ() - player1.zOld;

        var speed = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2) + Math.pow(deltaZ, 2));
        if (speed > 0)
        {
            player.die(DamageSource.MAGIC);
            player.sendSystemMessage(Component.literal("didn't your mom told you to stand still before throwing dice?"));
        }
        else
        {
            int num = RandomSource.createNewThreadLocalInstance().nextInt(7);
            player.sendSystemMessage(Component.literal("your number is " + num));
        }
    }

}
