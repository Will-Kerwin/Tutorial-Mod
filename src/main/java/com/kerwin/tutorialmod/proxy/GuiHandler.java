package com.kerwin.tutorialmod.proxy;

import com.kerwin.tutorialmod.container.ContainerElectricFurnace;
import com.kerwin.tutorialmod.gui.GuiElectricFurnace;
import com.kerwin.tutorialmod.tile.TileElectricFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import javax.annotation.Nullable;

public class GuiHandler implements IGuiHandler {

    // guis have id to distingush which shoud be made
    @Nullable
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity tileEntity = world.getTileEntity(pos);
        if (tileEntity instanceof TileElectricFurnace) {
            return new ContainerElectricFurnace(player.inventory, (TileElectricFurnace) tileEntity);
        }
        return null;
    }

    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity tileEntity = world.getTileEntity(pos);
        if (tileEntity instanceof TileElectricFurnace) {
            TileElectricFurnace tileElectricFurnace = (TileElectricFurnace) tileEntity;
            return new GuiElectricFurnace(tileElectricFurnace, new ContainerElectricFurnace(player.inventory, tileElectricFurnace));
        }
        return null;
    }
}
