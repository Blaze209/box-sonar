package expo.modules.ui.menu;

import expo.modules.kotlin.viewevent.ViewEventCallback;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ContextMenu.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final class ContextMenuKt$sam$expo_modules_kotlin_viewevent_ViewEventCallback$0 implements ViewEventCallback, FunctionAdapter {
    private final /* synthetic */ Function1 function;

    ContextMenuKt$sam$expo_modules_kotlin_viewevent_ViewEventCallback$0(Function1 function) {
        Intrinsics.checkNotNullParameter(function, "function");
        this.function = function;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof ViewEventCallback) && (obj instanceof FunctionAdapter)) {
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.FunctionAdapter
    public final Function<?> getFunctionDelegate() {
        return this.function;
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    @Override // expo.modules.kotlin.viewevent.ViewEventCallback
    public final /* synthetic */ void invoke(Object obj) {
        this.function.invoke(obj);
    }
}
