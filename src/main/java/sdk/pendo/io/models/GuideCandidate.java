package sdk.pendo.io.models;

import android.view.View;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.actions.ActivationManager;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J9\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0005HÖ\u0001J\t\u0010!\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\""}, d2 = {"Lsdk/pendo/io/models/GuideCandidate;", "", "guideModel", "Lsdk/pendo/io/models/GuideModel;", "stepIndex", "", "activationEvent", "Lsdk/pendo/io/actions/ActivationManager$ActivationEvents;", "targetView", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "(Lsdk/pendo/io/models/GuideModel;ILsdk/pendo/io/actions/ActivationManager$ActivationEvents;Ljava/lang/ref/WeakReference;)V", "getActivationEvent", "()Lsdk/pendo/io/actions/ActivationManager$ActivationEvents;", "guideId", "", "getGuideId", "()Ljava/lang/String;", "getGuideModel", "()Lsdk/pendo/io/models/GuideModel;", "getStepIndex", "()I", "getTargetView", "()Ljava/lang/ref/WeakReference;", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "toString", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class GuideCandidate {
    private final ActivationManager.ActivationEvents activationEvent;
    private final GuideModel guideModel;
    private final int stepIndex;
    private final WeakReference<View> targetView;

    public GuideCandidate(GuideModel guideModel, int i, ActivationManager.ActivationEvents activationEvent, WeakReference<View> weakReference) {
        Intrinsics.checkNotNullParameter(guideModel, "guideModel");
        Intrinsics.checkNotNullParameter(activationEvent, "activationEvent");
        this.guideModel = guideModel;
        this.stepIndex = i;
        this.activationEvent = activationEvent;
        this.targetView = weakReference;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GuideCandidate copy$default(GuideCandidate guideCandidate, GuideModel guideModel, int i, ActivationManager.ActivationEvents activationEvents, WeakReference weakReference, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            guideModel = guideCandidate.guideModel;
        }
        if ((i2 & 2) != 0) {
            i = guideCandidate.stepIndex;
        }
        if ((i2 & 4) != 0) {
            activationEvents = guideCandidate.activationEvent;
        }
        if ((i2 & 8) != 0) {
            weakReference = guideCandidate.targetView;
        }
        return guideCandidate.copy(guideModel, i, activationEvents, weakReference);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final GuideModel getGuideModel() {
        return this.guideModel;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getStepIndex() {
        return this.stepIndex;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ActivationManager.ActivationEvents getActivationEvent() {
        return this.activationEvent;
    }

    public final WeakReference<View> component4() {
        return this.targetView;
    }

    public final GuideCandidate copy(GuideModel guideModel, int stepIndex, ActivationManager.ActivationEvents activationEvent, WeakReference<View> targetView) {
        Intrinsics.checkNotNullParameter(guideModel, "guideModel");
        Intrinsics.checkNotNullParameter(activationEvent, "activationEvent");
        return new GuideCandidate(guideModel, stepIndex, activationEvent, targetView);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuideCandidate)) {
            return false;
        }
        GuideCandidate guideCandidate = (GuideCandidate) other;
        return Intrinsics.areEqual(this.guideModel, guideCandidate.guideModel) && this.stepIndex == guideCandidate.stepIndex && this.activationEvent == guideCandidate.activationEvent && Intrinsics.areEqual(this.targetView, guideCandidate.targetView);
    }

    public final ActivationManager.ActivationEvents getActivationEvent() {
        return this.activationEvent;
    }

    public final String getGuideId() {
        String guideId = this.guideModel.getGuideId();
        Intrinsics.checkNotNullExpressionValue(guideId, "getGuideId(...)");
        return guideId;
    }

    public final GuideModel getGuideModel() {
        return this.guideModel;
    }

    public final int getStepIndex() {
        return this.stepIndex;
    }

    public final WeakReference<View> getTargetView() {
        return this.targetView;
    }

    public int hashCode() {
        int iHashCode = ((((this.guideModel.hashCode() * 31) + Integer.hashCode(this.stepIndex)) * 31) + this.activationEvent.hashCode()) * 31;
        WeakReference<View> weakReference = this.targetView;
        return iHashCode + (weakReference == null ? 0 : weakReference.hashCode());
    }

    public String toString() {
        return "GuideCandidate(guideModel=" + this.guideModel + ", stepIndex=" + this.stepIndex + ", activationEvent=" + this.activationEvent + ", targetView=" + this.targetView + ")";
    }
}
