package com.keletu.arcane_arteries.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class AAItemBlocks extends ItemBlock {
    public AAItemBlocks(Block block) {
        super(block);
        this.setTranslationKey(block.getTranslationKey());
        this.setRegistryName(block.getRegistryName());
    }
}
