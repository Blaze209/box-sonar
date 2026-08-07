package external.sdk.pendo.io.glide.load.model;

import android.util.Log;
import external.sdk.pendo.io.glide.load.Options;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes4.dex */
public class StreamEncoder implements sdk.pendo.io.e.d<InputStream> {
    private static final String TAG = "StreamEncoder";
    private final sdk.pendo.io.i.a byteArrayPool;

    public StreamEncoder(sdk.pendo.io.i.a aVar) {
        this.byteArrayPool = aVar;
    }

    @Override // sdk.pendo.io.e.d
    public boolean encode(InputStream inputStream, File file, Options options) throws Throwable {
        FileOutputStream fileOutputStream;
        byte[] bArr = (byte[]) this.byteArrayPool.get(65536, byte[].class);
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
                while (true) {
                    try {
                        int i = inputStream.read(bArr);
                        if (i == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, i);
                    } catch (IOException e) {
                        e = e;
                        fileOutputStream2 = fileOutputStream;
                        if (Log.isLoggable(TAG, 3)) {
                            Log.d(TAG, "Failed to encode data onto the OutputStream", e);
                        }
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (IOException unused) {
                            }
                        }
                        this.byteArrayPool.put(bArr);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        this.byteArrayPool.put(bArr);
                        throw th;
                    }
                }
                fileOutputStream.close();
                try {
                    fileOutputStream.close();
                } catch (IOException unused3) {
                }
                this.byteArrayPool.put(bArr);
                return true;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
        } catch (IOException e2) {
            e = e2;
        }
    }
}
