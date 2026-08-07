package com.box.android.preview.previousversion;

import com.box.android.preview.previewtype.image.ImagePreviewReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviousVersionReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class PreviousVersionReducer$build$8 extends FunctionReferenceImpl implements Function1<ImagePreviewReducer.Action, PreviousVersionReducer.Action.Image> {
    public static final PreviousVersionReducer$build$8 INSTANCE = new PreviousVersionReducer$build$8();

    PreviousVersionReducer$build$8() {
        super(1, PreviousVersionReducer.Action.Image.class, "<init>", "<init>(Lcom/box/android/preview/previewtype/image/ImagePreviewReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final PreviousVersionReducer.Action.Image invoke(ImagePreviewReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new PreviousVersionReducer.Action.Image(p0);
    }
}
