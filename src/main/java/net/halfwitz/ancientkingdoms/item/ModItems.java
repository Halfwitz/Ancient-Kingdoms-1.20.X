package net.halfwitz.ancientkingdoms.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.halfwitz.ancientkingdoms.AncientKingdomsMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.halfwitz.ancientkingdoms.AncientKingdomsMod.MOD_ID;

public class ModItems {

    //Item Declarations
    public static final Item ANCIENT_NUGGET = registerItem("ancient_nugget", new Item(new FabricItemSettings()));
    public static final Item ANCIENT_INGOT = registerItem("ancient_ingot", new Item(new FabricItemSettings()));


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
        entries.add(ANCIENT_NUGGET);
        entries.add(ANCIENT_INGOT);
    }

    //Called by AncientKingdomsMod.java
    public static void registerModItems() {
        //Logs a message to confirm Mod Items are being registered for MOD_ID.
        AncientKingdomsMod.LOGGER.info("Registering Mod Items for "+MOD_ID);
        //Adds Item entries to INGREDIENTS Item Group
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::itemGroupIngredients);
    }
}
