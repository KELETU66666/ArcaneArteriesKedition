package com.keletu.arcane_arteries.bloodmagic;

import WayofTime.bloodmagic.altar.AltarTier;
import WayofTime.bloodmagic.api.BloodMagicPlugin;
import WayofTime.bloodmagic.api.IBloodMagicAPI;
import WayofTime.bloodmagic.api.IBloodMagicPlugin;
import WayofTime.bloodmagic.api.IBloodMagicRecipeRegistrar;
import WayofTime.bloodmagic.item.ItemSlate;
import com.keletu.arcane_arteries.block.AABlocks;
import com.keletu.arcane_arteries.item.AAItems;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.crafting.Ingredient;

@BloodMagicPlugin
public class BMRegistry implements IBloodMagicPlugin {
    private static IBloodMagicAPI api;

    @Override
    public void register(IBloodMagicAPI api) {
        BMRegistry.api = api;

        setAltarComponent(AABlocks.thaumic_rune, "BLOODRUNE");
        setAltarComponent(AABlocks.mana_rune, "BLOODRUNE");
    }

    private static void setAltarComponent(Block block, String componentType) {
            for (IBlockState state : block.getBlockState().getValidStates())
                api.registerAltarComponent(state, componentType);
    }

    @Override
    public void registerRecipes(IBloodMagicRecipeRegistrar recipeRegistrar) {
        recipeRegistrar.addBloodAltar(Ingredient.fromItem(AAItems.thaumic_slate), ItemSlate.SlateType.REINFORCED.getStack(), AltarTier.TWO.ordinal(), 1500, 20, 20);
        recipeRegistrar.addBloodAltar(Ingredient.fromItem(AAItems.mana_slate), ItemSlate.SlateType.REINFORCED.getStack(), AltarTier.TWO.ordinal(), 1500, 20, 20);
    }
}