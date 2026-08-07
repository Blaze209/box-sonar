package com.google.android.gms.internal.p000authapi;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.microsoft.intune.mam.client.os.MAMBinder;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@20.7.0 */
/* JADX INFO: loaded from: classes13.dex */
public class zbb extends MAMBinder implements IInterface {
    protected zbb(String str) {
        attachInterface(this, str);
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    @Override // com.microsoft.intune.mam.client.os.MAMBinder, com.microsoft.intune.mam.client.os.HookedBinder
    public final boolean onMAMTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i <= 16777215) {
            parcel.enforceInterface(getInterfaceDescriptor());
        } else if (super.onMAMTransact(i, parcel, parcel2, i2)) {
            return true;
        }
        return zba(i, parcel, parcel2, i2);
    }

    protected boolean zba(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        throw null;
    }
}
