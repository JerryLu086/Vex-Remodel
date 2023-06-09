package com.jerrylu086.vex_remodel;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Vex;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class VexAltRenderer extends MobRenderer<Vex, VexAltModel> {
    private static final ResourceLocation VEX_LOCATION = new ResourceLocation("textures/entity/illager/vex_alt.png");
    private static final ResourceLocation VEX_CHARGING_LOCATION = new ResourceLocation("textures/entity/illager/vex_charging_alt.png");

    public VexAltRenderer(EntityRendererProvider.Context p_174435_) {
        super(p_174435_, new VexAltModel(p_174435_.bakeLayer(VexRemodel.VEX_ALT_LAYER)), 0.3F);
        this.addLayer(new ItemInHandLayer<>(this, p_174435_.getItemInHandRenderer()));
    }

    protected int getBlockLightLevel(Vex pEntity, BlockPos pPos) {
        return 15;
    }

    public ResourceLocation getTextureLocation(Vex pEntity) {
        return pEntity.isCharging() ? VEX_CHARGING_LOCATION : VEX_LOCATION;
    }
}