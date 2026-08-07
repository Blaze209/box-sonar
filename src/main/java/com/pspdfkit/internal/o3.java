package com.pspdfkit.internal;

import androidx.media3.extractor.ts.PsExtractor;
import com.facebook.react.uimanager.ViewProps;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationProvider;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.AnnotationZIndexMove;
import com.pspdfkit.annotations.StampAnnotation;
import com.pspdfkit.annotations.appearance.AppearanceStreamGenerator;
import com.pspdfkit.annotations.measurements.MeasurementInfo;
import com.pspdfkit.annotations.measurements.MeasurementPrecision;
import com.pspdfkit.annotations.measurements.MeasurementValueConfiguration;
import com.pspdfkit.annotations.measurements.Scale;
import com.pspdfkit.annotations.note.AnnotationReviewSummary;
import com.pspdfkit.annotations.note.AnnotationStateChange;
import com.pspdfkit.document.checkpoint.PdfDocumentCheckpointer;
import com.pspdfkit.document.providers.AssetDataProvider;
import com.pspdfkit.exceptions.InvalidNutrientLicenseException;
import com.pspdfkit.exceptions.NutrientException;
import com.pspdfkit.internal.document.DataProviderShim;
import com.pspdfkit.internal.jni.NativeAnnotation;
import com.pspdfkit.internal.jni.NativeAnnotationListResult;
import com.pspdfkit.internal.jni.NativeAnnotationManager;
import com.pspdfkit.internal.jni.NativeDjinniError;
import com.pspdfkit.internal.jni.NativePlatformAnnotation;
import com.pspdfkit.undo.edit.annotations.AnnotationAddRemoveEdit;
import com.pspdfkit.utils.PdfLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: loaded from: classes3.dex */
public class o3 implements AnnotationProvider {
    public final lm a;
    public final Map<Integer, List<Annotation>> b;
    public final Set<Integer> c;
    public final NativeAnnotationManager d;
    public at e;
    public final ir f;
    public final m5 g;
    public final go<AnnotationProvider.OnAnnotationUpdatedListener> h;
    public boolean i;
    public final Mutex j;
    public final LinkedHashMap k;
    public final Mutex l;

    public static final class a {
        public final CompletableDeferred<List<Annotation>> a;
        public final boolean b;
        public final List<Annotation> c;

        /* JADX WARN: Multi-variable type inference failed */
        public a(CompletableDeferred<List<Annotation>> completableDeferred, boolean z, List<? extends Annotation> list) {
            completableDeferred.getClass();
            this.a = completableDeferred;
            this.b = z;
            this.c = list;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.areEqual(this.a, aVar.a) && this.b == aVar.b && Intrinsics.areEqual(this.c, aVar.c);
        }

        public final int hashCode() {
            int iA = mv.a(this.b, this.a.hashCode() * 31, 31);
            List<Annotation> list = this.c;
            return iA + (list == null ? 0 : list.hashCode());
        }

