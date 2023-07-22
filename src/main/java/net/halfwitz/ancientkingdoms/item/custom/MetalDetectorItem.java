package net.halfwitz.ancientkingdoms.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

/**
 * The MetalDetectorItem class extends Item and provides functionality for an ore detecting item in minecraft.
 */
public class MetalDetectorItem extends Item {

    //Passes Settings to super class Item.
    public MetalDetectorItem(Settings settings) {
        super(settings);
    }

    /**
     * When the item right clicks on a block it checks 64 blocks below the block for valuable
     * ore and if ore is found it alerts the player.
     * @param context the usage context
     * @return the enum for completion state of the action.
     */
    @Override //Overrides the Item useOnBlock which is used when the item right clicks on block
    public ActionResult useOnBlock(ItemUsageContext context) {
        if(!context.getWorld().isClient()) {  //if on server-side

            BlockPos positionClicked = context.getBlockPos(); //positionClicked= block position of block right-clicked
            PlayerEntity player = context.getPlayer(); //player is the entity who right-clicked
            boolean foundBlock = false; //true if valuable is found

            //Loops through each block below play up to 64 below positionClicked.getY()
            for(int i = 0; i <= positionClicked.getY() + 64; i++) {

                //Each block in loop is retrieved with blockState and block
                // of the block that is down(i) from the positionClicked
                BlockState blockState = context.getWorld().getBlockState(positionClicked.down(i));
                Block block = blockState.getBlock();

                //Calls isValuableBlock method to check if blockState at i is valuable
                // If valuable, calls outputValuableCoordinates, sets foundBlock to true, and breaks the loop.
                if (isValuableBlock(blockState)) {
                    outputValuableCoordinates(positionClicked.down(i), player, block);
                    foundBlock = true;
                    break;
                }
            }

            //If no valuables are found in loop, player is sent a custom message translated in en_us.json
            if(!foundBlock) {
                player.sendMessage(Text.translatable("item.ancientkingdoms.metal_detector.no_valuables"));
            }
        }

        //Each time the item is used it takes damage to its durability
        context.getStack().damage(1, context.getPlayer(),
                //The tool that is in the actively being used breaks
                playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));
        return ActionResult.SUCCESS; //Returns SUCCESS result, hand swings to indicate performance
    }

    //Sends player a literal message saying they found a valuable. Prints block name and coordinates.
    private void outputValuableCoordinates(BlockPos position, PlayerEntity player, Block block) {
        player.sendMessage(Text.literal("ye struck valuables"+ block.getName().getString() + " at (" +
                position.getX() + ", "+ position.getY() + ", "+ position.getZ() + ")"));
    }

    /**
     * Compares blockState to valuable blocks and returns whether it matches one of the designated valuables
     * @param blockState
     * @return true of blockState matches any valuable block. 
     */
    private boolean isValuableBlock(BlockState blockState) {
        return blockState.getBlock() == Blocks.IRON_ORE || blockState.getBlock() == Blocks.GOLD_ORE ||
                blockState.getBlock() == Blocks.DIAMOND_ORE || blockState.getBlock() == Blocks.REDSTONE_ORE;
    }
}
