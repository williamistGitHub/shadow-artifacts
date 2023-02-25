package tech.williamist.shadowartifacts.artifacts.urkolows;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Rarity;

public class UrkolowsJournalItem extends Item {

    public UrkolowsJournalItem() {
        super(new FabricItemSettings()
                .maxCount(1)
                .rarity(Rarity.UNCOMMON)
        );
    }

}
