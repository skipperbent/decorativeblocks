package pecee.decorativeblocks.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.Vec3;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

interface IBlockColoured  {
	
	void onBlockClicked(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer);
	void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random);
	void onBlockDestroyedByPlayer(World par1World, int par2, int par3, int par4, int par5);
	int getMixedBrightnessForBlock(IBlockAccess par1IBlockAccess, int par2, int par3, int par4);
	float getBlockBrightness(IBlockAccess par1IBlockAccess, int par2, int par3, int par4);
	float getExplosionResistance(Entity par1Entity);
	int tickRate(World par1World);
	void velocityToAddToEntity(World par1World, int par2, int par3, int par4, Entity par5Entity, Vec3 par6Vec3);
	int getRenderBlockPass();
	Icon getIcon(int par1, int par2);
	AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World, int par2, int par3, int par4);
	boolean isCollidable();
	boolean canCollideCheck(int par1, boolean par2);
	boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4);
	void onBlockAdded(World par1World, int par2, int par3, int par4);
	void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6);
	void onEntityWalking(World par1World, int par2, int par3, int par4, Entity par5Entity);
	void updateTick(World par1World, int par2, int par3, int par4, Random par5Random);
	boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9);
	void onBlockDestroyedByExplosion(World par1World, int par2, int par3, int par4, Explosion par5Explosion);
	
}
