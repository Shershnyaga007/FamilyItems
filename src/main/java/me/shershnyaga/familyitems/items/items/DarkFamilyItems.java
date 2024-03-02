package me.shershnyaga.familyitems.items.items;

import me.shershnyaga.familyitems.FamilyItemsMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.mojang.text2speech.Narrator.LOGGER;

public class DarkFamilyItems {

    public static final Item NIGHT_HORROR = Registry.register(Registries.ITEM, new Identifier(FamilyItemsMod.MOD_ID,
            "night_horror"), new FamilySword(7, -1f, new FabricItemSettings()
            .maxCount(1)
    ));

    public static final Item DAY_HORROR = Registry.register(Registries.ITEM, new Identifier(FamilyItemsMod.MOD_ID,
            "day_horror"), new Item(new FabricItemSettings()
            .maxCount(1)
    ));


    public static void registerItems() {
        LOGGER.info("Register DarkFamilyItems");
    }
}
