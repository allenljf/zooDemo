package com.allenli.zoo.model.bean;

import java.io.Serializable;
import java.util.List;

public class AnimalBean {

    private ResultBean result;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {

        private int limit;
        private int offset;
        private int count;
        private String sort;
        private List<ResultsBean> results;

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
            this.sort = sort;
        }

        public List<ResultsBean> getResults() {
            return results;
        }

        public void setResults(List<ResultsBean> results) {
            this.results = results;
        }

        public static class ResultsBean implements Serializable {
            private String _full_count;
            private String A_Behavior;
            private String A_Distribution;
            private String A_Voice03_URL;
            private String A_POIGroup;
            private double rank;
            private String A_Code;
            private String A_Pic04_ALT;
            private String A_Voice03_ALT;
            private String A_Theme_URL;
            private String A_Summary;
            private String A_Update;
            private String A_Pic02_URL;
            private String A_pdf01_ALT;
            private String A_Keywords;
            private String A_Theme_Name;
            private String A_pdf02_ALT;
            private String A_Family;
            private String A_Adopt;
            private String A_Voice01_ALT;
            private String A_Pic02_ALT;
            private String A_Vedio_URL;
            private String A_Pic04_URL;
            private String A_Order;
            private String A_pdf01_URL;
            private String A_Voice02_ALT;
            private String A_Diet;
            private String A_Name_Latin;
            private String A_Feature;
            private String A_Habitat;
            private String A_Phylum;
            private String A_Class;
            private String A_Pic03_ALT;
            private String A_AlsoKnown;
            private String A_Voice02_URL;
            private String A_Name_En;
            private String A_Name_Ch;
            private String A_Pic03_URL;
            private String A_Location;
            private String A_Voice01_URL;
            private String A_pdf02_URL;
            private String A_CID;
            private String A_Interpretation;
            private String A_Pic01_URL;
            private String A_Conservation;
            private String A_Pic01_ALT;
            private int _id;
            private String A_Geo;
            private String A_Crisis;

            public String get_full_count() {
                return _full_count;
            }

            public void set_full_count(String _full_count) {
                this._full_count = _full_count;
            }

            public String getA_Behavior() {
                return A_Behavior;
            }

            public void setA_Behavior(String A_Behavior) {
                this.A_Behavior = A_Behavior;
            }

            public String getA_Distribution() {
                return A_Distribution;
            }

            public void setA_Distribution(String A_Distribution) {
                this.A_Distribution = A_Distribution;
            }

            public String getA_Voice03_URL() {
                return A_Voice03_URL;
            }

            public void setA_Voice03_URL(String A_Voice03_URL) {
                this.A_Voice03_URL = A_Voice03_URL;
            }

            public String getA_POIGroup() {
                return A_POIGroup;
            }

            public void setA_POIGroup(String A_POIGroup) {
                this.A_POIGroup = A_POIGroup;
            }

            public double getRank() {
                return rank;
            }

            public void setRank(double rank) {
                this.rank = rank;
            }

            public String getA_Code() {
                return A_Code;
            }

            public void setA_Code(String A_Code) {
                this.A_Code = A_Code;
            }

            public String getA_Pic04_ALT() {
                return A_Pic04_ALT;
            }

            public void setA_Pic04_ALT(String A_Pic04_ALT) {
                this.A_Pic04_ALT = A_Pic04_ALT;
            }

            public String getA_Voice03_ALT() {
                return A_Voice03_ALT;
            }

            public void setA_Voice03_ALT(String A_Voice03_ALT) {
                this.A_Voice03_ALT = A_Voice03_ALT;
            }

            public String getA_Theme_URL() {
                return A_Theme_URL;
            }

            public void setA_Theme_URL(String A_Theme_URL) {
                this.A_Theme_URL = A_Theme_URL;
            }

            public String getA_Summary() {
                return A_Summary;
            }

            public void setA_Summary(String A_Summary) {
                this.A_Summary = A_Summary;
            }

            public String getA_Update() {
                return A_Update;
            }

            public void setA_Update(String A_Update) {
                this.A_Update = A_Update;
            }

            public String getA_Pic02_URL() {
                return A_Pic02_URL;
            }

            public void setA_Pic02_URL(String A_Pic02_URL) {
                this.A_Pic02_URL = A_Pic02_URL;
            }

            public String getA_pdf01_ALT() {
                return A_pdf01_ALT;
            }

            public void setA_pdf01_ALT(String A_pdf01_ALT) {
                this.A_pdf01_ALT = A_pdf01_ALT;
            }

            public String getA_Keywords() {
                return A_Keywords;
            }

            public void setA_Keywords(String A_Keywords) {
                this.A_Keywords = A_Keywords;
            }

            public String getA_Theme_Name() {
                return A_Theme_Name;
            }

            public void setA_Theme_Name(String A_Theme_Name) {
                this.A_Theme_Name = A_Theme_Name;
            }

            public String getA_pdf02_ALT() {
                return A_pdf02_ALT;
            }

            public void setA_pdf02_ALT(String A_pdf02_ALT) {
                this.A_pdf02_ALT = A_pdf02_ALT;
            }

            public String getA_Family() {
                return A_Family;
            }

            public void setA_Family(String A_Family) {
                this.A_Family = A_Family;
            }

            public String getA_Adopt() {
                return A_Adopt;
            }

            public void setA_Adopt(String A_Adopt) {
                this.A_Adopt = A_Adopt;
            }

            public String getA_Voice01_ALT() {
                return A_Voice01_ALT;
            }

