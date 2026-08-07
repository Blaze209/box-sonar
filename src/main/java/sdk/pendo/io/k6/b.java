package sdk.pendo.io.k6;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¨\u0006\u0006"}, d2 = {"Lsdk/pendo/io/a5/a;", "Lsdk/pendo/io/m6/a;", "event", "Lsdk/pendo/io/a5/a$a;", "fn", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "pendoIO_release"}, k = 2, mv = {1, 9, 0})
public final class b {
    public static final sdk.pendo.io.a5.a a(sdk.pendo.io.a5.a aVar, sdk.pendo.io.m6.a event, sdk.pendo.io.a5.a.InterfaceC0343a interfaceC0343a) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        Intrinsics.checkNotNullParameter(event, "event");
        sdk.pendo.io.a5.a aVarB = aVar.b(event.b(), interfaceC0343a);
        Intrinsics.checkNotNullExpressionValue(aVarB, "on(...)");
        return aVarB;
    }
}
