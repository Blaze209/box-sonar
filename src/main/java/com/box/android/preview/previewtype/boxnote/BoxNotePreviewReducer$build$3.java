package com.box.android.preview.previewtype.boxnote;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxNotePreviewReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class BoxNotePreviewReducer$build$3 extends FunctionReferenceImpl implements Function1<BoxNoteEditModeReducer.Action, BoxNotePreviewReducer.Action.EditModeAction> {
    public static final BoxNotePreviewReducer$build$3 INSTANCE = new BoxNotePreviewReducer$build$3();

    BoxNotePreviewReducer$build$3() {
        super(1, BoxNotePreviewReducer.Action.EditModeAction.class, "<init>", "<init>(Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final BoxNotePreviewReducer.Action.EditModeAction invoke(BoxNoteEditModeReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new BoxNotePreviewReducer.Action.EditModeAction(p0);
    }
}
