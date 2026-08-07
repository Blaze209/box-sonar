package com.box.android.data.user;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.box.android.data.persistence.BoxDatabaseKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DatabaseProvider.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J3\u0010\u0004\u001a\u0002H\u0005\"\b\b\u0000\u0010\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00050\n2\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/box/android/data/user/DatabaseProvider;", "", "<init>", "()V", "createDb", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/room/RoomDatabase;", "context", "Landroid/content/Context;", "klass", "Ljava/lang/Class;", "name", "", "(Landroid/content/Context;Ljava/lang/Class;Ljava/lang/String;)Landroidx/room/RoomDatabase;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DatabaseProvider {
    @Inject
    public DatabaseProvider() {
    }

    public final <T extends RoomDatabase> T createDb(Context context, Class<T> klass, String name) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(klass, "klass");
        Intrinsics.checkNotNullParameter(name, "name");
        return (T) Room.databaseBuilder(context, klass, name).addMigrations(BoxDatabaseKt.getMIGRATION_1_2()).addMigrations(BoxDatabaseKt.getMIGRATION_2_3()).addMigrations(BoxDatabaseKt.getMIGRATION_3_4()).addMigrations(BoxDatabaseKt.getMIGRATION_4_5()).addMigrations(BoxDatabaseKt.getMIGRATION_5_6()).addMigrations(BoxDatabaseKt.getMIGRATION_6_7()).addMigrations(BoxDatabaseKt.getMIGRATION_7_8()).addMigrations(BoxDatabaseKt.getMIGRATION_8_9()).addMigrations(BoxDatabaseKt.getMIGRATION_9_10()).addMigrations(BoxDatabaseKt.getMIGRATION_10_11()).addMigrations(BoxDatabaseKt.getMIGRATION_11_12()).addMigrations(BoxDatabaseKt.getMIGRATION_12_13()).addMigrations(BoxDatabaseKt.getMIGRATION_13_14()).addMigrations(BoxDatabaseKt.getMIGRATION_14_15()).addMigrations(BoxDatabaseKt.getMIGRATION_15_16()).addMigrations(BoxDatabaseKt.getMIGRATION_16_17()).addMigrations(BoxDatabaseKt.getMIGRATION_17_18()).addMigrations(BoxDatabaseKt.getMIGRATION_18_19()).addMigrations(BoxDatabaseKt.getMIGRATION_19_20()).addMigrations(BoxDatabaseKt.getMIGRATION_20_21()).addMigrations(BoxDatabaseKt.getMIGRATION_21_22()).addMigrations(BoxDatabaseKt.getMIGRATION_22_23()).addMigrations(BoxDatabaseKt.getMIGRATION_23_24()).addMigrations(BoxDatabaseKt.getMIGRATION_24_25()).addMigrations(BoxDatabaseKt.getMIGRATION_25_26()).addMigrations(BoxDatabaseKt.getMIGRATION_34_35()).addMigrations(BoxDatabaseKt.getMIGRATION_37_38()).addMigrations(BoxDatabaseKt.getMIGRATION_39_40()).build();
    }
}
