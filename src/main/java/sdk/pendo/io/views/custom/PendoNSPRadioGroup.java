package sdk.pendo.io.views.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.react.uimanager.ViewProps;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import sdk.pendo.io.actions.PendoCommand;
import sdk.pendo.io.actions.PendoCommandDispatcher;
import sdk.pendo.io.actions.PendoCommandEventType;
import sdk.pendo.io.c2.b;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.utilities.script.JavascriptRunner;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 ,2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001,B\u0013\b\u0016\u0012\b\u0010#\u001a\u0004\u0018\u00010\"¢\u0006\u0004\b$\u0010%B\u001d\b\u0016\u0012\b\u0010#\u001a\u0004\u0018\u00010\"\u0012\b\u0010'\u001a\u0004\u0018\u00010&¢\u0006\u0004\b$\u0010(B%\b\u0016\u0012\b\u0010#\u001a\u0004\u0018\u00010\"\u0012\b\u0010'\u001a\u0004\u0018\u00010&\u0012\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b$\u0010+J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0012\u0010\u0010\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0016\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0011H\u0016J\u0018\u0010\u0017\u001a\u00020\u00052\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001a\u001a\u00020\u000eH\u0016J\b\u0010\u001b\u001a\u00020\u000eH\u0016R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!¨\u0006-"}, d2 = {"Lsdk/pendo/io/views/custom/PendoNSPRadioGroup;", "Lsdk/pendo/io/views/custom/PendoMultipleRowViewGroup;", "Landroid/view/View$OnClickListener;", "Lsdk/pendo/io/views/custom/ViewBaseScriptBridge$RadioGroupScriptBridge;", "Lsdk/pendo/io/views/custom/ActionableBlock;", "", "init", "Landroid/view/View;", "child", "addView", "v", ViewProps.ON_CLICK, "", "getElementId", "", "valueString", "setOnSubmit", "Lsdk/pendo/io/c2/b;", "Lsdk/pendo/io/views/custom/ActionableBlock$OnSubmitAction;", "getOnSubmit", "", "Lsdk/pendo/io/actions/PendoCommand;", "commands", "setActions", "Lsdk/pendo/io/views/custom/ViewBaseScriptBridge;", "getViewScriptBridge", "getType", "getSelectedResponseId", "Lsdk/pendo/io/views/custom/PendoNSPRadioButton;", "chosenButton", "Lsdk/pendo/io/views/custom/PendoNSPRadioButton;", "", "mCommands", "Ljava/util/List;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class PendoNSPRadioGroup extends PendoMultipleRowViewGroup implements View.OnClickListener, ViewBaseScriptBridge.RadioGroupScriptBridge, ActionableBlock {
    public static final String DEFAULT_RESPONSE = "";
    private PendoNSPRadioButton chosenButton;
    private List<PendoCommand> mCommands;

    public PendoNSPRadioGroup(Context context) {
        super(context);
        init();
    }

    private final void init() {
    }

    @Override // android.view.ViewGroup
    public void addView(View child) {
        if (child != null) {
            child.setOnClickListener(this);
        }
        super.addView(child);
    }

    @Override // sdk.pendo.io.views.custom.ActionableBlock
    public CharSequence getElementId() {
        CharSequence contentDescription = getContentDescription();
        Intrinsics.checkNotNullExpressionValue(contentDescription, "getContentDescription(...)");
        return contentDescription;
    }

    @Override // sdk.pendo.io.views.custom.ActionableBlock
    public b<ActionableBlock.OnSubmitAction, String> getOnSubmit() {
        return null;
    }

    @Override // sdk.pendo.io.views.custom.ViewBaseScriptBridge.RadioGroupScriptBridge
    public String getSelectedResponseId() {
        String responseId;
        PendoNSPRadioButton pendoNSPRadioButton = this.chosenButton;
        return (pendoNSPRadioButton == null || (responseId = pendoNSPRadioButton.getResponseId()) == null) ? "" : responseId;
    }

    @Override // sdk.pendo.io.views.custom.ViewBaseScriptBridge
    public String getType() {
        String simpleName = Reflection.getOrCreateKotlinClass(PendoNSPRadioGroup.class).getSimpleName();
        return simpleName == null ? "PendoNSPRadioGroup" : simpleName;
    }

    @Override // sdk.pendo.io.views.custom.ViewBaseScriptBridge
    public ViewBaseScriptBridge getViewScriptBridge() {
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        if (!Intrinsics.areEqual(v, this.chosenButton)) {
            PendoNSPRadioButton pendoNSPRadioButton = this.chosenButton;
            if (pendoNSPRadioButton != null) {
                pendoNSPRadioButton.setChecked(false);
            }
            this.chosenButton = (PendoNSPRadioButton) v;
        }
        List<PendoCommand> list = this.mCommands;
        if (list == null || list.isEmpty()) {
            PendoLogger.d("No commands.", new Object[0]);
            return;
        }
        JavascriptRunner.GuideContext.addBasicParamsToGuideCommands(this.mCommands);
        PendoCommandDispatcher pendoCommandDispatcher = PendoCommandDispatcher.getInstance();
        List<PendoCommand> list2 = this.mCommands;
        Intrinsics.checkNotNull(list2);
        pendoCommandDispatcher.dispatchCommands(list2, PendoCommandEventType.UserEventType.TAP_ON, true);
    }

    @Override // sdk.pendo.io.views.custom.ActionableBlock
    public void setActions(List<PendoCommand> commands) {
        if (commands == null || commands.isEmpty()) {
            PendoLogger.d("No commands.", new Object[0]);
        } else {
            this.mCommands = commands;
        }
    }

    @Override // sdk.pendo.io.views.custom.ActionableBlock
    public void setOnSubmit(String valueString) {
    }

    public PendoNSPRadioGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public PendoNSPRadioGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }
}
