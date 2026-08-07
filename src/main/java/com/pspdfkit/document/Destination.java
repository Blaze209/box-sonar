package com.pspdfkit.document;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.facebook.react.uimanager.ViewProps;
import com.pspdfkit.internal.kv;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003JO\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u0007HÆ\u0001J\u0014\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010#\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010$\u001a\u00020%HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013¨\u0006&"}, d2 = {"Lcom/pspdfkit/document/Destination;", "", "pageIndex", "", "type", "Lcom/pspdfkit/document/DestinationType;", "left", "", ViewProps.TOP, "width", "height", "zoom", "<init>", "(ILcom/pspdfkit/document/DestinationType;FFFFF)V", "getPageIndex", "()I", "getType", "()Lcom/pspdfkit/document/DestinationType;", "getLeft", "()F", "getTop", "getWidth", "getHeight", "getZoom", "component1", "component2", "component3", "component4", "component5", "component6", "component7", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "toString", "", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class Destination {
    public static final int $stable = 0;
    private final float height;
    private final float left;
    private final int pageIndex;
    private final float top;
    private final DestinationType type;
    private final float width;
    private final float zoom;

    public Destination(int i, DestinationType destinationType, float f, float f2, float f3, float f4, float f5) {
        destinationType.getClass();
        this.pageIndex = i;
        this.type = destinationType;
        this.left = f;
        this.top = f2;
        this.width = f3;
        this.height = f4;
        this.zoom = f5;
    }

    public static /* synthetic */ Destination copy$default(Destination destination, int i, DestinationType destinationType, float f, float f2, float f3, float f4, float f5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = destination.pageIndex;
        }
        if ((i2 & 2) != 0) {
            destinationType = destination.type;
        }
        if ((i2 & 4) != 0) {
            f = destination.left;
        }
        if ((i2 & 8) != 0) {
            f2 = destination.top;
        }
        if ((i2 & 16) != 0) {
            f3 = destination.width;
        }
        if ((i2 & 32) != 0) {
            f4 = destination.height;
        }
        if ((i2 & 64) != 0) {
            f5 = destination.zoom;
        }
        float f6 = f4;
        float f7 = f5;
        float f8 = f3;
        float f9 = f;
        return destination.copy(i, destinationType, f9, f2, f8, f6, f7);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getPageIndex() {
        return this.pageIndex;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final DestinationType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final float getLeft() {
        return this.left;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final float getTop() {
        return this.top;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final float getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final float getHeight() {
        return this.height;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final float getZoom() {
        return this.zoom;
    }

    public final Destination copy(int pageIndex, DestinationType type, float left, float top, float width, float height, float zoom) {
        type.getClass();
        return new Destination(pageIndex, type, left, top, width, height, zoom);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Destination)) {
            return false;
        }
        Destination destination = (Destination) other;
        return this.pageIndex == destination.pageIndex && this.type == destination.type && Float.compare(this.left, destination.left) == 0 && Float.compare(this.top, destination.top) == 0 && Float.compare(this.width, destination.width) == 0 && Float.compare(this.height, destination.height) == 0 && Float.compare(this.zoom, destination.zoom) == 0;
    }

    public final float getHeight() {
        return this.height;
    }

    public final float getLeft() {
        return this.left;
    }

    public final int getPageIndex() {
        return this.pageIndex;
    }

    public final float getTop() {
        return this.top;
    }

    public final DestinationType getType() {
        return this.type;
    }

    public final float getWidth() {
        return this.width;
    }

    public final float getZoom() {
        return this.zoom;
    }

    public int hashCode() {
        return Float.hashCode(this.zoom) + kv.a(this.height, kv.a(this.width, kv.a(this.top, kv.a(this.left, (this.type.hashCode() + (Integer.hashCode(this.pageIndex) * 31)) * 31, 31), 31), 31), 31);
    }

    public String toString() {
        return "Destination(pageIndex=" + this.pageIndex + ", type=" + this.type + ", left=" + this.left + ", top=" + this.top + ", width=" + this.width + ", height=" + this.height + ", zoom=" + this.zoom + ")";
    }
}
