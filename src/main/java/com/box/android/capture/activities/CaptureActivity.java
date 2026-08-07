package com.box.android.capture.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.WindowCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.box.android.base.presentation.ThumbnailManager;
import com.box.android.base.presentation.fragments.models.BottomSheetAttributes;
import com.box.android.base.presentation.utilities.EdgeToEdgeUtils;
import com.box.android.base.presentation.utilities.IItemActionHandler;
import com.box.android.base.presentation.views.ToolbarWithOverlayWarning;
import com.box.android.browse.cpl.itempicker.ItemPickerActivity;
import com.box.android.capture.CaptureErrorFragment;
import com.box.android.capture.CaptureHistoryFragment;
import com.box.android.capture.ICaptureActivity;
import com.box.android.capture.IPermissionHandler;
import com.box.android.capture.audiorecording.cpl.AudioCaptureReducer;
import com.box.android.capture.cpl.CaptureModeState;
import com.box.android.capture.cpl.CaptureReducer;
import com.box.android.capture.cpl.CaptureSettingsReducer;
import com.box.android.capture.cpl.ImageCaptureReducer;
import com.box.android.capture.cpl.UninitializedCaptureModeState;
import com.box.android.capture.databinding.LayoutCaptureActivityBinding;
import com.box.android.capture.documentscanning.DocumentScanningReducer;
import com.box.android.capture.videorecording.VideoCaptureReducer;
import com.box.android.capture.videorecording.VideoRecordingReducer;
import com.box.android.capture.viewmodel.CaptureViewModel;
import com.box.android.capture.widget.CaptureModeSwitcherKt;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.common.utilities.IntentConstants;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.cpl.Store;
import com.box.android.cpl.StoreKt;
import com.box.android.domain.R;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.mappers.FolderModelMapper;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.capture.CaptureMode;
import com.box.android.domain.models.capture.FlashMode;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.PermissionsModel;
import com.box.android.domain.models.preview.PreviewSource;
import com.box.android.utilities.CoroutineExtensionsKt;
import com.box.androidsdk.content.models.BoxFolder;
import com.pspdfkit.BuildConfig;
import dagger.hilt.android.AndroidEntryPoint;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.KClassesJvm;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: CaptureActivity.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000¿\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001.\b\u0007\u0018\u0000 i2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001iB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u00100\u001a\u0004\u0018\u000101H\u0014¢\u0006\u0002\u00102J\u0012\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000106H\u0014J\u0006\u00107\u001a\u000208J\u0012\u00109\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000106H\u0015J\u0010\u0010:\u001a\u0002042\u0006\u0010;\u001a\u00020<H\u0002J\b\u0010=\u001a\u000204H\u0016J\b\u0010>\u001a\u000204H\u0016J\b\u0010?\u001a\u000208H\u0014J\"\u0010@\u001a\u0002042\u0006\u0010A\u001a\u0002012\u0006\u0010B\u001a\u0002012\b\u0010C\u001a\u0004\u0018\u00010DH\u0014J\b\u0010E\u001a\u000204H\u0002J\b\u0010F\u001a\u000204H\u0002J\b\u0010G\u001a\u000204H\u0002J\b\u0010H\u001a\u000204H\u0002J\u0018\u0010I\u001a\u0002042\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u000208H\u0002J\b\u0010M\u001a\u000204H\u0002J\b\u0010N\u001a\u000204H\u0002J\b\u0010O\u001a\u000204H\u0002J\u0010\u0010P\u001a\u0002082\u0006\u0010Q\u001a\u00020RH\u0016J\u0010\u0010S\u001a\u0002042\u0006\u0010Q\u001a\u00020RH\u0016J\u001b\u0010T\u001a\b\u0012\u0004\u0012\u00020 0U2\u0006\u0010Q\u001a\u00020RH\u0016¢\u0006\u0002\u0010VJ\u0010\u0010W\u001a\u0002042\u0006\u0010Q\u001a\u00020RH\u0016J\u0010\u0010X\u001a\u0002042\u0006\u0010Y\u001a\u00020ZH\u0016J\b\u0010[\u001a\u000204H\u0016J\u0010\u0010\\\u001a\u0002042\u0006\u0010]\u001a\u00020^H\u0016J \u0010_\u001a\u0002042\u0006\u0010]\u001a\u00020^2\u0006\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020cH\u0016J\b\u0010d\u001a\u000204H\u0016J\u001a\u0010e\u001a\u0002042\u0006\u0010f\u001a\u00020g2\b\b\u0002\u0010h\u001a\u000208H\u0002R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\"X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020(X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0010\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0004\n\u0002\u0010/¨\u0006j"}, d2 = {"Lcom/box/android/capture/activities/CaptureActivity;", "Lcom/box/android/base/presentation/activities/BoxFragmentActivity;", "Lcom/box/android/capture/IPermissionHandler;", "Lcom/box/android/capture/ICaptureActivity;", "<init>", "()V", "itemActionHandlerFactory", "Lcom/box/android/base/presentation/utilities/IItemActionHandler$Factory;", "getItemActionHandlerFactory", "()Lcom/box/android/base/presentation/utilities/IItemActionHandler$Factory;", "setItemActionHandlerFactory", "(Lcom/box/android/base/presentation/utilities/IItemActionHandler$Factory;)V", "itemActionHandler", "Lcom/box/android/base/presentation/utilities/IItemActionHandler;", "getItemActionHandler", "()Lcom/box/android/base/presentation/utilities/IItemActionHandler;", "setItemActionHandler", "(Lcom/box/android/base/presentation/utilities/IItemActionHandler;)V", "intentServices", "Lcom/box/android/coreservices/services/IntentServices;", "getIntentServices", "()Lcom/box/android/coreservices/services/IntentServices;", "setIntentServices", "(Lcom/box/android/coreservices/services/IntentServices;)V", "captureViewModel", "Lcom/box/android/capture/viewmodel/CaptureViewModel;", "getCaptureViewModel", "()Lcom/box/android/capture/viewmodel/CaptureViewModel;", "captureViewModel$delegate", "Lkotlin/Lazy;", "unavailableCams", "", "", "cameraManager", "Landroid/hardware/camera2/CameraManager;", "getCameraManager", "()Landroid/hardware/camera2/CameraManager;", "setCameraManager", "(Landroid/hardware/camera2/CameraManager;)V", "binding", "Lcom/box/android/capture/databinding/LayoutCaptureActivityBinding;", "getBinding", "()Lcom/box/android/capture/databinding/LayoutCaptureActivityBinding;", "setBinding", "(Lcom/box/android/capture/databinding/LayoutCaptureActivityBinding;)V", "cameraAvailabilityCallback", "com/box/android/capture/activities/CaptureActivity$cameraAvailabilityCallback$1", "Lcom/box/android/capture/activities/CaptureActivity$cameraAvailabilityCallback$1;", "getActivityLayoutId", "", "()Ljava/lang/Integer;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "areAllCamerasAvailable", "", "onBoxCreate", "renderView", "state", "Lcom/box/android/capture/cpl/CaptureReducer$State;", "onBoxResume", "onPause", "shouldHandleCaptureLaunch", "handleOnActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "setupWindow", "setupUI", "showProgress", "hideProgress", "updateFolderLabel", "folder", "Lcom/box/android/domain/models/item/FolderModel;", "enabled", "showFolderErrorState", "setupOnClickEvents", "setupModeSwitcher", "areAllPermissionsGranted", "captureMode", "Lcom/box/android/domain/models/capture/CaptureMode;", "onPermissionsGranted", "requiredPermissions", "", "(Lcom/box/android/domain/models/capture/CaptureMode;)[Ljava/lang/String;", "openErrorFragment", "showCaptureHistory", "fragmentTransaction", "Landroidx/fragment/app/FragmentTransaction;", "closeCaptureHistory", "onItemClick", "item", "Lcom/box/android/domain/models/item/FileModel;", "showBottomSheet", "type", "Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$BottomSheetMenuType;", "launchContext", "Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$LaunchContext;", "onDestroy", "replaceFragment", BuildConfig.FLAVOR, "Landroidx/fragment/app/Fragment;", "shouldAddToBackStack", "Companion", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
public final class CaptureActivity extends Hilt_CaptureActivity implements IPermissionHandler, ICaptureActivity {
    private static final String FOLDER_ID = "folderId";
    private static final int SELECT_FOLDER_REQUEST = 100;
    public LayoutCaptureActivityBinding binding;
    private final CaptureActivity$cameraAvailabilityCallback$1 cameraAvailabilityCallback;
    public CameraManager cameraManager;

    /* JADX INFO: renamed from: captureViewModel$delegate, reason: from kotlin metadata */
    private final Lazy captureViewModel;

    @Inject
    public IntentServices intentServices;
    public IItemActionHandler itemActionHandler;

    @Inject
    public IItemActionHandler.Factory itemActionHandlerFactory;
    private final Set<String> unavailableCams;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final String[] CAMERA_CAPTURE_REQUIRED_PERMISSIONS = {"android.permission.CAMERA"};
    private static final String[] VIDEO_CAPTURE_REQUIRED_PERMISSIONS = {"android.permission.CAMERA", "android.permission.RECORD_AUDIO"};
    private static final String[] AUDIO_CAPTURE_REQUIRED_PERMISSIONS = {"android.permission.RECORD_AUDIO"};

    /* JADX INFO: compiled from: CaptureActivity.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[FlashMode.values().length];
            try {
                iArr[FlashMode.AUTO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FlashMode.OFF.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FlashMode.ON.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[CaptureMode.values().length];
            try {
                iArr2[CaptureMode.PHOTO.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[CaptureMode.SCAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[CaptureMode.AUDIO.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[CaptureMode.VIDEO.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected Integer getActivityLayoutId() {
        return null;
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected boolean shouldHandleCaptureLaunch() {
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.box.android.capture.activities.CaptureActivity$cameraAvailabilityCallback$1] */
    public CaptureActivity() {
        getDelegate().setLocalNightMode(2);
        final CaptureActivity captureActivity = this;
        final Function0 function0 = null;
        this.captureViewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(CaptureViewModel.class), new Function0<ViewModelStore>() { // from class: com.box.android.capture.activities.CaptureActivity$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return captureActivity.getViewModelStore();
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.box.android.capture.activities.CaptureActivity$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return captureActivity.getDefaultViewModelProviderFactory();
            }
        }, new Function0<CreationExtras>() { // from class: com.box.android.capture.activities.CaptureActivity$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? captureActivity.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
        this.unavailableCams = new LinkedHashSet();
        this.cameraAvailabilityCallback = new CameraManager.AvailabilityCallback() { // from class: com.box.android.capture.activities.CaptureActivity$cameraAvailabilityCallback$1
            @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
            public void onCameraAvailable(String cameraId) {
                Intrinsics.checkNotNullParameter(cameraId, "cameraId");
                this.this$0.unavailableCams.remove(cameraId);
            }

            @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
            public void onCameraUnavailable(String cameraId) {
                Intrinsics.checkNotNullParameter(cameraId, "cameraId");
                this.this$0.unavailableCams.add(cameraId);
            }
        };
    }

    /* JADX INFO: compiled from: CaptureActivity.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0006R\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u000b\u0010\bR\u0019\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\r\u0010\bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/box/android/capture/activities/CaptureActivity$Companion;", "", "<init>", "()V", "CAMERA_CAPTURE_REQUIRED_PERMISSIONS", "", "", "getCAMERA_CAPTURE_REQUIRED_PERMISSIONS", "()[Ljava/lang/String;", "[Ljava/lang/String;", "VIDEO_CAPTURE_REQUIRED_PERMISSIONS", "getVIDEO_CAPTURE_REQUIRED_PERMISSIONS", "AUDIO_CAPTURE_REQUIRED_PERMISSIONS", "getAUDIO_CAPTURE_REQUIRED_PERMISSIONS", "SELECT_FOLDER_REQUEST", "", "FOLDER_ID", "getLaunchIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "captureMode", "Lcom/box/android/domain/models/capture/CaptureMode;", "folderId", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String[] getCAMERA_CAPTURE_REQUIRED_PERMISSIONS() {
            return CaptureActivity.CAMERA_CAPTURE_REQUIRED_PERMISSIONS;
        }

        public final String[] getVIDEO_CAPTURE_REQUIRED_PERMISSIONS() {
            return CaptureActivity.VIDEO_CAPTURE_REQUIRED_PERMISSIONS;
        }

        public final String[] getAUDIO_CAPTURE_REQUIRED_PERMISSIONS() {
            return CaptureActivity.AUDIO_CAPTURE_REQUIRED_PERMISSIONS;
        }

        public static /* synthetic */ Intent getLaunchIntent$default(Companion companion, Context context, CaptureMode captureMode, String str, int i, Object obj) {
            if ((i & 2) != 0) {
                captureMode = null;
            }
            if ((i & 4) != 0) {
                str = null;
            }
            return companion.getLaunchIntent(context, captureMode, str);
        }

        public final Intent getLaunchIntent(Context context, CaptureMode captureMode, String folderId) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) CaptureActivity.class);
            intent.putExtra("folderId", folderId);
            if (captureMode != null) {
                intent.setAction(captureMode.name());
            }
            return intent;
        }
    }

    public final IItemActionHandler.Factory getItemActionHandlerFactory() {
        IItemActionHandler.Factory factory = this.itemActionHandlerFactory;
        if (factory != null) {
            return factory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("itemActionHandlerFactory");
        return null;
    }

    public final void setItemActionHandlerFactory(IItemActionHandler.Factory factory) {
        Intrinsics.checkNotNullParameter(factory, "<set-?>");
        this.itemActionHandlerFactory = factory;
    }

    public final IItemActionHandler getItemActionHandler() {
        IItemActionHandler iItemActionHandler = this.itemActionHandler;
        if (iItemActionHandler != null) {
            return iItemActionHandler;
        }
        Intrinsics.throwUninitializedPropertyAccessException("itemActionHandler");
        return null;
    }

    public final void setItemActionHandler(IItemActionHandler iItemActionHandler) {
        Intrinsics.checkNotNullParameter(iItemActionHandler, "<set-?>");
        this.itemActionHandler = iItemActionHandler;
    }

    public final IntentServices getIntentServices() {
        IntentServices intentServices = this.intentServices;
        if (intentServices != null) {
            return intentServices;
        }
        Intrinsics.throwUninitializedPropertyAccessException("intentServices");
        return null;
    }

    public final void setIntentServices(IntentServices intentServices) {
        Intrinsics.checkNotNullParameter(intentServices, "<set-?>");
        this.intentServices = intentServices;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CaptureViewModel getCaptureViewModel() {
        return (CaptureViewModel) this.captureViewModel.getValue();
    }

    public final CameraManager getCameraManager() {
        CameraManager cameraManager = this.cameraManager;
        if (cameraManager != null) {
            return cameraManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("cameraManager");
        return null;
    }

    public final void setCameraManager(CameraManager cameraManager) {
        Intrinsics.checkNotNullParameter(cameraManager, "<set-?>");
        this.cameraManager = cameraManager;
    }

    public final LayoutCaptureActivityBinding getBinding() {
        LayoutCaptureActivityBinding layoutCaptureActivityBinding = this.binding;
        if (layoutCaptureActivityBinding != null) {
            return layoutCaptureActivityBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(LayoutCaptureActivityBinding layoutCaptureActivityBinding) {
        Intrinsics.checkNotNullParameter(layoutCaptureActivityBinding, "<set-?>");
        this.binding = layoutCaptureActivityBinding;
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        LayoutCaptureActivityBinding layoutCaptureActivityBindingInflate = LayoutCaptureActivityBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(layoutCaptureActivityBindingInflate, "inflate(...)");
        setBinding(layoutCaptureActivityBindingInflate);
        setContentView(getBinding().getRoot());
        super.onMAMCreate(null);
        Object systemService = getSystemService("camera");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.camera2.CameraManager");
        setCameraManager((CameraManager) systemService);
        getCameraManager().registerAvailabilityCallback(this.cameraAvailabilityCallback, (Handler) null);
    }

    public final boolean areAllCamerasAvailable() {
        return this.unavailableCams.isEmpty();
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected void onBoxCreate(Bundle savedInstanceState) {
        CaptureMode captureMode;
        CaptureMode next;
        super.onBoxCreate(savedInstanceState);
        BoxAmplitudeAnalytics.createCaptureEventBuilder().logCaptureLaunched();
        setItemActionHandler(getItemActionHandlerFactory().create(this));
        ToolbarWithOverlayWarning toolbarWithOverlayWarning = getBinding().captureToolbar.toolbar;
        Intrinsics.checkNotNull(toolbarWithOverlayWarning, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        setSupportActionBar(toolbarWithOverlayWarning);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.hide();
        }
        String action = getIntent().getAction();
        if (action != null) {
            Iterator<CaptureMode> it = CaptureMode.getEntries().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics.areEqual(next.name(), action));
            captureMode = next;
        } else {
            captureMode = null;
        }
        CaptureActivity captureActivity = this;
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(captureActivity), null, null, new AnonymousClass1(getCaptureViewModel().getStore().scope(new PropertyReference1Impl() { // from class: com.box.android.capture.activities.CaptureActivity$onBoxCreate$captureStateScope$1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((CaptureReducer.State) obj).getCaptureModeState();
            }
        }), null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(captureActivity), null, null, new AnonymousClass2(null), 3, null);
        StoreKt.observe$default(getCaptureViewModel().getStore(), new PropertyReference1Impl() { // from class: com.box.android.capture.activities.CaptureActivity.onBoxCreate.3
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Boolean.valueOf(((CaptureReducer.State) obj).isSelectingFolder());
            }
        }, null, new Function1() { // from class: com.box.android.capture.activities.CaptureActivity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CaptureActivity.onBoxCreate$lambda$1(this.f$0, ((Boolean) obj).booleanValue());
            }
        }, 2, null);
        if (!getResources().getBoolean(R.bool.is7inchOrLarger)) {
            setRequestedOrientation(1);
        }
        setupUI();
        setupWindow();
        setupOnClickEvents();
        getCaptureViewModel().getStore().send(new CaptureReducer.Action.InitializeFolder(getIntent().getStringExtra("folderId"), captureMode));
        CaptureReducer.State value = getCaptureViewModel().getStore().getState().getValue();
        CaptureMode captureMode2 = value.getCaptureMode();
        setupModeSwitcher();
        if (value.getCaptureModeState() instanceof UninitializedCaptureModeState) {
            getCaptureViewModel().getStore().send(new CaptureReducer.Action.SwitchMode(captureMode2));
        }
    }

    /* JADX INFO: renamed from: com.box.android.capture.activities.CaptureActivity$onBoxCreate$1, reason: invalid class name */
    /* JADX INFO: compiled from: CaptureActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.activities.CaptureActivity$onBoxCreate$1", f = "CaptureActivity.kt", i = {}, l = {Token.CONST}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Store<CaptureModeState, CaptureReducer.Action> $captureStateScope;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Store<CaptureModeState, CaptureReducer.Action> store, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$captureStateScope = store;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CaptureActivity.this.new AnonymousClass1(this.$captureStateScope, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.box.android.capture.activities.CaptureActivity$onBoxCreate$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: CaptureActivity.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.box.android.capture.activities.CaptureActivity$onBoxCreate$1$1", f = "CaptureActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class C01311 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Store<CaptureModeState, CaptureReducer.Action> $captureStateScope;
            int label;
            final /* synthetic */ CaptureActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01311(Store<CaptureModeState, CaptureReducer.Action> store, CaptureActivity captureActivity, Continuation<? super C01311> continuation) {
                super(2, continuation);
                this.$captureStateScope = store;
                this.this$0 = captureActivity;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01311(this.$captureStateScope, this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01311) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Store<CaptureModeState, CaptureReducer.Action> store = this.$captureStateScope;
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ImageCaptureReducer.State.class);
                C01321 c01321 = C01321.INSTANCE;
                LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this.this$0);
                CaptureActivity captureActivity = this.this$0;
                final Flow flowDistinctUntilChanged = FlowKt.distinctUntilChanged(store.getState(), new Function2<CaptureModeState, CaptureModeState, Boolean>() { // from class: com.box.android.capture.activities.CaptureActivity$onBoxCreate$1$1$invokeSuspend$$inlined$switchScope$1
                    @Override // kotlin.jvm.functions.Function2
                    public final Boolean invoke(CaptureModeState old, CaptureModeState captureModeState) {
                        Intrinsics.checkNotNullParameter(old, "old");
                        Intrinsics.checkNotNullParameter(captureModeState, "new");
                        return Boolean.valueOf((old instanceof ImageCaptureReducer.State) && (captureModeState instanceof ImageCaptureReducer.State));
                    }
                });
                FlowKt.launchIn(FlowKt.onEach(new Flow<ImageCaptureReducer.State>() { // from class: com.box.android.capture.activities.CaptureActivity$onBoxCreate$1$1$invokeSuspend$$inlined$switchScope$2
                    @Override // kotlinx.coroutines.flow.Flow
                    public Object collect(FlowCollector<? super ImageCaptureReducer.State> flowCollector, Continuation continuation) {
                        Object objCollect = flowDistinctUntilChanged.collect(new AnonymousClass2(flowCollector), continuation);
                        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: com.box.android.capture.activities.CaptureActivity$onBoxCreate$1$1$invokeSuspend$$inlined$switchScope$2$2, reason: invalid class name */
                    /* JADX INFO: compiled from: Emitters.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2", "com/box/android/cpl/StoreKt$switchScope$$inlined$mapNotNull$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        /* JADX INFO: renamed from: com.box.android.capture.activities.CaptureActivity$onBoxCreate$1$1$invokeSuspend$$inlined$switchScope$2$2$1, reason: invalid class name */
                        /* JADX INFO: compiled from: Emitters.kt */
                        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                        @DebugMetadata(c = "com.box.android.capture.activities.CaptureActivity$onBoxCreate$1$1$invokeSuspend$$inlined$switchScope$2$2", f = "CaptureActivity.kt", i = {0, 0, 0, 0, 0, 0}, l = {221}, m = "emit", n = {"value", "$completion", "value", "$this$mapNotNull_u24lambda_u246", "transformed", "$i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
                        public static final class AnonymousClass1 extends ContinuationImpl {
                            int I$0;
                            Object L$0;
                            Object L$1;
                            Object L$2;
                            Object L$3;
                            Object L$4;
                            int label;
                            /* synthetic */ Object result;

                            public AnonymousClass1(Continuation continuation) {
                                super(continuation);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                this.result = obj;
                                this.label |= Integer.MIN_VALUE;
                                return AnonymousClass2.this.emit(null, this);
                            }
                        }

                        public AnonymousClass2(FlowCollector flowCollector) {
                            this.$this_unsafeFlow = flowCollector;
                        }

                        /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public final Object emit(Object obj, Continuation continuation) {
                            AnonymousClass1 anonymousClass1;
                            if (continuation instanceof AnonymousClass1) {
                                anonymousClass1 = (AnonymousClass1) continuation;
                                if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                                    anonymousClass1.label -= Integer.MIN_VALUE;
                                } else {
                                    anonymousClass1 = new AnonymousClass1(continuation);
                                }
                            } else {
                                anonymousClass1 = new AnonymousClass1(continuation);
                            }
                            Object obj2 = anonymousClass1.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = anonymousClass1.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj2);
                                FlowCollector flowCollector = this.$this_unsafeFlow;
                                ImageCaptureReducer.State state = (ImageCaptureReducer.State) (!(obj instanceof ImageCaptureReducer.State) ? null : obj);
                                if (state != null) {
                                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                    anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                                    anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                                    anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(state);
                                    anonymousClass1.I$0 = 0;
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(state, anonymousClass1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                            } else {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                int i2 = anonymousClass1.I$0;
                                Object obj3 = anonymousClass1.L$2;
                                Object obj4 = anonymousClass1.L$0;
                                ResultKt.throwOnFailure(obj2);
                            }
                            return Unit.INSTANCE;
                        }
                    }
                }, new CaptureActivity$onBoxCreate$1$1$invokeSuspend$$inlined$switchScope$3(store, orCreateKotlinClass, c01321, null, captureActivity)), StoreKt.registerCoroutineScope(store, CoroutineExtensionsKt.getChildScope(lifecycleScope), KClassesJvm.getJvmName(orCreateKotlinClass)));
                Store<CaptureModeState, CaptureReducer.Action> store2 = this.$captureStateScope;
                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(VideoCaptureReducer.State.class);
                AnonymousClass3 anonymousClass3 = AnonymousClass3.INSTANCE;
                LifecycleCoroutineScope lifecycleScope2 = LifecycleOwnerKt.getLifecycleScope(this.this$0);
                CaptureActivity captureActivity2 = this.this$0;
                final Flow flowDistinctUntilChanged2 = FlowKt.distinctUntilChanged(store2.getState(), new Function2<CaptureModeState, CaptureModeState, Boolean>() { // from class: com.box.android.capture.activities.CaptureActivity$onBoxCreate$1$1$invokeSuspend$$inlined$switchScope$4
                    @Override // kotlin.jvm.functions.Function2
                    public final Boolean invoke(CaptureModeState old, CaptureModeState captureModeState) {
                        Intrinsics.checkNotNullParameter(old, "old");
                        Intrinsics.checkNotNullParameter(captureModeState, "new");
                        return Boolean.valueOf((old instanceof VideoCaptureReducer.State) && (captureModeState instanceof VideoCaptureReducer.State));
                    }
                });
                FlowKt.launchIn(FlowKt.onEach(new Flow<VideoCaptureReducer.State>() { // from class: com.box.android.capture.activities.CaptureActivity$onBoxCreate$1$1$invokeSuspend$$inlined$switchScope$5
                    @Override // kotlinx.coroutines.flow.Flow
                    public Object collect(FlowCollector<? super VideoCaptureReducer.State> flowCollector, Continuation continuation) {
                        Object objCollect = flowDistinctUntilChanged2.collect(new AnonymousClass2(flowCollector), continuation);
                        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: com.box.android.capture.activities.CaptureActivity$onBoxCreate$1$1$invokeSuspend$$inlined$switchScope$5$2, reason: invalid class name */
                    /* JADX INFO: compiled from: Emitters.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2", "com/box/android/cpl/StoreKt$switchScope$$inlined$mapNotNull$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        /* JADX INFO: renamed from: com.box.android.capture.activities.CaptureActivity$onBoxCreate$1$1$invokeSuspend$$inlined$switchScope$5$2$1, reason: invalid class name */
                        /* JADX INFO: compiled from: Emitters.kt */
                        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                        @DebugMetadata(c = "com.box.android.capture.activities.CaptureActivity$onBoxCreate$1$1$invokeSuspend$$inlined$switchScope$5$2", f = "CaptureActivity.kt", i = {0, 0, 0, 0, 0, 0}, l = {221}, m = "emit", n = {"value", "$completion", "value", "$this$mapNotNull_u24lambda_u246", "transformed", "$i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
                        public static final class AnonymousClass1 extends ContinuationImpl {
                            int I$0;
                            Object L$0;
                            Object L$1;
                            Object L$2;
                            Object L$3;
                            Object L$4;
                            int label;
                            /* synthetic */ Object result;

                            public AnonymousClass1(Continuation continuation) {
                                super(continuation);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                this.result = obj;
                                this.label |= Integer.MIN_VALUE;
                                return AnonymousClass2.this.emit(null, this);
                            }
                        }

                        public AnonymousClass2(FlowCollector flowCollector) {
                            this.$this_unsafeFlow = flowCollector;
                        }

                        /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public final Object emit(Object obj, Continuation continuation) {
                            AnonymousClass1 anonymousClass1;
                            if (continuation instanceof AnonymousClass1) {
                                anonymousClass1 = (AnonymousClass1) continuation;
                                if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                                    anonymousClass1.label -= Integer.MIN_VALUE;
                                } else {
                                    anonymousClass1 = new AnonymousClass1(continuation);
                                }
                            } else {
                                anonymousClass1 = new AnonymousClass1(continuation);
                            }
                            Object obj2 = anonymousClass1.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = anonymousClass1.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj2);
                                FlowCollector flowCollector = this.$this_unsafeFlow;
                                VideoCaptureReducer.State state = (VideoCaptureReducer.State) (!(obj instanceof VideoCaptureReducer.State) ? null : obj);
                                if (state != null) {
                                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                    anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                                    anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                                    anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(state);
                                    anonymousClass1.I$0 = 0;
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(state, anonymousClass1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                            } else {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                int i2 = anonymousClass1.I$0;
                                Object obj3 = anonymousClass1.L$2;
                                Object obj4 = anonymousClass1.L$0;
                                ResultKt.throwOnFailure(obj2);
                            }
                            return Unit.INSTANCE;
                        }
                    }
                }, new CaptureActivity$onBoxCreate$1$1$invokeSuspend$$inlined$switchScope$6(store2, orCreateKotlinClass2, anonymousClass3, null, captureActivity2)), StoreKt.registerCoroutineScope(store2, CoroutineExtensionsKt.getChildScope(lifecycleScope2), KClassesJvm.getJvmName(orCreateKotlinClass2)));
                Store<CaptureModeState, CaptureReducer.Action> store3 = this.$captureStateScope;
                KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(AudioCaptureReducer.State.class);
                AnonymousClass5 anonymousClass5 = AnonymousClass5.INSTANCE;
                LifecycleCoroutineScope lifecycleScope3 = LifecycleOwnerKt.getLifecycleScope(this.this$0);
                CaptureActivity captureActivity3 = this.this$0;
                final Flow flowDistinctUntilChanged3 = FlowKt.distinctUntilChanged(store3.getState(), new Function2<CaptureModeState, CaptureModeState, Boolean>() { // from class: com.box.android.capture.activities.CaptureActivity$onBoxCreate$1$1$invokeSuspend$$inlined$switchScope$7
                    @Override // kotlin.jvm.functions.Function2
                    public final Boolean invoke(CaptureModeState old, CaptureModeState captureModeState) {
                        Intrinsics.checkNotNullParameter(old, "old");
                        Intrinsics.checkNotNullParameter(captureModeState, "new");
                        return Boolean.valueOf((old instanceof AudioCaptureReducer.State) && (captureModeState instanceof AudioCaptureReducer.State));
                    }
                });
                FlowKt.launchIn(FlowKt.onEach(new Flow<AudioCaptureReducer.State>() { // from class: com.box.android.capture.activities.CaptureActivity$onBoxCreate$1$1$invokeSuspend$$inlined$switchScope$8
                    @Override // kotlinx.coroutines.flow.Flow
                    public Object collect(FlowCollector<? super AudioCaptureReducer.State> flowCollector, Continuation continuation) {
                        Object objCollect = flowDistinctUntilChanged3.collect(new AnonymousClass2(flowCollector), continuation);
                        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: com.box.android.capture.activities.CaptureActivity$onBoxCreate$1$1$invokeSuspend$$inlined$switchScope$8$2, reason: invalid class name */
                    /* JADX INFO: compiled from: Emitters.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2", "com/box/android/cpl/StoreKt$switchScope$$inlined$mapNotNull$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        /* JADX INFO: renamed from: com.box.android.capture.activities.CaptureActivity$onBoxCreate$1$1$invokeSuspend$$inlined$switchScope$8$2$1, reason: invalid class name */
                        /* JADX INFO: compiled from: Emitters.kt */
                        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                        @DebugMetadata(c = "com.box.android.capture.activities.CaptureActivity$onBoxCreate$1$1$invokeSuspend$$inlined$switchScope$8$2", f = "CaptureActivity.kt", i = {0, 0, 0, 0, 0, 0}, l = {221}, m = "emit", n = {"value", "$completion", "value", "$this$mapNotNull_u24lambda_u246", "transformed", "$i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
                        public static final class AnonymousClass1 extends ContinuationImpl {
                            int I$0;
                            Object L$0;
                            Object L$1;
                            Object L$2;
                            Object L$3;
                            Object L$4;
                            int label;
                            /* synthetic */ Object result;

                            public AnonymousClass1(Continuation continuation) {
                                super(continuation);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                this.result = obj;
                                this.label |= Integer.MIN_VALUE;
                                return AnonymousClass2.this.emit(null, this);
                            }
                        }

                        public AnonymousClass2(FlowCollector flowCollector) {
                            this.$this_unsafeFlow = flowCollector;
                        }

                        /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public final Object emit(Object obj, Continuation continuation) {
                            AnonymousClass1 anonymousClass1;
                            if (continuation instanceof AnonymousClass1) {
                                anonymousClass1 = (AnonymousClass1) continuation;
                                if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                                    anonymousClass1.label -= Integer.MIN_VALUE;
                                } else {
                                    anonymousClass1 = new AnonymousClass1(continuation);
                                }
                            } else {
                                anonymousClass1 = new AnonymousClass1(continuation);
                            }
                            Object obj2 = anonymousClass1.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = anonymousClass1.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj2);
                                FlowCollector flowCollector = this.$this_unsafeFlow;
                                AudioCaptureReducer.State state = (AudioCaptureReducer.State) (!(obj instanceof AudioCaptureReducer.State) ? null : obj);
                                if (state != null) {
                                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                    anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                                    anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                                    anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(state);
                                    anonymousClass1.I$0 = 0;
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(state, anonymousClass1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                            } else {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                int i2 = anonymousClass1.I$0;
                                Object obj3 = anonymousClass1.L$2;
                                Object obj4 = anonymousClass1.L$0;
                                ResultKt.throwOnFailure(obj2);
                            }
                            return Unit.INSTANCE;
                        }
                    }
                }, new CaptureActivity$onBoxCreate$1$1$invokeSuspend$$inlined$switchScope$9(store3, orCreateKotlinClass3, anonymousClass5, null, captureActivity3)), StoreKt.registerCoroutineScope(store3, CoroutineExtensionsKt.getChildScope(lifecycleScope3), KClassesJvm.getJvmName(orCreateKotlinClass3)));
                Store<CaptureModeState, CaptureReducer.Action> store4 = this.$captureStateScope;
                KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(DocumentScanningReducer.State.class);
                AnonymousClass7 anonymousClass7 = AnonymousClass7.INSTANCE;
                LifecycleCoroutineScope lifecycleScope4 = LifecycleOwnerKt.getLifecycleScope(this.this$0);
                CaptureActivity captureActivity4 = this.this$0;
                final Flow flowDistinctUntilChanged4 = FlowKt.distinctUntilChanged(store4.getState(), new Function2<CaptureModeState, CaptureModeState, Boolean>() { // from class: com.box.android.capture.activities.CaptureActivity$onBoxCreate$1$1$invokeSuspend$$inlined$switchScope$10
                    @Override // kotlin.jvm.functions.Function2
                    public final Boolean invoke(CaptureModeState old, CaptureModeState captureModeState) {
                        Intrinsics.checkNotNullParameter(old, "old");
                        Intrinsics.checkNotNullParameter(captureModeState, "new");
                        return Boolean.valueOf((old instanceof DocumentScanningReducer.State) && (captureModeState instanceof DocumentScanningReducer.State));
                    }
                });
                FlowKt.launchIn(FlowKt.onEach(new Flow<DocumentScanningReducer.State>() { // from class: com.box.android.capture.activities.CaptureActivity$onBoxCreate$1$1$invokeSuspend$$inlined$switchScope$11
                    @Override // kotlinx.coroutines.flow.Flow
                    public Object collect(FlowCollector<? super DocumentScanningReducer.State> flowCollector, Continuation continuation) {
                        Object objCollect = flowDistinctUntilChanged4.collect(new AnonymousClass2(flowCollector), continuation);
                        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: com.box.android.capture.activities.CaptureActivity$onBoxCreate$1$1$invokeSuspend$$inlined$switchScope$11$2, reason: invalid class name */
                    /* JADX INFO: compiled from: Emitters.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2", "com/box/android/cpl/StoreKt$switchScope$$inlined$mapNotNull$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        /* JADX INFO: renamed from: com.box.android.capture.activities.CaptureActivity$onBoxCreate$1$1$invokeSuspend$$inlined$switchScope$11$2$1, reason: invalid class name */
                        /* JADX INFO: compiled from: Emitters.kt */
                        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                        @DebugMetadata(c = "com.box.android.capture.activities.CaptureActivity$onBoxCreate$1$1$invokeSuspend$$inlined$switchScope$11$2", f = "CaptureActivity.kt", i = {0, 0, 0, 0, 0, 0}, l = {221}, m = "emit", n = {"value", "$completion", "value", "$this$mapNotNull_u24lambda_u246", "transformed", "$i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
                        public static final class AnonymousClass1 extends ContinuationImpl {
                            int I$0;
                            Object L$0;
                            Object L$1;
                            Object L$2;
                            Object L$3;
                            Object L$4;
                            int label;
                            /* synthetic */ Object result;

                            public AnonymousClass1(Continuation continuation) {
                                super(continuation);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                this.result = obj;
                                this.label |= Integer.MIN_VALUE;
                                return AnonymousClass2.this.emit(null, this);
                            }
                        }

                        public AnonymousClass2(FlowCollector flowCollector) {
                            this.$this_unsafeFlow = flowCollector;
                        }

                        /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public final Object emit(Object obj, Continuation continuation) {
                            AnonymousClass1 anonymousClass1;
                            if (continuation instanceof AnonymousClass1) {
                                anonymousClass1 = (AnonymousClass1) continuation;
                                if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                                    anonymousClass1.label -= Integer.MIN_VALUE;
                                } else {
                                    anonymousClass1 = new AnonymousClass1(continuation);
                                }
                            } else {
                                anonymousClass1 = new AnonymousClass1(continuation);
                            }
                            Object obj2 = anonymousClass1.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = anonymousClass1.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj2);
                                FlowCollector flowCollector = this.$this_unsafeFlow;
                                DocumentScanningReducer.State state = (DocumentScanningReducer.State) (!(obj instanceof DocumentScanningReducer.State) ? null : obj);
                                if (state != null) {
                                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                    anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                                    anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                                    anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(state);
                                    anonymousClass1.I$0 = 0;
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(state, anonymousClass1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                            } else {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                int i2 = anonymousClass1.I$0;
                                Object obj3 = anonymousClass1.L$2;
                                Object obj4 = anonymousClass1.L$0;
                                ResultKt.throwOnFailure(obj2);
                            }
                            return Unit.INSTANCE;
                        }
                    }
                }, new CaptureActivity$onBoxCreate$1$1$invokeSuspend$$inlined$switchScope$12(store4, orCreateKotlinClass4, anonymousClass7, null, captureActivity4)), StoreKt.registerCoroutineScope(store4, CoroutineExtensionsKt.getChildScope(lifecycleScope4), KClassesJvm.getJvmName(orCreateKotlinClass4)));
                Store<CaptureModeState, CaptureReducer.Action> store5 = this.$captureStateScope;
                KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(CaptureSettingsReducer.State.class);
                AnonymousClass9 anonymousClass9 = AnonymousClass9.INSTANCE;
                LifecycleCoroutineScope lifecycleScope5 = LifecycleOwnerKt.getLifecycleScope(this.this$0);
                CaptureActivity captureActivity5 = this.this$0;
                final Flow flowDistinctUntilChanged5 = FlowKt.distinctUntilChanged(store5.getState(), new Function2<CaptureModeState, CaptureModeState, Boolean>() { // from class: com.box.android.capture.activities.CaptureActivity$onBoxCreate$1$1$invokeSuspend$$inlined$switchScope$13
                    @Override // kotlin.jvm.functions.Function2
                    public final Boolean invoke(CaptureModeState old, CaptureModeState captureModeState) {
                        Intrinsics.checkNotNullParameter(old, "old");
                        Intrinsics.checkNotNullParameter(captureModeState, "new");
                        return Boolean.valueOf((old instanceof CaptureSettingsReducer.State) && (captureModeState instanceof CaptureSettingsReducer.State));
                    }
                });
                FlowKt.launchIn(FlowKt.onEach(new Flow<CaptureSettingsReducer.State>() { // from class: com.box.android.capture.activities.CaptureActivity$onBoxCreate$1$1$invokeSuspend$$inlined$switchScope$14
                    @Override // kotlinx.coroutines.flow.Flow
                    public Object collect(FlowCollector<? super CaptureSettingsReducer.State> flowCollector, Continuation continuation) {
                        Object objCollect = flowDistinctUntilChanged5.collect(new AnonymousClass2(flowCollector), continuation);
                        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: com.box.android.capture.activities.CaptureActivity$onBoxCreate$1$1$invokeSuspend$$inlined$switchScope$14$2, reason: invalid class name */
                    /* JADX INFO: compiled from: Emitters.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2", "com/box/android/cpl/StoreKt$switchScope$$inlined$mapNotNull$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        /* JADX INFO: renamed from: com.box.android.capture.activities.CaptureActivity$onBoxCreate$1$1$invokeSuspend$$inlined$switchScope$14$2$1, reason: invalid class name */
                        /* JADX INFO: compiled from: Emitters.kt */
                        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                        @DebugMetadata(c = "com.box.android.capture.activities.CaptureActivity$onBoxCreate$1$1$invokeSuspend$$inlined$switchScope$14$2", f = "CaptureActivity.kt", i = {0, 0, 0, 0, 0, 0}, l = {221}, m = "emit", n = {"value", "$completion", "value", "$this$mapNotNull_u24lambda_u246", "transformed", "$i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
                        public static final class AnonymousClass1 extends ContinuationImpl {
                            int I$0;
                            Object L$0;
                            Object L$1;
                            Object L$2;
                            Object L$3;
                            Object L$4;
                            int label;
                            /* synthetic */ Object result;

                            public AnonymousClass1(Continuation continuation) {
                                super(continuation);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                this.result = obj;
                                this.label |= Integer.MIN_VALUE;
                                return AnonymousClass2.this.emit(null, this);
                            }
                        }

                        public AnonymousClass2(FlowCollector flowCollector) {
                            this.$this_unsafeFlow = flowCollector;
                        }

                        /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public final Object emit(Object obj, Continuation continuation) {
                            AnonymousClass1 anonymousClass1;
                            if (continuation instanceof AnonymousClass1) {
                                anonymousClass1 = (AnonymousClass1) continuation;
                                if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                                    anonymousClass1.label -= Integer.MIN_VALUE;
                                } else {
                                    anonymousClass1 = new AnonymousClass1(continuation);
                                }
                            } else {
                                anonymousClass1 = new AnonymousClass1(continuation);
                            }
                            Object obj2 = anonymousClass1.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = anonymousClass1.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj2);
                                FlowCollector flowCollector = this.$this_unsafeFlow;
                                CaptureSettingsReducer.State state = (CaptureSettingsReducer.State) (!(obj instanceof CaptureSettingsReducer.State) ? null : obj);
                                if (state != null) {
                                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                    anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                                    anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                                    anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(state);
                                    anonymousClass1.I$0 = 0;
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(state, anonymousClass1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                            } else {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                int i2 = anonymousClass1.I$0;
                                Object obj3 = anonymousClass1.L$2;
                                Object obj4 = anonymousClass1.L$0;
                                ResultKt.throwOnFailure(obj2);
                            }
                            return Unit.INSTANCE;
                        }
                    }
                }, new CaptureActivity$onBoxCreate$1$1$invokeSuspend$$inlined$switchScope$15(store5, orCreateKotlinClass5, anonymousClass9, null, captureActivity5)), StoreKt.registerCoroutineScope(store5, CoroutineExtensionsKt.getChildScope(lifecycleScope5), KClassesJvm.getJvmName(orCreateKotlinClass5)));
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: com.box.android.capture.activities.CaptureActivity$onBoxCreate$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: CaptureActivity.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            static final /* synthetic */ class C01321 extends FunctionReferenceImpl implements Function1<ImageCaptureReducer.Action, CaptureReducer.Action.Camera> {
                public static final C01321 INSTANCE = new C01321();

                C01321() {
                    super(1, CaptureReducer.Action.Camera.class, "<init>", "<init>(Lcom/box/android/capture/cpl/ImageCaptureReducer$Action;)V", 0);
                }

                @Override // kotlin.jvm.functions.Function1
                public final CaptureReducer.Action.Camera invoke(ImageCaptureReducer.Action p0) {
                    Intrinsics.checkNotNullParameter(p0, "p0");
                    return new CaptureReducer.Action.Camera(p0);
                }
            }

            /* JADX INFO: renamed from: com.box.android.capture.activities.CaptureActivity$onBoxCreate$1$1$3, reason: invalid class name */
            /* JADX INFO: compiled from: CaptureActivity.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<VideoCaptureReducer.Action, CaptureReducer.Action.Video> {
                public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

                AnonymousClass3() {
                    super(1, CaptureReducer.Action.Video.class, "<init>", "<init>(Lcom/box/android/capture/videorecording/VideoCaptureReducer$Action;)V", 0);
                }

                @Override // kotlin.jvm.functions.Function1
                public final CaptureReducer.Action.Video invoke(VideoCaptureReducer.Action p0) {
                    Intrinsics.checkNotNullParameter(p0, "p0");
                    return new CaptureReducer.Action.Video(p0);
                }
            }

            /* JADX INFO: renamed from: com.box.android.capture.activities.CaptureActivity$onBoxCreate$1$1$5, reason: invalid class name */
            /* JADX INFO: compiled from: CaptureActivity.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            static final /* synthetic */ class AnonymousClass5 extends FunctionReferenceImpl implements Function1<AudioCaptureReducer.Action, CaptureReducer.Action.AudioRecording> {
                public static final AnonymousClass5 INSTANCE = new AnonymousClass5();

                AnonymousClass5() {
                    super(1, CaptureReducer.Action.AudioRecording.class, "<init>", "<init>(Lcom/box/android/capture/audiorecording/cpl/AudioCaptureReducer$Action;)V", 0);
                }

                @Override // kotlin.jvm.functions.Function1
                public final CaptureReducer.Action.AudioRecording invoke(AudioCaptureReducer.Action p0) {
                    Intrinsics.checkNotNullParameter(p0, "p0");
                    return new CaptureReducer.Action.AudioRecording(p0);
                }
            }

            /* JADX INFO: renamed from: com.box.android.capture.activities.CaptureActivity$onBoxCreate$1$1$7, reason: invalid class name */
            /* JADX INFO: compiled from: CaptureActivity.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            static final /* synthetic */ class AnonymousClass7 extends FunctionReferenceImpl implements Function1<DocumentScanningReducer.Action, CaptureReducer.Action.DocumentScanning> {
                public static final AnonymousClass7 INSTANCE = new AnonymousClass7();

                AnonymousClass7() {
                    super(1, CaptureReducer.Action.DocumentScanning.class, "<init>", "<init>(Lcom/box/android/capture/documentscanning/DocumentScanningReducer$Action;)V", 0);
                }

                @Override // kotlin.jvm.functions.Function1
                public final CaptureReducer.Action.DocumentScanning invoke(DocumentScanningReducer.Action p0) {
                    Intrinsics.checkNotNullParameter(p0, "p0");
                    return new CaptureReducer.Action.DocumentScanning(p0);
                }
            }

            /* JADX INFO: renamed from: com.box.android.capture.activities.CaptureActivity$onBoxCreate$1$1$9, reason: invalid class name */
            /* JADX INFO: compiled from: CaptureActivity.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            static final /* synthetic */ class AnonymousClass9 extends FunctionReferenceImpl implements Function1<CaptureSettingsReducer.Action, CaptureReducer.Action.CaptureSettings> {
                public static final AnonymousClass9 INSTANCE = new AnonymousClass9();

                AnonymousClass9() {
                    super(1, CaptureReducer.Action.CaptureSettings.class, "<init>", "<init>(Lcom/box/android/capture/cpl/CaptureSettingsReducer$Action;)V", 0);
                }

                @Override // kotlin.jvm.functions.Function1
                public final CaptureReducer.Action.CaptureSettings invoke(CaptureSettingsReducer.Action p0) {
                    Intrinsics.checkNotNullParameter(p0, "p0");
                    return new CaptureReducer.Action.CaptureSettings(p0);
                }
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(CaptureActivity.this, Lifecycle.State.CREATED, new C01311(this.$captureStateScope, CaptureActivity.this, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.box.android.capture.activities.CaptureActivity$onBoxCreate$2, reason: invalid class name */
    /* JADX INFO: compiled from: CaptureActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.activities.CaptureActivity$onBoxCreate$2", f = "CaptureActivity.kt", i = {0}, l = {200}, m = "invokeSuspend", n = {"firstTimeRestoration"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CaptureActivity.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                booleanRef.element = true;
                this.L$0 = SpillingKt.nullOutSpilledVariable(booleanRef);
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(CaptureActivity.this, Lifecycle.State.CREATED, new AnonymousClass1(CaptureActivity.this, booleanRef, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.box.android.capture.activities.CaptureActivity$onBoxCreate$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: CaptureActivity.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.box.android.capture.activities.CaptureActivity$onBoxCreate$2$1", f = "CaptureActivity.kt", i = {}, l = {201}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Ref.BooleanRef $firstTimeRestoration;
            int label;
            final /* synthetic */ CaptureActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(CaptureActivity captureActivity, Ref.BooleanRef booleanRef, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = captureActivity;
                this.$firstTimeRestoration = booleanRef;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$firstTimeRestoration, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    StateFlow<CaptureReducer.State> state = this.this$0.getCaptureViewModel().getStore().getState();
                    final CaptureActivity captureActivity = this.this$0;
                    final Ref.BooleanRef booleanRef = this.$firstTimeRestoration;
                    this.label = 1;
                    if (state.collect(new FlowCollector() { // from class: com.box.android.capture.activities.CaptureActivity.onBoxCreate.2.1.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                            return emit((CaptureReducer.State) obj2, (Continuation<? super Unit>) continuation);
                        }

                        public final Object emit(CaptureReducer.State state2, Continuation<? super Unit> continuation) {
                            captureActivity.renderView(state2);
                            if (booleanRef.element && state2.getCaptureHistoryVisible()) {
                                captureActivity.replaceFragment(new CaptureHistoryFragment(), true);
                            }
                            booleanRef.element = false;
                            return Unit.INSTANCE;
                        }
                    }, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                throw new KotlinNothingValueException();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBoxCreate$lambda$1(CaptureActivity captureActivity, boolean z) {
        if (z) {
            captureActivity.startActivityForResult(ItemPickerActivity.Companion.getLaunchIntent$default(ItemPickerActivity.INSTANCE, captureActivity, null, true, true, captureActivity.getString(com.box.android.capture.R.string.pick_destination), 2, null), 100);
            captureActivity.getCaptureViewModel().getStore().send(CaptureReducer.Action.ChangeFolderHandled.INSTANCE);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderView(CaptureReducer.State state) {
        VideoRecordingReducer.State state2;
        getBinding().captureToolbar.toolbar.setVisibility((state.getCaptureHistoryVisible() && state.getPendingCapturePreview() == null) ? 0 : 8);
        if (state.getShouldShowProgress()) {
            showProgress();
        } else {
            hideProgress();
        }
        FolderModel selectedFolder = state.getSelectedFolder();
        if (selectedFolder != null) {
            updateFolderLabel(selectedFolder, state.getFolderSelectionEnabled());
        }
        String elapsedTime = null;
        if (state.isClosing()) {
            if (Intrinsics.areEqual(state.getSelectedFolderServerId(), ItemId.INSTANCE.getROOT_ITEM_ID())) {
                Intent intentNavigationActivityIntent$default = IntentServices.navigationActivityIntent$default(getIntentServices(), this, this.mFeatureFlips.getMainScreenRedesign().getEnabled(), null, 4, null);
                intentNavigationActivityIntent$default.addFlags(335544320);
                startActivity(intentNavigationActivityIntent$default);
            } else {
                Intent intentMainPhoneActivityIntent = getIntentServices().mainPhoneActivityIntent(this);
                intentMainPhoneActivityIntent.addFlags(335544320);
                ItemId.Remote selectedFolderServerId = state.getSelectedFolderServerId();
                intentMainPhoneActivityIntent.putExtra(IntentConstants.EXTRA_INIT_FOLDER_ID, selectedFolderServerId != null ? selectedFolderServerId.getBoxId() : null);
                startActivity(intentMainPhoneActivityIntent);
            }
            finish();
        }
        TextView textView = getBinding().elapsedTime;
        CaptureModeState captureModeState = state.getCaptureModeState();
        VideoCaptureReducer.State.Recording recording = captureModeState instanceof VideoCaptureReducer.State.Recording ? (VideoCaptureReducer.State.Recording) captureModeState : null;
        if (recording != null && (state2 = recording.getState()) != null) {
            elapsedTime = state2.getElapsedTime();
        }
        textView.setText(elapsedTime);
        FlashMode flashMode = state.getFlashMode();
        if (flashMode != null) {
            getBinding().captureFlashButton.setVisibility(0);
            int i = WhenMappings.$EnumSwitchMapping$0[flashMode.ordinal()];
            if (i == 1) {
                getBinding().captureFlashButton.setImageResource(com.box.android.capture.R.drawable.ic_flash_auto_black_24dp);
            } else if (i == 2) {
                getBinding().captureFlashButton.setImageResource(com.box.android.capture.R.drawable.ic_flash_off_black_24dp);
            } else {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                getBinding().captureFlashButton.setImageResource(com.box.android.capture.R.drawable.ic_flash_on_black_24dp);
            }
        } else {
            getBinding().captureFlashButton.setVisibility(4);
        }
        if (state.getFolderError() != null) {
            showFolderErrorState();
        }
        if (state.getModeSwitcherVisible()) {
            getBinding().modeSwitcherCompose.setVisibility(0);
        } else {
            getBinding().modeSwitcherCompose.setVisibility(4);
        }
        if (state.getTopBarVisible()) {
            getBinding().captureTopBar.setVisibility(0);
        } else {
            getBinding().captureTopBar.setVisibility(8);
        }
        if (state.getSettingsButtonVisible()) {
            getBinding().captureSettingsButton.setVisibility(0);
            getBinding().captureSettingsButton.setEnabled(true);
        } else {
            getBinding().captureSettingsButton.setVisibility(4);
            getBinding().captureSettingsButton.setEnabled(false);
        }
        if (state.getElapsedTimeVisible()) {
            getBinding().changeUploadFolderButton.setVisibility(8);
            getBinding().elapsedTime.setVisibility(0);
        } else {
            getBinding().changeUploadFolderButton.setVisibility(0);
            getBinding().elapsedTime.setVisibility(8);
        }
        if (state.getCloseButtonVisible()) {
            getBinding().captureCloseButton.setVisibility(0);
        } else {
            getBinding().captureCloseButton.setVisibility(4);
        }
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    public void onBoxResume() {
        super.onBoxResume();
        getItemActionHandler().registerItemActionHandler();
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity, androidx.fragment.app.FragmentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMPause() {
        super.onMAMPause();
        getItemActionHandler().unregisterItemActionHandler();
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected void handleOnActivityResult(int requestCode, int resultCode, Intent data) {
        super.handleOnActivityResult(requestCode, resultCode, data);
        if (requestCode != 100) {
            getItemActionHandler().handleActivityResult(requestCode, resultCode, data);
        } else if (resultCode == -1) {
            FolderModelMapper folderModelMapper = FolderModelMapper.INSTANCE;
            Serializable serializableExtra = data != null ? data.getSerializableExtra(ItemPickerActivity.EXTRA_FOLDER) : null;
            Intrinsics.checkNotNull(serializableExtra, "null cannot be cast to non-null type com.box.androidsdk.content.models.BoxFolder");
            getCaptureViewModel().getStore().send(new CaptureReducer.Action.UpdateFolder(FolderModelMapper.toFolderModel$default(folderModelMapper, (BoxFolder) serializableExtra, false, 1, null)));
        }
    }

    private final void setupWindow() {
        ToolbarWithOverlayWarning toolbar = getBinding().captureToolbar.toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        CommonBoxUtil.addStatusBarPaddingTop(toolbar);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        EdgeToEdgeUtils.INSTANCE.enableDarkEdgeToEdge(this);
    }

    private final void setupUI() {
        ConstraintLayout captureTopBar = getBinding().captureTopBar;
        Intrinsics.checkNotNullExpressionValue(captureTopBar, "captureTopBar");
        CommonBoxUtil.addStatusBarPaddingTop(captureTopBar);
        getBinding().changeUploadFolderButton.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.capture.activities.CaptureActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CaptureActivity.setupUI$lambda$0(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupUI$lambda$0(CaptureActivity captureActivity, View view) {
        captureActivity.getCaptureViewModel().getStore().send(CaptureReducer.Action.ChangeFolder.INSTANCE);
    }

    private final void showProgress() {
        getBinding().changeUploadFolderButton.setVisibility(4);
        getBinding().folderProgressBar.setVisibility(0);
    }

    private final void hideProgress() {
        getBinding().folderProgressBar.setVisibility(4);
        getBinding().changeUploadFolderButton.setVisibility(0);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0032  */
    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    /* JADX WARN: Code duplicated, block: B:9:0x002f  */
    private final void updateFolderLabel(FolderModel folder, boolean enabled) {
        int i;
        String name = folder.getName();
        if (folder.getPermissions() != null) {
            PermissionsModel permissions = folder.getPermissions();
            Intrinsics.checkNotNull(permissions);
            if (!permissions.getCanUpload()) {
                showFolderErrorState();
            } else {
                int defaultIconResource = ThumbnailManager.INSTANCE.getDefaultIconResource(folder);
                TextView textView = getBinding().folderLabel;
                Resources resources = getResources();
                if (enabled) {
                    i = com.box.android.capture.R.color.box_blue_50;
                } else {
                    i = com.box.android.capture.R.color.box_gray_50;
                }
                textView.setTextColor(resources.getColor(i, null));
                getBinding().folderIcon.setImageResource(defaultIconResource);
            }
        } else {
            int defaultIconResource2 = ThumbnailManager.INSTANCE.getDefaultIconResource(folder);
            TextView textView2 = getBinding().folderLabel;
            Resources resources2 = getResources();
            if (enabled) {
                i = com.box.android.capture.R.color.box_blue_50;
            } else {
                i = com.box.android.capture.R.color.box_gray_50;
            }
            textView2.setTextColor(resources2.getColor(i, null));
            getBinding().folderIcon.setImageResource(defaultIconResource2);
        }
        getBinding().folderLabel.setText(name);
        getBinding().changeUploadFolderButton.setClickable(enabled);
    }

    private final void showFolderErrorState() {
        getBinding().folderLabel.setTextColor(CommonBoxUtil.getColorFromAttribute(this, com.box.android.capture.R.attr.notification));
        getBinding().folderIcon.setImageResource(com.box.android.capture.R.drawable.ic_error_24);
    }

    private final void setupOnClickEvents() {
        getBinding().captureFlashButton.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.capture.activities.CaptureActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CaptureActivity.setupOnClickEvents$lambda$0(this.f$0, view);
            }
        });
        getBinding().captureCloseButton.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.capture.activities.CaptureActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CaptureActivity.setupOnClickEvents$lambda$1(this.f$0, view);
            }
        });
        getBinding().captureSettingsButton.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.capture.activities.CaptureActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CaptureActivity.setupOnClickEvents$lambda$2(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupOnClickEvents$lambda$0(CaptureActivity captureActivity, View view) {
        captureActivity.getCaptureViewModel().getStore().send(CaptureReducer.Action.ToggleFlashMode.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupOnClickEvents$lambda$1(CaptureActivity captureActivity, View view) {
        captureActivity.getCaptureViewModel().getStore().send(CaptureReducer.Action.TryCloseCapture.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupOnClickEvents$lambda$2(CaptureActivity captureActivity, View view) {
        captureActivity.getCaptureViewModel().getStore().send(CaptureReducer.Action.OpenCaptureSettings.INSTANCE);
    }

    private final void setupModeSwitcher() {
        getBinding().modeSwitcherCompose.setContent(ComposableLambdaKt.composableLambdaInstance(595620043, true, new Function2() { // from class: com.box.android.capture.activities.CaptureActivity$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return CaptureActivity.setupModeSwitcher$lambda$0(this.f$0, (Composer) obj, ((Integer) obj2).intValue());
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupModeSwitcher$lambda$0(CaptureActivity captureActivity, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C440@17646L43:CaptureActivity.kt#6z65x8");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(595620043, i, -1, "com.box.android.capture.activities.CaptureActivity.setupModeSwitcher.<anonymous> (CaptureActivity.kt:440)");
            }
            CaptureModeSwitcherKt.CaptureModeSwitcher(captureActivity.getCaptureViewModel().getStore(), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    @Override // com.box.android.capture.IPermissionHandler
    public boolean areAllPermissionsGranted(CaptureMode captureMode) {
        Intrinsics.checkNotNullParameter(captureMode, "captureMode");
        List<String> requiredPermissions = captureMode.getRequiredPermissions();
        if ((requiredPermissions instanceof Collection) && requiredPermissions.isEmpty()) {
            return true;
        }
        Iterator<T> it = requiredPermissions.iterator();
        while (it.hasNext()) {
            if (ContextCompat.checkSelfPermission(getBaseContext(), (String) it.next()) != 0) {
                return false;
            }
        }
        return true;
    }

    @Override // com.box.android.capture.IPermissionHandler
    public void onPermissionsGranted(CaptureMode captureMode) {
        Intrinsics.checkNotNullParameter(captureMode, "captureMode");
        int i = WhenMappings.$EnumSwitchMapping$1[captureMode.ordinal()];
        if (i == 1) {
            getCaptureViewModel().getStore().send(new CaptureReducer.Action.Camera(ImageCaptureReducer.Action.PermissionGranted.INSTANCE));
            return;
        }
        if (i == 2) {
            getCaptureViewModel().getStore().send(new CaptureReducer.Action.DocumentScanning(DocumentScanningReducer.Action.GrantPermission.INSTANCE));
        } else if (i == 3) {
            getCaptureViewModel().getStore().send(new CaptureReducer.Action.AudioRecording(AudioCaptureReducer.Action.PermissionsGranted.INSTANCE));
        } else {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            getCaptureViewModel().getStore().send(new CaptureReducer.Action.Video(VideoCaptureReducer.Action.PermissionsGranted.INSTANCE));
        }
    }

    @Override // com.box.android.capture.IPermissionHandler
    public String[] requiredPermissions(CaptureMode captureMode) {
        Intrinsics.checkNotNullParameter(captureMode, "captureMode");
        int i = WhenMappings.$EnumSwitchMapping$1[captureMode.ordinal()];
        if (i == 1) {
            return CAMERA_CAPTURE_REQUIRED_PERMISSIONS;
        }
        if (i == 2) {
            return CAMERA_CAPTURE_REQUIRED_PERMISSIONS;
        }
        if (i == 3) {
            return AUDIO_CAPTURE_REQUIRED_PERMISSIONS;
        }
        if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        return VIDEO_CAPTURE_REQUIRED_PERMISSIONS;
    }

    @Override // com.box.android.capture.ICaptureActivity
    public void openErrorFragment(CaptureMode captureMode) {
        Intrinsics.checkNotNullParameter(captureMode, "captureMode");
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
        fragmentTransactionBeginTransaction.replace(com.box.android.capture.R.id.capture_fragment_container, CaptureErrorFragment.INSTANCE.newInstance(captureMode));
        fragmentTransactionBeginTransaction.commit();
    }

    @Override // com.box.android.capture.ICaptureActivity
    public void showCaptureHistory(FragmentTransaction fragmentTransaction) {
        Intrinsics.checkNotNullParameter(fragmentTransaction, "fragmentTransaction");
        getCaptureViewModel().getStore().send(CaptureReducer.Action.OpenCaptureHistory.INSTANCE);
        fragmentTransaction.replace(com.box.android.capture.R.id.capture_fragment_container, new CaptureHistoryFragment());
    }

    @Override // com.box.android.capture.ICaptureActivity
    public void closeCaptureHistory() {
        getCaptureViewModel().getStore().send(CaptureReducer.Action.CloseCaptureHistory.INSTANCE);
        getSupportFragmentManager().popBackStack();
    }

    @Override // com.box.android.capture.ICaptureActivity
    public void onItemClick(FileModel item) {
        Intrinsics.checkNotNullParameter(item, "item");
        IItemActionHandler.onItemClick$default(getItemActionHandler(), item, false, PreviewSource.CaptureHistory.INSTANCE, 2, null);
    }

    @Override // com.box.android.capture.ICaptureActivity
    public void showBottomSheet(FileModel item, BottomSheetAttributes.BottomSheetMenuType type, BottomSheetAttributes.LaunchContext launchContext) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(launchContext, "launchContext");
        IItemActionHandler.showBottomSheet$default(getItemActionHandler(), item, type, launchContext, (DialogInterface.OnShowListener) null, (List) null, 24, (Object) null);
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMDestroy() {
        super.onMAMDestroy();
        getCameraManager().unregisterAvailabilityCallback(this.cameraAvailabilityCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void replaceFragment(Fragment fragment, boolean shouldAddToBackStack) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
        if (shouldAddToBackStack) {
            fragmentTransactionBeginTransaction.addToBackStack(null);
        }
        fragmentTransactionBeginTransaction.setReorderingAllowed(true);
        fragmentTransactionBeginTransaction.replace(com.box.android.capture.R.id.capture_fragment_container, fragment);
        fragmentTransactionBeginTransaction.commit();
    }

    static /* synthetic */ void replaceFragment$default(CaptureActivity captureActivity, Fragment fragment, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        captureActivity.replaceFragment(fragment, z);
    }
}
