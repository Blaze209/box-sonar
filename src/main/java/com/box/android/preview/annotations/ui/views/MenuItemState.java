package com.box.android.preview.annotations.ui.views;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: BoxPopupWindow.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/preview/annotations/ui/views/MenuItemState;", "", "isVisible", "", "isEnabled", "<init>", "(ZZ)V", "()Z", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MenuItemState {
    public static final int $stable = 0;
    private final boolean isEnabled;
    private final boolean isVisible;

    /* JADX WARN: Illegal instructions before constructor call */
    public MenuItemState() {
        boolean z = false;
        this(z, z, 3, null);
    }

    public static /* synthetic */ MenuItemState copy$default(MenuItemState menuItemState, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = menuItemState.isVisible;
        }
        if ((i & 2) != 0) {
            z2 = menuItemState.isEnabled;
        }
        return menuItemState.copy(z, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsVisible() {
        return this.isVisible;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsEnabled() {
        return this.isEnabled;
    }

    public final MenuItemState copy(boolean isVisible, boolean isEnabled) {
        return new MenuItemState(isVisible, isEnabled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MenuItemState)) {
            return false;
        }
        MenuItemState menuItemState = (MenuItemState) other;
        return this.isVisible == menuItemState.isVisible && this.isEnabled == menuItemState.isEnabled;
    }

    public int hashCode() {
        return (Boolean.hashCode(this.isVisible) * 31) + Boolean.hashCode(this.isEnabled);
    }

    public String toString() {
        return "MenuItemState(isVisible=" + this.isVisible + ", isEnabled=" + this.isEnabled + ")";
    }

    public MenuItemState(boolean z, boolean z2) {
        this.isVisible = z;
        this.isEnabled = z2;
    }

    public /* synthetic */ MenuItemState(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? true : z2);
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }
}
