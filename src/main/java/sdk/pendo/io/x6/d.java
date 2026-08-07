package sdk.pendo.io.x6;

import android.app.Activity;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.json.JSONArray;
import org.json.JSONObject;
import sdk.pendo.io.actions.ActivationManager;
import sdk.pendo.io.actions.ElementInfoAndViewRef;
import sdk.pendo.io.listeners.views.PendoDrawerListener;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&JP\u0010\u0013\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\bH&J\u0010\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H&J\u0010\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H&J\u0010\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018H&J\u0016\u0010\u001c\u001a\u00020\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H&J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001dH&J\n\u0010\u001f\u001a\u0004\u0018\u00010\u001dH&J\b\u0010 \u001a\u00020\u0015H&J\u0013\u0010!\u001a\u00020\u001dH¦@ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\b\u0010$\u001a\u00020#H&J\b\u0010%\u001a\u00020\u0004H&J\u0010\u0010(\u001a\u00020\u00042\u0006\u0010'\u001a\u00020&H&J#\u0010*\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020)H¦@ø\u0001\u0000¢\u0006\u0004\b*\u0010+J\u001e\u00100\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010,2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020-0,H&J\b\u00102\u001a\u000201H&J\b\u00103\u001a\u00020\u0004H&\u0082\u0002\u0004\n\u0002\b\u0019¨\u00064"}, d2 = {"Lsdk/pendo/io/x6/d;", "Lsdk/pendo/io/f6/d;", "Landroid/app/Activity;", "activity", "", "onActivityResumed", "onActivityPaused", "onActivityDestroyed", "", "includePageViewTexts", "includeFeatureClickTexts", "includeFeatureClickNestedTexts", "includeRetroElementCompatibilityHashes", "isOldScreenIdFormat", "ignoreDynamicFragmentsInScrollView", "isRespondToScrollChangeEventsForScreenId", "", "globalLayoutChangeDebouncer", "shouldDetectClicksForAccessibility", "setPolicy", "Lsdk/pendo/io/k3/j;", "", "getScreenChangedNewScreenIdSubject", "getScreenLayoutChangedSameScreenIdSubject", "Ljava/lang/ref/WeakReference;", "Lsdk/pendo/io/listeners/views/PendoDrawerListener;", "getPendoDrawerListenerRef", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setPendoDrawerListenerRef", "Lorg/json/JSONObject;", "getCurrentScreenData", "getPreviousScreenData", "getCurrentScreenId", "getScreenDataForCapture", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lorg/json/JSONArray;", "getViewTreeDataForCapture", "handleScreenChanges", "Lsdk/pendo/io/x6/g;", "triggerEvent", "onGlobalLayoutChangeEvent", "Lsdk/pendo/io/t7/c;", "generateScreenshotBitmap", "(Landroid/app/Activity;Lsdk/pendo/io/t7/c;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lsdk/pendo/io/actions/ActivationManager$Trigger;", "triggerList", "Lsdk/pendo/io/actions/ElementInfoAndViewRef;", "getMatchingElementsIfExist", "Lsdk/pendo/io/x6/k;", "getScreenManagerPolicy", "onSessionEnd", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public interface d extends sdk.pendo.io.f6.d {
    Object generateScreenshotBitmap(Activity activity, sdk.pendo.io.t7.c cVar, Continuation<? super Unit> continuation);

    JSONObject getCurrentScreenData();

    String getCurrentScreenId();

    List<ElementInfoAndViewRef> getMatchingElementsIfExist(List<ActivationManager.Trigger> triggerList);

    WeakReference<PendoDrawerListener> getPendoDrawerListenerRef();

    JSONObject getPreviousScreenData();

    sdk.pendo.io.k3.j<String> getScreenChangedNewScreenIdSubject();

    Object getScreenDataForCapture(Continuation<? super JSONObject> continuation);

    sdk.pendo.io.k3.j<String> getScreenLayoutChangedSameScreenIdSubject();

    k getScreenManagerPolicy();

    JSONArray getViewTreeDataForCapture();

    void handleScreenChanges();

    void onActivityDestroyed(Activity activity);

    void onActivityPaused(Activity activity);

    void onActivityResumed(Activity activity);

    void onGlobalLayoutChangeEvent(g triggerEvent);

    void onSessionEnd();

    void setPendoDrawerListenerRef(WeakReference<PendoDrawerListener> listener);

    void setPolicy(boolean includePageViewTexts, boolean includeFeatureClickTexts, boolean includeFeatureClickNestedTexts, boolean includeRetroElementCompatibilityHashes, boolean isOldScreenIdFormat, boolean ignoreDynamicFragmentsInScrollView, boolean isRespondToScrollChangeEventsForScreenId, long globalLayoutChangeDebouncer, boolean shouldDetectClicksForAccessibility);
}
