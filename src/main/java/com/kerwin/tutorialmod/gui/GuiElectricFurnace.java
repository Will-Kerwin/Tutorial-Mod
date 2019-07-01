package com.kerwin.tutorialmod.gui;

import com.kerwin.tutorialmod.container.ContainerElectricFurnace;
import com.kerwin.tutorialmod.reference.Reference;
import com.kerwin.tutorialmod.tile.TileElectricFurnace;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;

public class GuiElectricFurnace extends GuiContainer {

    // set size of background guis usually 256, 256 (gui and other things)
    public static final int WIDTH = 180;
    public static final int HEIGHT = 180;

    private static final ResourceLocation background = new ResourceLocation(Reference.MODID, "textures/gui/gui_electric_furnace.png");

    public GuiElectricFurnace(TileElectricFurnace tileElectricFurnace, ContainerElectricFurnace containerElectricFurnace) {
        super(containerElectricFurnace);

        xSize = WIDTH;
        ySize = HEIGHT;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        mc.getTextureManager().bindTexture(background);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }
}
