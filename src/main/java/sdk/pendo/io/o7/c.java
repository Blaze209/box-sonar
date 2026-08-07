package sdk.pendo.io.o7;

import android.app.Activity;
import android.content.res.Resources;
import android.view.OrientationEventListener;
import androidx.media3.exoplayer.upstream.CmcdData;
import io.split.android.client.service.ServiceConstants;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.sync.Mutex;
import org.json.JSONArray;
import sdk.pendo.io.Pendo;
import sdk.pendo.io.h7.h;
import sdk.pendo.io.h7.m;
import sdk.pendo.io.h7.p;
import sdk.pendo.io.h7.s;
import sdk.pendo.io.h7.u;
import sdk.pendo.io.h7.x;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.SessionData;
import sdk.pendo.io.sdk.flutter.FlutterScreenManager;
import sdk.pendo.io.sdk.flutter.IFlutterBridge;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 02\u00020\u0001:\u0002\u0007\rB)\u0012\u0006\u0010*\u001a\u00020\u0003\u0012\u0006\u0010+\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\b\b\u0002\u0010-\u001a\u00020,¢\u0006\u0004\b.\u0010/J \u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0002H\u0002J+\u0010\u0007\u001a\u00020\b2\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0002H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\tJ\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\f\u0010\u0007\u001a\u00020\u000e*\u00020\u000eH\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J+\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR*\u0010\u001f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u001b\u0010)\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\u0082\u0002\u0004\n\u0002\b\u0019¨\u00061"}, d2 = {"Lsdk/pendo/io/o7/c;", "Lsdk/pendo/io/o7/a;", "", "", "", "srEventData", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/app/Activity;", "activity", "c", "b", "", "Lsdk/pendo/io/models/SessionData;", "data", "Lsdk/pendo/io/h7/m;", "config", "(Landroid/app/Activity;Lsdk/pendo/io/models/SessionData;Lsdk/pendo/io/h7/m;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lsdk/pendo/io/p5/a;", "p", "Lsdk/pendo/io/p5/a;", "pendoComponents", "Lsdk/pendo/io/sdk/flutter/IFlutterBridge;", "q", "Lsdk/pendo/io/sdk/flutter/IFlutterBridge;", Pendo.PendoOptions.FLUTTER_BRIDGE, "Lkotlinx/coroutines/flow/MutableSharedFlow;", "r", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "onFlutterEventFlow", "Landroid/view/OrientationEventListener;", "s", "Landroid/view/OrientationEventListener;", "orientationChangeListener", "Lsdk/pendo/io/o7/b;", "t", "Lkotlin/Lazy;", "n", "()Lsdk/pendo/io/o7/b;", "flutterCallbacksListener", ServiceConstants.WORKER_PARAM_API_KEY, "baseUrl", "Lsdk/pendo/io/z6/b;", "dispatcherProvider", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lsdk/pendo/io/p5/a;Lsdk/pendo/io/z6/b;)V", "u", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class c extends a {

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    private final sdk.pendo.io.p5.a pendoComponents;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    private final IFlutterBridge flutterBridge;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    private final MutableSharedFlow<Map<String, Object>> onFlutterEventFlow;

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    private OrientationEventListener orientationChangeListener;

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    private final Lazy flutterCallbacksListener;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J8\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0002J0\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0002J>\u0010\u000b\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002¨\u0006\u0012"}, d2 = {"Lsdk/pendo/io/o7/c$b;", "", "", "", "srEventData", "", "timestamp", "retroactiveScreenId", "Lsdk/pendo/io/h7/p;", "displayData", "Lsdk/pendo/io/h7/f;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/h7/h;", "", "eventType", "Lsdk/pendo/io/h7/u;", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    private static final class b {
        public static final b a = new b();

        private b() {
        }

        public final u a(int eventType, long timestamp, String retroactiveScreenId, p displayData, Map<String, ? extends Object> srEventData) {
            Intrinsics.checkNotNullParameter(retroactiveScreenId, "retroactiveScreenId");
            Intrinsics.checkNotNullParameter(displayData, "displayData");
            Intrinsics.checkNotNullParameter(srEventData, "srEventData");
            if (eventType == x.FULL_SNAPSHOT.getValue()) {
                return a(srEventData, timestamp, retroactiveScreenId, displayData);
            }
            if (eventType == x.INCREMENTAL_SNAPSHOT.getValue()) {
                return a(srEventData, timestamp, retroactiveScreenId);
            }
            PendoLogger.w("SRFlutterManager", "FlutterEventStrategyFactory not valid for evenType " + eventType);
            return null;
        }

        private final sdk.pendo.io.h7.f a(Map<String, ? extends Object> srEventData, long timestamp, String retroactiveScreenId, p displayData) {
            try {
                Object obj = srEventData.get("data");
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
                Object obj2 = ((Map) obj).get("node");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
                Object obj3 = ((Map) obj2).get("childNodes");
                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.collections.List<*>");
                Object obj4 = ((List) obj3).get(1);
                Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
                Object obj5 = ((Map) obj4).get("childNodes");
                Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type kotlin.collections.List<*>");
                Object obj6 = ((List) obj5).get(1);
                Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
                Object obj7 = ((Map) obj6).get("childNodes");
                Intrinsics.checkNotNull(obj7, "null cannot be cast to non-null type kotlin.collections.List<*>");
                return new sdk.pendo.io.h7.f(timestamp, retroactiveScreenId, new JSONArray((Collection) obj7), displayData);
            } catch (Exception e) {
                PendoLogger.d("SRFlutterManager", "generateFullSnapshotData failed: " + e);
                return null;
            }
        }

        private final h a(Map<String, ? extends Object> srEventData, long timestamp, String retroactiveScreenId) {
            try {
                Object obj = srEventData.get("data");
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
                Map map = (Map) obj;
                Object obj2 = map.get("x");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Number");
                float fFloatValue = ((Number) obj2).floatValue();
                Object obj3 = map.get("y");
                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Number");
                float fFloatValue2 = ((Number) obj3).floatValue();
                Object obj4 = map.get("type");
                Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.Number");
                int iIntValue = ((Number) obj4).intValue();
                if (iIntValue == x.TOUCH_START.getValue() || iIntValue == x.TOUCH_END.getValue()) {
                    return new h(timestamp, retroactiveScreenId, iIntValue, fFloatValue, fFloatValue2);
                }
                return null;
            } catch (Exception e) {
                PendoLogger.d("SRFlutterManager", "generateIncrementalSnapshotData failed: " + e);
                return null;
            }
        }
    }

    /* JADX INFO: renamed from: sdk.pendo.io.o7.c$c, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0007\n\u0002\b\u0003*\u0001\u0000\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"sdk/pendo/io/o7/c$c$a", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "()Lsdk/pendo/io/o7/c$c$a;"}, k = 3, mv = {1, 9, 0})
    static final class C0447c extends Lambda implements Function0<a> {
        final /* synthetic */ sdk.pendo.io.z6.b b;

        /* JADX INFO: renamed from: sdk.pendo.io.o7.c$c$a */
        @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0002H\u0016¨\u0006\b"}, d2 = {"sdk/pendo/io/o7/c$c$a", "Lsdk/pendo/io/o7/b;", "", "", "", "srEventData", "", "sendSREventData", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
        public static final class a extends sdk.pendo.io.o7.b {
            final /* synthetic */ c a;
            final /* synthetic */ sdk.pendo.io.z6.b b;

            /* JADX INFO: renamed from: sdk.pendo.io.o7.c$c$a$a, reason: collision with other inner class name */
            @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
            @DebugMetadata(c = "sdk.pendo.io.sessionreplay.managers.SRFlutterManager$flutterCallbacksListener$2$1$sendSREventData$1", f = "SRFlutterManager.kt", i = {}, l = {79}, m = "invokeSuspend", n = {}, s = {})
            static final class C0448a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int a;
                final /* synthetic */ sdk.pendo.io.z6.b b;
                final /* synthetic */ c c;

                /* JADX INFO: renamed from: sdk.pendo.io.o7.c$c$a$a$a, reason: collision with other inner class name */
                @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
                @DebugMetadata(c = "sdk.pendo.io.sessionreplay.managers.SRFlutterManager$flutterCallbacksListener$2$1$sendSREventData$1$1", f = "SRFlutterManager.kt", i = {}, l = {81}, m = "invokeSuspend", n = {}, s = {})
                static final class C0449a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    int a;
                    final /* synthetic */ c b;

                    /* JADX INFO: renamed from: sdk.pendo.io.o7.c$c$a$a$a$a, reason: collision with other inner class name */
                    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0000H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "", "", "eventData", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0})
                    static final class C0450a<T> implements FlowCollector {
                        final /* synthetic */ c a;

                        /* JADX INFO: renamed from: sdk.pendo.io.o7.c$c$a$a$a$a$a, reason: collision with other inner class name */
                        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                        @DebugMetadata(c = "sdk.pendo.io.sessionreplay.managers.SRFlutterManager$flutterCallbacksListener$2$1$sendSREventData$1$1$1", f = "SRFlutterManager.kt", i = {}, l = {83}, m = "emit", n = {}, s = {})
                        static final class C0451a extends ContinuationImpl {
                            /* synthetic */ Object a;
                            final /* synthetic */ C0450a<T> b;
                            int c;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            C0451a(C0450a<? super T> c0450a, Continuation<? super C0451a> continuation) {
                                super(continuation);
                                this.b = c0450a;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                this.a = obj;
                                this.c |= Integer.MIN_VALUE;
                                return this.b.emit(null, this);
                            }
                        }

                        C0450a(c cVar) {
                            this.a = cVar;
                        }

                        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                        public final Object emit(Map<String, ? extends Object> map, Continuation<? super Unit> continuation) {
                            C0451a c0451a;
                            if (continuation instanceof C0451a) {
                                c0451a = (C0451a) continuation;
                                int i = c0451a.c;
                                if ((i & Integer.MIN_VALUE) != 0) {
                                    c0451a.c = i - Integer.MIN_VALUE;
                                } else {
                                    c0451a = new C0451a(this, continuation);
                                }
                            } else {
                                c0451a = new C0451a(this, continuation);
                            }
                            Object obj = c0451a.a;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i2 = c0451a.c;
                            try {
                                if (i2 == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    c cVar = this.a;
                                    c0451a.c = 1;
                                    if (cVar.a(map, c0451a) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                } else {
                                    if (i2 != 1) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    ResultKt.throwOnFailure(obj);
                                }
                            } catch (CancellationException e) {
                                throw e;
                            } catch (Exception e2) {
                                PendoLogger.e("SRFlutterManager", "handleOnSREvent: " + e2);
                            }
                            return Unit.INSTANCE;
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C0449a(c cVar, Continuation<? super C0449a> continuation) {
                        super(2, continuation);
                        this.b = cVar;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((C0449a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C0449a(this.b, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.a;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            MutableSharedFlow mutableSharedFlow = this.b.onFlutterEventFlow;
                            C0450a c0450a = new C0450a(this.b);
                            this.a = 1;
                            if (mutableSharedFlow.collect(c0450a, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        throw new KotlinNothingValueException();
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0448a(sdk.pendo.io.z6.b bVar, c cVar, Continuation<? super C0448a> continuation) {
                    super(2, continuation);
                    this.b = bVar;
                    this.c = cVar;
                }

                @Override // kotlin.jvm.functions.Function2
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C0448a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C0448a(this.b, this.c, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.a;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        CoroutineDispatcher coroutineDispatcherC = this.b.c();
                        C0449a c0449a = new C0449a(this.c, null);
                        this.a = 1;
                        if (BuildersKt.withContext(coroutineDispatcherC, c0449a, this) == coroutine_suspended) {
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

            a(c cVar, sdk.pendo.io.z6.b bVar) {
                this.a = cVar;
                this.b = bVar;
            }

            @Override // sdk.pendo.io.sdk.flutter.IFlutterEventsCallback
            public void sendSREventData(Map<String, ? extends Object> srEventData) {
                m configurations = this.a.getConfigurations();
                if ((configurations == null || configurations.getEnable()) && this.a.a(srEventData) && this.a.getRecordingsManager() != null) {
                    if (this.a.getOnEventCollectionJob() == null) {
                        c cVar = this.a;
                        cVar.a(BuildersKt__Builders_commonKt.launch$default(cVar.getCoroutineScope(), new CoroutineName("EventCollectionCoroutine"), null, new C0448a(this.b, this.a, null), 2, null));
                    }
                    this.a.onFlutterEventFlow.tryEmit(srEventData);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0447c(sdk.pendo.io.z6.b bVar) {
            super(0);
            this.b = bVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final a invoke() {
            return new a(c.this, this.b);
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sdk.pendo.io.sessionreplay.managers.SRFlutterManager", f = "SRFlutterManager.kt", i = {0, 0, 0}, l = {306}, m = "handleOnSREvent", n = {"this", "srEventData", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2"})
    static final class d extends ContinuationImpl {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int f;

        d(Continuation<? super d> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return c.this.a((Map<String, ? extends Object>) null, this);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sessionreplay.managers.SRFlutterManager$onStopSession$1", f = "SRFlutterManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class e extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;

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
            return c.this.new e(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (c.this.getRecordingsManager() == null) {
                return Unit.INSTANCE;
            }
            sdk.pendo.io.p7.c recordingsManager = c.this.getRecordingsManager();
            PendoLogger.i("SRFlutterManager", "onStopSession ->  visitor:" + (recordingsManager != null ? recordingsManager.getSessionVisitorId() : null));
            c.this.a((m) null);
            c.this.a((s) null);
            sdk.pendo.io.p7.c recordingsManager2 = c.this.getRecordingsManager();
            if (recordingsManager2 != null) {
                recordingsManager2.a();
            }
            c.this.a((sdk.pendo.io.p7.c) null);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"sdk/pendo/io/o7/c$f", "Landroid/view/OrientationEventListener;", "", "orientation", "", "onOrientationChanged", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    public static final class f extends OrientationEventListener {
        final /* synthetic */ Activity a;
        final /* synthetic */ c b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(Activity activity, c cVar) {
            super(activity);
            this.a = activity;
            this.b = cVar;
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int orientation) {
            if (orientation == -1) {
                return;
            }
            this.b.c(this.a);
            PendoLogger.d("SRFlutterManager", "Screen rotation detected, updated display data: " + this.b.getDisplayData());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(String apiKey, String baseUrl, sdk.pendo.io.p5.a pendoComponents, sdk.pendo.io.z6.b dispatcherProvider) {
        IFlutterBridge flutterBridge;
        super(apiKey, baseUrl, dispatcherProvider);
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Intrinsics.checkNotNullParameter(pendoComponents, "pendoComponents");
        Intrinsics.checkNotNullParameter(dispatcherProvider, "dispatcherProvider");
        this.pendoComponents = pendoComponents;
        if (pendoComponents.b() instanceof FlutterScreenManager) {
            sdk.pendo.io.x6.d dVarB = pendoComponents.b();
            Intrinsics.checkNotNull(dVarB, "null cannot be cast to non-null type sdk.pendo.io.sdk.flutter.FlutterScreenManager");
            flutterBridge = ((FlutterScreenManager) dVarB).getFlutterBridge();
            if (flutterBridge != null) {
                PendoLogger.i("SRFlutterManager", "Flutter bridge successfully extracted from FlutterScreenManager");
            } else {
                PendoLogger.w("SRFlutterManager", "Flutter bridge is null in FlutterScreenManager");
            }
        } else {
            PendoLogger.w("SRFlutterManager", "ScreenManager is not a FlutterScreenManager, Flutter bridge not available");
            flutterBridge = null;
        }
        this.flutterBridge = flutterBridge;
        this.onFlutterEventFlow = SharedFlowKt.MutableSharedFlow$default(0, 1, null, 5, null);
        this.flutterCallbacksListener = LazyKt.lazy(new C0447c(dispatcherProvider));
    }

    private final void b(Activity activity) {
        f fVar = new f(activity, this);
        if (fVar.canDetectOrientation()) {
            fVar.enable();
        }
        this.orientationChangeListener = fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(Activity activity) {
        p pVarA = a(activity);
        a(new p(a(pVarA.getWidth()), a(pVarA.getHeight() - pVarA.getBottomInset()), 0, 0, 0, a(pVarA.getBottomInset())));
    }

    private final sdk.pendo.io.o7.b n() {
        return (sdk.pendo.io.o7.b) this.flutterCallbacksListener.getValue();
    }

    public /* synthetic */ c(String str, String str2, sdk.pendo.io.p5.a aVar, sdk.pendo.io.z6.b bVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, aVar, (i & 8) != 0 ? sdk.pendo.io.z6.a.a : bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(Map<String, ? extends Object> map, Continuation<? super Unit> continuation) {
        d dVar;
        Mutex srMutex;
        Object obj;
        sdk.pendo.io.p7.c recordingsManager;
        if (continuation instanceof d) {
            dVar = (d) continuation;
            int i = dVar.f;
            if ((i & Integer.MIN_VALUE) != 0) {
                dVar.f = i - Integer.MIN_VALUE;
            } else {
                dVar = new d(continuation);
            }
        } else {
            dVar = new d(continuation);
        }
        Object obj2 = dVar.d;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = dVar.f;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj2);
            srMutex = getSrMutex();
            dVar.a = this;
            dVar.b = map;
            dVar.c = srMutex;
            dVar.f = 1;
            if (srMutex.lock(null, dVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Mutex mutex = (Mutex) dVar.c;
            map = (Map) dVar.b;
            c cVar = (c) dVar.a;
            ResultKt.throwOnFailure(obj2);
            srMutex = mutex;
            this = cVar;
        }
        Map<String, ? extends Object> map2 = map;
        if (map2 != null) {
            try {
                obj = map2.get("type");
            } catch (Throwable th) {
                srMutex.unlock(null);
                throw th;
            }
        } else {
            obj = null;
        }
        Integer num = obj instanceof Integer ? (Integer) obj : null;
        if (num == null) {
            throw new Exception("No Event Type Found");
        }
        u uVarA = b.a.a(num.intValue(), System.currentTimeMillis(), this.pendoComponents.b().getEMPTY_STRING(), this.getDisplayData(), map2);
        if (uVarA != null && (recordingsManager = this.getRecordingsManager()) != null) {
            recordingsManager.a(uVarA);
            Unit unit = Unit.INSTANCE;
        }
        srMutex.unlock(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean a(Map<String, ? extends Object> srEventData) {
        if (srEventData == null || srEventData.isEmpty()) {
            return false;
        }
        Object obj = srEventData.get("type");
        Integer num = obj instanceof Integer ? (Integer) obj : null;
        int value = x.FULL_SNAPSHOT.getValue();
        if (num == null || num.intValue() != value) {
            int value2 = x.INCREMENTAL_SNAPSHOT.getValue();
            if (num == null || num.intValue() != value2) {
                return false;
            }
        }
        return true;
    }

    @Override // sdk.pendo.io.o7.a
    public Object a(Activity activity, SessionData sessionData, m mVar, Continuation<? super Unit> continuation) {
        Map<String, Object> mapEmptyMap;
        IFlutterBridge iFlutterBridge = this.flutterBridge;
        if (iFlutterBridge == null) {
            PendoLogger.w("SRFlutterManager", "Flutter bridge is null, cannot enable session");
        } else {
            iFlutterBridge.registerForEvents(n());
            IFlutterBridge iFlutterBridge2 = this.flutterBridge;
            m configurations = getConfigurations();
            if (configurations == null || (mapEmptyMap = configurations.i()) == null) {
                mapEmptyMap = MapsKt.emptyMap();
            }
            iFlutterBridge2.setSRConfig(mapEmptyMap);
            a(new sdk.pendo.io.p7.c(sessionData.getVisitorId(), sessionData.getAccountId(), m(), mVar, k(), null, 32, null));
            c(activity);
            b(activity);
        }
        return Unit.INSTANCE;
    }

    @Override // sdk.pendo.io.o7.g
    public void a() {
        OrientationEventListener orientationEventListener = this.orientationChangeListener;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
        this.orientationChangeListener = null;
        super.c();
        sdk.pendo.io.s7.x.a(getCoroutineScope(), getSrMutex(), getDispatcherProvider().b(), null, new e(null), 4, null);
    }

    private final int a(int i) {
        return (int) (i / Resources.getSystem().getDisplayMetrics().density);
    }
}
