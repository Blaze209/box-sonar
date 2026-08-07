package sdk.pendo.io.s7;

import androidx.media3.exoplayer.upstream.CmcdData;
import external.sdk.pendo.io.gson.Gson;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.actions.PendoCommandAction;
import sdk.pendo.io.actions.PendoCommandEventType;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0003\u001a\u00020\u0002R\u001c\u0010\u0007\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006R\u001c\u0010\n\u001a\n \u0005*\u0004\u0018\u00010\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lsdk/pendo/io/s7/k0;", "", "Lexternal/sdk/pendo/io/gson/Gson;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lexternal/sdk/pendo/io/gson/a;", "kotlin.jvm.PlatformType", "Lexternal/sdk/pendo/io/gson/a;", "gsonBuilder", "b", "Lexternal/sdk/pendo/io/gson/Gson;", "gson", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class k0 {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final external.sdk.pendo.io.gson.a gsonBuilder;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final Gson gson;

    public k0() {
        external.sdk.pendo.io.gson.a aVarA = new external.sdk.pendo.io.gson.a().a(PendoCommandAction.class, new PendoCommandAction.PendoCommandActionDeserializer()).a(PendoCommandEventType.class, new PendoCommandEventType.PendoCommandEventTypeDeserializer());
        this.gsonBuilder = aVarA;
        this.gson = aVarA.a();
    }

    public final Gson a() {
        Gson gson = this.gson;
        Intrinsics.checkNotNullExpressionValue(gson, "gson");
        return gson;
    }
}
