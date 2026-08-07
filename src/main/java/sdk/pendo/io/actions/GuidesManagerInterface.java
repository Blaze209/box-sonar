package sdk.pendo.io.actions;

import android.view.View;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import sdk.pendo.io.models.GuideCandidate;
import sdk.pendo.io.models.GuideModel;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&J2\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\n2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H&J\b\u0010\u0014\u001a\u00020\u0003H&J$\u0010\u0015\u001a\u00020\u00032\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&¨\u0006\u0018"}, d2 = {"Lsdk/pendo/io/actions/GuidesManagerInterface;", "", "addGuideToGuidesMap", "", "guideModel", "Lsdk/pendo/io/models/GuideModel;", "getGuide", "guideId", "", "getGuideActions", "", "Lsdk/pendo/io/actions/PendoCommand;", "show", "Lkotlin/Pair;", "", "guideCandidates", "Lsdk/pendo/io/models/GuideCandidate;", "guideTriggeredByView", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "showPreview", "storeAndActivateSessionGuides", "guideModelList", "guideActions", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface GuidesManagerInterface {
    void addGuideToGuidesMap(GuideModel guideModel);

    GuideModel getGuide(String guideId);

    List<PendoCommand> getGuideActions();

    Pair<String, Integer> show(List<GuideCandidate> guideCandidates, WeakReference<View> guideTriggeredByView);

    void showPreview();

    void storeAndActivateSessionGuides(List<? extends GuideModel> guideModelList, List<PendoCommand> guideActions);
}
