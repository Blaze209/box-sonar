package com.pspdfkit.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.exceptions.InvalidNutrientLicenseException;
import com.pspdfkit.internal.jni.NativeAnnotation;
import com.pspdfkit.internal.jni.NativeLicenseFeatures;
import com.pspdfkit.internal.jni.NativeReplyType;
import com.pspdfkit.utils.PdfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
@DebugMetadata(c = "com.pspdfkit.internal.annotations.AnnotationProviderImpl$getFlattenedAnnotationReplies$4", f = "AnnotationProviderImpl.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {TypedValues.AttributesType.TYPE_PATH_ROTATE, 1115}, m = "invokeSuspend", n = {"nativeAnnotation", "pageIndex", "objectNumber", "nativeAnnotation", "cachedAnnotations", "$this$withLock_u24default$iv", "pageIndex", "objectNumber", "$i$f$withLock"}, nl = {TypedValues.AttributesType.TYPE_PIVOT_TARGET, 1116}, s = {"L$0", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1", "I$2"}, v = 2)
public final class u3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Annotation>>, Object> {
    public int a;
    public int b;
    public NativeAnnotation c;
    public List d;
    public Mutex e;
    public o3 f;
    public boolean g;
    public int h;
    public final /* synthetic */ boolean i;
    public final /* synthetic */ o3 j;
    public final /* synthetic */ Annotation k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u3(boolean z, o3 o3Var, Annotation annotation, Continuation<? super u3> continuation) {
        super(2, continuation);
        this.i = z;
        this.j = o3Var;
        this.k = annotation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new u3(this.i, this.j, this.k, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Annotation>> continuation) {
        return ((u3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00ac A[Catch: all -> 0x0112, TRY_ENTER, TryCatch #0 {all -> 0x0112, blocks: (B:32:0x00ac, B:33:0x00b5), top: B:55:0x00aa }] */
    /* JADX WARN: Code duplicated, block: B:33:0x00b5 A[Catch: all -> 0x0112, TRY_LEAVE, TryCatch #0 {all -> 0x0112, blocks: (B:32:0x00ac, B:33:0x00b5), top: B:55:0x00aa }] */
    /* JADX WARN: Code duplicated, block: B:36:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:38:0x00de  */
    /* JADX WARN: Code duplicated, block: B:39:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:42:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:58:0x010d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:60:0x00ce A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x0108 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r2v3, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v8 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int objectNumber;
        NativeAnnotation nativeAnnotation;
        int i;
        List list;
        NativeAnnotation nativeAnnotation2;
        o3 o3Var;
        ?? r2;
        boolean z;
        ArrayList<NativeAnnotation> flattenedAnnotationReplies;
        ArrayList arrayList;
        int size;
        Long annotationId;
        Iterator it;
        Object next;
        Annotation annotation;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.h;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            if (!this.i && !ar.b().a(NativeLicenseFeatures.ANNOTATION_REPLIES)) {
                throw new InvalidNutrientLicenseException("Your current license doesn't allow creating annotation replies.");
            }
            int pageIndex = this.k.getPageIndex();
            objectNumber = this.k.getObjectNumber();
            nativeAnnotation = this.k.getInternal().getNativeAnnotation();
            if (!this.k.isAttached() || pageIndex == Integer.MIN_VALUE || objectNumber == Integer.MIN_VALUE || nativeAnnotation == null) {
                throw new IllegalArgumentException("Retrieval of replies for detached annotations is not supported.");
            }
            o3 o3Var2 = this.j;
            this.c = nativeAnnotation;
            this.a = pageIndex;
            this.b = objectNumber;
            this.h = 1;
            Object annotations = o3Var2.getAnnotations(pageIndex, this);
            if (annotations != coroutine_suspended) {
                i = pageIndex;
                obj = annotations;
            }
            return coroutine_suspended;
        }
        if (i2 == 1) {
            objectNumber = this.b;
            i = this.a;
            nativeAnnotation = this.c;
            ResultKt.throwOnFailure(obj);
        } else {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            z = this.g;
            o3Var = this.f;
            Mutex mutex = this.e;
            list = this.d;
            nativeAnnotation2 = this.c;
            ResultKt.throwOnFailure(obj);
            r2 = mutex;
        }
        try {
            if (z) {
                flattenedAnnotationReplies = o3Var.d.getAnnotationsForDeletion(nativeAnnotation2, NativeReplyType.TEXT_AND_STATE);
            } else {
                flattenedAnnotationReplies = o3Var.d.getFlattenedAnnotationReplies(nativeAnnotation2, NativeReplyType.TEXT_AND_STATE);
            }
            r2.unlock(null);
            flattenedAnnotationReplies.getClass();
            arrayList = new ArrayList();
            size = flattenedAnnotationReplies.size();
            r2 = 0;
            while (r2 < size) {
                NativeAnnotation nativeAnnotation3 = flattenedAnnotationReplies.get(r2);
                r2++;
                annotationId = nativeAnnotation3.getAnnotationId();
                if (annotationId == null) {
                    PdfLog.w("Nutri.AnnotationProvImp", "Fetched native reply without valid annotation ID. Skipping.", new Object[0]);
                    annotation = null;
                } else {
                    it = list.iterator();
                    do {
                        if (it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                    } while (((Annotation) next).getObjectNumber() != annotationId.longValue());
                    annotation = (Annotation) next;
                }
                if (annotation != null) {
                    arrayList.add(annotation);
                }
            }
            return arrayList;
        } catch (Throwable th) {
            r2.unlock(null);
            throw th;
        }
        List list2 = (List) obj;
        o3 o3Var3 = this.j;
        Mutex mutex2 = o3Var3.j;
        boolean z2 = this.i;
        this.c = nativeAnnotation;
        this.d = list2;
        this.e = mutex2;
        this.f = o3Var3;
        this.a = i;
        this.b = objectNumber;
        this.g = z2;
        this.h = 2;
        if (mutex2.lock(null, this) != coroutine_suspended) {
            list = list2;
            nativeAnnotation2 = nativeAnnotation;
            o3Var = o3Var3;
            r2 = mutex2;
            z = z2;
            if (z) {
                flattenedAnnotationReplies = o3Var.d.getAnnotationsForDeletion(nativeAnnotation2, NativeReplyType.TEXT_AND_STATE);
            } else {
                flattenedAnnotationReplies = o3Var.d.getFlattenedAnnotationReplies(nativeAnnotation2, NativeReplyType.TEXT_AND_STATE);
            }
            r2.unlock(null);
            flattenedAnnotationReplies.getClass();
            arrayList = new ArrayList();
            size = flattenedAnnotationReplies.size();
            r2 = 0;
            while (r2 < size) {
                NativeAnnotation nativeAnnotation4 = flattenedAnnotationReplies.get(r2);
                r2++;
                annotationId = nativeAnnotation4.getAnnotationId();
                if (annotationId == null) {
                    PdfLog.w("Nutri.AnnotationProvImp", "Fetched native reply without valid annotation ID. Skipping.", new Object[0]);
                    annotation = null;
                } else {
                    it = list.iterator();
                    do {
                        if (it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                    } while (((Annotation) next).getObjectNumber() != annotationId.longValue());
                    annotation = (Annotation) next;
                }
                if (annotation != null) {
                    arrayList.add(annotation);
                }
            }
            return arrayList;
        }
        return coroutine_suspended;
    }
}
