package tech.williamist.shadowartifacts.items;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import tech.williamist.shadowartifacts.ShadowArtifacts;

public final class UnregisteredItem {

    private Item item;
    private Identifier id;

    public UnregisteredItem(Item item, Identifier id) {
        this.item = item;
        this.id = id;
    }

    public UnregisteredItem(Item item, String id) {
        this(item, ShadowArtifacts.createIdentifier(id));
    }

    public void register() {
        Registry.register(Registries.ITEM, this.id, this.item);
    }

    public Item getItem() {
        return this.item;
    }

}
