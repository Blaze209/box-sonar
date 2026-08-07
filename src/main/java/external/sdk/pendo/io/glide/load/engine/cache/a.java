package external.sdk.pendo.io.glide.load.engine.cache;

import java.io.File;
import sdk.pendo.io.e.f;

/* JADX INFO: loaded from: classes4.dex */
public interface a {

    /* JADX INFO: renamed from: external.sdk.pendo.io.glide.load.engine.cache.a$a, reason: collision with other inner class name */
    public interface InterfaceC0311a {
        a build();
    }

    public interface b {
        boolean a(File file);
    }

    void clear();

    File get(f fVar);

    void put(f fVar, b bVar);
}
