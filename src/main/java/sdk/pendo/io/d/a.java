package sdk.pendo.io.d;

import android.os.StrictMode;
import com.facebook.cache.disk.DefaultDiskStorage;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements Closeable {
    private final File a;
    private final File b;
    private final File c;
    private final File d;
    private final int e;
    private long f;
    private final int g;
    private Writer i;
    private int k;
    private long h = 0;
    private final LinkedHashMap<String, d> j = new LinkedHashMap<>(0, 0.75f, true);
    private long l = 0;
    final ThreadPoolExecutor m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b(null));
    private final Callable<Void> n = new CallableC0369a();

    /* JADX INFO: renamed from: sdk.pendo.io.d.a$a, reason: collision with other inner class name */
    class CallableC0369a implements Callable<Void> {
        CallableC0369a() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            synchronized (a.this) {
                if (a.this.i == null) {
                    return null;
                }
                a.this.g();
                if (a.this.c()) {
                    a.this.f();
                    a.this.k = 0;
                }
                return null;
            }
        }
    }

    private static final class b implements ThreadFactory {
        private b() {
        }

        /* synthetic */ b(CallableC0369a callableC0369a) {
            this();
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }
    }

    public final class c {
        private final d a;
        private final boolean[] b;
        private boolean c;

        private c(d dVar) {
            this.a = dVar;
            this.b = dVar.e ? null : new boolean[a.this.g];
        }

        public void a() {
            a.this.a(this, false);
        }

        public void b() {
            if (this.c) {
                return;
            }
            try {
                a();
            } catch (IOException unused) {
            }
        }

        public void c() {
            a.this.a(this, true);
            this.c = true;
        }

        /* synthetic */ c(a aVar, d dVar, CallableC0369a callableC0369a) {
            this(dVar);
        }

        public File a(int i) {
            File fileB;
            synchronized (a.this) {
                if (this.a.f != this) {
                    throw new IllegalStateException();
                }
                if (!this.a.e) {
                    this.b[i] = true;
                }
                fileB = this.a.b(i);
                a.this.a.mkdirs();
            }
            return fileB;
        }
    }

    private final class d {
        private final String a;
        private final long[] b;
        File[] c;
        File[] d;
        private boolean e;
        private c f;
        private long g;

        private d(String str) {
            this.a = str;
            this.b = new long[a.this.g];
            this.c = new File[a.this.g];
            this.d = new File[a.this.g];
            StringBuilder sbAppend = new StringBuilder(str).append('.');
            int length = sbAppend.length();
            for (int i = 0; i < a.this.g; i++) {
                sbAppend.append(i);
                this.c[i] = new File(a.this.a, sbAppend.toString());
                sbAppend.append(DefaultDiskStorage.FileType.TEMP);
                this.d[i] = new File(a.this.a, sbAppend.toString());
                sbAppend.setLength(length);
            }
        }

        /* synthetic */ d(a aVar, String str, CallableC0369a callableC0369a) {
            this(str);
        }

        public File b(int i) {
            return this.d[i];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String[] strArr) throws IOException {
            if (strArr.length != a.this.g) {
                throw a(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.b[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException unused) {
                    throw a(strArr);
                }
            }
        }

        public File a(int i) {
            return this.c[i];
        }

        public String a() {
            StringBuilder sb = new StringBuilder();
            for (long j : this.b) {
                sb.append(' ').append(j);
            }
            return sb.toString();
        }

        private IOException a(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }
    }

    public final class e {
        private final String a;
        private final long b;
        private final long[] c;
        private final File[] d;

        private e(String str, long j, File[] fileArr, long[] jArr) {
            this.a = str;
            this.b = j;
            this.d = fileArr;
            this.c = jArr;
        }

        public File a(int i) {
            return this.d[i];
        }

        /* synthetic */ e(a aVar, String str, long j, File[] fileArr, long[] jArr, CallableC0369a callableC0369a) {
            this(str, j, fileArr, jArr);
        }
    }

    private a(File file, int i, int i2, long j) {
        this.a = file;
        this.e = i;
        this.b = new File(file, "journal");
        this.c = new File(file, "journal.tmp");
        this.d = new File(file, "journal.bkp");
        this.g = i2;
        this.f = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        while (this.h > this.f) {
            d(this.j.entrySet().iterator().next().getKey());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.i == null) {
            return;
        }
        for (d dVar : new ArrayList(this.j.values())) {
            if (dVar.f != null) {
                dVar.f.a();
            }
        }
        g();
        a(this.i);
        this.i = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        int i = this.k;
        return i >= 2000 && i >= this.j.size();
    }

    private void d() throws IOException {
        a(this.c);
        Iterator<d> it = this.j.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            int i = 0;
            if (next.f == null) {
                while (i < this.g) {
                    this.h += next.b[i];
                    i++;
                }
            } else {
                next.f = null;
                while (i < this.g) {
                    a(next.a(i));
                    a(next.b(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    private void e() {
        sdk.pendo.io.d.b bVar = new sdk.pendo.io.d.b(new FileInputStream(this.b), sdk.pendo.io.d.c.a);
        try {
            String strC = bVar.c();
            String strC2 = bVar.c();
            String strC3 = bVar.c();
            String strC4 = bVar.c();
            String strC5 = bVar.c();
            if (!"libcore.io.DiskLruCache".equals(strC) || !"1".equals(strC2) || !Integer.toString(this.e).equals(strC3) || !Integer.toString(this.g).equals(strC4) || !"".equals(strC5)) {
                throw new IOException("unexpected journal header: [" + strC + ", " + strC2 + ", " + strC4 + ", " + strC5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    c(bVar.c());
                    i++;
                } catch (EOFException unused) {
                    this.k = i - this.j.size();
                    if (bVar.b()) {
                        f();
                    } else {
                        this.i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.b, true), sdk.pendo.io.d.c.a));
                    }
                    sdk.pendo.io.d.c.a(bVar);
                    return;
                }
            }
        } catch (Throwable th) {
            sdk.pendo.io.d.c.a(bVar);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void f() {
        Writer writer = this.i;
        if (writer != null) {
            a(writer);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.c), sdk.pendo.io.d.c.a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.e));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.g));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (d dVar : this.j.values()) {
                bufferedWriter.write((dVar.f != null ? new StringBuilder().append("DIRTY ").append(dVar.a).append('\n') : new StringBuilder().append("CLEAN ").append(dVar.a).append(dVar.a()).append('\n')).toString());
            }
            a(bufferedWriter);
            if (this.b.exists()) {
                a(this.b, this.d, true);
            }
            a(this.c, this.b, false);
            this.d.delete();
            this.i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.b, true), sdk.pendo.io.d.c.a));
        } catch (Throwable th) {
            a(bufferedWriter);
            throw th;
        }
    }

    public void b() throws IOException {
        close();
        sdk.pendo.io.d.c.a(this.a);
    }

    private static void b(Writer writer) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    private void c(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i);
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i);
            if (iIndexOf == 6 && str.startsWith("REMOVE")) {
                this.j.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i, iIndexOf2);
        }
        d dVar = this.j.get(strSubstring);
        CallableC0369a callableC0369a = null;
        if (dVar == null) {
            dVar = new d(this, strSubstring, callableC0369a);
            this.j.put(strSubstring, dVar);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith("CLEAN")) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            dVar.e = true;
            dVar.f = null;
            dVar.b(strArrSplit);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith("DIRTY")) {
            dVar.f = new c(this, dVar, callableC0369a);
        } else if (iIndexOf2 != -1 || iIndexOf != 4 || !str.startsWith("READ")) {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    public synchronized boolean d(String str) {
        a();
        d dVar = this.j.get(str);
        if (dVar != null && dVar.f == null) {
            for (int i = 0; i < this.g; i++) {
                File fileA = dVar.a(i);
                if (fileA.exists() && !fileA.delete()) {
                    throw new IOException("failed to delete " + fileA);
                }
                this.h -= dVar.b[i];
                dVar.b[i] = 0;
            }
            this.k++;
            this.i.append((CharSequence) "REMOVE");
            this.i.append(' ');
            this.i.append((CharSequence) str);
            this.i.append('\n');
            this.j.remove(str);
            if (c()) {
                this.m.submit(this.n);
            }
            return true;
        }
        return false;
    }

    private void a() {
        if (this.i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public synchronized e b(String str) {
        Throwable th;
        try {
            try {
                a();
                d dVar = this.j.get(str);
                if (dVar == null) {
                    return null;
                }
                if (!dVar.e) {
                    return null;
                }
                for (File file : dVar.c) {
                    try {
                        if (!file.exists()) {
                            return null;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                this.k++;
                this.i.append((CharSequence) "READ");
                this.i.append(' ');
                this.i.append((CharSequence) str);
                this.i.append('\n');
                if (c()) {
                    this.m.submit(this.n);
                }
                return new e(this, str, dVar.g, dVar.c, dVar.b, null);
            } catch (Throwable th3) {
                th = th3;
                th = th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
        throw th;
    }

    private static void a(Writer writer) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(c cVar, boolean z) {
        d dVar = cVar.a;
        if (dVar.f != cVar) {
            throw new IllegalStateException();
        }
        if (z && !dVar.e) {
            for (int i = 0; i < this.g; i++) {
                if (!cVar.b[i]) {
                    cVar.a();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                }
                if (!dVar.b(i).exists()) {
                    cVar.a();
                    return;
                }
            }
        }
        for (int i2 = 0; i2 < this.g; i2++) {
            File fileB = dVar.b(i2);
            if (!z) {
                a(fileB);
            } else if (fileB.exists()) {
                File fileA = dVar.a(i2);
                fileB.renameTo(fileA);
                long j = dVar.b[i2];
                long length = fileA.length();
                dVar.b[i2] = length;
                this.h = (this.h - j) + length;
            }
        }
        this.k++;
        dVar.f = null;
        if (!(dVar.e | z)) {
            this.j.remove(dVar.a);
            this.i.append((CharSequence) "REMOVE");
            this.i.append(' ');
            this.i.append((CharSequence) dVar.a);
            this.i.append('\n');
        } else {
            dVar.e = true;
            this.i.append((CharSequence) "CLEAN");
            this.i.append(' ');
            this.i.append((CharSequence) dVar.a);
            this.i.append((CharSequence) dVar.a());
            this.i.append('\n');
            if (z) {
                long j2 = this.l;
                this.l = 1 + j2;
                dVar.g = j2;
            }
        }
        b(this.i);
        if (this.h > this.f || c()) {
            this.m.submit(this.n);
        }
    }

    private static void a(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public c a(String str) {
        return a(str, -1L);
    }

    private synchronized c a(String str, long j) {
        a();
        d dVar = this.j.get(str);
        CallableC0369a callableC0369a = null;
        if (j != -1 && (dVar == null || dVar.g != j)) {
            return null;
        }
        if (dVar == null) {
            dVar = new d(this, str, callableC0369a);
            this.j.put(str, dVar);
        } else if (dVar.f != null) {
            return null;
        }
        c cVar = new c(this, dVar, callableC0369a);
        dVar.f = cVar;
        this.i.append((CharSequence) "DIRTY");
        this.i.append(' ');
        this.i.append((CharSequence) str);
        this.i.append('\n');
        b(this.i);
        return cVar;
    }

    public static a a(File file, int i, int i2, long j) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        File file2 = new File(file, "journal.bkp");
        if (file2.exists()) {
            File file3 = new File(file, "journal");
            if (file3.exists()) {
                file2.delete();
            } else {
                a(file2, file3, false);
            }
        }
        a aVar = new a(file, i, i2, j);
        if (aVar.b.exists()) {
            try {
                aVar.e();
                aVar.d();
                return aVar;
            } catch (IOException e2) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                aVar.b();
            }
        }
        file.mkdirs();
        a aVar2 = new a(file, i, i2, j);
        aVar2.f();
        return aVar2;
    }

    private static void a(File file, File file2, boolean z) throws IOException {
        if (z) {
            a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }
}
