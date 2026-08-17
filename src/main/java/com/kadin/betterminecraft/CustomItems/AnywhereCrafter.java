package com.kadin.betterminecraft.CustomItems;

import com.mojang.logging.LogUtils;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.CraftingMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.KineticWeapon;
import net.minecraft.world.item.equipment.Equippable;
import net.minecraft.world.level.Level;
import org.slf4j.Logger;

public class AnywhereCrafter extends Item {

    public static final Logger LOGGER = LogUtils.getLogger();
    private static final Component CONTAINER_TITLE = Component.translatable("Anywhere Crafting!");


    public AnywhereCrafter(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        // only apply to server side
        if (!level.isClientSide()) {
            player.openMenu(new SimpleMenuProvider(
                    (containerId, inventory, p) ->
                            new CraftingMenu(containerId, inventory, ContainerLevelAccess.NULL),
                    CONTAINER_TITLE
            ));
        }

        return InteractionResult.SUCCESS;
    }
}

// ContainerLevelAccess access