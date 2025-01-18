package com.gildedrose;

public class AgedBrieStrategyImpl implements Strategy {
    @Override
    public Item updateQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0 && item.quality < 50) {
            item.quality = item.quality + 1;
        }
        return item;
    }
}
