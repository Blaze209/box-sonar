package com.pspdfkit.internal;

import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.note.AnnotationStateChange;
import com.pspdfkit.annotations.note.AuthorState;
import com.pspdfkit.exceptions.InvalidNutrientLicenseException;
import com.pspdfkit.internal.jni.NativeAnnotation;
import com.pspdfkit.internal.jni.NativeAnnotationStateChange;
import com.pspdfkit.internal.jni.NativeAuthorState;
import com.pspdfkit.internal.jni.NativeLicenseFeatures;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.annotations.AnnotationProviderImpl$getReviewHistory$2", f = "AnnotationProviderImpl.kt", i = {0, 0, 0, 0, 0, 0}, l = {1115}, m = "invokeSuspend", n = {ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "native", "$this$withLock_u24default$iv", "$completion$iv", "$i$a$-let-AnnotationProviderImpl$getReviewHistory$2$1", "$i$f$withLock"}, nl = {1116}, s = {"L$0", "L$2", "L$3", "L$4", "I$0", "I$1"}, v = 2)
public final class v3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<AnnotationStateChange>>, Object> {
    public ArrayList a;
    public o3 b;
    public NativeAnnotation c;
    public Mutex d;
    public Object e;
    public int f;
    public final /* synthetic */ o3 g;
    public final /* synthetic */ Annotation h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v3(o3 o3Var, Annotation annotation, Continuation<? super v3> continuation) {
        super(2, continuation);
        this.g = o3Var;
        this.h = annotation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new v3(this.g, this.h, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<AnnotationStateChange>> continuation) {
        return new v3(this.g, this.h, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        NativeAnnotation nativeAnnotation;
        ArrayList arrayList;
        o3 o3Var;
        Mutex mutex;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.f;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!ar.b().a(NativeLicenseFeatures.ANNOTATION_REPLIES)) {
                throw new InvalidNutrientLicenseException("Your current license doesn't allow creating annotation replies.");
            }
            ArrayList arrayList2 = new ArrayList();
            nativeAnnotation = this.h.getInternal().getNativeAnnotation();
            if (nativeAnnotation == null) {
                return arrayList2;
            }
            o3 o3Var2 = this.g;
            Mutex mutex2 = o3Var2.j;
            this.a = arrayList2;
            this.b = o3Var2;
            this.c = nativeAnnotation;
            this.d = mutex2;
            this.e = SpillingKt.nullOutSpilledVariable(this);
            this.f = 1;
            if (mutex2.lock(null, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            arrayList = arrayList2;
            o3Var = o3Var2;
            mutex = mutex2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mutex = this.d;
            nativeAnnotation = this.c;
            o3Var = this.b;
            arrayList = this.a;
            ResultKt.throwOnFailure(obj);
        }
        try {
            ArrayList<NativeAnnotationStateChange> reviewHistory = o3Var.d.getReviewHistory(nativeAnnotation);
            mutex.unlock(null);
            reviewHistory.getClass();
            Iterator<NativeAnnotationStateChange> it = reviewHistory.iterator();
            it.getClass();
            while (it.hasNext()) {
                NativeAnnotationStateChange next = it.next();
                next.getClass();
                String author = next.getAuthor();
                NativeAuthorState state = next.getState();
                state.getClass();
                arrayList.add(new AnnotationStateChange(author, AuthorState.getEntries().get(state.ordinal()), next.getCreationDate()));
            }
            return arrayList;
        } catch (Throwable th) {
            mutex.unlock(null);
            throw th;
        }
    }
}
