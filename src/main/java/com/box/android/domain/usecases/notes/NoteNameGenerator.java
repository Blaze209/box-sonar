package com.box.android.domain.usecases.notes;

import com.box.android.common.utilities.Clock;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.common.utilities.ResourcesProvider;
import com.box.android.domain.R;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoteNameGenerator.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/box/android/domain/usecases/notes/NoteNameGenerator;", "", "resourcesProvider", "Lcom/box/android/common/utilities/ResourcesProvider;", "clock", "Lcom/box/android/common/utilities/Clock;", "<init>", "(Lcom/box/android/common/utilities/ResourcesProvider;Lcom/box/android/common/utilities/Clock;)V", "generate", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NoteNameGenerator {
    private final Clock clock;
    private final ResourcesProvider resourcesProvider;

    @Inject
    public NoteNameGenerator(ResourcesProvider resourcesProvider, Clock clock) {
        Intrinsics.checkNotNullParameter(resourcesProvider, "resourcesProvider");
        Intrinsics.checkNotNullParameter(clock, "clock");
        this.resourcesProvider = resourcesProvider;
        this.clock = clock;
    }

    public final String generate() {
        return this.resourcesProvider.getString(R.string.untitled_note) + " " + new SimpleDateFormat(CommonBoxUtil.DATE_FORMAT, Locale.US).format(new Date(this.clock.currentTimeMillis())) + ".boxnote";
    }
}
