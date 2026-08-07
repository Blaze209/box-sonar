package androidx.compose.foundation.text.input.internal;

import androidx.compose.ui.text.style.TextDirection;
import java.util.Locale;
import kotlin.Metadata;

/* JADX INFO: compiled from: TextFieldLayoutStateCache.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H\u0000¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"resolveTextDirectionForKeyboardTypePhone", "Landroidx/compose/ui/text/style/TextDirection;", "locale", "Ljava/util/Locale;", "Landroidx/compose/ui/text/intl/PlatformLocale;", "(Ljava/util/Locale;)I", "foundation"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextFieldLayoutStateCache_androidKt {
    public static final int resolveTextDirectionForKeyboardTypePhone(Locale locale) {
        byte bResolve = DigitDirectionalityApi28.INSTANCE.resolve(locale);
        if (bResolve == 1 || bResolve == 2) {
            return TextDirection.INSTANCE.m9547getRtls_7Xco();
        }
        return TextDirection.INSTANCE.m9546getLtrs_7Xco();
    }
}
