package tech.williamist.shadowartifacts.items;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import tech.williamist.shadowartifacts.ShadowArtifacts;
import tech.williamist.shadowartifacts.artifacts.urkolows.UrkolowsJournalItem;

import java.lang.reflect.Field;

public final class ItemHolder {

    public static final UnregisteredItem URKOLOWS_JOURNAL = new UnregisteredItem(
            new UrkolowsJournalItem(),
            "urkolows_journal"
    );

    public static void registerAllItems() {
        for (Field f : ItemHolder.class.getDeclaredFields()) {
            if (f.getType() == UnregisteredItem.class) {
                try {
                    ((UnregisteredItem)f.get(null)).register();
                } catch (IllegalAccessException e) {
                    System.out.println("Couldn't access field " + f.getName() + " whilst registering items.");
                }
            }
        }
    }

}
