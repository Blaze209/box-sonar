package sdk.pendo.io.t7;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.PixelCopy;
import android.view.Surface;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.TimeoutKt;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.s7.e1;
import sdk.pendo.io.s7.r0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000  2\u00020\u0001:\u0001\tB%\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u0014\u0012\u0006\u0010\u001a\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u001b¢\u0006\u0004\b\u001e\u0010\u001fJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0003J \u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0003J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\t\u001a\u00020\bH\u0007J)\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\fH\u0087@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\t\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\fH\u0081@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\u0011J\u0019\u0010\u0010\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\fH\u0001¢\u0006\u0004\b\u0010\u0010\u0013R\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u00148\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0019R\u0017\u0010\u0007\u001a\u00020\u001b8\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u001c\u001a\u0004\b\u0010\u0010\u001d\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {"Lsdk/pendo/io/t7/b;", "", "Landroid/view/Window;", "window", "Landroid/graphics/Bitmap;", "dest", "Landroid/view/PixelCopy$OnPixelCopyFinishedListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Landroid/view/Surface;", "surface", "Lsdk/pendo/io/s7/e1$a;", "data", "Lkotlin/Pair;", "", "b", "(Lsdk/pendo/io/s7/e1$a;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "(Lsdk/pendo/io/s7/e1$a;)Landroid/view/Surface;", "", "Ljava/util/List;", "c", "()Ljava/util/List;", "screens", "Landroid/graphics/Bitmap;", "finalBitmap", "Lsdk/pendo/io/t7/c;", "Lsdk/pendo/io/t7/c;", "()Lsdk/pendo/io/t7/c;", "<init>", "(Ljava/util/List;Landroid/graphics/Bitmap;Lsdk/pendo/io/t7/c;)V", "d", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class b {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final List<e1.a> screens;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final Bitmap finalBitmap;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final sdk.pendo.io.t7.c listener;

    /* JADX INFO: renamed from: sdk.pendo.io.t7.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.utilities.captureScreen.PixelCopyCaptureScreen$captureRootWithPixelCopy$$inlined$suspendCoroutineWithTimeout$1", f = "PixelCopyCaptureScreen.kt", i = {}, l = {14}, m = "invokeSuspend", n = {}, s = {})
    public static final class C0493b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object a;
        int b;
        final /* synthetic */ Ref.ObjectRef c;
        final /* synthetic */ e1.a d;
        final /* synthetic */ b e;
        final /* synthetic */ Bitmap f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0493b(Ref.ObjectRef objectRef, Continuation continuation, e1.a aVar, b bVar, Bitmap bitmap) {
            super(2, continuation);
            this.c = objectRef;
            this.d = aVar;
            this.e = bVar;
            this.f = bitmap;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C0493b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C0493b(this.c, continuation, this.d, this.e, this.f);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Ref.ObjectRef objectRef;
            T t;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Ref.ObjectRef objectRef2 = this.c;
                this.a = objectRef2;
                this.b = 1;
                CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(this), 1);
                cancellableContinuationImpl.initCancellability();
                d dVar = new d(cancellableContinuationImpl);
                try {
                    Window windowC = this.d.c();
                    if (windowC != null) {
                        this.e.a(windowC, this.f, dVar);
                    } else {
                        Surface surfaceB = this.e.b(this.d);
                        if (surfaceB != null && surfaceB.isValid()) {
                            this.e.a(surfaceB, this.f, dVar);
                        } else if (cancellableContinuationImpl.isActive()) {
                            cancellableContinuationImpl.resume(Boxing.boxInt(1), (Function1<? super Throwable, Unit>) null);
                        }
                    }
                } catch (Exception e) {
                    PendoLogger.e(e, e.getMessage(), "PixelCopy.request for additional root");
                    if (cancellableContinuationImpl.isActive()) {
                        cancellableContinuationImpl.resume(Boxing.boxInt(1), (Function1<? super Throwable, Unit>) null);
                    }
                }
                Object result = cancellableContinuationImpl.getResult();
                if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(this);
                }
                if (result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                objectRef = objectRef2;
                t = result;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                objectRef = (Ref.ObjectRef) this.a;
                ResultKt.throwOnFailure(obj);
                t = obj;
            }
            objectRef.element = t;
            return Unit.INSTANCE;
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sdk.pendo.io.utilities.captureScreen.PixelCopyCaptureScreen", f = "PixelCopyCaptureScreen.kt", i = {0, 0, 0, 0, 0}, l = {182}, m = "captureRootWithPixelCopy$pendoIO_release", n = {"this", "data", "winFrame", "tempBitmap", "finalValue$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
    static final class c extends ContinuationImpl {
        Object a;
        Object b;
        Object c;
        Object d;
        Object e;
        /* synthetic */ Object f;
        int h;

        c(Continuation<? super c> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f = obj;
            this.h |= Integer.MIN_VALUE;
            return b.this.a(null, this);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "", "onPixelCopyFinished"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class d implements PixelCopy.OnPixelCopyFinishedListener {
        final /* synthetic */ CancellableContinuation<Integer> a;

        /* JADX WARN: Multi-variable type inference failed */
        d(CancellableContinuation<? super Integer> cancellableContinuation) {
            this.a = cancellableContinuation;
        }

        @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
        public final void onPixelCopyFinished(int i) {
            if (this.a.isActive()) {
                this.a.resume(Integer.valueOf(i), (Function1<? super Throwable, Unit>) null);
            }
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.utilities.captureScreen.PixelCopyCaptureScreen$captureScreenToBitmap$1", f = "PixelCopyCaptureScreen.kt", i = {0, 1, 1}, l = {29, 35}, m = "invokeSuspend", n = {"iterator", "iterator", "data"}, s = {"L$0", "L$0", "L$1"})
    static final class e extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object a;
        Object b;
        int c;

        e(Continuation<? super e> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((e) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return b.this.new e(continuation);
        }

        /* JADX WARN: Code duplicated, block: B:16:0x0051  */
        /* JADX WARN: Code duplicated, block: B:22:0x007b  */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x0047, code lost:
        
            if (r6.b(r4, r5) == r0) goto L18;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0064, code lost:
        
            if (r6 == r0) goto L18;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0066, code lost:
        
            return r0;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0064 -> B:19:0x0067). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r5.c
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L2a
                if (r1 == r3) goto L22
                if (r1 != r2) goto L1a
                java.lang.Object r1 = r5.b
                sdk.pendo.io.s7.e1$a r1 = (sdk.pendo.io.s7.e1.a) r1
                java.lang.Object r3 = r5.a
                java.util.Iterator r3 = (java.util.Iterator) r3
                kotlin.ResultKt.throwOnFailure(r6)
                goto L67
            L1a:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L22:
                java.lang.Object r1 = r5.a
                java.util.Iterator r1 = (java.util.Iterator) r1
                kotlin.ResultKt.throwOnFailure(r6)
                goto L4a
            L2a:
                kotlin.ResultKt.throwOnFailure(r6)
                sdk.pendo.io.t7.b r6 = sdk.pendo.io.t7.b.this
                java.util.List r6 = r6.c()
                java.util.Iterator r1 = r6.iterator()
                sdk.pendo.io.t7.b r6 = sdk.pendo.io.t7.b.this
                java.lang.Object r4 = r1.next()
                sdk.pendo.io.s7.e1$a r4 = (sdk.pendo.io.s7.e1.a) r4
                r5.a = r1
                r5.c = r3
                java.lang.Object r6 = r6.b(r4, r5)
                if (r6 != r0) goto L4a
                goto L66
            L4a:
                r3 = r1
            L4b:
                boolean r6 = r3.hasNext()
                if (r6 == 0) goto L7b
                java.lang.Object r6 = r3.next()
                r1 = r6
                sdk.pendo.io.s7.e1$a r1 = (sdk.pendo.io.s7.e1.a) r1
                sdk.pendo.io.t7.b r6 = sdk.pendo.io.t7.b.this
                r5.a = r3
                r5.b = r1
                r5.c = r2
                java.lang.Object r6 = r6.a(r1, r5)
                if (r6 != r0) goto L67
            L66:
                return r0
            L67:
                java.lang.Boolean r6 = (java.lang.Boolean) r6
                boolean r6 = r6.booleanValue()
                if (r6 != 0) goto L4b
                sdk.pendo.io.t7.a$a r6 = sdk.pendo.io.t7.a.INSTANCE
                sdk.pendo.io.t7.b r4 = sdk.pendo.io.t7.b.this
                android.graphics.Bitmap r4 = sdk.pendo.io.t7.b.a(r4)
                r6.a(r1, r4)
                goto L4b
            L7b:
                sdk.pendo.io.t7.b r6 = sdk.pendo.io.t7.b.this
                sdk.pendo.io.t7.c r6 = r6.getListener()
                sdk.pendo.io.t7.b r5 = sdk.pendo.io.t7.b.this
                android.graphics.Bitmap r5 = sdk.pendo.io.t7.b.a(r5)
                r6.a(r5)
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.t7.b.e.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.utilities.captureScreen.PixelCopyCaptureScreen$execute$$inlined$suspendCoroutineWithTimeout$1", f = "PixelCopyCaptureScreen.kt", i = {}, l = {14}, m = "invokeSuspend", n = {}, s = {})
    public static final class f extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object a;
        int b;
        final /* synthetic */ Ref.ObjectRef c;
        final /* synthetic */ e1.a d;
        final /* synthetic */ b e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Ref.ObjectRef objectRef, Continuation continuation, e1.a aVar, b bVar) {
            super(2, continuation);
            this.c = objectRef;
            this.d = aVar;
            this.e = bVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((f) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new f(this.c, continuation, this.d, this.e);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Ref.ObjectRef objectRef;
            T t;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Ref.ObjectRef objectRef2 = this.c;
                this.a = objectRef2;
                this.b = 1;
                CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(this), 1);
                cancellableContinuationImpl.initCancellability();
                try {
                    PixelCopy.request(sdk.pendo.io.d6.c.h().a().getWindow(), this.d.b(), this.e.finalBitmap, new h(cancellableContinuationImpl, this.e), new Handler(Looper.getMainLooper()));
                } catch (Exception e) {
                    PendoLogger.e(e, e.getMessage(), "PixelCopy.request");
                    if (cancellableContinuationImpl.isActive()) {
                        cancellableContinuationImpl.resume(new Pair(Boxing.boxInt(1), this.e.finalBitmap), (Function1<? super Throwable, Unit>) null);
                    }
                }
                Object result = cancellableContinuationImpl.getResult();
                if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(this);
                }
                if (result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                objectRef = objectRef2;
                t = result;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                objectRef = (Ref.ObjectRef) this.a;
                ResultKt.throwOnFailure(obj);
                t = obj;
            }
            objectRef.element = t;
            return Unit.INSTANCE;
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sdk.pendo.io.utilities.captureScreen.PixelCopyCaptureScreen", f = "PixelCopyCaptureScreen.kt", i = {0}, l = {182}, m = "execute", n = {"finalValue$iv"}, s = {"L$0"})
    static final class g extends ContinuationImpl {
        Object a;
        /* synthetic */ Object b;
        int d;

        g(Continuation<? super g> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return b.this.b(null, this);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "copyResult", "", "onPixelCopyFinished"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class h implements PixelCopy.OnPixelCopyFinishedListener {
        final /* synthetic */ CancellableContinuation<Pair<Integer, Bitmap>> a;
        final /* synthetic */ b b;

        /* JADX WARN: Multi-variable type inference failed */
        h(CancellableContinuation<? super Pair<Integer, Bitmap>> cancellableContinuation, b bVar) {
            this.a = cancellableContinuation;
            this.b = bVar;
        }

        @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
        public final void onPixelCopyFinished(int i) {
            if (i != 0) {
                PendoLogger.e("PixelCopyCaptureScreen -> PixelCopyFinished: " + i, new Object[0]);
            }
            if (this.a.isActive()) {
                this.a.resume(new Pair<>(Integer.valueOf(i), this.b.finalBitmap), (Function1<? super Throwable, Unit>) null);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(List<? extends e1.a> screens, Bitmap finalBitmap, sdk.pendo.io.t7.c listener) {
        Intrinsics.checkNotNullParameter(screens, "screens");
        Intrinsics.checkNotNullParameter(finalBitmap, "finalBitmap");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.screens = screens;
        this.finalBitmap = finalBitmap;
        this.listener = listener;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    public final Object b(e1.a aVar, Continuation<? super Pair<Integer, Bitmap>> continuation) {
        g gVar;
        Ref.ObjectRef objectRef;
        if (continuation instanceof g) {
            gVar = (g) continuation;
            int i = gVar.d;
            if ((i & Integer.MIN_VALUE) != 0) {
                gVar.d = i - Integer.MIN_VALUE;
            } else {
                gVar = new g(continuation);
            }
        } else {
            gVar = new g(continuation);
        }
        Object obj = gVar.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = gVar.d;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            f fVar = new f(objectRef2, null, aVar, this);
            gVar.a = objectRef2;
            gVar.d = 1;
            if (TimeoutKt.withTimeoutOrNull(5000L, fVar, gVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef = objectRef2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef = (Ref.ObjectRef) gVar.a;
            ResultKt.throwOnFailure(obj);
        }
        return (Pair) objectRef.element;
    }

    public final List<e1.a> c() {
        return this.screens;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final sdk.pendo.io.t7.c getListener() {
        return this.listener;
    }

    public final Surface b(e1.a data) {
        View view;
        ViewParent parent;
        Intrinsics.checkNotNullParameter(data, "data");
        WeakReference<View> weakReference = data.a;
        if (weakReference == null || (view = weakReference.get()) == null || (parent = view.getParent()) == null) {
            return null;
        }
        Object objA = r0.a("mSurface", parent);
        if (objA instanceof Surface) {
            return (Surface) objA;
        }
        return null;
    }

    private final void a(e1.a data) {
        WindowManager.LayoutParams layoutParamsA = data.a();
        if (layoutParamsA != null && (layoutParamsA.flags & 2) == 2) {
            new Canvas(this.finalBitmap).drawARGB((int) (255 * layoutParamsA.dimAmount), 0, 0, 0);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    public final Object a(e1.a aVar, Continuation<? super Boolean> continuation) {
        c cVar;
        Rect rect;
        Ref.ObjectRef objectRef;
        e1.a aVar2;
        b bVar;
        Bitmap bitmap;
        if (continuation instanceof c) {
            cVar = (c) continuation;
            int i = cVar.h;
            if ((i & Integer.MIN_VALUE) != 0) {
                cVar.h = i - Integer.MIN_VALUE;
            } else {
                cVar = new c(continuation);
            }
        } else {
            cVar = new c(continuation);
        }
        Object obj = cVar.f;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = cVar.h;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Rect rectB = aVar.b();
            if (rectB == null) {
                return Boxing.boxBoolean(false);
            }
            int iWidth = rectB.width();
            int iHeight = rectB.height();
            if (iWidth <= 0 || iHeight <= 0) {
                return Boxing.boxBoolean(false);
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iWidth, iHeight, Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            C0493b c0493b = new C0493b(objectRef2, null, aVar, this, bitmapCreateBitmap);
            cVar.a = this;
            cVar.b = aVar;
            cVar.c = rectB;
            cVar.d = bitmapCreateBitmap;
            cVar.e = objectRef2;
            cVar.h = 1;
            if (TimeoutKt.withTimeoutOrNull(5000L, c0493b, cVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
            rect = rectB;
            objectRef = objectRef2;
            aVar2 = aVar;
            bVar = this;
            bitmap = bitmapCreateBitmap;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef = (Ref.ObjectRef) cVar.e;
            bitmap = (Bitmap) cVar.d;
            rect = (Rect) cVar.c;
            aVar2 = (e1.a) cVar.b;
            bVar = (b) cVar.a;
            ResultKt.throwOnFailure(obj);
        }
        Integer num = (Integer) objectRef.element;
        if (num == null || num.intValue() != 0) {
            bitmap.recycle();
            return Boxing.boxBoolean(false);
        }
        bVar.a(aVar2);
        new Canvas(bVar.finalBitmap).drawBitmap(bitmap, rect.left, rect.top, (Paint) null);
        bitmap.recycle();
        return Boxing.boxBoolean(true);
    }

    public final void a() {
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new e(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(Surface surface, Bitmap dest, PixelCopy.OnPixelCopyFinishedListener listener) {
        PixelCopy.request(surface, dest, listener, new Handler(Looper.getMainLooper()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(Window window, Bitmap dest, PixelCopy.OnPixelCopyFinishedListener listener) {
        PixelCopy.request(window, dest, listener, new Handler(Looper.getMainLooper()));
    }
}
