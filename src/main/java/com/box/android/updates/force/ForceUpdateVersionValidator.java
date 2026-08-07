package com.box.android.updates.force;

import com.box.android.domain.util.VersionComparator;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ForceUpdateVersionValidator.kt */
/* JADX INFO: loaded from: classes13.dex */
@Singleton
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u001c\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bJ\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0007H\u0002¨\u0006\u000e"}, d2 = {"Lcom/box/android/updates/force/ForceUpdateVersionValidator;", "", "<init>", "()V", "isBelowMinVersion", "", "current", "", "minSupported", "isInBlocklist", "blocklist", "", "isNumericVersion", "version", "app-updates_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ForceUpdateVersionValidator {
    public static final int $stable = 0;

    @Inject
    public ForceUpdateVersionValidator() {
    }

    public final boolean isBelowMinVersion(String current, String minSupported) {
        String string;
        Intrinsics.checkNotNullParameter(current, "current");
        String string2 = StringsKt.trim((CharSequence) current).toString();
        if (minSupported == null || (string = StringsKt.trim((CharSequence) minSupported).toString()) == null || string2.length() == 0 || string.length() == 0 || !isNumericVersion(string2) || !isNumericVersion(string)) {
            return false;
        }
        return VersionComparator.INSTANCE.isLessThan(string2, string);
    }

    public final boolean isInBlocklist(String current, Set<String> blocklist) {
        Intrinsics.checkNotNullParameter(current, "current");
        Intrinsics.checkNotNullParameter(blocklist, "blocklist");
        String string = StringsKt.trim((CharSequence) current).toString();
        if (string.length() == 0 || blocklist.isEmpty()) {
            return false;
        }
        return blocklist.contains(string);
    }

    private final boolean isNumericVersion(String version) {
        List listSplit$default = StringsKt.split$default((CharSequence) version, new char[]{'.'}, false, 0, 6, (Object) null);
        if ((listSplit$default instanceof Collection) && listSplit$default.isEmpty()) {
            return true;
        }
        Iterator it = listSplit$default.iterator();
        while (it.hasNext()) {
            if (StringsKt.toLongOrNull((String) it.next()) == null) {
                return false;
            }
        }
        return true;
    }
}
