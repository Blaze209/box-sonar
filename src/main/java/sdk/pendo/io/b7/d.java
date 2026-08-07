package sdk.pendo.io.b7;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.media3.exoplayer.upstream.CmcdData;
import java.lang.reflect.Field;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lsdk/pendo/io/b7/d;", "", "Landroidx/drawerlayout/widget/DrawerLayout;", "drawerLayout", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Landroidx/drawerlayout/widget/DrawerLayout;)I", "", "b", "(Landroidx/drawerlayout/widget/DrawerLayout;)F", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class d {
    public static final d a = new d();

    private d() {
    }

    public final int a(DrawerLayout drawerLayout) {
        if (drawerLayout == null) {
            return -16777216;
        }
        try {
            Field declaredField = DrawerLayout.class.getDeclaredField("mScrimColor");
            declaredField.setAccessible(true);
            return declaredField.getInt(drawerLayout);
        } catch (Exception unused) {
            return -16777216;
        }
    }

    public final float b(DrawerLayout drawerLayout) {
        if (drawerLayout == null) {
            return 0.5f;
        }
        try {
            Field declaredField = DrawerLayout.class.getDeclaredField("mScrimOpacity");
            declaredField.setAccessible(true);
            return declaredField.getFloat(drawerLayout);
        } catch (Exception unused) {
            return 0.5f;
        }
    }
}
