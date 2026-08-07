package com.microsoft.intune.mam.client.os;

import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface BinderBehavior {
    void attach(HookedBinder hookedBinder);

    boolean onMAMTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException;

    boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException;
}
