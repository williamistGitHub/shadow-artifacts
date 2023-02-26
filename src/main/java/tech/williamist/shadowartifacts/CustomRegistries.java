package tech.williamist.shadowartifacts;

import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.fabricmc.fabric.api.event.registry.RegistryAttribute;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import tech.williamist.shadowartifacts.aspects.emblems.Emblem;

public final class CustomRegistries {

    private static final RegistryKey<Registry<Emblem>> EMBLEMS_KEY = RegistryKey.ofRegistry(
            ShadowArtifacts.createIdentifier("emblems_registry")
    );
    public static final Registry<Emblem> EMBLEMS = FabricRegistryBuilder.createSimple(
            EMBLEMS_KEY
    )
            .attribute(RegistryAttribute.SYNCED)
            .buildAndRegister();

}
