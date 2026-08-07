package com.box.android.utilities;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.box.android.R;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.domain.metrics.hubs.HubsObservability;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ShortcutHelper.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0007J:\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u000fH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/box/android/utilities/ShortcutHelper;", "", "<init>", "()V", "ADAPTIVE_ICON_CANVAS_SIZE_DP", "", "ADAPTIVE_ICON_DRAW_AREA_DP", "BACKGROUND_COLOR", "createShortcutIcon", "Landroid/graphics/Bitmap;", "context", "Landroid/content/Context;", HubsObservability.HUB_ASSET_ICON, "Landroid/graphics/drawable/Drawable;", "getMatrixForDrawingAtCenter", "Landroid/graphics/Matrix;", "canvasWidth", "canvasHeight", "iconWidth", "iconHeight", "finalIconSize", "matrix", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ShortcutHelper {
    public static final int $stable = 0;
    private static final int ADAPTIVE_ICON_CANVAS_SIZE_DP = 108;
    private static final int ADAPTIVE_ICON_DRAW_AREA_DP = 36;
    private static final int BACKGROUND_COLOR = 2131099825;
    public static final ShortcutHelper INSTANCE = new ShortcutHelper();

    private ShortcutHelper() {
    }

    @JvmStatic
    public static final Bitmap createShortcutIcon(Context context, Drawable icon) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(icon, "icon");
        return createShortcutIcon(context, CommonBoxUtil.drawableToBitmap$default(CommonBoxUtil.INSTANCE, icon, null, null, 6, null));
    }

    @JvmStatic
    public static final Bitmap createShortcutIcon(Context context, Bitmap icon) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(108, 108, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawColor(context.getColor(R.color.dark_blue));
        canvas.drawBitmap(icon, getMatrixForDrawingAtCenter$default(INSTANCE, canvas.getWidth(), canvas.getHeight(), icon.getWidth(), icon.getHeight(), 36, null, 32, null), new Paint(2));
        return bitmapCreateBitmap;
    }

    public static /* synthetic */ Matrix getMatrixForDrawingAtCenter$default(ShortcutHelper shortcutHelper, int i, int i2, int i3, int i4, int i5, Matrix matrix, int i6, Object obj) {
        if ((i6 & 32) != 0) {
            matrix = new Matrix();
        }
        return shortcutHelper.getMatrixForDrawingAtCenter(i, i2, i3, i4, i5, matrix);
    }

    public final Matrix getMatrixForDrawingAtCenter(int canvasWidth, int canvasHeight, int iconWidth, int iconHeight, int finalIconSize, Matrix matrix) {
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        float fMax = finalIconSize / Math.max(iconHeight, iconWidth);
        matrix.postScale(fMax, fMax);
        matrix.postTranslate((canvasWidth - (iconWidth * fMax)) / 2.0f, (canvasHeight - (iconHeight * fMax)) / 2.0f);
        return matrix;
    }
}
