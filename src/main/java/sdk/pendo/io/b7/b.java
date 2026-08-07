package sdk.pendo.io.b7;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.Base64;
import android.view.View;
import androidx.media3.exoplayer.upstream.CmcdData;
import java.io.ByteArrayOutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.logging.PendoLogger;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0000\u001a\u0016\u0010\u0002\u001a\u00020\u0005*\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0000\u001a\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¨\u0006\b"}, d2 = {"Landroid/graphics/Bitmap;", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", "quality", "", "Landroid/view/View;", "view", "pendoIO_release"}, k = 2, mv = {1, 9, 0})
public final class b {
    public static final byte[] a(Bitmap bitmap, int i) {
        Intrinsics.checkNotNullParameter(bitmap, "<this>");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.WEBP, i, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
        return byteArray;
    }

    public static /* synthetic */ byte[] a(Bitmap bitmap, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 80;
        }
        return a(bitmap, i);
    }

    public static final String a(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "<this>");
        try {
            return Base64.encodeToString(a(bitmap, 0, 1, null), 2);
        } catch (Exception unused) {
            return null;
        }
    }

    public static final Bitmap a(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        try {
            if (view.getWidth() <= 0 || view.getHeight() <= 0) {
                throw new IllegalArgumentException("View must be laid out".toString());
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(width, height, config)");
            view.draw(new Canvas(bitmapCreateBitmap));
            return bitmapCreateBitmap;
        } catch (Exception e) {
            PendoLogger.d("takeSnapshotOfView: failed to draw view '" + view.getClass().getSimpleName() + "' - " + e.getMessage(), new Object[0]);
            return null;
        }
    }
}
