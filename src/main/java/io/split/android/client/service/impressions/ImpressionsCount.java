package io.split.android.client.service.impressions;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ImpressionsCount {
    private static final String FIELD_PER_FEATURE_COUNTS = "pf";

    @SerializedName(FIELD_PER_FEATURE_COUNTS)
    public final List<ImpressionsCountPerFeature> perFeature;

    public ImpressionsCount(List<ImpressionsCountPerFeature> countList) {
        this.perFeature = countList;
    }

    public int hashCode() {
        return this.perFeature.hashCode();
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ArrayList<ImpressionsCountPerFeature> arrayList = new ArrayList(((ImpressionsCount) o).perFeature);
        ArrayList<ImpressionsCountPerFeature> arrayList2 = new ArrayList(this.perFeature);
        if (arrayList.size() != arrayList2.size()) {
            return false;
        }
        HashMap map = new HashMap();
        for (ImpressionsCountPerFeature impressionsCountPerFeature : arrayList) {
            map.put(impressionsCountPerFeature.feature, impressionsCountPerFeature);
        }
        for (ImpressionsCountPerFeature impressionsCountPerFeature2 : arrayList2) {
            ImpressionsCountPerFeature impressionsCountPerFeature3 = (ImpressionsCountPerFeature) map.get(impressionsCountPerFeature2.feature);
            if (impressionsCountPerFeature3 == null || impressionsCountPerFeature2.count != impressionsCountPerFeature3.count || impressionsCountPerFeature2.timeframe != impressionsCountPerFeature3.timeframe) {
                return false;
            }
        }
        return true;
    }
}
