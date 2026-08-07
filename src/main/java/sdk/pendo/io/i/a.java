package sdk.pendo.io.i;

/* JADX INFO: loaded from: classes4.dex */
public interface a {
    void clearMemory();

    <T> T get(int i, Class<T> cls);

    <T> T getExact(int i, Class<T> cls);

    <T> void put(T t);

    void trimMemory(int i);
}
