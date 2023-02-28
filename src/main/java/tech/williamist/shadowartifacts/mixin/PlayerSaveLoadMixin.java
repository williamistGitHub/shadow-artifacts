package tech.williamist.shadowartifacts.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import tech.williamist.shadowartifacts.ShadowArtifacts;
import tech.williamist.shadowartifacts.events.SaveLoadDataCallback;

@Mixin(PlayerEntity.class)
public abstract class PlayerSaveLoadMixin {

    @Inject(method = "readCustomDataFromNbt", at = @At("TAIL"))
    protected void onReadNbt(NbtCompound nbt, CallbackInfo info) {
        System.out.println("DEBUG: Player read nbt data.");
        // if there is custom data there
        if (nbt.contains(ShadowArtifacts.MOD_ID)) {
            SaveLoadDataCallback.PLAYER_LOAD.invoker().interact((PlayerEntity)(Object)this, nbt.getCompound(ShadowArtifacts.MOD_ID));
        }
    }

    @Inject(method = "writeCustomDataToNbt", at = @At("TAIL"))
    protected void onWriteNbt(NbtCompound nbt, CallbackInfo info) {
        if (!nbt.contains(ShadowArtifacts.MOD_ID))
            nbt.put(ShadowArtifacts.MOD_ID, new NbtCompound());
        System.out.println("DEBUG: Player wrote nbt data.");
        SaveLoadDataCallback.PLAYER_SAVE.invoker().interact((PlayerEntity)(Object)this, nbt.getCompound(ShadowArtifacts.MOD_ID));
    }

}
