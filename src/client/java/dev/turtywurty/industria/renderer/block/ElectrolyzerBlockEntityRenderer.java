package dev.turtywurty.industria.renderer.block;

import dev.turtywurty.industria.blockentity.ElectrolyzerBlockEntity;
import dev.turtywurty.industria.model.ElectrolyzerModel;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.util.math.MatrixStack;

public class ElectrolyzerBlockEntityRenderer extends IndustriaBlockEntityRenderer<ElectrolyzerBlockEntity> {
    private final ElectrolyzerModel model;

    public ElectrolyzerBlockEntityRenderer(BlockEntityRendererFactory.Context context) {
        super(context);
        this.model = new ElectrolyzerModel(context.getLayerModelPart(ElectrolyzerModel.LAYER_LOCATION));
    }

    @Override
    protected void onRender(ElectrolyzerBlockEntity entity, float tickDelta, MatrixStack matrices, OrderedRenderCommandQueue queue, int light, int overlay) {
        queue.submitModel(model, null, matrices, this.model.getLayer(ElectrolyzerModel.TEXTURE_LOCATION), light, overlay, -1, null);
    }
}
