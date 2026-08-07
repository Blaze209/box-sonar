package com.pspdfkit.document.image;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.pspdfkit.internal.fi;
import com.pspdfkit.utils.PdfLog;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseImagePickerFragment extends Fragment {
    private static final String KEY_PENDING_INTENT_FOR_RESULT = "PENDING_INTENT_FOR_RESULT";
    private static final String LOG_TAG = "Nutri.BaseImgPickerFrag";
    protected ActivityResult lastActivityResult;
    protected ImagePicker.OnImagePickedListener onImagePickedListener;
    protected Intent pendingIntentForResult;

    public static class ActivityResult {
        final Intent data;
        final int resultCode;

        public ActivityResult(int i, Intent intent) {
            this.resultCode = i;
            this.data = intent;
        }
    }

    public void finish() {
        this.lastActivityResult = null;
        fi.a(getFragmentManager(), (Fragment) this, false);
    }

    public abstract Intent getImagePickerIntent();

    public abstract int getRequestCode();

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == getRequestCode()) {
            this.lastActivityResult = new ActivityResult(i2, intent);
            onImagePickerResult(i2, intent);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.pendingIntentForResult = (Intent) bundle.getParcelable(KEY_PENDING_INTENT_FOR_RESULT);
        }
    }

    public abstract void onImagePickerResult(int i, Intent intent);

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable(KEY_PENDING_INTENT_FOR_RESULT, this.pendingIntentForResult);
    }

    public abstract void queueStartActivityForResult(Intent intent);

    public void setOnImagePickedListener(ImagePicker.OnImagePickedListener onImagePickedListener) {
        this.onImagePickedListener = onImagePickedListener;
        ActivityResult activityResult = this.lastActivityResult;
        if (activityResult != null) {
            onImagePickerResult(activityResult.resultCode, activityResult.data);
        }
    }

    public boolean showImagePicker() {
        try {
            Intent imagePickerIntent = getImagePickerIntent();
            if (imagePickerIntent == null) {
                return false;
            }
            queueStartActivityForResult(imagePickerIntent);
            return true;
        } catch (SecurityException e) {
            PdfLog.e(LOG_TAG, e, "Failed to capture image due to security exception!", new Object[0]);
            return false;
        }
    }
}
