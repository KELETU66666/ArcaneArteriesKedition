package com.keletu.arcane_arteries.item;

import WayofTime.bloodmagic.util.helper.TextHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Arrays;
import java.util.List;

public class AAItem extends Item {

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, World world, List<String> list, ITooltipFlag flag) {
        if(this == AAItems.botanyRuneItem)
            list.addAll(Arrays.asList(TextHelper.cutLongString(TextHelper.localizeEffect("tooltip.botania.slate.desc"))));
        if(this == AAItems.thaumicRuneItem)
            list.addAll(Arrays.asList(TextHelper.cutLongString(TextHelper.localizeEffect("tooltip.thaumcraft.slate.desc"))));
    }
}
