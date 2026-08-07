package androidx.compose.ui.tooling.animation;

import androidx.compose.ui.tooling.data.Group;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnimationSearch.android.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class AnimationSearch_androidKt$findRememberedData$rememberCalls$1$1 implements Function1<Group, Boolean> {
    public static final AnimationSearch_androidKt$findRememberedData$rememberCalls$1$1 INSTANCE = new AnimationSearch_androidKt$findRememberedData$rememberCalls$1$1();

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(Group group) {
        return Boolean.valueOf(Intrinsics.areEqual(group.getName(), "remember"));
    }
}
