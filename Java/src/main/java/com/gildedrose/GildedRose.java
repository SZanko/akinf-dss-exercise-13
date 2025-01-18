package com.gildedrose;

class GildedRose {
    Item[] items;

    private final DefaultStrategyImpl defaultStrategy = new DefaultStrategyImpl();
    private final AgedBrieStrategyImpl agedBrieStrategy = new AgedBrieStrategyImpl();
    private final BackStagePassStrategyImpl backStagePassStrategy = new BackStagePassStrategyImpl();
    private final SulfurStrategyImpl sulfurStrategy = new SulfurStrategyImpl();

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.name) {
                case "Aged Brie" -> agedBrieStrategy.updateQuality(item);
                case "Backstage passes to a TAFKAL80ETC concert" -> backStagePassStrategy.updateQuality(item);
                case "Sulfuras, Hand of Ragnaros" -> sulfurStrategy.updateQuality(item);
                default -> defaultStrategy.updateQuality(item);
            }
        }
    }
}
