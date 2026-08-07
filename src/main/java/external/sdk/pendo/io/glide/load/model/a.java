package external.sdk.pendo.io.glide.load.model;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public interface a {

    @Deprecated
    public static final a a = new C0314a();
    public static final a b = new LazyHeaders.a().a();

    /* JADX INFO: renamed from: external.sdk.pendo.io.glide.load.model.a$a, reason: collision with other inner class name */
    class C0314a implements a {
        C0314a() {
        }

        @Override // external.sdk.pendo.io.glide.load.model.a
        public Map<String, String> getHeaders() {
            return Collections.emptyMap();
        }
    }

    Map<String, String> getHeaders();
}
