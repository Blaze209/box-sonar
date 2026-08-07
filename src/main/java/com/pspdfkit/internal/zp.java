package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.Matrix;
import com.pspdfkit.internal.jni.NativePDFSnapper;
import com.pspdfkit.internal.jni.NativePage;
import com.pspdfkit.preferences.PSPDFKitPreferences;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.views.page.handler.utils.MeasurementSnappingHandler$Companion$createAsync$2", f = "MeasurementSnappingHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
public final class zp extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super aq>, Object> {
    public final /* synthetic */ lm a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Context c;
    public final /* synthetic */ Matrix d;
    public final /* synthetic */ PSPDFKitPreferences e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zp(lm lmVar, int i, Context context, Matrix matrix, PSPDFKitPreferences pSPDFKitPreferences, Continuation<? super zp> continuation) {
        super(2, continuation);
        this.a = lmVar;
        this.b = i;
        this.c = context;
        this.d = matrix;
        this.e = pSPDFKitPreferences;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new zp(this.a, this.b, this.c, this.d, this.e, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super aq> continuation) {
        return ((zp) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        NativePage page = this.a.y.getPage(this.b);
        if (page == null) {
            throw new IllegalStateException("Measurement snapper could not get page " + this.b + " from document.");
        }
        NativePDFSnapper nativePDFSnapperCreate = NativePDFSnapper.create(page);
        nativePDFSnapperCreate.getClass();
        return new aq(this.c, nativePDFSnapperCreate, this.d, this.e);
    }
}
