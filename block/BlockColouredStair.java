package pecee.decorativeblocks.block;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import pecee.decorativeblocks.CommonProxy;
import pecee.decorativeblocks.DecorativeBlocksCore;
import pecee.decorativeblocks.block.BlockProperties.BlockType;

import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.StatCollector;
import net.minecraft.util.StringUtils;
import net.minecraft.world.World;

public class BlockColouredStair extends BlockStairs
{
    protected String unlocalizedName_tmp;

    public BlockColouredStair(int id, Block block, int item) {
        super(id, block, item);
        this.setCreativeTab(CreativeTabs.tabBlock).setHardness(2.0F).setResistance(5.0F).setStepSound(soundStoneFootstep);
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