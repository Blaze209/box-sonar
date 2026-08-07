package com.box.android.preview.previewtype.document.copytext;

import android.graphics.RectF;
import com.box.android.cpl.Store;
import com.box.android.preview.document.copytext.CopySelectedTextReducer;
import com.pspdfkit.datastructures.TextSelection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DocumentTextSelectionListener.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J1\u0010\b\u001a\u00020\r2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0007¢\u0006\u0002\u0010\u0015J\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u0010*\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002J\u001c\u0010\u0017\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000bH\u0016R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/box/android/preview/previewtype/document/copytext/DocumentTextSelectionListener;", "Lcom/pspdfkit/ui/special_mode/manager/TextSelectionManager$OnTextSelectionChangeListener;", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/preview/document/copytext/CopySelectedTextReducer$State;", "Lcom/box/android/preview/document/copytext/CopySelectedTextReducer$Action;", "<init>", "(Lcom/box/android/cpl/Store;)V", "onBeforeTextSelectionChange", "", "newTextSelection", "Lcom/pspdfkit/datastructures/TextSelection;", "previousTextSelection", "", "textBlocks", "", "Landroid/graphics/RectF;", "text", "", "pageIndex", "", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;)V", "getBoundingBox", "onAfterTextSelectionChange", "currentTextSelection", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DocumentTextSelectionListener implements com.pspdfkit.ui.special_mode.manager.TextSelectionManager.OnTextSelectionChangeListener {
    public static final int $stable = 0;
    private final Store<CopySelectedTextReducer.State, CopySelectedTextReducer.Action> store;

    @Override // com.pspdfkit.ui.special_mode.manager.TextSelectionManager.OnTextSelectionChangeListener
    public void onAfterTextSelectionChange(TextSelection newTextSelection, TextSelection currentTextSelection) {
    }

    public DocumentTextSelectionListener(Store<CopySelectedTextReducer.State, CopySelectedTextReducer.Action> store) {
        Intrinsics.checkNotNullParameter(store, "store");
        this.store = store;
    }

    @Override // com.pspdfkit.ui.special_mode.manager.TextSelectionManager.OnTextSelectionChangeListener
    public boolean onBeforeTextSelectionChange(TextSelection newTextSelection, TextSelection previousTextSelection) {
        onBeforeTextSelectionChange(newTextSelection != null ? newTextSelection.textBlocks : null, newTextSelection != null ? newTextSelection.text : null, newTextSelection != null ? Integer.valueOf(newTextSelection.pageIndex) : null);
        return true;
    }

    public final void onBeforeTextSelectionChange(List<? extends RectF> textBlocks, String text, Integer pageIndex) {
        RectF boundingBox = textBlocks != null ? getBoundingBox(textBlocks) : null;
        if (boundingBox == null || text == null || pageIndex == null) {
            this.store.send(new CopySelectedTextReducer.Action.TextSelected(null));
        } else {
            this.store.send(new CopySelectedTextReducer.Action.TextSelected(new CopySelectedTextReducer.TextSelection(text, boundingBox, pageIndex.intValue())));
        }
    }

    private final RectF getBoundingBox(List<? extends RectF> list) {
        if (list.isEmpty()) {
            return null;
        }
        List<? extends RectF> list2 = list;
        Iterator<T> it = list2.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        float fMin = ((RectF) it.next()).left;
        while (it.hasNext()) {
            fMin = Math.min(fMin, ((RectF) it.next()).left);
        }
        Iterator<T> it2 = list2.iterator();
        if (!it2.hasNext()) {
            throw new NoSuchElementException();
        }
        float fMax = ((RectF) it2.next()).top;
        while (it2.hasNext()) {
            fMax = Math.max(fMax, ((RectF) it2.next()).top);
        }
        Iterator<T> it3 = list2.iterator();
        if (!it3.hasNext()) {
            throw new NoSuchElementException();
        }
        float fMax2 = ((RectF) it3.next()).right;
        while (it3.hasNext()) {
            fMax2 = Math.max(fMax2, ((RectF) it3.next()).right);
        }
        Iterator<T> it4 = list2.iterator();
        if (it4.hasNext()) {
            float fMin2 = ((RectF) it4.next()).bottom;
            while (it4.hasNext()) {
                fMin2 = Math.min(fMin2, ((RectF) it4.next()).bottom);
            }
            return new RectF(fMin, fMax, fMax2, fMin2);
        }
        throw new NoSuchElementException();
    }
}
