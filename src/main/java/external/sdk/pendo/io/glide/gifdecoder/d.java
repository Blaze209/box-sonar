package external.sdk.pendo.io.glide.gifdecoder;

import android.util.Log;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public class d {
    private ByteBuffer b;
    private c c;
    private final byte[] a = new byte[256];
    private int d = 0;

    private boolean b() {
        return this.c.b != 0;
    }

    private int d() {
        try {
            return this.b.get() & 255;
        } catch (Exception unused) {
            this.c.b = 1;
            return 0;
        }
    }

    private void e() {
        this.c.d.a = l();
        this.c.d.b = l();
        this.c.d.c = l();
        this.c.d.d = l();
        int iD = d();
        boolean z = (iD & 128) != 0;
        int iPow = (int) Math.pow(2.0d, (iD & 7) + 1);
        b bVar = this.c.d;
        bVar.e = (iD & 64) != 0;
        if (z) {
            bVar.k = a(iPow);
        } else {
            bVar.k = null;
        }
        this.c.d.j = this.b.position();
        o();
        if (b()) {
            return;
        }
        c cVar = this.c;
        cVar.c++;
        cVar.e.add(cVar.d);
    }

    private void f() {
        int iD = d();
        this.d = iD;
        if (iD <= 0) {
            return;
        }
        int i = 0;
        int i2 = 0;
        while (true) {
            try {
                int i3 = this.d;
                if (i >= i3) {
                    return;
                }
                i2 = i3 - i;
                this.b.get(this.a, i, i2);
                i += i2;
            } catch (Exception e) {
                if (Log.isLoggable("GifHeaderParser", 3)) {
                    Log.d("GifHeaderParser", "Error Reading Block n: " + i + " count: " + i2 + " blockSize: " + this.d, e);
                }
                this.c.b = 1;
                return;
            }
        }
    }

    private void g() {
        b(Integer.MAX_VALUE);
    }

    private void h() {
        d();
        int iD = d();
        b bVar = this.c.d;
        int i = (iD & 28) >> 2;
        bVar.g = i;
        if (i == 0) {
            bVar.g = 1;
        }
        bVar.f = (iD & 1) != 0;
        int iL = l();
        if (iL < 2) {
            iL = 10;
        }
        b bVar2 = this.c.d;
        bVar2.i = iL * 10;
        bVar2.h = d();
        d();
    }

    private void i() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append((char) d());
        }
        if (!sb.toString().startsWith("GIF")) {
            this.c.b = 1;
            return;
        }
        j();
        if (!this.c.h || b()) {
            return;
        }
        c cVar = this.c;
        cVar.a = a(cVar.i);
        c cVar2 = this.c;
        cVar2.l = cVar2.a[cVar2.j];
    }

    private void j() {
        this.c.f = l();
        this.c.g = l();
        int iD = d();
        c cVar = this.c;
        cVar.h = (iD & 128) != 0;
        cVar.i = (int) Math.pow(2.0d, (iD & 7) + 1);
        this.c.j = d();
        this.c.k = d();
    }

    private void k() {
        do {
            f();
            byte[] bArr = this.a;
            if (bArr[0] == 1) {
                this.c.m = ((bArr[2] & 255) << 8) | (bArr[1] & 255);
            }
            if (this.d <= 0) {
                return;
            }
        } while (!b());
    }

    private int l() {
        return this.b.getShort();
    }

    private void m() {
        this.b = null;
        Arrays.fill(this.a, (byte) 0);
        this.c = new c();
        this.d = 0;
    }

    private void n() {
        int iD;
        do {
            iD = d();
            this.b.position(Math.min(this.b.position() + iD, this.b.limit()));
        } while (iD > 0);
    }

    private void o() {
        d();
        n();
    }

    public void a() {
        this.b = null;
        this.c = null;
    }

    public c c() {
        if (this.b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        if (b()) {
            return this.c;
        }
        i();
        if (!b()) {
            g();
            c cVar = this.c;
            if (cVar.c < 0) {
                cVar.b = 1;
            }
        }
        return this.c;
    }

    private int[] a(int i) {
        byte[] bArr = new byte[i * 3];
        int[] iArr = null;
        try {
            this.b.get(bArr);
            iArr = new int[256];
            int i2 = 0;
            int i3 = 0;
            while (i2 < i) {
                int i4 = bArr[i3] & 255;
                int i5 = i3 + 2;
                int i6 = bArr[i3 + 1] & 255;
                i3 += 3;
                int i7 = i2 + 1;
                iArr[i2] = (i6 << 8) | (i4 << 16) | (-16777216) | (bArr[i5] & 255);
                i2 = i7;
            }
            return iArr;
        } catch (BufferUnderflowException e) {
            if (Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", e);
            }
            this.c.b = 1;
            return iArr;
        }
    }

    private void b(int i) {
        boolean z = false;
        while (!z && !b() && this.c.c <= i) {
            int iD = d();
            if (iD == 33) {
                int iD2 = d();
                if (iD2 != 1) {
                    if (iD2 == 249) {
                        this.c.d = new b();
                        h();
                    } else if (iD2 != 254 && iD2 == 255) {
                        f();
                        StringBuilder sb = new StringBuilder();
                        for (int i2 = 0; i2 < 11; i2++) {
                            sb.append((char) this.a[i2]);
                        }
                        if (sb.toString().equals("NETSCAPE2.0")) {
                            k();
                        }
                    }
                }
                n();
            } else if (iD == 44) {
                c cVar = this.c;
                if (cVar.d == null) {
                    cVar.d = new b();
                }
                e();
            } else if (iD != 59) {
                this.c.b = 1;
            } else {
                z = true;
            }
        }
    }

    public d a(ByteBuffer byteBuffer) {
        m();
        ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.b = byteBufferAsReadOnlyBuffer;
        byteBufferAsReadOnlyBuffer.position(0);
        this.b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    public d a(byte[] bArr) {
        if (bArr != null) {
            a(ByteBuffer.wrap(bArr));
            return this;
        }
        this.b = null;
        this.c.b = 2;
        return this;
    }
}
