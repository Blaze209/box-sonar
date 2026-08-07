package com.microsoft.aad.adal;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public interface IBrokerAccountService extends IInterface {
    public static final String DESCRIPTOR = "com.microsoft.aad.adal.IBrokerAccountService";

    public static class Default implements IBrokerAccountService {
        @Override // com.microsoft.aad.adal.IBrokerAccountService
        public Bundle acquireTokenSilently(Map map) throws RemoteException {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.microsoft.aad.adal.IBrokerAccountService
        public Bundle getBrokerUsers() throws RemoteException {
            return null;
        }

        @Override // com.microsoft.aad.adal.IBrokerAccountService
        public Bundle getInactiveBrokerKey(Bundle bundle) throws RemoteException {
            return null;
        }

        @Override // com.microsoft.aad.adal.IBrokerAccountService
        public Intent getIntentForInteractiveRequest() throws RemoteException {
            return null;
        }

        @Override // com.microsoft.aad.adal.IBrokerAccountService
        public void removeAccounts() throws RemoteException {
        }
    }

    Bundle acquireTokenSilently(Map map) throws RemoteException;

    Bundle getBrokerUsers() throws RemoteException;

    Bundle getInactiveBrokerKey(Bundle bundle) throws RemoteException;

    Intent getIntentForInteractiveRequest() throws RemoteException;

    void removeAccounts() throws RemoteException;

    public static abstract class Stub extends Binder implements IBrokerAccountService {
        static final int TRANSACTION_acquireTokenSilently = 2;
        static final int TRANSACTION_getBrokerUsers = 1;
        static final int TRANSACTION_getInactiveBrokerKey = 5;
        static final int TRANSACTION_getIntentForInteractiveRequest = 3;
        static final int TRANSACTION_removeAccounts = 4;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IBrokerAccountService.DESCRIPTOR);
        }

        public static IBrokerAccountService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IBrokerAccountService.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IBrokerAccountService)) {
                return (IBrokerAccountService) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IBrokerAccountService.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IBrokerAccountService.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                Bundle brokerUsers = getBrokerUsers();
                parcel2.writeNoException();
                _Parcel.writeTypedObject(parcel2, brokerUsers, 1);
            } else if (i == 2) {
                Bundle bundleAcquireTokenSilently = acquireTokenSilently(parcel.readHashMap(getClass().getClassLoader()));
                parcel2.writeNoException();
                _Parcel.writeTypedObject(parcel2, bundleAcquireTokenSilently, 1);
            } else if (i == 3) {
                Intent intentForInteractiveRequest = getIntentForInteractiveRequest();
                parcel2.writeNoException();
                _Parcel.writeTypedObject(parcel2, intentForInteractiveRequest, 1);
            } else if (i == 4) {
                removeAccounts();
                parcel2.writeNoException();
            } else if (i == 5) {
                Bundle inactiveBrokerKey = getInactiveBrokerKey((Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                _Parcel.writeTypedObject(parcel2, inactiveBrokerKey, 1);
            } else {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            return true;
        }

        private static class Proxy implements IBrokerAccountService {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IBrokerAccountService.DESCRIPTOR;
            }

            @Override // com.microsoft.aad.adal.IBrokerAccountService
            public Bundle getBrokerUsers() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IBrokerAccountService.DESCRIPTOR);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (Bundle) _Parcel.readTypedObject(parcelObtain2, Bundle.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.microsoft.aad.adal.IBrokerAccountService
            public Bundle acquireTokenSilently(Map map) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IBrokerAccountService.DESCRIPTOR);
                    parcelObtain.writeMap(map);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (Bundle) _Parcel.readTypedObject(parcelObtain2, Bundle.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.microsoft.aad.adal.IBrokerAccountService
            public Intent getIntentForInteractiveRequest() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IBrokerAccountService.DESCRIPTOR);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (Intent) _Parcel.readTypedObject(parcelObtain2, Intent.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.microsoft.aad.adal.IBrokerAccountService
            public void removeAccounts() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IBrokerAccountService.DESCRIPTOR);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.microsoft.aad.adal.IBrokerAccountService
            public Bundle getInactiveBrokerKey(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IBrokerAccountService.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (Bundle) _Parcel.readTypedObject(parcelObtain2, Bundle.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }

    public static class _Parcel {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T readTypedObject(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void writeTypedObject(Parcel parcel, T t, int i) {
            if (t != null) {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i);
            } else {
                parcel.writeInt(0);
            }
        }
    }
}
