package sdk.pendo.io.actions;

import android.app.Activity;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;
import sdk.pendo.io.d1.a;
import sdk.pendo.io.d1.b;
import sdk.pendo.io.d1.g;
import sdk.pendo.io.d1.i;
import sdk.pendo.io.d1.l;
import sdk.pendo.io.d6.c;
import sdk.pendo.io.events.ConditionData;
import sdk.pendo.io.events.IdentificationData;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.GuideCandidate;
import sdk.pendo.io.models.GuideModel;
import sdk.pendo.io.models.StepLocationModel;
import sdk.pendo.io.s7.b1;
import sdk.pendo.io.s7.e1;
import sdk.pendo.io.s7.s;
import sdk.pendo.io.x6.d;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00100\u001a\u00020/¢\u0006\u0004\b6\u00107J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J$\u0010\u000b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0002J$\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\u0010\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\bJ\u001a\u0010\u0012\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\bJ\u001a\u0010\u0014\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\bJ\u000e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\bJ,\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0019\u001a\u00020\u00182\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u001aJ*\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010!\u001a\u00020 J\u0018\u0010#\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0016\u0010&\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0004J\u000e\u0010(\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u0004J\u000e\u0010)\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0004J\b\u0010*\u001a\u0004\u0018\u00010\u0004J2\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020 0-2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001a2\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rR\u0014\u00100\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u001c\u00104\u001a\n 3*\u0004\u0018\u000102028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105¨\u00068"}, d2 = {"Lsdk/pendo/io/actions/GuideActivationHelper;", "", "Lsdk/pendo/io/actions/ActivationManager$Trigger;", "trigger", "Lorg/json/JSONObject;", "objectData", "", "isGuideMatchesPageOrView", "", "objectDataKey", "selector", "isSelectorMatch", "featureSelector", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "getView", "isFeatureSelectorMatch", "pageSelector", "isPageSelectorMatch", "trackSelector", "isTrackSelectorMatch", "jsonString", "Lsdk/pendo/io/d1/b;", "jsonPathParse", "Lsdk/pendo/io/actions/ActivationManager$ActivationEvents;", "activationEvent", "", "guidesTriggers", "", "Lsdk/pendo/io/models/GuideCandidate;", "getGuidesMatchingCurrentActivationTrigger", "viewReference", "", "currentStepIndex", "getGuidesMatchingCurrentActivationTriggerForTooltips", "isGuideTriggerMatchSelector", "screenData", IdentificationData.SERIALIZED_NAME, "getObjectDataForScreenAndElement", "trackEventJSON", "getObjectDataForTrackEvent", "getObjectDataForScreen", "getCurrentScreenData", "guideCandidatesList", "guideTriggeredByView", "Lkotlin/Pair;", "showGuide", "Lsdk/pendo/io/x6/d;", "screenManager", "Lsdk/pendo/io/x6/d;", "Lsdk/pendo/io/d1/a;", "kotlin.jvm.PlatformType", "conf", "Lsdk/pendo/io/d1/a;", "<init>", "(Lsdk/pendo/io/x6/d;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class GuideActivationHelper {
    private final a conf;
    private final d screenManager;

    public GuideActivationHelper(d screenManager) {
        Intrinsics.checkNotNullParameter(screenManager, "screenManager");
        this.screenManager = screenManager;
        this.conf = a.b().a(i.DEFAULT_PATH_LEAF_TO_NULL, i.SUPPRESS_EXCEPTIONS);
    }

    private final WeakReference<View> getView(String featureSelector, JSONObject objectData) {
        WeakReference<View> weakReference;
        if (objectData != null && featureSelector != null) {
            if (!objectData.has("retroElementInfo")) {
                PendoLogger.w("objectData has no retroElementInfo", new Object[0]);
                return null;
            }
            sdk.pendo.io.r1.a aVar = (sdk.pendo.io.r1.a) jsonPathParse(objectData.get("retroElementInfo").toString()).a(featureSelector, new l[0]);
            if (aVar != null && !aVar.isEmpty()) {
                IdentificationData identificationDataMakeFromJson = IdentificationData.makeFromJson(aVar.a());
                Activity activityA = c.h().a();
                if (activityA != null) {
                    e1.a aVarA = s.a.a(b1.a, activityA, false, 2, null);
                    View viewA = sdk.pendo.io.c6.a.a((aVarA == null || (weakReference = aVarA.a) == null) ? null : weakReference.get(), identificationDataMakeFromJson, true, (ConditionData) null);
                    if (viewA != null) {
                        return new WeakReference<>(viewA);
                    }
                }
            }
        }
        return null;
    }

    private final boolean isGuideMatchesPageOrView(ActivationManager.Trigger trigger, JSONObject objectData) {
        if (!isPageSelectorMatch(objectData, trigger.getActivation().getPageSelector())) {
            return false;
        }
        StepLocationModel location = trigger.getLocation();
        String featureSelector = location != null ? location.getFeatureSelector() : null;
        if (featureSelector == null || StringsKt.isBlank(featureSelector)) {
            return true;
        }
        StepLocationModel location2 = trigger.getLocation();
        return isFeatureSelectorMatch(objectData, location2 != null ? location2.getFeatureSelector() : null);
    }

    private final boolean isSelectorMatch(JSONObject objectData, String objectDataKey, String selector) {
        if (objectData == null || !objectData.has(objectDataKey) || selector == null || selector.length() == 0) {
            PendoLogger.i("isSelectorMatch with " + objectDataKey + " key -> objectData or key or trackSelector are not exist", new Object[0]);
            return false;
        }
        sdk.pendo.io.r1.a aVar = (sdk.pendo.io.r1.a) jsonPathParse(objectData.get(objectDataKey).toString()).a(selector, new l[0]);
        return !(aVar == null || aVar.isEmpty());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Pair showGuide$default(GuideActivationHelper guideActivationHelper, List list, WeakReference weakReference, int i, Object obj) {
        if ((i & 2) != 0) {
            weakReference = null;
        }
        return guideActivationHelper.showGuide(list, weakReference);
    }

    public final JSONObject getCurrentScreenData() {
        return this.screenManager.getCurrentScreenData();
    }

    public final Set<GuideCandidate> getGuidesMatchingCurrentActivationTrigger(JSONObject objectData, ActivationManager.ActivationEvents activationEvent, List<ActivationManager.Trigger> guidesTriggers) {
        Intrinsics.checkNotNullParameter(activationEvent, "activationEvent");
        Intrinsics.checkNotNullParameter(guidesTriggers, "guidesTriggers");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList<ActivationManager.Trigger> arrayList = new ArrayList();
        for (Object obj : guidesTriggers) {
            String event = ((ActivationManager.Trigger) obj).getActivation().getEvent();
            if (event != null && event.length() != 0) {
                Intrinsics.checkNotNull(event);
                if (event.contentEquals(activationEvent.getActivationEvent()) || event.contentEquals(ActivationManager.ActivationEvents.ANY.getActivationEvent())) {
                    arrayList.add(obj);
                }
            }
        }
        for (ActivationManager.Trigger trigger : arrayList) {
            if (isGuideTriggerMatchSelector(trigger, objectData)) {
                for (String str : trigger.getGuideIds()) {
                    ActivationManager.ActivationEvents activationEventsFromString = ActivationManager.ActivationEvents.INSTANCE.fromString(trigger.getActivation().getEvent());
                    if (activationEventsFromString != null) {
                        GuideModel guide = GuidesManager.INSTANCE.getGuide(str);
                        if (guide != null) {
                            Integer currentStepIndex = StepSeenManager.getInstance().getCurrentStepIndex();
                            Intrinsics.checkNotNull(currentStepIndex);
                            int iIntValue = currentStepIndex.intValue();
                            StepLocationModel location = trigger.getLocation();
                            linkedHashSet.add(new GuideCandidate(guide, iIntValue, activationEventsFromString, getView(location != null ? location.getFeatureSelector() : null, objectData)));
                        } else {
                            PendoLogger.w("GuideActivationHelper", "getGuidesMatchingCurrentActivationTrigger: guide not found for id: " + str);
                        }
                    }
                }
            }
        }
        return linkedHashSet;
    }

    public final Set<GuideCandidate> getGuidesMatchingCurrentActivationTriggerForTooltips(ActivationManager.Trigger trigger, WeakReference<View> viewReference, int currentStepIndex) {
        Intrinsics.checkNotNullParameter(trigger, "trigger");
        Intrinsics.checkNotNullParameter(viewReference, "viewReference");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (String str : trigger.getGuideIds()) {
            ActivationManager.ActivationEvents activationEventsFromString = ActivationManager.ActivationEvents.INSTANCE.fromString(trigger.getActivation().getEvent());
            if (activationEventsFromString != null) {
                GuideModel guide = GuidesManager.INSTANCE.getGuide(str);
                if (guide != null) {
                    linkedHashSet.add(new GuideCandidate(guide, currentStepIndex, activationEventsFromString, viewReference));
                } else {
                    PendoLogger.w("GuideActivationHelper", "getGuidesMatchingCurrentActivationTriggerForTooltips: guide not found for id: " + str);
                }
            }
        }
        return linkedHashSet;
    }

    public final JSONObject getObjectDataForScreen(JSONObject screenData) throws JSONException {
        Intrinsics.checkNotNullParameter(screenData, "screenData");
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(ActivationManager.SCREEN_DATA_KEY, screenData);
        jSONObject.put(ActivationManager.SCREEN_DATA_KEY, jSONObject2);
        return jSONObject;
    }

    public final JSONObject getObjectDataForScreenAndElement(JSONObject screenData, JSONObject elementInfo) throws JSONException {
        Intrinsics.checkNotNullParameter(screenData, "screenData");
        Intrinsics.checkNotNullParameter(elementInfo, "elementInfo");
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        jSONObject2.put(ActivationManager.SCREEN_DATA_KEY, screenData);
        jSONObject.put(ActivationManager.SCREEN_DATA_KEY, jSONObject2);
        jSONObject3.put("retroElementInfo", elementInfo);
        jSONObject.put("retroElementInfo", jSONObject3);
        return jSONObject;
    }

    public final JSONObject getObjectDataForTrackEvent(JSONObject trackEventJSON) throws JSONException {
        Intrinsics.checkNotNullParameter(trackEventJSON, "trackEventJSON");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(ActivationManager.TRACK_EVENT_KEY, trackEventJSON);
        return jSONObject;
    }

    public final boolean isFeatureSelectorMatch(JSONObject objectData, String featureSelector) {
        return isSelectorMatch(objectData, "retroElementInfo", featureSelector);
    }

    public final boolean isGuideTriggerMatchSelector(ActivationManager.Trigger trigger, JSONObject objectData) {
        Intrinsics.checkNotNullParameter(trigger, "trigger");
        String event = trigger.getActivation().getEvent();
        if (Intrinsics.areEqual(event, ActivationManager.ActivationEvents.APP_LAUNCH.getActivationEvent()) ? true : Intrinsics.areEqual(event, ActivationManager.ActivationEvents.ANY.getActivationEvent())) {
            return true;
        }
        if (Intrinsics.areEqual(event, ActivationManager.ActivationEvents.TRACK_EVENT.getActivationEvent())) {
            return isTrackSelectorMatch(objectData, trigger.getActivation().getTrackSelector());
        }
        if (Intrinsics.areEqual(event, ActivationManager.ActivationEvents.VIEW.getActivationEvent())) {
            return isGuideMatchesPageOrView(trigger, objectData);
        }
        if (Intrinsics.areEqual(event, ActivationManager.ActivationEvents.CLICK.getActivationEvent())) {
            return isPageSelectorMatch(objectData, trigger.getActivation().getPageSelector()) && isFeatureSelectorMatch(objectData, trigger.getActivation().getFeatureSelector());
        }
        PendoLogger.i("isStepTriggerMatch -> unknown activation event", new Object[0]);
        return false;
    }

    public final boolean isPageSelectorMatch(JSONObject objectData, String pageSelector) {
        return isSelectorMatch(objectData, ActivationManager.SCREEN_DATA_KEY, pageSelector);
    }

    public final boolean isTrackSelectorMatch(JSONObject objectData, String trackSelector) {
        return isSelectorMatch(objectData, ActivationManager.TRACK_EVENT_KEY, trackSelector);
    }

    public final b jsonPathParse(String jsonString) {
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        b bVarA = g.a(this.conf).a(jsonString);
        Intrinsics.checkNotNullExpressionValue(bVarA, "parse(...)");
        return bVarA;
    }

    public final Pair<String, Integer> showGuide(List<GuideCandidate> guideCandidatesList, WeakReference<View> guideTriggeredByView) {
        Intrinsics.checkNotNullParameter(guideCandidatesList, "guideCandidatesList");
        return !guideCandidatesList.isEmpty() ? GuidesManager.INSTANCE.show(guideCandidatesList, guideTriggeredByView) : TuplesKt.to("", -1);
    }
}
