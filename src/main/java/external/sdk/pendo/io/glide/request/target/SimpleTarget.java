package external.sdk.pendo.io.glide.request.target;

import sdk.pendo.io.v.c;
import sdk.pendo.io.y.l;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public abstract class SimpleTarget<Z> extends BaseTarget<Z> {
    private final int height;
    private final int width;

    public SimpleTarget() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // external.sdk.pendo.io.glide.request.target.Target
    public final void getSize(c cVar) {
        if (!l.b(this.width, this.height)) {
            throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + this.width + " and height: " + this.height + ", either provide dimensions in the constructor or call override()");
        }
        cVar.onSizeReady(this.width, this.height);
    }

    @Override // external.sdk.pendo.io.glide.request.target.Target
    public void removeCallback(c cVar) {
    }

    public SimpleTarget(int i, int i2) {
        this.width = i;
        this.height = i2;
    }
}
