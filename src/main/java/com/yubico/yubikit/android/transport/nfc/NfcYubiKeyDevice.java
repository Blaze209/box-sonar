package com.yubico.yubikit.android.transport.nfc;

import android.nfc.FormatException;
import android.nfc.NdefMessage;
import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import android.nfc.tech.Ndef;
import com.yubico.yubikit.core.Transport;
import com.yubico.yubikit.core.YubiKeyConnection;
import com.yubico.yubikit.core.YubiKeyDevice;
import com.yubico.yubikit.core.application.ApplicationNotAvailableException;
import com.yubico.yubikit.core.smartcard.AppId;
import com.yubico.yubikit.core.smartcard.SmartCardConnection;
import com.yubico.yubikit.core.smartcard.SmartCardProtocol;
import com.yubico.yubikit.core.util.Callback;
import com.yubico.yubikit.core.util.Result;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public class NfcYubiKeyDevice implements YubiKeyDevice {
    private final ExecutorService executorService;
    private final AtomicBoolean removed = new AtomicBoolean();
    private final Tag tag;
    private final int timeout;

    public NfcYubiKeyDevice(Tag tag, int i, ExecutorService executorService) {
        this.executorService = executorService;
        this.tag = tag;
        this.timeout = i;
    }

    public Tag getTag() {
        return this.tag;
    }

    private NfcSmartCardConnection openIso7816Connection() throws IOException {
        IsoDep isoDep = IsoDep.get(this.tag);
        if (isoDep == null) {
            throw new IOException("the tag does not support ISO-DEP");
        }
        isoDep.setTimeout(this.timeout);
        isoDep.connect();
        return new NfcSmartCardConnection(isoDep);
    }

    public byte[] readNdef() throws IOException {
        try {
            Ndef ndef = Ndef.get(this.tag);
            if (ndef != null) {
                try {
                    ndef.connect();
                    NdefMessage ndefMessage = ndef.getNdefMessage();
                    if (ndefMessage != null) {
                        byte[] byteArray = ndefMessage.toByteArray();
                        if (ndef != null) {
                            ndef.close();
                        }
                        return byteArray;
                    }
                } catch (Throwable th) {
                    if (ndef != null) {
                        try {
                            ndef.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
            if (ndef != null) {
                ndef.close();
            }
            throw new IOException("NDEF data missing or invalid");
        } catch (FormatException e) {
            throw new IOException(e);
        }
    }

    public void remove(final Runnable runnable) {
        this.removed.set(true);
        this.executorService.submit(new Runnable() { // from class: com.yubico.yubikit.android.transport.nfc.NfcYubiKeyDevice$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m14397xae7593e0(runnable);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$remove$0$com-yubico-yubikit-android-transport-nfc-NfcYubiKeyDevice, reason: not valid java name */
    /* synthetic */ void m14397xae7593e0(Runnable runnable) {
        try {
            IsoDep isoDep = IsoDep.get(this.tag);
            isoDep.connect();
            while (isoDep.isConnected()) {
                Thread.sleep(250L);
            }
        } catch (IOException | InterruptedException | SecurityException unused) {
        }
        runnable.run();
    }

    @Override // com.yubico.yubikit.core.YubiKeyDevice
    public Transport getTransport() {
        return Transport.NFC;
    }

    @Override // com.yubico.yubikit.core.YubiKeyDevice
    public boolean supportsConnection(Class<? extends YubiKeyConnection> cls) {
        return cls.isAssignableFrom(NfcSmartCardConnection.class);
    }

    @Override // com.yubico.yubikit.core.YubiKeyDevice
    public <T extends YubiKeyConnection> T openConnection(Class<T> cls) throws IOException {
        if (cls.isAssignableFrom(NfcSmartCardConnection.class)) {
            return (T) Objects.requireNonNull(cls.cast(openIso7816Connection()));
        }
        throw new IllegalStateException("The connection type is not supported by this session");
    }

    @Override // com.yubico.yubikit.core.YubiKeyDevice
    public <T extends YubiKeyConnection> void requestConnection(final Class<T> cls, final Callback<Result<T, IOException>> callback) {
        if (this.removed.get()) {
            callback.invoke(Result.failure(new IOException("Can't requestConnection after calling remove()")));
        } else {
            this.executorService.submit(new Runnable() { // from class: com.yubico.yubikit.android.transport.nfc.NfcYubiKeyDevice$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m14398xc7f5df50(cls, callback);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$requestConnection$1$com-yubico-yubikit-android-transport-nfc-NfcYubiKeyDevice, reason: not valid java name */
    /* synthetic */ void m14398xc7f5df50(Class cls, Callback callback) {
        try {
            YubiKeyConnection yubiKeyConnectionOpenConnection = openConnection(cls);
            try {
                callback.invoke(Result.success(yubiKeyConnectionOpenConnection));
                if (yubiKeyConnectionOpenConnection != null) {
                    yubiKeyConnectionOpenConnection.close();
                }
            } catch (Throwable th) {
                if (yubiKeyConnectionOpenConnection != null) {
                    try {
                        yubiKeyConnectionOpenConnection.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (IOException e) {
            callback.invoke(Result.failure(e));
        } catch (Exception e2) {
            callback.invoke(Result.failure(new IOException("openConnection(" + cls.getSimpleName() + ") exception: " + e2.getMessage())));
        }
    }

    public boolean isYubiKey() {
        try {
            SmartCardConnection smartCardConnection = (SmartCardConnection) openConnection(SmartCardConnection.class);
            try {
                SmartCardProtocol smartCardProtocol = new SmartCardProtocol(smartCardConnection);
                try {
                    try {
                        smartCardProtocol.select(AppId.MANAGEMENT);
                        if (smartCardConnection != null) {
                            smartCardConnection.close();
                        }
                        return true;
                    } catch (ApplicationNotAvailableException unused) {
                        smartCardProtocol.select(AppId.OTP);
                        if (smartCardConnection != null) {
                            smartCardConnection.close();
                        }
                        return true;
                    }
                } catch (ApplicationNotAvailableException unused2) {
                    if (smartCardConnection == null) {
                        return false;
                    }
                    smartCardConnection.close();
                    return false;
                }
            } catch (Throwable th) {
                if (smartCardConnection != null) {
                    try {
                        smartCardConnection.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (IOException unused3) {
            return false;
        }
    }

    public String toString() {
        return "NfcYubiKeyDevice{tag=" + this.tag + ", timeout=" + this.timeout + AbstractJsonLexerKt.END_OBJ;
    }
}
