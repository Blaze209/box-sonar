package com.microsoft.intune.mam.client.os;

import android.os.Binder;
import android.os.Parcel;
import android.os.RemoteException;
import com.microsoft.intune.mam.client.app.MAMComponents;

/* JADX INFO: loaded from: classes3.dex */
public abstract class MAMBinder extends Binder implements HookedBinder {
    private final BinderBehavior mBehavior;

    @Override // com.microsoft.intune.mam.client.os.HookedBinder
    public final Binder asBinder() {
        return this;
    }

    public MAMBinder() {
        BinderBehavior binderBehavior = (BinderBehavior) MAMComponents.get(BinderBehavior.class);
        this.mBehavior = binderBehavior;
        if (binderBehavior != null) {
            binderBehavior.attach(this);
        }
    }

    @Override // android.os.Binder
    protected final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        BinderBehavior binderBehavior = this.mBehavior;
        return binderBehavior == null ? onMAMTransact(i, parcel, parcel2, i2) : binderBehavior.onTransact(i, parcel, parcel2, i2);
    }

    public boolean onMAMTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        BinderBehavior binderBehavior = this.mBehavior;
        return binderBehavior == null ? onTransactReal(i, parcel, parcel2, i2) : binderBehavior.onMAMTransact(i, parcel, parcel2, i2);
    }

    @Override // com.microsoft.intune.mam.client.os.HookedBinder
    public final boolean onTransactReal(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        return super.onTransact(i, parcel, parcel2, i2);
    }
}
