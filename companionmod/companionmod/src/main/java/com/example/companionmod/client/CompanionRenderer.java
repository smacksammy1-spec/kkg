package com.example.companionmod.client;

import com.example.companionmod.entity.CompanionEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class CompanionRenderer extends GeoEntityRenderer<CompanionEntity> {
    public CompanionRenderer(EntityRendererProvider.Context context) {
        super(context, new CompanionModel());
        this.shadowRadius = 0.4F;
    }
}
