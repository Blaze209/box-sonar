package com.microsoft.intune.mam.client.os;

import android.os.Binder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface HookedBinder {
    Binder asBinder();

    boolean onMAMTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException;

    boolean onTransactReal(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException;
}
