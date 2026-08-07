package sdk.pendo.io.u6;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.Pendo;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R$\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068G@BX\u0086\u000e¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR$\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\r8G@BX\u0086\u000e¢\u0006\f\n\u0004\b\n\u0010\u000e\u001a\u0004\b\u0005\u0010\u000fR$\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\r8G@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\b\u0010\u000f¨\u0006\u0015"}, d2 = {"Lsdk/pendo/io/u6/a;", "", "Lsdk/pendo/io/Pendo$PendoOptions;", "pendoOptions", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", "<set-?>", "b", "Z", "c", "()Z", "showViewBounds", "", "J", "()J", "scanDebounceMs", "d", "scanTimeoutMs", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class a {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private static boolean showViewBounds;
    public static final a a = new a();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private static long scanDebounceMs = 350;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private static long scanTimeoutMs = 1200;

    private a() {
    }

    public final void a(Pendo.PendoOptions pendoOptions) {
        Intrinsics.checkNotNullParameter(pendoOptions, "pendoOptions");
        Boolean sRShowViewBounds = pendoOptions.getSRShowViewBounds();
        Intrinsics.checkNotNullExpressionValue(sRShowViewBounds, "getSRShowViewBounds(...)");
        showViewBounds = sRShowViewBounds.booleanValue();
        Long sRScanDebounceMs = pendoOptions.getSRScanDebounceMs();
        scanDebounceMs = sRScanDebounceMs == null ? 350L : sRScanDebounceMs.longValue();
        Long sRScanTimeoutMs = pendoOptions.getSRScanTimeoutMs();
        scanTimeoutMs = sRScanTimeoutMs == null ? 1200L : sRScanTimeoutMs.longValue();
    }

    public final long b() {
        return scanTimeoutMs;
    }

    public final boolean c() {
        return showViewBounds;
    }

    public final long a() {
        return scanDebounceMs;
    }
}
