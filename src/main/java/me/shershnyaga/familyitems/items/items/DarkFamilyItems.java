package me.shershnyaga.familyitems.items.items;

import me.shershnyaga.familyitems.FamilyItemsMod;
import me.shershnyaga.familyitems.items.items.darkfamily.DayHorror;
import me.shershnyaga.familyitems.items.items.darkfamily.NightHorror;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class DarkFamilyItems {

    public static final Item NIGHT_HORROR = Registry.register(Registries.ITEM, new Identifier(FamilyItemsMod.MOD_ID,
            "night_horror"), new NightHorror(new FamilySwordDefaultTool(7),
            7, -3f, new FabricItemSettings()
            .maxCount(1)
    ));

    public static final Item DAY_HORROR = Registry.register(Registries.ITEM, new Identifier(FamilyItemsMod.MOD_ID,
            "day_horror"), new DayHorror(new FamilySwordDefaultTool(7),
            7, -3f, new FabricItemSettings()
            .maxCount(1)
    ));


    public static void registerItems() {
        // LOGGER.info("Register DarkFamilyItems");
    }
}
