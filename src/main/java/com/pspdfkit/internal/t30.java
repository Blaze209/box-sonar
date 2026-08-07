package com.pspdfkit.internal;

import android.content.ClipData;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import androidx.media3.common.MimeTypes;
import com.microsoft.intune.mam.client.content.MAMContentResolverManagement;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.StampAnnotation;
import com.pspdfkit.annotations.stamps.StampPickerItem;
import com.pspdfkit.document.sharing.DocumentSharingProvider;
import com.pspdfkit.document.sharing.DocumentSharingProviderProcessor;
import com.pspdfkit.utils.PdfLog;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.io.FileNotFoundException;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class t30 extends e1 {
    public Uri b;
    public Disposable c;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ Annotation b;

        public a(Annotation annotation) {
            this.b = annotation;
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Object obj) {
            Uri uri = (Uri) obj;
            uri.getClass();
            t30.this.b = uri;
            t30.a(this.b, uri);
        }
    }

    public t30(Uri uri) {
        this.b = uri;
    }

    @Override // com.pspdfkit.internal.e1
    public final Annotation a() {
        Annotation annotation = this.a;
        if (annotation != null) {
            return annotation;
        }
        Uri uri = this.b;
        if (uri != null) {
            Context context = n5.a;
            if (context == null) {
                throw new IllegalStateException("The application context should not be null. Please call fun setApplicationContext(context: Context) first");
            }
            try {
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(MAMContentResolverManagement.openInputStream(context.getContentResolver(), uri));
                if (bitmapDecodeStream != null) {
                    this.a = StampPickerItem.fromBitmap(bitmapDecodeStream).build().createStampAnnotation(0);
                }
            } catch (FileNotFoundException unused) {
                PdfLog.i("Nutri.StampAnnotClipSrc", "File for the current imageFileUri was not found and the exception was ignored.This is not an issue; just means the current annotation does not have a bitmap attached to it.", new Object[0]);
            }
        }
        return this.a;
    }

    @Override // com.pspdfkit.internal.e1
    public final boolean b() {
        return super.b() || this.b != null;
    }

    @Override // com.pspdfkit.internal.e1
    public final void c() {
        this.a = null;
        yz.a(this.c);
        this.c = null;
        Uri uri = this.b;
        if (uri != null) {
            Context context = n5.a;
            if (context == null) {
                throw new IllegalStateException("The application context should not be null. Please call fun setApplicationContext(context: Context) first");
            }
            DocumentSharingProvider.deleteFile(context, uri);
        }
        this.b = null;
    }

    @Override // com.pspdfkit.internal.e1
    public final void d() {
        this.a = null;
    }

    @Override // com.pspdfkit.internal.e1
    public final boolean e() {
        Annotation annotationA = a();
        if (annotationA == null || !(annotationA instanceof StampAnnotation)) {
            return false;
        }
        Uri uri = this.b;
        if (uri != null) {
            yz.a(this.c);
            this.c = null;
            a(annotationA, uri);
            return true;
        }
        Context context = n5.a;
        if (context == null) {
            throw new IllegalStateException("The application context should not be null. Please call fun setApplicationContext(context: Context) first");
        }
        Bitmap bitmap = ((StampAnnotation) annotationA).getBitmap();
        if (bitmap == null) {
            return false;
        }
        yz.a(this.c);
        this.c = null;
        Single<Uri> singlePrepareBitmapForSharing = DocumentSharingProviderProcessor.prepareBitmapForSharing(context, bitmap);
        synchronized (ar.class) {
            q10.c();
        }
        Scheduler schedulerIo = Schedulers.io();
        schedulerIo.getClass();
        this.c = singlePrepareBitmapForSharing.subscribeOn(schedulerIo).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(annotationA));
        return true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof t30) {
            return Intrinsics.areEqual(this.b, ((t30) obj).b);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.b);
    }

    public t30(StampAnnotation stampAnnotation) {
        this.a = stampAnnotation;
    }

    public static void a(Annotation annotation, Uri uri) {
        z8.a(new ClipData(annotation.getName(), new String[]{MimeTypes.IMAGE_JPEG}, new ClipData.Item(uri)), null, 0);
    }
}
