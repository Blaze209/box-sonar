package com.pspdfkit.internal;

import com.pspdfkit.instant.exceptions.InstantErrorCode;
import com.pspdfkit.instant.exceptions.InstantException;
import com.pspdfkit.instant.internal.jni.NativeAsset;
import com.pspdfkit.instant.internal.jni.NativeAssetLoadState;
import com.pspdfkit.instant.internal.jni.NativeAssetManager;
import com.pspdfkit.instant.internal.jni.NativeInstantError;
import com.pspdfkit.instant.internal.jni.NativeProgressReporterResult;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class il {
    public final gm a;
    public final NativeAssetManager b;
    public final b c;
    public final HashSet d = new HashSet();

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[NativeAssetLoadState.values().length];
            b = iArr;
            try {
                iArr[NativeAssetLoadState.LOCAL_ONLY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[NativeAssetLoadState.UPLOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[NativeAssetLoadState.REMOTE_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[NativeAssetLoadState.DOWNLOADING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[NativeAssetLoadState.LOADED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[y30.b(5).length];
            a = iArr2;
            try {
                iArr2[0] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[1] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[4] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[2] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[3] = 5;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public interface c {
        void a(String str);

        void a(String str, InstantException instantException);

        void b(String str);
    }

    public il(gm gmVar) {
        this.a = gmVar;
        NativeAssetManager assetManager = gmVar.c.getAssetManager();
        if (assetManager == null) {
            throw new InstantException("Asset provider for Instant document was null! Contact PSPDFKit support to report this issue.", null);
        }
        this.b = assetManager;
        b bVar = new b();
        this.c = bVar;
        pl plVarA = gmVar.a();
        plVarA.getClass();
        plVarA.d = new WeakReference<>(bVar);
    }

    public final void a(String str) {
        NativeProgressReporterResult nativeProgressReporterResultScheduleDownloadOfAsset;
        uw.a(str, "assetIdentifier", null);
        synchronized (this) {
            nativeProgressReporterResultScheduleDownloadOfAsset = this.a.c.scheduleDownloadOfAsset(str);
        }
        if (nativeProgressReporterResultScheduleDownloadOfAsset.isError()) {
            InstantException instantExceptionA = lr.a(nativeProgressReporterResultScheduleDownloadOfAsset.error());
            if (instantExceptionA.getErrorCode() == InstantErrorCode.ATTACHMENT_ALREADY_TRANSFERRED) {
                this.c.b(str);
            } else if (instantExceptionA.getErrorCode() != InstantErrorCode.ATTACHMENT_TRANSFER_IN_PROGRESS) {
                synchronized (this) {
                    this.d.add(str);
                }
                this.c.a(str, instantExceptionA);
            }
        }
    }

    public class b implements q5 {
        public final go<c> a = new go<>();

        public b() {
        }

        @Override // com.pspdfkit.internal.q5
        public final void a(String str) {
            Iterator<c> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().a(str);
            }
        }

        public final void b(String str) {
            synchronized (il.this) {
                il.this.d.remove(str);
            }
            Iterator<c> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().b(str);
            }
        }

        @Override // com.pspdfkit.internal.q5
        public final void a(NativeAsset nativeAsset) {
            b(nativeAsset.getIdentifier());
        }

        @Override // com.pspdfkit.internal.q5
        public final void a(String str, NativeInstantError nativeInstantError) {
            a(str, lr.a(nativeInstantError));
        }

        public final void a(String str, InstantException instantException) {
            synchronized (il.this) {
                il.this.d.add(str);
            }
            Iterator<c> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().a(str, instantException);
            }
        }
    }

    public static byte[] a(fl flVar) {
        int iA = y30.a(flVar.c);
        if (iA != 0 && iA != 1 && iA != 4) {
            throw new InstantException(InstantErrorCode.ATTACHMENT_NOT_LOADED, "The Instant asset has not been downloaded yet: %s", flVar);
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(flVar.b);
            try {
                byte[] bArrA = wg.a(fileInputStream);
                fileInputStream.close();
                return bArrA;
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException e) {
            throw new InstantException(InstantErrorCode.ATTACHMENT_NOT_LOADED, e, "Could not read backing data for Instant asset: %s", flVar);
        }
    }

    public final synchronized void a() {
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            a((String) it.next());
        }
    }

    public static fl a(NativeAsset nativeAsset) {
        String identifier = nativeAsset.getIdentifier();
        String filePath = nativeAsset.getFilePath();
        nativeAsset.getMimeType();
        NativeAssetLoadState loadState = nativeAsset.getLoadState();
        int i = a.b[loadState.ordinal()];
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                i2 = 3;
                if (i != 3) {
                    i2 = 4;
                    if (i != 4) {
                        i2 = 5;
                        if (i != 5) {
                            throw new IllegalArgumentException("Conversion for NativeAssetLoadState (" + loadState + ") is not implemented");
                        }
                    }
                }
            }
        }
        return new fl(identifier, filePath, i2);
    }
}
