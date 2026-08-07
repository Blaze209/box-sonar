package androidx.compose.material3;

import kotlin.Metadata;

/* JADX INFO: compiled from: TimePicker.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R&\u0010\u0004\u001a\u00020\u00032\b\b\u0001\u0010\u0002\u001a\u00020\u00038'@fX¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\t\u001a\u00020\u00032\b\b\u0001\u0010\u0002\u001a\u00020\u00038'@fX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00038W@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00038W@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u0018\u0010\u0012\u001a\u00020\u0013X¦\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0017\u001a\u00020\u0018X¦\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001bÀ\u0006\u0001"}, d2 = {"Landroidx/compose/material3/TimePickerState;", "", "value", "", "minute", "getMinute", "()I", "setMinute", "(I)V", "hour", "getHour", "setHour", "hourInput", "getHourInput", "setHourInput", "minuteInput", "getMinuteInput", "setMinuteInput", "is24hour", "", "()Z", "set24hour", "(Z)V", "selection", "Landroidx/compose/material3/TimePickerSelectionMode;", "getSelection-yecRtBI", "setSelection-6_8s6DQ", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface TimePickerState {
    int getHour();

    int getMinute();

    /* JADX INFO: renamed from: getSelection-yecRtBI */
    int mo2728getSelectionyecRtBI();

    boolean is24hour();

    void set24hour(boolean z);

    void setHour(int i);

    void setMinute(int i);

    /* JADX INFO: renamed from: setSelection-6_8s6DQ */
    void mo2730setSelection6_8s6DQ(int i);

    default int getHourInput() {
        return getHour();
    }

    default void setHourInput(int i) {
        if (i < 0 || i >= 24) {
            return;
        }
        setHour(i);
    }

    default int getMinuteInput() {
        return getMinute();
    }

    default void setMinuteInput(int i) {
        if (i < 0 || i >= 60) {
            return;
        }
        setMinute(i);
    }
}
