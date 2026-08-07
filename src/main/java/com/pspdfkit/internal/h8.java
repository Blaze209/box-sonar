package com.pspdfkit.internal;

import android.content.Context;
import android.widget.LinearLayout;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.media3.extractor.WavUtil;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.pspdfkit.R;
import com.pspdfkit.bookmarks.Bookmark;
import com.pspdfkit.bookmarks.BookmarkProvider;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.ui.drawable.PdfDrawableManager;
import com.pspdfkit.ui.drawable.PdfDrawableProvider;
import com.pspdfkit.ui.outline.BookmarkViewAdapter;
import com.pspdfkit.utils.PdfLog;
import java.util.Collection;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import okio.Utf8;

/* JADX INFO: loaded from: classes3.dex */
public final class h8 extends nt<Bookmark> implements BookmarkProvider.BookmarkListener, PdfDrawableManager {
    public i8 d;
    public BookmarkViewAdapter e;
    public ot f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h8(Context context, ViewModelStoreOwner viewModelStoreOwner) {
        super(context, viewModelStoreOwner);
        context.getClass();
        b((lm) null, (PdfConfiguration) null);
    }

    public static final i8 e() {
        return new i8();
    }

    private final void setData(List<? extends Bookmark> list) {
        i8 i8Var = this.d;
        if (i8Var != null) {
            i8Var.a(list);
        }
    }

    @Override // com.pspdfkit.internal.nt
    public final void a(lm lmVar, PdfConfiguration pdfConfiguration) {
        b(lmVar, pdfConfiguration);
        if (this.b) {
            c();
        }
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.pspdfkit.ui.drawable.PdfDrawableManager
    public final void addDrawableProvider(PdfDrawableProvider pdfDrawableProvider) {
        pdfDrawableProvider.getClass();
        i8 i8Var = this.d;
        if (i8Var != null) {
            hu<PdfDrawableProvider> huVar = i8Var.a;
            huVar.getClass();
            huVar.b.a(pdfDrawableProvider);
            i8Var.b();
        }
    }

    @Override // com.pspdfkit.internal.nt
    public final void b() {
        if (this.b) {
            c();
        }
        i8 i8Var = this.d;
        if (i8Var != null) {
            i8Var.a(true);
        }
    }

    @Override // com.pspdfkit.internal.nt
    public final void c() {
        List<Bookmark> bookmarks;
        BookmarkViewAdapter bookmarkViewAdapter = this.e;
        if (bookmarkViewAdapter == null || (bookmarks = bookmarkViewAdapter.getBookmarks()) == null) {
            return;
        }
        setData(bookmarks);
    }

    public final void d() {
        StateFlow<f8> stateFlow;
        f8 value;
        i8 i8Var = this.d;
        if (i8Var == null || (stateFlow = i8Var.e) == null || (value = stateFlow.getValue()) == null || !value.l) {
            return;
        }
        int i = 0;
        for (Object obj : value.b) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Bookmark bookmark = (Bookmark) obj;
            BookmarkViewAdapter bookmarkViewAdapter = this.e;
            if (bookmarkViewAdapter != null) {
                bookmarkViewAdapter.onBookmarkPositionSet(bookmark, i);
            }
            i = i2;
        }
        i8 i8Var2 = this.d;
        if (i8Var2 != null) {
            i8Var2.a(value.b);
        }
        i8 i8Var3 = this.d;
        if (i8Var3 != null) {
            i8Var3.a();
        }
    }

    @Override // com.pspdfkit.internal.nt
    public int getTabButtonId() {
        return R.id.pspdf__menu_pdf_outline_view_bookmarks;
    }

    @Override // com.pspdfkit.internal.nt
    public String getTitle() {
        String strA = no.a(getContext(), R.string.pspdf__bookmarks, null);
        strA.getClass();
        return strA;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        BookmarkViewAdapter bookmarkViewAdapter = this.e;
        if (bookmarkViewAdapter != null) {
            bookmarkViewAdapter.addBookmarkListener(this);
        }
    }

