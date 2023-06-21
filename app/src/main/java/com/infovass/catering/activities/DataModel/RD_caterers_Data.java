package com.infovass.catering.activities.DataModel;

import java.util.ArrayList;

public class RD_caterers_Data {

    private ArrayList<RD_caterers_Bannerdata> bannerData ;
    private ArrayList<RD_caterers_TopRankeCaterers> topRankedCaterers ;
    private ArrayList<RD_TopRankedCaterersItem> topRankedCaterersItems ;
    private ArrayList<RD_catererData> caterersData ;

    public RD_caterers_Data(ArrayList<RD_caterers_Bannerdata> bannerData, ArrayList<RD_caterers_TopRankeCaterers> topRankedCaterers, ArrayList<RD_TopRankedCaterersItem> topRankedCaterersItems, ArrayList<RD_catererData> caterersData) {
        this.bannerData = bannerData;
        this.topRankedCaterers = topRankedCaterers;
        this.topRankedCaterersItems = topRankedCaterersItems;
        this.caterersData = caterersData;
    }

    public ArrayList<RD_caterers_Bannerdata> getBannerData() {
        return bannerData;
    }

    public void setBannerData(ArrayList<RD_caterers_Bannerdata> bannerData) {
        this.bannerData = bannerData;
    }

    public ArrayList<RD_caterers_TopRankeCaterers> getTopRankedCaterers() {
        return topRankedCaterers;
    }

    public void setTopRankedCaterers(ArrayList<RD_caterers_TopRankeCaterers> topRankedCaterers) {
        this.topRankedCaterers = topRankedCaterers;
    }

    public ArrayList<RD_TopRankedCaterersItem> getTopRankedCaterersItems() {
        return topRankedCaterersItems;
    }

    public void setTopRankedCaterersItems(ArrayList<RD_TopRankedCaterersItem> topRankedCaterersItems) {
        this.topRankedCaterersItems = topRankedCaterersItems;
    }

    public ArrayList<RD_catererData> getCaterersData() {
        return caterersData;
    }

    public void setCaterersData(ArrayList<RD_catererData> caterersData) {
        this.caterersData = caterersData;
    }
}
