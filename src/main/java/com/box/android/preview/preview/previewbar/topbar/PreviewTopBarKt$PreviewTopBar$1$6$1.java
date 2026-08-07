package com.box.android.preview.preview.previewbar.topbar;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: PreviewTopBar.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final class PreviewTopBarKt$PreviewTopBar$1$6$1 implements Function1<Boolean, Boolean> {
    public static final PreviewTopBarKt$PreviewTopBar$1$6$1 INSTANCE = new PreviewTopBarKt$PreviewTopBar$1$6$1();

    PreviewTopBarKt$PreviewTopBar$1$6$1() {
    }

    public final Boolean invoke(boolean z) {
        return Boolean.valueOf(!z);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
        return invoke(bool.booleanValue());
    }
}
