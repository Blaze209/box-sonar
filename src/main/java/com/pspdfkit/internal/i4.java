package com.pspdfkit.internal;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.FreeTextAnnotation;
import com.pspdfkit.ui.rendering.AnnotationOverlayRenderStrategy;
import com.pspdfkit.utils.PdfLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: classes3.dex */
public final class i4 implements nx {
    public final au a;
    public final c5 b;
    public boolean c;
    public final ArrayList d;
    public final LinkedHashSet e;
    public final CoroutineScope f;
    public Job g;
    public final ArrayDeque<ny> h;
    public Job i;
    public Job j;
    public boolean k;
    public final c3 l;
    public boolean m;
    public EnumSet<AnnotationType> n;
    public boolean o;
    public et p;
    public final c5.a q;

    public static final /* synthetic */ class a {
        public static final /* synthetic */ EnumEntries<AnnotationType> a = EnumEntriesKt.enumEntries(AnnotationType.values());
    }

    @DebugMetadata(c = "com.pspdfkit.internal.views.page.AnnotationRenderingCoordinator$refreshAnnotationOverlay$launchedJob$1", f = "AnnotationRenderingCoordinator.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {677, 684}, m = "invokeSuspend", n = {"$this$launch", "state", "overlayTypesSnapshot", "$this$launch", "state", "overlayTypesSnapshot", "overlayRefreshComputation"}, nl = {684, 751}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"}, v = 2)
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public Object a;
        public Object b;
        public Object c;
        public int d;
        public /* synthetic */ Object e;

        /* JADX INFO: renamed from: com.pspdfkit.internal.i4$b$b, reason: collision with other inner class name */
        @DebugMetadata(c = "com.pspdfkit.internal.views.page.AnnotationRenderingCoordinator$refreshAnnotationOverlay$launchedJob$1$overlayRefreshComputation$1", f = "AnnotationRenderingCoordinator.kt", i = {}, l = {678}, m = "invokeSuspend", n = {}, nl = {681}, s = {}, v = 2)
        public static final class C0274b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super rt>, Object> {
            public int a;
            public final /* synthetic */ m40 b;
            public final /* synthetic */ i4 c;
            public final /* synthetic */ EnumSet<AnnotationType> d;

            /* JADX INFO: renamed from: com.pspdfkit.internal.i4$b$b$a */
            @DebugMetadata(c = "com.pspdfkit.internal.views.page.AnnotationRenderingCoordinator$refreshAnnotationOverlay$launchedJob$1$overlayRefreshComputation$1$1", f = "AnnotationRenderingCoordinator.kt", i = {}, l = {681}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
            public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                public int a;
                public final /* synthetic */ i4 b;
                public final /* synthetic */ List<Annotation> c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public a(i4 i4Var, List<? extends Annotation> list, Continuation<? super a> continuation) {
                    super(2, continuation);
                    this.b = i4Var;
                    this.c = list;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new a(this.b, this.c, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return new a(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object objWithTimeoutOrNull;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.a;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        c5 c5Var = this.b.b;
                        List<Annotation> list = this.c;
                        this.a = 1;
                        c5Var.getClass();
                        if (list.isEmpty()) {
                            objWithTimeoutOrNull = Unit.INSTANCE;
                        } else {
                            LinkedHashSet linkedHashSet = new LinkedHashSet();
                            for (Annotation annotation : list) {
                                AnnotationOverlayRenderStrategy.Strategy overlayRenderStrategy = c5Var.e.getOverlayRenderStrategy(annotation);
                                overlayRenderStrategy.getClass();
                                if (!annotation.isMeasurement() && annotation.get_appearanceStreamGenerator() == null && overlayRenderStrategy == AnnotationOverlayRenderStrategy.Strategy.PLATFORM_RENDERING) {
                                    AnnotationType type = annotation.getType();
                                    type.getClass();
                                    switch (p10.a.a[type.ordinal()]) {
                                        case 1:
                                        case 2:
                                        case 3:
                                        case 4:
                                        case 5:
                                        case 6:
                                            if (!annotation.getInternal().getPrefersPlatformRendering()) {
                                                String uuid = annotation.getInternal().getUuid();
                                                l5 l5Var = c5Var.f;
                                                l5Var.getClass();
                                                uuid.getClass();
                                                l5.a aVar = l5Var.a.get(uuid);
                                                if (aVar instanceof l5.a.b) {
                                                    continue;
                                                } else if (!(aVar instanceof l5.a.C0277a)) {
                                                    if (aVar != null) {
                                                        throw new NoWhenBranchMatchedException();
                                                    }
                                                    Job jobB = c5Var.b(annotation);
                                                    if (jobB != null) {
                                                        linkedHashSet.add(jobB);
                                                    }
                                                } else {
                                                    Job job = (Job) c5Var.h.get(uuid);
                                                    if (job != null) {
                                                        linkedHashSet.add(job);
                                                    }
                                                }
                                            } else {
                                                continue;
                                            }
                                            break;
                                    }
                                }
                            }
                            objWithTimeoutOrNull = linkedHashSet.isEmpty() ? Unit.INSTANCE : TimeoutKt.withTimeoutOrNull(500L, new d5(linkedHashSet, null), this);
                        }
                        if (objWithTimeoutOrNull == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0274b(m40 m40Var, i4 i4Var, EnumSet<AnnotationType> enumSet, Continuation<? super C0274b> continuation) {
                super(2, continuation);
                this.b = m40Var;
                this.c = i4Var;
                this.d = enumSet;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C0274b(this.b, this.c, this.d, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super rt> continuation) {
                return ((C0274b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                int objectNumber;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    o3 annotationProvider = this.b.a.getAnnotationProvider();
                    int i2 = this.b.b;
                    this.a = 1;
                    obj = annotationProvider.getAnnotations(i2, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                List<Annotation> list = (List) obj;
                i4 i4Var = this.c;
                BuildersKt__Builders_commonKt.launch$default(i4Var.f, null, null, new a(i4Var, list, null), 3, null);
                m40 m40Var = this.b;
                EnumSet<AnnotationType> enumSet = this.d;
                enumSet.getClass();
                ArrayList arrayList = new ArrayList(list.size());
                LinkedHashMap linkedHashMap = new LinkedHashMap(list.size());
                boolean z = false;
                for (Annotation annotation : list) {
                    g4 g4VarA = i4.a(annotation, enumSet);
                    boolean zA = n40.a(m40Var, annotation);
                    int iOrdinal = g4VarA.ordinal();
                    if (iOrdinal != 0) {
                        if (iOrdinal != 1) {
                            throw new NoWhenBranchMatchedException();
                        }
                        Integer numValueOf = (annotation.isAttached() && (objectNumber = annotation.getObjectNumber()) != Integer.MIN_VALUE) ? Integer.valueOf(objectNumber) : null;
                        if (numValueOf != null) {
                            arrayList.add(numValueOf);
                            if (!zA) {
                                linkedHashMap.put(numValueOf, annotation);
                            }
                        }
                    } else if (!zA) {
                        z = true;
                    }
                }
                return new rt(CollectionsKt.sorted(CollectionsKt.distinct(arrayList)), linkedHashMap, z);
            }
        }

        public b(Continuation<? super b> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            b bVar = i4.this.new b(continuation);
            bVar.e = obj;
            return bVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            b bVar = i4.this.new b(continuation);
            bVar.e = coroutineScope;
            return bVar.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:38:0x00dd  */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x00ad, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(r13, r6, r12) == r0) goto L29;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                Method dump skipped, instruction units count: 254
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.pspdfkit.internal.i4.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @DebugMetadata(c = "com.pspdfkit.internal.views.page.AnnotationRenderingCoordinator$refreshAnnotationOverlay$launchedJob$1$1", f = "AnnotationRenderingCoordinator.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public final /* synthetic */ i4 a;
            public final /* synthetic */ m40 b;
            public final /* synthetic */ EnumSet<AnnotationType> c;
            public final /* synthetic */ rt d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(i4 i4Var, m40 m40Var, EnumSet<AnnotationType> enumSet, rt rtVar, Continuation<? super a> continuation) {
                super(2, continuation);
                this.a = i4Var;
                this.b = m40Var;
                this.c = enumSet;
                this.d = rtVar;
            }

            public static final m40 a(rt rtVar, m40 m40Var) {
                return n40.a(m40Var, rtVar.a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(this.a, this.b, this.c, this.d, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                ResultKt.throwOnFailure(obj);
                if (!this.a.a()) {
                    return Unit.INSTANCE;
                }
                m40 state = this.a.a.getState();
                if (state == null) {
                    return Unit.INSTANCE;
                }
                int i = state.b;
                m40 m40Var = this.b;
                if (i != m40Var.b || !Intrinsics.areEqual(state.a, m40Var.a)) {
                    return Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual(this.a.n, this.c)) {
                    this.a.b();
                    return Unit.INSTANCE;
                }
                boolean zAreEqual = Intrinsics.areEqual(state.l, this.b.l);
                i4 i4Var = this.a;
                if (!zAreEqual) {
                    i4Var.b();
                    return Unit.INSTANCE;
                }
                Set<Integer> annotations = i4Var.l.getAnnotations();
                final Set<Integer> setKeySet = this.d.b.keySet();
                setKeySet.getClass();
                boolean zAreEqual2 = Intrinsics.areEqual(state.n, this.d.a);
                au auVar = this.a.a;
                final rt rtVar = this.d;
                auVar.a(new Function1() { // from class: com.pspdfkit.internal.i4$b$a$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return i4.b.a.a(rtVar, (m40) obj2);
                    }
                });
                i4 i4Var2 = this.a;
                boolean z = i4Var2.o;
                i4Var2.o = true;
                if (!zAreEqual2 || !z) {
                    i4Var2.e();
                }
                if (Intrinsics.areEqual(annotations, setKeySet)) {
                    return Unit.INSTANCE;
                }
                Sequence sequenceFilter = SequencesKt.filter(CollectionsKt.asSequence(annotations), new Function1() { // from class: com.pspdfkit.internal.i4$b$a$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return Boolean.valueOf(i4.b.a.a(setKeySet, ((Integer) obj2).intValue()));
                    }
                });
                i4 i4Var3 = this.a;
                Iterator it = sequenceFilter.iterator();
                while (it.hasNext()) {
                    int iIntValue = ((Number) it.next()).intValue();
                    c3 c3Var = i4Var3.l;
                    z4<?> z4Var = (z4) c3Var.g.get(Integer.valueOf(iIntValue));
                    if (z4Var != null) {
                        if (z4Var.a().getParent() != c3Var) {
                            c3Var.b(z4Var);
                        } else {
                            c3Var.removeView(z4Var.a());
                            i4 i4Var4 = c3Var.e;
                            i4Var4.b.b(z4Var);
                            i4Var4.d.remove(z4Var);
                        }
                    }
                }
                Collection<Annotation> collectionValues = this.d.b.values();
                collectionValues.getClass();
                i4 i4Var5 = this.a;
                for (Annotation annotation : collectionValues) {
                    annotation.getClass();
                    i4Var5.l.a(annotation, !n40.a(state, annotation));
                }
                i4 i4Var6 = this.a;
                Collection<Annotation> collectionValues2 = this.d.b.values();
                collectionValues2.getClass();
                i4Var6.a(collectionValues2);
                i4 i4Var7 = this.a;
                i4Var7.h.addLast(new ny(i4Var7.c && this.d.c, true, null));
                Job job = i4Var7.g;
                if (job == null || !job.isActive()) {
                    i4Var7.d();
                }
                return Unit.INSTANCE;
            }

            public static final boolean a(Set set, int i) {
                return !set.contains(Integer.valueOf(i));
            }
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.views.page.AnnotationRenderingCoordinator$scheduleOverlayOrderRefresh$1", f = "AnnotationRenderingCoordinator.kt", i = {0, 1, 1}, l = {633, 634}, m = "invokeSuspend", n = {"currentState", "currentState", "annotations"}, nl = {632, 643}, s = {"L$0", "L$0", "L$1"}, v = 2)
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public Object a;
        public Object b;
        public int c;

        @DebugMetadata(c = "com.pspdfkit.internal.views.page.AnnotationRenderingCoordinator$scheduleOverlayOrderRefresh$1$1", f = "AnnotationRenderingCoordinator.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public final /* synthetic */ i4 a;
            public final /* synthetic */ List<Annotation> b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(i4 i4Var, List<? extends Annotation> list, Continuation<? super a> continuation) {
                super(2, continuation);
                this.a = i4Var;
                this.b = list;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(this.a, this.b, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return new a(this.a, this.b, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                ResultKt.throwOnFailure(obj);
                this.a.a((List<? extends Annotation>) this.b);
                return Unit.INSTANCE;
            }
        }

        public c(Continuation<? super c> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return i4.this.new c(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return i4.this.new c(continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0095 -> B:15:0x002f). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            m40 state;
            MainCoroutineDispatcher main;
            a aVar;
            i4 i4Var;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.c;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i == 1) {
                        state = (m40) this.a;
                        ResultKt.throwOnFailure(obj);
                        List list = (List) obj;
                        main = Dispatchers.getMain();
                        aVar = new a(i4.this, list, null);
                        this.a = SpillingKt.nullOutSpilledVariable(state);
                        this.b = SpillingKt.nullOutSpilledVariable(list);
                        this.c = 2;
                        if (BuildersKt.withContext(main, aVar, this) != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    }
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th) {
                        i4 i4Var2 = i4.this;
                        i4Var2.j = null;
                        if (i4Var2.k && i4Var2.a()) {
                            i4.this.c();
                        }
                        throw th;
                    }
                }
                i4 i4Var3 = i4.this;
                if (!i4Var3.k && i4Var3.a()) {
                    i4 i4Var4 = i4.this;
                    i4Var4.k = false;
                    state = i4Var4.a.getState();
                    if (state == null) {
                        Unit unit = Unit.INSTANCE;
                        i4 i4Var5 = i4.this;
                        i4Var5.j = null;
                        if (i4Var5.k && i4Var5.a()) {
                            i4.this.c();
                        }
                        return unit;
                    }
                    o3 annotationProvider = state.a.getAnnotationProvider();
                    int i2 = state.b;
                    this.a = SpillingKt.nullOutSpilledVariable(state);
                    this.b = null;
                    this.c = 1;
                    obj = annotationProvider.getAnnotations(i2, this);
                    if (obj != coroutine_suspended) {
                        List list2 = (List) obj;
                        main = Dispatchers.getMain();
                        aVar = new a(i4.this, list2, null);
                        this.a = SpillingKt.nullOutSpilledVariable(state);
                        this.b = SpillingKt.nullOutSpilledVariable(list2);
                        this.c = 2;
                        if (BuildersKt.withContext(main, aVar, this) != coroutine_suspended) {
                            i4 i4Var6 = i4.this;
                            if (!i4Var6.k) {
                            }
                            i4Var = i4.this;
                            i4Var.j = null;
                            if (i4Var.k) {
                                i4.this.c();
                            }
                        }
                    }
                    return coroutine_suspended;
                }
                i4Var = i4.this;
                i4Var.j = null;
                if (i4Var.k && i4Var.a()) {
                    i4.this.c();
                }
            } catch (CancellationException e) {
                throw e;
            } catch (Throwable th2) {
                PdfLog.e("Nutri.AnnotRenderCoord", th2, "Error loading annotations for overlay ordering", new Object[0]);
                i4 i4Var7 = i4.this;
                i4Var7.j = null;
                if (i4Var7.k && i4Var7.a()) {
                }
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.views.page.AnnotationRenderingCoordinator$startNextPageRenderingJob$1", f = "AnnotationRenderingCoordinator.kt", i = {}, l = {309, 313, 334}, m = "invokeSuspend", n = {}, nl = {312, 334, 338}, s = {}, v = 2)
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ ny b;
        public final /* synthetic */ i4 c;
        public final /* synthetic */ int d;

        @DebugMetadata(c = "com.pspdfkit.internal.views.page.AnnotationRenderingCoordinator$startNextPageRenderingJob$1$1", f = "AnnotationRenderingCoordinator.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public final /* synthetic */ i4 a;
            public final /* synthetic */ int b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(i4 i4Var, int i, Continuation<? super a> continuation) {
                super(2, continuation);
                this.a = i4Var;
                this.b = i;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(this.a, this.b, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return new a(this.a, this.b, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                ResultKt.throwOnFailure(obj);
                et etVar = this.a.p;
                if (etVar == null) {
                    return null;
                }
                etVar.a(this.b);
                return Unit.INSTANCE;
            }
        }

        @DebugMetadata(c = "com.pspdfkit.internal.views.page.AnnotationRenderingCoordinator$startNextPageRenderingJob$1$2", f = "AnnotationRenderingCoordinator.kt", i = {0}, l = {806}, m = "invokeSuspend", n = {"$i$f$suspendCancellableCoroutine"}, nl = {816}, s = {"I$0"}, v = 2)
        public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public int a;
            public final /* synthetic */ i4 b;
            public final /* synthetic */ ny c;

            public static final class a implements dt {
                public final /* synthetic */ CancellableContinuationImpl a;

                public a(CancellableContinuationImpl cancellableContinuationImpl) {
                    this.a = cancellableContinuationImpl;
                }

                @Override // com.pspdfkit.internal.dt
                public final void a(uy uyVar) {
                    CancellableContinuationImpl cancellableContinuationImpl = this.a;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuationImpl.resumeWith(Result.m14780constructorimpl(Unit.INSTANCE));
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(i4 i4Var, ny nyVar, Continuation<? super b> continuation) {
                super(2, continuation);
                this.b = i4Var;
                this.c = nyVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new b(this.b, this.c, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return new b(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.a;
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        i4 i4Var = this.b;
                        if (i4Var.a.v || this.c.b) {
                            this.a = 1;
                            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(this), 1);
                            cancellableContinuationImpl.initCancellability();
                            i4Var.a.a(new a(cancellableContinuationImpl));
                            Object result = cancellableContinuationImpl.getResult();
                            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                DebugProbesKt.probeCoroutineSuspended(this);
                            }
                            if (result == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                } catch (IllegalStateException unused) {
                    PdfLog.w("Nutri.AnnotRenderCoord", "Attempted to refresh page render after rebinding...", new Object[0]);
                    return Unit.INSTANCE;
                }
            }
        }

        @DebugMetadata(c = "com.pspdfkit.internal.views.page.AnnotationRenderingCoordinator$startNextPageRenderingJob$1$3", f = "AnnotationRenderingCoordinator.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public final /* synthetic */ ny a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(ny nyVar, Continuation<? super c> continuation) {
                super(2, continuation);
                this.a = nyVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new c(this.a, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return new c(this.a, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                ResultKt.throwOnFailure(obj);
                Function0<Unit> function0 = this.a.c;
                if (function0 == null) {
                    return null;
                }
                function0.invoke();
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ny nyVar, i4 i4Var, int i, Continuation<? super d> continuation) {
            super(2, continuation);
            this.b = nyVar;
            this.c = i4Var;
            this.d = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new d(this.b, this.c, this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:25:0x005f A[Catch: all -> 0x0028, TryCatch #0 {all -> 0x0028, blocks: (B:7:0x0014, B:28:0x0073, B:11:0x0020, B:25:0x005f, B:12:0x0024, B:20:0x0043, B:22:0x0049, B:17:0x002d), top: B:36:0x000c }] */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0070, code lost:
        
            if (r10 == r1) goto L27;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.String r0 = "Error refreshing page rendering: "
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r9.a
                r3 = 3
                r4 = 2
                r5 = 1
                r6 = 0
                if (r2 == 0) goto L2a
                if (r2 == r5) goto L24
                if (r2 == r4) goto L20
                if (r2 != r3) goto L18
                kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L28
                goto L73
            L18:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L20:
                kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L28
                goto L5f
            L24:
                kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L28
                goto L43
            L28:
                r10 = move-exception
                goto L76
            L2a:
                kotlin.ResultKt.throwOnFailure(r10)
                kotlinx.coroutines.MainCoroutineDispatcher r10 = kotlinx.coroutines.Dispatchers.getMain()     // Catch: java.lang.Throwable -> L28
                com.pspdfkit.internal.i4$d$a r2 = new com.pspdfkit.internal.i4$d$a     // Catch: java.lang.Throwable -> L28
                com.pspdfkit.internal.i4 r7 = r9.c     // Catch: java.lang.Throwable -> L28
                int r8 = r9.d     // Catch: java.lang.Throwable -> L28
                r2.<init>(r7, r8, r6)     // Catch: java.lang.Throwable -> L28
                r9.a = r5     // Catch: java.lang.Throwable -> L28
                java.lang.Object r10 = kotlinx.coroutines.BuildersKt.withContext(r10, r2, r9)     // Catch: java.lang.Throwable -> L28
                if (r10 != r1) goto L43
                goto L72
            L43:
                com.pspdfkit.internal.ny r10 = r9.b     // Catch: java.lang.Throwable -> L28
                boolean r10 = r10.a     // Catch: java.lang.Throwable -> L28
                if (r10 == 0) goto L5f
                kotlinx.coroutines.MainCoroutineDispatcher r10 = kotlinx.coroutines.Dispatchers.getMain()     // Catch: java.lang.Throwable -> L28
                com.pspdfkit.internal.i4$d$b r2 = new com.pspdfkit.internal.i4$d$b     // Catch: java.lang.Throwable -> L28
                com.pspdfkit.internal.i4 r5 = r9.c     // Catch: java.lang.Throwable -> L28
                com.pspdfkit.internal.ny r7 = r9.b     // Catch: java.lang.Throwable -> L28
                r2.<init>(r5, r7, r6)     // Catch: java.lang.Throwable -> L28
                r9.a = r4     // Catch: java.lang.Throwable -> L28
                java.lang.Object r10 = kotlinx.coroutines.BuildersKt.withContext(r10, r2, r9)     // Catch: java.lang.Throwable -> L28
                if (r10 != r1) goto L5f
                goto L72
            L5f:
                kotlinx.coroutines.MainCoroutineDispatcher r10 = kotlinx.coroutines.Dispatchers.getMain()     // Catch: java.lang.Throwable -> L28
                com.pspdfkit.internal.i4$d$c r2 = new com.pspdfkit.internal.i4$d$c     // Catch: java.lang.Throwable -> L28
                com.pspdfkit.internal.ny r4 = r9.b     // Catch: java.lang.Throwable -> L28
                r2.<init>(r4, r6)     // Catch: java.lang.Throwable -> L28
                r9.a = r3     // Catch: java.lang.Throwable -> L28
                java.lang.Object r10 = kotlinx.coroutines.BuildersKt.withContext(r10, r2, r9)     // Catch: java.lang.Throwable -> L28
                if (r10 != r1) goto L73
            L72:
                return r1
            L73:
                kotlin.Unit r10 = (kotlin.Unit) r10     // Catch: java.lang.Throwable -> L28
                goto L90
            L76:
                java.lang.String r1 = "Nutri.AnnotRenderCoord"
                java.lang.String r2 = r10.getMessage()     // Catch: java.lang.Throwable -> L9a
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9a
                r3.<init>(r0)     // Catch: java.lang.Throwable -> L9a
                java.lang.StringBuilder r0 = r3.append(r2)     // Catch: java.lang.Throwable -> L9a
                java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L9a
                java.lang.Object[] r10 = new java.lang.Object[]{r10}     // Catch: java.lang.Throwable -> L9a
                com.pspdfkit.utils.PdfLog.e(r1, r0, r10)     // Catch: java.lang.Throwable -> L9a
            L90:
                com.pspdfkit.internal.i4 r9 = r9.c
                r9.g = r6
                r9.d()
                kotlin.Unit r9 = kotlin.Unit.INSTANCE
                return r9
            L9a:
                r10 = move-exception
                com.pspdfkit.internal.i4 r9 = r9.c
                r9.g = r6
                r9.d()
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.pspdfkit.internal.i4.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public i4(au auVar, c5 c5Var) {
        c5Var.getClass();
        this.a = auVar;
        this.b = c5Var;
        this.d = new ArrayList();
        this.e = new LinkedHashSet();
        this.f = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        this.h = new ArrayDeque<>();
        this.l = new c3(auVar, this);
        this.m = true;
        EnumSet<AnnotationType> enumSetNoneOf = EnumSet.noneOf(AnnotationType.class);
        enumSetNoneOf.getClass();
        this.n = enumSetNoneOf;
        this.q = new c5.a() { // from class: com.pspdfkit.internal.i4$$ExternalSyntheticLambda5
            @Override // com.pspdfkit.internal.c5.a
            public final void a(Annotation annotation) {
                i4.a(this.f$0, annotation);
            }
        };
    }

    public static final m40 a(m40 m40Var, m40 m40Var2) {
        m40Var2.getClass();
        return m40Var;
    }

    public static final m40 b(m40 m40Var, m40 m40Var2) {
        m40Var2.getClass();
        return m40Var;
    }

    public final void c(final Annotation annotation) {
        annotation.getClass();
        this.e.remove(annotation.getUuid());
        this.a.a(new Function1() { // from class: com.pspdfkit.internal.i4$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return i4.a(annotation, (m40) obj);
            }
        });
        c5 c5Var = this.b;
        c5Var.getClass();
        String uuid = annotation.getInternal().getUuid();
        Job job = (Job) c5Var.h.remove(uuid);
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        l5 l5Var = c5Var.f;
        l5Var.getClass();
        uuid.getClass();
        l5Var.a.remove(uuid);
    }

    public final void d() {
        ny nyVarRemoveFirstOrNull;
        m40 state;
        if (!a() || (nyVarRemoveFirstOrNull = this.h.removeFirstOrNull()) == null || (state = this.a.getState()) == null) {
            return;
        }
        this.g = BuildersKt__Builders_commonKt.launch$default(this.f, null, null, new d(nyVarRemoveFirstOrNull, this, state.b, null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.ArrayList] */
    public final void e() {
        final ?? list;
        m40 state = this.a.getState();
        if (state == null) {
            return;
        }
        if (this.o) {
            list = CollectionsKt.toList(state.k);
        } else {
            EnumEntries<AnnotationType> enumEntries = a.a;
            list = new ArrayList();
            for (AnnotationType annotationType : enumEntries) {
                AnnotationType annotationType2 = annotationType;
                if (state.k.contains(annotationType2) || this.n.contains(annotationType2)) {
                    list.add(annotationType);
                }
            }
        }
        this.a.a(new Function1() { // from class: com.pspdfkit.internal.i4$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return i4.a(list, (m40) obj);
            }
        });
    }

    @Override // com.pspdfkit.internal.nx
    public final void recycle() {
        int i = 0;
        this.c = false;
        this.o = false;
        this.e.clear();
        this.k = false;
        JobKt__JobKt.cancelChildren$default(this.f.getCoroutineContext(), (CancellationException) null, 1, (Object) null);
        this.h.clear();
        this.a.a(new Function1() { // from class: com.pspdfkit.internal.i4$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return i4.a((m40) obj);
            }
        });
        c5 c5Var = this.b;
        c5.a aVar = this.q;
        c5Var.getClass();
        aVar.getClass();
        c5Var.i.b(aVar);
        this.l.recycle();
        this.a.removeView(this.l);
        ArrayList arrayList = this.d;
        c5 c5Var2 = this.b;
        int size = arrayList.size();
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            c5Var2.b((z4<?>) obj);
        }
        this.d.clear();
    }

    /* JADX WARN: Code duplicated, block: B:33:0x007f  */
    public static g4 a(Annotation annotation, EnumSet enumSet) {
        annotation.getClass();
        enumSet.getClass();
        boolean zContains = true;
        if (!annotation.isSignature()) {
            float f = ww.a;
            if (StringsKt.equals("AutoCAD SHX Text", annotation.getCreator(), true)) {
                zContains = false;
            } else {
                if (annotation.getType() == AnnotationType.FREETEXT) {
                    FreeTextAnnotation freeTextAnnotation = annotation instanceof FreeTextAnnotation ? (FreeTextAnnotation) annotation : null;
                    if (freeTextAnnotation != null && freeTextAnnotation.getIntent() != FreeTextAnnotation.FreeTextAnnotationIntent.FREE_TEXT_CALLOUT) {
                        float fAbs = Math.abs(freeTextAnnotation.getBoundingBox().width());
                        float fAbs2 = Math.abs(freeTextAnnotation.getBoundingBox().height());
                        float textSize = freeTextAnnotation.getTextSize();
                        if (fAbs > 0.0f && fAbs2 > 0.0f && textSize > 0.0f) {
                            float fMin = Math.min(fAbs, fAbs2);
                            float f2 = fAbs * fAbs2;
                            float f3 = textSize / fMin;
                            if (fMin <= 12.0f && f2 <= 200.0f && f3 >= 0.8f) {
                                zContains = false;
                            }
                        }
                    }
                }
                zContains = enumSet.contains(annotation.getType());
            }
        }
        return zContains ? g4.OVERLAY : g4.PAGE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v6, types: [T, com.pspdfkit.internal.m40] */
    public final void b(Annotation annotation) {
        T tA;
        annotation.getClass();
        m40 state = this.a.getState();
        if (state == null) {
            return;
        }
        this.e.remove(annotation.getUuid());
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? A = !state.l.contains(annotation) ? state : m40.a(state, false, null, 0.0f, false, false, CollectionsKt.minus(state.l, annotation), null, null, 14335);
        objectRef.element = A;
        if (A == state) {
            return;
        }
        if (n40.a((m40) A, annotation)) {
            this.a.a(new Function1() { // from class: com.pspdfkit.internal.i4$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return i4.a(objectRef, (m40) obj);
                }
            });
            return;
        }
        if (a(annotation, this.n) == g4.OVERLAY) {
            m40 m40Var = (m40) objectRef.element;
            m40Var.getClass();
            if (!m40Var.n.contains(Integer.valueOf(annotation.getObjectNumber()))) {
                tA = m40Var;
                tA = n40.a(m40Var, (List<Integer>) CollectionsKt.plus((Collection<? extends Integer>) m40Var.n, Integer.valueOf(annotation.getObjectNumber())));
            }
            tA = m40Var;
            objectRef.element = tA;
            this.l.a(annotation, true);
        }
        this.a.a(new Function1() { // from class: com.pspdfkit.internal.i4$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return i4.b(objectRef, (m40) obj);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:32:0x009a  */
    public final void d(Annotation annotation) {
        final m40 m40VarA;
        annotation.getClass();
        m40 state = this.a.getState();
        if (state != null && annotation.getPageIndex() == state.b) {
            c5 c5Var = this.b;
            c5Var.getClass();
            String uuid = annotation.getInternal().getUuid();
            Job job = (Job) c5Var.h.remove(uuid);
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            l5 l5Var = c5Var.f;
            l5Var.getClass();
            uuid.getClass();
            l5Var.a.remove(uuid);
            Job job2 = this.i;
            boolean z = job2 != null && job2.isActive();
            g4 g4VarA = a(annotation, this.n);
            boolean zA = n40.a(state, annotation);
            boolean z2 = annotation.isAttached() && !zA && g4VarA == g4.OVERLAY;
            List<Integer> list = state.n;
            if (z2) {
                if (list.contains(Integer.valueOf(annotation.getObjectNumber()))) {
                    m40VarA = state;
                } else {
                    m40VarA = n40.a(state, (List<Integer>) CollectionsKt.plus((Collection<? extends Integer>) state.n, Integer.valueOf(annotation.getObjectNumber())));
                }
            } else if (list.contains(Integer.valueOf(annotation.getObjectNumber()))) {
                m40VarA = n40.a(state, (List<Integer>) CollectionsKt.minus(state.n, Integer.valueOf(annotation.getObjectNumber())));
            } else {
                m40VarA = state;
            }
            if (m40VarA != state) {
                this.a.a(new Function1() { // from class: com.pspdfkit.internal.i4$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return i4.b(m40VarA, (m40) obj);
                    }
                });
                e();
            }
            if (g4VarA == g4.OVERLAY) {
                this.l.a(annotation, z2);
                if (z) {
                    b();
                }
            }
            if (g4VarA == g4.PAGE) {
                if (zA && this.e.contains(annotation.getUuid())) {
                    return;
                }
                this.a.a((dt) null);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final m40 b(Ref.ObjectRef objectRef, m40 m40Var) {
        m40Var.getClass();
        return (m40) objectRef.element;
    }

    public static final z4 b(i4 i4Var, Annotation annotation) {
        annotation.getClass();
        return i4Var.l.a(annotation);
    }

    public final void b() {
        if (a()) {
            Job job = this.i;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.i = BuildersKt__Builders_commonKt.launch$default(this.f, null, null, new b(null), 3, null);
        }
    }

    public static final m40 a(Annotation annotation, m40 m40Var) {
        m40Var.getClass();
        annotation.getClass();
        boolean zContains = m40Var.l.contains(annotation);
        boolean zContains2 = m40Var.n.contains(Integer.valueOf(annotation.getObjectNumber()));
        if (!zContains && !zContains2) {
            return m40Var;
        }
        List<Annotation> listMinus = m40Var.l;
        if (zContains) {
            listMinus = CollectionsKt.minus(listMinus, annotation);
        }
        List<Annotation> list = listMinus;
        List<Integer> listMinus2 = m40Var.n;
        if (zContains2) {
            listMinus2 = CollectionsKt.minus(listMinus2, Integer.valueOf(annotation.getObjectNumber()));
        }
        return m40.a(m40Var, false, null, 0.0f, false, false, list, null, listMinus2, 6143);
    }

    public static final m40 a(List list, m40 m40Var) {
        m40Var.getClass();
        list.getClass();
        return Intrinsics.areEqual(m40Var.m, list) ? m40Var : m40.a(m40Var, false, null, 0.0f, false, false, null, list, null, 12287);
    }

    public static final m40 a(m40 m40Var) {
        m40Var.getClass();
        if (!m40Var.l.isEmpty()) {
            m40Var = m40.a(m40Var, false, null, 0.0f, false, false, CollectionsKt.emptyList(), null, null, 14335);
        }
        m40 m40Var2 = m40Var;
        return m40Var2.n.isEmpty() ? m40Var2 : m40.a(m40Var2, false, null, 0.0f, false, false, null, null, CollectionsKt.emptyList(), 8191);
    }

    public final boolean a() {
        return (this.p == null || this.a.getState() == null) ? false : true;
    }

    public final void a(Annotation annotation) {
        final m40 m40VarA;
        annotation.getClass();
        m40 state = this.a.getState();
        if (state == null) {
            return;
        }
        g4 g4VarA = a(annotation, this.n);
        boolean zIsAttached = annotation.isAttached();
        boolean zContains = state.l.contains(annotation);
        boolean zContains2 = state.n.contains(Integer.valueOf(annotation.getObjectNumber()));
        if (!zContains || zContains2) {
            List<Annotation> listPlus = state.l;
            if (!zContains) {
                listPlus = CollectionsKt.plus((Collection<? extends Annotation>) listPlus, annotation);
            }
            List<Annotation> list = listPlus;
            List<Integer> listMinus = state.n;
            if (zContains2) {
                listMinus = CollectionsKt.minus(listMinus, Integer.valueOf(annotation.getObjectNumber()));
            }
            m40VarA = m40.a(state, false, null, 0.0f, false, false, list, null, listMinus, 6143);
        } else {
            m40VarA = state;
        }
        if (m40VarA == state) {
            return;
        }
        this.a.a(new Function1() { // from class: com.pspdfkit.internal.i4$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return i4.a(m40VarA, (m40) obj);
            }
        });
        if (!zIsAttached && g4VarA == g4.PAGE) {
            this.e.add(annotation.getUuid());
        }
        if (g4VarA == g4.OVERLAY) {
            this.l.a(annotation, false);
        }
    }

    public final void c() {
        if (a()) {
            this.k = true;
            Job job = this.j;
            if (job == null || !job.isActive()) {
                this.j = BuildersKt__Builders_commonKt.launch$default(this.f, null, null, new c(null), 3, null);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final m40 a(Ref.ObjectRef objectRef, m40 m40Var) {
        m40Var.getClass();
        return (m40) objectRef.element;
    }

    public final void a(List<? extends Annotation> list, boolean z, Function0<Unit> function0) {
        boolean z2;
        list.getClass();
        m40 state = this.a.getState();
        if (state == null) {
            return;
        }
        Iterator<? extends Annotation> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                z2 = false;
                break;
            }
            Annotation next = it.next();
            if (!n40.a(state, next) && a(next, this.n) == g4.PAGE) {
                z2 = true;
                break;
            }
        }
        this.h.addLast(new ny(z2, z, function0));
        Job job = this.g;
        if (job == null || !job.isActive()) {
            d();
        }
    }

    public final void a(List<? extends z4<?>> list, boolean z) {
        m40 state;
        boolean z2;
        list.getClass();
        if (a() && (state = this.a.getState()) != null) {
            boolean z3 = false;
            for (z4<?> z4Var : list) {
                this.d.remove(z4Var);
                Annotation annotation = z4Var.getAnnotation();
                if (annotation == null || !annotation.isAttached() || n40.a(state, annotation) || a(annotation, this.n) != g4.OVERLAY || z) {
                    z2 = false;
                } else {
                    c3 c3Var = this.l;
                    c3Var.getClass();
                    Annotation annotation2 = z4Var.getAnnotation();
                    if (annotation2 != null) {
                        if (c3Var.a(annotation2) == null) {
                            ViewParent parent = z4Var.a().getParent();
                            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                            if (viewGroup != null) {
                                viewGroup.removeView(z4Var.a());
                            }
                            View viewA = z4Var.a();
                            if (viewA instanceof yy) {
                                c3Var.addView(viewA, 0);
                            } else {
                                c3Var.addView(viewA);
                            }
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (!this.b.a(z4Var)) {
                            c5 c5Var = this.b;
                            c5Var.getClass();
                            AnnotationOverlayRenderStrategy.Strategy overlayRenderStrategy = c5Var.e.getOverlayRenderStrategy(annotation);
                            overlayRenderStrategy.getClass();
                            z4<?> z4VarA = c5Var.a(annotation, overlayRenderStrategy);
                            c3 c3Var2 = this.l;
                            c3Var2.getClass();
                            z4VarA.getClass();
                            View viewA2 = z4VarA.a();
                            if (viewA2 instanceof yy) {
                                c3Var2.addView(viewA2, 0);
                            } else {
                                c3Var2.addView(viewA2);
                            }
                            z4Var.a().bringToFront();
                            z4VarA.a(new j4(this, z4Var));
                        }
                    } else {
                        throw new IllegalArgumentException("Annotation view has no annotation");
                    }
                }
                if (z2) {
                    z3 = true;
                } else {
                    this.b.b(z4Var);
                    this.d.remove(z4Var);
                }
            }
            if (z3) {
                c();
            }
        }
    }

    public static final void a(i4 i4Var, Annotation annotation) {
        m40 state;
        z4<?> z4VarA;
        annotation.getClass();
        if (!i4Var.a() || (state = i4Var.a.getState()) == null || annotation.getPageIndex() != state.b || (z4VarA = i4Var.l.a(annotation)) == null || i4Var.b.a(z4VarA)) {
            return;
        }
        c5 c5Var = i4Var.b;
        c5Var.getClass();
        AnnotationOverlayRenderStrategy.Strategy overlayRenderStrategy = c5Var.e.getOverlayRenderStrategy(annotation);
        overlayRenderStrategy.getClass();
        z4<?> z4VarA2 = c5Var.a(annotation, overlayRenderStrategy);
        c3 c3Var = i4Var.l;
        c3Var.getClass();
        z4VarA2.getClass();
        View viewA = z4VarA2.a();
        if (viewA instanceof yy) {
            c3Var.addView(viewA, 0);
        } else {
            c3Var.addView(viewA);
        }
        z4VarA.a().bringToFront();
        z4VarA2.a(new j4(i4Var, z4VarA));
    }

    public final void a(List<? extends Annotation> list) {
        final m40 state = this.a.getState();
        if (state == null) {
            return;
        }
        a((Collection) SequencesKt.toList(SequencesKt.filter(CollectionsKt.asSequence(list), new Function1() { // from class: com.pspdfkit.internal.i4$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(i4.a(state, this, (Annotation) obj));
            }
        })));
    }

    public static final boolean a(m40 m40Var, i4 i4Var, Annotation annotation) {
        annotation.getClass();
        return !n40.a(m40Var, annotation) && a(annotation, i4Var.n) == g4.OVERLAY;
    }

    public final void a(Collection collection) {
        Iterator it = SequencesKt.filterNot(SequencesKt.mapNotNull(CollectionsKt.asSequence(collection), new Function1() { // from class: com.pspdfkit.internal.i4$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return i4.b(this.f$0, (Annotation) obj);
            }
        }), new Function1() { // from class: com.pspdfkit.internal.i4$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(i4.a((z4) obj));
            }
        }).iterator();
        while (it.hasNext()) {
            ((z4) it.next()).a().bringToFront();
        }
    }

    public static final boolean a(z4 z4Var) {
        z4Var.getClass();
        return z4Var instanceof yy;
    }
}
