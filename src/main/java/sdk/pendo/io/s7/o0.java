package sdk.pendo.io.s7;

import androidx.fragment.app.Fragment;
import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0001¨\u0006\u0003"}, d2 = {"Landroidx/fragment/app/Fragment;", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "pendoIO_release"}, k = 2, mv = {1, 9, 0})
public final class o0 {
    public static final boolean a(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        return !fragment.isDetached() && fragment.isVisible() && !fragment.isRemoving() && e1.a(fragment.getView(), 1);
    }
}
