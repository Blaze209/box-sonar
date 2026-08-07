package com.pspdfkit.document.image;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import com.microsoft.intune.mam.client.content.pm.MAMPackageManagement;
import com.pspdfkit.R;
import com.pspdfkit.document.sharing.DocumentSharingProvider;
import com.pspdfkit.internal.am;
import com.pspdfkit.internal.ar;
import com.pspdfkit.internal.j0;
import com.pspdfkit.internal.n5;
import com.pspdfkit.internal.no;
import com.pspdfkit.internal.s8;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
public class CameraImagePickerFragment extends BaseImagePickerFragment {
    private static final int ASK_FOR_CAMERA_PERMISSION_REQUEST_CODE = 102;
    private static final String KEY_TEMP_IMAGE_URI = "TEMP_IMAGE_URI";
    private static final int REQUEST_CODE = 101;
    private final am intentCreator;
    private Uri tempImageUri;
    private boolean waitingForPermissions;

    public CameraImagePickerFragment() {
        j0 j0Var;
        synchronized (ar.class) {
            if (ar.a == null) {
                Context context = n5.a;
                if (context == null) {
                    throw new IllegalStateException("The application context should not be null. Please call fun setApplicationContext(context: Context) first");
                }
                ar.a = new j0(context);
            }
            j0Var = ar.a;
        }
        this.intentCreator = j0Var;
    }

    private boolean checkRequiredPermissions() {
        if (!hasCameraPermissionInManifest() || ContextCompat.checkSelfPermission(getContext(), "android.permission.CAMERA") != -1 || this.waitingForPermissions) {
            return true;
        }
        this.waitingForPermissions = true;
        requestPermissions(new String[]{"android.permission.CAMERA"}, 102);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: createTemporaryFile, reason: merged with bridge method [inline-methods] */
    public Uri lambda$getImagePickerIntent$0(Context context) {
        return DocumentSharingProvider.createTemporaryFile(context, "JPEG_" + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(new Date()) + "_", ".jpg");
    }

    private boolean hasCameraPermissionInManifest() {
        try {
            String[] strArr = MAMPackageManagement.getPackageInfo(getContext().getPackageManager(), getContext().getPackageName(), 4096).requestedPermissions;
            if (strArr == null) {
                return false;
            }
            for (String str : strArr) {
                if (str.equals("android.permission.CAMERA")) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    @Override // com.pspdfkit.document.image.BaseImagePickerFragment
    public Intent getImagePickerIntent() {
        final Context context = getContext();
        if (context == null) {
            return null;
        }
        s8 s8VarA = ((j0) this.intentCreator).a(new Function0() { // from class: com.pspdfkit.document.image.CameraImagePickerFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$getImagePickerIntent$0(context);
            }
        });
        if (s8VarA == s8.b.a) {
            Toast.makeText(context, no.a(context, R.string.pspdf__camera_not_available, null), 0).show();
            return null;
        }
        if (!(s8VarA instanceof s8.c)) {
            return null;
        }
        s8.c cVar = (s8.c) s8VarA;
        this.tempImageUri = cVar.b;
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.setFlags(cVar.a);
        intent.putExtra("output", cVar.b);
        return intent;
    }

    @Override // com.pspdfkit.document.image.BaseImagePickerFragment
    public int getRequestCode() {
        return 101;
    }

    @Override // com.pspdfkit.document.image.BaseImagePickerFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        DocumentSharingProvider.checkProviderConfiguration(getContext(), "capturing images from camera");
        if (bundle != null) {
            this.tempImageUri = (Uri) bundle.getParcelable(KEY_TEMP_IMAGE_URI);
        }
        if (this.pendingIntentForResult == null || !checkRequiredPermissions()) {
            return;
        }
        queueStartActivityForResult(this.pendingIntentForResult);
        this.pendingIntentForResult = null;
        this.waitingForPermissions = false;
    }

    @Override // com.pspdfkit.document.image.BaseImagePickerFragment
    public void onImagePickerResult(int i, Intent intent) {
        Uri uri;
        ImagePicker.OnImagePickedListener onImagePickedListener = this.onImagePickedListener;
        if (onImagePickedListener != null) {
            if (i == -1 && (uri = this.tempImageUri) != null) {
                onImagePickedListener.onImagePicked(uri);
                this.tempImageUri = null;
            } else if (i == 0) {
                onImagePickedListener.onImagePickerCancelled();
                ImagePicker.deleteTemporaryFile(getContext(), this.tempImageUri);
            } else {
                onImagePickedListener.onImagePickerUnknownError();
                ImagePicker.deleteTemporaryFile(getContext(), this.tempImageUri);
            }
            finish();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Intent intent;
        this.waitingForPermissions = false;
        if (i == 102) {
            if (iArr.length > 0 && iArr[0] == 0 && (intent = this.pendingIntentForResult) != null) {
                startActivityForResult(intent, 101);
                this.pendingIntentForResult = null;
                return;
            }
            ImagePicker.OnImagePickedListener onImagePickedListener = this.onImagePickedListener;
            if (onImagePickedListener != null) {
                onImagePickedListener.onCameraPermissionDeclined(!shouldShowRequestPermissionRationale("android.permission.CAMERA"));
            }
            this.pendingIntentForResult = null;
            finish();
        }
    }

    @Override // com.pspdfkit.document.image.BaseImagePickerFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable(KEY_TEMP_IMAGE_URI, this.tempImageUri);
    }

    @Override // com.pspdfkit.document.image.BaseImagePickerFragment
    public void queueStartActivityForResult(Intent intent) {
        DocumentSharingProvider.checkProviderConfiguration(getContext(), "capturing images from camera");
        if (isAdded() && checkRequiredPermissions()) {
            startActivityForResult(intent, getRequestCode());
        } else {
            this.pendingIntentForResult = intent;
        }
    }
}
