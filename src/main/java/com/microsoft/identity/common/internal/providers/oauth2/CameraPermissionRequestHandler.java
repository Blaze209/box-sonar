package com.microsoft.identity.common.internal.providers.oauth2;

import android.content.Context;
import android.content.DialogInterface;
import android.webkit.PermissionRequest;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import com.microsoft.identity.common.R;
import com.microsoft.identity.common.internal.broker.SdmQrPinManager;
import com.microsoft.identity.common.java.ui.PreferredAuthMethod;
import com.microsoft.identity.common.logging.Logger;
import com.microsoft.intune.mam.client.app.MAMAlertDialogBuilder;
import com.pspdfkit.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: CameraPermissionRequestHandler.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u0010H\u0002J\u0016\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\tH\u0002J\b\u0010\u0016\u001a\u00020\u000bH\u0002J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\tH\u0002J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\tH\u0002J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u001b\u001a\u00020\u0010H\u0002J\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/microsoft/identity/common/internal/providers/oauth2/CameraPermissionRequestHandler;", "", BuildConfig.FLAVOR, "Lcom/microsoft/identity/common/internal/providers/oauth2/WebViewAuthorizationFragment;", "(Lcom/microsoft/identity/common/internal/providers/oauth2/WebViewAuthorizationFragment;)V", "activityResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "currentPermissionRequest", "Landroid/webkit/PermissionRequest;", "isGranted", "", "appHasCameraPermission", "context", "Landroid/content/Context;", "defaultHandler", "", "deny", "grant", "handle", "request", "isForCamera", "isQrPinRequest", "isRepeatedRequest", "permissionRequest", "isValid", "qrPinHandler", "requestCameraPermission", "showQrPinCameraRationale", "Companion", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CameraPermissionRequestHandler {

    @Deprecated
    private static final String MICROSOFT_CLOUD_URL = "https://login.microsoftonline.com/";

    @Deprecated
    private static final String TAG = "CameraPermissionRequestHandler";
    private final ActivityResultLauncher<String> activityResultLauncher;
    private PermissionRequest currentPermissionRequest;
    private boolean isGranted;
    private static final Companion Companion = new Companion(null);

    @Deprecated
    private static final String[] cameraResource = {"android.webkit.resource.VIDEO_CAPTURE"};

    public CameraPermissionRequestHandler(WebViewAuthorizationFragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        ActivityResultLauncher<String> activityResultLauncherRegisterForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback() { // from class: com.microsoft.identity.common.internal.providers.oauth2.CameraPermissionRequestHandler$$ExternalSyntheticLambda0
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                CameraPermissionRequestHandler.activityResultLauncher$lambda$0(this.f$0, ((Boolean) obj).booleanValue());
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…)\n            }\n        }");
        this.activityResultLauncher = activityResultLauncherRegisterForActivityResult;
    }

    /* JADX INFO: compiled from: CameraPermissionRequestHandler.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/microsoft/identity/common/internal/providers/oauth2/CameraPermissionRequestHandler$Companion;", "", "()V", "MICROSOFT_CLOUD_URL", "", "TAG", "cameraResource", "", "[Ljava/lang/String;", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void activityResultLauncher$lambda$0(CameraPermissionRequestHandler this$0, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Logger.info(TAG, "Camera permission granted: " + z);
        if (z) {
            this$0.grant();
        } else {
            this$0.deny();
        }
    }

    public final void handle(PermissionRequest request, Context context) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(context, "context");
        if (isValid(request)) {
            this.currentPermissionRequest = request;
            this.isGranted = false;
            if (isQrPinRequest()) {
                qrPinHandler(context);
                return;
            } else {
                defaultHandler(context);
                return;
            }
        }
        Logger.warn("CameraPermissionRequestHandler:handle", "Permission request is not valid, returning.");
    }

    private final void grant() {
        PermissionRequest permissionRequest = this.currentPermissionRequest;
        if (permissionRequest != null) {
            permissionRequest.grant(cameraResource);
            this.isGranted = true;
        }
    }

    private final void deny() {
        PermissionRequest permissionRequest = this.currentPermissionRequest;
        if (permissionRequest != null) {
            permissionRequest.deny();
            this.isGranted = false;
        }
    }

    private final boolean isValid(PermissionRequest request) {
        if (!isForCamera(request)) {
            Logger.warn("CameraPermissionRequestHandler:isValid", "Permission request is not for camera.");
            request.deny();
            return false;
        }
        if (isRepeatedRequest(request)) {
            Logger.info("CameraPermissionRequestHandler:isValid", "Repeated request, permission is granted: " + this.isGranted);
            if (this.isGranted) {
                request.grant(cameraResource);
            } else {
                request.deny();
            }
            return false;
        }
        Logger.info("CameraPermissionRequestHandler:isValid", "Valid new request.");
        return true;
    }

    private final boolean isQrPinRequest() {
        PermissionRequest permissionRequest = this.currentPermissionRequest;
        if ((permissionRequest != null ? permissionRequest.getOrigin() : null) != null) {
            PermissionRequest permissionRequest2 = this.currentPermissionRequest;
            if (StringsKt.equals(MICROSOFT_CLOUD_URL, String.valueOf(permissionRequest2 != null ? permissionRequest2.getOrigin() : null), true) && StringsKt.equals$default(PreferredAuthMethod.QR.value, SdmQrPinManager.INSTANCE.getPreferredAuthConfig(), false, 2, null)) {
                return true;
            }
        }
        return false;
    }

    private final void defaultHandler(Context context) {
        if (appHasCameraPermission(context)) {
            Logger.info("CameraPermissionRequestHandler:defaultHandler", "App level camera permission already granted, silent grant.");
            grant();
        } else {
            requestCameraPermission();
        }
    }

    private final void qrPinHandler(Context context) {
        if (appHasCameraPermission(context)) {
            Logger.info("CameraPermissionRequestHandler:handleQrPin", "App level camera permission already granted.");
            if (SdmQrPinManager.INSTANCE.isCameraConsentSuppressed()) {
                Logger.info("CameraPermissionRequestHandler:handleQrPin", "Camera consent suppress is enabled.");
                grant();
                return;
            } else {
                Logger.info("CameraPermissionRequestHandler:handleQrPin", "Camera consent suppress is not enabled.");
                showQrPinCameraRationale(context);
                return;
            }
        }
        requestCameraPermission();
    }

    private final boolean appHasCameraPermission(Context context) {
        return ContextCompat.checkSelfPermission(context, "android.permission.CAMERA") == 0;
    }

    private final void showQrPinCameraRationale(Context context) {
        MAMAlertDialogBuilder mAMAlertDialogBuilder = new MAMAlertDialogBuilder(context);
        final String str = "CameraPermissionRequestHandler:showQrPinCameraRationale";
        mAMAlertDialogBuilder.setMessage(R.string.qr_code_rationale_message).setTitle(R.string.qr_code_rationale_header).setCancelable(false).setPositiveButton(R.string.qr_code_rationale_allow, new DialogInterface.OnClickListener() { // from class: com.microsoft.identity.common.internal.providers.oauth2.CameraPermissionRequestHandler$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                CameraPermissionRequestHandler.showQrPinCameraRationale$lambda$3(str, this, dialogInterface, i);
            }
        }).setNegativeButton(R.string.qr_code_rationale_block, new DialogInterface.OnClickListener() { // from class: com.microsoft.identity.common.internal.providers.oauth2.CameraPermissionRequestHandler$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                CameraPermissionRequestHandler.showQrPinCameraRationale$lambda$4(str, this, dialogInterface, i);
            }
        });
        mAMAlertDialogBuilder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showQrPinCameraRationale$lambda$3(String methodTag, CameraPermissionRequestHandler this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(methodTag, "$methodTag");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Logger.info(methodTag, "User accepted camera permission rationale.");
        this$0.requestCameraPermission();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showQrPinCameraRationale$lambda$4(String methodTag, CameraPermissionRequestHandler this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(methodTag, "$methodTag");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Logger.info(methodTag, "User denied camera permission rationale.");
        this$0.deny();
    }

    private final boolean isRepeatedRequest(PermissionRequest permissionRequest) {
        PermissionRequest permissionRequest2 = this.currentPermissionRequest;
        return permissionRequest2 != null && permissionRequest2.getResources().length == permissionRequest.getResources().length && Intrinsics.areEqual(permissionRequest2.getOrigin(), permissionRequest.getOrigin());
    }

    private final boolean isForCamera(PermissionRequest request) {
        return request.getResources().length == 1 && Intrinsics.areEqual("android.webkit.resource.VIDEO_CAPTURE", request.getResources()[0]);
    }

    private final void requestCameraPermission() {
        this.activityResultLauncher.launch("android.permission.CAMERA");
    }
}
