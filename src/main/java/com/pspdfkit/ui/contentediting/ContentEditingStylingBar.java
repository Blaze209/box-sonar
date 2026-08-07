package com.pspdfkit.ui.contentediting;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.CompoundButtonCompat;
import com.pspdfkit.R;
import com.pspdfkit.contentediting.ContentEditingFormatter;
import com.pspdfkit.contentediting.models.Alignment;
import com.pspdfkit.contentediting.models.StyleInfo;
import com.pspdfkit.contentediting.models.TextBlockStyleInfo;
import com.pspdfkit.internal.e9;
import com.pspdfkit.internal.f60;
import com.pspdfkit.internal.fk;
import com.pspdfkit.internal.gk;
import com.pspdfkit.internal.go;
import com.pspdfkit.internal.hn;
import com.pspdfkit.internal.of;
import com.pspdfkit.internal.uw;
import com.pspdfkit.ui.special_mode.controller.ContentEditingController;
import com.pspdfkit.ui.special_mode.manager.ContentEditingManager;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ContentEditingStylingBar extends FrameLayout implements View.OnClickListener, ContentEditingManager.OnContentEditingModeChangeListener, ContentEditingManager.OnContentEditingContentChangeListener, RadioGroup.OnCheckedChangeListener, CompoundButton.OnCheckedChangeListener {
    private static final int ANIMATION_DURATION_MS = 250;
    private CompoundButton alignCenterButton;
    private RadioGroup alignGroup;
    private CompoundButton alignJustifiedButton;
    private CompoundButton alignLeftButton;
    private CompoundButton alignRightButton;
    private Integer backgroundColor;
    private CompoundButton boldButton;
    private TextView clearButton;
    private Integer colorButtonFillColor;
    private View contentEditingBarLayout;
    private ContentEditingController controller;
    private StyleInfo currentStyleInfo;
    private TextBlockStyleInfo currentTextBlockStyleInfo;
    private String currentlyEditedTextBlockId;
    private AppCompatImageView decreaseFontSizeButton;
    private Integer fontButtonsTintColor;
    private Integer fontButtonsTintColorChecked;
    private AppCompatImageView fontColorButton;
    private AppCompatImageView fontNameButtonPhone;
    private TextView fontNameText;
    private View fontSizeButton;
    private AppCompatImageView fontSizeButtonPhone;
    private TextView fontSizeText;
    private String fontSizeUnit;
    private TextView fontSizeUnitText;
    private Integer fontSmallButtonsTintColor;
    private Integer iconBorderColor;
    private Integer iconColor;
    private final of immersiveHelper;
    private AppCompatImageView increaseFontSizeButton;
    private boolean isDisplayed;
    private CompoundButton italicButton;
    private final go<OnContentEditingBarLifecycleListener> lifecycleListeners;
    private AppCompatImageView linespacingButton;
    private Integer textColor;
    private View unknownColorOverlay;

    /* JADX INFO: renamed from: com.pspdfkit.ui.contentediting.ContentEditingStylingBar$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$pspdfkit$contentediting$models$Alignment;

        static {
            int[] iArr = new int[Alignment.values().length];
            $SwitchMap$com$pspdfkit$contentediting$models$Alignment = iArr;
            try {
                iArr[Alignment.BEGIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$pspdfkit$contentediting$models$Alignment[Alignment.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$pspdfkit$contentediting$models$Alignment[Alignment.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$pspdfkit$contentediting$models$Alignment[Alignment.JUSTIFIED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public interface OnContentEditingBarLifecycleListener {
        void onDisplayContentEditingBar(ContentEditingStylingBar contentEditingStylingBar);

        void onPrepareContentEditingBar(ContentEditingStylingBar contentEditingStylingBar);

        void onRemoveContentEditingBar(ContentEditingStylingBar contentEditingStylingBar);
    }

    public ContentEditingStylingBar(Context context) {
        super(context);
        this.lifecycleListeners = new go<>();
        this.immersiveHelper = new of();
        this.currentStyleInfo = null;
        this.currentTextBlockStyleInfo = null;
        this.fontSizeUnit = "pt";
        this.currentlyEditedTextBlockId = null;
        init(context, null, 0, 0);
    }

    private e9 createColorCircleDrawable() {
        return new e9(getContext(), this.iconBorderColor.intValue(), this.colorButtonFillColor.intValue(), 8.0f, 10.0f, 1.0f);
    }

    private void extractFontSizeUnit(Context context) {
        String string = context.getString(R.string.pspdf__unit_pt);
        String strReplace = string.replace("%1$s", "");
        if (string.length() == strReplace.length()) {
            return;
        }
        this.fontSizeUnit = strReplace.trim();
    }

    private Alignment getAlignmentForRadioButton(int i) {
        if (i == R.id.pspdf__content_editing_textalign_left) {
            return Alignment.BEGIN;
        }
        if (i == R.id.pspdf__content_editing_textalign_centered) {
            return Alignment.CENTER;
        }
        if (i == R.id.pspdf__content_editing_textalign_right) {
            return Alignment.END;
        }
        return i == R.id.pspdf__content_editing_textalign_justified ? Alignment.JUSTIFIED : Alignment.BEGIN;
    }

    private void hide() {
        if (this.isDisplayed) {
            this.isDisplayed = false;
            of ofVar = this.immersiveHelper;
            hn.c cVar = ofVar.b;
            if (cVar != null) {
                cVar.b();
            }
            ofVar.b = null;
            Runnable runnable = ofVar.c;
            if (runnable != null) {
                removeCallbacks(runnable);
                ofVar.c = null;
            }
            final boolean z = this.immersiveHelper.a;
            setTranslationY(0.0f);
            animate().translationY(getHeight()).setInterpolator(new AccelerateInterpolator()).setDuration(250L).withEndAction(new Runnable() { // from class: com.pspdfkit.ui.contentediting.ContentEditingStylingBar$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$hide$1(z);
                }
            });
            Iterator<OnContentEditingBarLifecycleListener> it = this.lifecycleListeners.iterator();
            while (it.hasNext()) {
                it.next().onRemoveContentEditingBar(this);
            }
        }
    }

    private void init(Context context, AttributeSet attributeSet, int i, int i2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{android.R.attr.elevation}, i, i2);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(0, context.getResources().getDimensionPixelOffset(R.dimen.pspdf__form_editing_bar_elevation));
        typedArrayObtainStyledAttributes.recycle();
        ViewCompat.setElevation(this, dimensionPixelOffset);
        extractFontSizeUnit(context);
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$hide$1(boolean z) {
        setVisibility(4);
        this.immersiveHelper.a(getContext(), z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$show$0() {
        Iterator<OnContentEditingBarLifecycleListener> it = this.lifecycleListeners.iterator();
        while (it.hasNext()) {
            it.next().onDisplayContentEditingBar(this);
        }
    }

    private void prepareForDisplay() {
        if (this.contentEditingBarLayout != null) {
            return;
        }
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.pspdf__content_editing_bar, (ViewGroup) this, true);
        this.contentEditingBarLayout = viewInflate.findViewById(R.id.pspdf__content_editing_bar_layout);
        View viewFindViewById = viewInflate.findViewById(R.id.top_divider);
        this.boldButton = (CompoundButton) viewInflate.findViewById(R.id.pspdf__font_bold);
        this.italicButton = (CompoundButton) viewInflate.findViewById(R.id.pspdf__font_italic);
        this.fontNameText = (TextView) viewInflate.findViewById(R.id.pspdf__content_editing_font_name_textbutton);
        this.fontSizeText = (TextView) viewInflate.findViewById(R.id.pspdf__content_editing_font_size_text);
        this.fontSizeUnitText = (TextView) viewInflate.findViewById(R.id.pspdf__content_editing_font_size_unit_text);
        this.increaseFontSizeButton = (AppCompatImageView) viewInflate.findViewById(R.id.pspdf__content_editing_increase_font_size_button);
        this.decreaseFontSizeButton = (AppCompatImageView) viewInflate.findViewById(R.id.pspdf__content_editing_decrease_font_size_button);
        this.fontSizeButton = viewInflate.findViewById(R.id.pspdf__layout_content_editing_font_size_compound_button);
        this.fontNameButtonPhone = (AppCompatImageView) viewInflate.findViewById(R.id.pspdf__content_editing_font_name_imagebutton);
        this.fontSizeButtonPhone = (AppCompatImageView) viewInflate.findViewById(R.id.pspdf__content_editing_font_size_imagebutton);
        this.fontColorButton = (AppCompatImageView) viewInflate.findViewById(R.id.pspdf__content_editing_font_color);
        this.unknownColorOverlay = viewInflate.findViewById(R.id.pspdf_unknown_color_overlay);
        this.boldButton = (CompoundButton) viewInflate.findViewById(R.id.pspdf__font_bold);
        this.italicButton = (CompoundButton) viewInflate.findViewById(R.id.pspdf__font_italic);
        this.clearButton = (TextView) viewInflate.findViewById(R.id.pspdf__content_editing_clear_button);
        this.alignGroup = (RadioGroup) viewInflate.findViewById(R.id.pspdf__content_editing_textalign_group);
        this.alignLeftButton = (CompoundButton) viewInflate.findViewById(R.id.pspdf__content_editing_textalign_left);
        this.alignRightButton = (CompoundButton) viewInflate.findViewById(R.id.pspdf__content_editing_textalign_centered);
        this.alignCenterButton = (CompoundButton) viewInflate.findViewById(R.id.pspdf__content_editing_textalign_right);
        this.alignJustifiedButton = (CompoundButton) viewInflate.findViewById(R.id.pspdf__content_editing_textalign_justified);
        AppCompatImageView appCompatImageView = (AppCompatImageView) viewInflate.findViewById(R.id.pspdf__content_editing_linespacing);
        this.linespacingButton = appCompatImageView;
        for (View view : Arrays.asList(this.fontNameText, this.increaseFontSizeButton, this.decreaseFontSizeButton, this.fontSizeButton, this.fontNameButtonPhone, this.fontSizeButtonPhone, this.fontColorButton, this.boldButton, this.italicButton, this.clearButton, appCompatImageView)) {
            if (view != null) {
                view.setOnClickListener(this);
            }
        }
        this.alignGroup.setOnCheckedChangeListener(this);
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(null, R.styleable.pspdf__contentEditingStylingBar, R.attr.pspdf__contentEditingStylingBarStyle, R.style.PSPDFKit_ContentEditingStylingBar);
        int color = ContextCompat.getColor(getContext(), R.color.pspdf__onBackgroundLight);
        int color2 = ContextCompat.getColor(getContext(), R.color.pspdf__inverseOnSurfaceLight);
        int color3 = ContextCompat.getColor(getContext(), R.color.pspdf__surfaceDimLight);
        int color4 = ContextCompat.getColor(getContext(), R.color.pspdf__surfaceDimLight);
        int iA = f60.a(getContext(), android.R.attr.colorBackground, R.color.pspdf__surfaceLight);
        Integer num = this.backgroundColor;
        int iIntValue = num != null ? num.intValue() : typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__contentEditingStylingBar_pspdf__backgroundColor, iA);
        Integer num2 = this.textColor;
        int iIntValue2 = num2 != null ? num2.intValue() : typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__contentEditingStylingBar_pspdf__textColor, color);
        Integer num3 = this.iconColor;
        int iIntValue3 = num3 != null ? num3.intValue() : typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__contentEditingStylingBar_pspdf__iconsColor, color);
        Integer num4 = this.iconBorderColor;
        int iIntValue4 = num4 != null ? num4.intValue() : typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__contentEditingStylingBar_pspdf__iconBorderColor, color);
        Integer num5 = this.fontButtonsTintColor;
        int iIntValue5 = num5 != null ? num5.intValue() : typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__contentEditingStylingBar_pspdf__fontButtonsTintColor, color2);
        int iIntValue6 = this.fontButtonsTintColor != null ? this.fontButtonsTintColorChecked.intValue() : typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__contentEditingStylingBar_pspdf__fontButtonsTintColorChecked, color3);
        int iIntValue7 = this.fontButtonsTintColor != null ? this.fontSmallButtonsTintColor.intValue() : typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__contentEditingStylingBar_pspdf__fontSmallButtonsTintColor, color2);
        int color5 = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__contentEditingStylingBar_pspdf__borderColor, color4);
        Integer num6 = this.colorButtonFillColor;
        if (num6 != null) {
            color = num6.intValue();
        }
        typedArrayObtainStyledAttributes.recycle();
        viewFindViewById.setBackgroundColor(color5);
        setIconsColor(iIntValue3);
        setColorButtonFillColor(color);
        setIconBorderColor(iIntValue4);
        setFontButtonsColor(iIntValue5);
        setFontButtonsColorChecked(iIntValue6);
        setFontSmallButtonsColor(iIntValue7);
        e9 e9VarCreateColorCircleDrawable = createColorCircleDrawable();
        setButtonsBackgroundColor(iIntValue5, iIntValue6, iIntValue7);
        setBackgroundColor(iIntValue);
        setTextColor(iIntValue2);
        this.fontColorButton.setImageDrawable(e9VarCreateColorCircleDrawable);
        updateClearButton();
        updateDisplayedTextBlockStyle();
    }

    private void setButtonsBackgroundColor(int i, int i2, int i3) {
        setStateBackgroundColors(Arrays.asList(this.fontNameText, this.fontNameButtonPhone, this.fontSizeButton, this.fontSizeButtonPhone, this.fontColorButton, this.linespacingButton), ColorStateList.valueOf(i));
        setStateBackgroundColors(Arrays.asList(this.increaseFontSizeButton, this.decreaseFontSizeButton), ColorStateList.valueOf(i3));
        setStateBackgroundColors(Arrays.asList(this.boldButton, this.italicButton, this.alignLeftButton, this.alignCenterButton, this.alignRightButton, this.alignJustifiedButton), new ColorStateList(new int[][]{new int[]{android.R.attr.state_checked, android.R.attr.state_pressed}, new int[]{android.R.attr.state_pressed}, new int[]{android.R.attr.state_checked}, new int[0]}, new int[]{i2, i2, i2, i}));
    }

    private void setColorButtonFillColor(int i) {
        this.colorButtonFillColor = Integer.valueOf(i);
    }

    private void setPrimaryTextColor(TextView textView, int i) {
        textView.setTextColor(new ColorStateList(new int[][]{new int[]{android.R.attr.state_enabled}, FrameLayout.EMPTY_STATE_SET}, new int[]{i, textView.getTextColors() != null ? textView.getTextColors().getColorForState(FrameLayout.EMPTY_STATE_SET, i) : i}));
    }

    private void setStateBackgroundColors(List<View> list, ColorStateList colorStateList) {
        for (View view : list) {
            if (view != null) {
                view.setBackgroundTintList(colorStateList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void show() {
        if (this.isDisplayed) {
            return;
        }
        this.isDisplayed = true;
        setVisibility(0);
        animate().translationY(0.0f).setInterpolator(new DecelerateInterpolator()).setDuration(250L).withEndAction(new Runnable() { // from class: com.pspdfkit.ui.contentediting.ContentEditingStylingBar$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$show$0();
            }
        });
        of ofVar = this.immersiveHelper;
        Context context = getContext();
        ofVar.getClass();
        context.getClass();
        fk fkVarA = gk.a(context);
        if (fkVarA != null && fkVarA.c) {
            ofVar.d = gk.a(context, ofVar.d);
        }
        Iterator<OnContentEditingBarLifecycleListener> it = this.lifecycleListeners.iterator();
        while (it.hasNext()) {
            it.next().onPrepareContentEditingBar(this);
        }
    }

    private void updateAlignmentRadioButtons(TextBlockStyleInfo textBlockStyleInfo) {
        RadioGroup radioGroup = this.alignGroup;
        if (radioGroup == null) {
            return;
        }
        radioGroup.setOnCheckedChangeListener(null);
        int i = AnonymousClass1.$SwitchMap$com$pspdfkit$contentediting$models$Alignment[textBlockStyleInfo.getAlignment().ordinal()];
        if (i == 1) {
            this.alignGroup.check(R.id.pspdf__content_editing_textalign_left);
        } else if (i == 2) {
            this.alignGroup.check(R.id.pspdf__content_editing_textalign_right);
        } else if (i == 3) {
            this.alignGroup.check(R.id.pspdf__content_editing_textalign_centered);
        } else if (i == 4) {
            this.alignGroup.check(R.id.pspdf__content_editing_textalign_justified);
        }
        this.alignGroup.setOnCheckedChangeListener(this);
    }

    private void updateCheckButton(CompoundButton compoundButton, boolean z, boolean z2) {
        if (compoundButton == null) {
            return;
        }
        boolean z3 = compoundButton instanceof RadioButton;
        if (!z3) {
            compoundButton.setOnCheckedChangeListener(null);
        }
        compoundButton.setChecked(z);
        compoundButton.setEnabled(z2);
        compoundButton.setAlpha(z2 ? 1.0f : 0.5f);
        if (z3) {
            return;
        }
        compoundButton.setOnCheckedChangeListener(this);
    }

    private void updateClearButton() {
        TextView textView = this.clearButton;
        if (textView != null) {
            ContentEditingController contentEditingController = this.controller;
            textView.setEnabled(contentEditingController != null && contentEditingController.isClearContentEditingEnabled());
        }
    }

    private void updateColorButton(Integer num) {
        int i;
        if (this.fontColorButton == null) {
            return;
        }
        if (num == null) {
            num = this.fontButtonsTintColor;
            i = 0;
        } else {
            i = 4;
        }
        setColorButtonFillColor(num.intValue());
        this.fontColorButton.setImageDrawable(createColorCircleDrawable());
        this.unknownColorOverlay.setVisibility(i);
    }

    private void updateDisplayedStyle(StyleInfo styleInfo) {
        setFontNameText(styleInfo.getFontNameForDisplay(getContext()), styleInfo.isFontResolved());
        setFontSizeText(styleInfo.getPointSizeForDisplay(), this.fontSizeUnit);
        updateColorButton(styleInfo.getColorInt());
        CompoundButton compoundButton = this.boldButton;
        Boolean bool = Boolean.TRUE;
        boolean zEquals = bool.equals(styleInfo.getBold());
        ContentEditingController contentEditingController = this.controller;
        updateCheckButton(compoundButton, zEquals, contentEditingController != null && contentEditingController.isBoldStyleButtonEnabled(styleInfo));
        CompoundButton compoundButton2 = this.italicButton;
        boolean zEquals2 = bool.equals(styleInfo.getItalic());
        ContentEditingController contentEditingController2 = this.controller;
        updateCheckButton(compoundButton2, zEquals2, contentEditingController2 != null && contentEditingController2.isItalicStyleButtonEnabled(styleInfo));
        this.currentStyleInfo = styleInfo;
        updateSizeButtons(styleInfo);
    }

    private void updateDisplayedTextBlockStyle() {
        TextBlockStyleInfo currentTextBlockStyleInfo;
        ContentEditingController contentEditingController = this.controller;
        if (contentEditingController == null || (currentTextBlockStyleInfo = contentEditingController.getCurrentTextBlockStyleInfo()) == null) {
            return;
        }
        updateDisplayedTextBlockStyle(currentTextBlockStyleInfo);
    }

    private void updateSizeButtons(StyleInfo styleInfo) {
        ContentEditingController contentEditingController = this.controller;
        boolean z = (contentEditingController == null || contentEditingController.getCurrentFormatter() == null) ? false : true;
        if (this.increaseFontSizeButton != null) {
            boolean z2 = z && this.controller.getCurrentFormatter().isIncreaseFontSizeEnabled(styleInfo);
            this.increaseFontSizeButton.setEnabled(z2);
            this.increaseFontSizeButton.setAlpha(z2 ? 1.0f : 0.5f);
        }
        if (this.decreaseFontSizeButton != null) {
            boolean z3 = z && this.controller.getCurrentFormatter().isDecreaseFontSizeEnabled(styleInfo);
            this.decreaseFontSizeButton.setEnabled(z3);
            this.decreaseFontSizeButton.setAlpha(z3 ? 1.0f : 0.5f);
        }
    }

    public void addOnContentEditingBarLifecycleListener(OnContentEditingBarLifecycleListener onContentEditingBarLifecycleListener) {
        uw.a(onContentEditingBarLifecycleListener, "Content Editing Listener", null);
        this.lifecycleListeners.a(onContentEditingBarLifecycleListener);
    }

    public void bindController(ContentEditingController contentEditingController) {
        this.controller = contentEditingController;
        contentEditingController.getContentEditingManager().addOnContentEditingContentChangeListener(this);
        StyleInfo currentStyleInfo = contentEditingController.getCurrentStyleInfo();
        if (currentStyleInfo != null) {
            updateDisplayedStyle(currentStyleInfo);
        }
        TextBlockStyleInfo currentTextBlockStyleInfo = contentEditingController.getCurrentTextBlockStyleInfo();
        if (currentTextBlockStyleInfo != null) {
            updateDisplayedTextBlockStyle(currentTextBlockStyleInfo);
        }
        updateClearButton();
        this.immersiveHelper.a(this, new Runnable() { // from class: com.pspdfkit.ui.contentediting.ContentEditingStylingBar$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.show();
            }
        });
    }

    @Override // android.view.View
    public boolean fitSystemWindows(Rect rect) {
        setPadding(rect.left, 0, rect.right, rect.bottom);
        return false;
    }

    public int getBackgroundColor() {
        return this.backgroundColor.intValue();
    }

    public boolean isDisplayed() {
        return this.isDisplayed;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        ContentEditingController contentEditingController = this.controller;
        if (contentEditingController == null || contentEditingController.getCurrentFormatter() == null) {
            return;
        }
        if (compoundButton == this.boldButton) {
            this.controller.getCurrentFormatter().setBold(z);
        } else if (compoundButton == this.italicButton) {
            this.controller.getCurrentFormatter().setItalic(z);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextBlockStyleInfo textBlockStyleInfo;
        ContentEditingController contentEditingController = this.controller;
        if (contentEditingController == null) {
            return;
        }
        if (view == this.clearButton) {
            contentEditingController.clearContentEditing();
            return;
        }
        if (view == this.fontNameText || view == this.fontNameButtonPhone) {
            contentEditingController.displayFontNamesSheet(this.currentStyleInfo);
            return;
        }
        if (view == this.fontSizeButton || view == this.fontSizeButtonPhone) {
            contentEditingController.displayFontSizesSheet(this.currentStyleInfo);
            return;
        }
        if (view == this.fontColorButton) {
            contentEditingController.displayColorPicker(this.currentStyleInfo);
            return;
        }
        if (view == this.linespacingButton && (textBlockStyleInfo = this.currentTextBlockStyleInfo) != null) {
            contentEditingController.displayLineSpacingSheet(textBlockStyleInfo.getLineSpacingFactor());
            return;
        }
        if (contentEditingController.getCurrentFormatter() == null || this.currentStyleInfo == null) {
            return;
        }
        if (view == this.increaseFontSizeButton) {
            this.controller.getCurrentFormatter().increaseFontSize(this.currentStyleInfo);
        } else if (view == this.decreaseFontSizeButton) {
            this.controller.getCurrentFormatter().decreaseFontSize(this.currentStyleInfo);
        }
    }

    @Override // com.pspdfkit.ui.special_mode.manager.ContentEditingManager.OnContentEditingContentChangeListener
    public void onContentSelectionChange(String str, int i, int i2, StyleInfo styleInfo, boolean z) {
        StyleInfo styleInfo2;
        if (z || (styleInfo2 = this.currentStyleInfo) == null || !styleInfo2.equals(styleInfo)) {
            updateDisplayedStyle(styleInfo);
        }
    }

    @Override // com.pspdfkit.ui.special_mode.manager.ContentEditingManager.OnContentEditingModeChangeListener
    public void onEnterContentEditingMode(ContentEditingController contentEditingController) {
    }

    @Override // com.pspdfkit.ui.special_mode.manager.ContentEditingManager.OnContentEditingModeChangeListener
    public void onExitContentEditingMode(ContentEditingController contentEditingController) {
    }

    @Override // com.pspdfkit.ui.special_mode.manager.ContentEditingManager.OnContentEditingContentChangeListener
    public void onFinishEditingContentBlock(String str) {
        if (str == this.currentlyEditedTextBlockId) {
            this.currentlyEditedTextBlockId = null;
            this.currentStyleInfo = null;
            this.currentTextBlockStyleInfo = null;
        }
        updateClearButton();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.isDisplayed) {
            return;
        }
        setTranslationY(getMeasuredHeight());
    }

    @Override // com.pspdfkit.ui.special_mode.manager.ContentEditingManager.OnContentEditingContentChangeListener
    public void onStartEditingContentBlock(String str) {
        this.currentlyEditedTextBlockId = str;
        updateClearButton();
    }

    @Override // com.pspdfkit.ui.special_mode.manager.ContentEditingManager.OnContentEditingContentChangeListener
    public void onTextBlockStyleChange(String str, TextBlockStyleInfo textBlockStyleInfo) {
        updateDisplayedTextBlockStyle(textBlockStyleInfo);
    }

    public void removeOnContentEditingBarLifecycleListener(OnContentEditingBarLifecycleListener onContentEditingBarLifecycleListener) {
        uw.a(onContentEditingBarLifecycleListener, "Content Editing Listener", null);
        this.lifecycleListeners.b(onContentEditingBarLifecycleListener);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.backgroundColor = Integer.valueOf(i);
        View view = this.contentEditingBarLayout;
        if (view != null) {
            view.setBackgroundColor(i);
        }
        super.setBackgroundColor(i);
    }

    public void setFontButtonsColor(int i) {
        this.fontButtonsTintColor = Integer.valueOf(i);
    }

    public void setFontButtonsColorChecked(int i) {
        this.fontButtonsTintColorChecked = Integer.valueOf(i);
    }

    public void setFontNameText(String str, boolean z) {
        if (this.fontNameText == null) {
            return;
        }
        uw.a(str, "fontName", null);
        if (z) {
            this.fontNameText.setText(str);
            return;
        }
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new StyleSpan(2), 0, str.length(), 33);
        this.fontNameText.setText(spannableString);
    }

    public void setFontSizeText(String str, String str2) {
        TextView textView = this.fontSizeText;
        if (textView == null) {
            return;
        }
        textView.setText(str);
        TextView textView2 = this.fontSizeUnitText;
        if (textView2 == null) {
            return;
        }
        textView2.setText(str2);
    }

    public void setFontSmallButtonsColor(int i) {
        this.fontSmallButtonsTintColor = Integer.valueOf(i);
    }

    public void setIconBorderColor(int i) {
        this.iconBorderColor = Integer.valueOf(i);
    }

    public void setIconsColor(int i) {
        this.iconColor = Integer.valueOf(i);
        List<AppCompatImageView> listAsList = Arrays.asList(this.fontNameButtonPhone, this.fontSizeButtonPhone, this.increaseFontSizeButton, this.decreaseFontSizeButton, this.linespacingButton);
        List listAsList2 = Arrays.asList(this.boldButton, this.italicButton, this.alignLeftButton, this.alignCenterButton, this.alignRightButton, this.alignJustifiedButton);
        for (AppCompatImageView appCompatImageView : listAsList) {
            if (appCompatImageView != null && appCompatImageView.getDrawable() != null) {
                DrawableCompat.setTint(appCompatImageView.getDrawable(), i);
            }
        }
        Iterator it = listAsList2.iterator();
        while (it.hasNext()) {
            CompoundButtonCompat.setButtonTintList((CompoundButton) it.next(), ColorStateList.valueOf(i));
        }
    }

    public void setTextColor(int i) {
        this.textColor = Integer.valueOf(i);
        for (TextView textView : Arrays.asList(this.fontNameText, this.fontSizeText, this.fontSizeUnitText, this.clearButton)) {
            if (textView != null) {
                setPrimaryTextColor(textView, i);
            }
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            prepareForDisplay();
        }
    }

    public void unbindController() {
        of ofVar = this.immersiveHelper;
        hn.c cVar = ofVar.b;
        if (cVar != null) {
            cVar.b();
        }
        ofVar.b = null;
        Runnable runnable = ofVar.c;
        if (runnable != null) {
            removeCallbacks(runnable);
            ofVar.c = null;
        }
        ContentEditingController contentEditingController = this.controller;
        if (contentEditingController != null) {
            contentEditingController.getContentEditingManager().removeOnContentEditingContentChangeListener(this);
            this.controller = null;
        }
        hide();
    }

    public boolean wasInImmersiveModeBeforeShowing() {
        return this.immersiveHelper.a;
    }

    private void updateDisplayedTextBlockStyle(TextBlockStyleInfo textBlockStyleInfo) {
        this.currentTextBlockStyleInfo = textBlockStyleInfo;
        updateAlignmentRadioButtons(textBlockStyleInfo);
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        ContentEditingFormatter currentFormatter;
        ContentEditingController contentEditingController = this.controller;
        if (contentEditingController == null || (currentFormatter = contentEditingController.getCurrentFormatter()) == null) {
            return;
        }
        currentFormatter.setTextAlignment(getAlignmentForRadioButton(i));
    }

    public ContentEditingStylingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lifecycleListeners = new go<>();
        this.immersiveHelper = new of();
        this.currentStyleInfo = null;
        this.currentTextBlockStyleInfo = null;
        this.fontSizeUnit = "pt";
        this.currentlyEditedTextBlockId = null;
        init(context, attributeSet, 0, 0);
    }

    public ContentEditingStylingBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lifecycleListeners = new go<>();
        this.immersiveHelper = new of();
        this.currentStyleInfo = null;
        this.currentTextBlockStyleInfo = null;
        this.fontSizeUnit = "pt";
        this.currentlyEditedTextBlockId = null;
        init(context, attributeSet, i, 0);
    }

    public ContentEditingStylingBar(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.lifecycleListeners = new go<>();
        this.immersiveHelper = new of();
        this.currentStyleInfo = null;
        this.currentTextBlockStyleInfo = null;
        this.fontSizeUnit = "pt";
        this.currentlyEditedTextBlockId = null;
        init(context, attributeSet, i, i2);
    }
}
