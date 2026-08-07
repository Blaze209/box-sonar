package com.pspdfkit.internal.rendering;

import com.pspdfkit.internal.jni.NativeRenderResultError;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002¨\u0006\u0003"}, d2 = {"Lcom/pspdfkit/internal/rendering/PageRenderingException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PageRenderingException extends Exception {
    public PageRenderingException(int i, NativeRenderResultError nativeRenderResultError) {
        super("Error rendering page " + i + ": " + (nativeRenderResultError != null ? nativeRenderResultError.name() : null));
    }
}
