package com.pspdfkit.ui.inspector.views;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.pspdfkit.internal.fh;
import com.pspdfkit.internal.tx;
import com.pspdfkit.ui.inspector.PropertyInspectorController;
import com.pspdfkit.ui.inspector.PropertyInspectorView;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ContentEditingFontSizesPickerView extends RecyclerView implements PropertyInspectorView {
    private final List<Integer> availableFontSizes;
    private final FontPickerInspectorView.FontSizePickerListener listener;
    String unmatchedCurrentSize;

    public ContentEditingFontSizesPickerView(Context context, List<Integer> list, Integer num, String str, FontPickerInspectorView.FontSizePickerListener fontSizePickerListener) {
        super(context);
        this.unmatchedCurrentSize = null;
        this.availableFontSizes = list;
        this.listener = fontSizePickerListener;
        init(num, str);
    }

    private void init(Integer num, String str) {
        setAdapter(new fh(getContext(), this, this.availableFontSizes, num, str, this.listener));
        setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        addItemDecoration(new tx(getContext()));
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public void bindController(PropertyInspectorController propertyInspectorController) {
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public int getPropertyInspectorMaxHeight() {
        return getMeasuredHeight();
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public int getPropertyInspectorMinHeight() {
        return getMinimumHeight();
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public int getSuggestedHeight() {
        return getMeasuredHeight();
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public View getView() {
        return this;
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public void unbindController() {
    }
}
