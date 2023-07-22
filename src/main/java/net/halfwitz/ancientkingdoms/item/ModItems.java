package net.halfwitz.ancientkingdoms.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.halfwitz.ancientkingdoms.AncientKingdomsMod;
import net.halfwitz.ancientkingdoms.block.ModBlocks;
import net.halfwitz.ancientkingdoms.item.custom.MetalDetectorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.halfwitz.ancientkingdoms.AncientKingdomsMod.MOD_ID;

public class ModItems {

    //Item Declarations
    public static final Item ANCIENT_FRAGMENT = registerItem("ancient_fragment", new Item(new FabricItemSettings()));
    public static final Item ANCIENT_INGOT = registerItem("ancient_ingot", new Item(new FabricItemSettings()));

    public static final Item METAL_DETECTOR = registerItem("metal_detector", new MetalDetectorItem(new FabricItemSettings().maxDamage(256)));


    /*
    * Registers an Item object with name name.
    * @param name - The name of the object (must be unique and lowercase)
    * @param item - The object being registered.
    * @return Completes registering the Item in the ITEM registry.
     */
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(AncientKingdomsMod.MOD_ID, name), item);
    }

    /*Adds Items to Ingredients ItemGroup as an entry.
    * @param entries - the FabricItemGroupEntries being added to.
     */
    private static void itemGroupIngredients(FabricItemGroupEntries entries) {
        entries.add(ANCIENT_FRAGMENT);
        entries.add(ANCIENT_INGOT);
    }
    /*Adds Items to Natural ItemGroup as an entry.
     * @param entries - the FabricItemGroupEntries being added to.
     */
    private static void itemGroupNatural(FabricItemGroupEntries entries) {
        entries.add(ModBlocks.ANCIENT_BLOCK);
        entries.add(ModBlocks.ANCIENT_ORE);
        entries.add(ModBlocks.NETHER_ANCIENT_ORE);
        entries.add(ModBlocks.DEEPSLATE_ANCIENT_ORE);
        entries.add(ModBlocks.END_STONE_ANCIENT_ORE);
    }
    /*Adds Items to Tools ItemGroup as an entry.
     * @param entries - the FabricItemGroupEntries being added to.
     */
    private static void itemGroupTools(FabricItemGroupEntries entries) {
        entries.add(METAL_DETECTOR);
    }

    //Called by AncientKingdomsMod.java
    public static void registerModItems() {
        //Logs a message to confirm Mod Items are being registered for MOD_ID.
        AncientKingdomsMod.LOGGER.info("Registering Mod Items for "+MOD_ID);
        //Adds Item entries to INGREDIENTS Item Group
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::itemGroupIngredients);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(ModItems::itemGroupNatural);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModItems::itemGroupTools);

    }
}
