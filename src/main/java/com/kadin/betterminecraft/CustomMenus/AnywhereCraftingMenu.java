package com.kadin.betterminecraft.CustomMenus;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;

public class AnywhereCraftingMenu extends CraftingMenu {

    public AnywhereCraftingMenu(int containerId, Inventory inventory) {
        super(
                containerId,
                inventory,
                // CraftingMenu requires a ContainerLevelAccess to update the crafting result. Since there is no actual crafting table block, use the player's current position
                ContainerLevelAccess.create(
                        inventory.player.level(),
                        inventory.player.blockPosition()
                )
        );
    }

    // CraftingMenu normally checks whether the player is still close enough to the // crafting table. Menu will close right away if we don't override this and always return true
    @Override
    public boolean stillValid(Player player) {
        return true;
    }
}