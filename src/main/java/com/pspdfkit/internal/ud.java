package com.pspdfkit.internal;

import android.content.Context;
import android.util.Log;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.pspdfkit.compose.theme.UiIconScheme;
import com.pspdfkit.document.PageBinding;
import com.pspdfkit.ui.documentinfo.OnDocumentInfoViewModeChangeListener;
import com.pspdfkit.ui.documentinfo.OnDocumentInfoViewSaveListener;
import io.nutrient.ui.theme.ThemeWrapperKt;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.text.Regex;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/pspdfkit/internal/ud;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ud extends ViewModel {
    public lm a;
    public final MutableStateFlow<rd> b;
    public final StateFlow<rd> c;
    public final MutableStateFlow<UiIconScheme> d;
    public final StateFlow<UiIconScheme> e;
    public final go<OnDocumentInfoViewModeChangeListener> f;
    public final go<OnDocumentInfoViewSaveListener> g;
    public final a h;

    public static final class a extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public final /* synthetic */ ud a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(CoroutineExceptionHandler.Companion companion, ud udVar) {
            super(companion);
            this.a = udVar;
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public final void handleException(CoroutineContext coroutineContext, Throwable th) {
            rd value;
            Log.w("Nutri.DocumentInfoVM", "Couldn't save document.", th);
            MutableStateFlow<rd> mutableStateFlow = this.a.b;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, rd.a(value, false, null, false, true, 3)));
        }
    }

    public ud() {
        MutableStateFlow<rd> MutableStateFlow = StateFlowKt.MutableStateFlow(new rd(0));
        this.b = MutableStateFlow;
        this.c = FlowKt.asStateFlow(MutableStateFlow);
        MutableStateFlow<UiIconScheme> MutableStateFlow2 = StateFlowKt.MutableStateFlow(ThemeWrapperKt.getDefaultUiIcons$default(null, 1, null));
        this.d = MutableStateFlow2;
        this.e = FlowKt.asStateFlow(MutableStateFlow2);
        this.f = new go<>();
        this.g = new go<>();
        this.h = new a(CoroutineExceptionHandler.INSTANCE, this);
    }

    public final void a(Context context) {
        rd value;
        rd value2;
        yd ydVar;
        List listEmptyList;
        lm lmVar;
        context.getClass();
        boolean z = this.c.getValue().c;
        go<OnDocumentInfoViewModeChangeListener> goVar = this.f;
        if (!z) {
            if (!goVar.a.isEmpty()) {
                Iterator<OnDocumentInfoViewModeChangeListener> it = this.f.iterator();
                while (it.hasNext()) {
                    if (it.next().onDocumentInfoViewEditingModeEnter()) {
                        return;
                    }
                }
            }
            MutableStateFlow<rd> mutableStateFlow = this.b;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, rd.a(value, false, null, true, false, 3)));
            return;
        }
        if (!goVar.a.isEmpty()) {
            Iterator<OnDocumentInfoViewModeChangeListener> it2 = this.f.iterator();
            while (it2.hasNext()) {
                if (it2.next().onDocumentInfoViewEditingModeExit()) {
                    return;
                }
            }
        }
        Iterator<ld> it3 = this.c.getValue().b.iterator();
        while (it3.hasNext()) {
            for (od odVar : it3.next().d) {
                odVar.getClass();
                lm lmVar2 = this.a;
                if (lmVar2 != null && (ydVar = lmVar2.i) != null) {
                    int iA = y30.a(odVar.a);
                    if (iA == 14) {
                        PageBinding pageBinding = ((tt) odVar).e;
                        if (pageBinding != PageBinding.UNKNOWN && (lmVar = this.a) != null) {
                            lmVar.setPageBinding(pageBinding);
                        }
                    } else if (iA == 0) {
                        ydVar.setTitle(odVar.a(context));
                    } else if (iA == 1) {
                        ydVar.setAuthor(odVar.a(context));
                    } else if (iA == 2) {
                        ydVar.setSubject(odVar.a(context));
                    } else if (iA == 3) {
                        String strA = odVar.a(context);
                        strA.getClass();
                        List<String> listSplit = new Regex(",\\s").split(strA, 0);
                        if (listSplit.isEmpty()) {
                            listEmptyList = CollectionsKt.emptyList();
                            break;
                        }
                        ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
                        while (true) {
                            if (listIterator.hasPrevious()) {
                                if (listIterator.previous().length() != 0) {
                                    listEmptyList = CollectionsKt.take(listSplit, listIterator.nextIndex() + 1);
                                    break;
                                }
                            } else {
                                listEmptyList = CollectionsKt.emptyList();
                                break;
                            }
                        }
                        String[] strArr = (String[]) listEmptyList.toArray(new String[0]);
                        ydVar.setKeywords(CollectionsKt.listOf(Arrays.copyOf(strArr, strArr.length)));
                    }
                }
            }
        }
        if (this.c.getValue().a) {
            MutableStateFlow<rd> mutableStateFlow2 = this.b;
            do {
                value2 = mutableStateFlow2.getValue();
            } while (!mutableStateFlow2.compareAndSet(value2, rd.a(value2, false, null, false, true, 3)));
            Log.w("Nutri.DocumentInfoVM", "Trying to save readonly document from DocumentInfo screen.");
            return;
        }
        lm lmVar3 = this.a;
        if (lmVar3 == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.h, null, new td(lmVar3, this, null), 2, null);
    }
}
