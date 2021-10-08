package com.gildedrose.itemupdaters;

import com.gildedrose.Item;

public interface ItemUpdater {
    int MINIMUM_ITEM_QUALITY = 0; // The Quality of an item is never negative
    int MAXIMUM_ITEM_QUALITY = 50; // The Quality of an item is never more than 50

    void update(Item item);
}
