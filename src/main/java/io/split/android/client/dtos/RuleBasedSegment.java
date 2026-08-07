package io.split.android.client.dtos;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class RuleBasedSegment {

    @SerializedName("changeNumber")
    private final long mChangeNumber;

    @SerializedName("conditions")
    private final List<Condition> mConditions;

    @SerializedName("excluded")
    private final Excluded mExcluded;

    @SerializedName("name")
    private final String mName;

    @SerializedName("status")
    private final Status mStatus;

    @SerializedName(SerializableEvent.TRAFFIC_TYPE_NAME_FIELD)
    private final String mTrafficTypeName;

    public RuleBasedSegment(String name, String trafficTypeName, long changeNumber, Status status, List<Condition> conditions, Excluded excluded) {
        this.mName = name;
        this.mTrafficTypeName = trafficTypeName;
        this.mChangeNumber = changeNumber;
        this.mStatus = status;
        this.mConditions = conditions;
        this.mExcluded = excluded;
    }

    public String getName() {
        return this.mName;
    }

    public String getTrafficTypeName() {
        return this.mTrafficTypeName;
    }

    public long getChangeNumber() {
        return this.mChangeNumber;
    }

    public Status getStatus() {
        return this.mStatus;
    }

    public List<Condition> getConditions() {
        return this.mConditions;
    }

    public Excluded getExcluded() {
        return this.mExcluded;
    }
}
