package sdk.pendo.io.actions;

import android.view.View;
import com.box.android.observability.DiagnosisParams;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import org.json.JSONObject;
import sdk.pendo.io.models.GuideCandidate;
import sdk.pendo.io.models.GuideModel;
import sdk.pendo.io.models.StepModel;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bH&J\b\u0010\t\u001a\u00020\u0003H&J$\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH&J\u001a\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&J\b\u0010\u0015\u001a\u00020\u0003H&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\rH&J\u0016\u0010\u0018\u001a\u00020\u00032\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH&J\u0016\u0010\u001c\u001a\u00020\u00032\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH&J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u000bH&J\u0016\u0010\u001f\u001a\u00020\u00032\f\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u0005H&¨\u0006\""}, d2 = {"Lsdk/pendo/io/actions/IActivationManager;", "", DiagnosisParams.CLEAR_ON_LOGOUT, "", "getGuidesTriggers", "", "Lsdk/pendo/io/actions/ActivationManager$Trigger;", "getTriggersForStep", "", "handleAnyActivation", "handleClick", "", "viewElementInfo", "Lorg/json/JSONObject;", "guideTriggeredByView", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "handleLaunchGuideFromGuide", "guideId", "stepModel", "Lsdk/pendo/io/models/StepModel;", "handleScreenView", "handleTrack", "trackEventJSON", "populateGuideSetWithViewActivation", "guidesSetWithViewActivation", "", "Lsdk/pendo/io/models/GuideCandidate;", "populateGuidesSetWithTrackActivationBeforeSessionStart", "guidesSetWithTrackActivation", "removeGuideIdFromTriggers", "restartWithGuides", "guides", "Lsdk/pendo/io/models/GuideModel;", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface IActivationManager {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ String handleClick$default(IActivationManager iActivationManager, JSONObject jSONObject, WeakReference weakReference, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handleClick");
            }
            if ((i & 2) != 0) {
                weakReference = null;
            }
            return iActivationManager.handleClick(jSONObject, weakReference);
        }
    }

    void clear();

    List<ActivationManager.Trigger> getGuidesTriggers();

    List<ActivationManager.Trigger> getTriggersForStep();

    void handleAnyActivation();

    String handleClick(JSONObject viewElementInfo, WeakReference<View> guideTriggeredByView);

    void handleLaunchGuideFromGuide(String guideId, StepModel stepModel);

    void handleScreenView();

    void handleTrack(JSONObject trackEventJSON);

    void populateGuideSetWithViewActivation(Set<GuideCandidate> guidesSetWithViewActivation);

    void populateGuidesSetWithTrackActivationBeforeSessionStart(Set<GuideCandidate> guidesSetWithTrackActivation);

    void removeGuideIdFromTriggers(String guideId);

    void restartWithGuides(List<? extends GuideModel> guides);
}
