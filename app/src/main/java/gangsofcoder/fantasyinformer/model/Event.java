package gangsofcoder.fantasyinformer.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by suraj on 05-May-18.
 */

public class Event {


    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("data")
    @Expose
    private List<EventData> data = null;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<EventData> getData() {
        return data;
    }

    public void setData(List<EventData> data) {
        this.data = data;
    }


    public class EventData {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("date")
        @Expose
        private String date;
        @SerializedName("DateTime")
        @Expose
        private String dateTime;
        @SerializedName("Category")
        @Expose
        private String category;
        @SerializedName("TeamA")
        @Expose
        private String teamA;
        @SerializedName("TeamB")
        @Expose
        private String teamB;
        @SerializedName("MatchType")
        @Expose
        private String matchType;
        @SerializedName("discription")
        @Expose
        private String discription;
        @SerializedName("base_path")
        @Expose
        private String basePath;
        private boolean showShimmer;
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getDateTime() {
            return dateTime;
        }

        public void setDateTime(String dateTime) {
            this.dateTime = dateTime;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getTeamA() {
            return teamA;
        }

        public void setTeamA(String teamA) {
            this.teamA = teamA;
        }

        public String getTeamB() {
            return teamB;
        }

        public void setTeamB(String teamB) {
            this.teamB = teamB;
        }

        public String getMatchType() {
            return matchType;
        }

        public void setMatchType(String matchType) {
            this.matchType = matchType;
        }

        public String getDiscription() {
            return discription;
        }

        public void setDiscription(String discription) {
            this.discription = discription;
        }

        public String getBasePath() {
            return basePath;
        }

        public void setBasePath(String basePath) {
            this.basePath = basePath;
        }

        public boolean isShowShimmer() {
            return showShimmer;
        }

        public void setShowShimmer(boolean showShimmer) {
            this.showShimmer = showShimmer;
        }
    }
}
