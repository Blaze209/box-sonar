package androidx.media3.common;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.microsoft.intune.mam.client.os.MAMBinder;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public final class BundleListRetriever extends MAMBinder {
    private static final int REPLY_BREAK = 2;
    private static final int REPLY_CONTINUE = 1;
    private static final int REPLY_END_OF_LIST = 0;
    private final ImmutableList<Bundle> list;

    public BundleListRetriever(List<Bundle> list) {
        this.list = ImmutableList.copyOf((Collection) list);
    }

    @Override // com.microsoft.intune.mam.client.os.MAMBinder, com.microsoft.intune.mam.client.os.HookedBinder
    public boolean onMAMTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return super.onMAMTransact(i, parcel, parcel2, i2);
        }
        if (parcel2 == null) {
            return false;
        }
        int size = this.list.size();
        int i3 = parcel.readInt();
        while (i3 < size && parcel2.dataSize() < C.SUGGESTED_MAX_IPC_SIZE) {
            parcel2.writeInt(1);
            parcel2.writeBundle(this.list.get(i3));
            i3++;
        }
        parcel2.writeInt(i3 < size ? 2 : 0);
        return true;
    }

    public static ImmutableList<Bundle> getList(IBinder iBinder) {
        if (iBinder instanceof BundleListRetriever) {
            return ((BundleListRetriever) iBinder).list;
        }
        return getListFromRemoteBinder(iBinder);
    }

    static ImmutableList<Bundle> getListFromRemoteBinder(IBinder iBinder) {
        int i;
        ImmutableList.Builder builder = ImmutableList.builder();
        int i2 = 0;
        int i3 = 1;
        while (i3 != 0) {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInt(i2);
                try {
                    iBinder.transact(1, parcelObtain, parcelObtain2, 0);
                    while (true) {
                        i = parcelObtain2.readInt();
                        if (i == 1) {
                            builder.add((Bundle) Preconditions.checkNotNull(parcelObtain2.readBundle()));
                            i2++;
                        }
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    i3 = i;
                } catch (RemoteException e) {
                    throw new RuntimeException(e);
                }
            } catch (Throwable th) {
                parcelObtain2.recycle();
                parcelObtain.recycle();
                throw th;
            }
        }
        return builder.build();
    }
}
