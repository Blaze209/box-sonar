package sdk.pendo.io.actions;

import android.R;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.GuideModel;
import sdk.pendo.io.models.StepGuideModel;
import sdk.pendo.io.models.StepModel;
import sdk.pendo.io.o3.b;
import sdk.pendo.io.q3.e;
import sdk.pendo.io.r5.g;
import sdk.pendo.io.t4.a;
import sdk.pendo.io.utilities.AndroidUtils;
import sdk.pendo.io.views.GuideViewHolder;
import sdk.pendo.io.views.inserts.VisualGuideLayout;

/* JADX INFO: loaded from: classes4.dex */
public class VisualGuide extends VisualGuideBase {
    private static final String TAG = "VisualGuide";
    private b mLifecycleResumeSubscription;

    public VisualGuide(GuideModel guideModel, VisualGuideLifecycleListener visualGuideLifecycleListener, StepSeenManagerInterface stepSeenManagerInterface) {
        super(guideModel, visualGuideLifecycleListener);
        this.mVisualGuideType = VisualGuideBase.VisualGuideType.FULL_SCREEN;
        this.mStepSeenManager = stepSeenManagerInterface;
    }

    private boolean setRootView(View view) {
        if (view == null) {
            return false;
        }
        View viewFindViewById = view.findViewById(R.id.content);
        if (viewFindViewById instanceof ViewGroup) {
            view = viewFindViewById;
        }
        setRootView((ViewGroup) view);
        return true;
    }

    private void setViewHolder(View view) {
        if (view == null || view.getTag() == null || !(view.getTag() instanceof GuideViewHolder)) {
            PendoLogger.d("VisualGuide Not setting view holder.", new Object[0]);
        } else if (((GuideViewHolder) view.getTag()).mainLayout == null) {
            PendoLogger.d("VisualGuide No main layout, not updating the view holder.", new Object[0]);
        }
    }

    protected boolean inflateContent(Activity activity, int i) {
        setContainerView((ViewGroup) LayoutInflater.from(activity).inflate(this.mVisualGuideType.getLayoutId(), getRootView(), false));
        ViewGroup container = getContainer();
        StepModel stepModel = getSteps().get(i);
        if (container != null) {
            setViewHolder(((VisualGuideLayout) container.findViewById(sdk.pendo.io.R.id.insert_visual_container)).inflateView(stepModel.getStepContent(), container, getGuideId(), this.mStepSeenManager.getCurrentStepId(), this.mVisualGuideType));
            return true;
        }
        PendoLogger.w("VisualGuide Cannot show guide, container is null. Pendo ID: " + getGuideId(), new Object[0]);
        return false;
    }

    public final void init(Activity activity, g gVar, String str) {
        if (activity == null) {
            PendoLogger.d("VisualGuide Cannot show guide, activity is null. GuideId: " + getGuideId(), new Object[0]);
            return;
        }
        super.init(str, gVar);
        this.mActivity = new WeakReference<>(activity);
        int iIntValue = this.mStepSeenManager.getCurrentStepIndex().intValue();
        if (getSteps() == null || getSteps().get(iIntValue) == null) {
            PendoLogger.d("VisualGuide Cannot show guide, guide step is null. GuideId: " + getGuideId(), new Object[0]);
            return;
        }
        Window window = activity.getWindow();
        if (window == null) {
            PendoLogger.d("VisualGuide Cannot show guide, activity window is null. GuideId: " + getGuideId(), new Object[0]);
            return;
        }
        if (!setRootView(window.getDecorView())) {
            PendoLogger.d("VisualGuide Cannot show guide, rootView is null. GuideId: " + getGuideId(), new Object[0]);
            return;
        }
        initializeTimeoutCounter(iIntValue);
        if (inflateContent(activity, iIntValue)) {
            this.mLifecycleResumeSubscription = sdk.pendo.io.d6.b.a().a(activity, a.RESUME, AndroidUtils.a(activity), new e() { // from class: sdk.pendo.io.actions.VisualGuide$$ExternalSyntheticLambda0
                @Override // sdk.pendo.io.q3.e
                public final void accept(Object obj) {
                    this.f$0.m16681lambda$init$0$sdkpendoioactionsVisualGuide((a) obj);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$init$0$sdk-pendo-io-actions-VisualGuide, reason: not valid java name */
    /* synthetic */ void m16681lambda$init$0$sdkpendoioactionsVisualGuide(a aVar) {
        if (GuidesActionsManager.getInstance().wasGuideFullyDisplayedAfterAnimation(getGuideId())) {
            GuidesActionsManager.getInstance().removeGuideFullyDisplayedAfterAnimation(getGuideId());
        }
    }

    @Override // sdk.pendo.io.actions.VisualGuideBase
    final void onDestroy() {
        try {
            PendoLogger.d("VisualGuide Pendo destroying.", new Object[0]);
            b bVar = this.mLifecycleResumeSubscription;
            if (bVar != null) {
                bVar.dispose();
                this.mLifecycleResumeSubscription = null;
            }
            VisualGuideLifecycleListener visualGuideLifecycleListener = this.mListener;
            if (visualGuideLifecycleListener != null) {
                visualGuideLifecycleListener.onDestroy(getGuideId());
            }
            getAndSetShowing(false);
            setContainerView(null);
            setRootView((ViewGroup) null);
            WeakReference<Activity> weakReference = this.mActivity;
            if (weakReference != null && weakReference.get() != null) {
                this.mActivity.get().finish();
            }
            this.mActivity = null;
            this.mAdditionalInfo = new JSONObject();
            setTracker(null);
            unsubscribeSubscriptions();
        } catch (Exception e) {
            PendoLogger.e("VisualGuide OnDestroy with guideId: " + getGuideId() + " with error: " + e + " with message: " + e.getMessage(), new Object[0]);
        }
    }

    @Override // sdk.pendo.io.actions.VisualGuideBase
    public final boolean show() {
        PendoLogger.d("VisualGuide start showing guide", new Object[0]);
        try {
            setStartDuration(System.currentTimeMillis());
            StepGuideModel stepGuideModel = getStepGuideModel();
            if (stepGuideModel == null) {
                PendoLogger.d(TAG, "VisualGuide show() method aborted. The stepGuideModel was null");
                return false;
            }
            createVisualAnimationManager(stepGuideModel);
            this.mVisualAnimationManager.performShow(this.mActivity.get(), null);
            return true;
        } catch (Exception e) {
            PendoLogger.e("VisualGuide Can't show guide: " + e + " with message: " + e.getMessage(), new Object[0]);
            onDestroy();
            return false;
        }
    }

    public VisualGuide(StepGuideModel stepGuideModel, VisualGuideLifecycleListener visualGuideLifecycleListener, StepSeenManagerInterface stepSeenManagerInterface) {
        super(stepGuideModel, visualGuideLifecycleListener);
        this.mVisualGuideType = VisualGuideBase.VisualGuideType.FULL_SCREEN;
        this.mStepSeenManager = stepSeenManagerInterface;
    }
}
