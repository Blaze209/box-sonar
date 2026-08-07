package com.box.android.capture.cpl;

import androidx.camera.core.CameraSelector;
import com.box.android.cpl.Effect;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.capture.CaptureMode;
import com.box.android.domain.models.capture.FlashMode;
import com.box.android.domain.models.capture.PhotoQuality;
import com.pspdfkit.analytics.Analytics;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImageCaptureReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u000e\u000fB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/box/android/capture/cpl/ImageCaptureReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/capture/cpl/ImageCaptureReducer$State;", "Lcom/box/android/capture/cpl/ImageCaptureReducer$Action;", "environment", "Lcom/box/android/capture/cpl/CaptureEnvironment;", "<init>", "(Lcom/box/android/capture/cpl/CaptureEnvironment;)V", "reduce", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "cameraState", "Lcom/box/android/capture/cpl/ImageCaptureReducer$State$Camera;", "State", "Action", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ImageCaptureReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final CaptureEnvironment environment;

    public ImageCaptureReducer(CaptureEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ Reducable<State, Action> getBuild() {
        return Reducable.DefaultImpls.getBuild(this);
    }

    /* JADX INFO: compiled from: ImageCaptureReducer.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/capture/cpl/ImageCaptureReducer$State;", "Lcom/box/android/capture/cpl/CaptureModeState;", "<init>", "()V", "Initializing", "PermissionRequired", "Camera", "Review", "Lcom/box/android/capture/cpl/ImageCaptureReducer$State$Camera;", "Lcom/box/android/capture/cpl/ImageCaptureReducer$State$Initializing;", "Lcom/box/android/capture/cpl/ImageCaptureReducer$State$PermissionRequired;", "Lcom/box/android/capture/cpl/ImageCaptureReducer$State$Review;", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class State extends CaptureModeState {
        public static final int $stable = 0;

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: ImageCaptureReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/capture/cpl/ImageCaptureReducer$State$Initializing;", "Lcom/box/android/capture/cpl/ImageCaptureReducer$State;", "<init>", "()V", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Initializing extends State {
            public static final int $stable = 0;
            public static final Initializing INSTANCE = new Initializing();

            private Initializing() {
                super(null);
            }
        }

        private State() {
        }

        /* JADX INFO: compiled from: ImageCaptureReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/capture/cpl/ImageCaptureReducer$State$PermissionRequired;", "Lcom/box/android/capture/cpl/ImageCaptureReducer$State;", "<init>", "()V", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class PermissionRequired extends State {
            public static final int $stable = 0;
            public static final PermissionRequired INSTANCE = new PermissionRequired();

            private PermissionRequired() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ImageCaptureReducer.kt */
        @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/box/android/capture/cpl/ImageCaptureReducer$State$Camera;", "Lcom/box/android/capture/cpl/ImageCaptureReducer$State;", "flashMode", "Lcom/box/android/domain/models/capture/FlashMode;", "cameraSelector", "Landroidx/camera/core/CameraSelector;", "photoQuality", "Lcom/box/android/domain/models/capture/PhotoQuality;", "saveGpsLocation", "", "<init>", "(Lcom/box/android/domain/models/capture/FlashMode;Landroidx/camera/core/CameraSelector;Lcom/box/android/domain/models/capture/PhotoQuality;Z)V", "getFlashMode", "()Lcom/box/android/domain/models/capture/FlashMode;", "getCameraSelector", "()Landroidx/camera/core/CameraSelector;", "getPhotoQuality", "()Lcom/box/android/domain/models/capture/PhotoQuality;", "getSaveGpsLocation", "()Z", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Camera extends State {
            public static final int $stable = 8;
            private final CameraSelector cameraSelector;
            private final FlashMode flashMode;
            private final PhotoQuality photoQuality;
            private final boolean saveGpsLocation;

            public static /* synthetic */ Camera copy$default(Camera camera, FlashMode flashMode, CameraSelector cameraSelector, PhotoQuality photoQuality, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    flashMode = camera.flashMode;
                }
                if ((i & 2) != 0) {
                    cameraSelector = camera.cameraSelector;
                }
                if ((i & 4) != 0) {
                    photoQuality = camera.photoQuality;
                }
                if ((i & 8) != 0) {
                    z = camera.saveGpsLocation;
                }
                return camera.copy(flashMode, cameraSelector, photoQuality, z);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final FlashMode getFlashMode() {
                return this.flashMode;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final CameraSelector getCameraSelector() {
                return this.cameraSelector;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final PhotoQuality getPhotoQuality() {
                return this.photoQuality;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final boolean getSaveGpsLocation() {
                return this.saveGpsLocation;
            }

            public final Camera copy(FlashMode flashMode, CameraSelector cameraSelector, PhotoQuality photoQuality, boolean saveGpsLocation) {
                Intrinsics.checkNotNullParameter(flashMode, "flashMode");
                Intrinsics.checkNotNullParameter(cameraSelector, "cameraSelector");
                Intrinsics.checkNotNullParameter(photoQuality, "photoQuality");
                return new Camera(flashMode, cameraSelector, photoQuality, saveGpsLocation);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Camera)) {
                    return false;
                }
                Camera camera = (Camera) other;
                return this.flashMode == camera.flashMode && Intrinsics.areEqual(this.cameraSelector, camera.cameraSelector) && this.photoQuality == camera.photoQuality && this.saveGpsLocation == camera.saveGpsLocation;
            }

            public int hashCode() {
                return (((((this.flashMode.hashCode() * 31) + this.cameraSelector.hashCode()) * 31) + this.photoQuality.hashCode()) * 31) + Boolean.hashCode(this.saveGpsLocation);
            }

            public String toString() {
                return "Camera(flashMode=" + this.flashMode + ", cameraSelector=" + this.cameraSelector + ", photoQuality=" + this.photoQuality + ", saveGpsLocation=" + this.saveGpsLocation + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Camera(FlashMode flashMode, CameraSelector cameraSelector, PhotoQuality photoQuality, boolean z) {
                super(null);
                Intrinsics.checkNotNullParameter(flashMode, "flashMode");
                Intrinsics.checkNotNullParameter(cameraSelector, "cameraSelector");
                Intrinsics.checkNotNullParameter(photoQuality, "photoQuality");
                this.flashMode = flashMode;
                this.cameraSelector = cameraSelector;
                this.photoQuality = photoQuality;
                this.saveGpsLocation = z;
            }

            public final FlashMode getFlashMode() {
                return this.flashMode;
            }

            public final CameraSelector getCameraSelector() {
                return this.cameraSelector;
            }

            public final PhotoQuality getPhotoQuality() {
                return this.photoQuality;
            }

            public final boolean getSaveGpsLocation() {
                return this.saveGpsLocation;
            }
        }

        /* JADX INFO: compiled from: ImageCaptureReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/capture/cpl/ImageCaptureReducer$State$Review;", "Lcom/box/android/capture/cpl/ImageCaptureReducer$State;", "file", "Ljava/io/File;", "<init>", "(Ljava/io/File;)V", "getFile", "()Ljava/io/File;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Review extends State {
            public static final int $stable = 8;
            private final File file;

            public static /* synthetic */ Review copy$default(Review review, File file, int i, Object obj) {
                if ((i & 1) != 0) {
                    file = review.file;
                }
                return review.copy(file);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final File getFile() {
                return this.file;
            }

            public final Review copy(File file) {
                Intrinsics.checkNotNullParameter(file, "file");
                return new Review(file);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Review) && Intrinsics.areEqual(this.file, ((Review) other).file);
            }

            public int hashCode() {
                return this.file.hashCode();
            }

            public String toString() {
                return "Review(file=" + this.file + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Review(File file) {
                super(null);
                Intrinsics.checkNotNullParameter(file, "file");
                this.file = file;
            }

            public final File getFile() {
                return this.file;
            }
        }
    }

    /* JADX INFO: compiled from: ImageCaptureReducer.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\t\u0004\u0005\u0006\u0007\b\t\n\u000b\fB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\t\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015¨\u0006\u0016"}, d2 = {"Lcom/box/android/capture/cpl/ImageCaptureReducer$Action;", "", "<init>", "()V", "ToggleCamera", "Initialize", "PermissionGranted", "ImageSaved", "ImageCompressed", "Review", "UploadPhoto", "FinishReview", "CloseCamera", "Lcom/box/android/capture/cpl/ImageCaptureReducer$Action$CloseCamera;", "Lcom/box/android/capture/cpl/ImageCaptureReducer$Action$FinishReview;", "Lcom/box/android/capture/cpl/ImageCaptureReducer$Action$ImageCompressed;", "Lcom/box/android/capture/cpl/ImageCaptureReducer$Action$ImageSaved;", "Lcom/box/android/capture/cpl/ImageCaptureReducer$Action$Initialize;", "Lcom/box/android/capture/cpl/ImageCaptureReducer$Action$PermissionGranted;", "Lcom/box/android/capture/cpl/ImageCaptureReducer$Action$Review;", "Lcom/box/android/capture/cpl/ImageCaptureReducer$Action$ToggleCamera;", "Lcom/box/android/capture/cpl/ImageCaptureReducer$Action$UploadPhoto;", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: ImageCaptureReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/capture/cpl/ImageCaptureReducer$Action$ToggleCamera;", "Lcom/box/android/capture/cpl/ImageCaptureReducer$Action;", "<init>", "()V", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class ToggleCamera extends Action {
            public static final int $stable = 0;
            public static final ToggleCamera INSTANCE = new ToggleCamera();

            private ToggleCamera() {
                super(null);
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: ImageCaptureReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/capture/cpl/ImageCaptureReducer$Action$Initialize;", "Lcom/box/android/capture/cpl/ImageCaptureReducer$Action;", "<init>", "()V", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Initialize extends Action {
            public static final int $stable = 0;
            public static final Initialize INSTANCE = new Initialize();

            private Initialize() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ImageCaptureReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/capture/cpl/ImageCaptureReducer$Action$PermissionGranted;", "Lcom/box/android/capture/cpl/ImageCaptureReducer$Action;", "<init>", "()V", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class PermissionGranted extends Action {
            public static final int $stable = 0;
            public static final PermissionGranted INSTANCE = new PermissionGranted();

            private PermissionGranted() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ImageCaptureReducer.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/box/android/capture/cpl/ImageCaptureReducer$Action$ImageSaved;", "Lcom/box/android/capture/cpl/ImageCaptureReducer$Action;", "file", "Ljava/io/File;", "photoQuality", "Lcom/box/android/domain/models/capture/PhotoQuality;", "<init>", "(Ljava/io/File;Lcom/box/android/domain/models/capture/PhotoQuality;)V", "getFile", "()Ljava/io/File;", "getPhotoQuality", "()Lcom/box/android/domain/models/capture/PhotoQuality;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ImageSaved extends Action {
            public static final int $stable = 8;
            private final File file;
            private final PhotoQuality photoQuality;

            public static /* synthetic */ ImageSaved copy$default(ImageSaved imageSaved, File file, PhotoQuality photoQuality, int i, Object obj) {
                if ((i & 1) != 0) {
                    file = imageSaved.file;
                }
                if ((i & 2) != 0) {
                    photoQuality = imageSaved.photoQuality;
                }
                return imageSaved.copy(file, photoQuality);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final File getFile() {
                return this.file;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final PhotoQuality getPhotoQuality() {
                return this.photoQuality;
            }

            public final ImageSaved copy(File file, PhotoQuality photoQuality) {
                Intrinsics.checkNotNullParameter(file, "file");
                Intrinsics.checkNotNullParameter(photoQuality, "photoQuality");
                return new ImageSaved(file, photoQuality);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ImageSaved)) {
                    return false;
                }
                ImageSaved imageSaved = (ImageSaved) other;
                return Intrinsics.areEqual(this.file, imageSaved.file) && this.photoQuality == imageSaved.photoQuality;
            }

            public int hashCode() {
                return (this.file.hashCode() * 31) + this.photoQuality.hashCode();
            }

            public String toString() {
                return "ImageSaved(file=" + this.file + ", photoQuality=" + this.photoQuality + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ImageSaved(File file, PhotoQuality photoQuality) {
                super(null);
                Intrinsics.checkNotNullParameter(file, "file");
                Intrinsics.checkNotNullParameter(photoQuality, "photoQuality");
                this.file = file;
                this.photoQuality = photoQuality;
            }

            public final File getFile() {
                return this.file;
            }

            public final PhotoQuality getPhotoQuality() {
                return this.photoQuality;
            }
        }

        /* JADX INFO: compiled from: ImageCaptureReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/capture/cpl/ImageCaptureReducer$Action$ImageCompressed;", "Lcom/box/android/capture/cpl/ImageCaptureReducer$Action;", "file", "Ljava/io/File;", "<init>", "(Ljava/io/File;)V", "getFile", "()Ljava/io/File;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ImageCompressed extends Action {
            public static final int $stable = 8;
            private final File file;

            public static /* synthetic */ ImageCompressed copy$default(ImageCompressed imageCompressed, File file, int i, Object obj) {
                if ((i & 1) != 0) {
                    file = imageCompressed.file;
                }
                return imageCompressed.copy(file);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final File getFile() {
                return this.file;
            }

            public final ImageCompressed copy(File file) {
                Intrinsics.checkNotNullParameter(file, "file");
                return new ImageCompressed(file);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ImageCompressed) && Intrinsics.areEqual(this.file, ((ImageCompressed) other).file);
            }

            public int hashCode() {
                return this.file.hashCode();
            }

            public String toString() {
                return "ImageCompressed(file=" + this.file + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ImageCompressed(File file) {
                super(null);
                Intrinsics.checkNotNullParameter(file, "file");
                this.file = file;
            }

            public final File getFile() {
                return this.file;
            }
        }

        /* JADX INFO: compiled from: ImageCaptureReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/capture/cpl/ImageCaptureReducer$Action$Review;", "Lcom/box/android/capture/cpl/ImageCaptureReducer$Action;", "file", "Ljava/io/File;", "<init>", "(Ljava/io/File;)V", "getFile", "()Ljava/io/File;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Review extends Action {
            public static final int $stable = 8;
            private final File file;

            public static /* synthetic */ Review copy$default(Review review, File file, int i, Object obj) {
                if ((i & 1) != 0) {
                    file = review.file;
                }
                return review.copy(file);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final File getFile() {
                return this.file;
            }

            public final Review copy(File file) {
                Intrinsics.checkNotNullParameter(file, "file");
                return new Review(file);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Review) && Intrinsics.areEqual(this.file, ((Review) other).file);
            }

            public int hashCode() {
                return this.file.hashCode();
            }

            public String toString() {
                return "Review(file=" + this.file + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Review(File file) {
                super(null);
                Intrinsics.checkNotNullParameter(file, "file");
                this.file = file;
            }

            public final File getFile() {
                return this.file;
            }
        }

        /* JADX INFO: compiled from: ImageCaptureReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/capture/cpl/ImageCaptureReducer$Action$UploadPhoto;", "Lcom/box/android/capture/cpl/ImageCaptureReducer$Action;", "file", "Ljava/io/File;", "<init>", "(Ljava/io/File;)V", "getFile", "()Ljava/io/File;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class UploadPhoto extends Action {
            public static final int $stable = 8;
            private final File file;

            public static /* synthetic */ UploadPhoto copy$default(UploadPhoto uploadPhoto, File file, int i, Object obj) {
                if ((i & 1) != 0) {
                    file = uploadPhoto.file;
                }
                return uploadPhoto.copy(file);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final File getFile() {
                return this.file;
            }

            public final UploadPhoto copy(File file) {
                Intrinsics.checkNotNullParameter(file, "file");
                return new UploadPhoto(file);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof UploadPhoto) && Intrinsics.areEqual(this.file, ((UploadPhoto) other).file);
            }

            public int hashCode() {
                return this.file.hashCode();
            }

            public String toString() {
                return "UploadPhoto(file=" + this.file + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public UploadPhoto(File file) {
                super(null);
                Intrinsics.checkNotNullParameter(file, "file");
                this.file = file;
            }

            public final File getFile() {
                return this.file;
            }
        }

        /* JADX INFO: compiled from: ImageCaptureReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/capture/cpl/ImageCaptureReducer$Action$FinishReview;", "Lcom/box/android/capture/cpl/ImageCaptureReducer$Action;", "<init>", "()V", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class FinishReview extends Action {
            public static final int $stable = 0;
            public static final FinishReview INSTANCE = new FinishReview();

            private FinishReview() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ImageCaptureReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/capture/cpl/ImageCaptureReducer$Action$CloseCamera;", "Lcom/box/android/capture/cpl/ImageCaptureReducer$Action;", "<init>", "()V", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class CloseCamera extends Action {
            public static final int $stable = 0;
            public static final CloseCamera INSTANCE = new CloseCamera();

            private CloseCamera() {
                super(null);
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public ReducerResult<State, Action> reduce(State state, Action action) {
        CameraSelector cameraSelector;
        State.Camera cameraCopy$default;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (action instanceof Action.ToggleCamera) {
            boolean z = state instanceof State.Camera;
            State.Camera camera = z ? (State.Camera) state : null;
            if (Intrinsics.areEqual(camera != null ? camera.getCameraSelector() : null, CameraSelector.DEFAULT_BACK_CAMERA)) {
                cameraSelector = CameraSelector.DEFAULT_FRONT_CAMERA;
            } else {
                cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA;
            }
            CameraSelector cameraSelector2 = cameraSelector;
            Intrinsics.checkNotNull(cameraSelector2);
            this.environment.getCameraSession().setCameraSelector(cameraSelector2);
            State.Camera camera2 = z ? (State.Camera) state : null;
            if (camera2 != null && (cameraCopy$default = State.Camera.copy$default(camera2, null, cameraSelector2, null, false, 13, null)) != null) {
                state = cameraCopy$default;
            }
            return new ReducerResult<>(state, null, 2, null);
        }
        if (action instanceof Action.Initialize) {
            if (this.environment.getPermissionsHandler().areAllPermissionsGranted(CaptureMode.PHOTO.getRequiredPermissions())) {
                return new ReducerResult<>(new State.Camera(this.environment.getCapturePreferencesService().getFlashModeOrDefault(FlashMode.AUTO), this.environment.getCameraSession().getCameraSelector(), this.environment.getCapturePreferencesService().getPhotoQuality(), this.environment.getCapturePreferencesService().getSaveGpsLocation()), null, 2, null);
            }
            return new ReducerResult<>(State.PermissionRequired.INSTANCE, null, 2, null);
        }
        if (action instanceof Action.PermissionGranted) {
            return new ReducerResult<>(cameraState(), null, 2, null);
        }
        if (action instanceof Action.Review) {
            return new ReducerResult<>(new State.Review(((Action.Review) action).getFile()), null, 2, null);
        }
        if (action instanceof Action.ImageSaved) {
            return new ReducerResult<>(state, Effect.INSTANCE.merge(Effect.INSTANCE.fireAndForget(new AnonymousClass1(null)), new Effect((Function1) new AnonymousClass2(action, null))));
        }
        if (action instanceof Action.ImageCompressed) {
            if (this.environment.getCaptureSettingsEnvironment().getCapturePreferencesService().getReviewPhotoAfterCapture()) {
                return new ReducerResult<>(state, new Effect(new Action.Review(((Action.ImageCompressed) action).getFile())));
            }
            return new ReducerResult<>(state, new Effect(new Action.UploadPhoto(((Action.ImageCompressed) action).getFile())));
        }
        if (action instanceof Action.FinishReview) {
            return new ReducerResult<>(cameraState(), null, 2, null);
        }
        return action instanceof Action.UploadPhoto ? new ReducerResult<>(state, new Effect(Action.FinishReview.INSTANCE)) : new ReducerResult<>(state, null, 2, null);
    }

    /* JADX INFO: renamed from: com.box.android.capture.cpl.ImageCaptureReducer$reduce$1, reason: invalid class name */
    /* JADX INFO: compiled from: ImageCaptureReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.cpl.ImageCaptureReducer$reduce$1", f = "ImageCaptureReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ImageCaptureReducer.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ImageCaptureReducer.this.environment.getCaptureShutterSoundHelper().playShutterSoundIfRequired();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.box.android.capture.cpl.ImageCaptureReducer$reduce$2, reason: invalid class name */
    /* JADX INFO: compiled from: ImageCaptureReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/box/android/capture/cpl/ImageCaptureReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.cpl.ImageCaptureReducer$reduce$2", f = "ImageCaptureReducer.kt", i = {}, l = {79}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Action>, Object> {
        final /* synthetic */ Action $action;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Action action, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.$action = action;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return ImageCaptureReducer.this.new AnonymousClass2(this.$action, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Action> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = ImageCaptureReducer.this.environment.getImageCaptureHelper().compressImage(((Action.ImageSaved) this.$action).getFile(), ((Action.ImageSaved) this.$action).getPhotoQuality().getCompression(), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return new Action.ImageCompressed((File) obj);
        }
    }

    private final State.Camera cameraState() {
        return new State.Camera(this.environment.getCapturePreferencesService().getFlashModeOrDefault(FlashMode.AUTO), this.environment.getCameraSession().getCameraSelector(), this.environment.getCapturePreferencesService().getPhotoQuality(), this.environment.getCapturePreferencesService().getSaveGpsLocation());
    }
}
