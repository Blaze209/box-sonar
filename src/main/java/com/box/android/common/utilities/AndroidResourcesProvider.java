package com.box.android.common.utilities;

import java.util.Arrays;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ResourcesProvider.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J)\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\"\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/common/utilities/AndroidResourcesProvider;", "Lcom/box/android/common/utilities/ResourcesProvider;", "<init>", "()V", "getString", "", "resourceId", "", "formatArgs", "", "", "(I[Ljava/lang/Object;)Ljava/lang/String;", "common_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AndroidResourcesProvider implements ResourcesProvider {
    @Inject
    public AndroidResourcesProvider() {
    }

    @Override // com.box.android.common.utilities.ResourcesProvider
    public String getString(int resourceId) {
        String string = ApplicationProvider.getApplication().getResources().getString(resourceId);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @Override // com.box.android.common.utilities.ResourcesProvider
    public String getString(int resourceId, Object... formatArgs) {
        Intrinsics.checkNotNullParameter(formatArgs, "formatArgs");
        String string = ApplicationProvider.getApplication().getResources().getString(resourceId, Arrays.copyOf(formatArgs, formatArgs.length));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }
}
