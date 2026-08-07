package com.box.android.base.compose;

import android.graphics.Bitmap;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxItemThumbnail.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/box/android/base/compose/ItemThumbnail;", "", "<init>", "()V", "Icon", "PreviewThumbnail", "Placeholder", "Lcom/box/android/base/compose/ItemThumbnail$Icon;", "Lcom/box/android/base/compose/ItemThumbnail$Placeholder;", "Lcom/box/android/base/compose/ItemThumbnail$PreviewThumbnail;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class ItemThumbnail {
    public static final int $stable = 0;

    public /* synthetic */ ItemThumbnail(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: BoxItemThumbnail.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ$\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/box/android/base/compose/ItemThumbnail$Icon;", "Lcom/box/android/base/compose/ItemThumbnail;", "iconRes", "", "contentDescription", "<init>", "(ILjava/lang/Integer;)V", "getIconRes", "()I", "getContentDescription", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(ILjava/lang/Integer;)Lcom/box/android/base/compose/ItemThumbnail$Icon;", "equals", "", "other", "", "hashCode", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Icon extends ItemThumbnail {
        public static final int $stable = 0;
        private final Integer contentDescription;
        private final int iconRes;

        public static /* synthetic */ Icon copy$default(Icon icon, int i, Integer num, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = icon.iconRes;
            }
            if ((i2 & 2) != 0) {
                num = icon.contentDescription;
            }
            return icon.copy(i, num);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getIconRes() {
            return this.iconRes;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getContentDescription() {
            return this.contentDescription;
        }

        public final Icon copy(int iconRes, Integer contentDescription) {
            return new Icon(iconRes, contentDescription);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Icon)) {
                return false;
            }
            Icon icon = (Icon) other;
            return this.iconRes == icon.iconRes && Intrinsics.areEqual(this.contentDescription, icon.contentDescription);
        }

        public int hashCode() {
            int iHashCode = Integer.hashCode(this.iconRes) * 31;
            Integer num = this.contentDescription;
            return iHashCode + (num == null ? 0 : num.hashCode());
        }

        public String toString() {
            return "Icon(iconRes=" + this.iconRes + ", contentDescription=" + this.contentDescription + ")";
        }

        public Icon(int i, Integer num) {
            super(null);
            this.iconRes = i;
            this.contentDescription = num;
        }

        public /* synthetic */ Icon(int i, Integer num, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i2 & 2) != 0 ? null : num);
        }

        public final Integer getContentDescription() {
            return this.contentDescription;
        }

        public final int getIconRes() {
            return this.iconRes;
        }
    }

    private ItemThumbnail() {
    }

    /* JADX INFO: compiled from: BoxItemThumbnail.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/base/compose/ItemThumbnail$PreviewThumbnail;", "Lcom/box/android/base/compose/ItemThumbnail;", "thumbnail", "Landroid/graphics/Bitmap;", "<init>", "(Landroid/graphics/Bitmap;)V", "getThumbnail", "()Landroid/graphics/Bitmap;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class PreviewThumbnail extends ItemThumbnail {
        public static final int $stable = 8;
        private final Bitmap thumbnail;

        public static /* synthetic */ PreviewThumbnail copy$default(PreviewThumbnail previewThumbnail, Bitmap bitmap, int i, Object obj) {
            if ((i & 1) != 0) {
                bitmap = previewThumbnail.thumbnail;
            }
            return previewThumbnail.copy(bitmap);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Bitmap getThumbnail() {
            return this.thumbnail;
        }

        public final PreviewThumbnail copy(Bitmap thumbnail) {
            Intrinsics.checkNotNullParameter(thumbnail, "thumbnail");
            return new PreviewThumbnail(thumbnail);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof PreviewThumbnail) && Intrinsics.areEqual(this.thumbnail, ((PreviewThumbnail) other).thumbnail);
        }

        public int hashCode() {
            return this.thumbnail.hashCode();
        }

        public String toString() {
            return "PreviewThumbnail(thumbnail=" + this.thumbnail + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PreviewThumbnail(Bitmap thumbnail) {
            super(null);
            Intrinsics.checkNotNullParameter(thumbnail, "thumbnail");
            this.thumbnail = thumbnail;
        }

        public final Bitmap getThumbnail() {
            return this.thumbnail;
        }
    }

    /* JADX INFO: compiled from: BoxItemThumbnail.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/base/compose/ItemThumbnail$Placeholder;", "Lcom/box/android/base/compose/ItemThumbnail;", "<init>", "()V", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Placeholder extends ItemThumbnail {
        public static final int $stable = 0;
        public static final Placeholder INSTANCE = new Placeholder();

        private Placeholder() {
            super(null);
        }
    }
}
