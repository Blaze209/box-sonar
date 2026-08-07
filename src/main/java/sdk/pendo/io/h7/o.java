package sdk.pendo.io.h7;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\u0003\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\bR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\f¨\u0006\u0011"}, d2 = {"Lsdk/pendo/io/h7/o;", "", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", "Lsdk/pendo/io/h7/q;", "recordingData", "", "Lorg/json/JSONArray;", "c", "b", "", "Ljava/util/List;", "mutablePayloadData", "payloadData", "<init>", "(Ljava/util/List;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class o {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final List<q> mutablePayloadData;

    public o(List<? extends q> payloadData) {
        Intrinsics.checkNotNullParameter(payloadData, "payloadData");
        this.mutablePayloadData = CollectionsKt.toMutableList((Collection) payloadData);
    }

    public final void a(List<? extends q> recordingData) {
        Intrinsics.checkNotNullParameter(recordingData, "recordingData");
        this.mutablePayloadData.addAll(recordingData);
    }

    public final JSONArray b() {
        JSONArray jSONArray = new JSONArray();
        Iterator<T> it = this.mutablePayloadData.iterator();
        while (it.hasNext()) {
            jSONArray.put(((q) it.next()).a());
        }
        return jSONArray;
    }

    public final JSONArray c() {
        JSONArray jSONArray = new JSONArray();
        Iterator<T> it = this.mutablePayloadData.iterator();
        while (it.hasNext()) {
            jSONArray.put(((q) it.next()).b());
        }
        return jSONArray;
    }

    public final int a() {
        return this.mutablePayloadData.size();
    }
}
