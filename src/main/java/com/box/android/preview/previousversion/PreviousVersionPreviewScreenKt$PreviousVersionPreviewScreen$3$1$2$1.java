package com.box.android.preview.previousversion;

import com.box.android.preview.item.labels.classification.PreviewClassificationReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviousVersionPreviewScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class PreviousVersionPreviewScreenKt$PreviousVersionPreviewScreen$3$1$2$1 extends FunctionReferenceImpl implements Function1<PreviewClassificationReducer.Action, PreviousVersionReducer.Action.Classification> {
    public static final PreviousVersionPreviewScreenKt$PreviousVersionPreviewScreen$3$1$2$1 INSTANCE = new PreviousVersionPreviewScreenKt$PreviousVersionPreviewScreen$3$1$2$1();

    PreviousVersionPreviewScreenKt$PreviousVersionPreviewScreen$3$1$2$1() {
        super(1, PreviousVersionReducer.Action.Classification.class, "<init>", "<init>(Lcom/box/android/preview/item/labels/classification/PreviewClassificationReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final PreviousVersionReducer.Action.Classification invoke(PreviewClassificationReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new PreviousVersionReducer.Action.Classification(p0);
    }
}
