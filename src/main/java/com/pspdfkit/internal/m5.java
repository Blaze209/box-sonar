package com.pspdfkit.internal;

import android.util.LongSparseArray;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationProvider;
import com.pspdfkit.annotations.appearance.AppearanceStreamGenerator;
import com.pspdfkit.document.providers.DataProvider;
import com.pspdfkit.internal.document.DataProviderShim;
import com.pspdfkit.internal.jni.NativeAPStreamDocumentGenerator;
import com.pspdfkit.internal.jni.NativeAPStreamGenerationOptions;
import com.pspdfkit.internal.jni.NativeAPStreamOrigin;
import com.pspdfkit.internal.jni.NativeAPStreamResult;
import com.pspdfkit.internal.jni.NativeAnnotation;
import com.pspdfkit.internal.jni.NativeDocumentProvider;
import java.lang.ref.WeakReference;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
public final class m5 extends NativeAPStreamDocumentGenerator {
    public final WeakReference<lm> b;
    public final LongSparseArray<WeakReference<Annotation>> a = new LongSparseArray<>();
    public final go<AppearanceStreamGenerator> c = new go<>();

    @DebugMetadata(c = "com.pspdfkit.internal.annotations.AppearanceStreamProvider$getAnnotationForNativeAnnotation$1", f = "AppearanceStreamProvider.kt", i = {}, l = {123}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Annotation>>, Object> {
        public int a;
        public final /* synthetic */ AnnotationProvider b;
        public final /* synthetic */ NativeAnnotation c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AnnotationProvider annotationProvider, NativeAnnotation nativeAnnotation, Continuation<? super a> continuation) {
            super(2, continuation);
            this.b = annotationProvider;
            this.c = nativeAnnotation;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.b, this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Annotation>> continuation) {
            return new a(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            AnnotationProvider annotationProvider = this.b;
            Integer absolutePageIndex = this.c.getAbsolutePageIndex();
            absolutePageIndex.getClass();
            int iIntValue = absolutePageIndex.intValue();
            this.a = 1;
            Object annotations = annotationProvider.getAnnotations(iIntValue, this);
            return annotations == coroutine_suspended ? coroutine_suspended : annotations;
        }
    }

    public m5(lm lmVar) {
        this.b = new WeakReference<>(lmVar);
        Iterator<NativeDocumentProvider> it = lmVar.y.getDocumentProviders().iterator();
        it.getClass();
        while (it.hasNext()) {
            it.next().setAPStreamDocumentGenerator(this);
        }
    }

    public final void a(Annotation annotation) {
        annotation.getClass();
        NativeAnnotation nativeAnnotation = annotation.getInternal().getNativeAnnotation();
        if (nativeAnnotation == null) {
            return;
        }
        synchronized (this.a) {
            this.a.put(nativeAnnotation.getIdentifier(), new WeakReference<>(annotation));
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void b(Annotation annotation) {
        NativeAnnotation nativeAnnotation = annotation.getInternal().getNativeAnnotation();
        if (nativeAnnotation == null) {
            return;
        }
        synchronized (this.a) {
            this.a.remove(nativeAnnotation.getIdentifier());
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.pspdfkit.internal.jni.NativeAPStreamDocumentGenerator
    public final NativeAPStreamResult generateAPStream(NativeAnnotation nativeAnnotation, EnumSet<NativeAPStreamGenerationOptions> enumSet) {
        AppearanceStreamGenerator next;
        nativeAnnotation.getClass();
        enumSet.getClass();
        Annotation annotationA = a(nativeAnnotation);
        if (annotationA == null) {
            return null;
        }
        EnumSet<AppearanceStreamGenerator.AppearanceStreamGenerationOptions> enumSetA = mr.a(enumSet);
        Iterator<AppearanceStreamGenerator> it = this.c.iterator();
        it.getClass();
        do {
            if (!it.hasNext()) {
                next = annotationA.get_appearanceStreamGenerator();
                if (next != null && next.shouldUseGeneratorForAnnotation(annotationA)) {
                    break;
                }
                next = null;
                break;
            }
            next = it.next();
        } while (!next.shouldUseGeneratorForAnnotation(annotationA));
        DataProvider dataProviderForAnnotation = next != null ? next.getDataProviderForAnnotation(annotationA, enumSetA) : null;
        if (dataProviderForAnnotation != null) {
            return new NativeAPStreamResult(new DataProviderShim(dataProviderForAnnotation), NativeAPStreamOrigin.ADAPTABLE);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0035 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:? A[RETURN, SYNTHETIC] */
    @Override // com.pspdfkit.internal.jni.NativeAPStreamDocumentGenerator
    public final boolean shouldUseApstreamDocumentGenerator(NativeAnnotation nativeAnnotation) {
        AppearanceStreamGenerator next;
        nativeAnnotation.getClass();
        Annotation annotationA = a(nativeAnnotation);
        if (annotationA == null) {
            return false;
        }
        Iterator<AppearanceStreamGenerator> it = this.c.iterator();
        it.getClass();
        while (it.hasNext()) {
            next = it.next();
            if (next.shouldUseGeneratorForAnnotation(annotationA)) {
                if (next != null) {
                    return true;
                }
                return false;
            }
        }
        next = annotationA.get_appearanceStreamGenerator();
        if (next == null || !next.shouldUseGeneratorForAnnotation(annotationA)) {
            next = null;
        }
        if (next != null) {
            return true;
        }
        return false;
    }

    public final synchronized Annotation a(NativeAnnotation nativeAnnotation) {
        WeakReference<Annotation> weakReference = this.a.get(nativeAnnotation.getIdentifier());
        Annotation annotation = weakReference != null ? weakReference.get() : null;
        if (!this.c.a.isEmpty() && annotation == null) {
            if (nativeAnnotation.getAbsolutePageIndex() != null) {
                lm lmVar = this.b.get();
                if (lmVar == null) {
                    return null;
                }
                for (Annotation annotation2 : (List) BuildersKt__BuildersKt.runBlocking$default(null, new a(lmVar.getAnnotationProvider(), nativeAnnotation, null), 1, null)) {
                    if (annotation2.getInternal().getNativeAnnotation() != null) {
                        NativeAnnotation nativeAnnotation2 = annotation2.getInternal().getNativeAnnotation();
                        nativeAnnotation2.getClass();
                        if (nativeAnnotation2.getIdentifier() == nativeAnnotation.getIdentifier()) {
                            return annotation2;
                        }
                    }
                }
            }
            return null;
        }
        return annotation;
    }
}
