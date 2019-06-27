package com.kerwin.tutorialmod.block;

import com.kerwin.tutorialmod.reference.Reference;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks {

    @GameRegistry.ObjectHolder("tutorialmod:electric_furnace")
    public static BlockElectricFurnace blockElectricFurnace;

    @SideOnly(Side.CLIENT)
    public static void initModels(){
        blockElectricFurnace.initModel();
    }
}
