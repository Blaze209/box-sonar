package expo.modules.ui;

import android.util.Log;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import com.box.android.domain.metrics.hubs.HubsObservability;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0012\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u001a\u0015\u0010\u0004\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005\u001a\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e\"\u0017\u0010\u0006\u001a\u00020\u0001*\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005\"\u0019\u0010\b\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"colorToComposeColorOrNull", "Landroidx/compose/ui/graphics/Color;", "color", "Landroid/graphics/Color;", "colorToComposeColor", "(Landroid/graphics/Color;)J", "compose", "getCompose", "composeOrNull", "getComposeOrNull", "(Landroid/graphics/Color;)Landroidx/compose/ui/graphics/Color;", "getImageVector", "Landroidx/compose/ui/graphics/vector/ImageVector;", HubsObservability.HUB_ASSET_ICON, "", "expo-ui_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class UtilsKt {
    public static final Color colorToComposeColorOrNull(android.graphics.Color color) {
        if (color != null) {
            return Color.m6804boximpl(ColorKt.Color$default(color.red(), color.green(), color.blue(), color.alpha(), null, 16, null));
        }
        return null;
    }

    public static final long colorToComposeColor(android.graphics.Color color) {
        Color colorColorToComposeColorOrNull = colorToComposeColorOrNull(color);
        return colorColorToComposeColorOrNull != null ? colorColorToComposeColorOrNull.m6824unboximpl() : Color.INSTANCE.m6850getUnspecified0d7_KjU();
    }

    public static final long getCompose(android.graphics.Color color) {
        return colorToComposeColor(color);
    }

    public static final Color getComposeOrNull(android.graphics.Color color) {
        return colorToComposeColorOrNull(color);
    }

    public static final ImageVector getImageVector(String str) {
        String str2 = str;
        if (str2 != null && str2.length() != 0) {
            try {
                List listSplit$default = StringsKt.split$default((CharSequence) str, new String[]{"."}, false, 0, 6, (Object) null);
                Class<?> cls = Class.forName("androidx.compose.material.icons." + ((String) listSplit$default.get(0)) + "." + ((String) listSplit$default.get(1)) + "Kt");
                Object objInvoke = cls.getDeclaredMethods()[0].invoke(Reflection.getOrCreateKotlinClass(cls.getClass()), null);
                Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type androidx.compose.ui.graphics.vector.ImageVector");
                return (ImageVector) objInvoke;
            } catch (Exception unused) {
                Log.w("ExpoUI", "The icon " + str + " couldn't be found.");
            }
        }
        return null;
    }
}
