package tech.williamist.shadowartifacts.aspects.emblems;

import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;

public class Emblem {

    public boolean isDroppedFromMobs = true;
    public Identifier[] mobsDroppedFrom = null;
    public int[] dropPercentages = null;

    public Emblem(Identifier[] mobsDroppedFrom, int[] dropPercentages) {
        this.mobsDroppedFrom = mobsDroppedFrom;
        this.dropPercentages = dropPercentages;
    }

    public Emblem() {
        this.isDroppedFromMobs = false;
    }

}
