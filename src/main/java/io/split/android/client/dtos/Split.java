package io.split.android.client.dtos;

import com.google.gson.annotations.SerializedName;
import io.split.android.client.TreatmentLabels;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class Split {

    @SerializedName("algo")
    public int algo;

    @SerializedName("changeNumber")
    public long changeNumber;

    @SerializedName("conditions")
    public List<Condition> conditions;

    @SerializedName("configurations")
    public Map<String, String> configurations;

    @SerializedName("defaultTreatment")
    public String defaultTreatment;

    @SerializedName("impressionsDisabled")
    public boolean impressionsDisabled;
    public String json;

    @SerializedName(TreatmentLabels.KILLED)
    public boolean killed;

    @SerializedName("name")
    public String name;

    @SerializedName("prerequisites")
    public List<Prerequisite> prerequisites;

    @SerializedName("seed")
    public int seed;

    @SerializedName("sets")
    public Set<String> sets;

    @SerializedName("status")
    public Status status;

    @SerializedName("trafficAllocation")
    public Integer trafficAllocation;

    @SerializedName("trafficAllocationSeed")
    public Integer trafficAllocationSeed;

    @SerializedName(SerializableEvent.TRAFFIC_TYPE_NAME_FIELD)
    public String trafficTypeName;

    public Split() {
        this.impressionsDisabled = false;
        this.json = null;
    }

    public Split(String name, String json) {
        this.impressionsDisabled = false;
        this.name = name;
        this.json = json;
    }

    public List<Prerequisite> getPrerequisites() {
        List<Prerequisite> list = this.prerequisites;
        return list == null ? new ArrayList() : list;
    }
}
