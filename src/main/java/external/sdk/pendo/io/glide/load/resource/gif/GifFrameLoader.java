package external.sdk.pendo.io.glide.load.resource.gif;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import external.sdk.pendo.io.glide.RequestBuilder;
import external.sdk.pendo.io.glide.RequestManager;
import external.sdk.pendo.io.glide.load.Transformation;
import external.sdk.pendo.io.glide.request.RequestOptions;
import external.sdk.pendo.io.glide.request.target.CustomTarget;
import external.sdk.pendo.io.glide.signature.ObjectKey;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import sdk.pendo.io.e.f;
import sdk.pendo.io.y.k;
import sdk.pendo.io.y.l;

/* JADX INFO: loaded from: classes4.dex */
class GifFrameLoader {
    private final external.sdk.pendo.io.glide.gifdecoder.a a;
    private final Handler b;
    private final List<b> c;
    final RequestManager d;
    private final sdk.pendo.io.i.b e;
    private boolean f;
    private boolean g;
    private boolean h;
    private RequestBuilder<Bitmap> i;
    private a j;
    private boolean k;
    private a l;
    private Bitmap m;
    private Transformation<Bitmap> n;
    private a o;
    private OnEveryFrameListener p;
    private int q;
    private int r;
    private int s;

    interface OnEveryFrameListener {
        void onFrameReady();
    }

    static class a extends CustomTarget<Bitmap> {
        private final Handler a;
        final int b;
        private final long c;
        private Bitmap d;

        a(Handler handler, int i, long j) {
            this.a = handler;
            this.b = i;
            this.c = j;
        }

        Bitmap a() {
            return this.d;
        }

        @Override // external.sdk.pendo.io.glide.request.target.Target
        public void onLoadCleared(Drawable drawable) {
            this.d = null;
        }

        public void onResourceReady(Bitmap bitmap, external.sdk.pendo.io.glide.request.transition.a<? super Bitmap> aVar) {
            this.d = bitmap;
            this.a.sendMessageAtTime(this.a.obtainMessage(1, this), this.c);
        }

        @Override // external.sdk.pendo.io.glide.request.target.Target
        public /* bridge */ /* synthetic */ void onResourceReady(Object obj, external.sdk.pendo.io.glide.request.transition.a aVar) {
            onResourceReady((Bitmap) obj, (external.sdk.pendo.io.glide.request.transition.a<? super Bitmap>) aVar);
        }
    }

    public interface b {
        void onFrameReady();
    }

