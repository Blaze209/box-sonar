package com.box.android.preview.preview;

import com.box.android.preview.preview.previewbar.bottombar.BottomBarReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviewReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class PreviewReducer$build$14 extends FunctionReferenceImpl implements Function1<BottomBarReducer.Action, PreviewReducer.Action.BottomBarAction> {
    public static final PreviewReducer$build$14 INSTANCE = new PreviewReducer$build$14();

    PreviewReducer$build$14() {
        super(1, PreviewReducer.Action.BottomBarAction.class, "<init>", "<init>(Lcom/box/android/preview/preview/previewbar/bottombar/BottomBarReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final PreviewReducer.Action.BottomBarAction invoke(BottomBarReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new PreviewReducer.Action.BottomBarAction(p0);
    }
}
