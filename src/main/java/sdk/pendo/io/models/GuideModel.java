package sdk.pendo.io.models;

import android.text.TextUtils;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import io.split.android.grammar.Treatments;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.apache.commons.logging.LogFactory;
import sdk.pendo.io.a0.f;
import sdk.pendo.io.a0.i;
import sdk.pendo.io.a0.l;
import sdk.pendo.io.actions.GuideActionConfiguration;
import sdk.pendo.io.actions.VisualGuidesManager;
import sdk.pendo.io.b0.c;
import sdk.pendo.io.j4.a;
import sdk.pendo.io.k3.j;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.r5.m;

/* JADX INFO: loaded from: classes4.dex */
public class GuideModel implements Comparable<GuideModel> {
    private static final int COMPARED_TO_ACTION = -1;
    private static final String COULD_NOT_DELIVER_STEP_MESSAGE = "getGuideStepIndex, could not deliver stepId: %s, of the guideId: %s";
    public static final String DEFAULT_GUIDE_STEP_ID = "";
    public static final int FIRST_GUIDES_CHILD_INDEX = 0;
    public static final String FULLSCREEN_WIDGET_NAME = "Fullscreen";
    public static final String INVALID_GUIDE_ID = "";
    public static final String NO_ID = "";
    public static final String PREVIEW_GUIDE_ID = "PREVIEW_GUIDE_ID";
    public static final String PREVIEW_GUIDE_NAME = "DEFAULT_NAME";
    public static final String PREVIEW_GUIDE_STEP_ID = "PREVIEW_GUIDE_STEP_ID";
    private static final String TAG = "GuideModel";
    private static final int THIS_ACTION = 1;
    public static final String TOOLTIP_WIDGET_NAME = "Tooltip";

    @c("activations")
    private f mActivations;

    @c(RemoteConfigConstants.RequestFieldKey.APP_ID)
    private String mAppId;

    @c("carousels")
    private f mCarousels;

    @c("contentUrl")
    private String mContentUrl;

    @c(Treatments.CONTROL)
    private Boolean mControl;

    @c("configuration")
    private GeneralGuidesConfiguration mGeneralGuideConfiguration;

    @c("guideId")
    private String mGuideId;

    @c("language")
    private String mGuideLanguage;

    @c("guideName")
    private String mGuideName;
    public final transient a<GuideStatus> mGuideStatus;

    @c(LogFactory.PRIORITY_KEY)
    private int mPriority;

    @c("recurrence")
    private long mRecurrence;

    @c("steps")
    private List<StepModel> mSteps;
    private m mTracker;

    public enum VisualGuideType {
        TOOLTIP(GuideModel.TOOLTIP_WIDGET_NAME),
        FULLSCREEN(GuideModel.FULLSCREEN_WIDGET_NAME);

        public final String widgetName;

        VisualGuideType(String str) {
            this.widgetName = str;
        }
    }

    public GuideModel() {
        this.mGeneralGuideConfiguration = new GeneralGuidesConfiguration();
        this.mControl = Boolean.FALSE;
        this.mContentUrl = null;
        this.mGuideLanguage = "";
        this.mGuideStatus = a.b(new ContentNotReady());
    }

    public static GuideModel guideFactory(StepGuideModel stepGuideModel) {
        return VisualGuidesManager.getInstance().createVisualGuide(stepGuideModel);
    }

    private boolean isValidStepIndex(int i, List<StepModel> list) {
        return i >= 0 && i < list.size();
    }

