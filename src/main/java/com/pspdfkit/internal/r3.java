package com.pspdfkit.internal;

import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.exceptions.InvalidNutrientLicenseException;
import com.pspdfkit.internal.jni.NativeLicenseFeatures;
import java.util.ArrayList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.annotations.AnnotationProviderImpl$getAnnotationReplies$2", f = "AnnotationProviderImpl.kt", i = {0}, l = {285}, m = "invokeSuspend", n = {"uuid"}, nl = {1110}, s = {"L$0"}, v = 2)
public final class r3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Annotation>>, Object> {
    public String a;
    public int b;
    public final /* synthetic */ o3 c;
    public final /* synthetic */ Annotation d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r3(o3 o3Var, Annotation annotation, Continuation<? super r3> continuation) {
        super(2, continuation);
        this.c = o3Var;
        this.d = annotation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new r3(this.c, this.d, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Annotation>> continuation) {
        return new r3(this.c, this.d, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.b;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!ar.b().a(NativeLicenseFeatures.ANNOTATION_REPLIES)) {
                throw new InvalidNutrientLicenseException("Your current license doesn't allow creating annotation replies.");
            }
            if (!this.d.isAttached() || this.d.getPageIndex() == Integer.MIN_VALUE) {
                throw new IllegalArgumentException("Retrieval of replies for detached annotations is not supported.");
            }
            String uuid = this.d.getInternal().getUuid();
            o3 o3Var = this.c;
            int pageIndex = this.d.getPageIndex();
            this.a = uuid;
            this.b = 1;
            Object annotations = o3Var.getAnnotations(pageIndex, this);
            if (annotations == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj = annotations;
            str = uuid;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str = this.a;
            ResultKt.throwOnFailure(obj);
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : (Iterable) obj) {
            if (Intrinsics.areEqual(((Annotation) obj2).getInternal().getInReplyToUuid(), str)) {
                arrayList.add(obj2);
            }
        }
        return arrayList;
    }
}
