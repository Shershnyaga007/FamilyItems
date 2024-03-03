package me.shershnyaga.familyitems.items;

import me.shershnyaga.familyitems.FamilyItemsMod;
import me.shershnyaga.familyitems.items.neonub.FrostSorrow;
import me.shershnyaga.familyitems.items.stepfks.Sasaikudosai;
import me.shershnyaga.familyitems.items.templates.FamilySword;
import me.shershnyaga.familyitems.items.templates.FamilySwordDefaultTool;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class StepfksItems {
    public static final Item SASAI_KUDOSAI = Registry.register(Registries.ITEM, new Identifier(FamilyItemsMod.MOD_ID,
            "sasai_kudosai"), new Sasaikudosai(new FamilySwordDefaultTool(5),
            5, -2.4f, new FabricItemSettings()
            .maxCount(1)));


    public static void registerItems() {

    }
}
