package sdk.pendo.io.e1;

import com.box.android.data.api.models.MetadataReservedKeys;
import java.util.Collection;

/* JADX INFO: loaded from: classes4.dex */
public abstract class h implements Comparable<h> {
    public static final h b = new a(null);
    protected Object a;

    class a extends h {
        a(Object obj) {
            super(obj);
        }

        @Override // sdk.pendo.io.e1.h
        public Object a() {
            return null;
        }

        @Override // sdk.pendo.io.e1.h, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(h hVar) {
            return super.compareTo(hVar);
        }
    }

    private static class b extends h {
        private int c;

        private b(Object obj, int i) {
            super(obj);
            this.c = i;
        }

        @Override // sdk.pendo.io.e1.h, java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(h hVar) {
            return hVar instanceof b ? Integer.compare(((b) hVar).c, this.c) : super.compareTo(hVar);
        }

        @Override // sdk.pendo.io.e1.h
        public Object a() {
            return Integer.valueOf(this.c);
        }
    }

    private static class c extends h {
        private Collection<String> c;

        private c(Object obj, Collection<String> collection) {
            super(obj);
            this.c = collection;
        }

        @Override // sdk.pendo.io.e1.h
        public Object a() {
            return i.a("&&", this.c);
        }

        @Override // sdk.pendo.io.e1.h, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(h hVar) {
            return super.compareTo(hVar);
        }
    }

    private static class d extends h {
        private String c;

        private d(Object obj, String str) {
            super(obj);
            this.c = str;
        }

        @Override // sdk.pendo.io.e1.h
        public Object a() {
            return this.c;
        }

        @Override // sdk.pendo.io.e1.h, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(h hVar) {
            return super.compareTo(hVar);
        }
    }

    private static class e extends h {
        private e(Object obj) {
            super(obj);
        }

        @Override // sdk.pendo.io.e1.h
        Object a() {
            return MetadataReservedKeys.PREFIX;
        }

        @Override // sdk.pendo.io.e1.h, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(h hVar) {
            return super.compareTo(hVar);
        }
    }

    private h(Object obj) {
        this.a = obj;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a */
    public int compareTo(h hVar) {
        return a().toString().compareTo(hVar.a().toString()) * (-1);
    }

    abstract Object a();

    public static h a(Object obj, int i) {
        return new b(obj, i);
    }

    public static h a(Object obj, String str) {
        return new d(obj, str);
    }

    public static h a(Object obj, Collection<String> collection) {
        return new c(obj, collection);
    }

    public static h a(Object obj) {
        return new e(obj);
    }
}
