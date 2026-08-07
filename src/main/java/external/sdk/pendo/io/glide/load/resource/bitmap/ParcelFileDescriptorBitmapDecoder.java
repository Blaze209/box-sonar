package external.sdk.pendo.io.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import external.sdk.pendo.io.glide.load.Options;
import sdk.pendo.io.e.i;

/* JADX INFO: loaded from: classes4.dex */
public final class ParcelFileDescriptorBitmapDecoder implements i<ParcelFileDescriptor, Bitmap> {
    private static final int MAXIMUM_FILE_BYTE_SIZE_FOR_FILE_DESCRIPTOR_DECODER = 536870912;
    private final b downsampler;

    public ParcelFileDescriptorBitmapDecoder(b bVar) {
        this.downsampler = bVar;
    }

    private boolean isSafeToTryDecoding(ParcelFileDescriptor parcelFileDescriptor) {
        String str = Build.MANUFACTURER;
        return !("HUAWEI".equalsIgnoreCase(str) || "HONOR".equalsIgnoreCase(str)) || parcelFileDescriptor.getStatSize() <= 536870912;
    }

    @Override // sdk.pendo.io.e.i
    public sdk.pendo.io.h.c<Bitmap> decode(ParcelFileDescriptor parcelFileDescriptor, int i, int i2, Options options) {
        return this.downsampler.a(parcelFileDescriptor, i, i2, options);
    }

    @Override // sdk.pendo.io.e.i
    public boolean handles(ParcelFileDescriptor parcelFileDescriptor, Options options) {
        return isSafeToTryDecoding(parcelFileDescriptor) && this.downsampler.a(parcelFileDescriptor);
    }
}
