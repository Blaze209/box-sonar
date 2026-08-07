package sdk.pendo.io.v6;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import androidx.compose.material.DrawerState;
import androidx.compose.material.ModalBottomSheetState;
import androidx.compose.material3.SheetState;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.box.android.common.utilities.BoxCommonConstants;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowKt;
import org.json.JSONObject;
import sdk.pendo.io.Pendo;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.network.interfaces.GetAuthToken;
import sdk.pendo.io.s7.b1;
import sdk.pendo.io.s7.e1;
import sdk.pendo.io.s7.x;
import sdk.pendo.io.s7.y0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 ¬\u00012\u00020\u00012\u00020\u0002:\u0002\u0014\u0017B\u001f\u0012\b\u0010§\u0001\u001a\u00030¦\u0001\u0012\n\b\u0002\u0010©\u0001\u001a\u00030¨\u0001¢\u0006\u0006\bª\u0001\u0010«\u0001J,\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\r\u001a\u00020\u000bH\u0002J/\u0010\n\u001a\u00020\u000b2\u001a\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00100\u000eH\u0082@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u000bH\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0016\u001a\u00020\u000bH\u0002J\u0013\u0010\u0017\u001a\u00020\u000bH\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0015J\u0013\u0010\n\u001a\u00020\u000bH\u0082@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u0015J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0002J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0013\u0010\u001c\u001a\u00020\u000bH\u0090@ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0015J\u001b\u0010!\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0090@ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J\u0013\u0010#\u001a\u00020\u000bH\u0090@ø\u0001\u0000¢\u0006\u0004\b\"\u0010\u0015J\b\u0010$\u001a\u00020\u000bH\u0016J\u0013\u0010%\u001a\u00020\u000bH\u0094@ø\u0001\u0000¢\u0006\u0004\b%\u0010\u0015J\u0013\u0010'\u001a\u00020\u0003H\u0090@ø\u0001\u0000¢\u0006\u0004\b&\u0010\u0015J\u0013\u0010)\u001a\u00020\u000bH\u0090@ø\u0001\u0000¢\u0006\u0004\b(\u0010\u0015J\u0013\u0010*\u001a\u00020\u000bH\u0096@ø\u0001\u0000¢\u0006\u0004\b*\u0010\u0015J#\u00100\u001a\u00020-2\u0006\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u0005H\u0090@ø\u0001\u0000¢\u0006\u0004\b.\u0010/J\u001f\u00104\u001a\u00020\u000b2\u000e\u00101\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0010H\u0010¢\u0006\u0004\b2\u00103J\u0016\u0010\n\u001a\u00020\u000b2\f\u00106\u001a\b\u0012\u0004\u0012\u0002050\u0018H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u0019H\u0016J\u0013\u00108\u001a\u00020\u000bH\u0096@ø\u0001\u0000¢\u0006\u0004\b8\u0010\u0015J\u0012\u0010;\u001a\u00020\u000b2\b\u0010:\u001a\u0004\u0018\u000109H\u0016J\u000f\u0010>\u001a\u00020\u000bH\u0010¢\u0006\u0004\b<\u0010=J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010@\u001a\u00020?J\u000f\u0010\u0014\u001a\u00020\u000bH\u0001¢\u0006\u0004\b\u0014\u0010=J\u000f\u0010A\u001a\u00020\u0005H\u0000¢\u0006\u0004\bA\u0010BJ\b\u0010C\u001a\u00020\u0005H\u0017R\u001b\u0010G\u001a\u00020D8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010E\u001a\u0004\b\u0017\u0010FR\u0018\u0010J\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010IR\u001e\u0010M\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010K8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010LR\u0018\u0010Q\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010S\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010PR6\u0010W\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00100\u000e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\r\u0010T\u001a\u0004\bR\u0010U\"\u0004\b\n\u0010VR*\u0010^\u001a\u0004\u0018\u00010\u00038\u0000@\u0000X\u0081\u000e¢\u0006\u0018\n\u0004\b\f\u0010X\u0012\u0004\b]\u0010=\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R*\u0010c\u001a\u0004\u0018\u00010\u00038\u0000@\u0000X\u0081\u000e¢\u0006\u0018\n\u0004\b_\u0010X\u0012\u0004\bb\u0010=\u001a\u0004\b`\u0010Z\"\u0004\ba\u0010\\R*\u0010h\u001a\u0004\u0018\u00010\u00038\u0000@\u0000X\u0081\u000e¢\u0006\u0018\n\u0004\bd\u0010X\u0012\u0004\bg\u0010=\u001a\u0004\be\u0010Z\"\u0004\bf\u0010\\R0\u0010o\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00188\u0000@\u0000X\u0081\u000e¢\u0006\u0018\n\u0004\b\u0016\u0010i\u0012\u0004\bn\u0010=\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\u0016\u0010r\u001a\u00020p8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010qR\"\u0010\u0006\u001a\u00020\u00058\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bs\u0010t\u001a\u0004\bd\u0010B\"\u0004\b\u0014\u0010uR\"\u0010\u0007\u001a\u00020\u00058\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bv\u0010t\u001a\u0004\b_\u0010B\"\u0004\b\n\u0010uR\"\u0010|\u001a\n w*\u0004\u0018\u00010\u00050\u00058\u0000X\u0080\u0004¢\u0006\f\n\u0004\bx\u0010y\u001a\u0004\bz\u0010{R\"\u0010\u007f\u001a\n w*\u0004\u0018\u00010\u00050\u00058\u0000X\u0080\u0004¢\u0006\f\n\u0004\b}\u0010y\u001a\u0004\b~\u0010{R%\u0010\u0082\u0001\u001a\n w*\u0004\u0018\u00010\u00050\u00058\u0000X\u0080\u0004¢\u0006\u000e\n\u0005\b\u0080\u0001\u0010y\u001a\u0005\b\u0081\u0001\u0010{R%\u0010\u0085\u0001\u001a\n w*\u0004\u0018\u00010\u00050\u00058\u0000X\u0080\u0004¢\u0006\u000e\n\u0005\b\u0083\u0001\u0010y\u001a\u0005\b\u0084\u0001\u0010{R \u0010\u008b\u0001\u001a\u00030\u0086\u00018\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\b\u0087\u0001\u0010\u0088\u0001\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001R\u0018\u0010\u008f\u0001\u001a\u00030\u008c\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R\u001f\u0010\u0094\u0001\u001a\u00030\u0090\u00018\u0010X\u0090\u0004¢\u0006\u000f\n\u0006\b\u0091\u0001\u0010\u0092\u0001\u001a\u0005\bO\u0010\u0093\u0001R$\u0010\u0098\u0001\u001a\t\u0012\u0004\u0012\u0002050\u0095\u00018\u0000X\u0080\u0004¢\u0006\u000e\n\u0005\b\u0096\u0001\u0010i\u001a\u0005\b\u0097\u0001\u0010kR1\u0010\u009b\u0001\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00100\u000e8\u0000X\u0080\u0004¢\u0006\u000e\n\u0005\b\u0099\u0001\u0010T\u001a\u0005\b\u009a\u0001\u0010UR-\u0010\u009d\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u001c\n\u0005\b\u009c\u0001\u0010t\u0012\u0005\b\u009f\u0001\u0010=\u001a\u0005\b\u009d\u0001\u0010B\"\u0005\b\u009e\u0001\u0010uR\u001e\u0010£\u0001\u001a\t\u0012\u0004\u0012\u00020\u00050 \u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¡\u0001\u0010¢\u0001R\u001c\u0010¥\u0001\u001a\b\u0012\u0004\u0012\u00020\u00030\u00188\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b¤\u0001\u0010i\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u00ad\u0001"}, d2 = {"Lsdk/pendo/io/v6/e;", "Lsdk/pendo/io/x6/e;", "Lsdk/pendo/io/v6/h;", "", "route", "", "isDrawerOpen", "isBottomSheetOpen", "Lsdk/pendo/io/s7/e1$a;", "rootViewData", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", "g", "f", "", "", "Ljava/lang/ref/WeakReference;", "Landroid/view/ViewGroup;", "androidComposeViewMap", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "b", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "j", "c", "", "Landroid/view/View;", "root", "calculateScreenIdentifierAndScreenData$pendoIO_release", "calculateScreenIdentifierAndScreenData", "Landroid/app/Activity;", "activity", "onActivityResumedInternal$pendoIO_release", "(Landroid/app/Activity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onActivityResumedInternal", "handleVeryFirstScreen$pendoIO_release", "handleVeryFirstScreen", "initGlobalLayoutChangeListener", "handleScrollChangeEvent", "calculateScreenId$pendoIO_release", "calculateScreenId", "handleNewScreenIdentified$pendoIO_release", "handleNewScreenIdentified", "handleSameScreenIdentified", "includeText", "isForCapture", "Lorg/json/JSONObject;", "getScreenData$pendoIO_release", "(ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getScreenData", "rootViewWeakReference", "setFocusListener$pendoIO_release", "(Ljava/lang/ref/WeakReference;)V", "setFocusListener", "Lsdk/pendo/io/v6/a;", "allElementsList", "androidComposeView", "clearInternal", "Lsdk/pendo/io/network/interfaces/GetAuthToken$GetAuthTokenResponse;", "response", "onGetAccessTokenResponseReceived", "cancelScreenManagerCoroutineJobs$pendoIO_release", "()V", "cancelScreenManagerCoroutineJobs", "", "state", "k", "()Z", "shouldCollectDynamicChanges", "Lsdk/pendo/io/s7/i;", "Lkotlin/Lazy;", "()Lsdk/pendo/io/s7/i;", "composeUtilityHelper", "Landroid/view/ViewTreeObserver$OnDrawListener;", "Landroid/view/ViewTreeObserver$OnDrawListener;", "onDrawListener", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "drawEventsFlow", "Lkotlinx/coroutines/Job;", "d", "Lkotlinx/coroutines/Job;", "drawEventsCollectionJob", "e", "navBackstackCollectionJob", "Ljava/util/Map;", "()Ljava/util/Map;", "(Ljava/util/Map;)V", "visibleAndroidComposeViews", "Ljava/lang/String;", "getLastActiveComposeRouteNav2$pendoIO_release", "()Ljava/lang/String;", "setLastActiveComposeRouteNav2$pendoIO_release", "(Ljava/lang/String;)V", "getLastActiveComposeRouteNav2$pendoIO_release$annotations", "lastActiveComposeRouteNav2", CmcdData.STREAMING_FORMAT_HLS, "getLastActiveComposeRouteNav3$pendoIO_release", "setLastActiveComposeRouteNav3$pendoIO_release", "getLastActiveComposeRouteNav3$pendoIO_release$annotations", "lastActiveComposeRouteNav3", "i", "getLastActiveComposeRouteCircuit$pendoIO_release", "setLastActiveComposeRouteCircuit$pendoIO_release", "getLastActiveComposeRouteCircuit$pendoIO_release$annotations", "lastActiveComposeRouteCircuit", "Ljava/util/List;", "getLastActiveScreenTags$pendoIO_release", "()Ljava/util/List;", "setLastActiveScreenTags$pendoIO_release", "(Ljava/util/List;)V", "getLastActiveScreenTags$pendoIO_release$annotations", "lastActiveScreenTags", "Lsdk/pendo/io/Pendo$PendoOptions$AdaptivePageScanningMode;", "Lsdk/pendo/io/Pendo$PendoOptions$AdaptivePageScanningMode;", "adaptivePageScanningMode", CmcdData.STREAM_TYPE_LIVE, "Z", "(Z)V", CmcdData.OBJECT_TYPE_MANIFEST, "kotlin.jvm.PlatformType", "n", "Ljava/lang/Boolean;", "isComposeMaterialDrawerStateAvailable$pendoIO_release", "()Ljava/lang/Boolean;", "isComposeMaterialDrawerStateAvailable", "o", "isComposeMaterial3DrawerStateAvailable$pendoIO_release", "isComposeMaterial3DrawerStateAvailable", "p", "isComposeMaterialModalBottomSheetStateAvailable$pendoIO_release", "isComposeMaterialModalBottomSheetStateAvailable", "q", "isComposeMaterial3SheetStateAvailable$pendoIO_release", "isComposeMaterial3SheetStateAvailable", "Lsdk/pendo/io/v6/c;", "r", "Lsdk/pendo/io/v6/c;", "getComposeMotionEventHandler$pendoIO_release", "()Lsdk/pendo/io/v6/c;", "composeMotionEventHandler", "Lsdk/pendo/io/x6/m;", "s", "Lsdk/pendo/io/x6/m;", "viewMotionEventHandler", "Lsdk/pendo/io/v6/g;", "t", "Lsdk/pendo/io/v6/g;", "()Lsdk/pendo/io/v6/g;", "motionEventHandler", "", "u", "getAllComposeElementsOnScreen$pendoIO_release", "allComposeElementsOnScreen", "v", "getAndroidComposeViewsOnScreen$pendoIO_release", "androidComposeViewsOnScreen", "w", "isDrawEventsFlowActive", "setDrawEventsFlowActive", "isDrawEventsFlowActive$annotations", "Lkotlinx/coroutines/flow/MutableStateFlow;", "x", "Lkotlinx/coroutines/flow/MutableStateFlow;", "useDebounce", "y", "specialComposeViewElements", "Lsdk/pendo/io/Pendo$PendoOptions;", "pendoOptions", "Lsdk/pendo/io/s7/m;", "dispatcherProvider", "<init>", "(Lsdk/pendo/io/Pendo$PendoOptions;Lsdk/pendo/io/s7/m;)V", "z", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class e extends sdk.pendo.io.x6.e implements sdk.pendo.io.v6.h {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final Lazy composeUtilityHelper;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private ViewTreeObserver.OnDrawListener onDrawListener;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private MutableSharedFlow<Unit> drawEventsFlow;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private Job drawEventsCollectionJob;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private Job navBackstackCollectionJob;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private Map<Integer, WeakReference<ViewGroup>> visibleAndroidComposeViews;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private volatile String lastActiveComposeRouteNav2;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private volatile String lastActiveComposeRouteNav3;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private volatile String lastActiveComposeRouteCircuit;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private volatile List<String> lastActiveScreenTags;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private Pendo.PendoOptions.AdaptivePageScanningMode adaptivePageScanningMode;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    private volatile boolean isDrawerOpen;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    private volatile boolean isBottomSheetOpen;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    private final Boolean isComposeMaterialDrawerStateAvailable;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    private final Boolean isComposeMaterial3DrawerStateAvailable;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    private final Boolean isComposeMaterialModalBottomSheetStateAvailable;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    private final Boolean isComposeMaterial3SheetStateAvailable;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    private final sdk.pendo.io.v6.c composeMotionEventHandler;

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    private final sdk.pendo.io.x6.m viewMotionEventHandler;

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    private final sdk.pendo.io.v6.g motionEventHandler;

    /* JADX INFO: renamed from: u, reason: from kotlin metadata */
    private final List<sdk.pendo.io.v6.a> allComposeElementsOnScreen;

    /* JADX INFO: renamed from: v, reason: from kotlin metadata */
    private final Map<Integer, WeakReference<ViewGroup>> androidComposeViewsOnScreen;

    /* JADX INFO: renamed from: w, reason: from kotlin metadata */
    private boolean isDrawEventsFlowActive;

    /* JADX INFO: renamed from: x, reason: from kotlin metadata */
    private final MutableStateFlow<Boolean> useDebounce;

    /* JADX INFO: renamed from: y, reason: from kotlin metadata */
    private final List<String> specialComposeViewElements;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sdk.compose.ComposeScreenManager$1", f = "ComposeScreenManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
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
            return e.this.new a(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            e.this.c().a((sdk.pendo.io.v6.h) e.this);
            b1.a.a(e.this.c());
            PendoLogger.d("ComposeScreenManager", "Pendo session is using Compose");
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\r\u0010\u000b¨\u0006\u0011"}, d2 = {"Lsdk/pendo/io/v6/e$c;", "", "", "toString", "", "hashCode", "other", "", "equals", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Z", "()Z", "isDrawer", "b", "isOpen", "<init>", "(ZZ)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    private static final /* data */ class c {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final boolean isDrawer;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        private final boolean isOpen;

        public c(boolean z, boolean z2) {
            this.isDrawer = z;
            this.isOpen = z2;
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final boolean getIsDrawer() {
            return this.isDrawer;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final boolean getIsOpen() {
            return this.isOpen;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof c)) {
                return false;
            }
            c cVar = (c) other;
            return this.isDrawer == cVar.isDrawer && this.isOpen == cVar.isOpen;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        public int hashCode() {
            boolean z = this.isDrawer;
            ?? r0 = z;
            if (z) {
                r0 = 1;
            }
            int i = r0 * 31;
            boolean z2 = this.isOpen;
            return i + (z2 ? 1 : z2);
        }

        public String toString() {
            return "ComposableStateInfo(isDrawer=" + this.isDrawer + ", isOpen=" + this.isOpen + ")";
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Pendo.PendoOptions.AdaptivePageScanningMode.values().length];
            try {
                iArr[Pendo.PendoOptions.AdaptivePageScanningMode.TIME_FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Pendo.PendoOptions.AdaptivePageScanningMode.DISABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    /* JADX INFO: renamed from: sdk.pendo.io.v6.e$e, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sdk.compose.ComposeScreenManager$addComposeViewListenersTemp$2", f = "ComposeScreenManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C0504e extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ Map<Integer, WeakReference<ViewGroup>> c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0504e(Map<Integer, WeakReference<ViewGroup>> map, Continuation<? super C0504e> continuation) {
            super(2, continuation);
            this.c = map;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C0504e) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return e.this.new C0504e(this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ViewTreeObserver viewTreeObserver;
            ViewTreeObserver viewTreeObserver2;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            e eVar = e.this;
            Map<Integer, WeakReference<ViewGroup>> mapE = eVar.e();
            Map<Integer, WeakReference<ViewGroup>> map = this.c;
            e eVar2 = e.this;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<Integer, WeakReference<ViewGroup>> entry : mapE.entrySet()) {
                int iIntValue = entry.getKey().intValue();
                WeakReference<ViewGroup> value = entry.getValue();
                if (map.containsKey(Boxing.boxInt(iIntValue))) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                } else {
                    PendoLogger.d("ComposeScreenManager", "androidComposeView is not in the map anymore, removing it - " + iIntValue);
                    ViewGroup viewGroup = value.get();
                    if (viewGroup != null && (viewTreeObserver2 = viewGroup.getViewTreeObserver()) != null) {
                        viewTreeObserver2.removeOnDrawListener(eVar2.onDrawListener);
                    }
                }
            }
            eVar.a(TypeIntrinsics.asMutableMap(linkedHashMap));
            Map<Integer, WeakReference<ViewGroup>> mapE2 = e.this.e();
            Map<Integer, WeakReference<ViewGroup>> map2 = this.c;
            e eVar3 = e.this;
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Map.Entry<Integer, WeakReference<ViewGroup>> entry2 : map2.entrySet()) {
                int iIntValue2 = entry2.getKey().intValue();
                WeakReference<ViewGroup> value2 = entry2.getValue();
                if (!eVar3.e().containsKey(Boxing.boxInt(iIntValue2))) {
                    PendoLogger.d("ComposeScreenManager", "androidComposeView is new, adding it - " + iIntValue2 + " for view " + value2.get());
                    ViewGroup viewGroup2 = value2.get();
                    if (viewGroup2 != null && (viewTreeObserver = viewGroup2.getViewTreeObserver()) != null) {
                        viewTreeObserver.addOnDrawListener(eVar3.onDrawListener);
                    }
                    linkedHashMap2.put(entry2.getKey(), entry2.getValue());
                }
            }
            mapE2.putAll(linkedHashMap2);
            PendoLogger.d("ComposeScreenManager", "addComposeViewListenersTemp -> visibleAndroidComposeViews size: " + e.this.e().size());
            return Unit.INSTANCE;
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sdk.pendo.io.sdk.compose.ComposeScreenManager", f = "ComposeScreenManager.kt", i = {0, 1, 2, 3}, l = {123, 130, Token.TARGET, Token.LOOP, 134}, m = "calculateScreenIdentifierAndScreenData$pendoIO_release", n = {"this", "this", "this", "this"}, s = {"L$0", "L$0", "L$0", "L$0"})
    static final class f extends ContinuationImpl {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        f(Continuation<? super f> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return e.this.calculateScreenIdentifierAndScreenData$pendoIO_release(this);
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sdk.pendo.io.sdk.compose.ComposeScreenManager", f = "ComposeScreenManager.kt", i = {0}, l = {249, 255}, m = "clearInternal", n = {"this"}, s = {"L$0"})
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
            return e.this.clearInternal(this);
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* synthetic */ class h extends FunctionReferenceImpl implements Function0<Boolean> {
        h(Object obj) {
            super(0, obj, e.class, "shouldIgnoreLowCodeLogic", "shouldIgnoreLowCodeLogic$pendoIO_release()Z", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return Boolean.valueOf(((e) this.receiver).k());
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sdk.pendo.io.sdk.compose.ComposeScreenManager", f = "ComposeScreenManager.kt", i = {0, 1}, l = {209, BoxCommonConstants.REQUEST_RENAME}, m = "getScreenData$pendoIO_release", n = {"this", "screenDataAsJson"}, s = {"L$0", "L$0"})
    static final class i extends ContinuationImpl {
        Object a;
        /* synthetic */ Object b;
        int d;

        i(Continuation<? super i> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return e.this.getScreenData$pendoIO_release(false, false, this);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sdk.compose.ComposeScreenManager$handleComposableState$1", f = "ComposeScreenManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class j extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ Object c;
        final /* synthetic */ c d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(Object obj, c cVar, Continuation<? super j> continuation) {
            super(2, continuation);
            this.c = obj;
            this.d = cVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((j) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return e.this.new j(this.c, this.d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            sdk.pendo.io.x6.g gVar;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (e.this.k()) {
                return Unit.INSTANCE;
            }
            PendoLogger.d("ComposeScreenManager", "handleComposableState -> state: " + this.c);
            boolean isBottomSheetOpen = e.this.getIsBottomSheetOpen();
            boolean isDrawerOpen = e.this.getIsDrawerOpen();
            c cVar = this.d;
            if (cVar == null) {
                PendoLogger.i("ComposeScreenManager", "handleComposableState -> we don't yet support this compose state: " + this.c);
            } else if (cVar.getIsDrawer()) {
                e.this.b(this.d.getIsOpen());
            } else {
                e.this.a(this.d.getIsOpen());
            }
            if (isDrawerOpen == e.this.getIsDrawerOpen()) {
                if (isBottomSheetOpen != e.this.getIsBottomSheetOpen()) {
                    gVar = e.this.getIsBottomSheetOpen() ? sdk.pendo.io.x6.g.ON_BOTTOM_SHEET_OPENED : sdk.pendo.io.x6.g.ON_BOTTOM_SHEET_CLOSED;
                }
                return Unit.INSTANCE;
            }
            gVar = e.this.getIsDrawerOpen() ? sdk.pendo.io.x6.g.ON_DRAWER_OPENED : sdk.pendo.io.x6.g.ON_DRAWER_CLOSED;
            e.this.onGlobalLayoutChangeEvent(gVar);
            return Unit.INSTANCE;
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sdk.pendo.io.sdk.compose.ComposeScreenManager", f = "ComposeScreenManager.kt", i = {0}, l = {204, 205}, m = "handleSameScreenIdentified", n = {"this"}, s = {"L$0"})
    static final class k extends ContinuationImpl {
        Object a;
        /* synthetic */ Object b;
        int d;

        k(Continuation<? super k> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return e.this.handleSameScreenIdentified(this);
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sdk.pendo.io.sdk.compose.ComposeScreenManager", f = "ComposeScreenManager.kt", i = {0}, l = {Token.ARROW, Token.YIELD_STAR}, m = "handleScrollChangeEvent", n = {"this"}, s = {"L$0"})
    static final class l extends ContinuationImpl {
        Object a;
        /* synthetic */ Object b;
        int d;

        l(Continuation<? super l> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return e.this.handleScrollChangeEvent(this);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sdk.compose.ComposeScreenManager$initDrawEventsFlow$1", f = "ComposeScreenManager.kt", i = {}, l = {335}, m = "invokeSuspend", n = {}, s = {})
    static final class m extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;

        @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "it", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Lkotlin/Unit;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0})
        static final class a<T> implements FlowCollector {
            final /* synthetic */ e a;

            a(e eVar) {
                this.a = eVar;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object emit(Unit unit, Continuation<? super Unit> continuation) {
                if (!this.a.shouldCollectDynamicChanges()) {
                    return Unit.INSTANCE;
                }
                PendoLogger.d("ComposeScreenManager", "drawEventsFlow COLLECT after 2000ms ");
                this.a.onGlobalLayoutChangeEvent(sdk.pendo.io.x6.g.ON_DRAW);
                return Unit.INSTANCE;
            }
        }

        m(Continuation<? super m> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((m) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return e.this.new m(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Flow flowSample;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableSharedFlow mutableSharedFlow = e.this.drawEventsFlow;
                if (mutableSharedFlow != null && (flowSample = FlowKt.sample(mutableSharedFlow, 2000L)) != null) {
                    a aVar = new a(e.this);
                    this.a = 1;
                    if (flowSample.collect(aVar, this) == coroutine_suspended) {
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

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sdk.compose.ComposeScreenManager$onGetAccessTokenResponseReceived$1", f = "ComposeScreenManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class n extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ GetAuthToken.GetAuthTokenResponse b;
        final /* synthetic */ e c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        n(GetAuthToken.GetAuthTokenResponse getAuthTokenResponse, e eVar, Continuation<? super n> continuation) {
            super(2, continuation);
            this.b = getAuthTokenResponse;
            this.c = eVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((n) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new n(this.b, this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            GetAuthToken.GetAuthTokenResponse getAuthTokenResponse = this.b;
            if (getAuthTokenResponse != null) {
                boolean disableComposeWindowCallback = getAuthTokenResponse.getDisableComposeWindowCallback();
                e eVar = this.c;
                eVar.setDisableGlobalClickInterceptor$pendoIO_release(disableComposeWindowCallback);
                PendoLogger.d("ComposeScreenManager", "disableComposeWindowCallback- " + eVar.getDisableGlobalClickInterceptor());
            }
            e.super.onGetAccessTokenResponseReceived(this.b);
            return Unit.INSTANCE;
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sdk.pendo.io.sdk.compose.ComposeScreenManager", f = "ComposeScreenManager.kt", i = {0, 0}, l = {444}, m = "refreshActiveComposeRoutesSnapshot", n = {"this", "routeSnapshot"}, s = {"L$0", "L$1"})
    static final class o extends ContinuationImpl {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int f;

        o(Continuation<? super o> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return e.this.a((Continuation<? super Unit>) this);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sdk.compose.ComposeScreenManager$removeAllViewsInListenersMap$2", f = "ComposeScreenManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
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
            return e.this.new p(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Collection<WeakReference<ViewGroup>> collectionValues = e.this.e().values();
            e eVar = e.this;
            Iterator<T> it = collectionValues.iterator();
            while (it.hasNext()) {
                ViewGroup viewGroup = (ViewGroup) ((WeakReference) it.next()).get();
                if (viewGroup == null) {
                    return Unit.INSTANCE;
                }
                Intrinsics.checkNotNull(viewGroup);
                viewGroup.getViewTreeObserver().removeOnDrawListener(eVar.onDrawListener);
            }
            e.this.e().clear();
            return Unit.INSTANCE;
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sdk.pendo.io.sdk.compose.ComposeScreenManager", f = "ComposeScreenManager.kt", i = {0}, l = {429}, m = "sendVisibleAndroidComposeViewsAndClear", n = {"this"}, s = {"L$0"})
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
            return e.this.c(this);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\u0004\u001a\u00028\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "invoke", "()Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    public static final class r extends Lambda implements Function0<sdk.pendo.io.s7.i> {
        final /* synthetic */ sdk.pendo.io.v2.a a;
        final /* synthetic */ sdk.pendo.io.d3.a b;
        final /* synthetic */ Function0 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(sdk.pendo.io.v2.a aVar, sdk.pendo.io.d3.a aVar2, Function0 function0) {
            super(0);
            this.a = aVar;
            this.b = aVar2;
            this.c = function0;
        }

        /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object, sdk.pendo.io.s7.i] */
        @Override // kotlin.jvm.functions.Function0
        public final sdk.pendo.io.s7.i invoke() {
            sdk.pendo.io.v2.a aVar = this.a;
            return (aVar instanceof sdk.pendo.io.v2.b ? ((sdk.pendo.io.v2.b) aVar).getScope() : aVar.getKoin().getScopeRegistry().getRootScope()).b(Reflection.getOrCreateKotlinClass(sdk.pendo.io.s7.i.class), this.b, this.c);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Pendo.PendoOptions pendoOptions, sdk.pendo.io.s7.m dispatcherProvider) {
        super(pendoOptions, dispatcherProvider);
        Intrinsics.checkNotNullParameter(pendoOptions, "pendoOptions");
        Intrinsics.checkNotNullParameter(dispatcherProvider, "dispatcherProvider");
        this.composeUtilityHelper = LazyKt.lazy(sdk.pendo.io.i3.b.a.a(), (Function0) new r(this, null, null));
        this.visibleAndroidComposeViews = new LinkedHashMap();
        Pendo.PendoOptions.AdaptivePageScanningMode adaptivePageScanning = pendoOptions.getAdaptivePageScanning();
        Intrinsics.checkNotNullExpressionValue(adaptivePageScanning, "getAdaptivePageScanning(...)");
        this.adaptivePageScanningMode = adaptivePageScanning;
        this.isComposeMaterialDrawerStateAvailable = y0.b("androidx.compose.material.DrawerState");
        this.isComposeMaterial3DrawerStateAvailable = y0.b("androidx.compose.material3.DrawerState");
        this.isComposeMaterialModalBottomSheetStateAvailable = y0.b("androidx.compose.material.ModalBottomSheetState");
        this.isComposeMaterial3SheetStateAvailable = y0.b("androidx.compose.material3.SheetState");
        sdk.pendo.io.v6.c cVar = new sdk.pendo.io.v6.c(new h(this), getScreenManagerPolicy().getIncludeFeatureClickTexts(), this);
        this.composeMotionEventHandler = cVar;
        sdk.pendo.io.x6.m mVar = new sdk.pendo.io.x6.m(this);
        this.viewMotionEventHandler = mVar;
        this.motionEventHandler = new sdk.pendo.io.v6.g(cVar, mVar);
        this.allComposeElementsOnScreen = new ArrayList();
        this.androidComposeViewsOnScreen = new LinkedHashMap();
        this.isDrawEventsFlowActive = true;
        this.useDebounce = StateFlowKt.MutableStateFlow(Boolean.TRUE);
        this.specialComposeViewElements = CollectionsKt.listOf("MapView");
        x.a(getSmCoroutineScope(), getScreenManagerMutex(), new CoroutineName("composeScreenManagerInit"), null, new a(null), 4, null);
    }

    private final void f() {
        if (this.drawEventsFlow == null) {
            this.drawEventsFlow = SharedFlowKt.MutableSharedFlow(1, 1, BufferOverflow.DROP_LATEST);
        }
        Job job = this.drawEventsCollectionJob;
        if (job == null || job == null || !job.isActive()) {
            this.drawEventsCollectionJob = BuildersKt__Builders_commonKt.launch$default(getSmCoroutineScope(), new CoroutineName("drawEventsCollectionCoroutine"), null, new m(null), 2, null);
        }
    }

    private final void g() {
        if (this.onDrawListener == null) {
            this.onDrawListener = new ViewTreeObserver.OnDrawListener() { // from class: sdk.pendo.io.v6.e$$ExternalSyntheticLambda1
                @Override // android.view.ViewTreeObserver.OnDrawListener
                public final void onDraw() {
                    e.e(this.f$0);
                }
            };
        }
    }

    private final void j() {
        PendoLogger.d("ComposeScreenManager sendAllElementsListAndClear -> list size: " + this.allComposeElementsOnScreen.size(), new Object[0]);
        this.composeMotionEventHandler.a(CollectionsKt.toMutableList((Collection) this.allComposeElementsOnScreen));
        this.allComposeElementsOnScreen.clear();
    }

    @Override // sdk.pendo.io.x6.e, sdk.pendo.io.x6.i
    public Object calculateScreenId$pendoIO_release(Continuation<? super String> continuation) {
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        String str = this.lastActiveComposeRouteNav2;
        if (str != null) {
            if (StringsKt.isBlank(str)) {
                str = null;
            }
            if (str != null) {
                Boxing.boxBoolean(listCreateListBuilder.add(str));
            }
        }
        String str2 = this.lastActiveComposeRouteNav3;
        if (str2 != null) {
            if (StringsKt.isBlank(str2)) {
                str2 = null;
            }
            if (str2 != null) {
                Boxing.boxBoolean(listCreateListBuilder.add(str2));
            }
        }
        String str3 = this.lastActiveComposeRouteCircuit;
        if (str3 != null) {
            if (StringsKt.isBlank(str3)) {
                str3 = null;
            }
            if (str3 != null) {
                Boxing.boxBoolean(listCreateListBuilder.add(str3));
            }
        }
        List<String> list = this.lastActiveScreenTags;
        if (list != null) {
            listCreateListBuilder.addAll(list);
        }
        List listSorted = CollectionsKt.sorted(CollectionsKt.build(listCreateListBuilder));
        List list2 = !listSorted.isEmpty() ? listSorted : null;
        String strJoinToString$default = list2 != null ? CollectionsKt.joinToString$default(list2, "|", null, null, 0, null, null, 62, null) : null;
        return (strJoinToString$default == null || strJoinToString$default.length() == 0) ? super.calculateScreenId$pendoIO_release(continuation) : a(strJoinToString$default, this.isDrawerOpen, this.isBottomSheetOpen, getCurrentRootViewData());
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00b2 A[PHI: r11 r12
      0x00b2: PHI (r11v5 'this' sdk.pendo.io.v6.e) = (r11v4 'this' sdk.pendo.io.v6.e), (r11v15 'this' sdk.pendo.io.v6.e) binds: [B:34:0x00af, B:19:0x0049] A[DONT_GENERATE, DONT_INLINE]
      0x00b2: PHI (r12v12 java.lang.Object) = (r12v11 java.lang.Object), (r12v1 java.lang.Object) binds: [B:34:0x00af, B:19:0x0049] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:39:0x00bf A[PHI: r11
      0x00bf: PHI (r11v6 'this' sdk.pendo.io.v6.e) = (r11v5 'this' sdk.pendo.io.v6.e), (r11v17 'this' sdk.pendo.io.v6.e) binds: [B:37:0x00bc, B:18:0x0040] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00c7, code lost:
    
        if (r11.setupTouchInterceptor(r0) == r1) goto L41;
     */
    @Override // sdk.pendo.io.x6.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object calculateScreenIdentifierAndScreenData$pendoIO_release(kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            Method dump skipped, instruction units count: 205
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.v6.e.calculateScreenIdentifierAndScreenData$pendoIO_release(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // sdk.pendo.io.x6.e, sdk.pendo.io.x6.i
    public void cancelScreenManagerCoroutineJobs$pendoIO_release() {
        super.cancelScreenManagerCoroutineJobs$pendoIO_release();
        this.drawEventsCollectionJob = null;
        this.drawEventsFlow = null;
        Job job = this.navBackstackCollectionJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.navBackstackCollectionJob = null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x005b, code lost:
    
        if (super.clearInternal(r0) == r1) goto L21;
     */
    @Override // sdk.pendo.io.x6.e, sdk.pendo.io.x6.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object clearInternal(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof sdk.pendo.io.v6.e.g
            if (r0 == 0) goto L13
            r0 = r6
            sdk.pendo.io.v6.e$g r0 = (sdk.pendo.io.v6.e.g) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            sdk.pendo.io.v6.e$g r0 = new sdk.pendo.io.v6.e$g
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r6)
            goto L5e
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            java.lang.Object r5 = r0.a
            sdk.pendo.io.v6.e r5 = (sdk.pendo.io.v6.e) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4a
        L3c:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.a = r5
            r0.d = r4
            java.lang.Object r6 = r5.b(r0)
            if (r6 != r1) goto L4a
            goto L5d
        L4a:
            r6 = 0
            r5.lastActiveComposeRouteNav2 = r6
            r5.lastActiveComposeRouteNav3 = r6
            r5.lastActiveComposeRouteCircuit = r6
            r5.lastActiveScreenTags = r6
            r0.a = r6
            r0.d = r3
            java.lang.Object r5 = super.clearInternal(r0)
            if (r5 != r1) goto L5e
        L5d:
            return r1
        L5e:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.v6.e.clearInternal(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // sdk.pendo.io.x6.i
    /* JADX INFO: renamed from: d, reason: from getter and merged with bridge method [inline-methods] */
    public sdk.pendo.io.v6.g getMotionEventHandler$pendoIO_release() {
        return this.motionEventHandler;
    }

    public final Map<Integer, WeakReference<ViewGroup>> e() {
        return this.visibleAndroidComposeViews;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // sdk.pendo.io.x6.e, sdk.pendo.io.x6.i
    public Object getScreenData$pendoIO_release(boolean z, boolean z2, Continuation<? super JSONObject> continuation) {
        i iVar;
        if (continuation instanceof i) {
            iVar = (i) continuation;
            int i2 = iVar.d;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                iVar.d = i2 - Integer.MIN_VALUE;
            } else {
                iVar = new i(continuation);
            }
        } else {
            iVar = new i(continuation);
        }
        Object screenData$pendoIO_release = iVar.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = iVar.d;
        if (i3 == 0) {
            ResultKt.throwOnFailure(screenData$pendoIO_release);
            iVar.a = this;
            iVar.d = 1;
            screenData$pendoIO_release = super.getScreenData$pendoIO_release(z, z2, iVar);
            if (screenData$pendoIO_release != coroutine_suspended) {
            }
        }
        if (i3 != 1) {
            if (i3 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            JSONObject jSONObject = (JSONObject) iVar.a;
            ResultKt.throwOnFailure(screenData$pendoIO_release);
            return jSONObject;
        }
        this = (e) iVar.a;
        ResultKt.throwOnFailure(screenData$pendoIO_release);
        JSONObject jSONObject2 = (JSONObject) screenData$pendoIO_release;
        this.b();
        this.j();
        iVar.a = jSONObject2;
        iVar.d = 2;
        return this.c(iVar) == coroutine_suspended ? coroutine_suspended : jSONObject2;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final boolean getIsBottomSheetOpen() {
        return this.isBottomSheetOpen;
    }

    @Override // sdk.pendo.io.x6.e, sdk.pendo.io.x6.i
    public Object handleNewScreenIdentified$pendoIO_release(Continuation<? super Unit> continuation) {
        sdk.pendo.io.s7.e.INSTANCE.a().b();
        Object objHandleNewScreenIdentified$pendoIO_release = super.handleNewScreenIdentified$pendoIO_release(continuation);
        return objHandleNewScreenIdentified$pendoIO_release == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objHandleNewScreenIdentified$pendoIO_release : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005b, code lost:
    
        if (super.handleSameScreenIdentified(r0) == r1) goto L23;
     */
    @Override // sdk.pendo.io.x6.e, sdk.pendo.io.x6.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object handleSameScreenIdentified(kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof sdk.pendo.io.v6.e.k
            if (r0 == 0) goto L13
            r0 = r7
            sdk.pendo.io.v6.e$k r0 = (sdk.pendo.io.v6.e.k) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            sdk.pendo.io.v6.e$k r0 = new sdk.pendo.io.v6.e$k
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 2
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L3d
            if (r2 == r5) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r7)
            goto L5e
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            java.lang.Object r6 = r0.a
            sdk.pendo.io.v6.e r6 = (sdk.pendo.io.v6.e) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L53
        L3d:
            kotlin.ResultKt.throwOnFailure(r7)
            sdk.pendo.io.s7.b1 r7 = sdk.pendo.io.s7.b1.a
            sdk.pendo.io.s7.i r7 = r7.a()
            if (r7 == 0) goto L53
            r0.a = r6
            r0.d = r5
            java.lang.Object r7 = sdk.pendo.io.s7.i.a(r7, r4, r0, r5, r4)
            if (r7 != r1) goto L53
            goto L5d
        L53:
            r0.a = r4
            r0.d = r3
            java.lang.Object r6 = super.handleSameScreenIdentified(r0)
            if (r6 != r1) goto L5e
        L5d:
            return r1
        L5e:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.v6.e.handleSameScreenIdentified(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005b, code lost:
    
        if (super.handleScrollChangeEvent(r0) == r1) goto L23;
     */
    @Override // sdk.pendo.io.x6.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected java.lang.Object handleScrollChangeEvent(kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof sdk.pendo.io.v6.e.l
            if (r0 == 0) goto L13
            r0 = r7
            sdk.pendo.io.v6.e$l r0 = (sdk.pendo.io.v6.e.l) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            sdk.pendo.io.v6.e$l r0 = new sdk.pendo.io.v6.e$l
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 2
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L3d
            if (r2 == r5) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r7)
            goto L5e
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            java.lang.Object r6 = r0.a
            sdk.pendo.io.v6.e r6 = (sdk.pendo.io.v6.e) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L53
        L3d:
            kotlin.ResultKt.throwOnFailure(r7)
            sdk.pendo.io.s7.b1 r7 = sdk.pendo.io.s7.b1.a
            sdk.pendo.io.s7.i r7 = r7.a()
            if (r7 == 0) goto L53
            r0.a = r6
            r0.d = r5
            java.lang.Object r7 = sdk.pendo.io.s7.i.a(r7, r4, r0, r5, r4)
            if (r7 != r1) goto L53
            goto L5d
        L53:
            r0.a = r4
            r0.d = r3
            java.lang.Object r6 = super.handleScrollChangeEvent(r0)
            if (r6 != r1) goto L5e
        L5d:
            return r1
        L5e:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.v6.e.handleScrollChangeEvent(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // sdk.pendo.io.x6.i
    public Object handleVeryFirstScreen$pendoIO_release(Continuation<? super Unit> continuation) {
        onGlobalLayoutChangeEvent(sdk.pendo.io.x6.g.ON_SCREEN_CHANGED);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final boolean getIsDrawerOpen() {
        return this.isDrawerOpen;
    }

    @Override // sdk.pendo.io.x6.e
    public void initGlobalLayoutChangeListener() {
        if (getOnGlobalLayoutChangeListener() == null) {
            setOnGlobalLayoutChangeListener$pendoIO_release(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: sdk.pendo.io.v6.e$$ExternalSyntheticLambda0
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public final void onGlobalLayout() {
                    e.d(this.f$0);
                }
            });
        }
    }

    public final boolean k() {
        return shouldIgnoreChangesInApp$pendoIO_release() && !PendoInternal.S();
    }

    @Override // sdk.pendo.io.x6.e, sdk.pendo.io.x6.i
    public Object onActivityResumedInternal$pendoIO_release(Activity activity, Continuation<? super Unit> continuation) {
        g();
        f();
        Object objOnActivityResumedInternal$pendoIO_release = super.onActivityResumedInternal$pendoIO_release(activity, continuation);
        return objOnActivityResumedInternal$pendoIO_release == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objOnActivityResumedInternal$pendoIO_release : Unit.INSTANCE;
    }

    @Override // sdk.pendo.io.x6.e, sdk.pendo.io.f6.d
    public void onGetAccessTokenResponseReceived(GetAuthToken.GetAuthTokenResponse response) {
        x.a(getSmCoroutineScope(), getScreenManagerMutex(), null, null, new n(response, this, null), 6, null);
    }

    @Override // sdk.pendo.io.x6.e
    public void setFocusListener$pendoIO_release(WeakReference<View> rootViewWeakReference) {
        View view;
        if (rootViewWeakReference == null || (view = rootViewWeakReference.get()) == null) {
            return;
        }
        String strQ = e1.q(view);
        Intrinsics.checkNotNullExpressionValue(strQ, "viewClassName(...)");
        if (StringsKt.contains$default((CharSequence) strQ, (CharSequence) "androidx.compose", false, 2, (Object) null)) {
            PendoLogger.d("ComposeScreenManager", "setFocusListener -> not be added since this is a compose window");
        } else {
            super.setFocusListener$pendoIO_release(rootViewWeakReference);
        }
    }

    @Override // sdk.pendo.io.x6.e
    public boolean shouldCollectDynamicChanges() {
        Window window;
        if (!super.shouldCollectDynamicChanges()) {
            return false;
        }
        Activity activity = getCurrentActivityRef$pendoIO_release().get();
        return !e1.h((activity == null || (window = activity.getWindow()) == null) ? null : window.getDecorView());
    }

    public /* synthetic */ e(Pendo.PendoOptions pendoOptions, sdk.pendo.io.s7.m mVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(pendoOptions, (i2 & 2) != 0 ? new sdk.pendo.io.s7.k() : mVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final sdk.pendo.io.s7.i c() {
        return (sdk.pendo.io.s7.i) this.composeUtilityHelper.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(e this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PendoLogger.d("ComposeScreenManager", "EVENT -> onGlobalLayoutChange");
        this$0.onGlobalLayoutChangeEvent(sdk.pendo.io.x6.g.ON_GLOBAL_LAYOUT_CHANGED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(e this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isDrawEventsFlowActive) {
            if (this$0.useDebounce.getValue().booleanValue()) {
                this$0.onGlobalLayoutChangeEvent(sdk.pendo.io.x6.g.ON_DRAW);
                return;
            }
            MutableSharedFlow<Unit> mutableSharedFlow = this$0.drawEventsFlow;
            if (mutableSharedFlow != null) {
                mutableSharedFlow.tryEmit(Unit.INSTANCE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object c(Continuation<? super Unit> continuation) {
        q qVar;
        if (continuation instanceof q) {
            qVar = (q) continuation;
            int i2 = qVar.d;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                qVar.d = i2 - Integer.MIN_VALUE;
            } else {
                qVar = new q(continuation);
            }
        } else {
            qVar = new q(continuation);
        }
        Object obj = qVar.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = qVar.d;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            Map<Integer, WeakReference<ViewGroup>> mutableMap = MapsKt.toMutableMap(this.androidComposeViewsOnScreen);
            qVar.a = this;
            qVar.d = 1;
            if (a(mutableMap, qVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this = (e) qVar.a;
            ResultKt.throwOnFailure(obj);
        }
        this.androidComposeViewsOnScreen.clear();
        return Unit.INSTANCE;
    }

    public final void b() {
        boolean z;
        boolean z2;
        Iterator<String> it = this.specialComposeViewElements.iterator();
        while (true) {
            z = true;
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            ArrayList<sdk.pendo.io.x6.h.c> arrayList = getSpecialViewsMap$pendoIO_release().get(next);
            z2 = false;
            sdk.pendo.io.x6.h.c cVar = arrayList != null ? (sdk.pendo.io.x6.h.c) CollectionsKt.getOrNull(arrayList, 0) : null;
            Activity activity = getCurrentActivityRef$pendoIO_release().get();
            if (cVar != null && activity != null && fetchView$pendoIO_release(cVar, activity) != null) {
                int i2 = d.a[this.adaptivePageScanningMode.ordinal()];
                if (i2 == 1) {
                    PendoLogger.d("ComposeScreenManager", "considerSpecialViews -> " + next + " is visible, and AdaptivePageScanning was set to TIME_FIXED, setting fixed scanning time");
                } else {
                    if (i2 != 2) {
                        break;
                    }
                    PendoLogger.d("ComposeScreenManager", "considerSpecialViews -> " + next + " is visible, and AdaptivePageScanning was set to DISABLED, dynamic changes are ignored.");
                    z2 = true;
                    z = false;
                }
                this.isDrawEventsFlowActive = z;
                this.useDebounce.setValue(Boolean.valueOf(z2));
            }
        }
        z2 = true;
        this.isDrawEventsFlowActive = z;
        this.useDebounce.setValue(Boolean.valueOf(z2));
    }

    private final Object a(Map<Integer, WeakReference<ViewGroup>> map, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(getDispatcherProvider().getMain().plus(new CoroutineName("addComposeViewListenersTempCoroutine")), new C0504e(map, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    private final List<View> b(View root) {
        ArrayList arrayList = new ArrayList();
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(root);
        while (!arrayDeque.isEmpty()) {
            View view = (View) arrayDeque.removeLast();
            sdk.pendo.io.s7.i iVarC = c();
            Intrinsics.checkNotNull(view);
            if (iVarC.d(view)) {
                arrayList.add(view);
            } else if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = viewGroup.getChildAt(i2);
                    if (childAt != null) {
                        arrayDeque.add(childAt);
                    }
                }
            }
        }
        return arrayList;
    }

    private final String a(String route, boolean isDrawerOpen, boolean isBottomSheetOpen, e1.a rootViewData) {
        if (isDrawerOpen) {
            return sdk.pendo.io.x6.i.DRAWER_ID;
        }
        if (rootViewData != null && rootViewData.g()) {
            return sdk.pendo.io.x6.i.DIALOG_ID;
        }
        if ((rootViewData != null && rootViewData.f()) || isBottomSheetOpen) {
            return sdk.pendo.io.x6.i.BOTTOM_SHEET_ID;
        }
        if (rootViewData != null && rootViewData.i()) {
            return sdk.pendo.io.x6.i.PANEL_ID;
        }
        if (route != null && route.length() != 0) {
            return route;
        }
        PendoLogger.d("ComposeScreenManager", "calculateScreenIdentifier -> compose active, route is null");
        return "";
    }

    private final Object b(Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(getDispatcherProvider().getMain().plus(new CoroutineName("removeAllViewsInListenersMap")), new p(null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    private final List<View> a() {
        WeakReference<View> weakReference;
        View view;
        Collection<WeakReference<ViewGroup>> collectionValues = this.visibleAndroidComposeViews.values();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = (ViewGroup) ((WeakReference) it.next()).get();
            if (viewGroup != null) {
                arrayList.add(viewGroup);
            }
        }
        if (!arrayList.isEmpty()) {
            return arrayList;
        }
        e1.a currentRootViewData = getCurrentRootViewData();
        return (currentRootViewData == null || (weakReference = currentRootViewData.a) == null || (view = weakReference.get()) == null) ? CollectionsKt.emptyList() : b(view);
    }

    public final void b(boolean z) {
        this.isDrawerOpen = z;
    }

    public final void a(Object state) {
        c cVar;
        Intrinsics.checkNotNullParameter(state, "state");
        Boolean bool = this.isComposeMaterialDrawerStateAvailable;
        Intrinsics.checkNotNull(bool);
        if (bool.booleanValue() && (state instanceof DrawerState)) {
            cVar = new c(true, ((DrawerState) state).isOpen());
        } else {
            Boolean bool2 = this.isComposeMaterial3DrawerStateAvailable;
            Intrinsics.checkNotNull(bool2);
            if (bool2.booleanValue() && (state instanceof androidx.compose.material3.DrawerState)) {
                cVar = new c(true, ((androidx.compose.material3.DrawerState) state).isOpen());
            } else {
                Boolean bool3 = this.isComposeMaterialModalBottomSheetStateAvailable;
                Intrinsics.checkNotNull(bool3);
                if (bool3.booleanValue() && (state instanceof ModalBottomSheetState)) {
                    cVar = new c(false, ((ModalBottomSheetState) state).isVisible());
                } else {
                    Boolean bool4 = this.isComposeMaterial3SheetStateAvailable;
                    Intrinsics.checkNotNull(bool4);
                    cVar = (bool4.booleanValue() && (state instanceof SheetState)) ? new c(false, ((SheetState) state).isVisible()) : null;
                }
            }
        }
        x.a(getSmCoroutineScope(), getScreenManagerMutex(), null, null, new j(state, cVar, null), 6, null);
    }

    @Override // sdk.pendo.io.v6.h
    public void a(List<sdk.pendo.io.v6.a> allElementsList) {
        Intrinsics.checkNotNullParameter(allElementsList, "allElementsList");
        this.allComposeElementsOnScreen.addAll(allElementsList);
    }

    @Override // sdk.pendo.io.v6.h
    public void a(View androidComposeView) {
        Intrinsics.checkNotNullParameter(androidComposeView, "androidComposeView");
        ViewGroup viewGroup = androidComposeView instanceof ViewGroup ? (ViewGroup) androidComposeView : null;
        if (viewGroup == null) {
            return;
        }
        this.androidComposeViewsOnScreen.put(Integer.valueOf(viewGroup.hashCode()), new WeakReference<>(viewGroup));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(Continuation<? super Unit> continuation) {
        o oVar;
        sdk.pendo.io.s7.h hVar;
        e eVar;
        Iterator it;
        if (continuation instanceof o) {
            oVar = (o) continuation;
            int i2 = oVar.f;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                oVar.f = i2 - Integer.MIN_VALUE;
            } else {
                oVar = new o(continuation);
            }
        } else {
            oVar = new o(continuation);
        }
        Object obj = oVar.d;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = oVar.f;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            List<View> listA = a();
            if (listA.isEmpty()) {
                this.lastActiveComposeRouteNav2 = null;
                this.lastActiveComposeRouteNav3 = null;
                this.lastActiveComposeRouteCircuit = null;
                this.lastActiveScreenTags = null;
                return Unit.INSTANCE;
            }
            hVar = new sdk.pendo.io.s7.h(null, null, null, null, 15, null);
            eVar = this;
            it = listA.iterator();
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            it = (Iterator) oVar.c;
            hVar = (sdk.pendo.io.s7.h) oVar.b;
            eVar = (e) oVar.a;
            ResultKt.throwOnFailure(obj);
        }
        while (it.hasNext()) {
            View view = (View) it.next();
            sdk.pendo.io.s7.i iVarC = eVar.c();
            oVar.a = eVar;
            oVar.b = hVar;
            oVar.c = it;
            oVar.f = 1;
            if (iVarC.a(view, hVar, oVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        eVar.lastActiveComposeRouteNav2 = hVar.getNav2Route();
        eVar.lastActiveComposeRouteNav3 = hVar.getNav3Scene();
        eVar.lastActiveComposeRouteCircuit = hVar.getCircuitScreen();
        List<String> listD = hVar.d();
        eVar.lastActiveScreenTags = listD.isEmpty() ? null : listD;
        List<String> list = eVar.lastActiveScreenTags;
        if (list != null && !list.isEmpty()) {
            PendoLogger.d("ComposeScreenManager", "refreshActiveComposeRoutesSnapshot -> screenTags: " + eVar.lastActiveScreenTags);
        }
        return Unit.INSTANCE;
    }

    public final void a(boolean z) {
        this.isBottomSheetOpen = z;
    }

    public final void a(Map<Integer, WeakReference<ViewGroup>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.visibleAndroidComposeViews = map;
    }
}
