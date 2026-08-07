package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import com.pspdfkit.annotations.WidgetAnnotation;
import com.pspdfkit.document.image.BitmapUtils;
import com.pspdfkit.document.image.ImagePicker;
import com.pspdfkit.forms.PushButtonFormElement;
import com.pspdfkit.utils.PdfLog;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;

/* JADX INFO: loaded from: classes3.dex */
public final class rv implements yl.c {
    public final /* synthetic */ sv a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ PushButtonFormElement c;
    public final /* synthetic */ WidgetAnnotation d;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ PushButtonFormElement a;
        public final /* synthetic */ sv b;
        public final /* synthetic */ WidgetAnnotation c;

        public a(PushButtonFormElement pushButtonFormElement, sv svVar, WidgetAnnotation widgetAnnotation) {
            this.a = pushButtonFormElement;
            this.b = svVar;
            this.c = widgetAnnotation;
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Object obj) {
            Bitmap bitmap = (Bitmap) obj;
            bitmap.getClass();
            this.a.setBitmap(bitmap);
            this.b.a.notifyAnnotationHasChanged(this.c);
        }
    }

    public static final class b<T> implements Consumer {
        public static final b<T> a = new b<>();

        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Object obj) {
            Throwable th = (Throwable) obj;
            th.getClass();
            PdfLog.e("Nutri.PdfFragJsPlatDel", th, "Can't import button icon: Bitmap decoding failed.", new Object[0]);
        }
    }

    public rv(sv svVar, Context context, PushButtonFormElement pushButtonFormElement, WidgetAnnotation widgetAnnotation) {
        this.a = svVar;
        this.b = context;
        this.c = pushButtonFormElement;
        this.d = widgetAnnotation;
    }

    public static final void a(Context context, Uri uri) {
        ImagePicker.deleteTemporaryFile(context, uri);
    }

    @Override // com.pspdfkit.internal.yl.c
    public final void onImagePicked(final Uri uri) {
        uri.getClass();
        Single<Bitmap> singleDecodeBitmapAsync = BitmapUtils.decodeBitmapAsync(this.b, uri);
        final Context context = this.b;
        this.a.c.add(singleDecodeBitmapAsync.doFinally(new Action() { // from class: com.pspdfkit.internal.rv$$ExternalSyntheticLambda0
            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() {
                rv.a(context, uri);
            }
        }).subscribe(new a(this.c, this.a, this.d), b.a));
    }

    @Override // com.pspdfkit.internal.yl.c
    public final void onImagePickerCancelled() {
    }

    @Override // com.pspdfkit.internal.yl.c
    public final void onImagePickerUnknownError() {
    }
}
