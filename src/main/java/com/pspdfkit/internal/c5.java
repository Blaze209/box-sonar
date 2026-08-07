package com.pspdfkit.internal;

import android.content.Context;
import android.view.ViewGroup;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.FreeTextAnnotation;
import com.pspdfkit.annotations.WidgetAnnotation;
import com.pspdfkit.annotations.configuration.AnnotationConfigurationRegistry;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.forms.FormElement;
import com.pspdfkit.forms.FormType;
import com.pspdfkit.forms.PushButtonFormElement;
import com.pspdfkit.internal.jni.NativeAnnotation;
import com.pspdfkit.internal.views.document.DocumentView;
import com.pspdfkit.ui.PdfFragment;
import com.pspdfkit.ui.annotations.AnnotationViewsListener;
import com.pspdfkit.ui.rendering.AnnotationOverlayRenderStrategy;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes3.dex */
public class c5 {
    public static final AnnotationOverlayRenderStrategy t = new AnnotationOverlayRenderStrategy() { // from class: com.pspdfkit.internal.c5$$ExternalSyntheticLambda0
        @Override // com.pspdfkit.ui.rendering.AnnotationOverlayRenderStrategy
        public final AnnotationOverlayRenderStrategy.Strategy getOverlayRenderStrategy(Annotation annotation) {
            return c5.a(annotation);
        }
    };
    public final Context a;
    public final PdfFragment b;
    public final PdfConfiguration c;
    public final CompositeDisposable d;
    public AnnotationOverlayRenderStrategy e;
    public final l5 f;
    public final CoroutineScope g;
    public final LinkedHashMap h;
    public final go<a> i;
    public final px<yj> j;
    public final px<k30> k;
    public final px<yy> l;
    public final px<vy> m;
    public final px<e00> n;
    public final px<ni> o;
    public final px<j10> p;
    public final px<zy> q;
    public final ArrayList r;
    public final go<AnnotationViewsListener> s;

    public interface a {
        void a(Annotation annotation);
    }

