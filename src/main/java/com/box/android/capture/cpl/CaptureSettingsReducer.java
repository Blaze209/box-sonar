package com.box.android.capture.cpl;

import com.box.android.cpl.Effect;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.models.capture.PhotoQuality;
import com.box.android.domain.models.capture.VideoQuality;
import com.pspdfkit.analytics.Analytics;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CaptureSettingsReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0010\u0011B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/box/android/capture/cpl/CaptureSettingsReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/capture/cpl/CaptureSettingsReducer$State;", "Lcom/box/android/capture/cpl/CaptureSettingsReducer$Action;", "environment", "Lcom/box/android/capture/cpl/CaptureSettingsEnvironment;", "<init>", "(Lcom/box/android/capture/cpl/CaptureSettingsEnvironment;)V", "reduce", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "sendCaptureModeToggleAmplitudeEvent", "", "enabled", "", "State", "Action", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CaptureSettingsReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final CaptureSettingsEnvironment environment;

    public CaptureSettingsReducer(CaptureSettingsEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ Reducable<State, Action> getBuild() {
        return Reducable.DefaultImpls.getBuild(this);
    }

    /* JADX INFO: compiled from: CaptureSettingsReducer.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006$"}, d2 = {"Lcom/box/android/capture/cpl/CaptureSettingsReducer$State;", "Lcom/box/android/capture/cpl/CaptureModeState;", "launchIntoCapture", "", "reviewPhotoAfterCapture", "photoQuality", "Lcom/box/android/domain/models/capture/PhotoQuality;", "videoQuality", "Lcom/box/android/domain/models/capture/VideoQuality;", "saveGpsLocation", "launchIntoCaptureDialog", "<init>", "(ZZLcom/box/android/domain/models/capture/PhotoQuality;Lcom/box/android/domain/models/capture/VideoQuality;ZZ)V", "getLaunchIntoCapture", "()Z", "getReviewPhotoAfterCapture", "getPhotoQuality", "()Lcom/box/android/domain/models/capture/PhotoQuality;", "getVideoQuality", "()Lcom/box/android/domain/models/capture/VideoQuality;", "getSaveGpsLocation", "getLaunchIntoCaptureDialog", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State extends CaptureModeState {
        public static final int $stable = 0;
        private final boolean launchIntoCapture;
        private final boolean launchIntoCaptureDialog;
        private final PhotoQuality photoQuality;
        private final boolean reviewPhotoAfterCapture;
        private final boolean saveGpsLocation;
        private final VideoQuality videoQuality;

        public static /* synthetic */ State copy$default(State state, boolean z, boolean z2, PhotoQuality photoQuality, VideoQuality videoQuality, boolean z3, boolean z4, int i, Object obj) {
            if ((i & 1) != 0) {
                z = state.launchIntoCapture;
            }
            if ((i & 2) != 0) {
                z2 = state.reviewPhotoAfterCapture;
            }
            if ((i & 4) != 0) {
                photoQuality = state.photoQuality;
            }
            if ((i & 8) != 0) {
                videoQuality = state.videoQuality;
            }
            if ((i & 16) != 0) {
                z3 = state.saveGpsLocation;
            }
            if ((i & 32) != 0) {
                z4 = state.launchIntoCaptureDialog;
            }
            boolean z5 = z3;
            boolean z6 = z4;
            return state.copy(z, z2, photoQuality, videoQuality, z5, z6);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getLaunchIntoCapture() {
            return this.launchIntoCapture;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getReviewPhotoAfterCapture() {
            return this.reviewPhotoAfterCapture;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final PhotoQuality getPhotoQuality() {
            return this.photoQuality;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final VideoQuality getVideoQuality() {
            return this.videoQuality;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getSaveGpsLocation() {
            return this.saveGpsLocation;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final boolean getLaunchIntoCaptureDialog() {
            return this.launchIntoCaptureDialog;
        }

        public final State copy(boolean launchIntoCapture, boolean reviewPhotoAfterCapture, PhotoQuality photoQuality, VideoQuality videoQuality, boolean saveGpsLocation, boolean launchIntoCaptureDialog) {
            Intrinsics.checkNotNullParameter(photoQuality, "photoQuality");
            Intrinsics.checkNotNullParameter(videoQuality, "videoQuality");
            return new State(launchIntoCapture, reviewPhotoAfterCapture, photoQuality, videoQuality, saveGpsLocation, launchIntoCaptureDialog);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return this.launchIntoCapture == state.launchIntoCapture && this.reviewPhotoAfterCapture == state.reviewPhotoAfterCapture && this.photoQuality == state.photoQuality && this.videoQuality == state.videoQuality && this.saveGpsLocation == state.saveGpsLocation && this.launchIntoCaptureDialog == state.launchIntoCaptureDialog;
        }

        public int hashCode() {
            return (((((((((Boolean.hashCode(this.launchIntoCapture) * 31) + Boolean.hashCode(this.reviewPhotoAfterCapture)) * 31) + this.photoQuality.hashCode()) * 31) + this.videoQuality.hashCode()) * 31) + Boolean.hashCode(this.saveGpsLocation)) * 31) + Boolean.hashCode(this.launchIntoCaptureDialog);
        }

        public String toString() {
            return "State(launchIntoCapture=" + this.launchIntoCapture + ", reviewPhotoAfterCapture=" + this.reviewPhotoAfterCapture + ", photoQuality=" + this.photoQuality + ", videoQuality=" + this.videoQuality + ", saveGpsLocation=" + this.saveGpsLocation + ", launchIntoCaptureDialog=" + this.launchIntoCaptureDialog + ")";
        }

        public State(boolean z, boolean z2, PhotoQuality photoQuality, VideoQuality videoQuality, boolean z3, boolean z4) {
            Intrinsics.checkNotNullParameter(photoQuality, "photoQuality");
            Intrinsics.checkNotNullParameter(videoQuality, "videoQuality");
            this.launchIntoCapture = z;
            this.reviewPhotoAfterCapture = z2;
            this.photoQuality = photoQuality;
            this.videoQuality = videoQuality;
            this.saveGpsLocation = z3;
            this.launchIntoCaptureDialog = z4;
        }

        public /* synthetic */ State(boolean z, boolean z2, PhotoQuality photoQuality, VideoQuality videoQuality, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(z, z2, photoQuality, videoQuality, z3, (i & 32) != 0 ? false : z4);
        }

        public final boolean getLaunchIntoCapture() {
            return this.launchIntoCapture;
        }

        public final boolean getReviewPhotoAfterCapture() {
            return this.reviewPhotoAfterCapture;
        }

        public final PhotoQuality getPhotoQuality() {
            return this.photoQuality;
        }

        public final VideoQuality getVideoQuality() {
            return this.videoQuality;
        }

        public final boolean getSaveGpsLocation() {
            return this.saveGpsLocation;
        }

        public final boolean getLaunchIntoCaptureDialog() {
            return this.launchIntoCaptureDialog;
        }
    }

    /* JADX INFO: compiled from: CaptureSettingsReducer.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0007\u0004\u0005\u0006\u0007\b\t\nB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0007\u000b\f\r\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/box/android/capture/cpl/CaptureSettingsReducer$Action;", "", "<init>", "()V", "CloseSettings", "ToggleLaunchIntoCapture", "ToggleReviewPhotoAfterCapture", "ToggleGpsLocation", "SelectPhotoQuality", "SelectVideoQuality", "LaunchIntoCaptureDialogShown", "Lcom/box/android/capture/cpl/CaptureSettingsReducer$Action$CloseSettings;", "Lcom/box/android/capture/cpl/CaptureSettingsReducer$Action$LaunchIntoCaptureDialogShown;", "Lcom/box/android/capture/cpl/CaptureSettingsReducer$Action$SelectPhotoQuality;", "Lcom/box/android/capture/cpl/CaptureSettingsReducer$Action$SelectVideoQuality;", "Lcom/box/android/capture/cpl/CaptureSettingsReducer$Action$ToggleGpsLocation;", "Lcom/box/android/capture/cpl/CaptureSettingsReducer$Action$ToggleLaunchIntoCapture;", "Lcom/box/android/capture/cpl/CaptureSettingsReducer$Action$ToggleReviewPhotoAfterCapture;", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: CaptureSettingsReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/capture/cpl/CaptureSettingsReducer$Action$CloseSettings;", "Lcom/box/android/capture/cpl/CaptureSettingsReducer$Action;", "<init>", "()V", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class CloseSettings extends Action {
            public static final int $stable = 0;
            public static final CloseSettings INSTANCE = new CloseSettings();

            private CloseSettings() {
                super(null);
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: CaptureSettingsReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/capture/cpl/CaptureSettingsReducer$Action$ToggleLaunchIntoCapture;", "Lcom/box/android/capture/cpl/CaptureSettingsReducer$Action;", "<init>", "()V", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class ToggleLaunchIntoCapture extends Action {
            public static final int $stable = 0;
            public static final ToggleLaunchIntoCapture INSTANCE = new ToggleLaunchIntoCapture();

            private ToggleLaunchIntoCapture() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: CaptureSettingsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/capture/cpl/CaptureSettingsReducer$Action$ToggleReviewPhotoAfterCapture;", "Lcom/box/android/capture/cpl/CaptureSettingsReducer$Action;", "enable", "", "<init>", "(Z)V", "getEnable", "()Z", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ToggleReviewPhotoAfterCapture extends Action {
            public static final int $stable = 0;
            private final boolean enable;

            public static /* synthetic */ ToggleReviewPhotoAfterCapture copy$default(ToggleReviewPhotoAfterCapture toggleReviewPhotoAfterCapture, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = toggleReviewPhotoAfterCapture.enable;
                }
                return toggleReviewPhotoAfterCapture.copy(z);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getEnable() {
                return this.enable;
            }

            public final ToggleReviewPhotoAfterCapture copy(boolean enable) {
                return new ToggleReviewPhotoAfterCapture(enable);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ToggleReviewPhotoAfterCapture) && this.enable == ((ToggleReviewPhotoAfterCapture) other).enable;
            }

            public int hashCode() {
                return Boolean.hashCode(this.enable);
            }

            public String toString() {
                return "ToggleReviewPhotoAfterCapture(enable=" + this.enable + ")";
            }

            public ToggleReviewPhotoAfterCapture(boolean z) {
                super(null);
                this.enable = z;
            }

            public final boolean getEnable() {
                return this.enable;
            }
        }

        /* JADX INFO: compiled from: CaptureSettingsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/capture/cpl/CaptureSettingsReducer$Action$ToggleGpsLocation;", "Lcom/box/android/capture/cpl/CaptureSettingsReducer$Action;", "enable", "", "<init>", "(Z)V", "getEnable", "()Z", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ToggleGpsLocation extends Action {
            public static final int $stable = 0;
            private final boolean enable;

            public static /* synthetic */ ToggleGpsLocation copy$default(ToggleGpsLocation toggleGpsLocation, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = toggleGpsLocation.enable;
                }
                return toggleGpsLocation.copy(z);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getEnable() {
                return this.enable;
            }

            public final ToggleGpsLocation copy(boolean enable) {
                return new ToggleGpsLocation(enable);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ToggleGpsLocation) && this.enable == ((ToggleGpsLocation) other).enable;
            }

            public int hashCode() {
                return Boolean.hashCode(this.enable);
            }

            public String toString() {
                return "ToggleGpsLocation(enable=" + this.enable + ")";
            }

            public ToggleGpsLocation(boolean z) {
                super(null);
                this.enable = z;
            }

            public final boolean getEnable() {
                return this.enable;
            }
        }

        /* JADX INFO: compiled from: CaptureSettingsReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/capture/cpl/CaptureSettingsReducer$Action$SelectPhotoQuality;", "Lcom/box/android/capture/cpl/CaptureSettingsReducer$Action;", "photoQuality", "Lcom/box/android/domain/models/capture/PhotoQuality;", "<init>", "(Lcom/box/android/domain/models/capture/PhotoQuality;)V", "getPhotoQuality", "()Lcom/box/android/domain/models/capture/PhotoQuality;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SelectPhotoQuality extends Action {
            public static final int $stable = 0;
            private final PhotoQuality photoQuality;

            public static /* synthetic */ SelectPhotoQuality copy$default(SelectPhotoQuality selectPhotoQuality, PhotoQuality photoQuality, int i, Object obj) {
                if ((i & 1) != 0) {
                    photoQuality = selectPhotoQuality.photoQuality;
                }
                return selectPhotoQuality.copy(photoQuality);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final PhotoQuality getPhotoQuality() {
                return this.photoQuality;
            }

            public final SelectPhotoQuality copy(PhotoQuality photoQuality) {
                Intrinsics.checkNotNullParameter(photoQuality, "photoQuality");
                return new SelectPhotoQuality(photoQuality);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SelectPhotoQuality) && this.photoQuality == ((SelectPhotoQuality) other).photoQuality;
            }

            public int hashCode() {
                return this.photoQuality.hashCode();
            }

            public String toString() {
                return "SelectPhotoQuality(photoQuality=" + this.photoQuality + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SelectPhotoQuality(PhotoQuality photoQuality) {
                super(null);
                Intrinsics.checkNotNullParameter(photoQuality, "photoQuality");
                this.photoQuality = photoQuality;
            }

            public final PhotoQuality getPhotoQuality() {
                return this.photoQuality;
            }
        }

        /* JADX INFO: compiled from: CaptureSettingsReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/capture/cpl/CaptureSettingsReducer$Action$SelectVideoQuality;", "Lcom/box/android/capture/cpl/CaptureSettingsReducer$Action;", "videoQuality", "Lcom/box/android/domain/models/capture/VideoQuality;", "<init>", "(Lcom/box/android/domain/models/capture/VideoQuality;)V", "getVideoQuality", "()Lcom/box/android/domain/models/capture/VideoQuality;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SelectVideoQuality extends Action {
            public static final int $stable = 0;
            private final VideoQuality videoQuality;

            public static /* synthetic */ SelectVideoQuality copy$default(SelectVideoQuality selectVideoQuality, VideoQuality videoQuality, int i, Object obj) {
                if ((i & 1) != 0) {
                    videoQuality = selectVideoQuality.videoQuality;
                }
                return selectVideoQuality.copy(videoQuality);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final VideoQuality getVideoQuality() {
                return this.videoQuality;
            }

            public final SelectVideoQuality copy(VideoQuality videoQuality) {
                Intrinsics.checkNotNullParameter(videoQuality, "videoQuality");
                return new SelectVideoQuality(videoQuality);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SelectVideoQuality) && this.videoQuality == ((SelectVideoQuality) other).videoQuality;
            }

            public int hashCode() {
                return this.videoQuality.hashCode();
            }

            public String toString() {
                return "SelectVideoQuality(videoQuality=" + this.videoQuality + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SelectVideoQuality(VideoQuality videoQuality) {
                super(null);
                Intrinsics.checkNotNullParameter(videoQuality, "videoQuality");
                this.videoQuality = videoQuality;
            }

            public final VideoQuality getVideoQuality() {
                return this.videoQuality;
            }
        }

        /* JADX INFO: compiled from: CaptureSettingsReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/capture/cpl/CaptureSettingsReducer$Action$LaunchIntoCaptureDialogShown;", "Lcom/box/android/capture/cpl/CaptureSettingsReducer$Action;", "<init>", "()V", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class LaunchIntoCaptureDialogShown extends Action {
            public static final int $stable = 0;
            public static final LaunchIntoCaptureDialogShown INSTANCE = new LaunchIntoCaptureDialogShown();

            private LaunchIntoCaptureDialogShown() {
                super(null);
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public ReducerResult<State, Action> reduce(State state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (action instanceof Action.ToggleLaunchIntoCapture) {
            boolean z = !state.getLaunchIntoCapture();
            return new ReducerResult<>(State.copy$default(state, z, false, null, null, false, z, 30, null), Effect.INSTANCE.fireAndForget(new AnonymousClass1(z, null)));
        }
        if (action instanceof Action.ToggleReviewPhotoAfterCapture) {
            return new ReducerResult<>(State.copy$default(state, false, ((Action.ToggleReviewPhotoAfterCapture) action).getEnable(), null, null, false, false, 61, null), Effect.INSTANCE.fireAndForget(new AnonymousClass2(action, null)));
        }
        if (action instanceof Action.SelectPhotoQuality) {
            return new ReducerResult<>(State.copy$default(state, false, false, ((Action.SelectPhotoQuality) action).getPhotoQuality(), null, false, false, 59, null), Effect.INSTANCE.fireAndForget(new AnonymousClass3(action, null)));
        }
        if (action instanceof Action.SelectVideoQuality) {
            return new ReducerResult<>(State.copy$default(state, false, false, null, ((Action.SelectVideoQuality) action).getVideoQuality(), false, false, 55, null), Effect.INSTANCE.fireAndForget(new AnonymousClass4(action, null)));
        }
        if (action instanceof Action.ToggleGpsLocation) {
            return new ReducerResult<>(State.copy$default(state, false, false, null, null, ((Action.ToggleGpsLocation) action).getEnable(), false, 47, null), Effect.INSTANCE.fireAndForget(new AnonymousClass5(action, null)));
        }
        if (action instanceof Action.LaunchIntoCaptureDialogShown) {
            return new ReducerResult<>(State.copy$default(state, false, false, null, null, false, false, 31, null), null, 2, null);
        }
        if (action instanceof Action.CloseSettings) {
            return new ReducerResult<>(state, null, 2, null);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: renamed from: com.box.android.capture.cpl.CaptureSettingsReducer$reduce$1, reason: invalid class name */
    /* JADX INFO: compiled from: CaptureSettingsReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.cpl.CaptureSettingsReducer$reduce$1", f = "CaptureSettingsReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $enabled;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(boolean z, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.$enabled = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return CaptureSettingsReducer.this.new AnonymousClass1(this.$enabled, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                CaptureSettingsReducer.this.environment.getLaunchIntoCaptureUseCase().setLaunchIntoCapturePreference(this.$enabled);
                if (this.$enabled) {
                    CaptureSettingsReducer.this.environment.getLaunchIntoCaptureUseCase().clearPending();
                }
                CaptureSettingsReducer.this.sendCaptureModeToggleAmplitudeEvent(this.$enabled);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.box.android.capture.cpl.CaptureSettingsReducer$reduce$2, reason: invalid class name */
    /* JADX INFO: compiled from: CaptureSettingsReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.cpl.CaptureSettingsReducer$reduce$2", f = "CaptureSettingsReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Action $action;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Action action, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.$action = action;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return CaptureSettingsReducer.this.new AnonymousClass2(this.$action, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CaptureSettingsReducer.this.environment.getCapturePreferencesService().setReviewPhotoAfterCapture(((Action.ToggleReviewPhotoAfterCapture) this.$action).getEnable());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.box.android.capture.cpl.CaptureSettingsReducer$reduce$3, reason: invalid class name */
    /* JADX INFO: compiled from: CaptureSettingsReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.cpl.CaptureSettingsReducer$reduce$3", f = "CaptureSettingsReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Action $action;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(Action action, Continuation<? super AnonymousClass3> continuation) {
            super(1, continuation);
            this.$action = action;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return CaptureSettingsReducer.this.new AnonymousClass3(this.$action, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                CaptureSettingsReducer.this.environment.getCapturePreferencesService().setPhotoQuality(((Action.SelectPhotoQuality) this.$action).getPhotoQuality());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.box.android.capture.cpl.CaptureSettingsReducer$reduce$4, reason: invalid class name */
    /* JADX INFO: compiled from: CaptureSettingsReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.cpl.CaptureSettingsReducer$reduce$4", f = "CaptureSettingsReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass4 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Action $action;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(Action action, Continuation<? super AnonymousClass4> continuation) {
            super(1, continuation);
            this.$action = action;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return CaptureSettingsReducer.this.new AnonymousClass4(this.$action, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                CaptureSettingsReducer.this.environment.getCapturePreferencesService().setVideoQuality(((Action.SelectVideoQuality) this.$action).getVideoQuality());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.box.android.capture.cpl.CaptureSettingsReducer$reduce$5, reason: invalid class name */
    /* JADX INFO: compiled from: CaptureSettingsReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.cpl.CaptureSettingsReducer$reduce$5", f = "CaptureSettingsReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass5 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Action $action;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(Action action, Continuation<? super AnonymousClass5> continuation) {
            super(1, continuation);
            this.$action = action;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return CaptureSettingsReducer.this.new AnonymousClass5(this.$action, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass5) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                CaptureSettingsReducer.this.environment.getCapturePreferencesService().setSaveGpsLocation(((Action.ToggleGpsLocation) this.$action).getEnable());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendCaptureModeToggleAmplitudeEvent(boolean enabled) {
        String str;
        BoxAmplitudeAnalytics.EventPropertyBuilder eventPropertyBuilderCreateEventBuilder = BoxAmplitudeAnalytics.createEventBuilder();
        if (enabled) {
            str = BoxAnalyticsParams.EVENT_CAPTURE_MODE_ALWAYS_OPEN_TOGGLE_BUTTON_ENABLED;
        } else {
            str = BoxAnalyticsParams.EVENT_CAPTURE_MODE_ALWAYS_OPEN_TOGGLE_BUTTON_DISABLED;
        }
        eventPropertyBuilderCreateEventBuilder.logEvent(str);
    }
}
