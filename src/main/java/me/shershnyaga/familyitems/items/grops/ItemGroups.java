package me.shershnyaga.familyitems.items.grops;

import me.shershnyaga.familyitems.FamilyItemsMod;
import me.shershnyaga.familyitems.items.items.DarkFamilyItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static com.mojang.text2speech.Narrator.LOGGER;

public class ItemGroups {
    public static final ItemGroup DarkFamilyItemsGroup = Registry.register(Registries.ITEM_GROUP,
            new Identifier(FamilyItemsMod.MOD_ID, "darkfamily"),
            FabricItemGroup.builder().displayName(Text.translatable("darkfamily.group.name"))
                    .icon(() -> new ItemStack(DarkFamilyItems.NIGHT_HORROR))
                    .entries(((displayContext, entries) -> {
                        entries.add(new ItemStack(DarkFamilyItems.NIGHT_HORROR));
                        entries.add(new ItemStack(DarkFamilyItems.DAY_HORROR));
                    }))
                    .build());


    public static void registerGroups() {
        LOGGER.info("Register DarkFamilyItemsGroup");
    }
}
