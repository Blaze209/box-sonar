package sdk.pendo.io.actions;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.a0.f;
import sdk.pendo.io.a0.i;
import sdk.pendo.io.a0.l;
import sdk.pendo.io.b.a;
import sdk.pendo.io.b.d;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.GuideModel;
import sdk.pendo.io.models.StepContentModel;
import sdk.pendo.io.models.StepModel;
import sdk.pendo.io.models.StepSeen;
import sdk.pendo.io.utilities.script.JavascriptRunner;
import sdk.pendo.io.views.GuideViewHolder;
import sdk.pendo.io.views.custom.PendoCarouselLayout;
import sdk.pendo.io.views.custom.PendoLinearLayout;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 @2\u00020\u00012\u00020\u0002:\u0001@B+\u0012\b\u00108\u001a\u0004\u0018\u000107\u0012\u0006\u00109\u001a\u00020\u0005\u0012\b\u0010;\u001a\u0004\u0018\u00010:\u0012\u0006\u0010=\u001a\u00020<¢\u0006\u0004\b>\u0010?J\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0003H\u0002J\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u000e\u001a\u00020\u000bH\u0002J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0014J\b\u0010\u0015\u001a\u00020\u0013H\u0007J \u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0011H\u0014J \u0010\u001f\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0011H\u0016J\u0010\u0010!\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u0011H\u0016J\u0010\u0010\"\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u0011H\u0016R0\u0010%\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b%\u0010&\u0012\u0004\b+\u0010,\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R&\u0010/\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160.0-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00101\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00103\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00102R\u0016\u00104\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00102R\u0016\u00105\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106¨\u0006A"}, d2 = {"Lsdk/pendo/io/actions/CarouselVisualGuide;", "Lsdk/pendo/io/actions/VisualGuide;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "Lsdk/pendo/io/a0/l;", "stepContent", "", "stepId", "retrieveCarouselStepActions", "viewContent", "", "inflateCarouselPageIndicatorLayoutHolderView", "Lsdk/pendo/io/actions/PendoCommandEventType$UserEventType;", "eventType", "dispatchSwipeRelatedActions", "getSwipeEventType", "Landroid/app/Activity;", "activity", "", "currentStepIndex", "", "inflateContent", "inflateCarouselSteps", "Lsdk/pendo/io/actions/PendoCommand;", "pendoCommand", VisualGuideBase.GUIDE_STEP_ID_PARAMETER_NAME, "nextGuideStepIndex", "advanceGuide", "i", "", "v", "i1", "onPageScrolled", "pageIndex", "onPageSelected", "onPageScrollStateChanged", "Ljava/lang/ref/WeakReference;", "Lsdk/pendo/io/views/custom/PendoCarouselLayout;", "mPendoCarouselLayout", "Ljava/lang/ref/WeakReference;", "getMPendoCarouselLayout", "()Ljava/lang/ref/WeakReference;", "setMPendoCarouselLayout", "(Ljava/lang/ref/WeakReference;)V", "getMPendoCarouselLayout$annotations", "()V", "Ljava/util/HashMap;", "", "mStepActionsMap", "Ljava/util/HashMap;", "mCurrentSelectedPage", "I", "mPreviousSelectedPage", "mCarouselStartIndex", "mIsManualSwipe", "Z", "Lsdk/pendo/io/models/GuideModel;", "guideModel", "carouselId", "Lsdk/pendo/io/actions/VisualGuideLifecycleListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lsdk/pendo/io/actions/StepSeenManagerInterface;", "stepSeenManager", "<init>", "(Lsdk/pendo/io/models/GuideModel;Ljava/lang/String;Lsdk/pendo/io/actions/VisualGuideLifecycleListener;Lsdk/pendo/io/actions/StepSeenManagerInterface;)V", "Companion", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class CarouselVisualGuide extends VisualGuide implements ViewPager.OnPageChangeListener {
    private static final String SWIPER = "Swiper";
    private static final String TAG = "CarouselVisualGuide";
    private int mCarouselStartIndex;
    private int mCurrentSelectedPage;
    private boolean mIsManualSwipe;
    private WeakReference<PendoCarouselLayout> mPendoCarouselLayout;
    private int mPreviousSelectedPage;
    private final HashMap<String, List<PendoCommand>> mStepActionsMap;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CarouselVisualGuide(GuideModel guideModel, String carouselId, VisualGuideLifecycleListener visualGuideLifecycleListener, StepSeenManagerInterface stepSeenManager) {
        super(guideModel, visualGuideLifecycleListener, stepSeenManager);
        Intrinsics.checkNotNullParameter(carouselId, "carouselId");
        Intrinsics.checkNotNullParameter(stepSeenManager, "stepSeenManager");
        this.mStepActionsMap = new HashMap<>();
        this.mIsManualSwipe = true;
        this.mVisualGuideType = VisualGuideBase.VisualGuideType.CAROUSEL;
        this.mCarouselId = carouselId;
    }

    private final void dispatchSwipeRelatedActions(PendoCommandEventType.UserEventType eventType, String stepId) {
        ArrayList arrayList;
        if (this.mStepActionsMap.containsKey(stepId)) {
            List<PendoCommand> list = this.mStepActionsMap.get(stepId);
            if (list != null) {
                arrayList = new ArrayList();
                for (Object obj : list) {
                    if (Intrinsics.areEqual(((PendoCommand) obj).eventType, eventType)) {
                        arrayList.add(obj);
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList == null || arrayList.isEmpty()) {
                PendoLogger.d(TAG, "No commands.");
            } else {
                JavascriptRunner.GuideContext.addBasicParamsToGuideCommands(arrayList);
                PendoCommandDispatcher.getInstance().dispatchCommandsIOThread(arrayList, eventType);
            }
        }
    }

    public static /* synthetic */ void getMPendoCarouselLayout$annotations() {
    }

    private final PendoCommandEventType.UserEventType getSwipeEventType() {
        PendoCommandEventType.UserEventType userEventType = this.mCurrentSelectedPage > this.mPreviousSelectedPage ? PendoCommandEventType.UserEventType.SWIPE_LEFT : PendoCommandEventType.UserEventType.SWIPE_RIGHT;
        Intrinsics.checkNotNull(userEventType);
        return userEventType;
    }

    private final void inflateCarouselPageIndicatorLayoutHolderView(l viewContent) {
        try {
            WeakReference<PendoCarouselLayout> weakReference = this.mPendoCarouselLayout;
            Intrinsics.checkNotNull(weakReference);
            PendoCarouselLayout pendoCarouselLayout = weakReference.get();
            View viewA = d.a(pendoCarouselLayout != null ? pendoCarouselLayout.getContext() : null, viewContent, getContainer(), GuideViewHolder.class, getGuideId(), getSteps().get(0).getStepContentModel().getGuideStepId());
            if (viewA == null || getContainer() == null) {
                return;
            }
            WeakReference<PendoCarouselLayout> weakReference2 = this.mPendoCarouselLayout;
            Intrinsics.checkNotNull(weakReference2);
            PendoCarouselLayout pendoCarouselLayout2 = weakReference2.get();
            if (pendoCarouselLayout2 != null) {
                pendoCarouselLayout2.setAndActivateIndicatorContainerBlock((PendoLinearLayout) viewA);
            }
        } catch (Exception unused) {
            PendoLogger.w(TAG, "Can't inflate carousel page indicator view for guide: " + getGuideId());
        }
    }

    private final l retrieveCarouselStepActions(l stepContent, String stepId) {
        l lVarE;
        if (stepContent != null && stepContent.d(GuideActionConfiguration.GUIDE_BUILDING_BLOCK_VIEWS) && (lVarE = stepContent.b(GuideActionConfiguration.GUIDE_BUILDING_BLOCK_VIEWS).a(0).e()) != null && lVarE.d("widget") && Intrinsics.areEqual(lVarE.a("widget").g(), SWIPER)) {
            stepContent.e(GuideActionConfiguration.GUIDE_BUILDING_BLOCK_VIEWS);
            f fVar = new f();
            fVar.a(lVarE.b(GuideActionConfiguration.GUIDE_BUILDING_BLOCK_VIEWS).a(0));
            stepContent.a(GuideActionConfiguration.GUIDE_BUILDING_BLOCK_VIEWS, fVar);
            f fVarB = lVarE.b("actions");
            if (fVarB != null && fVarB.size() > 0) {
                JavascriptRunner.GuideContext guideContext = new JavascriptRunner.GuideContext(getGuideId());
                HashMap<String, List<PendoCommand>> map = this.mStepActionsMap;
                List<PendoCommand> pendoCommandsWithParameters = PendoCommand.getPendoCommandsWithParameters(fVarB, PendoCommandAction.PendoCommandGlobalAction.PendoInfoConsts.createPendoMetadataParams(getGuideId()), guideContext);
                Intrinsics.checkNotNullExpressionValue(pendoCommandsWithParameters, "getPendoCommandsWithParameters(...)");
                map.put(stepId, pendoCommandsWithParameters);
            }
        }
        return stepContent;
    }

    protected boolean advanceGuide(PendoCommand pendoCommand, String guideStepId, int nextGuideStepIndex) {
        PendoCarouselLayout pendoCarouselLayout;
        StepContentModel stepContentModel;
        Intrinsics.checkNotNullParameter(pendoCommand, "pendoCommand");
        Intrinsics.checkNotNullParameter(guideStepId, "guideStepId");
        StepModel guideStepModel = getGuideStepModel(guideStepId);
        String carouselId = (guideStepModel == null || (stepContentModel = guideStepModel.getStepContentModel()) == null) ? null : stepContentModel.getCarouselId();
        String str = this.mCarouselId;
        if (str == null || carouselId == null || !Intrinsics.areEqual(str, carouselId)) {
            return super.advanceGuide(pendoCommand, guideStepId, Integer.valueOf(nextGuideStepIndex));
        }
        if (!Intrinsics.areEqual(pendoCommand.eventType, PendoCommandEventType.UserEventType.SWIPE_LEFT) && !Intrinsics.areEqual(pendoCommand.eventType, PendoCommandEventType.UserEventType.SWIPE_RIGHT)) {
            this.mIsManualSwipe = false;
            try {
                WeakReference<PendoCarouselLayout> weakReference = this.mPendoCarouselLayout;
                if (weakReference != null && (pendoCarouselLayout = weakReference.get()) != null) {
                    pendoCarouselLayout.setCurrentItem(nextGuideStepIndex - this.mCarouselStartIndex, true);
                }
            } catch (Exception e) {
                PendoLogger.w(String.valueOf(e.getMessage()), new Object[0]);
            }
        }
        resetGuideStepDuration(this.mStepSeenManager.getCurrentStepId());
        this.mStepSeenManager.setCurrentStepSeen(new StepSeen(getGuideId(), guideStepId, Integer.valueOf(nextGuideStepIndex)));
        initializeTimeoutCounter(nextGuideStepIndex);
        setStartDuration(System.currentTimeMillis());
        handleGuideSeenAnalytics();
        return false;
    }

    public final WeakReference<PendoCarouselLayout> getMPendoCarouselLayout() {
        return this.mPendoCarouselLayout;
    }

    public final boolean inflateCarouselSteps() {
        PagerAdapter mViewPagerAdapter;
        try {
            this.mStepActionsMap.clear();
            List<StepModel> steps = getSteps();
            if (steps != null) {
                for (StepModel stepModel : steps) {
                    StepContentModel stepContentModel = stepModel != null ? stepModel.getStepContentModel() : null;
                    if (stepContentModel != null && Intrinsics.areEqual(stepContentModel.getCarouselId(), this.mCarouselId)) {
                        i screenContents = GuideActionConfiguration.getScreenContents(stepModel.getStepContent());
                        if (screenContents != null && screenContents.j()) {
                            String guideStepId = stepModel.getStepContentModel().getGuideStepId();
                            l lVarE = screenContents.e();
                            Intrinsics.checkNotNull(guideStepId);
                            l lVarRetrieveCarouselStepActions = retrieveCarouselStepActions(lVarE, guideStepId);
                            WeakReference<PendoCarouselLayout> weakReference = this.mPendoCarouselLayout;
                            Intrinsics.checkNotNull(weakReference);
                            PendoCarouselLayout pendoCarouselLayout = weakReference.get();
                            Context context = pendoCarouselLayout != null ? pendoCarouselLayout.getContext() : null;
                            WeakReference<PendoCarouselLayout> weakReference2 = this.mPendoCarouselLayout;
                            Intrinsics.checkNotNull(weakReference2);
                            PendoCarouselLayout pendoCarouselLayout2 = weakReference2.get();
                            View viewA = d.a(context, lVarRetrieveCarouselStepActions, pendoCarouselLayout2 != null ? pendoCarouselLayout2.getPagesContainer() : null, GuideViewHolder.class, getGuideId(), guideStepId);
                            if (viewA == null) {
                                PendoLogger.w(TAG, "Cannot inflate the main screen, bad content.");
                                return false;
                            }
                            a.a(viewA);
                            WeakReference<PendoCarouselLayout> weakReference3 = this.mPendoCarouselLayout;
                            Intrinsics.checkNotNull(weakReference3);
                            PendoCarouselLayout pendoCarouselLayout3 = weakReference3.get();
                            if (pendoCarouselLayout3 != null) {
                                pendoCarouselLayout3.addStepView(viewA);
                            }
                        }
                        PendoLogger.w(TAG, "Cannot inflate the main screen, bad content.");
                        return false;
                    }
                }
            }
            WeakReference<PendoCarouselLayout> weakReference4 = this.mPendoCarouselLayout;
            Intrinsics.checkNotNull(weakReference4);
            PendoCarouselLayout pendoCarouselLayout4 = weakReference4.get();
            if (pendoCarouselLayout4 == null || (mViewPagerAdapter = pendoCarouselLayout4.getMViewPagerAdapter()) == null) {
                return true;
            }
            mViewPagerAdapter.notifyDataSetChanged();
            return true;
        } catch (Exception e) {
            PendoLogger.e(TAG, "Failed to inflateCarouselSteps", e);
            return false;
        }
    }

    @Override // sdk.pendo.io.actions.VisualGuide
    protected boolean inflateContent(Activity activity, int currentStepIndex) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.mCarouselStartIndex = currentStepIndex;
        View viewInflate = LayoutInflater.from(activity).inflate(this.mVisualGuideType.getLayoutId(), getRootView(), false);
        Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.view.ViewGroup");
        setContainerView((ViewGroup) viewInflate);
        ViewGroup container = getContainer();
        WeakReference<PendoCarouselLayout> weakReference = new WeakReference<>(container instanceof PendoCarouselLayout ? (PendoCarouselLayout) container : null);
        this.mPendoCarouselLayout = weakReference;
        if (!inflateCarouselSteps()) {
            if (Unit.INSTANCE == null) {
                PendoLogger.w("Cannot show guide, container is null. GuideId: " + getGuideId(), new Object[0]);
            }
            return false;
        }
        PendoCarouselLayout pendoCarouselLayout = weakReference.get();
        if (pendoCarouselLayout != null) {
            pendoCarouselLayout.setOnPageChangeListener(this);
        }
        l carouselIndicatorsLayoutView = getCarouselIndicatorsLayoutView(this.mCarouselId);
        Intrinsics.checkNotNullExpressionValue(carouselIndicatorsLayoutView, "getCarouselIndicatorsLayoutView(...)");
        inflateCarouselPageIndicatorLayoutHolderView(carouselIndicatorsLayoutView);
        return true;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float v, int i1) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int pageIndex) {
        this.mPreviousSelectedPage = this.mCurrentSelectedPage;
        this.mCurrentSelectedPage = pageIndex;
        WeakReference<PendoCarouselLayout> weakReference = this.mPendoCarouselLayout;
        Intrinsics.checkNotNull(weakReference);
        PendoCarouselLayout pendoCarouselLayout = weakReference.get();
        if (pendoCarouselLayout != null) {
            pendoCarouselLayout.onPageSelected(this.mPreviousSelectedPage, this.mCurrentSelectedPage);
        }
        if (!this.mIsManualSwipe) {
            this.mIsManualSwipe = true;
            return;
        }
        PendoCommandEventType.UserEventType swipeEventType = getSwipeEventType();
        String guideStepId = getGuideStepId(this.mPreviousSelectedPage);
        Intrinsics.checkNotNullExpressionValue(guideStepId, "getGuideStepId(...)");
        dispatchSwipeRelatedActions(swipeEventType, guideStepId);
    }

    public final void setMPendoCarouselLayout(WeakReference<PendoCarouselLayout> weakReference) {
        this.mPendoCarouselLayout = weakReference;
    }

    @Override // sdk.pendo.io.actions.VisualGuideBase
    public /* bridge */ /* synthetic */ boolean advanceGuide(PendoCommand pendoCommand, String str, Integer num) {
        return advanceGuide(pendoCommand, str, num.intValue());
    }
}
