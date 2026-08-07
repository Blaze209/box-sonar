package androidx.constraintlayout.compose;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: TransitionScope.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Landroidx/constraintlayout/compose/SwipeTouchUp;", "", "name", "", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "Companion", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SwipeTouchUp {
    public static final int $stable = 0;
    private final String name;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final SwipeTouchUp AutoComplete = new SwipeTouchUp("autocomplete");
    private static final SwipeTouchUp ToStart = new SwipeTouchUp("toStart");
    private static final SwipeTouchUp ToEnd = new SwipeTouchUp("toEnd");
    private static final SwipeTouchUp Stop = new SwipeTouchUp("stop");
    private static final SwipeTouchUp Decelerate = new SwipeTouchUp("decelerate");
    private static final SwipeTouchUp NeverCompleteStart = new SwipeTouchUp("neverCompleteStart");
    private static final SwipeTouchUp NeverCompleteEnd = new SwipeTouchUp("neverCompleteEnd");

    public SwipeTouchUp(String str) {
        this.name = str;
    }

    /* JADX INFO: compiled from: TransitionScope.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0011\u0010\u0011\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006¨\u0006\u0013"}, d2 = {"Landroidx/constraintlayout/compose/SwipeTouchUp$Companion;", "", "()V", "AutoComplete", "Landroidx/constraintlayout/compose/SwipeTouchUp;", "getAutoComplete", "()Landroidx/constraintlayout/compose/SwipeTouchUp;", "Decelerate", "getDecelerate", "NeverCompleteEnd", "getNeverCompleteEnd", "NeverCompleteStart", "getNeverCompleteStart", "Stop", "getStop", "ToEnd", "getToEnd", "ToStart", "getToStart", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SwipeTouchUp getAutoComplete() {
            return SwipeTouchUp.AutoComplete;
        }

        public final SwipeTouchUp getToStart() {
            return SwipeTouchUp.ToStart;
        }

        public final SwipeTouchUp getToEnd() {
            return SwipeTouchUp.ToEnd;
        }

        public final SwipeTouchUp getStop() {
            return SwipeTouchUp.Stop;
        }

        public final SwipeTouchUp getDecelerate() {
            return SwipeTouchUp.Decelerate;
        }

        public final SwipeTouchUp getNeverCompleteStart() {
            return SwipeTouchUp.NeverCompleteStart;
        }

        public final SwipeTouchUp getNeverCompleteEnd() {
            return SwipeTouchUp.NeverCompleteEnd;
        }
    }

    public final String getName() {
        return this.name;
    }
}
