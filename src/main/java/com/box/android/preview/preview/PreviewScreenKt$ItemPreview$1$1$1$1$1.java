package com.box.android.preview.preview;

import com.box.android.preview.previewtype.document.copytext.TextSelectionManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: PreviewScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class PreviewScreenKt$ItemPreview$1$1$1$1$1 extends FunctionReferenceImpl implements Function0<TextSelectionManager> {
    PreviewScreenKt$ItemPreview$1$1$1$1$1(Object obj) {
        super(0, obj, PreviewUIDependencyProvider.class, "getTextSelectionManager", "getTextSelectionManager()Lcom/box/android/preview/previewtype/document/copytext/TextSelectionManager;", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final TextSelectionManager invoke() {
        return ((PreviewUIDependencyProvider) this.receiver).getTextSelectionManager();
    }
}
