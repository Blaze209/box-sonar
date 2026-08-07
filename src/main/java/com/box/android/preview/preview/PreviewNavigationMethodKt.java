package com.box.android.preview.preview;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviewNavigationMethod.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toMetricsName", "", "Lcom/box/android/preview/preview/PreviewNavigationMethod;", "preview_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class PreviewNavigationMethodKt {

    /* JADX INFO: compiled from: PreviewNavigationMethod.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PreviewNavigationMethod.values().length];
            try {
                iArr[PreviewNavigationMethod.GALLERY_VIEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PreviewNavigationMethod.PLAYLIST_VIEW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PreviewNavigationMethod.SWIPE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final String toMetricsName(PreviewNavigationMethod previewNavigationMethod) {
        Intrinsics.checkNotNullParameter(previewNavigationMethod, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[previewNavigationMethod.ordinal()];
        if (i == 1) {
            return "gallery view";
        }
        if (i == 2) {
            return "playlist view";
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return "swipe";
    }
}
