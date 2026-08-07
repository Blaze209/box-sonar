package com.pspdfkit.internal;

import android.graphics.Bitmap;
import android.graphics.Point;
import com.pspdfkit.internal.jni.NativePageRenderingConfig;
import com.pspdfkit.internal.jni.NativeRenderResult;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.rendering.PageRendererCoroutines$renderPageRegion$4", f = "PageRendererCoroutines.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
public final class mu extends SuspendLambda implements Function3<Bitmap, NativePageRenderingConfig, Continuation<? super NativeRenderResult>, Object> {
    public /* synthetic */ Bitmap a;
    public /* synthetic */ NativePageRenderingConfig b;
    public final /* synthetic */ jm c;
    public final /* synthetic */ oy d;
    public final /* synthetic */ int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mu(jm jmVar, oy oyVar, int i, Continuation<? super mu> continuation) {
        super(3, continuation);
        this.c = jmVar;
        this.d = oyVar;
        this.e = i;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Bitmap bitmap, NativePageRenderingConfig nativePageRenderingConfig, Continuation<? super NativeRenderResult> continuation) {
        mu muVar = new mu(this.c, this.d, this.e, continuation);
        muVar.a = bitmap;
        muVar.b = nativePageRenderingConfig;
        return muVar.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Bitmap bitmap = this.a;
        NativePageRenderingConfig nativePageRenderingConfig = this.b;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        jm jmVar = this.c;
        ou ouVar = jmVar.a;
        int i = jmVar.b;
        oy oyVar = this.d;
        Point point = oyVar.a;
        return ouVar.a(i, bitmap, point.x, point.y, oyVar.b.getWidth(), this.d.b.getHeight(), nativePageRenderingConfig, this.e);
    }
}
