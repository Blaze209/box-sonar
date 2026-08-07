package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.common.MimeTypes;
import com.pspdfkit.document.providers.DataProvider;
import com.pspdfkit.utils.PdfLog;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class w7 {
    public final String a;
    public final int b;
    public final int c;
    public final int d;

    public static final class a {
        @JvmStatic
        public static w7 a(final Context context, final Uri uri) throws IOException {
            context.getClass();
            uri.getClass();
            Function0 function0 = new Function0() { // from class: com.pspdfkit.internal.w7$a$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return w7.a.b(context, uri);
                }
            };
            String string = uri.toString();
            string.getClass();
            return a(function0, string);
        }

        public static final InputStream b(Context context, Uri uri) throws IOException {
            InputStream inputStreamB = wg.b(context, uri);
            inputStreamB.getClass();
            return inputStreamB;
        }

        @JvmStatic
        public static w7 a(final DataProvider dataProvider) throws IOException {
            dataProvider.getClass();
            Function0 function0 = new Function0() { // from class: com.pspdfkit.internal.w7$a$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return w7.a.b(dataProvider);
                }
            };
            String title = dataProvider.getTitle();
            if (title == null) {
                title = dataProvider.toString();
            }
            return a(function0, title);
        }

        public static final InputStream b(DataProvider dataProvider) {
            return new nk(dataProvider);
        }

        public static w7 a(Function0 function0, String str) throws IOException {
            int attributeInt;
            BitmapFactory.Options options = new BitmapFactory.Options();
            int i = 1;
            options.inJustDecodeBounds = true;
            try {
                Closeable closeable = (Closeable) function0.invoke();
                try {
                    BitmapFactory.decodeStream((InputStream) closeable, null, options);
                    CloseableKt.closeFinally(closeable, null);
                    try {
                        if (Intrinsics.areEqual(MimeTypes.IMAGE_JPEG, options.outMimeType)) {
                            try {
                                Closeable closeable2 = (Closeable) function0.invoke();
                                try {
                                    try {
                                        attributeInt = new ExifInterface((InputStream) closeable2).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
                                    } catch (IOException unused) {
                                        attributeInt = 1;
                                    }
                                    i = attributeInt != 0 ? attributeInt : 1;
                                    Unit unit = Unit.INSTANCE;
                                    CloseableKt.closeFinally(closeable2, null);
                                } catch (Throwable th) {
                                    try {
                                        throw th;
                                    } catch (Throwable th2) {
                                        CloseableKt.closeFinally(closeable2, th);
                                        throw th2;
                                    }
                                }
                            } catch (IOException e) {
                                throw new IOException("Could not open image input stream: " + str, e);
                            }
                        }
                    } catch (Throwable th3) {
                        PdfLog.e("Nutri.BitmapInfo", th3, "Can't read exif orientation data", new Object[0]);
                    }
                    return new w7(options.outMimeType, options.outWidth, options.outHeight, i);
                } catch (Throwable th4) {
                    try {
                        throw th4;
                    } catch (Throwable th5) {
                        CloseableKt.closeFinally(closeable, th4);
                        throw th5;
                    }
                }
            } catch (IOException e2) {
                throw new IOException("Could not open image input stream: " + str, e2);
            }
        }
    }

    public w7(String str, int i, int i2, int i3) {
        this.a = str;
        this.b = i;
        this.c = i2;
        this.d = i3;
    }
}
