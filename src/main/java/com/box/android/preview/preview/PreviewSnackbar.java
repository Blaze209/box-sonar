package com.box.android.preview.preview;

import androidx.compose.material3.SnackbarDuration;
import com.box.android.base.compose.SnackbarAction;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.pspdfkit.analytics.Analytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviewSnackbars.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\tHÆ\u0003J:\u0010\u0019\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/box/android/preview/preview/PreviewSnackbar;", "", "messageRes", "", Analytics.Data.ACTION, "Lcom/box/android/preview/preview/PreviewReducer$Action;", "duration", "Landroidx/compose/material3/SnackbarDuration;", "snackbarAction", "Lcom/box/android/base/compose/SnackbarAction;", "<init>", "(Ljava/lang/Integer;Lcom/box/android/preview/preview/PreviewReducer$Action;Landroidx/compose/material3/SnackbarDuration;Lcom/box/android/base/compose/SnackbarAction;)V", "getMessageRes", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAction", "()Lcom/box/android/preview/preview/PreviewReducer$Action;", "getDuration", "()Landroidx/compose/material3/SnackbarDuration;", "getSnackbarAction", "()Lcom/box/android/base/compose/SnackbarAction;", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/Integer;Lcom/box/android/preview/preview/PreviewReducer$Action;Landroidx/compose/material3/SnackbarDuration;Lcom/box/android/base/compose/SnackbarAction;)Lcom/box/android/preview/preview/PreviewSnackbar;", "equals", "", "other", "hashCode", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class PreviewSnackbar {
    public static final int $stable = SnackbarAction.$stable;
    private final PreviewReducer.Action action;
    private final SnackbarDuration duration;
    private final Integer messageRes;
    private final SnackbarAction snackbarAction;

    public static /* synthetic */ PreviewSnackbar copy$default(PreviewSnackbar previewSnackbar, Integer num, PreviewReducer.Action action, SnackbarDuration snackbarDuration, SnackbarAction snackbarAction, int i, Object obj) {
        if ((i & 1) != 0) {
            num = previewSnackbar.messageRes;
        }
        if ((i & 2) != 0) {
            action = previewSnackbar.action;
        }
        if ((i & 4) != 0) {
            snackbarDuration = previewSnackbar.duration;
        }
        if ((i & 8) != 0) {
            snackbarAction = previewSnackbar.snackbarAction;
        }
        return previewSnackbar.copy(num, action, snackbarDuration, snackbarAction);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getMessageRes() {
        return this.messageRes;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final PreviewReducer.Action getAction() {
        return this.action;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final SnackbarDuration getDuration() {
        return this.duration;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final SnackbarAction getSnackbarAction() {
        return this.snackbarAction;
    }

    public final PreviewSnackbar copy(Integer messageRes, PreviewReducer.Action action, SnackbarDuration duration, SnackbarAction snackbarAction) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(duration, "duration");
        return new PreviewSnackbar(messageRes, action, duration, snackbarAction);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PreviewSnackbar)) {
            return false;
        }
        PreviewSnackbar previewSnackbar = (PreviewSnackbar) other;
        return Intrinsics.areEqual(this.messageRes, previewSnackbar.messageRes) && Intrinsics.areEqual(this.action, previewSnackbar.action) && this.duration == previewSnackbar.duration && Intrinsics.areEqual(this.snackbarAction, previewSnackbar.snackbarAction);
    }

    public int hashCode() {
        Integer num = this.messageRes;
        int iHashCode = (((((num == null ? 0 : num.hashCode()) * 31) + this.action.hashCode()) * 31) + this.duration.hashCode()) * 31;
        SnackbarAction snackbarAction = this.snackbarAction;
        return iHashCode + (snackbarAction != null ? snackbarAction.hashCode() : 0);
    }

    public String toString() {
        return "PreviewSnackbar(messageRes=" + this.messageRes + ", action=" + this.action + ", duration=" + this.duration + ", snackbarAction=" + this.snackbarAction + ")";
    }

    public PreviewSnackbar(Integer num, PreviewReducer.Action action, SnackbarDuration duration, SnackbarAction snackbarAction) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(duration, "duration");
        this.messageRes = num;
        this.action = action;
        this.duration = duration;
        this.snackbarAction = snackbarAction;
    }

    public final Integer getMessageRes() {
        return this.messageRes;
    }

    public final PreviewReducer.Action getAction() {
        return this.action;
    }

    public /* synthetic */ PreviewSnackbar(Integer num, PreviewReducer.Action action, SnackbarDuration snackbarDuration, SnackbarAction snackbarAction, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(num, action, (i & 4) != 0 ? SnackbarDuration.Short : snackbarDuration, (i & 8) != 0 ? null : snackbarAction);
    }

    public final SnackbarDuration getDuration() {
        return this.duration;
    }

    public final SnackbarAction getSnackbarAction() {
        return this.snackbarAction;
    }
}
