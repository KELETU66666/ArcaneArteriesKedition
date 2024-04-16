package com.keletu.arcane_arteries;

import WayofTime.bloodmagic.core.RegistrarBloodMagicItems;
import com.keletu.arcane_arteries.block.AABlocks;
import com.keletu.arcane_arteries.item.AAItems;
import com.keletu.arcane_arteries.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.CrucibleRecipe;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.crafting.ShapedArcaneRecipe;
import vazkii.botania.api.BotaniaAPI;

@Mod(
        modid = ArcaneArteries.MOD_ID,
        name = ArcaneArteries.MOD_NAME,
        version = ArcaneArteries.VERSION,
        dependencies = "required-after:bloodmagic; required-after:thaumcraft; required-after:botania"
)
public class ArcaneArteries {

    public static final String MOD_ID = "arcane_arteries";
    public static final String MOD_NAME = "Arcane Arteries Kedition";
    public static final String VERSION = "1.0.0";

    @SidedProxy(clientSide = "com.keletu.arcane_arteries.proxy.ClientProxy", serverSide = "com.keletu.arcane_arteries.proxy.CommonProxy")
    public static CommonProxy proxy;


    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

        proxy.init(event);

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);

        ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("aa:thaumic_dagger"),
                new CrucibleRecipe(/*"DAGGER"*/"", new ItemStack(AAItems.thaumic_sacrificial_dagger), RegistrarBloodMagicItems.SACRIFICIAL_DAGGER, new AspectList().add(Aspect.MAGIC, 20).add(Aspect.EARTH, 20)));

        ThaumcraftApi.addInfusionCraftingRecipe(new ResourceLocation("aa:thaumic_sacrificial_dagger"),
                new InfusionRecipe(/*"SACRIFICIAL_DAGGER"*/"", new ItemStack(AAItems.thaumic_dagger_of_sacrifice, 1), 7, (new AspectList()).add(Aspect.MAGIC, 30).add(Aspect.LIFE, 30), new ItemStack(AAItems.thaumic_sacrificial_dagger), "ingotThaumium", "ingotThaumium"));

        ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("aa:thaumic_slate"),
                new CrucibleRecipe(/*"RUNE"*/"", new ItemStack(AAItems.thaumic_slate), Blocks.STONE, new AspectList().add(Aspect.MAGIC, 5).add(Aspect.EARTH, 5)));

        ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation("aa:thaumic_rune"),
                new ShapedArcaneRecipe(
                        new ResourceLocation(""),
                        /*"RUNE"*/"",
                        50,
                        new AspectList().add(Aspect.FIRE, 2).add(Aspect.ORDER, 2),
                        new ItemStack(AABlocks.thaumic_rune, 1),
                        " S ",
                        "ABA",
                        " S ",
                        'A', "ingotThaumium",
                        'S', new ItemStack(AAItems.thaumic_slate),
                        'B', new ItemStack(Blocks.STONE)));

        //ThaumcraftApi.addInfusionCraftingRecipe(new ResourceLocation("aa:thaumic_rune"),
        //        new InfusionRecipe(/*"RUNE"*/"", new ItemStack(AABlocks.thaumic_rune, 1), 2, (new AspectList()).add(Aspect.MAGIC, 10).add(Aspect.LIFE, 10).add(Aspect.ORDER, 10), new ItemStack(Blocks.STONE), "ingotThaumium", new ItemStack(AAItems.thaumic_slate), "ingotThaumium", new ItemStack(AAItems.thaumic_slate)));

        BotaniaAPI.registerRuneAltarRecipe(new ItemStack(AAItems.botany_sacrificial_dagger), 2000, "ingotElvenElementium", "ingotElvenElementium", new ItemStack(RegistrarBloodMagicItems.SACRIFICIAL_DAGGER));
        BotaniaAPI.registerManaAlchemyRecipe(new ItemStack(AAItems.botany_dagger_of_sacrifice), new ItemStack(AAItems.botany_sacrificial_dagger), 6000);

        BotaniaAPI.registerManaInfusionRecipe(new ItemStack(AAItems.mana_slate, 1), new ItemStack(Blocks.STONE), 3000);

    }

    @Mod.EventBusSubscriber
    public static class ObjectRegistryHandler {

        @SubscribeEvent
        public static void addItems(RegistryEvent.Register<Item> event) {
            proxy.registerItems(event);
        }

        @SubscribeEvent
        @SideOnly(Side.CLIENT)
        public static void modelRegistryEvent(ModelRegistryEvent event) {
            proxy.modelRegistryEvent(event);
        }
    }

    public static CreativeTabs tabForgottenRelics = new CreativeTabs("tabArcaneArteries") {
        @SideOnly(Side.CLIENT)
        public ItemStack createIcon() {
            return new ItemStack(RegistrarBloodMagicItems.DAGGER_OF_SACRIFICE);
        }
    };
}
