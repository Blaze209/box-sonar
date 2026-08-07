package androidx.camera.lifecycle;

import android.content.Context;
import androidx.arch.core.util.Function;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraEffect;
import androidx.camera.core.CameraFilter;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraInfoUnavailableException;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraX;
import androidx.camera.core.CameraXConfig;
import androidx.camera.core.ConcurrentCamera;
import androidx.camera.core.LayoutSettings;
import androidx.camera.core.Preview;
import androidx.camera.core.UseCase;
import androidx.camera.core.UseCaseGroup;
import androidx.camera.core.ViewPort;
import androidx.camera.core.concurrent.CameraCoordinator;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraConfigProvider;
import androidx.camera.core.impl.CameraConfigs;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.ExtendedCameraConfigProviderStore;
import androidx.camera.core.impl.RestrictedCameraInfo;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.ContextUtil;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import androidx.lifecycle.LifecycleOwner;
import androidx.tracing.Trace;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: ProcessCameraProvider.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 Z2\u00020\u0001:\u0001ZB\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jk\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010.2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002012\b\u00103\u001a\u0004\u0018\u0001042\u000e\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001060\u00042\u0016\u00107\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010908\"\u0004\u0018\u000109H\u0001¢\u0006\u0004\b:\u0010;J \u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010<\u001a\u00020.2\u0006\u0010=\u001a\u00020>H\u0007J5\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010<\u001a\u00020.2\u0016\u00107\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010908\"\u0004\u0018\u000109H\u0007¢\u0006\u0002\u0010?J\u0018\u0010)\u001a\u00020@2\u000e\u0010A\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010B0\u0004H\u0007J\u0010\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020FH\u0002J\u000e\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\u0018\u0010H\u001a\u00020I2\u0006\u0010<\u001a\u00020.2\u0006\u0010J\u001a\u00020\u0005H\u0002J\u0010\u0010K\u001a\u00020\u00052\u0006\u0010<\u001a\u00020.H\u0017J\u0016\u0010L\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001f2\u0006\u0010M\u001a\u00020$H\u0002J\u0010\u0010N\u001a\u00020\u00142\u0006\u0010<\u001a\u00020.H\u0016J\u0010\u0010O\u001a\u00020\u00142\u0006\u0010P\u001a\u000209H\u0016J\u0010\u0010Q\u001a\u00020\u00142\u0006\u0010P\u001a\u000209H\u0002J\u0010\u0010R\u001a\u00020\u00142\u0006\u0010P\u001a\u000209H\u0002J\u0010\u0010S\u001a\u00020D2\u0006\u0010T\u001a\u00020\u001bH\u0002J\u0010\u0010U\u001a\u00020D2\u0006\u0010M\u001a\u00020$H\u0002J\u000e\u0010V\u001a\b\u0012\u0004\u0012\u00020!0\u001fH\u0007J%\u0010W\u001a\u00020D2\u0016\u00107\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010908\"\u0004\u0018\u000109H\u0017¢\u0006\u0002\u0010XJ\b\u0010Y\u001a\u00020DH\u0017R0\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00048G¢\u0006\u0006\u001a\u0004\b\f\u0010\bR$\u0010\r\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00148G¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015R\u001c\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u00178\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001f8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R \u0010 \u001a\u0010\u0012\f\u0012\n \"*\u0004\u0018\u00010!0!0\u001f8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006["}, d2 = {"Landroidx/camera/lifecycle/ProcessCameraProvider;", "Landroidx/camera/lifecycle/LifecycleCameraProvider;", "()V", "cameraInfos", "", "Landroidx/camera/core/CameraInfo;", "activeConcurrentCameraInfos", "getActiveConcurrentCameraInfos", "()Ljava/util/List;", "setActiveConcurrentCameraInfos", "(Ljava/util/List;)V", "availableConcurrentCameraInfos", "getAvailableConcurrentCameraInfos", "cameraOperatingMode", "", "getCameraOperatingMode", "()I", "setCameraOperatingMode", "(I)V", "isConcurrentCameraModeOn", "", "()Z", "mCameraInfoMap", "", "Landroidx/camera/core/internal/CameraUseCaseAdapter$CameraId;", "Landroidx/camera/core/impl/RestrictedCameraInfo;", "mCameraX", "Landroidx/camera/core/CameraX;", "mCameraXConfigProvider", "Landroidx/camera/core/CameraXConfig$Provider;", "mCameraXInitializeFuture", "Lcom/google/common/util/concurrent/ListenableFuture;", "mCameraXShutdownFuture", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "mContext", "Landroid/content/Context;", "mLifecycleCameraRepository", "Landroidx/camera/lifecycle/LifecycleCameraRepository;", "mLock", "", "bindToLifecycle", "Landroidx/camera/core/Camera;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "primaryCameraSelector", "Landroidx/camera/core/CameraSelector;", "secondaryCameraSelector", "primaryLayoutSettings", "Landroidx/camera/core/LayoutSettings;", "secondaryLayoutSettings", "viewPort", "Landroidx/camera/core/ViewPort;", "effects", "Landroidx/camera/core/CameraEffect;", "useCases", "", "Landroidx/camera/core/UseCase;", "bindToLifecycle$camera_lifecycle_release", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/camera/core/CameraSelector;Landroidx/camera/core/CameraSelector;Landroidx/camera/core/LayoutSettings;Landroidx/camera/core/LayoutSettings;Landroidx/camera/core/ViewPort;Ljava/util/List;[Landroidx/camera/core/UseCase;)Landroidx/camera/core/Camera;", "cameraSelector", "useCaseGroup", "Landroidx/camera/core/UseCaseGroup;", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/camera/core/CameraSelector;[Landroidx/camera/core/UseCase;)Landroidx/camera/core/Camera;", "Landroidx/camera/core/ConcurrentCamera;", "singleCameraConfigs", "Landroidx/camera/core/ConcurrentCamera$SingleCameraConfig;", "configureInstanceInternal", "", "cameraXConfig", "Landroidx/camera/core/CameraXConfig;", "getAvailableCameraInfos", "getCameraConfig", "Landroidx/camera/core/impl/CameraConfig;", "cameraInfo", "getCameraInfo", "getOrCreateCameraXInstance", "context", "hasCamera", "isBound", "useCase", "isPreview", "isVideoCapture", "setCameraX", "cameraX", "setContext", "shutdownAsync", "unbind", "([Landroidx/camera/core/UseCase;)V", "unbindAll", "Companion", "camera-lifecycle_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ProcessCameraProvider implements LifecycleCameraProvider {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ProcessCameraProvider sAppInstance = new ProcessCameraProvider();
    private final Map<CameraUseCaseAdapter.CameraId, RestrictedCameraInfo> mCameraInfoMap;
    private CameraX mCameraX;
    private CameraXConfig.Provider mCameraXConfigProvider;
    private ListenableFuture<CameraX> mCameraXInitializeFuture;
    private ListenableFuture<Void> mCameraXShutdownFuture;
    private Context mContext;
    private final LifecycleCameraRepository mLifecycleCameraRepository;
    private final Object mLock = new Object();

    @JvmStatic
    public static final void configureInstance(CameraXConfig cameraXConfig) {
        INSTANCE.configureInstance(cameraXConfig);
    }

    @JvmStatic
    public static final ListenableFuture<ProcessCameraProvider> getInstance(Context context) {
        return INSTANCE.getInstance(context);
    }

    private ProcessCameraProvider() {
        ListenableFuture<Void> listenableFutureImmediateFuture = Futures.immediateFuture(null);
        Intrinsics.checkNotNullExpressionValue(listenableFutureImmediateFuture, "immediateFuture<Void>(null)");
        this.mCameraXShutdownFuture = listenableFutureImmediateFuture;
        this.mLifecycleCameraRepository = new LifecycleCameraRepository();
        this.mCameraInfoMap = new HashMap();
    }

    public final ListenableFuture<Void> shutdownAsync() {
        ListenableFuture<Void> listenableFutureImmediateFuture;
        Threads.runOnMainSync(new Runnable() { // from class: androidx.camera.lifecycle.ProcessCameraProvider$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                ProcessCameraProvider.shutdownAsync$lambda$0(this.f$0);
            }
        });
        CameraX cameraX = this.mCameraX;
        if (cameraX != null) {
            Intrinsics.checkNotNull(cameraX);
            cameraX.getCameraFactory().getCameraCoordinator().shutdown();
        }
        CameraX cameraX2 = this.mCameraX;
        if (cameraX2 != null) {
            Intrinsics.checkNotNull(cameraX2);
            listenableFutureImmediateFuture = cameraX2.shutdown();
        } else {
            listenableFutureImmediateFuture = Futures.immediateFuture(null);
        }
        Intrinsics.checkNotNullExpressionValue(listenableFutureImmediateFuture, "if (mCameraX != null) mC…mediateFuture<Void>(null)");
        synchronized (this.mLock) {
            this.mCameraXConfigProvider = null;
            this.mCameraXInitializeFuture = null;
            this.mCameraXShutdownFuture = listenableFutureImmediateFuture;
            this.mCameraInfoMap.clear();
            Unit unit = Unit.INSTANCE;
        }
        this.mCameraX = null;
        this.mContext = null;
        return listenableFutureImmediateFuture;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void shutdownAsync$lambda$0(ProcessCameraProvider this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.unbindAll();
        this$0.mLifecycleCameraRepository.clear();
    }

    public final Camera bindToLifecycle(LifecycleOwner lifecycleOwner, CameraSelector cameraSelector, UseCase... useCases) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(cameraSelector, "cameraSelector");
        Intrinsics.checkNotNullParameter(useCases, "useCases");
        Trace.beginSection("CX:bindToLifecycle");
        try {
            if (getCameraOperatingMode() != 2) {
                setCameraOperatingMode(1);
                LayoutSettings DEFAULT = LayoutSettings.DEFAULT;
                Intrinsics.checkNotNullExpressionValue(DEFAULT, "DEFAULT");
                LayoutSettings DEFAULT2 = LayoutSettings.DEFAULT;
                Intrinsics.checkNotNullExpressionValue(DEFAULT2, "DEFAULT");
                Camera cameraBindToLifecycle$camera_lifecycle_release = bindToLifecycle$camera_lifecycle_release(lifecycleOwner, cameraSelector, null, DEFAULT, DEFAULT2, null, CollectionsKt.emptyList(), (UseCase[]) Arrays.copyOf(useCases, useCases.length));
                Trace.endSection();
                return cameraBindToLifecycle$camera_lifecycle_release;
            }
            throw new UnsupportedOperationException("bindToLifecycle for single camera is not supported in concurrent camera mode, call unbindAll() first");
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    public final Camera bindToLifecycle(LifecycleOwner lifecycleOwner, CameraSelector cameraSelector, UseCaseGroup useCaseGroup) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(cameraSelector, "cameraSelector");
        Intrinsics.checkNotNullParameter(useCaseGroup, "useCaseGroup");
        Trace.beginSection("CX:bindToLifecycle-UseCaseGroup");
        try {
            if (getCameraOperatingMode() != 2) {
                setCameraOperatingMode(1);
                LayoutSettings DEFAULT = LayoutSettings.DEFAULT;
                Intrinsics.checkNotNullExpressionValue(DEFAULT, "DEFAULT");
                LayoutSettings DEFAULT2 = LayoutSettings.DEFAULT;
                Intrinsics.checkNotNullExpressionValue(DEFAULT2, "DEFAULT");
                ViewPort viewPort = useCaseGroup.getViewPort();
                List<CameraEffect> effects = useCaseGroup.getEffects();
                Intrinsics.checkNotNullExpressionValue(effects, "useCaseGroup.effects");
                List<UseCase> useCases = useCaseGroup.getUseCases();
                Intrinsics.checkNotNullExpressionValue(useCases, "useCaseGroup.useCases");
                UseCase[] useCaseArr = (UseCase[]) useCases.toArray(new UseCase[0]);
                Camera cameraBindToLifecycle$camera_lifecycle_release = bindToLifecycle$camera_lifecycle_release(lifecycleOwner, cameraSelector, null, DEFAULT, DEFAULT2, viewPort, effects, (UseCase[]) Arrays.copyOf(useCaseArr, useCaseArr.length));
                Trace.endSection();
                return cameraBindToLifecycle$camera_lifecycle_release;
            }
            throw new UnsupportedOperationException("bindToLifecycle for single camera is not supported in concurrent camera mode, call unbindAll() first.");
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:55:0x0206 A[Catch: all -> 0x0317, TryCatch #1 {all -> 0x0317, blocks: (B:3:0x000f, B:5:0x0016, B:7:0x001c, B:10:0x005a, B:12:0x0060, B:14:0x006e, B:16:0x0084, B:18:0x009a, B:19:0x00c7, B:21:0x00cd, B:22:0x00e2, B:24:0x00e8, B:26:0x00fd, B:27:0x0101, B:28:0x0112, B:65:0x02e8, B:29:0x013d, B:30:0x0144, B:31:0x0145, B:32:0x014a, B:33:0x014b, B:35:0x015f, B:37:0x0165, B:38:0x016d, B:39:0x0186, B:41:0x0198, B:44:0x01a3, B:45:0x01aa, B:46:0x01ab, B:48:0x01c4, B:50:0x01d2, B:53:0x01fd, B:59:0x0215, B:64:0x02e3, B:55:0x0206, B:57:0x020c, B:60:0x0277, B:61:0x027b, B:63:0x0281, B:68:0x02f1, B:69:0x02f8, B:70:0x02f9, B:71:0x02fe, B:72:0x02ff, B:73:0x0306, B:74:0x0307, B:75:0x030e, B:76:0x030f, B:77:0x0316), top: B:83:0x000f, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x020c A[Catch: all -> 0x0317, TryCatch #1 {all -> 0x0317, blocks: (B:3:0x000f, B:5:0x0016, B:7:0x001c, B:10:0x005a, B:12:0x0060, B:14:0x006e, B:16:0x0084, B:18:0x009a, B:19:0x00c7, B:21:0x00cd, B:22:0x00e2, B:24:0x00e8, B:26:0x00fd, B:27:0x0101, B:28:0x0112, B:65:0x02e8, B:29:0x013d, B:30:0x0144, B:31:0x0145, B:32:0x014a, B:33:0x014b, B:35:0x015f, B:37:0x0165, B:38:0x016d, B:39:0x0186, B:41:0x0198, B:44:0x01a3, B:45:0x01aa, B:46:0x01ab, B:48:0x01c4, B:50:0x01d2, B:53:0x01fd, B:59:0x0215, B:64:0x02e3, B:55:0x0206, B:57:0x020c, B:60:0x0277, B:61:0x027b, B:63:0x0281, B:68:0x02f1, B:69:0x02f8, B:70:0x02f9, B:71:0x02fe, B:72:0x02ff, B:73:0x0306, B:74:0x0307, B:75:0x030e, B:76:0x030f, B:77:0x0316), top: B:83:0x000f, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x0281 A[Catch: all -> 0x0317, LOOP:2: B:61:0x027b->B:63:0x0281, LOOP_END, TryCatch #1 {all -> 0x0317, blocks: (B:3:0x000f, B:5:0x0016, B:7:0x001c, B:10:0x005a, B:12:0x0060, B:14:0x006e, B:16:0x0084, B:18:0x009a, B:19:0x00c7, B:21:0x00cd, B:22:0x00e2, B:24:0x00e8, B:26:0x00fd, B:27:0x0101, B:28:0x0112, B:65:0x02e8, B:29:0x013d, B:30:0x0144, B:31:0x0145, B:32:0x014a, B:33:0x014b, B:35:0x015f, B:37:0x0165, B:38:0x016d, B:39:0x0186, B:41:0x0198, B:44:0x01a3, B:45:0x01aa, B:46:0x01ab, B:48:0x01c4, B:50:0x01d2, B:53:0x01fd, B:59:0x0215, B:64:0x02e3, B:55:0x0206, B:57:0x020c, B:60:0x0277, B:61:0x027b, B:63:0x0281, B:68:0x02f1, B:69:0x02f8, B:70:0x02f9, B:71:0x02fe, B:72:0x02ff, B:73:0x0306, B:74:0x0307, B:75:0x030e, B:76:0x030f, B:77:0x0316), top: B:83:0x000f, inners: #0 }] */
    public final ConcurrentCamera bindToLifecycle(List<ConcurrentCamera.SingleCameraConfig> singleCameraConfigs) {
        Intrinsics.checkNotNullParameter(singleCameraConfigs, "singleCameraConfigs");
        Trace.beginSection("CX:bindToLifecycle-Concurrent");
        try {
            if (singleCameraConfigs.size() < 2) {
                throw new IllegalArgumentException("Concurrent camera needs two camera configs.");
            }
            if (singleCameraConfigs.size() > 2) {
                throw new IllegalArgumentException("Concurrent camera is only supporting two cameras at maximum.");
            }
            ConcurrentCamera.SingleCameraConfig singleCameraConfig = singleCameraConfigs.get(0);
            Intrinsics.checkNotNull(singleCameraConfig);
            ConcurrentCamera.SingleCameraConfig singleCameraConfig2 = singleCameraConfig;
            ConcurrentCamera.SingleCameraConfig singleCameraConfig3 = singleCameraConfigs.get(1);
            Intrinsics.checkNotNull(singleCameraConfig3);
            ConcurrentCamera.SingleCameraConfig singleCameraConfig4 = singleCameraConfig3;
            ArrayList arrayList = new ArrayList();
            if (Intrinsics.areEqual(singleCameraConfig2.getCameraSelector().getLensFacing(), singleCameraConfig4.getCameraSelector().getLensFacing())) {
                if (getCameraOperatingMode() == 2) {
                    throw new UnsupportedOperationException("Camera is already running, call unbindAll() before binding more cameras.");
                }
                if (!Intrinsics.areEqual(singleCameraConfig2.getLifecycleOwner(), singleCameraConfig4.getLifecycleOwner()) || !Intrinsics.areEqual(singleCameraConfig2.getUseCaseGroup().getViewPort(), singleCameraConfig4.getUseCaseGroup().getViewPort()) || !Intrinsics.areEqual(singleCameraConfig2.getUseCaseGroup().getEffects(), singleCameraConfig4.getUseCaseGroup().getEffects())) {
                    throw new IllegalArgumentException("Two camera configs need to have the same lifecycle owner, view port and effects.");
                }
                LifecycleOwner lifecycleOwner = singleCameraConfig2.getLifecycleOwner();
                Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "firstCameraConfig.lifecycleOwner");
                CameraSelector cameraSelector = singleCameraConfig2.getCameraSelector();
                Intrinsics.checkNotNullExpressionValue(cameraSelector, "firstCameraConfig.cameraSelector");
                ViewPort viewPort = singleCameraConfig2.getUseCaseGroup().getViewPort();
                List<CameraEffect> effects = singleCameraConfig2.getUseCaseGroup().getEffects();
                Intrinsics.checkNotNullExpressionValue(effects, "firstCameraConfig.useCaseGroup.effects");
                ArrayList arrayList2 = new ArrayList();
                for (ConcurrentCamera.SingleCameraConfig singleCameraConfig5 : singleCameraConfigs) {
                    Intrinsics.checkNotNull(singleCameraConfig5);
                    for (UseCase useCase : singleCameraConfig5.getUseCaseGroup().getUseCases()) {
                        Intrinsics.checkNotNullExpressionValue(useCase, "config!!.useCaseGroup.useCases");
                        UseCase useCase2 = useCase;
                        String physicalCameraId = singleCameraConfig5.getCameraSelector().getPhysicalCameraId();
                        if (physicalCameraId != null) {
                            useCase2.setPhysicalCameraId(physicalCameraId);
                        }
                    }
                    List<UseCase> useCases = singleCameraConfig5.getUseCaseGroup().getUseCases();
                    Intrinsics.checkNotNullExpressionValue(useCases, "config.useCaseGroup.useCases");
                    arrayList2.addAll(useCases);
                }
                setCameraOperatingMode(1);
                LayoutSettings DEFAULT = LayoutSettings.DEFAULT;
                Intrinsics.checkNotNullExpressionValue(DEFAULT, "DEFAULT");
                LayoutSettings DEFAULT2 = LayoutSettings.DEFAULT;
                Intrinsics.checkNotNullExpressionValue(DEFAULT2, "DEFAULT");
                UseCase[] useCaseArr = (UseCase[]) arrayList2.toArray(new UseCase[0]);
                arrayList.add(bindToLifecycle$camera_lifecycle_release(lifecycleOwner, cameraSelector, null, DEFAULT, DEFAULT2, viewPort, effects, (UseCase[]) Arrays.copyOf(useCaseArr, useCaseArr.length)));
            } else {
                Context context = this.mContext;
                Intrinsics.checkNotNull(context);
                if (context.getPackageManager().hasSystemFeature("android.hardware.camera.concurrent")) {
                    if (getCameraOperatingMode() == 1) {
                        throw new UnsupportedOperationException("Camera is already running, call unbindAll() before binding more cameras.");
                    }
                    ArrayList arrayList3 = new ArrayList();
                    try {
                        CameraSelector cameraSelector2 = singleCameraConfig2.getCameraSelector();
                        Intrinsics.checkNotNullExpressionValue(cameraSelector2, "firstCameraConfig.cameraSelector");
                        CameraInfo cameraInfo = getCameraInfo(cameraSelector2);
                        CameraSelector cameraSelector3 = singleCameraConfig4.getCameraSelector();
                        Intrinsics.checkNotNullExpressionValue(cameraSelector3, "secondCameraConfig.cameraSelector");
                        CameraInfo cameraInfo2 = getCameraInfo(cameraSelector3);
                        arrayList3.add(cameraInfo);
                        arrayList3.add(cameraInfo2);
                        if (!getActiveConcurrentCameraInfos().isEmpty() && !Intrinsics.areEqual(arrayList3, getActiveConcurrentCameraInfos())) {
                            throw new UnsupportedOperationException("Cameras are already running, call unbindAll() before binding more cameras.");
                        }
                        setCameraOperatingMode(2);
                        if (Objects.equals(singleCameraConfig2.getUseCaseGroup().getUseCases(), singleCameraConfig4.getUseCaseGroup().getUseCases()) && singleCameraConfig2.getUseCaseGroup().getUseCases().size() == 2) {
                            UseCase useCase0 = singleCameraConfig2.getUseCaseGroup().getUseCases().get(0);
                            UseCase useCase1 = singleCameraConfig2.getUseCaseGroup().getUseCases().get(1);
                            Intrinsics.checkNotNullExpressionValue(useCase0, "useCase0");
                            if (isVideoCapture(useCase0)) {
                                Intrinsics.checkNotNullExpressionValue(useCase1, "useCase1");
                                if (!isPreview(useCase1)) {
                                    if (isPreview(useCase0)) {
                                        Intrinsics.checkNotNullExpressionValue(useCase1, "useCase1");
                                        if (isVideoCapture(useCase1)) {
                                        }
                                    }
                                    for (ConcurrentCamera.SingleCameraConfig singleCameraConfig6 : singleCameraConfigs) {
                                        Intrinsics.checkNotNull(singleCameraConfig6);
                                        LifecycleOwner lifecycleOwner2 = singleCameraConfig6.getLifecycleOwner();
                                        Intrinsics.checkNotNullExpressionValue(lifecycleOwner2, "config!!.lifecycleOwner");
                                        CameraSelector cameraSelector4 = singleCameraConfig6.getCameraSelector();
                                        Intrinsics.checkNotNullExpressionValue(cameraSelector4, "config.cameraSelector");
                                        LayoutSettings DEFAULT3 = LayoutSettings.DEFAULT;
                                        Intrinsics.checkNotNullExpressionValue(DEFAULT3, "DEFAULT");
                                        LayoutSettings DEFAULT4 = LayoutSettings.DEFAULT;
                                        Intrinsics.checkNotNullExpressionValue(DEFAULT4, "DEFAULT");
                                        ViewPort viewPort2 = singleCameraConfig6.getUseCaseGroup().getViewPort();
                                        List<CameraEffect> effects2 = singleCameraConfig6.getUseCaseGroup().getEffects();
                                        Intrinsics.checkNotNullExpressionValue(effects2, "config.useCaseGroup.effects");
                                        List<UseCase> useCases2 = singleCameraConfig6.getUseCaseGroup().getUseCases();
                                        Intrinsics.checkNotNullExpressionValue(useCases2, "config.useCaseGroup.useCases");
                                        UseCase[] useCaseArr2 = (UseCase[]) useCases2.toArray(new UseCase[0]);
                                        arrayList.add(bindToLifecycle$camera_lifecycle_release(lifecycleOwner2, cameraSelector4, null, DEFAULT3, DEFAULT4, viewPort2, effects2, (UseCase[]) Arrays.copyOf(useCaseArr2, useCaseArr2.length)));
                                    }
                                }
                                LifecycleOwner lifecycleOwner3 = singleCameraConfig2.getLifecycleOwner();
                                Intrinsics.checkNotNullExpressionValue(lifecycleOwner3, "firstCameraConfig.lifecycleOwner");
                                CameraSelector cameraSelector5 = singleCameraConfig2.getCameraSelector();
                                Intrinsics.checkNotNullExpressionValue(cameraSelector5, "firstCameraConfig.cameraSelector");
                                CameraSelector cameraSelector6 = singleCameraConfig4.getCameraSelector();
                                LayoutSettings layoutSettings = singleCameraConfig2.getLayoutSettings();
                                Intrinsics.checkNotNullExpressionValue(layoutSettings, "firstCameraConfig.layoutSettings");
                                LayoutSettings layoutSettings2 = singleCameraConfig4.getLayoutSettings();
                                Intrinsics.checkNotNullExpressionValue(layoutSettings2, "secondCameraConfig.layoutSettings");
                                ViewPort viewPort3 = singleCameraConfig2.getUseCaseGroup().getViewPort();
                                List<CameraEffect> effects3 = singleCameraConfig2.getUseCaseGroup().getEffects();
                                Intrinsics.checkNotNullExpressionValue(effects3, "firstCameraConfig.useCaseGroup.effects");
                                List<UseCase> useCases3 = singleCameraConfig2.getUseCaseGroup().getUseCases();
                                Intrinsics.checkNotNullExpressionValue(useCases3, "firstCameraConfig.useCaseGroup.useCases");
                                UseCase[] useCaseArr3 = (UseCase[]) useCases3.toArray(new UseCase[0]);
                                arrayList.add(bindToLifecycle$camera_lifecycle_release(lifecycleOwner3, cameraSelector5, cameraSelector6, layoutSettings, layoutSettings2, viewPort3, effects3, (UseCase[]) Arrays.copyOf(useCaseArr3, useCaseArr3.length)));
                            } else {
                                if (isPreview(useCase0)) {
                                    Intrinsics.checkNotNullExpressionValue(useCase1, "useCase1");
                                    if (isVideoCapture(useCase1)) {
                                        LifecycleOwner lifecycleOwner4 = singleCameraConfig2.getLifecycleOwner();
                                        Intrinsics.checkNotNullExpressionValue(lifecycleOwner4, "firstCameraConfig.lifecycleOwner");
                                        CameraSelector cameraSelector7 = singleCameraConfig2.getCameraSelector();
                                        Intrinsics.checkNotNullExpressionValue(cameraSelector7, "firstCameraConfig.cameraSelector");
                                        CameraSelector cameraSelector8 = singleCameraConfig4.getCameraSelector();
                                        LayoutSettings layoutSettings3 = singleCameraConfig2.getLayoutSettings();
                                        Intrinsics.checkNotNullExpressionValue(layoutSettings3, "firstCameraConfig.layoutSettings");
                                        LayoutSettings layoutSettings4 = singleCameraConfig4.getLayoutSettings();
                                        Intrinsics.checkNotNullExpressionValue(layoutSettings4, "secondCameraConfig.layoutSettings");
                                        ViewPort viewPort4 = singleCameraConfig2.getUseCaseGroup().getViewPort();
                                        List<CameraEffect> effects4 = singleCameraConfig2.getUseCaseGroup().getEffects();
                                        Intrinsics.checkNotNullExpressionValue(effects4, "firstCameraConfig.useCaseGroup.effects");
                                        List<UseCase> useCases4 = singleCameraConfig2.getUseCaseGroup().getUseCases();
                                        Intrinsics.checkNotNullExpressionValue(useCases4, "firstCameraConfig.useCaseGroup.useCases");
                                        UseCase[] useCaseArr4 = (UseCase[]) useCases4.toArray(new UseCase[0]);
                                        arrayList.add(bindToLifecycle$camera_lifecycle_release(lifecycleOwner4, cameraSelector7, cameraSelector8, layoutSettings3, layoutSettings4, viewPort4, effects4, (UseCase[]) Arrays.copyOf(useCaseArr4, useCaseArr4.length)));
                                    }
                                }
                                while (r13.hasNext()) {
                                    Intrinsics.checkNotNull(singleCameraConfig6);
                                    LifecycleOwner lifecycleOwner5 = singleCameraConfig6.getLifecycleOwner();
                                    Intrinsics.checkNotNullExpressionValue(lifecycleOwner5, "config!!.lifecycleOwner");
                                    CameraSelector cameraSelector9 = singleCameraConfig6.getCameraSelector();
                                    Intrinsics.checkNotNullExpressionValue(cameraSelector9, "config.cameraSelector");
                                    LayoutSettings DEFAULT5 = LayoutSettings.DEFAULT;
                                    Intrinsics.checkNotNullExpressionValue(DEFAULT5, "DEFAULT");
                                    LayoutSettings DEFAULT6 = LayoutSettings.DEFAULT;
                                    Intrinsics.checkNotNullExpressionValue(DEFAULT6, "DEFAULT");
                                    ViewPort viewPort5 = singleCameraConfig6.getUseCaseGroup().getViewPort();
                                    List<CameraEffect> effects5 = singleCameraConfig6.getUseCaseGroup().getEffects();
                                    Intrinsics.checkNotNullExpressionValue(effects5, "config.useCaseGroup.effects");
                                    List<UseCase> useCases5 = singleCameraConfig6.getUseCaseGroup().getUseCases();
                                    Intrinsics.checkNotNullExpressionValue(useCases5, "config.useCaseGroup.useCases");
                                    UseCase[] useCaseArr5 = (UseCase[]) useCases5.toArray(new UseCase[0]);
                                    arrayList.add(bindToLifecycle$camera_lifecycle_release(lifecycleOwner5, cameraSelector9, null, DEFAULT5, DEFAULT6, viewPort5, effects5, (UseCase[]) Arrays.copyOf(useCaseArr5, useCaseArr5.length)));
                                }
                            }
                        } else {
                            while (r13.hasNext()) {
                                Intrinsics.checkNotNull(singleCameraConfig6);
                                LifecycleOwner lifecycleOwner6 = singleCameraConfig6.getLifecycleOwner();
                                Intrinsics.checkNotNullExpressionValue(lifecycleOwner6, "config!!.lifecycleOwner");
                                CameraSelector cameraSelector10 = singleCameraConfig6.getCameraSelector();
                                Intrinsics.checkNotNullExpressionValue(cameraSelector10, "config.cameraSelector");
                                LayoutSettings DEFAULT7 = LayoutSettings.DEFAULT;
                                Intrinsics.checkNotNullExpressionValue(DEFAULT7, "DEFAULT");
                                LayoutSettings DEFAULT8 = LayoutSettings.DEFAULT;
                                Intrinsics.checkNotNullExpressionValue(DEFAULT8, "DEFAULT");
                                ViewPort viewPort6 = singleCameraConfig6.getUseCaseGroup().getViewPort();
                                List<CameraEffect> effects6 = singleCameraConfig6.getUseCaseGroup().getEffects();
                                Intrinsics.checkNotNullExpressionValue(effects6, "config.useCaseGroup.effects");
                                List<UseCase> useCases6 = singleCameraConfig6.getUseCaseGroup().getUseCases();
                                Intrinsics.checkNotNullExpressionValue(useCases6, "config.useCaseGroup.useCases");
                                UseCase[] useCaseArr6 = (UseCase[]) useCases6.toArray(new UseCase[0]);
                                arrayList.add(bindToLifecycle$camera_lifecycle_release(lifecycleOwner6, cameraSelector10, null, DEFAULT7, DEFAULT8, viewPort6, effects6, (UseCase[]) Arrays.copyOf(useCaseArr6, useCaseArr6.length)));
                            }
                        }
                        setActiveConcurrentCameraInfos(arrayList3);
                    } catch (IllegalArgumentException unused) {
                        throw new IllegalArgumentException("Invalid camera selectors in camera configs.");
                    }
                } else {
                    throw new UnsupportedOperationException("Concurrent camera is not supported on the device.");
                }
            }
            ConcurrentCamera concurrentCamera = new ConcurrentCamera(arrayList);
            Trace.endSection();
            return concurrentCamera;
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isVideoCapture(UseCase useCase) {
        return useCase.getCurrentConfig().containsOption(UseCaseConfig.OPTION_CAPTURE_TYPE) && useCase.getCurrentConfig().getCaptureType() == UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isPreview(UseCase useCase) {
        return useCase instanceof Preview;
    }

    public final Camera bindToLifecycle$camera_lifecycle_release(LifecycleOwner lifecycleOwner, CameraSelector primaryCameraSelector, CameraSelector secondaryCameraSelector, LayoutSettings primaryLayoutSettings, LayoutSettings secondaryLayoutSettings, ViewPort viewPort, List<? extends CameraEffect> effects, UseCase... useCases) {
        CameraInternal cameraInternal;
        RestrictedCameraInfo restrictedCameraInfo;
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(primaryCameraSelector, "primaryCameraSelector");
        Intrinsics.checkNotNullParameter(primaryLayoutSettings, "primaryLayoutSettings");
        Intrinsics.checkNotNullParameter(secondaryLayoutSettings, "secondaryLayoutSettings");
        Intrinsics.checkNotNullParameter(effects, "effects");
        Intrinsics.checkNotNullParameter(useCases, "useCases");
        Trace.beginSection("CX:bindToLifecycle-internal");
        try {
            Threads.checkMainThread();
            CameraX cameraX = this.mCameraX;
            Intrinsics.checkNotNull(cameraX);
            CameraInternal cameraInternalSelect = primaryCameraSelector.select(cameraX.getCameraRepository().getCameras());
            Intrinsics.checkNotNullExpressionValue(cameraInternalSelect, "primaryCameraSelector.se…cameraRepository.cameras)");
            cameraInternalSelect.setPrimary(true);
            CameraInfo cameraInfo = getCameraInfo(primaryCameraSelector);
            Intrinsics.checkNotNull(cameraInfo, "null cannot be cast to non-null type androidx.camera.core.impl.RestrictedCameraInfo");
            RestrictedCameraInfo restrictedCameraInfo2 = (RestrictedCameraInfo) cameraInfo;
            if (secondaryCameraSelector != null) {
                CameraX cameraX2 = this.mCameraX;
                Intrinsics.checkNotNull(cameraX2);
                CameraInternal cameraInternalSelect2 = secondaryCameraSelector.select(cameraX2.getCameraRepository().getCameras());
                cameraInternalSelect2.setPrimary(false);
                CameraInfo cameraInfo2 = getCameraInfo(secondaryCameraSelector);
                Intrinsics.checkNotNull(cameraInfo2, "null cannot be cast to non-null type androidx.camera.core.impl.RestrictedCameraInfo");
                cameraInternal = cameraInternalSelect2;
                restrictedCameraInfo = (RestrictedCameraInfo) cameraInfo2;
            } else {
                cameraInternal = null;
                restrictedCameraInfo = null;
            }
            LifecycleCamera lifecycleCamera = this.mLifecycleCameraRepository.getLifecycleCamera(lifecycleOwner, CameraUseCaseAdapter.generateCameraId(restrictedCameraInfo2, restrictedCameraInfo));
            Collection<LifecycleCamera> lifecycleCameras = this.mLifecycleCameraRepository.getLifecycleCameras();
            for (UseCase useCase : ArraysKt.filterNotNull(useCases)) {
                for (LifecycleCamera lifecycleCameras2 : lifecycleCameras) {
                    Intrinsics.checkNotNullExpressionValue(lifecycleCameras2, "lifecycleCameras");
                    LifecycleCamera lifecycleCamera2 = lifecycleCameras2;
                    if (lifecycleCamera2.isBound(useCase) && !Intrinsics.areEqual(lifecycleCamera2, lifecycleCamera)) {
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        String str = String.format("Use case %s already bound to a different lifecycle.", Arrays.copyOf(new Object[]{useCase}, 1));
                        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                        throw new IllegalStateException(str);
                    }
                }
            }
            if (lifecycleCamera == null) {
                LifecycleCameraRepository lifecycleCameraRepository = this.mLifecycleCameraRepository;
                CameraX cameraX3 = this.mCameraX;
                Intrinsics.checkNotNull(cameraX3);
                CameraCoordinator cameraCoordinator = cameraX3.getCameraFactory().getCameraCoordinator();
                CameraX cameraX4 = this.mCameraX;
                Intrinsics.checkNotNull(cameraX4);
                CameraDeviceSurfaceManager cameraDeviceSurfaceManager = cameraX4.getCameraDeviceSurfaceManager();
                CameraX cameraX5 = this.mCameraX;
                Intrinsics.checkNotNull(cameraX5);
                lifecycleCamera = lifecycleCameraRepository.createLifecycleCamera(lifecycleOwner, new CameraUseCaseAdapter(cameraInternalSelect, cameraInternal, restrictedCameraInfo2, restrictedCameraInfo, primaryLayoutSettings, secondaryLayoutSettings, cameraCoordinator, cameraDeviceSurfaceManager, cameraX5.getDefaultConfigFactory()));
            }
            if (useCases.length != 0) {
                LifecycleCameraRepository lifecycleCameraRepository2 = this.mLifecycleCameraRepository;
                Intrinsics.checkNotNull(lifecycleCamera);
                List listListOf = CollectionsKt.listOf(Arrays.copyOf(useCases, useCases.length));
                CameraX cameraX6 = this.mCameraX;
                Intrinsics.checkNotNull(cameraX6);
                LifecycleCamera lifecycleCamera3 = lifecycleCamera;
                lifecycleCameraRepository2.bindToLifecycleCamera(lifecycleCamera3, viewPort, effects, listListOf, cameraX6.getCameraFactory().getCameraCoordinator());
                lifecycleCamera = lifecycleCamera3;
            } else {
                Intrinsics.checkNotNull(lifecycleCamera);
            }
            Trace.endSection();
            return lifecycleCamera;
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    @Override // androidx.camera.lifecycle.LifecycleCameraProvider
    public boolean isBound(UseCase useCase) {
        Intrinsics.checkNotNullParameter(useCase, "useCase");
        for (LifecycleCamera lifecycleCamera : this.mLifecycleCameraRepository.getLifecycleCameras()) {
            Intrinsics.checkNotNullExpressionValue(lifecycleCamera, "mLifecycleCameraRepository.lifecycleCameras");
            if (lifecycleCamera.isBound(useCase)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.lifecycle.LifecycleCameraProvider
    public void unbind(UseCase... useCases) {
        Intrinsics.checkNotNullParameter(useCases, "useCases");
        Trace.beginSection("CX:unbind");
        try {
            Threads.checkMainThread();
            if (getCameraOperatingMode() != 2) {
                this.mLifecycleCameraRepository.unbind(CollectionsKt.listOf(Arrays.copyOf(useCases, useCases.length)));
                Unit unit = Unit.INSTANCE;
                Trace.endSection();
                return;
            }
            throw new UnsupportedOperationException("Unbind usecase is not supported in concurrent camera mode, call unbindAll() first.");
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    @Override // androidx.camera.lifecycle.LifecycleCameraProvider
    public void unbindAll() {
        Trace.beginSection("CX:unbindAll");
        try {
            Threads.checkMainThread();
            setCameraOperatingMode(0);
            this.mLifecycleCameraRepository.unbindAll();
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }

    @Override // androidx.camera.core.CameraProvider
    public boolean hasCamera(CameraSelector cameraSelector) throws CameraInfoUnavailableException {
        boolean z;
        Intrinsics.checkNotNullParameter(cameraSelector, "cameraSelector");
        Trace.beginSection("CX:hasCamera");
        try {
            CameraX cameraX = this.mCameraX;
            Intrinsics.checkNotNull(cameraX);
            cameraSelector.select(cameraX.getCameraRepository().getCameras());
            z = true;
        } catch (IllegalArgumentException unused) {
            z = false;
        } finally {
            Trace.endSection();
        }
        return z;
    }

    @Override // androidx.camera.core.CameraProvider
    public List<CameraInfo> getAvailableCameraInfos() {
        Trace.beginSection("CX:getAvailableCameraInfos");
        try {
            ArrayList arrayList = new ArrayList();
            CameraX cameraX = this.mCameraX;
            Intrinsics.checkNotNull(cameraX);
            LinkedHashSet<CameraInternal> cameras = cameraX.getCameraRepository().getCameras();
            Intrinsics.checkNotNullExpressionValue(cameras, "mCameraX!!.cameraRepository.cameras");
            Iterator<CameraInternal> it = cameras.iterator();
            while (it.hasNext()) {
                CameraInfo cameraInfo = it.next().getCameraInfo();
                Intrinsics.checkNotNullExpressionValue(cameraInfo, "camera.cameraInfo");
                arrayList.add(cameraInfo);
            }
            Trace.endSection();
            return arrayList;
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    public final List<List<CameraInfo>> getAvailableConcurrentCameraInfos() {
        Trace.beginSection("CX:getAvailableConcurrentCameraInfos");
        try {
            Objects.requireNonNull(this.mCameraX);
            CameraX cameraX = this.mCameraX;
            Intrinsics.checkNotNull(cameraX);
            Objects.requireNonNull(cameraX.getCameraFactory().getCameraCoordinator());
            CameraX cameraX2 = this.mCameraX;
            Intrinsics.checkNotNull(cameraX2);
            List<List<CameraSelector>> concurrentCameraSelectors = cameraX2.getCameraFactory().getCameraCoordinator().getConcurrentCameraSelectors();
            Intrinsics.checkNotNullExpressionValue(concurrentCameraSelectors, "mCameraX!!.cameraFactory…concurrentCameraSelectors");
            ArrayList arrayList = new ArrayList();
            for (List<CameraSelector> list : concurrentCameraSelectors) {
                ArrayList arrayList2 = new ArrayList();
                for (CameraSelector cameraSelector : list) {
                    try {
                        Intrinsics.checkNotNullExpressionValue(cameraSelector, "cameraSelector");
                        arrayList2.add(getCameraInfo(cameraSelector));
                    } catch (IllegalArgumentException unused) {
                    }
                }
                arrayList.add(arrayList2);
            }
            return arrayList;
        } finally {
            Trace.endSection();
        }
    }

    @Override // androidx.camera.core.CameraProvider
    public CameraInfo getCameraInfo(CameraSelector cameraSelector) {
        Object restrictedCameraInfo;
        Intrinsics.checkNotNullParameter(cameraSelector, "cameraSelector");
        Trace.beginSection("CX:getCameraInfo");
        try {
            CameraX cameraX = this.mCameraX;
            Intrinsics.checkNotNull(cameraX);
            CameraInfoInternal cameraInfoInternal = cameraSelector.select(cameraX.getCameraRepository().getCameras()).getCameraInfoInternal();
            Intrinsics.checkNotNullExpressionValue(cameraInfoInternal, "cameraSelector.select(mC…meras).cameraInfoInternal");
            CameraConfig cameraConfig = getCameraConfig(cameraSelector, cameraInfoInternal);
            CameraUseCaseAdapter.CameraId cameraIdCreate = CameraUseCaseAdapter.CameraId.create(cameraInfoInternal.getCameraId(), cameraConfig.getCompatibilityId());
            Intrinsics.checkNotNullExpressionValue(cameraIdCreate, "create(\n                …ilityId\n                )");
            synchronized (this.mLock) {
                restrictedCameraInfo = this.mCameraInfoMap.get(cameraIdCreate);
                if (restrictedCameraInfo == null) {
                    restrictedCameraInfo = new RestrictedCameraInfo(cameraInfoInternal, cameraConfig);
                    this.mCameraInfoMap.put(cameraIdCreate, restrictedCameraInfo);
                }
                Unit unit = Unit.INSTANCE;
            }
            RestrictedCameraInfo restrictedCameraInfo2 = (RestrictedCameraInfo) restrictedCameraInfo;
            Trace.endSection();
            return restrictedCameraInfo2;
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    public final boolean isConcurrentCameraModeOn() {
        return getCameraOperatingMode() == 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ListenableFuture<CameraX> getOrCreateCameraXInstance(Context context) {
        synchronized (this.mLock) {
            ListenableFuture<CameraX> listenableFuture = this.mCameraXInitializeFuture;
            if (listenableFuture != null) {
                Intrinsics.checkNotNull(listenableFuture, "null cannot be cast to non-null type com.google.common.util.concurrent.ListenableFuture<androidx.camera.core.CameraX>");
                return listenableFuture;
            }
            final CameraX cameraX = new CameraX(context, this.mCameraXConfigProvider);
            ListenableFuture<CameraX> future = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.lifecycle.ProcessCameraProvider$$ExternalSyntheticLambda0
                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                    return ProcessCameraProvider.getOrCreateCameraXInstance$lambda$18$lambda$17(this.f$0, cameraX, completer);
                }
            });
            this.mCameraXInitializeFuture = future;
            Intrinsics.checkNotNull(future, "null cannot be cast to non-null type com.google.common.util.concurrent.ListenableFuture<androidx.camera.core.CameraX>");
            return future;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object getOrCreateCameraXInstance$lambda$18$lambda$17(ProcessCameraProvider this$0, final CameraX cameraX, final CallbackToFutureAdapter.Completer completer) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(cameraX, "$cameraX");
        Intrinsics.checkNotNullParameter(completer, "completer");
        synchronized (this$0.mLock) {
            FutureChain futureChainFrom = FutureChain.from(this$0.mCameraXShutdownFuture);
            final Function1<Void, ListenableFuture<Void>> function1 = new Function1<Void, ListenableFuture<Void>>() { // from class: androidx.camera.lifecycle.ProcessCameraProvider$getOrCreateCameraXInstance$1$1$1$future$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final ListenableFuture<Void> invoke(Void r1) {
                    return cameraX.getInitializeFuture();
                }
            };
            FutureChain futureChainTransformAsync = futureChainFrom.transformAsync(new AsyncFunction() { // from class: androidx.camera.lifecycle.ProcessCameraProvider$$ExternalSyntheticLambda2
                @Override // androidx.camera.core.impl.utils.futures.AsyncFunction
                public final ListenableFuture apply(Object obj) {
                    return ProcessCameraProvider.getOrCreateCameraXInstance$lambda$18$lambda$17$lambda$16$lambda$15(function1, obj);
                }
            }, CameraXExecutors.directExecutor());
            Intrinsics.checkNotNullExpressionValue(futureChainTransformAsync, "cameraX = CameraX(contex…                        )");
            Futures.addCallback(futureChainTransformAsync, new FutureCallback<Void>() { // from class: androidx.camera.lifecycle.ProcessCameraProvider$getOrCreateCameraXInstance$1$1$1$1
                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onSuccess(Void result) {
                    completer.set(cameraX);
                }

                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onFailure(Throwable t) {
                    Intrinsics.checkNotNullParameter(t, "t");
                    completer.setException(t);
                }
            }, CameraXExecutors.directExecutor());
            Unit unit = Unit.INSTANCE;
        }
        return "ProcessCameraProvider-initializeCameraX";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ListenableFuture getOrCreateCameraXInstance$lambda$18$lambda$17$lambda$16$lambda$15(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return (ListenableFuture) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void configureInstanceInternal(final CameraXConfig cameraXConfig) {
        Trace.beginSection("CX:configureInstanceInternal");
        try {
            synchronized (this.mLock) {
                Preconditions.checkNotNull(cameraXConfig);
                Preconditions.checkState(this.mCameraXConfigProvider == null, "CameraX has already been configured. To use a different configuration, shutdown() must be called.");
                this.mCameraXConfigProvider = new CameraXConfig.Provider() { // from class: androidx.camera.lifecycle.ProcessCameraProvider$configureInstanceInternal$1$1$1
                    @Override // androidx.camera.core.CameraXConfig.Provider
                    public final CameraXConfig getCameraXConfig() {
                        return cameraXConfig;
                    }
                };
                Unit unit = Unit.INSTANCE;
            }
            Unit unit2 = Unit.INSTANCE;
            Trace.endSection();
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CameraConfig getCameraConfig(CameraSelector cameraSelector, CameraInfo cameraInfo) {
        CameraConfig cameraConfig = null;
        for (CameraFilter cameraFilter : cameraSelector.getCameraFilterSet()) {
            Intrinsics.checkNotNullExpressionValue(cameraFilter, "cameraSelector.cameraFilterSet");
            CameraFilter cameraFilter2 = cameraFilter;
            if (!Intrinsics.areEqual(cameraFilter2.getIdentifier(), CameraFilter.DEFAULT_ID)) {
                CameraConfigProvider configProvider = ExtendedCameraConfigProviderStore.getConfigProvider(cameraFilter2.getIdentifier());
                Context context = this.mContext;
                Intrinsics.checkNotNull(context);
                CameraConfig config = configProvider.getConfig(cameraInfo, context);
                if (config == null) {
                    continue;
                } else {
                    if (cameraConfig != null) {
                        throw new IllegalArgumentException("Cannot apply multiple extended camera configs at the same time.");
                    }
                    cameraConfig = config;
                }
            }
        }
        return cameraConfig == null ? CameraConfigs.defaultConfig() : cameraConfig;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCameraX(CameraX cameraX) {
        this.mCameraX = cameraX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setContext(Context context) {
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getCameraOperatingMode() {
        CameraX cameraX = this.mCameraX;
        if (cameraX == null) {
            return 0;
        }
        Intrinsics.checkNotNull(cameraX);
        return cameraX.getCameraFactory().getCameraCoordinator().getCameraOperatingMode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCameraOperatingMode(int i) {
        CameraX cameraX = this.mCameraX;
        if (cameraX == null) {
            return;
        }
        Intrinsics.checkNotNull(cameraX);
        cameraX.getCameraFactory().getCameraCoordinator().setCameraOperatingMode(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<CameraInfo> getActiveConcurrentCameraInfos() {
        CameraX cameraX = this.mCameraX;
        if (cameraX == null) {
            return new ArrayList();
        }
        Intrinsics.checkNotNull(cameraX);
        List<CameraInfo> activeConcurrentCameraInfos = cameraX.getCameraFactory().getCameraCoordinator().getActiveConcurrentCameraInfos();
        Intrinsics.checkNotNullExpressionValue(activeConcurrentCameraInfos, "mCameraX!!.cameraFactory…tiveConcurrentCameraInfos");
        return activeConcurrentCameraInfos;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setActiveConcurrentCameraInfos(List<? extends CameraInfo> list) {
        CameraX cameraX = this.mCameraX;
        if (cameraX == null) {
            return;
        }
        Intrinsics.checkNotNull(cameraX);
        cameraX.getCameraFactory().getCameraCoordinator().setActiveConcurrentCameraInfos(list);
    }

    /* JADX INFO: compiled from: ProcessCameraProvider.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/camera/lifecycle/ProcessCameraProvider$Companion;", "", "()V", "sAppInstance", "Landroidx/camera/lifecycle/ProcessCameraProvider;", "configureInstance", "", "cameraXConfig", "Landroidx/camera/core/CameraXConfig;", "getInstance", "Lcom/google/common/util/concurrent/ListenableFuture;", "context", "Landroid/content/Context;", "camera-lifecycle_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ListenableFuture<ProcessCameraProvider> getInstance(final Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Preconditions.checkNotNull(context);
            ListenableFuture orCreateCameraXInstance = ProcessCameraProvider.sAppInstance.getOrCreateCameraXInstance(context);
            final Function1<CameraX, ProcessCameraProvider> function1 = new Function1<CameraX, ProcessCameraProvider>() { // from class: androidx.camera.lifecycle.ProcessCameraProvider$Companion$getInstance$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final ProcessCameraProvider invoke(CameraX cameraX) {
                    ProcessCameraProvider processCameraProvider = ProcessCameraProvider.sAppInstance;
                    Intrinsics.checkNotNullExpressionValue(cameraX, "cameraX");
                    processCameraProvider.setCameraX(cameraX);
                    ProcessCameraProvider processCameraProvider2 = ProcessCameraProvider.sAppInstance;
                    Context applicationContext = ContextUtil.getApplicationContext(context);
                    Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(context)");
                    processCameraProvider2.setContext(applicationContext);
                    return ProcessCameraProvider.sAppInstance;
                }
            };
            ListenableFuture<ProcessCameraProvider> listenableFutureTransform = Futures.transform(orCreateCameraXInstance, new Function() { // from class: androidx.camera.lifecycle.ProcessCameraProvider$Companion$$ExternalSyntheticLambda0
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return ProcessCameraProvider.Companion.getInstance$lambda$0(function1, obj);
                }
            }, CameraXExecutors.directExecutor());
            Intrinsics.checkNotNullExpressionValue(listenableFutureTransform, "context: Context): Liste…tExecutor()\n            )");
            return listenableFutureTransform;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final ProcessCameraProvider getInstance$lambda$0(Function1 tmp0, Object obj) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            return (ProcessCameraProvider) tmp0.invoke(obj);
        }

        @JvmStatic
        public final void configureInstance(CameraXConfig cameraXConfig) {
            Intrinsics.checkNotNullParameter(cameraXConfig, "cameraXConfig");
            Trace.beginSection("CX:configureInstance");
            try {
                ProcessCameraProvider.sAppInstance.configureInstanceInternal(cameraXConfig);
                Unit unit = Unit.INSTANCE;
            } finally {
                Trace.endSection();
            }
        }
    }
}
