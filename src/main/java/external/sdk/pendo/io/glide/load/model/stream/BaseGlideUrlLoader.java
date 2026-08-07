package external.sdk.pendo.io.glide.load.model.stream;

import android.text.TextUtils;
import external.sdk.pendo.io.glide.load.Options;
import external.sdk.pendo.io.glide.load.model.GlideUrl;
import external.sdk.pendo.io.glide.load.model.a;
import external.sdk.pendo.io.glide.load.model.b;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import sdk.pendo.io.e.f;
import sdk.pendo.io.l.c;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseGlideUrlLoader<Model> implements b<Model, InputStream> {
    private final b<GlideUrl, InputStream> concreteLoader;
    private final c<Model, GlideUrl> modelCache;

    protected BaseGlideUrlLoader(b<GlideUrl, InputStream> bVar) {
        this(bVar, null);
    }

    private static List<f> getAlternateKeys(Collection<String> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(new GlideUrl(it.next()));
        }
        return arrayList;
    }

    @Override // external.sdk.pendo.io.glide.load.model.b
    public b.a<InputStream> buildLoadData(Model model, int i, int i2, Options options) {
        c<Model, GlideUrl> cVar = this.modelCache;
        GlideUrl glideUrlA = cVar != null ? cVar.a(model, i, i2) : null;
        if (glideUrlA == null) {
            String url = getUrl(model, i, i2, options);
            if (TextUtils.isEmpty(url)) {
                return null;
            }
            GlideUrl glideUrl = new GlideUrl(url, getHeaders(model, i, i2, options));
            c<Model, GlideUrl> cVar2 = this.modelCache;
            if (cVar2 != null) {
                cVar2.a(model, i, i2, glideUrl);
            }
            glideUrlA = glideUrl;
        }
        List<String> alternateUrls = getAlternateUrls(model, i, i2, options);
        b.a<InputStream> aVarBuildLoadData = this.concreteLoader.buildLoadData(glideUrlA, i, i2, options);
        return (aVarBuildLoadData == null || alternateUrls.isEmpty()) ? aVarBuildLoadData : new b.a<>(aVarBuildLoadData.a, getAlternateKeys(alternateUrls), aVarBuildLoadData.c);
    }

    protected List<String> getAlternateUrls(Model model, int i, int i2, Options options) {
        return Collections.emptyList();
    }

    protected a getHeaders(Model model, int i, int i2, Options options) {
        return a.b;
    }

    protected abstract String getUrl(Model model, int i, int i2, Options options);

    @Override // external.sdk.pendo.io.glide.load.model.b
    public abstract /* synthetic */ boolean handles(Object obj);

    protected BaseGlideUrlLoader(b<GlideUrl, InputStream> bVar, c<Model, GlideUrl> cVar) {
        this.concreteLoader = bVar;
        this.modelCache = cVar;
    }
}
