package com.pspdfkit.internal;

import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.LinkAnnotation;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.views.page.pageview.data.providers.AnnotationDrawableStateProvider$loadAnnotations$1", f = "AnnotationDrawableStateProvider.kt", i = {1}, l = {70, 72}, m = "invokeSuspend", n = {"annotations"}, nl = {71, 71}, s = {"L$0"}, v = 2)
public final class s1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public Object a;
    public MutableStateFlow b;
    public int c;
    public final /* synthetic */ m40 d;
    public final /* synthetic */ t1 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s1(m40 m40Var, t1 t1Var, Continuation<? super s1> continuation) {
        super(2, continuation);
        this.d = m40Var;
        this.e = t1Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new s1(this.d, this.e, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return new s1(this.d, this.e, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.c;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            o3 annotationProvider = this.d.a.getAnnotationProvider();
            int i2 = this.d.b;
            this.c = 1;
            obj = annotationProvider.getAnnotations(i2, this);
            if (obj != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mutableStateFlow = this.b;
            ResultKt.throwOnFailure(obj);
        }
        mutableStateFlow.setValue(obj);
        this.e.c.invoke();
        return Unit.INSTANCE;
        List list = (List) obj;
        MutableStateFlow<List<q1>> mutableStateFlow2 = this.e.e;
        CoroutineDispatcher io2 = Dispatchers.getIO();
        a aVar = new a(list, this.e, null);
        this.a = SpillingKt.nullOutSpilledVariable(list);
        this.b = mutableStateFlow2;
        this.c = 2;
        obj = BuildersKt.withContext(io2, aVar, this);
        if (obj != coroutine_suspended) {
            mutableStateFlow = mutableStateFlow2;
            mutableStateFlow.setValue(obj);
            this.e.c.invoke();
            return Unit.INSTANCE;
        }
        return coroutine_suspended;
    }

    @DebugMetadata(c = "com.pspdfkit.internal.views.page.pageview.data.providers.AnnotationDrawableStateProvider$loadAnnotations$1$1", f = "AnnotationDrawableStateProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends q1>>, Object> {
        public final /* synthetic */ List<Annotation> a;
        public final /* synthetic */ t1 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(List<? extends Annotation> list, t1 t1Var, Continuation<? super a> continuation) {
            super(2, continuation);
            this.a = list;
            this.b = t1Var;
        }

        public static final boolean a(Annotation annotation) {
            return ww.h(annotation) && annotation.getType() == AnnotationType.LINK;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.a, this.b, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends q1>> continuation) {
            return new a(this.a, this.b, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            Sequence sequenceFilter = SequencesKt.filter(CollectionsKt.asSequence(this.a), new Function1() { // from class: com.pspdfkit.internal.s1$a$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return Boolean.valueOf(s1.a.a((Annotation) obj2));
                }
            });
            final t1 t1Var = this.b;
            return SequencesKt.toList(SequencesKt.map(sequenceFilter, new Function1() { // from class: com.pspdfkit.internal.s1$a$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return s1.a.a(t1Var, (Annotation) obj2);
                }
            }));
        }

        public static final q1 a(t1 t1Var, Annotation annotation) {
            if (annotation instanceof LinkAnnotation) {
                return new co((LinkAnnotation) annotation, t1Var.a);
            }
            return new q1(annotation);
        }
    }
}
