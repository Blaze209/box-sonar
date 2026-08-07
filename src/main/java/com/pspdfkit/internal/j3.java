package com.pspdfkit.internal;

import android.graphics.RectF;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.collection.SparseArrayCompat;
import androidx.media3.common.PlaybackException;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.actions.Action;
import com.pspdfkit.annotations.measurements.MeasurementPrecision;
import com.pspdfkit.annotations.measurements.Scale;
import com.pspdfkit.exceptions.InvalidNutrientLicenseException;
import com.pspdfkit.exceptions.NutrientException;
import com.pspdfkit.internal.jni.NativeAnnotation;
import com.pspdfkit.internal.jni.NativeAnnotationManager;
import com.pspdfkit.internal.jni.NativeUpdatePropertiesResult;
import com.pspdfkit.utils.EdgeInsets;
import com.pspdfkit.utils.PdfLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Date;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class j3 {
    public static long m;
    public o3 a;
    public NativeAnnotation b;
    public boolean c;
    public NativeAnnotationManager d;
    public Annotation e;
    public final k3 f = new k3(0);
    public final go<zs> g = new go<>();
    public Job h;
    public boolean i;
    public k4 j;
    public boolean k;
    public static final AtomicInteger l = new AtomicInteger(-1);
    public static final Set<Integer> n = SetsKt.setOf((Object[]) new Integer[]{20, 21, 8, 2});

    @DebugMetadata(c = "com.pspdfkit.internal.annotations.properties.AnnotationPropertyManager$triggerDelayedSyncToBackend$1", f = "AnnotationPropertyManager.kt", i = {}, l = {340}, m = "invokeSuspend", n = {}, nl = {343}, s = {}, v = 2)
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ long b;
        public final /* synthetic */ j3 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(long j, j3 j3Var, Continuation<? super a> continuation) {
            super(2, continuation);
            this.b = j;
            this.c = j3Var;
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
            o3 o3Var;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.a = 1;
                if (DelayKt.delay(100L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            if (j3.m != this.b) {
                return Unit.INSTANCE;
            }
            j3 j3Var = this.c;
            if (j3Var.b != null && (o3Var = j3Var.a) != null) {
                if ((o3Var instanceof wk) && ((wk) o3Var).p) {
                    this.c.i = true;
                    return Unit.INSTANCE;
                }
                j3 j3Var2 = this.c;
                synchronized (j3Var2) {
                    j3Var2.a(true);
                }
            }
            this.c.h = null;
            return Unit.INSTANCE;
        }
    }

    public final synchronized void a(k4 k4Var) {
        k4 k4Var2 = this.j;
        if (k4Var2 != null) {
            k4Var2.c();
        }
        this.j = k4Var;
        Annotation annotation = this.e;
        if (annotation == null || !annotation.isAttached()) {
            return;
        }
        k();
    }

    public final byte b(int i) {
        Object obj = (byte) 0;
        Object obj2 = this.f.a.get(i);
        if (obj2 != null) {
            if (!(obj2 instanceof Byte)) {
                throw new IllegalArgumentException(("Property with key " + i + " is not a " + Reflection.getOrCreateKotlinClass(Byte.class).getSimpleName()).toString());
            }
            obj = obj2;
        }
        return ((Number) obj).byteValue();
    }

    public final Date c(int i) {
        Object obj = this.f.a.get(i);
        if (obj == null) {
            obj = null;
        } else if (!(obj instanceof Date)) {
            throw new IllegalArgumentException(("Property with key " + i + " is not a " + Reflection.getOrCreateKotlinClass(Date.class).getSimpleName()).toString());
        }
        return (Date) obj;
    }

    public final synchronized k4 d() {
        return this.j;
    }

    public final List<?> e(int i) {
        Object obj = this.f.a.get(i);
        if (obj == null) {
            obj = null;
        } else if (!(obj instanceof List)) {
            throw new IllegalArgumentException(("Property with key " + i + " is not a " + Reflection.getOrCreateKotlinClass(List.class).getSimpleName()).toString());
        }
        return (List) obj;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof j3) && this.f.a(((j3) obj).f, n);
    }

    public final RectF f(int i) {
        Object obj = this.f.a.get(i);
        if (obj == null) {
            obj = null;
        } else if (!(obj instanceof RectF)) {
            throw new IllegalArgumentException(("Property with key " + i + " is not a " + Reflection.getOrCreateKotlinClass(RectF.class).getSimpleName()).toString());
        }
        return (RectF) obj;
    }

    public final synchronized void g() {
        NativeAnnotationManager nativeAnnotationManager;
        NativeAnnotation nativeAnnotation = this.b;
        if (nativeAnnotation != null && (nativeAnnotationManager = this.d) != null) {
            this.f.e = true;
            byte[] properties = nativeAnnotationManager.getProperties(nativeAnnotation);
            if (properties == null) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                throw new NutrientException(String.format("Couldn't fetch properties for annotation %s: %s", Arrays.copyOf(new Object[]{nativeAnnotation, nativeAnnotation.getAnnotationId()}, 2)));
            }
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(properties);
            byteBufferWrap.getClass();
            g3 g3Var = new g3();
            byteBufferWrap.order(ByteOrder.LITTLE_ENDIAN);
            g3Var.a(byteBufferWrap.position() + byteBufferWrap.getInt(byteBufferWrap.position()), byteBufferWrap);
            ah ahVar = new ah(g3Var);
            k3 k3Var = this.f;
            k3Var.getClass();
            ahVar.a(k3Var, 3000);
            ahVar.a(k3Var, 3001);
            ahVar.a(k3Var, 12);
            ahVar.a(k3Var, 19);
            ahVar.a(k3Var, 23);
            ahVar.a(k3Var, 13);
            ahVar.a(k3Var, 24);
            ahVar.a(k3Var, 25);
            ahVar.a(k3Var, 14);
            ahVar.a(k3Var, 9);
            ahVar.a(k3Var, 10);
            ahVar.a(k3Var, 3);
            ahVar.a(k3Var, 22);
            ahVar.a(k3Var, 7);
            ahVar.a(k3Var, 6);
            ahVar.a(k3Var, 9001);
            ahVar.a(k3Var, 15);
            ahVar.a(k3Var, 1007);
            ahVar.a(k3Var, 29);
            ahVar.a(k3Var, 11);
            ahVar.a(k3Var, 16);
            ahVar.a(k3Var, 27);
            ahVar.a(k3Var, 21);
            ahVar.a(k3Var, 8);
            ahVar.a(k3Var, 2);
            ahVar.a(k3Var, 0);
            ahVar.a(k3Var, 1);
            ahVar.a(k3Var, 5);
            ahVar.a(k3Var, 18);
            ahVar.a(k3Var, 28);
            ahVar.a(k3Var, 4);
            ahVar.a(k3Var, 20);
            ahVar.a(k3Var, 26);
            int iA = g3Var.a(4);
            short s = iA != 0 ? g3Var.b.getShort(iA + g3Var.a) : (short) 0;
            Object[] enumConstants = AnnotationType.class.getEnumConstants();
            if (enumConstants == null) {
                throw new IllegalArgumentException("Flatbuffer enum conversion failure. ");
            }
            Enum r6 = ((Enum[]) enumConstants)[s];
            r6.getClass();
            yp ypVar = null;
            switch (ah.a.a[((AnnotationType) r6).ordinal()]) {
                case 1:
                    ahVar.a(k3Var, 1001);
                    ahVar.a(k3Var, 1002);
                    ahVar.a(k3Var, 1004);
                    ahVar.a(k3Var, 1000);
                    ahVar.a(k3Var, 1005);
                    ahVar.a(k3Var, 1006);
                    ahVar.a(k3Var, 101);
                    ahVar.a(k3Var, 100);
                    ahVar.a(k3Var, 102);
                    break;
                case 2:
                    ahVar.a(k3Var, 2000);
                    ahVar.a(k3Var, 101);
                    ahVar.a(k3Var, 100);
                    break;
                case 3:
                    ahVar.a(k3Var, 1001);
                    ahVar.a(k3Var, 1002);
                    ahVar.a(k3Var, 1004);
                    break;
                case 4:
                case 5:
                    ahVar.a(k3Var, 7002);
                    ahVar.a(k3Var, 7003);
                    ahVar.a(k3Var, 7000);
                    ahVar.a(k3Var, PlaybackException.ERROR_CODE_VIDEO_FRAME_PROCESSING_FAILED);
                    break;
                case 6:
                case 7:
                case 8:
                case 9:
                    ahVar.a(k3Var, PlaybackException.ERROR_CODE_AUDIO_TRACK_INIT_FAILED);
                    break;
                case 10:
                    ahVar.a(k3Var, 4000);
                    ahVar.a(k3Var, PlaybackException.ERROR_CODE_DECODER_INIT_FAILED);
                    ahVar.a(k3Var, 17);
                    ahVar.a(k3Var, 12001);
                    break;
                case 11:
                    ahVar.a(k3Var, 4000);
                    break;
                case 12:
                    ahVar.a(k3Var, 4000);
                    ahVar.a(k3Var, CameraAccessExceptionCompat.CAMERA_UNAVAILABLE_DO_NOT_DISTURB);
                    ahVar.a(k3Var, CameraAccessExceptionCompat.CAMERA_CHARACTERISTICS_CREATION_ERROR);
                    ahVar.a(k3Var, 10003);
                    ahVar.a(k3Var, 10004);
                    break;
                case 13:
                    ahVar.a(k3Var, PlaybackException.ERROR_CODE_DRM_PROVISIONING_FAILED);
                    ahVar.a(k3Var, PlaybackException.ERROR_CODE_DRM_SCHEME_UNSUPPORTED);
                    ahVar.a(k3Var, 4000);
                    ahVar.a(k3Var, 2000);
                    break;
                case 14:
                    ahVar.a(k3Var, 101);
                    ahVar.a(k3Var, 103);
                    yp ypVar2 = new yp();
                    int iA2 = g3Var.a(150);
                    if (iA2 != 0) {
                        int i = iA2 + g3Var.a;
                        int i2 = g3Var.b.getInt(i) + i;
                        ByteBuffer byteBuffer = g3Var.b;
                        byteBuffer.getClass();
                        ypVar2.a(i2, byteBuffer);
                        ypVar = ypVar2;
                    }
                    if (ypVar != null) {
                        ahVar.a(k3Var, 11001);
                        ahVar.a(k3Var, 11002);
                    }
                    break;
                case 15:
                    ahVar.a(k3Var, 101);
                    ahVar.a(k3Var, 103);
                    ahVar.a(k3Var, 102);
                    ahVar.a(k3Var, 105);
                    yp ypVar3 = new yp();
                    int iA3 = g3Var.a(150);
                    if (iA3 != 0) {
                        int i3 = iA3 + g3Var.a;
                        int i4 = g3Var.b.getInt(i3) + i3;
                        ByteBuffer byteBuffer2 = g3Var.b;
                        byteBuffer2.getClass();
                        ypVar3.a(i4, byteBuffer2);
                        ypVar = ypVar3;
                    }
                    if (ypVar != null) {
                        ahVar.a(k3Var, 11001);
                        ahVar.a(k3Var, 11002);
                    }
                    break;
                case 16:
                    ahVar.a(k3Var, 101);
                    ahVar.a(k3Var, 100);
                    ahVar.a(k3Var, 102);
                    ahVar.a(k3Var, 104);
                    yp ypVar4 = new yp();
                    int iA4 = g3Var.a(150);
                    if (iA4 != 0) {
                        int i5 = iA4 + g3Var.a;
                        int i6 = g3Var.b.getInt(i5) + i5;
                        ByteBuffer byteBuffer3 = g3Var.b;
                        byteBuffer3.getClass();
                        ypVar4.a(i6, byteBuffer3);
                        ypVar = ypVar4;
                    }
                    if (ypVar != null) {
                        ahVar.a(k3Var, 11001);
                        ahVar.a(k3Var, 11002);
                    }
                    break;
                case 17:
                case 18:
                    ahVar.a(k3Var, 101);
                    yp ypVar5 = new yp();
                    int iA5 = g3Var.a(150);
                    if (iA5 != 0) {
                        int i7 = iA5 + g3Var.a;
                        int i8 = g3Var.b.getInt(i7) + i7;
                        ByteBuffer byteBuffer4 = g3Var.b;
                        byteBuffer4.getClass();
                        ypVar5.a(i8, byteBuffer4);
                        ypVar = ypVar5;
                    }
                    if (ypVar != null) {
                        ahVar.a(k3Var, 11001);
                        ahVar.a(k3Var, 11002);
                    }
                    break;
                case 19:
                    ahVar.a(k3Var, PlaybackException.ERROR_CODE_AUDIO_TRACK_INIT_FAILED);
                    ahVar.a(k3Var, 8001);
                    ahVar.a(k3Var, 8002);
                    ahVar.a(k3Var, 8003);
                    break;
            }
            this.f.e = false;
            this.c = true;
        }
    }

    public final void h(int i) {
        k3 k3Var = this.f;
        synchronized (k3Var) {
            k3Var.a.remove(i);
            k3Var.b.remove(Integer.valueOf(i));
        }
        l();
    }

    public final int hashCode() {
        return this.f.a(n);
    }

    public final synchronized void i() {
        a(false);
        g();
    }

    public final synchronized boolean j() {
        k4 k4Var;
        boolean z = false;
        if (this.b == null) {
            return false;
        }
        if (!this.f.e() && ((k4Var = this.j) == null || !k4Var.a)) {
            return false;
        }
        k4 k4Var2 = this.j;
        boolean zA = (k4Var2 != null && k4Var2.e()) | a();
        k4 k4Var3 = this.j;
        if (k4Var3 != null && k4Var3.d()) {
            z = true;
        }
        return zA | z;
    }

    public final synchronized void k() {
        a(true);
    }

    public final void l() {
        Job job = this.h;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.h = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new a(m, this, null), 3, null);
    }

    public final String toString() {
        return this.f.toString();
    }

    public final EnumSet<?> d(int i) {
        Object obj = this.f.a.get(i);
        if (obj == null) {
            obj = null;
        } else if (!(obj instanceof EnumSet)) {
            throw new IllegalArgumentException(("Property with key " + i + " is not a " + Reflection.getOrCreateKotlinClass(EnumSet.class).getSimpleName()).toString());
        }
        return (EnumSet) obj;
    }

    public final void a(final Annotation annotation) {
        if (this.e == null) {
            this.e = annotation;
            this.f.c = new k3.a() { // from class: com.pspdfkit.internal.j3$$ExternalSyntheticLambda0
                @Override // com.pspdfkit.internal.k3.a
                public final void a(int i, Object obj, Object obj2) {
                    j3.a(this.f$0, annotation, i, obj, obj2);
                }
            };
            return;
        }
        throw new IllegalStateException("Annotation has already been set!");
    }

    public final Scale h() {
        Object obj = this.f.a.get(11002);
        if (obj == null) {
            obj = null;
        } else if (!(obj instanceof Scale)) {
            throw new IllegalArgumentException(("Property with key 11002 is not a " + Reflection.getOrCreateKotlinClass(Scale.class).getSimpleName()).toString());
        }
        return (Scale) obj;
    }

    public static final void a(j3 j3Var, Annotation annotation, int i, Object obj, Object obj2) {
        Iterator<zs> it = j3Var.g.iterator();
        it.getClass();
        while (it.hasNext()) {
            it.next().onAnnotationPropertyChange(annotation, i, obj, obj2);
        }
    }

    public final synchronized boolean a(boolean z) {
        Annotation annotation;
        o3 o3Var;
        boolean zJ = j();
        if (zJ && (this.d == null || this.b == null)) {
            this.i = true;
            return false;
        }
        if (!zJ && !this.k && !this.i) {
            return false;
        }
        NativeAnnotationManager nativeAnnotationManager = this.d;
        if (nativeAnnotationManager == null) {
            return false;
        }
        NativeAnnotation nativeAnnotation = this.b;
        if (nativeAnnotation == null) {
            return false;
        }
        nativeAnnotationManager.synchronizeAnnotationToBackend(nativeAnnotation, this.k);
        this.k = false;
        this.i = false;
        if (z && (annotation = this.e) != null && (o3Var = this.a) != null) {
            o3Var.e(annotation);
        }
        return true;
    }

    public final Action b() {
        Object obj = this.f.a.get(3000);
        if (obj == null) {
            obj = null;
        } else if (!(obj instanceof Action)) {
            throw new IllegalArgumentException(("Property with key 3000 is not a " + Reflection.getOrCreateKotlinClass(Action.class).getSimpleName()).toString());
        }
        return (Action) obj;
    }

    public final p c() {
        Object obj = this.f.a.get(3001);
        if (obj == null) {
            obj = null;
        } else if (!(obj instanceof p)) {
            throw new IllegalArgumentException(("Property with key 3001 is not a " + Reflection.getOrCreateKotlinClass(p.class).getSimpleName()).toString());
        }
        return (p) obj;
    }

    public final JSONObject e() {
        Object obj = this.f.a.get(9001);
        if (obj == null) {
            obj = null;
        } else if (!(obj instanceof JSONObject)) {
            throw new IllegalArgumentException(("Property with key 9001 is not a " + Reflection.getOrCreateKotlinClass(JSONObject.class).getSimpleName()).toString());
        }
        return (JSONObject) obj;
    }

    public final MeasurementPrecision f() {
        Object obj = this.f.a.get(11001);
        if (obj == null) {
            obj = null;
        } else if (!(obj instanceof MeasurementPrecision)) {
            throw new IllegalArgumentException(("Property with key 11001 is not a " + Reflection.getOrCreateKotlinClass(MeasurementPrecision.class).getSimpleName()).toString());
        }
        return (MeasurementPrecision) obj;
    }

    public final synchronized boolean a() {
        if (!this.f.e()) {
            return false;
        }
        AtomicInteger atomicInteger = l;
        if (atomicInteger.get() == -1) {
            atomicInteger.compareAndSet(-1, ar.b().a() ? 1 : 0);
        }
        if (atomicInteger.get() != 0) {
            yg ygVar = new yg();
            int iA = bh.a(this.f, ygVar);
            ygVar.d(ygVar.c, 4);
            ygVar.a(iA);
            ygVar.a.position(ygVar.b);
            ygVar.g = true;
            yg ygVar2 = new yg();
            int iB = bh.b(this.f, ygVar2);
            ygVar2.d(ygVar2.c, 4);
            ygVar2.a(iB);
            ygVar2.a.position(ygVar2.b);
            ygVar2.g = true;
            int i = ygVar2.b;
            int iCapacity = ygVar2.a.capacity() - ygVar2.b;
            if (!ygVar2.g) {
                throw new AssertionError("FlatBuffers: you can only access the serialized buffer after it has been finished by FlatBufferBuilder.finish().");
            }
            byte[] bArr = new byte[iCapacity];
            ygVar2.a.position(i);
            ygVar2.a.get(bArr);
            int i2 = ygVar.b;
            int iCapacity2 = ygVar.a.capacity() - ygVar.b;
            if (ygVar.g) {
                byte[] bArr2 = new byte[iCapacity2];
                ygVar.a.position(i2);
                ygVar.a.get(bArr2);
                NativeAnnotation nativeAnnotation = this.b;
                RectF updatedBoundingBox = null;
                if (nativeAnnotation == null) {
                    PdfLog.e("Nutri.AnnotationPropertyManager", "Native annotation is null, can't sync properties.", new Object[0]);
                } else {
                    NativeAnnotationManager nativeAnnotationManager = this.d;
                    if (nativeAnnotationManager == null) {
                        PdfLog.e("Nutri.AnnotationPropertyManager", "Annotation provider is null, can't sync properties.", new Object[0]);
                    } else {
                        NativeUpdatePropertiesResult nativeUpdatePropertiesResultUpdateProperties = nativeAnnotationManager.updateProperties(nativeAnnotation, bArr, bArr2);
                        nativeUpdatePropertiesResultUpdateProperties.getClass();
                        if (nativeUpdatePropertiesResultUpdateProperties.getHasError()) {
                            PdfLog.d("Nutri.AnnotationPropertyManager", "Can't update annotation properties %s: %s", this.e, nativeUpdatePropertiesResultUpdateProperties.getErrorString());
                        }
                        updatedBoundingBox = nativeUpdatePropertiesResultUpdateProperties.getUpdatedBoundingBox();
                    }
                }
                if (updatedBoundingBox != null) {
                    this.f.a(9, updatedBoundingBox, false);
                }
                this.f.a(8, new Date(), false);
                this.f.a();
                return true;
            }
            throw new AssertionError("FlatBuffers: you can only access the serialized buffer after it has been finished by FlatBufferBuilder.finish().");
        }
        throw new InvalidNutrientLicenseException("Your license does not allow annotation editing.");
    }

    public final void a(j3 j3Var, boolean z) {
        k3.a aVar;
        j3Var.getClass();
        k3 k3Var = j3Var.f;
        k3Var.getClass();
        SparseArrayCompat<Object> sparseArrayCompatM337clone = k3Var.a.m337clone();
        new LinkedHashSet();
        sparseArrayCompatM337clone.getClass();
        k3 k3Var2 = this.f;
        synchronized (k3Var2) {
            if (!k3Var2.e && (aVar = k3Var2.c) != null) {
                int size = sparseArrayCompatM337clone.size();
                for (int i = 0; i < size; i++) {
                    int iKeyAt = sparseArrayCompatM337clone.keyAt(i);
                    Object objValueAt = sparseArrayCompatM337clone.valueAt(i);
                    Object obj = k3Var2.a.get(iKeyAt);
                    if (!Intrinsics.areEqual(obj, objValueAt)) {
                        aVar.a(iKeyAt, obj, objValueAt);
                    }
                }
            }
            k3Var2.a.clear();
            int size2 = sparseArrayCompatM337clone.size();
            for (int i2 = 0; i2 < size2; i2++) {
                int iKeyAt2 = sparseArrayCompatM337clone.keyAt(i2);
                k3Var2.a.put(iKeyAt2, sparseArrayCompatM337clone.valueAt(i2));
                if (z) {
                    k3Var2.b.add(Integer.valueOf(iKeyAt2));
                    k3Var2.d = true;
                }
            }
            if (z) {
                return;
            }
            k3Var2.b();
        }
    }

    public final String g(int i) {
        Object obj = this.f.a.get(i);
        if (obj == null) {
            obj = null;
        } else if (!(obj instanceof String)) {
            throw new IllegalArgumentException(("Property with key " + i + " is not a " + Reflection.getOrCreateKotlinClass(String.class).getSimpleName()).toString());
        }
        return (String) obj;
    }

    public final int a(int i, int i2) {
        k3 k3Var = this.f;
        Object objValueOf = Integer.valueOf(i2);
        Object obj = k3Var.a.get(i);
        if (obj != null) {
            if (!(obj instanceof Integer)) {
                throw new IllegalArgumentException(("Property with key " + i + " is not a " + Reflection.getOrCreateKotlinClass(Integer.class).getSimpleName()).toString());
            }
            objValueOf = obj;
        }
        return ((Number) objValueOf).intValue();
    }

    public final float a(int i, float f) {
        k3 k3Var = this.f;
        Object objValueOf = Float.valueOf(f);
        Object obj = k3Var.a.get(i);
        if (obj != null) {
            if (!(obj instanceof Float)) {
                throw new IllegalArgumentException(("Property with key " + i + " is not a " + Reflection.getOrCreateKotlinClass(Float.class).getSimpleName()).toString());
            }
            objValueOf = obj;
        }
        return ((Number) objValueOf).floatValue();
    }

    public final boolean a(int i) {
        k3 k3Var = this.f;
        Object obj = Boolean.FALSE;
        Object obj2 = k3Var.a.get(i);
        if (obj2 != null) {
            if (!(obj2 instanceof Boolean)) {
                throw new IllegalArgumentException(("Property with key " + i + " is not a " + Reflection.getOrCreateKotlinClass(Boolean.class).getSimpleName()).toString());
            }
            obj = obj2;
        }
        return ((Boolean) obj).booleanValue();
    }

    public final Enum<?> a(int i, Enum<?> r3) {
        r3.getClass();
        Object obj = this.f.a.get(i);
        Object obj2 = r3;
        if (obj != null) {
            if (!(obj instanceof Enum)) {
                throw new IllegalArgumentException(("Property with key " + i + " is not a " + Reflection.getOrCreateKotlinClass(Enum.class).getSimpleName()).toString());
            }
            obj2 = obj;
        }
        return (Enum) obj2;
    }

    public final EdgeInsets a(EdgeInsets edgeInsets) {
        Object obj = this.f.a.get(1007);
        Object obj2 = edgeInsets;
        if (obj != null) {
            if (!(obj instanceof EdgeInsets)) {
                throw new IllegalArgumentException(("Property with key 1007 is not a " + Reflection.getOrCreateKotlinClass(EdgeInsets.class).getSimpleName()).toString());
            }
            obj2 = obj;
        }
        return (EdgeInsets) obj2;
    }
}
