package com.microsoft.identity.common.java.controllers;

import com.microsoft.identity.common.java.commands.BaseCommand;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public class CommandResultCache {
    private static final int DEFAULT_ITEM_COUNT = 250;
    private final Object cacheLock;
    private final Map<BaseCommand, CommandResultCacheItem> mCache;

    public CommandResultCache() {
        this(250);
    }

    public CommandResultCache(final int i) {
        this.cacheLock = new Object();
        this.mCache = new LinkedHashMap<BaseCommand, CommandResultCacheItem>(i + 1, 0.75f, true) { // from class: com.microsoft.identity.common.java.controllers.CommandResultCache.1
            @Override // java.util.LinkedHashMap
            protected boolean removeEldestEntry(Map.Entry<BaseCommand, CommandResultCacheItem> entry) {
                return size() > i;
            }
        };
    }

    public CommandResult get(BaseCommand baseCommand) {
        synchronized (this.cacheLock) {
            CommandResultCacheItem commandResultCacheItem = this.mCache.get(baseCommand);
            if (commandResultCacheItem == null) {
                return null;
            }
            if (commandResultCacheItem.isExpired()) {
                this.mCache.remove(baseCommand);
                return null;
            }
            return commandResultCacheItem.getValue();
        }
    }

    public void put(BaseCommand baseCommand, CommandResult commandResult) {
        synchronized (this.cacheLock) {
            this.mCache.put(baseCommand, new CommandResultCacheItem(commandResult));
        }
    }

    public int getSize() {
        int size;
        synchronized (this.cacheLock) {
            size = this.mCache.size();
        }
        return size;
    }

    public void clear() {
        synchronized (this.cacheLock) {
            this.mCache.clear();
        }
    }
}
