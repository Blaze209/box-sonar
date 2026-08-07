package sdk.pendo.io.e7;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.core.view.GravityCompat;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.h7.s;
import sdk.pendo.io.j7.v;
import sdk.pendo.io.j7.y;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u000b\u0010\fJ(\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\r"}, d2 = {"Lsdk/pendo/io/e7/e;", "Lsdk/pendo/io/e7/h;", "Landroid/widget/ImageView;", "", "id", "view", ViewProps.Z_INDEX, "Lsdk/pendo/io/h7/s;", "privacyConfig", "Lsdk/pendo/io/j7/v;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class e implements h<ImageView> {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            try {
                iArr[ImageView.ScaleType.MATRIX.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ImageView.ScaleType.FIT_START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ImageView.ScaleType.FIT_END.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            a = iArr;
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x007d  */
    /* JADX WARN: Code duplicated, block: B:20:0x009a  */
    /* JADX WARN: Code duplicated, block: B:37:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:49:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:52:0x0202  */
    /* JADX WARN: Code duplicated, block: B:55:0x0206  */
    /* JADX WARN: Code duplicated, block: B:56:0x020f  */
    @Override // sdk.pendo.io.e7.h
    public v a(int id, ImageView view, int zIndex, s privacyConfig) {
        int width;
        int height;
        sdk.pendo.io.j7.o oVar;
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(privacyConfig, "privacyConfig");
        Rect rectB = sdk.pendo.io.b7.j.a.b(view);
        sdk.pendo.io.f7.a aVar = sdk.pendo.io.f7.a.a;
        sdk.pendo.io.j7.c cVarA = sdk.pendo.io.f7.a.a(aVar, id + 1, zIndex, rectB, view, null, 16, null);
        cVarA.b(view.getPaddingStart(), view.getPaddingTop(), view.getPaddingEnd(), view.getPaddingBottom());
        cVarA.b(1);
        cVarA.c(16);
        Bitmap bitmapA = sdk.pendo.io.b7.f.a.a(view, privacyConfig.c(), "ImageView" + view.getClass().getSimpleName());
        if (bitmapA != null) {
            Drawable drawable = view.getDrawable();
            if (drawable != null) {
                Integer numValueOf = Integer.valueOf(drawable.getIntrinsicWidth());
                if (numValueOf.intValue() <= 0) {
                    numValueOf = null;
                }
                if (numValueOf != null) {
                    width = numValueOf.intValue();
                } else {
                    width = bitmapA.getWidth();
                }
            } else {
                width = bitmapA.getWidth();
            }
            if (drawable != null) {
                Integer numValueOf2 = Integer.valueOf(drawable.getIntrinsicHeight());
                if (numValueOf2.intValue() <= 0) {
                    numValueOf2 = null;
                }
                if (numValueOf2 != null) {
                    height = numValueOf2.intValue();
                } else {
                    height = bitmapA.getHeight();
                }
            } else {
                height = bitmapA.getHeight();
            }
            sdk.pendo.io.j7.h hVarA = aVar.a(id + 2, zIndex, (Rect) null, bitmapA, "ImageView" + view.getClass().getSimpleName());
            ImageView.ScaleType scaleType = view.getScaleType();
            switch (scaleType == null ? -1 : b.a[scaleType.ordinal()]) {
                case 1:
                    RectF rectF = new RectF(0.0f, 0.0f, width, height);
                    view.getImageMatrix().mapRect(rectF);
                    hVarA.a(new y(Integer.valueOf((int) rectF.width()), y.a.LENGTH));
                    hVarA.a(new sdk.pendo.io.j7.g(Integer.valueOf((int) rectF.height()), sdk.pendo.io.j7.g.a.LENGTH));
                    hVarA.a((sdk.pendo.io.j7.o) null);
                    if (!view.getCropToPadding() && (view.getPaddingStart() != 0 || view.getPaddingTop() != 0 || view.getPaddingEnd() != 0 || view.getPaddingBottom() != 0)) {
                        hVarA.a(-view.getPaddingStart(), -view.getPaddingTop(), -view.getPaddingEnd(), -view.getPaddingBottom());
                    }
                    ImageView.ScaleType scaleType2 = view.getScaleType();
                    i = scaleType2 != null ? b.a[scaleType2.ordinal()] : -1;
                    if (i != 5) {
                        if (i == 6) {
                            cVarA.b(GravityCompat.END);
                            i2 = 80;
                        }
                        cVarA.a(hVarA);
                    } else {
                        cVarA.b(GravityCompat.START);
                        i2 = 48;
                    }
                    cVarA.c(i2);
                    cVarA.a(hVarA);
                    break;
                case 2:
                    hVarA.a(new y(100, y.a.PERCENT));
                    hVarA.a(new sdk.pendo.io.j7.g(100, sdk.pendo.io.j7.g.a.PERCENT));
                    oVar = new sdk.pendo.io.j7.o(sdk.pendo.io.j7.o.a.COVER);
                    break;
                case 3:
                    hVarA.a(new y(100, y.a.PERCENT));
                    hVarA.a(new sdk.pendo.io.j7.g(100, sdk.pendo.io.j7.g.a.PERCENT));
                    oVar = new sdk.pendo.io.j7.o(sdk.pendo.io.j7.o.a.SCALE_DOWN);
                    break;
                case 4:
                case 5:
                case 6:
                    hVarA.a(new y(100, y.a.PERCENT));
                    hVarA.a(new sdk.pendo.io.j7.g(100, sdk.pendo.io.j7.g.a.PERCENT));
                    oVar = new sdk.pendo.io.j7.o(sdk.pendo.io.j7.o.a.CONTAIN);
                    break;
                case 7:
                    hVarA.a(new y(100, y.a.PERCENT));
                    hVarA.a(new sdk.pendo.io.j7.g(100, sdk.pendo.io.j7.g.a.PERCENT));
                    oVar = new sdk.pendo.io.j7.o(sdk.pendo.io.j7.o.a.FILL);
                    break;
                default:
                    hVarA.a(new y(Integer.valueOf(width), y.a.LENGTH));
                    hVarA.a(new sdk.pendo.io.j7.g(Integer.valueOf(height), sdk.pendo.io.j7.g.a.LENGTH));
                    hVarA.a((sdk.pendo.io.j7.o) null);
                    if (!view.getCropToPadding()) {
                        hVarA.a(-view.getPaddingStart(), -view.getPaddingTop(), -view.getPaddingEnd(), -view.getPaddingBottom());
                    }
                    ImageView.ScaleType scaleType3 = view.getScaleType();
                    if (scaleType3 != null) {
                    }
                    if (i != 5) {
                        if (i == 6) {
                            cVarA.b(GravityCompat.END);
                            i2 = 80;
                        }
                        cVarA.a(hVarA);
                    } else {
                        cVarA.b(GravityCompat.START);
                        i2 = 48;
                    }
                    cVarA.c(i2);
                    cVarA.a(hVarA);
                    break;
            }
            hVarA.a(oVar);
            if (!view.getCropToPadding()) {
                hVarA.a(-view.getPaddingStart(), -view.getPaddingTop(), -view.getPaddingEnd(), -view.getPaddingBottom());
            }
            ImageView.ScaleType scaleType4 = view.getScaleType();
            if (scaleType4 != null) {
            }
            if (i != 5) {
                if (i == 6) {
                    cVarA.b(GravityCompat.END);
                    i2 = 80;
                }
                cVarA.a(hVarA);
            } else {
                cVarA.b(GravityCompat.START);
                i2 = 48;
            }
            cVarA.c(i2);
            cVarA.a(hVarA);
        }
        return cVarA;
    }
}
