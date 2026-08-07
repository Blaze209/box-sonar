package sdk.pendo.io.sdk.react;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import sdk.pendo.io.Pendo;
import sdk.pendo.io.d6.c;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.s7.e1;
import sdk.pendo.io.s7.k;
import sdk.pendo.io.s7.m;
import sdk.pendo.io.s7.x;
import sdk.pendo.io.t4.a;
import sdk.pendo.io.x6.e;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 j2\u00020\u00012\u00020\u0002:\u0001jB#\u0012\u0006\u0010c\u001a\u00020b\u0012\b\u0010e\u001a\u0004\u0018\u00010d\u0012\b\b\u0002\u0010g\u001a\u00020f¢\u0006\u0004\bh\u0010iJF\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00032\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u000bH\u0002J*\u0010\u0010\u001a\u00020\r2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fH\u0002J,\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0011j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\u00122\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0007H\u0002JH\u0010\u001c\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00072\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00172\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00052\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0017H\u0016J&\u0010 \u001a\u00020\r2\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00052\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\b\u0010!\u001a\u00020\rH\u0016J\b\u0010\"\u001a\u00020\rH\u0014J%\u0010'\u001a\u00020\r2\b\u0010#\u001a\u0004\u0018\u00010\u00072\u0006\u0010$\u001a\u00020\u001eH\u0090@ø\u0001\u0000¢\u0006\u0004\b%\u0010&J\u001f\u0010+\u001a\u0004\u0018\u00010*2\b\u0010)\u001a\u0004\u0018\u00010(H\u0096@ø\u0001\u0000¢\u0006\u0004\b+\u0010,J\u0019\u0010/\u001a\u0004\u0018\u00010*2\u0006\u0010)\u001a\u00020(H\u0001¢\u0006\u0004\b-\u0010.J\u0013\u00102\u001a\u00020\u0007H\u0090@ø\u0001\u0000¢\u0006\u0004\b0\u00101J\u0016\u00104\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u00103\u001a\u00020\u0003H\u0014J\u000e\u00105\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0003R.\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u000b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\b\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010;\u001a\u00020\u001e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R2\u0010C\u001a\u0012\u0012\u0004\u0012\u00020\u00070Aj\b\u0012\u0004\u0012\u00020\u0007`B8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR$\u0010I\u001a\u0004\u0018\u00010\u00078\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\"\u0010O\u001a\u00020\u001e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bO\u0010<\u001a\u0004\bP\u0010>\"\u0004\bQ\u0010@R>\u0010R\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0011j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\u00128\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR$\u0010Y\u001a\u0004\u0018\u00010X8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\"\u0010_\u001a\u00020\u001e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b_\u0010<\u001a\u0004\b`\u0010>\"\u0004\ba\u0010@\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006k"}, d2 = {"Lsdk/pendo/io/sdk/react/ReactNativeScreenManager;", "Lsdk/pendo/io/x6/e;", "Lsdk/pendo/io/sdk/react/IReactNativeEventsImp;", "Landroid/view/View;", "activityRootView", "", "", "", "rootTagsMap", "", "reactRootViews", "", "filteredRootTagsMap", "", "retrieveAllValidRNRootViews", "", "reduceReachableRNRootViews", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getRootsWithNativeId", "nativeId", "findRNViewWithNativeId", "rnScreenName", "", "rnRootTags", "", "rnInfo", "clickableElementsArray", "newScreenIdentified", "errorMap", "", "shouldSendErrorToBE", "sendFailureInfo", "initGlobalLayoutChangeListener", "initWindowFocusChangeListener", "newScreenId", "forceNotifyNewScreen", "setNewScreenId$pendoIO_release", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setNewScreenId", "Landroid/app/Activity;", "activity", "Lsdk/pendo/io/s7/e1$a;", "calculateCurrentRootViewData", "(Landroid/app/Activity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTopmostRootViewData$pendoIO_release", "(Landroid/app/Activity;)Lsdk/pendo/io/s7/e1$a;", "getTopmostRootViewData", "calculateScreenId$pendoIO_release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calculateScreenId", "rootView", "getCurrentScreenContentRoots", "filterReactRoots", "Ljava/util/Map;", "getRootTagsMap$pendoIO_release", "()Ljava/util/Map;", "setRootTagsMap$pendoIO_release", "(Ljava/util/Map;)V", ReactNativeScreenManager.IS_NATIVE_STACK, "Z", "isNativeStack$pendoIO_release", "()Z", "setNativeStack$pendoIO_release", "(Z)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", ReactNativeScreenManager.NATIVE_IDS, "Ljava/util/ArrayList;", "getNativeIDs$pendoIO_release", "()Ljava/util/ArrayList;", "setNativeIDs$pendoIO_release", "(Ljava/util/ArrayList;)V", "screenName", "Ljava/lang/String;", "getScreenName$pendoIO_release", "()Ljava/lang/String;", "setScreenName$pendoIO_release", "(Ljava/lang/String;)V", "shouldForceNextScreenNotification", "getShouldForceNextScreenNotification$pendoIO_release", "setShouldForceNextScreenNotification$pendoIO_release", "clickableElements", "Ljava/util/HashMap;", "getClickableElements$pendoIO_release", "()Ljava/util/HashMap;", "setClickableElements$pendoIO_release", "(Ljava/util/HashMap;)V", "Lsdk/pendo/io/sdk/react/PlatformStateManagerRNHelper;", "rnHelper", "Lsdk/pendo/io/sdk/react/PlatformStateManagerRNHelper;", "getRnHelper$pendoIO_release", "()Lsdk/pendo/io/sdk/react/PlatformStateManagerRNHelper;", "setRnHelper$pendoIO_release", "(Lsdk/pendo/io/sdk/react/PlatformStateManagerRNHelper;)V", "useClickableElementsFromJS", "getUseClickableElementsFromJS$pendoIO_release", "setUseClickableElementsFromJS$pendoIO_release", "Lsdk/pendo/io/Pendo$PendoOptions;", "pendoOptions", "Lsdk/pendo/io/sdk/react/IReactNativeBridge;", Pendo.PendoOptions.REACT_NATIVE_BRIDGE, "Lsdk/pendo/io/s7/m;", "defaultDispatcherProvider", "<init>", "(Lsdk/pendo/io/Pendo$PendoOptions;Lsdk/pendo/io/sdk/react/IReactNativeBridge;Lsdk/pendo/io/s7/m;)V", "ReactNativeBridge", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class ReactNativeScreenManager extends e implements IReactNativeEventsImp {
    public static final String API_TRIGGERED_SCAN = "apiTriggeredScan";
    private static final String FIND_VIEW_METHOD = "findView";
    private static final String IS_NATIVE_STACK = "isNativeStack";
    private static final int MIN_ROOT_VIEW_SIZE = 10;
    private static final String NATIVE_IDS = "nativeIDs";
    private static final String REACT_FIND_VIEW_UTIL_CLASS = "com.facebook.react.uimanager.util.ReactFindViewUtil";
    private static final String TAG = "ReactNativeScreenManager";
    private HashMap<Integer, String> clickableElements;
    private boolean isNativeStack;
    private ArrayList<String> nativeIDs;
    private PlatformStateManagerRNHelper rnHelper;
    private Map<Integer, String> rootTagsMap;
    private String screenName;
    private boolean shouldForceNextScreenNotification;
    private boolean useClickableElementsFromJS;

    /* JADX INFO: renamed from: sdk.pendo.io.sdk.react.ReactNativeScreenManager$newScreenIdentified$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sdk.react.ReactNativeScreenManager$newScreenIdentified$1", f = "ReactNativeScreenManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<Object> $clickableElementsArray;
        final /* synthetic */ Map<String, Object> $rnInfo;
        final /* synthetic */ List<Integer> $rnRootTags;
        final /* synthetic */ String $rnScreenName;
        int label;
        final /* synthetic */ ReactNativeScreenManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, List<Integer> list, Map<String, ? extends Object> map, List<? extends Object> list2, ReactNativeScreenManager reactNativeScreenManager, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$rnScreenName = str;
            this.$rnRootTags = list;
            this.$rnInfo = map;
            this.$clickableElementsArray = list2;
            this.this$0 = reactNativeScreenManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$rnScreenName, this.$rnRootTags, this.$rnInfo, this.$clickableElementsArray, this.this$0, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            List<Integer> list;
            Boolean bool;
            HashMap<Integer, String> map;
            Boolean bool2;
            List<? extends Object> list2;
            HashMap<Integer, String> map2;
            Map<String, Object> map3;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (PlatformStateManager.INSTANCE.isReactNativeAnalyticsEnabled() && this.$rnScreenName != null && (list = this.$rnRootTags) != null && !list.isEmpty()) {
                PendoLogger.d("ReactNativeScreenManager -> newScreenIdentified: screenName=" + this.$rnScreenName + ", rnRootTags=" + this.$rnRootTags + ", rnInfo=" + this.$rnInfo + ", clickableElements=" + this.$clickableElementsArray, new Object[0]);
                this.this$0.setScreenName$pendoIO_release(this.$rnScreenName);
                if (this.this$0.getRnHelper() == null) {
                    this.this$0.setRnHelper$pendoIO_release(new PlatformStateManagerRNHelper());
                }
                ArrayList<String> arrayList = null;
                if (this.this$0.getRnHelper() == null || (map3 = this.$rnInfo) == null || !map3.containsKey(ReactNativeScreenManager.API_TRIGGERED_SCAN) || !(map3.get(ReactNativeScreenManager.API_TRIGGERED_SCAN) instanceof Boolean)) {
                    bool = null;
                } else {
                    Object obj2 = map3.get(ReactNativeScreenManager.API_TRIGGERED_SCAN);
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                    }
                    bool = (Boolean) obj2;
                }
                this.this$0.setShouldForceNextScreenNotification$pendoIO_release(bool == null || !bool.booleanValue());
                PendoLogger.d("ReactNativeScreenManager -> newScreenIdentified: forceNotifyNextScreenNotification - " + this.this$0.getShouldForceNextScreenNotification(), new Object[0]);
                ReactNativeScreenManager reactNativeScreenManager = this.this$0;
                PlatformStateManagerRNHelper rnHelper = reactNativeScreenManager.getRnHelper();
                if (rnHelper == null || (map = rnHelper.populateRootTags(this.$rnRootTags, this.$rnInfo)) == null) {
                    map = new HashMap<>();
                }
                reactNativeScreenManager.setRootTagsMap$pendoIO_release(map);
                if (this.this$0.getUseClickableElementsFromJS() && (list2 = this.$clickableElementsArray) != null) {
                    ReactNativeScreenManager reactNativeScreenManager2 = this.this$0;
                    PlatformStateManagerRNHelper rnHelper2 = reactNativeScreenManager2.getRnHelper();
                    if (rnHelper2 == null || (map2 = rnHelper2.populateClickableElements(list2)) == null) {
                        map2 = new HashMap<>();
                    }
                    reactNativeScreenManager2.setClickableElements$pendoIO_release(map2);
                }
                if (this.this$0.getRnHelper() != null) {
                    Map<String, Object> map4 = this.$rnInfo;
                    if (map4 != null && map4.containsKey(ReactNativeScreenManager.IS_NATIVE_STACK) && (map4.get(ReactNativeScreenManager.IS_NATIVE_STACK) instanceof Boolean)) {
                        Object obj3 = map4.get(ReactNativeScreenManager.IS_NATIVE_STACK);
                        if (obj3 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                        }
                        bool2 = (Boolean) obj3;
                    } else {
                        bool2 = null;
                    }
                    if (bool2 != null) {
                        this.this$0.setNativeStack$pendoIO_release(bool2.booleanValue());
                    }
                }
                if (this.this$0.getRnHelper() != null) {
                    Map<String, Object> map5 = this.$rnInfo;
                    if (map5 != null && map5.containsKey(ReactNativeScreenManager.NATIVE_IDS) && (map5.get(ReactNativeScreenManager.NATIVE_IDS) instanceof ArrayList)) {
                        Object obj4 = map5.get(ReactNativeScreenManager.NATIVE_IDS);
                        if (obj4 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<*>");
                        }
                        arrayList = (ArrayList) obj4;
                    }
                    if (arrayList != null) {
                        ReactNativeScreenManager reactNativeScreenManager3 = this.this$0;
                        if (!arrayList.isEmpty() && (arrayList.get(0) instanceof String)) {
                            reactNativeScreenManager3.setNativeIDs$pendoIO_release(arrayList);
                        }
                    }
                }
                if (this.this$0.getCurrentActivity().get() != null) {
                    this.this$0.handleScreenChanges();
                } else {
                    c.h().c(a.RESUME);
                    PendoLogger.d("ReactNativeScreenManager -> newScreenIdentified: no active activity, triggering lifecycle flow", new Object[0]);
                }
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactNativeScreenManager(Pendo.PendoOptions pendoOptions, IReactNativeBridge iReactNativeBridge, m defaultDispatcherProvider) {
        super(pendoOptions, defaultDispatcherProvider);
        Intrinsics.checkNotNullParameter(pendoOptions, "pendoOptions");
        Intrinsics.checkNotNullParameter(defaultDispatcherProvider, "defaultDispatcherProvider");
        this.rootTagsMap = new HashMap();
        this.nativeIDs = new ArrayList<>();
        this.clickableElements = new HashMap<>();
        if (iReactNativeBridge != null) {
            iReactNativeBridge.registerForEvents(this);
        }
        this.useClickableElementsFromJS = pendoOptions.getUseClickableElementsFromJS();
        if (this.rnHelper == null) {
            this.rnHelper = new PlatformStateManagerRNHelper();
        }
    }

    private final View findRNViewWithNativeId(View activityRootView, String nativeId) {
        try {
            Object objInvoke = Class.forName(REACT_FIND_VIEW_UTIL_CLASS).getMethod(FIND_VIEW_METHOD, View.class, String.class).invoke(null, activityRootView, nativeId);
            if (objInvoke instanceof View) {
                return (View) objInvoke;
            }
            return null;
        } catch (Exception e) {
            PendoLogger.d("ReactNativeScreenManager -> findRNViewWithNativeId " + e.getMessage(), new Object[0]);
            return null;
        }
    }

    private final HashMap<Integer, String> getRootsWithNativeId(View activityRootView) {
        HashMap<Integer, String> map = new HashMap<>();
        for (String str : this.nativeIDs) {
            Intrinsics.checkNotNull(str);
            View viewFindRNViewWithNativeId = findRNViewWithNativeId(activityRootView, str);
            if (viewFindRNViewWithNativeId != null) {
                map.put(Integer.valueOf(viewFindRNViewWithNativeId.getId()), PlatformStateManagerRNHelper.NATIVE_ID_TAG);
            }
        }
        return map;
    }

    private final void reduceReachableRNRootViews(Map<Integer, String> rootTagsMap, Set<? extends View> reactRootViews) {
        for (View view : reactRootViews) {
            for (View view2 : reactRootViews) {
                if (rootTagsMap.containsKey(Integer.valueOf(view.getId())) && rootTagsMap.containsKey(Integer.valueOf(view2.getId()))) {
                    try {
                        if (!Intrinsics.areEqual(view, view2) && view.findViewById(view2.getId()) != null) {
                            rootTagsMap.remove(Integer.valueOf(view2.getId()));
                        }
                    } catch (Exception e) {
                        PendoLogger.w(TAG, e.getMessage());
                    }
                }
            }
        }
    }

    private final void retrieveAllValidRNRootViews(View activityRootView, Map<Integer, String> rootTagsMap, Set<View> reactRootViews, Map<Integer, String> filteredRootTagsMap) {
        for (Map.Entry<Integer, String> entry : rootTagsMap.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            String value = entry.getValue();
            try {
                View viewFindViewById = activityRootView.findViewById(iIntValue);
                if (viewFindViewById != null) {
                    reactRootViews.add(viewFindViewById);
                    filteredRootTagsMap.put(Integer.valueOf(iIntValue), value);
                }
            } catch (Exception e) {
                PendoLogger.w(TAG, e.getMessage());
            }
        }
    }

    @Override // sdk.pendo.io.x6.i
    public Object calculateCurrentRootViewData(Activity activity, Continuation<? super e1.a> continuation) {
        WeakReference<View> weakReference;
        View view;
        e1.a topmostRootViewData$pendoIO_release = null;
        if (activity != null) {
            try {
                topmostRootViewData$pendoIO_release = getTopmostRootViewData$pendoIO_release(activity);
                if (topmostRootViewData$pendoIO_release != null && (weakReference = topmostRootViewData$pendoIO_release.a) != null && (view = weakReference.get()) != null) {
                    PendoLogger.d(TAG, "calculateCurrentRootViewData -> root:" + view.getClass().getSimpleName());
                    filterReactRoots(view);
                    return topmostRootViewData$pendoIO_release;
                }
            } catch (Throwable th) {
                PendoLogger.w(TAG, "calculateCurrentRootViewData -> " + th);
            }
        } else if (topmostRootViewData$pendoIO_release != null) {
            PendoLogger.d(TAG, "calculateCurrentRootViewData -> root:" + view.getClass().getSimpleName());
            filterReactRoots(view);
            return topmostRootViewData$pendoIO_release;
        }
        return topmostRootViewData$pendoIO_release;
    }

    @Override // sdk.pendo.io.x6.e, sdk.pendo.io.x6.i
    public Object calculateScreenId$pendoIO_release(Continuation<? super String> continuation) {
        String str = this.screenName;
        return str == null ? getCurrentScreenId$pendoIO_release() : str;
    }

    public final void filterReactRoots(View activityRootView) {
        Object next;
        Intrinsics.checkNotNullParameter(activityRootView, "activityRootView");
        if (this.rootTagsMap.isEmpty() || !this.shouldForceNextScreenNotification) {
            return;
        }
        Iterator<T> it = this.rootTagsMap.entrySet().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.areEqual(((Map.Entry) next).getValue(), PlatformStateManagerRNHelper.MODAL_TAG));
        Map.Entry entry = (Map.Entry) next;
        if (entry != null) {
            try {
                if (activityRootView.findViewById(((Number) entry.getKey()).intValue()) != null) {
                    int iIntValue = ((Number) entry.getKey()).intValue();
                    this.rootTagsMap.clear();
                    this.rootTagsMap.put(Integer.valueOf(iIntValue), PlatformStateManagerRNHelper.MODAL_TAG);
                    PendoLogger.d("ReactNativeScreenManager -> filterReactRoots: modal tag found, using only modalTag=" + iIntValue, new Object[0]);
                    return;
                }
            } catch (Exception e) {
                PendoLogger.w(TAG, "filterReactRoots: error finding modal tag - " + e.getMessage());
            }
        }
        HashSet hashSet = new HashSet();
        HashMap map = new HashMap();
        retrieveAllValidRNRootViews(activityRootView, this.rootTagsMap, hashSet, map);
        this.rootTagsMap.clear();
        this.rootTagsMap.putAll(map);
        this.rootTagsMap.putAll(getRootsWithNativeId(activityRootView));
        reduceReachableRNRootViews(this.rootTagsMap, hashSet);
        PendoLogger.d("ReactNativeScreenManager -> filterReactRoots " + this.rootTagsMap, new Object[0]);
    }

    public final HashMap<Integer, String> getClickableElements$pendoIO_release() {
        return this.clickableElements;
    }

    @Override // sdk.pendo.io.x6.i
    protected Set<View> getCurrentScreenContentRoots(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        HashSet hashSet = new HashSet();
        if (PlatformStateManager.INSTANCE.getFrameworkType() != Pendo.PendoOptions.FrameworkType.REACT_NAVIGATION || this.isNativeStack || this.rootTagsMap.isEmpty()) {
            PendoLogger.d("ReactNativeScreenManager -> getCurrentScreenContentRoots, return the current activity rootView: " + rootView.getClass().getSimpleName() + ", id: " + rootView.getId(), new Object[0]);
            hashSet.add(rootView);
            return hashSet;
        }
        for (Map.Entry<Integer, String> entry : this.rootTagsMap.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            String value = entry.getValue();
            View viewFindViewById = rootView.findViewById(iIntValue);
            if (viewFindViewById != null) {
                PendoLogger.d("ReactNativeScreenManager -> getCurrentScreenContentRoots, react rootView: " + viewFindViewById.getClass().getSimpleName() + ", id: " + viewFindViewById.getId() + ", type: " + value, new Object[0]);
                hashSet.add(viewFindViewById);
            }
        }
        return hashSet;
    }

    public final ArrayList<String> getNativeIDs$pendoIO_release() {
        return this.nativeIDs;
    }

    /* JADX INFO: renamed from: getRnHelper$pendoIO_release, reason: from getter */
    public final PlatformStateManagerRNHelper getRnHelper() {
        return this.rnHelper;
    }

    public final Map<Integer, String> getRootTagsMap$pendoIO_release() {
        return this.rootTagsMap;
    }

    /* JADX INFO: renamed from: getScreenName$pendoIO_release, reason: from getter */
    public final String getScreenName() {
        return this.screenName;
    }

    /* JADX INFO: renamed from: getShouldForceNextScreenNotification$pendoIO_release, reason: from getter */
    public final boolean getShouldForceNextScreenNotification() {
        return this.shouldForceNextScreenNotification;
    }

    public final e1.a getTopmostRootViewData$pendoIO_release(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        View decorView = activity.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
        if (decorView.getLayoutParams() == null) {
            return null;
        }
        WeakReference weakReference = new WeakReference(decorView);
        ViewGroup.LayoutParams layoutParams = decorView.getLayoutParams();
        e1.a aVar = new e1.a(weakReference, layoutParams instanceof WindowManager.LayoutParams ? (WindowManager.LayoutParams) layoutParams : null);
        if (activity.hasWindowFocus()) {
            PendoLogger.d("ReactNativeScreenManager getActivityMostTopRootViewData -> activity.hasWindowFocus: " + activity.hasWindowFocus(), new Object[0]);
            return aVar;
        }
        List<e1.a> listA = e1.a(activity);
        PendoLogger.d(TAG, "getActivityMostTopRootViewData -> activity has no focus, viewRoots.size: " + listA.size());
        if (listA.size() > 1) {
            for (int size = listA.size() - 1; size > 0; size--) {
                e1.a aVar2 = listA.get(size);
                WindowManager.LayoutParams layoutParamsA = aVar2.a();
                Integer numValueOf = layoutParamsA != null ? Integer.valueOf(layoutParamsA.type) : null;
                PendoLogger.d(TAG, "getActivityMostTopRootViewData -> root[" + size + "] type: " + numValueOf + ", isDialogType: " + aVar2.g() + ", isPopupWindowType: " + aVar2.i() + ", isBottomSheetType: " + aVar2.f() + ", hasValidSize: " + aVar2.a(10));
                if ((aVar2.g() || aVar2.i() || aVar2.f()) && aVar2.a(10)) {
                    return aVar2;
                }
            }
        }
        return aVar;
    }

    /* JADX INFO: renamed from: getUseClickableElementsFromJS$pendoIO_release, reason: from getter */
    public final boolean getUseClickableElementsFromJS() {
        return this.useClickableElementsFromJS;
    }

    @Override // sdk.pendo.io.x6.e
    public void initGlobalLayoutChangeListener() {
    }

    @Override // sdk.pendo.io.x6.e
    protected void initWindowFocusChangeListener() {
    }

    /* JADX INFO: renamed from: isNativeStack$pendoIO_release, reason: from getter */
    public final boolean getIsNativeStack() {
        return this.isNativeStack;
    }

    @Override // sdk.pendo.io.sdk.react.IReactNativeEventsImp
    public void newScreenIdentified(String rnScreenName, List<Integer> rnRootTags, Map<String, ? extends Object> rnInfo, List<? extends Object> clickableElementsArray) {
        x.a(getSmCoroutineScope(), getScreenManagerMutex(), null, null, new AnonymousClass1(rnScreenName, rnRootTags, rnInfo, clickableElementsArray, this, null), 6, null);
    }

    @Override // sdk.pendo.io.sdk.react.IReactNativeEventsImp
    public void sendFailureInfo(Map<String, ? extends Object> errorMap, boolean shouldSendErrorToBE) {
        if (errorMap == null || errorMap.isEmpty()) {
            return;
        }
        String str = "ReactNativePlugin: " + errorMap;
        Object[] objArr = new Object[0];
        if (shouldSendErrorToBE) {
            PendoLogger.e(str, objArr);
        } else {
            PendoLogger.w(str, objArr);
        }
    }

    public final void setClickableElements$pendoIO_release(HashMap<Integer, String> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.clickableElements = map;
    }

    public final void setNativeIDs$pendoIO_release(ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.nativeIDs = arrayList;
    }

    public final void setNativeStack$pendoIO_release(boolean z) {
        this.isNativeStack = z;
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
            boolean r0 = r8 instanceof sdk.pendo.io.sdk.react.ReactNativeScreenManager$setNewScreenId$1
            if (r0 == 0) goto L13
            r0 = r8
            sdk.pendo.io.sdk.react.ReactNativeScreenManager$setNewScreenId$1 r0 = (sdk.pendo.io.sdk.react.ReactNativeScreenManager$setNewScreenId$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            sdk.pendo.io.sdk.react.ReactNativeScreenManager$setNewScreenId$1 r0 = new sdk.pendo.io.sdk.react.ReactNativeScreenManager$setNewScreenId$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
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
            java.lang.Object r5 = r0.L$0
            sdk.pendo.io.sdk.react.ReactNativeScreenManager r5 = (sdk.pendo.io.sdk.react.ReactNativeScreenManager) r5
            kotlin.ResultKt.throwOnFailure(r8)
            goto L54
        L39:
            kotlin.ResultKt.throwOnFailure(r8)
            boolean r8 = r5.shouldForceNextScreenNotification
            r0.L$0 = r5
            if (r8 == 0) goto L4b
            r0.label = r4
            java.lang.Object r6 = super.setNewScreenId$pendoIO_release(r6, r4, r0)
            if (r6 != r1) goto L54
            goto L53
        L4b:
            r0.label = r3
            java.lang.Object r6 = super.setNewScreenId$pendoIO_release(r6, r7, r0)
            if (r6 != r1) goto L54
        L53:
            return r1
        L54:
            r6 = 0
            r5.shouldForceNextScreenNotification = r6
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.sdk.react.ReactNativeScreenManager.setNewScreenId$pendoIO_release(java.lang.String, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void setRnHelper$pendoIO_release(PlatformStateManagerRNHelper platformStateManagerRNHelper) {
        this.rnHelper = platformStateManagerRNHelper;
    }

    public final void setRootTagsMap$pendoIO_release(Map<Integer, String> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.rootTagsMap = map;
    }

    public final void setScreenName$pendoIO_release(String str) {
        this.screenName = str;
    }

    public final void setShouldForceNextScreenNotification$pendoIO_release(boolean z) {
        this.shouldForceNextScreenNotification = z;
    }

    public final void setUseClickableElementsFromJS$pendoIO_release(boolean z) {
        this.useClickableElementsFromJS = z;
    }

    public /* synthetic */ ReactNativeScreenManager(Pendo.PendoOptions pendoOptions, IReactNativeBridge iReactNativeBridge, m mVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(pendoOptions, iReactNativeBridge, (i & 4) != 0 ? new k() : mVar);
    }
}
