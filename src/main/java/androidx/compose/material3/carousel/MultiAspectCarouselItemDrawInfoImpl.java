package androidx.compose.material3.carousel;

import androidx.compose.foundation.gestures.Orientation;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;

/* JADX INFO: compiled from: MultiAspectCarousel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0013\u0010\u001f\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0096\u0002J\b\u0010\"\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\r8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\r8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000fR\u0014\u0010\u0016\u001a\u00020\r8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000fR\u0014\u0010\u0018\u001a\u00020\r8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u000fR\u0014\u0010\u001a\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001c¨\u0006#"}, d2 = {"Landroidx/compose/material3/carousel/MultiAspectCarouselItemDrawInfoImpl;", "Landroidx/compose/material3/carousel/MultiAspectCarouselItemDrawInfo;", FirebaseAnalytics.Param.INDEX, "", "containerState", "Landroidx/compose/material3/carousel/MultiAspectCarouselContainerState;", "itemState", "Landroidx/compose/material3/carousel/MultiAspectCarouselItemInfoState;", "<init>", "(ILandroidx/compose/material3/carousel/MultiAspectCarouselContainerState;Landroidx/compose/material3/carousel/MultiAspectCarouselItemInfoState;)V", "getIndex", "()I", "size", "", "getSize", "()F", "minSize", "getMinSize", "maxSize", "getMaxSize", "maskStart", "getMaskStart", "maskEnd", "getMaskEnd", "parallax", "getParallax", "isHorizontal", "", "()Z", "toString", "", "equals", "other", "", "hashCode", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class MultiAspectCarouselItemDrawInfoImpl implements MultiAspectCarouselItemDrawInfo {
    private final MultiAspectCarouselContainerState containerState;
    private final int index;
    private final MultiAspectCarouselItemInfoState itemState;

    public MultiAspectCarouselItemDrawInfoImpl(int i, MultiAspectCarouselContainerState multiAspectCarouselContainerState, MultiAspectCarouselItemInfoState multiAspectCarouselItemInfoState) {
        this.index = i;
        this.containerState = multiAspectCarouselContainerState;
        this.itemState = multiAspectCarouselItemInfoState;
    }

    @Override // androidx.compose.material3.carousel.MultiAspectCarouselItemDrawInfo
    public int getIndex() {
        return this.index;
    }

    @Override // androidx.compose.material3.carousel.MultiAspectCarouselItemDrawInfo
    public float getSize() {
        return getMaskEnd() - getMaskStart();
    }

    @Override // androidx.compose.material3.carousel.MultiAspectCarouselItemDrawInfo
    public float getMinSize() {
        return MultiAspectCarouselKt.getMinSize(this.itemState);
    }

    @Override // androidx.compose.material3.carousel.MultiAspectCarouselItemDrawInfo
    public float getMaxSize() {
        return this.itemState.getMainAxisSize();
    }

    @Override // androidx.compose.material3.carousel.MultiAspectCarouselItemDrawInfo
    public float getMaskStart() {
        return Float.intBitsToFloat((int) (MultiAspectCarouselKt.getMask(this.containerState, this.itemState) >> 32));
    }

    @Override // androidx.compose.material3.carousel.MultiAspectCarouselItemDrawInfo
    public float getMaskEnd() {
        return Float.intBitsToFloat((int) (MultiAspectCarouselKt.getMask(this.containerState, this.itemState) & 4294967295L));
    }

    @Override // androidx.compose.material3.carousel.MultiAspectCarouselItemDrawInfo
    public float getParallax() {
        return MultiAspectCarouselKt.getParallax(this.containerState, this.itemState);
    }

    @Override // androidx.compose.material3.carousel.MultiAspectCarouselItemDrawInfo
    public boolean isHorizontal() {
        return this.containerState.getOrientation() == Orientation.Horizontal;
    }

    public String toString() {
        return "MultiAspectCarouselItemDrawInfoImpl(size=" + getSize() + ",minSize=" + getMinSize() + ",maxSize=" + getMaxSize() + ",maskStart=" + getMaskStart() + ",maskEnd=" + getMaskEnd() + ",parallax=" + getParallax() + ",isHorizontal=" + isHorizontal() + ",)";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MultiAspectCarouselItemDrawInfoImpl)) {
            return false;
        }
        MultiAspectCarouselItemDrawInfoImpl multiAspectCarouselItemDrawInfoImpl = (MultiAspectCarouselItemDrawInfoImpl) other;
        return getIndex() == multiAspectCarouselItemDrawInfoImpl.getIndex() && getSize() == multiAspectCarouselItemDrawInfoImpl.getSize() && getMinSize() == multiAspectCarouselItemDrawInfoImpl.getMinSize() && getMaxSize() == multiAspectCarouselItemDrawInfoImpl.getMaxSize() && getMaskStart() == multiAspectCarouselItemDrawInfoImpl.getMaskStart() && getMaskEnd() == multiAspectCarouselItemDrawInfoImpl.getMaskEnd() && getParallax() == multiAspectCarouselItemDrawInfoImpl.getParallax() && isHorizontal() == multiAspectCarouselItemDrawInfoImpl.isHorizontal();
    }

    public int hashCode() {
        return (((((((((((((Integer.hashCode(getIndex()) * 31) + Float.hashCode(getSize())) * 31) + Float.hashCode(getMinSize())) * 31) + Float.hashCode(getMaxSize())) * 31) + Float.hashCode(getMaskStart())) * 31) + Float.hashCode(getMaskEnd())) * 31) + Float.hashCode(getParallax())) * 31) + Boolean.hashCode(isHorizontal());
    }
}
