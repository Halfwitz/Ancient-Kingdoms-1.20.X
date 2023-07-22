package net.halfwitz.ancientkingdoms.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.halfwitz.ancientkingdoms.AncientKingdomsMod;
import net.halfwitz.ancientkingdoms.block.custom.SoundBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    //Ancient Block
    public static final Block ANCIENT_BLOCK = registerBlock("ancient_block",
            new Block(FabricBlockSettings.copyOf(Blocks.NETHERITE_BLOCK)));
    //Ancient Ore
    public static final Block ANCIENT_ORE = registerBlock("ancient_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.ANCIENT_DEBRIS)));
    public static final Block DEEPSLATE_ANCIENT_ORE = registerBlock("deepslate_ancient_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.ANCIENT_DEBRIS)));
    public static final Block END_STONE_ANCIENT_ORE = registerBlock("end_stone_ancient_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.ANCIENT_DEBRIS)));
    public static final Block NETHER_ANCIENT_ORE = registerBlock("nether_ancient_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.ANCIENT_DEBRIS)));

    public static final Block SOUND_BLOCK = registerBlock("sound_block",
            new SoundBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));



    /* Adds Block entry to BLOCK DefaultedRegistry, and calls registerBlockItem to add it as a BlockItem as well.
     * @param name - name of the block being registered as BlockItem
     * @param block - The Block item being registered as BlockItem
     * @return - Returns and completes the passed entry for the block as Block.
     */
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block); //creates a BlockItem for Block block
        return Registry.register(Registries.BLOCK, new Identifier(AncientKingdomsMod.MOD_ID, name), block);
    }

    /* Adds BlockItem entry to ITEM DefaultedRegistry
    * @param name - name of the block being registered as BlockItem
    * @param block - The Block item being registered as BlockItem
    * @return - Returns and completes the passed entry for the block as BlockItem.
     */
    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(AncientKingdomsMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    //Registers Blocks and logs information in LOGGER.
    public static void registerModBlocks() {
        AncientKingdomsMod.LOGGER.info("Registering Mod Blocks for "+ AncientKingdomsMod.MOD_ID);
    }
}