    public void capOut() {
        this.mGeneralGuideConfiguration.getCapping().setMaxSessionImpressions(0);
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof GuideModel) && getGuideId().equals(((GuideModel) obj).getGuideId());
        }
        return true;
    }

    public f getActivations() {
        return this.mActivations;
    }

    public String getAppId() {
        return this.mAppId;
    }

    public l getCarouselIndicatorsLayoutView(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator<i> it = this.mCarousels.iterator();
        while (it.hasNext()) {
            l lVarE = it.next().e();
            if (str.equals(lVarE.a("carouselId").g())) {
                l lVarE2 = lVarE.b(GuideActionConfiguration.GUIDE_BUILDING_BLOCK_VIEWS).a(0).e();
                l lVar = lVarE2;
                while (lVarE2 != null && !lVarE2.a("widget").g().equals("CarouselIndicatorWrapper")) {
                    lVar = lVarE2;
                    lVarE2 = lVarE2.b(GuideActionConfiguration.GUIDE_BUILDING_BLOCK_VIEWS).a(0).e();
                }
                return lVar;
            }
        }
        return null;
    }

    public f getCarousels() {
        return this.mCarousels;
    }

    public String getContentUrl() {
        return this.mContentUrl;
    }

    public GeneralGuidesConfiguration getGeneralGuideConfiguration() {
        return this.mGeneralGuideConfiguration;
    }

    public String getGuideId() {
        String str = this.mGuideId;
        return str != null ? str : "";
    }

    public String getGuideLanguage() {
        return this.mGuideLanguage;
    }

    public String getGuideName() {
        return this.mGuideName;
    }

    public String getGuideStepCarouselId(String str) {
        StepModel guideStepModel;
        if (TextUtils.isEmpty(str) || (guideStepModel = getGuideStepModel(str)) == null || guideStepModel.getStepContentModel() == null) {
            return null;
        }
        return guideStepModel.getStepContentModel().getCarouselId();
    }

    public String getGuideStepId(int i) {
        StepContentModel stepContentModel = getStepContentModel(i);
        return stepContentModel != null ? stepContentModel.getGuideStepId() : "";
    }

    public Integer getGuideStepIndex(String str) {
        String guideStepId;
        try {
            List<StepModel> steps = getSteps();
            if (steps == null) {
                return null;
            }
            for (int i = 0; i < steps.size(); i++) {
                StepModel stepModel = steps.get(i);
                StepContentModel stepContentModel = stepModel != null ? stepModel.getStepContentModel() : null;
                if (stepContentModel != null && (guideStepId = stepContentModel.getGuideStepId()) != null && guideStepId.equals(str)) {
                    return Integer.valueOf(i);
                }
            }
            PendoLogger.e(TAG + String.format(COULD_NOT_DELIVER_STEP_MESSAGE, str, getGuideId()), new Object[0]);
            return null;
        } catch (Exception e) {
            PendoLogger.e("GuideModelgetGuideStepIndex with error: " + e + String.format(COULD_NOT_DELIVER_STEP_MESSAGE, str, getGuideId()) + " with message: " + e.getMessage(), new Object[0]);
            return null;
        }
    }

    public StepGuideModel getGuideStepModel(int i) {
        List<StepModel> steps = getSteps();
        if (steps == null || !isValidStepIndex(i, steps)) {
            return null;
        }
        return steps.get(i).getStepContent();
    }

    public List<String> getImages() {
        if (this.mControl.booleanValue()) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<StepModel> it = this.mSteps.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().getImages());
        }
        return arrayList;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public long getRecurrence() {
        return this.mRecurrence;
    }

    public j<GuideStatus> getStatus() {
        return this.mGuideStatus;
    }

    public GuideStatus getStatusValue() {
        return this.mGuideStatus.o() ? new Completed() : this.mGuideStatus.n();
    }

    public StepContentModel getStepContentModel(int i) {
        List<StepModel> steps = getSteps();
        if (steps == null) {
            PendoLogger.d("GuideModel Guide steps were null in guide " + getGuideId(), new Object[0]);
            return null;
        }
        if (i >= 0 && i < steps.size()) {
            return steps.get(i).getStepContentModel();
        }
        PendoLogger.d("GuideModel step index in guide: " + getGuideId() + " was: " + i + " there were " + steps.size() + "steps", new Object[0]);
        return null;
    }

    public List<StepModel> getSteps() {
        return this.mSteps;
    }

    public final m getTracker() {
        return this.mTracker;
    }

    public final int hashCode() {
        return getGuideId().hashCode();
    }

    public boolean isCompleted() {
        return this.mGuideStatus.o() || this.mGuideStatus.n().getStatus() == GuideStatus.getGUIDE_SHOWN();
    }

    public boolean isInControlGroup() {
        return this.mControl.booleanValue();
    }

    public boolean isReady() {
        return this.mGuideStatus.n().getStatus() == GuideStatus.getREADY();
    }

    public void setActivations(f fVar) {
        this.mActivations = fVar;
    }

    public void setAppId(String str) {
        this.mAppId = str;
    }

    public void setCancelled() {
        PendoLogger.i("GuideModel Guide " + this.mGuideId + " setCancelled", new Object[0]);
        this.mGuideStatus.onNext(new Cancelled());
    }

    public void setCarousels(f fVar) {
        this.mCarousels = fVar;
    }

    public void setContentError() {
        PendoLogger.d("GuideModel Guide " + this.mGuideId + " setContentError", new Object[0]);
        this.mGuideStatus.onNext(new ContentError());
    }

    public void setContentNotReady() {
        PendoLogger.d("GuideModel Guide " + this.mGuideId + " setContentNotReady", new Object[0]);
        this.mGuideStatus.onNext(new ContentNotReady());
    }

    public void setContentReady() {
        PendoLogger.d("GuideModel Guide " + this.mGuideId + " setContentReady", new Object[0]);
        this.mGuideStatus.onNext(new ContentReady());
    }

    public void setGeneralGuideConfiguration(GeneralGuidesConfiguration generalGuidesConfiguration) {
        this.mGeneralGuideConfiguration = generalGuidesConfiguration;
    }

    public void setGuideId(String str) {
        this.mGuideId = str;
    }

    public void setGuideLanguage(String str) {
        this.mGuideLanguage = str;
    }

    public void setGuideName(String str) {
        this.mGuideName = str;
    }

    public void setGuideShown() {
        PendoLogger.i("GuideModel Guide " + this.mGuideId + " setGuideShown", new Object[0]);
        this.mGuideStatus.onNext(new GuideShown());
    }

    public void setImageError() {
        PendoLogger.i("GuideModel Guide " + this.mGuideId + " setImageError", new Object[0]);
        this.mGuideStatus.onNext(new ImageError());
    }

    public void setImageReady() {
        PendoLogger.i("GuideModel Guide " + this.mGuideId + " setImageReady", new Object[0]);
        setReady();
    }

    public void setIsInControlGroup(boolean z) {
        this.mControl = Boolean.valueOf(z);
    }

    public void setNeedsImages() {
        this.mGuideStatus.onNext(new ImageNotReady());
    }

    public void setPriority(int i) {
        this.mPriority = i;
    }

    public void setReady() {
        PendoLogger.d("GuideModel Guide " + this.mGuideId + " setReady", new Object[0]);
        this.mGuideStatus.onNext(new Ready());
    }

    public void setRecurrence(long j) {
        this.mRecurrence = j;
    }

    public void setSteps(List<StepModel> list) {
        this.mSteps = list;
    }

    public final void setTracker(m mVar) {
        this.mTracker = mVar;
    }

    public void terminateStatus() {
        PendoLogger.d("GuideModel Guide " + this.mGuideId + " terminateStatus", new Object[0]);
        this.mGuideStatus.onComplete();
    }

    public final String toString() {
        return "Guide Model: {[guideId = " + getGuideId() + "], [appId = " + (getAppId() != null ? getAppId() : "") + "], [priority = " + getPriority() + "], [activation = " + (getActivations() != null ? getActivations().toString() : "") + "], [steps = " + (getSteps() != null ? getSteps().toString() : "") + "], [language = " + getGuideLanguage() + "}";
    }

    protected GuideModel(GuideModel guideModel) {
        this.mGeneralGuideConfiguration = new GeneralGuidesConfiguration();
        this.mControl = Boolean.FALSE;
        this.mContentUrl = null;
        this.mGuideLanguage = "";
        a<GuideStatus> aVarB = a.b(new ContentNotReady());
        this.mGuideStatus = aVarB;
        if (guideModel != null) {
            setActivations(guideModel.getActivations());
            setAppId(guideModel.getAppId());
            setGuideId(guideModel.getGuideId());
            setPriority(guideModel.getPriority());
            setSteps(guideModel.getSteps());
            setGuideName(guideModel.getGuideName());
            setGeneralGuideConfiguration(guideModel.getGeneralGuideConfiguration());
            setCarousels(guideModel.getCarousels());
            setGuideLanguage(guideModel.getGuideLanguage());
            if (guideModel.mGuideStatus.o()) {
                aVarB.onComplete();
            } else {
                aVarB.onNext((GuideStatus) Objects.requireNonNull(guideModel.mGuideStatus.n()));
            }
        }
    }

    @Override // java.lang.Comparable
    public final int compareTo(GuideModel guideModel) {
        return getPriority() < guideModel.getPriority() ? 1 : -1;
    }

    public StepModel getGuideStepModel(String str) {
        String guideStepId;
        try {
            List<StepModel> steps = getSteps();
            if (steps == null) {
                return null;
            }
            Iterator<StepModel> it = steps.iterator();
            while (it.hasNext()) {
                StepModel next = it.next();
                StepContentModel stepContentModel = next != null ? next.getStepContentModel() : null;
                if (stepContentModel != null && (guideStepId = stepContentModel.getGuideStepId()) != null && guideStepId.equals(str)) {
                    return next;
                }
            }
            PendoLogger.e(TAG + String.format(COULD_NOT_DELIVER_STEP_MESSAGE, str, getGuideId()), new Object[0]);
            return null;
        } catch (Exception e) {
            PendoLogger.e("GuideModelgetGuideStepModel with error: " + e + String.format(COULD_NOT_DELIVER_STEP_MESSAGE, str, getGuideId()), e.getMessage());
            return null;
        }
    }

    public GuideModel(StepGuideModel stepGuideModel) {
        this.mGeneralGuideConfiguration = new GeneralGuidesConfiguration();
        this.mControl = Boolean.FALSE;
        this.mContentUrl = null;
        this.mGuideLanguage = "";
        this.mGuideStatus = a.b(new ContentNotReady());
        if (stepGuideModel != null) {
            try {
                StepModel stepModel = new StepModel();
                StepContentModel stepContentModel = new StepContentModel();
                stepContentModel.setStepContentModel(stepGuideModel);
                stepContentModel.setGuideId(PREVIEW_GUIDE_ID);
                stepContentModel.setGuideStepId(PREVIEW_GUIDE_STEP_ID);
                stepModel.setStepContentModel(stepContentModel);
                stepModel.setStepLocationModel(new StepLocationModel());
                stepModel.setStepActivations(new ArrayList());
                ArrayList arrayList = new ArrayList();
                arrayList.add(stepModel);
                setSteps(arrayList);
                setGuideId(PREVIEW_GUIDE_ID);
                setPriority(3);
                setActivations(null);
                setGuideName(PREVIEW_GUIDE_NAME);
                setGeneralGuideConfiguration(null);
            } catch (Exception e) {
                PendoLogger.e("GuideModel stepGuideModelId " + stepGuideModel.getId() + " with error:" + e + " with message: " + e.getMessage(), new Object[0]);
            }
        }
    }
}
