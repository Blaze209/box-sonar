package androidx.constraintlayout.compose;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.facebook.react.views.progressbar.ReactProgressBarViewManager;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;

/* JADX INFO: compiled from: MotionCarousel.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J;\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010!\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0005HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\u001a\u0010\t\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016¨\u0006&"}, d2 = {"Landroidx/constraintlayout/compose/CarouselState;", "", "direction", "Landroidx/constraintlayout/compose/MotionCarouselDirection;", FirebaseAnalytics.Param.INDEX, "", "targetIndex", "snapping", "", ReactProgressBarViewManager.PROP_ANIMATING, "(Landroidx/constraintlayout/compose/MotionCarouselDirection;IIZZ)V", "getAnimating", "()Z", "setAnimating", "(Z)V", "getDirection", "()Landroidx/constraintlayout/compose/MotionCarouselDirection;", "setDirection", "(Landroidx/constraintlayout/compose/MotionCarouselDirection;)V", "getIndex", "()I", "setIndex", "(I)V", "getSnapping", "setSnapping", "getTargetIndex", "setTargetIndex", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "toString", "", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final /* data */ class CarouselState {
    private boolean animating;
    private MotionCarouselDirection direction;
    private int index;
    private boolean snapping;
    private int targetIndex;

    public static /* synthetic */ CarouselState copy$default(CarouselState carouselState, MotionCarouselDirection motionCarouselDirection, int i, int i2, boolean z, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            motionCarouselDirection = carouselState.direction;
        }
        if ((i3 & 2) != 0) {
            i = carouselState.index;
        }
        if ((i3 & 4) != 0) {
            i2 = carouselState.targetIndex;
        }
        if ((i3 & 8) != 0) {
            z = carouselState.snapping;
        }
        if ((i3 & 16) != 0) {
            z2 = carouselState.animating;
        }
        boolean z3 = z2;
        int i4 = i2;
        return carouselState.copy(motionCarouselDirection, i, i4, z, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MotionCarouselDirection getDirection() {
        return this.direction;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getTargetIndex() {
        return this.targetIndex;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getSnapping() {
        return this.snapping;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getAnimating() {
        return this.animating;
    }

    public final CarouselState copy(MotionCarouselDirection direction, int index, int targetIndex, boolean snapping, boolean animating) {
        return new CarouselState(direction, index, targetIndex, snapping, animating);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CarouselState)) {
            return false;
        }
        CarouselState carouselState = (CarouselState) other;
        return this.direction == carouselState.direction && this.index == carouselState.index && this.targetIndex == carouselState.targetIndex && this.snapping == carouselState.snapping && this.animating == carouselState.animating;
    }

    public int hashCode() {
        return (((((((this.direction.hashCode() * 31) + Integer.hashCode(this.index)) * 31) + Integer.hashCode(this.targetIndex)) * 31) + Boolean.hashCode(this.snapping)) * 31) + Boolean.hashCode(this.animating);
    }

    public String toString() {
        return "CarouselState(direction=" + this.direction + ", index=" + this.index + ", targetIndex=" + this.targetIndex + ", snapping=" + this.snapping + ", animating=" + this.animating + ')';
    }

    public CarouselState(MotionCarouselDirection motionCarouselDirection, int i, int i2, boolean z, boolean z2) {
        this.direction = motionCarouselDirection;
        this.index = i;
        this.targetIndex = i2;
        this.snapping = z;
        this.animating = z2;
    }

    public final MotionCarouselDirection getDirection() {
        return this.direction;
    }

    public final void setDirection(MotionCarouselDirection motionCarouselDirection) {
        this.direction = motionCarouselDirection;
    }

    public final int getIndex() {
        return this.index;
    }

    public final void setIndex(int i) {
        this.index = i;
    }

    public final int getTargetIndex() {
        return this.targetIndex;
    }

    public final void setTargetIndex(int i) {
        this.targetIndex = i;
    }

    public final boolean getSnapping() {
        return this.snapping;
    }

    public final void setSnapping(boolean z) {
        this.snapping = z;
    }

    public final boolean getAnimating() {
        return this.animating;
    }

    public final void setAnimating(boolean z) {
        this.animating = z;
    }
}
