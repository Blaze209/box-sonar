package external.sdk.pendo.io.glide.load.engine.bitmap_recycle;

import external.sdk.pendo.io.glide.load.engine.bitmap_recycle.f;
import java.util.Queue;
import sdk.pendo.io.y.l;

/* JADX INFO: loaded from: classes4.dex */
abstract class c<T extends f> {
    private final Queue<T> a = l.a(20);

    c() {
    }

    abstract T a();

    public void a(T t) {
        if (this.a.size() < 20) {
            this.a.offer(t);
        }
    }

    T b() {
        T tPoll = this.a.poll();
        return tPoll == null ? (T) a() : tPoll;
    }
}
