package com.kadin.betterminecraft.CustomItems;

import com.kadin.betterminecraft.BetterMinecraft;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CustomItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BetterMinecraft.MOD_ID);

    public static final DeferredItem<Item> ANYWHERE_CRAFTER = ITEMS.registerItem(
            "anywhere_crafter",
            AnywhereCrafter::new, // The factory that the properties will be passed into.
            props -> props // A unary operator of the properties to use.
    );

}
