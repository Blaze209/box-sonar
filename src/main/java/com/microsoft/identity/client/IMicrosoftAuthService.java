package com.microsoft.identity.client;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes14.dex */
public interface IMicrosoftAuthService extends IInterface {
    public static final String DESCRIPTOR = "com.microsoft.identity.client.IMicrosoftAuthService";

    public static class Default implements IMicrosoftAuthService {
        @Override // com.microsoft.identity.client.IMicrosoftAuthService
        public Bundle acquireTokenSilently(Bundle bundle) throws RemoteException {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.microsoft.identity.client.IMicrosoftAuthService
        public Bundle generateSignedHttpRequest(Bundle bundle) throws RemoteException {
            return null;
        }

        @Override // com.microsoft.identity.client.IMicrosoftAuthService
        public Bundle getAccounts(Bundle bundle) throws RemoteException {
            return null;
        }

        @Override // com.microsoft.identity.client.IMicrosoftAuthService
        public Bundle getCurrentAccount(Bundle bundle) throws RemoteException {
            return null;
        }

        @Override // com.microsoft.identity.client.IMicrosoftAuthService
        public Bundle getDeviceMode() throws RemoteException {
            return null;
        }

        @Override // com.microsoft.identity.client.IMicrosoftAuthService
        public Intent getIntentForInteractiveRequest() throws RemoteException {
            return null;
        }

        @Override // com.microsoft.identity.client.IMicrosoftAuthService
        public Bundle hello(Bundle bundle) throws RemoteException {
            return null;
        }

        @Override // com.microsoft.identity.client.IMicrosoftAuthService
        public Bundle removeAccount(Bundle bundle) throws RemoteException {
            return null;
        }

        @Override // com.microsoft.identity.client.IMicrosoftAuthService
        public Bundle removeAccountFromSharedDevice(Bundle bundle) throws RemoteException {
            return null;
        }
    }

    Bundle acquireTokenSilently(Bundle bundle) throws RemoteException;

    Bundle generateSignedHttpRequest(Bundle bundle) throws RemoteException;

    Bundle getAccounts(Bundle bundle) throws RemoteException;

    Bundle getCurrentAccount(Bundle bundle) throws RemoteException;

    Bundle getDeviceMode() throws RemoteException;

    Intent getIntentForInteractiveRequest() throws RemoteException;

    Bundle hello(Bundle bundle) throws RemoteException;

    Bundle removeAccount(Bundle bundle) throws RemoteException;

    Bundle removeAccountFromSharedDevice(Bundle bundle) throws RemoteException;

    public static abstract class Stub extends Binder implements IMicrosoftAuthService {
        static final int TRANSACTION_acquireTokenSilently = 3;
        static final int TRANSACTION_generateSignedHttpRequest = 9;
        static final int TRANSACTION_getAccounts = 2;
        static final int TRANSACTION_getCurrentAccount = 7;
        static final int TRANSACTION_getDeviceMode = 6;
        static final int TRANSACTION_getIntentForInteractiveRequest = 4;
        static final int TRANSACTION_hello = 1;
        static final int TRANSACTION_removeAccount = 5;
        static final int TRANSACTION_removeAccountFromSharedDevice = 8;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IMicrosoftAuthService.DESCRIPTOR);
        }

        public static IMicrosoftAuthService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IMicrosoftAuthService.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IMicrosoftAuthService)) {
                return (IMicrosoftAuthService) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IMicrosoftAuthService.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IMicrosoftAuthService.DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    Bundle bundleHello = hello((Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    _Parcel.writeTypedObject(parcel2, bundleHello, 1);
                    return true;
                case 2:
                    Bundle accounts = getAccounts((Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    _Parcel.writeTypedObject(parcel2, accounts, 1);
                    return true;
                case 3:
                    Bundle bundleAcquireTokenSilently = acquireTokenSilently((Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    _Parcel.writeTypedObject(parcel2, bundleAcquireTokenSilently, 1);
                    return true;
                case 4:
                    Intent intentForInteractiveRequest = getIntentForInteractiveRequest();
                    parcel2.writeNoException();
                    _Parcel.writeTypedObject(parcel2, intentForInteractiveRequest, 1);
                    return true;
                case 5:
                    Bundle bundleRemoveAccount = removeAccount((Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    _Parcel.writeTypedObject(parcel2, bundleRemoveAccount, 1);
                    return true;
                case 6:
                    Bundle deviceMode = getDeviceMode();
                    parcel2.writeNoException();
                    _Parcel.writeTypedObject(parcel2, deviceMode, 1);
                    return true;
                case 7:
                    Bundle currentAccount = getCurrentAccount((Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    _Parcel.writeTypedObject(parcel2, currentAccount, 1);
                    return true;
                case 8:
                    Bundle bundleRemoveAccountFromSharedDevice = removeAccountFromSharedDevice((Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    _Parcel.writeTypedObject(parcel2, bundleRemoveAccountFromSharedDevice, 1);
                    return true;
                case 9:
                    Bundle bundleGenerateSignedHttpRequest = generateSignedHttpRequest((Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    _Parcel.writeTypedObject(parcel2, bundleGenerateSignedHttpRequest, 1);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        private static class Proxy implements IMicrosoftAuthService {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IMicrosoftAuthService.DESCRIPTOR;
            }

            @Override // com.microsoft.identity.client.IMicrosoftAuthService
            public Bundle hello(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMicrosoftAuthService.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (Bundle) _Parcel.readTypedObject(parcelObtain2, Bundle.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.microsoft.identity.client.IMicrosoftAuthService
            public Bundle getAccounts(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMicrosoftAuthService.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (Bundle) _Parcel.readTypedObject(parcelObtain2, Bundle.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.microsoft.identity.client.IMicrosoftAuthService
            public Bundle acquireTokenSilently(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMicrosoftAuthService.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (Bundle) _Parcel.readTypedObject(parcelObtain2, Bundle.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.microsoft.identity.client.IMicrosoftAuthService
            public Intent getIntentForInteractiveRequest() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMicrosoftAuthService.DESCRIPTOR);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (Intent) _Parcel.readTypedObject(parcelObtain2, Intent.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.microsoft.identity.client.IMicrosoftAuthService
            public Bundle removeAccount(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMicrosoftAuthService.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (Bundle) _Parcel.readTypedObject(parcelObtain2, Bundle.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.microsoft.identity.client.IMicrosoftAuthService
            public Bundle getDeviceMode() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMicrosoftAuthService.DESCRIPTOR);
                    this.mRemote.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (Bundle) _Parcel.readTypedObject(parcelObtain2, Bundle.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.microsoft.identity.client.IMicrosoftAuthService
            public Bundle getCurrentAccount(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMicrosoftAuthService.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (Bundle) _Parcel.readTypedObject(parcelObtain2, Bundle.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.microsoft.identity.client.IMicrosoftAuthService
            public Bundle removeAccountFromSharedDevice(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMicrosoftAuthService.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (Bundle) _Parcel.readTypedObject(parcelObtain2, Bundle.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.microsoft.identity.client.IMicrosoftAuthService
            public Bundle generateSignedHttpRequest(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMicrosoftAuthService.DESCRIPTOR);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(9, parcelObtain, parcelObtain2, 0);
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
