package com.box.android.preview.preview;

import com.box.android.preview.preview.previewbar.topbar.TopBarReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviewReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class PreviewReducer$build$11 extends FunctionReferenceImpl implements Function1<TopBarReducer.Action, PreviewReducer.Action.TopBarAction> {
    public static final PreviewReducer$build$11 INSTANCE = new PreviewReducer$build$11();

    PreviewReducer$build$11() {
        super(1, PreviewReducer.Action.TopBarAction.class, "<init>", "<init>(Lcom/box/android/preview/preview/previewbar/topbar/TopBarReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final PreviewReducer.Action.TopBarAction invoke(TopBarReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new PreviewReducer.Action.TopBarAction(p0);
    }
}
