package sdk.pendo.io.l7;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.a0.l;
import sdk.pendo.io.e2.c0;
import sdk.pendo.io.e2.x;
import sdk.pendo.io.h7.g;
import sdk.pendo.io.h7.m;
import sdk.pendo.io.models.SessionData;
import sdk.pendo.io.p7.d;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u0005\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\nR\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lsdk/pendo/io/l7/b;", "Lsdk/pendo/io/l7/a;", "", "json", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lsdk/pendo/io/models/SessionData;", "sessionData", "Lsdk/pendo/io/h7/m;", "(Lsdk/pendo/io/models/SessionData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lsdk/pendo/io/p7/d;", "Lsdk/pendo/io/p7/d;", "api", "Lsdk/pendo/io/h7/g;", "b", "Lsdk/pendo/io/h7/g;", "platformConfigs", "<init>", "(Lsdk/pendo/io/p7/d;Lsdk/pendo/io/h7/g;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final d api;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final g platformConfigs;

    public b(d api, g platformConfigs) {
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(platformConfigs, "platformConfigs");
        this.api = api;
        this.platformConfigs = platformConfigs;
    }

    @Override // sdk.pendo.io.l7.a
    public Object a(SessionData sessionData, Continuation<? super m> continuation) {
        String string;
        l lVarA;
        d dVar = this.api;
        c0.Companion companion = c0.INSTANCE;
        if (sessionData == null || (lVarA = sdk.pendo.io.i7.a.a(sessionData)) == null || (string = lVarA.toString()) == null) {
            string = "{}";
        }
        return dVar.b(companion.a(string, x.INSTANCE.b("application/json")), this.platformConfigs.a(), String.valueOf(System.currentTimeMillis()), continuation);
    }

    @Override // sdk.pendo.io.l7.a
    public Object a(String str, Continuation<? super Unit> continuation) {
        Object objA = this.api.a(c0.Companion.a(c0.INSTANCE, str, null, 1, null), this.platformConfigs.a(), String.valueOf(System.currentTimeMillis()), continuation);
        return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Unit.INSTANCE;
    }
}
