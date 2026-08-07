package sdk.pendo.io.r5;

import androidx.core.util.Pair;
import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import sdk.pendo.io.logging.PendoLogger;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ$\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0016\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\r"}, d2 = {"Lsdk/pendo/io/r5/c;", "", "Lorg/json/JSONObject;", "event", "Lsdk/pendo/io/a0/f;", "immediateEventsArray", "Landroidx/core/util/Pair;", "", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "immediateEvent", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class c {
    public static final c a = new c();

    private c() {
    }

    public final Pair<Boolean, String> a(JSONObject event, sdk.pendo.io.a0.f immediateEventsArray) {
        Intrinsics.checkNotNullParameter(event, "event");
        Pair<Boolean, String> pair = new Pair<>(Boolean.FALSE, "");
        if (immediateEventsArray != null) {
            int size = immediateEventsArray.size();
            for (int i = 0; i < size; i++) {
                try {
                    String strG = immediateEventsArray.a(i).g();
                    Intrinsics.checkNotNull(strG);
                    if (a(strG, event)) {
                        return new Pair<>(Boolean.TRUE, a(event) ? "previous_visitor_end_session_analytics" : "");
                    }
                    continue;
                } catch (Exception e) {
                    PendoLogger.d("AnalyticEventsManagerHelper + isShouldFlush " + e.getMessage(), new Object[0]);
                }
            }
        }
        return pair;
    }

    public final boolean a(JSONObject event) {
        Intrinsics.checkNotNullParameter(event, "event");
        d dVar = d.APP_SESSION_END;
        return Intrinsics.areEqual(dVar.b(), event.optString("event")) || Intrinsics.areEqual(dVar.b(), event.optString("type"));
    }

    public final boolean a(String immediateEvent, JSONObject event) {
        Intrinsics.checkNotNullParameter(immediateEvent, "immediateEvent");
        Intrinsics.checkNotNullParameter(event, "event");
        return Intrinsics.areEqual(immediateEvent, event.optString("event")) || Intrinsics.areEqual(immediateEvent, event.optString("type"));
    }
}
