package me.shershnyaga.familyitems.items;

import me.shershnyaga.familyitems.FamilyItemsMod;
import me.shershnyaga.familyitems.items.deylan.VoidSword;
import me.shershnyaga.familyitems.items.templates.FamilySwordDefaultTool;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class DeylanItems {
    public static final Item VOID_SWORD = Registry.register(Registries.ITEM, new Identifier(FamilyItemsMod.MOD_ID,
            "void_sword"), new VoidSword(new FamilySwordDefaultTool(4),
            4, -3f, new FabricItemSettings()
            .customDamage((stack, amount, entity, breakCallback) -> amount + (int) (entity.getHealth() / 100 * 4))
            .maxCount(1)));

    public static void registerItems() {

    }
}
