package external.sdk.pendo.io.glide.load.model;

import androidx.core.util.Pools;
import external.sdk.pendo.io.glide.load.Options;
import external.sdk.pendo.io.glide.load.engine.n;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import sdk.pendo.io.e.f;
import sdk.pendo.io.y.k;

/* JADX INFO: loaded from: classes4.dex */
class d<Model, Data> implements b<Model, Data> {
    private final List<b<Model, Data>> a;
    private final Pools.Pool<List<Throwable>> b;

    static class a<Data> implements external.sdk.pendo.io.glide.load.data.a<Data>, external.sdk.pendo.io.glide.load.data.a.InterfaceC0307a<Data> {
        private final List<external.sdk.pendo.io.glide.load.data.a<Data>> a;
        private final Pools.Pool<List<Throwable>> b;
        private int c;
        private sdk.pendo.io.c.b d;
        private external.sdk.pendo.io.glide.load.data.a.InterfaceC0307a<? super Data> e;
        private List<Throwable> f;
        private boolean g;

        a(List<external.sdk.pendo.io.glide.load.data.a<Data>> list, Pools.Pool<List<Throwable>> pool) {
            this.b = pool;
            k.a(list);
            this.a = list;
            this.c = 0;
        }

        @Override // external.sdk.pendo.io.glide.load.data.a.InterfaceC0307a
        public void a(Data data) {
            if (data != null) {
                this.e.a(data);
            } else {
                a();
            }
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public void cancel() {
            this.g = true;
            Iterator<external.sdk.pendo.io.glide.load.data.a<Data>> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().cancel();
            }
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public void cleanup() {
            List<Throwable> list = this.f;
            if (list != null) {
                this.b.release(list);
            }
            this.f = null;
            Iterator<external.sdk.pendo.io.glide.load.data.a<Data>> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().cleanup();
            }
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public Class<Data> getDataClass() {
            return this.a.get(0).getDataClass();
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public sdk.pendo.io.e.a getDataSource() {
            return this.a.get(0).getDataSource();
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public void loadData(sdk.pendo.io.c.b bVar, external.sdk.pendo.io.glide.load.data.a.InterfaceC0307a<? super Data> interfaceC0307a) {
            this.d = bVar;
            this.e = interfaceC0307a;
            this.f = this.b.acquire();
            this.a.get(this.c).loadData(bVar, this);
            if (this.g) {
                cancel();
            }
        }

        @Override // external.sdk.pendo.io.glide.load.data.a.InterfaceC0307a
        public void a(Exception exc) {
            ((List) k.a(this.f)).add(exc);
            a();
        }

        private void a() {
            if (this.g) {
                return;
            }
            if (this.c < this.a.size() - 1) {
                this.c++;
                loadData(this.d, this.e);
            } else {
                k.a(this.f);
                this.e.a((Exception) new n("Fetch failed", new ArrayList(this.f)));
            }
        }
    }

    d(List<b<Model, Data>> list, Pools.Pool<List<Throwable>> pool) {
        this.a = list;
        this.b = pool;
    }

    @Override // external.sdk.pendo.io.glide.load.model.b
    public b.a<Data> buildLoadData(Model model, int i, int i2, Options options) {
        b.a<Data> aVarBuildLoadData;
        int size = this.a.size();
        ArrayList arrayList = new ArrayList(size);
        f fVar = null;
        for (int i3 = 0; i3 < size; i3++) {
            b<Model, Data> bVar = this.a.get(i3);
            if (bVar.handles(model) && (aVarBuildLoadData = bVar.buildLoadData(model, i, i2, options)) != null) {
                fVar = aVarBuildLoadData.a;
                arrayList.add(aVarBuildLoadData.c);
            }
        }
        if (arrayList.isEmpty() || fVar == null) {
            return null;
        }
        return new b.a<>(fVar, new a(arrayList, this.b));
    }

    @Override // external.sdk.pendo.io.glide.load.model.b
    public boolean handles(Model model) {
        Iterator<b<Model, Data>> it = this.a.iterator();
        while (it.hasNext()) {
            if (it.next().handles(model)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.a.toArray()) + AbstractJsonLexerKt.END_OBJ;
    }
}
