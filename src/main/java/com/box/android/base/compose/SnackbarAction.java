package com.box.android.base.compose;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SnackbarMessage.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/box/android/base/compose/SnackbarAction;", "", "label", "", ViewProps.ON_CLICK, "Lkotlin/Function0;", "", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getLabel", "()Ljava/lang/String;", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class SnackbarAction {
    public static final int $stable = 0;
    private final String label;
    private final Function0<Unit> onClick;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SnackbarAction copy$default(SnackbarAction snackbarAction, String str, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = snackbarAction.label;
        }
        if ((i & 2) != 0) {
            function0 = snackbarAction.onClick;
        }
        return snackbarAction.copy(str, function0);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    public final Function0<Unit> component2() {
        return this.onClick;
    }

    public final SnackbarAction copy(String label, Function0<Unit> onClick) {
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        return new SnackbarAction(label, onClick);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SnackbarAction)) {
            return false;
        }
        SnackbarAction snackbarAction = (SnackbarAction) other;
        return Intrinsics.areEqual(this.label, snackbarAction.label) && Intrinsics.areEqual(this.onClick, snackbarAction.onClick);
    }

    public int hashCode() {
        return (this.label.hashCode() * 31) + this.onClick.hashCode();
    }

    public String toString() {
        return "SnackbarAction(label=" + this.label + ", onClick=" + this.onClick + ")";
    }

    public SnackbarAction(String label, Function0<Unit> onClick) {
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.label = label;
        this.onClick = onClick;
    }

    public final String getLabel() {
        return this.label;
    }

    public final Function0<Unit> getOnClick() {
        return this.onClick;
    }
}