        public final String toString() {
            return "PageLoadHandle(loader=" + this.a + ", shouldLoad=" + this.b + ", oldAnnotations=" + this.c + ")";
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.annotations.AnnotationProviderImpl", f = "AnnotationProviderImpl.kt", i = {0, 0, 0, 0}, l = {450}, m = "addAnnotationToPageInternal", n = {"annotation", "preferredObjectNumber", ViewProps.Z_INDEX, "addToUndoStack"}, nl = {502}, s = {"L$0", "L$1", "L$2", "Z$0"}, v = 2)
    public static final class b extends ContinuationImpl {
        public Annotation a;
        public Object b;
        public Object c;
        public boolean d;
        public /* synthetic */ Object e;
        public int g;

        public b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= Integer.MIN_VALUE;
            return o3.this.a((Annotation) null, (Integer) null, (Integer) null, false, (Continuation<? super Unit>) this);
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.annotations.AnnotationProviderImpl$addAnnotationToPageInternal$2", f = "AnnotationProviderImpl.kt", i = {1, 1, 1, 1, 2, 2, 2, 2}, l = {458, 1115, 1126}, m = "invokeSuspend", n = {"cachedAnnotations", "nativeAnnotation", "$this$withLock_u24default$iv", "$i$f$withLock", "cachedAnnotations", "nativeAnnotation", "$this$withLock_u24default$iv", "$i$f$withLock"}, nl = {460, 1116, 1127}, s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "I$0"}, v = 2)
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public List a;
        public Object b;
        public Mutex c;
        public Object d;
        public Object e;
        public Integer f;
        public Integer g;
        public int h;
        public final /* synthetic */ Annotation j;
        public final /* synthetic */ Integer k;
        public final /* synthetic */ Integer l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Annotation annotation, Integer num, Integer num2, Continuation<? super c> continuation) {
            super(2, continuation);
            this.j = annotation;
            this.k = num;
            this.l = num2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return o3.this.new c(this.j, this.k, this.l, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:30:0x014e A[Catch: all -> 0x01b1, TryCatch #0 {all -> 0x01b1, blocks: (B:28:0x0100, B:30:0x014e, B:31:0x0156), top: B:51:0x0100 }] */
        /* JADX WARN: Code duplicated, block: B:34:0x0161  */
        /* JADX WARN: Code duplicated, block: B:35:0x0169  */
        /* JADX WARN: Code duplicated, block: B:39:0x0191  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v15, types: [T, com.pspdfkit.internal.jni.NativeAnnotation] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            List<Annotation> mutableList;
            Ref.ObjectRef objectRef;
            T t;
            o3 o3Var;
            Mutex mutex;
            Annotation annotation;
            Integer num;
            Integer num2;
            NativeAnnotation nativeAnnotation;
            Integer num3;
            Annotation annotation2;
            o3 o3Var2;
            Mutex mutex2;
            Annotation annotation3;
            List<Annotation> list;
            Mutex mutex3;
            Annotation annotation4;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.h;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                o3.b(this.j);
                this.j.getInternal().ensureAnnotationCanBeAttachedToDocument(o3.this.a);
                this.j.getInternal().markPreferredForPlatformRendering();
                o3 o3Var3 = o3.this;
                int pageIndex = this.j.getPageIndex();
                this.h = 1;
                obj = o3Var3.getAnnotations(pageIndex, this);
                if (obj != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i == 2) {
                    num2 = this.g;
                    num = this.f;
                    o3Var = (o3) this.e;
                    annotation = (Annotation) this.d;
                    mutex = this.c;
                    objectRef = (Ref.ObjectRef) this.b;
                    List<Annotation> list2 = this.a;
                    ResultKt.throwOnFailure(obj);
                    mutableList = list2;
                    try {
                        annotation.getInternal().onBeforeAttachToDocument(o3Var.a, (NativeAnnotation) objectRef.element);
                        o3Var.d.attachToDocumentIfNotAttached((NativeAnnotation) objectRef.element, num, num2);
                        ir irVar = o3Var.f;
                        NativeAnnotation nativeAnnotation2 = (NativeAnnotation) objectRef.element;
                        NativeAnnotationManager nativeAnnotationManager = o3Var.d;
                        irVar.getClass();
                        nativeAnnotation2.getClass();
                        nativeAnnotationManager.getClass();
                        kr krVar = new kr(irVar, nativeAnnotationManager, nativeAnnotation2);
                        irVar.a.put(Long.valueOf(krVar.c), nativeAnnotation2);
                        annotation.getInternal().onAttachToDocument(o3Var.a, krVar);
                        nativeAnnotation = (NativeAnnotation) objectRef.element;
                        if (iw.b.get() < 10000) {
                            nativeAnnotation.setPlatformAnnotation(new iw(annotation));
                        }
                        Unit unit = Unit.INSTANCE;
                        mutex.unlock(null);
                        num3 = this.l;
                        annotation2 = this.j;
                        if (num3 != null) {
                            mutableList.add(num3.intValue(), annotation2);
                        } else {
                            Boxing.boxBoolean(mutableList.add(annotation2));
                        }
                        o3Var2 = o3.this;
                        mutex2 = o3Var2.j;
                        annotation3 = this.j;
                        this.a = mutableList;
                        this.b = SpillingKt.nullOutSpilledVariable(objectRef);
                        this.c = mutex2;
                        this.d = o3Var2;
                        this.e = annotation3;
                        this.f = null;
                        this.g = null;
                        this.h = 3;
                        if (mutex2.lock(null, this) != coroutine_suspended) {
                            list = mutableList;
                            mutex3 = mutex2;
                            annotation4 = annotation3;
                        }
                        return coroutine_suspended;
                    } catch (Throwable th) {
                        mutex.unlock(null);
                        throw th;
                    }
                }
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                annotation4 = (Annotation) this.e;
                o3Var2 = (o3) this.d;
                mutex3 = this.c;
                list = this.a;
                ResultKt.throwOnFailure(obj);
            }
            try {
                o3Var2.a(annotation4);
                o3Var2.b.put(Boxing.boxInt(annotation4.getPageIndex()), list);
                o3Var2.i = true;
                return Unit.INSTANCE;
            } finally {
                mutex3.unlock(null);
            }
            mutableList = CollectionsKt.toMutableList((Collection) obj);
            if (this.j.getInternal().getNativeAnnotation() != null) {
                throw new IllegalStateException("This annotation can't be added, since it is already attached to a document.");
            }
            objectRef = new Ref.ObjectRef();
            Integer detachedAnnotationLookupKey = this.j.getInternal().getDetachedAnnotationLookupKey();
            if (detachedAnnotationLookupKey != null) {
                o3 o3Var4 = o3.this;
                Annotation annotation5 = this.j;
                int iIntValue = detachedAnnotationLookupKey.intValue();
                NativeAnnotation heldAnnotation = o3Var4.d.getHeldAnnotation(iIntValue);
                o3Var4.d.dropAnnotation(iIntValue);
                annotation5.getInternal().setDetachedAnnotationLookupKey(null, null);
                t = heldAnnotation;
            } else {
                t = 0;
            }
            objectRef.element = t;
            if (t == 0) {
                objectRef.element = o3.this.d.createAnnotation(this.j.getPageIndex(), r10.a(this.j.getType()), this.k);
            }
            o3Var = o3.this;
            mutex = o3Var.l;
            annotation = this.j;
            Integer num4 = this.k;
            Integer num5 = this.l;
            this.a = mutableList;
            this.b = objectRef;
            this.c = mutex;
            this.d = annotation;
            this.e = o3Var;
            this.f = num4;
            this.g = num5;
            this.h = 2;
            if (mutex.lock(null, this) != coroutine_suspended) {
                num = num4;
                num2 = num5;
                annotation.getInternal().onBeforeAttachToDocument(o3Var.a, (NativeAnnotation) objectRef.element);
                o3Var.d.attachToDocumentIfNotAttached((NativeAnnotation) objectRef.element, num, num2);
                ir irVar2 = o3Var.f;
                NativeAnnotation nativeAnnotation3 = (NativeAnnotation) objectRef.element;
                NativeAnnotationManager nativeAnnotationManager2 = o3Var.d;
                irVar2.getClass();
                nativeAnnotation3.getClass();
                nativeAnnotationManager2.getClass();
                kr krVar2 = new kr(irVar2, nativeAnnotationManager2, nativeAnnotation3);
                irVar2.a.put(Long.valueOf(krVar2.c), nativeAnnotation3);
                annotation.getInternal().onAttachToDocument(o3Var.a, krVar2);
                nativeAnnotation = (NativeAnnotation) objectRef.element;
                if (iw.b.get() < 10000) {
                    nativeAnnotation.setPlatformAnnotation(new iw(annotation));
                }
                Unit unit2 = Unit.INSTANCE;
                mutex.unlock(null);
                num3 = this.l;
                annotation2 = this.j;
                if (num3 != null) {
                    mutableList.add(num3.intValue(), annotation2);
                } else {
                    Boxing.boxBoolean(mutableList.add(annotation2));
                }
                o3Var2 = o3.this;
                mutex2 = o3Var2.j;
                annotation3 = this.j;
                this.a = mutableList;
                this.b = SpillingKt.nullOutSpilledVariable(objectRef);
                this.c = mutex2;
                this.d = o3Var2;
                this.e = annotation3;
                this.f = null;
                this.g = null;
                this.h = 3;
                if (mutex2.lock(null, this) != coroutine_suspended) {
                    list = mutableList;
                    mutex3 = mutex2;
                    annotation4 = annotation3;
                    o3Var2.a(annotation4);
                    o3Var2.b.put(Boxing.boxInt(annotation4.getPageIndex()), list);
                    o3Var2.i = true;
                    return Unit.INSTANCE;
                }
            }
            return coroutine_suspended;
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.annotations.AnnotationProviderImpl", f = "AnnotationProviderImpl.kt", i = {0, 0}, l = {643}, m = "createAnnotationFromInstantJson$suspendImpl", n = {"$this", "annotationJson"}, nl = {642}, s = {"L$0", "L$1"}, v = 2)
    public static final class d extends ContinuationImpl {
        public o3 a;
        public Object b;
        public /* synthetic */ Object c;
        public int e;

        public d(Continuation<? super d> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return o3.a(o3.this, (String) null, this);
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.annotations.AnnotationProviderImpl$createAnnotationFromInstantJson$annotation$1", f = "AnnotationProviderImpl.kt", i = {0, 0, 1, 1, 2, 2}, l = {1115, 663, 667}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$i$f$withLock", "pageIndex", "annotationId", "pageIndex", "annotationId"}, nl = {1116, 665, 1121}, s = {"L$0", "I$0", "I$0", "J$0", "I$0", "J$0"}, v = 2)
    public static final class e extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Annotation>, Object> {
        public Mutex a;
        public o3 b;
        public String c;
        public int d;
        public long e;
        public int f;
        public final /* synthetic */ String h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(String str, Continuation<? super e> continuation) {
            super(2, continuation);
            this.h = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return o3.this.new e(this.h, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Annotation> continuation) {
            return o3.this.new e(this.h, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x00bb, code lost:
        
            if (r12 == r0) goto L28;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                Method dump skipped, instruction units count: 222
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.pspdfkit.internal.o3.e.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.annotations.AnnotationProviderImpl", f = "AnnotationProviderImpl.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {417}, m = "getAllAnnotationsOfType$suspendImpl", n = {"$this", "types", "$this$getAllAnnotationsOfType_u24lambda_u240", "startIndex", "pageCount", "end", "$i$a$-buildList-AnnotationProviderImpl$getAllAnnotationsOfType$3", "pageIndex"}, nl = {418}, s = {"L$0", "L$1", "L$3", "I$0", "I$1", "I$2", "I$3", "I$4"}, v = 2)
    public static final class f extends ContinuationImpl {
        public o3 a;
        public Set b;
        public List c;
        public List d;
        public int e;
        public int f;
        public int g;
        public int h;
        public int i;
        public /* synthetic */ Object j;
        public int l;

        public f(Continuation<? super f> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.j = obj;
            this.l |= Integer.MIN_VALUE;
            return o3.a(o3.this, (Set<? extends AnnotationType>) null, 0, 0, this);
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.annotations.AnnotationProviderImpl", f = "AnnotationProviderImpl.kt", i = {0, 0, 0}, l = {378}, m = "getAnnotation$suspendImpl", n = {"$this", "pageIndex", "objectNumber"}, nl = {1110}, s = {"L$0", "I$0", "I$1"}, v = 2)
    public static final class g extends ContinuationImpl {
        public Object a;
        public int b;
        public /* synthetic */ Object c;
        public int e;

        public g(Continuation<? super g> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return o3.a(o3.this, 0, 0, this);
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.annotations.AnnotationProviderImpl", f = "AnnotationProviderImpl.kt", i = {0, 0, 0}, l = {381}, m = "getAnnotation$suspendImpl", n = {"$this", "uuid", "pageIndex"}, nl = {1110}, s = {"L$0", "L$1", "I$0"}, v = 2)
    public static final class h extends ContinuationImpl {
        public Object a;
        public String b;
        public /* synthetic */ Object c;
        public int e;

        public h(Continuation<? super h> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return o3.a(o3.this, 0, (String) null, this);
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.annotations.AnnotationProviderImpl", f = "AnnotationProviderImpl.kt", i = {0, 0, 0, 0, 0}, l = {392}, m = "getAnnotations$suspendImpl", n = {"$this", "objectNumbers", "remaining", "found", "pageIndex"}, nl = {393}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 2)
    public static final class i extends ContinuationImpl {
        public o3 a;
        public Object b;
        public Set c;
        public List d;
        public int e;
        public int f;
        public /* synthetic */ Object g;
        public int i;

        public i(Continuation<? super i> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.g = obj;
            this.i |= Integer.MIN_VALUE;
            return o3.a(o3.this, (Collection<Integer>) null, this);
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.annotations.AnnotationProviderImpl", f = "AnnotationProviderImpl.kt", i = {0, 0}, l = {235}, m = "getAnnotationsJson$suspendImpl", n = {"$this", "pageIndex"}, nl = {PsExtractor.VIDEO_STREAM_MASK}, s = {"L$0", "I$0"}, v = 2)
    public static final class j extends ContinuationImpl {
        public Object a;
        public /* synthetic */ Object b;
        public int d;

        public j(Continuation<? super j> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return o3.a(o3.this, 0, this);
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.annotations.AnnotationProviderImpl$getAnnotationsJson$2", f = "AnnotationProviderImpl.kt", i = {0, 0}, l = {1115}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$i$f$withLock"}, nl = {1116}, s = {"L$0", "I$1"}, v = 2)
    public static final class k extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        public Mutex a;
        public o3 b;
        public int c;
        public int d;
        public final /* synthetic */ int f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(int i, Continuation<? super k> continuation) {
            super(2, continuation);
            this.f = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return o3.this.new k(this.f, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
            return o3.this.new k(this.f, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            o3 o3Var;
            Mutex mutex;
            int i;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.d;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                o3.this.a(this.f);
                o3Var = o3.this;
                Mutex mutex2 = o3Var.j;
                int i3 = this.f;
                this.a = mutex2;
                this.b = o3Var;
                this.c = i3;
                this.d = 1;
                if (mutex2.lock(null, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutex = mutex2;
                i = i3;
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i = this.c;
                o3Var = this.b;
                mutex = this.a;
                ResultKt.throwOnFailure(obj);
            }
            try {
                String annotationsJson = o3Var.d.getAnnotationsJson(i);
                annotationsJson.getClass();
                return annotationsJson;
            } finally {
                mutex.unlock(null);
            }
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.annotations.AnnotationProviderImpl", f = "AnnotationProviderImpl.kt", i = {0, 0, 0, 1, 1, 1}, l = {728, 728}, m = "moveAnnotation$suspendImpl", n = {"$this", "annotation", ViewProps.Z_INDEX, "$this", "annotation", ViewProps.Z_INDEX}, nl = {728, 729}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "I$0"}, v = 2)
    public static final class l extends ContinuationImpl {
        public Object a;
        public Object b;
        public o3 c;
        public int d;
        public int e;
        public /* synthetic */ Object f;
        public int h;

        public l(Continuation<? super l> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f = obj;
            this.h |= Integer.MIN_VALUE;
            return o3.a(o3.this, (Annotation) null, 0, this);
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.annotations.AnnotationProviderImpl", f = "AnnotationProviderImpl.kt", i = {0, 0}, l = {519}, m = "removeAnnotationFromPage", n = {"annotation", "addToUndoStack"}, nl = {518}, s = {"L$0", "Z$0"}, v = 2)
    public static final class m extends ContinuationImpl {
        public Object a;
        public /* synthetic */ Object b;
        public int d;

        public m(Continuation<? super m> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return o3.this.a((Annotation) null, false, (Continuation<? super Unit>) this);
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.annotations.AnnotationProviderImpl$removeAnnotationFromPage$removedAnnotations$1", f = "AnnotationProviderImpl.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {1115, 1127, 1156}, m = "invokeSuspend", n = {"$this$withContext", "nativeAnnotation", "backupForUndo", "$this$withLock_u24default$iv", "$i$f$withLock", "$this$withContext", "nativeAnnotation", "backupForUndo", "coreRemoveResult", "removedNative", "$this$withLock_u24default$iv", "pageIndex", "$i$f$withLock", "$this$withContext", "nativeAnnotation", "backupForUndo", "coreRemoveResult", "removedNative", "cachedAnnotations", "removedAnnotations", "$this$withLock_u24default$iv", "pageIndex", "$i$f$withLock"}, nl = {1116, 1128, 1157}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0", "I$1"}, v = 2)
    public static final class n extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Annotation>>, Object> {
        public Object a;
        public StampAnnotation b;
        public Object c;
        public Object d;
        public Object e;
        public Object f;
        public Mutex g;
        public o3 h;
        public int i;
        public int j;
        public /* synthetic */ Object k;
        public final /* synthetic */ Annotation m;
        public final /* synthetic */ boolean n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(Annotation annotation, boolean z, Continuation<? super n> continuation) {
            super(2, continuation);
            this.m = annotation;
            this.n = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            n nVar = o3.this.new n(this.m, this.n, continuation);
            nVar.k = obj;
            return nVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Annotation>> continuation) {
            return ((n) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:133:0x01c0 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:27:0x00c8  */
        /* JADX WARN: Code duplicated, block: B:63:0x0197  */
        /* JADX WARN: Code duplicated, block: B:66:0x01a1  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            NativeAnnotation nativeAnnotation;
            StampAnnotation stampAnnotation;
            NativeAnnotation nativeAnnotation2;
            o3 o3Var;
            Mutex mutex;
            NativeAnnotationListResult nativeAnnotationListResultRemoveAnnotation;
            Integer absolutePageIndex;
            StampAnnotation stampAnnotation2;
            o3 o3Var2;
            ArrayList<NativeAnnotation> arrayList;
            int i;
            Mutex mutex2;
            List<Annotation> list;
            List<Annotation> mutableList;
            int i2;
            o3 o3Var3;
            Mutex mutex3;
            List list2;
            Iterator it;
            Object next;
            Annotation annotation;
            NativeAnnotation nativeAnnotation3;
            StampAnnotation stampAnnotation3;
            Annotation annotation2;
            CoroutineScope coroutineScope = (CoroutineScope) this.k;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.j;
            try {
                if (i3 == 0) {
                    ResultKt.throwOnFailure(obj);
                    o3.b(this.m);
                    if (Intrinsics.areEqual(o3.this.a, this.m.getInternal().getInternalDocument()) && (nativeAnnotation = this.m.getInternal().getNativeAnnotation()) != null) {
                        Annotation annotation3 = this.m;
                        if ((annotation3 instanceof StampAnnotation) && ((StampAnnotation) annotation3).hasBitmap()) {
                            Annotation annotation4 = this.m;
                            Annotation copy = annotation4.getCopy(annotation4.getPageIndex());
                            if (copy instanceof StampAnnotation) {
                                stampAnnotation = (StampAnnotation) copy;
                            } else {
                                stampAnnotation = null;
                            }
                        } else {
                            stampAnnotation = null;
                        }
                        o3 o3Var4 = o3.this;
                        Mutex mutex4 = o3Var4.l;
                        this.k = coroutineScope;
                        this.a = nativeAnnotation;
                        this.b = stampAnnotation;
                        this.c = mutex4;
                        this.d = o3Var4;
                        this.i = 0;
                        this.j = 1;
                        if (mutex4.lock(null, this) != coroutine_suspended) {
                            nativeAnnotation2 = nativeAnnotation;
                            o3Var = o3Var4;
                            mutex = mutex4;
                        }
                        return coroutine_suspended;
                    }
                    return CollectionsKt.emptyList();
                }
                if (i3 == 1) {
                    o3Var = (o3) this.d;
                    mutex = (Mutex) this.c;
                    stampAnnotation = this.b;
                    NativeAnnotation nativeAnnotation4 = (NativeAnnotation) this.a;
                    ResultKt.throwOnFailure(obj);
                    nativeAnnotation2 = nativeAnnotation4;
                } else {
                    if (i3 == 2) {
                        i = this.i;
                        o3Var2 = (o3) this.f;
                        mutex2 = (Mutex) this.e;
                        arrayList = (ArrayList) this.d;
                        nativeAnnotationListResultRemoveAnnotation = (NativeAnnotationListResult) this.c;
                        StampAnnotation stampAnnotation4 = this.b;
                        nativeAnnotation2 = (NativeAnnotation) this.a;
                        ResultKt.throwOnFailure(obj);
                        stampAnnotation2 = stampAnnotation4;
                        try {
                            list = o3Var2.b.get(Boxing.boxInt(i));
                            if (list != null || (mutableList = CollectionsKt.toMutableList((Collection) list)) == null) {
                                PdfLog.w("Nutri.AnnotationProvImp", "Can't remove annotations from cache: annotations not cached for page " + i + ".", new Object[0]);
                                List listEmptyList = CollectionsKt.emptyList();
                                mutex2.unlock(null);
                                return listEmptyList;
                            }
                            mutex2.unlock(null);
                            ArrayList arrayList2 = new ArrayList();
                            int size = arrayList.size();
                            int i4 = 0;
                            while (i4 < size) {
                                NativeAnnotation nativeAnnotation5 = arrayList.get(i4);
                                i4++;
                                NativeAnnotation nativeAnnotation6 = nativeAnnotation5;
                                NativePlatformAnnotation platformAnnotation = nativeAnnotation6.getPlatformAnnotation();
                                iw iwVar = platformAnnotation instanceof iw ? (iw) platformAnnotation : null;
                                if (iwVar != null) {
                                    annotation = iwVar.a.get();
                                    if (!Annotation.class.isInstance(annotation)) {
                                        annotation = null;
                                    }
                                    if (annotation == null) {
                                        it = mutableList.iterator();
                                        while (true) {
                                            if (it.hasNext()) {
                                                next = null;
                                                break;
                                            }
                                            next = it.next();
                                            nativeAnnotation3 = ((Annotation) next).getInternal().getNativeAnnotation();
                                            if (nativeAnnotation3 == null && nativeAnnotation3.getIdentifier() == nativeAnnotation6.getIdentifier()) {
                                                break;
                                            }
                                        }
                                        annotation = (Annotation) next;
                                    }
                                } else {
                                    it = mutableList.iterator();
                                    while (true) {
                                        if (it.hasNext()) {
                                            next = null;
                                            break;
                                        }
                                        next = it.next();
                                        nativeAnnotation3 = ((Annotation) next).getInternal().getNativeAnnotation();
                                        if (nativeAnnotation3 == null) {
                                        }
                                    }
                                    annotation = (Annotation) next;
                                }
                                if (annotation != null) {
                                    arrayList2.add(annotation);
                                }
                            }
                            int size2 = arrayList2.size();
                            int i5 = 0;
                            while (i5 < size2) {
                                Object obj2 = arrayList2.get(i5);
                                i5++;
                                Annotation annotation5 = (Annotation) obj2;
                                if (mutableList.remove(annotation5)) {
                                    PdfLog.d("Nutri.AnnotationProvImp", "Removed annotation %s with objNum %d.", annotation5.getType(), Boxing.boxInt(annotation5.getObjectNumber()));
                                }
                            }
                            if (!arrayList2.isEmpty()) {
                                o3.this.i = true;
                            }
                            o3 o3Var5 = o3.this;
                            Mutex mutex5 = o3Var5.j;
                            this.k = SpillingKt.nullOutSpilledVariable(coroutineScope);
                            this.a = SpillingKt.nullOutSpilledVariable(nativeAnnotation2);
                            this.b = stampAnnotation2;
                            this.c = SpillingKt.nullOutSpilledVariable(nativeAnnotationListResultRemoveAnnotation);
                            this.d = SpillingKt.nullOutSpilledVariable(arrayList);
                            this.e = mutableList;
                            this.f = arrayList2;
                            this.g = mutex5;
                            this.h = o3Var5;
                            this.i = i;
                            this.j = 3;
                            if (mutex5.lock(null, this) != coroutine_suspended) {
                                i2 = i;
                                o3Var3 = o3Var5;
                                mutex3 = mutex5;
                                list2 = arrayList2;
                                stampAnnotation3 = stampAnnotation2;
                            }
                            return coroutine_suspended;
                        } catch (Throwable th) {
                            mutex2.unlock(null);
                            throw th;
                        }
                    }
                    if (i3 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i2 = this.i;
                    o3Var3 = this.h;
                    mutex3 = this.g;
                    list2 = (List) this.f;
                    mutableList = (List) this.e;
                    StampAnnotation stampAnnotation5 = this.b;
                    ResultKt.throwOnFailure(obj);
                    stampAnnotation3 = stampAnnotation5;
                }
                try {
                    o3Var3.b.put(Boxing.boxInt(i2), mutableList);
                    Unit unit = Unit.INSTANCE;
                    mutex3.unlock(null);
                    PdfLog.d("Nutri.AnnotationProvImp", "Groomed cache for page %d.", Boxing.boxInt(i2));
                    o3.this.f(this.m);
                    if (this.n) {
                        AnnotationType type = this.m.getType();
                        type.getClass();
                        switch (u0.a[type.ordinal()]) {
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                            case 9:
                            case 10:
                            case 11:
                            case 12:
                            case 13:
                            case 14:
                            case 15:
                            case 16:
                                at atVar = o3.this.e;
                                if (atVar != null) {
                                    if (stampAnnotation3 == null) {
                                        annotation2 = stampAnnotation3;
                                        annotation2 = this.m;
                                    }
                                    annotation2 = stampAnnotation3;
                                    atVar.a(new AnnotationAddRemoveEdit(annotation2, AnnotationAddRemoveEdit.Type.REMOVE_ANNOTATION));
                                }
                                break;
                            case 17:
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                                break;
                            default:
                                throw new NoWhenBranchMatchedException();
                        }
                    }
                    Iterator it2 = list2.iterator();
                    while (it2.hasNext()) {
                        ((Annotation) it2.next()).getInternal().onDetachedFromDocument();
                    }
                    return list2;
                } catch (Throwable th2) {
                    mutex3.unlock(null);
                    throw th2;
                }
                nativeAnnotationListResultRemoveAnnotation = o3Var.d.removeAnnotation(nativeAnnotation2);
                mutex.unlock(null);
                nativeAnnotationListResultRemoveAnnotation.getClass();
                if (nativeAnnotationListResultRemoveAnnotation.hasError()) {
                    NativeDjinniError nativeDjinniErrorError = nativeAnnotationListResultRemoveAnnotation.error();
                    nativeDjinniErrorError.getClass();
                    throw new NutrientException("Could not remove annotation " + this.m + ": " + nativeDjinniErrorError.getCode() + " " + nativeDjinniErrorError.getMessage());
                }
                ArrayList<NativeAnnotation> arrayListValue = nativeAnnotationListResultRemoveAnnotation.value();
                arrayListValue.getClass();
                int size3 = arrayListValue.size();
                int i6 = 0;
                do {
                    if (i6 >= size3) {
                        absolutePageIndex = null;
                        break;
                    }
                    NativeAnnotation nativeAnnotation7 = arrayListValue.get(i6);
                    i6++;
                    absolutePageIndex = nativeAnnotation7.getAbsolutePageIndex();
                } while (absolutePageIndex == null);
                if (absolutePageIndex == null) {
                    return CollectionsKt.emptyList();
                }
                int iIntValue = absolutePageIndex.intValue();
                o3 o3Var6 = o3.this;
                Mutex mutex6 = o3Var6.j;
                this.k = coroutineScope;
                this.a = SpillingKt.nullOutSpilledVariable(nativeAnnotation2);
                this.b = stampAnnotation;
                this.c = SpillingKt.nullOutSpilledVariable(nativeAnnotationListResultRemoveAnnotation);
                this.d = arrayListValue;
                this.e = mutex6;
                this.f = o3Var6;
                this.i = iIntValue;
                this.j = 2;
                if (mutex6.lock(null, this) != coroutine_suspended) {
                    stampAnnotation2 = stampAnnotation;
                    o3Var2 = o3Var6;
                    arrayList = arrayListValue;
                    i = iIntValue;
                    mutex2 = mutex6;
                    list = o3Var2.b.get(Boxing.boxInt(i));
                    if (list != null) {
                    }
                    PdfLog.w("Nutri.AnnotationProvImp", "Can't remove annotations from cache: annotations not cached for page " + i + ".", new Object[0]);
                    List listEmptyList2 = CollectionsKt.emptyList();
                    mutex2.unlock(null);
                    return listEmptyList2;
                }
                return coroutine_suspended;
            } catch (Throwable th3) {
                mutex.unlock(null);
                throw th3;
            }
        }
    }

    public o3() {
        throw null;
    }

    public o3(lm lmVar) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        NativeAnnotationManager nativeAnnotationManagerCreate = NativeAnnotationManager.create(lmVar.y, new DataProviderShim(new AssetDataProvider(wg.b("annotations.bfbs"))));
        if (nativeAnnotationManagerCreate == null) {
            throw new NutrientException("Could not initialize NativeAnnotationManager.");
        }
        this.a = lmVar;
        this.b = linkedHashMap;
        this.c = linkedHashSet;
        this.d = nativeAnnotationManagerCreate;
        this.f = new ir();
        this.g = new m5(lmVar);
        this.h = new go<>();
        this.j = MutexKt.Mutex$default(false, 1, null);
        this.k = new LinkedHashMap();
        this.l = MutexKt.Mutex$default(false, 1, null);
    }

    public static final void b(o3 o3Var, Annotation annotation) {
        Iterator<AnnotationProvider.OnAnnotationUpdatedListener> it = o3Var.h.iterator();
        it.getClass();
        while (it.hasNext()) {
            it.next().onAnnotationRemoved(annotation);
        }
    }

    public Object a(Set<Integer> set, Continuation<? super List<? extends Annotation>> continuation) {
        return a(this, (Set) set, (ContinuationImpl) continuation);
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider
    public final Object addAnnotationToPage(Annotation annotation, Continuation<? super Unit> continuation) {
        Object objA = a(annotation, (Integer) null, (Integer) null, true, continuation);
        return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Unit.INSTANCE;
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider
    public final void addAppearanceStreamGenerator(AppearanceStreamGenerator appearanceStreamGenerator) {
        appearanceStreamGenerator.getClass();
        addAppearanceStreamGenerator(appearanceStreamGenerator, false);
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider
    public final Object appendAnnotationState(Annotation annotation, AnnotationStateChange annotationStateChange, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new p3(this, annotation, annotationStateChange, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    public final void c(final Annotation annotation) {
        annotation.getClass();
        annotation.getInternal().notifyAnnotationCreated();
        h60.a(new Runnable() { // from class: com.pspdfkit.internal.o3$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                o3.a(this.f$0, annotation);
            }
        });
        PdfDocumentCheckpointer pdfDocumentCheckpointer = this.a.J;
        if (pdfDocumentCheckpointer != null) {
            pdfDocumentCheckpointer.onDocumentModified();
        }
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider
    public final Object createAnnotationFromInstantJson(String str, Continuation<? super Annotation> continuation) {
        return a(this, str, continuation);
    }

    public final void d(final Annotation annotation) {
        annotation.getClass();
        annotation.getInternal().notifyAnnotationRemoved();
        h60.a(new Runnable() { // from class: com.pspdfkit.internal.o3$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                o3.b(this.f$0, annotation);
            }
        });
        PdfDocumentCheckpointer pdfDocumentCheckpointer = this.a.J;
        if (pdfDocumentCheckpointer != null) {
            pdfDocumentCheckpointer.onDocumentModified();
        }
    }

    public final void e(final Annotation annotation) {
        annotation.getClass();
        annotation.getInternal().notifyAnnotationUpdated();
        h60.a(new Runnable() { // from class: com.pspdfkit.internal.o3$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                o3.c(this.f$0, annotation);
            }
        });
        PdfDocumentCheckpointer pdfDocumentCheckpointer = this.a.J;
        if (pdfDocumentCheckpointer != null) {
            pdfDocumentCheckpointer.onDocumentModified();
        }
    }

    public final void f(Annotation annotation) {
        if (annotation.isMeasurement()) {
            lm lmVar = this.a;
            Function1 function1 = new Function1() { // from class: com.pspdfkit.internal.o3$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return o3.a((List) obj);
                }
            };
            lmVar.getClass();
            lmVar.a(EmptyCoroutineContext.INSTANCE, new pm(lmVar, function1, null));
        }
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider
    public final Object getAllAnnotationsOfType(Set<? extends AnnotationType> set, int i2, int i3, Continuation<? super List<? extends Annotation>> continuation) {
        return a(this, set, i2, i3, continuation);
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider
    public final Object getAnnotation(int i2, int i3, Continuation<? super Annotation> continuation) {
        return a(this, i2, i3, continuation);
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider
    public final Object getAnnotationReplies(Annotation annotation, Continuation<? super List<? extends Annotation>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new r3(this, annotation, null), continuation);
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider
    public final Object getAnnotations(Collection<Integer> collection, Continuation<? super List<? extends Annotation>> continuation) {
        return a(this, collection, continuation);
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider
    public final Object getAnnotationsJson(int i2, Continuation<? super String> continuation) {
        return a(this, i2, continuation);
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider
    public final Object getFlattenedAnnotationReplies(Annotation annotation, Continuation<? super List<? extends Annotation>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new t3(this, annotation, null), continuation);
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider
    public final Object getReviewHistory(Annotation annotation, Continuation<? super List<AnnotationStateChange>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new v3(this, annotation, null), continuation);
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider
    public final Object getReviewSummary(Annotation annotation, String str, Continuation<? super AnnotationReviewSummary> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new w3(this, annotation, str, null), continuation);
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider
    public final Object getZIndex(Annotation annotation, Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new y3(annotation, this, null), continuation);
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider
    public boolean hasUnsavedChanges() {
        if (this.i) {
            return true;
        }
        Collection<List<Annotation>> collectionValues = this.b.values();
        if ((collectionValues instanceof Collection) && collectionValues.isEmpty()) {
            return false;
        }
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            List list = (List) it.next();
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    if (((Annotation) it2.next()).isModified()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider
    public final Object moveAnnotation(Annotation annotation, int i2, Continuation<? super Unit> continuation) {
        return a(this, annotation, i2, continuation);
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider
    public Object removeAnnotationFromPage(Annotation annotation, Continuation<? super Unit> continuation) {
        Object objA = a(annotation, true, continuation);
        return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Unit.INSTANCE;
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider
    public final void removeAppearanceStreamGenerator(AppearanceStreamGenerator appearanceStreamGenerator) {
        appearanceStreamGenerator.getClass();
        m5 m5Var = this.g;
        m5Var.getClass();
        appearanceStreamGenerator.getClass();
        m5Var.c.b(appearanceStreamGenerator);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0023  */
    /* JADX WARN: Code duplicated, block: B:15:0x0029  */
    public static final Unit a(MeasurementValueConfiguration measurementValueConfiguration, List list) {
        o00 o00Var;
        list.getClass();
        if (Intrinsics.areEqual(e60.a, measurementValueConfiguration)) {
            MeasurementValueConfiguration measurementValueConfiguration2 = e60.a;
            if (!Intrinsics.areEqual(measurementValueConfiguration2 != null ? measurementValueConfiguration2.getName() : null, measurementValueConfiguration != null ? measurementValueConfiguration.getName() : null)) {
                e60.a = measurementValueConfiguration;
                o00Var = e60.b;
                if (o00Var != null) {
                    o00Var.a(measurementValueConfiguration);
                }
            }
        } else {
            e60.a = measurementValueConfiguration;
            o00Var = e60.b;
            if (o00Var != null) {
                o00Var.a(measurementValueConfiguration);
            }
        }
        return Unit.INSTANCE;
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider
    public final Object addAnnotationToPage(Annotation annotation, int i2, Continuation<? super Unit> continuation) {
        Object objA = a(annotation, (Integer) null, Boxing.boxInt(i2), true, continuation);
        return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Unit.INSTANCE;
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider
    public final void addAppearanceStreamGenerator(AppearanceStreamGenerator appearanceStreamGenerator, boolean z) {
        appearanceStreamGenerator.getClass();
        m5 m5Var = this.g;
        m5Var.getClass();
        appearanceStreamGenerator.getClass();
        go<AppearanceStreamGenerator> goVar = m5Var.c;
        if (z) {
            goVar.addFirst(appearanceStreamGenerator);
        } else {
            goVar.a(appearanceStreamGenerator);
        }
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider
    public final Object getAllAnnotationsOfType(Set<? extends AnnotationType> set, Continuation<? super List<? extends Annotation>> continuation) {
        return a(this, set, 0, this.a.s, continuation);
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider
    public final Object getAnnotation(int i2, String str, Continuation<? super Annotation> continuation) {
        return a(this, i2, str, continuation);
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider
    public Object getAnnotations(int i2, Continuation<? super List<? extends Annotation>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new s3(this, i2, null), continuation);
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider
    public final Object moveAnnotation(int i2, int i3, int i4, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new a4(this, i2, i3, i4, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    public final void b() {
        this.i = false;
        Iterator<T> it = this.b.values().iterator();
        while (it.hasNext()) {
            Iterator it2 = ((List) it.next()).iterator();
            while (it2.hasNext()) {
                j3 properties = ((Annotation) it2.next()).getInternal().getProperties();
                k3 k3Var = properties.f;
                synchronized (k3Var) {
                    k3Var.a();
                    k3Var.d = false;
                }
                k4 k4Var = properties.j;
                if (k4Var != null) {
                    k4Var.b = false;
                }
            }
        }
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider
    public final Object moveAnnotation(Annotation annotation, AnnotationZIndexMove annotationZIndexMove, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new b4(annotation, this, annotationZIndexMove, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    public static final void c(o3 o3Var, Annotation annotation) {
        Iterator<AnnotationProvider.OnAnnotationUpdatedListener> it = o3Var.h.iterator();
        it.getClass();
        while (it.hasNext()) {
            it.next().onAnnotationUpdated(annotation);
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0074  */
    /* JADX WARN: Code duplicated, block: B:19:0x0085  */
    /* JADX WARN: Code duplicated, block: B:20:0x0088  */
    /* JADX WARN: Code duplicated, block: B:22:0x008c  */
    /* JADX WARN: Code duplicated, block: B:24:0x009c  */
    /* JADX WARN: Code duplicated, block: B:26:0x00a0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:27:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:28:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:32:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:39:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:41:0x0100 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:42:0x0101  */
    /* JADX WARN: Code duplicated, block: B:46:0x0119  */
    /* JADX WARN: Code duplicated, block: B:48:0x011f  */
    /* JADX WARN: Code duplicated, block: B:49:0x0147  */
    /* JADX WARN: Code duplicated, block: B:51:0x0155  */
    /* JADX WARN: Code duplicated, block: B:53:0x0186  */
    /* JADX WARN: Code duplicated, block: B:57:0x00c3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:61:0x00ac A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00d1 -> B:44:0x0115). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x0101 -> B:43:0x010c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:17:0x0074
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object a(int r23, java.util.List r24, kotlin.coroutines.jvm.internal.ContinuationImpl r25) {
        /*
            Method dump skipped, instruction units count: 423
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pspdfkit.internal.o3.a(int, java.util.List, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public static void b(Annotation annotation) {
        if (ar.b().a(annotation)) {
            return;
        }
        throw new InvalidNutrientLicenseException("Your license does not allow editing this annotation: " + annotation.getClass().getSimpleName());
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static /* synthetic */ Object a(o3 o3Var, int i2, Continuation<? super String> continuation) {
        j jVar;
        if (continuation instanceof j) {
            jVar = (j) continuation;
            int i3 = jVar.d;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                jVar.d = i3 - Integer.MIN_VALUE;
            } else {
                jVar = o3Var.new j(continuation);
            }
        } else {
            jVar = o3Var.new j(continuation);
        }
        Object objWithContext = jVar.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = jVar.d;
        if (i4 == 0) {
            ResultKt.throwOnFailure(objWithContext);
            CoroutineDispatcher io2 = Dispatchers.getIO();
            k kVar = o3Var.new k(i2, null);
            jVar.a = SpillingKt.nullOutSpilledVariable(o3Var);
            jVar.d = 1;
            objWithContext = BuildersKt.withContext(io2, kVar, jVar);
            if (objWithContext == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objWithContext);
        }
        objWithContext.getClass();
        return objWithContext;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static /* synthetic */ Object a(o3 o3Var, int i2, int i3, Continuation<? super Annotation> continuation) {
        g gVar;
        if (continuation instanceof g) {
            gVar = (g) continuation;
            int i4 = gVar.e;
            if ((i4 & Integer.MIN_VALUE) != 0) {
                gVar.e = i4 - Integer.MIN_VALUE;
            } else {
                gVar = o3Var.new g(continuation);
            }
        } else {
            gVar = o3Var.new g(continuation);
        }
        Object annotations = gVar.c;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = gVar.e;
        if (i5 == 0) {
            ResultKt.throwOnFailure(annotations);
            gVar.a = SpillingKt.nullOutSpilledVariable(o3Var);
            gVar.b = i3;
            gVar.e = 1;
            annotations = o3Var.getAnnotations(i2, gVar);
            if (annotations == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i3 = gVar.b;
            ResultKt.throwOnFailure(annotations);
        }
        for (Object obj : (Iterable) annotations) {
            if (((Annotation) obj).getObjectNumber() == i3) {
                return obj;
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static /* synthetic */ Object a(o3 o3Var, int i2, String str, Continuation<? super Annotation> continuation) {
        h hVar;
        if (continuation instanceof h) {
            hVar = (h) continuation;
            int i3 = hVar.e;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                hVar.e = i3 - Integer.MIN_VALUE;
            } else {
                hVar = o3Var.new h(continuation);
            }
        } else {
            hVar = o3Var.new h(continuation);
        }
        Object annotations = hVar.c;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = hVar.e;
        if (i4 == 0) {
            ResultKt.throwOnFailure(annotations);
            hVar.a = SpillingKt.nullOutSpilledVariable(o3Var);
            hVar.b = str;
            hVar.e = 1;
            annotations = o3Var.getAnnotations(i2, hVar);
            if (annotations == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str = hVar.b;
            ResultKt.throwOnFailure(annotations);
        }
        for (Object obj : (Iterable) annotations) {
            if (Intrinsics.areEqual(((Annotation) obj).getInternal().getUuid(), str)) {
                return obj;
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x008a -> B:25:0x008d). Please report as a decompilation issue!!! */
    public static Object a(o3 o3Var, Collection<Integer> collection, Continuation<? super List<? extends Annotation>> continuation) {
        i iVar;
        o3 o3Var2;
        int i2;
        List list;
        i iVar2;
        Collection<Integer> collection2;
        Set set;
        int i3;
        Object annotations;
        if (continuation instanceof i) {
            iVar = (i) continuation;
            int i4 = iVar.i;
            if ((i4 & Integer.MIN_VALUE) != 0) {
                iVar.i = i4 - Integer.MIN_VALUE;
            } else {
                iVar = o3Var.new i(continuation);
            }
        } else {
            iVar = o3Var.new i(continuation);
        }
        Object obj = iVar.g;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = iVar.i;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            if (collection.isEmpty()) {
                return CollectionsKt.emptyList();
            }
            Set mutableSet = CollectionsKt.toMutableSet(collection);
            ArrayList arrayList = new ArrayList();
            o3Var2 = o3Var;
            i2 = o3Var.a.s;
            list = arrayList;
            iVar2 = iVar;
            collection2 = collection;
            set = mutableSet;
            i3 = 0;
            if (i3 < i2 || set.isEmpty()) {
                return list;
            }
            iVar2.a = o3Var2;
            iVar2.b = SpillingKt.nullOutSpilledVariable(collection2);
            iVar2.c = set;
            iVar2.d = list;
            iVar2.e = i3;
            iVar2.f = i2;
            iVar2.i = 1;
            annotations = o3Var2.getAnnotations(i3, iVar2);
            if (annotations == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i2 = iVar.f;
            int i6 = iVar.e;
            List list2 = iVar.d;
            Set set2 = iVar.c;
            Collection<Integer> collection3 = (Collection) iVar.b;
            o3 o3Var3 = iVar.a;
            ResultKt.throwOnFailure(obj);
            i3 = i6;
            o3Var2 = o3Var3;
            annotations = obj;
            iVar2 = iVar;
            collection2 = collection3;
            set = set2;
            list = list2;
        }
        List list3 = (List) annotations;
        if (!list3.isEmpty()) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list3, 10)), 16));
            for (Object obj2 : list3) {
                linkedHashMap.put(Boxing.boxInt(((Annotation) obj2).getObjectNumber()), obj2);
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator it = set.iterator();
            while (it.hasNext()) {
                Annotation annotation = (Annotation) linkedHashMap.get(Boxing.boxInt(((Number) it.next()).intValue()));
                if (annotation != null) {
                    arrayList2.add(annotation);
                }
            }
            CollectionsKt.addAll(list, arrayList2);
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            int size = arrayList2.size();
            int i7 = 0;
            while (i7 < size) {
                Object obj3 = arrayList2.get(i7);
                i7++;
                arrayList3.add(Boxing.boxInt(((Annotation) obj3).getObjectNumber()));
            }
            CollectionsKt.removeAll((Collection) set, (Iterable) arrayList3);
        }
        i3++;
        if (i3 < i2) {
        }
        return list;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0068  */
    /* JADX WARN: Code duplicated, block: B:18:0x0082 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:19:0x0083  */
    /* JADX WARN: Code duplicated, block: B:23:0x0097  */
    /* JADX WARN: Code duplicated, block: B:30:0x00a8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:32:0x0091 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0083 -> B:20:0x008b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static java.lang.Object a(com.pspdfkit.internal.o3 r11, java.util.Set<? extends com.pspdfkit.annotations.AnnotationType> r12, int r13, int r14, kotlin.coroutines.Continuation<? super java.util.List<? extends com.pspdfkit.annotations.Annotation>> r15) {
        /*
            boolean r0 = r15 instanceof com.pspdfkit.internal.o3.f
            if (r0 == 0) goto L13
            r0 = r15
            com.pspdfkit.internal.o3$f r0 = (com.pspdfkit.internal.o3.f) r0
            int r1 = r0.l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.l = r1
            goto L18
        L13:
            com.pspdfkit.internal.o3$f r0 = new com.pspdfkit.internal.o3$f
            r0.<init>(r15)
        L18:
            java.lang.Object r15 = r0.j
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.l
            r3 = 1
            if (r2 == 0) goto L4f
            if (r2 != r3) goto L47
            int r11 = r0.i
            int r12 = r0.h
            int r13 = r0.g
            int r14 = r0.f
            int r2 = r0.e
            java.util.List r4 = r0.d
            java.util.List r5 = r0.c
            java.util.Set r6 = r0.b
            com.pspdfkit.internal.o3 r7 = r0.a
            kotlin.ResultKt.throwOnFailure(r15)
            r10 = r13
            r13 = r11
            r11 = r7
            r7 = r5
            r5 = r12
            r12 = r6
            r6 = r4
            r4 = r0
            r0 = r10
            r10 = r2
            r2 = r14
            r14 = r10
            goto L8b
        L47:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L4f:
            kotlin.ResultKt.throwOnFailure(r15)
            int r15 = r13 + r14
            com.pspdfkit.internal.lm r2 = r11.a
            int r2 = r2.s
            int r15 = kotlin.ranges.RangesKt.coerceAtMost(r15, r2)
            java.util.List r2 = kotlin.collections.CollectionsKt.createListBuilder()
            r4 = 0
            r5 = r2
            r6 = r5
            r2 = r0
            r0 = r14
            r14 = r13
        L66:
            if (r13 >= r15) goto Lb4
            r2.a = r11
            r2.b = r12
            r2.c = r6
            r2.d = r5
            r2.e = r14
            r2.f = r0
            r2.g = r15
            r2.h = r4
            r2.i = r13
            r2.l = r3
            java.lang.Object r7 = r11.getAnnotations(r13, r2)
            if (r7 != r1) goto L83
            return r1
        L83:
            r10 = r0
            r0 = r15
            r15 = r7
            r7 = r6
            r6 = r5
            r5 = r4
            r4 = r2
            r2 = r10
        L8b:
            java.lang.Iterable r15 = (java.lang.Iterable) r15
            java.util.Iterator r15 = r15.iterator()
        L91:
            boolean r8 = r15.hasNext()
            if (r8 == 0) goto Lac
            java.lang.Object r8 = r15.next()
            r9 = r8
            com.pspdfkit.annotations.Annotation r9 = (com.pspdfkit.annotations.Annotation) r9
            com.pspdfkit.annotations.AnnotationType r9 = r9.getType()
            boolean r9 = r12.contains(r9)
            if (r9 == 0) goto L91
            r6.add(r8)
            goto L91
        Lac:
            int r13 = r13 + r3
            r15 = r0
            r0 = r2
            r2 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            goto L66
        Lb4:
            java.util.List r11 = kotlin.collections.CollectionsKt.build(r6)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pspdfkit.internal.o3.a(com.pspdfkit.internal.o3, java.util.Set, int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(Annotation annotation, Integer num, Integer num2, boolean z, Continuation<? super Unit> continuation) {
        b bVar;
        o3 o3Var;
        Annotation annotation2;
        if (continuation instanceof b) {
            bVar = (b) continuation;
            int i2 = bVar.g;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                bVar.g = i2 - Integer.MIN_VALUE;
            } else {
                bVar = new b(continuation);
            }
        } else {
            bVar = new b(continuation);
        }
        Object obj = bVar.e;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = bVar.g;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineDispatcher io2 = Dispatchers.getIO();
            o3Var = this;
            c cVar = o3Var.new c(annotation, num, num2, null);
            bVar.a = annotation;
            bVar.b = SpillingKt.nullOutSpilledVariable(num);
            bVar.c = SpillingKt.nullOutSpilledVariable(num2);
            bVar.d = z;
            bVar.g = 1;
            if (BuildersKt.withContext(io2, cVar, bVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
            annotation2 = annotation;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            z = bVar.d;
            annotation2 = bVar.a;
            ResultKt.throwOnFailure(obj);
            o3Var = this;
        }
        PdfLog.d("Nutri.AnnotationProvImp", "Attached annotation %s with objNum %d to page %d.", annotation2.getType(), Boxing.boxInt(annotation2.getObjectNumber()), Boxing.boxInt(annotation2.getPageIndex()));
        if (z) {
            AnnotationType type = annotation2.getType();
            type.getClass();
            switch (u0.a[type.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                    at atVar = o3Var.e;
                    if (atVar != null) {
                        atVar.a(new AnnotationAddRemoveEdit(annotation2, AnnotationAddRemoveEdit.Type.ADD_ANNOTATION));
                    }
                    break;
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
        o3Var.c(annotation2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(Annotation annotation, boolean z, Continuation<? super Unit> continuation) {
        m mVar;
        if (continuation instanceof m) {
            mVar = (m) continuation;
            int i2 = mVar.d;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                mVar.d = i2 - Integer.MIN_VALUE;
            } else {
                mVar = new m(continuation);
            }
        } else {
            mVar = new m(continuation);
        }
        Object objWithContext = mVar.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = mVar.d;
        if (i3 == 0) {
            ResultKt.throwOnFailure(objWithContext);
            CoroutineDispatcher io2 = Dispatchers.getIO();
            n nVar = new n(annotation, z, null);
            mVar.a = SpillingKt.nullOutSpilledVariable(annotation);
            mVar.d = 1;
            objWithContext = BuildersKt.withContext(io2, nVar, mVar);
            if (objWithContext == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objWithContext);
        }
        Iterator it = ((List) objWithContext).iterator();
        while (it.hasNext()) {
            d((Annotation) it.next());
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static Object a(o3 o3Var, String str, Continuation<? super Annotation> continuation) {
        d dVar;
        if (continuation instanceof d) {
            dVar = (d) continuation;
            int i2 = dVar.e;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                dVar.e = i2 - Integer.MIN_VALUE;
            } else {
                dVar = o3Var.new d(continuation);
            }
        } else {
            dVar = o3Var.new d(continuation);
        }
        Object objWithContext = dVar.c;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = dVar.e;
        if (i3 == 0) {
            ResultKt.throwOnFailure(objWithContext);
            if (ar.b().a()) {
                CoroutineDispatcher io2 = Dispatchers.getIO();
                e eVar = o3Var.new e(str, null);
                dVar.a = o3Var;
                dVar.b = SpillingKt.nullOutSpilledVariable(str);
                dVar.e = 1;
                objWithContext = BuildersKt.withContext(io2, eVar, dVar);
                if (objWithContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                throw new InvalidNutrientLicenseException("Your license does not allow annotation editing.");
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            o3Var = dVar.a;
            ResultKt.throwOnFailure(objWithContext);
        }
        Annotation annotation = (Annotation) objWithContext;
        o3Var.c(annotation);
        return annotation;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a0, code lost:
    
        if (r7.moveAnnotation(r10, r1, r9, r0) == r2) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ java.lang.Object a(com.pspdfkit.internal.o3 r7, com.pspdfkit.annotations.Annotation r8, int r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            boolean r0 = r10 instanceof com.pspdfkit.internal.o3.l
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 == 0) goto L13
            r0 = r10
            com.pspdfkit.internal.o3$l r0 = (com.pspdfkit.internal.o3.l) r0
            int r2 = r0.h
            r3 = r2 & r1
            if (r3 == 0) goto L13
            int r2 = r2 - r1
            r0.h = r2
            goto L18
        L13:
            com.pspdfkit.internal.o3$l r0 = new com.pspdfkit.internal.o3$l
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.f
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r0.h
            r4 = 2
            r5 = 1
            if (r3 == 0) goto L54
            if (r3 == r5) goto L3d
            if (r3 != r4) goto L35
            java.lang.Object r7 = r0.b
            com.pspdfkit.annotations.Annotation r7 = (com.pspdfkit.annotations.Annotation) r7
            java.lang.Object r7 = r0.a
            com.pspdfkit.internal.o3 r7 = (com.pspdfkit.internal.o3) r7
            kotlin.ResultKt.throwOnFailure(r10)
            goto La3
        L35:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3d:
            int r7 = r0.e
            int r9 = r0.d
            com.pspdfkit.internal.o3 r8 = r0.c
            java.lang.Object r1 = r0.b
            com.pspdfkit.annotations.Annotation r1 = (com.pspdfkit.annotations.Annotation) r1
            java.lang.Object r3 = r0.a
            com.pspdfkit.internal.o3 r3 = (com.pspdfkit.internal.o3) r3
            kotlin.ResultKt.throwOnFailure(r10)
            r6 = r10
            r10 = r7
            r7 = r8
            r8 = r1
            r1 = r6
            goto L83
        L54:
            kotlin.ResultKt.throwOnFailure(r10)
            boolean r10 = r8.isAttached()
            if (r10 == 0) goto La6
            int r10 = r8.getPageIndex()
            if (r10 == r1) goto La6
            int r10 = r8.getPageIndex()
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r0.a = r1
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r0.b = r1
            r0.c = r7
            r0.d = r9
            r0.e = r10
            r0.h = r5
            java.lang.Object r1 = r7.getZIndex(r8, r0)
            if (r1 != r2) goto L82
            goto La2
        L82:
            r3 = r7
        L83:
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r3)
            r0.a = r3
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r0.b = r8
            r8 = 0
            r0.c = r8
            r0.d = r9
            r0.h = r4
            java.lang.Object r7 = r7.moveAnnotation(r10, r1, r9, r0)
            if (r7 != r2) goto La3
        La2:
            return r2
        La3:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        La6:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r8 = "Annotation must be attached to change its z-index."
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pspdfkit.internal.o3.a(com.pspdfkit.internal.o3, com.pspdfkit.annotations.Annotation, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final void a(o3 o3Var, Annotation annotation) {
        Iterator<AnnotationProvider.OnAnnotationUpdatedListener> it = o3Var.h.iterator();
        it.getClass();
        while (it.hasNext()) {
            it.next().onAnnotationCreated(annotation);
        }
    }

    public final void a(final int i2, final List<? extends Annotation> list, final List<? extends Annotation> list2) {
        list.getClass();
        list2.getClass();
        h60.a(new Runnable() { // from class: com.pspdfkit.internal.o3$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                o3.a(this.f$0, i2, list, list2);
            }
        });
        PdfDocumentCheckpointer pdfDocumentCheckpointer = this.a.J;
        if (pdfDocumentCheckpointer != null) {
            pdfDocumentCheckpointer.onDocumentModified();
        }
    }

    public static final void a(o3 o3Var, int i2, List list, List list2) {
        Iterator<AnnotationProvider.OnAnnotationUpdatedListener> it = o3Var.h.iterator();
        it.getClass();
        while (it.hasNext()) {
            it.next().onAnnotationZOrderChanged(i2, list, list2);
        }
    }

    public void a() {
        this.c.addAll(this.b.keySet());
    }

    /* JADX WARN: Code duplicated, block: B:17:0x006c  */
    /* JADX WARN: Code duplicated, block: B:19:0x00aa A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x00ab -> B:21:0x00b1). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static /* synthetic */ java.lang.Object a(com.pspdfkit.internal.o3 r13, java.util.Set r14, kotlin.coroutines.jvm.internal.ContinuationImpl r15) {
        /*
            boolean r0 = r15 instanceof com.pspdfkit.internal.c4
            if (r0 == 0) goto L13
            r0 = r15
            com.pspdfkit.internal.c4 r0 = (com.pspdfkit.internal.c4) r0
            int r1 = r0.l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.l = r1
            goto L18
        L13:
            com.pspdfkit.internal.c4 r0 = new com.pspdfkit.internal.c4
            r0.<init>(r13, r15)
        L18:
            java.lang.Object r15 = r0.j
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.l
            r3 = 1
            if (r2 == 0) goto L52
            if (r2 != r3) goto L4a
            int r13 = r0.i
            int r14 = r0.h
            java.util.Iterator r2 = r0.f
            java.util.Collection r4 = r0.e
            java.lang.Object r5 = r0.d
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.lang.Object r6 = r0.c
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.lang.Object r7 = r0.b
            java.util.Set r7 = (java.util.Set) r7
            com.pspdfkit.internal.o3 r8 = r0.a
            kotlin.ResultKt.throwOnFailure(r15)
            r12 = r4
            r4 = r13
            r13 = r8
            r8 = r12
            r12 = r6
            r6 = r0
            r0 = r12
            r12 = r7
            r7 = r2
            r2 = r12
            goto Lb1
        L4a:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L52:
            kotlin.ResultKt.throwOnFailure(r15)
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
            java.util.Iterator r2 = r14.iterator()
            r4 = 0
            r7 = r15
            r5 = r0
            r6 = r2
            r15 = r14
            r0 = r15
            r2 = r0
            r14 = r4
        L66:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto Lbb
            java.lang.Object r8 = r6.next()
            r9 = r8
            java.lang.Number r9 = (java.lang.Number) r9
            int r9 = r9.intValue()
            java.util.Set<java.lang.Integer> r10 = r13.c
            java.lang.Integer r11 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r9)
            r10.add(r11)
            r5.a = r13
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r5.b = r10
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
            r5.c = r10
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r5.d = r10
            r5.e = r7
            r5.f = r6
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r5.g = r8
            r5.h = r14
            r5.i = r4
            r5.l = r3
            java.lang.Object r8 = r13.getAnnotations(r9, r5)
            if (r8 != r1) goto Lab
            return r1
        Lab:
            r12 = r5
            r5 = r15
            r15 = r8
            r8 = r7
            r7 = r6
            r6 = r12
        Lb1:
            java.lang.Iterable r15 = (java.lang.Iterable) r15
            kotlin.collections.CollectionsKt.addAll(r8, r15)
            r15 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            goto L66
        Lbb:
            java.util.List r7 = (java.util.List) r7
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pspdfkit.internal.o3.a(com.pspdfkit.internal.o3, java.util.Set, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public Object a(ContinuationImpl continuationImpl) {
        Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new d4(this, null), continuationImpl);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    public Object a(NativeAnnotation nativeAnnotation, boolean z, ContinuationImpl continuationImpl) {
        return BuildersKt.withContext(Dispatchers.getIO(), new q3(this, nativeAnnotation, z, null), continuationImpl);
    }

    public final void a(Annotation annotation) {
        if (annotation.isMeasurement()) {
            MeasurementInfo measurementInfo = annotation.getMeasurementInfo();
            if (e60.a == null && measurementInfo != null) {
                Scale scale = measurementInfo.scale;
                scale.getClass();
                MeasurementPrecision measurementPrecision = measurementInfo.precision;
                measurementPrecision.getClass();
                final MeasurementValueConfiguration measurementValueConfiguration = new MeasurementValueConfiguration(null, scale, measurementPrecision);
                lm lmVar = this.a;
                Function1 function1 = new Function1() { // from class: com.pspdfkit.internal.o3$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return o3.a(measurementValueConfiguration, (List) obj);
                    }
                };
                lmVar.getClass();
                lmVar.a(EmptyCoroutineContext.INSTANCE, new pm(lmVar, function1, null));
                return;
            }
            lm lmVar2 = this.a;
            lmVar2.getClass();
            lmVar2.a(EmptyCoroutineContext.INSTANCE, new pm(lmVar2, null, null));
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0023  */
    /* JADX WARN: Code duplicated, block: B:15:0x0029  */
    public static final Unit a(List list) {
        o00 o00Var;
        list.getClass();
        if (list.isEmpty()) {
            if (Intrinsics.areEqual(e60.a, (Object) null)) {
                MeasurementValueConfiguration measurementValueConfiguration = e60.a;
                if (!Intrinsics.areEqual(measurementValueConfiguration != null ? measurementValueConfiguration.getName() : null, (Object) null)) {
                    e60.a = null;
                    o00Var = e60.b;
                    if (o00Var != null) {
                        o00Var.a(null);
                    }
                }
            } else {
                e60.a = null;
                o00Var = e60.b;
                if (o00Var != null) {
                    o00Var.a(null);
                }
            }
        }
        return Unit.INSTANCE;
    }

    public final void a(at atVar, Runnable runnable) {
        runnable.getClass();
        at atVar2 = this.e;
        if (atVar2 == null && atVar == null) {
            runnable.run();
            return;
        }
        if (atVar == null) {
            if (atVar2 == null) {
                throw new IllegalStateException("No listener available to record edits into compound edit.");
            }
            atVar = atVar2;
        }
        mf mfVar = new mf(atVar);
        mfVar.b = true;
        this.e = mfVar;
        try {
            runnable.run();
        } finally {
            mfVar.c();
            this.e = atVar2;
        }
    }

    public final void a(int i2) {
        if (i2 < 0 || i2 >= this.a.s) {
            throw new IllegalArgumentException(("Invalid page number passed: " + i2).toString());
        }
    }
}
