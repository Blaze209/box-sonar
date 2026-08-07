package external.sdk.pendo.io.glide.load.resource.bitmap;

import androidx.exifinterface.media.ExifInterface;
import external.sdk.pendo.io.glide.load.ImageHeaderParser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes4.dex */
public final class ExifInterfaceImageHeaderParser implements ImageHeaderParser {
    @Override // external.sdk.pendo.io.glide.load.ImageHeaderParser
    public int getOrientation(InputStream inputStream, sdk.pendo.io.i.a aVar) {
        int attributeInt = new ExifInterface(inputStream).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
        if (attributeInt == 0) {
            return -1;
        }
        return attributeInt;
    }

    @Override // external.sdk.pendo.io.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType getType(InputStream inputStream) {
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    @Override // external.sdk.pendo.io.glide.load.ImageHeaderParser
    public boolean hasJpegMpf(InputStream inputStream, sdk.pendo.io.i.a aVar) {
        return false;
    }

    @Override // external.sdk.pendo.io.glide.load.ImageHeaderParser
    public boolean hasJpegMpf(ByteBuffer byteBuffer, sdk.pendo.io.i.a aVar) {
        return false;
    }

    @Override // external.sdk.pendo.io.glide.load.ImageHeaderParser
    public int getOrientation(ByteBuffer byteBuffer, sdk.pendo.io.i.a aVar) {
        return getOrientation(sdk.pendo.io.y.a.d(byteBuffer), aVar);
    }

    @Override // external.sdk.pendo.io.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType getType(ByteBuffer byteBuffer) {
        return ImageHeaderParser.ImageType.UNKNOWN;
    }
}
