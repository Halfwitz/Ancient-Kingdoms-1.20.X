package net.halfwitz.ancientkingdoms.block.custom;

import net.halfwitz.ancientkingdoms.AncientKingdomsMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;

public class SoundBlock extends Block {
    public SoundBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos,
                              PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (player.isSneaking()) {
            world.playSound(player, pos, SoundEvents.BLOCK_NOTE_BLOCK_BANJO.value(), SoundCategory.BLOCKS, 1f, 1f);
            return ActionResult.SUCCESS;
        }
        else {
            world.playSound(player, pos, SoundEvents.BLOCK_NOTE_BLOCK_COW_BELL.value(), SoundCategory.BLOCKS, 1f, 1f);
            return ActionResult.CONSUME;
        }

        /* if(world.isClient()) {
            if(hand == Hand.MAIN_HAND) {
                AncientKingdomsMod.LOGGER.info("CLIENT Main Hand"); //demonstration of whether CLIENT|SERVER & MAIN_HAND|OFF_HAND is used
            }
            else {
                AncientKingdomsMod.LOGGER.info("CLIENT Off Hand"); //demonstration of whether CLIENT|SERVER & MAIN_HAND|OFF_HAND is used

            }
        }
        else {
            if(hand == Hand.MAIN_HAND) {
                AncientKingdomsMod.LOGGER.info("SERVER Main Hand"); //demonstration of whether CLIENT|SERVER & MAIN_HAND|OFF_HAND is used

            }
            else {
                AncientKingdomsMod.LOGGER.info("SERVER Off Hand"); //demonstration of whether CLIENT|SERVER & MAIN_HAND|OFF_HAND is used

            }
        }
        AncientKingdomsMod.LOGGER.info("Right Clicked Sound Block");


        return ActionResult.SUCCESS;*/
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        world.playSound(entity, pos, SoundEvents.BLOCK_NOTE_BLOCK_BIT.value(), SoundCategory.BLOCKS, 1f, 1f);
        super.onSteppedOn(world, pos, state, entity);
    }
}
