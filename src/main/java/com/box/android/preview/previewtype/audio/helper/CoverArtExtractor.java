package com.box.android.preview.previewtype.audio.helper;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.media3.common.Tracks;
import androidx.media3.extractor.metadata.id3.ApicFrame;
import com.google.common.collect.UnmodifiableIterator;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CoverArtExtractor.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002¨\u0006\u000b"}, d2 = {"Lcom/box/android/preview/previewtype/audio/helper/CoverArtExtractor;", "", "<init>", "()V", "getCoverArt", "Landroid/graphics/Bitmap;", "tracks", "Landroidx/media3/common/Tracks;", "extractImageMetadata", "metadata", "Landroidx/media3/common/Metadata;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CoverArtExtractor {
    public static final int $stable = 0;

    @Inject
    public CoverArtExtractor() {
    }

    public final Bitmap getCoverArt(Tracks tracks) {
        Intrinsics.checkNotNullParameter(tracks, "tracks");
        UnmodifiableIterator<Tracks.Group> it = tracks.getGroups().iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            Tracks.Group next = it.next();
            int i = next.length;
            for (int i2 = 0; i2 < i; i2++) {
                Bitmap bitmapExtractImageMetadata = extractImageMetadata(next.getTrackFormat(i2).metadata);
                if (bitmapExtractImageMetadata != null) {
                    return bitmapExtractImageMetadata;
                }
            }
        }
        return null;
    }

    private final Bitmap extractImageMetadata(androidx.media3.common.Metadata metadata) {
        if (metadata == null) {
            return null;
        }
        int length = metadata.length();
        for (int i = 0; i < length; i++) {
            androidx.media3.common.Metadata.Entry entry = metadata.get(i);
            Intrinsics.checkNotNullExpressionValue(entry, "get(...)");
            if (entry instanceof ApicFrame) {
                byte[] pictureData = ((ApicFrame) entry).pictureData;
                Intrinsics.checkNotNullExpressionValue(pictureData, "pictureData");
                return BitmapFactory.decodeByteArray(pictureData, 0, pictureData.length);
            }
        }
        return null;
    }
}
