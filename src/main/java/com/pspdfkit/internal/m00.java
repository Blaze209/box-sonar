package com.pspdfkit.internal;

import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationProvider;
import com.pspdfkit.annotations.AnnotationType;
import java.util.ArrayList;
import java.util.EnumSet;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.utilities.measurements.SecondaryUnitHelper$updateMeasurementAnnotationsSecondaryUnits$2", f = "SecondaryUnitHelper.kt", i = {0}, l = {36}, m = "invokeSuspend", n = {"$this$launch"}, nl = {44}, s = {"L$0"}, v = 2)
public final class m00 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int a;
    public /* synthetic */ Object b;
    public final /* synthetic */ AnnotationProvider c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m00(AnnotationProvider annotationProvider, Continuation<? super m00> continuation) {
        super(2, continuation);
        this.c = annotationProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        m00 m00Var = new m00(this.c, continuation);
        m00Var.b = obj;
        return m00Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        m00 m00Var = new m00(this.c, continuation);
        m00Var.b = coroutineScope;
        return m00Var.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope = (CoroutineScope) this.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AnnotationProvider annotationProvider = this.c;
            EnumSet<AnnotationType> enumSet = bq.a;
            enumSet.getClass();
            this.b = coroutineScope;
            this.a = 1;
            obj = annotationProvider.getAllAnnotationsOfType(enumSet, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : (Iterable) obj) {
            Annotation annotation = (Annotation) obj2;
            if (!CoroutineScopeKt.isActive(coroutineScope)) {
                return Unit.INSTANCE;
            }
            if (annotation.getInternal().updateMeasurementContentsString()) {
                arrayList.add(obj2);
            }
        }
        return Unit.INSTANCE;
    }
}
