package sdk.pendo.io.v1;

/* JADX INFO: loaded from: classes5.dex */
public abstract class k<T> {
    private static String b = "Invalid or non Implemented status";
    public final j a;

    public k(j jVar) {
        this.a = jVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T a(Object obj) {
        return obj;
    }

    public void a(Object obj, Object obj2) {
        throw new RuntimeException(b + " addValue(Object current, Object value) in " + getClass());
    }

    public Object b() {
        throw new RuntimeException(b + " createObject() in " + getClass());
    }

    public k<?> b(String str) {
        throw new RuntimeException(b + " startObject(String key) in " + getClass() + " key=" + str);
    }

    public Object a() {
        throw new RuntimeException(b + " createArray() in " + getClass());
    }

    public void a(Object obj, String str, Object obj2) {
        throw new RuntimeException(b + " setValue in " + getClass() + " key=" + str);
    }

    public k<?> a(String str) {
        throw new RuntimeException(b + " startArray in " + getClass() + " key=" + str);
    }
}
