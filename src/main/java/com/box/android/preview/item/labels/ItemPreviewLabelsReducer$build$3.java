package com.box.android.preview.item.labels;

import com.box.android.preview.item.labels.offline.PreviewOfflineLabelReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemPreviewLabelsReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class ItemPreviewLabelsReducer$build$3 extends FunctionReferenceImpl implements Function1<PreviewOfflineLabelReducer.Action, ItemPreviewLabelsReducer.Action.Offline> {
    public static final ItemPreviewLabelsReducer$build$3 INSTANCE = new ItemPreviewLabelsReducer$build$3();

    ItemPreviewLabelsReducer$build$3() {
        super(1, ItemPreviewLabelsReducer.Action.Offline.class, "<init>", "<init>(Lcom/box/android/preview/item/labels/offline/PreviewOfflineLabelReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final ItemPreviewLabelsReducer.Action.Offline invoke(PreviewOfflineLabelReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new ItemPreviewLabelsReducer.Action.Offline(p0);
    }
}
