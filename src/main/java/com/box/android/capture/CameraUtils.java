package com.box.android.capture;

import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import androidx.camera.core.Camera;
import androidx.camera.core.ZoomState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CameraUtils.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/box/android/capture/CameraUtils;", "", "<init>", "()V", "setupZoom", "", "camera", "Landroidx/camera/core/Camera;", "captureCameraPreview", "Landroid/view/View;", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CameraUtils {
    public static final int $stable = 0;
    public static final CameraUtils INSTANCE = new CameraUtils();

    private CameraUtils() {
    }

    public final void setupZoom(final Camera camera, View captureCameraPreview) {
        Intrinsics.checkNotNullParameter(camera, "camera");
        Intrinsics.checkNotNullParameter(captureCameraPreview, "captureCameraPreview");
        final ScaleGestureDetector scaleGestureDetector = new ScaleGestureDetector(captureCameraPreview.getContext(), new ScaleGestureDetector.SimpleOnScaleGestureListener() { // from class: com.box.android.capture.CameraUtils$setupZoom$listener$1
            @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScale(ScaleGestureDetector detector) {
                Intrinsics.checkNotNullParameter(detector, "detector");
                ZoomState value = camera.getCameraInfo().getZoomState().getValue();
                camera.getCameraControl().setZoomRatio((value != null ? value.getZoomRatio() : 0.0f) * detector.getScaleFactor());
                return true;
            }
        });
        captureCameraPreview.setOnTouchListener(new View.OnTouchListener() { // from class: com.box.android.capture.CameraUtils$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return CameraUtils.setupZoom$lambda$0(scaleGestureDetector, view, motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupZoom$lambda$0(ScaleGestureDetector scaleGestureDetector, View view, MotionEvent motionEvent) {
        if (view != null) {
            view.performClick();
        }
        scaleGestureDetector.onTouchEvent(motionEvent);
        return true;
    }
}
