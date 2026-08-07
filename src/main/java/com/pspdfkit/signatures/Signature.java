package com.pspdfkit.signatures;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.InkAnnotation;
import com.pspdfkit.annotations.StampAnnotation;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.internal.ff;
import com.pspdfkit.internal.ip;
import com.pspdfkit.internal.n5;
import com.pspdfkit.internal.q70;
import com.pspdfkit.ui.fonts.Font;
import com.pspdfkit.utils.ParcelExtensions;
import com.pspdfkit.utils.PdfLog;
import com.pspdfkit.utils.Size;
import io.reactivex.rxjava3.exceptions.Exceptions;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.parcelize.Parceler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 72\u00020\u0001:\u000267Bk\b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0006\u0010%\u001a\u00020&J \u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\b\b\u0001\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\nJ \u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\b\b\u0001\u0010+\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u000fJ\u0010\u0010'\u001a\u00020(2\b\b\u0001\u0010+\u001a\u00020\u0005J\u0006\u00100\u001a\u00020\u0005J\u0016\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010.\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b/\u0010 ¨\u00068"}, d2 = {"Lcom/pspdfkit/signatures/Signature;", "Landroid/os/Parcelable;", "id", "", Signature.JSON_KEY_INK_COLOR, "", "lineWidth", "", Signature.JSON_KEY_LINES, "", "Landroid/graphics/PointF;", Signature.JSON_KEY_BIOMETRIC_DATA, "Lcom/pspdfkit/signatures/BiometricSignatureData;", Signature.JSON_KEY_DRAW_WIDTH_RATIO, Signature.JSON_KEY_STAMP_RECT, "Landroid/graphics/RectF;", Signature.JSON_KEY_BITMAP, "Landroid/graphics/Bitmap;", "<init>", "(JIFLjava/util/List;Lcom/pspdfkit/signatures/BiometricSignatureData;FLandroid/graphics/RectF;Landroid/graphics/Bitmap;)V", "getId", "()J", "getInkColor", "()I", "getLineWidth", "()F", "getLines", "()Ljava/util/List;", "getBiometricData", "()Lcom/pspdfkit/signatures/BiometricSignatureData;", "getDrawWidthRatio", "getStampRect", "()Landroid/graphics/RectF;", "getBitmap", "()Landroid/graphics/Bitmap;", "bitmapUri", "Landroid/net/Uri;", "toJson", "Lorg/json/JSONObject;", "toAnnotation", "Lcom/pspdfkit/annotations/Annotation;", "document", "Lcom/pspdfkit/document/PdfDocument;", "pageIndex", "touchPoint", "targetRect", "boundingBox", "getBoundingBox", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "HorizontalInset", "Companion", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class Signature implements Parcelable {
    public static final long ID_NOT_SET = -1;
    private static final String JSON_KEY_BIOMETRIC_DATA = "biometricData";
    private static final String JSON_KEY_BITMAP = "bitmap";
    private static final String JSON_KEY_DRAW_WIDTH_RATIO = "drawWidthRatio";
    private static final String JSON_KEY_INK_COLOR = "inkColor";
    private static final String JSON_KEY_LINES = "lines";
    private static final String JSON_KEY_LINE_WIDTH_PDF = "lineWidthPdf";
    private static final String JSON_KEY_STAMP_RECT = "stampRect";
    private static final String JSON_KEY_X = "x";
    private static final String JSON_KEY_Y = "y";
    private static final float MIN_SIGNATURE_ANNOTATION_PDF_SIZE = 32.0f;
    private final BiometricSignatureData biometricData;
    private final Bitmap bitmap;
    private Uri bitmapUri;
    private final float drawWidthRatio;
    private final long id;
    private final int inkColor;
    private final float lineWidth;
    private final List<List<PointF>> lines;
    private final RectF stampRect;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<Signature> CREATOR = new Creator();
    public static final int $stable = 8;

    @Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016JB\u0010\u0010\u001a\u00020\u00022\b\b\u0001\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u000f2\u0012\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u000fJ,\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u000fJ\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\u000e\u0010*\u001a\u00020\u00022\u0006\u0010+\u001a\u00020,J\u0016\u0010*\u001a\u00020\u00022\u0006\u0010-\u001a\u00020\r2\u0006\u0010+\u001a\u00020,J2\u0010.\u001a\u00020\u001b2\u0006\u0010/\u001a\u00020!2\u0006\u00100\u001a\u0002012\b\b\u0001\u00102\u001a\u00020\n2\b\b\u0001\u00103\u001a\u00020\u000f2\u0006\u00104\u001a\u000205J\u0010\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u001bH\u0002R\u000e\u0010\f\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020!X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020!X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020!X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020!X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020!X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020!X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020!X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020!X\u0082T¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/pspdfkit/signatures/Signature$Companion;", "Lkotlinx/parcelize/Parceler;", "Lcom/pspdfkit/signatures/Signature;", "<init>", "()V", "write", "", "parcel", "Landroid/os/Parcel;", "flags", "", PasskeyWebListener.CREATE_UNIQUE_KEY, "ID_NOT_SET", "", "MIN_SIGNATURE_ANNOTATION_PDF_SIZE", "", "createInkSignature", Signature.JSON_KEY_INK_COLOR, Signature.JSON_KEY_LINE_WIDTH_PDF, Signature.JSON_KEY_LINES, "", "Landroid/graphics/PointF;", "biometricSignatureData", "Lcom/pspdfkit/signatures/BiometricSignatureData;", Signature.JSON_KEY_DRAW_WIDTH_RATIO, "createStampSignature", Signature.JSON_KEY_BITMAP, "Landroid/graphics/Bitmap;", Signature.JSON_KEY_STAMP_RECT, "Landroid/graphics/RectF;", "generateCacheUriForBitmap", "Landroid/net/Uri;", "JSON_KEY_INK_COLOR", "", "JSON_KEY_LINE_WIDTH_PDF", "JSON_KEY_LINES", "JSON_KEY_X", "JSON_KEY_Y", "JSON_KEY_BIOMETRIC_DATA", "JSON_KEY_DRAW_WIDTH_RATIO", "JSON_KEY_BITMAP", "JSON_KEY_STAMP_RECT", "fromJson", "signatureJson", "Lorg/json/JSONObject;", "id", "textToBitmap", "text", "font", "Lcom/pspdfkit/ui/fonts/Font;", "color", "scaleFactor", "displayMetrics", "Landroid/util/DisplayMetrics;", "detectHorizontalImageInset", "Lcom/pspdfkit/signatures/Signature$HorizontalInset;", "image", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion implements Parceler<Signature> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Signature createInkSignature$default(Companion companion, int i, float f, List list, BiometricSignatureData biometricSignatureData, float f2, int i2, Object obj) {
            if ((i2 & 8) != 0) {
                biometricSignatureData = null;
            }
            BiometricSignatureData biometricSignatureData2 = biometricSignatureData;
            if ((i2 & 16) != 0) {
                f2 = 1.0f;
            }
            return companion.createInkSignature(i, f, list, biometricSignatureData2, f2);
        }

        public static /* synthetic */ Signature createStampSignature$default(Companion companion, Bitmap bitmap, RectF rectF, BiometricSignatureData biometricSignatureData, float f, int i, Object obj) {
            if ((i & 4) != 0) {
                biometricSignatureData = null;
            }
            if ((i & 8) != 0) {
                f = 1.0f;
            }
            return companion.createStampSignature(bitmap, rectF, biometricSignatureData, f);
        }

        private final HorizontalInset detectHorizontalImageInset(Bitmap image) {
            int width = image.getWidth();
            int height = image.getHeight();
            int[] iArr = new int[width * height];
            image.getPixels(iArr, 0, width, 0, 0, width, height);
            int i = width / 2;
            int i2 = 0;
            int i3 = 0;
            boolean z = false;
            boolean z2 = false;
            for (int i4 = 0; i4 < i; i4++) {
                for (int i5 = 0; i5 < height && (!z || !z2); i5++) {
                    if (!z && iArr[(i5 * width) + i4] != 0) {
                        i2 = i4;
                        z = true;
                    }
                    if (!z2 && iArr[(((i5 + 1) * width) - i4) - 1] != 0) {
                        i3 = i4;
                        z2 = true;
                    }
                }
                if (z && z2) {
                    break;
                }
            }
            int[] iArr2 = {i2, i3};
            int i6 = Integer.MAX_VALUE;
            for (int i7 = 0; i7 < 2; i7++) {
                int i8 = iArr2[i7];
                if (i8 < i6) {
                    i6 = i8;
                }
            }
            int i9 = i6 / 4;
            return new HorizontalInset(ip.a(0, i2 - i9), ip.a(0, i3 - i9));
        }

        private final Uri generateCacheUriForBitmap(Bitmap bitmap) {
            if (bitmap == null) {
                return null;
            }
            Context context = n5.a;
            if (context == null) {
                throw new IllegalStateException("The application context should not be null. Please call fun setApplicationContext(context: Context) first");
            }
            String absolutePath = context.getCacheDir().getAbsolutePath();
            q70.a();
            String string = UUID.randomUUID().toString();
            string.getClass();
            return Uri.parse(absolutePath + File.separator + string);
        }

        public final Signature createInkSignature(int inkColor, float lineWidthPdf, List<? extends List<? extends PointF>> lines, BiometricSignatureData biometricSignatureData, float drawWidthRatio) {
            lines.getClass();
            return new Signature(new Random().nextLong(), inkColor, lineWidthPdf, lines, biometricSignatureData, drawWidthRatio, null, null, 192, null);
        }

        public final Signature createStampSignature(Bitmap bitmap, RectF stampRect, BiometricSignatureData biometricSignatureData, float drawWidthRatio) {
            bitmap.getClass();
            stampRect.getClass();
            return new Signature(new Random().nextLong(), 0, 0.0f, null, biometricSignatureData, drawWidthRatio, stampRect, bitmap, 14, null);
        }

        public final Signature fromJson(JSONObject signatureJson) throws JSONException {
            signatureJson.getClass();
            return fromJson(-1L, signatureJson);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlinx.parcelize.Parceler
        public /* bridge */ Signature[] newArray(int i) {
            return (Signature[]) Parceler.DefaultImpls.newArray(this, i);
        }

        public final Bitmap textToBitmap(String text, Font font, int color, float scaleFactor, DisplayMetrics displayMetrics) {
            text.getClass();
            font.getClass();
            displayMetrics.getClass();
            if (scaleFactor <= 0.0f) {
                throw new IllegalArgumentException(("scaleFactor must be a positive value, it was: " + scaleFactor).toString());
            }
            if (font.getDefaultTypeface() == null) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                throw new IllegalArgumentException(String.format("Font %s is not available on this device.", Arrays.copyOf(new Object[]{font.getName()}, 1)).toString());
            }
            Paint paint = new Paint(2);
            paint.setTypeface(font.getDefaultTypeface());
            paint.setColor(color);
            paint.setTextSize(TypedValue.applyDimension(3, 100.0f, displayMetrics) * scaleFactor);
            paint.setAntiAlias(true);
            Paint.FontMetrics fontMetrics = paint.getFontMetrics();
            float f = -fontMetrics.ascent;
            String str = " " + text + " ";
            int iMeasureText = (int) paint.measureText(str);
            int i = (int) (fontMetrics.descent + f);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMeasureText, i, Bitmap.Config.ARGB_8888);
            new Canvas(bitmapCreateBitmap).drawText(str, 0.0f, f, paint);
            HorizontalInset horizontalInsetDetectHorizontalImageInset = detectHorizontalImageInset(bitmapCreateBitmap);
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(bitmapCreateBitmap, horizontalInsetDetectHorizontalImageInset.getInsetLeft(), 0, iMeasureText - horizontalInsetDetectHorizontalImageInset.getTotalInset(), i);
            bitmapCreateBitmap2.getClass();
            return bitmapCreateBitmap2;
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlinx.parcelize.Parceler
        public Signature create(Parcel parcel) {
            Bitmap bitmapDecodeFile;
            String path;
            parcel.getClass();
            long j = parcel.readLong();
            int i = parcel.readInt();
            float f = parcel.readFloat();
            int i2 = parcel.readInt();
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < i2; i3++) {
                int i4 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList();
                for (int i5 = 0; i5 < i4; i5++) {
                    arrayList2.add(new PointF(parcel.readFloat(), parcel.readFloat()));
                }
                arrayList.add(arrayList2);
            }
            BiometricSignatureData biometricSignatureData = (BiometricSignatureData) ParcelExtensions.readSupportParcelable(parcel, BiometricSignatureData.class.getClassLoader(), BiometricSignatureData.class);
            float f2 = parcel.readFloat();
            Uri uri = (Uri) ParcelExtensions.readSupportParcelable(parcel, Uri.class.getClassLoader(), Uri.class);
            if (uri == null || (path = uri.getPath()) == null) {
                bitmapDecodeFile = null;
            } else {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                bitmapDecodeFile = BitmapFactory.decodeFile(path, options);
                new File(path).delete();
            }
            return new Signature(j, i, f, arrayList, biometricSignatureData, f2, (RectF) ParcelExtensions.readSupportParcelable(parcel, RectF.class.getClassLoader(), RectF.class), bitmapDecodeFile, null);
        }

        public final Signature fromJson(long id, JSONObject signatureJson) throws JSONException {
            ArrayList arrayList;
            List<Long> listNormalizeTimePoints;
            ArrayList arrayList2;
            JSONArray jSONArray;
            signatureJson.getClass();
            JSONObject jSONObjectOptJSONObject = signatureJson.optJSONObject(Signature.JSON_KEY_BIOMETRIC_DATA);
            BiometricSignatureData biometricSignatureData = null;
            if (jSONObjectOptJSONObject != null) {
                try {
                    if (!jSONObjectOptJSONObject.has("pressurePoints") || (jSONArray = jSONObjectOptJSONObject.getJSONArray("pressurePoints")) == null) {
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList(jSONArray.length());
                        for (int i = 0; i < jSONArray.length(); i++) {
                            arrayList.add(Float.valueOf((float) jSONArray.getDouble(i)));
                        }
                    }
                    if (jSONObjectOptJSONObject.has("timePoints")) {
                        BiometricSignatureData.Companion companion = BiometricSignatureData.INSTANCE;
                        JSONArray jSONArray2 = jSONObjectOptJSONObject.getJSONArray("timePoints");
                        if (jSONArray2 == null) {
                            arrayList2 = null;
                        } else {
                            arrayList2 = new ArrayList(jSONArray2.length());
                            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                                arrayList2.add(Long.valueOf(jSONArray2.getLong(i2)));
                            }
                        }
                        listNormalizeTimePoints = companion.normalizeTimePoints(arrayList2);
                    } else {
                        listNormalizeTimePoints = null;
                    }
                    biometricSignatureData = new BiometricSignatureData(arrayList, listNormalizeTimePoints, jSONObjectOptJSONObject.has("touchRadius") ? Float.valueOf((float) jSONObjectOptJSONObject.getDouble("touchRadius")) : null, jSONObjectOptJSONObject.has("inputMethod") ? BiometricSignatureData.InputMethod.valueOf(jSONObjectOptJSONObject.getString("inputMethod")) : null);
                } catch (JSONException e) {
                    PdfLog.e("Nutri.BioSignDatJsonSer", e, "Error while deserializing biometric signature data.", new Object[0]);
                    throw Exceptions.propagate(e);
                }
            }
            float fOptDouble = (float) signatureJson.optDouble(Signature.JSON_KEY_DRAW_WIDTH_RATIO, 1.0d);
            if (signatureJson.has(Signature.JSON_KEY_BITMAP)) {
                Bitmap bitmapA = ff.a(signatureJson.getString(Signature.JSON_KEY_BITMAP));
                bitmapA.getClass();
                JSONArray jSONArray3 = signatureJson.getJSONArray(Signature.JSON_KEY_STAMP_RECT);
                return new Signature(id, 0, 0.0f, null, biometricSignatureData, fOptDouble, new RectF((float) jSONArray3.getDouble(0), (float) jSONArray3.getDouble(1), (float) jSONArray3.getDouble(2), (float) jSONArray3.getDouble(3)), bitmapA, 14, null);
            }
            int i3 = signatureJson.getInt(Signature.JSON_KEY_INK_COLOR);
            float f = (float) signatureJson.getDouble(Signature.JSON_KEY_LINE_WIDTH_PDF);
            int i4 = 0;
            ArrayList arrayList3 = new ArrayList();
            JSONArray jSONArray4 = signatureJson.getJSONArray(Signature.JSON_KEY_LINES);
            int length = jSONArray4.length();
            int i5 = 0;
            while (i5 < length) {
                ArrayList arrayList4 = new ArrayList();
                JSONArray jSONArray5 = jSONArray4.getJSONArray(i5);
                int length2 = jSONArray5.length();
                int i6 = i4;
                while (i6 < length2) {
                    JSONObject jSONObject = jSONArray5.getJSONObject(i6);
                    arrayList4.add(new PointF((float) jSONObject.getDouble("x"), (float) jSONObject.getDouble("y")));
                    i6++;
                    length = length;
                }
                arrayList3.add(arrayList4);
                i5++;
                i4 = 0;
            }
            return new Signature(id, i3, f, arrayList3, biometricSignatureData, fOptDouble, null, null, 192, null);
        }

        @Override // kotlinx.parcelize.Parceler
        public void write(Signature signature, Parcel parcel, int i) throws IOException {
            String path;
            signature.getClass();
            parcel.getClass();
            parcel.writeLong(signature.getId());
            parcel.writeInt(signature.getInkColor());
            parcel.writeFloat(signature.getLineWidth());
            parcel.writeInt(signature.getLines().size());
            for (List<PointF> list : signature.getLines()) {
                parcel.writeInt(list.size());
                for (PointF pointF : list) {
                    parcel.writeFloat(pointF.x);
                    parcel.writeFloat(pointF.y);
                }
            }
            parcel.writeParcelable(signature.getBiometricData(), i);
            parcel.writeFloat(signature.getDrawWidthRatio());
            signature.bitmapUri = generateCacheUriForBitmap(signature.getBitmap());
            Uri uri = signature.bitmapUri;
            if (uri != null) {
                parcel.writeParcelable(uri, i);
                Bitmap bitmap = signature.getBitmap();
                if (bitmap != null && (path = uri.getPath()) != null) {
                    FileOutputStream fileOutputStream = new FileOutputStream(new File(path));
                    try {
                        bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                        CloseableKt.closeFinally(fileOutputStream, null);
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            CloseableKt.closeFinally(fileOutputStream, th);
                            throw th2;
                        }
                    }
                }
            }
            parcel.writeParcelable(signature.getStampRect(), i);
        }
    }

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<Signature> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Signature createFromParcel(Parcel parcel) {
            parcel.getClass();
            return Signature.INSTANCE.create(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Signature[] newArray(int i) {
            return new Signature[i];
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\n\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/pspdfkit/signatures/Signature$HorizontalInset;", "", "insetLeft", "", "insetRight", "<init>", "(II)V", "getInsetLeft", "()I", "getInsetRight", "totalInset", "getTotalInset", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "toString", "", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class HorizontalInset {
        private final int insetLeft;
        private final int insetRight;

        public HorizontalInset(int i, int i2) {
            this.insetLeft = i;
            this.insetRight = i2;
        }

        public static /* synthetic */ HorizontalInset copy$default(HorizontalInset horizontalInset, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = horizontalInset.insetLeft;
            }
            if ((i3 & 2) != 0) {
                i2 = horizontalInset.insetRight;
            }
            return horizontalInset.copy(i, i2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getInsetLeft() {
            return this.insetLeft;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getInsetRight() {
            return this.insetRight;
        }

        public final HorizontalInset copy(int insetLeft, int insetRight) {
            return new HorizontalInset(insetLeft, insetRight);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof HorizontalInset)) {
                return false;
            }
            HorizontalInset horizontalInset = (HorizontalInset) other;
            return this.insetLeft == horizontalInset.insetLeft && this.insetRight == horizontalInset.insetRight;
        }

        public final int getInsetLeft() {
            return this.insetLeft;
        }

        public final int getInsetRight() {
            return this.insetRight;
        }

        public final int getTotalInset() {
            return this.insetLeft + this.insetRight;
        }

        public int hashCode() {
            return Integer.hashCode(this.insetRight) + (Integer.hashCode(this.insetLeft) * 31);
        }

        public String toString() {
            return "HorizontalInset(insetLeft=" + this.insetLeft + ", insetRight=" + this.insetRight + ")";
        }
    }

    public /* synthetic */ Signature(long j, int i, float f, List list, BiometricSignatureData biometricSignatureData, float f2, RectF rectF, Bitmap bitmap, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, i, f, list, biometricSignatureData, f2, rectF, bitmap);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final BiometricSignatureData getBiometricData() {
        return this.biometricData;
    }

    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    public final RectF getBoundingBox() {
        RectF rectF;
        if (this.bitmap != null) {
            RectF rectF2 = this.stampRect;
            if (rectF2 != null) {
                return rectF2;
            }
            throw new IllegalStateException("Stamp rect not set on stamp signature.");
        }
        List<List<PointF>> list = this.lines;
        list.getClass();
        if (list.isEmpty()) {
            rectF = new RectF();
        } else {
            Iterator<List<PointF>> it = list.iterator();
            float f = 0.0f;
            float f2 = 0.0f;
            while (it.hasNext()) {
                for (PointF pointF : it.next()) {
                    float f3 = pointF.x;
                    if (f3 > f2) {
                        f2 = f3;
                    }
                    float f4 = pointF.y;
                    if (f4 > f) {
                        f = f4;
                    }
                }
            }
            rectF = new RectF(0.0f, f, f2, 0.0f);
        }
        if (rectF.width() == 0.0f) {
            rectF.right = 1.0f;
        }
        if (rectF.height() == 0.0f) {
            rectF.top = 1.0f;
        }
        float f5 = rectF.top;
        float f6 = this.lineWidth / 2.0f;
        rectF.top = f5 + f6;
        rectF.right = f6 + rectF.right;
        return rectF;
    }

    public final float getDrawWidthRatio() {
        return this.drawWidthRatio;
    }

    public final long getId() {
        return this.id;
    }

    public final int getInkColor() {
        return this.inkColor;
    }

    public final float getLineWidth() {
        return this.lineWidth;
    }

    public final List<List<PointF>> getLines() {
        return this.lines;
    }

    public final RectF getStampRect() {
        return this.stampRect;
    }

    public final Annotation toAnnotation(PdfDocument document, int pageIndex, PointF touchPoint) {
        float f;
        float fMax;
        float fMax2;
        document.getClass();
        touchPoint.getClass();
        Size pageSize = document.getPageSize(pageIndex);
        pageSize.getClass();
        RectF boundingBox = getBoundingBox();
        float f2 = (document.getPageSize(pageIndex).width / 4) * this.drawWidthRatio;
        float fWidth = boundingBox.width();
        float f3 = -boundingBox.height();
        if (fWidth > f3) {
            f = (f2 / fWidth) * f3;
        } else {
            float f4 = (f2 / f3) * fWidth;
            f = f2;
            f2 = f4;
        }
        if (f2 < f) {
            float f5 = f / f2;
            fMax2 = Math.max(MIN_SIGNATURE_ANNOTATION_PDF_SIZE, Math.min(f2, pageSize.width));
            fMax = f5 * fMax2;
        } else {
            float f6 = f2 / f;
            fMax = Math.max(MIN_SIGNATURE_ANNOTATION_PDF_SIZE, Math.min(f, pageSize.height));
            fMax2 = f6 * fMax;
        }
        float f7 = touchPoint.x;
        float f8 = touchPoint.y;
        float f9 = fMax2 / 2.0f;
        float f10 = fMax / 2.0f;
        RectF rectF = new RectF(f7 - f9, f8 + f10, f7 + f9, f8 - f10);
        ff.a(rectF, new RectF(0.0f, pageSize.height, pageSize.width, 0.0f));
        Annotation annotation = toAnnotation(pageIndex);
        annotation.updateTransformationProperties(rectF, boundingBox);
        annotation.setBoundingBox(rectF);
        return annotation;
    }

    public final JSONObject toJson() throws JSONException {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        JSONObject jSONObject = new JSONObject();
        if (this.bitmap == null) {
            jSONObject.put(JSON_KEY_INK_COLOR, this.inkColor);
            jSONObject.put(JSON_KEY_LINE_WIDTH_PDF, this.lineWidth);
            JSONArray jSONArray3 = new JSONArray();
            for (List<PointF> list : this.lines) {
                JSONArray jSONArray4 = new JSONArray();
                for (PointF pointF : list) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("x", pointF.x);
                    jSONObject2.put("y", pointF.y);
                    jSONArray4.put(jSONObject2);
                }
                jSONArray3.put(jSONArray4);
            }
            jSONObject.put(JSON_KEY_LINES, jSONArray3);
        } else {
            RectF boundingBox = getBoundingBox();
            jSONObject.put(JSON_KEY_STAMP_RECT, new JSONArray(new float[]{boundingBox.left, boundingBox.top, boundingBox.right, boundingBox.bottom}));
            Bitmap bitmap = (Bitmap) Objects.requireNonNull(this.bitmap);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            jSONObject.put(JSON_KEY_BITMAP, Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0));
        }
        jSONObject.put(JSON_KEY_DRAW_WIDTH_RATIO, this.drawWidthRatio);
        BiometricSignatureData biometricSignatureData = this.biometricData;
        Object obj = null;
        if (biometricSignatureData != null) {
            JSONObject jSONObject3 = new JSONObject();
            try {
                List<Float> pressurePoints = biometricSignatureData.getPressurePoints();
                if (pressurePoints == null) {
                    jSONArray = null;
                } else {
                    jSONArray = new JSONArray();
                    Iterator<Float> it = pressurePoints.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(it.next());
                    }
                }
                jSONObject3.put("pressurePoints", jSONArray);
                List<Long> timePoints = biometricSignatureData.getTimePoints();
                if (timePoints == null) {
                    jSONArray2 = null;
                } else {
                    jSONArray2 = new JSONArray();
                    Iterator<Long> it2 = timePoints.iterator();
                    while (it2.hasNext()) {
                        jSONArray2.put(it2.next());
                    }
                }
                jSONObject3.put("timePoints", jSONArray2);
                jSONObject3.put("inputMethod", biometricSignatureData.getInputMethod() != null ? biometricSignatureData.getInputMethod().name() : null);
                jSONObject3.put("touchRadius", biometricSignatureData.getTouchRadius());
                obj = jSONObject3;
            } catch (JSONException e) {
                PdfLog.e("Nutri.BioSignDatJsonSer", e, "Error while serializing biometric signature data.", new Object[0]);
                throw Exceptions.propagate(e);
            }
        }
        jSONObject.put(JSON_KEY_BIOMETRIC_DATA, obj);
        return jSONObject;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) throws IOException {
        dest.getClass();
        INSTANCE.write(this, dest, flags);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Signature(long j, int i, float f, List<? extends List<? extends PointF>> list, BiometricSignatureData biometricSignatureData, float f2, RectF rectF, Bitmap bitmap) {
        this.id = j;
        this.inkColor = i;
        this.lineWidth = f;
        this.lines = list;
        this.biometricData = biometricSignatureData;
        this.drawWidthRatio = f2;
        this.stampRect = rectF;
        this.bitmap = bitmap;
        if (bitmap != null) {
            if (rectF == null) {
                throw new IllegalArgumentException("Stamp rect cannot be null for signature with a bitmap.");
            }
            if (!list.isEmpty()) {
                throw new IllegalArgumentException("Ink lines should not be set for signature with a bitmap.");
            }
        } else if (list.isEmpty()) {
            throw new IllegalArgumentException("Ink lines cannot be empty for signature without a bitmap.");
        }
        if (list.isEmpty()) {
            if (bitmap == null) {
                throw new IllegalArgumentException("Bitmap must be set when not using ink lines for signature.");
            }
        } else {
            if (bitmap != null) {
                throw new IllegalArgumentException("No bitmap required for signature with ink lines.");
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final Annotation toAnnotation(int pageIndex) {
        Annotation stampAnnotation;
        Bitmap bitmap = this.bitmap;
        if (bitmap != null) {
            stampAnnotation = new StampAnnotation(pageIndex, getBoundingBox(), bitmap);
        } else {
            InkAnnotation inkAnnotation = new InkAnnotation(pageIndex);
            inkAnnotation.setLines(this.lines);
            inkAnnotation.setColor(this.inkColor);
            inkAnnotation.setLineWidth(this.lineWidth);
            stampAnnotation = inkAnnotation;
        }
        stampAnnotation.getInternal().setIsSignature(true);
        return stampAnnotation;
    }

    public /* synthetic */ Signature(long j, int i, float f, List list, BiometricSignatureData biometricSignatureData, float f2, RectF rectF, Bitmap bitmap, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? -1L : j, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? 0.0f : f, (i2 & 8) != 0 ? CollectionsKt.emptyList() : list, (i2 & 16) != 0 ? null : biometricSignatureData, (i2 & 32) != 0 ? 1.0f : f2, (i2 & 64) != 0 ? null : rectF, (i2 & 128) != 0 ? null : bitmap);
    }

    public final Annotation toAnnotation(PdfDocument document, int pageIndex, RectF targetRect) {
        document.getClass();
        targetRect.getClass();
        Annotation annotation = toAnnotation(document, pageIndex, new PointF(targetRect.centerX(), targetRect.centerY()));
        RectF boundingBox = annotation.getBoundingBox();
        float fWidth = boundingBox.width();
        float f = -boundingBox.height();
        float fWidth2 = targetRect.width();
        float f2 = -targetRect.height();
        float f3 = fWidth / f >= fWidth2 / f2 ? fWidth2 / fWidth : f2 / f;
        float f4 = fWidth * f3;
        float f5 = f * f3;
        float f6 = ((fWidth2 - f4) / 2.0f) + targetRect.left;
        float f7 = targetRect.top - ((f2 - f5) / 2.0f);
        RectF rectF = new RectF(f6, f7, f4 + f6, f7 - f5);
        annotation.updateTransformationProperties(rectF, annotation.getBoundingBox());
        annotation.setBoundingBox(rectF);
        return annotation;
    }
}
