package com.kerwin.tutorialmod.proxy;

import com.kerwin.tutorialmod.TutorialMod;
import com.kerwin.tutorialmod.block.BlockElectricFurnace;
import com.kerwin.tutorialmod.block.ModBlocks;
import com.kerwin.tutorialmod.reference.Reference;
import com.kerwin.tutorialmod.tile.TileElectricFurnace;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod.EventBusSubscriber
public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {

    }

    public void init(FMLInitializationEvent event) {
        NetworkRegistry.INSTANCE.registerGuiHandler(TutorialMod.instance, new GuiHandler());
    }

    public void postInit(FMLPostInitializationEvent event) {

    }

    // registers in world blocks
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        // register standard blocks
        event.getRegistry().register(new BlockElectricFurnace());
        //tile entity
        GameRegistry.registerTileEntity(TileElectricFurnace.class, Reference.MODID + "_electric_furnace");
    }

    // registers inventory items and place holders for blocks
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new ItemBlock(ModBlocks.blockElectricFurnace).setRegistryName(BlockElectricFurnace.ELECTRIC_FURNACE));
    }
}
