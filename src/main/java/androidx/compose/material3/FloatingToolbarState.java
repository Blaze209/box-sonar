package androidx.compose.material3;

import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: FloatingToolbar.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\bg\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eR\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R\u0018\u0010\u000b\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\f\u0010\u0005\"\u0004\b\r\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000fÀ\u0006\u0001"}, d2 = {"Landroidx/compose/material3/FloatingToolbarState;", "", "offsetLimit", "", "getOffsetLimit", "()F", "setOffsetLimit", "(F)V", "offset", "getOffset", "setOffset", "contentOffset", "getContentOffset", "setContentOffset", "Companion", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface FloatingToolbarState {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    float getContentOffset();

    float getOffset();

    float getOffsetLimit();

    void setContentOffset(float f);

    void setOffset(float f);

    void setOffsetLimit(float f);

    /* JADX INFO: compiled from: FloatingToolbar.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\f\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u00030\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/material3/FloatingToolbarState$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/FloatingToolbarState;", "getSaver$material3", "()Landroidx/compose/runtime/saveable/Saver;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Saver<FloatingToolbarState, ?> Saver = ListSaverKt.listSaver(new Function2() { // from class: androidx.compose.material3.FloatingToolbarState$Companion$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return FloatingToolbarState.Companion.Saver$lambda$0((SaverScope) obj, (FloatingToolbarState) obj2);
            }
        }, new Function1() { // from class: androidx.compose.material3.FloatingToolbarState$Companion$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FloatingToolbarState.Companion.Saver$lambda$1((List) obj);
            }
        });

        private Companion() {
        }

        public final Saver<FloatingToolbarState, ?> getSaver$material3() {
            return Saver;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List Saver$lambda$0(SaverScope saverScope, FloatingToolbarState floatingToolbarState) {
            return CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(floatingToolbarState.getOffsetLimit()), Float.valueOf(floatingToolbarState.getOffset()), Float.valueOf(floatingToolbarState.getContentOffset())});
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final FloatingToolbarState Saver$lambda$1(List list) {
            return FloatingToolbarKt.FloatingToolbarState(((Number) list.get(0)).floatValue(), ((Number) list.get(1)).floatValue(), ((Number) list.get(2)).floatValue());
        }
    }
}
