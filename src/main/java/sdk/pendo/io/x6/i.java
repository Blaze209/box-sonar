package sdk.pendo.io.x6;

import android.app.Activity;
import android.content.Context;
import android.view.GestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.box.android.browse.fragments.BoxSearchFragment;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.json.JSONArray;
import org.json.JSONObject;
import sdk.pendo.io.Pendo;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.actions.ActivationManager;
import sdk.pendo.io.actions.ElementInfoAndViewRef;
import sdk.pendo.io.listeners.views.OnElementInScreenFoundListener;
import sdk.pendo.io.listeners.views.PendoDrawerListener;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.StepLocationModel;
import sdk.pendo.io.s7.b0;
import sdk.pendo.io.s7.b1;
import sdk.pendo.io.s7.e1;
import sdk.pendo.io.s7.x;
import sdk.pendo.io.sdk.react.PlatformStateManager;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u008a\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b \u0018\u0000 Ô\u00012\u00020\u00012\u00020\u0002:\u0002Õ\u0001B\u001d\u0012\b\u0010Ñ\u0001\u001a\u00030Ð\u0001\u0012\b\b\u0002\u0010n\u001a\u00020m¢\u0006\u0006\bÒ\u0001\u0010Ó\u0001J#\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0082@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0002J\u0013\u0010\u000e\u001a\u00020\rH\u0082@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0010\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001b\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0003H\u0090@ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u001a\u001a\u00020\rH\u0090@ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u000fJ\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001d\u0010\u001e\u001a\u00020\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010!\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u0011H\u0016J\u0016\u0010#\u001a\u00020\r2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020 0\u0011H\u0016J\u000f\u0010&\u001a\u00020\rH\u0010¢\u0006\u0004\b$\u0010%J\b\u0010'\u001a\u00020\rH\u0016J\u0010\u0010*\u001a\u00020\r2\u0006\u0010)\u001a\u00020(H\u0016J\u0010\u0010+\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016JP\u00107\u001a\u00020\r2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020,2\u0006\u0010/\u001a\u00020,2\u0006\u00100\u001a\u00020,2\u0006\u00101\u001a\u00020,2\u0006\u00102\u001a\u00020,2\u0006\u00103\u001a\u00020,2\u0006\u00105\u001a\u0002042\u0006\u00106\u001a\u00020,H\u0016J\u0013\u00109\u001a\u000208H\u0096@ø\u0001\u0000¢\u0006\u0004\b9\u0010\u000fJ\b\u0010;\u001a\u00020:H\u0016J#\u0010=\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020<H\u0096@ø\u0001\u0000¢\u0006\u0004\b=\u0010>J\u0010\u0010A\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010?H\u0016J\u000e\u0010B\u001a\b\u0012\u0004\u0012\u00020@0?H\u0016J\b\u0010C\u001a\u00020\rH\u0016J\n\u0010D\u001a\u0004\u0018\u000108H\u0016J\n\u0010E\u001a\u0004\u0018\u000108H\u0016J\b\u0010F\u001a\u00020@H\u0016J\u000f\u0010I\u001a\u00020,H\u0000¢\u0006\u0004\bG\u0010HJ\u0013\u0010K\u001a\u00020\rH\u0090@ø\u0001\u0000¢\u0006\u0004\bJ\u0010\u000fJ\u0013\u0010L\u001a\u00020\rH\u0096@ø\u0001\u0000¢\u0006\u0004\bL\u0010\u000fJ\u000f\u0010N\u001a\u00020,H\u0000¢\u0006\u0004\bM\u0010HJ\u0013\u0010P\u001a\u00020\rH\u0090@ø\u0001\u0000¢\u0006\u0004\bO\u0010\u000fJ\u0013\u0010Q\u001a\u00020\rH\u0086@ø\u0001\u0000¢\u0006\u0004\bQ\u0010\u000fJ\u001f\u0010S\u001a\u0004\u0018\u00010R2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096@ø\u0001\u0000¢\u0006\u0004\bS\u0010\u0017J#\u0010X\u001a\u0002082\u0006\u0010T\u001a\u00020,2\u0006\u0010U\u001a\u00020,H @ø\u0001\u0000¢\u0006\u0004\bV\u0010WJ'\u0010]\u001a\u00020\r2\b\u0010Y\u001a\u0004\u0018\u00010@2\b\b\u0002\u0010Z\u001a\u00020,H\u0090@ø\u0001\u0000¢\u0006\u0004\b[\u0010\\J\u0013\u0010_\u001a\u00020@H @ø\u0001\u0000¢\u0006\u0004\b^\u0010\u000fJ\u0018\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010`\u001a\u00020\u000bH\u0014J\u001e\u0010e\u001a\n\u0012\u0004\u0012\u00020d\u0018\u00010a2\f\u0010c\u001a\b\u0012\u0004\u0012\u00020b0aH\u0016J+\u0010j\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00112\u0006\u0010f\u001a\u0002082\f\u0010g\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0011H\u0000¢\u0006\u0004\bh\u0010iJ\b\u0010k\u001a\u00020\rH\u0016J\u0013\u0010l\u001a\u00020\rH\u0096@ø\u0001\u0000¢\u0006\u0004\bl\u0010\u000fR\u0017\u0010n\u001a\u00020m8\u0006¢\u0006\f\n\u0004\bn\u0010o\u001a\u0004\bp\u0010qR\u001a\u0010s\u001a\u00020r8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bs\u0010t\u001a\u0004\bu\u0010vR\u0014\u0010x\u001a\u00020w8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bx\u0010yR\u0016\u0010{\u001a\u00020z8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010|R\u001c\u0010~\u001a\u00020}8\u0004X\u0084\u0004¢\u0006\u000e\n\u0004\b~\u0010\u007f\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R2\u0010\u0083\u0001\u001a\u000b\u0012\u0004\u0012\u00020\r\u0018\u00010\u0082\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u0083\u0001\u0010\u0084\u0001\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001\"\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001c\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u0089\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R\u0017\u0010\u008c\u0001\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R(\u0010\u008e\u0001\u001a\u00020,8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0006\b\u008e\u0001\u0010\u008f\u0001\u001a\u0005\b\u0090\u0001\u0010H\"\u0006\b\u0091\u0001\u0010\u0092\u0001R)\u0010\u0093\u0001\u001a\u00020@8\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u0093\u0001\u0010\u0094\u0001\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001\"\u0006\b\u0097\u0001\u0010\u0098\u0001R)\u0010\u0099\u0001\u001a\u00020@8\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u0099\u0001\u0010\u0094\u0001\u001a\u0006\b\u009a\u0001\u0010\u0096\u0001\"\u0006\b\u009b\u0001\u0010\u0098\u0001R6\u0010\u009d\u0001\u001a\u0004\u0018\u0001082\t\u0010\u009c\u0001\u001a\u0004\u0018\u0001088\u0000@@X\u0080\u000e¢\u0006\u0018\n\u0006\b\u009d\u0001\u0010\u009e\u0001\u001a\u0006\b\u009f\u0001\u0010 \u0001\"\u0006\b¡\u0001\u0010¢\u0001R\u001b\u0010£\u0001\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b£\u0001\u0010\u009e\u0001R%\u0010¥\u0001\u001a\t\u0012\u0004\u0012\u00020@0¤\u00018\u0004X\u0084\u0004¢\u0006\u000f\n\u0006\b¥\u0001\u0010¦\u0001\u001a\u0005\bA\u0010§\u0001R%\u0010¨\u0001\u001a\t\u0012\u0004\u0012\u00020@0¤\u00018\u0004X\u0084\u0004¢\u0006\u000f\n\u0006\b¨\u0001\u0010¦\u0001\u001a\u0005\bB\u0010§\u0001R1\u0010©\u0001\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u00118\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b©\u0001\u0010ª\u0001\u001a\u0006\b«\u0001\u0010¬\u0001\"\u0006\b\u00ad\u0001\u0010®\u0001R1\u0010¯\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00118\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b¯\u0001\u0010ª\u0001\u001a\u0006\b°\u0001\u0010¬\u0001\"\u0006\b±\u0001\u0010®\u0001R+\u0010²\u0001\u001a\u0004\u0018\u00010R8\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b²\u0001\u0010³\u0001\u001a\u0006\b´\u0001\u0010µ\u0001\"\u0006\b¶\u0001\u0010·\u0001R,\u0010¹\u0001\u001a\u0005\u0018\u00010¸\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b¹\u0001\u0010º\u0001\u001a\u0006\b»\u0001\u0010¼\u0001\"\u0006\b½\u0001\u0010¾\u0001R(\u0010¿\u0001\u001a\u00020,8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0006\b¿\u0001\u0010\u008f\u0001\u001a\u0005\bÀ\u0001\u0010H\"\u0006\bÁ\u0001\u0010\u0092\u0001R!\u0010Ç\u0001\u001a\u00030Â\u00018PX\u0090\u0084\u0002¢\u0006\u0010\n\u0006\bÃ\u0001\u0010Ä\u0001\u001a\u0006\bÅ\u0001\u0010Æ\u0001R\u001f\u0010\u0006\u001a\u00020\u00058@X\u0080\u0084\u0002¢\u0006\u0010\n\u0006\bÈ\u0001\u0010Ä\u0001\u001a\u0006\bÉ\u0001\u0010Ê\u0001R*\u0010Î\u0001\u001a\u0013\u0012\u0005\u0012\u00030Ì\u0001\u0012\u0005\u0012\u00030Í\u0001\u0018\u00010Ë\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÎ\u0001\u0010Ï\u0001\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006Ö\u0001"}, d2 = {"Lsdk/pendo/io/x6/i;", "Lsdk/pendo/io/x6/d;", "Lsdk/pendo/io/w5/a;", "Landroid/app/Activity;", "activity", "Lsdk/pendo/io/v6/i;", "pendoGestureListener", "Landroid/view/GestureDetector;", "createGestureDetector", "(Landroid/app/Activity;Lsdk/pendo/io/v6/i;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Landroid/view/View;", "getCurrentScreenContentRoots", "", "removePendoGlobalClickInterceptor", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearResources", "Ljava/lang/ref/WeakReference;", "getCurrentActivity", "Lsdk/pendo/io/x6/k;", "getScreenManagerPolicy", "onActivityResumed", "onActivityResumedInternal$pendoIO_release", "(Landroid/app/Activity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onActivityResumedInternal", "handleVeryFirstScreen$pendoIO_release", "handleVeryFirstScreen", "onActivityPaused", "Landroid/view/Window;", "window", "addGlobalClicksInterceptor", "(Landroid/view/Window;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lsdk/pendo/io/listeners/views/PendoDrawerListener;", "getPendoDrawerListenerRef", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setPendoDrawerListenerRef", "cancelScreenManagerCoroutineJobs$pendoIO_release", "()V", "cancelScreenManagerCoroutineJobs", "handleScreenChanges", "Lsdk/pendo/io/x6/g;", "triggerEvent", "onGlobalLayoutChangeEvent", "onActivityDestroyed", "", "includePageViewTexts", "includeFeatureClickTexts", "includeFeatureClickNestedTexts", "includeRetroElementCompatibilityHashes", "isOldScreenIdFormat", "ignoreDynamicFragmentsInScrollView", "isRespondToScrollChangeEventsForScreenId", "", "globalLayoutChangeDebouncer", "shouldDetectClicksForAccessibility", "setPolicy", "Lorg/json/JSONObject;", "getScreenDataForCapture", "Lorg/json/JSONArray;", "getViewTreeDataForCapture", "Lsdk/pendo/io/t7/c;", "generateScreenshotBitmap", "(Landroid/app/Activity;Lsdk/pendo/io/t7/c;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lsdk/pendo/io/k3/j;", "", "getScreenChangedNewScreenIdSubject", "getScreenLayoutChangedSameScreenIdSubject", "triggerManualNewScreenIdSubject", "getCurrentScreenData", "getPreviousScreenData", "getCurrentScreenId", "shouldIgnoreChangesInApp$pendoIO_release", "()Z", "shouldIgnoreChangesInApp", "handleNewScreenIdentified$pendoIO_release", "handleNewScreenIdentified", "handleSameScreenIdentified", "shouldListenToAppChanges$pendoIO_release", "shouldListenToAppChanges", "calculateScreenIdentifierAndScreenData$pendoIO_release", "calculateScreenIdentifierAndScreenData", "setupTouchInterceptor", "Lsdk/pendo/io/s7/e1$a;", "calculateCurrentRootViewData", "includeText", "isForCapture", "getScreenData$pendoIO_release", "(ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getScreenData", "newScreenId", "forceNotifyNewScreen", "setNewScreenId$pendoIO_release", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setNewScreenId", "calculateScreenId$pendoIO_release", "calculateScreenId", "rootView", "", "Lsdk/pendo/io/actions/ActivationManager$Trigger;", "triggerList", "Lsdk/pendo/io/actions/ElementInfoAndViewRef;", "getMatchingElementsIfExist", "viewAsJson", "viewRef", "createViewRefIfNeeded$pendoIO_release", "(Lorg/json/JSONObject;Ljava/lang/ref/WeakReference;)Ljava/lang/ref/WeakReference;", "createViewRefIfNeeded", "onSessionEnd", "clearInternal", "Lsdk/pendo/io/s7/m;", "dispatcherProvider", "Lsdk/pendo/io/s7/m;", "getDispatcherProvider", "()Lsdk/pendo/io/s7/m;", "Lkotlinx/coroutines/sync/Mutex;", "screenManagerMutex", "Lkotlinx/coroutines/sync/Mutex;", "getScreenManagerMutex$pendoIO_release", "()Lkotlinx/coroutines/sync/Mutex;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "smCoroutineExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlinx/coroutines/CompletableJob;", "smCoroutineScopeMainJob", "Lkotlinx/coroutines/CompletableJob;", "Lkotlinx/coroutines/CoroutineScope;", "smCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getSmCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "screenContentChangeFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "getScreenContentChangeFlow$pendoIO_release", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "setScreenContentChangeFlow$pendoIO_release", "(Lkotlinx/coroutines/flow/MutableSharedFlow;)V", "Lkotlinx/coroutines/Job;", "screenContentChangeCollectionJob", "Lkotlinx/coroutines/Job;", "screenManagerPolicy", "Lsdk/pendo/io/x6/k;", "disableGlobalClickInterceptor", "Z", "getDisableGlobalClickInterceptor$pendoIO_release", "setDisableGlobalClickInterceptor$pendoIO_release", "(Z)V", "currentScreenId", "Ljava/lang/String;", "getCurrentScreenId$pendoIO_release", "()Ljava/lang/String;", "setCurrentScreenId$pendoIO_release", "(Ljava/lang/String;)V", "previousScreenId", "getPreviousScreenId$pendoIO_release", "setPreviousScreenId$pendoIO_release", "newValue", "currentScreenData", "Lorg/json/JSONObject;", "getCurrentScreenData$pendoIO_release", "()Lorg/json/JSONObject;", "setCurrentScreenData$pendoIO_release", "(Lorg/json/JSONObject;)V", "previousScreenData", "Lsdk/pendo/io/j4/b;", "screenChangedNewScreenIdSubject", "Lsdk/pendo/io/j4/b;", "()Lsdk/pendo/io/j4/b;", "screenLayoutChangedSameScreenIdSubject", "pendoDrawerListenerRef", "Ljava/lang/ref/WeakReference;", "getPendoDrawerListenerRef$pendoIO_release", "()Ljava/lang/ref/WeakReference;", "setPendoDrawerListenerRef$pendoIO_release", "(Ljava/lang/ref/WeakReference;)V", "currentActivityRef", "getCurrentActivityRef$pendoIO_release", "setCurrentActivityRef$pendoIO_release", "currentRootViewData", "Lsdk/pendo/io/s7/e1$a;", "getCurrentRootViewData$pendoIO_release", "()Lsdk/pendo/io/s7/e1$a;", "setCurrentRootViewData$pendoIO_release", "(Lsdk/pendo/io/s7/e1$a;)V", "Lsdk/pendo/io/x6/a;", "focusHandler", "Lsdk/pendo/io/x6/a;", "getFocusHandler$pendoIO_release", "()Lsdk/pendo/io/x6/a;", "setFocusHandler$pendoIO_release", "(Lsdk/pendo/io/x6/a;)V", "forceScreenScanOnScreenContentChange", "getForceScreenScanOnScreenContentChange$pendoIO_release", "setForceScreenScanOnScreenContentChange$pendoIO_release", "Lsdk/pendo/io/s7/b0;", "motionEventHandler$delegate", "Lkotlin/Lazy;", "getMotionEventHandler$pendoIO_release", "()Lsdk/pendo/io/s7/b0;", "motionEventHandler", "pendoGestureListener$delegate", "getPendoGestureListener$pendoIO_release", "()Lsdk/pendo/io/v6/i;", "Lkotlin/Pair;", "Landroid/view/ViewGroup;", "Lsdk/pendo/io/s5/c;", "globalClickObserverEntry", "Lkotlin/Pair;", "Lsdk/pendo/io/Pendo$PendoOptions;", "pendoOptions", "<init>", "(Lsdk/pendo/io/Pendo$PendoOptions;Lsdk/pendo/io/s7/m;)V", "Companion", "b", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public abstract class i implements sdk.pendo.io.x6.d, sdk.pendo.io.w5.a {
    public static final String BOTTOM_SHEET_ID = "__BOTTOM_SHEET__";
    public static final String DIALOG_ID = "__DIALOG__";
    public static final String DRAWER_ID = "__DRAWER__";
    public static final String FRAGMENTS_SEPARATOR = "_F_";
    public static final String NEW_DELIMITER = "|";
    public static final int NOT_VALID = -1;
    public static final String OLD_DELIMITER = "";
    public static final String PANEL_ID = "__PANEL__";
    private static final long SCREEN_CONTENT_CHANGE_TIMEOUT = 100;
    private static final String TAG = "ScreenManagerBase";
    private WeakReference<Activity> currentActivityRef;
    private e1.a currentRootViewData;
    private volatile JSONObject currentScreenData;
    private volatile String currentScreenId;
    private volatile boolean disableGlobalClickInterceptor;
    private final sdk.pendo.io.s7.m dispatcherProvider;
    private sdk.pendo.io.x6.a focusHandler;
    private boolean forceScreenScanOnScreenContentChange;
    private Pair<? extends ViewGroup, ? extends sdk.pendo.io.s5.c> globalClickObserverEntry;

    /* JADX INFO: renamed from: motionEventHandler$delegate, reason: from kotlin metadata */
    private final Lazy motionEventHandler;
    private WeakReference<PendoDrawerListener> pendoDrawerListenerRef;

    /* JADX INFO: renamed from: pendoGestureListener$delegate, reason: from kotlin metadata */
    private final Lazy pendoGestureListener;
    private volatile JSONObject previousScreenData;
    private volatile String previousScreenId;
    private final sdk.pendo.io.j4.b<String> screenChangedNewScreenIdSubject;
    private Job screenContentChangeCollectionJob;
    private MutableSharedFlow<Unit> screenContentChangeFlow;
    private final sdk.pendo.io.j4.b<String> screenLayoutChangedSameScreenIdSubject;
    private final Mutex screenManagerMutex;
    private final sdk.pendo.io.x6.k screenManagerPolicy;
    private final CoroutineExceptionHandler smCoroutineExceptionHandler;
    private final CoroutineScope smCoroutineScope;
    private CompletableJob smCoroutineScopeMainJob;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Regex specialCharsRegex = new Regex("[^\\dA-Za-z0-9_|]");

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sdk.manager.screenmanager.ScreenManagerBase$1", f = "ScreenManagerBase.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;

        a(Continuation<? super a> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return i.this.new a(continuation);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            i.this.screenManagerPolicy.o();
            if (!i.this.screenManagerPolicy.getDisableBackCapture()) {
                i.this.setFocusHandler$pendoIO_release(new sdk.pendo.io.x6.a(null, 1, 0 == true ? 1 : 0));
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: sdk.pendo.io.x6.i$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\tR\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0011\u001a\u00020\u00108\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u000bR\u0014\u0010\u0014\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u000bR\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u000b¨\u0006\u001b"}, d2 = {"Lsdk/pendo/io/x6/i$b;", "", "", "screenId", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lkotlin/text/Regex;", "specialCharsRegex", "Lkotlin/text/Regex;", "()Lkotlin/text/Regex;", "BOTTOM_SHEET_ID", "Ljava/lang/String;", "DIALOG_ID", "DRAWER_ID", "FRAGMENTS_SEPARATOR", "NEW_DELIMITER", "", "NOT_VALID", "I", "OLD_DELIMITER", "PANEL_ID", "", "SCREEN_CONTENT_CHANGE_TIMEOUT", "J", "TAG", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Regex a() {
            return i.specialCharsRegex;
        }

        public final boolean a(String screenId) {
            Intrinsics.checkNotNullParameter(screenId, "screenId");
            return Intrinsics.areEqual(screenId, i.DIALOG_ID) || Intrinsics.areEqual(screenId, i.PANEL_ID) || Intrinsics.areEqual(screenId, i.DRAWER_ID) || Intrinsics.areEqual(screenId, i.BOTTOM_SHEET_ID);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sdk.manager.screenmanager.ScreenManagerBase$addGlobalClicksInterceptor$2", f = "ScreenManagerBase.kt", i = {0, 0}, l = {282}, m = "invokeSuspend", n = {"decorView", "it"}, s = {"L$0", "L$2"})
    static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object a;
        Object b;
        int c;
        private /* synthetic */ Object d;
        final /* synthetic */ Window e;
        final /* synthetic */ i f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Window window, i iVar, Continuation<? super c> continuation) {
            super(2, continuation);
            this.e = window;
            this.f = iVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            c cVar = new c(this.e, this.f, continuation);
            cVar.d = obj;
            return cVar;
        }

        /* JADX WARN: Code duplicated, block: B:32:0x00c7  */
        /* JADX WARN: Code duplicated, block: B:33:0x00d1  */
        /* JADX WARN: Code duplicated, block: B:35:0x00e3 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:36:0x00e4  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Activity activity;
            Object objCreateGestureDetector;
            ViewGroup viewGroup;
            i iVar;
            ViewGroup viewGroup2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.c;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (PlatformStateManager.INSTANCE.isFlutterCodelessApp()) {
                    return Unit.INSTANCE;
                }
                Window window = this.e;
                View decorView = window != null ? window.getDecorView() : null;
                ViewGroup viewGroup3 = decorView instanceof ViewGroup ? (ViewGroup) decorView : null;
                if (viewGroup3 == null) {
                    PendoLogger.i(i.TAG, "addGlobalClicksInterceptor -> window is null");
                } else {
                    i iVar2 = this.f;
                    Pair pair = iVar2.globalClickObserverEntry;
                    if (pair != null) {
                        ViewGroup viewGroup4 = (ViewGroup) pair.component1();
                        sdk.pendo.io.s5.c cVar = (sdk.pendo.io.s5.c) pair.component2();
                        if (viewGroup4 != viewGroup3) {
                            PendoLogger.d(i.TAG, "addGlobalClicksInterceptor -> moving global click observer from decorView " + viewGroup4.hashCode() + " to " + viewGroup3.hashCode());
                            sdk.pendo.io.s5.a.a.b(viewGroup4, cVar);
                            iVar2.globalClickObserverEntry = null;
                            activity = iVar2.getCurrentActivityRef$pendoIO_release().get();
                            if (activity == null) {
                                PendoLogger.d(i.TAG, "addGlobalClicksInterceptor -> current activity is null");
                            } else {
                                sdk.pendo.io.v6.i pendoGestureListener$pendoIO_release = iVar2.getPendoGestureListener$pendoIO_release();
                                this.d = viewGroup3;
                                this.a = iVar2;
                                this.b = viewGroup3;
                                this.c = 1;
                                objCreateGestureDetector = iVar2.createGestureDetector(activity, pendoGestureListener$pendoIO_release, this);
                                if (objCreateGestureDetector == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                viewGroup = viewGroup3;
                                iVar = iVar2;
                                obj = objCreateGestureDetector;
                                viewGroup2 = viewGroup;
                            }
                        } else {
                            PendoLogger.d(i.TAG, "addGlobalClicksInterceptor -> Pendo Touch Interceptor is already attached to " + viewGroup3.hashCode());
                        }
                    } else {
                        activity = iVar2.getCurrentActivityRef$pendoIO_release().get();
                        if (activity == null) {
                            PendoLogger.d(i.TAG, "addGlobalClicksInterceptor -> current activity is null");
                        } else {
                            sdk.pendo.io.v6.i pendoGestureListener$pendoIO_release2 = iVar2.getPendoGestureListener$pendoIO_release();
                            this.d = viewGroup3;
                            this.a = iVar2;
                            this.b = viewGroup3;
                            this.c = 1;
                            objCreateGestureDetector = iVar2.createGestureDetector(activity, pendoGestureListener$pendoIO_release2, this);
                            if (objCreateGestureDetector == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            viewGroup = viewGroup3;
                            iVar = iVar2;
                            obj = objCreateGestureDetector;
                            viewGroup2 = viewGroup;
                        }
                    }
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            viewGroup = (ViewGroup) this.b;
            iVar = (i) this.a;
            viewGroup2 = (ViewGroup) this.d;
            ResultKt.throwOnFailure(obj);
            sdk.pendo.io.r5.k kVar = new sdk.pendo.io.r5.k((GestureDetector) obj);
            iVar.globalClickObserverEntry = TuplesKt.to(viewGroup2, kVar);
            sdk.pendo.io.s5.a.a.a(viewGroup2, kVar);
            PendoLogger.d(i.TAG, "addGlobalClicksInterceptor -> adding global click observer for window " + viewGroup.hashCode());
            return Unit.INSTANCE;
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sdk.pendo.io.sdk.manager.screenmanager.ScreenManagerBase", f = "ScreenManagerBase.kt", i = {0, 1, 2}, l = {490, 497, 498, 499}, m = "calculateScreenIdentifierAndScreenData$suspendImpl", n = {"$this", "$this", "$this"}, s = {"L$0", "L$0", "L$0"})
    static final class d extends ContinuationImpl {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        d(Continuation<? super d> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return i.calculateScreenIdentifierAndScreenData$suspendImpl(i.this, this);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sdk.manager.screenmanager.ScreenManagerBase$clearResources$1", f = "ScreenManagerBase.kt", i = {}, l = {694}, m = "invokeSuspend", n = {}, s = {})
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
            return i.this.new e(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                i iVar = i.this;
                this.a = 1;
                if (iVar.clearInternal(this) == coroutine_suspended) {
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

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Landroid/view/GestureDetector;", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sdk.manager.screenmanager.ScreenManagerBase$createGestureDetector$2", f = "ScreenManagerBase.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class f extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super GestureDetector>, Object> {
        int a;
        final /* synthetic */ Activity b;
        final /* synthetic */ sdk.pendo.io.v6.i c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(Activity activity, sdk.pendo.io.v6.i iVar, Continuation<? super f> continuation) {
            super(2, continuation);
            this.b = activity;
            this.c = iVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super GestureDetector> continuation) {
            return ((f) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new f(this.b, this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return new GestureDetector(this.b, this.c);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sdk.manager.screenmanager.ScreenManagerBase$generateScreenshotBitmap$2", f = "ScreenManagerBase.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class g extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ Activity b;
        final /* synthetic */ sdk.pendo.io.t7.c c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(Activity activity, sdk.pendo.io.t7.c cVar, Continuation<? super g> continuation) {
            super(2, continuation);
            this.b = activity;
            this.c = cVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((g) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new g(this.b, this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            e1.b(this.b, this.c);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¨\u0006\t"}, d2 = {"sdk/pendo/io/x6/i$h", "Lsdk/pendo/io/listeners/views/OnElementInScreenFoundListener;", "Lorg/json/JSONObject;", "viewAsJson", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "viewRef", "", "onViewFound", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    public static final class h implements OnElementInScreenFoundListener {
        final /* synthetic */ List<ActivationManager.Trigger> a;
        final /* synthetic */ i b;
        final /* synthetic */ ArrayList<ElementInfoAndViewRef> c;

        h(List<ActivationManager.Trigger> list, i iVar, ArrayList<ElementInfoAndViewRef> arrayList) {
            this.a = list;
            this.b = iVar;
            this.c = arrayList;
        }

        @Override // sdk.pendo.io.listeners.views.OnElementInScreenFoundListener
        public void onViewFound(JSONObject viewAsJson, WeakReference<View> viewRef) {
            sdk.pendo.io.r1.a aVar;
            Intrinsics.checkNotNullParameter(viewAsJson, "viewAsJson");
            Intrinsics.checkNotNullParameter(viewRef, "viewRef");
            for (ActivationManager.Trigger trigger : this.a) {
                try {
                    JSONObject jSONObject = viewAsJson.getJSONObject("retroElementInfo");
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("retroElementInfo", jSONObject);
                    StepLocationModel location = trigger.getLocation();
                    String featureSelector = location != null ? location.getFeatureSelector() : null;
                    if (featureSelector != null && !StringsKt.isBlank(featureSelector) && (aVar = (sdk.pendo.io.r1.a) sdk.pendo.io.d1.g.a(sdk.pendo.io.d1.a.b().a(sdk.pendo.io.d1.i.DEFAULT_PATH_LEAF_TO_NULL, sdk.pendo.io.d1.i.SUPPRESS_EXCEPTIONS)).a(jSONObject2.toString()).a(trigger.getLocation().getFeatureSelector(), new sdk.pendo.io.d1.l[0])) != null && !aVar.isEmpty()) {
                        WeakReference<View> weakReferenceCreateViewRefIfNeeded$pendoIO_release = this.b.createViewRefIfNeeded$pendoIO_release(viewAsJson, viewRef);
                        ArrayList<ElementInfoAndViewRef> arrayList = this.c;
                        Intrinsics.checkNotNull(jSONObject);
                        arrayList.add(new ElementInfoAndViewRef(jSONObject, weakReferenceCreateViewRefIfNeeded$pendoIO_release, trigger));
                    }
                } catch (Exception e) {
                    String message = e.getMessage();
                    if (message == null) {
                        message = "getMatchingElementsIfExist";
                    }
                    PendoLogger.w(e, message, new Object[0]);
                }
            }
        }
    }

    /* JADX INFO: renamed from: sdk.pendo.io.x6.i$i, reason: collision with other inner class name */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sdk.pendo.io.sdk.manager.screenmanager.ScreenManagerBase", f = "ScreenManagerBase.kt", i = {0}, l = {467}, m = "handleNewScreenIdentified$suspendImpl", n = {"$this"}, s = {"L$0"})
    static final class C0526i extends ContinuationImpl {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        C0526i(Continuation<? super C0526i> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return i.handleNewScreenIdentified$suspendImpl(i.this, this);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lsdk/pendo/io/x6/m;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "()Lsdk/pendo/io/x6/m;"}, k = 3, mv = {1, 9, 0})
    static final class j extends Lambda implements Function0<sdk.pendo.io.x6.m> {
        j() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final sdk.pendo.io.x6.m invoke() {
            return new sdk.pendo.io.x6.m(i.this);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sdk.manager.screenmanager.ScreenManagerBase$onActivityDestroyed$1", f = "ScreenManagerBase.kt", i = {}, l = {344}, m = "invokeSuspend", n = {}, s = {})
    static final class k extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;

        k(Continuation<? super k> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((k) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return i.this.new k(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                i iVar = i.this;
                this.a = 1;
                if (iVar.removePendoGlobalClickInterceptor(this) == coroutine_suspended) {
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
    @DebugMetadata(c = "sdk.pendo.io.sdk.manager.screenmanager.ScreenManagerBase$onActivityResumed$1", f = "ScreenManagerBase.kt", i = {}, l = {177}, m = "invokeSuspend", n = {}, s = {})
    static final class l extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ Activity c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(Activity activity, Continuation<? super l> continuation) {
            super(2, continuation);
            this.c = activity;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((l) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return i.this.new l(this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                i iVar = i.this;
                Activity activity = this.c;
                this.a = 1;
                if (iVar.onActivityResumedInternal$pendoIO_release(activity, this) == coroutine_suspended) {
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
    @DebugMetadata(c = "sdk.pendo.io.sdk.manager.screenmanager.ScreenManagerBase", f = "ScreenManagerBase.kt", i = {0, 0}, l = {BoxSearchFragment.REQUEST_FILTER_SEARCH_RESULTS, 230}, m = "onActivityResumedInternal$suspendImpl", n = {"$this", "activity"}, s = {"L$0", "L$1"})
    static final class m extends ContinuationImpl {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        m(Continuation<? super m> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return i.onActivityResumedInternal$suspendImpl(i.this, null, this);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sdk.manager.screenmanager.ScreenManagerBase$onActivityResumedInternal$2", f = "ScreenManagerBase.kt", i = {}, l = {205}, m = "invokeSuspend", n = {}, s = {})
    static final class n extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;

        @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "it", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Lkotlin/Unit;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0})
        static final class a<T> implements FlowCollector {
            final /* synthetic */ i a;

            /* JADX INFO: renamed from: sdk.pendo.io.x6.i$n$a$a, reason: collision with other inner class name */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            @DebugMetadata(c = "sdk.pendo.io.sdk.manager.screenmanager.ScreenManagerBase$onActivityResumedInternal$2$2", f = "ScreenManagerBase.kt", i = {0, 1}, l = {736, 214}, m = "emit", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0"})
            static final class C0527a extends ContinuationImpl {
                Object a;
                Object b;
                /* synthetic */ Object c;
                final /* synthetic */ a<T> d;
                int e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C0527a(a<? super T> aVar, Continuation<? super C0527a> continuation) {
                    super(continuation);
                    this.d = aVar;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    this.c = obj;
                    this.e |= Integer.MIN_VALUE;
                    return this.d.emit(null, this);
                }
            }

            a(i iVar) {
                this.a = iVar;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            /* JADX WARN: Code restructure failed: missing block: B:29:0x007b, code lost:
            
                if (r6.calculateScreenIdentifierAndScreenData$pendoIO_release(r7) == r0) goto L30;
             */
            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object emit(kotlin.Unit r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
                /*
                    r6 = this;
                    boolean r7 = r8 instanceof sdk.pendo.io.x6.i.n.a.C0527a
                    if (r7 == 0) goto L13
                    r7 = r8
                    sdk.pendo.io.x6.i$n$a$a r7 = (sdk.pendo.io.x6.i.n.a.C0527a) r7
                    int r0 = r7.e
                    r1 = -2147483648(0xffffffff80000000, float:-0.0)
                    r2 = r0 & r1
                    if (r2 == 0) goto L13
                    int r0 = r0 - r1
                    r7.e = r0
                    goto L18
                L13:
                    sdk.pendo.io.x6.i$n$a$a r7 = new sdk.pendo.io.x6.i$n$a$a
                    r7.<init>(r6, r8)
                L18:
                    java.lang.Object r8 = r7.c
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r1 = r7.e
                    r2 = 2
                    r3 = 1
                    java.lang.String r4 = "ScreenManagerBase"
                    r5 = 0
                    if (r1 == 0) goto L4a
                    if (r1 == r3) goto L3d
                    if (r1 != r2) goto L35
                    java.lang.Object r6 = r7.a
                    kotlinx.coroutines.sync.Mutex r6 = (kotlinx.coroutines.sync.Mutex) r6
                    kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L33
                    goto L7f
                L33:
                    r7 = move-exception
                    goto L85
                L35:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r7)
                    throw r6
                L3d:
                    java.lang.Object r6 = r7.b
                    sdk.pendo.io.x6.i r6 = (sdk.pendo.io.x6.i) r6
                    java.lang.Object r1 = r7.a
                    kotlinx.coroutines.sync.Mutex r1 = (kotlinx.coroutines.sync.Mutex) r1
                    kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L8d
                    r8 = r1
                    goto L6b
                L4a:
                    kotlin.ResultKt.throwOnFailure(r8)
                    java.lang.String r8 = "screenContentChangeFlow COLLECT after 100 timeout ms"
                    java.lang.Object[] r8 = new java.lang.Object[]{r8}
                    sdk.pendo.io.logging.PendoLogger.d(r4, r8)
                    sdk.pendo.io.x6.i r8 = r6.a     // Catch: java.lang.Throwable -> L8d
                    kotlinx.coroutines.sync.Mutex r8 = r8.getScreenManagerMutex()     // Catch: java.lang.Throwable -> L8d
                    sdk.pendo.io.x6.i r6 = r6.a     // Catch: java.lang.Throwable -> L8d
                    r7.a = r8     // Catch: java.lang.Throwable -> L8d
                    r7.b = r6     // Catch: java.lang.Throwable -> L8d
                    r7.e = r3     // Catch: java.lang.Throwable -> L8d
                    java.lang.Object r1 = r8.lock(r5, r7)     // Catch: java.lang.Throwable -> L8d
                    if (r1 != r0) goto L6b
                    goto L7d
                L6b:
                    boolean r1 = r6.shouldIgnoreChangesInApp$pendoIO_release()     // Catch: java.lang.Throwable -> L87
                    if (r1 != 0) goto L7e
                    r7.a = r8     // Catch: java.lang.Throwable -> L87
                    r7.b = r5     // Catch: java.lang.Throwable -> L87
                    r7.e = r2     // Catch: java.lang.Throwable -> L87
                    java.lang.Object r6 = r6.calculateScreenIdentifierAndScreenData$pendoIO_release(r7)     // Catch: java.lang.Throwable -> L87
                    if (r6 != r0) goto L7e
                L7d:
                    return r0
                L7e:
                    r6 = r8
                L7f:
                    kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L33
                    r6.unlock(r5)     // Catch: java.lang.Throwable -> L8d
                    goto L97
                L85:
                    r8 = r6
                    goto L89
                L87:
                    r6 = move-exception
                    r7 = r6
                L89:
                    r8.unlock(r5)     // Catch: java.lang.Throwable -> L8d
                    throw r7     // Catch: java.lang.Throwable -> L8d
                L8d:
                    r6 = move-exception
                    boolean r7 = r6 instanceof java.util.concurrent.CancellationException
                    if (r7 != 0) goto L9a
                    java.lang.String r7 = "screenContentChangeFlow COLLECT error"
                    sdk.pendo.io.logging.PendoLogger.e(r4, r7, r6)
                L97:
                    kotlin.Unit r6 = kotlin.Unit.INSTANCE
                    return r6
                L9a:
                    throw r6
                */
                throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.x6.i.n.a.emit(kotlin.Unit, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\b"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1"}, k = 1, mv = {1, 9, 0})
        public static final class b implements Flow<Unit> {
            final /* synthetic */ Flow a;
            final /* synthetic */ i b;

            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
            public static final class a<T> implements FlowCollector {
                final /* synthetic */ FlowCollector a;
                final /* synthetic */ i b;

                /* JADX INFO: renamed from: sdk.pendo.io.x6.i$n$b$a$a, reason: collision with other inner class name */
                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "sdk.pendo.io.sdk.manager.screenmanager.ScreenManagerBase$onActivityResumedInternal$2$invokeSuspend$$inlined$filter$1$2", f = "ScreenManagerBase.kt", i = {}, l = {223}, m = "emit", n = {}, s = {})
                public static final class C0528a extends ContinuationImpl {
                    /* synthetic */ Object a;
                    int b;

                    public C0528a(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= Integer.MIN_VALUE;
                        return a.this.emit(null, this);
                    }
                }

                public a(FlowCollector flowCollector, i iVar) {
                    this.a = flowCollector;
                    this.b = iVar;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Object obj, Continuation continuation) {
                    C0528a c0528a;
                    if (continuation instanceof C0528a) {
                        c0528a = (C0528a) continuation;
                        int i = c0528a.b;
                        if ((i & Integer.MIN_VALUE) != 0) {
                            c0528a.b = i - Integer.MIN_VALUE;
                        } else {
                            c0528a = new C0528a(continuation);
                        }
                    } else {
                        c0528a = new C0528a(continuation);
                    }
                    Object obj2 = c0528a.a;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i2 = c0528a.b;
                    if (i2 == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.a;
                        if (this.b.shouldListenToAppChanges$pendoIO_release()) {
                            c0528a.b = 1;
                            if (flowCollector.emit(obj, c0528a) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    } else {
                        if (i2 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            public b(Flow flow, i iVar) {
                this.a = flow;
                this.b = iVar;
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super Unit> flowCollector, Continuation continuation) {
                Object objCollect = this.a.collect(new a(flowCollector, this.b), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }

        n(Continuation<? super n> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((n) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return i.this.new n(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Flow flowA;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableSharedFlow<Unit> screenContentChangeFlow$pendoIO_release = i.this.getScreenContentChangeFlow$pendoIO_release();
                if (screenContentChangeFlow$pendoIO_release != null && (flowA = x.a(screenContentChangeFlow$pendoIO_release, 100L)) != null) {
                    b bVar = new b(flowA, i.this);
                    a aVar = new a(i.this);
                    this.a = 1;
                    if (bVar.collect(aVar, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
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

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lsdk/pendo/io/v6/i;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "()Lsdk/pendo/io/v6/i;"}, k = 3, mv = {1, 9, 0})
    static final class o extends Lambda implements Function0<sdk.pendo.io.v6.i> {
        o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final sdk.pendo.io.v6.i invoke() {
            return new sdk.pendo.io.v6.i(i.this.getMotionEventHandler(), i.this.getSmCoroutineScope());
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sdk.manager.screenmanager.ScreenManagerBase$removePendoGlobalClickInterceptor$2", f = "ScreenManagerBase.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class p extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;

        p(Continuation<? super p> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((p) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return i.this.new p(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Pair pair = i.this.globalClickObserverEntry;
            if (pair == null) {
                return null;
            }
            i iVar = i.this;
            sdk.pendo.io.s5.a.a.b((ViewGroup) pair.component1(), (sdk.pendo.io.s5.c) pair.component2());
            iVar.globalClickObserverEntry = null;
            return Unit.INSTANCE;
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sdk.pendo.io.sdk.manager.screenmanager.ScreenManagerBase", f = "ScreenManagerBase.kt", i = {0, 1}, l = {567, 575}, m = "setNewScreenId$suspendImpl", n = {"$this", "$this"}, s = {"L$0", "L$0"})
    static final class q extends ContinuationImpl {
        Object a;
        /* synthetic */ Object b;
        int d;

        q(Continuation<? super q> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return i.setNewScreenId$suspendImpl(i.this, null, false, this);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sdk.manager.screenmanager.ScreenManagerBase$setPolicy$1", f = "ScreenManagerBase.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class r extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ boolean c;
        final /* synthetic */ boolean d;
        final /* synthetic */ boolean e;
        final /* synthetic */ boolean f;
        final /* synthetic */ boolean g;
        final /* synthetic */ boolean h;
        final /* synthetic */ boolean i;
        final /* synthetic */ long j;
        final /* synthetic */ boolean k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        r(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, long j, boolean z8, Continuation<? super r> continuation) {
            super(2, continuation);
            this.c = z;
            this.d = z2;
            this.e = z3;
            this.f = z4;
            this.g = z5;
            this.h = z6;
            this.i = z7;
            this.j = j;
            this.k = z8;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((r) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return i.this.new r(this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Exception {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            i.this.screenManagerPolicy.a(this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k);
            try {
                Activity activity = i.this.getCurrentActivityRef$pendoIO_release().get();
                Context baseContext = activity != null ? activity.getBaseContext() : null;
                if (this.k && sdk.pendo.io.s7.b.a(baseContext)) {
                    PendoLogger.d(i.TAG, "EVENT -> setPolicy shouldDetectClicksForAccessibility, rescan current screen");
                    i.this.onGlobalLayoutChangeEvent(sdk.pendo.io.x6.g.ON_SCREEN_CHANGED);
                }
            } catch (Exception e) {
                if (e instanceof CancellationException) {
                    throw e;
                }
                PendoLogger.w(i.TAG, "Failed to re-scan for accessibility " + e);
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "handleException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0})
    public static final class s extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public s(CoroutineExceptionHandler.Companion companion) {
            super(companion);
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(CoroutineContext context, Throwable exception) {
            PendoLogger.e(i.TAG, "Coroutine uncaught exception handler: " + exception, exception);
        }
    }

    public i(Pendo.PendoOptions pendoOptions, sdk.pendo.io.s7.m dispatcherProvider) {
        Intrinsics.checkNotNullParameter(pendoOptions, "pendoOptions");
        Intrinsics.checkNotNullParameter(dispatcherProvider, "dispatcherProvider");
        this.dispatcherProvider = dispatcherProvider;
        Mutex mutexMutex$default = MutexKt.Mutex$default(false, 1, null);
        this.screenManagerMutex = mutexMutex$default;
        s sVar = new s(CoroutineExceptionHandler.INSTANCE);
        this.smCoroutineExceptionHandler = sVar;
        this.smCoroutineScopeMainJob = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(dispatcherProvider.getIo().plus(this.smCoroutineScopeMainJob).plus(sVar).plus(new CoroutineName("ScreenManagerMainCoroutine")));
        this.smCoroutineScope = CoroutineScope;
        this.screenManagerPolicy = new sdk.pendo.io.x6.k(pendoOptions);
        this.currentScreenId = "";
        this.previousScreenId = "";
        sdk.pendo.io.j4.b<String> bVarM = sdk.pendo.io.j4.b.m();
        Intrinsics.checkNotNullExpressionValue(bVarM, "create(...)");
        this.screenChangedNewScreenIdSubject = bVarM;
        sdk.pendo.io.j4.b<String> bVarM2 = sdk.pendo.io.j4.b.m();
        Intrinsics.checkNotNullExpressionValue(bVarM2, "create(...)");
        this.screenLayoutChangedSameScreenIdSubject = bVarM2;
        this.currentActivityRef = new WeakReference<>(null);
        this.motionEventHandler = LazyKt.lazy(new j());
        this.pendoGestureListener = LazyKt.lazy(new o());
        x.a(CoroutineScope, mutexMutex$default, new CoroutineName("screenManagerBaseInit"), null, new a(null), 4, null);
    }

    static /* synthetic */ Object calculateCurrentRootViewData$suspendImpl(i iVar, Activity activity, Continuation<? super e1.a> continuation) {
        Object obj;
        Object objA = null;
        if (activity != null) {
            try {
                objA = sdk.pendo.io.s7.s.a.a(b1.a, activity, false, 2, null);
                objA = Unit.INSTANCE;
                obj = objA;
            } catch (Throwable th) {
                th = th;
                PendoLogger.w("calculateCurrentRootViewData -> " + th, new Object[0]);
                return objA;
            }
        } else {
            obj = null;
        }
        if (objA != null) {
            return obj;
        }
        try {
            PendoLogger.w("calculateCurrentRootViewData -> activity is null", new Object[0]);
            return obj;
        } catch (Throwable th2) {
            objA = obj;
            th = th2;
            PendoLogger.w("calculateCurrentRootViewData -> " + th, new Object[0]);
            return objA;
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00a3 A[PHI: r10
      0x00a3: PHI (r10v5 sdk.pendo.io.x6.i) = (r10v4 sdk.pendo.io.x6.i), (r10v14 sdk.pendo.io.x6.i) binds: [B:32:0x00a0, B:17:0x003d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ab, code lost:
    
        if (r10.setupTouchInterceptor(r0) == r1) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object calculateScreenIdentifierAndScreenData$suspendImpl(sdk.pendo.io.x6.i r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            boolean r0 = r11 instanceof sdk.pendo.io.x6.i.d
            if (r0 == 0) goto L13
            r0 = r11
            sdk.pendo.io.x6.i$d r0 = (sdk.pendo.io.x6.i.d) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            sdk.pendo.io.x6.i$d r0 = new sdk.pendo.io.x6.i$d
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.e
            r3 = 0
            r4 = 0
            r5 = 4
            r6 = 3
            r7 = 2
            r8 = 1
            if (r2 == 0) goto L5d
            if (r2 == r8) goto L4d
            if (r2 == r7) goto L45
            if (r2 == r6) goto L3d
            if (r2 != r5) goto L35
            kotlin.ResultKt.throwOnFailure(r11)
            goto Lae
        L35:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L3d:
            java.lang.Object r10 = r0.a
            sdk.pendo.io.x6.i r10 = (sdk.pendo.io.x6.i) r10
            kotlin.ResultKt.throwOnFailure(r11)
            goto La3
        L45:
            java.lang.Object r10 = r0.a
            sdk.pendo.io.x6.i r10 = (sdk.pendo.io.x6.i) r10
            kotlin.ResultKt.throwOnFailure(r11)
            goto L96
        L4d:
            java.lang.Object r10 = r0.b
            sdk.pendo.io.x6.i r10 = (sdk.pendo.io.x6.i) r10
            java.lang.Object r2 = r0.a
            sdk.pendo.io.x6.i r2 = (sdk.pendo.io.x6.i) r2
            kotlin.ResultKt.throwOnFailure(r11)
            r9 = r11
            r11 = r10
            r10 = r2
            r2 = r9
            goto L77
        L5d:
            kotlin.ResultKt.throwOnFailure(r11)
            java.lang.ref.WeakReference<android.app.Activity> r11 = r10.currentActivityRef
            java.lang.Object r11 = r11.get()
            android.app.Activity r11 = (android.app.Activity) r11
            r0.a = r10
            r0.b = r10
            r0.e = r8
            java.lang.Object r11 = r10.calculateCurrentRootViewData(r11, r0)
            if (r11 != r1) goto L75
            goto Lad
        L75:
            r2 = r11
            r11 = r10
        L77:
            sdk.pendo.io.s7.e1$a r2 = (sdk.pendo.io.s7.e1.a) r2
            r11.currentRootViewData = r2
            sdk.pendo.io.s7.e1$a r11 = r10.currentRootViewData
            if (r11 != 0) goto L89
            java.lang.Object[] r10 = new java.lang.Object[r4]
            java.lang.String r11 = "calculateScreenIdentifierAndScreenData -> root data is null"
            sdk.pendo.io.logging.PendoLogger.w(r11, r10)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L89:
            r0.a = r10
            r0.b = r3
            r0.e = r7
            java.lang.Object r11 = r10.calculateScreenId$pendoIO_release(r0)
            if (r11 != r1) goto L96
            goto Lad
        L96:
            java.lang.String r11 = (java.lang.String) r11
            r0.a = r10
            r0.e = r6
            java.lang.Object r11 = r10.setNewScreenId$pendoIO_release(r11, r4, r0)
            if (r11 != r1) goto La3
            goto Lad
        La3:
            r0.a = r3
            r0.e = r5
            java.lang.Object r10 = r10.setupTouchInterceptor(r0)
            if (r10 != r1) goto Lae
        Lad:
            return r1
        Lae:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.x6.i.calculateScreenIdentifierAndScreenData$suspendImpl(sdk.pendo.io.x6.i, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object clearInternal$suspendImpl(i iVar, Continuation<? super Unit> continuation) {
        iVar.currentActivityRef = new WeakReference<>(null);
        iVar.currentRootViewData = null;
        Object objRemovePendoGlobalClickInterceptor = iVar.removePendoGlobalClickInterceptor(continuation);
        return objRemovePendoGlobalClickInterceptor == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objRemovePendoGlobalClickInterceptor : Unit.INSTANCE;
    }

    private final void clearResources() {
        cancelScreenManagerCoroutineJobs$pendoIO_release();
        x.a(this.smCoroutineScope, this.screenManagerMutex, this.dispatcherProvider.getMain().plus(new CoroutineName("clearResources")), null, new e(null), 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object createGestureDetector(Activity activity, sdk.pendo.io.v6.i iVar, Continuation<? super GestureDetector> continuation) {
        return BuildersKt.withContext(this.dispatcherProvider.getMain(), new f(activity, iVar, null), continuation);
    }

    static /* synthetic */ Object generateScreenshotBitmap$suspendImpl(i iVar, Activity activity, sdk.pendo.io.t7.c cVar, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(iVar.dispatcherProvider.getMain().plus(new CoroutineName("generateScreenshotBitmap")), new g(activity, cVar, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    private final Set<View> getCurrentScreenContentRoots() {
        WeakReference<View> weakReference;
        View view;
        if (sdk.pendo.io.d6.c.h().a() == null) {
            return null;
        }
        b1 b1Var = b1.a;
        Activity activityA = sdk.pendo.io.d6.c.h().a();
        Intrinsics.checkNotNullExpressionValue(activityA, "getCurrentVisibleActivity(...)");
        e1.a aVarA = sdk.pendo.io.s7.s.a.a(b1Var, activityA, false, 2, null);
        if (aVarA != null && (weakReference = aVarA.a) != null && (view = weakReference.get()) != null) {
            return getCurrentScreenContentRoots(view);
        }
        PendoLogger.d("ScreenManagerBase getCurrentScreenContentRoots -> current root view is null", new Object[0]);
        return null;
    }

    static /* synthetic */ Object getScreenDataForCapture$suspendImpl(i iVar, Continuation<? super JSONObject> continuation) {
        return iVar.getScreenData$pendoIO_release(true, true, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    static /* synthetic */ Object handleNewScreenIdentified$suspendImpl(i iVar, Continuation<? super Unit> continuation) {
        C0526i c0526i;
        Object obj;
        i iVar2;
        if (continuation instanceof C0526i) {
            c0526i = (C0526i) continuation;
            int i = c0526i.e;
            if ((i & Integer.MIN_VALUE) != 0) {
                c0526i.e = i - Integer.MIN_VALUE;
            } else {
                c0526i = iVar.new C0526i(continuation);
            }
        } else {
            c0526i = iVar.new C0526i(continuation);
        }
        Object obj2 = c0526i.c;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c0526i.e;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj2);
            boolean z = iVar.screenManagerPolicy.includePageViewTexts;
            c0526i.a = iVar;
            c0526i.b = iVar;
            c0526i.e = 1;
            Object screenData$pendoIO_release = iVar.getScreenData$pendoIO_release(z, false, c0526i);
            if (screenData$pendoIO_release == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj = screenData$pendoIO_release;
            iVar2 = iVar;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i iVar3 = (i) c0526i.b;
            i iVar4 = (i) c0526i.a;
            ResultKt.throwOnFailure(obj2);
            iVar2 = iVar3;
            iVar = iVar4;
            obj = obj2;
        }
        iVar2.setCurrentScreenData$pendoIO_release((JSONObject) obj);
        iVar.screenChangedNewScreenIdSubject.onNext(iVar.currentScreenId);
        return Unit.INSTANCE;
    }

    static /* synthetic */ Object handleSameScreenIdentified$suspendImpl(i iVar, Continuation<? super Unit> continuation) {
        iVar.screenLayoutChangedSameScreenIdSubject.onNext(iVar.currentScreenId);
        return Unit.INSTANCE;
    }

    static /* synthetic */ Object handleVeryFirstScreen$suspendImpl(i iVar, Continuation<? super Unit> continuation) {
        MutableSharedFlow<Unit> mutableSharedFlow = iVar.screenContentChangeFlow;
        if (mutableSharedFlow != null) {
            Boxing.boxBoolean(mutableSharedFlow.tryEmit(Unit.INSTANCE));
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00ab, code lost:
    
        if (r12.addGlobalClicksInterceptor(r13, r0) == r1) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object onActivityResumedInternal$suspendImpl(sdk.pendo.io.x6.i r12, android.app.Activity r13, kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            boolean r0 = r14 instanceof sdk.pendo.io.x6.i.m
            if (r0 == 0) goto L13
            r0 = r14
            sdk.pendo.io.x6.i$m r0 = (sdk.pendo.io.x6.i.m) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            sdk.pendo.io.x6.i$m r0 = new sdk.pendo.io.x6.i$m
            r0.<init>(r14)
        L18:
            java.lang.Object r14 = r0.c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.e
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L43
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            kotlin.ResultKt.throwOnFailure(r14)
            goto Lae
        L2e:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L36:
            java.lang.Object r12 = r0.b
            r13 = r12
            android.app.Activity r13 = (android.app.Activity) r13
            java.lang.Object r12 = r0.a
            sdk.pendo.io.x6.i r12 = (sdk.pendo.io.x6.i) r12
            kotlin.ResultKt.throwOnFailure(r14)
            goto L99
        L43:
            kotlin.ResultKt.throwOnFailure(r14)
            java.lang.ref.WeakReference r14 = new java.lang.ref.WeakReference
            r14.<init>(r13)
            r12.currentActivityRef = r14
            sdk.pendo.io.s7.b1 r14 = sdk.pendo.io.s7.b1.a
            r2 = 0
            sdk.pendo.io.s7.e1$a r14 = sdk.pendo.io.s7.s.a.a(r14, r13, r2, r3, r5)
            r12.currentRootViewData = r14
            java.lang.ref.WeakReference<sdk.pendo.io.listeners.views.PendoDrawerListener> r14 = r12.pendoDrawerListenerRef
            if (r14 == 0) goto L65
            java.lang.Object r14 = r14.get()
            sdk.pendo.io.listeners.views.PendoDrawerListener r14 = (sdk.pendo.io.listeners.views.PendoDrawerListener) r14
            if (r14 == 0) goto L65
            r14.setDrawerState(r2)
        L65:
            kotlinx.coroutines.flow.MutableSharedFlow<kotlin.Unit> r14 = r12.screenContentChangeFlow
            if (r14 != 0) goto L71
            kotlinx.coroutines.channels.BufferOverflow r14 = kotlinx.coroutines.channels.BufferOverflow.DROP_LATEST
            kotlinx.coroutines.flow.MutableSharedFlow r14 = kotlinx.coroutines.flow.SharedFlowKt.MutableSharedFlow(r4, r4, r14)
            r12.screenContentChangeFlow = r14
        L71:
            kotlinx.coroutines.Job r14 = r12.screenContentChangeCollectionJob
            if (r14 != 0) goto L8c
            kotlinx.coroutines.CoroutineScope r6 = r12.smCoroutineScope
            kotlinx.coroutines.CoroutineName r7 = new kotlinx.coroutines.CoroutineName
            java.lang.String r14 = "onScreenContentChangesCoroutine"
            r7.<init>(r14)
            sdk.pendo.io.x6.i$n r9 = new sdk.pendo.io.x6.i$n
            r9.<init>(r5)
            r10 = 2
            r11 = 0
            r8 = 0
            kotlinx.coroutines.Job r14 = kotlinx.coroutines.BuildersKt.launch$default(r6, r7, r8, r9, r10, r11)
            r12.screenContentChangeCollectionJob = r14
        L8c:
            r0.a = r12
            r0.b = r13
            r0.e = r4
            java.lang.Object r14 = r12.handleVeryFirstScreen$pendoIO_release(r0)
            if (r14 != r1) goto L99
            goto Lad
        L99:
            boolean r14 = r12.disableGlobalClickInterceptor
            if (r14 != 0) goto Lb1
            android.view.Window r13 = r13.getWindow()
            r0.a = r5
            r0.b = r5
            r0.e = r3
            java.lang.Object r12 = r12.addGlobalClicksInterceptor(r13, r0)
            if (r12 != r1) goto Lae
        Lad:
            return r1
        Lae:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        Lb1:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.x6.i.onActivityResumedInternal$suspendImpl(sdk.pendo.io.x6.i, android.app.Activity, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object removePendoGlobalClickInterceptor(Continuation<? super Unit> continuation) {
        return BuildersKt.withContext(this.dispatcherProvider.getMain().plus(new CoroutineName("removePendoGlobalClickInterceptor")), new p(null), continuation);
    }

    public static /* synthetic */ Object setNewScreenId$pendoIO_release$default(i iVar, String str, boolean z, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setNewScreenId");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return iVar.setNewScreenId$pendoIO_release(str, z, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0096, code lost:
    
        if (r5.handleSameScreenIdentified(r0) == r1) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00cf, code lost:
    
        if (r5.handleNewScreenIdentified$pendoIO_release(r0) == r1) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00d1, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object setNewScreenId$suspendImpl(sdk.pendo.io.x6.i r5, java.lang.String r6, boolean r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            Method dump skipped, instruction units count: 216
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.x6.i.setNewScreenId$suspendImpl(sdk.pendo.io.x6.i, java.lang.String, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object addGlobalClicksInterceptor(Window window, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.dispatcherProvider.getMain(), new c(window, this, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    public Object calculateCurrentRootViewData(Activity activity, Continuation<? super e1.a> continuation) {
        return calculateCurrentRootViewData$suspendImpl(this, activity, continuation);
    }

    public abstract Object calculateScreenId$pendoIO_release(Continuation<? super String> continuation);

    public Object calculateScreenIdentifierAndScreenData$pendoIO_release(Continuation<? super Unit> continuation) {
        return calculateScreenIdentifierAndScreenData$suspendImpl(this, continuation);
    }

    public void cancelScreenManagerCoroutineJobs$pendoIO_release() {
        JobKt__JobKt.cancelChildren$default((Job) this.smCoroutineScopeMainJob, (CancellationException) null, 1, (Object) null);
        this.screenContentChangeCollectionJob = null;
        this.screenContentChangeFlow = null;
    }

    public Object clearInternal(Continuation<? super Unit> continuation) {
        return clearInternal$suspendImpl(this, continuation);
    }

    public final WeakReference<View> createViewRefIfNeeded$pendoIO_release(JSONObject viewAsJson, WeakReference<View> viewRef) {
        Intrinsics.checkNotNullParameter(viewAsJson, "viewAsJson");
        Intrinsics.checkNotNullParameter(viewRef, "viewRef");
        return (PlatformStateManager.INSTANCE.isJetpackComposeApp() && viewRef.get() == null) ? new WeakReference<>(sdk.pendo.io.s7.e.INSTANCE.a().a(viewAsJson)) : viewRef;
    }

    @Override // sdk.pendo.io.x6.d
    public Object generateScreenshotBitmap(Activity activity, sdk.pendo.io.t7.c cVar, Continuation<? super Unit> continuation) {
        return generateScreenshotBitmap$suspendImpl(this, activity, cVar, continuation);
    }

    public WeakReference<Activity> getCurrentActivity() {
        return this.currentActivityRef;
    }

    public final WeakReference<Activity> getCurrentActivityRef$pendoIO_release() {
        return this.currentActivityRef;
    }

    /* JADX INFO: renamed from: getCurrentRootViewData$pendoIO_release, reason: from getter */
    public final e1.a getCurrentRootViewData() {
        return this.currentRootViewData;
    }

    @Override // sdk.pendo.io.x6.d
    public JSONObject getCurrentScreenData() {
        JSONObject jSONObject = this.currentScreenData;
        if (jSONObject != null) {
            return new JSONObject(jSONObject.toString());
        }
        return null;
    }

    /* JADX INFO: renamed from: getCurrentScreenData$pendoIO_release, reason: from getter */
    public final JSONObject getCurrentScreenData() {
        return this.currentScreenData;
    }

    @Override // sdk.pendo.io.x6.d
    /* JADX INFO: renamed from: getCurrentScreenId, reason: from getter */
    public String getEMPTY_STRING() {
        return this.currentScreenId;
    }

    public final String getCurrentScreenId$pendoIO_release() {
        return this.currentScreenId;
    }

    /* JADX INFO: renamed from: getDisableGlobalClickInterceptor$pendoIO_release, reason: from getter */
    public final boolean getDisableGlobalClickInterceptor() {
        return this.disableGlobalClickInterceptor;
    }

    public final sdk.pendo.io.s7.m getDispatcherProvider() {
        return this.dispatcherProvider;
    }

    /* JADX INFO: renamed from: getFocusHandler$pendoIO_release, reason: from getter */
    public final sdk.pendo.io.x6.a getFocusHandler() {
        return this.focusHandler;
    }

    /* JADX INFO: renamed from: getForceScreenScanOnScreenContentChange$pendoIO_release, reason: from getter */
    public final boolean getForceScreenScanOnScreenContentChange() {
        return this.forceScreenScanOnScreenContentChange;
    }

    @Override // sdk.pendo.io.v2.a
    public sdk.pendo.io.u2.a getKoin() {
        return sdk.pendo.io.w5.a.C0510a.a(this);
    }

    @Override // sdk.pendo.io.x6.d
    public List<ElementInfoAndViewRef> getMatchingElementsIfExist(List<ActivationManager.Trigger> triggerList) {
        Intrinsics.checkNotNullParameter(triggerList, "triggerList");
        Set<View> currentScreenContentRoots = getCurrentScreenContentRoots();
        ArrayList arrayList = new ArrayList();
        if (sdk.pendo.io.s7.s.a.a(b1.a, currentScreenContentRoots, false, new h(triggerList, this, arrayList), this.currentScreenId, 2, null) == null) {
            return null;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: getMotionEventHandler$pendoIO_release */
    public b0 getMotionEventHandler() {
        return (b0) this.motionEventHandler.getValue();
    }

    @Override // sdk.pendo.io.x6.d
    public WeakReference<PendoDrawerListener> getPendoDrawerListenerRef() {
        return this.pendoDrawerListenerRef;
    }

    public final WeakReference<PendoDrawerListener> getPendoDrawerListenerRef$pendoIO_release() {
        return this.pendoDrawerListenerRef;
    }

    public final sdk.pendo.io.v6.i getPendoGestureListener$pendoIO_release() {
        return (sdk.pendo.io.v6.i) this.pendoGestureListener.getValue();
    }

    @Override // sdk.pendo.io.x6.d
    public JSONObject getPreviousScreenData() {
        return this.previousScreenData;
    }

    /* JADX INFO: renamed from: getPreviousScreenId$pendoIO_release, reason: from getter */
    public final String getPreviousScreenId() {
        return this.previousScreenId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // sdk.pendo.io.x6.d
    public final sdk.pendo.io.j4.b<String> getScreenChangedNewScreenIdSubject() {
        return this.screenChangedNewScreenIdSubject;
    }

    public final MutableSharedFlow<Unit> getScreenContentChangeFlow$pendoIO_release() {
        return this.screenContentChangeFlow;
    }

    public abstract Object getScreenData$pendoIO_release(boolean z, boolean z2, Continuation<? super JSONObject> continuation);

    @Override // sdk.pendo.io.x6.d
    public Object getScreenDataForCapture(Continuation<? super JSONObject> continuation) {
        return getScreenDataForCapture$suspendImpl(this, continuation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // sdk.pendo.io.x6.d
    public final sdk.pendo.io.j4.b<String> getScreenLayoutChangedSameScreenIdSubject() {
        return this.screenLayoutChangedSameScreenIdSubject;
    }

    /* JADX INFO: renamed from: getScreenManagerMutex$pendoIO_release, reason: from getter */
    public final Mutex getScreenManagerMutex() {
        return this.screenManagerMutex;
    }

    @Override // sdk.pendo.io.x6.d
    public sdk.pendo.io.x6.k getScreenManagerPolicy() {
        return this.screenManagerPolicy;
    }

    protected final CoroutineScope getSmCoroutineScope() {
        return this.smCoroutineScope;
    }

    @Override // sdk.pendo.io.x6.d
    public JSONArray getViewTreeDataForCapture() {
        WeakReference<View> weakReference;
        View view;
        if (this.currentActivityRef.get() == null) {
            return new JSONArray();
        }
        e1.a aVar = this.currentRootViewData;
        if (aVar == null || (weakReference = aVar.a) == null || (view = weakReference.get()) == null) {
            return new JSONArray();
        }
        JSONArray jSONArrayA = sdk.pendo.io.s7.s.a.a(b1.a, getCurrentScreenContentRoots(view), true, null, this.currentScreenId, 4, null);
        return jSONArrayA == null ? new JSONArray() : jSONArrayA;
    }

    public Object handleNewScreenIdentified$pendoIO_release(Continuation<? super Unit> continuation) {
        return handleNewScreenIdentified$suspendImpl(this, continuation);
    }

    public Object handleSameScreenIdentified(Continuation<? super Unit> continuation) {
        return handleSameScreenIdentified$suspendImpl(this, continuation);
    }

    @Override // sdk.pendo.io.x6.d
    public void handleScreenChanges() {
        PendoLogger.d(TAG, "screenContentChange");
        this.forceScreenScanOnScreenContentChange = true;
        MutableSharedFlow<Unit> mutableSharedFlow = this.screenContentChangeFlow;
        if (mutableSharedFlow != null) {
            mutableSharedFlow.tryEmit(Unit.INSTANCE);
        }
    }

    public Object handleVeryFirstScreen$pendoIO_release(Continuation<? super Unit> continuation) {
        return handleVeryFirstScreen$suspendImpl(this, continuation);
    }

    @Override // sdk.pendo.io.x6.d
    public void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        x.a(this.smCoroutineScope, this.screenManagerMutex, this.dispatcherProvider.getMain().plus(new CoroutineName("onActivityDestroyed")), null, new k(null), 4, null);
    }

    @Override // sdk.pendo.io.x6.d
    public void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        clearResources();
    }

    @Override // sdk.pendo.io.x6.d
    public void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (shouldIgnoreChangesInApp$pendoIO_release()) {
            return;
        }
        x.a(this.smCoroutineScope, this.screenManagerMutex, this.dispatcherProvider.getMain().plus(new CoroutineName("onActivityResumedBase")), null, new l(activity, null), 4, null);
    }

    public Object onActivityResumedInternal$pendoIO_release(Activity activity, Continuation<? super Unit> continuation) {
        return onActivityResumedInternal$suspendImpl(this, activity, continuation);
    }

    @Override // sdk.pendo.io.x6.d
    public void onGlobalLayoutChangeEvent(sdk.pendo.io.x6.g triggerEvent) {
        Intrinsics.checkNotNullParameter(triggerEvent, "triggerEvent");
    }

    @Override // sdk.pendo.io.x6.d
    public void onSessionEnd() {
        this.currentScreenId = "";
        this.previousScreenId = "";
        setCurrentScreenData$pendoIO_release(null);
        this.previousScreenData = null;
        clearResources();
    }

    public final void setCurrentActivityRef$pendoIO_release(WeakReference<Activity> weakReference) {
        Intrinsics.checkNotNullParameter(weakReference, "<set-?>");
        this.currentActivityRef = weakReference;
    }

    public final void setCurrentRootViewData$pendoIO_release(e1.a aVar) {
        this.currentRootViewData = aVar;
    }

    public final void setCurrentScreenData$pendoIO_release(JSONObject jSONObject) {
        this.previousScreenData = this.currentScreenData;
        this.currentScreenData = jSONObject;
    }

    public final void setCurrentScreenId$pendoIO_release(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.currentScreenId = str;
    }

    public final void setDisableGlobalClickInterceptor$pendoIO_release(boolean z) {
        this.disableGlobalClickInterceptor = z;
    }

    public final void setFocusHandler$pendoIO_release(sdk.pendo.io.x6.a aVar) {
        this.focusHandler = aVar;
    }

    public final void setForceScreenScanOnScreenContentChange$pendoIO_release(boolean z) {
        this.forceScreenScanOnScreenContentChange = z;
    }

    public Object setNewScreenId$pendoIO_release(String str, boolean z, Continuation<? super Unit> continuation) {
        return setNewScreenId$suspendImpl(this, str, z, continuation);
    }

    @Override // sdk.pendo.io.x6.d
    public void setPendoDrawerListenerRef(WeakReference<PendoDrawerListener> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.pendoDrawerListenerRef = listener;
    }

    public final void setPendoDrawerListenerRef$pendoIO_release(WeakReference<PendoDrawerListener> weakReference) {
        this.pendoDrawerListenerRef = weakReference;
    }

    @Override // sdk.pendo.io.x6.d
    public void setPolicy(boolean includePageViewTexts, boolean includeFeatureClickTexts, boolean includeFeatureClickNestedTexts, boolean includeRetroElementCompatibilityHashes, boolean isOldScreenIdFormat, boolean ignoreDynamicFragmentsInScrollView, boolean isRespondToScrollChangeEventsForScreenId, long globalLayoutChangeDebouncer, boolean shouldDetectClicksForAccessibility) {
        x.a(this.smCoroutineScope, this.screenManagerMutex, null, null, new r(includePageViewTexts, includeFeatureClickTexts, includeFeatureClickNestedTexts, includeRetroElementCompatibilityHashes, isOldScreenIdFormat, ignoreDynamicFragmentsInScrollView, isRespondToScrollChangeEventsForScreenId, globalLayoutChangeDebouncer, shouldDetectClicksForAccessibility, null), 6, null);
    }

    public final void setPreviousScreenId$pendoIO_release(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.previousScreenId = str;
    }

    public final void setScreenContentChangeFlow$pendoIO_release(MutableSharedFlow<Unit> mutableSharedFlow) {
        this.screenContentChangeFlow = mutableSharedFlow;
    }

    public final Object setupTouchInterceptor(Continuation<? super Unit> continuation) {
        Window window;
        if (this.disableGlobalClickInterceptor) {
            return Unit.INSTANCE;
        }
        e1.a aVar = this.currentRootViewData;
        if (aVar == null || !aVar.g()) {
            Activity activity = this.currentActivityRef.get();
            window = activity != null ? activity.getWindow() : null;
        } else {
            window = aVar.c();
        }
        Object objAddGlobalClicksInterceptor = addGlobalClicksInterceptor(window, continuation);
        return objAddGlobalClicksInterceptor == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAddGlobalClicksInterceptor : Unit.INSTANCE;
    }

    public final boolean shouldIgnoreChangesInApp$pendoIO_release() {
        return sdk.pendo.io.j6.a.d() || PlatformStateManager.INSTANCE.isTrackEventSolutionOnly() || !PendoInternal.Z();
    }

    public final boolean shouldListenToAppChanges$pendoIO_release() {
        return (!PendoInternal.Z() || sdk.pendo.io.w6.b.e().f() || this.currentActivityRef.get() == null) ? false : true;
    }

    public void triggerManualNewScreenIdSubject() {
        if (getEMPTY_STRING().length() > 0) {
            this.screenChangedNewScreenIdSubject.onNext(getEMPTY_STRING());
        }
    }

    public /* synthetic */ i(Pendo.PendoOptions pendoOptions, sdk.pendo.io.s7.m mVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(pendoOptions, (i & 2) != 0 ? new sdk.pendo.io.s7.k() : mVar);
    }

    protected Set<View> getCurrentScreenContentRoots(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        return SetsKt.setOf(rootView);
    }

    @Override // sdk.pendo.io.x6.d
    public sdk.pendo.io.k3.j<String> getScreenChangedNewScreenIdSubject() {
        return this.screenChangedNewScreenIdSubject;
    }

    @Override // sdk.pendo.io.x6.d
    public sdk.pendo.io.k3.j<String> getScreenLayoutChangedSameScreenIdSubject() {
        return this.screenLayoutChangedSameScreenIdSubject;
    }
}
