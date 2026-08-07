package com.pspdfkit.internal.jni;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Pair;
import com.pspdfkit.document.providers.DataProvider;
import com.pspdfkit.internal.mr;
import com.pspdfkit.internal.u7;
import com.pspdfkit.internal.z7;
import com.pspdfkit.utils.Size;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/pspdfkit/internal/jni/NativeImageFactory;", "", "<init>", "()V", "Companion", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class NativeImageFactory {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int DEFAULT_BUFFER_SIZE = 512000;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0007J$\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u001c\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\u0013\u001a\u00020\u0014H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/pspdfkit/internal/jni/NativeImageFactory$Companion;", "", "<init>", "()V", "DEFAULT_BUFFER_SIZE", "", "fromBitmap", "Landroid/util/Pair;", "Lcom/pspdfkit/internal/jni/NativeImage;", "Lcom/pspdfkit/utils/Size;", "bitmap", "Landroid/graphics/Bitmap;", "quality", "fromUri", "context", "Landroid/content/Context;", "fileUri", "Landroid/net/Uri;", "fromDataProvider", "dataProvider", "Lcom/pspdfkit/document/providers/DataProvider;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final Pair<NativeImage, Size> fromBitmap(Bitmap bitmap, int quality) throws IOException {
            bitmap.getClass();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(NativeImageFactory.DEFAULT_BUFFER_SIZE);
            if (bitmap.hasAlpha()) {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                return new Pair<>(new NativeImage(NativeImageEncoding.PNG, byteArrayOutputStream.toByteArray(), null), new Size(bitmap.getWidth(), bitmap.getHeight()));
            }
            bitmap.compress(Bitmap.CompressFormat.JPEG, quality, byteArrayOutputStream);
            return new Pair<>(new NativeImage(NativeImageEncoding.JPEG, byteArrayOutputStream.toByteArray(), null), new Size(bitmap.getWidth(), bitmap.getHeight()));
        }

        @JvmStatic
        public final Pair<NativeImage, Size> fromDataProvider(DataProvider dataProvider) throws IOException {
            dataProvider.getClass();
            u7 u7VarA = z7.a(dataProvider);
            Bitmap.CompressFormat compressFormat = u7VarA.a;
            compressFormat.getClass();
            return new Pair<>(new NativeImage(mr.a(compressFormat), u7VarA.b, null), new Size(u7VarA.c, u7VarA.d));
        }

        @JvmStatic
        public final Pair<NativeImage, Size> fromUri(Context context, Uri fileUri) throws IOException {
            context.getClass();
            fileUri.getClass();
            u7 u7VarA = z7.a(context, fileUri, true);
            Bitmap.CompressFormat compressFormat = u7VarA.a;
            compressFormat.getClass();
            return new Pair<>(new NativeImage(mr.a(compressFormat), u7VarA.b, null), new Size(u7VarA.c, u7VarA.d));
        }

        private Companion() {
        }
    }

    @JvmStatic
    public static final Pair<NativeImage, Size> fromBitmap(Bitmap bitmap, int i) throws IOException {
        return INSTANCE.fromBitmap(bitmap, i);
    }

    @JvmStatic
    public static final Pair<NativeImage, Size> fromDataProvider(DataProvider dataProvider) {
        return INSTANCE.fromDataProvider(dataProvider);
    }

    @JvmStatic
    public static final Pair<NativeImage, Size> fromUri(Context context, Uri uri) throws IOException {
        return INSTANCE.fromUri(context, uri);
    }
}
