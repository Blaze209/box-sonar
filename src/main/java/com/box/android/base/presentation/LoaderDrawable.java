package com.box.android.base.presentation;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.models.BoxDownload;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.requests.BoxRequest;
import com.box.androidsdk.content.requests.BoxRequestDownload;
import com.box.androidsdk.content.requests.BoxRequestsFile;
import com.box.androidsdk.content.requests.BoxResponse;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes9.dex */
public class LoaderDrawable extends BitmapDrawable {
    WeakReference<ThumbnailTask> mTaskRef;

    public interface ImageReadyListener {
        void onImageException(BoxResponse boxResponse, ImageView imageView);

        void onImageReady(File file, BoxRequest boxRequest, Bitmap bitmap, ImageView imageView);
    }

    private LoaderDrawable(ThumbnailTask thumbnailTask, Resources resources, Bitmap bitmap) {
        super(resources, bitmap);
        this.mTaskRef = new WeakReference<>(thumbnailTask);
    }

    public ThumbnailTask getTask() {
        return this.mTaskRef.get();
    }

    public static LoaderDrawable create(BoxRequestsFile.DownloadThumbnail downloadThumbnail, BoxItem boxItem, ImageView imageView, Bitmap bitmap, ImageReadyListener imageReadyListener) {
        return new LoaderDrawable(ThumbnailTask.create(downloadThumbnail, boxItem, imageView, imageReadyListener), imageView.getResources(), bitmap);
    }

    public static LoaderDrawable create(BoxRequestsFile.DownloadRepresentation downloadRepresentation, BoxItem boxItem, ImageView imageView, Bitmap bitmap, ImageReadyListener imageReadyListener) {
        return new LoaderDrawable(ThumbnailTask.create(downloadRepresentation, boxItem, imageView, imageReadyListener), imageView.getResources(), bitmap);
    }

    public boolean matchesRequest(BoxRequest boxRequest) {
        if (getTask() != null) {
            return getTask().getKey().equals(ThumbnailTask.createRequestKey(boxRequest));
        }
        return false;
    }

    static class ThumbnailTask extends BoxFutureTask<BoxDownload> {
        private final BoxItem mBoxItem;
        private final String mKey;

        protected ThumbnailTask(Callable<BoxResponse<BoxDownload>> callable, BoxRequest boxRequest, BoxItem boxItem) {
            super(callable, boxRequest);
            this.mKey = createRequestKey(boxRequest);
            this.mBoxItem = boxItem;
        }

        protected static String createRequestKey(BoxRequest boxRequest) {
            if (boxRequest instanceof BoxRequestsFile.DownloadThumbnail) {
                return ((BoxRequestsFile.DownloadThumbnail) boxRequest).getId();
            }
            if (boxRequest instanceof BoxRequestsFile.DownloadRepresentation) {
                return ((BoxRequestsFile.DownloadRepresentation) boxRequest).getId();
            }
            return Integer.toString(boxRequest.hashCode());
        }

        public String getKey() {
            return this.mKey;
        }

        public BoxItem getBoxItem() {
            return this.mBoxItem;
        }

        public static ThumbnailTask create(final BoxRequestDownload boxRequestDownload, BoxItem boxItem, ImageView imageView, final ImageReadyListener imageReadyListener) {
            final WeakReference weakReference = new WeakReference(imageView);
            return new ThumbnailTask(new Callable<BoxResponse<BoxDownload>>() { // from class: com.box.android.base.presentation.LoaderDrawable.ThumbnailTask.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public BoxResponse<BoxDownload> call() throws Exception {
                    BoxDownload boxDownload;
                    Exception e = null;
                    try {
                        File target = boxRequestDownload.getTarget();
                        boxDownload = (!target.exists() || target.length() <= 0) ? (BoxDownload) boxRequestDownload.send() : null;
                        try {
                            ImageView imageView2 = (ImageView) weakReference.get();
                            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(target.getAbsolutePath());
                            String strCreateRequestKey = ThumbnailTask.createRequestKey(boxRequestDownload);
                            if (bitmapDecodeFile != null && imageView2 != null && (imageView2.getDrawable() instanceof LoaderDrawable) && ((LoaderDrawable) imageView2.getDrawable()).getTask().getKey().equals(strCreateRequestKey)) {
                                imageReadyListener.onImageReady(target, boxRequestDownload, bitmapDecodeFile, (ImageView) weakReference.get());
                            }
                        } catch (Exception e2) {
                            e = e2;
                        }
                    } catch (Exception e3) {
                        boxDownload = null;
                        e = e3;
                    }
                    BoxResponse<BoxDownload> boxResponse = new BoxResponse<>(boxDownload, e, boxRequestDownload);
                    if (e != null) {
                        imageReadyListener.onImageException(boxResponse, (ImageView) weakReference.get());
                    }
                    return boxResponse;
                }
            }, boxRequestDownload, boxItem);
        }
    }
}
