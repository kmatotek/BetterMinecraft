package com.kadin.betterminecraft.CustomItems;

import com.kadin.betterminecraft.CustomMenus.AnywhereCraftingMenu;
import com.mojang.logging.LogUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
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
                            new AnywhereCraftingMenu(containerId, inventory),
                    CONTAINER_TITLE
            ));
        }

        return InteractionResult.SUCCESS;
    }
}