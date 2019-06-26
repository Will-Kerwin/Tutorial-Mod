package com.kerwin.tutorialmod.block;

import com.kerwin.tutorialmod.TutorialMod;
import com.kerwin.tutorialmod.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;

public class BlockElectricFurnace extends Block {

    public BlockElectricFurnace(){
        super(Material.IRON);
        // tutorialmod:electric_furnace
        setRegistryName(new ResourceLocation(Reference.MODID, "electric_furnace"));
        setUnlocalizedName(Reference.MODID + ".electric_furnace");
        setHarvestLevel("pickaxe", 2);
    }
}
