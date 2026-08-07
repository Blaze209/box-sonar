package com.pspdfkit.internal;

import androidx.lifecycle.ViewModel;
import com.pspdfkit.bookmarks.Bookmark;
import com.pspdfkit.ui.drawable.PdfDrawableProvider;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/pspdfkit/internal/i8;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class i8 extends ViewModel {
    public final hu<PdfDrawableProvider> a = new hu<>(Schedulers.computation());
    public Disposable b;
    public k8 c;
    public final MutableStateFlow<f8> d;
    public final StateFlow<f8> e;

    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return ComparisonsKt.compareValues(((Bookmark) t).getSortKey(), ((Bookmark) t2).getSortKey());
        }
    }

    public static final class b<T> implements Consumer {
        public b() {
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Object obj) {
            List list = (List) obj;
            list.getClass();
            k8 k8Var = i8.this.c;
            if (k8Var != null) {
                k8Var.f.clear();
                k8Var.f.addAll(list);
            }
        }
    }

    public i8() {
        MutableStateFlow<f8> MutableStateFlow = StateFlowKt.MutableStateFlow(new f8(0));
        this.d = MutableStateFlow;
        this.e = FlowKt.asStateFlow(MutableStateFlow);
    }

    public final void a(boolean z) {
        f8 value;
        f8 value2;
        MutableStateFlow<f8> mutableStateFlow = this.d;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, f8.a(value, null, null, 0, null, false, false, false, false, null, z, null, false, false, null, false, false, 65023)));
        if (z) {
            return;
        }
        MutableStateFlow<f8> mutableStateFlow2 = this.d;
        do {
            value2 = mutableStateFlow2.getValue();
        } while (!mutableStateFlow2.compareAndSet(value2, f8.a(value2, null, null, 0, null, false, false, false, false, null, false, null, false, false, null, false, false, 63487)));
    }

    public final void b() {
        yz.a(this.b);
        this.b = null;
        hu<PdfDrawableProvider> huVar = this.a;
        this.b = huVar.a.toObservable().map(huVar.a()).subscribeOn(huVar.c).observeOn(AndroidSchedulers.mainThread()).take(1L).subscribe(new b());
    }

    @Override // androidx.lifecycle.ViewModel
    public final void onCleared() {
        super.onCleared();
        yz.a(this.b);
        this.b = null;
    }

    public final void a() {
        f8 value;
        MutableStateFlow<f8> mutableStateFlow = this.d;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, f8.a(value, null, null, 0, null, false, false, false, false, null, false, null, !this.d.getValue().l, false, null, false, false, 63487)));
    }

    public final void a(List<? extends Bookmark> list) {
        i8 i8Var = this;
        list.getClass();
        List listSortedWith = CollectionsKt.sortedWith(list, new a());
        MutableStateFlow<f8> mutableStateFlow = i8Var.d;
        while (true) {
            f8 value = mutableStateFlow.getValue();
            if (mutableStateFlow.compareAndSet(value, f8.a(value, null, listSortedWith, 0, i8Var.c, false, false, false, false, null, false, null, list.isEmpty() ? false : i8Var.d.getValue().l, false, null, false, false, 30709))) {
                return;
            } else {
                i8Var = this;
            }
        }
    }
}
