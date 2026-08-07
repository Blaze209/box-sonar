package com.box.android.preview.item.labels;

import com.box.android.preview.item.labels.classification.PreviewClassificationReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviewLabels.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class PreviewLabelsKt$PreviewLabels$1$4$1 extends FunctionReferenceImpl implements Function1<PreviewClassificationReducer.Action, ItemPreviewLabelsReducer.Action.Classification> {
    public static final PreviewLabelsKt$PreviewLabels$1$4$1 INSTANCE = new PreviewLabelsKt$PreviewLabels$1$4$1();

    PreviewLabelsKt$PreviewLabels$1$4$1() {
        super(1, ItemPreviewLabelsReducer.Action.Classification.class, "<init>", "<init>(Lcom/box/android/preview/item/labels/classification/PreviewClassificationReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final ItemPreviewLabelsReducer.Action.Classification invoke(PreviewClassificationReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new ItemPreviewLabelsReducer.Action.Classification(p0);
    }
}
