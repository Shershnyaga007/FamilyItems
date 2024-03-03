package me.shershnyaga.familyitems.groups;

import me.shershnyaga.familyitems.FamilyItemsMod;
import me.shershnyaga.familyitems.items.DarkFamilyItems;
import me.shershnyaga.familyitems.items.NeoNubItems;
import me.shershnyaga.familyitems.items.StepfksItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

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

    public static final ItemGroup NeoNubItemsGroup = Registry.register(Registries.ITEM_GROUP,
            new Identifier(FamilyItemsMod.MOD_ID, "neonub"),
            FabricItemGroup.builder().displayName(Text.translatable("neonub.group.name"))
                    .icon(() -> new ItemStack(NeoNubItems.FROST_SORROW))
                    .entries(((displayContext, entries) -> {
                        entries.add(new ItemStack(NeoNubItems.FROST_SORROW));
                    }))
                    .build());

    public static final ItemGroup StepfksGroup = Registry.register(Registries.ITEM_GROUP,
            new Identifier(FamilyItemsMod.MOD_ID, "stepfks"),
            FabricItemGroup.builder().displayName(Text.translatable("stepfks.group.name"))
                    .icon(() -> new ItemStack(StepfksItems.SASAI_KUDOSAI))
                    .entries(((displayContext, entries) -> {
                        entries.add(new ItemStack(StepfksItems.SASAI_KUDOSAI));
                    }))
                    .build());

    public static void registerGroups() {
        // LOGGER.info("Register DarkFamilyItemsGroup");
    }
}
