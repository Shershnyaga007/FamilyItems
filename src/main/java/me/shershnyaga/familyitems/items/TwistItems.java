package me.shershnyaga.familyitems.items;

import me.shershnyaga.familyitems.FamilyItemsMod;
import me.shershnyaga.familyitems.items.templates.FamilySwordDefaultTool;
import me.shershnyaga.familyitems.items.twist.FlamingTwister;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class TwistItems {
    public static final Item FLAMING_TWISTER = Registry.register(Registries.ITEM, new Identifier(FamilyItemsMod.MOD_ID,
            "flaming_twister"), new FlamingTwister(new FamilySwordDefaultTool(5),
            5, -2.4f, new FabricItemSettings()
            .maxCount(1)));


    public static void registerItems() {

    }
}
