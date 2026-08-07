package external.sdk.pendo.io.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.util.Log;
import external.sdk.pendo.io.glide.load.Options;
import external.sdk.pendo.io.glide.load.ResourceEncoder;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import sdk.pendo.io.e.g;
import sdk.pendo.io.y.l;

/* JADX INFO: loaded from: classes4.dex */
public class BitmapEncoder implements ResourceEncoder<Bitmap> {
    private static final String TAG = "BitmapEncoder";
    private final sdk.pendo.io.i.a arrayPool;
    public static final g<Integer> COMPRESSION_QUALITY = g.a("external.sdk.pendo.io.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);
    public static final g<Bitmap.CompressFormat> COMPRESSION_FORMAT = g.a("external.sdk.pendo.io.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");

    @Deprecated
    public BitmapEncoder() {
        this.arrayPool = null;
    }

    private Bitmap.CompressFormat getFormat(Bitmap bitmap, Options options) {
        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) options.get(COMPRESSION_FORMAT);
        if (compressFormat != null) {
            return compressFormat;
        }
        return bitmap.hasAlpha() ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG;
    }

    @Override // external.sdk.pendo.io.glide.load.ResourceEncoder
    public sdk.pendo.io.e.c getEncodeStrategy(Options options) {
        return sdk.pendo.io.e.c.TRANSFORMED;
    }

    public BitmapEncoder(sdk.pendo.io.i.a aVar) {
        this.arrayPool = aVar;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0073 A[Catch: all -> 0x00c8, TRY_LEAVE, TryCatch #5 {all -> 0x00c8, blocks: (B:3:0x0023, B:13:0x004e, B:30:0x006d, B:32:0x0073, B:37:0x00c4, B:38:0x00c7, B:28:0x0069), top: B:49:0x0023 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v9 */
    @Override // external.sdk.pendo.io.glide.load.ResourceEncoder, sdk.pendo.io.e.d
    public boolean encode(sdk.pendo.io.h.c<Bitmap> cVar, File file, Options options) {
        OutputStream fileOutputStream;
        Bitmap bitmap = cVar.get();
        Bitmap.CompressFormat format = getFormat(bitmap, options);
        sdk.pendo.io.z.b.a("encode: [%dx%d] %s", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), format);
        try {
            long jA = sdk.pendo.io.y.g.a();
            int iIntValue = ((Integer) options.get(COMPRESSION_QUALITY)).intValue();
            OutputStream aVar = null;
            try {
                try {
                    try {
                        fileOutputStream = new FileOutputStream(file);
                        try {
                            aVar = this.arrayPool != null ? new sdk.pendo.io.f.a(fileOutputStream, this.arrayPool) : fileOutputStream;
                            bitmap.compress(format, iIntValue, aVar);
                            aVar.close();
                            this = 1;
                            aVar.close();
                        } catch (IOException e) {
                            e = e;
                            aVar = fileOutputStream;
                            if (Log.isLoggable(TAG, 3)) {
                                Log.d(TAG, "Failed to encode Bitmap", e);
                            }
                            this = 0;
                            this = 0;
                            if (aVar != null) {
                                aVar.close();
                            }
                            if (Log.isLoggable(TAG, 2)) {
                                Log.v(TAG, "Compressed with type: " + format + " of size " + l.a(bitmap) + " in " + sdk.pendo.io.y.g.a(jA) + ", options format: " + options.get(COMPRESSION_FORMAT) + ", hasAlpha: " + bitmap.hasAlpha());
                            }
                            sdk.pendo.io.z.b.a();
                            return this;
                        } catch (Throwable th) {
                            th = th;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException unused) {
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e2) {
                        e = e2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = aVar;
                }
            } catch (IOException unused2) {
            }
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "Compressed with type: " + format + " of size " + l.a(bitmap) + " in " + sdk.pendo.io.y.g.a(jA) + ", options format: " + options.get(COMPRESSION_FORMAT) + ", hasAlpha: " + bitmap.hasAlpha());
            }
            sdk.pendo.io.z.b.a();
            return this;
        } catch (Throwable th3) {
            sdk.pendo.io.z.b.a();
            throw th3;
        }
    }
}
