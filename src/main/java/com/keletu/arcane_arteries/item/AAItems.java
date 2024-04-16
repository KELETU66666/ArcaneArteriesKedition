package com.keletu.arcane_arteries.item;

import com.keletu.arcane_arteries.ArcaneArteries;
import com.keletu.arcane_arteries.block.AABlocks;
import net.minecraft.item.Item;

public class AAItems {
    public static final Item mana_slate = new AAItem().setRegistryName("mana_slate").setTranslationKey("mana_slate").setCreativeTab(ArcaneArteries.tabForgottenRelics);
    public static final Item thaumic_slate = new AAItem().setRegistryName("thaumic_slate").setTranslationKey("thaumic_slate").setCreativeTab(ArcaneArteries.tabForgottenRelics);
    public static final Item thaumic_sacrificial_dagger = new ItemThaumicSacrificialDagger();
    public static final Item botany_sacrificial_dagger = new ItemBotanySacrificialDagger();
    public static final Item thaumic_dagger_of_sacrifice = new ItemThaumicDaggerOfSacrifice();
    public static final Item botany_dagger_of_sacrifice = new ItemBotanyDaggerOfSacrifice();

    public static final Item thaumicRuneItem = new AAItemBlocks(AABlocks.thaumic_rune);
    public static final Item botanyRuneItem = new AAItemBlocks(AABlocks.mana_rune);
}
