package sdk.pendo.io.c0;

import external.sdk.pendo.io.gson.internal.bind.TypeAdapters;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;
import sdk.pendo.io.a0.q;

/* JADX INFO: loaded from: classes4.dex */
public final class k {

    private static final class a extends Writer {
        private final Appendable a;
        private final C0358a b = new C0358a();

        /* JADX INFO: renamed from: sdk.pendo.io.c0.k$a$a, reason: collision with other inner class name */
        static class C0358a implements CharSequence {
            char[] a;

            C0358a() {
            }

            @Override // java.lang.CharSequence
            public char charAt(int i) {
                return this.a[i];
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.a.length;
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i, int i2) {
                return new String(this.a, i, i2 - i);
            }
        }

        a(Appendable appendable) {
            this.a = appendable;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.Writer
        public void write(int i) throws IOException {
            this.a.append((char) i);
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) throws IOException {
            C0358a c0358a = this.b;
            c0358a.a = cArr;
            this.a.append(c0358a, i, i2 + i);
        }
    }

    public static sdk.pendo.io.a0.i a(sdk.pendo.io.h0.a aVar) {
        boolean z;
        try {
            try {
                aVar.t();
                z = false;
                try {
                    return TypeAdapters.V.a(aVar);
                } catch (EOFException e) {
                    e = e;
                    if (z) {
                        return sdk.pendo.io.a0.k.a;
                    }
                    throw new q(e);
                }
            } catch (EOFException e2) {
                e = e2;
                z = true;
            }
        } catch (sdk.pendo.io.h0.d e3) {
            throw new q(e3);
        } catch (IOException e4) {
            throw new sdk.pendo.io.a0.j(e4);
        } catch (NumberFormatException e5) {
            throw new q(e5);
        }
    }

    public static void a(sdk.pendo.io.a0.i iVar, sdk.pendo.io.h0.c cVar) {
        TypeAdapters.V.a(cVar, iVar);
    }

    public static Writer a(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new a(appendable);
    }
}
