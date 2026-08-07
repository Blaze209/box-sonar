package sdk.pendo.io.x6;

import android.app.Activity;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import sdk.pendo.io.Pendo;
import sdk.pendo.io.actions.ActivationManager;
import sdk.pendo.io.actions.ElementInfoAndViewRef;
import sdk.pendo.io.listeners.views.PendoDrawerListener;
import sdk.pendo.io.network.interfaces.GetAuthToken;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b<\u0010=J\u0010\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J\u0010\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0016J\u0016\u0010\u000b\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\u0013\u0010\u0010\u001a\u00020\fH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\nH\u0016J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016JP\u0010(\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\u001dH\u0016J#\u0010*\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020)H\u0096@ø\u0001\u0000¢\u0006\u0004\b*\u0010+J\u001e\u00100\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010,2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020-0,H\u0016J\b\u00102\u001a\u000201H\u0016J\b\u00103\u001a\u00020\nH\u0016J\u0012\u00106\u001a\u00020\n2\b\u00105\u001a\u0004\u0018\u000104H\u0016R\u0014\u00109\u001a\u00020\u00038\u0002X\u0082D¢\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010;\u001a\u00020\u00038\u0002X\u0082D¢\u0006\u0006\n\u0004\b:\u00108\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006>"}, d2 = {"Lsdk/pendo/io/x6/l;", "Lsdk/pendo/io/x6/d;", "Lsdk/pendo/io/k3/j;", "", "getScreenChangedNewScreenIdSubject", "getScreenLayoutChangedSameScreenIdSubject", "Ljava/lang/ref/WeakReference;", "Lsdk/pendo/io/listeners/views/PendoDrawerListener;", "getPendoDrawerListenerRef", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "setPendoDrawerListenerRef", "Lorg/json/JSONObject;", "getCurrentScreenData", "getPreviousScreenData", "getCurrentScreenId", "getScreenDataForCapture", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lorg/json/JSONArray;", "getViewTreeDataForCapture", "handleScreenChanges", "Lsdk/pendo/io/x6/g;", "triggerEvent", "onGlobalLayoutChangeEvent", "Landroid/app/Activity;", "activity", "onActivityPaused", "onActivityResumed", "onActivityDestroyed", "", "includePageViewTexts", "includeFeatureClickTexts", "includeFeatureClickNestedTexts", "includeRetroElementCompatibilityHashes", "isOldScreenIdFormat", "ignoreDynamicFragmentsInScrollView", "isRespondToScrollChangeEventsForScreenId", "", "globalLayoutChangeDebouncer", "shouldDetectClicksForAccessibility", "setPolicy", "Lsdk/pendo/io/t7/c;", "generateScreenshotBitmap", "(Landroid/app/Activity;Lsdk/pendo/io/t7/c;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lsdk/pendo/io/actions/ActivationManager$Trigger;", "triggerList", "Lsdk/pendo/io/actions/ElementInfoAndViewRef;", "getMatchingElementsIfExist", "Lsdk/pendo/io/x6/k;", "getScreenManagerPolicy", "onSessionEnd", "Lsdk/pendo/io/network/interfaces/GetAuthToken$GetAuthTokenResponse;", "response", "onGetAccessTokenResponseReceived", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Ljava/lang/String;", "TAG", "b", "EMPTY_STRING", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class l implements d {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final String TAG = "ScreenManagerTrackEventOnly";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final String EMPTY_STRING = "";

    @Override // sdk.pendo.io.x6.d
    public Object generateScreenshotBitmap(Activity activity, sdk.pendo.io.t7.c cVar, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // sdk.pendo.io.x6.d
    public JSONObject getCurrentScreenData() {
        return null;
    }

    @Override // sdk.pendo.io.x6.d
    /* JADX INFO: renamed from: getCurrentScreenId, reason: from getter */
    public String getEMPTY_STRING() {
        return this.EMPTY_STRING;
    }

    @Override // sdk.pendo.io.x6.d
    public List<ElementInfoAndViewRef> getMatchingElementsIfExist(List<ActivationManager.Trigger> triggerList) {
        Intrinsics.checkNotNullParameter(triggerList, "triggerList");
        return null;
    }

    @Override // sdk.pendo.io.x6.d
    public WeakReference<PendoDrawerListener> getPendoDrawerListenerRef() {
        return null;
    }

    @Override // sdk.pendo.io.x6.d
    public JSONObject getPreviousScreenData() {
        return null;
    }

    @Override // sdk.pendo.io.x6.d
    public sdk.pendo.io.k3.j<String> getScreenChangedNewScreenIdSubject() {
        return null;
    }

    @Override // sdk.pendo.io.x6.d
    public Object getScreenDataForCapture(Continuation<? super JSONObject> continuation) {
        return new JSONObject();
    }

    @Override // sdk.pendo.io.x6.d
    public sdk.pendo.io.k3.j<String> getScreenLayoutChangedSameScreenIdSubject() {
        return null;
    }

    @Override // sdk.pendo.io.x6.d
    public k getScreenManagerPolicy() {
        return new k(new Pendo.PendoOptions());
    }

    @Override // sdk.pendo.io.x6.d
    public JSONArray getViewTreeDataForCapture() {
        return new JSONArray();
    }

    @Override // sdk.pendo.io.x6.d
    public void handleScreenChanges() {
    }

    @Override // sdk.pendo.io.x6.d
    public void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // sdk.pendo.io.x6.d
    public void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // sdk.pendo.io.x6.d
    public void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // sdk.pendo.io.f6.d
    public void onGetAccessTokenResponseReceived(GetAuthToken.GetAuthTokenResponse response) {
    }

    @Override // sdk.pendo.io.x6.d
    public void onGlobalLayoutChangeEvent(g triggerEvent) {
        Intrinsics.checkNotNullParameter(triggerEvent, "triggerEvent");
    }

    @Override // sdk.pendo.io.x6.d
    public void onSessionEnd() {
    }

    @Override // sdk.pendo.io.x6.d
    public void setPendoDrawerListenerRef(WeakReference<PendoDrawerListener> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    @Override // sdk.pendo.io.x6.d
    public void setPolicy(boolean includePageViewTexts, boolean includeFeatureClickTexts, boolean includeFeatureClickNestedTexts, boolean includeRetroElementCompatibilityHashes, boolean isOldScreenIdFormat, boolean ignoreDynamicFragmentsInScrollView, boolean isRespondToScrollChangeEventsForScreenId, long globalLayoutChangeDebouncer, boolean shouldDetectClicksForAccessibility) {
    }
}
