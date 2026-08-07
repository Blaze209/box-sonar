package com.pspdfkit.ui.inspector.views;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.pspdfkit.internal.ch;
import com.pspdfkit.internal.oa;
import com.pspdfkit.ui.fonts.Font;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ContentEditingFontNamesPickerView extends FontPickerInspectorDetailView {
    public ContentEditingFontNamesPickerView(Context context, List<Font> list, Font font, FontPickerInspectorView.FontPickerListener fontPickerListener) {
        super(context, list, font, fontPickerListener);
    }

    @Override // com.pspdfkit.ui.inspector.views.FontPickerInspectorDetailView
    public ch createAdapter(Context context, RecyclerView recyclerView, Font font, List<Font> list, FontPickerInspectorView.FontPickerListener fontPickerListener) {
        return new oa(getContext(), recyclerView, list, font, fontPickerListener);
    }
}
