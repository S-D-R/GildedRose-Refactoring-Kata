package com.gildedrose.itemupdaters;

import com.gildedrose.Item;

public class ItemUpdaterFactory {

    // NOTE: we cache each item updater to avoid unnecessary allocations
    private static final DefaultItemUpdater DEFAULT_ITEM_UPDATER = new DefaultItemUpdater();
    private static final AgedBrieItemUpdater AGED_BRIE_ITEM_UPDATER = new AgedBrieItemUpdater();
    private static final SulfurasItemUpdater SULFURAS_ITEM_UPDATER = new SulfurasItemUpdater();
    private static final BackstagePassesItemUpdater BACKSTAGE_PASSES_ITEM_UPDATER = new BackstagePassesItemUpdater();

    public static ItemUpdater getItemUpdaterFor(Item item) {
        if (item.name.equals("Aged Brie")) {
            return AGED_BRIE_ITEM_UPDATER;
        }

        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return SULFURAS_ITEM_UPDATER;
        }

        if (item.name.startsWith("Backstage passes")) {
            return BACKSTAGE_PASSES_ITEM_UPDATER;
        }

        return DEFAULT_ITEM_UPDATER;
    }

}
