package androidx.media3.effect;

import android.graphics.Bitmap;
import androidx.media3.common.Format;

/* JADX INFO: loaded from: classes8.dex */
final class BitmapFrame implements Frame {
    private final Bitmap bitmap;
    private final Metadata metadata;

    public static final class Metadata implements Frame.Metadata {
        private final Format format;
        private final long presentationTimeUs;

        public Metadata(long j, Format format) {
            this.presentationTimeUs = j;
            this.format = format;
        }

        public long getPresentationTimeUs() {
            return this.presentationTimeUs;
        }

        public Format getFormat() {
            return this.format;
        }
    }

    public BitmapFrame(Bitmap bitmap, Metadata metadata) {
        this.bitmap = bitmap;
        this.metadata = metadata;
    }

    @Override // androidx.media3.effect.Frame
    public Metadata getMetadata() {
        return this.metadata;
    }

    @Override // androidx.media3.effect.Frame
    public void release(SyncFenceCompat syncFenceCompat) {
        this.bitmap.recycle();
    }

    public Bitmap getBitmap() {
        return this.bitmap;
    }
}
