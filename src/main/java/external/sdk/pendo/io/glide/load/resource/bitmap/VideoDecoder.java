package external.sdk.pendo.io.glide.load.resource.bitmap;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.MediaDataSource;
import android.media.MediaExtractor;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.media3.common.MimeTypes;
import com.microsoft.intune.mam.client.media.MAMMediaMetadataRetriever;
import external.sdk.pendo.io.glide.load.Options;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import sdk.pendo.io.e.i;

/* JADX INFO: loaded from: classes4.dex */
public class VideoDecoder<T> implements i<T, Bitmap> {
    public static final long DEFAULT_FRAME = -1;
    static final int DEFAULT_FRAME_OPTION = 2;
    private static final String TAG = "VideoDecoder";
    private static final String WEBM_MIME_TYPE = "video/webm";
    private final sdk.pendo.io.i.b bitmapPool;
    private final f factory;
    private final e<T> initializer;
    public static final sdk.pendo.io.e.g<Long> TARGET_FRAME = sdk.pendo.io.e.g.a("external.sdk.pendo.io.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new a());
    public static final sdk.pendo.io.e.g<Integer> FRAME_OPTION = sdk.pendo.io.e.g.a("external.sdk.pendo.io.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new b());
    private static final f DEFAULT_FACTORY = new f();
    private static final List<String> PIXEL_T_BUILD_ID_PREFIXES_REQUIRING_HDR_180_ROTATION_FIX = Collections.unmodifiableList(Arrays.asList("TP1A", "TD1A.220804.031"));

    class a implements sdk.pendo.io.e.g.b<Long> {
        private final ByteBuffer a = ByteBuffer.allocate(8);

        a() {
        }

        @Override // sdk.pendo.io.e.g.b
        public void a(byte[] bArr, Long l, MessageDigest messageDigest) {
            messageDigest.update(bArr);
            synchronized (this.a) {
                this.a.position(0);
                messageDigest.update(this.a.putLong(l.longValue()).array());
            }
        }
    }

    class b implements sdk.pendo.io.e.g.b<Integer> {
        private final ByteBuffer a = ByteBuffer.allocate(4);

        b() {
        }

        @Override // sdk.pendo.io.e.g.b
        public void a(byte[] bArr, Integer num, MessageDigest messageDigest) {
            if (num == null) {
                return;
            }
            messageDigest.update(bArr);
            synchronized (this.a) {
                this.a.position(0);
                messageDigest.update(this.a.putInt(num.intValue()).array());
            }
        }
    }

    interface e<T> {
        void a(MediaExtractor mediaExtractor, T t);

        void a(MediaMetadataRetriever mediaMetadataRetriever, T t);
    }

    static class f {
        f() {
        }

        public MediaMetadataRetriever a() {
            return new MAMMediaMetadataRetriever();
        }
    }

    private static final class h extends RuntimeException {
        h() {
            super("MediaMetadataRetriever failed to retrieve a frame without throwing, check the adb logs for .*MetadataRetriever.* prior to this exception for details");
        }
    }

    VideoDecoder(sdk.pendo.io.i.b bVar, e<T> eVar) {
        this(bVar, eVar, DEFAULT_FACTORY);
    }

    public static i<AssetFileDescriptor, Bitmap> asset(sdk.pendo.io.i.b bVar) {
        return new VideoDecoder(bVar, new c(null));
    }

    public static i<ByteBuffer, Bitmap> byteBuffer(sdk.pendo.io.i.b bVar) {
        return new VideoDecoder(bVar, new d());
    }

    private static Bitmap correctHdr180DegVideoFrameOrientation(MediaMetadataRetriever mediaMetadataRetriever, Bitmap bitmap) {
        if (isHdr180RotationFixRequired()) {
            try {
                if (isHDR(mediaMetadataRetriever)) {
                    if (Math.abs(Integer.parseInt(mediaMetadataRetriever.extractMetadata(24))) != 180) {
                        return bitmap;
                    }
                    if (Log.isLoggable("VideoDecoder", 3)) {
                        Log.d("VideoDecoder", "Applying HDR 180 deg thumbnail correction");
                    }
                    Matrix matrix = new Matrix();
                    matrix.postRotate(180.0f, bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2.0f);
                    return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                }
            } catch (NumberFormatException unused) {
                if (!Log.isLoggable("VideoDecoder", 3)) {
                    return bitmap;
                }
                Log.d("VideoDecoder", "Exception trying to extract HDR transfer function or rotation");
                return bitmap;
            }
        }
        return bitmap;
    }

    private Bitmap decodeFrame(T t, MediaMetadataRetriever mediaMetadataRetriever, long j, int i, int i2, int i3, external.sdk.pendo.io.glide.load.resource.bitmap.a aVar) {
        if (isUnsupportedFormat(t, mediaMetadataRetriever)) {
            throw new IllegalStateException("Cannot decode VP8 video on CrOS.");
        }
        Bitmap bitmapDecodeScaledFrame = (i2 == Integer.MIN_VALUE || i3 == Integer.MIN_VALUE || aVar == external.sdk.pendo.io.glide.load.resource.bitmap.a.f) ? null : decodeScaledFrame(mediaMetadataRetriever, j, i, i2, i3, aVar);
        if (bitmapDecodeScaledFrame == null) {
            bitmapDecodeScaledFrame = decodeOriginalFrame(mediaMetadataRetriever, j, i);
        }
        Bitmap bitmapCorrectHdr180DegVideoFrameOrientation = correctHdr180DegVideoFrameOrientation(mediaMetadataRetriever, bitmapDecodeScaledFrame);
        if (bitmapCorrectHdr180DegVideoFrameOrientation != null) {
            return bitmapCorrectHdr180DegVideoFrameOrientation;
        }
        throw new h();
    }

    private static Bitmap decodeOriginalFrame(MediaMetadataRetriever mediaMetadataRetriever, long j, int i) {
        return mediaMetadataRetriever.getFrameAtTime(j, i);
    }

    private static Bitmap decodeScaledFrame(MediaMetadataRetriever mediaMetadataRetriever, long j, int i, int i2, int i3, external.sdk.pendo.io.glide.load.resource.bitmap.a aVar) {
        try {
            int i4 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int i5 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            int i6 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            if (i6 == 90 || i6 == 270) {
                i5 = i4;
                i4 = i5;
            }
            float fB = aVar.b(i4, i5, i2, i3);
            return mediaMetadataRetriever.getScaledFrameAtTime(j, i, Math.round(i4 * fB), Math.round(fB * i5));
        } catch (Throwable th) {
            if (!Log.isLoggable("VideoDecoder", 3)) {
                return null;
            }
            Log.d("VideoDecoder", "Exception trying to decode a scaled frame on oreo+, falling back to a fullsize frame", th);
            return null;
        }
    }

    private static boolean isHDR(MediaMetadataRetriever mediaMetadataRetriever) {
        String strExtractMetadata = mediaMetadataRetriever.extractMetadata(36);
        String strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(35);
        int i = Integer.parseInt(strExtractMetadata);
        return (i == 7 || i == 6) && Integer.parseInt(strExtractMetadata2) == 6;
    }

    static boolean isHdr180RotationFixRequired() {
        if (Build.MODEL.startsWith("Pixel") && Build.VERSION.SDK_INT == 33) {
            return isTBuildRequiringRotationFix();
        }
        return Build.VERSION.SDK_INT < 33;
    }

    private static boolean isTBuildRequiringRotationFix() {
        Iterator<String> it = PIXEL_T_BUILD_ID_PREFIXES_REQUIRING_HDR_180_ROTATION_FIX.iterator();
        while (it.hasNext()) {
            if (Build.ID.startsWith(it.next())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0054 A[Catch: all -> 0x005f, TRY_LEAVE, TryCatch #2 {all -> 0x005f, blocks: (B:23:0x004e, B:25:0x0054), top: B:38:0x004e }] */
    private boolean isUnsupportedFormat(T t, MediaMetadataRetriever mediaMetadataRetriever) {
        MediaExtractor mediaExtractor;
        String str = Build.DEVICE;
        if (str == null || !str.matches(".+_cheets|cheets_.+")) {
            return false;
        }
        try {
            try {
                if (!"video/webm".equals(mediaMetadataRetriever.extractMetadata(12))) {
                    return false;
                }
                mediaExtractor = new MediaExtractor();
                try {
                    this.initializer.a(mediaExtractor, t);
                    int trackCount = mediaExtractor.getTrackCount();
                    for (int i = 0; i < trackCount; i++) {
                        if (MimeTypes.VIDEO_VP8.equals(mediaExtractor.getTrackFormat(i).getString("mime"))) {
                            mediaExtractor.release();
                            return true;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    if (Log.isLoggable("VideoDecoder", 3)) {
                        Log.d("VideoDecoder", "Exception trying to extract track info for a webm video on CrOS.", th);
                    }
                    return false;
                }
                return false;
                if (Log.isLoggable("VideoDecoder", 3)) {
                    Log.d("VideoDecoder", "Exception trying to extract track info for a webm video on CrOS.", th);
                }
                return false;
            } finally {
                if (mediaExtractor != null) {
                    mediaExtractor.release();
                }
            }
        } catch (Throwable th2) {
            th = th2;
            mediaExtractor = null;
        }
    }

    public static i<ParcelFileDescriptor, Bitmap> parcel(sdk.pendo.io.i.b bVar) {
        return new VideoDecoder(bVar, new g());
    }

    @Override // sdk.pendo.io.e.i
    public sdk.pendo.io.h.c<Bitmap> decode(T t, int i, int i2, Options options) throws IOException {
        long jLongValue = ((Long) options.get(TARGET_FRAME)).longValue();
        if (jLongValue < 0 && jLongValue != -1) {
            throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + jLongValue);
        }
        Integer num = (Integer) options.get(FRAME_OPTION);
        if (num == null) {
            num = 2;
        }
        external.sdk.pendo.io.glide.load.resource.bitmap.a aVar = (external.sdk.pendo.io.glide.load.resource.bitmap.a) options.get(external.sdk.pendo.io.glide.load.resource.bitmap.a.h);
        if (aVar == null) {
            aVar = external.sdk.pendo.io.glide.load.resource.bitmap.a.g;
        }
        external.sdk.pendo.io.glide.load.resource.bitmap.a aVar2 = aVar;
        MediaMetadataRetriever mediaMetadataRetrieverA = this.factory.a();
        try {
            this.initializer.a(mediaMetadataRetrieverA, t);
            return BitmapResource.obtain(decodeFrame(t, mediaMetadataRetrieverA, jLongValue, num.intValue(), i, i2, aVar2), this.bitmapPool);
        } finally {
            mediaMetadataRetrieverA.close();
        }
    }

    @Override // sdk.pendo.io.e.i
    public boolean handles(T t, Options options) {
        return true;
    }

    private static final class c implements e<AssetFileDescriptor> {
        private c() {
        }

        /* synthetic */ c(a aVar) {
            this();
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.VideoDecoder.e
        public void a(MediaExtractor mediaExtractor, AssetFileDescriptor assetFileDescriptor) throws IOException {
            mediaExtractor.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.VideoDecoder.e
        public void a(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) {
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }
    }

    static final class d implements e<ByteBuffer> {

        class a extends MediaDataSource {
            final /* synthetic */ ByteBuffer a;

            a(ByteBuffer byteBuffer) {
                this.a = byteBuffer;
            }

            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // android.media.MediaDataSource
            public long getSize() {
                return this.a.limit();
            }

            @Override // android.media.MediaDataSource
            public int readAt(long j, byte[] bArr, int i, int i2) {
                if (j >= this.a.limit()) {
                    return -1;
                }
                this.a.position((int) j);
                int iMin = Math.min(i2, this.a.remaining());
                this.a.get(bArr, i, iMin);
                return iMin;
            }
        }

        d() {
        }

        private MediaDataSource a(ByteBuffer byteBuffer) {
            return new a(byteBuffer);
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.VideoDecoder.e
        public void a(MediaExtractor mediaExtractor, ByteBuffer byteBuffer) throws IOException {
            mediaExtractor.setDataSource(a(byteBuffer));
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.VideoDecoder.e
        public void a(MediaMetadataRetriever mediaMetadataRetriever, ByteBuffer byteBuffer) {
            mediaMetadataRetriever.setDataSource(a(byteBuffer));
        }
    }

    static final class g implements e<ParcelFileDescriptor> {
        g() {
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.VideoDecoder.e
        public void a(MediaExtractor mediaExtractor, ParcelFileDescriptor parcelFileDescriptor) throws IOException {
            mediaExtractor.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.VideoDecoder.e
        public void a(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }

    VideoDecoder(sdk.pendo.io.i.b bVar, e<T> eVar, f fVar) {
        this.bitmapPool = bVar;
        this.initializer = eVar;
        this.factory = fVar;
    }
}
