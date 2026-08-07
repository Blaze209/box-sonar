package expo.modules.ui;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.kotlin.views.ComposeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HostView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001Bm\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0003\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0003¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003J\u0011\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0003HÆ\u0003J\u0011\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0003HÆ\u0003Jo\u0010\u001b\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u0010\b\u0002\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00032\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0019\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0019\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000f¨\u0006#"}, d2 = {"Lexpo/modules/ui/HostProps;", "Lexpo/modules/kotlin/views/ComposeProps;", "colorScheme", "Landroidx/compose/runtime/MutableState;", "Lexpo/modules/ui/ExpoColorScheme;", ViewProps.LAYOUT_DIRECTION, "Lexpo/modules/ui/ExpoLayoutDirection;", "useViewportSizeMeasurement", "", "ignoreSafeAreaKeyboardInsets", "matchContentsHorizontal", "matchContentsVertical", "<init>", "(Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;)V", "getColorScheme", "()Landroidx/compose/runtime/MutableState;", "getLayoutDirection", "getUseViewportSizeMeasurement", "getIgnoreSafeAreaKeyboardInsets", "getMatchContentsHorizontal", "getMatchContentsVertical", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class HostProps implements ComposeProps {
    public static final int $stable = 0;
    private final MutableState<ExpoColorScheme> colorScheme;
    private final MutableState<Boolean> ignoreSafeAreaKeyboardInsets;
    private final MutableState<ExpoLayoutDirection> layoutDirection;
    private final MutableState<Boolean> matchContentsHorizontal;
    private final MutableState<Boolean> matchContentsVertical;
    private final MutableState<Boolean> useViewportSizeMeasurement;

    public HostProps() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HostProps copy$default(HostProps hostProps, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5, MutableState mutableState6, int i, Object obj) {
        if ((i & 1) != 0) {
            mutableState = hostProps.colorScheme;
        }
        if ((i & 2) != 0) {
            mutableState2 = hostProps.layoutDirection;
        }
        if ((i & 4) != 0) {
            mutableState3 = hostProps.useViewportSizeMeasurement;
        }
        if ((i & 8) != 0) {
            mutableState4 = hostProps.ignoreSafeAreaKeyboardInsets;
        }
        if ((i & 16) != 0) {
            mutableState5 = hostProps.matchContentsHorizontal;
        }
        if ((i & 32) != 0) {
            mutableState6 = hostProps.matchContentsVertical;
        }
        MutableState mutableState7 = mutableState5;
        MutableState mutableState8 = mutableState6;
        return hostProps.copy(mutableState, mutableState2, mutableState3, mutableState4, mutableState7, mutableState8);
    }

    public final MutableState<ExpoColorScheme> component1() {
        return this.colorScheme;
    }

    public final MutableState<ExpoLayoutDirection> component2() {
        return this.layoutDirection;
    }

    public final MutableState<Boolean> component3() {
        return this.useViewportSizeMeasurement;
    }

    public final MutableState<Boolean> component4() {
        return this.ignoreSafeAreaKeyboardInsets;
    }

    public final MutableState<Boolean> component5() {
        return this.matchContentsHorizontal;
    }

    public final MutableState<Boolean> component6() {
        return this.matchContentsVertical;
    }

    public final HostProps copy(MutableState<ExpoColorScheme> colorScheme, MutableState<ExpoLayoutDirection> layoutDirection, MutableState<Boolean> useViewportSizeMeasurement, MutableState<Boolean> ignoreSafeAreaKeyboardInsets, MutableState<Boolean> matchContentsHorizontal, MutableState<Boolean> matchContentsVertical) {
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(useViewportSizeMeasurement, "useViewportSizeMeasurement");
        Intrinsics.checkNotNullParameter(ignoreSafeAreaKeyboardInsets, "ignoreSafeAreaKeyboardInsets");
        Intrinsics.checkNotNullParameter(matchContentsHorizontal, "matchContentsHorizontal");
        Intrinsics.checkNotNullParameter(matchContentsVertical, "matchContentsVertical");
        return new HostProps(colorScheme, layoutDirection, useViewportSizeMeasurement, ignoreSafeAreaKeyboardInsets, matchContentsHorizontal, matchContentsVertical);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HostProps)) {
            return false;
        }
        HostProps hostProps = (HostProps) other;
        return Intrinsics.areEqual(this.colorScheme, hostProps.colorScheme) && Intrinsics.areEqual(this.layoutDirection, hostProps.layoutDirection) && Intrinsics.areEqual(this.useViewportSizeMeasurement, hostProps.useViewportSizeMeasurement) && Intrinsics.areEqual(this.ignoreSafeAreaKeyboardInsets, hostProps.ignoreSafeAreaKeyboardInsets) && Intrinsics.areEqual(this.matchContentsHorizontal, hostProps.matchContentsHorizontal) && Intrinsics.areEqual(this.matchContentsVertical, hostProps.matchContentsVertical);
    }

    public int hashCode() {
        return (((((((((this.colorScheme.hashCode() * 31) + this.layoutDirection.hashCode()) * 31) + this.useViewportSizeMeasurement.hashCode()) * 31) + this.ignoreSafeAreaKeyboardInsets.hashCode()) * 31) + this.matchContentsHorizontal.hashCode()) * 31) + this.matchContentsVertical.hashCode();
    }

    public String toString() {
        return "HostProps(colorScheme=" + this.colorScheme + ", layoutDirection=" + this.layoutDirection + ", useViewportSizeMeasurement=" + this.useViewportSizeMeasurement + ", ignoreSafeAreaKeyboardInsets=" + this.ignoreSafeAreaKeyboardInsets + ", matchContentsHorizontal=" + this.matchContentsHorizontal + ", matchContentsVertical=" + this.matchContentsVertical + ")";
    }

    public HostProps(MutableState<ExpoColorScheme> colorScheme, MutableState<ExpoLayoutDirection> layoutDirection, MutableState<Boolean> useViewportSizeMeasurement, MutableState<Boolean> ignoreSafeAreaKeyboardInsets, MutableState<Boolean> matchContentsHorizontal, MutableState<Boolean> matchContentsVertical) {
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(useViewportSizeMeasurement, "useViewportSizeMeasurement");
        Intrinsics.checkNotNullParameter(ignoreSafeAreaKeyboardInsets, "ignoreSafeAreaKeyboardInsets");
        Intrinsics.checkNotNullParameter(matchContentsHorizontal, "matchContentsHorizontal");
        Intrinsics.checkNotNullParameter(matchContentsVertical, "matchContentsVertical");
        this.colorScheme = colorScheme;
        this.layoutDirection = layoutDirection;
        this.useViewportSizeMeasurement = useViewportSizeMeasurement;
        this.ignoreSafeAreaKeyboardInsets = ignoreSafeAreaKeyboardInsets;
        this.matchContentsHorizontal = matchContentsHorizontal;
        this.matchContentsVertical = matchContentsVertical;
    }

    public /* synthetic */ HostProps(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5, MutableState mutableState6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null) : mutableState, (i & 2) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ExpoLayoutDirection.LeftToRight, null, 2, null) : mutableState2, (i & 4) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null) : mutableState3, (i & 8) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null) : mutableState4, (i & 16) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null) : mutableState5, (i & 32) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null) : mutableState6);
    }

    public final MutableState<ExpoColorScheme> getColorScheme() {
        return this.colorScheme;
    }

    public final MutableState<ExpoLayoutDirection> getLayoutDirection() {
        return this.layoutDirection;
    }

    public final MutableState<Boolean> getUseViewportSizeMeasurement() {
        return this.useViewportSizeMeasurement;
    }

    public final MutableState<Boolean> getIgnoreSafeAreaKeyboardInsets() {
        return this.ignoreSafeAreaKeyboardInsets;
    }

    public final MutableState<Boolean> getMatchContentsHorizontal() {
        return this.matchContentsHorizontal;
    }

    public final MutableState<Boolean> getMatchContentsVertical() {
        return this.matchContentsVertical;
    }
}
