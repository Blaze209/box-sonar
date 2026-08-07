package com.pspdfkit.internal;

import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.note.AnnotationStateChange;
import com.pspdfkit.annotations.note.AuthorState;
import com.pspdfkit.exceptions.InvalidNutrientLicenseException;
import com.pspdfkit.internal.jni.NativeAnnotation;
import com.pspdfkit.internal.jni.NativeAnnotationStateChange;
import com.pspdfkit.internal.jni.NativeLicenseFeatures;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.annotations.AnnotationProviderImpl$appendAnnotationState$2", f = "AnnotationProviderImpl.kt", i = {0, 0}, l = {1115}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$i$f$withLock"}, nl = {1116}, s = {"L$0", "I$0"}, v = 2)
public final class p3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super NativeAnnotation>, Object> {
    public Mutex a;
    public Annotation b;
    public AnnotationStateChange c;
    public o3 d;
    public int e;
    public final /* synthetic */ o3 f;
    public final /* synthetic */ Annotation g;
    public final /* synthetic */ AnnotationStateChange h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p3(o3 o3Var, Annotation annotation, AnnotationStateChange annotationStateChange, Continuation<? super p3> continuation) {
        super(2, continuation);
        this.f = o3Var;
        this.g = annotation;
        this.h = annotationStateChange;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new p3(this.f, this.g, this.h, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super NativeAnnotation> continuation) {
        return ((p3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        o3 o3Var;
        Mutex mutex;
        Annotation annotation;
        AnnotationStateChange annotationStateChange;
        NativeAnnotation nativeAnnotationAppendAnnotationState;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.e;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!ar.b().a(NativeLicenseFeatures.ANNOTATION_REPLIES)) {
                throw new InvalidNutrientLicenseException("Your current license doesn't allow creating annotation replies.");
            }
            o3 o3Var2 = this.f;
            Mutex mutex2 = o3Var2.j;
            Annotation annotation2 = this.g;
            AnnotationStateChange annotationStateChange2 = this.h;
            this.a = mutex2;
            this.b = annotation2;
            this.c = annotationStateChange2;
            this.d = o3Var2;
            this.e = 1;
            if (mutex2.lock(null, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            o3Var = o3Var2;
            mutex = mutex2;
            annotation = annotation2;
            annotationStateChange = annotationStateChange2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            o3Var = this.d;
            annotationStateChange = this.c;
            annotation = this.b;
            mutex = this.a;
            ResultKt.throwOnFailure(obj);
        }
        try {
            NativeAnnotation nativeAnnotation = annotation.getInternal().getNativeAnnotation();
            if (nativeAnnotation != null) {
                annotationStateChange.getClass();
                String author = annotationStateChange.getAuthor();
                AuthorState authorState = annotationStateChange.getAuthorState();
                authorState.getClass();
                nativeAnnotationAppendAnnotationState = o3Var.d.appendAnnotationState(nativeAnnotation, new NativeAnnotationStateChange(author, mr.a.a.get(authorState.ordinal()), annotationStateChange.getCreationDate()));
            } else {
                nativeAnnotationAppendAnnotationState = null;
            }
            return nativeAnnotationAppendAnnotationState;
        } finally {
            mutex.unlock(null);
        }
    }
}
