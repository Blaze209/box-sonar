package com.pspdfkit.ui.inspector.views;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.pspdfkit.internal.bo;
import com.pspdfkit.internal.tx;
import com.pspdfkit.ui.inspector.PropertyInspectorController;
import com.pspdfkit.ui.inspector.PropertyInspectorView;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001!B;\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0001\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001b\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001c\u0010\u001aR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lcom/pspdfkit/ui/inspector/views/ContentEditingLineSpacingPickerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/pspdfkit/ui/inspector/PropertyInspectorView;", "Landroid/content/Context;", "context", "", "", "availablSizes", "defaultValue", "unsupportedCurrentValue", "Lcom/pspdfkit/ui/inspector/views/ContentEditingLineSpacingPickerView$LineSpacingPickerListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Landroid/content/Context;Ljava/util/List;Ljava/lang/Float;Ljava/lang/Float;Lcom/pspdfkit/ui/inspector/views/ContentEditingLineSpacingPickerView$LineSpacingPickerListener;)V", "Landroid/view/View;", "getView", "()Landroid/view/View;", "Lcom/pspdfkit/ui/inspector/PropertyInspectorController;", "controller", "", "bindController", "(Lcom/pspdfkit/ui/inspector/PropertyInspectorController;)V", "unbindController", "()V", "", "getPropertyInspectorMinHeight", "()I", "getPropertyInspectorMaxHeight", "getSuggestedHeight", "Ljava/util/List;", "Lcom/pspdfkit/internal/bo;", "adapter", "Lcom/pspdfkit/internal/bo;", "LineSpacingPickerListener", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ContentEditingLineSpacingPickerView extends RecyclerView implements PropertyInspectorView {
    public static final int $stable = 8;
    private bo adapter;
    private final List<Float> availablSizes;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/pspdfkit/ui/inspector/views/ContentEditingLineSpacingPickerView$LineSpacingPickerListener;", "", "onLineSpacingSelected", "", "lineSpacing", "", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public interface LineSpacingPickerListener {
        void onLineSpacingSelected(float lineSpacing);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentEditingLineSpacingPickerView(Context context, List<Float> list, Float f, Float f2, LineSpacingPickerListener lineSpacingPickerListener) {
        super(context);
        context.getClass();
        list.getClass();
        lineSpacingPickerListener.getClass();
        this.availablSizes = list;
        bo boVar = new bo(context, this, list, f, f2, lineSpacingPickerListener);
        this.adapter = boVar;
        setAdapter(boVar);
        setLayoutManager(new LinearLayoutManager(context, 1, false));
        addItemDecoration(new tx(context));
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public void bindController(PropertyInspectorController controller) {
        controller.getClass();
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
