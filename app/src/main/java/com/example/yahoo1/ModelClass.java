package com.example.yahoo1;

public class ModelClass {


    String open,high,low,closed,adjusted,volume,dividendAmount,splitCoefficient;


    //CGS


    public ModelClass(String open, String high, String low, String closed, String adjusted, String volume, String dividendAmount, String splitCoefficient) {
        this.open = open;
        this.high = high;
        this.low = low;
        this.closed = closed;
        this.adjusted = adjusted;
        this.volume = volume;
        this.dividendAmount = dividendAmount;
        this.splitCoefficient = splitCoefficient;
    }


    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getClosed() {
        return closed;
    }

    public void setClosed(String closed) {
        this.closed = closed;
    }

    public String getAdjusted() {
        return adjusted;
    }

    public void setAdjusted(String adjusted) {
        this.adjusted = adjusted;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getDividendAmount() {
        return dividendAmount;
    }

    public void setDividendAmount(String dividendAmount) {
        this.dividendAmount = dividendAmount;
    }

    public String getSplitCoefficient() {
        return splitCoefficient;
    }

    public void setSplitCoefficient(String splitCoefficient) {
        this.splitCoefficient = splitCoefficient;
    }
}
