package com.kadin.betterminecraft;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

import static com.kadin.betterminecraft.CustomItems.CustomItems.ITEMS;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(BetterMinecraft.MOD_ID)
public class BetterMinecraft {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "betterminecraft";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();



    public BetterMinecraft(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register the Deferred Register to the mod event bus so items get registered
        ITEMS.register(modEventBus);
    }


    private void commonSetup(FMLCommonSetupEvent event) {

    }


    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }
}
