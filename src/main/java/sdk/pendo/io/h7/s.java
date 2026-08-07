package sdk.pendo.io.h7;

import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import androidx.core.graphics.drawable.DrawableKt;
import androidx.media3.exoplayer.upstream.CmcdData;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0001\u0007B\u001d\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\f¨\u0006\u0010"}, d2 = {"Lsdk/pendo/io/h7/s;", "", "", "c", "Lsdk/pendo/io/h7/l;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/h7/l;", "b", "()Lsdk/pendo/io/h7/l;", "privacyMode", "", "", "Ljava/util/List;", "blockedSelectors", "<init>", "(Lsdk/pendo/io/h7/l;Ljava/util/List;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class s {

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<Bitmap> d = LazyKt.lazy(a.a);

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final l privacyMode;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final List<String> blockedSelectors;

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Landroid/graphics/Bitmap;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "()Landroid/graphics/Bitmap;"}, k = 3, mv = {1, 9, 0})
    static final class a extends Lambda implements Function0<Bitmap> {
        public static final a a = new a();

        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Bitmap invoke() {
            return DrawableKt.toBitmap$default(new ColorDrawable(-8355712), 1, 1, null, 4, null);
        }
    }

    /* JADX INFO: renamed from: sdk.pendo.io.h7.s$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lsdk/pendo/io/h7/s$b;", "", "Landroid/graphics/Bitmap;", "blockedBitmap$delegate", "Lkotlin/Lazy;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "()Landroid/graphics/Bitmap;", "blockedBitmap", "", "BLOCKED_PLACEHOLDER_COLOR", "I", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Bitmap a() {
            return (Bitmap) s.d.getValue();
        }
    }

    public s(l privacyMode, List<String> blockedSelectors) {
        Intrinsics.checkNotNullParameter(privacyMode, "privacyMode");
        Intrinsics.checkNotNullParameter(blockedSelectors, "blockedSelectors");
        this.privacyMode = privacyMode;
        this.blockedSelectors = blockedSelectors;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final l getPrivacyMode() {
        return this.privacyMode;
    }

    public final boolean c() {
        return this.blockedSelectors.contains("img");
    }
}
