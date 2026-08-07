package external.sdk.pendo.io.glide.load.data;

import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public final class ParcelFileDescriptorRewinder implements b<ParcelFileDescriptor> {
    private final InternalRewinder rewinder;

    public static final class Factory implements b.a<ParcelFileDescriptor> {
        @Override // external.sdk.pendo.io.glide.load.data.b.a
        public b<ParcelFileDescriptor> build(ParcelFileDescriptor parcelFileDescriptor) {
            return new ParcelFileDescriptorRewinder(parcelFileDescriptor);
        }

        @Override // external.sdk.pendo.io.glide.load.data.b.a
        public Class<ParcelFileDescriptor> getDataClass() {
            return ParcelFileDescriptor.class;
        }
    }

    private static final class InternalRewinder {
        private final ParcelFileDescriptor a;

        InternalRewinder(ParcelFileDescriptor parcelFileDescriptor) {
            this.a = parcelFileDescriptor;
        }

        ParcelFileDescriptor rewind() throws IOException {
            try {
                Os.lseek(this.a.getFileDescriptor(), 0L, OsConstants.SEEK_SET);
                return this.a;
            } catch (ErrnoException e) {
                throw new IOException(e);
            }
        }
    }

    public ParcelFileDescriptorRewinder(ParcelFileDescriptor parcelFileDescriptor) {
        this.rewinder = new InternalRewinder(parcelFileDescriptor);
    }

    public static boolean isSupported() {
        return !"robolectric".equals(Build.FINGERPRINT);
    }

    @Override // external.sdk.pendo.io.glide.load.data.b
    public void cleanup() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // external.sdk.pendo.io.glide.load.data.b
    public ParcelFileDescriptor rewindAndGet() {
        return this.rewinder.rewind();
    }
}
