package com.pspdfkit.internal;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class yg {
    public static final /* synthetic */ boolean o = true;
    public ByteBuffer a;
    public int b;
    public int c;
    public int[] d;
    public int e;
    public boolean f;
    public boolean g;
    public int h;
    public int[] i;
    public int j;
    public int k;
    public boolean l;
    public final b m;
    public final l70 n;

    public static abstract class a {
    }

    public static final class b extends a {
        public static final b a = new b();
    }

    public yg() {
        b bVar = b.a;
        if (l70.a == null) {
            l70.a = new m70();
        }
        m70 m70Var = l70.a;
        this.c = 1;
        this.d = null;
        this.e = 0;
        this.f = false;
        this.g = false;
        this.i = new int[16];
        this.j = 0;
        this.k = 0;
        this.l = false;
        this.m = bVar;
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(1024).order(ByteOrder.LITTLE_ENDIAN);
        this.a = byteBufferOrder;
        this.n = m70Var;
        this.b = byteBufferOrder.capacity();
    }

    public final void a(short s) {
        ByteBuffer byteBuffer = this.a;
        int i = this.b - 2;
        this.b = i;
        byteBuffer.putShort(i, s);
    }

    public final void b(int i) {
        ByteBuffer byteBuffer = this.a;
        int i2 = this.b - 4;
        this.b = i2;
        byteBuffer.putInt(i2, i);
    }

    public final void c(int i, int i2) {
        if (i2 != 0) {
            if (i2 != this.a.capacity() - this.b) {
                throw new AssertionError("FlatBuffers: struct must be serialized inline.");
            }
            c(i);
        }
    }

    public final void d(int i, int i2) {
        int i3;
        if (i > this.c) {
            this.c = i;
        }
        int i4 = ((~((this.a.capacity() - this.b) + i2)) + 1) & (i - 1);
        while (this.b < i4 + i + i2) {
            int iCapacity = this.a.capacity();
            ByteBuffer byteBuffer = this.a;
            b bVar = this.m;
            int iCapacity2 = byteBuffer.capacity();
            if (iCapacity2 == 0) {
                i3 = 1024;
            } else {
                i3 = 2147483639;
                if (iCapacity2 == 2147483639) {
                    throw new AssertionError("FlatBuffers: cannot grow buffer beyond 2 gigabytes.");
                }
                if (((-1073741824) & iCapacity2) == 0) {
                    i3 = iCapacity2 << 1;
                }
            }
            byteBuffer.position(0);
            bVar.getClass();
            ByteBuffer byteBufferOrder = ByteBuffer.allocate(i3).order(ByteOrder.LITTLE_ENDIAN);
            byteBufferOrder.position(byteBufferOrder.clear().capacity() - iCapacity2);
            byteBufferOrder.put(byteBuffer);
            this.a = byteBufferOrder;
            if (byteBuffer != byteBufferOrder) {
                this.m.getClass();
            }
            this.b = (this.a.capacity() - iCapacity) + this.b;
        }
        for (int i5 = 0; i5 < i4; i5++) {
            ByteBuffer byteBuffer2 = this.a;
            int i6 = this.b - 1;
            this.b = i6;
            byteBuffer2.put(i6, (byte) 0);
        }
    }

    public final void a(long j) {
        ByteBuffer byteBuffer = this.a;
        int i = this.b - 8;
        this.b = i;
        byteBuffer.putLong(i, j);
    }

    public final int b() {
        if (!this.f) {
            throw new AssertionError("FlatBuffers: endVector called without startVector");
        }
        this.f = false;
        b(this.k);
        return this.a.capacity() - this.b;
    }

    public final void a(float f) {
        ByteBuffer byteBuffer = this.a;
        int i = this.b - 4;
        this.b = i;
        byteBuffer.putFloat(i, f);
    }

    public final void a(int i) {
        d(4, 0);
        if (!o && i > this.a.capacity() - this.b) {
            throw new AssertionError();
        }
        b(((this.a.capacity() - this.b) - i) + 4);
    }

    public final void c(int i) {
        this.d[i] = this.a.capacity() - this.b;
    }

    public final void c() {
        this.l = true;
    }

    public final void b(int i, int i2) {
        if (this.l || i2 != 0) {
            a(i2);
            c(i);
        }
    }

    public final int a(String str) {
        int iA = this.n.a(str);
        d(1, 0);
        ByteBuffer byteBuffer = this.a;
        int i = this.b - 1;
        this.b = i;
        byteBuffer.put(i, (byte) 0);
        a(1, iA, 1);
        ByteBuffer byteBuffer2 = this.a;
        int i2 = this.b - iA;
        this.b = i2;
        byteBuffer2.position(i2);
        this.n.a(str, this.a);
        return b();
    }

    public final void a(int i, int i2, int i3) {
        if (!this.f) {
            this.k = i2;
            int i4 = i * i2;
            d(4, i4);
            d(i3, i4);
            this.f = true;
            return;
        }
        throw new AssertionError("FlatBuffers: object serialization must not be nested.");
    }

    public final void a(int i, byte b2) {
        if (this.l || b2 != 0) {
            d(1, 0);
            ByteBuffer byteBuffer = this.a;
            int i2 = this.b - 1;
            this.b = i2;
            byteBuffer.put(i2, b2);
            c(i);
        }
    }

    public final void a(int i, short s) {
        if (this.l || s != 0) {
            d(2, 0);
            a(s);
            c(i);
        }
    }

    public final void a(int i, int i2) {
        if (this.l || i2 != 0) {
            d(4, 0);
            b(i2);
            c(i);
        }
    }

    public final void a(int i, long j) {
        if (this.l || j != 0) {
            d(8, 0);
            a(j);
            c(i);
        }
    }

    public final void a(int i, float f) {
        if (this.l || f != 0.0d) {
            d(4, 0);
            a(f);
            c(i);
        }
    }

    public final void d(int i) {
        if (!this.f) {
            int[] iArr = this.d;
            if (iArr == null || iArr.length < i) {
                this.d = new int[i];
            }
            this.e = i;
            Arrays.fill(this.d, 0, i, 0);
            this.f = true;
            this.h = this.a.capacity() - this.b;
            return;
        }
        throw new AssertionError("FlatBuffers: object serialization must not be nested.");
    }

    public final int a() {
        int i;
        if (this.d != null && this.f) {
            d(4, 0);
            b(0);
            int iCapacity = this.a.capacity() - this.b;
            int i2 = this.e - 1;
            while (i2 >= 0 && this.d[i2] == 0) {
                i2--;
            }
            for (int i3 = i2; i3 >= 0; i3--) {
                int i4 = this.d[i3];
                int i5 = i4 != 0 ? iCapacity - i4 : 0;
                d(2, 0);
                a((short) i5);
            }
            short s = (short) (iCapacity - this.h);
            d(2, 0);
            a(s);
            d(2, 0);
            a((short) ((i2 + 3) * 2));
            int i6 = 0;
            loop2: while (true) {
                if (i6 >= this.j) {
                    i = 0;
                    break;
                }
                int iCapacity2 = this.a.capacity() - this.i[i6];
                int i7 = this.b;
                short s2 = this.a.getShort(iCapacity2);
                if (s2 == this.a.getShort(i7)) {
                    int i8 = 2;
                    while (true) {
                        if (i8 < s2) {
                            if (this.a.getShort(iCapacity2 + i8) != this.a.getShort(i7 + i8)) {
                                break;
                            }
                            i8 += 2;
                        } else {
                            i = this.i[i6];
                            break loop2;
                        }
                    }
                }
                i6++;
            }
            if (i != 0) {
                int iCapacity3 = this.a.capacity() - iCapacity;
                this.b = iCapacity3;
                this.a.putInt(iCapacity3, i - iCapacity);
            } else {
                int i9 = this.j;
                int[] iArr = this.i;
                if (i9 == iArr.length) {
                    this.i = Arrays.copyOf(iArr, i9 * 2);
                }
                int[] iArr2 = this.i;
                int i10 = this.j;
                this.j = i10 + 1;
                iArr2[i10] = this.a.capacity() - this.b;
                ByteBuffer byteBuffer = this.a;
                byteBuffer.putInt(byteBuffer.capacity() - iCapacity, (this.a.capacity() - this.b) - iCapacity);
            }
            this.f = false;
            return iCapacity;
        }
        throw new AssertionError("FlatBuffers: endTable called without startTable");
    }
}
