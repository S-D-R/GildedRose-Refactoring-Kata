package com.gildedrose.itemupdaters;

import com.gildedrose.Item;

public class AgedBrieItemUpdater implements ItemUpdater {

    @Override
    public void update(Item item) {
        // "Aged Brie" actually increases in Quality the older it gets
        item.quality++;
        item.sellIn--;

        // Once the sell by date has passed, Quality degrades twice as fast
        // => aged brie improves twice as fast
        if (item.sellIn < 0) {
            item.quality++;
        }

        // The Quality of an item is never more than 50
        if (item.quality > MAXIMUM_ITEM_QUALITY) {
            item.quality = MAXIMUM_ITEM_QUALITY;
        }
    }
}
