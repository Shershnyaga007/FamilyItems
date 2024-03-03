package me.shershnyaga.familyitems.items;

import me.shershnyaga.familyitems.FamilyItemsMod;
import me.shershnyaga.familyitems.items.neonub.FrostSorrow;
import me.shershnyaga.familyitems.items.templates.FamilySword;
import me.shershnyaga.familyitems.items.templates.FamilySwordDefaultTool;
import net.fabricmc.fabric.api.item.v1.CustomDamageHandler;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class NeoNubItems {

    public static final Item FROST_SORROW = Registry.register(Registries.ITEM, new Identifier(FamilyItemsMod.MOD_ID,
            "frost_sorrow"), new FrostSorrow(new FamilySwordDefaultTool(6),
            6, -3.2f, new FabricItemSettings()
            .maxCount(1)));

    public static void registerItems() {

    }

}
