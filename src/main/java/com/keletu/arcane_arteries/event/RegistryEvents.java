package com.keletu.arcane_arteries.event;

import com.keletu.arcane_arteries.block.AABlocks;
import com.keletu.arcane_arteries.item.AAItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod.EventBusSubscriber
public class RegistryEvents {
    @SubscribeEvent
    public static void regBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(AABlocks.thaumic_rune);
        event.getRegistry().registerAll(AABlocks.mana_rune);
    }

    @SubscribeEvent
    public static void regItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(AAItems.thaumicRuneItem);
        event.getRegistry().registerAll(AAItems.botanyRuneItem);

        event.getRegistry().registerAll(AAItems.thaumic_sacrificial_dagger);
        event.getRegistry().registerAll(AAItems.botany_sacrificial_dagger);

        event.getRegistry().registerAll(AAItems.thaumic_dagger_of_sacrifice);
        event.getRegistry().registerAll(AAItems.botany_dagger_of_sacrifice);

        event.getRegistry().registerAll(AAItems.mana_slate);
        event.getRegistry().registerAll(AAItems.thaumic_slate);
    }
}