            public void setA_Voice01_ALT(String A_Voice01_ALT) {
                this.A_Voice01_ALT = A_Voice01_ALT;
            }

            public String getA_Pic02_ALT() {
                return A_Pic02_ALT;
            }

            public void setA_Pic02_ALT(String A_Pic02_ALT) {
                this.A_Pic02_ALT = A_Pic02_ALT;
            }

            public String getA_Vedio_URL() {
                return A_Vedio_URL;
            }

            public void setA_Vedio_URL(String A_Vedio_URL) {
                this.A_Vedio_URL = A_Vedio_URL;
            }

            public String getA_Pic04_URL() {
                return A_Pic04_URL;
            }

            public void setA_Pic04_URL(String A_Pic04_URL) {
                this.A_Pic04_URL = A_Pic04_URL;
            }

            public String getA_Order() {
                return A_Order;
            }

            public void setA_Order(String A_Order) {
                this.A_Order = A_Order;
            }

            public String getA_pdf01_URL() {
                return A_pdf01_URL;
            }

            public void setA_pdf01_URL(String A_pdf01_URL) {
                this.A_pdf01_URL = A_pdf01_URL;
            }

            public String getA_Voice02_ALT() {
                return A_Voice02_ALT;
            }

            public void setA_Voice02_ALT(String A_Voice02_ALT) {
                this.A_Voice02_ALT = A_Voice02_ALT;
            }

            public String getA_Diet() {
                return A_Diet;
            }

            public void setA_Diet(String A_Diet) {
                this.A_Diet = A_Diet;
            }

            public String getA_Name_Latin() {
                return A_Name_Latin;
            }

            public void setA_Name_Latin(String A_Name_Latin) {
                this.A_Name_Latin = A_Name_Latin;
            }

            public String getA_Feature() {
                return A_Feature;
            }

            public void setA_Feature(String A_Feature) {
                this.A_Feature = A_Feature;
            }

            public String getA_Habitat() {
                return A_Habitat;
            }

            public void setA_Habitat(String A_Habitat) {
                this.A_Habitat = A_Habitat;
            }

            public String getA_Phylum() {
                return A_Phylum;
            }

            public void setA_Phylum(String A_Phylum) {
                this.A_Phylum = A_Phylum;
            }

            public String getA_Class() {
                return A_Class;
            }

            public void setA_Class(String A_Class) {
                this.A_Class = A_Class;
            }

            public String getA_Pic03_ALT() {
                return A_Pic03_ALT;
            }

            public void setA_Pic03_ALT(String A_Pic03_ALT) {
                this.A_Pic03_ALT = A_Pic03_ALT;
            }

            public String getA_AlsoKnown() {
                return A_AlsoKnown;
            }

            public void setA_AlsoKnown(String A_AlsoKnown) {
                this.A_AlsoKnown = A_AlsoKnown;
            }

            public String getA_Voice02_URL() {
                return A_Voice02_URL;
            }

            public void setA_Voice02_URL(String A_Voice02_URL) {
                this.A_Voice02_URL = A_Voice02_URL;
            }

            public String getA_Name_En() {
                return A_Name_En;
            }

            public void setA_Name_En(String A_Name_En) {
                this.A_Name_En = A_Name_En;
            }

            public String getA_Name_Ch() {
                return A_Name_Ch;
            }

            public void setA_Name_Ch(String A_Name_Ch) {
                this.A_Name_Ch = A_Name_Ch;
            }

            public String getA_Pic03_URL() {
                return A_Pic03_URL;
            }

            public void setA_Pic03_URL(String A_Pic03_URL) {
                this.A_Pic03_URL = A_Pic03_URL;
            }

            public String getA_Location() {
                return A_Location;
            }

            public void setA_Location(String A_Location) {
                this.A_Location = A_Location;
            }

            public String getA_Voice01_URL() {
                return A_Voice01_URL;
            }

            public void setA_Voice01_URL(String A_Voice01_URL) {
                this.A_Voice01_URL = A_Voice01_URL;
            }

            public String getA_pdf02_URL() {
                return A_pdf02_URL;
            }

            public void setA_pdf02_URL(String A_pdf02_URL) {
                this.A_pdf02_URL = A_pdf02_URL;
            }

            public String getA_CID() {
                return A_CID;
            }

            public void setA_CID(String A_CID) {
                this.A_CID = A_CID;
            }

            public String getA_Interpretation() {
                return A_Interpretation;
            }

            public void setA_Interpretation(String A_Interpretation) {
                this.A_Interpretation = A_Interpretation;
            }

            public String getA_Pic01_URL() {
                return A_Pic01_URL;
            }

            public void setA_Pic01_URL(String A_Pic01_URL) {
                this.A_Pic01_URL = A_Pic01_URL;
            }

            public String getA_Conservation() {
                return A_Conservation;
            }

            public void setA_Conservation(String A_Conservation) {
                this.A_Conservation = A_Conservation;
            }

            public String getA_Pic01_ALT() {
                return A_Pic01_ALT;
            }

            public void setA_Pic01_ALT(String A_Pic01_ALT) {
                this.A_Pic01_ALT = A_Pic01_ALT;
            }

            public int get_id() {
                return _id;
            }

            public void set_id(int _id) {
                this._id = _id;
            }

            public String getA_Geo() {
                return A_Geo;
            }

            public void setA_Geo(String A_Geo) {
                this.A_Geo = A_Geo;
            }

            public String getA_Crisis() {
                return A_Crisis;
            }

            public void setA_Crisis(String A_Crisis) {
                this.A_Crisis = A_Crisis;
            }
        }
    }
}