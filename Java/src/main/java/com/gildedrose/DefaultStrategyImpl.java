package com.gildedrose;

public class DefaultStrategyImpl implements Strategy {
    @Override
    public Item[] updateQuality(Item[] items) {
        for (Item item : items) {
            if (item.quality() > 0) {
                item.quality = item.quality - 1;
            }
        }
    }
}
