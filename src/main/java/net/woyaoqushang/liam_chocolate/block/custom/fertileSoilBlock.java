package net.woyaoqushang.liam_chocolate.block.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.FarmlandWaterManager;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.PlantType;
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;
import java.util.List;

public class fertileSoilBlock extends Block {
    public fertileSoilBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isRandomlyTicking(BlockState blockState) {
        return true;
        //return super.isRandomlyTicking(blockState);
    }

    @Override
    public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction facing, IPlantable plantable) {
        PlantType plant = plantable.getPlantType(world,pos);


        if (plant == PlantType.CROP || plant == PlantType.PLAINS) {
            return true;
        }


        return super.canSustainPlant(state, world, pos, facing, plantable);
    }



    @Override
    public void randomTick(BlockState blockState, ServerLevel level, BlockPos pos, RandomSource source) {
        BlockState blockAbove = level.getBlockState(pos.above());

        if (isNearWater(level,pos) || level.isRainingAt(pos.above()))
        {
            if (blockAbove.getBlock() instanceof CropBlock crop)
            {
                    crop.growCrops(level, pos.above(), blockAbove);
            }
        }
    }

    private static boolean isNearWater(LevelReader levelReader, BlockPos blockPos) {
        BlockState state = levelReader.getBlockState(blockPos);
        Iterator var3 = BlockPos.betweenClosed(blockPos.offset(-4, 0, -4), blockPos.offset(4, 1, 4)).iterator();

        BlockPos blockpos;
        do {
            if (!var3.hasNext()) {
                return FarmlandWaterManager.hasBlockWaterTicket(levelReader, blockPos);
            }

            blockpos = (BlockPos)var3.next();
        } while(!state.canBeHydrated(levelReader, blockPos, levelReader.getFluidState(blockpos), blockpos));

        return true;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable BlockGetter getter, List<Component> components, TooltipFlag flag) {

        if (Screen.hasShiftDown())
        {
            components.add(Component.literal(""));
            components.add(Component.translatable("liam_chocolate.tooltip.fertile_soil_block.shift"));
        }
        else
        {
            components.add(Component.literal(""));
            components.add(Component.translatable("liam_chocolate.tooltip.fertile_soil_block"));
            components.add(Component.translatable("liam_chocolate.tooltip.shift_for_more_info").withStyle(ChatFormatting.GOLD));
        }


        super.appendHoverText(stack, getter, components, flag);
    }
}
