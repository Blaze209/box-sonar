package external.sdk.pendo.io.glide.load.engine;

import external.sdk.pendo.io.glide.load.Options;
import java.io.File;

/* JADX INFO: loaded from: classes4.dex */
class d<DataType> implements external.sdk.pendo.io.glide.load.engine.cache.a.b {
    private final sdk.pendo.io.e.d<DataType> a;
    private final DataType b;
    private final Options c;

    d(sdk.pendo.io.e.d<DataType> dVar, DataType datatype, Options options) {
        this.a = dVar;
        this.b = datatype;
        this.c = options;
    }

    @Override // external.sdk.pendo.io.glide.load.engine.cache.a.b
    public boolean a(File file) {
        return this.a.encode(this.b, file, this.c);
    }
}
