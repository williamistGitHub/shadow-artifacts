package tech.williamist.shadowartifacts.events;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.ActionResult;

public interface SaveLoadDataCallback {

    Event<SaveLoadDataCallback> PLAYER_SAVE = EventFactory.createArrayBacked(SaveLoadDataCallback.class,
            (listeners) -> (player, nbt) -> {

                for (SaveLoadDataCallback listener : listeners) {
                    ActionResult result = listener.interact(player, nbt);

                    if (result != ActionResult.PASS)
                        return result;
                }

                return ActionResult.PASS;

            });

    Event<SaveLoadDataCallback> PLAYER_LOAD = EventFactory.createArrayBacked(SaveLoadDataCallback.class,
            (listeners) -> (player, nbt) -> {

                for (SaveLoadDataCallback listener : listeners) {
                    ActionResult result = listener.interact(player, nbt);

                    if (result != ActionResult.PASS)
                        return result;
                }

                return ActionResult.PASS;

            });

    ActionResult interact(PlayerEntity player, NbtCompound nbt);

}
