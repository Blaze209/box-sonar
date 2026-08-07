package expo.modules.nativeelementsexpo;

import android.content.Context;
import android.util.TypedValue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MenuUtils.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a \u0010\u0005\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u00012\b\b\u0001\u0010\u0007\u001a\u00020\u0001H\u0001¨\u0006\b"}, d2 = {"dpToPx", "", "Landroid/content/Context;", "dp", "", "resolveThemeColor", "attr", "fallback", "cirrus-native-elements-expo_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class MenuUtilsKt {
    public static final int dpToPx(Context context, float f) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public static final int resolveThemeColor(Context context, int i, int i2) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        TypedValue typedValue = new TypedValue();
        boolean zResolveAttribute = context.getTheme().resolveAttribute(i, typedValue, true);
        if (!zResolveAttribute || typedValue.resourceId == 0) {
            return (!zResolveAttribute || typedValue.data == 0) ? i2 : typedValue.data;
        }
        return context.getColor(typedValue.resourceId);
    }
}
