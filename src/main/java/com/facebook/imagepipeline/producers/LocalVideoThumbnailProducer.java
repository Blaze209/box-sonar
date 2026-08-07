package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.media3.common.MimeTypes;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.google.android.gms.common.internal.ImagesContract;
import com.microsoft.intune.mam.client.content.MAMContentResolverManagement;
import com.microsoft.intune.mam.client.media.MAMMediaMetadataRetriever;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes13.dex */
public class LocalVideoThumbnailProducer implements Producer<CloseableReference<CloseableImage>> {
    static final String CREATED_THUMBNAIL = "createdThumbnail";
    public static final String PRODUCER_NAME = "VideoThumbnailProducer";
    private final ContentResolver mContentResolver;
    private final Executor mExecutor;

    public LocalVideoThumbnailProducer(Executor executor, ContentResolver contentResolver) {
        this.mExecutor = executor;
        this.mContentResolver = contentResolver;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<CloseableReference<CloseableImage>> consumer, final ProducerContext producerContext) {
        final ProducerListener2 producerListener = producerContext.getProducerListener();
        final ImageRequest imageRequest = producerContext.getImageRequest();
        producerContext.putOriginExtra(ImagesContract.LOCAL, MimeTypes.BASE_TYPE_VIDEO);
        final StatefulProducerRunnable<CloseableReference<CloseableImage>> statefulProducerRunnable = new StatefulProducerRunnable<CloseableReference<CloseableImage>>(consumer, producerListener, producerContext, PRODUCER_NAME) { // from class: com.facebook.imagepipeline.producers.LocalVideoThumbnailProducer.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
            public void onSuccess(@Nullable CloseableReference<CloseableImage> closeableReference) {
                super.onSuccess(closeableReference);
                producerListener.onUltimateProducerReached(producerContext, LocalVideoThumbnailProducer.PRODUCER_NAME, closeableReference != null);
                producerContext.putOriginExtra(ImagesContract.LOCAL, MimeTypes.BASE_TYPE_VIDEO);
            }

            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
            protected void onFailure(Exception exc) {
                super.onFailure(exc);
                producerListener.onUltimateProducerReached(producerContext, LocalVideoThumbnailProducer.PRODUCER_NAME, false);
                producerContext.putOriginExtra(ImagesContract.LOCAL, MimeTypes.BASE_TYPE_VIDEO);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.common.executors.StatefulRunnable
            @Nullable
            public CloseableReference<CloseableImage> getResult() throws Exception {
                String localFilePath;
                try {
                    localFilePath = LocalVideoThumbnailProducer.this.getLocalFilePath(imageRequest);
                } catch (IllegalArgumentException unused) {
                    localFilePath = null;
                }
                Bitmap bitmapCreateVideoThumbnail = localFilePath != null ? ThumbnailUtils.createVideoThumbnail(localFilePath, LocalVideoThumbnailProducer.calculateKind(imageRequest)) : null;
                if (bitmapCreateVideoThumbnail == null) {
                    bitmapCreateVideoThumbnail = LocalVideoThumbnailProducer.createThumbnailFromContentProvider(LocalVideoThumbnailProducer.this.mContentResolver, imageRequest.getSourceUri());
                }
                if (bitmapCreateVideoThumbnail == null) {
                    return null;
                }
                CloseableStaticBitmap closeableStaticBitmapOf = CloseableStaticBitmap.of(bitmapCreateVideoThumbnail, SimpleBitmapReleaser.getInstance(), ImmutableQualityInfo.FULL_QUALITY, 0);
                producerContext.putExtra("image_format", "thumbnail");
                closeableStaticBitmapOf.putExtras(producerContext.getExtras());
                return CloseableReference.of(closeableStaticBitmapOf);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable
            public Map<String, String> getExtraMapOnSuccess(@Nullable CloseableReference<CloseableImage> closeableReference) {
                return ImmutableMap.of(LocalVideoThumbnailProducer.CREATED_THUMBNAIL, String.valueOf(closeableReference != null));
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
            public void disposeResult(@Nullable CloseableReference<CloseableImage> closeableReference) {
                CloseableReference.closeSafely(closeableReference);
            }
        };
        producerContext.addCallbacks(new BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.LocalVideoThumbnailProducer.2
            @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
            public void onCancellationRequested() {
                statefulProducerRunnable.cancel();
            }
        });
        this.mExecutor.execute(statefulProducerRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int calculateKind(ImageRequest imageRequest) {
        return (imageRequest.getPreferredWidth() > 96 || imageRequest.getPreferredHeight() > 96) ? 1 : 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public String getLocalFilePath(ImageRequest imageRequest) {
        return UriUtil.getRealPathFromUri(this.mContentResolver, imageRequest.getSourceUri());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static Bitmap createThumbnailFromContentProvider(ContentResolver contentResolver, Uri uri) throws Throwable {
        MAMMediaMetadataRetriever mAMMediaMetadataRetriever;
        MAMMediaMetadataRetriever mAMMediaMetadataRetriever2 = null;
        try {
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = MAMContentResolverManagement.openFileDescriptor(contentResolver, uri, "r");
            Preconditions.checkNotNull(parcelFileDescriptorOpenFileDescriptor);
            mAMMediaMetadataRetriever = new MAMMediaMetadataRetriever();
            try {
                mAMMediaMetadataRetriever.setDataSource(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                Bitmap frameAtTime = mAMMediaMetadataRetriever.getFrameAtTime(-1L);
                try {
                    mAMMediaMetadataRetriever.release();
                } catch (IOException unused) {
                }
                return frameAtTime;
            } catch (FileNotFoundException unused2) {
                if (mAMMediaMetadataRetriever != null) {
                    try {
                        mAMMediaMetadataRetriever.release();
                    } catch (IOException unused3) {
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                mAMMediaMetadataRetriever2 = mAMMediaMetadataRetriever;
                if (mAMMediaMetadataRetriever2 != null) {
                    try {
                        mAMMediaMetadataRetriever2.release();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException unused5) {
            mAMMediaMetadataRetriever = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
