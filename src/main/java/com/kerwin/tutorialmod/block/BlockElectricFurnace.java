package com.kerwin.tutorialmod.block;

import com.kerwin.tutorialmod.TutorialMod;
import com.kerwin.tutorialmod.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import com.kerwin.tutorialmod.tile.TileElectricFurnace;

import javax.annotation.Nullable;

// block is for basic tile entitiy is storing data more than the standard 16
public class BlockElectricFurnace extends Block implements ITileEntityProvider {

    // this is for multi textures
    public static final PropertyDirection FACING = PropertyDirection.create("facing");

    public static final ResourceLocation ELECTRIC_FURNACE = new ResourceLocation(Reference.MODID, "electric_furnace");

    public BlockElectricFurnace() {
        super(Material.IRON);

        // tutorialmod:electric_furnace <-- reg name
        setRegistryName(ELECTRIC_FURNACE);
        setHardness(5f);
        setUnlocalizedName(Reference.MODID + ".electric_furnace");
        setHarvestLevel("pickaxe", 2);
        setCreativeTab(TutorialMod.creativeTab);

        //setting default state for multi texture
        setDefaultState(blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileElectricFurnace();
    }

    // if activated open gui sorta thing
    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,
                                    EnumFacing facing, float hitX, float hitY, float hitZ) {
        // Only For server execution
        if (world.isRemote) {
            return true;
        }
        TileEntity tileEntity = world.getTileEntity(pos);
        if (!(tileEntity instanceof TileElectricFurnace)) {
            return false;
        }
        player.openGui(TutorialMod.instance, 0, world, pos.getX(), pos.getY(), pos.getZ());
        return true;

    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        // this renders in inventory
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        return this.getDefaultState().withProperty(FACING, EnumFacing.getDirectionFromEntityLiving(pos, placer));
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[]{FACING});
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(FACING, EnumFacing.getFront(meta & 7));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(FACING).getIndex();
    }


}
