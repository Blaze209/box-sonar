package sdk.pendo.io.sdk.flutter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.View;
import android.view.Window;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.box.androidsdk.content.models.BoxRepresentation;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.json.JSONArray;
import org.json.JSONObject;
import sdk.pendo.io.Pendo;
import sdk.pendo.io.actions.ActivationManager;
import sdk.pendo.io.actions.ElementInfoAndViewRef;
import sdk.pendo.io.actions.IActivationManager;
import sdk.pendo.io.d1.g;
import sdk.pendo.io.d1.l;
import sdk.pendo.io.events.IdentificationData;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.StepLocationModel;
import sdk.pendo.io.network.interfaces.GetAuthToken;
import sdk.pendo.io.s7.i0;
import sdk.pendo.io.s7.k;
import sdk.pendo.io.s7.m;
import sdk.pendo.io.s7.t0;
import sdk.pendo.io.s7.x;
import sdk.pendo.io.w6.a;
import sdk.pendo.io.x6.i;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 l2\u00020\u00012\u00020\u0002:\u0001\tB#\u0012\u0006\u0010g\u001a\u00020f\u0012\b\u0010;\u001a\u0004\u0018\u000108\u0012\b\b\u0002\u0010i\u001a\u00020h¢\u0006\u0004\bj\u0010kJ(\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0016\u0010\u0007\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H\u0002J$\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J$\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J%\u0010\u0014\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0011\u001a\u00020\bH\u0090@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J \u0010\u0015\u001a\u00020\r2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005H\u0016J\u001c\u0010\u0017\u001a\u00020\r2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J#\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\bH\u0090@ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u0013\u0010 \u001a\u00020\nH\u0090@ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u0013\u0010!\u001a\u00020\u001aH\u0096@ø\u0001\u0000¢\u0006\u0004\b!\u0010\u001fJ\u001e\u0010&\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010\"2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0016J\u0012\u0010)\u001a\u00020\r2\b\u0010(\u001a\u0004\u0018\u00010'H\u0016J \u0010*\u001a\u00020\r2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005H\u0016J \u0010,\u001a\u00020\r2\u0016\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005H\u0016J\b\u0010.\u001a\u00020-H\u0016J#\u00103\u001a\u00020\r2\u0006\u00100\u001a\u00020/2\u0006\u00102\u001a\u000201H\u0096@ø\u0001\u0000¢\u0006\u0004\b3\u00104J$\u0010\t\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\u0005H\u0007J\f\u00107\u001a\b\u0012\u0004\u0012\u00020605J\b\u00109\u001a\u0004\u0018\u000108R\u0016\u0010;\u001a\u0004\u0018\u0001088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010:R\u001c\u0010=\u001a\b\u0012\u0004\u0012\u000206058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010<R*\u0010E\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b7\u0010>\u0012\u0004\bC\u0010D\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR(\u0010M\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\bF\u0010G\u0012\u0004\bL\u0010D\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR*\u0010R\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\bN\u0010G\u0012\u0004\bQ\u0010D\u001a\u0004\bO\u0010I\"\u0004\bP\u0010KR0\u0010Y\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\bS\u0010T\u0012\u0004\bX\u0010D\u001a\u0004\b\t\u0010U\"\u0004\bV\u0010WR2\u0010^\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\bZ\u0010T\u0012\u0004\b]\u0010D\u001a\u0004\b[\u0010U\"\u0004\b\\\u0010WR(\u0010e\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b_\u0010`\u0012\u0004\bd\u0010D\u001a\u0004\ba\u0010b\"\u0004\b\t\u0010c\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006m"}, d2 = {"Lsdk/pendo/io/sdk/flutter/FlutterScreenManager;", "Lsdk/pendo/io/x6/i;", "Lsdk/pendo/io/sdk/flutter/IFlutterEventsCallback;", "Lsdk/pendo/io/s7/i0;", "pendoAnchorView", "", "", "abstractViewTreeMap", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", "screenName", BoxRepresentation.FIELD_INFO, "", "newScreenIdentified", "screenContentChanged", "newScreenId", "forceNotifyNewScreen", "setNewScreenId$pendoIO_release", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setNewScreenId", "screenDataForCaptureReady", "retroElementInfo", "clickActionDetected", "includeText", "isForCapture", "Lorg/json/JSONObject;", "getScreenData$pendoIO_release", "(ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getScreenData", "calculateScreenId$pendoIO_release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calculateScreenId", "getScreenDataForCapture", "", "Lsdk/pendo/io/actions/ActivationManager$Trigger;", "triggerList", "Lsdk/pendo/io/actions/ElementInfoAndViewRef;", "getMatchingElementsIfExist", "Lsdk/pendo/io/network/interfaces/GetAuthToken$GetAuthTokenResponse;", "response", "onGetAccessTokenResponseReceived", "sendLogToBE", "srEventData", "sendSREventData", "Lorg/json/JSONArray;", "getViewTreeDataForCapture", "Landroid/app/Activity;", "activity", "Lsdk/pendo/io/t7/c;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "generateScreenshotBitmap", "(Landroid/app/Activity;Lsdk/pendo/io/t7/c;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lsdk/pendo/io/j4/b;", "Lsdk/pendo/io/s7/t0;", "c", "Lsdk/pendo/io/sdk/flutter/IFlutterBridge;", "b", "Lsdk/pendo/io/sdk/flutter/IFlutterBridge;", Pendo.PendoOptions.FLUTTER_BRIDGE, "Lsdk/pendo/io/j4/b;", "captureScreenDataSubject", "Ljava/lang/String;", "getFlutterScreenName", "()Ljava/lang/String;", "setFlutterScreenName", "(Ljava/lang/String;)V", "getFlutterScreenName$annotations", "()V", "flutterScreenName", "d", "Lorg/json/JSONObject;", "getRetroactiveScreenData", "()Lorg/json/JSONObject;", "setRetroactiveScreenData", "(Lorg/json/JSONObject;)V", "getRetroactiveScreenData$annotations", ActivationManager.SCREEN_DATA_KEY, "e", "getRetroactiveScreenDataForCapture", "setRetroactiveScreenDataForCapture", "getRetroactiveScreenDataForCapture$annotations", "retroactiveScreenDataForCapture", "f", "Ljava/util/Map;", "()Ljava/util/Map;", "setAbstractViewTree", "(Ljava/util/Map;)V", "getAbstractViewTree$annotations", "abstractViewTree", "g", "getAbstractViewTreeDataForCapture", "setAbstractViewTreeDataForCapture", "getAbstractViewTreeDataForCapture$annotations", "abstractViewTreeDataForCapture", CmcdData.STREAMING_FORMAT_HLS, "Z", "getNewScreenDetected", "()Z", "(Z)V", "getNewScreenDetected$annotations", "newScreenDetected", "Lsdk/pendo/io/Pendo$PendoOptions;", "pendoOptions", "Lsdk/pendo/io/s7/m;", "defaultDispatcherProvider", "<init>", "(Lsdk/pendo/io/Pendo$PendoOptions;Lsdk/pendo/io/sdk/flutter/IFlutterBridge;Lsdk/pendo/io/s7/m;)V", "i", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class FlutterScreenManager extends i implements IFlutterEventsCallback {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final IFlutterBridge flutterBridge;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private sdk.pendo.io.j4.b<t0> captureScreenDataSubject;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private String flutterScreenName;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private JSONObject retroactiveScreenData;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private JSONObject retroactiveScreenDataForCapture;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private Map<?, ?> abstractViewTree;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private Map<?, ?> abstractViewTreeDataForCapture;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private boolean newScreenDetected;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sdk.flutter.FlutterScreenManager$generateScreenshotBitmap$2", f = "FlutterScreenManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ Activity b;
        final /* synthetic */ FlutterScreenManager c;
        final /* synthetic */ sdk.pendo.io.t7.c d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Activity activity, FlutterScreenManager flutterScreenManager, sdk.pendo.io.t7.c cVar, Continuation<? super b> continuation) {
            super(2, continuation);
            this.b = activity;
            this.c = flutterScreenManager;
            this.d = cVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.b, this.c, this.d, continuation);
        }

        /* JADX WARN: Code duplicated, block: B:16:0x0033  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            int iIntValue;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Window window = this.b.getWindow();
            View decorView = window != null ? window.getDecorView() : null;
            int iIntValue2 = 1;
            if (decorView != null) {
                Integer numBoxInt = Boxing.boxInt(decorView.getWidth());
                if (numBoxInt.intValue() <= 0) {
                    numBoxInt = null;
                }
                if (numBoxInt != null) {
                    iIntValue = numBoxInt.intValue();
                } else {
                    iIntValue = 1;
                }
            } else {
                iIntValue = 1;
            }
            if (decorView != null) {
                Integer numBoxInt2 = Boxing.boxInt(decorView.getHeight());
                if (numBoxInt2.intValue() <= 0) {
                    numBoxInt2 = null;
                }
                if (numBoxInt2 != null) {
                    iIntValue2 = numBoxInt2.intValue();
                }
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iIntValue, iIntValue2, Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(width, height, config)");
            try {
                IFlutterBridge iFlutterBridge = this.c.flutterBridge;
                byte[] bArrDecode = Base64.decode(iFlutterBridge != null ? iFlutterBridge.generateBitmap() : null, 0);
                Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(...)");
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                Intrinsics.checkNotNullExpressionValue(bitmapDecodeByteArray, "decodeByteArray(...)");
                bitmapCreateBitmap = bitmapDecodeByteArray;
            } catch (Exception e) {
                PendoLogger.w("FlutterScreenManager", "Failed to capture the screen, exception: " + e);
            }
            this.d.a(bitmapCreateBitmap);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sdk.flutter.FlutterScreenManager$newScreenIdentified$1", f = "FlutterScreenManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ String b;
        final /* synthetic */ Map<String, Object> c;
        final /* synthetic */ FlutterScreenManager d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, Map<String, ? extends Object> map, FlutterScreenManager flutterScreenManager, Continuation<? super c> continuation) {
            super(2, continuation);
            this.b = str;
            this.c = map;
            this.d = flutterScreenManager;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new c(this.b, this.c, this.d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            PendoLogger.i("FlutterScreenManager", "newScreenIdentified -> screen name received from plugin: " + this.b + " and info " + this.c);
            sdk.pendo.io.s7.e.INSTANCE.a().b();
            this.d.a(this.b, this.c);
            this.d.a(true);
            MutableSharedFlow<Unit> screenContentChangeFlow$pendoIO_release = this.d.getScreenContentChangeFlow$pendoIO_release();
            if (screenContentChangeFlow$pendoIO_release != null) {
                Boxing.boxBoolean(screenContentChangeFlow$pendoIO_release.tryEmit(Unit.INSTANCE));
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sdk.flutter.FlutterScreenManager$screenContentChanged$1", f = "FlutterScreenManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ String b;
        final /* synthetic */ Map<String, Object> c;
        final /* synthetic */ FlutterScreenManager d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str, Map<String, ? extends Object> map, FlutterScreenManager flutterScreenManager, Continuation<? super d> continuation) {
            super(2, continuation);
            this.b = str;
            this.c = map;
            this.d = flutterScreenManager;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new d(this.b, this.c, this.d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            i0 i0Var;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            PendoLogger.i("FlutterScreenManager", "screenContentChanged -> screen name received from plugin: " + this.b + " and info " + this.c);
            this.d.a(this.b, this.c);
            Map map = MapsKt.toMap(this.d.a());
            if (map.isEmpty()) {
                return Unit.INSTANCE;
            }
            sdk.pendo.io.s7.e.Companion companion = sdk.pendo.io.s7.e.INSTANCE;
            WeakReference<i0> weakReferenceC = companion.a().c();
            if (weakReferenceC != null && (i0Var = weakReferenceC.get()) != null) {
                if (!this.d.a(i0Var, (Map<Object, ? extends Object>) map)) {
                    return Unit.INSTANCE;
                }
                companion.a().b();
            }
            MutableSharedFlow<Unit> screenContentChangeFlow$pendoIO_release = this.d.getScreenContentChangeFlow$pendoIO_release();
            if (screenContentChangeFlow$pendoIO_release != null) {
                Boxing.boxBoolean(screenContentChangeFlow$pendoIO_release.tryEmit(Unit.INSTANCE));
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sdk.pendo.io.sdk.flutter.FlutterScreenManager", f = "FlutterScreenManager.kt", i = {0, 1}, l = {134, 136}, m = "setNewScreenId$pendoIO_release", n = {"this", "this"}, s = {"L$0", "L$0"})
    static final class e extends ContinuationImpl {
        Object a;
        /* synthetic */ Object b;
        int d;

        e(Continuation<? super e> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return FlutterScreenManager.this.setNewScreenId$pendoIO_release(null, false, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlutterScreenManager(Pendo.PendoOptions pendoOptions, IFlutterBridge iFlutterBridge, m defaultDispatcherProvider) {
        super(pendoOptions, defaultDispatcherProvider);
        Intrinsics.checkNotNullParameter(pendoOptions, "pendoOptions");
        Intrinsics.checkNotNullParameter(defaultDispatcherProvider, "defaultDispatcherProvider");
        this.flutterBridge = iFlutterBridge;
        sdk.pendo.io.j4.b<t0> bVarM = sdk.pendo.io.j4.b.m();
        Intrinsics.checkNotNullExpressionValue(bVarM, "create(...)");
        this.captureScreenDataSubject = bVarM;
        this.retroactiveScreenData = new JSONObject();
        this.abstractViewTree = new HashMap();
        if (iFlutterBridge != null) {
            iFlutterBridge.registerForEvents(this);
        }
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final IFlutterBridge getFlutterBridge() {
        return this.flutterBridge;
    }

    public final sdk.pendo.io.j4.b<t0> c() {
        try {
            IFlutterBridge iFlutterBridge = this.flutterBridge;
            if (iFlutterBridge != null) {
                iFlutterBridge.prepareDataForCapture();
            }
        } catch (Exception e2) {
            PendoLogger.w("FlutterScreenManager", "Failed to prepare screen data for capture, exception: " + e2);
        }
        return this.captureScreenDataSubject;
    }

    @Override // sdk.pendo.io.x6.i
    public Object calculateScreenId$pendoIO_release(Continuation<? super String> continuation) {
        String str = this.flutterScreenName;
        return str == null ? "" : str;
    }

    @Override // sdk.pendo.io.sdk.flutter.IFlutterEventsCallback
    public void clickActionDetected(Map<String, ? extends Object> retroElementInfo) {
        Intrinsics.checkNotNullParameter(retroElementInfo, "retroElementInfo");
        if (shouldIgnoreChangesInApp$pendoIO_release()) {
            return;
        }
        JSONObject jSONObject = new JSONObject(retroElementInfo);
        a.a.a(jSONObject, false);
        IActivationManager.DefaultImpls.handleClick$default(ActivationManager.INSTANCE, jSONObject, null, 2, null);
    }

    @Override // sdk.pendo.io.x6.i, sdk.pendo.io.x6.d
    public Object generateScreenshotBitmap(Activity activity, sdk.pendo.io.t7.c cVar, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(getDispatcherProvider().getMain().plus(new CoroutineName("generateScreenshotBitmap")), new b(activity, this, cVar, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    @Override // sdk.pendo.io.x6.i, sdk.pendo.io.x6.d
    public List<ElementInfoAndViewRef> getMatchingElementsIfExist(List<ActivationManager.Trigger> triggerList) {
        Intrinsics.checkNotNullParameter(triggerList, "triggerList");
        Map map = MapsKt.toMap(this.abstractViewTree);
        String str = null;
        if (map.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            ArrayList arrayList2 = new ArrayList();
            Object obj = map.get("root");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
            arrayList2.add((Map) obj);
            while (!arrayList2.isEmpty()) {
                Object objRemove = arrayList2.remove(CollectionsKt.getLastIndex(arrayList2));
                Intrinsics.checkNotNullExpressionValue(objRemove, "removeAt(...)");
                Map map2 = (Map) objRemove;
                Object obj2 = map2.get(IdentificationData.SERIALIZED_NAME);
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
                Map map3 = (Map) obj2;
                JSONObject jSONObject = new JSONObject();
                Object obj3 = map3.get("retroElementInfo");
                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
                jSONObject.put("retroElementInfo", new JSONObject((Map) obj3));
                for (ActivationManager.Trigger trigger : triggerList) {
                    try {
                        sdk.pendo.io.d1.b bVarA = g.a(sdk.pendo.io.d1.a.b().a(sdk.pendo.io.d1.i.DEFAULT_PATH_LEAF_TO_NULL, sdk.pendo.io.d1.i.SUPPRESS_EXCEPTIONS)).a(jSONObject.toString());
                        StepLocationModel location = trigger.getLocation();
                        sdk.pendo.io.r1.a aVar = (sdk.pendo.io.r1.a) bVarA.a(location != null ? location.getFeatureSelector() : str, new l[0]);
                        if (aVar != null && !aVar.isEmpty()) {
                            Object obj4 = map3.get(ViewProps.POSITION);
                            Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
                            Map map4 = (Map) obj4;
                            sdk.pendo.io.s7.e eVarA = sdk.pendo.io.s7.e.INSTANCE.a();
                            Activity activityA = sdk.pendo.io.d6.c.h().a();
                            Intrinsics.checkNotNullExpressionValue(activityA, "getCurrentVisibleActivity(...)");
                            Object obj5 = map4.get("left");
                            Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type kotlin.Double");
                            double dDoubleValue = ((Double) obj5).doubleValue();
                            Object obj6 = map4.get(ViewProps.TOP);
                            Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type kotlin.Double");
                            double dDoubleValue2 = ((Double) obj6).doubleValue();
                            Object obj7 = map4.get("width");
                            Intrinsics.checkNotNull(obj7, "null cannot be cast to non-null type kotlin.Double");
                            double dDoubleValue3 = ((Double) obj7).doubleValue();
                            Object obj8 = map4.get("height");
                            Intrinsics.checkNotNull(obj8, "null cannot be cast to non-null type kotlin.Double");
                            double dDoubleValue4 = ((Double) obj8).doubleValue();
                            StepLocationModel location2 = trigger.getLocation();
                            arrayList.add(new ElementInfoAndViewRef(jSONObject, new WeakReference(sdk.pendo.io.s7.e.a(eVarA, activityA, dDoubleValue, dDoubleValue2, dDoubleValue3, dDoubleValue4, location2 != null ? location2.getFeatureSelector() : null, null, null, null, 448, null)), trigger));
                        }
                    } catch (Exception e2) {
                        String message = e2.getMessage();
                        if (message == null) {
                            message = " FlutterScreenManager getMatchingElementsIfExist jsonPath";
                        }
                        PendoLogger.w(e2, message, new Object[0]);
                    }
                    str = null;
                }
                Object obj9 = map2.get("children");
                Intrinsics.checkNotNull(obj9, "null cannot be cast to non-null type java.util.ArrayList<*>{ kotlin.collections.TypeAliasesKt.ArrayList<*> }");
                for (Object obj10 : (ArrayList) obj9) {
                    Intrinsics.checkNotNull(obj10, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
                    arrayList2.add((Map) obj10);
                }
                str = null;
            }
        } catch (Exception e3) {
            PendoLogger.w(e3, e3.getMessage(), " FlutterScreenManager getMatchingElementsIfExist");
        }
        return arrayList;
    }

    @Override // sdk.pendo.io.x6.i
    public Object getScreenData$pendoIO_release(boolean z, boolean z2, Continuation<? super JSONObject> continuation) {
        return this.retroactiveScreenData;
    }

    @Override // sdk.pendo.io.x6.i, sdk.pendo.io.x6.d
    public Object getScreenDataForCapture(Continuation<? super JSONObject> continuation) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = this.retroactiveScreenDataForCapture;
        if (jSONObject2 == null) {
            return jSONObject;
        }
        Intrinsics.checkNotNull(jSONObject2);
        this.retroactiveScreenDataForCapture = null;
        return jSONObject2;
    }

    @Override // sdk.pendo.io.x6.i, sdk.pendo.io.x6.d
    public JSONArray getViewTreeDataForCapture() {
        JSONArray jSONArray = new JSONArray();
        if (this.abstractViewTreeDataForCapture == null) {
            return jSONArray;
        }
        try {
            ArrayList arrayList = new ArrayList();
            Map<?, ?> map = this.abstractViewTreeDataForCapture;
            Intrinsics.checkNotNull(map);
            Object obj = map.get("root");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
            arrayList.add((Map) obj);
            while (!arrayList.isEmpty()) {
                Object objRemove = arrayList.remove(CollectionsKt.getLastIndex(arrayList));
                Intrinsics.checkNotNullExpressionValue(objRemove, "removeAt(...)");
                Map map2 = (Map) objRemove;
                Object obj2 = map2.get(IdentificationData.SERIALIZED_NAME);
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
                jSONArray.put(new JSONObject((Map) obj2));
                Object obj3 = map2.get("children");
                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type java.util.ArrayList<*>{ kotlin.collections.TypeAliasesKt.ArrayList<*> }");
                for (Object obj4 : (ArrayList) obj3) {
                    Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
                    arrayList.add((Map) obj4);
                }
            }
        } catch (Exception e2) {
            PendoLogger.w("FlutterScreenManager", "getViewTreeDataForCapture: " + e2.getMessage());
        }
        this.abstractViewTreeDataForCapture = null;
        return jSONArray;
    }

    @Override // sdk.pendo.io.sdk.flutter.IFlutterEventsCallback
    public void newScreenIdentified(String screenName, Map<String, ? extends Object> info) {
        Intrinsics.checkNotNullParameter(screenName, "screenName");
        Intrinsics.checkNotNullParameter(info, "info");
        x.a(getSmCoroutineScope(), getScreenManagerMutex(), null, null, new c(screenName, info, this, null), 6, null);
    }

    @Override // sdk.pendo.io.f6.d
    public void onGetAccessTokenResponseReceived(GetAuthToken.GetAuthTokenResponse response) {
    }

    @Override // sdk.pendo.io.sdk.flutter.IFlutterEventsCallback
    public void screenContentChanged(String screenName, Map<String, ? extends Object> info) {
        Intrinsics.checkNotNullParameter(screenName, "screenName");
        Intrinsics.checkNotNullParameter(info, "info");
        x.a(getSmCoroutineScope(), getScreenManagerMutex(), null, null, new d(screenName, info, this, null), 6, null);
    }

    @Override // sdk.pendo.io.sdk.flutter.IFlutterEventsCallback
    public void screenDataForCaptureReady(Map<String, ? extends Object> info) {
        if (info != null) {
            Object obj = info.get(ActivationManager.SCREEN_DATA_KEY);
            Map map = obj instanceof Map ? (Map) obj : null;
            if (map != null) {
                this.retroactiveScreenDataForCapture = new JSONObject(map);
            }
            Object obj2 = info.get("tree");
            Map<?, ?> map2 = obj2 instanceof Map ? (Map) obj2 : null;
            if (map2 != null) {
                this.abstractViewTreeDataForCapture = map2;
            }
        }
        this.captureScreenDataSubject.onNext(new t0());
    }

    @Override // sdk.pendo.io.sdk.flutter.IFlutterEventsCallback
    public void sendLogToBE(Map<String, ? extends Object> info) {
        if (info == null) {
            return;
        }
        Object obj = info.get("message");
        String str = obj instanceof String ? (String) obj : null;
        if (str != null) {
            Object obj2 = info.get("stackTrace");
            String str2 = obj2 instanceof String ? (String) obj2 : null;
            if (str2 != null) {
                str = str + " | with stacktrace: " + str2;
            }
            PendoLogger.e("FlutterScreenManager", str, (Throwable) null);
        }
    }

    @Override // sdk.pendo.io.sdk.flutter.IFlutterEventsCallback
    public void sendSREventData(Map<String, ? extends Object> srEventData) {
        if (srEventData == null) {
            PendoLogger.w("FlutterScreenManager", "sendSREventData: received null SR event data");
            return;
        }
        PendoLogger.d("FlutterScreenManager", "sendSREventData: received SR event data: " + srEventData);
        try {
            PendoLogger.i("FlutterScreenManager", "Processing Flutter SR event data with keys: " + srEventData.keySet());
        } catch (Exception e2) {
            PendoLogger.e("FlutterScreenManager", "Error processing SR event data from Flutter", e2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0048, code lost:
    
        if (super.setNewScreenId$pendoIO_release(r6, true, r0) == r1) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0051, code lost:
    
        if (super.setNewScreenId$pendoIO_release(r6, r7, r0) == r1) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0053, code lost:
    
        return r1;
     */
    @Override // sdk.pendo.io.x6.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object setNewScreenId$pendoIO_release(java.lang.String r6, boolean r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof sdk.pendo.io.sdk.flutter.FlutterScreenManager.e
            if (r0 == 0) goto L13
            r0 = r8
            sdk.pendo.io.sdk.flutter.FlutterScreenManager$e r0 = (sdk.pendo.io.sdk.flutter.FlutterScreenManager.e) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            sdk.pendo.io.sdk.flutter.FlutterScreenManager$e r0 = new sdk.pendo.io.sdk.flutter.FlutterScreenManager$e
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L39
            if (r2 == r4) goto L31
            if (r2 != r3) goto L29
            goto L31
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            java.lang.Object r5 = r0.a
            sdk.pendo.io.sdk.flutter.FlutterScreenManager r5 = (sdk.pendo.io.sdk.flutter.FlutterScreenManager) r5
            kotlin.ResultKt.throwOnFailure(r8)
            goto L54
        L39:
            kotlin.ResultKt.throwOnFailure(r8)
            boolean r8 = r5.newScreenDetected
            r0.a = r5
            if (r8 == 0) goto L4b
            r0.d = r4
            java.lang.Object r6 = super.setNewScreenId$pendoIO_release(r6, r4, r0)
            if (r6 != r1) goto L54
            goto L53
        L4b:
            r0.d = r3
            java.lang.Object r6 = super.setNewScreenId$pendoIO_release(r6, r7, r0)
            if (r6 != r1) goto L54
        L53:
            return r1
        L54:
            r6 = 0
            r5.newScreenDetected = r6
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.sdk.flutter.FlutterScreenManager.setNewScreenId$pendoIO_release(java.lang.String, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public /* synthetic */ FlutterScreenManager(Pendo.PendoOptions pendoOptions, IFlutterBridge iFlutterBridge, m mVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(pendoOptions, iFlutterBridge, (i & 4) != 0 ? new k() : mVar);
    }

    public final void a(String screenName, Map<String, ? extends Object> info) {
        Intrinsics.checkNotNullParameter(screenName, "screenName");
        Intrinsics.checkNotNullParameter(info, "info");
        this.flutterScreenName = screenName;
        Object obj = info.get(ActivationManager.SCREEN_DATA_KEY);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
        this.retroactiveScreenData = new JSONObject((Map) obj);
        Object obj2 = info.get("tree");
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
        this.abstractViewTree = (Map) obj2;
    }

    public final Map<?, ?> a() {
        return this.abstractViewTree;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean a(i0 pendoAnchorView, Map<Object, ? extends Object> abstractViewTreeMap) {
        boolean z;
        boolean z2 = true;
        z2 = true;
        try {
            String featureSelector = pendoAnchorView.getFeatureSelector();
            if (featureSelector == null) {
                return true;
            }
            ArrayList arrayList = new ArrayList();
            Object obj = abstractViewTreeMap.get("root");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
            arrayList.add((Map) obj);
            PendoLogger.d("FlutterScreenManager", "isAnchorViewPositionChanged current position: x:" + pendoAnchorView.getX() + ", y:" + pendoAnchorView.getY() + ", width:" + pendoAnchorView.getWidth() + ", height:" + pendoAnchorView.getHeight());
            while (!arrayList.isEmpty()) {
                Object objRemove = arrayList.remove(CollectionsKt.getLastIndex(arrayList));
                Intrinsics.checkNotNullExpressionValue(objRemove, "removeAt(...)");
                Map map = (Map) objRemove;
                Object obj2 = map.get(IdentificationData.SERIALIZED_NAME);
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
                Map map2 = (Map) obj2;
                JSONObject jSONObject = new JSONObject();
                Object obj3 = map2.get("retroElementInfo");
                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
                JSONObject jSONObjectPut = jSONObject.put("retroElementInfo", new JSONObject((Map) obj3));
                sdk.pendo.io.d1.a aVarB = sdk.pendo.io.d1.a.b();
                sdk.pendo.io.d1.i[] iVarArr = new sdk.pendo.io.d1.i[2];
                sdk.pendo.io.d1.i iVar = sdk.pendo.io.d1.i.DEFAULT_PATH_LEAF_TO_NULL;
                z = z2 ? 1 : 0;
                try {
                    iVarArr[0] = iVar;
                    iVarArr[z ? 1 : 0] = sdk.pendo.io.d1.i.SUPPRESS_EXCEPTIONS;
                    sdk.pendo.io.r1.a aVar = (sdk.pendo.io.r1.a) g.a(aVarB.a(iVarArr)).a(jSONObjectPut.toString()).a(featureSelector, new l[0]);
                    if (aVar != null && !aVar.isEmpty()) {
                        Object obj4 = map2.get(ViewProps.POSITION);
                        Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
                        Map map3 = (Map) obj4;
                        Object obj5 = map3.get("left");
                        Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type kotlin.Double");
                        float fDoubleValue = (float) ((Double) obj5).doubleValue();
                        Object obj6 = map3.get(ViewProps.TOP);
                        Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type kotlin.Double");
                        float fDoubleValue2 = (float) ((Double) obj6).doubleValue();
                        Object obj7 = map3.get("width");
                        Intrinsics.checkNotNull(obj7, "null cannot be cast to non-null type kotlin.Double");
                        int iDoubleValue = (int) ((Double) obj7).doubleValue();
                        Object obj8 = map3.get("height");
                        Intrinsics.checkNotNull(obj8, "null cannot be cast to non-null type kotlin.Double");
                        int iDoubleValue2 = (int) ((Double) obj8).doubleValue();
                        PendoLogger.d("FlutterScreenManager", "isAnchorViewPositionChanged new position: x:" + fDoubleValue + ", y:" + fDoubleValue2 + ", width:" + iDoubleValue + ", height:" + iDoubleValue2);
                        if (fDoubleValue == pendoAnchorView.getX() && fDoubleValue2 == pendoAnchorView.getY() && iDoubleValue == pendoAnchorView.getWidth() && iDoubleValue2 == pendoAnchorView.getHeight()) {
                            return false;
                        }
                        return z;
                    }
                    Object obj9 = map.get("children");
                    Intrinsics.checkNotNull(obj9, "null cannot be cast to non-null type java.util.ArrayList<*>{ kotlin.collections.TypeAliasesKt.ArrayList<*> }");
                    for (Object obj10 : (ArrayList) obj9) {
                        Intrinsics.checkNotNull(obj10, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
                        arrayList.add((Map) obj10);
                    }
                    z2 = z ? 1 : 0;
                } catch (Exception e2) {
                    e = e2;
                }
            }
            return z2 ? 1 : 0;
        } catch (Exception e3) {
            e = e3;
            z = z2;
        }
        PendoLogger.w(e, e.getMessage(), " FlutterScreenManager isAnchorViewPositionChanged");
        return z;
    }

    public final void a(boolean z) {
        this.newScreenDetected = z;
    }
}
