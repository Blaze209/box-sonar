package com.pspdfkit.internal;

import android.app.Activity;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.media3.common.MimeTypes;
import com.microsoft.intune.mam.client.media.MAMMediaPlayer;
import com.microsoft.intune.mam.client.view.MAMWindowManagement;
import com.microsoft.intune.mam.client.widget.MAMSurfaceView;
import com.pspdfkit.R;
import com.pspdfkit.utils.PdfLog;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class f70 extends MAMSurfaceView implements e70.g, ht.b {
    public boolean A;
    public boolean B;
    public final c C;
    public final d D;
    public final e E;
    public final f F;
    public Uri a;
    public int b;
    public int c;
    public SurfaceHolder d;
    public MediaPlayer e;
    public int f;
    public final Context g;
    public e70 h;
    public ht i;
    public int j;
    public int k;
    public final a l;
    public int m;
    public int n;
    public int o;
    public int p;
    public MediaPlayer.OnCompletionListener q;
    public MediaPlayer.OnPreparedListener r;
    public MediaPlayer.OnErrorListener s;
    public MediaPlayer.OnInfoListener t;
    public h u;
    public int v;
    public int w;
    public boolean x;
    public boolean y;
    public final b z;

    public class a implements MediaPlayer.OnVideoSizeChangedListener {
        public a() {
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            f70.this.j = mediaPlayer.getVideoWidth();
            f70.this.k = mediaPlayer.getVideoHeight();
            f70 f70Var = f70.this;
            if (f70Var.j == 0 || f70Var.k == 0) {
                return;
            }
            SurfaceHolder holder = f70Var.getHolder();
            f70 f70Var2 = f70.this;
            holder.setFixedSize(f70Var2.j, f70Var2.k);
            f70.this.requestLayout();
        }
    }

    public class b implements MediaPlayer.OnPreparedListener {
        public b() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public final void onPrepared(MediaPlayer mediaPlayer) {
            e70 e70Var;
            f70 f70Var = f70.this;
            f70Var.b = 2;
            f70Var.x = true;
            f70Var.y = true;
            e70 e70Var2 = f70Var.h;
            if (e70Var2 != null) {
                e70Var2.v.sendEmptyMessage(4);
            }
            f70 f70Var2 = f70.this;
            MediaPlayer.OnPreparedListener onPreparedListener = f70Var2.r;
            if (onPreparedListener != null) {
                onPreparedListener.onPrepared(f70Var2.e);
            }
            e70 e70Var3 = f70.this.h;
            if (e70Var3 != null) {
                e70Var3.setEnabled(true);
            }
            f70.this.j = mediaPlayer.getVideoWidth();
            f70.this.k = mediaPlayer.getVideoHeight();
            f70 f70Var3 = f70.this;
            int i = f70Var3.w;
            if (i != 0) {
                f70Var3.b(i);
            }
            f70 f70Var4 = f70.this;
            if (f70Var4.j == 0 || f70Var4.k == 0) {
                if (f70Var4.c == 3) {
                    f70Var4.e();
                    return;
                }
                return;
            }
            SurfaceHolder holder = f70Var4.getHolder();
            f70 f70Var5 = f70.this;
            holder.setFixedSize(f70Var5.j, f70Var5.k);
            f70 f70Var6 = f70.this;
            if (f70Var6.m == f70Var6.j && f70Var6.n == f70Var6.k) {
                if (f70Var6.c == 3) {
                    f70Var6.e();
                    e70 e70Var4 = f70.this.h;
                    if (e70Var4 != null) {
                        e70Var4.a(3000);
                        return;
                    }
                    return;
                }
                if (f70Var6.b()) {
                    return;
                }
                if ((i != 0 || f70.this.getCurrentPosition() > 0) && (e70Var = f70.this.h) != null) {
                    e70Var.a(0);
                }
            }
        }
    }

    public class c implements MediaPlayer.OnCompletionListener {
        public c() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public final void onCompletion(MediaPlayer mediaPlayer) {
            f70 f70Var = f70.this;
            f70Var.b = 5;
            f70Var.c = 5;
            if (f70Var.h != null) {
                boolean zIsPlaying = f70Var.e.isPlaying();
                f70 f70Var2 = f70.this;
                int i = f70Var2.b;
                f70Var2.h.v.sendEmptyMessage(7);
                PdfLog.d("Nutri.UniVideoView", "a=%s,b=%d", Boolean.valueOf(zIsPlaying), Integer.valueOf(i));
            }
            f70 f70Var3 = f70.this;
            MediaPlayer.OnCompletionListener onCompletionListener = f70Var3.q;
            if (onCompletionListener != null) {
                onCompletionListener.onCompletion(f70Var3.e);
            }
        }
    }

    public class d implements MediaPlayer.OnInfoListener {
        public d() {
        }

        /* JADX WARN: Code duplicated, block: B:16:0x003c  */
        /* JADX WARN: Code duplicated, block: B:22:0x0047 A[RETURN] */
        @Override // android.media.MediaPlayer.OnInfoListener
        public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            boolean z;
            MediaPlayer.OnInfoListener onInfoListener;
            if (i != 701) {
                if (i != 702) {
                    z = false;
                } else {
                    PdfLog.d("Nutri.UniVideoView", "onInfo MediaPlayer.MEDIA_INFO_BUFFERING_END", new Object[0]);
                    e70 e70Var = f70.this.h;
                    if (e70Var != null) {
                        e70Var.v.sendEmptyMessage(4);
                    }
                }
                onInfoListener = f70.this.t;
                if (onInfoListener != null) {
                    return !onInfoListener.onInfo(mediaPlayer, i, i2) || z;
                }
                return z;
            }
            PdfLog.d("Nutri.UniVideoView", "onInfo MediaPlayer.MEDIA_INFO_BUFFERING_START", new Object[0]);
            e70 e70Var2 = f70.this.h;
            if (e70Var2 != null) {
                e70Var2.v.sendEmptyMessage(3);
            }
            z = true;
            onInfoListener = f70.this.t;
            if (onInfoListener != null) {
                if (onInfoListener.onInfo(mediaPlayer, i, i2)) {
                }
            }
            return z;
        }
    }

    public class e implements MediaPlayer.OnErrorListener {
        public e() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            PdfLog.d("Nutri.UniVideoView", "Error: " + i + "," + i2, new Object[0]);
            f70 f70Var = f70.this;
            f70Var.b = -1;
            f70Var.c = -1;
            e70 e70Var = f70Var.h;
            if (e70Var != null) {
                e70Var.v.sendEmptyMessage(5);
            }
            f70 f70Var2 = f70.this;
            MediaPlayer.OnErrorListener onErrorListener = f70Var2.s;
            if (onErrorListener != null) {
                onErrorListener.onError(f70Var2.e, i, i2);
            }
            return true;
        }
    }

    public class f implements MediaPlayer.OnBufferingUpdateListener {
        public f() {
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            f70.this.v = i;
        }
    }

    public class g implements SurfaceHolder.Callback {
        public g() {
        }

        public final /* synthetic */ void a() {
            f70 f70Var = f70.this;
            int i = f70Var.w;
            if (i != 0) {
                f70Var.b(i);
            }
            f70.this.e();
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            f70 f70Var = f70.this;
            f70Var.m = i2;
            f70Var.n = i3;
            boolean z = f70Var.c == 3;
            boolean z2 = f70Var.j == i2 && f70Var.k == i3;
            if (f70Var.e != null && z && z2) {
                f70Var.post(new Runnable() { // from class: com.pspdfkit.internal.f70$g$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.a();
                    }
                });
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceCreated(SurfaceHolder surfaceHolder) {
            f70 f70Var = f70.this;
            f70Var.d = surfaceHolder;
            f70Var.c();
            f70 f70Var2 = f70.this;
            if (f70Var2.B && f70Var2.i == null) {
                ht htVar = new ht(f70Var2.g);
                f70Var2.i = htVar;
                htVar.g = f70Var2;
                htVar.b();
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            f70 f70Var = f70.this;
            f70Var.d = null;
            e70 e70Var = f70Var.h;
            if (e70Var != null) {
                e70Var.a();
            }
            f70 f70Var2 = f70.this;
            MediaPlayer mediaPlayer = f70Var2.e;
            if (mediaPlayer != null) {
                mediaPlayer.reset();
                f70Var2.e.release();
                f70Var2.e = null;
                f70Var2.b = 0;
                f70Var2.c = 0;
            }
            ht htVar = f70.this.i;
            if (htVar != null) {
                htVar.a();
            }
        }
    }

    public interface h {
    }

    public f70(Context context) {
        super(context, null, 0);
        this.b = 0;
        this.c = 0;
        this.d = null;
        this.e = null;
        this.l = new a();
        this.o = 0;
        this.p = 0;
        this.z = new b();
        this.C = new c();
        this.D = new d();
        this.E = new e();
        this.F = new f();
        g gVar = new g();
        this.g = context;
        this.A = false;
        this.B = false;
        this.j = 0;
        this.k = 0;
        getHolder().addCallback(gVar);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.b = 0;
        this.c = 0;
    }

    public final void a(int i) {
        if (this.B) {
            if (i == 1) {
                a(false, 1);
                return;
            }
            if (i == 2) {
                a(false, 9);
            } else if (i == 3) {
                a(true, 0);
            } else if (i == 4) {
                a(true, 8);
            }
        }
    }

    public final void b(int i) {
        if (!a()) {
            this.w = i;
        } else {
            this.e.seekTo(i);
            this.w = 0;
        }
    }

    public final void c() {
        e70 e70Var;
        if (this.a == null || this.d == null) {
            return;
        }
        AudioManager audioManager = (AudioManager) this.g.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        if (audioManager != null) {
            audioManager.requestAudioFocus(new AudioFocusRequest.Builder(1).setAudioAttributes(new AudioAttributes.Builder().setLegacyStreamType(3).build()).build());
        }
        MediaPlayer mediaPlayer = this.e;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            this.e.release();
            this.e = null;
            this.b = 0;
        }
        try {
            MAMMediaPlayer mAMMediaPlayer = new MAMMediaPlayer();
            this.e = mAMMediaPlayer;
            int i = this.f;
            if (i != 0) {
                mAMMediaPlayer.setAudioSessionId(i);
            } else {
                this.f = mAMMediaPlayer.getAudioSessionId();
            }
            this.e.setOnPreparedListener(this.z);
            this.e.setOnVideoSizeChangedListener(this.l);
            this.e.setOnCompletionListener(this.C);
            this.e.setOnErrorListener(this.E);
            this.e.setOnInfoListener(this.D);
            this.e.setOnBufferingUpdateListener(this.F);
            this.v = 0;
            this.e.setDataSource(this.g, this.a);
            this.e.setDisplay(this.d);
            setAudioStreamType(this.e);
            this.e.setScreenOnWhilePlaying(true);
            this.e.prepareAsync();
            this.b = 1;
            if (this.e == null || (e70Var = this.h) == null) {
                return;
            }
            e70Var.setMediaPlayer(this);
            this.h.setEnabled(a());
            this.h.a();
        } catch (IOException e2) {
            Log.w("Nutri.UniVideoView", "Unable to open content: " + this.a, e2);
            this.b = -1;
            this.c = -1;
            this.E.onError(this.e, 1, 0);
        }
    }

    public final void d() {
        if (a() && this.e.isPlaying()) {
            this.e.pause();
            this.b = 4;
            h hVar = this.u;
            if (hVar != null) {
                qq qqVar = (qq) hVar;
                if (qqVar.l != null && qqVar.k != null) {
                    int currentPosition = qqVar.i.getCurrentPosition();
                    int duration = qqVar.i.getDuration();
                    qq.a aVar = qqVar.l;
                    iq iqVar = qqVar.k;
                    if (currentPosition >= duration) {
                        ((pq) aVar).b(iqVar);
                    } else {
                        qqVar.i.getCurrentPosition();
                        ((pq) aVar).getClass();
                        iqVar.i = false;
                    }
                }
                qqVar.b();
            }
        }
        this.c = 4;
    }

    public final void e() {
        iq iqVar;
        e70 e70Var;
        if (!this.y && (e70Var = this.h) != null) {
            e70Var.v.sendEmptyMessage(3);
        }
        if (a()) {
            this.e.start();
            this.b = 3;
            h hVar = this.u;
            if (hVar != null) {
                qq qqVar = (qq) hVar;
                qq.a aVar = qqVar.l;
                if (aVar != null && (iqVar = qqVar.k) != null) {
                    qqVar.i.getCurrentPosition();
                    ((pq) aVar).a(iqVar);
                }
                qqVar.b();
            }
        }
        this.c = 3;
    }

    public int getBufferPercentage() {
        if (this.e != null) {
            return this.v;
        }
        return 0;
    }

    public int getCurrentPosition() {
        if (a()) {
            return this.e.getCurrentPosition();
        }
        return 0;
    }

    public int getDuration() {
        if (a()) {
            return this.e.getDuration();
        }
        return -1;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(f70.class.getName());
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        e70 e70Var;
        boolean z = (i == 4 || i == 24 || i == 25 || i == 164 || i == 82 || i == 5 || i == 6) ? false : true;
        if (a() && z && (e70Var = this.h) != null) {
            if (i == 79 || i == 85) {
                if (this.e.isPlaying()) {
                    d();
                    this.h.a(3000);
                } else {
                    e();
                    this.h.a();
                }
                return true;
            }
            if (i == 126) {
                if (!this.e.isPlaying()) {
                    e();
                    this.h.a();
                }
                return true;
            }
            if (i == 86 || i == 127) {
                if (this.e.isPlaying()) {
                    d();
                    this.h.a(3000);
                }
                return true;
            }
            if (e70Var.k) {
                e70Var.a();
            } else {
                e70Var.a(3000);
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.view.SurfaceView, android.view.View
    public final void onMeasure(int i, int i2) {
        int i3;
        super.onMeasure(i, i2);
        boolean z = this.A;
        int i4 = this.j;
        if (z) {
            setMeasuredDimension(View.getDefaultSize(i4, i), View.getDefaultSize(this.k, i2));
            return;
        }
        int defaultSize = View.getDefaultSize(i4, i);
        int defaultSize2 = View.getDefaultSize(this.k, i2);
        if (this.j > 0 && this.k > 0) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size2 = View.MeasureSpec.getSize(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                int i5 = this.j;
                int i6 = i5 * size2;
                int i7 = this.k;
                int i8 = size * i7;
                if (i6 < i8) {
                    defaultSize = i6 / i7;
                } else {
                    if (i6 > i8) {
                        defaultSize2 = i8 / i5;
                        defaultSize = size;
                    }
                    defaultSize = size;
                }
                defaultSize2 = size2;
            } else if (mode == 1073741824) {
                int i9 = (this.k * size) / this.j;
                if (mode2 != Integer.MIN_VALUE || i9 <= size2) {
                    defaultSize2 = i9;
                    defaultSize = size;
                }
                defaultSize = size;
                defaultSize2 = size2;
            } else {
                int i10 = this.j;
                int i11 = this.k;
                if (mode2 == 1073741824) {
                    i3 = (i10 * size2) / i11;
                    if (mode == Integer.MIN_VALUE && i3 > size) {
                        defaultSize = size;
                    }
                    defaultSize2 = size2;
                } else {
                    if (mode2 != Integer.MIN_VALUE || i11 <= size2) {
                        i3 = i10;
                        size2 = i11;
                    } else {
                        i3 = (size2 * i10) / i11;
                    }
                    if (mode == Integer.MIN_VALUE && i3 > size) {
                        defaultSize2 = (i11 * size) / i10;
                        defaultSize = size;
                    }
                }
                defaultSize = i3;
                defaultSize2 = size2;
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return a() && this.h != null && performClick();
    }

    @Override // android.view.View
    public final boolean onTrackballEvent(MotionEvent motionEvent) {
        e70 e70Var;
        if (!a() || (e70Var = this.h) == null) {
            return false;
        }
        if (e70Var.k) {
            e70Var.a();
            return false;
        }
        e70Var.a(3000);
        return false;
    }

    @Override // android.view.View
    public final boolean performClick() {
        e70 e70Var;
        if (!a() || (e70Var = this.h) == null) {
            return super.performClick();
        }
        if (e70Var.k) {
            e70Var.a();
            return true;
        }
        e70Var.a(3000);
        return true;
    }

    public void setAutoRotation(boolean z) {
        this.B = z;
    }

    public void setFitXY(boolean z) {
        this.A = z;
    }

    public void setFullscreen(boolean z) {
        a(z, !z ? 1 : 0);
    }

    public void setMediaController(e70 e70Var) {
        e70 e70Var2 = this.h;
        if (e70Var2 != null) {
            e70Var2.a();
        }
        this.h = e70Var;
        if (this.e == null || e70Var == null) {
            return;
        }
        e70Var.setMediaPlayer(this);
        this.h.setEnabled(a());
        this.h.a();
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.q = onCompletionListener;
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.s = onErrorListener;
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        this.t = onInfoListener;
    }

    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.r = onPreparedListener;
    }

    public void setVideoPath(String str) {
        setVideoURI(Uri.parse(str));
    }

    public void setVideoURI(Uri uri) {
        this.a = uri;
        this.w = 0;
        c();
        requestLayout();
        invalidate();
    }

    public void setVideoViewListener(h hVar) {
        this.u = hVar;
    }

    private void setAudioStreamType(MediaPlayer mediaPlayer) {
        mediaPlayer.setAudioAttributes(new AudioAttributes.Builder().setLegacyStreamType(3).build());
    }

    public final boolean b() {
        return a() && this.e.isPlaying();
    }

    public final void a(boolean z, int i) {
        Activity activity = (Activity) this.g;
        if (z) {
            if (this.o == 0 && this.p == 0) {
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                this.o = layoutParams.width;
                this.p = layoutParams.height;
            }
            activity.getWindow().addFlags(1024);
            activity.setRequestedOrientation(i);
        } else {
            ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
            layoutParams2.width = this.o;
            layoutParams2.height = this.p;
            setLayoutParams(layoutParams2);
            MAMWindowManagement.clearFlags(activity.getWindow(), 1024);
            activity.setRequestedOrientation(i);
        }
        e70 e70Var = this.h;
        e70Var.m = z;
        AppCompatImageButton appCompatImageButton = e70Var.o;
        if (z) {
            appCompatImageButton.setImageResource(R.drawable.pspdf__uvv_player_scale_out_btn);
        } else {
            appCompatImageButton.setImageResource(R.drawable.pspdf__uvv_player_scale_btn);
        }
        e70Var.p.setVisibility(e70Var.m ? 0 : 4);
    }

    public final boolean a() {
        int i;
        return (this.e == null || (i = this.b) == -1 || i == 0 || i == 1) ? false : true;
    }
}
