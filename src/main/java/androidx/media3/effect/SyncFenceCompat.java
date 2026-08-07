package androidx.media3.effect;

import android.hardware.SyncFence;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.system.StructPollfd;
import com.google.common.base.Preconditions;
import java.io.IOException;

/* JADX INFO: loaded from: classes8.dex */
public class SyncFenceCompat implements AutoCloseable {
    private final ParcelFileDescriptor parcelFileDescriptor;

    public static SyncFenceCompat duplicate(SyncFence syncFence) {
        return new SyncFenceCompat(readFileDescriptor(syncFence));
    }

    public static SyncFenceCompat adoptFenceFileDescriptor(int i) {
        return new SyncFenceCompat(ParcelFileDescriptor.adoptFd(i));
    }

    private SyncFenceCompat(ParcelFileDescriptor parcelFileDescriptor) {
        this.parcelFileDescriptor = parcelFileDescriptor;
    }

    public boolean await(int i) throws ErrnoException {
        StructPollfd structPollfd = new StructPollfd();
        StructPollfd[] structPollfdArr = {structPollfd};
        structPollfd.fd = this.parcelFileDescriptor.getFileDescriptor();
        structPollfdArr[0].events = (short) OsConstants.POLLIN;
        structPollfdArr[0].revents = (short) 0;
        return Os.poll(structPollfdArr, i) == 1;
    }

    @Override // java.lang.AutoCloseable
    public void close() throws IOException {
        this.parcelFileDescriptor.close();
    }

    private static ParcelFileDescriptor readFileDescriptor(SyncFence syncFence) {
        Parcel parcelObtain = Parcel.obtain();
        syncFence.writeToParcel(parcelObtain, 0);
        parcelObtain.setDataPosition(0);
        Preconditions.checkState(parcelObtain.readBoolean());
        return parcelObtain.readFileDescriptor();
    }
}
