package external.sdk.pendo.io.glide.load;

import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes4.dex */
public interface ImageHeaderParser {

    public enum ImageType {
        GIF(true),
        JPEG(false),
        RAW(false),
        PNG_A(true),
        PNG(false),
        WEBP_A(true),
        WEBP(false),
        ANIMATED_WEBP(true),
        AVIF(true),
        ANIMATED_AVIF(true),
        UNKNOWN(false);

        private final boolean hasAlpha;

        ImageType(boolean z) {
            this.hasAlpha = z;
        }

        public boolean hasAlpha() {
            return this.hasAlpha;
        }

        public boolean isWebp() {
            int i = a.a[ordinal()];
            return i == 1 || i == 2 || i == 3;
        }
    }

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ImageType.values().length];
            a = iArr;
            try {
                iArr[ImageType.WEBP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ImageType.WEBP_A.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ImageType.ANIMATED_WEBP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    int getOrientation(InputStream inputStream, sdk.pendo.io.i.a aVar);

    int getOrientation(ByteBuffer byteBuffer, sdk.pendo.io.i.a aVar);

    ImageType getType(InputStream inputStream);

    ImageType getType(ByteBuffer byteBuffer);

    boolean hasJpegMpf(InputStream inputStream, sdk.pendo.io.i.a aVar);

    boolean hasJpegMpf(ByteBuffer byteBuffer, sdk.pendo.io.i.a aVar);
}
