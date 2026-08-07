package sdk.pendo.io.models;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.b0.c;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\"\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003\u0018\u00010\u0003\u0012\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J%\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003\u0018\u00010\u0003HÆ\u0003J%\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003\u0018\u00010\u0003HÆ\u0003JU\u0010\u000f\u001a\u00020\u00002$\b\u0002\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003\u0018\u00010\u00032$\b\u0002\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0004HÖ\u0001R:\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR:\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u0016"}, d2 = {"Lsdk/pendo/io/models/MetadataModel;", "", "visitorMetaData", "", "", "accountMetaData", "(Ljava/util/Map;Ljava/util/Map;)V", "getAccountMetaData", "()Ljava/util/Map;", "setAccountMetaData", "(Ljava/util/Map;)V", "getVisitorMetaData", "setVisitorMetaData", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class MetadataModel {

    @c("account")
    private Map<String, ? extends Map<String, ? extends Object>> accountMetaData;

    @c(GlobalEventPropertiesKt.VISITOR_KEY)
    private Map<String, ? extends Map<String, ? extends Object>> visitorMetaData;

    public MetadataModel(Map<String, ? extends Map<String, ? extends Object>> map, Map<String, ? extends Map<String, ? extends Object>> map2) {
        this.visitorMetaData = map;
        this.accountMetaData = map2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MetadataModel copy$default(MetadataModel metadataModel, Map map, Map map2, int i, Object obj) {
        if ((i & 1) != 0) {
            map = metadataModel.visitorMetaData;
        }
        if ((i & 2) != 0) {
            map2 = metadataModel.accountMetaData;
        }
        return metadataModel.copy(map, map2);
    }

    public final Map<String, Map<String, Object>> component1() {
        return this.visitorMetaData;
    }

    public final Map<String, Map<String, Object>> component2() {
        return this.accountMetaData;
    }

    public final MetadataModel copy(Map<String, ? extends Map<String, ? extends Object>> visitorMetaData, Map<String, ? extends Map<String, ? extends Object>> accountMetaData) {
        return new MetadataModel(visitorMetaData, accountMetaData);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MetadataModel)) {
            return false;
        }
        MetadataModel metadataModel = (MetadataModel) other;
        return Intrinsics.areEqual(this.visitorMetaData, metadataModel.visitorMetaData) && Intrinsics.areEqual(this.accountMetaData, metadataModel.accountMetaData);
    }

    public final Map<String, Map<String, Object>> getAccountMetaData() {
        return this.accountMetaData;
    }

    public final Map<String, Map<String, Object>> getVisitorMetaData() {
        return this.visitorMetaData;
    }

    public int hashCode() {
        Map<String, ? extends Map<String, ? extends Object>> map = this.visitorMetaData;
        int iHashCode = (map == null ? 0 : map.hashCode()) * 31;
        Map<String, ? extends Map<String, ? extends Object>> map2 = this.accountMetaData;
        return iHashCode + (map2 != null ? map2.hashCode() : 0);
    }

    public final void setAccountMetaData(Map<String, ? extends Map<String, ? extends Object>> map) {
        this.accountMetaData = map;
    }

    public final void setVisitorMetaData(Map<String, ? extends Map<String, ? extends Object>> map) {
        this.visitorMetaData = map;
    }

    public String toString() {
        return "MetadataModel(visitorMetaData=" + this.visitorMetaData + ", accountMetaData=" + this.accountMetaData + ")";
    }
}
