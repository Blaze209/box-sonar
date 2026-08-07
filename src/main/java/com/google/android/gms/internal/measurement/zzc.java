package com.google.android.gms.internal.measurement;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.microsoft.intune.mam.client.os.MAMBinder;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
public class zzc extends MAMBinder implements IInterface {
    private static zze zza;

    protected zzc(String str) {
        attachInterface(this, str);
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    protected boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        return false;
    }

    @Override // com.microsoft.intune.mam.client.os.MAMBinder, com.microsoft.intune.mam.client.os.HookedBinder
    public boolean onMAMTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        boolean zOnMAMTransact;
        if (i > 16777215) {
            zOnMAMTransact = super.onMAMTransact(i, parcel, parcel2, i2);
        } else {
            parcel.enforceInterface(getInterfaceDescriptor());
            zOnMAMTransact = false;
        }
        if (zOnMAMTransact) {
            return true;
        }
        return zza(i, parcel, parcel2, i2);
    }
}
