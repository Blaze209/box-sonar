package com.pspdfkit.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.exoplayer.trackselection.AdaptiveTrackSelection;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.exceptions.InvalidNutrientLicenseException;
import java.util.List;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.annotations.AnnotationProviderImpl$moveAnnotation$2", f = "AnnotationProviderImpl.kt", i = {1, 1, 1, 1, 2, 2, 3, 3}, l = {703, 1115, 716, 718}, m = "invokeSuspend", n = {"annotations", "oldStructure", "$this$withLock_u24default$iv", "$i$f$withLock", "annotations", "oldStructure", "annotations", "oldStructure"}, nl = {TypedValues.TransitionType.TYPE_AUTO_TRANSITION, 1116, 718, AdaptiveTrackSelection.DEFAULT_MAX_HEIGHT_TO_DISCARD}, s = {"L$0", "L$1", "L$2", "I$3", "L$0", "L$1", "L$0", "L$1"}, v = 2)
public final class a4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public Object a;
    public List b;
    public Mutex c;
    public o3 d;
    public int e;
    public int f;
    public int g;
    public int h;
    public final /* synthetic */ o3 i;
    public final /* synthetic */ int j;
    public final /* synthetic */ int k;
    public final /* synthetic */ int l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a4(o3 o3Var, int i, int i2, int i3, Continuation<? super a4> continuation) {
        super(2, continuation);
        this.i = o3Var;
        this.j = i;
        this.k = i2;
        this.l = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new a4(this.i, this.j, this.k, this.l, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((a4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:46:0x00ff  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        List list;
        List<? extends Annotation> list2;
        o3 o3Var;
        Mutex mutex;
        int i;
        int i2;
        int i3;
        o3 o3Var2;
        Set<Integer> of;
        List list3;
        List<? extends Annotation> list4;
        List<? extends Annotation> list5;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = this.h;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            if (!ar.b().a()) {
                throw new InvalidNutrientLicenseException("Your license does not allow annotation editing.");
            }
            o3 o3Var3 = this.i;
            int i5 = this.j;
            this.h = 1;
            obj = o3Var3.getAnnotations(i5, this);
            if (obj != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i4 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            if (i4 == 2) {
                i3 = this.g;
                i2 = this.f;
                i = this.e;
                o3Var = this.d;
                mutex = this.c;
                list2 = this.b;
                List list6 = (List) this.a;
                ResultKt.throwOnFailure(obj);
                list = list6;
                try {
                    o3Var.d.reorderAnnotation(i, i2, Boxing.boxInt(i3));
                    mutex.unlock(null);
                    o3Var2 = this.i;
                    of = SetsKt.setOf(Boxing.boxInt(this.j));
                    this.a = SpillingKt.nullOutSpilledVariable(list);
                    this.b = list2;
                    this.c = null;
                    this.d = null;
                    this.h = 3;
                    if (o3Var2.a(of, this) != coroutine_suspended) {
                        list3 = list;
                        list4 = list2;
                        o3 o3Var4 = this.i;
                        int i6 = this.j;
                        this.a = SpillingKt.nullOutSpilledVariable(list3);
                        this.b = list4;
                        this.h = 4;
                        obj = o3Var4.getAnnotations(i6, this);
                        if (obj != coroutine_suspended) {
                            list5 = list4;
                        }
                    }
                    return coroutine_suspended;
                } catch (Throwable th) {
                    mutex.unlock(null);
                    throw th;
                }
            }
            if (i4 == 3) {
                list4 = this.b;
                list3 = (List) this.a;
                ResultKt.throwOnFailure(obj);
                o3 o3Var5 = this.i;
                int i7 = this.j;
                this.a = SpillingKt.nullOutSpilledVariable(list3);
                this.b = list4;
                this.h = 4;
                obj = o3Var5.getAnnotations(i7, this);
                if (obj != coroutine_suspended) {
                    list5 = list4;
                }
                return coroutine_suspended;
            }
            if (i4 != 4) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            list5 = this.b;
            ResultKt.throwOnFailure(obj);
        }
        o3 o3Var6 = this.i;
        o3Var6.i = true;
        o3Var6.a(this.j, list5, (List<? extends Annotation>) obj);
        return Unit.INSTANCE;
        list = (List) obj;
        int i8 = this.k;
        boolean z = false;
        boolean z2 = i8 >= 0 && i8 < list.size();
        int i9 = this.k;
        int i10 = this.j;
        if (!z2) {
            throw new IllegalArgumentException(("No annotation at z-index " + i9 + " on page " + i10).toString());
        }
        int i11 = this.l;
        if (i11 >= 0 && i11 < list.size()) {
            z = true;
        }
        int i12 = this.l;
        int i13 = this.j;
        if (!z) {
            throw new IllegalArgumentException(("Target z-index " + i12 + " is out of bounds on page " + i13).toString());
        }
        list2 = CollectionsKt.toList(list);
        o3Var = this.i;
        mutex = o3Var.j;
        i = this.j;
        int i14 = this.k;
        int i15 = this.l;
        this.a = SpillingKt.nullOutSpilledVariable(list);
        this.b = list2;
        this.c = mutex;
        this.d = o3Var;
        this.e = i;
        this.f = i14;
        this.g = i15;
        this.h = 2;
        if (mutex.lock(null, this) != coroutine_suspended) {
            i2 = i14;
            i3 = i15;
            o3Var.d.reorderAnnotation(i, i2, Boxing.boxInt(i3));
            mutex.unlock(null);
            o3Var2 = this.i;
            of = SetsKt.setOf(Boxing.boxInt(this.j));
            this.a = SpillingKt.nullOutSpilledVariable(list);
            this.b = list2;
            this.c = null;
            this.d = null;
            this.h = 3;
            if (o3Var2.a(of, this) != coroutine_suspended) {
                list3 = list;
                list4 = list2;
                o3 o3Var7 = this.i;
                int i16 = this.j;
                this.a = SpillingKt.nullOutSpilledVariable(list3);
                this.b = list4;
                this.h = 4;
                obj = o3Var7.getAnnotations(i16, this);
                if (obj != coroutine_suspended) {
                    list5 = list4;
                    o3 o3Var8 = this.i;
                    o3Var8.i = true;
                    o3Var8.a(this.j, list5, (List<? extends Annotation>) obj);
                    return Unit.INSTANCE;
                }
            }
        }
        return coroutine_suspended;
    }
}
