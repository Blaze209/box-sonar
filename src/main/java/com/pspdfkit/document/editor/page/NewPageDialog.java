package com.pspdfkit.document.editor.page;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.facebook.imageutils.JfifUtil;
import com.pspdfkit.R;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.document.processor.NewPage;
import com.pspdfkit.document.processor.PagePattern;
import com.pspdfkit.internal.a80;
import com.pspdfkit.internal.f60;
import com.pspdfkit.internal.fi;
import com.pspdfkit.internal.no;
import com.pspdfkit.internal.uc;
import com.pspdfkit.internal.uw;
import com.pspdfkit.internal.views.utils.CircleImageView;
import com.pspdfkit.internal.wc;
import com.pspdfkit.internal.yq;
import com.pspdfkit.utils.Size;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public class NewPageDialog extends AppCompatDialogFragment {
    public static final String ARG_DOCUMENT_PAGE_SIZE = "com.pspdfkit.ui.dialog.page.NewPageDialog.ARG_DOCUMENT_PAGE_SIZE";
    private static final int COLOR_VIEW_BORDER_WIDTH_DP = 2;
    private static final int DEFAULT_ROTATION = 0;
    private static final int DENSITY_360 = 360;
    public static final String FRAGMENT_TAG = "com.pspdfkit.ui.dialog.page.NewPageDialog.FRAGMENT_TAG";
    private static final float MIN_ALPHA = 0.75f;
    private static final float MIN_SCALE = 0.55f;
    private static final int PAGE_MARGIN_PX = 150;
    private Callback callback;
    private final ColorsAdapter colorsAdapter;
    private Size documentPageSize;
    private Spinner orientationSpinner;
    private final PagePatternAdapter pagePatternAdapter;
    private ViewPager.OnPageChangeListener patternsOnChangeListener;
    private ViewPager patternsViewPager;
    private PagePatternAdapter.PagerItem selectedPattern;
    private Spinner sizeSpinner;
    private ContextThemeWrapper themedContext;
    private static final SizeOption DEFAULT_SIZE_OPTION_FALLBACK = SizeOption.A4;
    private static final int[] ATTRS = R.styleable.pspdf__NewPageDialog;
    private static final int DEF_STYLE_ATTR = R.attr.pspdf__newPageDialogStyle;
    private static final int DEF_STYLE_RES = R.style.PSPDFKit_NewPageDialog;
    private List<PageTemplate> pageTemplates = Collections.EMPTY_LIST;
    private boolean showPageTemplatesLast = false;
    private ColorOption colorOption = ColorOption.COLOR_OPTION_1;
    private OrientationOption orientationOption = OrientationOption.PORTRAIT;
    private SizeOption sizeOption = SizeOption.USE_DOCUMENT_SIZE;
    private boolean didCreatePage = false;

    public interface Callback {
        void onDialogCancelled();

        void onDialogConfirmed(NewPage newPage);
    }

    public enum ColorOption {
        COLOR_OPTION_1(Color.rgb(255, 255, 255)),
        COLOR_OPTION_2(Color.rgb(246, 243, 231)),
        COLOR_OPTION_3(Color.rgb(250, 245, JfifUtil.MARKER_SOI)),
        COLOR_OPTION_4(Color.rgb(241, 236, 121)),
        COLOR_OPTION_5(Color.rgb(58, 100, 194));

        public final int color;

        ColorOption(int i) {
            this.color = i;
        }
    }

    public class ColorViewHolder extends RecyclerView.ViewHolder {
        final ImageView colorCheckMark;
        final CircleImageView colorCircleImageView;

        public ColorViewHolder(View view) {
            super(view);
            CircleImageView circleImageView = (CircleImageView) view.findViewById(R.id.pspdf__page_creator_color_item);
            this.colorCircleImageView = circleImageView;
            this.colorCheckMark = (ImageView) view.findViewById(R.id.pspdf__page_creator_color_checkmark);
            circleImageView.setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.document.editor.page.NewPageDialog$ColorViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$new$0(view2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$0(View view) {
            NewPageDialog.this.colorOption = ColorOption.values()[getAdapterPosition()];
            NewPageDialog.this.refreshPageBackgroundColor(getAdapterPosition());
        }
    }

    public class ColorsAdapter extends RecyclerView.Adapter<ColorViewHolder> {
        private boolean isEnabled;

        private ColorsAdapter() {
            this.isEnabled = true;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return ColorOption.values().length;
        }

        public void setEnabled(boolean z) {
            this.isEnabled = z;
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(ColorViewHolder colorViewHolder, int i) {
            ColorOption colorOption = ColorOption.values()[i];
            colorViewHolder.colorCircleImageView.setBorderColor(ContextCompat.getColor(colorViewHolder.itemView.getContext(), R.color.pspdf__onSecondaryLight));
            colorViewHolder.colorCircleImageView.setBorderWidthDp(2);
            colorViewHolder.colorCircleImageView.setBackgroundColor(colorOption.color);
            colorViewHolder.colorCircleImageView.setEnabled(this.isEnabled);
            boolean z = this.isEnabled;
            CircleImageView circleImageView = colorViewHolder.colorCircleImageView;
            if (z) {
                circleImageView.setAlpha(1.0f);
            } else {
                circleImageView.setAlpha(0.5f);
            }
            colorViewHolder.colorCheckMark.setVisibility(colorOption == NewPageDialog.this.colorOption ? 0 : 8);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public ColorViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return NewPageDialog.this.new ColorViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pspdf__page_creator_page_color_view, viewGroup, false));
        }
    }

    public static class NewPageDialogTitleStyle extends yq {
        public NewPageDialogTitleStyle(Context context) {
            super(context);
        }

        @Override // com.pspdfkit.internal.wc.a
        public int getCloseButtonIcon() {
            return R.drawable.pspdf__ic_done;
        }
    }

    public enum OrientationOption {
        PORTRAIT,
        LANDSCAPE
    }

    public enum PatternOption {
        BLANK(PagePattern.BLANK, -1, R.string.pspdf__page_pattern_none),
        DOTS_5MM(PagePattern.DOTS_5MM, R.drawable.pspdf__bg_page_pattern_5mm_dot, R.string.pspdf__page_pattern_dot_5mm),
        GRID_5MM(PagePattern.GRID_5MM, R.drawable.pspdf__bg_page_pattern_5mm_square, R.string.pspdf__page_pattern_grid_5mm),
        LINES_5MM(PagePattern.LINES_5MM, R.drawable.pspdf__bg_page_pattern_5mm_line, R.string.pspdf__page_pattern_line_5mm),
        LINES_7MM(PagePattern.LINES_7MM, R.drawable.pspdf__bg_page_pattern_7mm_line, R.string.pspdf__page_pattern_line_7mm);

        public final int imageResId;
        public final int labelResourceId;
        public final PagePattern pagePattern;

        PatternOption(PagePattern pagePattern, int i, int i2) {
            this.pagePattern = pagePattern;
            this.imageResId = i;
            this.labelResourceId = i2;
        }
    }

    public enum SizeOption {
        USE_DOCUMENT_SIZE(R.string.pspdf__use_document_size, null),
        A4(R.string.pspdf__page_size_a4, NewPage.PAGE_SIZE_A4),
        A5(R.string.pspdf__page_size_a5, NewPage.PAGE_SIZE_A5),
        US_LEGAL(R.string.pspdf__page_size_us_legal, NewPage.PAGE_SIZE_US_LEGAL),
        US_LETTER(R.string.pspdf__page_size_us_letter, NewPage.PAGE_SIZE_US_LETTER);

        public final Size pageSize;
        public final int stringRes;

        SizeOption(int i, Size size) {
            this.stringRes = i;
            this.pageSize = size;
        }
    }

    public class ViewPagerChangeListener implements ViewPager.OnPageChangeListener {
        private final ViewPager parentViewPager;

        public ViewPagerChangeListener(ViewPager viewPager) {
            this.parentViewPager = viewPager;
        }

        private void transform(View view, float f) {
            int width = view.getWidth();
            int height = view.getHeight();
            if (f <= -1.0f || f > 1.0f) {
                view.setAlpha(0.0f);
                return;
            }
            float fMax = Math.max(NewPageDialog.MIN_SCALE, 1.0f - Math.abs(f));
            float f2 = 1.0f - fMax;
            float f3 = (height * f2) / 2.0f;
            float f4 = (width * f2) / 2.0f;
            if (f < 0.0f) {
                view.setTranslationX(f4 - (f3 / 2.0f));
            } else {
                view.setTranslationX((f3 / 2.0f) + (-f4));
            }
            view.setScaleX(fMax);
            view.setScaleY(fMax);
            view.setAlpha((((fMax - NewPageDialog.MIN_SCALE) / 0.45f) * 0.25f) + 0.75f);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            int scrollX = this.parentViewPager.getScrollX();
            int childCount = this.parentViewPager.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = this.parentViewPager.getChildAt(i3);
                if (!((ViewPager.LayoutParams) childAt.getLayoutParams()).isDecor) {
                    float left = (childAt.getLeft() - scrollX) / childAt.getWidth();
                    if (!Float.isNaN(left)) {
                        transform(childAt, left);
                    }
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            NewPageDialog newPageDialog = NewPageDialog.this;
            newPageDialog.selectedPattern = (PagePatternAdapter.PagerItem) newPageDialog.pagePatternAdapter.pagerItems.get(i);
            NewPageDialog newPageDialog2 = NewPageDialog.this;
            if (newPageDialog2.selectedPattern instanceof PagePatternAdapter.PatternItem) {
                newPageDialog2.sizeSpinner.setEnabled(true);
                NewPageDialog.this.orientationSpinner.setEnabled(true);
                NewPageDialog.this.colorsAdapter.setEnabled(true);
            } else {
                newPageDialog2.sizeSpinner.setEnabled(false);
                NewPageDialog.this.orientationSpinner.setEnabled(false);
                NewPageDialog.this.colorsAdapter.setEnabled(false);
            }
        }
    }

    public NewPageDialog() {
        this.pagePatternAdapter = new PagePatternAdapter();
        this.colorsAdapter = new ColorsAdapter();
    }

    private NewPage createNewPage() {
        Size size;
        SizeOption sizeOption = this.sizeOption;
        if (sizeOption != SizeOption.USE_DOCUMENT_SIZE) {
            size = sizeOption.pageSize;
        } else {
            size = this.documentPageSize;
            if (size == null) {
                size = DEFAULT_SIZE_OPTION_FALLBACK.pageSize;
            }
        }
        Size portrait = this.orientationOption == OrientationOption.PORTRAIT ? size.toPortrait() : size.toLandscape();
        PagePatternAdapter.PagerItem pagerItem = this.selectedPattern;
        if (pagerItem instanceof PagePatternAdapter.PatternItem) {
            return NewPage.patternPage(portrait, ((PagePatternAdapter.PatternItem) pagerItem).pagePattern).backgroundColor(this.colorOption.color).rotation(0).build();
        }
        if (!(pagerItem instanceof PagePatternAdapter.PageItem)) {
            return NewPage.emptyPage(portrait).build();
        }
        PagePatternAdapter.PageItem pageItem = (PagePatternAdapter.PageItem) pagerItem;
        return NewPage.fromPage(pageItem.sourceDocument, pageItem.pageIndex).build();
    }

    public static void hide(FragmentManager fragmentManager) {
        uw.a(fragmentManager, "fragmentManager", null);
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            throw new IllegalStateException("removeFragment() may only be called from the main thread.");
        }
        Fragment fragmentFindFragmentByTag = fragmentManager.findFragmentByTag(FRAGMENT_TAG);
        if (fragmentFindFragmentByTag == null) {
            return;
        }
        fi.a(fragmentManager, fragmentFindFragmentByTag);
    }

    private boolean isFullscreen() {
        return !uc.a(getContext(), DENSITY_360);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$populateViews$0(View view) {
        onAddButtonClicked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$populateViews$1(View view) {
        onCancelButtonClicked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$populateViews$2(View view) {
        onAddButtonClicked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$populateViews$3(View view) {
        onCancelButtonClicked();
    }

    private void onCancelButtonClicked() {
        dismiss();
    }

    private void populateViews(View view) {
        boolean zIsFullscreen = isFullscreen();
        NewPageDialogTitleStyle newPageDialogTitleStyle = new NewPageDialogTitleStyle(getContext());
        int iA = f60.a(getContext(), androidx.appcompat.R.attr.colorAccent);
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(null, ATTRS, DEF_STYLE_ATTR, DEF_STYLE_RES);
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__NewPageDialog_pspdf__backgroundColor, f60.a(getContext(), android.R.attr.colorBackground, R.color.pspdf__onPrimaryLight));
        typedArrayObtainStyledAttributes.recycle();
        wc wcVar = new wc(getContext(), newPageDialogTitleStyle);
        wcVar.setTitle(R.string.pspdf__add_page);
        wcVar.a(zIsFullscreen, false);
        wcVar.setCloseButtonVisible(zIsFullscreen);
        if (zIsFullscreen) {
            wcVar.setCloseButtonOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.document.editor.page.NewPageDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$populateViews$0(view2);
                }
            });
            wcVar.setBackButtonOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.document.editor.page.NewPageDialog$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$populateViews$1(view2);
                }
            });
        } else {
            wcVar.setTopInset(0);
        }
        ((ViewGroup) view.findViewById(R.id.pspdf__page_creator_content)).addView(wcVar, 0);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        if (a80.c(getContext())) {
            linearLayoutManager.setReverseLayout(true);
        }
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.pspdf__page_creator_color_recycler_view);
        a80.a((ViewGroup) recyclerView);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(this.colorsAdapter);
        if (zIsFullscreen) {
            view.findViewById(R.id.pspdf__page_creator_footer).setVisibility(8);
        } else {
            TextView textView = (TextView) view.findViewById(R.id.pspdf__page_creator_add_btn);
            textView.setVisibility(0);
            textView.setTextColor(iA);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.document.editor.page.NewPageDialog$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$populateViews$2(view2);
                }
            });
            TextView textView2 = (TextView) view.findViewById(R.id.pspdf__page_creator_cancel_btn);
            textView2.setVisibility(0);
            textView2.setTextColor(iA);
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.document.editor.page.NewPageDialog$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$populateViews$3(view2);
                }
            });
        }
        yq.setRoundedBackground(view, wcVar, color, newPageDialogTitleStyle.getCornerRadius(), zIsFullscreen);
        preparePageOrientationSpinner(view);
        preparePageSizeSpinner(view);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.pspdf__page_creator_page_types_pager);
        this.patternsViewPager = viewPager;
        viewPager.setPageMargin(-a80.a(getContext(), 150));
        this.patternsViewPager.setOffscreenPageLimit(2);
        ViewPagerChangeListener viewPagerChangeListener = new ViewPagerChangeListener(this.patternsViewPager);
        this.patternsOnChangeListener = viewPagerChangeListener;
        this.patternsViewPager.addOnPageChangeListener(viewPagerChangeListener);
        this.patternsViewPager.setAdapter(this.pagePatternAdapter);
        setAdapterPatternOptions();
    }

    private void preparePageOrientationSpinner(View view) {
        this.orientationSpinner = (Spinner) view.findViewById(R.id.pspdf__page_creator_orientation_spinner);
        ArrayList arrayList = new ArrayList(OrientationOption.values().length);
        for (OrientationOption orientationOption : OrientationOption.values()) {
            if (orientationOption == OrientationOption.PORTRAIT) {
                arrayList.add(no.a(getContext(), R.string.pspdf__portrait, this.orientationSpinner));
            } else if (orientationOption == OrientationOption.LANDSCAPE) {
                arrayList.add(no.a(getContext(), R.string.pspdf__landscape, this.orientationSpinner));
            }
        }
        this.orientationSpinner.setAdapter((SpinnerAdapter) new ArrayAdapter(getContext(), android.R.layout.simple_spinner_dropdown_item, arrayList));
        this.orientationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.pspdfkit.document.editor.page.NewPageDialog.1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view2, int i, long j) {
                if (i >= OrientationOption.values().length) {
                    return;
                }
                NewPageDialog.this.orientationOption = OrientationOption.values()[i];
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    private void preparePageSizeSpinner(View view) {
        this.sizeSpinner = (Spinner) view.findViewById(R.id.pspdf__page_creator_size_spinner);
        ArrayList arrayList = new ArrayList(SizeOption.values().length);
        final ArrayList arrayList2 = new ArrayList(SizeOption.values().length);
        for (SizeOption sizeOption : SizeOption.values()) {
            if (this.documentPageSize != null || sizeOption != SizeOption.USE_DOCUMENT_SIZE) {
                arrayList2.add(sizeOption);
                arrayList.add(no.a(getContext(), sizeOption.stringRes, this.sizeSpinner));
            }
        }
        this.sizeSpinner.setAdapter((SpinnerAdapter) new ArrayAdapter(getContext(), android.R.layout.simple_spinner_dropdown_item, arrayList));
        this.sizeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.pspdfkit.document.editor.page.NewPageDialog.2
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view2, int i, long j) {
                int size = arrayList2.size();
                NewPageDialog newPageDialog = NewPageDialog.this;
                if (i >= size) {
                    newPageDialog.sizeOption = SizeOption.USE_DOCUMENT_SIZE;
                } else {
                    newPageDialog.sizeOption = (SizeOption) arrayList2.get(i);
                }
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshPageBackgroundColor(int i) {
        this.colorsAdapter.notifyDataSetChanged();
        this.colorOption = ColorOption.values()[i];
        for (int i2 = 0; i2 < this.pagePatternAdapter.getCount(); i2++) {
            View viewFindViewWithTag = this.patternsViewPager.findViewWithTag(Integer.valueOf(i2));
            if (viewFindViewWithTag != null) {
                viewFindViewWithTag.setBackgroundColor(this.colorOption.color);
            }
        }
    }

    public static boolean restore(FragmentManager fragmentManager, List<PageTemplate> list, Callback callback) {
        uw.a(fragmentManager, "fragmentManager", null);
        uw.a(list, "pageTemplates", null);
        uw.a(callback, "callback", null);
        return restore(fragmentManager, list, false, callback);
    }

    private void setAdapterPatternOptions() {
        List<PatternOption> listAsList = Arrays.asList(PatternOption.values());
        this.pagePatternAdapter.setRTL(a80.c(getContext()));
        this.pagePatternAdapter.setItems(listAsList, this.pageTemplates);
        this.pagePatternAdapter.prepareItems();
    }

    public static void show(FragmentManager fragmentManager, Size size, List<PageTemplate> list, Callback callback) {
        uw.a(fragmentManager, "fragmentManager", null);
        uw.a(list, "pageTemplates", null);
        uw.a(callback, "callback", null);
        show(fragmentManager, size, list, false, callback);
    }

    @Override // androidx.fragment.app.Fragment
    public Context getContext() {
        Context context = super.getContext();
        ContextThemeWrapper contextThemeWrapper = this.themedContext;
        if (contextThemeWrapper != null && contextThemeWrapper.getBaseContext() == context) {
            return this.themedContext;
        }
        if (context == null) {
            return null;
        }
        int i = DEF_STYLE_RES;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{DEF_STYLE_ATTR});
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, i);
        typedArrayObtainStyledAttributes.recycle();
        ContextThemeWrapper contextThemeWrapper2 = new ContextThemeWrapper(context, resourceId);
        this.themedContext = contextThemeWrapper2;
        return contextThemeWrapper2;
    }

    public void onAddButtonClicked() {
        Callback callback = this.callback;
        if (callback != null) {
            callback.onDialogConfirmed(createNewPage());
        }
        this.didCreatePage = true;
        dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            this.sizeOption = SizeOption.A4;
        } else {
            this.sizeOption = SizeOption.USE_DOCUMENT_SIZE;
            this.documentPageSize = (Size) arguments.getParcelable(ARG_DOCUMENT_PAGE_SIZE);
        }
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        setStyle(2, R.style.PSPDFKit_Dialog_Light_Panel_Dim);
        Dialog dialogOnCreateDialog = super.onCreateDialog(bundle);
        Window window = dialogOnCreateDialog.getWindow();
        if (window != null) {
            window.requestFeature(1);
            window.setBackgroundDrawable(null);
        }
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        Callback callback;
        super.onDismiss(dialogInterface);
        if (this.didCreatePage || (callback = this.callback) == null) {
            return;
        }
        callback.onDialogCancelled();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        if (isFullscreen()) {
            window.setLayout(-1, -1);
            return;
        }
        int dimension = (int) getResources().getDimension(R.dimen.pspdf__page_creator_dialog_width);
        int i = getResources().getDisplayMetrics().widthPixels;
        if (dimension > i) {
            dimension = i;
        }
        window.setLayout(dimension, -2);
        a80.a(dialog);
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public void setupDialog(Dialog dialog, int i) {
        super.setupDialog(dialog, i);
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.pspdf__page_creator_dialog, (ViewGroup) null);
        populateViews(viewInflate);
        dialog.setContentView(viewInflate);
    }

    public class PagePatternAdapter extends PagerAdapter {
        private boolean isRTL;
        private final List<PageTemplate> pageTemplates;
        private final List<PagerItem> pagerItems;
        private final List<PatternOption> patternOptions;

        public class PageItem extends PagerItem {
            final int pageIndex;
            final PdfDocument sourceDocument;

            public PageItem(PdfDocument pdfDocument, int i, String str, Drawable drawable) {
                super(str, drawable);
                this.sourceDocument = pdfDocument;
                this.pageIndex = i;
            }
        }

        public abstract class PagerItem {
            final Drawable patternDrawable;
            final String patternName;

            public PagerItem(String str, Drawable drawable) {
                this.patternName = str;
                this.patternDrawable = drawable;
            }
        }

        private PagePatternAdapter() {
            this.isRTL = false;
            this.patternOptions = new ArrayList();
            this.pageTemplates = new ArrayList();
            this.pagerItems = new ArrayList();
        }

        private void addPagePatterns() {
            Iterator<PatternOption> it = this.patternOptions.iterator();
            while (it.hasNext()) {
                this.pagerItems.add(new PatternItem(NewPageDialog.this.getContext(), it.next()));
            }
        }

        private void addPageTemplates() {
            for (PageTemplate pageTemplate : this.pageTemplates) {
                PagePattern pagePattern = pageTemplate.pagePattern;
                if (pagePattern != null) {
                    this.pagerItems.add(new PatternItem(pagePattern, pageTemplate.templateName, pageTemplate.previewImage));
                } else {
                    PdfDocument pdfDocument = pageTemplate.sourceDocument;
                    if (pdfDocument != null) {
                        this.pagerItems.add(new PageItem(pdfDocument, pageTemplate.pageIndex, pageTemplate.templateName, pageTemplate.previewImage));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setupPageLayout$0(int i, View view) {
            NewPageDialog.this.patternsViewPager.setCurrentItem(i, true);
        }

        private void setupPageLayout(ViewGroup viewGroup, final int i) {
            PagerItem pagerItem = this.pagerItems.get(i);
            CircleImageView circleImageView = (CircleImageView) viewGroup.findViewById(R.id.pspdf__page_creator_page_type_image);
            circleImageView.setBorderColor(ContextCompat.getColor(NewPageDialog.this.getContext(), R.color.pspdf__onSecondaryLight));
            circleImageView.setBackgroundColor(NewPageDialog.this.colorOption.color);
            circleImageView.setTag(Integer.valueOf(i));
            circleImageView.setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.document.editor.page.NewPageDialog$PagePatternAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$setupPageLayout$0(i, view);
                }
            });
            ((TextView) viewGroup.findViewById(R.id.pspdf__page_creator_page_type_label)).setText(pagerItem.patternName);
            Drawable drawable = pagerItem.patternDrawable;
            if (drawable != null) {
                circleImageView.a(drawable, pagerItem instanceof PatternItem);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.pagerItems.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return this.pagerItems.get(i).patternName;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pspdf__page_creator_page_pattern_item, viewGroup, false);
            setupPageLayout(viewGroup2, i);
            viewGroup.addView(viewGroup2);
            return viewGroup2;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        public void prepareItems() {
            this.pagerItems.clear();
            if (NewPageDialog.this.showPageTemplatesLast) {
                addPagePatterns();
                addPageTemplates();
            } else {
                addPageTemplates();
                addPagePatterns();
            }
            if (this.isRTL) {
                Collections.reverse(this.pagerItems);
            }
            notifyDataSetChanged();
            boolean z = this.isRTL;
            NewPageDialog newPageDialog = NewPageDialog.this;
            if (z) {
                newPageDialog.patternsViewPager.setCurrentItem(this.pagerItems.size() - 1);
            } else {
                newPageDialog.patternsViewPager.setCurrentItem(0);
                NewPageDialog.this.patternsOnChangeListener.onPageSelected(0);
            }
        }

        public void setItems(List<PatternOption> list, List<PageTemplate> list2) {
            this.patternOptions.clear();
            this.pageTemplates.clear();
            this.patternOptions.addAll(list);
            this.pageTemplates.addAll(list2);
        }

        public void setRTL(boolean z) {
            this.isRTL = z;
        }

        public class PatternItem extends PagerItem {
            private final PagePattern pagePattern;

            public PatternItem(PagePattern pagePattern, String str, Drawable drawable) {
                super(str, drawable);
                this.pagePattern = pagePattern;
            }

            /* JADX WARN: Illegal instructions before constructor call */
            public PatternItem(Context context, PatternOption patternOption) {
                String strA = no.a(NewPageDialog.this.getContext(), patternOption.labelResourceId, null);
                int i = patternOption.imageResId;
                super(strA, i != -1 ? AppCompatResources.getDrawable(context, i) : null);
                this.pagePattern = patternOption.pagePattern;
            }
        }
    }

    public static boolean restore(FragmentManager fragmentManager, List<PageTemplate> list, boolean z, Callback callback) {
        uw.a(fragmentManager, "fragmentManager", null);
        uw.a(list, "pageTemplates", null);
        uw.a(callback, "callback", null);
        NewPageDialog newPageDialog = (NewPageDialog) fragmentManager.findFragmentByTag(FRAGMENT_TAG);
        if (newPageDialog == null) {
            return false;
        }
        newPageDialog.callback = callback;
        newPageDialog.pageTemplates = list;
        newPageDialog.showPageTemplatesLast = z;
        return true;
    }

    public static void show(FragmentManager fragmentManager, Size size, List<PageTemplate> list, boolean z, Callback callback) {
        uw.a(fragmentManager, "fragmentManager", null);
        uw.a(list, "pageTemplates", null);
        uw.a(callback, "callback", null);
        NewPageDialog newPageDialog = (NewPageDialog) fragmentManager.findFragmentByTag(FRAGMENT_TAG);
        if (newPageDialog == null) {
            newPageDialog = new NewPageDialog();
            if (size != null) {
                Bundle bundle = new Bundle();
                bundle.putParcelable(ARG_DOCUMENT_PAGE_SIZE, size);
                newPageDialog.setArguments(bundle);
            }
        }
        newPageDialog.callback = callback;
        newPageDialog.pageTemplates = list;
        newPageDialog.showPageTemplatesLast = z;
        if (newPageDialog.isAdded()) {
            return;
        }
        newPageDialog.show(fragmentManager, FRAGMENT_TAG);
    }

    public static boolean restore(FragmentManager fragmentManager, Callback callback) {
        return restore(fragmentManager, Collections.EMPTY_LIST, callback);
    }

    public static void show(FragmentManager fragmentManager, Size size, Callback callback) {
        show(fragmentManager, size, Collections.EMPTY_LIST, callback);
    }
}
