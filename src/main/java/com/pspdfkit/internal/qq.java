package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.pspdfkit.R;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.LinkAnnotation;
import com.pspdfkit.annotations.MediaAnnotation;
import com.pspdfkit.annotations.actions.UriAction;
import com.pspdfkit.media.MediaUri;
import com.pspdfkit.utils.PdfLog;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public final class qq extends FrameLayout implements f70.h {
    public final lm a;
    public final e70 b;
    public Disposable c;
    public final AppCompatImageView d;
    public final AppCompatImageView e;
    public Disposable f;
    public boolean g;
    public boolean h;
    public final f70 i;
    public int j;
    public iq k;
    public a l;

    public interface a {
    }

    public qq(Context context, lm lmVar) {
        super(context);
        this.g = false;
        this.h = false;
        this.j = 1;
        this.a = lmVar;
        setBackgroundColor(0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        f70 f70Var = new f70(getContext());
        this.i = f70Var;
        f70Var.setVideoViewListener(this);
        f70Var.setAlpha(0.0f);
        addView(f70Var, layoutParams);
        e70 e70Var = new e70(context);
        this.b = e70Var;
        e70Var.setOnErrorView(R.layout.pspdf__uvv_on_error_layout);
        e70Var.setOnLoadingView(R.layout.pspdf__loading_view);
        e70Var.setVisibility(4);
        addView(e70Var);
        AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
        this.d = appCompatImageView;
        appCompatImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.internal.qq$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.a(view);
            }
        });
        appCompatImageView.setVisibility(4);
        addView(appCompatImageView, layoutParams);
        AppCompatImageView appCompatImageView2 = new AppCompatImageView(getContext());
        this.e = appCompatImageView2;
        appCompatImageView2.setScaleType(ImageView.ScaleType.FIT_XY);
        appCompatImageView2.setImageResource(R.drawable.pspdf__uvv_itv_player_play);
        appCompatImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.internal.qq$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.b(view);
            }
        });
        appCompatImageView2.setVisibility(4);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        addView(appCompatImageView2, layoutParams2);
    }

    private void setupImageCover(final iq iqVar) {
        setBackgroundColor(-16777216);
        Maybe maybeDoFinally = iqVar.a(getContext()).map(new Function() { // from class: com.pspdfkit.internal.qq$$ExternalSyntheticLambda10
            @Override // io.reactivex.rxjava3.functions.Function
            public final Object apply(Object obj) {
                return this.f$0.a((Uri) obj);
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).doFinally(new Action() { // from class: com.pspdfkit.internal.qq$$ExternalSyntheticLambda11
            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() throws Throwable {
                this.f$0.c();
            }
        });
        AppCompatImageView appCompatImageView = this.d;
        Objects.requireNonNull(appCompatImageView);
        this.f = maybeDoFinally.subscribe(new qq$$ExternalSyntheticLambda8(appCompatImageView), new Consumer() { // from class: com.pspdfkit.internal.qq$$ExternalSyntheticLambda12
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) throws Throwable {
                qq.a(iqVar, (Throwable) obj);
            }
        }, new Action() { // from class: com.pspdfkit.internal.qq$$ExternalSyntheticLambda1
            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() throws Throwable {
                qq.a(iqVar);
            }
        });
    }

    private void setupPreviewCover(final Uri uri) {
        setBackgroundColor(-16777216);
        Single singleDoFinally = Single.fromCallable(new Callable() { // from class: com.pspdfkit.internal.qq$$ExternalSyntheticLambda6
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ThumbnailUtils.createVideoThumbnail(uri.getPath(), 2);
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).doFinally(new Action() { // from class: com.pspdfkit.internal.qq$$ExternalSyntheticLambda7
            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() throws Throwable {
                this.f$0.d();
            }
        });
        AppCompatImageView appCompatImageView = this.d;
        Objects.requireNonNull(appCompatImageView);
        this.f = singleDoFinally.subscribe(new qq$$ExternalSyntheticLambda8(appCompatImageView), new Consumer() { // from class: com.pspdfkit.internal.qq$$ExternalSyntheticLambda9
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) {
                PdfLog.w("Nutri.MediaView", "Couldn't generate preview from: " + uri, new Object[0]);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:16:0x003c  */
    /* JADX WARN: Code duplicated, block: B:19:0x0048  */
    public final void a(iq iqVar, Uri uri) throws Throwable {
        String lastPathSegment;
        MediaUri mediaUri;
        String uri2;
        this.i.setVideoURI(uri);
        if (iqVar.f) {
            e70 e70Var = this.b;
            Annotation annotation = iqVar.a;
            if (annotation instanceof MediaAnnotation) {
                lastPathSegment = ((MediaAnnotation) annotation).getAssetName();
            } else if (annotation instanceof LinkAnnotation) {
                com.pspdfkit.annotations.actions.Action action = ((LinkAnnotation) annotation).getAction();
                if (!(action instanceof UriAction) || (uri2 = ((UriAction) action).getUri()) == null) {
                    mediaUri = null;
                } else {
                    mediaUri = MediaUri.parse(uri2);
                    if (mediaUri.getType() != MediaUri.UriType.MEDIA) {
                        mediaUri = null;
                    }
                }
                if (mediaUri != null) {
                    lastPathSegment = mediaUri.getParsedUri().getLastPathSegment();
                } else {
                    lastPathSegment = "";
                }
            } else {
                lastPathSegment = "";
            }
            e70Var.setTitle(lastPathSegment);
            this.b.setVisibility(0);
            this.i.setMediaController(this.b);
        }
        int iA = y30.a(iqVar.g);
        if (iA == 0) {
            setupPreviewCover(uri);
            return;
        }
        if (iA == 1) {
            setupImageCover(iqVar);
            return;
        }
        if (iA != 2) {
            if (iA != 3) {
                return;
            }
            setBackgroundColor(0);
            this.g = true;
            return;
        }
        setBackgroundColor(0);
        if (!this.i.b()) {
            this.e.setVisibility(0);
        }
        this.g = true;
    }

    public final void c() throws Throwable {
        if (!this.i.b()) {
            this.e.setVisibility(0);
            this.d.setVisibility(0);
        }
        this.g = true;
    }

    public final void d() throws Throwable {
        if (!this.i.b()) {
            this.e.setVisibility(0);
            this.d.setVisibility(0);
        }
        this.g = true;
    }

    public int getPosition() {
        return this.i.getCurrentPosition();
    }

    public void setMediaContent(final iq iqVar) {
        setBackgroundColor(0);
        yz.a(this.c);
        this.c = null;
        yz.a(this.f);
        this.f = null;
        f70 f70Var = this.i;
        MediaPlayer mediaPlayer = f70Var.e;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            f70Var.e.release();
            f70Var.e = null;
            f70Var.b = 0;
            f70Var.c = 0;
        }
        this.i.setMediaController(null);
        setBackgroundColor(0);
        this.i.setAlpha(0.0f);
        this.b.setVisibility(4);
        this.e.setVisibility(4);
        this.d.setVisibility(4);
        this.h = false;
        iq iqVar2 = this.k;
        if (iqVar2 != null) {
            a aVar = this.l;
            if (aVar != null) {
                iqVar2.i = false;
                ((pq) aVar).a.remove(iqVar2);
            }
            this.k.a();
        }
        this.k = iqVar;
        if (iqVar != null) {
            this.c = iqVar.a(getContext(), this.a).observeOn(AndroidSchedulers.mainThread()).doAfterTerminate(new Action() { // from class: com.pspdfkit.internal.qq$$ExternalSyntheticLambda0
                @Override // io.reactivex.rxjava3.functions.Action
                public final void run() {
                    this.f$0.a();
                }
            }).subscribe(new Consumer() { // from class: com.pspdfkit.internal.qq$$ExternalSyntheticLambda4
                @Override // io.reactivex.rxjava3.functions.Consumer
                public final void accept(Object obj) throws Throwable {
                    this.f$0.a(iqVar, (Uri) obj);
                }
            }, new Consumer() { // from class: com.pspdfkit.internal.qq$$ExternalSyntheticLambda5
                @Override // io.reactivex.rxjava3.functions.Consumer
                public final void accept(Object obj) throws Throwable {
                    this.f$0.a((Throwable) obj);
                }
            });
        }
    }

    public void setOnMediaPlaybackChangeListener(a aVar) {
        this.l = aVar;
    }

    public final void b() {
        setBackgroundColor(-16777216);
        this.i.setAlpha(1.0f);
        this.d.setVisibility(4);
        this.e.setVisibility(4);
    }

    public final void b(View view) {
        this.j = 2;
        a();
    }

    public final /* synthetic */ void a(Throwable th) throws Throwable {
        PdfLog.e("Nutri.MediaView", th, "Failed to get playable URI!", new Object[0]);
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).removeView(this);
        }
    }

    public final Bitmap a(Uri uri) throws Throwable {
        Context context = getContext();
        context.getClass();
        uri.getClass();
        return z7.a(context, uri);
    }

    public static void a(iq iqVar, Throwable th) throws Throwable {
        PdfLog.w("Nutri.MediaView", "Couldn't load cover for from path. Annotation: " + iqVar.a.getName(), new Object[0]);
    }

    public static void a(iq iqVar) throws Throwable {
        PdfLog.w("Nutri.MediaView", "Cover mode set to IMAGE but no path specified. Annotation: " + iqVar.a.getName(), new Object[0]);
    }

    public final void a(View view) {
        this.j = 2;
        a();
    }

    public final void a() {
        Disposable disposable = this.c;
        if ((disposable == null || disposable.isDisposed()) && this.k != null) {
            int iA = y30.a(this.j);
            if (iA == 1) {
                if (this.h) {
                    this.i.c();
                }
                this.i.b(0);
                this.i.e();
            } else if (iA == 2) {
                f70 f70Var = this.i;
                MediaPlayer mediaPlayer = f70Var.e;
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    f70Var.e.release();
                    f70Var.e = null;
                    f70Var.b = 0;
                    f70Var.c = 0;
                }
                this.h = true;
            } else if (iA == 3) {
                if (this.h) {
                    this.i.c();
                }
                this.i.e();
            } else if (iA == 4) {
                if (this.h) {
                    this.i.c();
                }
                this.i.d();
            }
            int i = this.j;
            if (i == 3) {
                iq iqVar = this.k;
                if (this.g) {
                    setBackgroundColor(0);
                    this.i.setAlpha(0.0f);
                    int iA2 = y30.a(iqVar.g);
                    if (iA2 == 0 || iA2 == 1) {
                        this.d.setVisibility(0);
                        this.e.setVisibility(0);
                    } else if (iA2 == 2) {
                        this.e.setVisibility(0);
                    }
                }
            } else if (i != 1) {
                b();
            }
            this.j = 1;
        }
    }
}
