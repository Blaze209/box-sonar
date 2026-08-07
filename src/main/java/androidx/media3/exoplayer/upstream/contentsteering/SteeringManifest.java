package androidx.media3.exoplayer.upstream.contentsteering;

import android.net.Uri;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes8.dex */
public final class SteeringManifest {
    public final ImmutableList<PathwayClone> pathwayClones;
    public final ImmutableList<String> pathwayPriority;
    public final Uri reloadUri;
    public final long timeToLiveMs;
    public final int version;

    public static final class PathwayClone {
        public final String baseId;
        public final String id;
        public final UriReplacement uriReplacement;

        public PathwayClone(String str, String str2, UriReplacement uriReplacement) {
            this.baseId = str;
            this.id = str2;
            this.uriReplacement = uriReplacement;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PathwayClone)) {
                return false;
            }
            PathwayClone pathwayClone = (PathwayClone) obj;
            return Objects.equals(this.baseId, pathwayClone.baseId) && Objects.equals(this.id, pathwayClone.id) && Objects.equals(this.uriReplacement, pathwayClone.uriReplacement);
        }

        public int hashCode() {
            return Objects.hash(this.baseId, this.id, this.uriReplacement);
        }
    }

    public static final class UriReplacement {
        public final String host;
        public final ImmutableMap<String, String> params;
        public final ImmutableMap<String, Uri> perRenditionUris;
        public final ImmutableMap<String, Uri> perVariantUris;

        public UriReplacement(String str, Map<String, String> map, Map<String, Uri> map2, Map<String, Uri> map3) {
            this.host = str;
            this.params = ImmutableMap.copyOf((Map) map);
            this.perVariantUris = ImmutableMap.copyOf((Map) map2);
            this.perRenditionUris = ImmutableMap.copyOf((Map) map3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof UriReplacement)) {
                return false;
            }
            UriReplacement uriReplacement = (UriReplacement) obj;
            return Objects.equals(this.host, uriReplacement.host) && Objects.equals(this.params, uriReplacement.params) && Objects.equals(this.perVariantUris, uriReplacement.perVariantUris) && Objects.equals(this.perRenditionUris, uriReplacement.perRenditionUris);
        }

        public int hashCode() {
            return Objects.hash(this.host, this.params, this.perVariantUris, this.perRenditionUris);
        }
    }

    public SteeringManifest(int i, long j, Uri uri, List<String> list, List<PathwayClone> list2) {
        this.version = i;
        this.timeToLiveMs = j;
        this.reloadUri = uri;
        this.pathwayPriority = ImmutableList.copyOf((Collection) list);
        this.pathwayClones = ImmutableList.copyOf((Collection) list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SteeringManifest)) {
            return false;
        }
        SteeringManifest steeringManifest = (SteeringManifest) obj;
        return this.version == steeringManifest.version && this.timeToLiveMs == steeringManifest.timeToLiveMs && Objects.equals(this.reloadUri, steeringManifest.reloadUri) && Objects.equals(this.pathwayPriority, steeringManifest.pathwayPriority) && Objects.equals(this.pathwayClones, steeringManifest.pathwayClones);
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.version), Long.valueOf(this.timeToLiveMs), this.reloadUri, this.pathwayPriority, this.pathwayClones);
    }
}
