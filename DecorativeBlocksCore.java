package pecee.decorativeblocks;

import java.awt.MultipleGradientPaint.ColorSpaceType;

import pecee.decorativeblocks.block.BlockColouredSlab;
import pecee.decorativeblocks.block.BlockProperties.BlockType;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.block.BlockStep;
import net.minecraft.block.BlockWoodSlab;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;

@Mod(modid = "decorativeblocks", name = "Decorative Blocks", version = "1.3")
@cpw.mods.fml.common.network.NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class DecorativeBlocksCore
{
    @SidedProxy(clientSide = "pecee.decorativeblocks.ClientProxy", serverSide = "pecee.decorativeblocks.CommonProxy")
    public static CommonProxy proxy;

    @Mod.Init
    public void load(FMLInitializationEvent event) {
        proxy.init();
    }
}
