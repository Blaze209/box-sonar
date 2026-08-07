package com.google.android.gms.internal.ads_identifier;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.microsoft.intune.mam.client.os.MAMBinder;

/* JADX INFO: loaded from: classes13.dex */
public class zzb extends MAMBinder implements IInterface {
    private static zzd zzc;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        throw new NoSuchMethodError();
    }

    @Override // com.microsoft.intune.mam.client.os.MAMBinder, com.microsoft.intune.mam.client.os.HookedBinder
    public boolean onMAMTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        throw new NoSuchMethodError();
    }
}
