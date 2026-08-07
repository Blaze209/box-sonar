package com.box.android.domain.localrepo.sqlitetables;

import com.box.androidsdk.content.models.BoxEntity;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;

/* JADX INFO: loaded from: classes11.dex */
@DatabaseTable(tableName = "BoxFeedCaching")
@Deprecated
public class BoxFeedCachingSQLData extends BoxTypedObjectSQLData {
    public static final String FEED_CACHE_ID = "cache_id";
    public static final String FEED_CACHE_ORDER = "cache_order";
    public static final String FEED_CACHE_PARENT_ID = "cache_parent_id";
    public static final String FEED_CACHE_PARENT_TYPE = "cache_parent_type";
    public static final String FEED_CACHE_TYPE = "cache_type";

    @DatabaseField(canBeNull = false)
    private String cache_id;

    @DatabaseField(canBeNull = false)
    private int cache_order;

    @DatabaseField(canBeNull = false, index = true)
    private String cache_parent_id;

    @DatabaseField(canBeNull = false, index = true)
    private String cache_parent_type;

    @DatabaseField(canBeNull = false)
    private String cache_type;

    public BoxFeedCachingSQLData() {
    }

    public BoxFeedCachingSQLData(BoxEntity boxEntity, String str, String str2, int i) {
        super(boxEntity.getType() + "_" + boxEntity.getUserId() + "," + str2 + CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR + str);
        this.cache_type = boxEntity.getType();
        this.cache_id = boxEntity.getUserId();
        this.cache_parent_id = str;
        this.cache_parent_type = str2;
        this.cache_order = i;
    }

    public String getCachedType() {
        return this.cache_type;
    }

    public String getCachedId() {
        return this.cache_id;
    }

    public String getParentType() {
        return this.cache_parent_type;
    }

    public String getParentId() {
        return this.cache_parent_id;
    }

    public int getSortOrder() {
        return this.cache_order;
    }

    public void setSortOrder(int i) {
        this.cache_order = i;
    }
}
