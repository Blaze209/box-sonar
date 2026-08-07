package dev.chrisbanes.haze;

import android.os.Build;
import kotlin.Metadata;

/* JADX INFO: compiled from: HazeNode.android.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0000¨\u0006\u0002"}, d2 = {"isBlurEnabledByDefault", "", "haze_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class HazeNode_androidKt {
    public static final boolean isBlurEnabledByDefault() {
        return Build.VERSION.SDK_INT >= 32;
    }
}
