package com.kerwin.tutorialmod.tile;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.items.ItemStackHandler;

public class TileElectricFurnace extends TileEntity {

    // specify size so input+output
    public static final int SIZE = 3 + 3;

    private ItemStackHandler itemStackHandler = new ItemStackHandler(SIZE) {
        @Override
        protected void onContentsChanged(int slot) {
            TileElectricFurnace.this.markDirty();
        }
    };
}
