package pecee.decorativeblocks;

import java.awt.color.ColorSpace;

import org.lwjgl.util.Color;

import pecee.decorativeblocks.block.BlockColouredBlock;
import pecee.decorativeblocks.block.BlockColouredCarpet;
import pecee.decorativeblocks.block.BlockColouredGlass;
import pecee.decorativeblocks.block.BlockColouredSlab;
import pecee.decorativeblocks.block.BlockColouredStair;
import pecee.decorativeblocks.block.BlockProperties.BlockType;
import pecee.decorativeblocks.item.ItemColouredBlock;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class CommonProxy
{
    public void init()
    {
        Block colorBlock = new BlockColouredBlock(600).setUnlocalizedName("colouredblock");
        GameRegistry.registerBlock(colorBlock, ItemColouredBlock.class, "Coloured Block");
        
        Block glass = new BlockColouredGlass(601).setUnlocalizedName("colouredglass");
        GameRegistry.registerBlock(glass, ItemColouredBlock.class, "Coloured Glass");
        
        // Loop through each color
        int slabsBlockId = 602;
        int stairsBlockId = slabsBlockId + (BlockType.values().length * 2);
        int carpetBlockId = stairsBlockId + BlockType.values().length;

        for (BlockType color : BlockType.values()) {
            ItemStack blockStack = new ItemStack(colorBlock, 1, color.getCode());
            ItemStack glassStack = new ItemStack(glass, 1, color.getCode());
            // Add stairs
            BlockHalfSlab slabSingle = (BlockHalfSlab) new BlockColouredSlab(slabsBlockId, false, colorBlock, color.getCode()).setUnlocalizedName("colouredslabsingle." + color.getCode());
            BlockHalfSlab slabDouble = (BlockHalfSlab) new BlockColouredSlab((slabsBlockId + 1), true, colorBlock, color.getCode()).setUnlocalizedName("colouredslabdouble." + color.getCode());
            GameRegistry.registerBlock(slabSingle, color.getName() + " Slab");
            Item.itemsList[slabSingle.blockID] = new ItemSlab(slabSingle.blockID - 256, slabSingle, slabDouble, false);
            LanguageRegistry.addName(slabSingle, color.getName() + " Slab");
            // Add stairs
            Block stair = new BlockColouredStair(stairsBlockId, colorBlock, color.getCode()).setUnlocalizedName("colouredstairs." + color.getCode());
            GameRegistry.registerBlock(stair, color.getName() + " Stair");
            // Add carpet
            Block carpet = new BlockColouredCarpet(carpetBlockId, colorBlock, color.getCode()).setUnlocalizedName("colouredcarpet." + color.getCode());
            GameRegistry.registerBlock(carpet, color.getName() + " Carpet");
            LanguageRegistry.addName(stair, color.getName() + " Stair");
            LanguageRegistry.addName(blockStack, color.getName() +  " Block");
            LanguageRegistry.addName(carpet, color.getName() +  " Carpet");
            LanguageRegistry.addName(glassStack, color.getName() + " Glass");
            
            // Block recipe
            GameRegistry.addShapelessRecipe(blockStack, new Object[] { new ItemStack(82, 1, 0), new ItemStack(351, 1, color.getCode()) } );
            // Glass recipe
            GameRegistry.addShapelessRecipe(glassStack, new Object[] { new ItemStack(20, 1, 0), new ItemStack(351, 1, color.getCode()) } );
            // Slabs recipe
            GameRegistry.addRecipe(new ItemStack(slabSingle, 1, 0), "   ", "   ", "xxx", 'x', blockStack);
            // Stairs recipe
            GameRegistry.addRecipe(new ItemStack(stair, 1, 0), "x  ", "xx ", "xxx", 'x', blockStack);
            // Carpet recipe
            GameRegistry.addRecipe(new ItemStack(carpet, 5, 0), "   ", "   ", "xxx", 'x', slabSingle);
            slabsBlockId = slabsBlockId + 2;
            stairsBlockId++;
            carpetBlockId++;
        }
        
        
        
    }
}
