package sdk.pendo.io.w6;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.actions.ActivationManager;
import sdk.pendo.io.k3.j;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.GlobalEventProperties;
import sdk.pendo.io.network.interfaces.GetAuthToken;
import sdk.pendo.io.r5.l;
import sdk.pendo.io.r5.m;
import sdk.pendo.io.s7.u0;
import sdk.pendo.io.utilities.AndroidUtils;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\rB\t\b\u0002¢\u0006\u0004\b4\u0010/J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\bH\u0002J \u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\bH\u0002J\u0006\u0010\f\u001a\u00020\u0005J\u0006\u0010\r\u001a\u00020\u0005J\u001c\u0010\t\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0016J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J#\u0010\t\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011H\u0097@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\u0013J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0003H\u0016J\u0006\u0010\u0015\u001a\u00020\u0011J\u0012\u0010\u0018\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016R\u0017\u0010\u001d\u001a\u00020\u00198\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u0004\u0018\u00010\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u001fR\u0014\u0010#\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020)0(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010*R\u001a\u00100\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\f\n\u0004\b\f\u0010-\u0012\u0004\b.\u0010/R\u0014\u00103\u001a\u0002018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u00102\u0082\u0002\u0004\n\u0002\b\u0019¨\u00065"}, d2 = {"Lsdk/pendo/io/w6/a;", "Lsdk/pendo/io/w6/c;", "Lsdk/pendo/io/f6/d;", "Lorg/json/JSONObject;", "event", "", "b", "json", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "screenData", "screenId", "g", "c", "currentScreenData", "previousScreenData", "viewElementInfo", "", "isTriggeredByCode", "(Lorg/json/JSONObject;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trackEventJSON", "f", "Lsdk/pendo/io/network/interfaces/GetAuthToken$GetAuthTokenResponse;", "response", "onGetAccessTokenResponseReceived", "Lsdk/pendo/io/models/GlobalEventProperties;", "Lsdk/pendo/io/models/GlobalEventProperties;", "d", "()Lsdk/pendo/io/models/GlobalEventProperties;", "globalEventProperties", "Lsdk/pendo/io/o3/b;", "Lsdk/pendo/io/o3/b;", "screenChangedSubscription", "Lsdk/pendo/io/r5/l;", "Lsdk/pendo/io/r5/l;", "rageClickDetector", "Lkotlinx/coroutines/CoroutineScope;", "e", "Lkotlinx/coroutines/CoroutineScope;", "clickEventsScope", "Lkotlinx/coroutines/channels/Channel;", "Lsdk/pendo/io/w6/a$c;", "Lkotlinx/coroutines/channels/Channel;", "clickEventChannel", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/Job;", "getClickEventJob$annotations", "()V", "clickEventJob", "Lsdk/pendo/io/x6/d;", "()Lsdk/pendo/io/x6/d;", "screenManager", "<init>", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class a implements sdk.pendo.io.w6.c, sdk.pendo.io.f6.d {
    public static final a a;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private static final GlobalEventProperties globalEventProperties;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private static final sdk.pendo.io.o3.b screenChangedSubscription;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private static final l rageClickDetector;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private static final CoroutineScope clickEventsScope;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private static final Channel<c> clickEventChannel;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private static final Job clickEventJob;

    /* JADX INFO: renamed from: sdk.pendo.io.w6.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Ljava/lang/String;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0})
    static final class C0513a extends Lambda implements Function1<String, Boolean> {
        public static final C0513a a = new C0513a();

        C0513a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(String str) {
            return Boolean.valueOf(a.a.f());
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Ljava/lang/String;)V"}, k = 3, mv = {1, 9, 0})
    static final class b extends Lambda implements Function1<String, Unit> {
        public static final b a = new b();

        b() {
            super(1);
        }

        public final void a(String str) {
            a aVar = a.a;
            JSONObject currentScreenData = aVar.e().getCurrentScreenData();
            JSONObject jSONObject = currentScreenData != null ? new JSONObject(currentScreenData.toString()) : null;
            JSONObject previousScreenData = aVar.e().getPreviousScreenData();
            aVar.a(jSONObject, previousScreenData != null ? new JSONObject(previousScreenData.toString()) : null);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            a(str);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010¨\u0006\u0014"}, d2 = {"Lsdk/pendo/io/w6/a$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lorg/json/JSONObject;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lorg/json/JSONObject;", "()Lorg/json/JSONObject;", "viewElementInfo", "b", "Z", "()Z", "isTriggeredByCode", "<init>", "(Lorg/json/JSONObject;Z)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    private static final /* data */ class c {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final JSONObject viewElementInfo;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        private final boolean isTriggeredByCode;

        public c(JSONObject viewElementInfo, boolean z) {
            Intrinsics.checkNotNullParameter(viewElementInfo, "viewElementInfo");
            this.viewElementInfo = viewElementInfo;
            this.isTriggeredByCode = z;
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final JSONObject getViewElementInfo() {
            return this.viewElementInfo;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final boolean getIsTriggeredByCode() {
            return this.isTriggeredByCode;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof c)) {
                return false;
            }
            c cVar = (c) other;
            return Intrinsics.areEqual(this.viewElementInfo, cVar.viewElementInfo) && this.isTriggeredByCode == cVar.isTriggeredByCode;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3 */
        /* JADX WARN: Type inference failed for: r1v4 */
        public int hashCode() {
            int iHashCode = this.viewElementInfo.hashCode() * 31;
            boolean z = this.isTriggeredByCode;
            ?? r1 = z;
            if (z) {
                r1 = 1;
            }
            return iHashCode + r1;
        }

        public String toString() {
            return "ClickEvent(viewElementInfo=" + this.viewElementInfo + ", isTriggeredByCode=" + this.isTriggeredByCode + ")";
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sdk.manager.AnalyticsManager$cleanup$1", f = "AnalyticsManager.kt", i = {}, l = {102}, m = "invokeSuspend", n = {}, s = {})
    static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;

        d(Continuation<? super d> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new d(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                l lVar = a.rageClickDetector;
                this.a = 1;
                if (lVar.a(this) == coroutine_suspended) {
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

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sdk.manager.AnalyticsManager$clickEventJob$1", f = "AnalyticsManager.kt", i = {}, l = {70, 71}, m = "invokeSuspend", n = {}, s = {})
    static final class e extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object a;
        int b;

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
            return new e(continuation);
        }

        /* JADX WARN: Code duplicated, block: B:11:0x0031 A[PHI: r1
          0x0031: PHI (r1v3 kotlinx.coroutines.channels.ChannelIterator) = 
          (r1v8 kotlinx.coroutines.channels.ChannelIterator)
          (r1v9 kotlinx.coroutines.channels.ChannelIterator)
          (r1v10 kotlinx.coroutines.channels.ChannelIterator)
         binds: [B:10:0x0026, B:17:0x005c, B:6:0x000e] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:14:0x003c A[PHI: r1 r7
          0x003c: PHI (r1v2 kotlinx.coroutines.channels.ChannelIterator) = (r1v11 kotlinx.coroutines.channels.ChannelIterator), (r1v12 kotlinx.coroutines.channels.ChannelIterator) binds: [B:12:0x0039, B:9:0x001e] A[DONT_GENERATE, DONT_INLINE]
          0x003c: PHI (r7v2 java.lang.Object) = (r7v9 java.lang.Object), (r7v0 java.lang.Object) binds: [B:12:0x0039, B:9:0x001e] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:16:0x0044  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x005c -> B:11:0x0031). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r6.b
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L26
                if (r1 == r3) goto L1e
                if (r1 != r2) goto L16
                java.lang.Object r1 = r6.a
                kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                kotlin.ResultKt.throwOnFailure(r7)
                goto L31
            L16:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L1e:
                java.lang.Object r1 = r6.a
                kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                kotlin.ResultKt.throwOnFailure(r7)
                goto L3c
            L26:
                kotlin.ResultKt.throwOnFailure(r7)
                kotlinx.coroutines.channels.Channel r7 = sdk.pendo.io.w6.a.a()
                kotlinx.coroutines.channels.ChannelIterator r1 = r7.iterator()
            L31:
                r6.a = r1
                r6.b = r3
                java.lang.Object r7 = r1.hasNext(r6)
                if (r7 != r0) goto L3c
                goto L5e
            L3c:
                java.lang.Boolean r7 = (java.lang.Boolean) r7
                boolean r7 = r7.booleanValue()
                if (r7 == 0) goto L5f
                java.lang.Object r7 = r1.next()
                sdk.pendo.io.w6.a$c r7 = (sdk.pendo.io.w6.a.c) r7
                sdk.pendo.io.w6.a r4 = sdk.pendo.io.w6.a.a
                org.json.JSONObject r5 = r7.getViewElementInfo()
                boolean r7 = r7.getIsTriggeredByCode()
                r6.a = r1
                r6.b = r2
                java.lang.Object r7 = r4.a(r5, r7, r6)
                if (r7 != r0) goto L31
            L5e:
                return r0
            L5f:
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.w6.a.e.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sdk.manager.AnalyticsManager$handleScreenViewEvent$1", f = "AnalyticsManager.kt", i = {}, l = {122}, m = "invokeSuspend", n = {}, s = {})
    static final class f extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;

        f(Continuation<? super f> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((f) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new f(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                l lVar = a.rageClickDetector;
                this.a = 1;
                if (lVar.a(this) == coroutine_suspended) {
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

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sdk.pendo.io.sdk.manager.AnalyticsManager", f = "AnalyticsManager.kt", i = {0, 0, 0}, l = {178}, m = "processClickEvent", n = {"viewElementInfo", "event", "isTriggeredByCode"}, s = {"L$0", "L$1", "Z$0"})
    static final class g extends ContinuationImpl {
        Object a;
        Object b;
        boolean c;
        /* synthetic */ Object d;
        int f;

        g(Continuation<? super g> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return a.this.a((JSONObject) null, false, (Continuation<? super Unit>) this);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\u0003\u001a\u00020\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "kotlin.jvm.PlatformType", "isInitiated", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Ljava/lang/Boolean;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0})
    static final class h extends Lambda implements Function1<Boolean, Boolean> {
        public static final h a = new h();

        h() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Boolean bool) {
            Intrinsics.checkNotNull(bool);
            return bool;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Ljava/lang/Object;", "kotlin.jvm.PlatformType", "it", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Ljava/lang/Object;)V"}, k = 3, mv = {1, 9, 0})
    static final class i extends Lambda implements Function1<Object, Unit> {
        final /* synthetic */ JSONObject a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(JSONObject jSONObject) {
            super(1);
            this.a = jSONObject;
        }

        public final void a(Object obj) {
            sdk.pendo.io.r5.i.e().d().onNext(this.a);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            a(obj);
            return Unit.INSTANCE;
        }
    }

    static {
        j<String> jVarA;
        a aVar = new a();
        a = aVar;
        globalEventProperties = new GlobalEventProperties();
        rageClickDetector = new l();
        sdk.pendo.io.o3.b bVarA = null;
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getDefault().limitedParallelism(1)).plus(new CoroutineName("AnalyticsClickSequencer")));
        clickEventsScope = CoroutineScope;
        clickEventChannel = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        clickEventJob = BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new e(null), 3, null);
        j<String> screenChangedNewScreenIdSubject = aVar.e().getScreenChangedNewScreenIdSubject();
        if (screenChangedNewScreenIdSubject != null && (jVarA = screenChangedNewScreenIdSubject.a(sdk.pendo.io.i4.a.b())) != null) {
            final C0513a c0513a = C0513a.a;
            j<String> jVarA2 = jVarA.a(new sdk.pendo.io.q3.j() { // from class: sdk.pendo.io.w6.a$$ExternalSyntheticLambda1
                @Override // sdk.pendo.io.q3.j
                public final boolean test(Object obj) {
                    return a.a(c0513a, obj);
                }
            });
            if (jVarA2 != null) {
                final b bVar = b.a;
                bVarA = jVarA2.a(new sdk.pendo.io.q3.e() { // from class: sdk.pendo.io.w6.a$$ExternalSyntheticLambda2
                    @Override // sdk.pendo.io.q3.e
                    public final void accept(Object obj) {
                        a.b(bVar, obj);
                    }
                }, new sdk.pendo.io.q6.a("ScreenManager, screenChangedSubscription"));
            }
        }
        screenChangedSubscription = bVarA;
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final sdk.pendo.io.x6.d e() {
        sdk.pendo.io.x6.d dVarZ = PendoInternal.z();
        Intrinsics.checkNotNullExpressionValue(dVarZ, "getScreenManager(...)");
        return dVarZ;
    }

    public final void c() {
        BuildersKt__Builders_commonKt.launch$default(clickEventsScope, null, null, new d(null), 3, null);
    }

    public final GlobalEventProperties d() {
        return globalEventProperties;
    }

    public final boolean f() {
        return PendoInternal.q() && !sdk.pendo.io.o6.a.d().g();
    }

    public final void g() {
    }

    @Override // sdk.pendo.io.f6.d
    public void onGetAccessTokenResponseReceived(GetAuthToken.GetAuthTokenResponse response) {
        Map<String, List<String>> promotedMetadataFields;
        if (response == null || (promotedMetadataFields = response.getPromotedMetadataFields()) == null) {
            return;
        }
        globalEventProperties.setPromotedMetadataKeys(promotedMetadataFields, PendoInternal.A());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void b(final JSONObject event) {
        ActivationManager activationManager = ActivationManager.INSTANCE;
        if (activationManager.isInited()) {
            sdk.pendo.io.r5.i.e().d().onNext(event);
            return;
        }
        sdk.pendo.io.j4.a<Boolean> aVarIsInitedObservable = activationManager.isInitedObservable();
        final h hVar = h.a;
        aVarIsInitedObservable.a(new sdk.pendo.io.q3.j() { // from class: sdk.pendo.io.w6.a$$ExternalSyntheticLambda3
            @Override // sdk.pendo.io.q3.j
            public final boolean test(Object obj) {
                return a.c(hVar, obj);
            }
        }).f().b(sdk.pendo.io.i4.a.d()).a(sdk.pendo.io.i4.a.d()).a(sdk.pendo.io.t6.c.a(new sdk.pendo.io.q3.e() { // from class: sdk.pendo.io.w6.a$$ExternalSyntheticLambda4
            @Override // sdk.pendo.io.q3.e
            public final void accept(Object obj) {
                a.a(event, (Boolean) obj);
            }
        }, "Observer for handleScreenViewEvent prior to ActivationManager being initialised"));
    }

    private final synchronized JSONObject a(JSONObject screenData, String screenId, String event) {
        JSONObject jSONObjectPut;
        jSONObjectPut = a(new JSONObject(), event).put("id", screenId).put("data", new JSONObject().put(ActivationManager.SCREEN_DATA_KEY, screenData));
        Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "put(...)");
        return jSONObjectPut;
    }

    @Override // sdk.pendo.io.w6.c
    public void a(JSONObject viewElementInfo, boolean isTriggeredByCode) {
        Intrinsics.checkNotNullParameter(viewElementInfo, "viewElementInfo");
        Object obj = clickEventChannel.mo11206trySendJP2dKIU(new c(new JSONObject(viewElementInfo.toString()), isTriggeredByCode));
        if (ChannelResult.m16343isFailureimpl(obj)) {
            PendoLogger.w("AnalyticsManager", "handleClickEvent, failed to enqueue click event: " + ChannelResult.m16338exceptionOrNullimpl(obj));
        }
    }

    public synchronized void a(JSONObject currentScreenData, JSONObject previousScreenData) {
        BuildersKt__Builders_commonKt.launch$default(clickEventsScope, null, null, new f(null), 3, null);
        if (previousScreenData != null && previousScreenData.has("retroactiveScreenId") && previousScreenData.get("retroactiveScreenId").toString().length() > 0) {
            sdk.pendo.io.r5.i.e().d().onNext(a(previousScreenData, previousScreenData.get("retroactiveScreenId").toString(), "RAScreenLeft"));
        }
        if (currentScreenData != null && currentScreenData.has("retroactiveScreenId") && currentScreenData.get("retroactiveScreenId").toString().length() > 0) {
            b(a(currentScreenData, currentScreenData.get("retroactiveScreenId").toString(), "RAScreenView"));
        }
    }

    public synchronized void a(JSONObject trackEventJSON) {
        Intrinsics.checkNotNullParameter(trackEventJSON, "trackEventJSON");
        PendoLogger.i("AnalyticsManager-> handleTrackEvent with trackEvent: " + trackEventJSON, new Object[0]);
        if (PendoInternal.S() && !PendoInternal.R()) {
            ActivationManager.INSTANCE.getTrackEventsBeforeSessionStart().add(new m.a(sdk.pendo.io.r5.d.TRACK_EVENT, trackEventJSON, null));
        } else if (f()) {
            sdk.pendo.io.r5.i.f().a(sdk.pendo.io.r5.d.TRACK_EVENT, trackEventJSON, null);
        }
    }

    private final JSONObject a(JSONObject json, String event) throws JSONException {
        long jW = PendoInternal.w();
        if (jW <= 0) {
            jW = System.currentTimeMillis();
        }
        json.put("event", event).put("accountId", PendoInternal.l()).put("visitorId", PendoInternal.G()).put("actionType", event).put("orientation", sdk.pendo.io.s7.l.g()).put("device_time", jW).put(RemoteConfigConstants.RequestFieldKey.APP_VERSION, AndroidUtils.d()).put("sdkVersion", u0.a());
        return json;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public Object a(JSONObject jSONObject, boolean z, Continuation<? super Unit> continuation) throws JSONException {
        g gVar;
        JSONObject jSONObjectA;
        if (continuation instanceof g) {
            gVar = (g) continuation;
            int i2 = gVar.f;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                gVar.f = i2 - Integer.MIN_VALUE;
            } else {
                gVar = new g(continuation);
            }
        } else {
            gVar = new g(continuation);
        }
        g gVar2 = gVar;
        Object objA = gVar2.d;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = gVar2.f;
        if (i3 == 0) {
            ResultKt.throwOnFailure(objA);
            if (!f()) {
                return Unit.INSTANCE;
            }
            JSONObject currentScreenData = e().getCurrentScreenData();
            if (currentScreenData == null || !currentScreenData.has("retroactiveScreenId")) {
                PendoLogger.w("AnalyticsManager", "handleClickEvent, currentScreenData is null or there is no currentScreenID within");
            } else {
                jSONObjectA = a(currentScreenData, currentScreenData.get("retroactiveScreenId").toString(), "RAClick");
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("tapLocation");
                if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.has("x") && jSONObjectOptJSONObject.has("y")) {
                    int iOptInt = jSONObjectOptJSONObject.optInt("x", -1);
                    int iOptInt2 = jSONObjectOptJSONObject.optInt("y", -1);
                    if (iOptInt >= 0 && iOptInt2 >= 0) {
                        long jOptLong = jSONObject.optLong("device_time", System.currentTimeMillis());
                        gVar2.a = jSONObject;
                        gVar2.b = jSONObjectA;
                        gVar2.c = z;
                        gVar2.f = 1;
                        objA = rageClickDetector.a(iOptInt, iOptInt2, jOptLong, gVar2);
                        if (objA == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    jSONObject.remove("tapLocation");
                }
                jSONObject.put("triggeredByCode", z);
                JSONObject jSONObject2 = jSONObjectA.getJSONObject("data");
                jSONObject2.put("retroElementInfo", jSONObject);
                jSONObjectA.put("data", jSONObject2);
                sdk.pendo.io.r5.i.e().d().onNext(jSONObjectA);
            }
            return Unit.INSTANCE;
        }
        if (i3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        z = gVar2.c;
        jSONObjectA = (JSONObject) gVar2.b;
        jSONObject = (JSONObject) gVar2.a;
        ResultKt.throwOnFailure(objA);
        if (((Boolean) objA).booleanValue()) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(sdk.pendo.io.r5.f.RAGE_CLICK.getValue());
            jSONObjectA.put("frustrationTypes", jSONArray);
        }
        jSONObject.remove("tapLocation");
        jSONObject.put("triggeredByCode", z);
        JSONObject jSONObject3 = jSONObjectA.getJSONObject("data");
        jSONObject3.put("retroElementInfo", jSONObject);
        jSONObjectA.put("data", jSONObject3);
        sdk.pendo.io.r5.i.e().d().onNext(jSONObjectA);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(JSONObject event, Boolean bool) {
        Intrinsics.checkNotNullParameter(event, "$event");
        j jVarA = j.a(new Object()).b(sdk.pendo.io.i4.a.d()).a(sdk.pendo.io.i4.a.d());
        final i iVar = new i(event);
        jVarA.a(new sdk.pendo.io.q3.e() { // from class: sdk.pendo.io.w6.a$$ExternalSyntheticLambda0
            @Override // sdk.pendo.io.q3.e
            public final void accept(Object obj) {
                a.d(iVar, obj);
            }
        }, new sdk.pendo.io.q6.a("ActivationManager, screenChangedSubscription"));
    }
}
