package com.pspdfkit.internal;

import android.content.Context;
import com.pspdfkit.internal.jni.NativeFormNotifications;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.ui.drawable.PdfDrawableHelperKt", f = "PdfDrawableHelper.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {34}, m = "getPdfDrawablesForPage", n = {"document", "drawableProviders", "context", "$this$flatMap$iv", "$this$flatMapTo$iv$iv", "destination$iv$iv", "element$iv$iv", NativeFormNotifications.PROVIDER_INDEX_INFO_KEY, "pageIndex", "$i$f$flatMap", "$i$f$flatMapTo", "$i$a$-flatMap-PdfDrawableHelperKt$getPdfDrawablesForPage$2"}, nl = {34}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "L$8", "I$0", "I$1", "I$2", "I$3"}, v = 2)
public final class ov extends ContinuationImpl {
    public lm a;
    public Object b;
    public Context c;
    public Object d;
    public Object e;
    public Collection f;
    public Iterator g;
    public Object h;
    public Object i;
    public int j;
    public int k;
    public int l;
    public /* synthetic */ Object m;
    public int n;

    public ov(ContinuationImpl continuationImpl) {
        super(continuationImpl);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.m = obj;
        this.n |= Integer.MIN_VALUE;
        return qv.a((lm) null, (List) null, (Context) null, 0, this);
    }
}
