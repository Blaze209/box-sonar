package com.pspdfkit.ui.search;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.TextViewCompat;
import com.pspdfkit.R;
import com.pspdfkit.analytics.Analytics;
import com.pspdfkit.document.search.SearchResult;
import com.pspdfkit.internal.ar;
import com.pspdfkit.internal.c30;
import com.pspdfkit.internal.i0;
import com.pspdfkit.internal.no;
import com.pspdfkit.internal.uw;
import com.pspdfkit.internal.z50;
import com.pspdfkit.ui.PSPDFKitViews;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class PdfSearchViewInline extends AbstractPdfSearchView implements PSPDFKitViews.PSPDFView {
    public static final int INLINE_SEARCH_SHOW_DELAY = 300;
    private static final int NO_SEARCH_RESULT_SELECTED = -1;
    private int backIconColorTint;
    private ImageButton btnBack;
    private ImageButton btnNextResult;
    private ImageButton btnPreviousResult;
    private boolean comingFromSavedState;
    private TextView currentResultTextView;
    private int inputFieldTextAppearance;
    private boolean isDisplayed;
    private int nextIcon;
    private int nextIconColorTint;
    private TextView noResultsFound;
    private int prevIcon;
    private int prevIconColorTint;
    private int resultTextAppearance;
    private final List<SearchResult> results;
    int selectedResultIndex;
    private ProgressBar throbber;
    private int throbberColor;

    public class ClickListener implements View.OnClickListener {
        private ClickListener() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = PdfSearchViewInline.this.selectedResultIndex;
            if (view.getId() == R.id.pspdf__search_btn_back) {
                PdfSearchViewInline.this.hide();
            } else if (view.getId() == R.id.pspdf__search_btn_prev) {
                i--;
            } else if (view.getId() == R.id.pspdf__search_btn_next) {
                i++;
            }
            if (i < 0 || i >= PdfSearchViewInline.this.results.size()) {
                return;
            }
            PdfSearchViewInline.this.selectSearchResult(i);
            PdfSearchViewInline.this.hideKeyboard();
        }
    }

    public PdfSearchViewInline(Context context) {
        this(context, null);
    }

    private void applyTheme() {
        Context context = getContext();
        TextViewCompat.setTextAppearance(getInputField(), this.inputFieldTextAppearance);
        TextViewCompat.setTextAppearance(this.currentResultTextView, this.resultTextAppearance);
        TextViewCompat.setTextAppearance(this.noResultsFound, this.resultTextAppearance);
        Drawable drawable = isRtl() ? AppCompatResources.getDrawable(context, R.drawable.pspdf__arrow_right) : AppCompatResources.getDrawable(context, R.drawable.pspdf__ic_arrow_back);
        if (drawable != null) {
            DrawableCompat.setTint(drawable, this.backIconColorTint);
        }
        this.btnBack.setImageDrawable(drawable);
        Drawable drawable2 = AppCompatResources.getDrawable(context, this.prevIcon);
        if (drawable2 != null) {
            int i = this.prevIconColorTint;
            drawable2 = DrawableCompat.wrap(drawable2);
            drawable2.getClass();
            DrawableCompat.setTint(drawable2, i);
        }
        this.btnPreviousResult.setImageDrawable(drawable2);
        Drawable drawable3 = AppCompatResources.getDrawable(context, this.nextIcon);
        if (drawable3 != null) {
            int i2 = this.nextIconColorTint;
            drawable3 = DrawableCompat.wrap(drawable3);
            drawable3.getClass();
            DrawableCompat.setTint(drawable3, i2);
        }
        this.btnNextResult.setImageDrawable(drawable3);
        if (this.throbber.getIndeterminateDrawable() != null) {
            Drawable indeterminateDrawable = this.throbber.getIndeterminateDrawable();
            int i3 = this.throbberColor;
            indeterminateDrawable.getClass();
            Drawable drawableWrap = DrawableCompat.wrap(indeterminateDrawable);
            drawableWrap.getClass();
            DrawableCompat.setTint(drawableWrap, i3);
            this.throbber.setIndeterminateDrawable(drawableWrap);
        }
    }

    private void fadeInView(View view) {
        if (view.getVisibility() == 0) {
            return;
        }
        view.setVisibility(0);
        view.setAlpha(0.0f);
        view.animate().alpha(1.0f).setDuration(getContext().getResources().getInteger(android.R.integer.config_shortAnimTime)).setListener(null);
    }

    private void fadeOutView(View view) {
        fadeOutView(view, false);
    }

    private void hideSearchResultsNavigation() {
        this.btnNextResult.setVisibility(4);
        this.btnPreviousResult.setVisibility(4);
        this.currentResultTextView.setVisibility(4);
        this.noResultsFound.setVisibility(8);
    }

    private void init() {
        Context context = getContext();
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, R.styleable.pspdf__SearchViewInline, R.attr.pspdf__inlineSearchStyle, R.style.PSPDFKit_SearchViewInline);
        this.prevIconColorTint = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__SearchViewInline_pspdf__prevIconColorTint, ContextCompat.getColor(context, R.color.pspdf__onPrimaryLight));
        this.nextIconColorTint = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__SearchViewInline_pspdf__nextIconColorTint, ContextCompat.getColor(context, R.color.pspdf__onPrimaryLight));
        this.backIconColorTint = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__SearchViewInline_pspdf__backIconColorTint, ContextCompat.getColor(context, R.color.pspdf__onPrimaryLight));
        this.throbberColor = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__SearchViewInline_pspdf__throbberColor, ContextCompat.getColor(context, R.color.pspdf__onPrimaryLight));
        this.prevIcon = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__SearchViewInline_pspdf__prevIconDrawable, R.drawable.pspdf__ic_chevron_left);
        this.nextIcon = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__SearchViewInline_pspdf__nextIconDrawable, R.drawable.pspdf__ic_chevron_right);
        this.inputFieldTextAppearance = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__SearchViewInline_pspdf__inputFieldTextAppearance, R.style.PSPDFKit_SearchViewInline_InputFieldTextAppearance);
        this.resultTextAppearance = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__SearchViewInline_pspdf__resultTextAppearance, R.style.PSPDFKit_SearchViewInline_ResultTextAppearance);
        typedArrayObtainStyledAttributes.recycle();
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.pspdf__search_view_inline, (ViewGroup) this, true);
        setInputField((EditText) viewInflate.findViewById(R.id.pspdf__search_edit_text_inline));
        this.throbber = (ProgressBar) viewInflate.findViewById(R.id.pspdf__search_progress_inline);
        this.btnBack = (ImageButton) viewInflate.findViewById(R.id.pspdf__search_btn_back);
        this.btnPreviousResult = (ImageButton) viewInflate.findViewById(R.id.pspdf__search_btn_prev);
        this.btnNextResult = (ImageButton) viewInflate.findViewById(R.id.pspdf__search_btn_next);
        this.currentResultTextView = (TextView) viewInflate.findViewById(R.id.pspdf__search_tv_current_result);
        this.noResultsFound = (TextView) viewInflate.findViewById(R.id.pspdf__search_tv_no_matches_found);
        ((EditText) Objects.requireNonNull(getInputField())).addTextChangedListener(new c30() { // from class: com.pspdfkit.ui.search.PdfSearchViewInline.1
            @Override // com.pspdfkit.internal.c30, android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                PdfSearchViewInline.this.clearSearch();
                if (charSequence.length() >= PdfSearchViewInline.this.getSearchConfiguration().getStartSearchChars()) {
                    PdfSearchViewInline.this.performSearch(charSequence.toString());
                }
            }
        });
        ClickListener clickListener = new ClickListener();
        this.btnBack.setOnClickListener(clickListener);
        this.btnPreviousResult.setOnClickListener(clickListener);
        this.btnNextResult.setOnClickListener(clickListener);
        getSearchConfiguration().getSnippetLength();
    }

    private boolean isRtl() {
        return getResources().getConfiguration().getLayoutDirection() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void selectSearchResult(int i) {
        if (i < 0 || i > this.results.size() - 1) {
            throw new IllegalArgumentException("Search result number " + i + " doesn't exist");
        }
        this.selectedResultIndex = i;
        SearchResult searchResult = this.results.get(i);
        dispatchSearchResultSelected(searchResult);
        showSearchResultsNavigation(this.selectedResultIndex + 1, this.results.size());
        i0 i0VarA = ar.a();
        Bundle bundleA = z50.a(i0VarA);
        bundleA.putInt(Analytics.Data.PAGE_INDEX, searchResult.pageIndex);
        bundleA.putString("sort", String.valueOf(this.selectedResultIndex));
        i0VarA.a(Analytics.Event.SELECT_SEARCH_RESULT, bundleA);
    }

    private void showSearchResultsNavigation(int i, int i2) {
        if (i == 0 && i2 == 0) {
            fadeInView(this.noResultsFound);
            fadeOutView(this.currentResultTextView);
            return;
        }
        this.currentResultTextView.setText(no.a(getContext(), R.string.pspdf__search_result_of, this, Integer.valueOf(i), Integer.valueOf(i2)));
        fadeInView(this.btnNextResult);
        fadeInView(this.btnPreviousResult);
        fadeInView(this.currentResultTextView);
        fadeOutView(this.noResultsFound, true);
    }

    private void showSearchResultsNavigationWhileSearching(int i) {
        if (i == 0) {
            return;
        }
        this.currentResultTextView.setText(no.a(getContext(), R.string.pspdf__search_result_of, this, Integer.valueOf(Math.max(this.selectedResultIndex + 1, 1)), Integer.valueOf(i)));
        fadeInView(this.currentResultTextView);
        fadeInView(this.btnNextResult);
        fadeInView(this.btnPreviousResult);
    }

    @Override // com.pspdfkit.ui.search.AbstractPdfSearchView
    public void clearSearchResults() {
        this.results.clear();
        this.btnNextResult.setVisibility(4);
        this.btnPreviousResult.setVisibility(4);
        this.currentResultTextView.setVisibility(4);
        this.noResultsFound.setVisibility(8);
    }

    public int getBackIconColorTint() {
        return this.backIconColorTint;
    }

    public int getHintTextColor() {
        return ((EditText) Objects.requireNonNull(getInputField())).getCurrentHintTextColor();
    }

    public int getNavigationTextColor() {
        return this.noResultsFound.getCurrentTextColor();
    }

    public int getNextIcon() {
        return this.nextIcon;
    }

    public int getNextIconColorTint() {
        return this.nextIconColorTint;
    }

    public int getPrevIcon() {
        return this.prevIcon;
    }

    public int getPrevIconColorTint() {
        return this.prevIconColorTint;
    }

    public int getTextColor() {
        return ((EditText) Objects.requireNonNull(getInputField())).getCurrentTextColor();
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews.PSPDFView
    public void hide() {
        if (isDisplayed()) {
            this.isDisplayed = false;
            hideKeyboard();
            setVisibility(4);
            getListeners().onHide(this);
            ((EditText) Objects.requireNonNull(getInputField())).setText("");
            i0 i0VarA = ar.a();
            i0VarA.getClass();
            i0VarA.b.onNext(new Pair<>(Analytics.Event.EXIT_SEARCH, new Bundle()));
        }
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews.PSPDFView
    public boolean isDisplayed() {
        return this.isDisplayed;
    }

    @Override // com.pspdfkit.ui.search.AbstractPdfSearchView
    public boolean isIdle() {
        return !isSearchInProgress();
    }

    @Override // com.pspdfkit.ui.search.AbstractPdfSearchView
    public void onMoreSearchResults(List<SearchResult> list) {
        this.results.addAll(list);
        if (list.isEmpty()) {
            return;
        }
        showSearchResultsNavigationWhileSearching(this.results.size());
    }

    @Override // com.pspdfkit.ui.search.AbstractPdfSearchView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        int i = savedState.currentHighlightedResult;
        if (i != -1) {
            this.selectedResultIndex = i;
            this.comingFromSavedState = true;
        }
    }

    @Override // com.pspdfkit.ui.search.AbstractPdfSearchView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.currentHighlightedResult = this.selectedResultIndex;
        return savedState;
    }

    @Override // com.pspdfkit.ui.search.AbstractPdfSearchView
    public void onSearchCanceled() {
        this.throbber.setVisibility(8);
        hideSearchResultsNavigation();
    }

    @Override // com.pspdfkit.ui.search.AbstractPdfSearchView
    public void onSearchComplete() {
        int i;
        this.throbber.setVisibility(8);
        int i2 = 0;
        if (this.results.isEmpty()) {
            showSearchResultsNavigation(0, 0);
            return;
        }
        if (this.comingFromSavedState && (i = this.selectedResultIndex) > -1 && i < this.results.size()) {
            selectSearchResult(this.selectedResultIndex);
            this.comingFromSavedState = false;
            return;
        }
        for (int i3 = 0; i3 < this.results.size(); i3++) {
            if (this.results.get(i3).pageIndex >= getCurrentPage()) {
                i2 = i3;
                break;
            }
        }
        selectSearchResult(i2);
    }

    @Override // com.pspdfkit.ui.search.AbstractPdfSearchView
    public void onSearchError(Throwable th) {
        Log.e("View", "Failed to retrieve search results.", th);
    }

    @Override // com.pspdfkit.ui.search.AbstractPdfSearchView
    public void onSearchStarted(String str) {
        hideSearchResultsNavigation();
        this.throbber.setVisibility(0);
        this.results.clear();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 1 && motionEvent.getY() > getBottom()) {
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

    public void setBackIconColorTint(int i) {
        this.backIconColorTint = i;
        applyTheme();
    }

    public void setHintTextColor(int i) {
        ((EditText) Objects.requireNonNull(getInputField())).setHintTextColor(i);
    }

    public void setNavigationTextColor(int i) {
        this.noResultsFound.setTextColor(i);
        this.currentResultTextView.setTextColor(i);
    }

    public void setNextIcon(int i) {
        this.nextIcon = i;
        applyTheme();
    }

    public void setNextIconColorTint(int i) {
        this.nextIconColorTint = i;
        applyTheme();
    }

    public void setPrevIcon(int i) {
        this.prevIcon = i;
        applyTheme();
    }

    public void setPrevIconColorTint(int i) {
        this.prevIconColorTint = i;
        applyTheme();
    }

    public void setTextColor(int i) {
        ((EditText) Objects.requireNonNull(getInputField())).setTextColor(i);
    }

    @Override // com.pspdfkit.ui.search.AbstractPdfSearchView, com.pspdfkit.ui.PSPDFKitViews.PSPDFView
    public void show() {
        super.show();
        if (isDisplayed()) {
            return;
        }
        this.isDisplayed = true;
        setVisibility(0);
        getListeners().onShow(this);
        if (!this.results.isEmpty() || ((EditText) Objects.requireNonNull(getInputField())).getText().length() < getSearchConfiguration().getStartSearchChars()) {
            showKeyboard();
        } else {
            clearSearch();
            performSearch(getInputField().getText().toString());
        }
        i0 i0VarA = ar.a();
        i0VarA.getClass();
        Bundle bundle = new Bundle();
        bundle.putString(Analytics.Data.SEARCH_TYPE, "SEARCH_INLINE");
        i0VarA.b.onNext(new Pair<>(Analytics.Event.START_SEARCH, bundle));
    }

    public PdfSearchViewInline(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.pspdf__inlineSearchStyle);
        this.results = new ArrayList();
        this.selectedResultIndex = -1;
        this.comingFromSavedState = false;
        this.isDisplayed = false;
        init();
        applyTheme();
        applyPolicy();
    }

    private void fadeOutView(final View view, final boolean z) {
        if (view.getVisibility() == 4 || view.getVisibility() == 8) {
            return;
        }
        view.setAlpha(1.0f);
        view.animate().alpha(0.0f).setDuration(getContext().getResources().getInteger(android.R.integer.config_shortAnimTime)).setListener(new AnimatorListenerAdapter() { // from class: com.pspdfkit.ui.search.PdfSearchViewInline.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setVisibility(z ? 8 : 4);
                view.animate().setListener(null);
            }
        });
    }

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.pspdfkit.ui.search.PdfSearchViewInline.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        private int currentHighlightedResult;
        private final Parcelable superState;

        public SavedState(Parcelable parcelable) {
            uw.a(parcelable, "superState", null);
            this.superState = parcelable;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public Parcelable getSuperState() {
            return this.superState;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.superState, i);
            parcel.writeInt(this.currentHighlightedResult);
        }

        public SavedState(Parcel parcel) {
            this.superState = parcel.readParcelable(PdfSearchViewInline.class.getClassLoader());
            this.currentHighlightedResult = parcel.readInt();
        }
    }
}
