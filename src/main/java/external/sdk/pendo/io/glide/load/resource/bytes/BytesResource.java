package external.sdk.pendo.io.glide.load.resource.bytes;

import sdk.pendo.io.h.c;
import sdk.pendo.io.y.k;

/* JADX INFO: loaded from: classes4.dex */
public class BytesResource implements c<byte[]> {
    private final byte[] bytes;

    public BytesResource(byte[] bArr) {
        this.bytes = (byte[]) k.a(bArr);
    }

    @Override // sdk.pendo.io.h.c
    public Class<byte[]> getResourceClass() {
        return byte[].class;
    }

    @Override // sdk.pendo.io.h.c
    public int getSize() {
        return this.bytes.length;
    }

    @Override // sdk.pendo.io.h.c
    public void recycle() {
    }

    @Override // sdk.pendo.io.h.c
    public byte[] get() {
        return this.bytes;
    }
}
