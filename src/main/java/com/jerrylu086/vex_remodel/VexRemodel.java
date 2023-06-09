package com.jerrylu086.vex_remodel;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("unused")
@Mod(VexRemodel.MOD_ID)
public class VexRemodel {
    public static final String MOD_ID = "vex_remodel";
    public static final Logger LOGGER = LogManager.getLogger();

    public VexRemodel() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
            modEventBus.addListener(this::registerLayerDefinitions);
            modEventBus.addListener(this::registerRenderers);
        });

        MinecraftForge.EVENT_BUS.register(this);
    }

    public static final ModelLayerLocation VEX_ALT_LAYER = new ModelLayerLocation(new ResourceLocation("vex_alt"), "main");

    public void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(VEX_ALT_LAYER, VexAltModel::createBodyLayer);
    }

    @OnlyIn(Dist.CLIENT)
    private void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityType.VEX, VexAltRenderer::new);
    }
}
