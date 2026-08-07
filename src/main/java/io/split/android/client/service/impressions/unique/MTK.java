package io.split.android.client.service.impressions.unique;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class MTK {

    @SerializedName("keys")
    private final List<UniqueKey> mKeys;

    public MTK(List<UniqueKey> keys) {
        this.mKeys = keys == null ? new ArrayList<>() : keys;
    }

    public MTK() {
        this(new ArrayList());
    }

    public List<UniqueKey> getKeys() {
        return this.mKeys;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return this.mKeys.equals(((MTK) o).mKeys);
    }

    public int hashCode() {
        return this.mKeys.hashCode();
    }
}
