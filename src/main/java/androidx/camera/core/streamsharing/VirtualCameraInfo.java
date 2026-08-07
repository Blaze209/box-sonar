package androidx.camera.core.streamsharing;

import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.ForwardingCameraInfo;
import androidx.camera.core.impl.utils.TransformUtils;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class VirtualCameraInfo extends ForwardingCameraInfo {
    private final String mVirtualCameraId;
    private int mVirtualCameraRotationDegrees;

    VirtualCameraInfo(CameraInfoInternal cameraInfoInternal) {
        super(cameraInfoInternal);
        this.mVirtualCameraId = "virtual-" + cameraInfoInternal.getCameraId() + CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR + UUID.randomUUID().toString();
    }

    @Override // androidx.camera.core.impl.ForwardingCameraInfo, androidx.camera.core.impl.CameraInfoInternal
    public String getCameraId() {
        return this.mVirtualCameraId;
    }

    void setVirtualCameraRotationDegrees(int i) {
        this.mVirtualCameraRotationDegrees = i;
    }

    @Override // androidx.camera.core.impl.ForwardingCameraInfo, androidx.camera.core.CameraInfo
    public int getSensorRotationDegrees() {
        return getSensorRotationDegrees(0);
    }

    @Override // androidx.camera.core.impl.ForwardingCameraInfo, androidx.camera.core.CameraInfo
    public int getSensorRotationDegrees(int i) {
        return TransformUtils.within360(super.getSensorRotationDegrees(i) - this.mVirtualCameraRotationDegrees);
    }
}
