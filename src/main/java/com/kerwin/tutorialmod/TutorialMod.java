package com.kerwin.tutorialmod;

import com.kerwin.tutorialmod.block.ModBlocks;
import com.kerwin.tutorialmod.proxy.CommonProxy;
import com.kerwin.tutorialmod.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION,
        dependencies = Reference.MOD_DEPENDENCIES, useMetadata = true)
public class TutorialMod {
    @SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.SERVER_PROXY)
    public static CommonProxy proxy;

    public static CreativeTabs creativeTabs = new CreativeTabs("Tutorial Mod"){
        @Override
        public ItemStack getTabIconItem(){return new ItemStack(ModBlocks.blockElectricFurnace);}
    };

    @Mod.Instance
    public static TutorialMod instance;

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        logger.info("Pre Init Stage, Hello my dudes!");
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        // some example code
        logger.info("Init Stage, Dudettes!");
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());

        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        logger.info("Post Init Stage, Dudeatrons!");
        proxy.postInit(event);
    }
}
