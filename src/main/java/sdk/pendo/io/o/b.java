package sdk.pendo.io.o;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

/* JADX INFO: loaded from: classes4.dex */
public final class b {
    private static volatile boolean a = true;

    public static Drawable a(Context context, int i, Resources.Theme theme) {
        return a(context, context, i, theme);
    }

    private static Drawable b(Context context, int i, Resources.Theme theme) {
        return ResourcesCompat.getDrawable(context.getResources(), i, theme);
    }

    private static Drawable c(Context context, int i, Resources.Theme theme) {
        if (theme != null) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, theme);
            contextThemeWrapper.applyOverrideConfiguration(theme.getResources().getConfiguration());
            context = contextThemeWrapper;
        }
        return AppCompatResources.getDrawable(context, i);
    }

    public static Drawable a(Context context, Context context2, int i) {
        return a(context, context2, i, null);
    }

    private static Drawable a(Context context, Context context2, int i, Resources.Theme theme) {
        try {
            if (a) {
                return c(context2, i, theme);
            }
        } catch (Resources.NotFoundException unused) {
        } catch (IllegalStateException e) {
            if (context.getPackageName().equals(context2.getPackageName())) {
                throw e;
            }
            return ContextCompat.getDrawable(context2, i);
        } catch (NoClassDefFoundError unused2) {
            a = false;
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        return b(context2, i, theme);
    }
}
