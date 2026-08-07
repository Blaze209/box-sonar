package androidx.media3.exoplayer.trackselection;

import android.graphics.Point;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.Tracks;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.source.TrackGroupArray;
import com.google.common.collect.ImmutableList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public final class TrackSelectionUtil {

    public interface AdaptiveTrackSelectionFactory {
        ExoTrackSelection createAdaptiveTrackSelection(ExoTrackSelection.Definition definition);
    }

    private TrackSelectionUtil() {
    }

    public static ExoTrackSelection[] createTrackSelectionsForDefinitions(ExoTrackSelection.Definition[] definitionArr, AdaptiveTrackSelectionFactory adaptiveTrackSelectionFactory) {
        ExoTrackSelection[] exoTrackSelectionArr = new ExoTrackSelection[definitionArr.length];
        boolean z = false;
        for (int i = 0; i < definitionArr.length; i++) {
            ExoTrackSelection.Definition definition = definitionArr[i];
            if (definition != null) {
                if (definition.tracks.length > 1 && !z) {
                    exoTrackSelectionArr[i] = adaptiveTrackSelectionFactory.createAdaptiveTrackSelection(definition);
                    z = true;
                } else {
                    exoTrackSelectionArr[i] = new FixedTrackSelection(definition.group, definition.tracks[0], definition.type);
                }
            }
        }
        return exoTrackSelectionArr;
    }

    @Deprecated
    public static DefaultTrackSelector.Parameters updateParametersWithOverride(DefaultTrackSelector.Parameters parameters, int i, TrackGroupArray trackGroupArray, boolean z, DefaultTrackSelector.SelectionOverride selectionOverride) {
        DefaultTrackSelector.Parameters.Builder rendererDisabled = parameters.buildUpon().clearSelectionOverrides(i).setRendererDisabled(i, z);
        if (selectionOverride != null) {
            rendererDisabled.setSelectionOverride(i, trackGroupArray, selectionOverride);
        }
        return rendererDisabled.build();
    }

    public static Tracks buildTracks(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, TrackSelection[] trackSelectionArr) {
        List[] listArr = new List[trackSelectionArr.length];
        for (int i = 0; i < trackSelectionArr.length; i++) {
            TrackSelection trackSelection = trackSelectionArr[i];
            listArr[i] = trackSelection != null ? ImmutableList.of(trackSelection) : ImmutableList.of();
        }
        return buildTracks(mappedTrackInfo, (List<? extends TrackSelection>[]) listArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r3v10, types: [int] */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v21 */
    public static Tracks buildTracks(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, List<? extends TrackSelection>[] listArr) {
        boolean z;
        ImmutableList.Builder builder = new ImmutableList.Builder();
        boolean z2 = false;
        int i = 0;
        while (i < mappedTrackInfo.getRendererCount()) {
            TrackGroupArray trackGroups = mappedTrackInfo.getTrackGroups(i);
            int i2 = z2 ? 1 : 0;
            MappingTrackSelector.MappedTrackInfo mappedTrackInfo2 = mappedTrackInfo;
            boolean z3 = z2;
            while (i2 < trackGroups.length) {
                TrackGroup trackGroup = trackGroups.get(i2);
                boolean z4 = mappedTrackInfo2.getAdaptiveSupport(i, i2, z3) != 0 ? true : z3 ? 1 : 0;
                int[] iArr = new int[trackGroup.length];
                boolean[] zArr = new boolean[trackGroup.length];
                int i3 = z3 ? 1 : 0;
                MappingTrackSelector.MappedTrackInfo mappedTrackInfo3 = mappedTrackInfo2;
                boolean z5 = z3;
                while (i3 < trackGroup.length) {
                    iArr[i3] = mappedTrackInfo3.getTrackSupport(i, i2, i3);
                    int length = listArr.length;
                    int i4 = z5 ? 1 : 0;
                    boolean z6 = i4;
                    while (i4 < length) {
                        z = z5;
                        List<? extends TrackSelection> list = listArr[i4];
                        for (?? r3 = z; r3 < list.size(); r3++) {
                            TrackSelection trackSelection = list.get(r3);
                            if (trackSelection.getTrackGroup().equals(trackGroup) && trackSelection.indexOf(i3) != -1) {
                                z6 = true;
                                break;
                            }
                        }
                        i4++;
                        listArr = listArr;
                        z = false;
                        z6 = z6;
                    }
                    z = z5;
                    zArr[i3] = z6;
                    i3++;
                    mappedTrackInfo3 = mappedTrackInfo;
                    listArr = listArr;
                    z5 = false;
                }
                builder.add(new Tracks.Group(trackGroup, z4, iArr, zArr));
                i2++;
                mappedTrackInfo2 = mappedTrackInfo;
                listArr = listArr;
                z3 = false;
            }
            i++;
            z2 = false;
        }
        TrackGroupArray unmappedTrackGroups = mappedTrackInfo.getUnmappedTrackGroups();
        for (int i5 = 0; i5 < unmappedTrackGroups.length; i5++) {
            TrackGroup trackGroup2 = unmappedTrackGroups.get(i5);
            int[] iArr2 = new int[trackGroup2.length];
            Arrays.fill(iArr2, 0);
            builder.add(new Tracks.Group(trackGroup2, false, iArr2, new boolean[trackGroup2.length]));
        }
        return new Tracks(builder.build());
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0010  */
    public static Point getMaxVideoSizeInViewport(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            if ((i3 > i4) == (i > i2)) {
                i2 = i;
                i = i2;
            }
        } else {
            i2 = i;
            i = i2;
        }
        int i5 = i3 * i;
        int i6 = i4 * i2;
        if (i5 >= i6) {
            return new Point(i2, Util.ceilDivide(i6, i3));
        }
        return new Point(Util.ceilDivide(i5, i4), i);
    }
}
