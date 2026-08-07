package external.sdk.pendo.io.glide.load.data.mediastore;

import java.io.File;

/* JADX INFO: loaded from: classes4.dex */
class a {
    a() {
    }

    public boolean a(File file) {
        return file.exists();
    }

    public long b(File file) {
        return file.length();
    }

    public File a(String str) {
        return new File(str);
    }
}
