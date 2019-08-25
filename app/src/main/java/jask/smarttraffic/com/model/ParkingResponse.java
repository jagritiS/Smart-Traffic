package jask.smarttraffic.com.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ParkingResponse {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("location")
    @Expose
    private Integer location;
    @SerializedName("row")
    @Expose
    private Integer row;
    @SerializedName("col")
    @Expose
    private Integer col;
    @SerializedName("stat")
    @Expose
    private Boolean stat;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getCol() {
        return col;
    }

    public void setCol(Integer col) {
        this.col = col;
    }

    public Boolean getStat() {
        return stat;
    }

    public void setStat(Boolean stat) {
        this.stat = stat;
    }

}