package com.gildedrose.itemupdaters;

import com.gildedrose.Item;

public class BackstagePassesItemUpdater implements ItemUpdater {

    @Override
    public void update(Item item) {
        // "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
        item.quality++;

        // Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less
        if (item.sellIn <= 10) {
            item.quality++;
        }

        if (item.sellIn <= 5) {
            item.quality++;
        }

        // The Quality of an item is never more than 50
        if (item.quality > MAXIMUM_ITEM_QUALITY) {
            item.quality = MAXIMUM_ITEM_QUALITY;
        }

        item.sellIn--;

        // but Quality drops to 0 after the concert
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }
}
