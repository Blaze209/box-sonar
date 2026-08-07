package expo.modules.nativeelementsexpo;

import com.google.firebase.analytics.FirebaseAnalytics;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;

/* JADX INFO: compiled from: NativeElementsExpoModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u00020\n8\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lexpo/modules/nativeelementsexpo/TriggerCharacterRecord;", "Lexpo/modules/kotlin/records/Record;", "<init>", "()V", FirebaseAnalytics.Param.CHARACTER, "", "getCharacter$annotations", "getCharacter", "()Ljava/lang/String;", "maxRange", "", "getMaxRange$annotations", "getMaxRange", "()I", "cirrus-native-elements-expo_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TriggerCharacterRecord implements Record {
    public static final int $stable = 0;
    private final String character = "";
    private final int maxRange = 100;

    @Field
    public static /* synthetic */ void getCharacter$annotations() {
    }

    @Field
    public static /* synthetic */ void getMaxRange$annotations() {
    }

    public final String getCharacter() {
        return this.character;
    }

    public final int getMaxRange() {
        return this.maxRange;
    }
}
