package sdk.pendo.io.u5;

import android.app.Activity;
import android.graphics.Bitmap;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import org.json.JSONArray;
import org.json.JSONObject;
import sdk.pendo.io.actions.ActivationManager;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.s7.t0;
import sdk.pendo.io.sdk.flutter.FlutterScreenManager;
import sdk.pendo.io.sdk.react.PlatformStateManager;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0007B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000b¢\u0006\u0004\b3\u0010\u0010J\u001b\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016R\"\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0016\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0007\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00102\u001a\u00020/8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u00101\u0082\u0002\u0004\n\u0002\b\u0019¨\u00064"}, d2 = {"Lsdk/pendo/io/u5/a;", "Lkotlinx/coroutines/CoroutineScope;", "Lsdk/pendo/io/t7/c;", "Lsdk/pendo/io/w5/a;", "Landroid/app/Activity;", "activity", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Landroid/app/Activity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/graphics/Bitmap;", "bitmap", "Lsdk/pendo/io/u5/a$a;", "Lsdk/pendo/io/u5/a$a;", "getListener", "()Lsdk/pendo/io/u5/a$a;", "setListener", "(Lsdk/pendo/io/u5/a$a;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lsdk/pendo/io/x6/d;", "b", "Lkotlin/Lazy;", "()Lsdk/pendo/io/x6/d;", "screenManager", "", "c", "Ljava/lang/String;", "TAG", "Lorg/json/JSONObject;", "d", "Lorg/json/JSONObject;", ActivationManager.SCREEN_DATA_KEY, "Lorg/json/JSONArray;", "e", "Lorg/json/JSONArray;", "viewTreeJSON", "Lkotlinx/coroutines/Job;", "f", "Lkotlinx/coroutines/Job;", "job", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "g", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "coroutineExceptionHandler", "Lsdk/pendo/io/o3/b;", CmcdData.STREAMING_FORMAT_HLS, "Lsdk/pendo/io/o3/b;", "prepareScreenDataForCaptureDisposable", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "<init>", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class a implements CoroutineScope, sdk.pendo.io.t7.c, sdk.pendo.io.w5.a {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private InterfaceC0496a listener;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final Lazy screenManager;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final String TAG;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private JSONObject retroactiveScreenData;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private JSONArray viewTreeJSON;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private Job job;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final CoroutineExceptionHandler coroutineExceptionHandler;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private sdk.pendo.io.o3.b prepareScreenDataForCaptureDisposable;

    /* JADX INFO: renamed from: sdk.pendo.io.u5.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0004"}, d2 = {"Lsdk/pendo/io/u5/a$a;", "", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    public interface InterfaceC0496a {
        void a();
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.async.CaptureScreenJob$doInBackground$2", f = "CaptureScreenJob.kt", i = {}, l = {67, 69}, m = "invokeSuspend", n = {}, s = {})
    static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object a;
        int b;
        final /* synthetic */ Activity d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Activity activity, Continuation<? super b> continuation) {
            super(2, continuation);
            this.d = activity;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return a.this.new b(this.d, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x0066, code lost:
        
            if (r6.generateScreenshotBitmap(r1, r3, r5) == r0) goto L22;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r5.b
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L22
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.ResultKt.throwOnFailure(r6)     // Catch: java.lang.Exception -> L69
                goto L75
            L12:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L1a:
                java.lang.Object r1 = r5.a
                sdk.pendo.io.u5.a r1 = (sdk.pendo.io.u5.a) r1
                kotlin.ResultKt.throwOnFailure(r6)     // Catch: java.lang.Exception -> L69
                goto L41
            L22:
                kotlin.ResultKt.throwOnFailure(r6)
                sdk.pendo.io.u5.a r6 = sdk.pendo.io.u5.a.this     // Catch: java.lang.Exception -> L69
                sdk.pendo.io.o3.b r6 = sdk.pendo.io.u5.a.a(r6)     // Catch: java.lang.Exception -> L69
                if (r6 == 0) goto L30
                r6.dispose()     // Catch: java.lang.Exception -> L69
            L30:
                sdk.pendo.io.u5.a r1 = sdk.pendo.io.u5.a.this     // Catch: java.lang.Exception -> L69
                sdk.pendo.io.x6.d r6 = sdk.pendo.io.u5.a.b(r1)     // Catch: java.lang.Exception -> L69
                r5.a = r1     // Catch: java.lang.Exception -> L69
                r5.b = r3     // Catch: java.lang.Exception -> L69
                java.lang.Object r6 = r6.getScreenDataForCapture(r5)     // Catch: java.lang.Exception -> L69
                if (r6 != r0) goto L41
                goto L68
            L41:
                org.json.JSONObject r6 = (org.json.JSONObject) r6     // Catch: java.lang.Exception -> L69
                sdk.pendo.io.u5.a.a(r1, r6)     // Catch: java.lang.Exception -> L69
                sdk.pendo.io.u5.a r6 = sdk.pendo.io.u5.a.this     // Catch: java.lang.Exception -> L69
                sdk.pendo.io.x6.d r1 = sdk.pendo.io.u5.a.b(r6)     // Catch: java.lang.Exception -> L69
                org.json.JSONArray r1 = r1.getViewTreeDataForCapture()     // Catch: java.lang.Exception -> L69
                sdk.pendo.io.u5.a.a(r6, r1)     // Catch: java.lang.Exception -> L69
                sdk.pendo.io.u5.a r6 = sdk.pendo.io.u5.a.this     // Catch: java.lang.Exception -> L69
                sdk.pendo.io.x6.d r6 = sdk.pendo.io.u5.a.b(r6)     // Catch: java.lang.Exception -> L69
                android.app.Activity r1 = r5.d     // Catch: java.lang.Exception -> L69
                sdk.pendo.io.u5.a r3 = sdk.pendo.io.u5.a.this     // Catch: java.lang.Exception -> L69
                r4 = 0
                r5.a = r4     // Catch: java.lang.Exception -> L69
                r5.b = r2     // Catch: java.lang.Exception -> L69
                java.lang.Object r5 = r6.generateScreenshotBitmap(r1, r3, r5)     // Catch: java.lang.Exception -> L69
                if (r5 != r0) goto L75
            L68:
                return r0
            L69:
                r6 = move-exception
                sdk.pendo.io.u5.a r5 = sdk.pendo.io.u5.a.this
                java.lang.String r5 = sdk.pendo.io.u5.a.c(r5)
                java.lang.String r0 = "Screen capture background operation"
                sdk.pendo.io.logging.PendoLogger.e(r5, r0, r6)
            L75:
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.u5.a.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lsdk/pendo/io/s7/t0;", "kotlin.jvm.PlatformType", "it", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Lsdk/pendo/io/s7/t0;)V"}, k = 3, mv = {1, 9, 0})
    static final class c extends Lambda implements Function1<t0, Unit> {
        final /* synthetic */ Activity b;

        /* JADX INFO: renamed from: sdk.pendo.io.u5.a$c$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
        @DebugMetadata(c = "sdk.pendo.io.async.CaptureScreenJob$executeTask$1$1", f = "CaptureScreenJob.kt", i = {}, l = {53}, m = "invokeSuspend", n = {}, s = {})
        static final class C0497a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int a;
            final /* synthetic */ a b;
            final /* synthetic */ Activity c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0497a(a aVar, Activity activity, Continuation<? super C0497a> continuation) {
                super(2, continuation);
                this.b = aVar;
                this.c = activity;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C0497a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C0497a(this.b, this.c, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    a aVar = this.b;
                    Activity activity = this.c;
                    this.a = 1;
                    if (aVar.a(activity, this) == coroutine_suspended) {
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
        c(Activity activity) {
            super(1);
            this.b = activity;
        }

        public final void a(t0 t0Var) {
            BuildersKt__Builders_commonKt.launch$default(a.this, null, null, new C0497a(a.this, this.b, null), 3, null);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(t0 t0Var) {
            a(t0Var);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.async.CaptureScreenJob$executeTask$2", f = "CaptureScreenJob.kt", i = {}, l = {56}, m = "invokeSuspend", n = {}, s = {})
    static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ Activity c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Activity activity, Continuation<? super d> continuation) {
            super(2, continuation);
            this.c = activity;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return a.this.new d(this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                a aVar = a.this;
                Activity activity = this.c;
                this.a = 1;
                if (aVar.a(activity, this) == coroutine_suspended) {
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

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "handleException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0})
    public static final class e extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(CoroutineExceptionHandler.Companion companion, a aVar) {
            super(companion);
            this.a = aVar;
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(CoroutineContext context, Throwable exception) {
            PendoLogger.e(this.a.TAG, "CoroutineExceptionHandler caught exception", exception, Boolean.TRUE);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\u0004\u001a\u00028\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "invoke", "()Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    public static final class f extends Lambda implements Function0<sdk.pendo.io.x6.d> {
        final /* synthetic */ sdk.pendo.io.v2.a a;
        final /* synthetic */ sdk.pendo.io.d3.a b;
        final /* synthetic */ Function0 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(sdk.pendo.io.v2.a aVar, sdk.pendo.io.d3.a aVar2, Function0 function0) {
            super(0);
            this.a = aVar;
            this.b = aVar2;
            this.c = function0;
        }

        /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object, sdk.pendo.io.x6.d] */
        @Override // kotlin.jvm.functions.Function0
        public final sdk.pendo.io.x6.d invoke() {
            sdk.pendo.io.v2.a aVar = this.a;
            return (aVar instanceof sdk.pendo.io.v2.b ? ((sdk.pendo.io.v2.b) aVar).getScope() : aVar.getKoin().getScopeRegistry().getRootScope()).b(Reflection.getOrCreateKotlinClass(sdk.pendo.io.x6.d.class), this.b, this.c);
        }
    }

    public a(InterfaceC0496a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
        this.screenManager = LazyKt.lazy(sdk.pendo.io.i3.b.a.a(), (Function0) new f(this, null, null));
        this.TAG = "CaptureScreenJob";
        this.job = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
        this.coroutineExceptionHandler = new e(CoroutineExceptionHandler.INSTANCE, this);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return Dispatchers.getMain().plus(this.job).plus(this.coroutineExceptionHandler);
    }

    @Override // sdk.pendo.io.v2.a
    public sdk.pendo.io.u2.a getKoin() {
        return sdk.pendo.io.w5.a.C0510a.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object a(Activity activity, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new b(activity, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    public final void a(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (!PlatformStateManager.INSTANCE.isFlutterCodelessApp()) {
            BuildersKt__Builders_commonKt.launch$default(this, null, null, new d(activity, null), 3, null);
            return;
        }
        sdk.pendo.io.x6.d dVarA = a();
        Intrinsics.checkNotNull(dVarA, "null cannot be cast to non-null type sdk.pendo.io.sdk.flutter.FlutterScreenManager");
        sdk.pendo.io.j4.b<t0> bVarC = ((FlutterScreenManager) dVarA).c();
        final c cVar = new c(activity);
        this.prepareScreenDataForCaptureDisposable = bVarC.b(new sdk.pendo.io.q3.e() { // from class: sdk.pendo.io.u5.a$$ExternalSyntheticLambda0
            @Override // sdk.pendo.io.q3.e
            public final void accept(Object obj) {
                a.a(cVar, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final sdk.pendo.io.x6.d a() {
        return (sdk.pendo.io.x6.d) this.screenManager.getValue();
    }

    @Override // sdk.pendo.io.t7.c
    public void a(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        sdk.pendo.io.l6.a.a(this.retroactiveScreenData, this.viewTreeJSON, bitmap);
        this.listener.a();
    }
}
