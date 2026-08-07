package com.box.android.adapters.listitems;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/* JADX INFO: loaded from: classes9.dex */
public class NavigationBarItem {
    public static final int TYPE_ALL_FILES = 3;
    public static final int TYPE_COLLECTION = 5;
    public static final int TYPE_FILE = 1;
    public static final int TYPE_FOLDER = 2;
    public static final int TYPE_MY_COLLECTIONS = 6;
    public static final int TYPE_OFFLINE_ITEMS = 4;
    private final String mId;
    private final String mName;
    private final int mType;

    public NavigationBarItem(int i, String str, String str2) {
        this.mType = i;
        this.mId = str;
        this.mName = str2;
    }

    public int getType() {
        return this.mType;
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public int hashCode() {
        return new HashCodeBuilder(61, 17).append(this.mId).append(this.mType).toHashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof NavigationBarItem)) {
            return false;
        }
        NavigationBarItem navigationBarItem = (NavigationBarItem) obj;
        return new EqualsBuilder().append(this.mId, navigationBarItem.mId).append(this.mType, navigationBarItem.mType).isEquals();
    }
}
