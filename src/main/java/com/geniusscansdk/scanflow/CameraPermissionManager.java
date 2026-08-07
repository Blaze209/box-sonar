package com.geniusscansdk.scanflow;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.geniusscansdk.R;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.pspdfkit.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CameraPermissionManager.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH\u0002J\b\u0010\u0012\u001a\u00020\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/geniusscansdk/scanflow/CameraPermissionManager;", "", BuildConfig.FLAVOR, "Landroidx/fragment/app/Fragment;", "<init>", "(Landroidx/fragment/app/Fragment;)V", "context", "Landroid/content/Context;", "permissionRequestLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "currentlyRequestingPermission", "", "checkPermissionGrantedAndRequestIfNeeded", "", "isPermissionGranted", "()Z", "onPermissionRequestResult", "displayPermissionDeniedDialog", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraPermissionManager {
    private final Context context;
    private boolean currentlyRequestingPermission;
    private final Fragment fragment;
    private final ActivityResultLauncher<String> permissionRequestLauncher;

    public CameraPermissionManager(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.fragment = fragment;
        Context contextRequireContext = fragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        this.context = contextRequireContext;
        this.permissionRequestLauncher = fragment.registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback() { // from class: com.geniusscansdk.scanflow.CameraPermissionManager$$ExternalSyntheticLambda2
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                CameraPermissionManager._init_$lambda$0(this.f$0, ((Boolean) obj).booleanValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(CameraPermissionManager cameraPermissionManager, boolean z) {
        cameraPermissionManager.currentlyRequestingPermission = false;
        cameraPermissionManager.onPermissionRequestResult(z);
    }

    public final void checkPermissionGrantedAndRequestIfNeeded() {
        if (isPermissionGranted() || this.currentlyRequestingPermission) {
            return;
        }
        this.permissionRequestLauncher.launch("android.permission.CAMERA");
        this.currentlyRequestingPermission = true;
    }

    public final boolean isPermissionGranted() {
        return ContextCompat.checkSelfPermission(this.context, "android.permission.CAMERA") == 0;
    }

    private final void onPermissionRequestResult(boolean isPermissionGranted) {
        if (isPermissionGranted) {
            return;
        }
        displayPermissionDeniedDialog();
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0029  */
    private final void displayPermissionDeniedDialog() {
        String str;
        ApplicationInfo applicationInfo = this.context.getApplicationInfo();
        Integer numValueOf = Integer.valueOf(applicationInfo.labelRes);
        if (numValueOf.intValue() == 0) {
            numValueOf = null;
        }
        if (numValueOf != null) {
            String string = this.context.getString(numValueOf.intValue());
            if (string != null) {
                str = string;
            } else {
                str = applicationInfo.nonLocalizedLabel;
            }
        } else {
            str = applicationInfo.nonLocalizedLabel;
        }
        new MaterialAlertDialogBuilder(this.context).setTitle((CharSequence) this.context.getString(R.string.gssdk_camera_permission_denied_title, str)).setMessage((CharSequence) this.context.getString(R.string.gssdk_camera_permission_denied_message, str)).setPositiveButton(R.string.gssdk_settings, new DialogInterface.OnClickListener() { // from class: com.geniusscansdk.scanflow.CameraPermissionManager$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                CameraPermissionManager.displayPermissionDeniedDialog$lambda$3(this.f$0, dialogInterface, i);
            }
        }).setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.geniusscansdk.scanflow.CameraPermissionManager$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                CameraPermissionManager.displayPermissionDeniedDialog$lambda$4(this.f$0, dialogInterface, i);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void displayPermissionDeniedDialog$lambda$3(CameraPermissionManager cameraPermissionManager, DialogInterface dialogInterface, int i) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", cameraPermissionManager.context.getPackageName(), null));
        cameraPermissionManager.fragment.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void displayPermissionDeniedDialog$lambda$4(CameraPermissionManager cameraPermissionManager, DialogInterface dialogInterface, int i) {
        cameraPermissionManager.fragment.requireActivity().finish();
    }
}
