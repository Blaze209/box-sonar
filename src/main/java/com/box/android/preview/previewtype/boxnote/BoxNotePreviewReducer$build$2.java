package com.box.android.preview.previewtype.boxnote;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxNotePreviewReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class BoxNotePreviewReducer$build$2 extends FunctionReferenceImpl implements Function1<BoxNoteEditModeReducer.State, BoxNotePreviewReducer.State.Editing> {
    public static final BoxNotePreviewReducer$build$2 INSTANCE = new BoxNotePreviewReducer$build$2();

    BoxNotePreviewReducer$build$2() {
        super(1, BoxNotePreviewReducer.State.Editing.class, "<init>", "<init>(Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$State;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final BoxNotePreviewReducer.State.Editing invoke(BoxNoteEditModeReducer.State p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new BoxNotePreviewReducer.State.Editing(p0);
    }
}
