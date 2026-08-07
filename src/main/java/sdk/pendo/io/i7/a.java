package sdk.pendo.io.i7;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.a0.l;
import sdk.pendo.io.models.GlobalEventPropertiesKt;
import sdk.pendo.io.models.SessionData;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¨\u0006\u0003"}, d2 = {"Lsdk/pendo/io/models/SessionData;", "Lsdk/pendo/io/a0/l;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "pendoIO_release"}, k = 2, mv = {1, 9, 0})
public final class a {
    public static final l a(SessionData sessionData) {
        Intrinsics.checkNotNullParameter(sessionData, "<this>");
        l lVar = new l();
        lVar.a("visitorId", sessionData.getVisitorId());
        lVar.a("accountId", sessionData.getAccountId());
        l lVar2 = new l();
        l lVar3 = new l();
        Map<String, Object> visitorData = sessionData.getVisitorData();
        if (visitorData != null) {
            for (Map.Entry<String, Object> entry : visitorData.entrySet()) {
                lVar3.a(entry.getKey(), String.valueOf(entry.getValue()));
            }
        }
        Unit unit = Unit.INSTANCE;
        lVar2.a(GlobalEventPropertiesKt.VISITOR_KEY, lVar3);
        l lVar4 = new l();
        Map<String, Object> accountData = sessionData.getAccountData();
        if (accountData != null) {
            for (Map.Entry<String, Object> entry2 : accountData.entrySet()) {
                lVar4.a(entry2.getKey(), String.valueOf(entry2.getValue()));
            }
        }
        Unit unit2 = Unit.INSTANCE;
        lVar2.a("account", lVar4);
        Unit unit3 = Unit.INSTANCE;
        lVar.a("metadata", lVar2);
        return lVar;
    }
}
