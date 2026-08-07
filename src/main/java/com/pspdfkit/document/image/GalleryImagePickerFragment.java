package com.pspdfkit.document.image;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.pspdfkit.internal.yl;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class GalleryImagePickerFragment extends BaseImagePickerFragment {
    private static final int REQUEST_CODE = 100;

    @Override // com.pspdfkit.document.image.BaseImagePickerFragment
    public Intent getImagePickerIntent() {
        Context contextRequireContext = requireContext();
        contextRequireContext.getClass();
        return yl.b.a(contextRequireContext, null, new ArrayList());
    }

    @Override // com.pspdfkit.document.image.BaseImagePickerFragment
    public int getRequestCode() {
        return 100;
    }

    @Override // com.pspdfkit.document.image.BaseImagePickerFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = this.pendingIntentForResult;
        if (intent != null) {
            queueStartActivityForResult(intent);
            this.pendingIntentForResult = null;
        }
    }

    @Override // com.pspdfkit.document.image.BaseImagePickerFragment
    public void onImagePickerResult(int i, Intent intent) {
        if (this.onImagePickedListener != null) {
            if (i != -1 || intent.getData() == null) {
                ImagePicker.OnImagePickedListener onImagePickedListener = this.onImagePickedListener;
                if (i == 0) {
                    onImagePickedListener.onImagePickerCancelled();
                } else {
                    onImagePickedListener.onImagePickerUnknownError();
                }
            } else {
                this.onImagePickedListener.onImagePicked(intent.getData());
            }
            finish();
        }
    }

    @Override // com.pspdfkit.document.image.BaseImagePickerFragment
    public void queueStartActivityForResult(Intent intent) {
        if (isAdded()) {
            startActivityForResult(intent, getRequestCode());
        } else {
            this.pendingIntentForResult = intent;
        }
    }
}
