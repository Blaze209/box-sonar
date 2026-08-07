package com.pspdfkit.ui.inspector.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.core.util.Pair;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.pspdfkit.R;
import com.pspdfkit.internal.a80;
import com.pspdfkit.internal.c30;
import com.pspdfkit.internal.dx;
import com.pspdfkit.internal.ex;
import com.pspdfkit.internal.f60;
import com.pspdfkit.internal.hn;
import com.pspdfkit.internal.n70;
import com.pspdfkit.internal.un;
import com.pspdfkit.internal.uw;
import com.pspdfkit.ui.LocalizedEditText;
import com.pspdfkit.ui.inspector.PropertyInspectorController;
import com.pspdfkit.ui.inspector.PropertyInspectorView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public final class OptionPickerInspectorView extends FrameLayout implements PropertyInspectorView, View.OnClickListener, View.OnFocusChangeListener, TextWatcher {
    private static final int CHECKBOX_SIZE_DP = 24;
    private static final int MIN_INSPECTOR_ITEMS_COUNT = 3;
    private static final int SUGGESTED_INSPECTOR_ITEMS_COUNT = 4;
    private String customValue;
    private LocalizedEditText customValueEditText;
    private Drawable customValueEditTextDrawable;
    private InputFilter[] customValueFilters;
    private int customValueInputType;
    private View customValueLayout;
    private final boolean isEditable;
    private final boolean isMultiSelectEnabled;
    private int itemHeight;
    private final OnOptionPickedListener listener;
    private int maxHeight;
    private final List<String> options;
    private OptionsAdapter optionsAdapter;
    private RecyclerView optionsContainer;
    private int originalSoftInputMode;
    private EditText searchView;
    private final List<Integer> selectedOptions;
    private boolean suppressCustomValueCallbacks;

    public interface OnOptionPickedListener {
        void onCustomValueChanged(String str);

        void onOptionsSelected(OptionPickerInspectorView optionPickerInspectorView, List<Integer> list);
    }

    public class OptionsAdapter extends RecyclerView.Adapter<ViewHolder> {
        static final int HEADER_TYPE = 0;
        static final int ITEM_TYPE = 1;
        String filter = "";
        List<Pair<Integer, Integer>> items = new ArrayList();
        final LayoutInflater layoutInflater;
        final dx style;

        public OptionsAdapter() {
            this.layoutInflater = LayoutInflater.from(OptionPickerInspectorView.this.getContext());
            this.style = new dx(OptionPickerInspectorView.this.getContext());
            setHasStableIds(true);
            prepareItems();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.items.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i) {
            return this.items.get(i).first.intValue();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return this.items.get(i).second.intValue();
        }

        public void prepareItems() {
            this.items.clear();
            OptionPickerInspectorView optionPickerInspectorView = OptionPickerInspectorView.this;
            if (optionPickerInspectorView.isEditable) {
                this.items.add(Pair.create(Integer.valueOf(optionPickerInspectorView.options.size()), 0));
            }
            for (int i = 0; i < OptionPickerInspectorView.this.options.size(); i++) {
                if (((String) OptionPickerInspectorView.this.options.get(i)).toLowerCase(Locale.getDefault()).contains(this.filter)) {
                    this.items.add(Pair.create(Integer.valueOf(i), 1));
                }
            }
            notifyDataSetChanged();
        }

        public void setFilter(String str) {
            this.filter = str;
            prepareItems();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            Pair<Integer, Integer> pair = this.items.get(i);
            if (getItemViewType(i) != 1) {
                OptionPickerInspectorView.this.updateCustomEditTextDrawable();
            } else {
                viewHolder.optionView.setText((CharSequence) OptionPickerInspectorView.this.options.get(pair.first.intValue()));
                viewHolder.optionView.setChecked(OptionPickerInspectorView.this.selectedOptions.contains(pair.first));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            LayoutInflater layoutInflater = this.layoutInflater;
            if (i == 1) {
                View viewInflate = layoutInflater.inflate(R.layout.pspdf__list_item_checked, viewGroup, false);
                ViewHolder viewHolder = new ViewHolder(viewInflate);
                viewInflate.setMinimumHeight(this.style.a);
                int i2 = this.style.e;
                viewInflate.setPadding(i2, 0, i2, 0);
                viewHolder.optionView.setTextColor(this.style.c);
                viewHolder.optionView.setTextSize(0, this.style.d);
                viewHolder.optionView.setCheckMarkDrawable(a80.a(OptionPickerInspectorView.this.getContext(), R.drawable.pspdf__check_mark, this.style.c));
                viewInflate.setOnClickListener(OptionPickerInspectorView.this);
                return viewHolder;
            }
            View viewInflate2 = layoutInflater.inflate(R.layout.pspdf__option_picker_custom_value_view, viewGroup, false);
            OptionPickerInspectorView.this.customValueEditText = (LocalizedEditText) viewInflate2.findViewById(R.id.pspdf__custom_value_edit_text);
            OptionPickerInspectorView optionPickerInspectorView = OptionPickerInspectorView.this;
            optionPickerInspectorView.customValueEditText.setText(optionPickerInspectorView.customValue);
            OptionPickerInspectorView.this.customValueLayout = viewInflate2.findViewById(R.id.pspdf__custom_value_layout);
            View view = OptionPickerInspectorView.this.customValueLayout;
            if (view != null) {
                int i3 = this.style.e;
                view.setPadding(i3, 0, i3, 0);
            }
            OptionPickerInspectorView optionPickerInspectorView2 = OptionPickerInspectorView.this;
            optionPickerInspectorView2.customValueEditTextDrawable = a80.a(optionPickerInspectorView2.getContext(), R.drawable.pspdf__ic_done, this.style.c);
            OptionPickerInspectorView optionPickerInspectorView3 = OptionPickerInspectorView.this;
            if (optionPickerInspectorView3.customValueEditTextDrawable != null) {
                int iA = a80.a(optionPickerInspectorView3.getContext(), 24);
                OptionPickerInspectorView.this.customValueEditTextDrawable.setBounds(0, 0, iA, iA);
            }
            OptionPickerInspectorView.this.updateCustomEditTextDrawable();
            OptionPickerInspectorView.this.customValueEditText.setMinimumHeight(this.style.a);
            OptionPickerInspectorView.this.customValueEditText.setTextSize(0, this.style.d);
            OptionPickerInspectorView.this.customValueEditText.setTextColor(this.style.c);
            OptionPickerInspectorView optionPickerInspectorView4 = OptionPickerInspectorView.this;
            optionPickerInspectorView4.customValueEditText.setInputType(optionPickerInspectorView4.customValueInputType);
            OptionPickerInspectorView optionPickerInspectorView5 = OptionPickerInspectorView.this;
            InputFilter[] inputFilterArr = optionPickerInspectorView5.customValueFilters;
            if (inputFilterArr != null) {
                optionPickerInspectorView5.customValueEditText.setFilters(inputFilterArr);
            }
            OptionPickerInspectorView optionPickerInspectorView6 = OptionPickerInspectorView.this;
            optionPickerInspectorView6.customValueEditText.addTextChangedListener(optionPickerInspectorView6);
            OptionPickerInspectorView optionPickerInspectorView7 = OptionPickerInspectorView.this;
            optionPickerInspectorView7.customValueEditText.setOnFocusChangeListener(optionPickerInspectorView7);
            return new ViewHolder(viewInflate2);
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final CheckedTextView optionView;

        public ViewHolder(View view) {
            super(view);
            this.optionView = (CheckedTextView) view.findViewById(R.id.pspdf__check_view);
        }
    }

    public OptionPickerInspectorView(Context context, List<String> list, List<Integer> list2, boolean z, boolean z2, String str, OnOptionPickedListener onOptionPickedListener) {
        super(context);
        this.selectedOptions = new ArrayList();
        this.customValueInputType = 1;
        this.maxHeight = 0;
        uw.a(list, "options", null);
        uw.a(list2, "defaultSelectedOptions", null);
        this.options = list;
        this.listener = onOptionPickedListener;
        this.isMultiSelectEnabled = z;
        this.isEditable = z2;
        init(context, list2, str);
    }

    private void clearCustomValueText() {
        LocalizedEditText localizedEditText = this.customValueEditText;
        if (localizedEditText != null) {
            this.suppressCustomValueCallbacks = true;
            try {
                localizedEditText.setText((CharSequence) null);
                this.suppressCustomValueCallbacks = false;
                this.customValueEditText.clearFocus();
            } catch (Throwable th) {
                this.suppressCustomValueCallbacks = false;
                throw th;
            }
        }
    }

    private int getCustomValueLayoutHeight() {
        View view = this.customValueLayout;
        if (view != null) {
            return view.getMeasuredHeight();
        }
        return 0;
    }

    private int getSearchViewHeight() {
        EditText editText = this.searchView;
        if (editText != null) {
            return editText.getMeasuredHeight();
        }
        return 0;
    }

    private void init(Context context, List<Integer> list, String str) {
        this.selectedOptions.addAll(list);
        this.customValue = str;
        Context context2 = getContext();
        TypedArray typedArrayA = ex.a(context2);
        int dimensionPixelSize = typedArrayA.getDimensionPixelSize(R.styleable.pspdf__PropertyInspector_pspdf__itemHeight, context2.getResources().getDimensionPixelSize(R.dimen.pspdf__inspector_item_height));
        typedArrayA.getColor(R.styleable.pspdf__PropertyInspector_pspdf__backgroundColor, -1);
        typedArrayA.getColor(R.styleable.pspdf__PropertyInspector_pspdf__progressBackgroundTint, -7829368);
        int color = typedArrayA.getColor(R.styleable.pspdf__PropertyInspector_pspdf__textColor, -7829368);
        typedArrayA.getColor(R.styleable.pspdf__PropertyInspector_pspdf__errorColor, ContextCompat.getColor(context2, R.color.pspdf__errorContainerLight));
        ContextCompat.getColor(context2, R.color.pspdf__outlineVariantLight);
        boolean z = typedArrayA.getBoolean(R.styleable.pspdf__PropertyInspector_pspdf__searchVisible, false);
        typedArrayA.getColor(R.styleable.pspdf__PropertyInspector_pspdf__buttonIconTint, f60.a(context2, androidx.appcompat.R.attr.colorAccent, R.color.pspdf__primaryLight));
        typedArrayA.recycle();
        float dimension = context2.getResources().getDimension(R.dimen.pspdf__inspector_text_size);
        context2.getResources().getDimensionPixelSize(R.dimen.pspdf__inspector_preview_item_height);
        int dimensionPixelSize2 = context2.getResources().getDimensionPixelSize(R.dimen.pspdf__inspector_padding);
        context2.getResources().getDimensionPixelSize(R.dimen.pspdf__inspector_vertical_padding);
        this.itemHeight = dimensionPixelSize;
        LayoutInflater.from(context).inflate(R.layout.pspdf__option_picker_inspector_view, (ViewGroup) this, true);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.pspdf__options_layout);
        this.optionsContainer = recyclerView;
        recyclerView.setNestedScrollingEnabled(true);
        OptionsAdapter optionsAdapter = new OptionsAdapter();
        this.optionsAdapter = optionsAdapter;
        this.optionsContainer.setAdapter(optionsAdapter);
        this.optionsContainer.setLayoutManager(new LinearLayoutManager(context, 1, false));
        if (z) {
            EditText editText = (EditText) findViewById(R.id.pspdf__search_edit_text_inline);
            this.searchView = editText;
            editText.setVisibility(0);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.searchView.getLayoutParams();
            marginLayoutParams.setMargins(dimensionPixelSize2 - a80.a(context, 4), 0, dimensionPixelSize2 - ((int) un.a(context, 1, 4)), 0);
            this.searchView.setLayoutParams(marginLayoutParams);
            this.searchView.setMinimumHeight(dimensionPixelSize);
            this.searchView.setTextSize(0, dimension);
            this.searchView.setTextColor(color);
            this.searchView.setOnFocusChangeListener(this);
            this.searchView.setMaxLines(1);
            this.searchView.setInputType(177);
            this.searchView.setImeOptions(3);
            this.searchView.addTextChangedListener(new c30() { // from class: com.pspdfkit.ui.inspector.views.OptionPickerInspectorView.1
                @Override // com.pspdfkit.internal.c30, android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    OptionPickerInspectorView.this.optionsAdapter.setFilter(charSequence.toString());
                }
            });
        }
    }

    private boolean isSelected(int i) {
        return i < this.options.size() && i >= 0 && this.selectedOptions.contains(Integer.valueOf(i));
    }

    private void onSelectedOptionsChanged() {
        OnOptionPickedListener onOptionPickedListener = this.listener;
        if (onOptionPickedListener != null) {
            onOptionPickedListener.onOptionsSelected(this, getSelectedOptions());
        }
    }

    private boolean setSelectedOption(int i, boolean z, boolean z2) {
        boolean z3 = false;
        if (i < this.options.size() && i >= 0) {
            z3 = this.selectedOptions.contains(Integer.valueOf(i)) != z;
            if (z3 && z) {
                this.selectedOptions.add(Integer.valueOf(i));
            } else if (!z) {
                this.selectedOptions.remove(Integer.valueOf(i));
            }
            this.optionsAdapter.notifyDataSetChanged();
            if (z3 && z2) {
                onSelectedOptionsChanged();
            }
        }
        return z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCustomEditTextDrawable() {
        LocalizedEditText localizedEditText = this.customValueEditText;
        if (localizedEditText == null || this.customValueEditTextDrawable == null) {
            return;
        }
        boolean zIsEmpty = TextUtils.isEmpty(localizedEditText.getText());
        LocalizedEditText localizedEditText2 = this.customValueEditText;
        if (zIsEmpty) {
            localizedEditText2.setCompoundDrawables(null, null, null, null);
        } else {
            localizedEditText2.setCompoundDrawables(null, null, this.customValueEditTextDrawable, null);
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public void bindController(PropertyInspectorController propertyInspectorController) {
    }

    public String getCustomValue() {
        LocalizedEditText localizedEditText = this.customValueEditText;
        if (localizedEditText != null) {
            return localizedEditText.getText().toString();
        }
        return null;
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public int getPropertyInspectorMaxHeight() {
        int iMax = Math.max(this.maxHeight, getMeasuredHeight());
        this.maxHeight = iMax;
        return iMax;
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public int getPropertyInspectorMinHeight() {
        return (Math.min(3, this.options.size()) * this.itemHeight) + getSearchViewHeight();
    }

    public List<Integer> getSelectedOptions() {
        return new ArrayList(this.selectedOptions);
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public int getSuggestedHeight() {
        return Math.min(this.optionsContainer.getMeasuredHeight(), Math.min(4, this.options.size()) * this.itemHeight) + getCustomValueLayoutHeight() + getSearchViewHeight();
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public View getView() {
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int itemId = (int) this.optionsAdapter.getItemId(this.optionsContainer.getLayoutManager().getPosition(view));
        if (itemId < 0) {
            return;
        }
        if (this.isMultiSelectEnabled) {
            setSelectedOption(itemId, !isSelected(itemId), true);
        } else {
            setSelectedOptions(Collections.singletonList(Integer.valueOf(itemId)), true);
        }
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (z) {
            this.originalSoftInputMode = hn.a(getContext(), 16);
        } else {
            hn.a(getContext(), this.originalSoftInputMode);
            hn.c(view);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        if (size > 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String string = charSequence.toString();
        if (n70.a(string, this.customValue)) {
            return;
        }
        this.customValue = string;
        updateCustomEditTextDrawable();
        if (this.suppressCustomValueCallbacks) {
            return;
        }
        if (!this.isMultiSelectEnabled && !TextUtils.isEmpty(string)) {
            setSelectedOptions(Collections.EMPTY_LIST, true);
        }
        OnOptionPickedListener onOptionPickedListener = this.listener;
        if (onOptionPickedListener != null) {
            onOptionPickedListener.onCustomValueChanged(string);
        }
    }

    public void setCustomValue(String str) {
        if (this.customValueEditText == null || n70.a(str, this.customValue)) {
            return;
        }
        this.suppressCustomValueCallbacks = true;
        try {
            this.customValueEditText.setText(str);
        } finally {
            this.suppressCustomValueCallbacks = false;
        }
    }

    public void setFilters(InputFilter[] inputFilterArr) {
        uw.a(inputFilterArr, "filters", null);
        this.customValueFilters = inputFilterArr;
        LocalizedEditText localizedEditText = this.customValueEditText;
        if (localizedEditText == null) {
            return;
        }
        localizedEditText.setFilters(inputFilterArr);
    }

    public void setInputType(int i) {
        this.customValueInputType = i;
        LocalizedEditText localizedEditText = this.customValueEditText;
        if (localizedEditText == null) {
            return;
        }
        localizedEditText.setInputType(i);
    }

    public void setSelectedOptions(List<Integer> list, boolean z) {
        boolean selectedOption;
        uw.a(list, "selectedOptions", null);
        if (this.isMultiSelectEnabled) {
            selectedOption = false;
            for (int i = 0; i < this.options.size(); i++) {
                selectedOption |= setSelectedOption(i, list.contains(Integer.valueOf(i)), false);
            }
        } else {
            int iIntValue = list.isEmpty() ? -1 : list.get(0).intValue();
            selectedOption = false;
            int i2 = 0;
            while (i2 < this.options.size()) {
                selectedOption |= setSelectedOption(i2, i2 == iIntValue, false);
                i2++;
            }
            if (!list.isEmpty()) {
                clearCustomValueText();
            }
        }
        if (selectedOption && z) {
            onSelectedOptionsChanged();
        }
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public void unbindController() {
    }
}
