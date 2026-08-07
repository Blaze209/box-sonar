package com.pspdfkit.ui.inspector.views;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.pspdfkit.internal.ch;
import com.pspdfkit.internal.tx;
import com.pspdfkit.ui.fonts.Font;
import com.pspdfkit.ui.inspector.PropertyInspectorController;
import com.pspdfkit.ui.inspector.PropertyInspectorView;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class FontPickerInspectorDetailView extends RecyclerView implements PropertyInspectorView {
    private ch adapter;
    private final List<Font> availableFonts;
    private final FontPickerInspectorView.FontPickerListener listener;

    public FontPickerInspectorDetailView(Context context, List<Font> list, Font font, FontPickerInspectorView.FontPickerListener fontPickerListener) {
        super(context);
        this.availableFonts = list;
        this.listener = fontPickerListener;
        init(font);
    }

    private void init(Font font) {
        ch chVarCreateAdapter = createAdapter(getContext(), this, font, this.availableFonts, this.listener);
        this.adapter = chVarCreateAdapter;
        setAdapter(chVarCreateAdapter);
        setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        addItemDecoration(new tx(getContext()));
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public void bindController(PropertyInspectorController propertyInspectorController) {
    }

    public ch createAdapter(Context context, RecyclerView recyclerView, Font font, List<Font> list, FontPickerInspectorView.FontPickerListener fontPickerListener) {
        return new ch(context, this, list, font, fontPickerListener);
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
