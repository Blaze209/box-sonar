package com.pspdfkit.ui.toolbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.content.res.AppCompatResources;
import com.pspdfkit.Nutrient;
import com.pspdfkit.R;
import com.pspdfkit.analytics.Analytics;
import com.pspdfkit.configuration.policy.ApplicationPolicy;
import com.pspdfkit.datastructures.TextSelection;
import com.pspdfkit.document.sharing.DocumentSharingManager;
import com.pspdfkit.internal.ar;
import com.pspdfkit.internal.c60;
import com.pspdfkit.internal.i0;
import com.pspdfkit.internal.no;
import com.pspdfkit.internal.z8;
import com.pspdfkit.ui.special_mode.controller.TextSelectionController;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class TextSelectionToolbar extends ContextualToolbar<TextSelectionController> {
    private static final int[] ATTRS = R.styleable.pspdf__TextSelectionToolbarIcons;
    private static final int DEF_STYLE_ATTR = R.attr.pspdf__textSelectionToolbarIconsStyle;
    private boolean areItemsSet;
    TextSelectionController controller;
    private int copyIcon;
    private int highlightIcon;
    private int iconColor;
    private int iconColorActivated;
    private int linkIcon;
    private int searchIcon;
    private int shareIcon;
    private int speakIcon;

    public TextSelectionToolbar(Context context) {
        super(context);
        this.areItemsSet = false;
        init(context);
    }

    private void applyAnnotationControllerChanges() {
        TextSelectionController textSelectionController = this.controller;
        if (textSelectionController == null || this.areItemsSet) {
            return;
        }
        setMenuItems(generateMenuItems(textSelectionController));
        this.areItemsSet = true;
        notifyToolbarChanged();
    }

    private List<ContextualToolbarMenuItem> generateMenuItems(TextSelectionController textSelectionController) {
        Context context = getContext();
        ArrayList arrayList = new ArrayList(5);
        int i = R.id.pspdf__text_selection_toolbar_item_copy;
        Drawable drawable = AppCompatResources.getDrawable(context, this.copyIcon);
        String strA = no.a(context, R.string.pspdf__action_menu_copy, null);
        int i2 = this.iconColor;
        int i3 = this.iconColorActivated;
        ContextualToolbarMenuItem.Position position = ContextualToolbarMenuItem.Position.END;
        ContextualToolbarMenuItem contextualToolbarMenuItemCreateSingleItem = ContextualToolbarMenuItem.createSingleItem(context, i, drawable, strA, i2, i3, position, false);
        contextualToolbarMenuItemCreateSingleItem.setEnabled((textSelectionController == null || textSelectionController.isTextExtractionEnabledByDocumentPermissions()) && Nutrient.getApplicationPolicy().hasPermissionForEvent(ApplicationPolicy.PolicyEvent.TEXT_COPY_PASTE));
        arrayList.add(contextualToolbarMenuItemCreateSingleItem);
        ContextualToolbarMenuItem contextualToolbarMenuItemCreateSingleItem2 = ContextualToolbarMenuItem.createSingleItem(context, R.id.pspdf__text_selection_toolbar_item_highlight, AppCompatResources.getDrawable(context, this.highlightIcon), no.a(context, R.string.pspdf__edit_menu_highlight, null), this.iconColor, this.iconColorActivated, position, false);
        contextualToolbarMenuItemCreateSingleItem2.setEnabled(textSelectionController == null || textSelectionController.isTextHighlightingEnabledByConfiguration());
        arrayList.add(contextualToolbarMenuItemCreateSingleItem2);
        ContextualToolbarMenuItem contextualToolbarMenuItemCreateSingleItem3 = ContextualToolbarMenuItem.createSingleItem(context, R.id.pspdf__text_selection_toolbar_item_speak, AppCompatResources.getDrawable(context, this.speakIcon), no.a(context, R.string.pspdf__action_menu_speak, null), this.iconColor, this.iconColorActivated, position, false);
        contextualToolbarMenuItemCreateSingleItem3.setEnabled(textSelectionController == null || textSelectionController.isTextExtractionEnabledByDocumentPermissions() || textSelectionController.isTextSpeakEnabledByDocumentPermissions());
        arrayList.add(contextualToolbarMenuItemCreateSingleItem3);
        arrayList.add(ContextualToolbarMenuItem.createSingleItem(context, R.id.pspdf__text_selection_toolbar_item_search, AppCompatResources.getDrawable(context, this.searchIcon), no.a(context, R.string.pspdf__activity_menu_search, null), this.iconColor, this.iconColorActivated, position, false));
        if (textSelectionController != null && textSelectionController.isTextSharingEnabledByConfiguration()) {
            ContextualToolbarMenuItem contextualToolbarMenuItemCreateSingleItem4 = ContextualToolbarMenuItem.createSingleItem(context, R.id.pspdf__text_selection_toolbar_item_share, AppCompatResources.getDrawable(context, this.shareIcon), no.a(context, R.string.pspdf__share, null), this.iconColor, this.iconColorActivated, position, false);
            contextualToolbarMenuItemCreateSingleItem4.setEnabled(textSelectionController.isTextExtractionEnabledByDocumentPermissions() && Nutrient.getApplicationPolicy().hasPermissionForEvent(ApplicationPolicy.PolicyEvent.TEXT_COPY_PASTE));
            arrayList.add(contextualToolbarMenuItemCreateSingleItem4);
        }
        ContextualToolbarMenuItem contextualToolbarMenuItemCreateSingleItem5 = ContextualToolbarMenuItem.createSingleItem(context, R.id.pspdf__text_selection_toolbar_item_link, AppCompatResources.getDrawable(context, this.linkIcon), no.a(context, R.string.pspdf__create_link, null), this.iconColor, this.iconColorActivated, position, false);
        contextualToolbarMenuItemCreateSingleItem5.setEnabled(textSelectionController != null && textSelectionController.isLinkCreationEnabledByConfiguration());
        arrayList.add(contextualToolbarMenuItemCreateSingleItem5);
        return arrayList;
    }

    private void init(Context context) {
        setId(R.id.pspdf__text_selection_toolbar);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, ATTRS, DEF_STYLE_ATTR, 0);
        this.iconColor = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__TextSelectionToolbarIcons_pspdf__iconsColor, getDefaultIconsColor());
        this.iconColorActivated = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__TextSelectionToolbarIcons_pspdf__iconsColorActivated, getDefaultIconsColorActivated());
        this.shareIcon = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__TextSelectionToolbarIcons_pspdf__shareIcon, R.drawable.pspdf__ic_share);
        this.copyIcon = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__TextSelectionToolbarIcons_pspdf__copyIcon, R.drawable.pspdf__ic_content_copy);
        this.speakIcon = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__TextSelectionToolbarIcons_pspdf__speakIcon, R.drawable.pspdf__ic_hearing);
        this.highlightIcon = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__TextSelectionToolbarIcons_pspdf__highlightIcon, R.drawable.pspdf__ic_highlight);
        this.searchIcon = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__TextSelectionToolbarIcons_pspdf__searchIcon, R.drawable.pspdf__ic_search);
        this.linkIcon = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__TextSelectionToolbarIcons_pspdf__linkIcon, R.drawable.pspdf__ic_link);
        typedArrayObtainStyledAttributes.recycle();
        this.closeButton.setIconColor(this.iconColor);
        setDragButtonColor(this.iconColor);
    }

    @Override // com.pspdfkit.ui.toolbar.ContextualToolbar
    public void handleMenuItemClick(ContextualToolbarMenuItem contextualToolbarMenuItem) {
        TextSelectionController textSelectionController;
        TextSelectionController textSelectionController2 = this.controller;
        TextSelection textSelection = textSelectionController2 != null ? textSelectionController2.getTextSelection() : null;
        if (this.controller == null || textSelection == null) {
            return;
        }
        int id = contextualToolbarMenuItem.getId();
        if (contextualToolbarMenuItem == this.closeButton) {
            this.controller.exitActiveMode();
            return;
        }
        if (id == R.id.pspdf__text_selection_toolbar_item_share) {
            if (TextUtils.isEmpty(textSelection.text)) {
                return;
            }
            DocumentSharingManager.shareText(getContext(), textSelection.text);
            i0 i0VarA = ar.a();
            i0VarA.getClass();
            Bundle bundle = new Bundle();
            bundle.putString(Analytics.Data.ACTION, "share");
            bundle.putInt(Analytics.Data.PAGE_INDEX, textSelection.pageIndex);
            i0VarA.a(Analytics.Event.PERFORM_TEXT_SELECTION_ACTION, bundle);
            return;
        }
        if (id == R.id.pspdf__text_selection_toolbar_item_copy) {
            z8.a(textSelection.text, "", getContext(), R.string.pspdf__text_copied_to_clipboard, 48);
            this.controller.exitActiveMode();
            i0 i0VarA2 = ar.a();
            i0VarA2.getClass();
            Bundle bundle2 = new Bundle();
            bundle2.putString(Analytics.Data.ACTION, "clipboard");
            bundle2.putInt(Analytics.Data.PAGE_INDEX, textSelection.pageIndex);
            i0VarA2.a(Analytics.Event.PERFORM_TEXT_SELECTION_ACTION, bundle2);
            return;
        }
        if (id == R.id.pspdf__text_selection_toolbar_item_highlight) {
            this.controller.highlightSelectedText();
            return;
        }
        if (id != R.id.pspdf__text_selection_toolbar_item_speak) {
            if (id == R.id.pspdf__text_selection_toolbar_item_search) {
                TextSelectionController textSelectionController3 = this.controller;
                if (textSelectionController3 != null) {
                    textSelectionController3.searchSelectedText();
                    return;
                }
                return;
            }
            if (id != R.id.pspdf__text_selection_toolbar_item_link || (textSelectionController = this.controller) == null) {
                return;
            }
            textSelectionController.createLinkAboveSelectedText();
            return;
        }
        Context context = getContext();
        String str = textSelection.text;
        c60.a aVar = c60.a;
        if (aVar != null) {
            aVar.a();
            c60.a = null;
        }
        if (str != null) {
            c60.a = new c60.a(context, str);
        }
        i0 i0VarA3 = ar.a();
        i0VarA3.getClass();
        Bundle bundle3 = new Bundle();
        bundle3.putString(Analytics.Data.ACTION, "tts");
        bundle3.putInt(Analytics.Data.PAGE_INDEX, textSelection.pageIndex);
        i0VarA3.a(Analytics.Event.PERFORM_TEXT_SELECTION_ACTION, bundle3);
    }

    @Override // com.pspdfkit.ui.toolbar.ContextualToolbar
    public boolean isControllerBound() {
        return this.controller != null;
    }

    @Override // com.pspdfkit.ui.toolbar.ContextualToolbar
    public void unbindController() {
        if (this.controller != null) {
            this.controller = null;
            c60.a aVar = c60.a;
            if (aVar != null) {
                aVar.a();
                c60.a = null;
            }
        }
        this.areItemsSet = false;
    }

    @Override // com.pspdfkit.ui.toolbar.ContextualToolbar
    public void bindController(TextSelectionController textSelectionController) {
        unbindController();
        this.controller = textSelectionController;
        applyAnnotationControllerChanges();
    }

    public TextSelectionToolbar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.areItemsSet = false;
        init(context);
    }

    public TextSelectionToolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.areItemsSet = false;
        init(context);
    }
}
