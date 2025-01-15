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
        assertEquals(0, app.items[0].sellIn);
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




}