    public static final /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[AnnotationType.values().length];
            try {
                iArr[AnnotationType.SOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AnnotationType.HIGHLIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AnnotationType.STRIKEOUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AnnotationType.UNDERLINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AnnotationType.SQUIGGLY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[AnnotationType.REDACT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[AnnotationType.NOTE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[AnnotationType.FILE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[AnnotationType.FREETEXT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[AnnotationType.LINE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[AnnotationType.POLYGON.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[AnnotationType.POLYLINE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[AnnotationType.CIRCLE.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[AnnotationType.SQUARE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[AnnotationType.INK.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            a = iArr;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ Ref.ObjectRef<z4<?>> a;

        public c(Ref.ObjectRef<z4<?>> objectRef) {
            this.a = objectRef;
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Object obj) {
            Boolean bool = (Boolean) obj;
            bool.getClass();
            this.a.element.a().setFocusable(bool.booleanValue());
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.views.annotations.AnnotationViewsFactory$launchApStreamCheck$launchedJob$1", f = "AnnotationViewsFactory.kt", i = {0, 0}, l = {506}, m = "invokeSuspend", n = {"$this$launch", "thisJob"}, nl = {512}, s = {"L$0", "L$1"}, v = 2)
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public Job a;
        public int b;
        public /* synthetic */ Object c;
        public final /* synthetic */ String e;
        public final /* synthetic */ Annotation f;
        public final /* synthetic */ NativeAnnotation g;

        @DebugMetadata(c = "com.pspdfkit.internal.views.annotations.AnnotationViewsFactory$launchApStreamCheck$launchedJob$1$hasApStream$1", f = "AnnotationViewsFactory.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
            public final /* synthetic */ Annotation a;
            public final /* synthetic */ NativeAnnotation b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Annotation annotation, NativeAnnotation nativeAnnotation, Continuation<? super a> continuation) {
                super(2, continuation);
                this.a = annotation;
                this.b = nativeAnnotation;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(this.a, this.b, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
                return new a(this.a, this.b, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                ResultKt.throwOnFailure(obj);
                return !this.a.isAttached() ? Boxing.boxBoolean(false) : Boxing.boxBoolean(this.b.hasAppearanceStream());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str, Annotation annotation, NativeAnnotation nativeAnnotation, Continuation<? super d> continuation) {
            super(2, continuation);
            this.e = str;
            this.f = annotation;
            this.g = nativeAnnotation;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            d dVar = c5.this.new d(this.e, this.f, this.g, continuation);
            dVar.c = obj;
            return dVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:24:0x006b A[Catch: all -> 0x0015, CancellationException -> 0x0018, Exception -> 0x00d0, TRY_LEAVE, TryCatch #3 {all -> 0x0015, blocks: (B:6:0x0011, B:22:0x0059, B:24:0x006b, B:29:0x0083, B:31:0x0095, B:33:0x00a1, B:38:0x00b9, B:55:0x0106, B:57:0x0112, B:58:0x0120, B:45:0x00d0, B:47:0x00dc), top: B:65:0x000b }] */
        /* JADX WARN: Code duplicated, block: B:27:0x0079  */
        /* JADX WARN: Code duplicated, block: B:29:0x0083 A[Catch: all -> 0x0015, CancellationException -> 0x0018, Exception -> 0x00d0, TRY_ENTER, TryCatch #3 {all -> 0x0015, blocks: (B:6:0x0011, B:22:0x0059, B:24:0x006b, B:29:0x0083, B:31:0x0095, B:33:0x00a1, B:38:0x00b9, B:55:0x0106, B:57:0x0112, B:58:0x0120, B:45:0x00d0, B:47:0x00dc), top: B:65:0x000b }] */
        /* JADX WARN: Code duplicated, block: B:31:0x0095 A[Catch: all -> 0x0015, CancellationException -> 0x0018, Exception -> 0x00d0, TryCatch #3 {all -> 0x0015, blocks: (B:6:0x0011, B:22:0x0059, B:24:0x006b, B:29:0x0083, B:31:0x0095, B:33:0x00a1, B:38:0x00b9, B:55:0x0106, B:57:0x0112, B:58:0x0120, B:45:0x00d0, B:47:0x00dc), top: B:65:0x000b }] */
        /* JADX WARN: Code duplicated, block: B:33:0x00a1 A[Catch: all -> 0x0015, CancellationException -> 0x0018, Exception -> 0x00d0, TRY_LEAVE, TryCatch #3 {all -> 0x0015, blocks: (B:6:0x0011, B:22:0x0059, B:24:0x006b, B:29:0x0083, B:31:0x0095, B:33:0x00a1, B:38:0x00b9, B:55:0x0106, B:57:0x0112, B:58:0x0120, B:45:0x00d0, B:47:0x00dc), top: B:65:0x000b }] */
        /* JADX WARN: Code duplicated, block: B:36:0x00af  */
        /* JADX WARN: Code duplicated, block: B:38:0x00b9 A[Catch: all -> 0x0015, CancellationException -> 0x0018, Exception -> 0x00d0, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x0015, blocks: (B:6:0x0011, B:22:0x0059, B:24:0x006b, B:29:0x0083, B:31:0x0095, B:33:0x00a1, B:38:0x00b9, B:55:0x0106, B:57:0x0112, B:58:0x0120, B:45:0x00d0, B:47:0x00dc), top: B:65:0x000b }] */
        /* JADX WARN: Code duplicated, block: B:47:0x00dc A[Catch: all -> 0x0015, TRY_LEAVE, TryCatch #3 {all -> 0x0015, blocks: (B:6:0x0011, B:22:0x0059, B:24:0x006b, B:29:0x0083, B:31:0x0095, B:33:0x00a1, B:38:0x00b9, B:55:0x0106, B:57:0x0112, B:58:0x0120, B:45:0x00d0, B:47:0x00dc), top: B:65:0x000b }] */
        /* JADX WARN: Code duplicated, block: B:50:0x00f6  */
        /* JADX WARN: Code duplicated, block: B:57:0x0112 A[Catch: all -> 0x0015, TryCatch #3 {all -> 0x0015, blocks: (B:6:0x0011, B:22:0x0059, B:24:0x006b, B:29:0x0083, B:31:0x0095, B:33:0x00a1, B:38:0x00b9, B:55:0x0106, B:57:0x0112, B:58:0x0120, B:45:0x00d0, B:47:0x00dc), top: B:65:0x000b }] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r0v12 */
        /* JADX WARN: Type inference failed for: r0v13 */
        /* JADX WARN: Type inference failed for: r0v18, types: [kotlinx.coroutines.Job] */
        /* JADX WARN: Type inference failed for: r0v19 */
        /* JADX WARN: Type inference failed for: r0v5 */
        /* JADX WARN: Type inference failed for: r0v7 */
        /* JADX WARN: Type inference failed for: r10v2 */
        /* JADX WARN: Type inference failed for: r10v3 */
        /* JADX WARN: Type inference failed for: r10v8, types: [kotlinx.coroutines.Job] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Throwable th;
            ?? r10;
            ?? r0;
            CancellationException e;
            ?? r1;
            boolean zBooleanValue;
            CoroutineScope coroutineScope = (CoroutineScope) this.c;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    r10 = (Job) coroutineScope.getCoroutineContext().get(Job.INSTANCE);
                    if (r10 == 0) {
                        return Unit.INSTANCE;
                    }
                    try {
                        CoroutineDispatcher io2 = Dispatchers.getIO();
                        a aVar = new a(this.f, this.g, null);
                        this.c = SpillingKt.nullOutSpilledVariable(coroutineScope);
                        this.a = r10;
                        this.b = 1;
                        Object objWithContext = BuildersKt.withContext(io2, aVar, this);
                        if (objWithContext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        r1 = r10;
                        obj = objWithContext;
                        zBooleanValue = ((Boolean) obj).booleanValue();
                        if (c5.this.h.get(this.e) != r1) {
                            Unit unit = Unit.INSTANCE;
                            if (c5.this.h.get(this.e) == r1) {
                                c5.this.h.remove(this.e);
                            }
                            return unit;
                        }
                        l5 l5Var = c5.this.f;
                        l5Var.a.put(this.e, new l5.a.b(zBooleanValue));
                        if (zBooleanValue) {
                            if (c5.this.h.get(this.e) != r1) {
                                Unit unit2 = Unit.INSTANCE;
                                if (c5.this.h.get(this.e) == r1) {
                                    c5.this.h.remove(this.e);
                                }
                                return unit2;
                            }
                            c5.a(c5.this, this.f);
                        }
                        if (c5.this.h.get(this.e) == r1) {
                            c5.this.h.remove(this.e);
                        }
                    } catch (CancellationException e2) {
                        r0 = r10;
                        e = e2;
                        if (c5.this.h.get(this.e) == r0) {
                            l5 l5Var2 = c5.this.f;
                            String str = this.e;
                            l5Var2.getClass();
                            l5Var2.a.remove(str);
                        }
                        throw e;
                    } catch (Exception unused) {
                        r0 = r10;
                        if (c5.this.h.get(this.e) == r0) {
                            l5 l5Var3 = c5.this.f;
                            String str2 = this.e;
                            l5Var3.getClass();
                            l5Var3.a.remove(str2);
                        }
                        if (c5.this.h.get(this.e) == r0) {
                            c5.this.h.remove(this.e);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (c5.this.h.get(this.e) == r10) {
                            c5.this.h.remove(this.e);
                        }
                        throw th;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    r0 = this.a;
                    try {
                        ResultKt.throwOnFailure(obj);
                        r1 = r0;
                        zBooleanValue = ((Boolean) obj).booleanValue();
                        if (c5.this.h.get(this.e) != r1) {
                            Unit unit3 = Unit.INSTANCE;
                            if (c5.this.h.get(this.e) == r1) {
                                c5.this.h.remove(this.e);
                            }
                            return unit3;
                        }
                        l5 l5Var4 = c5.this.f;
                        l5Var4.a.put(this.e, new l5.a.b(zBooleanValue));
                        if (zBooleanValue) {
                            if (c5.this.h.get(this.e) != r1) {
                                Unit unit4 = Unit.INSTANCE;
                                if (c5.this.h.get(this.e) == r1) {
                                    c5.this.h.remove(this.e);
                                }
                                return unit4;
                            }
                            c5.a(c5.this, this.f);
                        }
                        if (c5.this.h.get(this.e) == r1) {
                            c5.this.h.remove(this.e);
                        }
                    } catch (CancellationException e3) {
                        e = e3;
                        if (c5.this.h.get(this.e) == r0) {
                            l5 l5Var5 = c5.this.f;
                            String str3 = this.e;
                            l5Var5.getClass();
                            l5Var5.a.remove(str3);
                        }
                        throw e;
                    } catch (Exception unused2) {
                        if (c5.this.h.get(this.e) == r0) {
                            l5 l5Var6 = c5.this.f;
                            String str4 = this.e;
                            l5Var6.getClass();
                            l5Var6.a.remove(str4);
                        }
                        if (c5.this.h.get(this.e) == r0) {
                            c5.this.h.remove(this.e);
                        }
                    }
                }
                return Unit.INSTANCE;
            } catch (Throwable th3) {
                th = th3;
                r10 = coroutineScope;
            }
        }
    }

    public c5(Context context, PdfFragment pdfFragment, PdfConfiguration pdfConfiguration) {
        context.getClass();
        pdfFragment.getClass();
        pdfConfiguration.getClass();
        this.a = context;
        this.b = pdfFragment;
        this.c = pdfConfiguration;
        this.d = new CompositeDisposable();
        this.e = t;
        this.f = new l5();
        this.g = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        this.h = new LinkedHashMap();
        this.i = new go<>();
        this.j = new px<>(5);
        this.k = new px<>(5);
        this.l = new px<>(5);
        this.m = new px<>(5);
        this.n = new px<>(5);
        this.o = new px<>(5);
        this.p = new px<>(5);
        this.q = new px<>(5);
        this.r = new ArrayList();
        this.s = new go<>();
    }

    public static final j10 b(c5 c5Var) {
        Context context = c5Var.a;
        PdfConfiguration pdfConfiguration = c5Var.c;
        DocumentView documentViewA = c5Var.b.getInternal().getViewCoordinator().a(false);
        List list = Collections.EMPTY_LIST;
        return new j10(context, pdfConfiguration, documentViewA, 0);
    }

    public static final zy c(c5 c5Var) {
        return new zy(c5Var.a, c5Var.c, c5Var.b);
    }

    public static final yj d(c5 c5Var) {
        return new yj(c5Var.a, c5Var.c);
    }

    public static final k30 e(c5 c5Var) {
        return new k30(c5Var.a);
    }

    public static final zy f(c5 c5Var) {
        return new zy(c5Var.a, c5Var.c, c5Var.b);
    }

    public z4<?> a(Annotation annotation, AnnotationOverlayRenderStrategy.Strategy strategy) {
        annotation.getClass();
        return a(annotation, strategy, true);
    }

    public static final yy c(c5 c5Var, PdfDocument pdfDocument) {
        return new yy(c5Var.a, c5Var.c, pdfDocument);
    }

    public static final ni d(c5 c5Var, PdfDocument pdfDocument) {
        Context context = c5Var.a;
        PdfConfiguration pdfConfiguration = c5Var.c;
        AnnotationConfigurationRegistry annotationConfiguration = c5Var.b.getAnnotationConfiguration();
        annotationConfiguration.getClass();
        return new ni(context, pdfDocument, pdfConfiguration, annotationConfiguration);
    }

    public static final e00 e(c5 c5Var, PdfDocument pdfDocument) {
        Context context = c5Var.a;
        PdfConfiguration pdfConfiguration = c5Var.c;
        AnnotationConfigurationRegistry annotationConfiguration = c5Var.b.getAnnotationConfiguration();
        annotationConfiguration.getClass();
        return new e00(context, pdfDocument, pdfConfiguration, annotationConfiguration);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v10, types: [com.pspdfkit.internal.e00, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v12, types: [com.pspdfkit.internal.z4] */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.pspdfkit.internal.z4] */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.pspdfkit.internal.z4] */
    /* JADX WARN: Type inference failed for: r2v7, types: [com.pspdfkit.internal.z4] */
    /* JADX WARN: Type inference failed for: r2v9, types: [com.pspdfkit.internal.z4] */
    /* JADX WARN: Type inference failed for: r5v5, types: [T, io.reactivex.rxjava3.disposables.Disposable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v9, types: [T, com.pspdfkit.internal.nx] */
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
    public final z4<?> a(Annotation annotation, AnnotationOverlayRenderStrategy.Strategy strategy, boolean z) {
        annotation.getClass();
        strategy.getClass();
        final PdfDocument document = this.b.getDocument();
        if (document == null) {
            throw new IllegalStateException("Annotation view can be created only while document is loaded!");
        }
        if (z) {
            strategy = b(annotation, strategy);
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (annotation.get_appearanceStreamGenerator() == null) {
            T t2 = 0;
            T t3 = 0;
            if (strategy == AnnotationOverlayRenderStrategy.Strategy.AP_STREAM_RENDERING) {
                switch (b.a[annotation.getType().ordinal()]) {
                    case 1:
                        t3 = (z4) this.k.a(new px.a() { // from class: com.pspdfkit.internal.c5$$ExternalSyntheticLambda9
                            @Override // com.pspdfkit.internal.px.a
                            public final Object create() {
                                return c5.a(this.f$0);
                            }
                        });
                        break;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        t3 = (z4) this.l.a(new px.a() { // from class: com.pspdfkit.internal.c5$$ExternalSyntheticLambda8
                            @Override // com.pspdfkit.internal.px.a
                            public final Object create() {
                                return c5.a(this.f$0, document);
                            }
                        });
                        break;
                    case 6:
                        t3 = (z4) this.q.a(new px.a() { // from class: com.pspdfkit.internal.c5$$ExternalSyntheticLambda5
                            @Override // com.pspdfkit.internal.px.a
                            public final Object create() {
                                return c5.c(this.f$0);
                            }
                        });
                        break;
                }
                objectRef.element = t3;
            } else {
                switch (b.a[annotation.getType().ordinal()]) {
                    case 1:
                        t2 = (z4) this.k.a(new px.a() { // from class: com.pspdfkit.internal.c5$$ExternalSyntheticLambda3
                            @Override // com.pspdfkit.internal.px.a
                            public final Object create() {
                                return c5.e(this.f$0);
                            }
                        });
                        break;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        t2 = (z4) this.l.a(new px.a() { // from class: com.pspdfkit.internal.c5$$ExternalSyntheticLambda2
                            @Override // com.pspdfkit.internal.px.a
                            public final Object create() {
                                return c5.c(this.f$0, document);
                            }
                        });
                        break;
                    case 6:
                        t2 = (z4) this.q.a(new px.a() { // from class: com.pspdfkit.internal.c5$$ExternalSyntheticLambda1
                            @Override // com.pspdfkit.internal.px.a
                            public final Object create() {
                                return c5.f(this.f$0);
                            }
                        });
                        break;
                    case 7:
                    case 8:
                        t2 = (z4) this.j.a(new px.a() { // from class: com.pspdfkit.internal.c5$$ExternalSyntheticLambda13
                            @Override // com.pspdfkit.internal.px.a
                            public final Object create() {
                                return c5.d(this.f$0);
                            }
                        });
                        break;
                    case 9:
                        t2 = ((FreeTextAnnotation) annotation).getIntent() == FreeTextAnnotation.FreeTextAnnotationIntent.FREE_TEXT_CALLOUT ? (e00) this.o.a(new px.a() { // from class: com.pspdfkit.internal.c5$$ExternalSyntheticLambda11
                            @Override // com.pspdfkit.internal.px.a
                            public final Object create() {
                                return c5.d(this.f$0, document);
                            }
                        }) : (e00) this.n.a(new px.a() { // from class: com.pspdfkit.internal.c5$$ExternalSyntheticLambda12
                            @Override // com.pspdfkit.internal.px.a
                            public final Object create() {
                                return c5.e(this.f$0, document);
                            }
                        });
                        t2.getClass();
                        li liVar = t2.b;
                        Iterator<AnnotationViewsListener> it = this.s.iterator();
                        while (it.hasNext()) {
                            it.next().onAnnotationEditTextViewCreated(annotation, liVar);
                        }
                        break;
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                        t2 = (z4) this.p.a(new px.a() { // from class: com.pspdfkit.internal.c5$$ExternalSyntheticLambda10
                            @Override // com.pspdfkit.internal.px.a
                            public final Object create() {
                                return c5.b(this.f$0);
                            }
                        });
                        break;
                }
                objectRef.element = t2;
            }
        }
        if (objectRef.element == 0) {
            objectRef.element = this.m.a(new px.a() { // from class: com.pspdfkit.internal.c5$$ExternalSyntheticLambda6
                @Override // com.pspdfkit.internal.px.a
                public final Object create() {
                    return c5.b(this.f$0, document);
                }
            });
        }
        T t4 = objectRef.element;
        t4.getClass();
        ((z4) t4).setAnnotation(annotation);
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        ?? Subscribe = a(document, annotation).observeOn(AndroidSchedulers.mainThread()).doAfterTerminate(new Action() { // from class: com.pspdfkit.internal.c5$$ExternalSyntheticLambda7
            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() {
                c5.a(this.f$0, objectRef2);
            }
        }).subscribe(new c(objectRef));
        Subscribe.getClass();
        objectRef2.element = Subscribe;
        CompositeDisposable compositeDisposable = this.d;
        compositeDisposable.getClass();
        compositeDisposable.add(Subscribe);
        z4 z4Var = (z4) objectRef.element;
        z4Var.getClass();
        if ((z4Var instanceof vy) || (z4Var instanceof j10)) {
            this.r.add(objectRef.element);
        }
        return (z4) objectRef.element;
    }

    public static final vy b(c5 c5Var, PdfDocument pdfDocument) {
        return new vy(c5Var.a, c5Var.c, pdfDocument);
    }

    public void b(z4<?> z4Var) {
        z4Var.getClass();
        ViewGroup viewGroup = (ViewGroup) z4Var.a().getParent();
        if (viewGroup != null) {
            viewGroup.removeView(z4Var.a());
        }
        if (z4Var instanceof yj) {
            this.j.a((nx) z4Var);
        } else if (z4Var instanceof k30) {
            this.k.a((nx) z4Var);
        } else if (z4Var instanceof ni) {
            this.o.a((nx) z4Var);
        } else if (z4Var instanceof e00) {
            this.n.a((nx) z4Var);
        } else if (z4Var instanceof j10) {
            this.p.a((nx) z4Var);
        } else if (z4Var instanceof yy) {
            this.l.a((nx) z4Var);
        } else if (z4Var instanceof zy) {
            this.q.a((nx) z4Var);
        } else if (z4Var instanceof vy) {
            this.m.a((nx) z4Var);
        }
        if ((z4Var instanceof vy) || (z4Var instanceof j10)) {
            this.r.remove(z4Var);
        }
    }

    public final AnnotationOverlayRenderStrategy.Strategy b(Annotation annotation, AnnotationOverlayRenderStrategy.Strategy strategy) {
        if (!annotation.isMeasurement() && annotation.get_appearanceStreamGenerator() == null && strategy == AnnotationOverlayRenderStrategy.Strategy.PLATFORM_RENDERING) {
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
                        l5 l5Var = this.f;
                        l5Var.getClass();
                        uuid.getClass();
                        l5.a aVar = l5Var.a.get(uuid);
                        if (aVar instanceof l5.a.b) {
                            if (((l5.a.b) aVar).a) {
                                return AnnotationOverlayRenderStrategy.Strategy.AP_STREAM_RENDERING;
                            }
                        } else if (!(aVar instanceof l5.a.C0277a)) {
                            if (aVar == null) {
                                b(annotation);
                                return strategy;
                            }
                            throw new NoWhenBranchMatchedException();
                        }
                    }
                default:
                    return strategy;
            }
        }
        return strategy;
    }

    public final Job b(Annotation annotation) {
        String uuid = annotation.getInternal().getUuid();
        Job job = (Job) this.h.get(uuid);
        if (job != null) {
            return job;
        }
        NativeAnnotation nativeAnnotation = annotation.getInternal().getNativeAnnotation();
        if (nativeAnnotation == null) {
            return null;
        }
        l5 l5Var = this.f;
        l5Var.getClass();
        uuid.getClass();
        l5Var.a.put(uuid, l5.a.C0277a.a);
        Job jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(this.g, null, null, new d(uuid, annotation, nativeAnnotation, null), 3, null);
        this.h.put(uuid, jobLaunch$default);
        return jobLaunch$default;
    }

    public static final k30 a(c5 c5Var) {
        return new k30(c5Var.a);
    }

    public static final yy a(c5 c5Var, PdfDocument pdfDocument) {
        return new yy(c5Var.a, c5Var.c, pdfDocument);
    }

    public static final void a(c5 c5Var, Ref.ObjectRef objectRef) {
        Disposable disposable;
        CompositeDisposable compositeDisposable = c5Var.d;
        T t2 = objectRef.element;
        if (t2 == 0) {
            Intrinsics.throwUninitializedPropertyAccessException("disposable");
            disposable = null;
        } else {
            disposable = (Disposable) t2;
        }
        compositeDisposable.remove(disposable);
    }

    public final Single<Boolean> a(PdfDocument pdfDocument, final Annotation annotation) {
        Single<Boolean> singleSubscribeOn = Single.fromCallable(new Callable() { // from class: com.pspdfkit.internal.c5$$ExternalSyntheticLambda4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return c5.a(annotation, this);
            }
        }).subscribeOn(((lm) pdfDocument).b(3));
        singleSubscribeOn.getClass();
        return singleSubscribeOn;
    }

    public static final Boolean a(Annotation annotation, c5 c5Var) {
        FormElement formElement;
        boolean z = true;
        boolean z2 = ww.f(annotation) && ar.b().a(c5Var.c, annotation);
        boolean zE = ar.b().e(c5Var.c);
        if (!(annotation instanceof WidgetAnnotation)) {
            z = z2;
        } else if (!z2 || !zE || (formElement = ((WidgetAnnotation) annotation).getFormElement()) == null || (formElement.getType() != FormType.PUSHBUTTON ? formElement.getType() == FormType.SIGNATURE : ((PushButtonFormElement) formElement).getAction() == null)) {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    public boolean a(z4<?> z4Var) {
        Annotation annotation = z4Var.getAnnotation();
        if (annotation == null) {
            return false;
        }
        AnnotationOverlayRenderStrategy.Strategy overlayRenderStrategy = this.e.getOverlayRenderStrategy(annotation);
        overlayRenderStrategy.getClass();
        AnnotationOverlayRenderStrategy.Strategy strategyB = b(annotation, overlayRenderStrategy);
        switch (b.a[annotation.getType().ordinal()]) {
            case 1:
                if (strategyB == AnnotationOverlayRenderStrategy.Strategy.AP_STREAM_RENDERING) {
                    return z4Var instanceof vy;
                }
                return z4Var instanceof k30;
            case 2:
            case 3:
            case 4:
            case 5:
                return z4Var instanceof yy;
            case 6:
                return z4Var instanceof zy;
            case 7:
            case 8:
                if (strategyB == AnnotationOverlayRenderStrategy.Strategy.AP_STREAM_RENDERING) {
                    return z4Var instanceof vy;
                }
                return z4Var instanceof yj;
            case 9:
                if (strategyB == AnnotationOverlayRenderStrategy.Strategy.AP_STREAM_RENDERING) {
                    return z4Var instanceof vy;
                }
                return z4Var instanceof e00;
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                if (strategyB == AnnotationOverlayRenderStrategy.Strategy.AP_STREAM_RENDERING) {
                    return z4Var instanceof vy;
                }
                return z4Var instanceof j10;
            default:
                return true;
        }
    }

    public static final void a(c5 c5Var, Annotation annotation) {
        Iterator<a> it = c5Var.i.iterator();
        while (it.hasNext()) {
            it.next().a(annotation);
        }
    }

    public static final AnnotationOverlayRenderStrategy.Strategy a(Annotation annotation) {
        annotation.getClass();
        if (annotation.getType() == AnnotationType.FREETEXT) {
            return AnnotationOverlayRenderStrategy.Strategy.AP_STREAM_RENDERING;
        }
        return AnnotationOverlayRenderStrategy.Strategy.PLATFORM_RENDERING;
    }
}
