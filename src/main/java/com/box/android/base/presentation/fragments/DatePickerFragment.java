package com.box.android.base.presentation.fragments;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.DatePicker;
import com.box.android.base.R;
import java.util.Calendar;
import java.util.Date;

/* JADX INFO: loaded from: classes9.dex */
public class DatePickerFragment extends PositiveNegativeDialogFragment implements DatePickerDialog.OnDateSetListener, DialogInterface.OnDismissListener {
    private static final String EXTRA_START_DATE = "extraStartDate";
    DatePickerDialog mDialog;
    private DatePickerDialog.OnDateSetListener mOnDateSetListener;
    private final String EXTRA_KEY_YEAR = "extraYear";
    private final String EXTRA_KEY_MONTH = "extraMonth";
    private final String EXTRA_KEY_DAY = "extraDay";

    @Override // com.box.android.base.presentation.fragments.PositiveNegativeDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Date date;
        setRetainInstance(true);
        this.mButtonClicked = false;
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, 1);
        Calendar calendar2 = Calendar.getInstance();
        if (getArguments() != null && (date = (Date) getArguments().getSerializable(EXTRA_START_DATE)) != null) {
            calendar2.setTime(date);
        }
        if (calendar2.getTimeInMillis() < calendar.getTimeInMillis()) {
            calendar2.setTime(calendar.getTime());
        }
        int i = calendar2.get(1);
        int i2 = calendar2.get(2);
        int i3 = calendar2.get(5);
        if (bundle != null) {
            i = bundle.getInt("extraYear");
            i2 = bundle.getInt("extraMonth");
            i3 = bundle.getInt("extraDay");
        }
        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), R.style.ShareDialogTheme, this, i, i2, i3);
        this.mDialog = datePickerDialog;
        datePickerDialog.getDatePicker().setMinDate(calendar.getTimeInMillis());
        return this.mDialog;
    }

    public void setOnDateSetListener(DatePickerDialog.OnDateSetListener onDateSetListener) {
        this.mOnDateSetListener = onDateSetListener;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("extraYear", this.mDialog.getDatePicker().getYear());
        bundle.putInt("extraMonth", this.mDialog.getDatePicker().getMonth());
        bundle.putInt("extraDay", this.mDialog.getDatePicker().getDayOfMonth());
        super.onSaveInstanceState(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.DatePickerDialog.OnDateSetListener
    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        this.mButtonClicked = true;
        DatePickerDialog.OnDateSetListener onDateSetListener = this.mOnDateSetListener;
        if (onDateSetListener != null) {
            onDateSetListener.onDateSet(datePicker, i, i2, i3);
        }
    }

    @Override // com.box.android.base.presentation.fragments.PositiveNegativeDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Dialog dialog = getDialog();
        if (dialog != null && getRetainInstance()) {
            dialog.setDismissMessage(null);
        }
        super.onDestroyView();
    }

    public static final DatePickerFragment createFragment(Date date, DatePickerDialog.OnDateSetListener onDateSetListener, PositiveNegativeDialogFragment.OnPositiveOrNegativeButtonClickedListener onPositiveOrNegativeButtonClickedListener) {
        DatePickerFragment datePickerFragment = new DatePickerFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(EXTRA_START_DATE, date);
        datePickerFragment.setArguments(bundle);
        datePickerFragment.setOnDateSetListener(onDateSetListener);
        datePickerFragment.setOnPositiveOrNegativeButtonClickedListener(onPositiveOrNegativeButtonClickedListener);
        return datePickerFragment;
    }
}
