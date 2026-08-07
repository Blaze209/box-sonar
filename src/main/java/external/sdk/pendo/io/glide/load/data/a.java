package external.sdk.pendo.io.glide.load.data;

/* JADX INFO: loaded from: classes4.dex */
public interface a<T> {

    /* JADX INFO: renamed from: external.sdk.pendo.io.glide.load.data.a$a, reason: collision with other inner class name */
    public interface InterfaceC0307a<T> {
        void a(Exception exc);

        void a(T t);
    }

    void cancel();

    void cleanup();

    Class<T> getDataClass();

    sdk.pendo.io.e.a getDataSource();

    void loadData(sdk.pendo.io.c.b bVar, InterfaceC0307a<? super T> interfaceC0307a);
}
