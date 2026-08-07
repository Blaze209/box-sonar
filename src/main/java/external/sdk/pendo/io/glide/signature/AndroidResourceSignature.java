package external.sdk.pendo.io.glide.signature;

import android.content.Context;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import sdk.pendo.io.e.f;
import sdk.pendo.io.x.a;
import sdk.pendo.io.y.l;

/* JADX INFO: loaded from: classes4.dex */
public final class AndroidResourceSignature implements f {
    private final f applicationVersion;
    private final int nightMode;

    private AndroidResourceSignature(int i, f fVar) {
        this.nightMode = i;
        this.applicationVersion = fVar;
    }

    public static f obtain(Context context) {
        return new AndroidResourceSignature(context.getResources().getConfiguration().uiMode & 48, a.b(context));
    }

    @Override // sdk.pendo.io.e.f
    public boolean equals(Object obj) {
        if (obj instanceof AndroidResourceSignature) {
            AndroidResourceSignature androidResourceSignature = (AndroidResourceSignature) obj;
            if (this.nightMode == androidResourceSignature.nightMode && this.applicationVersion.equals(androidResourceSignature.applicationVersion)) {
                return true;
            }
        }
        return false;
    }

    @Override // sdk.pendo.io.e.f
    public int hashCode() {
        return l.a(this.applicationVersion, this.nightMode);
    }

    @Override // sdk.pendo.io.e.f
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        this.applicationVersion.updateDiskCacheKey(messageDigest);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.nightMode).array());
    }
}
