package sdk.pendo.io.actions;

import java.util.List;
import sdk.pendo.io.k3.j;
import sdk.pendo.io.models.StepGuideModel;

/* JADX INFO: loaded from: classes4.dex */
public interface VisualGuidesManagerInterface extends VisualGuideLifecycleListener {
    void addVisualGuide(VisualGuideBase visualGuideBase);

    void clearAllVisualGuides();

    VisualGuide createVisualGuide(StepGuideModel stepGuideModel);

    j<Boolean> getIsAnyGuideDisplayedObservable();

    List<VisualGuideBase> getShowingGuides();

    VisualGuideBase getVisualGuide(String str);

    boolean isAnyGuideDisplayed();

    boolean isAnyGuideShowing();

    boolean isGuideShowing(String str);

    void removeShowingGuide();

    void removeVisualGuide(String str);

    void setIsAnyGuideDisplayed(boolean z);
}
