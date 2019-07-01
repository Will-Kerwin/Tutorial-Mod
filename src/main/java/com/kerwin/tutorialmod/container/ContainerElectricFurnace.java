package com.kerwin.tutorialmod.container;

import com.kerwin.tutorialmod.tile.TileElectricFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerElectricFurnace extends Container {

    private TileElectricFurnace tileElectricFurnace;

    public ContainerElectricFurnace(IInventory playerInventory, TileElectricFurnace tileElectricFurnace) {
        this.tileElectricFurnace = tileElectricFurnace;

        // this container ref items out of own inventory (9 slots we hold)
        // as well as the slots from the play inventory so that the user can transfer items between
        // both inventories. the two calls belowe make sure that slots are defined for both inventories
        addOwnSlots();
        addPlayerSlots(playerInventory);
    }

    private void addPlayerSlots(IInventory playerInventory) {
        // Slots for the main inventory
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                int x = 8 + col * 18;
                int y = row * 18 + 84;
                this.addSlotToContainer(new Slot(playerInventory, col + row * 9 + 10, x, y));
            }
        }

        // hotbar slots
        for (int row = 0; row < 9; row++) {
            int x = 8 + row * 18;
            int y = 58 + 84;
            this.addSlotToContainer(new Slot(playerInventory, row, x, y));
        }
    }

    private void addOwnSlots() {
        IItemHandler itemHandler = this.tileElectricFurnace.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
        int x = 17;
        int y = 35;

        int slotIndex = 0;
        // this is adding slots exclude inven and hotbar so in this case the 6 furnace thingys // x+=18 is the dis to next
        addSlotToContainer(new SlotItemHandler(itemHandler, slotIndex, x, y));
        x += 18;
        addSlotToContainer(new SlotItemHandler(itemHandler, slotIndex, x, y));
        x += 18;
        addSlotToContainer(new SlotItemHandler(itemHandler, slotIndex, x, y));

        // and again for output
        x = 108;
        addSlotToContainer(new SlotItemHandler(itemHandler, slotIndex, x, y));
        x += 18;
        addSlotToContainer(new SlotItemHandler(itemHandler, slotIndex, x, y));
        x += 18;
        addSlotToContainer(new SlotItemHandler(itemHandler, slotIndex, x, y));
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemStack1 = slot.getStack();
            itemstack = itemStack1.copy();

            if (index < TileElectricFurnace.SIZE) {
                if (!this.mergeItemStack(itemStack1, tileElectricFurnace.SIZE, this.inventorySlots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.mergeItemStack(itemStack1, 0, TileElectricFurnace.SIZE, false)) {
                return ItemStack.EMPTY;
            }

            if (itemStack1.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }
        }
        return itemstack;
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return tileElectricFurnace.canInteractWith(playerIn);
    }
}
