package pecee.decorativeblocks.block;

import java.util.List;

import pecee.decorativeblocks.ConfigurationManager;
import pecee.decorativeblocks.block.BlockProperties.BlockType;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class BlockColouredBlock extends Block {
	@SideOnly(Side.CLIENT)
	private Icon[] iconArray;

	protected String unlocalizedName_tmp;
	
	public BlockColouredBlock(int id) {
		super(id, Material.wood);
		this.setCreativeTab(CreativeTabs.tabBlock).setHardness(2.0F)
				.setResistance(5.0F).setStepSound(soundStoneFootstep);
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int id, CreativeTabs tab, List subItems) {
		for (BlockType color : BlockType.values()) {
			subItems.add(new ItemStack(id, 1, color.getCode()));
		}
	}

	public int damageDropped(int par1) {
		return par1;
	}

	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2) {
		if (par2 < 0 || par2 >= BlockType.values().length) {
			par2 = 0;
		}

		return this.iconArray[par2];
	}

	@SideOnly(Side.CLIENT)
	/**
	 * When this method is called, your block should register all the icons it needs with the given IconRegister. This
	 * is the only chance you get to register icons.
	 */
	public void registerIcons(IconRegister par1IconRegister) {
		this.iconArray = new Icon[BlockType.values().length];

		for (BlockType color : BlockType.values()) {
			this.iconArray[color.ordinal()] = par1IconRegister.registerIcon(ConfigurationManager.MOD_ID + ":block_" + color.getCode());
		}
	}
	
	// Fix for old Forge versions
    public String func_94330_A() {
        return this.unlocalizedName_tmp;
    }

    @Override
    public Block setUnlocalizedName(String par1Str) {
        this.unlocalizedName_tmp = par1Str;
        return super.setUnlocalizedName(par1Str);
    }

}