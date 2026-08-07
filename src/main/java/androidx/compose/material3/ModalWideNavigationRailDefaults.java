package androidx.compose.material3;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* JADX INFO: compiled from: WideNavigationRail.kt */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated(level = DeprecationLevel.WARNING, message = "Deprecated in favor of default values in WideNavigationRailDefaults", replaceWith = @ReplaceWith(expression = "WideNavigationRailDefaults", imports = {}))
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/material3/ModalWideNavigationRailDefaults;", "", "<init>", "()V", "Properties", "Landroidx/compose/material3/ModalWideNavigationRailProperties;", "getProperties$annotations", "getProperties", "()Landroidx/compose/material3/ModalWideNavigationRailProperties;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ModalWideNavigationRailDefaults {
    public static final int $stable = 0;
    public static final ModalWideNavigationRailDefaults INSTANCE = new ModalWideNavigationRailDefaults();
    private static final ModalWideNavigationRailProperties Properties = WideNavigationRail_androidKt.createDefaultModalWideNavigationRailProperties();

    @Deprecated(level = DeprecationLevel.WARNING, message = "Deprecated in favor of function with WideNavigationRailDefaults.ModalExpandedProperties", replaceWith = @ReplaceWith(expression = "WideNavigationRailDefaults.ModalExpandedProperties", imports = {}))
    public static /* synthetic */ void getProperties$annotations() {
    }

    private ModalWideNavigationRailDefaults() {
    }

    public final ModalWideNavigationRailProperties getProperties() {
        return Properties;
    }
}
