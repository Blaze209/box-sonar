package sdk.pendo.io.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sdk.pendo.io.j4.a;
import sdk.pendo.io.k3.j;
import sdk.pendo.io.models.GuideModel;
import sdk.pendo.io.models.StepGuideModel;

/* JADX INFO: loaded from: classes4.dex */
public class VisualGuidesManager implements VisualGuidesManagerInterface {
    private static volatile VisualGuidesManager INSTANCE;
    private Map<String, VisualGuideBase> mVisualGuides = new HashMap();
    private a<Boolean> mIsAnyGuideDisplayedObservable = a.b(Boolean.FALSE);

    private VisualGuidesManager() {
    }

    public static synchronized VisualGuidesManagerInterface getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new VisualGuidesManager();
        }
        return INSTANCE;
    }

    @Override // sdk.pendo.io.actions.VisualGuidesManagerInterface
    public synchronized void addVisualGuide(VisualGuideBase visualGuideBase) {
        this.mVisualGuides.put(visualGuideBase.getGuideId(), visualGuideBase);
    }

    @Override // sdk.pendo.io.actions.VisualGuidesManagerInterface
    public synchronized void clearAllVisualGuides() {
        this.mVisualGuides = new HashMap();
    }

    @Override // sdk.pendo.io.actions.VisualGuidesManagerInterface
    public VisualGuide createVisualGuide(StepGuideModel stepGuideModel) {
        return new VisualGuide(stepGuideModel, this, StepSeenManager.getInstance());
    }

    @Override // sdk.pendo.io.actions.VisualGuidesManagerInterface
    public j<Boolean> getIsAnyGuideDisplayedObservable() {
        return this.mIsAnyGuideDisplayedObservable;
    }

    @Override // sdk.pendo.io.actions.VisualGuidesManagerInterface
    public List<VisualGuideBase> getShowingGuides() {
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, VisualGuideBase>> it = this.mVisualGuides.entrySet().iterator();
        while (it.hasNext()) {
            VisualGuideBase value = it.next().getValue();
            if (value.isShowing()) {
                arrayList.add(value);
            }
        }
        return arrayList;
    }

    @Override // sdk.pendo.io.actions.VisualGuidesManagerInterface
    public final synchronized VisualGuideBase getVisualGuide(String str) {
        return this.mVisualGuides.get(str);
    }

    @Override // sdk.pendo.io.actions.VisualGuidesManagerInterface
    public boolean isAnyGuideDisplayed() {
        return this.mIsAnyGuideDisplayedObservable.n().booleanValue();
    }

    @Override // sdk.pendo.io.actions.VisualGuidesManagerInterface
    public synchronized boolean isAnyGuideShowing() {
        return !getShowingGuides().isEmpty();
    }

    @Override // sdk.pendo.io.actions.VisualGuidesManagerInterface
    public boolean isGuideShowing(String str) {
        Iterator<VisualGuideBase> it = getShowingGuides().iterator();
        while (it.hasNext()) {
            if (it.next().getGuideId().equals(str)) {
                return true;
            }
        }
        return false;
    }

    @Override // sdk.pendo.io.actions.VisualGuideLifecycleListener
    public void onCreate(VisualGuideBase visualGuideBase) {
        addVisualGuide(visualGuideBase);
    }

    @Override // sdk.pendo.io.actions.VisualGuideLifecycleListener
    public void onDestroy(String str) {
        removeVisualGuide(str);
    }

    @Override // sdk.pendo.io.actions.VisualGuidesManagerInterface
    public synchronized void removeShowingGuide() {
        for (VisualGuideBase visualGuideBase : getShowingGuides()) {
            if (visualGuideBase instanceof ToolTipVisualGuide) {
                ((ToolTipVisualGuide) visualGuideBase).removeOnMainThread();
            }
        }
    }

    @Override // sdk.pendo.io.actions.VisualGuidesManagerInterface
    public synchronized void removeVisualGuide(String str) {
        GuideModel guide = GuidesManager.INSTANCE.getGuide(str);
        if (guide != null && guide.getSteps().size() - 1 == StepSeenManager.getInstance().getCurrentStepIndex().intValue()) {
            this.mVisualGuides.remove(str);
        }
    }

    @Override // sdk.pendo.io.actions.VisualGuidesManagerInterface
    public void setIsAnyGuideDisplayed(boolean z) {
        this.mIsAnyGuideDisplayedObservable.onNext(Boolean.valueOf(z));
    }
}
