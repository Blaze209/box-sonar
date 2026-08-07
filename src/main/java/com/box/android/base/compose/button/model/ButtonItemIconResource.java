package com.box.android.base.compose.button.model;

import androidx.compose.ui.graphics.vector.ImageVector;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ButtonItem.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/base/compose/button/model/ButtonItemIconResource;", "", "<init>", "()V", "DrawableResource", "ImageVectorResource", "Lcom/box/android/base/compose/button/model/ButtonItemIconResource$DrawableResource;", "Lcom/box/android/base/compose/button/model/ButtonItemIconResource$ImageVectorResource;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class ButtonItemIconResource {
    public static final int $stable = 0;

    public /* synthetic */ ButtonItemIconResource(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: ButtonItem.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/base/compose/button/model/ButtonItemIconResource$DrawableResource;", "Lcom/box/android/base/compose/button/model/ButtonItemIconResource;", "value", "", "<init>", "(I)V", "getValue", "()I", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class DrawableResource extends ButtonItemIconResource {
        public static final int $stable = 0;
        private final int value;

        public static /* synthetic */ DrawableResource copy$default(DrawableResource drawableResource, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = drawableResource.value;
            }
            return drawableResource.copy(i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getValue() {
            return this.value;
        }

        public final DrawableResource copy(int value) {
            return new DrawableResource(value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DrawableResource) && this.value == ((DrawableResource) other).value;
        }

        public int hashCode() {
            return Integer.hashCode(this.value);
        }

        public String toString() {
            return "DrawableResource(value=" + this.value + ")";
        }

        public DrawableResource(int i) {
            super(null);
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }
    }

    private ButtonItemIconResource() {
    }

    /* JADX INFO: compiled from: ButtonItem.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/base/compose/button/model/ButtonItemIconResource$ImageVectorResource;", "Lcom/box/android/base/compose/button/model/ButtonItemIconResource;", "value", "Landroidx/compose/ui/graphics/vector/ImageVector;", "<init>", "(Landroidx/compose/ui/graphics/vector/ImageVector;)V", "getValue", "()Landroidx/compose/ui/graphics/vector/ImageVector;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ImageVectorResource extends ButtonItemIconResource {
        public static final int $stable = 0;
        private final ImageVector value;

        public static /* synthetic */ ImageVectorResource copy$default(ImageVectorResource imageVectorResource, ImageVector imageVector, int i, Object obj) {
            if ((i & 1) != 0) {
                imageVector = imageVectorResource.value;
            }
            return imageVectorResource.copy(imageVector);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ImageVector getValue() {
            return this.value;
        }

        public final ImageVectorResource copy(ImageVector value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new ImageVectorResource(value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ImageVectorResource) && Intrinsics.areEqual(this.value, ((ImageVectorResource) other).value);
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return "ImageVectorResource(value=" + this.value + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ImageVectorResource(ImageVector value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final ImageVector getValue() {
            return this.value;
        }
    }
}
