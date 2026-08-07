package external.sdk.pendo.io.glide.load.engine;

import android.util.Log;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class n extends Exception {
    private static final StackTraceElement[] g = new StackTraceElement[0];
    private final List<Throwable> a;
    private sdk.pendo.io.e.f b;
    private sdk.pendo.io.e.a c;
    private Class<?> d;
    private String e;
    private Exception f;

    private static final class a implements Appendable {
        private final Appendable a;
        private boolean b = true;

        a(Appendable appendable) {
            this.a = appendable;
        }

        private CharSequence a(CharSequence charSequence) {
            return charSequence == null ? "" : charSequence;
        }

        @Override // java.lang.Appendable
        public Appendable append(char c) throws IOException {
            if (this.b) {
                this.b = false;
                this.a.append("  ");
            }
            this.b = c == '\n';
            this.a.append(c);
            return this;
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence) {
            CharSequence charSequenceA = a(charSequence);
            return append(charSequenceA, 0, charSequenceA.length());
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence, int i, int i2) throws IOException {
            CharSequence charSequenceA = a(charSequence);
            boolean z = false;
            if (this.b) {
                this.b = false;
                this.a.append("  ");
            }
            if (charSequenceA.length() > 0 && charSequenceA.charAt(i2 - 1) == '\n') {
                z = true;
            }
            this.b = z;
            this.a.append(charSequenceA, i, i2);
            return this;
        }
    }

    public n(String str) {
        this(str, (List<Throwable>) Collections.emptyList());
    }

    private void a(Throwable th, List<Throwable> list) {
        if (th instanceof n) {
            Iterator<Throwable> it = ((n) th).a().iterator();
            while (it.hasNext()) {
                a(it.next(), list);
            }
        } else if (th != null) {
            list.add(th);
        }
    }

    private static void b(List<Throwable> list, Appendable appendable) throws IOException {
        int size = list.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            appendable.append("Cause (").append(String.valueOf(i2)).append(" of ").append(String.valueOf(size)).append("): ");
            Throwable th = list.get(i);
            if (th instanceof n) {
                ((n) th).a(appendable);
            } else {
                a(th, appendable);
            }
            i = i2;
        }
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder sbAppend = new StringBuilder(71).append(this.e).append(this.d != null ? ", " + this.d : "").append(this.c != null ? ", " + this.c : "").append(this.b != null ? ", " + this.b : "");
        List<Throwable> listB = b();
        if (listB.isEmpty()) {
            return sbAppend.toString();
        }
        if (listB.size() == 1) {
            sbAppend.append("\nThere was 1 root cause:");
        } else {
            sbAppend.append("\nThere were ").append(listB.size()).append(" root causes:");
        }
        for (Throwable th : listB) {
            sbAppend.append('\n').append(th.getClass().getName()).append('(').append(th.getMessage()).append(')');
        }
        sbAppend.append("\n call GlideException#logRootCauses(String) for more detail");
        return sbAppend.toString();
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public n(String str, Throwable th) {
        this(str, (List<Throwable>) Collections.singletonList(th));
    }

    private static void a(List<Throwable> list, Appendable appendable) {
        try {
            b(list, appendable);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Throwable> b() {
        ArrayList arrayList = new ArrayList();
        a(this, arrayList);
        return arrayList;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        a(printStream);
    }

    public n(String str, List<Throwable> list) {
        this.e = str;
        setStackTrace(g);
        this.a = list;
    }

    private static void a(Throwable th, Appendable appendable) {
        try {
            appendable.append(th.getClass().toString()).append(": ").append(th.getMessage()).append('\n');
        } catch (IOException unused) {
            throw new RuntimeException(th);
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        a(printWriter);
    }

    public List<Throwable> a() {
        return this.a;
    }

    public void a(String str) {
        List<Throwable> listB = b();
        int size = listB.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            Log.i(str, "Root cause (" + i2 + " of " + size + ")", listB.get(i));
            i = i2;
        }
    }

    private void a(Appendable appendable) {
        a(this, appendable);
        a(a(), new a(appendable));
    }

    void a(sdk.pendo.io.e.f fVar, sdk.pendo.io.e.a aVar) {
        a(fVar, aVar, null);
    }

    void a(sdk.pendo.io.e.f fVar, sdk.pendo.io.e.a aVar, Class<?> cls) {
        this.b = fVar;
        this.c = aVar;
        this.d = cls;
    }

    public void a(Exception exc) {
        this.f = exc;
    }
}
