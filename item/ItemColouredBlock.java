package pecee.decorativeblocks.item;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import pecee.decorativeblocks.DecorativeBlocksCore;
import pecee.decorativeblocks.block.BlockProperties.BlockType;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class ItemColouredBlock extends ItemBlock {
	public ItemColouredBlock(int id) {
		super(id);
		setHasSubtypes(true);
		setMaxDamage(0);
	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack) {
		return getUnlocalizedName() + "." + BlockType.values()[itemstack.getItemDamage()].name();
	}

	@Override
	public int getMetadata(int par1) {
		return par1;
	}
}
