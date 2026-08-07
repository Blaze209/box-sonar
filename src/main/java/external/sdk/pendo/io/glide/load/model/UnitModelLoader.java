package external.sdk.pendo.io.glide.load.model;

import external.sdk.pendo.io.glide.load.Options;
import external.sdk.pendo.io.glide.signature.ObjectKey;

/* JADX INFO: loaded from: classes4.dex */
public class UnitModelLoader<Model> implements b<Model, Model> {
    private static final UnitModelLoader<?> INSTANCE = new UnitModelLoader<>();

    public static class Factory<Model> implements sdk.pendo.io.l.d<Model, Model> {
        private static final Factory<?> FACTORY = new Factory<>();

        @Deprecated
        public Factory() {
        }

        public static <T> Factory<T> getInstance() {
            return (Factory<T>) FACTORY;
        }

        @Override // sdk.pendo.io.l.d
        public b<Model, Model> build(e eVar) {
            return UnitModelLoader.getInstance();
        }

        public void teardown() {
        }
    }

    private static class a<Model> implements external.sdk.pendo.io.glide.load.data.a<Model> {
        private final Model a;

        a(Model model) {
            this.a = model;
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public void cancel() {
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public void cleanup() {
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public Class<Model> getDataClass() {
            return (Class<Model>) this.a.getClass();
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public sdk.pendo.io.e.a getDataSource() {
            return sdk.pendo.io.e.a.LOCAL;
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public void loadData(sdk.pendo.io.c.b bVar, external.sdk.pendo.io.glide.load.data.a.InterfaceC0307a<? super Model> interfaceC0307a) {
            interfaceC0307a.a(this.a);
        }
    }

    @Deprecated
    public UnitModelLoader() {
    }

    public static <T> UnitModelLoader<T> getInstance() {
        return (UnitModelLoader<T>) INSTANCE;
    }

    @Override // external.sdk.pendo.io.glide.load.model.b
    public b.a<Model> buildLoadData(Model model, int i, int i2, Options options) {
        return new b.a<>(new ObjectKey(model), new a(model));
    }

    @Override // external.sdk.pendo.io.glide.load.model.b
    public boolean handles(Model model) {
        return true;
    }
}
