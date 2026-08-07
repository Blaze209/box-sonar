package com.margelo.nitro.boxcontext;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import com.microsoft.intune.mam.client.content.MAMClipboard;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ClipboardService.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/margelo/nitro/boxcontext/ClipboardService;", "Lcom/margelo/nitro/boxcontext/HybridClipboardServiceSpec;", "<init>", "()V", "setString", "", "text", "", "cirrus_box-context_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ClipboardService extends HybridClipboardServiceSpec {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Context setString$lambda$0(BoxContext.Dependencies require) {
        Intrinsics.checkNotNullParameter(require, "$this$require");
        return require.getApplicationContext();
    }

    @Override // com.margelo.nitro.boxcontext.HybridClipboardServiceSpec
    public void setString(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        Object systemService = ((Context) BoxContext.INSTANCE.require(new Function1() { // from class: com.margelo.nitro.boxcontext.ClipboardService$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ClipboardService.setString$lambda$0((BoxContext.Dependencies) obj);
            }
        })).getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        MAMClipboard.setPrimaryClip((ClipboardManager) systemService, ClipData.newPlainText(null, text));
    }
}
