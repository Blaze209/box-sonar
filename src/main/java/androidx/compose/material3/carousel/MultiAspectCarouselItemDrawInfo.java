package androidx.compose.material3.carousel;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;

/* JADX INFO: compiled from: MultiAspectCarousel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078'X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0012\u0010\f\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\tR\u0014\u0010\u000e\u001a\u00020\u00078'X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\tR\u0014\u0010\u0010\u001a\u00020\u00078'X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\tR\u0014\u0010\u0012\u001a\u00020\u00078'X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\tR\u0012\u0010\u0014\u001a\u00020\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0016\u0082\u0001\u0001\u0017ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0018À\u0006\u0001"}, d2 = {"Landroidx/compose/material3/carousel/MultiAspectCarouselItemDrawInfo;", "", FirebaseAnalytics.Param.INDEX, "", "getIndex", "()I", "size", "", "getSize", "()F", "minSize", "getMinSize", "maxSize", "getMaxSize", "maskStart", "getMaskStart", "maskEnd", "getMaskEnd", "parallax", "getParallax", "isHorizontal", "", "()Z", "Landroidx/compose/material3/carousel/MultiAspectCarouselItemDrawInfoImpl;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface MultiAspectCarouselItemDrawInfo {
    int getIndex();

    float getMaskEnd();

    float getMaskStart();

    float getMaxSize();

    float getMinSize();

    float getParallax();

    float getSize();

    boolean isHorizontal();
}
