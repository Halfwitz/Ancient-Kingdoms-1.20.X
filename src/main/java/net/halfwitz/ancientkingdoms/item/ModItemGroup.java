package net.halfwitz.ancientkingdoms.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.halfwitz.ancientkingdoms.AncientKingdomsMod;
import net.halfwitz.ancientkingdoms.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static net.halfwitz.ancientkingdoms.AncientKingdomsMod.MOD_ID;

public class ModItemGroup {
    //Register an ItemGroup with Registry.register(registry, identifier, entries)
    public static final ItemGroup ANCIENT_KINGDOMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(AncientKingdomsMod.MOD_ID, "ancient_kingdoms_group"),
            //Set the translatable text to be translated in en_us.json
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.ancient_kingdoms_group"))
                    //Choose the chosen group icon
                    .icon(() -> new ItemStack(ModItems.ANCIENT_INGOT))
                    //Add an entry for each item/block/etc.
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.ancient_fragment);
                        entries.add(ModItems.ANCIENT_INGOT);

                        entries.add(ModBlocks.ANCIENT_ORE);
                        entries.add(ModBlocks.NETHER_ANCIENT_ORE);
                        entries.add(ModBlocks.DEEPSLATE_ANCIENT_ORE);
                        entries.add(ModBlocks.END_STONE_ANCIENT_ORE);
                        entries.add(ModBlocks.ANCIENT_BLOCK);
                    }).build());

    public static void registerItemGroups() {
        //Logs a message to confirm Mod Items are being registered for MOD_ID.
        AncientKingdomsMod.LOGGER.info("Registering Mod Item Groups for "+MOD_ID);
    }
}
