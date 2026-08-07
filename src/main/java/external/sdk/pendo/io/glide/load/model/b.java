package external.sdk.pendo.io.glide.load.model;

import external.sdk.pendo.io.glide.load.Options;
import java.util.Collections;
import java.util.List;
import sdk.pendo.io.e.f;
import sdk.pendo.io.y.k;

/* JADX INFO: loaded from: classes4.dex */
public interface b<Model, Data> {

    public static class a<Data> {
        public final f a;
        public final List<f> b;
        public final external.sdk.pendo.io.glide.load.data.a<Data> c;

        public a(f fVar, external.sdk.pendo.io.glide.load.data.a<Data> aVar) {
            this(fVar, Collections.emptyList(), aVar);
        }

        public a(f fVar, List<f> list, external.sdk.pendo.io.glide.load.data.a<Data> aVar) {
            this.a = (f) k.a(fVar);
            this.b = (List) k.a(list);
            this.c = (external.sdk.pendo.io.glide.load.data.a) k.a(aVar);
        }
    }

    a<Data> buildLoadData(Model model, int i, int i2, Options options);

    boolean handles(Model model);
}
