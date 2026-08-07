package com.pspdfkit.ui.search;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import com.pspdfkit.R;
import com.pspdfkit.analytics.Analytics;
import com.pspdfkit.document.search.SearchResult;
import com.pspdfkit.internal.ar;
import com.pspdfkit.internal.c30;
import com.pspdfkit.internal.i0;
import com.pspdfkit.internal.l00;
import com.pspdfkit.internal.no;
import com.pspdfkit.ui.PSPDFKitViews;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class PdfSearchViewModular extends AbstractPdfSearchView implements PSPDFKitViews.PSPDFView {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int SEARCH_VIEW_WIDTH_DP = 480;
    private l00 adapter;
    private boolean animationRunning;
    private int backgroundColor;
    private TextView footer;
    private int highlightBackgroundColor;
    private int highlightBorderColor;
    private int highlightTextColor;
    private int inputFieldBackgroundColor;
    private int inputFieldHintColor;
    private int inputFieldTextColor;
    private boolean isDisplayed;
    private l00.a itemTheme;
    private int listItemBackgroundColor;
    private int listItemSubtitleColor;
    private int listItemTitleColor;
    private int listSelector;
    ListView resultList;
    private View rootView;
    private int separatorColor;
    private boolean showPageLabels;
    private ProgressBar throbber;
    private static final GradientDrawable leftShadow = new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, new int[]{Color.argb(70, 80, 80, 80), 0});
    private static final GradientDrawable bottomShadow = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{Color.argb(70, 80, 80, 80), 0});

    public class InteractionHandler implements AdapterView.OnItemClickListener, AbsListView.OnScrollListener {
        private InteractionHandler() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (PdfSearchViewModular.this.resultList.getAdapter() == null) {
                return;
            }
            SearchResult searchResult = (SearchResult) PdfSearchViewModular.this.resultList.getAdapter().getItem(i);
            PdfSearchViewModular.this.dispatchSearchResultSelected(searchResult);
            i0 i0VarA = ar.a();
            i0VarA.getClass();
            Bundle bundle = new Bundle();
            bundle.putInt(Analytics.Data.PAGE_INDEX, searchResult.pageIndex);
            bundle.putString("sort", String.valueOf(i));
            i0VarA.a(Analytics.Event.SELECT_SEARCH_RESULT, bundle);
            PdfSearchViewModular.this.hide();
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 0) {
                PdfSearchViewModular.this.hideKeyboard();
            }
        }
    }

    public PdfSearchViewModular(Context context) {
        this(context, null);
    }

    private void applyTheme() {
        View viewFindViewById = this.rootView.findViewById(R.id.pspdf__separator);
        l00.a aVar = new l00.a();
        this.itemTheme = aVar;
        aVar.d = this.highlightBackgroundColor;
        aVar.e = this.highlightTextColor;
        aVar.a = this.listItemBackgroundColor;
        aVar.b = this.listItemTitleColor;
        aVar.c = this.listItemSubtitleColor;
        getChildAt(0).setBackgroundColor(this.backgroundColor);
        viewFindViewById.setBackgroundColor(this.separatorColor);
        ((EditText) Objects.requireNonNull(getInputField())).setBackgroundColor(this.inputFieldBackgroundColor);
        getInputField().setTextColor(this.inputFieldTextColor);
        getInputField().setHintTextColor(this.inputFieldHintColor);
        getInputField().addTextChangedListener(new c30() { // from class: com.pspdfkit.ui.search.PdfSearchViewModular.1
            @Override // com.pspdfkit.internal.c30, android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                PdfSearchViewModular.this.clearSearch();
                if (charSequence.length() >= PdfSearchViewModular.this.getSearchConfiguration().getStartSearchChars()) {
                    PdfSearchViewModular.this.performSearch(charSequence.toString());
                }
            }
        });
        getInputField().setOnKeyListener(new View.OnKeyListener() { // from class: com.pspdfkit.ui.search.PdfSearchViewModular$$ExternalSyntheticLambda0
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                return this.f$0.lambda$applyTheme$0(view, i, keyEvent);
            }
        });
        int i = this.listSelector;
        if (i != 0) {
            this.resultList.setSelector(i);
        }
        this.footer.setBackgroundColor(this.listItemBackgroundColor);
        this.footer.setTextColor(this.listItemTitleColor);
    }

    private int getSearchViewHeight() {
        int height = getHeight();
        return (height == 0 && getParent() != null && (getParent() instanceof ViewGroup)) ? ((ViewGroup) getParent()).getHeight() : height;
    }

    private void init() {
        Context context = getContext();
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, R.styleable.pspdf__SearchViewModular, R.attr.pspdf__modularSearchStyle, R.style.PSPDFKit_SearchViewModular);
        this.backgroundColor = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__SearchViewModular_pspdf__backgroundColor, ContextCompat.getColor(context, R.color.pspdf__onPrimaryLight));
        this.inputFieldTextColor = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__SearchViewModular_pspdf__inputFieldTextColor, ContextCompat.getColor(context, R.color.pspdf__outlineLight));
        this.inputFieldHintColor = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__SearchViewModular_pspdf__inputFieldHintColor, ContextCompat.getColor(context, R.color.pspdf__outlineVariantLight));
        this.inputFieldBackgroundColor = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__SearchViewModular_pspdf__inputFieldBackgroundColor, ContextCompat.getColor(context, android.R.color.transparent));
        this.separatorColor = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__SearchViewModular_pspdf__separatorColor, ContextCompat.getColor(context, R.color.pspdf__surfaceLight));
        this.listSelector = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__SearchViewModular_pspdf__listItemSelector, 0);
        this.listItemBackgroundColor = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__SearchViewModular_pspdf__listItemBackgroundColor, ContextCompat.getColor(context, android.R.color.transparent));
        this.listItemTitleColor = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__SearchViewModular_pspdf__listItemTitleColor, ContextCompat.getColor(context, R.color.pspdf__outlineVariantLight));
        this.listItemSubtitleColor = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__SearchViewModular_pspdf__listItemSubtitleColor, ContextCompat.getColor(context, R.color.pspdf__outlineLight));
        this.highlightBackgroundColor = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__SearchViewModular_pspdf__highlightBackgroundColor, ContextCompat.getColor(context, R.color.pspdf__tertiaryContainerLight));
        this.highlightTextColor = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__SearchViewModular_pspdf__highlightTextColor, ContextCompat.getColor(context, R.color.pspdf__onBackgroundLight));
        this.highlightBorderColor = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__SearchViewModular_pspdf__highlightBorderColor, ContextCompat.getColor(context, R.color.pspdf__onBackgroundLight));
        typedArrayObtainStyledAttributes.recycle();
        View viewInflate = View.inflate(context, R.layout.pspdf__search_view_modular, this);
        this.rootView = viewInflate;
        setInputField((EditText) viewInflate.findViewById(R.id.pspdf__search_edit_text_modular));
        this.resultList = (ListView) this.rootView.findViewById(R.id.pspdf__search_resultlist);
        this.throbber = (ProgressBar) this.rootView.findViewById(R.id.pspdf__search_progress_modular);
        this.footer = (TextView) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.pspdf__search_footer, (ViewGroup) this.resultList, false);
        InteractionHandler interactionHandler = new InteractionHandler();
        this.resultList.setOnItemClickListener(interactionHandler);
        this.resultList.setOnScrollListener(interactionHandler);
        ListView listView = this.resultList;
        TextView textView = this.footer;
        listView.getClass();
        textView.getClass();
        View view = new View(listView.getContext());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
        listView.addFooterView(view, null, true);
        listView.addFooterView(textView, null, false);
        float f = getResources().getDisplayMetrics().density * 480.0f;
        if (getResources().getDisplayMetrics().widthPixels > 1.2f * f) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) f, -1);
            layoutParams.gravity = GravityCompat.END;
            getChildAt(0).setLayoutParams(layoutParams);
        }
        setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$applyTheme$0(View view, int i, KeyEvent keyEvent) {
        if (i != 66) {
            return false;
        }
        hideKeyboard();
        return false;
    }

    @Override // com.pspdfkit.ui.search.AbstractPdfSearchView
    public void clearSearchResults() {
        this.resultList.setAdapter((ListAdapter) null);
    }

    @Override // android.view.View
    public boolean fitSystemWindows(Rect rect) {
        setPadding(rect.left, rect.top, rect.right, rect.bottom);
        return false;
    }

    public int getBackgroundColor() {
        return this.backgroundColor;
    }

    public int getHighlightBackgroundColor() {
        return this.highlightBackgroundColor;
    }

    public int getHighlightBorderColor() {
        return this.highlightBorderColor;
    }

    public int getHighlightTextColor() {
        return this.highlightTextColor;
    }

    public int getInputFieldBackgroundColor() {
        return this.inputFieldBackgroundColor;
    }

    public int getInputFieldHintColor() {
        return this.inputFieldHintColor;
    }

    public int getInputFieldTextColor() {
        return this.inputFieldTextColor;
    }

    public int getListItemBackgroundColor() {
        return this.listItemBackgroundColor;
    }

    public int getListItemSubtitleColor() {
        return this.listItemSubtitleColor;
    }

    public int getListItemTitleColor() {
        return this.listItemTitleColor;
    }

    public int getListSelector() {
        return this.listSelector;
    }

    public int getSeparatorColor() {
        return this.separatorColor;
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews.PSPDFView
    public void hide() {
        if (isDisplayed()) {
            this.isDisplayed = false;
            getListeners().onHide(this);
            hideKeyboard();
            animate().translationY(-getHeight()).setInterpolator(new AccelerateInterpolator()).setListener(new AnimatorListenerAdapter() { // from class: com.pspdfkit.ui.search.PdfSearchViewModular.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    PdfSearchViewModular.this.animationRunning = false;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    PdfSearchViewModular pdfSearchViewModular = PdfSearchViewModular.this;
                    pdfSearchViewModular.animationRunning = false;
                    if (pdfSearchViewModular.isDisplayed()) {
                        return;
                    }
                    PdfSearchViewModular.this.setVisibility(4);
                    i0 i0VarA = ar.a();
                    i0VarA.getClass();
                    i0VarA.a(Analytics.Event.EXIT_SEARCH, new Bundle());
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    PdfSearchViewModular.this.animationRunning = true;
                }
            });
        }
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews.PSPDFView
    public boolean isDisplayed() {
        return this.isDisplayed;
    }

    @Override // com.pspdfkit.ui.search.AbstractPdfSearchView
    public boolean isIdle() {
        return (this.animationRunning || isSearchInProgress() || hasTransientState()) ? false : true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight() + ((int) (getResources().getDisplayMetrics().density * 100.0f)));
    }

    @Override // com.pspdfkit.ui.search.AbstractPdfSearchView
    public void onMoreSearchResults(List<SearchResult> list) {
        l00 l00Var = this.adapter;
        l00Var.c.addAll(list);
        Collections.sort(l00Var.c);
        l00Var.notifyDataSetChanged();
    }

    @Override // com.pspdfkit.ui.search.AbstractPdfSearchView
    public void onSearchCanceled() {
        this.throbber.setVisibility(4);
        this.footer.setVisibility(4);
    }

    @Override // com.pspdfkit.ui.search.AbstractPdfSearchView
    public void onSearchComplete() {
        String strA = no.a(getContext(), R.string.pspdf__search_complete, this);
        SpannableString spannableString = new SpannableString(strA + "\n" + getResources().getQuantityString(R.plurals.pspdf__search_results_found, this.adapter.c.size(), Integer.valueOf(this.adapter.c.size())));
        spannableString.setSpan(new StyleSpan(1), 0, strA.length(), 18);
        this.footer.setText(spannableString);
        this.footer.setVisibility(0);
        this.throbber.setVisibility(4);
    }

    @Override // com.pspdfkit.ui.search.AbstractPdfSearchView
    public void onSearchError(Throwable th) {
        Log.e("View", "Failed to retrieve search results.", th);
    }

    @Override // com.pspdfkit.ui.search.AbstractPdfSearchView
    public void onSearchStarted(String str) {
        l00 l00Var = new l00(this, this.itemTheme, R.layout.pspdf__search_item, this.showPageLabels);
        this.adapter = l00Var;
        this.resultList.setAdapter((ListAdapter) l00Var);
        this.footer.setVisibility(4);
        this.throbber.setVisibility(0);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 1 && motionEvent.getX() < getChildAt(0).getLeft()) {
            performClick();
        }
        return true;
    }

    @Override // android.view.View
    public boolean performClick() {
        super.performClick();
        hide();
        return true;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.backgroundColor = i;
        applyTheme();
    }

    public void setHighlightBackgroundColor(int i) {
        this.highlightBackgroundColor = i;
        applyTheme();
    }

    public void setHighlightBorderColor(int i) {
        this.highlightBorderColor = i;
    }

    public void setHighlightTextColor(int i) {
        this.highlightTextColor = i;
    }

    public void setInputFieldBackgroundColor(int i) {
        this.inputFieldBackgroundColor = i;
        applyTheme();
    }

    public void setInputFieldHintColor(int i) {
        this.inputFieldHintColor = i;
        applyTheme();
    }

    public void setInputFieldTextColor(int i) {
        this.inputFieldTextColor = i;
        applyTheme();
    }

    public void setListItemSubtitleColor(int i) {
        this.listItemSubtitleColor = i;
        applyTheme();
    }

    public void setListItemTitleColor(int i) {
        this.listItemTitleColor = i;
        applyTheme();
    }

    public void setListSelector(int i) {
        this.listSelector = i;
        applyTheme();
    }

    public void setSeparatorColor(int i) {
        this.separatorColor = i;
        applyTheme();
    }

    public void setShowPageLabels(boolean z) {
        this.showPageLabels = z;
    }

    @Override // com.pspdfkit.ui.search.AbstractPdfSearchView, com.pspdfkit.ui.PSPDFKitViews.PSPDFView
    public void show() {
        super.show();
        if (isDisplayed()) {
            return;
        }
        this.isDisplayed = true;
        getListeners().onShow(this);
        setVisibility(0);
        setTranslationY(-getSearchViewHeight());
        animate().translationY(0.0f).setInterpolator(new DecelerateInterpolator()).setListener(new AnimatorListenerAdapter() { // from class: com.pspdfkit.ui.search.PdfSearchViewModular.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                PdfSearchViewModular.this.animationRunning = false;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PdfSearchViewModular pdfSearchViewModular = PdfSearchViewModular.this;
                pdfSearchViewModular.animationRunning = false;
                if (pdfSearchViewModular.isDisplayed()) {
                    PdfSearchViewModular.this.animate().setListener(null);
                    int length = ((EditText) Objects.requireNonNull(PdfSearchViewModular.this.getInputField())).getText().length();
                    PdfSearchViewModular pdfSearchViewModular2 = PdfSearchViewModular.this;
                    if (length == 0) {
                        pdfSearchViewModular2.showKeyboard();
                    } else if ((pdfSearchViewModular2.resultList.getAdapter() == null || PdfSearchViewModular.this.resultList.getAdapter().isEmpty()) && PdfSearchViewModular.this.getInputField().getText().length() >= PdfSearchViewModular.this.getSearchConfiguration().getStartSearchChars()) {
                        PdfSearchViewModular.this.clearSearch();
                        PdfSearchViewModular pdfSearchViewModular3 = PdfSearchViewModular.this;
                        pdfSearchViewModular3.performSearch(pdfSearchViewModular3.getInputField().getText().toString());
                    }
                    i0 i0VarA = ar.a();
                    i0VarA.getClass();
                    Bundle bundle = new Bundle();
                    bundle.putString(Analytics.Data.SEARCH_TYPE, "SEARCH_MODULAR");
                    i0VarA.b.onNext(new Pair<>(Analytics.Event.START_SEARCH, bundle));
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                PdfSearchViewModular.this.animationRunning = true;
            }
        });
    }

    public PdfSearchViewModular(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.pspdf__modularSearchStyle);
        this.animationRunning = false;
        this.isDisplayed = false;
        this.showPageLabels = true;
        init();
        applyTheme();
        applyPolicy();
    }

    public void getListItemBackgroundColor(int i) {
        this.listItemBackgroundColor = i;
        applyTheme();
    }
}
