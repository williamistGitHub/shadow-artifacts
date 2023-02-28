package tech.williamist.shadowartifacts;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import tech.williamist.shadowartifacts.aspects.emblems.EmblemManagerCommand;
import tech.williamist.shadowartifacts.aspects.emblems.Emblems;
import tech.williamist.shadowartifacts.items.ItemHolder;

public class ShadowArtifacts implements ModInitializer {

    public static final String MOD_ID = "shadow_artifacts";

    public static Identifier createIdentifier(String path) {
        return new Identifier(MOD_ID, path);
    }

    // item group
    private static final ItemGroup ITEM_GROUP = FabricItemGroup.builder(createIdentifier("item_group"))
            .icon(() -> new ItemStack(ItemHolder.URKOLOWS_JOURNAL.getItem()))
            .build();

    @Override
    public void onInitialize() {
        ItemHolder.registerAllItems();
        Emblems.registerAllEmblems();
        ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP).register(content -> {
            content.add(ItemHolder.URKOLOWS_JOURNAL.getItem());
        });
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            EmblemManagerCommand.register(dispatcher);
        });
    }

}
