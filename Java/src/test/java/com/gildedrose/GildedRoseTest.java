package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    private final GildedRose app = new GildedRose(null);

    @Test
    void GIVEN_nonValidName_WHEN_updateQualityAndQualityUnder50AndSelling0_THEN_updateQuality() {
        final Item[] items = new Item[] { new Item("foo", 0, 49) };
        app.items = items;
        app.updateQuality();
        assertEquals(47, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void GIVEN_nonValidName_WHEN_updateQualityAndQualityUnder0AndSelling0_THEN_updateQuality() {
        final Item[] items = new Item[] { new Item("foo", 0, -1) };
        app.items = items;
        app.updateQuality();
        assertEquals(-1, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void GIVEN_validName_WHEN_updateQualityAndQualityUnder0AndSelling0_THEN_updateQuality() {
        final Item[] items = new Item[] { new Item("Aged Brie", 0, -1) };
        app.items = items;
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(1, app.items[0].quality);
    }

    @Test
    void normalItemDegradesInQuality() {
        Item[] items = new Item[] { new Item("foo", 10, 20) };
        app.items = items;
        app.updateQuality();
        assertEquals(19, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    void agedBrieIncreasesInQuality() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 20) };
        app.items = items;
        app.updateQuality();
        assertEquals(21, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    void sulfurasNeverDecreasesInQuality() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 10, 80) };
        app.items = items;
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
        assertEquals(10, app.items[0].sellIn);
    }

    @Test
    void backstagePassesIncreaseInQuality() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) };
        app.items = items;
        app.updateQuality();
        assertEquals(21, app.items[0].quality);
        assertEquals(14, app.items[0].sellIn);
    }

    @Test
    void backstagePassesIncreaseInQualityBy2When10DaysOrLess() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20) };
        app.items = items;
        app.updateQuality();
        assertEquals(22, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    void backstagePassesIncreaseInQualityBy3When5DaysOrLess() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20) };
        app.items = items;
        app.updateQuality();
        assertEquals(23, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);
    }

    @Test
    void backstagePassesDropToZeroAfterConcert() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20) };
        app.items = items;
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

}
