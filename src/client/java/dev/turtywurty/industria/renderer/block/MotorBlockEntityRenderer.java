package dev.turtywurty.industria.renderer.block;

import dev.turtywurty.industria.blockentity.MotorBlockEntity;
import dev.turtywurty.industria.model.MotorModel;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.command.ModelCommandRenderer;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.Nullable;

public class MotorBlockEntityRenderer implements BlockEntityRenderer<MotorBlockEntity> {
    private final BlockEntityRendererFactory.Context context;
    private final MotorModel model;

    public MotorBlockEntityRenderer(BlockEntityRendererFactory.Context context) {
        this.context = context;

        this.model = new MotorModel(context.getLayerModelPart(MotorModel.LAYER_LOCATION));
    }

    @Override
    public void render(MotorBlockEntity entity, float tickProgress, MatrixStack matrices, int light, int overlay, Vec3d cameraPos, @Nullable ModelCommandRenderer.CrumblingOverlayCommand crumblingOverlayCommand, OrderedRenderCommandQueue orderedRenderCommandQueue) {
        matrices.push();
        matrices.translate(0.5, 1.5, 0.5);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(180));

        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180 + switch (entity.getCachedState().get(Properties.HORIZONTAL_FACING)) {
            case EAST -> 90;
            case SOUTH -> 180;
            case WEST -> 270;
            default -> 0;
        }));

        float rotationSpeed = entity.getRotationSpeed();
        entity.rodRotation += rotationSpeed * tickProgress;

        this.model.getMotorParts().spinRod().pitch = entity.rodRotation;
        orderedRenderCommandQueue.submitModel(model, null, matrices, model.getLayer(MotorModel.TEXTURE_LOCATION), light, overlay, -1, null);
        this.model.getMotorParts().spinRod().pitch = 0;

        matrices.pop();
    }
}
