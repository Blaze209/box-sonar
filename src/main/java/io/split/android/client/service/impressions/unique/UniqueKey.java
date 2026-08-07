package io.split.android.client.service.impressions.unique;

import com.google.gson.annotations.SerializedName;
import io.split.android.client.dtos.Identifiable;
import java.util.HashSet;
import java.util.Set;
import sdk.pendo.io.views.custom.videoplayer.youtube.PendoYoutubePlayer;

/* JADX INFO: loaded from: classes4.dex */
public class UniqueKey implements Identifiable {

    @SerializedName(PendoYoutubePlayer.FS_PARAMETER)
    private final Set<String> mFeatures;

    @SerializedName("k")
    private final String mKey;
    private transient long storageId;

    public UniqueKey(String key, Set<String> features) {
        this.mKey = key;
        this.mFeatures = features;
    }

    public UniqueKey(String key) {
        this(key, new HashSet());
    }

    public String getKey() {
        return this.mKey;
    }

    public Set<String> getFeatures() {
        return this.mFeatures;
    }

    @Override // io.split.android.client.dtos.Identifiable
    public long getId() {
        return this.storageId;
    }

    public void setStorageId(long storageId) {
        this.storageId = storageId;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o != null && getClass() == o.getClass()) {
            UniqueKey uniqueKey = (UniqueKey) o;
            if (this.mKey.equals(uniqueKey.mKey) && this.mFeatures.equals(uniqueKey.mFeatures)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.mKey.hashCode() + this.mFeatures.hashCode();
    }
}
