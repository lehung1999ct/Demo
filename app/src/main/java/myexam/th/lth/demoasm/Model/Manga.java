package myexam.th.lth.demoasm.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Manga {

    @SerializedName( "id" )
    @Expose
    private String id;

    @SerializedName( "name" )
    @Expose
    private String name;

    @SerializedName( "tag" )
    @Expose
    private String tag;

    @SerializedName( "thumb" )
    @Expose
    private String thumb;

    @SerializedName( "type" )
    @Expose
    private String type;

    @SerializedName( "category" )
    @Expose
    private String cate;

    @SerializedName( "res" )
    @Expose
    private String res;

    public Manga() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCate() {
        return cate;
    }

    public void setCate(String cate) {
        this.cate = cate;
    }

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }
}
