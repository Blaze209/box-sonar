package sdk.pendo.io.actions;

import android.view.View;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.observability.DiagnosisParams;
import com.facebook.infer.annotation.ThreadConfined;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.d1.l;
import sdk.pendo.io.j4.a;
import sdk.pendo.io.k3.j;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.ActivationModel;
import sdk.pendo.io.models.GuideCandidate;
import sdk.pendo.io.models.GuideModel;
import sdk.pendo.io.models.StepLocationModel;
import sdk.pendo.io.models.StepModel;
import sdk.pendo.io.o3.b;
import sdk.pendo.io.q3.e;
import sdk.pendo.io.r5.i;
import sdk.pendo.io.r5.m;
import sdk.pendo.io.x6.d;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010#\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002fgB\t\b\u0002¢\u0006\u0004\be\u0010KJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\"\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0013H\u0002J\u0016\u0010\u0017\u001a\u00020\u00022\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u0010H\u0002J\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018J\u000e\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0019J\u0006\u0010\u001b\u001a\u00020\u0019J\u0006\u0010\u001d\u001a\u00020\u0013J\u0016\u0010 \u001a\u00020\u00132\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0010H\u0016J\b\u0010!\u001a\u00020\u0013H\u0016J\"\u0010&\u001a\u00020\u00022\b\u0010\"\u001a\u0004\u0018\u00010\n2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#H\u0016J\u0010\u0010(\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\nH\u0016J\u000e\u0010*\u001a\b\u0012\u0004\u0012\u00020)0\u0010H\u0016J\u0010\u0010+\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010.\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010-\u001a\u0004\u0018\u00010,H\u0016J\u000e\u00100\u001a\b\u0012\u0004\u0012\u00020)0/H\u0017J\u0016\u00103\u001a\u00020\u00132\f\u00102\u001a\b\u0012\u0004\u0012\u00020\r01H\u0016J\u0016\u00105\u001a\u00020\u00132\f\u00104\u001a\b\u0012\u0004\u0012\u00020\r01H\u0016J\b\u00106\u001a\u00020\u0013H\u0017J\b\u00107\u001a\u00020\u0013H\u0017R\u0014\u00108\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010:\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b:\u00109R\u0014\u0010;\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b;\u00109R\u0014\u0010<\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b<\u00109R2\u0010@\u001a\u0012\u0012\u0004\u0012\u00020>0=j\b\u0012\u0004\u0012\u00020>`?8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER&\u0010F\u001a\b\u0012\u0004\u0012\u00020)0/8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\bF\u0010G\u0012\u0004\bJ\u0010K\u001a\u0004\bH\u0010IR\u0016\u0010M\u001a\u0004\u0018\u00010L8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010O\u001a\u0004\u0018\u00010L8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010NR\u0014\u0010P\u001a\u00020L8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010NR\u001d\u0010Q\u001a\b\u0012\u0004\u0012\u00020\b0\u00188\u0006¢\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010TR\"\u0010V\u001a\u00020U8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R8\u0010^\u001a&\u0012\f\u0012\n \\*\u0004\u0018\u00010\u00020\u0002 \\*\u0012\u0012\f\u0012\n \\*\u0004\u0018\u00010\u00020\u0002\u0018\u00010]018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b^\u0010_R8\u0010`\u001a&\u0012\f\u0012\n \\*\u0004\u0018\u00010\u00190\u0019 \\*\u0012\u0012\f\u0012\n \\*\u0004\u0018\u00010\u00190\u0019\u0018\u00010\u00180\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b`\u0010RR\u0014\u0010d\u001a\u00020a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bb\u0010c¨\u0006h"}, d2 = {"Lsdk/pendo/io/actions/ActivationManager;", "Lsdk/pendo/io/actions/IActivationManager;", "", "guideId", "Lsdk/pendo/io/models/ActivationModel;", "activationModel", "Lsdk/pendo/io/models/StepLocationModel;", "locationModel", "", "addGuideIdForActivationAndLocation", "Lorg/json/JSONObject;", "objectData", "Ljava/util/LinkedHashSet;", "Lsdk/pendo/io/models/GuideCandidate;", "Lkotlin/collections/LinkedHashSet;", "getGuidesWithMatchingViewsCurrentlyOnScreen", "", "Lsdk/pendo/io/actions/ElementInfoAndViewRef;", "getRetroElementInfoMatchingSelector", "", "handleRestart", "sendTrackEventsReceivedWhileStartSessionWasPendingApproval", "guideCandidatesList", "showScreenViewGuides", "Lsdk/pendo/io/j4/a;", "", "isInitedObservable", "isInited", "setIsInitedObservable", "start", "Lsdk/pendo/io/models/GuideModel;", "guides", "restartWithGuides", DiagnosisParams.CLEAR_ON_LOGOUT, "viewElementInfo", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "guideTriggeredByView", "handleClick", "trackEventJSON", "handleTrack", "Lsdk/pendo/io/actions/ActivationManager$Trigger;", "getGuidesTriggers", "removeGuideIdFromTriggers", "Lsdk/pendo/io/models/StepModel;", "stepModel", "handleLaunchGuideFromGuide", "", "getTriggersForStep", "", "guidesSetWithTrackActivation", "populateGuidesSetWithTrackActivationBeforeSessionStart", "guidesSetWithViewActivation", "populateGuideSetWithViewActivation", "handleScreenView", "handleAnyActivation", "TAG", "Ljava/lang/String;", "TRACK_EVENT_KEY", "ELEMENT_INFO_KEY", "SCREEN_DATA_KEY", "Ljava/util/ArrayList;", "Lsdk/pendo/io/r5/m$a;", "Lkotlin/collections/ArrayList;", "trackEventsBeforeSessionStart", "Ljava/util/ArrayList;", "getTrackEventsBeforeSessionStart", "()Ljava/util/ArrayList;", "setTrackEventsBeforeSessionStart", "(Ljava/util/ArrayList;)V", "triggers", "Ljava/util/List;", "getTriggers", "()Ljava/util/List;", "getTriggers$annotations", "()V", "Lsdk/pendo/io/o3/b;", "screenChangedSubscription", "Lsdk/pendo/io/o3/b;", "inScreenChangedSubscription", "activationTriggerSubscription", "activationTriggerSubject", "Lsdk/pendo/io/j4/a;", "getActivationTriggerSubject", "()Lsdk/pendo/io/j4/a;", "Lsdk/pendo/io/actions/GuideActivationHelper;", "guideActivationHelper", "Lsdk/pendo/io/actions/GuideActivationHelper;", "getGuideActivationHelper", "()Lsdk/pendo/io/actions/GuideActivationHelper;", "setGuideActivationHelper", "(Lsdk/pendo/io/actions/GuideActivationHelper;)V", "kotlin.jvm.PlatformType", "", "currentScreenSeenGuides", "Ljava/util/Set;", "sIsInitedObservable", "Lsdk/pendo/io/x6/d;", "getScreenManager", "()Lsdk/pendo/io/x6/d;", "screenManager", "<init>", "ActivationEvents", "Trigger", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class ActivationManager implements IActivationManager {
    public static final String ELEMENT_INFO_KEY = "retroElementInfo";
    public static final ActivationManager INSTANCE;
    public static final String SCREEN_DATA_KEY = "retroactiveScreenData";
    private static final String TAG = "ActivationManager";
    public static final String TRACK_EVENT_KEY = "trackEventInfo";
    private static final a<Object> activationTriggerSubject;
    private static final b activationTriggerSubscription;
    private static final Set<String> currentScreenSeenGuides;
    private static GuideActivationHelper guideActivationHelper;
    private static final b inScreenChangedSubscription;
    private static final a<Boolean> sIsInitedObservable;
    private static final b screenChangedSubscription;
    private static ArrayList<m.a> trackEventsBeforeSessionStart;
    private static final List<Trigger> triggers;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lsdk/pendo/io/actions/ActivationManager$ActivationEvents;", "", "activationEvent", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getActivationEvent", "()Ljava/lang/String;", "APP_LAUNCH", "VIEW", "CLICK", "PREVIEW", "TRACK_EVENT", ThreadConfined.ANY, "API", "Companion", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public enum ActivationEvents {
        APP_LAUNCH("appLaunch"),
        VIEW("view"),
        CLICK("click"),
        PREVIEW(BoxAnalyticsParams.CTA_PAGE_PREVIEW),
        TRACK_EVENT("track"),
        ANY("any"),
        API("api");

        private final String activationEvent;
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final HashMap<String, ActivationEvents> map = new HashMap<>();

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005R-\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lsdk/pendo/io/actions/ActivationManager$ActivationEvents$Companion;", "", "()V", "map", "Ljava/util/HashMap;", "", "Lsdk/pendo/io/actions/ActivationManager$ActivationEvents;", "Lkotlin/collections/HashMap;", "getMap", "()Ljava/util/HashMap;", "fromString", "type", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final ActivationEvents fromString(String type) {
                if (type != null) {
                    return ActivationEvents.INSTANCE.getMap().get(type);
                }
                return null;
            }

            public final HashMap<String, ActivationEvents> getMap() {
                return ActivationEvents.map;
            }
        }

        static {
            for (ActivationEvents activationEvents : values()) {
                map.put(activationEvents.activationEvent, activationEvents);
            }
        }

        ActivationEvents(String str) {
            this.activationEvent = str;
        }

        public static EnumEntries<ActivationEvents> getEntries() {
            return $ENTRIES;
        }

        public final String getActivationEvent() {
            return this.activationEvent;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bJ\u000e\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lsdk/pendo/io/actions/ActivationManager$Trigger;", "", "activation", "Lsdk/pendo/io/models/ActivationModel;", FirebaseAnalytics.Param.LOCATION, "Lsdk/pendo/io/models/StepLocationModel;", "(Lsdk/pendo/io/models/ActivationModel;Lsdk/pendo/io/models/StepLocationModel;)V", "getActivation", "()Lsdk/pendo/io/models/ActivationModel;", "guideIds", "", "", "getGuideIds", "()Ljava/util/Set;", "getLocation", "()Lsdk/pendo/io/models/StepLocationModel;", "addGuideId", "", "guideId", "removeGuideId", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Trigger {
        private final ActivationModel activation;
        private final Set<String> guideIds;
        private final StepLocationModel location;

        public Trigger(ActivationModel activation, StepLocationModel stepLocationModel) {
            Intrinsics.checkNotNullParameter(activation, "activation");
            this.activation = activation;
            this.location = stepLocationModel;
            this.guideIds = new LinkedHashSet();
        }

        public final void addGuideId(String guideId) {
            Intrinsics.checkNotNullParameter(guideId, "guideId");
            this.guideIds.add(guideId);
        }

        public final ActivationModel getActivation() {
            return this.activation;
        }

        public final Set<String> getGuideIds() {
            return this.guideIds;
        }

        public final StepLocationModel getLocation() {
            return this.location;
        }

        public final void removeGuideId(String guideId) {
            Intrinsics.checkNotNullParameter(guideId, "guideId");
            this.guideIds.remove(guideId);
        }
    }

    static {
        b bVarA;
        j<String> jVarA;
        j<String> jVarA2;
        ActivationManager activationManager = new ActivationManager();
        INSTANCE = activationManager;
        trackEventsBeforeSessionStart = new ArrayList<>();
        triggers = new ArrayList();
        a<Object> aVarM = a.m();
        Intrinsics.checkNotNullExpressionValue(aVarM, "create(...)");
        activationTriggerSubject = aVarM;
        guideActivationHelper = new GuideActivationHelper(activationManager.getScreenManager());
        currentScreenSeenGuides = Collections.synchronizedSet(new LinkedHashSet());
        j<String> screenChangedNewScreenIdSubject = activationManager.getScreenManager().getScreenChangedNewScreenIdSubject();
        b bVarA2 = null;
        if (screenChangedNewScreenIdSubject == null || (jVarA2 = screenChangedNewScreenIdSubject.a(sdk.pendo.io.i4.a.b())) == null) {
            bVarA = null;
        } else {
            final AnonymousClass1 anonymousClass1 = new Function1<String, Unit>() { // from class: sdk.pendo.io.actions.ActivationManager.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String str) {
                    ActivationManager.currentScreenSeenGuides.clear();
                    if (VisualGuidesManager.getInstance().isAnyGuideDisplayed()) {
                        return;
                    }
                    ActivationManager.INSTANCE.handleScreenView();
                }
            };
            bVarA = jVarA2.a(new e() { // from class: sdk.pendo.io.actions.ActivationManager$$ExternalSyntheticLambda0
                @Override // sdk.pendo.io.q3.e
                public final void accept(Object obj) {
                    ActivationManager._init_$lambda$0(anonymousClass1, obj);
                }
            }, new sdk.pendo.io.q6.a("ActivationManager, screenChangedSubscription"));
        }
        screenChangedSubscription = bVarA;
        j<String> screenLayoutChangedSameScreenIdSubject = activationManager.getScreenManager().getScreenLayoutChangedSameScreenIdSubject();
        if (screenLayoutChangedSameScreenIdSubject != null && (jVarA = screenLayoutChangedSameScreenIdSubject.a(sdk.pendo.io.i4.a.b())) != null) {
            final AnonymousClass2 anonymousClass2 = new Function1<String, Unit>() { // from class: sdk.pendo.io.actions.ActivationManager.2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String str) {
                    if (VisualGuidesManager.getInstance().isAnyGuideDisplayed()) {
                        return;
                    }
                    ActivationManager.INSTANCE.handleScreenView();
                }
            };
            bVarA2 = jVarA.a(new e() { // from class: sdk.pendo.io.actions.ActivationManager$$ExternalSyntheticLambda1
                @Override // sdk.pendo.io.q3.e
                public final void accept(Object obj) {
                    ActivationManager._init_$lambda$1(anonymousClass2, obj);
                }
            }, new sdk.pendo.io.q6.a("ActivationManager, inScreenChangedSubscription"));
        }
        inScreenChangedSubscription = bVarA2;
        b bVarA3 = aVarM.a(sdk.pendo.io.i4.a.b()).a(new e() { // from class: sdk.pendo.io.actions.ActivationManager$$ExternalSyntheticLambda2
            @Override // sdk.pendo.io.q3.e
            public final void accept(Object obj) {
                ActivationManager._init_$lambda$2(obj);
            }
        }, new sdk.pendo.io.q6.a("ActivationManager, activationTriggerSubscription"));
        Intrinsics.checkNotNullExpressionValue(bVarA3, "subscribe(...)");
        activationTriggerSubscription = bVarA3;
        sIsInitedObservable = a.b(Boolean.FALSE);
    }

    private ActivationManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$2(Object obj) {
        if (VisualGuidesManager.getInstance().isAnyGuideDisplayed()) {
            return;
        }
        INSTANCE.handleAnyActivation();
    }

    private final Object addGuideIdForActivationAndLocation(String guideId, ActivationModel activationModel, StepLocationModel locationModel) {
        Object next;
        Iterator<T> it = triggers.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            Trigger trigger = (Trigger) next;
            if (Intrinsics.areEqual(trigger.getActivation(), activationModel) && Intrinsics.areEqual(trigger.getLocation(), locationModel)) {
                break;
            }
        }
        Trigger trigger2 = (Trigger) next;
        if (trigger2 != null) {
            trigger2.addGuideId(guideId);
            return Unit.INSTANCE;
        }
        Trigger trigger3 = new Trigger(activationModel, locationModel);
        trigger3.addGuideId(guideId);
        triggers.add(trigger3);
        return trigger3;
    }

    private final LinkedHashSet<GuideCandidate> getGuidesWithMatchingViewsCurrentlyOnScreen(JSONObject objectData) {
        List<ElementInfoAndViewRef> retroElementInfoMatchingSelector;
        LinkedHashSet<GuideCandidate> linkedHashSet = new LinkedHashSet<>();
        if (objectData != null && (retroElementInfoMatchingSelector = INSTANCE.getRetroElementInfoMatchingSelector()) != null) {
            for (ElementInfoAndViewRef elementInfoAndViewRef : retroElementInfoMatchingSelector) {
                Integer currentStepIndex = StepSeenManager.getInstance().getCurrentStepIndex();
                GuideActivationHelper guideActivationHelper2 = guideActivationHelper;
                Trigger matchingTrigger = elementInfoAndViewRef.getMatchingTrigger();
                WeakReference<View> viewReference = elementInfoAndViewRef.getViewReference();
                Intrinsics.checkNotNull(currentStepIndex);
                linkedHashSet.addAll(guideActivationHelper2.getGuidesMatchingCurrentActivationTriggerForTooltips(matchingTrigger, viewReference, currentStepIndex.intValue()));
            }
        }
        return linkedHashSet;
    }

    private final List<ElementInfoAndViewRef> getRetroElementInfoMatchingSelector() throws JSONException {
        List<Trigger> triggersForStep = getTriggersForStep();
        if (triggersForStep.isEmpty()) {
            triggersForStep = triggers;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : triggersForStep) {
            String activationEvent = ActivationEvents.VIEW.getActivationEvent();
            String event = ((Trigger) obj).getActivation().getEvent();
            Intrinsics.checkNotNullExpressionValue(event, "getEvent(...)");
            if (activationEvent.contentEquals(event)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        if (getScreenManager().getCurrentScreenData() == null) {
            return null;
        }
        jSONObject.put(SCREEN_DATA_KEY, getScreenManager().getCurrentScreenData());
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            Trigger trigger = (Trigger) obj2;
            String pageSelector = trigger.getActivation().getPageSelector();
            if (pageSelector == null || StringsKt.isBlank(pageSelector)) {
                PendoLogger.e(TAG, "PageSelector of the following guides is null or empty, please verify " + trigger.getGuideIds());
            } else {
                GuideActivationHelper guideActivationHelper2 = guideActivationHelper;
                String string = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                sdk.pendo.io.r1.a aVar = (sdk.pendo.io.r1.a) guideActivationHelper2.jsonPathParse(string).a(pageSelector, new l[0]);
                if (aVar != null && !aVar.isEmpty()) {
                    arrayList2.add(obj2);
                }
            }
        }
        if (arrayList2.isEmpty()) {
            return null;
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj3 : arrayList2) {
            Trigger trigger2 = (Trigger) obj3;
            if (trigger2.getLocation() != null && trigger2.getLocation().getFeatureSelector() != null) {
                arrayList3.add(obj3);
            }
        }
        if (arrayList3.isEmpty()) {
            return null;
        }
        return PendoInternal.z().getMatchingElementsIfExist(arrayList3);
    }

    private final d getScreenManager() {
        d dVarZ = PendoInternal.z();
        Intrinsics.checkNotNullExpressionValue(dVarZ, "getScreenManager(...)");
        return dVarZ;
    }

    public static /* synthetic */ void getTriggers$annotations() {
    }

    private final synchronized void handleRestart() {
        PendoLogger.i("ActivationManager-> handleRestart after new init", new Object[0]);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(guideActivationHelper.getGuidesMatchingCurrentActivationTrigger(null, ActivationEvents.APP_LAUNCH, getGuidesTriggers()));
        PendoInternal.f(false);
        sendTrackEventsReceivedWhileStartSessionWasPendingApproval();
        if (linkedHashSet.isEmpty()) {
            populateGuidesSetWithTrackActivationBeforeSessionStart(linkedHashSet);
        }
        if (linkedHashSet.isEmpty()) {
            populateGuideSetWithViewActivation(linkedHashSet);
        }
        if (!linkedHashSet.isEmpty() && Intrinsics.areEqual(showScreenViewGuides(CollectionsKt.toList(linkedHashSet)), "")) {
            trackEventsBeforeSessionStart.clear();
        }
    }

    private final void sendTrackEventsReceivedWhileStartSessionWasPendingApproval() {
        CollectionsKt.sortedWith(trackEventsBeforeSessionStart, new Comparator() { // from class: sdk.pendo.io.actions.ActivationManager$sendTrackEventsReceivedWhileStartSessionWasPendingApproval$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Long.valueOf(((m.a) t).d()), Long.valueOf(((m.a) t2).d()));
            }
        });
        Iterator<T> it = trackEventsBeforeSessionStart.iterator();
        while (it.hasNext()) {
            i.f().a((m.a) it.next());
        }
    }

    private final String showScreenViewGuides(List<GuideCandidate> guideCandidatesList) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : guideCandidatesList) {
            GuideCandidate guideCandidate = (GuideCandidate) obj;
            if (guideCandidate.getActivationEvent() != ActivationEvents.VIEW || !currentScreenSeenGuides.contains(guideCandidate.getGuideId())) {
                arrayList.add(obj);
            }
        }
        Pair pairShowGuide$default = GuideActivationHelper.showGuide$default(guideActivationHelper, arrayList, null, 2, null);
        String str = (String) pairShowGuide$default.component1();
        int iIntValue = ((Number) pairShowGuide$default.component2()).intValue();
        if (!Intrinsics.areEqual(str, "")) {
            currentScreenSeenGuides.add(str + "_" + iIntValue);
        }
        return str;
    }

    @Override // sdk.pendo.io.actions.IActivationManager
    public synchronized void clear() {
        triggers.clear();
    }

    public final a<Object> getActivationTriggerSubject() {
        return activationTriggerSubject;
    }

    public final GuideActivationHelper getGuideActivationHelper() {
        return guideActivationHelper;
    }

    @Override // sdk.pendo.io.actions.IActivationManager
    public List<Trigger> getGuidesTriggers() {
        List<Trigger> triggersForStep = getTriggersForStep();
        return !triggersForStep.isEmpty() ? triggersForStep : triggers;
    }

    public final ArrayList<m.a> getTrackEventsBeforeSessionStart() {
        return trackEventsBeforeSessionStart;
    }

    public final List<Trigger> getTriggers() {
        return triggers;
    }

    @Override // sdk.pendo.io.actions.IActivationManager
    public List<Trigger> getTriggersForStep() {
        List<ActivationModel> stepActivations;
        ArrayList arrayList = new ArrayList();
        if (StepSeenManager.getInstance().getCurrentStepSeen() != null) {
            String currentStepGuideId = StepSeenManager.getInstance().getCurrentStepGuideId();
            String currentStepId = StepSeenManager.getInstance().getCurrentStepId();
            if (currentStepGuideId != null && currentStepId != null) {
                GuideModel guide = GuidesManager.INSTANCE.getGuide(currentStepGuideId);
                StepModel guideStepModel = guide != null ? guide.getGuideStepModel(currentStepId) : null;
                if (guideStepModel != null && (stepActivations = guideStepModel.getStepActivations()) != null) {
                    Intrinsics.checkNotNull(stepActivations);
                    for (ActivationModel activationModel : stepActivations) {
                        if (StepSeenManager.getInstance().isBackwardsStep()) {
                            if (Intrinsics.areEqual(activationModel.getEvent(), ActivationEvents.APP_LAUNCH.getActivationEvent()) || Intrinsics.areEqual(activationModel.getEvent(), ActivationEvents.API.getActivationEvent())) {
                                activationModel.setEvent(ActivationEvents.ANY.getActivationEvent());
                            } else if (Intrinsics.areEqual(activationModel.getEvent(), ActivationEvents.CLICK.getActivationEvent())) {
                                activationModel.setEvent(ActivationEvents.VIEW.getActivationEvent());
                                activationModel.setIsActivationOverridden(true);
                            }
                        }
                        if (StepSeenManager.getInstance().isBannerGuideStep()) {
                            activationModel = new ActivationModel();
                            activationModel.setEvent(ActivationEvents.ANY.getActivationEvent());
                        } else {
                            Intrinsics.checkNotNull(activationModel);
                        }
                        Trigger trigger = new Trigger(activationModel, guideStepModel.getStepLocationModel());
                        trigger.addGuideId(currentStepGuideId);
                        arrayList.add(trigger);
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // sdk.pendo.io.actions.IActivationManager
    public synchronized void handleAnyActivation() {
        if (PendoInternal.Z()) {
            GuideActivationHelper.showGuide$default(guideActivationHelper, CollectionsKt.toList(guideActivationHelper.getGuidesMatchingCurrentActivationTrigger(null, ActivationEvents.ANY, getGuidesTriggers())), null, 2, null);
        }
    }

    @Override // sdk.pendo.io.actions.IActivationManager
    public String handleClick(JSONObject viewElementInfo, WeakReference<View> guideTriggeredByView) {
        JSONObject currentScreenData = guideActivationHelper.getCurrentScreenData();
        if (currentScreenData == null || viewElementInfo == null) {
            return "";
        }
        PendoLogger.i("ActivationManager-> handleClick for viewElement: " + viewElementInfo, new Object[0]);
        Set<GuideCandidate> guidesMatchingCurrentActivationTrigger = guideActivationHelper.getGuidesMatchingCurrentActivationTrigger(guideActivationHelper.getObjectDataForScreenAndElement(currentScreenData, viewElementInfo), ActivationEvents.CLICK, INSTANCE.getGuidesTriggers());
        return !guidesMatchingCurrentActivationTrigger.isEmpty() ? guideActivationHelper.showGuide(CollectionsKt.toList(guidesMatchingCurrentActivationTrigger), guideTriggeredByView).component1() : "";
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0082 A[Catch: all -> 0x00c6, TryCatch #0 {, blocks: (B:4:0x0007, B:6:0x000f, B:13:0x001d, B:15:0x0023, B:17:0x002b, B:20:0x0033, B:22:0x005b, B:24:0x0063, B:26:0x0082, B:27:0x009a, B:29:0x009e), top: B:35:0x0007 }] */
    @Override // sdk.pendo.io.actions.IActivationManager
    public synchronized void handleLaunchGuideFromGuide(String guideId, StepModel stepModel) {
        List<ActivationModel> stepActivations;
        ActivationModel activationModel;
        Intrinsics.checkNotNullParameter(guideId, "guideId");
        Unit unit = null;
        boolean z = (stepModel != null ? stepModel.getStepLocationModel() : null) != null;
        String event = (stepModel == null || (stepActivations = stepModel.getStepActivations()) == null || (activationModel = (ActivationModel) CollectionsKt.first((List) stepActivations)) == null) ? null : activationModel.getEvent();
        if (event != null) {
            PendoLogger.i("ActivationManager-> handleLaunchGuideFromGuide for guideId: " + guideId + ", is tooltip: " + z + " and self activationEvent: " + event, new Object[0]);
            if (!z) {
                GuideModel guide = GuidesManager.INSTANCE.getGuide(guideId);
                if (guide != null) {
                    ArrayList arrayList = new ArrayList();
                    ActivationEvents activationEventsFromString = ActivationEvents.INSTANCE.fromString(event);
                    Intrinsics.checkNotNull(activationEventsFromString);
                    arrayList.add(new GuideCandidate(guide, 0, activationEventsFromString, null));
                    if (GuideActivationHelper.showGuide$default(guideActivationHelper, arrayList, null, 2, null) == null) {
                        PendoLogger.w(TAG, "handleLaunchGuideFromGuide: guide not found in active guides for id: " + guideId);
                        Unit unit2 = Unit.INSTANCE;
                    }
                } else {
                    PendoLogger.w(TAG, "handleLaunchGuideFromGuide: guide not found in active guides for id: " + guideId);
                    Unit unit3 = Unit.INSTANCE;
                }
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            PendoLogger.e(TAG, "handleLaunchGuideFromGuide with null guideActivationEvent for guideId: " + guideId + ", is tooltip: " + z + " ");
        }
    }

    @Override // sdk.pendo.io.actions.IActivationManager
    public synchronized void handleScreenView() {
        Unit unit;
        if (PendoInternal.Z()) {
            PendoLogger.i("ActivationManager-> handleScreenView", new Object[0]);
            if (guideActivationHelper.getCurrentScreenData() != null) {
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                ActivationManager activationManager = INSTANCE;
                activationManager.populateGuideSetWithViewActivation(linkedHashSet);
                if (!linkedHashSet.isEmpty()) {
                    activationManager.showScreenViewGuides(CollectionsKt.toList(linkedHashSet));
                }
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                PendoLogger.i("ActivationManager-> handleScreenView the currentScreenData is null", new Object[0]);
            }
        }
    }

    @Override // sdk.pendo.io.actions.IActivationManager
    public synchronized void handleTrack(JSONObject trackEventJSON) {
        Intrinsics.checkNotNullParameter(trackEventJSON, "trackEventJSON");
        PendoLogger.i("ActivationManager-> handleTrack with trackEvent: " + trackEventJSON, new Object[0]);
        Set<GuideCandidate> guidesMatchingCurrentActivationTrigger = guideActivationHelper.getGuidesMatchingCurrentActivationTrigger(guideActivationHelper.getObjectDataForTrackEvent(trackEventJSON), ActivationEvents.TRACK_EVENT, getGuidesTriggers());
        if (!guidesMatchingCurrentActivationTrigger.isEmpty()) {
            GuideActivationHelper.showGuide$default(guideActivationHelper, CollectionsKt.toList(guidesMatchingCurrentActivationTrigger), null, 2, null);
        }
    }

    public final boolean isInited() {
        Boolean boolN = sIsInitedObservable.n();
        Intrinsics.checkNotNull(boolN);
        return boolN.booleanValue();
    }

    public final a<Boolean> isInitedObservable() {
        a<Boolean> sIsInitedObservable2 = sIsInitedObservable;
        Intrinsics.checkNotNullExpressionValue(sIsInitedObservable2, "sIsInitedObservable");
        return sIsInitedObservable2;
    }

    @Override // sdk.pendo.io.actions.IActivationManager
    public void populateGuideSetWithViewActivation(Set<GuideCandidate> guidesSetWithViewActivation) throws JSONException {
        Intrinsics.checkNotNullParameter(guidesSetWithViewActivation, "guidesSetWithViewActivation");
        JSONObject currentScreenData = guideActivationHelper.getCurrentScreenData();
        if (currentScreenData != null) {
            JSONObject objectDataForScreen = guideActivationHelper.getObjectDataForScreen(currentScreenData);
            GuideActivationHelper guideActivationHelper2 = guideActivationHelper;
            ActivationEvents activationEvents = ActivationEvents.VIEW;
            ActivationManager activationManager = INSTANCE;
            guidesSetWithViewActivation.addAll(SetsKt.plus((Set) guideActivationHelper2.getGuidesMatchingCurrentActivationTrigger(objectDataForScreen, activationEvents, activationManager.getGuidesTriggers()), (Iterable) activationManager.getGuidesWithMatchingViewsCurrentlyOnScreen(objectDataForScreen)));
        }
    }

    @Override // sdk.pendo.io.actions.IActivationManager
    public void populateGuidesSetWithTrackActivationBeforeSessionStart(Set<GuideCandidate> guidesSetWithTrackActivation) throws JSONException {
        Intrinsics.checkNotNullParameter(guidesSetWithTrackActivation, "guidesSetWithTrackActivation");
        JSONObject jSONObject = new JSONObject();
        Iterator<T> it = trackEventsBeforeSessionStart.iterator();
        while (it.hasNext()) {
            jSONObject.put(TRACK_EVENT_KEY, ((m.a) it.next()).c());
            Set<GuideCandidate> guidesMatchingCurrentActivationTrigger = guideActivationHelper.getGuidesMatchingCurrentActivationTrigger(jSONObject, ActivationEvents.TRACK_EVENT, INSTANCE.getGuidesTriggers());
            if (!guidesMatchingCurrentActivationTrigger.isEmpty()) {
                guidesSetWithTrackActivation.addAll(guidesMatchingCurrentActivationTrigger);
                return;
            }
        }
        trackEventsBeforeSessionStart.clear();
    }

    @Override // sdk.pendo.io.actions.IActivationManager
    public synchronized void removeGuideIdFromTriggers(String guideId) {
        Intrinsics.checkNotNullParameter(guideId, "guideId");
        Iterator<Trigger> it = triggers.iterator();
        while (it.hasNext()) {
            Trigger next = it.next();
            next.getGuideIds().remove(guideId);
            if (next.getGuideIds().isEmpty()) {
                it.remove();
            }
        }
    }

    @Override // sdk.pendo.io.actions.IActivationManager
    public synchronized void restartWithGuides(List<? extends GuideModel> guides) {
        StepModel stepModel;
        Intrinsics.checkNotNullParameter(guides, "guides");
        try {
            triggers.clear();
            for (GuideModel guideModel : guides) {
                List<StepModel> steps = guideModel.getSteps();
                if (steps != null && (stepModel = steps.get(0)) != null) {
                    Intrinsics.checkNotNull(stepModel);
                    List<ActivationModel> stepActivations = stepModel.getStepActivations();
                    if (stepActivations != null) {
                        Intrinsics.checkNotNull(stepActivations);
                        for (ActivationModel activationModel : stepActivations) {
                            StepLocationModel stepLocationModel = stepModel.getStepLocationModel();
                            ActivationManager activationManager = INSTANCE;
                            String guideId = guideModel.getGuideId();
                            Intrinsics.checkNotNullExpressionValue(guideId, "getGuideId(...)");
                            Intrinsics.checkNotNull(activationModel);
                            activationManager.addGuideIdForActivationAndLocation(guideId, activationModel, stepLocationModel);
                        }
                    }
                }
            }
            handleRestart();
        } catch (Exception e) {
            String str = "GuideIds in restart payload\n";
            Iterator<T> it = guides.iterator();
            while (it.hasNext()) {
                str = str + ((GuideModel) it.next()).getGuideId() + " \n";
            }
            PendoLogger.e(e, e.getMessage(), str);
        }
    }

    public final void setGuideActivationHelper(GuideActivationHelper guideActivationHelper2) {
        Intrinsics.checkNotNullParameter(guideActivationHelper2, "<set-?>");
        guideActivationHelper = guideActivationHelper2;
    }

    public final void setIsInitedObservable(boolean isInited) {
        sIsInitedObservable.onNext(Boolean.valueOf(isInited));
    }

    public final void setTrackEventsBeforeSessionStart(ArrayList<m.a> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        trackEventsBeforeSessionStart = arrayList;
    }

    public final void start() {
    }
}
