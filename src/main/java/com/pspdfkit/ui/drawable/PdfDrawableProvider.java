package com.pspdfkit.ui.drawable;

import android.content.Context;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.ui.PageObjectProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b'\u0018\u00002\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J0\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0011\u001a\u00020\tH¦@¢\u0006\u0002\u0010\u0012J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0006J\u000e\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0006J\u0006\u0010\u0017\u001a\u00020\u0014J\u0010\u0010\u0017\u001a\u00020\u00142\b\b\u0001\u0010\u0011\u001a\u00020\tR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/pspdfkit/ui/drawable/PdfDrawableProvider;", "Lcom/pspdfkit/ui/PageObjectProvider;", "<init>", "()V", "drawableProviderObservers", "Ljava/util/ArrayList;", "Lcom/pspdfkit/ui/drawable/PdfDrawableProvider$DrawableProviderObserver;", "getFilteredPages", "", "", "getDrawablesForPage", "", "Lcom/pspdfkit/ui/drawable/PdfDrawable;", "context", "Landroid/content/Context;", "document", "Lcom/pspdfkit/document/PdfDocument;", "pageIndex", "(Landroid/content/Context;Lcom/pspdfkit/document/PdfDocument;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerDrawableProviderObserver", "", "drawableProviderObserver", "unregisterDrawableProviderObserver", "notifyDrawablesChanged", "DrawableProviderObserver", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class PdfDrawableProvider implements PageObjectProvider {
    public static final int $stable = 8;
    private final ArrayList<DrawableProviderObserver> drawableProviderObservers = new ArrayList<>();

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/pspdfkit/ui/drawable/PdfDrawableProvider$DrawableProviderObserver;", "", "onDrawablesChanged", "", "drawableProvider", "Lcom/pspdfkit/ui/drawable/PdfDrawableProvider;", "pageIndex", "", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public interface DrawableProviderObserver {
        void onDrawablesChanged(PdfDrawableProvider drawableProvider);

        void onDrawablesChanged(PdfDrawableProvider drawableProvider, int pageIndex);
    }

    public abstract Object getDrawablesForPage(Context context, PdfDocument pdfDocument, int i, Continuation<? super List<? extends PdfDrawable>> continuation);

    @Override // com.pspdfkit.ui.PageObjectProvider
    public Set<Integer> getFilteredPages() {
        return SetsKt.emptySet();
    }

    public final void notifyDrawablesChanged() {
        synchronized (this.drawableProviderObservers) {
            Iterator<DrawableProviderObserver> it = this.drawableProviderObservers.iterator();
            it.getClass();
            while (it.hasNext()) {
                DrawableProviderObserver next = it.next();
                next.getClass();
                next.onDrawablesChanged(this);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void registerDrawableProviderObserver(DrawableProviderObserver drawableProviderObserver) {
        drawableProviderObserver.getClass();
        synchronized (this.drawableProviderObservers) {
            if (!this.drawableProviderObservers.contains(drawableProviderObserver)) {
                this.drawableProviderObservers.add(drawableProviderObserver);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void unregisterDrawableProviderObserver(DrawableProviderObserver drawableProviderObserver) {
        drawableProviderObserver.getClass();
        synchronized (this.drawableProviderObservers) {
            this.drawableProviderObservers.remove(drawableProviderObserver);
        }
    }

    public final void notifyDrawablesChanged(int pageIndex) {
        synchronized (this.drawableProviderObservers) {
            Iterator<DrawableProviderObserver> it = this.drawableProviderObservers.iterator();
            it.getClass();
            while (it.hasNext()) {
                DrawableProviderObserver next = it.next();
                next.getClass();
                next.onDrawablesChanged(this, pageIndex);
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
