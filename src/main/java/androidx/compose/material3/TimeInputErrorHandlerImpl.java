package androidx.compose.material3;

import android.media.AudioManager;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import kotlin.Metadata;

/* JADX INFO: compiled from: TimePicker.android.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Landroidx/compose/material3/TimeInputErrorHandlerImpl;", "Landroidx/compose/material3/TimeInputErrorHandler;", "haptics", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "audioManager", "Landroid/media/AudioManager;", "isTouchExplorationEnabled", "", "<init>", "(Landroidx/compose/ui/hapticfeedback/HapticFeedback;Landroid/media/AudioManager;Z)V", "onError", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class TimeInputErrorHandlerImpl implements TimeInputErrorHandler {
    private final AudioManager audioManager;
    private final HapticFeedback haptics;
    private final boolean isTouchExplorationEnabled;

    public TimeInputErrorHandlerImpl(HapticFeedback hapticFeedback, AudioManager audioManager, boolean z) {
        this.haptics = hapticFeedback;
        this.audioManager = audioManager;
        this.isTouchExplorationEnabled = z;
    }

    @Override // androidx.compose.material3.TimeInputErrorHandler
    public void onError() {
        this.haptics.mo7590performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m7604getReject5zf0vsI());
        if (this.isTouchExplorationEnabled) {
            return;
        }
        this.audioManager.playSoundEffect(9, 0.5f);
    }
}
