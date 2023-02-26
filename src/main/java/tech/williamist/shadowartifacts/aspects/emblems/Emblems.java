package tech.williamist.shadowartifacts.aspects.emblems;

import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import tech.williamist.shadowartifacts.CustomRegistries;
import tech.williamist.shadowartifacts.ShadowArtifacts;
import tech.williamist.shadowartifacts.items.ItemHolder;
import tech.williamist.shadowartifacts.items.UnregisteredItem;

import java.lang.reflect.Field;

public final class Emblems {

    public static final Emblem FRIGHT = new Emblem(
            new Identifier[] {
                    new Identifier("minecraft", "spider"),
                    new Identifier("minecraft", "cave_spider")
            },
            new int[] {
                    20, // form 1/2
                    30, // form 3-1
                    20, // form 3-2
                    50  // form 4
            }
    );

    public static void registerAllEmblems() {
        for (Field f : Emblems.class.getDeclaredFields()) {
            if (f.getType() == Emblem.class) {
                try {
                    Registry.register(CustomRegistries.EMBLEMS, ShadowArtifacts.createIdentifier(f.getName().toLowerCase()), (Emblem)f.get(null));
                } catch (IllegalAccessException e) {
                    System.out.println("Couldn't access field " + f.getName() + " whilst registering emblems.");
                }
            }
        }
    }

}
