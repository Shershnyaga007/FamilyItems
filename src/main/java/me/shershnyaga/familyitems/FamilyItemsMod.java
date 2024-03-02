package me.shershnyaga.familyitems;

import me.shershnyaga.familyitems.items.grops.ItemGroups;
import me.shershnyaga.familyitems.items.items.DarkFamilyItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class FamilyItemsMod implements ModInitializer {
    public static final String MOD_ID = "familyitems";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    @Override
    public void onInitialize() {
        ItemGroups.registerGroups();
        DarkFamilyItems.registerItems();
    }
}
