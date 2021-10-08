package com.gildedrose.itemupdaters;

import com.gildedrose.Item;

public class ConjuredItemUpdater implements ItemUpdater {

    @Override
    public void update(Item item) {
        // "Conjured" items degrade in Quality twice as fast as normal items
        item.quality -= 2;
        item.sellIn--;

        // Once the sell by date has passed, Quality degrades twice as fast
        if (item.sellIn < 0) {
            item.quality -= 4;
        }

        // The Quality of an item is never negative
        if (item.quality < MINIMUM_ITEM_QUALITY) {
            item.quality = MINIMUM_ITEM_QUALITY;
        }
    }
}
