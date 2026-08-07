package com.box.android.preview.previousversion;

import com.box.android.preview.previewtype.document.copytext.TextSelectionManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: PreviousVersionPreviewScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$1$2$1 extends FunctionReferenceImpl implements Function0<TextSelectionManager> {
    PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$1$2$1(Object obj) {
        super(0, obj, PreviousVersionUIDependencyProvider.class, "getTextSelectionManager", "getTextSelectionManager()Lcom/box/android/preview/previewtype/document/copytext/TextSelectionManager;", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final TextSelectionManager invoke() {
        return ((PreviousVersionUIDependencyProvider) this.receiver).getTextSelectionManager();
    }
}
