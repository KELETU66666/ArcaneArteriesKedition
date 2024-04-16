package com.keletu.arcane_arteries.event;

import com.keletu.arcane_arteries.item.AAItems;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(value = Side.CLIENT)
public class ModelEvents {
    @SubscribeEvent
    public static void regModels(ModelRegistryEvent event) {
        defaultModel(AAItems.thaumicRuneItem);
        defaultModel(AAItems.botanyRuneItem);

        defaultModel(AAItems.mana_slate);
        defaultModel(AAItems.thaumic_slate);

        defaultModel(AAItems.botany_sacrificial_dagger);
        defaultModel(AAItems.thaumic_sacrificial_dagger);

        defaultModel(AAItems.botany_dagger_of_sacrifice);
        defaultModel(AAItems.thaumic_dagger_of_sacrifice);
    }

    static void defaultModel(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
}