    private class c implements Handler.Callback {
        c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                GifFrameLoader.this.a((a) message.obj);
                return true;
            }
            if (i != 2) {
                return false;
            }
            GifFrameLoader.this.d.clear((a) message.obj);
            return false;
        }
    }

    GifFrameLoader(external.sdk.pendo.io.glide.a aVar, external.sdk.pendo.io.glide.gifdecoder.a aVar2, int i, int i2, Transformation<Bitmap> transformation, Bitmap bitmap) {
        this(aVar.c(), external.sdk.pendo.io.glide.a.d(aVar.e()), aVar2, null, a(external.sdk.pendo.io.glide.a.d(aVar.e()), i, i2), transformation, bitmap);
    }

    private static f g() {
        return new ObjectKey(Double.valueOf(Math.random()));
    }

    private void m() {
        if (!this.f || this.g) {
            return;
        }
        if (this.h) {
            k.a(this.o == null, "Pending target must be null when starting from the first frame");
            this.a.resetFrameIndex();
            this.h = false;
        }
        a aVar = this.o;
        if (aVar != null) {
            this.o = null;
            a(aVar);
            return;
        }
        this.g = true;
        long jUptimeMillis = SystemClock.uptimeMillis() + ((long) this.a.getNextDelay());
        this.a.advance();
        this.l = new a(this.b, this.a.getCurrentFrameIndex(), jUptimeMillis);
        this.i.apply((external.sdk.pendo.io.glide.request.a<?>) RequestOptions.signatureOf(g())).m14700load((Object) this.a).into(this.l);
    }

    private void n() {
        Bitmap bitmap = this.m;
        if (bitmap != null) {
            this.e.put(bitmap);
            this.m = null;
        }
    }

    private void p() {
        if (this.f) {
            return;
        }
        this.f = true;
        this.k = false;
        m();
    }

    private void q() {
        this.f = false;
    }

    void a() {
        this.c.clear();
        n();
        q();
        a aVar = this.j;
        if (aVar != null) {
            this.d.clear(aVar);
            this.j = null;
        }
        a aVar2 = this.l;
        if (aVar2 != null) {
            this.d.clear(aVar2);
            this.l = null;
        }
        a aVar3 = this.o;
        if (aVar3 != null) {
            this.d.clear(aVar3);
            this.o = null;
        }
        this.a.clear();
        this.k = true;
    }

    ByteBuffer b() {
        return this.a.getData().asReadOnlyBuffer();
    }

    Bitmap c() {
        a aVar = this.j;
        return aVar != null ? aVar.a() : this.m;
    }

    int d() {
        a aVar = this.j;
        if (aVar != null) {
            return aVar.b;
        }
        return -1;
    }

    Bitmap e() {
        return this.m;
    }

    int f() {
        return this.a.getFrameCount();
    }

    Transformation<Bitmap> h() {
        return this.n;
    }

    int i() {
        return this.s;
    }

    int j() {
        return this.a.getTotalIterationCount();
    }

    int k() {
        return this.a.getByteSize() + this.q;
    }

    int l() {
        return this.r;
    }

    void o() {
        k.a(!this.f, "Can't restart a running animation");
        this.h = true;
        a aVar = this.o;
        if (aVar != null) {
            this.d.clear(aVar);
            this.o = null;
        }
    }

    GifFrameLoader(sdk.pendo.io.i.b bVar, RequestManager requestManager, external.sdk.pendo.io.glide.gifdecoder.a aVar, Handler handler, RequestBuilder<Bitmap> requestBuilder, Transformation<Bitmap> transformation, Bitmap bitmap) {
        this.c = new ArrayList();
        this.d = requestManager;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new c()) : handler;
        this.e = bVar;
        this.b = handler;
        this.i = requestBuilder;
        this.a = aVar;
        a(transformation, bitmap);
    }

    private static RequestBuilder<Bitmap> a(RequestManager requestManager, int i, int i2) {
        return requestManager.asBitmap().apply((external.sdk.pendo.io.glide.request.a<?>) RequestOptions.diskCacheStrategyOf(sdk.pendo.io.h.a.b).useAnimationPool(true).skipMemoryCache(true).override(i, i2));
    }

    void b(b bVar) {
        this.c.remove(bVar);
        if (this.c.isEmpty()) {
            q();
        }
    }

    void a(a aVar) {
        OnEveryFrameListener onEveryFrameListener = this.p;
        if (onEveryFrameListener != null) {
            onEveryFrameListener.onFrameReady();
        }
        this.g = false;
        if (!this.k) {
            if (this.f) {
                if (aVar.a() != null) {
                    n();
                    a aVar2 = this.j;
                    this.j = aVar;
                    for (int size = this.c.size() - 1; size >= 0; size--) {
                        this.c.get(size).onFrameReady();
                    }
                    if (aVar2 != null) {
                        this.b.obtainMessage(2, aVar2).sendToTarget();
                    }
                }
                m();
                return;
            }
            if (!this.h) {
                this.o = aVar;
                return;
            }
        }
        this.b.obtainMessage(2, aVar).sendToTarget();
    }

    void a(Transformation<Bitmap> transformation, Bitmap bitmap) {
        this.n = (Transformation) k.a(transformation);
        this.m = (Bitmap) k.a(bitmap);
        this.i = this.i.apply((external.sdk.pendo.io.glide.request.a<?>) new RequestOptions().transform(transformation));
        this.q = l.a(bitmap);
        this.r = bitmap.getWidth();
        this.s = bitmap.getHeight();
    }

    void a(b bVar) {
        if (this.k) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        }
        if (this.c.contains(bVar)) {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
        boolean zIsEmpty = this.c.isEmpty();
        this.c.add(bVar);
        if (zIsEmpty) {
            p();
        }
    }
}
