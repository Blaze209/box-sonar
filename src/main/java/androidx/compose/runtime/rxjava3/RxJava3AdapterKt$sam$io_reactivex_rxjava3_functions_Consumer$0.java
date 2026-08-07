package androidx.compose.runtime.rxjava3;

import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: RxJava3Adapter.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class RxJava3AdapterKt$sam$io_reactivex_rxjava3_functions_Consumer$0 implements Consumer {
    private final /* synthetic */ Function1 function;

    RxJava3AdapterKt$sam$io_reactivex_rxjava3_functions_Consumer$0(Function1 function1) {
        this.function = function1;
    }

    @Override // io.reactivex.rxjava3.functions.Consumer
    public final /* synthetic */ void accept(Object obj) {
        this.function.invoke(obj);
    }
}
