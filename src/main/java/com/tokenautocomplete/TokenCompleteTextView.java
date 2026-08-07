package com.tokenautocomplete;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Layout;
import android.text.NoCopySpan;
import android.text.Selection;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputMethodManager;
import android.widget.Filter;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class TokenCompleteTextView<T> extends AppCompatAutoCompleteTextView implements TextView.OnEditorActionListener, ViewSpan.Layout {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String TAG = "TokenAutoComplete";
    private boolean allowCollapse;
    private CountSpan countSpan;
    private SpannableStringBuilder hiddenContent;
    private boolean hintVisible;
    boolean inInvalidate;
    private boolean initialized;
    private boolean internalEditInProgress;
    private transient String lastCompletionText;
    private Layout lastLayout;
    private TokenListener<T> listener;
    private boolean performBestGuess;
    private CharSequence prefix;
    private boolean preventFreeFormText;
    private boolean savingState;
    private T selectedObject;
    private boolean shouldFocusNext;
    private TokenCompleteTextView<T>.TokenSpanWatcher spanWatcher;
    private TokenCompleteTextView<T>.TokenTextWatcher textWatcher;
    private TokenClickStyle tokenClickStyle;
    private int tokenLimit;
    private Tokenizer tokenizer;

    public interface TokenListener<T> {
        void onTokenAdded(T t);

        void onTokenIgnored(T t);

        void onTokenRemoved(T t);
    }

    protected List<T> convertSerializableObjectsToTypedObjects(List list) {
        return list;
    }

    protected abstract T defaultObject(String str);

    protected abstract View getViewForObject(T t);

    public boolean isTokenRemovable(T t) {
        return true;
    }

    public boolean shouldIgnoreToken(T t) {
        return false;
    }

    public enum TokenClickStyle {
        None(false),
        Delete(false),
        Select(true),
        SelectDeselect(true);

        private boolean mIsSelectable;

        TokenClickStyle(boolean z) {
            this.mIsSelectable = z;
        }

        public boolean isSelectable() {
            return this.mIsSelectable;
        }
    }

    protected void addListeners() {
        Editable text = getText();
        if (text != null) {
            text.setSpan(this.spanWatcher, 0, text.length(), 18);
            addTextChangedListener(this.textWatcher);
        }
    }

    protected void removeListeners() {
        Editable text = getText();
        if (text != null) {
            for (TokenSpanWatcher tokenSpanWatcher : (TokenSpanWatcher[]) text.getSpans(0, text.length(), TokenSpanWatcher.class)) {
                text.removeSpan(tokenSpanWatcher);
            }
            removeTextChangedListener(this.textWatcher);
        }
    }

    private void init() {
        if (this.initialized) {
            return;
        }
        setTokenizer(new CharacterTokenizer(Arrays.asList(Character.valueOf(AbstractJsonLexerKt.COMMA), ';'), ","));
        getText();
        this.spanWatcher = new TokenSpanWatcher();
        this.textWatcher = new TokenTextWatcher();
        this.hiddenContent = null;
        this.countSpan = new CountSpan();
        addListeners();
        setTextIsSelectable(false);
        setLongClickable(false);
        setInputType(getInputType() | 589824);
        setHorizontallyScrolling(false);
        setOnEditorActionListener(this);
        setFilters(new InputFilter[]{new InputFilter() { // from class: com.tokenautocomplete.TokenCompleteTextView.1
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                if (TokenCompleteTextView.this.internalEditInProgress) {
                    return null;
                }
                if (TokenCompleteTextView.this.tokenLimit != -1 && TokenCompleteTextView.this.getObjects().size() == TokenCompleteTextView.this.tokenLimit) {
                    return "";
                }
                if (!TokenCompleteTextView.this.tokenizer.containsTokenTerminator(charSequence) || (!TokenCompleteTextView.this.preventFreeFormText && TokenCompleteTextView.this.currentCompletionText().length() <= 0)) {
                    if (i3 >= TokenCompleteTextView.this.prefix.length()) {
                        return null;
                    }
                    if (i3 == 0 && i4 == 0) {
                        return null;
                    }
                    return i4 <= TokenCompleteTextView.this.prefix.length() ? TokenCompleteTextView.this.prefix.subSequence(i3, i4) : TokenCompleteTextView.this.prefix.subSequence(i3, TokenCompleteTextView.this.prefix.length());
                }
                TokenCompleteTextView.this.performCompletion();
                return "";
            }
        }});
        this.initialized = true;
    }

    public TokenCompleteTextView(Context context) {
        super(context);
        this.tokenClickStyle = TokenClickStyle.None;
        this.prefix = "";
        this.hintVisible = false;
        this.lastLayout = null;
        this.initialized = false;
        this.performBestGuess = true;
        this.preventFreeFormText = true;
        this.savingState = false;
        this.shouldFocusNext = false;
        this.allowCollapse = true;
        this.internalEditInProgress = false;
        this.tokenLimit = -1;
        this.lastCompletionText = null;
        this.inInvalidate = false;
        init();
    }

    public TokenCompleteTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.tokenClickStyle = TokenClickStyle.None;
        this.prefix = "";
        this.hintVisible = false;
        this.lastLayout = null;
        this.initialized = false;
        this.performBestGuess = true;
        this.preventFreeFormText = true;
        this.savingState = false;
        this.shouldFocusNext = false;
        this.allowCollapse = true;
        this.internalEditInProgress = false;
        this.tokenLimit = -1;
        this.lastCompletionText = null;
        this.inInvalidate = false;
        init();
    }

    public TokenCompleteTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.tokenClickStyle = TokenClickStyle.None;
        this.prefix = "";
        this.hintVisible = false;
        this.lastLayout = null;
        this.initialized = false;
        this.performBestGuess = true;
        this.preventFreeFormText = true;
        this.savingState = false;
        this.shouldFocusNext = false;
        this.allowCollapse = true;
        this.internalEditInProgress = false;
        this.tokenLimit = -1;
        this.lastCompletionText = null;
        this.inInvalidate = false;
        init();
    }

    @Override // android.widget.AutoCompleteTextView
    protected void performFiltering(CharSequence charSequence, int i) {
        Filter filter = getFilter();
        if (filter != null) {
            filter.filter(currentCompletionText(), this);
        }
    }

    public void setTokenizer(Tokenizer tokenizer) {
        this.tokenizer = tokenizer;
    }

    public void setTokenClickStyle(TokenClickStyle tokenClickStyle) {
        this.tokenClickStyle = tokenClickStyle;
    }

    public void setTokenListener(TokenListener<T> tokenListener) {
        this.listener = tokenListener;
    }

    public void setPrefix(CharSequence charSequence) {
        CharSequence charSequence2 = this.prefix;
        this.prefix = charSequence;
        Editable text = getText();
        if (text != null) {
            this.internalEditInProgress = true;
            if (charSequence2 != null) {
                text.replace(0, charSequence2.length(), charSequence);
            } else {
                text.insert(0, charSequence);
            }
            this.internalEditInProgress = false;
        }
        updateHint();
    }

    public void setPrefix(CharSequence charSequence, int i) {
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, spannableString.length(), 0);
        setPrefix(spannableString);
    }

    public List<T> getObjects() {
        ArrayList arrayList = new ArrayList();
        Editable text = getText();
        SpannableStringBuilder spannableStringBuilder = this.hiddenContent;
        if (spannableStringBuilder != null) {
            text = spannableStringBuilder;
        }
        for (TokenImageSpan tokenImageSpan : (TokenImageSpan[]) text.getSpans(0, text.length(), TokenImageSpan.class)) {
            arrayList.add(tokenImageSpan.getToken());
        }
        return arrayList;
    }

    public CharSequence getContentText() {
        SpannableStringBuilder spannableStringBuilder = this.hiddenContent;
        return spannableStringBuilder != null ? spannableStringBuilder : getText();
    }

    public void performBestGuess(boolean z) {
        this.performBestGuess = z;
    }

    public void preventFreeFormText(boolean z) {
        this.preventFreeFormText = z;
    }

    public void allowCollapse(boolean z) {
        this.allowCollapse = z;
    }

    public void setTokenLimit(int i) {
        this.tokenLimit = i;
    }

    public CharSequence getTextForAccessibility() {
        if (getObjects().size() == 0) {
            return getText();
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Editable text = getText();
        int length = -1;
        int spanEnd = 0;
        int length2 = -1;
        while (spanEnd < text.length()) {
            if (spanEnd == Selection.getSelectionStart(text)) {
                length = spannableStringBuilder.length();
            }
            if (spanEnd == Selection.getSelectionEnd(text)) {
                length2 = spannableStringBuilder.length();
            }
            TokenImageSpan[] tokenImageSpanArr = (TokenImageSpan[]) text.getSpans(spanEnd, spanEnd, TokenImageSpan.class);
            if (tokenImageSpanArr.length > 0) {
                TokenImageSpan tokenImageSpan = tokenImageSpanArr[0];
                spannableStringBuilder = spannableStringBuilder.append(this.tokenizer.wrapTokenValue(tokenImageSpan.getToken().toString()));
                spanEnd = text.getSpanEnd(tokenImageSpan);
            } else {
                spannableStringBuilder = spannableStringBuilder.append(text.subSequence(spanEnd, spanEnd + 1));
            }
            spanEnd++;
        }
        if (spanEnd == Selection.getSelectionStart(text)) {
            length = spannableStringBuilder.length();
        }
        if (spanEnd == Selection.getSelectionEnd(text)) {
            length2 = spannableStringBuilder.length();
        }
        if (length >= 0 && length2 >= 0) {
            Selection.setSelection(spannableStringBuilder, length, length2);
        }
        return spannableStringBuilder;
    }

    public void clearCompletionText() {
        if (currentCompletionText().length() == 0) {
            return;
        }
        Range currentCandidateTokenRange = getCurrentCandidateTokenRange();
        this.internalEditInProgress = true;
        getText().delete(currentCandidateTokenRange.start, currentCandidateTokenRange.end);
        this.internalEditInProgress = false;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (accessibilityEvent.getEventType() == 8192) {
            CharSequence textForAccessibility = getTextForAccessibility();
            accessibilityEvent.setFromIndex(Selection.getSelectionStart(textForAccessibility));
            accessibilityEvent.setToIndex(Selection.getSelectionEnd(textForAccessibility));
            accessibilityEvent.setItemCount(textForAccessibility.length());
        }
    }

    private Range getCurrentCandidateTokenRange() {
        Editable text = getText();
        int selectionEnd = getSelectionEnd();
        int length = this.prefix.length();
        int length2 = text.length();
        if (this.hintVisible) {
            length2 = length;
        }
        for (TokenImageSpan tokenImageSpan : (TokenImageSpan[]) text.getSpans(this.prefix.length(), text.length(), TokenImageSpan.class)) {
            int spanEnd = text.getSpanEnd(tokenImageSpan);
            if (length < spanEnd && selectionEnd >= spanEnd) {
                length = spanEnd;
            }
            int spanStart = text.getSpanStart(tokenImageSpan);
            if (length2 > spanStart && selectionEnd <= spanEnd) {
                length2 = spanStart;
            }
        }
        for (Range range : this.tokenizer.findTokenRanges(text, length, length2)) {
            if (range.start <= selectionEnd && selectionEnd <= range.end) {
                return range;
            }
        }
        return new Range(selectionEnd, selectionEnd);
    }

    protected CharSequence tokenToString(T t) {
        return t.toString();
    }

    protected String currentCompletionText() {
        if (this.hintVisible) {
            return "";
        }
        Editable text = getText();
        Range currentCandidateTokenRange = getCurrentCandidateTokenRange();
        String strSubstring = TextUtils.substring(text, currentCandidateTokenRange.start, currentCandidateTokenRange.end);
        Log.d(TAG, "Current completion text: " + strSubstring);
        return strSubstring;
    }

    protected float maxTextWidth() {
        return (getWidth() - getPaddingLeft()) - getPaddingRight();
    }

    @Override // com.tokenautocomplete.ViewSpan.Layout
    public int getMaxViewSpanWidth() {
        return (int) maxTextWidth();
    }

    private void api16Invalidate() {
        if (!this.initialized || this.inInvalidate) {
            return;
        }
        this.inInvalidate = true;
        setShadowLayer(getShadowRadius(), getShadowDx(), getShadowDy(), getShadowColor());
        this.inInvalidate = false;
    }

    @Override // android.view.View
    public void invalidate() {
        api16Invalidate();
        super.invalidate();
    }

    @Override // android.widget.AutoCompleteTextView
    public boolean enoughToFilter() {
        return this.tokenizer != null && !this.hintVisible && getSelectionEnd() >= 0 && getCurrentCandidateTokenRange().length() >= Math.max(getThreshold(), 1);
    }

    @Override // android.widget.AutoCompleteTextView
    public void performCompletion() {
        Object objDefaultObject;
        if ((getAdapter() == null || getListSelection() == -1) && enoughToFilter()) {
            if (getAdapter() != null && getAdapter().getCount() > 0 && this.performBestGuess) {
                objDefaultObject = getAdapter().getItem(0);
            } else {
                objDefaultObject = defaultObject(currentCompletionText());
            }
            replaceText(convertSelectionToString(objDefaultObject));
            return;
        }
        super.performCompletion();
    }

    @Override // androidx.appcompat.widget.AppCompatAutoCompleteTextView, com.microsoft.intune.mam.client.widget.MAMAutoCompleteTextView, com.microsoft.intune.mam.client.view.HookedView
    public InputConnection onMAMCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnMAMCreateInputConnection = super.onMAMCreateInputConnection(editorInfo);
        if (inputConnectionOnMAMCreateInputConnection == null) {
            return null;
        }
        TokenInputConnection tokenInputConnection = new TokenInputConnection(inputConnectionOnMAMCreateInputConnection, true);
        editorInfo.imeOptions &= -1073741825;
        editorInfo.imeOptions |= 268435456;
        return tokenInputConnection;
    }

    private void handleDone() {
        performCompletion();
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        }
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        boolean zOnKeyUp = super.onKeyUp(i, keyEvent);
        if (this.shouldFocusNext) {
            this.shouldFocusNext = false;
            handleDone();
        }
        return zOnKeyUp;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0028  */
    /* JADX WARN: Code duplicated, block: B:22:0x002f A[RETURN] */
    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 23 || i == 61 || i == 66) {
            if (keyEvent.hasNoModifiers()) {
                this.shouldFocusNext = true;
            } else if (super.onKeyDown(i, keyEvent)) {
                return false;
            }
        } else if (i != 67 || (canDeleteSelection(1) && !deleteSelectedObject())) {
            if (super.onKeyDown(i, keyEvent)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean deleteSelectedObject() {
        Editable text;
        TokenClickStyle tokenClickStyle = this.tokenClickStyle;
        if (tokenClickStyle == null || !tokenClickStyle.isSelectable() || (text = getText()) == null) {
            return false;
        }
        for (TokenCompleteTextView<T>.TokenImageSpan tokenImageSpan : (TokenImageSpan[]) text.getSpans(0, text.length(), TokenImageSpan.class)) {
            if (tokenImageSpan.view.isSelected()) {
                removeSpan(text, tokenImageSpan);
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        handleDone();
        return true;
    }

    @Override // com.microsoft.intune.mam.client.widget.MAMAutoCompleteTextView, android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int offsetForPosition;
        int actionMasked = motionEvent.getActionMasked();
        Editable text = getText();
        boolean zOnTouchEvent = this.tokenClickStyle == TokenClickStyle.None ? super.onTouchEvent(motionEvent) : false;
        if (isFocused() && text != null && this.lastLayout != null && actionMasked == 1 && (offsetForPosition = getOffsetForPosition(motionEvent.getX(), motionEvent.getY())) != -1) {
            TokenImageSpan[] tokenImageSpanArr = (TokenImageSpan[]) text.getSpans(offsetForPosition, offsetForPosition, TokenImageSpan.class);
            if (tokenImageSpanArr.length > 0) {
                tokenImageSpanArr[0].onClick();
                zOnTouchEvent = true;
            } else {
                clearSelections();
            }
        }
        return (zOnTouchEvent || this.tokenClickStyle == TokenClickStyle.None) ? zOnTouchEvent : super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.TextView
    protected void onSelectionChanged(int i, int i2) {
        if (this.hintVisible) {
            i = 0;
        }
        TokenClickStyle tokenClickStyle = this.tokenClickStyle;
        if (tokenClickStyle != null && tokenClickStyle.isSelectable() && getText() != null) {
            clearSelections();
        }
        CharSequence charSequence = this.prefix;
        if (charSequence != null && (i < charSequence.length() || i < this.prefix.length())) {
            setSelection(this.prefix.length());
            return;
        }
        Editable text = getText();
        if (text != null) {
            for (TokenImageSpan tokenImageSpan : (TokenImageSpan[]) text.getSpans(i, i, TokenImageSpan.class)) {
                int spanEnd = text.getSpanEnd(tokenImageSpan);
                if (i <= spanEnd && text.getSpanStart(tokenImageSpan) < i) {
                    if (spanEnd == text.length()) {
                        setSelection(spanEnd);
                        return;
                    } else {
                        setSelection(spanEnd + 1);
                        return;
                    }
                }
            }
        }
        super.onSelectionChanged(i, i);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.lastLayout = getLayout();
    }

    public void performCollapse(boolean z) {
        this.internalEditInProgress = true;
        if (!z) {
            Editable text = getText();
            if (text != null && this.hiddenContent == null && this.lastLayout != null) {
                text.removeSpan(this.spanWatcher);
                Spanned spannedEllipsizeWithSpans = SpanUtils.ellipsizeWithSpans(this.prefix, this.preventFreeFormText ? this.countSpan : null, getObjects().size(), this.lastLayout.getPaint(), text, maxTextWidth());
                if (spannedEllipsizeWithSpans != null) {
                    this.hiddenContent = new SpannableStringBuilder(text);
                    setText(spannedEllipsizeWithSpans);
                    TextUtils.copySpansFrom(spannedEllipsizeWithSpans, 0, spannedEllipsizeWithSpans.length(), TokenImageSpan.class, getText(), 0);
                    TextUtils.copySpansFrom(text, 0, this.hiddenContent.length(), TokenImageSpan.class, this.hiddenContent, 0);
                    SpannableStringBuilder spannableStringBuilder = this.hiddenContent;
                    spannableStringBuilder.setSpan(this.spanWatcher, 0, spannableStringBuilder.length(), 18);
                } else {
                    getText().setSpan(this.spanWatcher, 0, getText().length(), 18);
                }
            }
        } else {
            SpannableStringBuilder spannableStringBuilder2 = this.hiddenContent;
            if (spannableStringBuilder2 != null) {
                setText(spannableStringBuilder2);
                SpannableStringBuilder spannableStringBuilder3 = this.hiddenContent;
                TextUtils.copySpansFrom(spannableStringBuilder3, 0, spannableStringBuilder3.length(), TokenImageSpan.class, getText(), 0);
                this.hiddenContent = null;
                if (this.hintVisible) {
                    setSelection(this.prefix.length());
                } else {
                    post(new Runnable() { // from class: com.tokenautocomplete.TokenCompleteTextView.2
                        @Override // java.lang.Runnable
                        public void run() {
                            TokenCompleteTextView tokenCompleteTextView = TokenCompleteTextView.this;
                            tokenCompleteTextView.setSelection(tokenCompleteTextView.getText().length());
                        }
                    });
                }
                if (((TokenSpanWatcher[]) getText().getSpans(0, getText().length(), TokenSpanWatcher.class)).length == 0) {
                    getText().setSpan(this.spanWatcher, 0, getText().length(), 18);
                }
            }
        }
        this.internalEditInProgress = false;
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        clearSelections();
        if (this.allowCollapse) {
            performCollapse(z);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.widget.AutoCompleteTextView
    protected CharSequence convertSelectionToString(Object obj) {
        this.selectedObject = obj;
        return "";
    }

    protected TokenCompleteTextView<T>.TokenImageSpan buildSpanForObject(T t) {
        if (t == null) {
            return null;
        }
        return new TokenImageSpan(getViewForObject(t), t);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.widget.AutoCompleteTextView
    protected void replaceText(CharSequence charSequence) {
        clearComposingText();
        T t = this.selectedObject;
        if (t == null || t.toString().equals("")) {
            return;
        }
        TokenImageSpan tokenImageSpanBuildSpanForObject = buildSpanForObject(this.selectedObject);
        Editable text = getText();
        Range currentCandidateTokenRange = getCurrentCandidateTokenRange();
        String strSubstring = TextUtils.substring(text, currentCandidateTokenRange.start, currentCandidateTokenRange.end);
        if (strSubstring.length() > 0) {
            this.lastCompletionText = strSubstring;
        }
        if (text != null) {
            this.internalEditInProgress = true;
            if (tokenImageSpanBuildSpanForObject == null) {
                text.replace(currentCandidateTokenRange.start, currentCandidateTokenRange.end, "");
            } else if (shouldIgnoreToken(tokenImageSpanBuildSpanForObject.getToken())) {
                text.replace(currentCandidateTokenRange.start, currentCandidateTokenRange.end, "");
                TokenListener<T> tokenListener = this.listener;
                if (tokenListener != null) {
                    tokenListener.onTokenIgnored((T) tokenImageSpanBuildSpanForObject.getToken());
                }
            } else {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.tokenizer.wrapTokenValue(tokenToString(tokenImageSpanBuildSpanForObject.token)));
                text.replace(currentCandidateTokenRange.start, currentCandidateTokenRange.end, spannableStringBuilder);
                text.setSpan(tokenImageSpanBuildSpanForObject, currentCandidateTokenRange.start, currentCandidateTokenRange.start + spannableStringBuilder.length(), 33);
                text.insert(currentCandidateTokenRange.start + spannableStringBuilder.length(), " ");
            }
            this.internalEditInProgress = false;
        }
    }

    @Override // android.widget.TextView
    public boolean extractText(ExtractedTextRequest extractedTextRequest, ExtractedText extractedText) {
        try {
            return super.extractText(extractedTextRequest, extractedText);
        } catch (IndexOutOfBoundsException e) {
            Log.d(TAG, "extractText hit IndexOutOfBoundsException. This may be normal.", e);
            return false;
        }
    }

    public void addObjectSync(T t) {
        if (t == null) {
            return;
        }
        if (shouldIgnoreToken(t)) {
            TokenListener<T> tokenListener = this.listener;
            if (tokenListener != null) {
                tokenListener.onTokenIgnored(t);
                return;
            }
            return;
        }
        if (this.tokenLimit == -1 || getObjects().size() != this.tokenLimit) {
            insertSpan(buildSpanForObject(t));
            if (getText() == null || !isFocused()) {
                return;
            }
            setSelection(getText().length());
        }
    }

    public void addObjectAsync(final T t) {
        post(new Runnable() { // from class: com.tokenautocomplete.TokenCompleteTextView.3
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                TokenCompleteTextView.this.addObjectSync(t);
            }
        });
    }

    public void removeObjectSync(T t) {
        ArrayList<Editable> arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = this.hiddenContent;
        if (spannableStringBuilder != null) {
            arrayList.add(spannableStringBuilder);
        }
        if (getText() != null) {
            arrayList.add(getText());
        }
        for (Editable editable : arrayList) {
            for (TokenCompleteTextView<T>.TokenImageSpan tokenImageSpan : (TokenImageSpan[]) editable.getSpans(0, editable.length(), TokenImageSpan.class)) {
                if (tokenImageSpan.getToken().equals(t)) {
                    removeSpan(editable, tokenImageSpan);
                }
            }
        }
        updateCountSpan();
    }

    public void removeObjectAsync(final T t) {
        post(new Runnable() { // from class: com.tokenautocomplete.TokenCompleteTextView.4
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                TokenCompleteTextView.this.removeObjectSync(t);
            }
        });
    }

    public void clearAsync() {
        post(new Runnable() { // from class: com.tokenautocomplete.TokenCompleteTextView.5
            @Override // java.lang.Runnable
            public void run() {
                Iterator<T> it = TokenCompleteTextView.this.getObjects().iterator();
                while (it.hasNext()) {
                    TokenCompleteTextView.this.removeObjectSync(it.next());
                }
            }
        });
    }

    private void updateCountSpan() {
        if (this.preventFreeFormText) {
            Editable text = getText();
            this.countSpan.setCount(getObjects().size() - ((TokenImageSpan[]) getText().getSpans(0, getText().length(), TokenImageSpan.class)).length);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.countSpan.getCountText());
            spannableStringBuilder.setSpan(this.countSpan, 0, spannableStringBuilder.length(), 33);
            this.internalEditInProgress = true;
            int spanStart = text.getSpanStart(this.countSpan);
            if (spanStart != -1) {
                text.replace(spanStart, text.getSpanEnd(this.countSpan), spannableStringBuilder);
            } else {
                text.append((CharSequence) spannableStringBuilder);
            }
            this.internalEditInProgress = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeSpan(Editable editable, TokenCompleteTextView<T>.TokenImageSpan tokenImageSpan) {
        int spanEnd = editable.getSpanEnd(tokenImageSpan);
        if (spanEnd < editable.length() && editable.charAt(spanEnd) == ' ') {
            spanEnd++;
        }
        this.internalEditInProgress = true;
        editable.delete(editable.getSpanStart(tokenImageSpan), spanEnd);
        this.internalEditInProgress = false;
        if (!this.allowCollapse || isFocused()) {
            return;
        }
        updateCountSpan();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void insertSpan(TokenCompleteTextView<T>.TokenImageSpan tokenImageSpan) {
        CharSequence charSequenceWrapTokenValue = this.tokenizer.wrapTokenValue(tokenToString(((TokenImageSpan) tokenImageSpan).token));
        Editable text = getText();
        if (text == null) {
            return;
        }
        if (this.hiddenContent == null) {
            this.internalEditInProgress = true;
            int length = text.length();
            if (this.hintVisible) {
                length = this.prefix.length();
            } else {
                Range currentCandidateTokenRange = getCurrentCandidateTokenRange();
                if (currentCandidateTokenRange.length() > 0) {
                    length = currentCandidateTokenRange.start;
                }
            }
            text.insert(length, charSequenceWrapTokenValue);
            text.insert(charSequenceWrapTokenValue.length() + length, " ");
            text.setSpan(tokenImageSpan, length, charSequenceWrapTokenValue.length() + length, 33);
            this.internalEditInProgress = false;
            return;
        }
        CharSequence charSequenceWrapTokenValue2 = this.tokenizer.wrapTokenValue(tokenToString(tokenImageSpan.getToken()));
        int length2 = this.hiddenContent.length();
        this.hiddenContent.append(charSequenceWrapTokenValue2);
        this.hiddenContent.append((CharSequence) " ");
        this.hiddenContent.setSpan(tokenImageSpan, length2, charSequenceWrapTokenValue2.length() + length2, 33);
        updateCountSpan();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateHint() {
        HintSpan hintSpan;
        Editable text = getText();
        CharSequence hint = getHint();
        if (text == null || hint == null || this.prefix.length() <= 0) {
            return;
        }
        HintSpan[] hintSpanArr = (HintSpan[]) text.getSpans(0, text.length(), HintSpan.class);
        int length = this.prefix.length();
        if (hintSpanArr.length > 0) {
            hintSpan = hintSpanArr[0];
            length += text.getSpanEnd(hintSpan) - text.getSpanStart(hintSpan);
        } else {
            hintSpan = null;
        }
        if (text.length() != length) {
            if (hintSpan == null) {
                return;
            }
            int spanStart = text.getSpanStart(hintSpan);
            int spanEnd = text.getSpanEnd(hintSpan);
            this.internalEditInProgress = true;
            text.removeSpan(hintSpan);
            text.replace(spanStart, spanEnd, "");
            this.internalEditInProgress = false;
            this.hintVisible = false;
            return;
        }
        this.hintVisible = true;
        if (hintSpan != null) {
            return;
        }
        Typeface typeface = getTypeface();
        int style = typeface != null ? typeface.getStyle() : 0;
        ColorStateList hintTextColors = getHintTextColors();
        HintSpan hintSpan2 = new HintSpan(null, style, (int) getTextSize(), hintTextColors, hintTextColors);
        this.internalEditInProgress = true;
        text.insert(this.prefix.length(), hint);
        text.setSpan(hintSpan2, this.prefix.length(), this.prefix.length() + getHint().length(), 33);
        this.internalEditInProgress = false;
        setSelection(this.prefix.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSelections() {
        Editable text;
        TokenClickStyle tokenClickStyle = this.tokenClickStyle;
        if (tokenClickStyle == null || !tokenClickStyle.isSelectable() || (text = getText()) == null) {
            return;
        }
        for (TokenImageSpan tokenImageSpan : (TokenImageSpan[]) text.getSpans(0, text.length(), TokenImageSpan.class)) {
            tokenImageSpan.view.setSelected(false);
        }
        invalidate();
    }

    protected class TokenImageSpan extends ViewSpan implements NoCopySpan {
        private T token;

        public TokenImageSpan(View view, T t) {
            super(view, TokenCompleteTextView.this);
            this.token = t;
        }

        public T getToken() {
            return this.token;
        }

        public void onClick() {
            Editable text = TokenCompleteTextView.this.getText();
            if (text == null) {
                return;
            }
            int i = AnonymousClass7.$SwitchMap$com$tokenautocomplete$TokenCompleteTextView$TokenClickStyle[TokenCompleteTextView.this.tokenClickStyle.ordinal()];
            if (i == 1 || i == 2) {
                if (!this.view.isSelected()) {
                    TokenCompleteTextView.this.clearSelections();
                    this.view.setSelected(true);
                    return;
                } else if (TokenCompleteTextView.this.tokenClickStyle == TokenClickStyle.SelectDeselect || !TokenCompleteTextView.this.isTokenRemovable(this.token)) {
                    this.view.setSelected(false);
                    TokenCompleteTextView.this.invalidate();
                    return;
                }
            } else if (i != 3) {
                if (TokenCompleteTextView.this.getSelectionStart() != text.getSpanEnd(this)) {
                    TokenCompleteTextView.this.setSelection(text.getSpanEnd(this));
                    return;
                }
                return;
            }
            if (TokenCompleteTextView.this.isTokenRemovable(this.token)) {
                TokenCompleteTextView.this.removeSpan(text, this);
            }
        }
    }

    /* JADX INFO: renamed from: com.tokenautocomplete.TokenCompleteTextView$7, reason: invalid class name */
    static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] $SwitchMap$com$tokenautocomplete$TokenCompleteTextView$TokenClickStyle;

        static {
            int[] iArr = new int[TokenClickStyle.values().length];
            $SwitchMap$com$tokenautocomplete$TokenCompleteTextView$TokenClickStyle = iArr;
            try {
                iArr[TokenClickStyle.Select.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tokenautocomplete$TokenCompleteTextView$TokenClickStyle[TokenClickStyle.SelectDeselect.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tokenautocomplete$TokenCompleteTextView$TokenClickStyle[TokenClickStyle.Delete.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$tokenautocomplete$TokenCompleteTextView$TokenClickStyle[TokenClickStyle.None.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private class TokenSpanWatcher implements SpanWatcher {
        @Override // android.text.SpanWatcher
        public void onSpanChanged(Spannable spannable, Object obj, int i, int i2, int i3, int i4) {
        }

        private TokenSpanWatcher() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.text.SpanWatcher
        public void onSpanAdded(Spannable spannable, Object obj, int i, int i2) {
            if (!(obj instanceof TokenImageSpan) || TokenCompleteTextView.this.savingState) {
                return;
            }
            TokenImageSpan tokenImageSpan = (TokenImageSpan) obj;
            if (!TokenCompleteTextView.this.isFocused() && TokenCompleteTextView.this.allowCollapse) {
                TokenCompleteTextView.this.performCollapse(false);
            }
            if (TokenCompleteTextView.this.listener != null) {
                TokenCompleteTextView.this.listener.onTokenAdded(tokenImageSpan.getToken());
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.text.SpanWatcher
        public void onSpanRemoved(Spannable spannable, Object obj, int i, int i2) {
            if (!(obj instanceof TokenImageSpan) || TokenCompleteTextView.this.savingState) {
                return;
            }
            TokenImageSpan tokenImageSpan = (TokenImageSpan) obj;
            if (TokenCompleteTextView.this.listener != null) {
                TokenCompleteTextView.this.listener.onTokenRemoved(tokenImageSpan.getToken());
            }
        }
    }

    private class TokenTextWatcher implements TextWatcher {
        ArrayList<TokenCompleteTextView<T>.TokenImageSpan> spansToRemove;

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        private TokenTextWatcher() {
            this.spansToRemove = new ArrayList<>();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (i2 <= 0 || TokenCompleteTextView.this.getText() == null) {
                return;
            }
            Editable text = TokenCompleteTextView.this.getText();
            int i4 = i2 + i;
            TokenCompleteTextView<T>.TokenImageSpan[] tokenImageSpanArr = (TokenImageSpan[]) text.getSpans(i, i4, TokenImageSpan.class);
            ArrayList<TokenCompleteTextView<T>.TokenImageSpan> arrayList = new ArrayList<>();
            for (TokenCompleteTextView<T>.TokenImageSpan tokenImageSpan : tokenImageSpanArr) {
                if (text.getSpanStart(tokenImageSpan) < i4 && i < text.getSpanEnd(tokenImageSpan)) {
                    arrayList.add(tokenImageSpan);
                }
            }
            this.spansToRemove = arrayList;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            ArrayList<TokenImageSpan> arrayList = new ArrayList(this.spansToRemove);
            this.spansToRemove.clear();
            for (TokenImageSpan tokenImageSpan : arrayList) {
                if (editable.getSpanStart(tokenImageSpan) != -1 && editable.getSpanEnd(tokenImageSpan) != -1) {
                    TokenCompleteTextView.this.removeSpan(editable, tokenImageSpan);
                }
            }
            TokenCompleteTextView.this.clearSelections();
            TokenCompleteTextView.this.updateHint();
        }
    }

    protected List<Serializable> getSerializableObjects() {
        ArrayList arrayList = new ArrayList();
        for (T t : getObjects()) {
            if (t instanceof Serializable) {
                arrayList.add((Serializable) t);
            } else {
                Log.e(TAG, "Unable to save '" + t + "'");
            }
        }
        if (arrayList.size() != getObjects().size()) {
            Log.e(TAG, "You should make your objects Serializable or Parcelable or\noverride getSerializableObjects and convertSerializableArrayToObjectArray");
        }
        return arrayList;
    }

    private Class reifyParameterizedTypeClass() {
        Class<?> superclass = getClass();
        while (!superclass.getSuperclass().equals(TokenCompleteTextView.class)) {
            superclass = superclass.getSuperclass();
        }
        return (Class) ((ParameterizedType) superclass.getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override // android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        removeListeners();
        this.savingState = true;
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        this.savingState = false;
        SavedState savedState = new SavedState(parcelableOnSaveInstanceState);
        savedState.prefix = this.prefix;
        savedState.allowCollapse = this.allowCollapse;
        savedState.performBestGuess = this.performBestGuess;
        savedState.preventFreeFormText = this.preventFreeFormText;
        savedState.tokenClickStyle = this.tokenClickStyle;
        Class clsReifyParameterizedTypeClass = reifyParameterizedTypeClass();
        if (Parcelable.class.isAssignableFrom(clsReifyParameterizedTypeClass)) {
            savedState.parcelableClassName = clsReifyParameterizedTypeClass.getName();
            savedState.baseObjects = getObjects();
        } else {
            savedState.parcelableClassName = "Serializable";
            savedState.baseObjects = getSerializableObjects();
        }
        savedState.tokenizer = this.tokenizer;
        addListeners();
        return savedState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        List<?> listConvertSerializableObjectsToTypedObjects;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.internalEditInProgress = true;
        setText(savedState.prefix);
        this.prefix = savedState.prefix;
        this.internalEditInProgress = false;
        updateHint();
        this.allowCollapse = savedState.allowCollapse;
        this.performBestGuess = savedState.performBestGuess;
        this.preventFreeFormText = savedState.preventFreeFormText;
        this.tokenClickStyle = savedState.tokenClickStyle;
        this.tokenizer = savedState.tokenizer;
        addListeners();
        if ("Serializable".equals(savedState.parcelableClassName)) {
            listConvertSerializableObjectsToTypedObjects = convertSerializableObjectsToTypedObjects(savedState.baseObjects);
        } else {
            listConvertSerializableObjectsToTypedObjects = savedState.baseObjects;
        }
        Iterator<?> it = listConvertSerializableObjectsToTypedObjects.iterator();
        while (it.hasNext()) {
            addObjectSync(it.next());
        }
        if (isFocused() || !this.allowCollapse) {
            return;
        }
        post(new Runnable() { // from class: com.tokenautocomplete.TokenCompleteTextView.6
            @Override // java.lang.Runnable
            public void run() {
                TokenCompleteTextView tokenCompleteTextView = TokenCompleteTextView.this;
                tokenCompleteTextView.performCollapse(tokenCompleteTextView.isFocused());
            }
        });
    }

    private static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.tokenautocomplete.TokenCompleteTextView.SavedState.1
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
        static final String SERIALIZABLE_PLACEHOLDER = "Serializable";
        boolean allowCollapse;
        List<?> baseObjects;
        String parcelableClassName;
        boolean performBestGuess;
        CharSequence prefix;
        boolean preventFreeFormText;
        TokenClickStyle tokenClickStyle;
        Tokenizer tokenizer;
        String tokenizerClassName;

        SavedState(Parcel parcel) {
            super(parcel);
            this.prefix = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.allowCollapse = parcel.readInt() != 0;
            this.performBestGuess = parcel.readInt() != 0;
            this.preventFreeFormText = parcel.readInt() != 0;
            this.tokenClickStyle = TokenClickStyle.values()[parcel.readInt()];
            String string = parcel.readString();
            this.parcelableClassName = string;
            if (SERIALIZABLE_PLACEHOLDER.equals(string)) {
                this.baseObjects = (ArrayList) parcel.readSerializable();
            } else {
                try {
                    this.baseObjects = parcel.readArrayList(Class.forName(this.parcelableClassName).getClassLoader());
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
            String string2 = parcel.readString();
            this.tokenizerClassName = string2;
            try {
                this.tokenizer = (Tokenizer) parcel.readParcelable(Class.forName(string2).getClassLoader());
            } catch (ClassNotFoundException e2) {
                throw new RuntimeException(e2);
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            TextUtils.writeToParcel(this.prefix, parcel, 0);
            parcel.writeInt(this.allowCollapse ? 1 : 0);
            parcel.writeInt(this.performBestGuess ? 1 : 0);
            parcel.writeInt(this.preventFreeFormText ? 1 : 0);
            parcel.writeInt(this.tokenClickStyle.ordinal());
            if (SERIALIZABLE_PLACEHOLDER.equals(this.parcelableClassName)) {
                parcel.writeString(SERIALIZABLE_PLACEHOLDER);
                parcel.writeSerializable((Serializable) this.baseObjects);
            } else {
                parcel.writeString(this.parcelableClassName);
                parcel.writeList(this.baseObjects);
            }
            parcel.writeString(this.tokenizer.getClass().getCanonicalName());
            parcel.writeParcelable(this.tokenizer, 0);
        }

        public String toString() {
            return ("TokenCompleteTextView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " tokens=" + this.baseObjects) + "}";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean canDeleteSelection(int i) {
        if (getObjects().size() < 1) {
            return true;
        }
        int selectionEnd = getSelectionEnd();
        int selectionStart = i == 1 ? getSelectionStart() : selectionEnd - i;
        Editable text = getText();
        for (TokenImageSpan tokenImageSpan : (TokenImageSpan[]) text.getSpans(0, text.length(), TokenImageSpan.class)) {
            int spanStart = text.getSpanStart(tokenImageSpan);
            int spanEnd = text.getSpanEnd(tokenImageSpan);
            if (!isTokenRemovable(tokenImageSpan.token)) {
                if (selectionStart == selectionEnd) {
                    if (spanEnd + 1 == selectionEnd) {
                        return false;
                    }
                } else if (selectionStart <= spanStart && spanEnd + 1 <= selectionEnd) {
                    return false;
                }
            }
        }
        return true;
    }

    private class TokenInputConnection extends InputConnectionWrapper {
        TokenInputConnection(InputConnection inputConnection, boolean z) {
            super(inputConnection, z);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean deleteSurroundingText(int i, int i2) {
            if (!TokenCompleteTextView.this.canDeleteSelection(i)) {
                return false;
            }
            if (TokenCompleteTextView.this.getSelectionStart() <= TokenCompleteTextView.this.prefix.length()) {
                return TokenCompleteTextView.this.deleteSelectedObject() || super.deleteSurroundingText(0, i2);
            }
            return super.deleteSurroundingText(i, i2);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean setComposingRegion(int i, int i2) {
            if (TokenCompleteTextView.this.hintVisible) {
                i = 0;
                i2 = 0;
            }
            return super.setComposingRegion(i, i2);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean setComposingText(CharSequence charSequence, int i) {
            CharSequence hint = TokenCompleteTextView.this.getHint();
            if (hint != null && charSequence != null) {
                String str = hint.toString().trim().split(" ")[0];
                if (str.length() > 0 && str.equals(charSequence.toString())) {
                    charSequence = "";
                }
            }
            if (TokenCompleteTextView.this.lastCompletionText != null && charSequence != null && charSequence.length() == TokenCompleteTextView.this.lastCompletionText.length() + 1 && charSequence.toString().startsWith(TokenCompleteTextView.this.lastCompletionText)) {
                charSequence = charSequence.subSequence(charSequence.length() - 1, charSequence.length());
            }
            return super.setComposingText(charSequence, i);
        }
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        this.lastCompletionText = null;
    }
}
