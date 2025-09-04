package dev.turtywurty.industria.renderer.block;

import dev.turtywurty.industria.blockentity.ArcFurnaceBlockEntity;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.util.math.MatrixStack;

public class ArcFurnaceBlockEntityRenderer extends IndustriaBlockEntityRenderer<ArcFurnaceBlockEntity> {
    public ArcFurnaceBlockEntityRenderer(BlockEntityRendererFactory.Context context) {
        super(context);
    }


    @Override
    protected void onRender(ArcFurnaceBlockEntity entity, float tickDelta, MatrixStack matrices, OrderedRenderCommandQueue queue, int light, int overlay) {
    }
}
