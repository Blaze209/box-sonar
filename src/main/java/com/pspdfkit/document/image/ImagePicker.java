package com.pspdfkit.document.image;

import android.content.Context;
import android.net.Uri;
import androidx.fragment.app.FragmentManager;
import com.pspdfkit.document.sharing.DocumentSharingProvider;
import com.pspdfkit.internal.fi;
import com.pspdfkit.internal.uw;

/* JADX INFO: loaded from: classes3.dex */
public final class ImagePicker {
    private BaseImagePickerFragment activeImagePickerFragment;
    private final FragmentManager fragmentManager;
    private final String fragmentTag;
    private OnImagePickedListener onImagePickedListener;

    public interface OnImagePickedListener {
        void onCameraPermissionDeclined(boolean z);

        void onImagePicked(Uri uri);

        void onImagePickerCancelled();

        void onImagePickerUnknownError();
    }

    public ImagePicker(FragmentManager fragmentManager, String str) {
        uw.a(fragmentManager, "fragmentManager", null);
        uw.a(str, "fragmentTag", null);
        this.fragmentManager = fragmentManager;
        this.fragmentTag = str;
        this.activeImagePickerFragment = (BaseImagePickerFragment) fragmentManager.findFragmentByTag(str);
    }

    public static boolean deleteTemporaryFile(Context context, Uri uri) {
        return uri != null && DocumentSharingProvider.deleteFile(context, uri);
    }

    private void startImagePickerForFragment(BaseImagePickerFragment baseImagePickerFragment) {
        OnImagePickedListener onImagePickedListener = this.onImagePickedListener;
        if (onImagePickedListener != null) {
            baseImagePickerFragment.setOnImagePickedListener(onImagePickedListener);
        }
        if (fi.a(this.fragmentManager, baseImagePickerFragment, this.fragmentTag)) {
            this.fragmentManager.executePendingTransactions();
        }
        baseImagePickerFragment.showImagePicker();
    }

    public void setOnImagePickedListener(OnImagePickedListener onImagePickedListener) {
        this.onImagePickedListener = onImagePickedListener;
        BaseImagePickerFragment baseImagePickerFragment = this.activeImagePickerFragment;
        if (baseImagePickerFragment != null) {
            baseImagePickerFragment.setOnImagePickedListener(onImagePickedListener);
        }
    }

    public void startImageCapture() {
        BaseImagePickerFragment baseImagePickerFragment = this.activeImagePickerFragment;
        if (baseImagePickerFragment == null || !(baseImagePickerFragment instanceof CameraImagePickerFragment)) {
            if (baseImagePickerFragment != null) {
                baseImagePickerFragment.finish();
            }
            CameraImagePickerFragment cameraImagePickerFragment = (CameraImagePickerFragment) this.fragmentManager.findFragmentByTag(this.fragmentTag);
            this.activeImagePickerFragment = cameraImagePickerFragment;
            if (cameraImagePickerFragment == null) {
                this.activeImagePickerFragment = new CameraImagePickerFragment();
            }
        }
        startImagePickerForFragment(this.activeImagePickerFragment);
    }

    public void startImageGallery() {
        BaseImagePickerFragment baseImagePickerFragment = this.activeImagePickerFragment;
        if (baseImagePickerFragment == null || !(baseImagePickerFragment instanceof GalleryImagePickerFragment)) {
            if (baseImagePickerFragment != null) {
                baseImagePickerFragment.finish();
            }
            GalleryImagePickerFragment galleryImagePickerFragment = (GalleryImagePickerFragment) this.fragmentManager.findFragmentByTag(this.fragmentTag);
            this.activeImagePickerFragment = galleryImagePickerFragment;
            if (galleryImagePickerFragment == null) {
                this.activeImagePickerFragment = new GalleryImagePickerFragment();
            }
        }
        startImagePickerForFragment(this.activeImagePickerFragment);
    }

    public boolean wasStarted() {
        return this.fragmentManager.findFragmentByTag(this.fragmentTag) != null;
    }
}