    @Override // com.pspdfkit.bookmarks.BookmarkProvider.BookmarkListener
    public final void onBookmarkAdded(Bookmark bookmark) {
        f8 value;
        bookmark.getClass();
        i8 i8Var = this.d;
        if (i8Var != null) {
            MutableStateFlow<f8> mutableStateFlow = i8Var.d;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, f8.a(value, null, null, 0, null, false, false, false, false, null, false, bookmark, false, false, null, false, false, 31743)));
        }
    }

    @Override // com.pspdfkit.bookmarks.BookmarkProvider.BookmarkListener
    public final void onBookmarksChanged(List<? extends Bookmark> list) {
        list.getClass();
        setData(list);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        BookmarkViewAdapter bookmarkViewAdapter = this.e;
        if (bookmarkViewAdapter != null) {
            bookmarkViewAdapter.removeBookmarkListener(this);
        }
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.pspdfkit.ui.drawable.PdfDrawableManager
    public final void removeDrawableProvider(PdfDrawableProvider pdfDrawableProvider) {
        pdfDrawableProvider.getClass();
        i8 i8Var = this.d;
        if (i8Var != null) {
            hu<PdfDrawableProvider> huVar = i8Var.a;
            huVar.getClass();
            huVar.b.b(pdfDrawableProvider);
            i8Var.b();
        }
    }

    public final void setBookmarkAddingEnabled(boolean z) {
        f8 value;
        i8 i8Var = this.d;
        if (i8Var != null) {
            MutableStateFlow<f8> mutableStateFlow = i8Var.d;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, f8.a(value, null, null, 0, null, false, z, false, false, null, false, null, false, false, null, false, false, 65503)));
        }
    }

    public final void setBookmarkEditingEnabled(boolean z) {
        f8 value;
        i8 i8Var = this.d;
        if (i8Var != null) {
            MutableStateFlow<f8> mutableStateFlow = i8Var.d;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, f8.a(value, null, null, 0, null, false, false, false, z, null, false, null, false, false, null, false, false, 65407)));
        }
    }

    public final void setBookmarkRenamingEnabled(boolean z) {
        f8 value;
        i8 i8Var = this.d;
        if (i8Var != null) {
            MutableStateFlow<f8> mutableStateFlow = i8Var.d;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, f8.a(value, null, null, 0, null, false, false, z, false, null, false, null, false, false, null, false, false, 65471)));
        }
    }

    public final void setBookmarkViewAdapter(BookmarkViewAdapter bookmarkViewAdapter) {
        this.e = bookmarkViewAdapter;
        if (bookmarkViewAdapter != null) {
            bookmarkViewAdapter.addBookmarkListener(this);
        }
        if (this.b) {
            c();
        }
    }

    public final void setCurrentPageIndex(int i) {
        f8 value;
        i8 i8Var = this.d;
        if (i8Var != null) {
            MutableStateFlow<f8> mutableStateFlow = i8Var.d;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, f8.a(value, null, null, i, null, false, false, false, false, null, false, null, false, false, null, false, false, 65531)));
        }
    }

    @Override // com.pspdfkit.internal.nt
    public void setPageSelected(boolean z) {
        if (!z) {
            d();
        }
        super.setPageSelected(z);
    }

    public final void setRedactionAnnotationPreviewEnabled(boolean z) {
        k8 k8Var;
        i8 i8Var = this.d;
        if (i8Var == null || (k8Var = i8Var.c) == null) {
            return;
        }
        k8Var.e = z;
    }

    public final void setShowPageLabels(boolean z) {
        f8 value;
        i8 i8Var = this.d;
        if (i8Var != null) {
            MutableStateFlow<f8> mutableStateFlow = i8Var.d;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, f8.a(value, null, null, 0, null, z, false, false, false, null, false, null, false, false, null, false, false, 65519)));
        }
    }

    public static final boolean c(h8 h8Var, Bookmark bookmark) {
        bookmark.getClass();
        BookmarkViewAdapter bookmarkViewAdapter = h8Var.e;
        if (bookmarkViewAdapter != null) {
            return bookmarkViewAdapter.canRemoveBookmark(bookmark);
        }
        return false;
    }

    public static final boolean c(h8 h8Var) {
        BookmarkViewAdapter bookmarkViewAdapter = h8Var.e;
        if (bookmarkViewAdapter != null) {
            return bookmarkViewAdapter.isBookmarkAddButtonEnabled();
        }
        return false;
    }

    public static final Unit b(h8 h8Var, Bookmark bookmark) {
        bookmark.getClass();
        BookmarkViewAdapter bookmarkViewAdapter = h8Var.e;
        if (bookmarkViewAdapter != null) {
            bookmarkViewAdapter.onBookmarkRemove(bookmark);
        }
        return Unit.INSTANCE;
    }

    @Override // com.pspdfkit.internal.nt
    public final void a(ot otVar) {
        otVar.getClass();
        ot otVar2 = otVar;
        this.f = otVar2;
        i8 i8Var = this.d;
        if (i8Var == null) {
            return;
        }
        MutableStateFlow<f8> mutableStateFlow = i8Var.d;
        while (true) {
            f8 value = mutableStateFlow.getValue();
            if (mutableStateFlow.compareAndSet(value, f8.a(value, otVar2, null, 0, null, false, false, false, false, null, false, null, false, false, null, false, false, WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE))) {
                return;
            } else {
                otVar2 = otVar;
            }
        }
    }

    public static final Unit b(h8 h8Var) {
        f8 value;
        i8 i8Var = h8Var.d;
        if (i8Var != null) {
            MutableStateFlow<f8> mutableStateFlow = i8Var.d;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, f8.a(value, null, null, 0, null, false, false, false, false, null, false, null, false, false, null, false, false, 49151)));
        }
        return Unit.INSTANCE;
    }

    public static final Unit d(h8 h8Var) {
        f8 value;
        i8 i8Var = h8Var.d;
        if (i8Var != null) {
            MutableStateFlow<f8> mutableStateFlow = i8Var.d;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, f8.a(value, null, null, 0, null, false, false, false, false, null, false, null, false, false, null, false, false, 61439)));
        }
        return Unit.INSTANCE;
    }

    public final void b(lm lmVar, PdfConfiguration pdfConfiguration) {
        final StateFlow<f8> stateFlow;
        LifecycleOwner lifecycleOwner = ViewTreeLifecycleOwner.get(this);
        if (lifecycleOwner == null || lifecycleOwner.getLifecycle().getState() != Lifecycle.State.DESTROYED) {
            ViewModelStoreOwner viewModelStoreOwner = getViewModelStoreOwner();
            viewModelStoreOwner.getClass();
            i8 i8Var = (i8) new ViewModelProvider(viewModelStoreOwner, new v70(new Function0() { // from class: com.pspdfkit.internal.h8$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return h8.e();
                }
            })).get(String.valueOf(hashCode()), i8.class);
            Context context = getContext();
            context.getClass();
            i8Var.getClass();
            if (lmVar != null && pdfConfiguration != null) {
                i8Var.c = new k8(lmVar, context, pdfConfiguration);
                i8Var.b();
            } else {
                i8Var.c = null;
            }
            this.d = i8Var;
            ot otVar = this.f;
            if (otVar != null) {
                a(otVar);
            }
            i8 i8Var2 = this.d;
            if (i8Var2 == null || (stateFlow = i8Var2.e) == null) {
                return;
            }
            removeAllViews();
            Context context2 = getContext();
            context2.getClass();
            addView(y9.a(context2, ComposableLambdaKt.composableLambdaInstance(1830925369, true, new Function2() { // from class: com.pspdfkit.internal.h8$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return h8.a(this.f$0, stateFlow, (Composer) obj, ((Integer) obj2).intValue());
                }
            })), new LinearLayout.LayoutParams(-1, -2));
        }
    }

    public static final Unit d(h8 h8Var, Bookmark bookmark) {
        f8 value;
        bookmark.getClass();
        i8 i8Var = h8Var.d;
        if (i8Var != null) {
            MutableStateFlow<f8> mutableStateFlow = i8Var.d;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, f8.a(value, null, null, 0, null, false, false, false, false, null, false, null, false, true, bookmark, false, false, 53247)));
        }
        return Unit.INSTANCE;
    }

    @Override // com.pspdfkit.internal.nt
    public final void a() {
        d();
        i8 i8Var = this.d;
        if (i8Var != null) {
            i8Var.a(false);
        }
    }

    /* JADX WARN: Code duplicated, block: B:70:0x01a6  */
    public static final Unit a(final h8 h8Var, StateFlow stateFlow, Composer composer, int i) {
        Modifier modifier;
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1830925369, i, -1, "com.pspdfkit.internal.views.outline.BookmarkListView.setUpViews.<anonymous> (BookmarkListView.kt:194)");
            }
            h8Var.setId(R.id.pspdf__bookmark_list_view);
            final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(stateFlow, (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composer, 0, 7);
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            f8 f8Var = (f8) stateCollectAsStateWithLifecycle.getValue();
            boolean z = ((f8) stateCollectAsStateWithLifecycle.getValue()).l;
            boolean zChangedInstance = composer.changedInstance(h8Var);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.pspdfkit.internal.h8$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return h8.a(this.f$0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function0 function0 = (Function0) objRememberedValue;
            boolean zChanged = composer.changed(stateCollectAsStateWithLifecycle) | composer.changedInstance(h8Var);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.pspdfkit.internal.h8$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return h8.a(this.f$0, stateCollectAsStateWithLifecycle);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Function0 function1 = (Function0) objRememberedValue2;
            boolean zChangedInstance2 = composer.changedInstance(h8Var);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.pspdfkit.internal.h8$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return h8.a(this.f$0, (Bookmark) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            Function1 function2 = (Function1) objRememberedValue3;
            boolean zChangedInstance3 = composer.changedInstance(h8Var);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function2() { // from class: com.pspdfkit.internal.h8$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return h8.a(this.f$0, (Bookmark) obj, (String) obj2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            Function2 function3 = (Function2) objRememberedValue4;
            boolean zChangedInstance4 = composer.changedInstance(h8Var);
            Object objRememberedValue5 = composer.rememberedValue();
            if (zChangedInstance4 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new Function1() { // from class: com.pspdfkit.internal.h8$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return h8.b(this.f$0, (Bookmark) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            }
            Function1 function4 = (Function1) objRememberedValue5;
            boolean zChangedInstance5 = composer.changedInstance(h8Var);
            Object objRememberedValue6 = composer.rememberedValue();
            if (zChangedInstance5 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = new Function1() { // from class: com.pspdfkit.internal.h8$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(h8.c(this.f$0, (Bookmark) obj));
                    }
                };
                composer.updateRememberedValue(objRememberedValue6);
            }
            Function1 function5 = (Function1) objRememberedValue6;
            boolean zChangedInstance6 = composer.changedInstance(h8Var);
            Object objRememberedValue7 = composer.rememberedValue();
            if (zChangedInstance6 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue7 = new Function0() { // from class: com.pspdfkit.internal.h8$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(h8.c(this.f$0));
                    }
                };
                composer.updateRememberedValue(objRememberedValue7);
            }
            Function0 function6 = (Function0) objRememberedValue7;
            boolean zChangedInstance7 = composer.changedInstance(h8Var);
            Object objRememberedValue8 = composer.rememberedValue();
            if (zChangedInstance7 || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue8 = new Function0() { // from class: com.pspdfkit.internal.h8$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return h8.d(this.f$0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue8);
            }
            Function0 function7 = (Function0) objRememberedValue8;
            boolean zChangedInstance8 = composer.changedInstance(h8Var);
            Object objRememberedValue9 = composer.rememberedValue();
            if (zChangedInstance8 || objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue9 = new Function1() { // from class: com.pspdfkit.internal.h8$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return h8.d(this.f$0, (Bookmark) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue9);
            }
            Function1 function8 = (Function1) objRememberedValue9;
            boolean zChangedInstance9 = composer.changedInstance(h8Var);
            Object objRememberedValue10 = composer.rememberedValue();
            if (zChangedInstance9 || objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue10 = new Function0() { // from class: com.pspdfkit.internal.h8$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return h8.b(this.f$0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue10);
            }
            Function0 function9 = (Function0) objRememberedValue10;
            boolean zChangedInstance10 = composer.changedInstance(h8Var);
            Object objRememberedValue11 = composer.rememberedValue();
            if (zChangedInstance10) {
                modifier = modifierFillMaxSize$default;
            } else {
                modifier = modifierFillMaxSize$default;
                if (objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                }
                c8.a(modifier, f8Var, z, function0, function1, function2, function3, function4, function5, function6, function7, function8, function9, (Function2) objRememberedValue11, composer, 6, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            objRememberedValue11 = new Function2() { // from class: com.pspdfkit.internal.h8$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return h8.a(this.f$0, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                }
            };
            composer.updateRememberedValue(objRememberedValue11);
            c8.a(modifier, f8Var, z, function0, function1, function2, function3, function4, function5, function6, function7, function8, function9, (Function2) objRememberedValue11, composer, 6, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(h8 h8Var) {
        f8 value;
        BookmarkViewAdapter bookmarkViewAdapter = h8Var.e;
        if (bookmarkViewAdapter != null) {
            bookmarkViewAdapter.onBookmarkAdd();
        }
        i8 i8Var = h8Var.d;
        if (i8Var != null) {
            MutableStateFlow<f8> mutableStateFlow = i8Var.d;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, f8.a(value, null, null, 0, null, false, false, false, false, null, false, null, false, false, null, true, true, 15359)));
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(h8 h8Var, Bookmark bookmark) {
        f8 value;
        bookmark.getClass();
        i8 i8Var = h8Var.d;
        if (i8Var != null) {
            MutableStateFlow<f8> mutableStateFlow = i8Var.d;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, f8.a(value, null, null, 0, null, false, false, false, false, null, false, null, false, false, bookmark, false, false, GeneratorBase.SURR2_LAST)));
        }
        BookmarkViewAdapter bookmarkViewAdapter = h8Var.e;
        if (bookmarkViewAdapter != null) {
            bookmarkViewAdapter.onBookmarkClicked(bookmark);
        }
        nt.a aVar = h8Var.a;
        if (aVar != null) {
            aVar.hide();
        } else {
            PdfLog.e("OutlinePagerBaseView", "onHideListener is null! This shouldn't happen.\nMake sure you have called `PdfOutlineView#setDocument()` whenever a new document is loaded.", new Object[0]);
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(h8 h8Var, Bookmark bookmark, String str) {
        bookmark.getClass();
        str.getClass();
        h8Var.getClass();
        int length = str.length();
        BookmarkViewAdapter bookmarkViewAdapter = h8Var.e;
        if (length == 0) {
            if (bookmarkViewAdapter != null) {
                bookmarkViewAdapter.onBookmarkNameSet(bookmark, null);
            }
        } else if (bookmarkViewAdapter != null) {
            bookmarkViewAdapter.onBookmarkNameSet(bookmark, str);
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(h8 h8Var, int i, int i2) {
        f8 value;
        f8 f8VarA;
        i8 i8Var = h8Var.d;
        if (i8Var != null) {
            MutableStateFlow<f8> mutableStateFlow = i8Var.d;
            do {
                value = mutableStateFlow.getValue();
                f8VarA = value;
                List mutableList = CollectionsKt.toMutableList((Collection) f8VarA.b);
                if (i >= 0 && i < mutableList.size() && i2 >= 0 && i2 < mutableList.size() && i != i2) {
                    mutableList.add(i2, (Bookmark) mutableList.remove(i));
                    f8VarA = f8.a(f8VarA, null, ExtensionsKt.toImmutableList(mutableList), 0, null, false, false, false, false, null, false, null, false, false, null, false, false, Utf8.REPLACEMENT_CODE_POINT);
                }
            } while (!mutableStateFlow.compareAndSet(value, f8VarA));
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(h8 h8Var, State state) {
        if (((f8) state.getValue()).l) {
            h8Var.d();
        } else {
            i8 i8Var = h8Var.d;
            if (i8Var != null) {
                i8Var.a();
            }
        }
        return Unit.INSTANCE;
    }
}
