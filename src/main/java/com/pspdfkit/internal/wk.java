package com.pspdfkit.internal;

import android.graphics.Bitmap;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.StampAnnotation;
import com.pspdfkit.instant.annotations.InstantAnnotationProvider;
import com.pspdfkit.instant.document.InstantDocumentState;
import com.pspdfkit.internal.jni.NativeAnnotation;
import com.pspdfkit.internal.jni.NativeAnnotationManager;
import com.pspdfkit.internal.jni.NativeAnnotationType;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Mutex;

/* JADX INFO: loaded from: classes3.dex */
public final class wk extends o3 implements InstantAnnotationProvider {
    public final gm m;
    public final il n;
    public final LinkedHashMap o;
    public volatile boolean p;
    public final ArrayList q;

    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[NativeAnnotationType.values().length];
            try {
                iArr[NativeAnnotationType.STAMP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            a = iArr;
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.instant.annotations.InstantAnnotationProviderImpl", f = "InstantAnnotationProviderImpl.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {361, 372, 261, 264}, m = "getAnnotationForIdentifier", n = {"identifier", "$this$withLock_u24default$iv", "$i$f$withLock", "identifier", "$this$withLock_u24default$iv", "pageCount", "pageIndex", "$i$f$withLock", "identifier", "cachedAnnotations", "pageCount", "pageIndex", "identifier", "cachedAnnotations", "annotations", "$this$firstOrNull$iv", "element$iv", "it", "pageCount", "pageIndex", "$i$f$firstOrNull", "$i$a$-firstOrNull-InstantAnnotationProviderImpl$getAnnotationForIdentifier$match$1"}, nl = {362, 373, 264, 378}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "I$0", "I$1", "I$2", "L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "I$0", "I$1", "I$2", "I$3"}, v = 2)
    public static final class b extends ContinuationImpl {
        public String a;
        public Object b;
        public Object c;
        public Object d;
        public Iterator e;
        public Object f;
        public Object g;
        public int h;
        public int i;
        public int j;
        public /* synthetic */ Object k;
        public int m;

        public b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.k = obj;
            this.m |= Integer.MIN_VALUE;
            return wk.this.getAnnotationForIdentifier(null, this);
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.instant.annotations.InstantAnnotationProviderImpl", f = "InstantAnnotationProviderImpl.kt", i = {0, 1, 1, 1, 1, 1}, l = {73, 375}, m = "getAnnotations", n = {"pageIndex", "annotations", "instantInfos", "$this$withLock_u24default$iv", "pageIndex", "$i$f$withLock"}, nl = {80, 376}, s = {"I$0", "L$0", "L$1", "L$2", "I$0", "I$1"}, v = 2)
    public static final class c extends ContinuationImpl {
        public int a;
        public List b;
        public ArrayList c;
        public Mutex d;
        public /* synthetic */ Object e;
        public int g;

        public c(Continuation<? super c> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= Integer.MIN_VALUE;
            return wk.this.getAnnotations(0, this);
        }
    }

    public static final class d {
        public final Annotation a;
        public final String b;
        public final boolean c;

        public d(Annotation annotation, String str, boolean z) {
            this.a = annotation;
            this.b = str;
            this.c = z;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return Intrinsics.areEqual(this.a, dVar.a) && Intrinsics.areEqual(this.b, dVar.b) && this.c == dVar.c;
        }

        public final int hashCode() {
            int iHashCode = this.a.hashCode() * 31;
            String str = this.b;
            return Boolean.hashCode(this.c) + ((iHashCode + (str == null ? 0 : str.hashCode())) * 31);
        }

        public final String toString() {
            return "AnnotationInstantInfo(annotation=" + this.a + ", identifier=" + this.b + ", hasComments=" + this.c + ")";
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.instant.annotations.InstantAnnotationProviderImpl$refreshCachedAnnotationsForPages$2", f = "InstantAnnotationProviderImpl.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {361, Token.SCRIPT, 376}, m = "invokeSuspend", n = {"changedAnnotations", "$this$withLock_u24default$iv", "pageIndex", "$i$f$withLock", "changedAnnotations", "oldAnnotations", "annotationMapping", "pageIndex", "changedAnnotations", "oldAnnotations", "annotationMapping", "newAnnotations", "createdAnnotations", "updatedAnnotations", "deletedAnnotations", "identifiersToAdd", "identifiersToRemove", "$this$withLock_u24default$iv", "pageIndex", "$i$f$withLock"}, nl = {362, 139, 377}, s = {"L$0", "L$2", "I$0", "I$1", "L$0", "L$2", "L$3", "I$0", "L$0", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "I$0", "I$1"}, v = 2)
    public static final class e extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<Annotation>>, Object> {
        public List a;
        public Iterator b;
        public Object c;
        public Object d;
        public List e;
        public ArrayList f;
        public ArrayList g;
        public ArrayList h;
        public ArrayList i;
        public ArrayList j;
        public Mutex k;
        public wk l;
        public int m;
        public int n;
        public final /* synthetic */ Set<Integer> o;
        public final /* synthetic */ wk p;

        public static final class a<T> implements Comparator {
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((Annotation) t).getObjectNumber()), Integer.valueOf(((Annotation) t2).getObjectNumber()));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Set<Integer> set, wk wkVar, Continuation<? super e> continuation) {
            super(2, continuation);
            this.o = set;
            this.p = wkVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new e(this.o, this.p, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<Annotation>> continuation) {
            return new e(this.o, this.p, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:112:0x0352 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:115:0x00c5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:117:0x00b7 A[EXC_TOP_SPLITTER, PHI: r1 r2 r3 r4 r5 r7 r8 r9
          0x00b7: PHI (r1v15 java.lang.Object) = (r1v20 java.lang.Object), (r1v0 java.lang.Object) binds: [B:16:0x00b2, B:11:0x005c] A[DONT_GENERATE, DONT_INLINE]
          0x00b7: PHI (r2v10 int) = (r2v14 int), (r2v28 int) binds: [B:16:0x00b2, B:11:0x005c] A[DONT_GENERATE, DONT_INLINE]
          0x00b7: PHI (r3v14 com.pspdfkit.internal.wk) = (r3v20 com.pspdfkit.internal.wk), (r3v23 com.pspdfkit.internal.wk) binds: [B:16:0x00b2, B:11:0x005c] A[DONT_GENERATE, DONT_INLINE]
          0x00b7: PHI (r4v8 int) = (r4v9 int), (r4v0 int) binds: [B:16:0x00b2, B:11:0x005c] A[DONT_GENERATE, DONT_INLINE]
          0x00b7: PHI (r5v4 ??) = (r5v15 ??), (r5v16 ??) binds: [B:16:0x00b2, B:11:0x005c] A[DONT_GENERATE, DONT_INLINE]
          0x00b7: PHI (r7v9 ??) = (r7v21 ??), (r7v20 ?? I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) binds: [B:16:0x00b2, B:11:0x005c] A[DONT_GENERATE, DONT_INLINE]
          0x00b7: PHI (r8v2 java.util.Iterator<java.lang.Integer>) = (r8v3 java.util.Iterator<java.lang.Integer>), (r8v5 java.util.Iterator<java.lang.Integer>) binds: [B:16:0x00b2, B:11:0x005c] A[DONT_GENERATE, DONT_INLINE]
          0x00b7: PHI (r9v3 java.util.List) = (r9v4 java.util.List), (r9v7 java.util.List) binds: [B:16:0x00b2, B:11:0x005c] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:15:0x0084  */
        /* JADX WARN: Code duplicated, block: B:25:0x00d0 A[Catch: all -> 0x034c, TRY_ENTER, TryCatch #2 {all -> 0x034c, blocks: (B:18:0x00b7, B:26:0x00d5, B:25:0x00d0), top: B:117:0x00b7 }] */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x00fe, code lost:
        
            if (r5 == r1) goto L17;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v16 */
        /* JADX WARN: Type inference failed for: r1v17, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r1v18 */
        /* JADX WARN: Type inference failed for: r5v15 */
        /* JADX WARN: Type inference failed for: r5v16 */
        /* JADX WARN: Type inference failed for: r5v4, types: [kotlinx.coroutines.sync.Mutex] */
        /* JADX WARN: Type inference failed for: r5v7, types: [java.lang.Object, kotlinx.coroutines.sync.Mutex] */
        /* JADX WARN: Type inference failed for: r7v0 */
        /* JADX WARN: Type inference failed for: r7v10, types: [com.pspdfkit.internal.wk, java.lang.Object, java.util.ArrayList, java.util.List, kotlinx.coroutines.sync.Mutex] */
        /* JADX WARN: Type inference failed for: r7v11 */
        /* JADX WARN: Type inference failed for: r7v20 */
        /* JADX WARN: Type inference failed for: r7v21 */
        /* JADX WARN: Type inference failed for: r7v9, types: [java.lang.Object] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:74:0x027a -> B:113:0x0281). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r26) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 851
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.pspdfkit.internal.wk.e.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.instant.annotations.InstantAnnotationProviderImpl", f = "InstantAnnotationProviderImpl.kt", i = {0, 0, 1, 1, 1, 1}, l = {105, 362}, m = "removeAnnotationFromPage", n = {"annotation", "instantIdentifier", "annotation", "instantIdentifier", "$this$withLock_u24default$iv", "$i$f$withLock"}, nl = {106, 363}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "I$0"}, v = 2)
    public static final class f extends ContinuationImpl {
        public Object a;
        public String b;
        public Mutex c;
        public /* synthetic */ Object d;
        public int f;

        public f(Continuation<? super f> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return wk.this.removeAnnotationFromPage(null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wk(lm lmVar, gm gmVar, il ilVar) {
        super(lmVar);
        gmVar.getClass();
        ilVar.getClass();
        this.m = gmVar;
        this.n = ilVar;
        this.o = new LinkedHashMap();
        this.q = new ArrayList();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(bl blVar, ContinuationImpl continuationImpl) throws Throwable {
        yk ykVar;
        Function1 function1;
        Mutex mutex;
        int i;
        Throwable th;
        Mutex mutex2;
        if (continuationImpl instanceof yk) {
            ykVar = (yk) continuationImpl;
            int i2 = ykVar.f;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                ykVar.f = i2 - Integer.MIN_VALUE;
            } else {
                ykVar = new yk(this, continuationImpl);
            }
        } else {
            ykVar = new yk(this, continuationImpl);
        }
        Object objInvoke = ykVar.d;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = ykVar.f;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(objInvoke);
                Mutex mutex3 = this.l;
                ykVar.a = blVar;
                ykVar.b = mutex3;
                ykVar.c = 0;
                ykVar.f = 1;
                if (mutex3.lock(null, ykVar) != coroutine_suspended) {
                    function1 = blVar;
                    mutex = mutex3;
                    i = 0;
                }
                return coroutine_suspended;
            }
            if (i3 != 1) {
                if (i3 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutex2 = ykVar.b;
                try {
                    ResultKt.throwOnFailure(objInvoke);
                    mutex2.unlock(null);
                    return objInvoke;
                } catch (Throwable th2) {
                    th = th2;
                    mutex2.unlock(null);
                    throw th;
                }
            }
            i = ykVar.c;
            mutex = ykVar.b;
            function1 = (Function1) ykVar.a;
            ResultKt.throwOnFailure(objInvoke);
            ykVar.a = SpillingKt.nullOutSpilledVariable(function1);
            ykVar.b = mutex;
            ykVar.c = i;
            ykVar.f = 2;
            objInvoke = function1.invoke(ykVar);
            if (objInvoke != coroutine_suspended) {
                mutex2 = mutex;
                mutex2.unlock(null);
                return objInvoke;
            }
            return coroutine_suspended;
        } catch (Throwable th3) {
            Mutex mutex4 = mutex;
            th = th3;
            mutex2 = mutex4;
            mutex2.unlock(null);
            throw th;
        }
    }

    @Override // com.pspdfkit.instant.annotations.InstantAnnotationProvider
    public final void addNonAnnotationChangeListener(InstantAnnotationProvider.OnNonAnnotationChangeListener onNonAnnotationChangeListener) {
        onNonAnnotationChangeListener.getClass();
        this.q.add(onNonAnnotationChangeListener);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:32:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:36:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:39:0x010c  */
    /* JADX WARN: Code duplicated, block: B:45:0x012c  */
    /* JADX WARN: Code duplicated, block: B:48:0x0163  */
    /* JADX WARN: Code duplicated, block: B:54:0x0178  */
    /* JADX WARN: Code duplicated, block: B:57:0x0181 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:58:0x0182  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x0163 -> B:49:0x0169). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x0178 -> B:52:0x0170). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // com.pspdfkit.instant.annotations.InstantAnnotationProvider
    public final java.lang.Object getAnnotationForIdentifier(java.lang.String r19, kotlin.coroutines.Continuation<? super com.pspdfkit.annotations.Annotation> r20) {
        /*
            Method dump skipped, instruction units count: 404
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pspdfkit.internal.wk.getAnnotationForIdentifier(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00ac A[Catch: all -> 0x00d3, TryCatch #0 {all -> 0x00d3, blocks: (B:36:0x00a6, B:38:0x00ac, B:40:0x00b8, B:41:0x00bf, B:43:0x00c3, B:44:0x00cd), top: B:50:0x00a6 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00b8 A[Catch: all -> 0x00d3, TryCatch #0 {all -> 0x00d3, blocks: (B:36:0x00a6, B:38:0x00ac, B:40:0x00b8, B:41:0x00bf, B:43:0x00c3, B:44:0x00cd), top: B:50:0x00a6 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x00c3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:55:0x00aa A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.pspdfkit.internal.o3, com.pspdfkit.annotations.AnnotationProvider
    public final Object getAnnotations(int i, Continuation<? super List<? extends Annotation>> continuation) {
        c cVar;
        List list;
        ArrayList arrayList;
        Mutex mutex;
        int size;
        d dVar;
        String str;
        if (continuation instanceof c) {
            cVar = (c) continuation;
            int i2 = cVar.g;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                cVar.g = i2 - Integer.MIN_VALUE;
            } else {
                cVar = new c(continuation);
            }
        } else {
            cVar = new c(continuation);
        }
        Object annotations = cVar.e;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = cVar.g;
        int i4 = 0;
        if (i3 == 0) {
            ResultKt.throwOnFailure(annotations);
            cVar.a = i;
            cVar.g = 1;
            annotations = super.getAnnotations(i, cVar);
            if (annotations != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i3 == 1) {
            i = cVar.a;
            ResultKt.throwOnFailure(annotations);
        } else {
            if (i3 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mutex = cVar.d;
            arrayList = cVar.c;
            list = cVar.b;
            ResultKt.throwOnFailure(annotations);
        }
        try {
            size = arrayList.size();
            while (i4 < size) {
                Object obj = arrayList.get(i4);
                i4++;
                dVar = (d) obj;
                str = dVar.b;
                if (str != null) {
                    this.o.put(str, dVar.a);
                }
                if (dVar.c) {
                    dVar.a.getInternal().markAsInstantCommentRoot();
                }
            }
            Unit unit = Unit.INSTANCE;
            return list;
        } finally {
            mutex.unlock(null);
        }
        List<Annotation> list2 = (List) annotations;
        ArrayList arrayList2 = new ArrayList();
        for (Annotation annotation : list2) {
            NativeAnnotation nativeAnnotation = annotation.getInternal().getNativeAnnotation();
            d dVar2 = nativeAnnotation == null ? null : new d(annotation, this.d.getInstantIdentifier(nativeAnnotation), this.d.getInstantCommentCount(nativeAnnotation) > 0);
            if (dVar2 != null) {
                arrayList2.add(dVar2);
            }
        }
        Mutex mutex2 = this.j;
        cVar.b = list2;
        cVar.c = arrayList2;
        cVar.d = mutex2;
        cVar.a = i;
        cVar.g = 2;
        if (mutex2.lock(null, cVar) != coroutine_suspended) {
            list = list2;
            arrayList = arrayList2;
            mutex = mutex2;
            size = arrayList.size();
            while (i4 < size) {
                Object obj2 = arrayList.get(i4);
                i4++;
                dVar = (d) obj2;
                str = dVar.b;
                if (str != null) {
                    this.o.put(str, dVar.a);
                }
                if (dVar.c) {
                    dVar.a.getInternal().markAsInstantCommentRoot();
                }
            }
            Unit unit2 = Unit.INSTANCE;
            return list;
        }
        return coroutine_suspended;
    }

    @Override // com.pspdfkit.instant.annotations.InstantAnnotationProvider
    public final Object getIdentifierForAnnotation(Annotation annotation, Continuation<? super String> continuation) {
        String instantIdentifier;
        NativeAnnotation nativeAnnotation = annotation.getInternal().getNativeAnnotation();
        if (nativeAnnotation != null) {
            if (annotation.getInternal().getInternalDocument() != this.a) {
                nativeAnnotation = null;
            }
            if (nativeAnnotation != null && (instantIdentifier = this.d.getInstantIdentifier(nativeAnnotation)) != null) {
                return instantIdentifier;
            }
        }
        throw new IllegalStateException("The given annotation is not managed by this document");
    }

    @Override // com.pspdfkit.internal.o3, com.pspdfkit.annotations.AnnotationProvider
    public final boolean hasUnsavedChanges() {
        return super.hasUnsavedChanges() || this.m.b() != InstantDocumentState.CLEAN;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0088 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.pspdfkit.internal.o3, com.pspdfkit.annotations.AnnotationProvider
    public final Object removeAnnotationFromPage(Annotation annotation, Continuation<? super Unit> continuation) {
        f fVar;
        String instantIdentifier;
        String str;
        Mutex mutex;
        if (continuation instanceof f) {
            fVar = (f) continuation;
            int i = fVar.f;
            if ((i & Integer.MIN_VALUE) != 0) {
                fVar.f = i - Integer.MIN_VALUE;
            } else {
                fVar = new f(continuation);
            }
        } else {
            fVar = new f(continuation);
        }
        Object obj = fVar.d;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = fVar.f;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            NativeAnnotation nativeAnnotation = annotation.getInternal().getNativeAnnotation();
            instantIdentifier = nativeAnnotation != null ? this.d.getInstantIdentifier(nativeAnnotation) : null;
            fVar.a = SpillingKt.nullOutSpilledVariable(annotation);
            fVar.b = instantIdentifier;
            fVar.f = 1;
            if (super.removeAnnotationFromPage(annotation, fVar) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i2 == 1) {
            String str2 = fVar.b;
            Annotation annotation2 = (Annotation) fVar.a;
            ResultKt.throwOnFailure(obj);
            instantIdentifier = str2;
            annotation = annotation2;
        } else {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mutex = fVar.c;
            str = fVar.b;
            ResultKt.throwOnFailure(obj);
        }
        if (str != null) {
            try {
            } finally {
                mutex.unlock(null);
            }
        }
        return Unit.INSTANCE;
        Mutex mutex2 = this.j;
        fVar.a = SpillingKt.nullOutSpilledVariable(annotation);
        fVar.b = instantIdentifier;
        fVar.c = mutex2;
        fVar.f = 2;
        if (mutex2.lock(null, fVar) != coroutine_suspended) {
            str = instantIdentifier;
            mutex = mutex2;
            if (str != null) {
            }
            return Unit.INSTANCE;
        }
        return coroutine_suspended;
    }

    @Override // com.pspdfkit.internal.o3
    public final Object a(Set<Integer> set, Continuation<? super List<? extends Annotation>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new e(set, this, null), continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.pspdfkit.internal.o3
    public final Object a(ContinuationImpl continuationImpl) {
        xk xkVar;
        if (continuationImpl instanceof xk) {
            xkVar = (xk) continuationImpl;
            int i = xkVar.c;
            if ((i & Integer.MIN_VALUE) != 0) {
                xkVar.c = i - Integer.MIN_VALUE;
            } else {
                xkVar = new xk(this, continuationImpl);
            }
        } else {
            xkVar = new xk(this, continuationImpl);
        }
        Object obj = xkVar.a;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = xkVar.c;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            xkVar.c = 1;
            if (super.a(xkVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
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
        return Unit.INSTANCE;
    }

    @Override // com.pspdfkit.internal.o3
    public final Object a(NativeAnnotation nativeAnnotation, boolean z, ContinuationImpl continuationImpl) {
        if (a.a[nativeAnnotation.getAnnotationType().ordinal()] == 1) {
            byte[] properties = this.d.getProperties(nativeAnnotation);
            if (properties == null || properties.length == 0) {
                return null;
            }
            j3 j3Var = new j3();
            j3Var.b = nativeAnnotation;
            j3Var.a = this;
            j3Var.d = this.d;
            j3Var.c = false;
            j3Var.g();
            StampAnnotation stampAnnotation = new StampAnnotation(j3Var, false, (Bitmap) null);
            bm internal = stampAnnotation.getInternal();
            String additionalDataString = nativeAnnotation.getAdditionalDataString("imageAttachmentId");
            if (additionalDataString != null) {
                internal.setAnnotationResource(new uk(this.n, stampAnnotation, additionalDataString));
            }
            if (nativeAnnotation.getAnnotationId() != null) {
                lm lmVar = this.a;
                ir irVar = this.f;
                NativeAnnotationManager nativeAnnotationManager = this.d;
                irVar.getClass();
                nativeAnnotationManager.getClass();
                kr krVar = new kr(irVar, nativeAnnotationManager, nativeAnnotation);
                irVar.a.put(Long.valueOf(krVar.c), nativeAnnotation);
                internal.onAttachToDocument(lmVar, krVar);
            }
            return stampAnnotation;
        }
        return super.a(nativeAnnotation, z, continuationImpl);
    }

    public static final Annotation a(wk wkVar, List list, NativeAnnotation nativeAnnotation) {
        Object next;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            next = it.next();
            NativeAnnotation nativeAnnotation2 = ((Annotation) next).getInternal().getNativeAnnotation();
            if (nativeAnnotation2 != null && nativeAnnotation2.getIdentifier() == nativeAnnotation.getIdentifier()) {
                return (Annotation) next;
            }
        }
        next = null;
        return (Annotation) next;
    }

    @Override // com.pspdfkit.internal.o3
    public final void a() {
        this.c.addAll(this.b.keySet());
        this.o.clear();
    }
}
