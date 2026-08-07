package com.pspdfkit.ui.inspector.contentediting;

import android.content.Context;
import com.pspdfkit.R;
import com.pspdfkit.contentediting.ContentEditingFormatter;
import com.pspdfkit.contentediting.models.StyleInfo;
import com.pspdfkit.internal.pg;
import com.pspdfkit.internal.qa;
import com.pspdfkit.internal.ww;
import com.pspdfkit.ui.inspector.AbstractPropertyInspectorController;
import com.pspdfkit.ui.inspector.PropertyInspector;
import com.pspdfkit.ui.inspector.PropertyInspectorCoordinatorLayoutController;
import com.pspdfkit.ui.special_mode.controller.ContentEditingController;
import com.pspdfkit.ui.special_mode.controller.ContentEditingInspectorController;
import com.pspdfkit.ui.special_mode.controller.ContentEditingStylingBarItem;
import com.pspdfkit.ui.special_mode.manager.ContentEditingManager;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultContentEditingInspectorController extends AbstractPropertyInspectorController implements ContentEditingInspectorController {
    private qa contentEditingInspectorFactory;
    private final Context context;
    public ContentEditingController controller;
    private final ContentEditingManager.OnContentEditingModeChangeListener onContentEditingModeChangeListener;

    /* JADX INFO: renamed from: com.pspdfkit.ui.inspector.contentediting.DefaultContentEditingInspectorController$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$pspdfkit$ui$special_mode$controller$ContentEditingStylingBarItem;

        static {
            int[] iArr = new int[ContentEditingStylingBarItem.values().length];
            $SwitchMap$com$pspdfkit$ui$special_mode$controller$ContentEditingStylingBarItem = iArr;
            try {
                iArr[ContentEditingStylingBarItem.FONT_NAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$pspdfkit$ui$special_mode$controller$ContentEditingStylingBarItem[ContentEditingStylingBarItem.FONT_SIZE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$pspdfkit$ui$special_mode$controller$ContentEditingStylingBarItem[ContentEditingStylingBarItem.FONT_COLOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$pspdfkit$ui$special_mode$controller$ContentEditingStylingBarItem[ContentEditingStylingBarItem.LINE_SPACING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static class ContentEditingPropertyInspector extends PropertyInspector {
        private boolean wasClosedByBackButton;
        private boolean wasClosedByCloseButton;

        public ContentEditingPropertyInspector(Context context) {
            super(context);
            this.wasClosedByBackButton = false;
            this.wasClosedByCloseButton = false;
        }

        @Override // com.pspdfkit.ui.inspector.PropertyInspector, com.pspdfkit.ui.inspector.PropertyInspectorTitleButtonListener
        public boolean onBackButtonClicked() {
            this.wasClosedByBackButton = true;
            cancel();
            return true;
        }

        @Override // com.pspdfkit.ui.inspector.PropertyInspector, com.pspdfkit.ui.inspector.PropertyInspectorTitleButtonListener
        public boolean onCloseButtonClicked() {
            this.wasClosedByCloseButton = true;
            cancel();
            return true;
        }

        @Override // com.pspdfkit.ui.inspector.PropertyInspector
        public void reset() {
            super.reset();
            this.wasClosedByBackButton = false;
            this.wasClosedByCloseButton = false;
        }

        public boolean wasClosedByBackButton() {
            return this.wasClosedByBackButton;
        }

        public boolean wasClosedByCloseButton() {
            return this.wasClosedByCloseButton;
        }
    }

    public DefaultContentEditingInspectorController(Context context, PropertyInspectorCoordinatorLayoutController propertyInspectorCoordinatorLayoutController) {
        super(context, propertyInspectorCoordinatorLayoutController);
        this.onContentEditingModeChangeListener = new ContentEditingManager.OnContentEditingModeChangeListener() { // from class: com.pspdfkit.ui.inspector.contentediting.DefaultContentEditingInspectorController.1
            @Override // com.pspdfkit.ui.special_mode.manager.ContentEditingManager.OnContentEditingModeChangeListener
            public void onEnterContentEditingMode(ContentEditingController contentEditingController) {
            }

            @Override // com.pspdfkit.ui.special_mode.manager.ContentEditingManager.OnContentEditingModeChangeListener
            public void onExitContentEditingMode(ContentEditingController contentEditingController) {
                DefaultContentEditingInspectorController.this.cancel();
            }
        };
        getPropertyInspector().setId(R.id.pspdf__content_editing_inspector);
        getPropertyInspector().setCancelOnTouchOutside(true);
        this.context = context;
    }

    private void applyControllerChanges(List<pg> list, ContentEditingStylingBarItem contentEditingStylingBarItem, StyleInfo styleInfo, Float f) {
        ContentEditingController contentEditingController;
        String string;
        if (!isContentEditingInspectorVisible() || (contentEditingController = this.controller) == null || contentEditingController.getActiveContentEditingStylingItem() == null) {
            cancel();
            return;
        }
        Context context = this.context;
        ContentEditingStylingBarItem activeContentEditingStylingItem = this.controller.getActiveContentEditingStylingItem();
        float f2 = ww.a;
        context.getClass();
        activeContentEditingStylingItem.getClass();
        int i = ww.a.c[activeContentEditingStylingItem.ordinal()];
        if (i == 1) {
            string = context.getString(R.string.pspdf__edit_menu_text_color);
            string.getClass();
        } else if (i == 2) {
            string = context.getString(R.string.pspdf__picker_font);
            string.getClass();
        } else if (i == 3) {
            string = context.getString(R.string.pspdf__size);
            string.getClass();
        } else {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            string = context.getString(R.string.pspdf__content_editing_line_spacing);
            string.getClass();
        }
        ContentEditingPropertyInspector propertyInspector = getPropertyInspector();
        ContentEditingFormatter currentFormatter = this.controller.getCurrentFormatter();
        if (currentFormatter == null) {
            cancel();
            return;
        }
        int i2 = AnonymousClass2.$SwitchMap$com$pspdfkit$ui$special_mode$controller$ContentEditingStylingBarItem[contentEditingStylingBarItem.ordinal()];
        if (i2 == 1) {
            if (list == null) {
                return;
            }
            propertyInspector.showDetailView(this.contentEditingInspectorFactory.a(list, currentFormatter, styleInfo), string, true);
        } else if (i2 == 2) {
            propertyInspector.showDetailView(this.contentEditingInspectorFactory.b(currentFormatter, styleInfo), string, true);
        } else if (i2 == 3) {
            propertyInspector.showDetailView(this.contentEditingInspectorFactory.a(currentFormatter, styleInfo), string, true);
        } else {
            if (i2 != 4) {
                return;
            }
            propertyInspector.showDetailView(this.contentEditingInspectorFactory.a(currentFormatter, f), string, true);
        }
    }

    private void toggleInspectorVisibility(boolean z, List<pg> list, ContentEditingStylingBarItem contentEditingStylingBarItem, Float f) {
        toggleInspectorVisibility(z, list, contentEditingStylingBarItem, null, f);
    }

    @Override // com.pspdfkit.ui.special_mode.controller.ContentEditingInspectorController
    public void bindContentEditingController(ContentEditingController contentEditingController) {
        unbindContentEditingController();
        this.controller = contentEditingController;
        this.contentEditingInspectorFactory = new qa(contentEditingController);
        contentEditingController.getContentEditingManager().addOnContentEditingModeChangeListener(this.onContentEditingModeChangeListener);
        contentEditingController.bindContentEditingInspectorController(this);
    }

    @Override // com.pspdfkit.ui.inspector.AbstractPropertyInspectorController
    public PropertyInspector createPropertyInspector(Context context) {
        return new ContentEditingPropertyInspector(context);
    }

    @Override // com.pspdfkit.ui.special_mode.controller.ContentEditingInspectorController
    public void displayColorPicker(boolean z, StyleInfo styleInfo) {
        toggleInspectorVisibility(z, (List<pg>) null, ContentEditingStylingBarItem.FONT_COLOR, styleInfo);
    }

    @Override // com.pspdfkit.ui.special_mode.controller.ContentEditingInspectorController
    public void displayFontNamesSheet(boolean z, List<pg> list, StyleInfo styleInfo) {
        toggleInspectorVisibility(z, list, ContentEditingStylingBarItem.FONT_NAME, styleInfo);
    }

    @Override // com.pspdfkit.ui.special_mode.controller.ContentEditingInspectorController
    public void displayFontSizesSheet(boolean z, StyleInfo styleInfo) {
        toggleInspectorVisibility(z, (List<pg>) null, ContentEditingStylingBarItem.FONT_SIZE, styleInfo);
    }

    @Override // com.pspdfkit.ui.special_mode.controller.ContentEditingInspectorController
    public void displayLineSpacingSheet(boolean z, Float f) {
        toggleInspectorVisibility(z, (List<pg>) null, ContentEditingStylingBarItem.LINE_SPACING, f);
    }

    @Override // com.pspdfkit.ui.inspector.AbstractPropertyInspectorController
    public boolean isBoundToController() {
        return this.controller != null;
    }

    @Override // com.pspdfkit.ui.special_mode.controller.ContentEditingInspectorController
    public boolean isContentEditingInspectorVisible() {
        return isInspectorVisible();
    }

    @Override // com.pspdfkit.ui.inspector.AbstractPropertyInspectorController, com.pspdfkit.ui.inspector.PropertyInspectorCoordinatorLayoutController.PropertyInspectorLifecycleListener
    public void onDisplayPropertyInspector(PropertyInspector propertyInspector) {
        super.onDisplayPropertyInspector(propertyInspector);
        ContentEditingController contentEditingController = this.controller;
        if (contentEditingController != null) {
            contentEditingController.onDisplayPropertyInspector(propertyInspector);
        }
    }

    @Override // com.pspdfkit.ui.inspector.AbstractPropertyInspectorController, com.pspdfkit.ui.inspector.PropertyInspectorCoordinatorLayoutController.PropertyInspectorLifecycleListener
    public void onRemovePropertyInspector(PropertyInspector propertyInspector) {
        super.onRemovePropertyInspector(propertyInspector);
        ContentEditingController contentEditingController = this.controller;
        if (contentEditingController != null) {
            contentEditingController.onRemovePropertyInspector(propertyInspector);
        }
    }

    @Override // com.pspdfkit.ui.special_mode.controller.ContentEditingInspectorController
    public void unbindContentEditingController() {
        ContentEditingController contentEditingController = this.controller;
        if (contentEditingController != null) {
            contentEditingController.unbindContentEditingInspectorController();
            this.controller.getContentEditingManager().removeOnContentEditingModeChangeListener(this.onContentEditingModeChangeListener);
            this.controller = null;
        }
        cancel();
    }

    private void toggleInspectorVisibility(boolean z, List<pg> list, ContentEditingStylingBarItem contentEditingStylingBarItem, StyleInfo styleInfo) {
        toggleInspectorVisibility(z, list, contentEditingStylingBarItem, styleInfo, null);
    }

    @Override // com.pspdfkit.ui.inspector.AbstractPropertyInspectorController
    public ContentEditingPropertyInspector getPropertyInspector() {
        return (ContentEditingPropertyInspector) super.getPropertyInspector();
    }

    private void toggleInspectorVisibility(boolean z, List<pg> list, ContentEditingStylingBarItem contentEditingStylingBarItem, StyleInfo styleInfo, Float f) {
        if (isInspectorVisible()) {
            hideInspector(z);
        } else {
            showInspector(z);
            applyControllerChanges(list, contentEditingStylingBarItem, styleInfo, f);
        }
    }
}
