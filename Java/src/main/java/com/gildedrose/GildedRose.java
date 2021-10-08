package com.gildedrose;

import com.gildedrose.itemupdaters.ItemUpdaterFactory;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemUpdaterFactory.getItemUpdaterFor(item).update(item);
        }
    }
}
