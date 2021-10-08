package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void TestUpdateQualityDefaultItem() {
        Item[] items = new Item[]{
            new Item("foo", 2, 5),
            new Item("bar", 1, 0),
            new Item("baz", 0, 5)
        };

        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();

        // base case, sellIn and quality should decrease by 1
        assertEquals("foo", items[0].name);
        assertEquals(1, items[0].sellIn);
        assertEquals(4, items[0].quality);

        // test quality not going negative
        assertEquals("bar", items[1].name);
        assertEquals(0, items[1].sellIn);
        assertEquals(0, items[1].quality);

        // test quality decreasing twice as fast when sellIn is negative
        assertEquals("baz", items[2].name);
        assertEquals(-1, items[2].sellIn);
        assertEquals(3, items[2].quality);
    }

    @Test
    void testUpdateQualityAgedBrie() {
        Item[] items = new Item[]{
            new Item("Aged Brie", 2, 5),
            new Item("Aged Brie", 1, 50),
            new Item("Aged Brie", 0, 5)
        };

        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();

        // quality should increase by 1
        assertEquals("Aged Brie", items[0].name);
        assertEquals(1, items[0].sellIn);
        assertEquals(6, items[0].quality);

        // test quality not going above 50
        assertEquals("Aged Brie", items[1].name);
        assertEquals(0, items[1].sellIn);
        assertEquals(50, items[1].quality);

        // test quality increasing twice as fast when sellIn is negative
        assertEquals("Aged Brie", items[2].name);
        assertEquals(-1, items[2].sellIn);
        assertEquals(7, items[2].quality);
    }

    @Test
    void testUpdateQualitySulfuras() {
        Item[] items = new Item[]{
            new Item("Sulfuras, Hand of Ragnaros", 0, 80),
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
        };

        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();

        // test nothing changes
        assertEquals("Sulfuras, Hand of Ragnaros", items[0].name);
        assertEquals(0, items[0].sellIn);
        assertEquals(80, items[0].quality);

        assertEquals("Sulfuras, Hand of Ragnaros", items[1].name);
        assertEquals(-1, items[1].sellIn);
        assertEquals(80, items[1].quality);
    }

    @Test
    void testUpdateQualityBackstagePasses() {
        Item[] items = new Item[]{
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 0, 30),
            new Item("Backstage passes to a TAFKAL80ETC concert", 1, 48),
        };

        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();

        // test increasing quality by 1 when sellIn > 10
        assertEquals("Backstage passes to a TAFKAL80ETC concert", items[0].name);
        assertEquals(14, items[0].sellIn);
        assertEquals(21, items[0].quality);

        // test increasing quality by 2 when sellIn <= 10
        assertEquals("Backstage passes to a TAFKAL80ETC concert", items[1].name);
        assertEquals(9, items[1].sellIn);
        assertEquals(22, items[1].quality);

        // test increasing quality by 3 when sellIn <= 5
        assertEquals("Backstage passes to a TAFKAL80ETC concert", items[2].name);
        assertEquals(4, items[2].sellIn);
        assertEquals(23, items[2].quality);

        // test setting quality to 0 when sellIn < 0
        assertEquals("Backstage passes to a TAFKAL80ETC concert", items[3].name);
        assertEquals(-1, items[3].sellIn);
        assertEquals(0, items[3].quality);

        // test quality not going above 50
        assertEquals("Backstage passes to a TAFKAL80ETC concert", items[4].name);
        assertEquals(0, items[4].sellIn);
        assertEquals(50, items[4].quality);
    }

    @Test
    void testUpdateQualityConjuredItems() {
        Item[] items = new Item[]{
            new Item("Conjured Mana Cake", 3, 6),
            new Item("Conjured Mana Cake", 0, 6)
        };

        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();

        // test quality decreases twice as fast
        assertEquals("Conjured Mana Cake", items[0].name);
        assertEquals(2, items[0].sellIn);
        assertEquals(4, items[0].quality);

        // test quality decreases twice as fast, twice when sellIn is negative
        assertEquals("Conjured Mana Cake", items[1].name);
        assertEquals(-1, items[1].sellIn);
        assertEquals(2, items[1].quality);
    }

}
