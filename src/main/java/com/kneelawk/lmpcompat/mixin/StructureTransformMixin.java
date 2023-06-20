package com.kneelawk.lmpcompat.mixin;

import com.simibubi.create.content.contraptions.StructureTransform;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;

import alexiil.mc.lib.multipart.impl.LibMultiPart;
import alexiil.mc.lib.multipart.impl.MultipartBlockEntity;

import com.kneelawk.lmpcompat.create.StructureTransformUtils;

/**
 * This mixin gets Create and LMP to play nice together.
 */
@Mixin(StructureTransform.class)
public class StructureTransformMixin {
    @Inject(method = "apply(Lnet/minecraft/block/BlockState;)Lnet/minecraft/block/BlockState;", at = @At("HEAD"),
        cancellable = true)
    private void onApplyBlockState(BlockState state, CallbackInfoReturnable<BlockState> cir) {
        if (state.getBlock() == LibMultiPart.BLOCK) {
            // immediately cancel here because we want to do all transformations on the BlockEntity directly
            cir.setReturnValue(state);
        }
    }

    @Inject(method = "apply(Lnet/minecraft/block/entity/BlockEntity;)V", at = @At("HEAD"))
    private void onApplyTileEntity(BlockEntity te, CallbackInfo ci) {
        if (te instanceof MultipartBlockEntity multi && multi.isServerWorld()) {
            StructureTransform st = (StructureTransform) (Object) this;
            multi.applyTransformation(StructureTransformUtils.toDirectionTransformation(st));
        }
    }
}
