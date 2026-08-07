package com.pspdfkit.internal;

import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.CircleAnnotation;
import com.pspdfkit.annotations.FileAnnotation;
import com.pspdfkit.annotations.FreeTextAnnotation;
import com.pspdfkit.annotations.HighlightAnnotation;
import com.pspdfkit.annotations.InkAnnotation;
import com.pspdfkit.annotations.LineAnnotation;
import com.pspdfkit.annotations.LinkAnnotation;
import com.pspdfkit.annotations.NoteAnnotation;
import com.pspdfkit.annotations.PolygonAnnotation;
import com.pspdfkit.annotations.PolylineAnnotation;
import com.pspdfkit.annotations.RedactionAnnotation;
import com.pspdfkit.annotations.RichMediaAnnotation;
import com.pspdfkit.annotations.ScreenAnnotation;
import com.pspdfkit.annotations.SoundAnnotation;
import com.pspdfkit.annotations.SquareAnnotation;
import com.pspdfkit.annotations.SquigglyAnnotation;
import com.pspdfkit.annotations.StampAnnotation;
import com.pspdfkit.annotations.StrikeOutAnnotation;
import com.pspdfkit.annotations.UnderlineAnnotation;
import com.pspdfkit.annotations.UnknownAnnotation;
import com.pspdfkit.annotations.WidgetAnnotation;
import com.pspdfkit.internal.jni.NativeAnnotation;
import com.pspdfkit.internal.jni.NativeAnnotationManager;
import com.pspdfkit.internal.jni.NativeAnnotationType;
import com.pspdfkit.internal.jni.NativeLicenseFeatures;
import kotlin.ResultKt;
import kotlin.Unit;
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
@DebugMetadata(c = "com.pspdfkit.internal.annotations.AnnotationProviderImpl$createAnnotationForNativeAnnotation$2", f = "AnnotationProviderImpl.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {1115}, m = "invokeSuspend", n = {"flatbuffer", "properties", "type", "annotation", "$this$withLock_u24default$iv", "isAttached", "markDirty", "$i$f$withLock"}, nl = {1116}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "I$2"}, v = 2)
public final class q3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Annotation>, Object> {
    public Object a;
    public Object b;
    public Object c;
    public Annotation d;
    public Mutex e;
    public o3 f;
    public NativeAnnotation g;
    public int h;
    public boolean i;
    public int j;
    public final /* synthetic */ o3 k;
    public final /* synthetic */ NativeAnnotation l;
    public final /* synthetic */ boolean m;

    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[AnnotationType.values().length];
            try {
                iArr[AnnotationType.LINK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AnnotationType.WIDGET.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AnnotationType.NOTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AnnotationType.SQUIGGLY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AnnotationType.UNDERLINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[AnnotationType.HIGHLIGHT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[AnnotationType.STRIKEOUT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[AnnotationType.FREETEXT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[AnnotationType.INK.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[AnnotationType.STAMP.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[AnnotationType.FILE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[AnnotationType.SOUND.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[AnnotationType.LINE.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[AnnotationType.POLYGON.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[AnnotationType.POLYLINE.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[AnnotationType.SQUARE.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[AnnotationType.CIRCLE.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[AnnotationType.RICHMEDIA.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[AnnotationType.SCREEN.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[AnnotationType.REDACT.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q3(o3 o3Var, NativeAnnotation nativeAnnotation, boolean z, Continuation<? super q3> continuation) {
        super(2, continuation);
        this.k = o3Var;
        this.l = nativeAnnotation;
        this.m = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new q3(this.k, this.l, this.m, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Annotation> continuation) {
        return ((q3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Annotation linkAnnotation;
        int i;
        o3 o3Var;
        Annotation annotation;
        Mutex mutex;
        NativeAnnotation nativeAnnotation;
        boolean z;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.j;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            byte[] properties = this.k.d.getProperties(this.l);
            if (properties == null || properties.length == 0) {
                return null;
            }
            j3 j3Var = new j3();
            NativeAnnotation nativeAnnotation2 = this.l;
            o3 o3Var2 = this.k;
            nativeAnnotation2.getClass();
            j3Var.b = nativeAnnotation2;
            j3Var.a = o3Var2;
            j3Var.d = o3Var2.d;
            j3Var.c = false;
            j3Var.g();
            int i3 = this.l.getAnnotationId() != null ? 1 : 0;
            boolean z2 = i3 ^ 1;
            NativeAnnotationType annotationType = this.l.getAnnotationType();
            annotationType.getClass();
            AnnotationType annotationTypeA = mr.a(annotationType);
            switch (a.a[annotationTypeA.ordinal()]) {
                case 1:
                    linkAnnotation = new LinkAnnotation(j3Var, z2);
                    break;
                case 2:
                    linkAnnotation = new WidgetAnnotation(j3Var, z2, this.k.a.q.findImageResource(this.l));
                    break;
                case 3:
                    linkAnnotation = new NoteAnnotation(j3Var, z2);
                    break;
                case 4:
                    linkAnnotation = new SquigglyAnnotation(j3Var, z2);
                    break;
                case 5:
                    linkAnnotation = new UnderlineAnnotation(j3Var, z2);
                    break;
                case 6:
                    linkAnnotation = new HighlightAnnotation(j3Var, z2);
                    break;
                case 7:
                    linkAnnotation = new StrikeOutAnnotation(j3Var, z2);
                    break;
                case 8:
                    linkAnnotation = new FreeTextAnnotation(j3Var, z2);
                    break;
                case 9:
                    linkAnnotation = new InkAnnotation(j3Var, z2);
                    break;
                case 10:
                    linkAnnotation = new StampAnnotation(j3Var, z2, this.k.a.q.findImageResource(this.l));
                    break;
                case 11:
                    linkAnnotation = new FileAnnotation(j3Var, z2, this.k.a.q.findResource(this.l));
                    break;
                case 12:
                    linkAnnotation = new SoundAnnotation(j3Var, z2, this.k.a.q.findResource(this.l));
                    break;
                case 13:
                    linkAnnotation = new LineAnnotation(j3Var, z2);
                    break;
                case 14:
                    linkAnnotation = new PolygonAnnotation(j3Var, z2);
                    break;
                case 15:
                    linkAnnotation = new PolylineAnnotation(j3Var, z2);
                    break;
                case 16:
                    linkAnnotation = new SquareAnnotation(j3Var, z2);
                    break;
                case 17:
                    linkAnnotation = new CircleAnnotation(j3Var, z2);
                    break;
                case 18:
                    linkAnnotation = new RichMediaAnnotation(j3Var, z2, this.k.a.q.findResource(this.l));
                    break;
                case 19:
                    linkAnnotation = new ScreenAnnotation(j3Var, z2, this.k.a.q.findResource(this.l));
                    break;
                case 20:
                    linkAnnotation = !ar.b().a(NativeLicenseFeatures.REDACTION) ? null : new RedactionAnnotation(j3Var, z2);
                    break;
                default:
                    linkAnnotation = new UnknownAnnotation(this.l.getAnnotationType(), j3Var, z2);
                    break;
            }
            if (linkAnnotation == null) {
                return null;
            }
            o3 o3Var3 = this.k;
            Mutex mutex2 = o3Var3.l;
            NativeAnnotation nativeAnnotation3 = this.l;
            boolean z3 = this.m;
            this.a = SpillingKt.nullOutSpilledVariable(properties);
            this.b = SpillingKt.nullOutSpilledVariable(j3Var);
            this.c = SpillingKt.nullOutSpilledVariable(annotationTypeA);
            this.d = linkAnnotation;
            this.e = mutex2;
            this.f = o3Var3;
            this.g = nativeAnnotation3;
            this.h = i3;
            this.i = z3;
            this.j = 1;
            if (mutex2.lock(null, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            i = i3;
            o3Var = o3Var3;
            annotation = linkAnnotation;
            mutex = mutex2;
            nativeAnnotation = nativeAnnotation3;
            z = z3;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            z = this.i;
            i = this.h;
            nativeAnnotation = this.g;
            o3Var = this.f;
            mutex = this.e;
            annotation = this.d;
            ResultKt.throwOnFailure(obj);
        }
        try {
            if (i != 0) {
                ir irVar = o3Var.f;
                NativeAnnotationManager nativeAnnotationManager = o3Var.d;
                irVar.getClass();
                nativeAnnotation.getClass();
                nativeAnnotationManager.getClass();
                kr krVar = new kr(irVar, nativeAnnotationManager, nativeAnnotation);
                irVar.a.put(Long.valueOf(krVar.c), nativeAnnotation);
                annotation.getInternal().onAttachToDocument(o3Var.a, krVar);
            } else if (z) {
                annotation.getInternal().setDetachedAnnotationLookupKey(Boxing.boxInt(o3Var.d.holdAnnotation(nativeAnnotation)), o3Var.d);
            }
            Unit unit = Unit.INSTANCE;
            mutex.unlock(null);
            NativeAnnotation nativeAnnotation4 = this.l;
            if (iw.b.get() < 10000) {
                nativeAnnotation4.setPlatformAnnotation(new iw(annotation));
            }
            return annotation;
        } catch (Throwable th) {
            mutex.unlock(null);
            throw th;
        }
    }
}
