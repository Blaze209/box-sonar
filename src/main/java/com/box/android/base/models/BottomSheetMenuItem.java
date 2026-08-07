package com.box.android.base.models;

import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.metrics.hubs.HubsObservability;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BottomSheetMenuItem.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002!\"B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0014\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003J5\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006#"}, d2 = {"Lcom/box/android/base/models/BottomSheetMenuItem;", "", "id", "", "title", "", HubsObservability.HUB_ASSET_ICON, "Landroid/graphics/drawable/Drawable;", "state", "Lcom/box/android/base/models/BottomSheetMenuItem$State;", "<init>", "(ILjava/lang/CharSequence;Landroid/graphics/drawable/Drawable;Lcom/box/android/base/models/BottomSheetMenuItem$State;)V", "getId", "()I", "getTitle", "()Ljava/lang/CharSequence;", "getIcon", "()Landroid/graphics/drawable/Drawable;", "getState", "()Lcom/box/android/base/models/BottomSheetMenuItem$State;", "withIcon", "withState", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "toString", "", "State", "Companion", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class BottomSheetMenuItem {
    private final Drawable icon;
    private final int id;
    private final State state;
    private final CharSequence title;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: BottomSheetMenuItem.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/box/android/base/models/BottomSheetMenuItem$State;", "", "<init>", "(Ljava/lang/String;I)V", "ENABLED", "DISABLED", "LOADING", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum State {
        ENABLED,
        DISABLED,
        LOADING;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<State> getEntries() {
            return $ENTRIES;
        }
    }

    public static /* synthetic */ BottomSheetMenuItem copy$default(BottomSheetMenuItem bottomSheetMenuItem, int i, CharSequence charSequence, Drawable drawable, State state, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = bottomSheetMenuItem.id;
        }
        if ((i2 & 2) != 0) {
            charSequence = bottomSheetMenuItem.title;
        }
        if ((i2 & 4) != 0) {
            drawable = bottomSheetMenuItem.icon;
        }
        if ((i2 & 8) != 0) {
            state = bottomSheetMenuItem.state;
        }
        return bottomSheetMenuItem.copy(i, charSequence, drawable, state);
    }

    @JvmStatic
    public static final BottomSheetMenuItem fromMenuItem(MenuItem menuItem) {
        return INSTANCE.fromMenuItem(menuItem);
    }

    @JvmStatic
    public static final BottomSheetMenuItem fromMenuItem(MenuItem menuItem, State state) {
        return INSTANCE.fromMenuItem(menuItem, state);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final CharSequence getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Drawable getIcon() {
        return this.icon;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final State getState() {
        return this.state;
    }

    public final BottomSheetMenuItem copy(int id, CharSequence title, Drawable icon, State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        return new BottomSheetMenuItem(id, title, icon, state);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BottomSheetMenuItem)) {
            return false;
        }
        BottomSheetMenuItem bottomSheetMenuItem = (BottomSheetMenuItem) other;
        return this.id == bottomSheetMenuItem.id && Intrinsics.areEqual(this.title, bottomSheetMenuItem.title) && Intrinsics.areEqual(this.icon, bottomSheetMenuItem.icon) && this.state == bottomSheetMenuItem.state;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.id) * 31;
        CharSequence charSequence = this.title;
        int iHashCode2 = (iHashCode + (charSequence == null ? 0 : charSequence.hashCode())) * 31;
        Drawable drawable = this.icon;
        return ((iHashCode2 + (drawable != null ? drawable.hashCode() : 0)) * 31) + this.state.hashCode();
    }

    public String toString() {
        int i = this.id;
        CharSequence charSequence = this.title;
        return "BottomSheetMenuItem(id=" + i + ", title=" + ((Object) charSequence) + ", icon=" + this.icon + ", state=" + this.state + ")";
    }

    public BottomSheetMenuItem(int i, CharSequence charSequence, Drawable drawable, State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.id = i;
        this.title = charSequence;
        this.icon = drawable;
        this.state = state;
    }

    public final int getId() {
        return this.id;
    }

    public final CharSequence getTitle() {
        return this.title;
    }

    public final Drawable getIcon() {
        return this.icon;
    }

    public /* synthetic */ BottomSheetMenuItem(int i, CharSequence charSequence, Drawable drawable, State state, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, charSequence, drawable, (i2 & 8) != 0 ? State.ENABLED : state);
    }

    public final State getState() {
        return this.state;
    }

    public final BottomSheetMenuItem withIcon(Drawable icon) {
        return copy$default(this, 0, null, icon, null, 11, null);
    }

    public final BottomSheetMenuItem withState(State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        return copy$default(this, 0, null, null, state, 7, null);
    }

    /* JADX INFO: compiled from: BottomSheetMenuItem.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/box/android/base/models/BottomSheetMenuItem$Companion;", "", "<init>", "()V", "fromMenuItem", "Lcom/box/android/base/models/BottomSheetMenuItem;", "menuItem", "Landroid/view/MenuItem;", "state", "Lcom/box/android/base/models/BottomSheetMenuItem$State;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final BottomSheetMenuItem fromMenuItem(MenuItem menuItem) {
            Intrinsics.checkNotNullParameter(menuItem, "menuItem");
            return fromMenuItem$default(this, menuItem, null, 2, null);
        }

        private Companion() {
        }

        public static /* synthetic */ BottomSheetMenuItem fromMenuItem$default(Companion companion, MenuItem menuItem, State state, int i, Object obj) {
            if ((i & 2) != 0) {
                state = State.ENABLED;
            }
            return companion.fromMenuItem(menuItem, state);
        }

        @JvmStatic
        public final BottomSheetMenuItem fromMenuItem(MenuItem menuItem, State state) {
            Intrinsics.checkNotNullParameter(menuItem, "menuItem");
            Intrinsics.checkNotNullParameter(state, "state");
            return new BottomSheetMenuItem(menuItem.getItemId(), menuItem.getTitle(), menuItem.getIcon(), state);
        }
    }
}
