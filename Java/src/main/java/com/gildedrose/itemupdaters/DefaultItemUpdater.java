package com.gildedrose.itemupdaters;

import com.gildedrose.Item;

public class DefaultItemUpdater implements ItemUpdater {

    @Override
    public void update(Item item) {
        /*
        - All items have a SellIn value which denotes the number of days we have to sell the item
	    - All items have a Quality value which denotes how valuable the item is
	    - At the end of each day our system lowers both values for every item
        */
        item.quality--;
        item.sellIn--;

        // Once the sell by date has passed, Quality degrades twice as fast
        if (item.sellIn < 0) {
            item.quality--;
        }

        // The Quality of an item is never negative
        if (item.quality < MINIMUM_ITEM_QUALITY) {
            item.quality = MINIMUM_ITEM_QUALITY;
        }
    }
}
