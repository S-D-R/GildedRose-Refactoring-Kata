package com.gildedrose.itemupdaters;

import com.gildedrose.Item;

public class SulfurasItemUpdater implements ItemUpdater {

    @Override
    public void update(Item item) {
        // "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
        // => do nothing
    }
}
