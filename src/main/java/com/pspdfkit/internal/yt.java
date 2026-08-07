package com.pspdfkit.internal;

import com.box.android.data.datasource.hubs.HubAssetRemoteDataSource;
import com.pspdfkit.annotations.Annotation;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.views.page.PageEditor$returnSelectedAnnotationViewsTemporarily$1", f = "PageEditor.kt", i = {0, 1}, l = {792, HubAssetRemoteDataSource.HUB_BANNER_SCALED_SIZE}, m = "invokeSuspend", n = {"annotationView", "annotationView"}, nl = {795, 804}, s = {"L$0", "L$0"}, v = 2)
public final class yt extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public Object a;
    public int b;
    public final /* synthetic */ vt c;
    public final /* synthetic */ i4 d;
    public final /* synthetic */ Annotation e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yt(vt vtVar, i4 i4Var, Annotation annotation, Continuation<? super yt> continuation) {
        super(2, continuation);
        this.c = vtVar;
        this.d = i4Var;
        this.e = annotation;
    }

    public static final Unit a(i4 i4Var, z4 z4Var) {
        i4Var.a(CollectionsKt.listOf(z4Var), false);
        return Unit.INSTANCE;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new yt(this.c, this.d, this.e, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((yt) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00c1, code lost:
    
        if (kotlinx.coroutines.DelayKt.delay(300, r13) == r0) goto L24;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            Method dump skipped, instruction units count: 293
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pspdfkit.internal.yt.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    public static final Unit a(vt vtVar, Annotation annotation) {
        if (!vtVar.t.isEmpty()) {
            vtVar.a(annotation);
        }
        return Unit.INSTANCE;
    }
}
