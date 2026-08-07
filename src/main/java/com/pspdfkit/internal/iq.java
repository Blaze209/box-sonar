package com.pspdfkit.internal;

import android.content.Context;
import android.net.Uri;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.observability.DiagnosisParams;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.LinkAnnotation;
import com.pspdfkit.annotations.MediaAnnotation;
import com.pspdfkit.annotations.actions.Action;
import com.pspdfkit.annotations.actions.MediaOptions;
import com.pspdfkit.annotations.actions.UriAction;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.media.AssetsContentProvider;
import com.pspdfkit.media.MediaLinkUtils;
import com.pspdfkit.media.MediaUri;
import com.pspdfkit.utils.PdfLog;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.io.File;
import java.util.EnumSet;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class iq {
    public final Annotation a;
    public final int b;
    public final boolean e;
    public final boolean f;
    public final int g;
    public final String h;
    public final AtomicReference<Uri> c = new AtomicReference<>(null);
    public final AtomicBoolean d = new AtomicBoolean(false);
    public boolean i = false;

    public iq(Annotation annotation, int i, boolean z, boolean z2, String str, String str2) {
        int i2;
        this.a = annotation;
        this.b = i;
        this.e = z;
        this.f = z2;
        if (BoxAnalyticsParams.CTA_PAGE_PREVIEW.equalsIgnoreCase(str)) {
            i2 = 1;
        } else if ("image".equalsIgnoreCase(str)) {
            i2 = 2;
        } else if (DiagnosisParams.CLEAR_ON_LOGOUT.equalsIgnoreCase(str)) {
            i2 = 3;
        } else {
            "none".equalsIgnoreCase(str);
            i2 = 4;
        }
        this.g = i2;
        this.h = str2;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0047  */
    public static iq a(Annotation annotation) {
        MediaUri mediaUri;
        String uri;
        if (annotation instanceof MediaAnnotation) {
            EnumSet<MediaOptions> mediaOptions = ((MediaAnnotation) annotation).getMediaOptions();
            return new iq(annotation, 1, mediaOptions.contains(MediaOptions.AUTO_PLAY), mediaOptions.contains(MediaOptions.CONTROLS_ENABLED), null, null);
        }
        if (annotation instanceof LinkAnnotation) {
            Action action = ((LinkAnnotation) annotation).getAction();
            if (!(action instanceof UriAction) || (uri = ((UriAction) action).getUri()) == null) {
                mediaUri = null;
            } else {
                mediaUri = MediaUri.parse(uri);
                if (mediaUri.getType() != MediaUri.UriType.MEDIA) {
                    mediaUri = null;
                }
            }
            if (mediaUri != null) {
                MediaLinkUtils.VideoSettings videoSettingsFromOptions = mediaUri.getVideoSettingsFromOptions();
                return new iq(annotation, 2, videoSettingsFromOptions.autoplay, true, videoSettingsFromOptions.coverMode, videoSettingsFromOptions.coverImage);
            }
        }
        return null;
    }

    public final /* synthetic */ void b() throws Throwable {
        if (this.d.get()) {
            a();
        }
    }

    public final /* synthetic */ Uri b(Context context) throws Exception {
        File file = new File(this.h);
        if (file.exists()) {
            return Uri.fromFile(file);
        }
        if (!this.h.startsWith("file:///android_asset/") && !this.h.startsWith("localhost/")) {
            return Uri.parse(this.h);
        }
        return AssetsContentProvider.getAuthority(context).buildUpon().appendPath(this.h.replace("file:///android_asset/", "").replace("localhost/", "")).build();
    }

    public final Single a(final Context context, final lm lmVar) {
        Single map = Single.just(this.a).cast(LinkAnnotation.class).map(new Function() { // from class: com.pspdfkit.internal.iq$$ExternalSyntheticLambda0
            @Override // io.reactivex.rxjava3.functions.Function
            public final Object apply(Object obj) {
                return iq.a(context, lmVar, (LinkAnnotation) obj);
            }
        });
        final AtomicReference<Uri> atomicReference = this.c;
        Objects.requireNonNull(atomicReference);
        return map.doOnSuccess(new Consumer() { // from class: com.pspdfkit.internal.iq$$ExternalSyntheticLambda1
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) {
                atomicReference.set((Uri) obj);
            }
        }).doAfterTerminate(new io.reactivex.rxjava3.functions.Action() { // from class: com.pspdfkit.internal.iq$$ExternalSyntheticLambda2
            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() throws Throwable {
                this.f$0.b();
            }
        }).subscribeOn(Schedulers.io());
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0028  */
    public static Uri a(Context context, PdfDocument pdfDocument, LinkAnnotation linkAnnotation) throws Throwable {
        MediaUri mediaUri;
        String uri;
        if (linkAnnotation instanceof MediaAnnotation) {
            return ((MediaAnnotation) linkAnnotation).getFileUri(context, pdfDocument);
        }
        Action action = linkAnnotation.getAction();
        if (!(action instanceof UriAction) || (uri = ((UriAction) action).getUri()) == null) {
            mediaUri = null;
        } else {
            mediaUri = MediaUri.parse(uri);
            if (mediaUri.getType() != MediaUri.UriType.MEDIA) {
                mediaUri = null;
            }
        }
        return mediaUri != null ? mediaUri.getFileUri(context) : Uri.EMPTY;
    }

    public final void a() {
        if (this.b == 2) {
            return;
        }
        Uri uri = this.c.get();
        if (uri == null) {
            this.d.set(true);
            return;
        }
        File file = new File(uri.getPath());
        if (file.isFile()) {
            PdfLog.d("Nutri.MediaContent", "Deleting temporary media file for annotation: " + this.a, new Object[0]);
            this.d.set(!file.delete());
        }
    }

    public final Maybe<Uri> a(final Context context) {
        if (this.h == null) {
            return Maybe.empty();
        }
        return Maybe.fromCallable(new Callable() { // from class: com.pspdfkit.internal.iq$$ExternalSyntheticLambda3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.b(context);
            }
        });
    }
}
