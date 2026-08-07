package sdk.pendo.io.t7;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.s7.e1;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lsdk/pendo/io/t7/a;", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class a {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: sdk.pendo.io.t7.a$a, reason: collision with other inner class name and from kotlin metadata */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ$\u0010\n\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u0018\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\u000e"}, d2 = {"Lsdk/pendo/io/t7/a$a;", "", "", "Lsdk/pendo/io/s7/e1$a;", "viewRoots", "Landroid/graphics/Bitmap;", "bitmap", "Lsdk/pendo/io/t7/c;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "config", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(List<? extends e1.a> viewRoots, Bitmap bitmap, c listener) {
            Intrinsics.checkNotNullParameter(viewRoots, "viewRoots");
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            Intrinsics.checkNotNullParameter(listener, "listener");
            Iterator<T> it = viewRoots.iterator();
            while (it.hasNext()) {
                a.INSTANCE.a((e1.a) it.next(), bitmap);
            }
            listener.a(bitmap);
        }

        public final void a(e1.a config, Bitmap bitmap) {
            WeakReference<View> weakReference;
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            if (config == null || config.b() == null || config.a() == null || (weakReference = config.a) == null) {
                PendoLogger.e("drawRootToBitmap() config can't be null", new Object[0]);
                return;
            }
            View view = weakReference.get();
            if (view == null) {
                PendoLogger.e("drawRootToBitmap() -> root view is null", new Object[0]);
                return;
            }
            if ((config.a().flags & 2) == 2) {
                new Canvas(bitmap).drawARGB((int) (255 * config.a().dimAmount), 0, 0, 0);
            }
            Canvas canvas = new Canvas(bitmap);
            canvas.translate(config.b().left, config.b().top);
            try {
                view.draw(canvas);
            } catch (IllegalArgumentException e) {
                PendoLogger.d(e, "drawRootToBitmap() failed to draw root view - software rendering doesn't support hardware bitmaps", new Object[0]);
            }
        }
    }
}
