package sdk.pendo.io.s7;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.EnterExitState;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutInfo;
import androidx.compose.ui.layout.ModifierInfo;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsOwner;
import androidx.compose.ui.semantics.SemanticsOwnerKt;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.lifecycle.Lifecycle;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation3.runtime.NavEntry;
import androidx.navigation3.scene.Scene;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.slack.circuit.backstack.SaveableBackStack;
import com.slack.circuit.foundation.Circuit;
import com.slack.circuit.runtime.screen.Screen;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Stack;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
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
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.json.JSONArray;
import org.json.JSONException;
import sdk.pendo.io.events.IdentificationData;
import sdk.pendo.io.listeners.views.OnElementInScreenFoundListener;
import sdk.pendo.io.logging.PendoLogger;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010&\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 _2\u00020\u0001:\u0001\u0005B\u001b\u0012\b\b\u0002\u0010I\u001a\u00020\u0014\u0012\b\b\u0002\u0010J\u001a\u00020\u0014¢\u0006\u0004\b]\u0010^J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J0\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0004\b\u0005\u0010\u0013J\u001f\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0016J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0017\u001a\u00020\u0006H\u0007JC\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0080@ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ*\u0010\u0005\u001a\u0004\u0018\u00010 2\u0006\u0010\u0007\u001a\u00020\u00062\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010\"\u001a\u00020\u000eH\u0007J\u0012\u0010%\u001a\u00020\f2\b\u0010$\u001a\u0004\u0018\u00010#H\u0007J\u0017\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u001d\u0010&J\u0018\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010'*\u00020#J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u0005\u0010)J#\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010+\u001a\u00020*H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010,J+\u0010\u0005\u001a\u0004\u0018\u00010\u00012\u0018\u0010/\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030.\u0012\u0006\u0012\u0004\u0018\u00010\u00010-H\u0000¢\u0006\u0004\b\u0005\u00100JC\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u00101\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u001eJ\u001f\u0010\u0005\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u00103\u001a\u000202H\u0000¢\u0006\u0004\b\u0005\u00104J\u0006\u00105\u001a\u00020\fJ\u0018\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020#\u0018\u0001072\u0006\u00106\u001a\u00020\u0018H\u0002JD\u0010\u0005\u001a\u0004\u0018\u00010 2\u0006\u00108\u001a\u00020#2\u0014\u00109\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010'2\n\b\u0002\u0010:\u001a\u0004\u0018\u00010 2\u0006\u0010<\u001a\u00020;2\u0006\u0010=\u001a\u00020\u0012H\u0002JL\u0010\u0005\u001a\u0004\u0018\u00010 *\u00020#2\u0006\u0010=\u001a\u00020\u00122\n\b\u0002\u0010>\u001a\u0004\u0018\u00010 2\b\b\u0002\u0010<\u001a\u00020;2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0010\b\u0002\u0010?\u001a\n\u0012\u0004\u0012\u00020#\u0018\u000107H\u0002J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010>\u001a\u0004\u0018\u00010 H\u0002J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u00108\u001a\u00020#2\u0006\u0010@\u001a\u00020\u000eH\u0002J$\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020#07*\u00020#2\u0010\b\u0002\u0010?\u001a\n\u0012\u0004\u0012\u00020#\u0018\u000107H\u0002J\f\u0010\u0005\u001a\u00020A*\u00020#H\u0002J\u000e\u0010\u0010\u001a\u0004\u0018\u00010B*\u00020#H\u0002J\u000e\u0010\u001d\u001a\u0004\u0018\u00010C*\u00020#H\u0002J\u000e\u0010\u0019\u001a\u0004\u0018\u00010D*\u00020#H\u0002J\u000e\u0010E\u001a\u0004\u0018\u00010\u000e*\u00020#H\u0002J\u0014\u0010\u0005\u001a\u00020\u0004*\u00020#2\u0006\u0010+\u001a\u00020*H\u0002J\f\u0010F\u001a\u00020\f*\u00020#H\u0002R\u001a\u0010I\u001a\u00020\u00148\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010G\u001a\u0004\b(\u0010HR\u001a\u0010J\u001a\u00020\u00148\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001d\u0010G\u001a\u0004\bE\u0010HR\u001d\u0010N\u001a\u0004\u0018\u00010K8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010L\u001a\u0004\b\u0005\u0010MR\u001d\u0010P\u001a\u0004\u0018\u00010K8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010L\u001a\u0004\bO\u0010MR\u001d\u0010Q\u001a\u0004\u0018\u00010K8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u0010L\u001a\u0004\bF\u0010MR\u001d\u0010R\u001a\u0004\u0018\u00010K8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010L\u001a\u0004\b%\u0010MR\u001b\u0010T\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bF\u0010L\u001a\u0004\b\u001d\u0010SR\u001b\u0010U\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010L\u001a\u0004\b\u0010\u0010SR\u001b\u0010V\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bO\u0010L\u001a\u0004\b\u0019\u0010SR\u0018\u0010X\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u0010WR\u0014\u0010\\\u001a\u00020Y8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u0010[\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006`"}, d2 = {"Lsdk/pendo/io/s7/i;", "", "Lsdk/pendo/io/v6/h;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Landroid/view/View;", "view", "Lorg/json/JSONArray;", "tree", "Lsdk/pendo/io/listeners/views/OnElementInScreenFoundListener;", "onViewFoundListener", "", "forCapture", "", "currentScreenId", "d", TypedValues.Custom.S_REFERENCE, "Landroidx/compose/ui/geometry/Rect;", "(Ljava/lang/Object;)Landroidx/compose/ui/geometry/Rect;", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "androidComposeView", "Landroidx/compose/ui/semantics/SemanticsOwner;", "c", "textsWithElementsInfo", "identifiersWithElementsInfo", "includeTexts", "b", "(Landroid/view/View;Lorg/json/JSONArray;Lorg/json/JSONArray;ZZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lsdk/pendo/io/v6/a;", "allElementsList", "destinationName", "Landroidx/compose/ui/semantics/SemanticsNode;", "node", CmcdData.STREAMING_FORMAT_HLS, "(Landroid/view/View;)Landroidx/compose/ui/geometry/Rect;", "", "f", "(Landroid/view/View;)V", "Lsdk/pendo/io/s7/h;", "routeSnapshot", "(Landroid/view/View;Lsdk/pendo/io/s7/h;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "entry", "(Ljava/util/Map$Entry;)Ljava/lang/Object;", "includeText", "Lsdk/pendo/io/s7/e1$a;", "rootViewData", "(Ljava/lang/String;Lsdk/pendo/io/s7/e1$a;)Z", "j", "semanticsOwner", "", "semanticsNode", "interestingSemanticValues", "parent", "", IdentificationData.FIELD_INDEX_IN_PARENT, "rootPositionOnScreen", "composeElementParent", "transientUISemanticNodes", ViewProps.MARGIN, "Lsdk/pendo/io/s7/c0;", "Landroidx/navigation/NavBackStackEntry;", "Landroidx/compose/animation/AnimatedContentScope;", "Lcom/slack/circuit/backstack/SaveableBackStack;", "e", "g", "Lkotlinx/coroutines/CoroutineDispatcher;", "()Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcherMain", "dispatcherIO", "Ljava/lang/reflect/Field;", "Lkotlin/Lazy;", "()Ljava/lang/reflect/Field;", "compositionLocalMapField", "i", "staticValueHolderClassValueField", "dynamicValueHolderClassValueField", "semanticsOwnerField", "()Z", "detectNavBackStackEntry", "detectedNav3", "detectedCircuit", "Lsdk/pendo/io/v6/h;", "composeScanListener", "Lkotlinx/coroutines/sync/Mutex;", "k", "Lkotlinx/coroutines/sync/Mutex;", "mutex", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;)V", CmcdData.STREAM_TYPE_LIVE, "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class i {
    private static volatile boolean m;

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final CoroutineDispatcher dispatcherMain;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final CoroutineDispatcher dispatcherIO;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final Lazy compositionLocalMapField;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final Lazy staticValueHolderClassValueField;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final Lazy dynamicValueHolderClassValueField;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final Lazy semanticsOwnerField;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final Lazy detectNavBackStackEntry;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private final Lazy detectedNav3;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private final Lazy detectedCircuit;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private sdk.pendo.io.v6.h composeScanListener;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private final Mutex mutex;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final HashSet<String> n = SetsKt.hashSetOf("Text", "ContentDescription", "OnClick", "pendoTagKey", "pendoScreenIdModifierKey", "Role", "TestTag", "Selected", "ToggleableState", "EditableText", "IsTraversalGroup", "ScrollBy");

    /* JADX INFO: renamed from: sdk.pendo.io.s7.i$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000bR\u0014\u0010\u0011\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u000bR\u0014\u0010\u0013\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u000bR\u0014\u0010\u0014\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u000bR\u0014\u0010\u0015\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u000b¨\u0006\u0018"}, d2 = {"Lsdk/pendo/io/s7/i$a;", "", "", "detectedUnsupportedComposeVersion", "Z", "getDetectedUnsupportedComposeVersion", "()Z", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Z)V", "", "ANDROID_COMPOSE_VIEW", "Ljava/lang/String;", "COMPOSITION_LOCAL_MAP_FIELD", "DYNAMIC_VALUE_HOLDER_CLASS", "LAYOUT_NODE_CLASS", "SCENE_KEY", "SEMANTICS_OWNER", "STATE_FIELD", "STATIC_VALUE_HOLDER_CLASS", "TAG", "VALUE_FIELD", "WARNING_MESSAGE_UNSUPPORTED_COMPOSE_VERSION", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(boolean z) {
            i.m = z;
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[sdk.pendo.io.s7.g.values().length];
            try {
                iArr[sdk.pendo.io.s7.g.NAV2.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[sdk.pendo.io.s7.g.NAV3.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[sdk.pendo.io.s7.g.CIRCUIT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sdk.pendo.io.utilities.ComposeUtilityHelper", f = "ComposeUtilityHelper.kt", i = {0, 0, 0, 1, 1, 1}, l = {943, 303}, m = "checkForGuidePositionChange", n = {"this", "dispatcher", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "current", FirebaseAnalytics.Param.LOCATION}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
    static final class c extends ContinuationImpl {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int f;

        c(Continuation<? super c> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return i.this.a((CoroutineDispatcher) null, this);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.utilities.ComposeUtilityHelper$checkForGuidePositionChange$2$1$1", f = "ComposeUtilityHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ Ref.ObjectRef<Rect> b;
        final /* synthetic */ i c;
        final /* synthetic */ i0 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Ref.ObjectRef<Rect> objectRef, i iVar, i0 i0Var, Continuation<? super d> continuation) {
            super(2, continuation);
            this.b = objectRef;
            this.c = iVar;
            this.d = i0Var;
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

        /* JADX WARN: Type inference failed for: r1v4, types: [T, androidx.compose.ui.geometry.Rect] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.b.element = this.c.a(this.d.getReference());
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.utilities.ComposeUtilityHelper$collectActiveRoutesFromComposeView$2", f = "ComposeUtilityHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class e extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ View c;
        final /* synthetic */ sdk.pendo.io.s7.h d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(View view, sdk.pendo.io.s7.h hVar, Continuation<? super e> continuation) {
            super(2, continuation);
            this.c = view;
            this.d = hVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((e) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return i.this.new e(this.c, this.d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            SemanticsOwner semanticsOwnerC;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (i.this.d(this.c) && (semanticsOwnerC = i.this.c(this.c)) != null) {
                i.this.a(semanticsOwnerC.getRootSemanticsNode(), this.d);
                return Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ljava/lang/reflect/Field;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "()Ljava/lang/reflect/Field;"}, k = 3, mv = {1, 9, 0})
    static final class f extends Lambda implements Function0<Field> {
        public static final f a = new f();

        f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Field invoke() {
            try {
                Field declaredField = Class.forName("androidx.compose.ui.node.LayoutNode").getDeclaredField("compositionLocalMap");
                declaredField.setAccessible(true);
                return declaredField;
            } catch (ClassNotFoundException unused) {
                PendoLogger.w("ComposeUtilityHelper", "Pendo failed to scan the compose elements in your application. For Apps using Jetpack Compose the Pendo SDK requires androidx.compose.ui:ui version 1.5.0 or above. Please update this dependency in your build.gradle file. For more information about the SDK requirements see: https://github.com/pendo-io/pendo-mobile-sdk/blob/master/android/pnddocs/native-android.md");
                i.INSTANCE.a(true);
                return null;
            } catch (NoSuchFieldException unused2) {
                PendoLogger.w("ComposeUtilityHelper", "Pendo failed to scan the compose elements in your application. For Apps using Jetpack Compose the Pendo SDK requires androidx.compose.ui:ui version 1.5.0 or above. Please update this dependency in your build.gradle file. For more information about the SDK requirements see: https://github.com/pendo-io/pendo-mobile-sdk/blob/master/android/pnddocs/native-android.md");
                i.INSTANCE.a(true);
                return null;
            }
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sdk.pendo.io.utilities.ComposeUtilityHelper", f = "ComposeUtilityHelper.kt", i = {0, 0, 0, 0, 0, 0}, l = {351}, m = "createComposeTextsTagRetroElementIdentifier$pendoIO_release", n = {"this", "textsWithElementsInfo", "identifiersWithElementsInfo", "allElementsList", "includeTexts", "forCapture"}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "Z$1"})
    static final class g extends ContinuationImpl {
        Object a;
        Object b;
        Object c;
        Object d;
        boolean e;
        boolean f;
        /* synthetic */ Object g;
        int i;

        g(Continuation<? super g> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.g = obj;
            this.i |= Integer.MIN_VALUE;
            return i.this.b(null, null, null, false, false, null, this);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lsdk/pendo/io/v6/a;", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.utilities.ComposeUtilityHelper$createComposeTextsTagRetroElementIdentifier$composeElementRoot$1", f = "ComposeUtilityHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class h extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super sdk.pendo.io.v6.a>, Object> {
        int a;
        final /* synthetic */ View c;
        final /* synthetic */ List<sdk.pendo.io.v6.a> d;
        final /* synthetic */ String e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(View view, List<sdk.pendo.io.v6.a> list, String str, Continuation<? super h> continuation) {
            super(2, continuation);
            this.c = view;
            this.d = list;
            this.e = str;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super sdk.pendo.io.v6.a> continuation) {
            return ((h) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return i.this.new h(this.c, this.d, this.e, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return i.this.a(this.c, this.d, this.e);
        }
    }

    /* JADX INFO: renamed from: sdk.pendo.io.s7.i$i, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.utilities.ComposeUtilityHelper$createJsonFromViewAndScan$1", f = "ComposeUtilityHelper.kt", i = {}, l = {257}, m = "invokeSuspend", n = {}, s = {})
    static final class C0480i extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ JSONArray c;
        final /* synthetic */ OnElementInScreenFoundListener d;
        final /* synthetic */ boolean e;
        final /* synthetic */ View f;
        final /* synthetic */ String g;

        /* JADX INFO: renamed from: sdk.pendo.io.s7.i$i$a */
        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
        @DebugMetadata(c = "sdk.pendo.io.utilities.ComposeUtilityHelper$createJsonFromViewAndScan$1$job$1", f = "ComposeUtilityHelper.kt", i = {}, l = {246}, m = "invokeSuspend", n = {}, s = {})
        static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int a;
            final /* synthetic */ i b;
            final /* synthetic */ JSONArray c;
            final /* synthetic */ OnElementInScreenFoundListener d;
            final /* synthetic */ boolean e;
            final /* synthetic */ View f;
            final /* synthetic */ String g;

            /* JADX INFO: renamed from: sdk.pendo.io.s7.i$i$a$a, reason: collision with other inner class name */
            @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lsdk/pendo/io/v6/a;", "<anonymous>"}, k = 3, mv = {1, 9, 0})
            @DebugMetadata(c = "sdk.pendo.io.utilities.ComposeUtilityHelper$createJsonFromViewAndScan$1$job$1$composeElementRoot$1", f = "ComposeUtilityHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            static final class C0481a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super sdk.pendo.io.v6.a>, Object> {
                int a;
                final /* synthetic */ i b;
                final /* synthetic */ View c;
                final /* synthetic */ String d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0481a(i iVar, View view, String str, Continuation<? super C0481a> continuation) {
                    super(2, continuation);
                    this.b = iVar;
                    this.c = view;
                    this.d = str;
                }

                @Override // kotlin.jvm.functions.Function2
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super sdk.pendo.io.v6.a> continuation) {
                    return ((C0481a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C0481a(this.b, this.c, this.d, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.a != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return i.a(this.b, this.c, (List) null, this.d, 2, (Object) null);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(i iVar, JSONArray jSONArray, OnElementInScreenFoundListener onElementInScreenFoundListener, boolean z, View view, String str, Continuation<? super a> continuation) {
                super(2, continuation);
                this.b = iVar;
                this.c = jSONArray;
                this.d = onElementInScreenFoundListener;
                this.e = z;
                this.f = view;
                this.g = str;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(this.b, this.c, this.d, this.e, this.f, this.g, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws JSONException {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineDispatcher dispatcherMain = this.b.getDispatcherMain();
                    C0481a c0481a = new C0481a(this.b, this.f, this.g, null);
                    this.a = 1;
                    obj = BuildersKt.withContext(dispatcherMain, c0481a, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                sdk.pendo.io.v6.a aVar = (sdk.pendo.io.v6.a) obj;
                if (aVar != null) {
                    sdk.pendo.io.v6.b.a(aVar, this.c, this.d, this.e, false, 8, null);
                }
                if (this.e) {
                    this.b.a(aVar);
                }
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0480i(JSONArray jSONArray, OnElementInScreenFoundListener onElementInScreenFoundListener, boolean z, View view, String str, Continuation<? super C0480i> continuation) {
            super(2, continuation);
            this.c = jSONArray;
            this.d = onElementInScreenFoundListener;
            this.e = z;
            this.f = view;
            this.g = str;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C0480i) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return i.this.new C0480i(this.c, this.d, this.e, this.f, this.g, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Job jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(i.this.getDispatcherIO()), null, null, new a(i.this, this.c, this.d, this.e, this.f, this.g, null), 3, null);
                this.a = 1;
                if (jobLaunch$default.join(this) == coroutine_suspended) {
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

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0})
    static final class j extends Lambda implements Function0<Boolean> {
        public static final j a = new j();

        j() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            boolean z;
            try {
                PendoLogger.d("ComposeUtilityHelper", "Compose Navigation 2 found! " + NavBackStackEntry.class.getName());
                z = true;
            } catch (NoClassDefFoundError unused) {
                PendoLogger.w("ComposeUtilityHelper", "Compose Navigation 2 not found!");
                z = false;
            }
            return Boolean.valueOf(z);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0})
    static final class k extends Lambda implements Function0<Boolean> {
        public static final k a = new k();

        k() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            boolean z;
            try {
                PendoLogger.d("ComposeUtilityHelper", "Circuit found! " + Circuit.class.getName());
                z = true;
            } catch (NoClassDefFoundError unused) {
                PendoLogger.w("ComposeUtilityHelper", "Circuit not found!");
                z = false;
            }
            return Boolean.valueOf(z);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0})
    static final class l extends Lambda implements Function0<Boolean> {
        public static final l a = new l();

        l() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            boolean z;
            try {
                PendoLogger.d("ComposeUtilityHelper", "Compose Navigation 3 found! " + Scene.class.getName());
                z = true;
            } catch (NoClassDefFoundError unused) {
                PendoLogger.w("ComposeUtilityHelper", "Compose Navigation 3 not found!");
                z = false;
            }
            return Boolean.valueOf(z);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ljava/lang/reflect/Field;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "()Ljava/lang/reflect/Field;"}, k = 3, mv = {1, 9, 0})
    static final class m extends Lambda implements Function0<Field> {
        public static final m a = new m();

        m() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Field invoke() {
            try {
                Field declaredField = Class.forName("androidx.compose.runtime.DynamicValueHolder").getDeclaredField("state");
                declaredField.setAccessible(true);
                return declaredField;
            } catch (ClassNotFoundException unused) {
                PendoLogger.w("ComposeUtilityHelper", "Pendo failed to scan the compose elements in your application. For Apps using Jetpack Compose the Pendo SDK requires androidx.compose.ui:ui version 1.5.0 or above. Please update this dependency in your build.gradle file. For more information about the SDK requirements see: https://github.com/pendo-io/pendo-mobile-sdk/blob/master/android/pnddocs/native-android.md");
                return null;
            } catch (NoSuchFieldException unused2) {
                PendoLogger.w("ComposeUtilityHelper", "Pendo failed to scan the compose elements in your application. For Apps using Jetpack Compose the Pendo SDK requires androidx.compose.ui:ui version 1.5.0 or above. Please update this dependency in your build.gradle file. For more information about the SDK requirements see: https://github.com/pendo-io/pendo-mobile-sdk/blob/master/android/pnddocs/native-android.md");
                return null;
            }
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ljava/lang/reflect/Field;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "()Ljava/lang/reflect/Field;"}, k = 3, mv = {1, 9, 0})
    static final class n extends Lambda implements Function0<Field> {
        public static final n a = new n();

        n() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Field invoke() {
            try {
                Field declaredField = Class.forName("androidx.compose.ui.platform.AndroidComposeView").getDeclaredField("semanticsOwner");
                declaredField.setAccessible(true);
                return declaredField;
            } catch (ClassNotFoundException unused) {
                PendoLogger.w("ComposeUtilityHelper", "Pendo failed to scan the compose elements in your application. For Apps using Jetpack Compose the Pendo SDK requires androidx.compose.ui:ui version 1.5.0 or above. Please update this dependency in your build.gradle file. For more information about the SDK requirements see: https://github.com/pendo-io/pendo-mobile-sdk/blob/master/android/pnddocs/native-android.md");
                i.INSTANCE.a(true);
                return null;
            } catch (NoSuchFieldException unused2) {
                PendoLogger.w("ComposeUtilityHelper", "Pendo failed to scan the compose elements in your application. For Apps using Jetpack Compose the Pendo SDK requires androidx.compose.ui:ui version 1.5.0 or above. Please update this dependency in your build.gradle file. For more information about the SDK requirements see: https://github.com/pendo-io/pendo-mobile-sdk/blob/master/android/pnddocs/native-android.md");
                i.INSTANCE.a(true);
                return null;
            }
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ljava/lang/reflect/Field;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "()Ljava/lang/reflect/Field;"}, k = 3, mv = {1, 9, 0})
    static final class o extends Lambda implements Function0<Field> {
        public static final o a = new o();

        o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Field invoke() {
            try {
                Field declaredField = Class.forName("androidx.compose.runtime.StaticValueHolder").getDeclaredField("value");
                declaredField.setAccessible(true);
                return declaredField;
            } catch (ClassNotFoundException unused) {
                PendoLogger.w("ComposeUtilityHelper", "Pendo failed to scan the compose elements in your application. For Apps using Jetpack Compose the Pendo SDK requires androidx.compose.ui:ui version 1.5.0 or above. Please update this dependency in your build.gradle file. For more information about the SDK requirements see: https://github.com/pendo-io/pendo-mobile-sdk/blob/master/android/pnddocs/native-android.md");
                i.INSTANCE.a(true);
                return null;
            } catch (NoSuchFieldException unused2) {
                PendoLogger.w("ComposeUtilityHelper", "Pendo failed to scan the compose elements in your application. For Apps using Jetpack Compose the Pendo SDK requires androidx.compose.ui:ui version 1.5.0 or above. Please update this dependency in your build.gradle file. For more information about the SDK requirements see: https://github.com/pendo-io/pendo-mobile-sdk/blob/master/android/pnddocs/native-android.md");
                i.INSTANCE.a(true);
                return null;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    private final SaveableBackStack c(SemanticsNode semanticsNode) {
        try {
            LayoutInfo layoutInfo = semanticsNode.getLayoutInfo();
            Field fieldA = a();
            if (fieldA == null) {
                return null;
            }
            Object obj = fieldA.get(layoutInfo);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.Any, kotlin.Any>");
            Map map = (Map) obj;
            Field fieldG = g();
            if (fieldG == null) {
                return null;
            }
            Iterator it = map.values().iterator();
            while (it.hasNext()) {
                try {
                    Object obj2 = fieldG.get(it.next());
                    if (obj2 != null) {
                        Intrinsics.checkNotNull(obj2);
                        if ((obj2 instanceof MutableState) && (((MutableState) obj2).getValue() instanceof SaveableBackStack)) {
                            Object value = ((MutableState) obj2).getValue();
                            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type com.slack.circuit.backstack.SaveableBackStack");
                            return (SaveableBackStack) value;
                        }
                    }
                } catch (Exception unused) {
                }
            }
        } catch (Exception e2) {
            PendoLogger.e("ComposeUtilityHelper", "The Pendo SDK failed to extract Circuit navigation state", e2);
        }
        return null;
    }

    private final NavBackStackEntry d(SemanticsNode semanticsNode) {
        try {
            LayoutInfo layoutInfo = semanticsNode.getLayoutInfo();
            Field fieldA = a();
            if (fieldA == null) {
                return null;
            }
            Object obj = fieldA.get(layoutInfo);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.Any, kotlin.Any>");
            Map map = (Map) obj;
            Field fieldI = i();
            if (fieldI == null) {
                return null;
            }
            Iterator it = map.values().iterator();
            while (it.hasNext()) {
                try {
                    Object obj2 = fieldI.get(it.next());
                    if (obj2 != null) {
                        Intrinsics.checkNotNull(obj2);
                        if (obj2 instanceof NavBackStackEntry) {
                            return (NavBackStackEntry) obj2;
                        }
                        continue;
                    }
                } catch (Exception unused) {
                }
            }
        } catch (Exception e2) {
            PendoLogger.e("ComposeUtilityHelper", "The Pendo SDK failed to extract compose navigation state", e2);
        }
        return null;
    }

    private final String e(SemanticsNode semanticsNode) {
        try {
            for (Map.Entry<? extends SemanticsPropertyKey<?>, ? extends Object> entry : semanticsNode.getConfig()) {
                if (Intrinsics.areEqual(entry.getKey().getName(), "pendoScreenIdModifierKey")) {
                    Object value = entry.getValue();
                    if (value instanceof String) {
                        return (String) value;
                    }
                    return null;
                }
            }
        } catch (Exception e2) {
            PendoLogger.d("ComposeUtilityHelper", "extractPendoScreenTag failed: " + e2.getMessage());
        }
        return null;
    }

    private final Field g() {
        return (Field) this.dynamicValueHolderClassValueField.getValue();
    }

    private final Field h() {
        return (Field) this.semanticsOwnerField.getValue();
    }

    private final Field i() {
        return (Field) this.staticValueHolderClassValueField.getValue();
    }

    public final Rect b(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        android.graphics.Rect rectG = e1.g(view.getRootView());
        return new Rect(rectG.left, rectG.top, rectG.right, rectG.bottom);
    }

    public final Map<String, Object> f(SemanticsNode semanticsNode) {
        Intrinsics.checkNotNullParameter(semanticsNode, "<this>");
        try {
            a0.a();
            SemanticsConfiguration config = semanticsNode.getConfig();
            ArrayList<Map.Entry<? extends SemanticsPropertyKey<?>, ? extends Object>> arrayList = new ArrayList();
            for (Map.Entry<? extends SemanticsPropertyKey<?>, ? extends Object> entry : config) {
                if (n.contains(entry.getKey().getName())) {
                    arrayList.add(entry);
                }
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList, 10)), 16));
            for (Map.Entry<? extends SemanticsPropertyKey<?>, ? extends Object> entry2 : arrayList) {
                Pair pair = new Pair(entry2.getKey().getName(), a(entry2));
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
            return linkedHashMap;
        } catch (Exception e2) {
            PendoLogger.e("ComposeUtilityHelper filterInterestingNodes, Exception retrieving texts " + e2 + ", " + e2.getMessage(), new Object[0]);
            return new HashMap();
        }
    }

    public final boolean j() {
        try {
            Log.d("ComposeUtilityHelper", "Jetpack Compose found! " + ComposeView.class.getName());
            return true;
        } catch (NoClassDefFoundError unused) {
            Log.d("ComposeUtilityHelper", "Jetpack Compose not found!");
            return false;
        }
    }

    public i(CoroutineDispatcher dispatcherMain, CoroutineDispatcher dispatcherIO) {
        Intrinsics.checkNotNullParameter(dispatcherMain, "dispatcherMain");
        Intrinsics.checkNotNullParameter(dispatcherIO, "dispatcherIO");
        this.dispatcherMain = dispatcherMain;
        this.dispatcherIO = dispatcherIO;
        this.compositionLocalMapField = LazyKt.lazy(f.a);
        this.staticValueHolderClassValueField = LazyKt.lazy(o.a);
        this.dynamicValueHolderClassValueField = LazyKt.lazy(m.a);
        this.semanticsOwnerField = LazyKt.lazy(n.a);
        this.detectNavBackStackEntry = LazyKt.lazy(j.a);
        this.detectedNav3 = LazyKt.lazy(l.a);
        this.detectedCircuit = LazyKt.lazy(k.a);
        this.mutex = MutexKt.Mutex$default(false, 1, null);
    }

    private final boolean c() {
        return ((Boolean) this.detectedCircuit.getValue()).booleanValue();
    }

    private final boolean d() {
        return ((Boolean) this.detectedNav3.getValue()).booleanValue();
    }

    private final boolean g(SemanticsNode semanticsNode) {
        Rect boundsInWindow = semanticsNode.getBoundsInWindow();
        return ((int) (boundsInWindow.getRight() - boundsInWindow.getLeft())) != 0 && ((int) (boundsInWindow.getBottom() - boundsInWindow.getTop())) != 0 && boundsInWindow.getRight() > 0.0f && boundsInWindow.getBottom() > 0.0f && semanticsNode.getLayoutInfo().isPlaced();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    public final Object b(View view, JSONArray jSONArray, JSONArray jSONArray2, boolean z, boolean z2, String str, Continuation<? super Unit> continuation) {
        g gVar;
        List<sdk.pendo.io.v6.a> arrayList;
        boolean z3;
        i iVar;
        JSONArray jSONArray3;
        JSONArray jSONArray4;
        boolean z4;
        if (continuation instanceof g) {
            gVar = (g) continuation;
            int i = gVar.i;
            if ((i & Integer.MIN_VALUE) != 0) {
                gVar.i = i - Integer.MIN_VALUE;
            } else {
                gVar = new g(continuation);
            }
        } else {
            gVar = new g(continuation);
        }
        g gVar2 = gVar;
        Object objWithContext = gVar2.g;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = gVar2.i;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objWithContext);
            arrayList = new ArrayList<>();
            CoroutineDispatcher coroutineDispatcher = this.dispatcherMain;
            h hVar = new h(view, arrayList, str, null);
            gVar2.a = this;
            gVar2.b = jSONArray;
            gVar2.c = jSONArray2;
            gVar2.d = arrayList;
            gVar2.e = z;
            z3 = z2;
            gVar2.f = z3;
            gVar2.i = 1;
            objWithContext = BuildersKt.withContext(coroutineDispatcher, hVar, gVar2);
            if (objWithContext == coroutine_suspended) {
                return coroutine_suspended;
            }
            iVar = this;
            jSONArray3 = jSONArray;
            jSONArray4 = jSONArray2;
            z4 = z;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            boolean z5 = gVar2.f;
            boolean z6 = gVar2.e;
            arrayList = (List) gVar2.d;
            jSONArray4 = (JSONArray) gVar2.c;
            JSONArray jSONArray5 = (JSONArray) gVar2.b;
            i iVar2 = (i) gVar2.a;
            ResultKt.throwOnFailure(objWithContext);
            z4 = z6;
            jSONArray3 = jSONArray5;
            z3 = z5;
            iVar = iVar2;
        }
        sdk.pendo.io.v6.a aVar = (sdk.pendo.io.v6.a) objWithContext;
        sdk.pendo.io.v6.h hVar2 = iVar.composeScanListener;
        if (hVar2 != null) {
            hVar2.a(arrayList);
        }
        if (aVar != null) {
            sdk.pendo.io.v6.b.a(aVar, jSONArray3, jSONArray4, z4, z3);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final CoroutineDispatcher getDispatcherIO() {
        return this.dispatcherIO;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final CoroutineDispatcher getDispatcherMain() {
        return this.dispatcherMain;
    }

    public final boolean h(SemanticsNode node) {
        if (node == null) {
            return false;
        }
        try {
            Iterator<Map.Entry<? extends SemanticsPropertyKey<?>, ? extends Object>> it = node.getConfig().iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(it.next().getKey().getName(), "pendoStateModifierKey")) {
                    return true;
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        } catch (Exception unused) {
            return false;
        }
    }

    public /* synthetic */ i(CoroutineDispatcher coroutineDispatcher, CoroutineDispatcher coroutineDispatcher2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Dispatchers.getMain() : coroutineDispatcher, (i & 2) != 0 ? Dispatchers.getIO() : coroutineDispatcher2);
    }

    private final AnimatedContentScope b(SemanticsNode semanticsNode) {
        try {
            LayoutInfo layoutInfo = semanticsNode.getLayoutInfo();
            Field fieldA = a();
            if (fieldA == null) {
                return null;
            }
            Object obj = fieldA.get(layoutInfo);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.Any, kotlin.Any>");
            Map map = (Map) obj;
            Field fieldG = g();
            if (fieldG == null) {
                return null;
            }
            Iterator it = map.values().iterator();
            while (it.hasNext()) {
                try {
                    Object obj2 = fieldG.get(it.next());
                    if (obj2 != null) {
                        Intrinsics.checkNotNull(obj2);
                        if ((obj2 instanceof MutableState) && (((MutableState) obj2).getValue() instanceof AnimatedContentScope)) {
                            Object value = ((MutableState) obj2).getValue();
                            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.animation.AnimatedContentScope");
                            return (AnimatedContentScope) value;
                        }
                    }
                } catch (Exception unused) {
                }
            }
        } catch (Exception e2) {
            PendoLogger.e("ComposeUtilityHelper", "The Pendo SDK failed to extract compose navigation state", e2);
        }
        return null;
    }

    public final SemanticsOwner c(View androidComposeView) {
        Intrinsics.checkNotNullParameter(androidComposeView, "androidComposeView");
        try {
            Field fieldH = h();
            if (fieldH == null) {
                return null;
            }
            Object obj = fieldH.get(androidComposeView);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.ui.semantics.SemanticsOwner");
            return (SemanticsOwner) obj;
        } catch (Exception e2) {
            PendoLogger.d("ComposeUtilityHelper", "getSemanticsNode failed to get semantics node for view " + androidComposeView + ", error: " + e2);
            return null;
        }
    }

    public final boolean d(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        try {
            return Intrinsics.areEqual(view.getClass().getName(), "androidx.compose.ui.platform.AndroidComposeView");
        } catch (Exception unused) {
            PendoLogger.d("ComposeUtilityHelper", "isViewAndroidComposeView failed to get class name for view " + view);
            return false;
        }
    }

    private final boolean b() {
        return ((Boolean) this.detectNavBackStackEntry.getValue()).booleanValue();
    }

    public final void a(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        sdk.pendo.io.v6.h hVar = this.composeScanListener;
        if (hVar != null) {
            hVar.a(view);
        }
    }

    public final Object a(View view, JSONArray jSONArray, JSONArray jSONArray2, boolean z, boolean z2, String str, Continuation<? super Unit> continuation) {
        a(view);
        Object objB = b(view, jSONArray, jSONArray2, z, z2, str, continuation);
        return objB == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objB : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00a9 A[Catch: all -> 0x003e, TryCatch #1 {all -> 0x003e, blocks: (B:13:0x0039, B:34:0x00a3, B:36:0x00a9, B:38:0x00b3, B:41:0x00bf, B:43:0x00c5, B:45:0x00cf, B:47:0x00d9, B:58:0x014a, B:48:0x00e3, B:50:0x00f1, B:52:0x00fb, B:54:0x0101, B:56:0x010b), top: B:68:0x0039 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:41:0x00bf A[Catch: all -> 0x003e, TRY_ENTER, TryCatch #1 {all -> 0x003e, blocks: (B:13:0x0039, B:34:0x00a3, B:36:0x00a9, B:38:0x00b3, B:41:0x00bf, B:43:0x00c5, B:45:0x00cf, B:47:0x00d9, B:58:0x014a, B:48:0x00e3, B:50:0x00f1, B:52:0x00fb, B:54:0x0101, B:56:0x010b), top: B:68:0x0039 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00c5 A[Catch: all -> 0x003e, TryCatch #1 {all -> 0x003e, blocks: (B:13:0x0039, B:34:0x00a3, B:36:0x00a9, B:38:0x00b3, B:41:0x00bf, B:43:0x00c5, B:45:0x00cf, B:47:0x00d9, B:58:0x014a, B:48:0x00e3, B:50:0x00f1, B:52:0x00fb, B:54:0x0101, B:56:0x010b), top: B:68:0x0039 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:47:0x00d9 A[Catch: all -> 0x003e, TryCatch #1 {all -> 0x003e, blocks: (B:13:0x0039, B:34:0x00a3, B:36:0x00a9, B:38:0x00b3, B:41:0x00bf, B:43:0x00c5, B:45:0x00cf, B:47:0x00d9, B:58:0x014a, B:48:0x00e3, B:50:0x00f1, B:52:0x00fb, B:54:0x0101, B:56:0x010b), top: B:68:0x0039 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x00e3 A[Catch: all -> 0x003e, TryCatch #1 {all -> 0x003e, blocks: (B:13:0x0039, B:34:0x00a3, B:36:0x00a9, B:38:0x00b3, B:41:0x00bf, B:43:0x00c5, B:45:0x00cf, B:47:0x00d9, B:58:0x014a, B:48:0x00e3, B:50:0x00f1, B:52:0x00fb, B:54:0x0101, B:56:0x010b), top: B:68:0x0039 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x00f1 A[Catch: all -> 0x003e, TryCatch #1 {all -> 0x003e, blocks: (B:13:0x0039, B:34:0x00a3, B:36:0x00a9, B:38:0x00b3, B:41:0x00bf, B:43:0x00c5, B:45:0x00cf, B:47:0x00d9, B:58:0x014a, B:48:0x00e3, B:50:0x00f1, B:52:0x00fb, B:54:0x0101, B:56:0x010b), top: B:68:0x0039 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:54:0x0101 A[Catch: all -> 0x003e, TryCatch #1 {all -> 0x003e, blocks: (B:13:0x0039, B:34:0x00a3, B:36:0x00a9, B:38:0x00b3, B:41:0x00bf, B:43:0x00c5, B:45:0x00cf, B:47:0x00d9, B:58:0x014a, B:48:0x00e3, B:50:0x00f1, B:52:0x00fb, B:54:0x0101, B:56:0x010b), top: B:68:0x0039 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x010a  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Multi-variable type inference failed */
    public final Object a(CoroutineDispatcher coroutineDispatcher, Continuation<? super Unit> continuation) throws Throwable {
        c cVar;
        Mutex mutex;
        Mutex mutex2;
        i0 i0Var;
        Ref.ObjectRef objectRef;
        Rect rect;
        Float fBoxFloat;
        Rect rect2;
        Float fBoxFloat2;
        Rect rect3;
        Float fBoxFloat3;
        Rect rect4;
        Float fBoxFloat4;
        if (continuation instanceof c) {
            cVar = (c) continuation;
            int i = cVar.f;
            if ((i & Integer.MIN_VALUE) != 0) {
                cVar.f = i - Integer.MIN_VALUE;
            } else {
                cVar = new c(continuation);
            }
        } else {
            cVar = new c(continuation);
        }
        Object obj = cVar.d;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = cVar.f;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                mutex = this.mutex;
                cVar.a = this;
                cVar.b = coroutineDispatcher;
                cVar.c = mutex;
                cVar.f = 1;
                if (mutex.lock(null, cVar) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                objectRef = (Ref.ObjectRef) cVar.c;
                i0Var = (i0) cVar.b;
                mutex2 = (Mutex) cVar.a;
                try {
                    ResultKt.throwOnFailure(obj);
                    rect = (Rect) objectRef.element;
                    if (rect != null) {
                        fBoxFloat = Boxing.boxFloat(rect.getLeft());
                    } else {
                        fBoxFloat = null;
                    }
                    if (Intrinsics.areEqual(fBoxFloat, i0Var.getX())) {
                        rect4 = (Rect) objectRef.element;
                        if (rect4 != null) {
                            fBoxFloat4 = Boxing.boxFloat(rect4.getTop());
                        } else {
                            fBoxFloat4 = null;
                        }
                        if (Intrinsics.areEqual(fBoxFloat4, i0Var.getY())) {
                            PendoLogger.d("ComposeUtilityHelper", "checkForGuidePositionChange anchorView did not move");
                        } else {
                            float x = i0Var.getX();
                            float y = i0Var.getY();
                            rect2 = (Rect) objectRef.element;
                            if (rect2 != null) {
                                fBoxFloat2 = Boxing.boxFloat(rect2.getLeft());
                            } else {
                                fBoxFloat2 = null;
                            }
                            rect3 = (Rect) objectRef.element;
                            if (rect3 != null) {
                                fBoxFloat3 = Boxing.boxFloat(rect3.getTop());
                            } else {
                                fBoxFloat3 = null;
                            }
                            PendoLogger.d("ComposeUtilityHelper", "checkForGuidePositionChange anchorView did move, updating guide... current location- " + x + ", " + y + " new location - " + fBoxFloat2 + ", " + fBoxFloat3 + " ");
                            sdk.pendo.io.s7.e.INSTANCE.a().b();
                        }
                    } else {
                        float x2 = i0Var.getX();
                        float y2 = i0Var.getY();
                        rect2 = (Rect) objectRef.element;
                        if (rect2 != null) {
                            fBoxFloat2 = Boxing.boxFloat(rect2.getLeft());
                        } else {
                            fBoxFloat2 = null;
                        }
                        rect3 = (Rect) objectRef.element;
                        if (rect3 != null) {
                            fBoxFloat3 = Boxing.boxFloat(rect3.getTop());
                        } else {
                            fBoxFloat3 = null;
                        }
                        PendoLogger.d("ComposeUtilityHelper", "checkForGuidePositionChange anchorView did move, updating guide... current location- " + x2 + ", " + y2 + " new location - " + fBoxFloat2 + ", " + fBoxFloat3 + " ");
                        sdk.pendo.io.s7.e.INSTANCE.a().b();
                    }
                    Unit unit = Unit.INSTANCE;
                    mutex = mutex2;
                    mutex.unlock(null);
                    return Unit.INSTANCE;
                } catch (Throwable th) {
                    th = th;
                    mutex2.unlock(null);
                    throw th;
                }
            }
            Mutex mutex3 = (Mutex) cVar.c;
            coroutineDispatcher = (CoroutineDispatcher) cVar.b;
            i iVar = (i) cVar.a;
            ResultKt.throwOnFailure(obj);
            mutex = mutex3;
            this = iVar;
            WeakReference<i0> weakReferenceC = sdk.pendo.io.s7.e.INSTANCE.a().c();
            i0 i0Var2 = weakReferenceC != null ? weakReferenceC.get() : null;
            if (i0Var2 != null) {
                Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                if (coroutineDispatcher != null) {
                    d dVar = new d(objectRef2, this, i0Var2, null);
                    cVar.a = mutex;
                    cVar.b = i0Var2;
                    cVar.c = objectRef2;
                    cVar.f = 2;
                    if (BuildersKt.withContext(coroutineDispatcher, dVar, cVar) != coroutine_suspended) {
                        mutex2 = mutex;
                        i0Var = i0Var2;
                        objectRef = objectRef2;
                        rect = (Rect) objectRef.element;
                        if (rect != null) {
                            fBoxFloat = Boxing.boxFloat(rect.getLeft());
                        } else {
                            fBoxFloat = null;
                        }
                        if (Intrinsics.areEqual(fBoxFloat, i0Var.getX())) {
                            float x3 = i0Var.getX();
                            float y3 = i0Var.getY();
                            rect2 = (Rect) objectRef.element;
                            if (rect2 != null) {
                                fBoxFloat2 = Boxing.boxFloat(rect2.getLeft());
                            } else {
                                fBoxFloat2 = null;
                            }
                            rect3 = (Rect) objectRef.element;
                            if (rect3 != null) {
                                fBoxFloat3 = Boxing.boxFloat(rect3.getTop());
                            } else {
                                fBoxFloat3 = null;
                            }
                            PendoLogger.d("ComposeUtilityHelper", "checkForGuidePositionChange anchorView did move, updating guide... current location- " + x3 + ", " + y3 + " new location - " + fBoxFloat2 + ", " + fBoxFloat3 + " ");
                            sdk.pendo.io.s7.e.INSTANCE.a().b();
                        } else {
                            rect4 = (Rect) objectRef.element;
                            if (rect4 != null) {
                                fBoxFloat4 = Boxing.boxFloat(rect4.getTop());
                            } else {
                                fBoxFloat4 = null;
                            }
                            if (Intrinsics.areEqual(fBoxFloat4, i0Var.getY())) {
                                PendoLogger.d("ComposeUtilityHelper", "checkForGuidePositionChange anchorView did not move");
                            } else {
                                float x4 = i0Var.getX();
                                float y4 = i0Var.getY();
                                rect2 = (Rect) objectRef.element;
                                if (rect2 != null) {
                                    fBoxFloat2 = Boxing.boxFloat(rect2.getLeft());
                                } else {
                                    fBoxFloat2 = null;
                                }
                                rect3 = (Rect) objectRef.element;
                                if (rect3 != null) {
                                    fBoxFloat3 = Boxing.boxFloat(rect3.getTop());
                                } else {
                                    fBoxFloat3 = null;
                                }
                                PendoLogger.d("ComposeUtilityHelper", "checkForGuidePositionChange anchorView did move, updating guide... current location- " + x4 + ", " + y4 + " new location - " + fBoxFloat2 + ", " + fBoxFloat3 + " ");
                                sdk.pendo.io.s7.e.INSTANCE.a().b();
                            }
                        }
                    }
                    return coroutine_suspended;
                }
                mutex2 = mutex;
                Unit unit2 = Unit.INSTANCE;
                mutex = mutex2;
            }
            mutex.unlock(null);
            return Unit.INSTANCE;
        } catch (Throwable th2) {
            th = th2;
            mutex2 = mutex;
            mutex2.unlock(null);
            throw th;
        }
    }

    public static /* synthetic */ Object a(i iVar, CoroutineDispatcher coroutineDispatcher, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineDispatcher = iVar.dispatcherMain;
        }
        return iVar.a(coroutineDispatcher, (Continuation<? super Unit>) continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(SemanticsNode semanticsNode, sdk.pendo.io.s7.h hVar) {
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(semanticsNode);
        while (!arrayDeque.isEmpty()) {
            SemanticsNode semanticsNode2 = (SemanticsNode) arrayDeque.removeLast();
            if (g(semanticsNode2)) {
                c0 c0VarA = a(semanticsNode2);
                if (c0VarA.getShouldScan()) {
                    String strE = e(semanticsNode2);
                    if (strE != null) {
                        String str = "pnd_" + strE;
                        if (!hVar.d().contains(str)) {
                            hVar.d().add(str);
                            PendoLogger.d("ComposeUtilityHelper", "collectActiveRoutes -> found pendoScreen tag: " + strE);
                        }
                    }
                    String navRoute = c0VarA.getNavRoute();
                    if (navRoute != null) {
                        sdk.pendo.io.s7.g navigationVersion = c0VarA.getNavigationVersion();
                        int i = navigationVersion == null ? -1 : b.a[navigationVersion.ordinal()];
                        if (i == 1) {
                            hVar.b(navRoute);
                        } else if (i == 2) {
                            hVar.c(navRoute);
                        } else if (i == 3) {
                            hVar.a(navRoute);
                        }
                    }
                    List<SemanticsNode> children = semanticsNode2.getChildren();
                    for (int lastIndex = CollectionsKt.getLastIndex(children); -1 < lastIndex; lastIndex--) {
                        arrayDeque.add(children.get(lastIndex));
                    }
                }
            }
        }
    }

    public final Object a(View view, sdk.pendo.io.s7.h hVar, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.dispatcherMain, new e(view, hVar, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    private final sdk.pendo.io.v6.a a(SemanticsNode semanticsNode, Map<String, ? extends Object> interestingSemanticValues, sdk.pendo.io.v6.a parent, int indexInParent, Rect rootPositionOnScreen) {
        try {
            a0.a();
            return new sdk.pendo.io.v6.a(semanticsNode, interestingSemanticValues, parent, indexInParent, rootPositionOnScreen, null, 32, null);
        } catch (Exception e2) {
            PendoLogger.e("ComposeUtilityHelper createAComposeElementAndAddTextsFromCurrentSemanticsNode, Exception creating ComposeElement " + e2 + "  " + e2.getMessage(), new Object[0]);
            return null;
        }
    }

    private final sdk.pendo.io.v6.a a(SemanticsNode semanticsNode, Rect rect, sdk.pendo.io.v6.a aVar, int i, List<sdk.pendo.io.v6.a> list, List<SemanticsNode> list2) {
        sdk.pendo.io.v6.a aVarA;
        try {
            a0.a();
            if (!g(semanticsNode)) {
                return null;
            }
            Map<String, Object> mapF = f(semanticsNode);
            if (!a(semanticsNode).getShouldScan() || (aVarA = a(semanticsNode, (Map<String, ? extends Object>) mapF, aVar, i, rect)) == null) {
                return null;
            }
            List<sdk.pendo.io.v6.a> list3 = list;
            list3.add(0, aVarA);
            int i2 = 0;
            for (Object obj : a(semanticsNode, list2)) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                a(this, (SemanticsNode) obj, rect, aVarA, i2, list3, null, 16, null);
                list3 = list;
                i2 = i3;
            }
            return aVarA;
        } catch (Exception e2) {
            PendoLogger.e("ComposeUtilityHelper createComposeElementTree " + e2 + " , " + e2.getMessage(), new Object[0]);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ sdk.pendo.io.v6.a a(i iVar, SemanticsNode semanticsNode, Rect rect, sdk.pendo.io.v6.a aVar, int i, List list, List list2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            aVar = null;
        }
        if ((i2 & 4) != 0) {
            i = -1;
        }
        if ((i2 & 16) != 0) {
            list2 = null;
        }
        return iVar.a(semanticsNode, rect, aVar, i, (List<sdk.pendo.io.v6.a>) list, (List<SemanticsNode>) list2);
    }

    public final void a(View view, JSONArray tree, OnElementInScreenFoundListener onViewFoundListener, boolean forCapture, String currentScreenId) throws InterruptedException {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(tree, "tree");
        Intrinsics.checkNotNullParameter(currentScreenId, "currentScreenId");
        BuildersKt__BuildersKt.runBlocking$default(null, new C0480i(tree, onViewFoundListener, forCapture, view, currentScreenId, null), 1, null);
    }

    private final c0 a(SemanticsNode semanticsNode) {
        Object obj;
        String simpleName;
        sdk.pendo.io.s7.g gVar;
        boolean zIsAtLeast;
        Screen screen;
        Object currentState;
        NavBackStackEntry navBackStackEntryD;
        Lifecycle.State currentState2;
        boolean z = false;
        if (m || a() == null || i() == null || h() == null) {
            PendoLogger.w("Pendo failed to scan the compose elements in your application. For Apps using Jetpack Compose the Pendo SDK requires androidx.compose.ui:ui version 1.5.0 or above. Please update this dependency in your build.gradle file. For more information about the SDK requirements see: https://github.com/pendo-io/pendo-mobile-sdk/blob/master/android/pnddocs/native-android.md", new Object[0]);
            return new c0(false, null, null);
        }
        boolean z2 = true;
        if (!b() && !d() && !c()) {
            return new c0(true, null, null);
        }
        if (!b() || (navBackStackEntryD = d(semanticsNode)) == null) {
            obj = null;
            simpleName = null;
            gVar = null;
            zIsAtLeast = true;
        } else {
            simpleName = navBackStackEntryD.getDestination().getRoute();
            currentState2 = navBackStackEntryD.getLifecycleRegistry().getState();
            Intrinsics.checkNotNullExpressionValue(currentState2, "getCurrentState(...)");
            zIsAtLeast = currentState2.isAtLeast(Lifecycle.State.RESUMED);
            gVar = zIsAtLeast ? sdk.pendo.io.s7.g.NAV2 : null;
        }
        if (simpleName == null) {
            obj = currentState2;
            if (d()) {
                AnimatedContentScope animatedContentScopeB = b(semanticsNode);
                if (animatedContentScopeB == null) {
                    obj = currentState2;
                    return new c0(true, null, null);
                }
                Transition<?> parentTransition = animatedContentScopeB.getTransition().getParentTransition();
                if (parentTransition != null) {
                    obj = currentState2;
                    currentState = parentTransition.getCurrentState();
                } else {
                    obj = currentState2;
                    currentState = null;
                }
                Scene scene = currentState instanceof Scene ? (Scene) currentState : null;
                if (scene == null) {
                    return new c0(true, null, null);
                }
                EnterExitState currentState3 = animatedContentScopeB.getTransition().getCurrentState();
                EnterExitState targetState = animatedContentScopeB.getTransition().getTargetState();
                List entries = scene.getEntries();
                ArrayList arrayList = new ArrayList();
                Iterator it = entries.iterator();
                while (it.hasNext()) {
                    Object objA = r0.a("key", (NavEntry) it.next());
                    String simpleName2 = objA != null ? objA.getClass().getSimpleName() : null;
                    if (simpleName2 != null) {
                        arrayList.add(simpleName2);
                    }
                }
                simpleName = CollectionsKt.joinToString$default(CollectionsKt.toSortedSet(arrayList), "|", null, null, 0, null, null, 62, null);
                if (currentState3 == EnterExitState.Visible || (currentState3 == EnterExitState.PreEnter && targetState == EnterExitState.Visible)) {
                    z = true;
                }
                if (z) {
                    gVar = sdk.pendo.io.s7.g.NAV3;
                }
                obj = currentState3;
                zIsAtLeast = z;
            }
        }
        if (simpleName == null && c()) {
            SaveableBackStack saveableBackStackC = c(semanticsNode);
            if (saveableBackStackC == null) {
                return new c0(true, null, null);
            }
            SaveableBackStack.Record topRecord = saveableBackStackC.getTopRecord();
            if (topRecord == null || (screen = topRecord.getScreen()) == null || (simpleName = Reflection.getOrCreateKotlinClass(screen.getClass()).getSimpleName()) == null) {
                return new c0(true, null, null);
            }
            gVar = sdk.pendo.io.s7.g.CIRCUIT;
        } else {
            z2 = zIsAtLeast;
        }
        if (!z2) {
            PendoLogger.d("ComposeUtilityHelper", "The semantic node " + semanticsNode.getId() + " belongs to inactive back stack entry with route " + ((Object) simpleName) + " and state " + obj);
            a(semanticsNode, "");
        }
        if (!z2) {
            simpleName = null;
        }
        return new c0(z2, simpleName, z2 ? gVar : null);
    }

    private final List<SemanticsNode> a(SemanticsNode semanticsNode, List<SemanticsNode> list) {
        return list == null ? semanticsNode.getChildren() : list;
    }

    private final Field a() {
        return (Field) this.compositionLocalMapField.getValue();
    }

    private final List<SemanticsNode> a(SemanticsOwner semanticsOwner) {
        try {
            List allSemanticsNodes$default = SemanticsOwnerKt.getAllSemanticsNodes$default(semanticsOwner, true, false, 2, null);
            ArrayList arrayList = new ArrayList();
            for (Object obj : allSemanticsNodes$default) {
                if (h((SemanticsNode) obj)) {
                    arrayList.add(obj);
                }
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            return arrayList;
        } catch (Exception e2) {
            PendoLogger.d("ComposeUtilityHelper", "getFilteredNodesListToScan exception - " + e2.getMessage() + " ");
            return null;
        }
    }

    public final Rect a(Object reference) {
        try {
            a0.a();
            SemanticsNode semanticsNode = reference instanceof SemanticsNode ? (SemanticsNode) reference : null;
            if (semanticsNode != null) {
                return semanticsNode.getBoundsInWindow();
            }
        } catch (Exception e2) {
            PendoLogger.d("ComposeUtilityHelper getSemanticsNodeBounds, " + e2 + ", " + e2.getMessage(), new Object[0]);
        }
        return null;
    }

    public final boolean a(String destinationName, e1.a rootViewData) {
        Intrinsics.checkNotNullParameter(destinationName, "destinationName");
        Intrinsics.checkNotNullParameter(rootViewData, "rootViewData");
        if (rootViewData.h()) {
            return Intrinsics.areEqual(sdk.pendo.io.x6.i.DRAWER_ID, destinationName) || Intrinsics.areEqual(sdk.pendo.io.x6.i.BOTTOM_SHEET_ID, destinationName);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(sdk.pendo.io.v6.a composeElementParent) {
        try {
            Stack stack = new Stack();
            stack.add(composeElementParent);
            int iIntValue = 0;
            int i = 0;
            while (!stack.isEmpty()) {
                sdk.pendo.io.v6.a aVar = (sdk.pendo.io.v6.a) stack.pop();
                SemanticsNode semanticsNode = aVar.j().get();
                if (semanticsNode != null) {
                    PendoLogger.d("ComposeUtilityHelper", "################################################# current semantic id " + semanticsNode.getId() + ", isClickable: " + aVar.getClickable());
                    new ArrayList().add(semanticsNode);
                    SemanticsNode parent = semanticsNode.getParent();
                    Integer numValueOf = parent != null ? Integer.valueOf(parent.getId()) : null;
                    if (numValueOf != null && numValueOf.intValue() != iIntValue && numValueOf.intValue() > iIntValue) {
                        iIntValue = numValueOf.intValue();
                        i++;
                    } else if (numValueOf != null && numValueOf.intValue() != iIntValue) {
                        iIntValue = numValueOf.intValue();
                        i--;
                    }
                    StringBuilder sb = new StringBuilder();
                    if (i >= 0) {
                        int i2 = 0;
                        while (true) {
                            sb.append("   ");
                            if (i2 == i) {
                                break;
                            } else {
                                i2++;
                            }
                        }
                    }
                    if (numValueOf != null) {
                        LayoutInfo parentInfo = semanticsNode.getLayoutInfo().getParentInfo();
                        Integer numValueOf2 = parentInfo != null ? Integer.valueOf(parentInfo.getSemanticsId()) : null;
                        StringBuilder sb2 = new StringBuilder();
                        while (parentInfo != null && numValueOf2 != null && numValueOf2.intValue() > numValueOf.intValue()) {
                            List<ModifierInfo> modifierInfo = parentInfo.getModifierInfo();
                            sb2.append(((Object) sb) + " ^^^^^^^ Hidden semantic id " + numValueOf2 + "\n");
                            Iterator<ModifierInfo> it = modifierInfo.iterator();
                            while (it.hasNext()) {
                                sb2.append(((Object) sb) + " Hidden semantic node modifier info: " + it.next().getModifier() + "\n");
                            }
                            parentInfo = parentInfo.getParentInfo();
                            numValueOf2 = parentInfo != null ? Integer.valueOf(parentInfo.getSemanticsId()) : null;
                        }
                        if (sb2.length() > 0) {
                            PendoLogger.d("ComposeUtilityHelper", sb2);
                        }
                    }
                    String string = sb.toString();
                    Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                    a(semanticsNode, string);
                }
                stack.addAll(CollectionsKt.reversed(aVar.c()));
            }
        } catch (Throwable th) {
            PendoLogger.w("ComposeUtilityHelper", "printSemanticLayoutHierarchyTree " + th + " , " + th.getMessage());
        }
    }

    private final void a(SemanticsNode semanticsNode, String margin) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(margin + "-----------------------------------------\n");
            sb.append(margin + " Semantic node: " + semanticsNode + "\n");
            sb.append(margin + " Semantic node id: " + semanticsNode.getId() + "\n");
            sb.append(margin + " Semantic node boundsInWindow: " + semanticsNode.getBoundsInWindow() + "\n");
            sb.append(margin + " Semantic node boundsInRoot: " + semanticsNode.getBoundsInRoot() + "\n");
            sb.append(margin + " Semantic node isRoot: " + semanticsNode.isRoot() + "\n");
            sb.append(margin + " Semantic node childrenSize: " + semanticsNode.getChildren().size() + "\n");
            sb.append(margin + " Semantic node positionInRoot: " + Offset.m6577toStringimpl(semanticsNode.m8842getPositionInRootF1C5BW0()) + "\n");
            sb.append(margin + " Semantic node positionInWindow: " + Offset.m6577toStringimpl(semanticsNode.m8843getPositionInWindowF1C5BW0()) + "\n");
            LayoutInfo layoutInfo = semanticsNode.getLayoutInfo();
            ViewConfiguration viewConfiguration = layoutInfo.getViewConfiguration();
            List<ModifierInfo> modifierInfo = layoutInfo.getModifierInfo();
            SemanticsConfiguration config = semanticsNode.getConfig();
            sb.append(margin + " Semantic node layout info isPlaced: " + layoutInfo.isPlaced() + "\n");
            sb.append(margin + " Semantic node layout info isAttached: " + layoutInfo.isAttached() + "\n");
            sb.append(margin + " Semantic node layout info isDeactivated: " + layoutInfo.getIsDeactivated() + "\n");
            sb.append(margin + " Semantic node layout info semantic id: " + layoutInfo.getSemanticsId() + "\n");
            sb.append(margin + " Semantic node layout info view configuration: " + viewConfiguration + "\n");
            Iterator<ModifierInfo> it = modifierInfo.iterator();
            while (it.hasNext()) {
                sb.append(margin + " Semantic node modifier info: " + it.next().getModifier() + "\n");
            }
            sb.append(margin + " Semantic node config: " + config + "\n");
            PendoLogger.d("ComposeUtilityHelper", sb);
        } catch (Throwable th) {
            PendoLogger.w("ComposeUtilityHelper", "printSemanticNodeInfo " + th + " , " + th.getMessage());
        }
    }

    public final void a(sdk.pendo.io.v6.h listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.composeScanListener = listener;
    }

    public final Object a(Map.Entry<? extends SemanticsPropertyKey<?>, ? extends Object> entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        return (!Intrinsics.areEqual(entry.getKey().getName(), "OnClick") || entry.getValue() == null) ? entry.getValue() : Boolean.TRUE;
    }

    public final sdk.pendo.io.v6.a a(View view, List<sdk.pendo.io.v6.a> allElementsList, String destinationName) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(allElementsList, "allElementsList");
        Intrinsics.checkNotNullParameter(destinationName, "destinationName");
        try {
            a0.a();
            if (d(view)) {
                View rootView = view.getRootView();
                SemanticsOwner semanticsOwnerC = c(view);
                if (semanticsOwnerC == null) {
                    return null;
                }
                SemanticsNode rootSemanticsNode = semanticsOwnerC.getRootSemanticsNode();
                Rect rectB = b(view);
                WeakReference weakReference = new WeakReference(rootView);
                ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
                return a(this, rootSemanticsNode, rectB, null, 0, allElementsList, a(destinationName, new e1.a(weakReference, layoutParams instanceof WindowManager.LayoutParams ? (WindowManager.LayoutParams) layoutParams : null)) ? a(semanticsOwnerC) : null, 6, null);
            }
        } catch (Exception e2) {
            PendoLogger.e("ComposeUtilityHelper", "verifyAndroidComposeViewAndCreateComposeElementTree", e2);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ sdk.pendo.io.v6.a a(i iVar, View view, List list, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            list = new ArrayList();
        }
        return iVar.a(view, (List<sdk.pendo.io.v6.a>) list, str);
    }
}
