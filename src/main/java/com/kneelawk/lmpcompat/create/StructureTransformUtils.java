package com.kneelawk.lmpcompat.create;

import com.simibubi.create.content.contraptions.components.structureMovement.StructureTransform;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.DirectionTransformation;

public class StructureTransformUtils {
    public static DirectionTransformation toDirectionTransformation(StructureTransform st) {
        DirectionTransformation dt = DirectionTransformation.IDENTITY;
        dt = dt.prepend(st.mirror.getDirectionTransformation());

        if (st.rotationAxis == Direction.Axis.X) {
            dt = dt.prepend(DirectionTransformation.ROT_90_Z_NEG);
        } else if (st.rotationAxis == Direction.Axis.Z) {
            dt = dt.prepend(DirectionTransformation.ROT_90_X_POS);
        }

        dt = dt.prepend(st.rotation.getDirectionTransformation());

        if (st.rotationAxis == Direction.Axis.X) {
            dt = dt.prepend(DirectionTransformation.ROT_90_Z_POS);
        } else if (st.rotationAxis == Direction.Axis.Z) {
            dt = dt.prepend(DirectionTransformation.ROT_90_X_NEG);
        }

        return dt;
    }
}
