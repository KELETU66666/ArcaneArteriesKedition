package com.keletu.arcane_arteries.block;

import WayofTime.bloodmagic.block.BlockBloodRune;
import WayofTime.bloodmagic.util.helper.TextHelper;
import com.keletu.arcane_arteries.ArcaneArteries;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class AABasicBlock extends Block {

    public AABasicBlock() {
        super(Material.ROCK);
        setSoundType(SoundType.STONE);
        setHardness(2.0F);
        setResistance(5.0F);
        setHarvestLevel("pickaxe", 2);
        setCreativeTab(ArcaneArteries.tabForgottenRelics);
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag tooltipFlag) {
        tooltip.add(TextHelper.localizeEffect("tooltip.bloodmagic.decoration.safe"));
        super.addInformation(stack, world, tooltip, tooltipFlag);
    }
}
