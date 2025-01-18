package com.gildedrose;

public class SulfurStrategyImpl implements Strategy {
    @Override
    public Item updateQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
        return item;
    }
}
