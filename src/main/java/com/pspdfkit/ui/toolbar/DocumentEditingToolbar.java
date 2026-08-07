package com.pspdfkit.ui.toolbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import com.pspdfkit.R;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.internal.no;
import com.pspdfkit.internal.uc;
import com.pspdfkit.preferences.PSPDFKitPreferences;
import com.pspdfkit.ui.PdfFragment;
import com.pspdfkit.ui.special_mode.controller.DocumentEditingController;
import com.pspdfkit.ui.special_mode.manager.DocumentEditingManager;
import com.pspdfkit.ui.toolbar.grouping.presets.DocumentEditingToolbarGroupingRule;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public class DocumentEditingToolbar extends ContextualToolbar<DocumentEditingController> implements DocumentEditingManager.OnDocumentEditingPageSelectionChangeListener, UndoRedoToolbarHelper.UndoRedoToolbarHost {
    private static final int[] ATTRS = R.styleable.pspdf__DocumentEditingToolbarIcons;
    private static final int DEF_STYLE_ATTR = R.attr.pspdf__documentEditingToolbarIconsStyle;
    DocumentEditingController controller;
    private int doneIcon;
    private int duplicatePagesIcon;
    private int exportPagesIcon;
    private int iconColor;
    private int iconColorActivated;
    private int importDocumentIcon;
    private int moreIcon;
    private int redoIcon;
    private int removePagesIcon;
    private int rotatePagesIcon;
    private int undoIcon;
    private UndoRedoToolbarHelper undoRedoHelper;

    public DocumentEditingToolbar(Context context) {
        super(context);
        init(context);
    }

    private void applyControllerChanges() {
        DocumentEditingController documentEditingController = this.controller;
        if (documentEditingController == null) {
            return;
        }
        boolean z = !documentEditingController.getSelectedPages().isEmpty();
        setMenuItemEnabled(R.id.pspdf__document_editing_toolbar_item_duplicate_pages, z);
        setMenuItemEnabled(R.id.pspdf__document_editing_toolbar_item_rotate_pages, z);
        setMenuItemEnabled(R.id.pspdf__document_editing_toolbar_item_export_pages, z);
        setMenuItemEnabled(R.id.pspdf__document_editing_toolbar_item_remove_pages, z);
        setMenuItemVisibility(R.id.pspdf__document_editing_toolbar_item_export_pages, this.controller.isExportEnabled() ? 0 : 8);
        this.undoRedoHelper.updateUndoRedoButtons(new Function2() { // from class: com.pspdfkit.ui.toolbar.DocumentEditingToolbar$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return this.f$0.lambda$applyControllerChanges$0((Boolean) obj, (Boolean) obj2);
            }
        });
        notifyToolbarChanged();
    }

    private List<ContextualToolbarMenuItem> generateMenuItems() {
        Context context = getContext();
        ArrayList arrayList = new ArrayList();
        int i = R.id.pspdf__document_editing_toolbar_item_rotate_pages;
        Drawable drawable = AppCompatResources.getDrawable(context, this.rotatePagesIcon);
        String strA = no.a(context, R.string.pspdf__rotate_pages, null);
        int i2 = this.iconColor;
        int i3 = this.iconColorActivated;
        ContextualToolbarMenuItem.Position position = ContextualToolbarMenuItem.Position.START;
        arrayList.add(ContextualToolbarMenuItem.createSingleItem(context, i, drawable, strA, i2, i3, position, false));
        arrayList.add(ContextualToolbarMenuItem.createSingleItem(context, R.id.pspdf__document_editing_toolbar_item_duplicate_pages, AppCompatResources.getDrawable(context, this.duplicatePagesIcon), no.a(context, R.string.pspdf__duplicate_pages, null), this.iconColor, this.iconColorActivated, position, false));
        arrayList.add(ContextualToolbarMenuItem.createSingleItem(context, R.id.pspdf__document_editing_toolbar_item_remove_pages, AppCompatResources.getDrawable(context, this.removePagesIcon), no.a(context, R.string.pspdf__delete_pages, null), this.iconColor, this.iconColorActivated, position, false));
        arrayList.add(ContextualToolbarMenuItem.createSingleItem(context, R.id.pspdf__document_editing_toolbar_item_done, AppCompatResources.getDrawable(context, this.doneIcon), no.a(context, R.string.pspdf__save, null), this.iconColor, this.iconColorActivated, ContextualToolbarMenuItem.Position.END, false));
        ContextualToolbarMenuItem contextualToolbarMenuItemCreateSingleItem = ContextualToolbarMenuItem.createSingleItem(context, R.id.pspdf__document_editing_toolbar_item_undo, AppCompatResources.getDrawable(context, this.undoIcon), no.a(context, R.string.pspdf__undo, null), this.iconColor, this.iconColorActivated, position, false);
        contextualToolbarMenuItemCreateSingleItem.setEnabled(false);
        arrayList.add(contextualToolbarMenuItemCreateSingleItem);
        ContextualToolbarMenuItem contextualToolbarMenuItemCreateSingleItem2 = ContextualToolbarMenuItem.createSingleItem(context, R.id.pspdf__document_editing_toolbar_item_redo, AppCompatResources.getDrawable(context, this.redoIcon), no.a(context, R.string.pspdf__redo, null), this.iconColor, this.iconColorActivated, position, false);
        contextualToolbarMenuItemCreateSingleItem2.setEnabled(false);
        arrayList.add(contextualToolbarMenuItemCreateSingleItem2);
        arrayList.add(ContextualToolbarMenuItem.createGroupItem(R.id.pspdf__document_editing_toolbar_group_more, position, false, new ArrayList(), ContextualToolbarMenuItem.createSingleItem(context, R.id.pspdf__document_editing_toolbar_group_more, AppCompatResources.getDrawable(context, this.moreIcon), no.a(context, R.string.pspdf__more_options, null), this.iconColor, this.iconColorActivated, position, false)));
        arrayList.add(ContextualToolbarMenuItem.createSingleItem(context, R.id.pspdf__document_editing_toolbar_item_export_pages, AppCompatResources.getDrawable(context, this.exportPagesIcon), no.a(context, R.string.pspdf__export_pages, null), this.iconColor, this.iconColorActivated, position, false));
        arrayList.add(ContextualToolbarMenuItem.createSingleItem(context, R.id.pspdf__document_editing_toolbar_item_import_document, AppCompatResources.getDrawable(context, this.importDocumentIcon), no.a(context, R.string.pspdf__import_document, null), this.iconColor, this.iconColorActivated, position, false));
        return arrayList;
    }

    private void init(Context context) {
        setId(R.id.pspdf__document_editing_toolbar);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, ATTRS, DEF_STYLE_ATTR, 0);
        this.iconColor = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__DocumentEditingToolbarIcons_pspdf__iconsColor, getDefaultIconsColor());
        this.iconColorActivated = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__DocumentEditingToolbarIcons_pspdf__iconsColorActivated, getDefaultIconsColorActivated());
        this.undoIcon = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__DocumentEditingToolbarIcons_pspdf__undoIcon, R.drawable.pspdf__ic_undo);
        this.redoIcon = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__DocumentEditingToolbarIcons_pspdf__redoIcon, R.drawable.pspdf__ic_redo);
        this.rotatePagesIcon = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__DocumentEditingToolbarIcons_pspdf__rotatePagesIcon, R.drawable.pspdf__ic_rotate_page);
        this.removePagesIcon = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__DocumentEditingToolbarIcons_pspdf__removePagesIcon, R.drawable.pspdf__ic_delete);
        this.exportPagesIcon = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__DocumentEditingToolbarIcons_pspdf__exportPagesIcon, R.drawable.pspdf__ic_export_pages);
        this.importDocumentIcon = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__DocumentEditingToolbarIcons_pspdf__importDocumentIcon, R.drawable.pspdf__ic_import_documents);
        this.duplicatePagesIcon = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__DocumentEditingToolbarIcons_pspdf__duplicatePagesIcon, R.drawable.pspdf__ic_duplicate_page);
        this.moreIcon = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__DocumentEditingToolbarIcons_pspdf__moreIcon, R.drawable.pspdf__ic_more_horizontal);
        this.doneIcon = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__DocumentEditingToolbarIcons_pspdf__doneIcon, R.drawable.pspdf__ic_done);
        typedArrayObtainStyledAttributes.recycle();
        this.closeButton.setIconColor(this.iconColor);
        this.closeButton.setIcon(AppCompatResources.getDrawable(context, R.drawable.pspdf__ic_arrow_back));
        setDragButtonColor(this.iconColor);
        setDraggable(true);
        setLayoutParams(new ToolbarCoordinatorLayout.LayoutParams(PSPDFKitPreferences.get(getContext()).getLastToolbarPosition(this, uc.a(getContext(), 540) ? ToolbarCoordinatorLayout.LayoutParams.Position.LEFT : ToolbarCoordinatorLayout.LayoutParams.Position.TOP), EnumSet.allOf(ToolbarCoordinatorLayout.LayoutParams.Position.class)));
        setUseBackButtonForCloseWhenHorizontal(false);
        setMenuItemGroupingRule(new DocumentEditingToolbarGroupingRule(context));
        this.undoRedoHelper = new UndoRedoToolbarHelper(this, 0, R.id.pspdf__document_editing_toolbar_item_undo, R.id.pspdf__document_editing_toolbar_item_redo);
        setMenuItems(generateMenuItems());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$applyControllerChanges$0(Boolean bool, Boolean bool2) {
        setMenuItemEnabled(R.id.pspdf__document_editing_toolbar_item_done, bool.booleanValue() && !this.controller.isDocumentEmpty());
        return Unit.INSTANCE;
    }

    @Override // com.pspdfkit.ui.toolbar.UndoRedoToolbarHelper.UndoRedoToolbarHost
    public PdfConfiguration getConfiguration() {
        return null;
    }

    @Override // com.pspdfkit.ui.toolbar.UndoRedoToolbarHelper.UndoRedoToolbarHost
    public PdfFragment getFragment() {
        return null;
    }

    @Override // com.pspdfkit.ui.toolbar.UndoRedoToolbarHelper.UndoRedoToolbarHost
    public LifecycleOwner getLifecycleOwner() {
        return ViewTreeLifecycleOwner.get(this);
    }

    @Override // com.pspdfkit.ui.toolbar.ContextualToolbar
    public void handleMenuItemClick(ContextualToolbarMenuItem contextualToolbarMenuItem) {
        if (this.controller != null) {
            int id = contextualToolbarMenuItem.getId();
            if (contextualToolbarMenuItem == this.closeButton) {
                this.controller.exitActiveMode();
            } else if (id == R.id.pspdf__document_editing_toolbar_item_remove_pages) {
                this.controller.removeSelectedPages();
            } else if (id == R.id.pspdf__document_editing_toolbar_item_undo) {
                this.undoRedoHelper.executeUndo();
            } else if (id == R.id.pspdf__document_editing_toolbar_item_redo) {
                this.undoRedoHelper.executeRedo();
            } else if (id == R.id.pspdf__document_editing_toolbar_item_export_pages) {
                this.controller.exportSelectedPages(getContext());
            } else if (id == R.id.pspdf__document_editing_toolbar_item_import_document) {
                this.controller.importDocument(getContext());
            } else if (id == R.id.pspdf__document_editing_toolbar_item_done) {
                this.controller.performSaving(getContext(), contextualToolbarMenuItem);
            } else if (id == R.id.pspdf__document_editing_toolbar_item_rotate_pages) {
                this.controller.rotateSelectedPages();
            } else if (id == R.id.pspdf__document_editing_toolbar_item_duplicate_pages) {
                this.controller.duplicateSelectedPages();
            }
            applyControllerChanges();
        }
    }

    @Override // com.pspdfkit.ui.toolbar.ContextualToolbar
    public boolean isControllerBound() {
        return this.controller != null;
    }

    @Override // com.pspdfkit.ui.special_mode.manager.DocumentEditingManager.OnDocumentEditingPageSelectionChangeListener
    public void onDocumentEditingPageSelectionChanged(DocumentEditingController documentEditingController) {
        applyControllerChanges();
    }

    @Override // com.pspdfkit.ui.toolbar.ContextualToolbar
    public void unbindController() {
        DocumentEditingController documentEditingController = this.controller;
        if (documentEditingController != null) {
            documentEditingController.getDocumentEditingManager().removeOnDocumentEditingPageSelectionChangeListener(this);
            this.controller = null;
        }
        this.undoRedoHelper.unbindUndoManager();
    }

    @Override // com.pspdfkit.ui.toolbar.ContextualToolbar
    public void bindController(DocumentEditingController documentEditingController) {
        unbindController();
        this.controller = documentEditingController;
        documentEditingController.getDocumentEditingManager().addOnDocumentEditingPageSelectionChangeListener(this);
        this.undoRedoHelper.bindProvider(new DocumentEditorUndoProvider(documentEditingController));
        applyControllerChanges();
    }

    public DocumentEditingToolbar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public DocumentEditingToolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }
}
