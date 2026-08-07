package com.pspdfkit.ui.thumbnail;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.facebook.react.uimanager.ViewProps;
import com.pspdfkit.internal.mv;
import com.pspdfkit.internal.p60;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0087\b\u0018\u00002\u00020\u0001BQ\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0017J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001aJ\\\u0010\u001c\u001a\u00020\u00002\b\b\u0003\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\u001eHÖ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b!\u0010\u0011J\u001a\u0010#\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b#\u0010$R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010%\u001a\u0004\b&\u0010\u0011R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010'\u001a\u0004\b(\u0010\u0013R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010)\u001a\u0004\b*\u0010\u0015R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010+\u001a\u0004\b\t\u0010\u0017R\u0017\u0010\n\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\n\u0010+\u001a\u0004\b\n\u0010\u0017R\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010,\u001a\u0004\b-\u0010\u001aR\u0019\u0010\r\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\r\u0010,\u001a\u0004\b.\u0010\u001a¨\u0006/"}, d2 = {"Lcom/pspdfkit/ui/thumbnail/ThumbnailItem;", "", "", "pageIndex", "Lcom/pspdfkit/internal/p60;", ViewProps.POSITION, "Lcom/pspdfkit/ui/thumbnail/ThumbnailBitmap;", "bitmap", "", "isSelected", "isRendering", "", "absolutePositionX", "absolutePositionY", "<init>", "(ILcom/pspdfkit/internal/p60;Lcom/pspdfkit/ui/thumbnail/ThumbnailBitmap;ZZLjava/lang/Float;Ljava/lang/Float;)V", "component1", "()I", "component2", "()Lcom/pspdfkit/internal/p60;", "component3", "()Lcom/pspdfkit/ui/thumbnail/ThumbnailBitmap;", "component4", "()Z", "component5", "component6", "()Ljava/lang/Float;", "component7", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(ILcom/pspdfkit/internal/p60;Lcom/pspdfkit/ui/thumbnail/ThumbnailBitmap;ZZLjava/lang/Float;Ljava/lang/Float;)Lcom/pspdfkit/ui/thumbnail/ThumbnailItem;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "I", "getPageIndex", "Lcom/pspdfkit/internal/p60;", "getPosition", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBitmap;", "getBitmap", "Z", "Ljava/lang/Float;", "getAbsolutePositionX", "getAbsolutePositionY", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class ThumbnailItem {
    public static final int $stable = 8;
    private final Float absolutePositionX;
    private final Float absolutePositionY;
    private final ThumbnailBitmap bitmap;
    private final boolean isRendering;
    private final boolean isSelected;
    private final int pageIndex;
    private final p60 position;

    public ThumbnailItem(int i, p60 p60Var, ThumbnailBitmap thumbnailBitmap, boolean z, boolean z2, Float f, Float f2) {
        p60Var.getClass();
        this.pageIndex = i;
        this.position = p60Var;
        this.bitmap = thumbnailBitmap;
        this.isSelected = z;
        this.isRendering = z2;
        this.absolutePositionX = f;
        this.absolutePositionY = f2;
    }

    public static /* synthetic */ ThumbnailItem copy$default(ThumbnailItem thumbnailItem, int i, p60 p60Var, ThumbnailBitmap thumbnailBitmap, boolean z, boolean z2, Float f, Float f2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = thumbnailItem.pageIndex;
        }
        if ((i2 & 2) != 0) {
            p60Var = thumbnailItem.position;
        }
        if ((i2 & 4) != 0) {
            thumbnailBitmap = thumbnailItem.bitmap;
        }
        if ((i2 & 8) != 0) {
            z = thumbnailItem.isSelected;
        }
        if ((i2 & 16) != 0) {
            z2 = thumbnailItem.isRendering;
        }
        if ((i2 & 32) != 0) {
            f = thumbnailItem.absolutePositionX;
        }
        if ((i2 & 64) != 0) {
            f2 = thumbnailItem.absolutePositionY;
        }
        Float f3 = f;
        Float f4 = f2;
        boolean z3 = z2;
        ThumbnailBitmap thumbnailBitmap2 = thumbnailBitmap;
        return thumbnailItem.copy(i, p60Var, thumbnailBitmap2, z, z3, f3, f4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getPageIndex() {
        return this.pageIndex;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final p60 getPosition() {
        return this.position;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ThumbnailBitmap getBitmap() {
        return this.bitmap;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsRendering() {
        return this.isRendering;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Float getAbsolutePositionX() {
        return this.absolutePositionX;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Float getAbsolutePositionY() {
        return this.absolutePositionY;
    }

    public final ThumbnailItem copy(int pageIndex, p60 position, ThumbnailBitmap bitmap, boolean isSelected, boolean isRendering, Float absolutePositionX, Float absolutePositionY) {
        position.getClass();
        return new ThumbnailItem(pageIndex, position, bitmap, isSelected, isRendering, absolutePositionX, absolutePositionY);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ThumbnailItem)) {
            return false;
        }
        ThumbnailItem thumbnailItem = (ThumbnailItem) other;
        return this.pageIndex == thumbnailItem.pageIndex && Intrinsics.areEqual(this.position, thumbnailItem.position) && Intrinsics.areEqual(this.bitmap, thumbnailItem.bitmap) && this.isSelected == thumbnailItem.isSelected && this.isRendering == thumbnailItem.isRendering && Intrinsics.areEqual((Object) this.absolutePositionX, (Object) thumbnailItem.absolutePositionX) && Intrinsics.areEqual((Object) this.absolutePositionY, (Object) thumbnailItem.absolutePositionY);
    }

    public final Float getAbsolutePositionX() {
        return this.absolutePositionX;
    }

    public final Float getAbsolutePositionY() {
        return this.absolutePositionY;
    }

    public final ThumbnailBitmap getBitmap() {
        return this.bitmap;
    }

    public final int getPageIndex() {
        return this.pageIndex;
    }

    public final p60 getPosition() {
        return this.position;
    }

    public int hashCode() {
        int iHashCode = (this.position.hashCode() + (Integer.hashCode(this.pageIndex) * 31)) * 31;
        ThumbnailBitmap thumbnailBitmap = this.bitmap;
        int iA = mv.a(this.isRendering, mv.a(this.isSelected, (iHashCode + (thumbnailBitmap == null ? 0 : thumbnailBitmap.hashCode())) * 31, 31), 31);
        Float f = this.absolutePositionX;
        int iHashCode2 = (iA + (f == null ? 0 : f.hashCode())) * 31;
        Float f2 = this.absolutePositionY;
        return iHashCode2 + (f2 != null ? f2.hashCode() : 0);
    }

    public final boolean isRendering() {
        return this.isRendering;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public String toString() {
        return "ThumbnailItem(pageIndex=" + this.pageIndex + ", position=" + this.position + ", bitmap=" + this.bitmap + ", isSelected=" + this.isSelected + ", isRendering=" + this.isRendering + ", absolutePositionX=" + this.absolutePositionX + ", absolutePositionY=" + this.absolutePositionY + ")";
    }

    public /* synthetic */ ThumbnailItem(int i, p60 p60Var, ThumbnailBitmap thumbnailBitmap, boolean z, boolean z2, Float f, Float f2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, p60Var, (i2 & 4) != 0 ? null : thumbnailBitmap, (i2 & 8) != 0 ? false : z, (i2 & 16) != 0 ? false : z2, (i2 & 32) != 0 ? null : f, (i2 & 64) != 0 ? null : f2);
    }
}
