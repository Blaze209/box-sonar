package androidx.compose.material3;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;

/* JADX INFO: compiled from: ListItem.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Landroidx/compose/material3/InteractiveListColorState;", "", "enabled", "", "selected", "dragged", "<init>", "(ZZZ)V", "getEnabled", "()Z", "getSelected", "getDragged", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final /* data */ class InteractiveListColorState {
    private final boolean dragged;
    private final boolean enabled;
    private final boolean selected;

    public static /* synthetic */ InteractiveListColorState copy$default(InteractiveListColorState interactiveListColorState, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = interactiveListColorState.enabled;
        }
        if ((i & 2) != 0) {
            z2 = interactiveListColorState.selected;
        }
        if ((i & 4) != 0) {
            z3 = interactiveListColorState.dragged;
        }
        return interactiveListColorState.copy(z, z2, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getSelected() {
        return this.selected;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getDragged() {
        return this.dragged;
    }

    public final InteractiveListColorState copy(boolean enabled, boolean selected, boolean dragged) {
        return new InteractiveListColorState(enabled, selected, dragged);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InteractiveListColorState)) {
            return false;
        }
        InteractiveListColorState interactiveListColorState = (InteractiveListColorState) other;
        return this.enabled == interactiveListColorState.enabled && this.selected == interactiveListColorState.selected && this.dragged == interactiveListColorState.dragged;
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.enabled) * 31) + Boolean.hashCode(this.selected)) * 31) + Boolean.hashCode(this.dragged);
    }

    public String toString() {
        return "InteractiveListColorState(enabled=" + this.enabled + ", selected=" + this.selected + ", dragged=" + this.dragged + ')';
    }

    public InteractiveListColorState(boolean z, boolean z2, boolean z3) {
        this.enabled = z;
        this.selected = z2;
        this.dragged = z3;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    public final boolean getDragged() {
        return this.dragged;
    }
}
