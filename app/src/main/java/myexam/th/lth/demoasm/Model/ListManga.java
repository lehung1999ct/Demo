package myexam.th.lth.demoasm.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ListManga{

    @SerializedName( "data_all" )
    @Expose
    private ArrayList<Manga> getManga = new ArrayList<>(  );

    public ArrayList<Manga> getGetManga() {
        return getManga;
    }

    public void setGetManga(ArrayList<Manga> getManga) {
        this.getManga = getManga;
    }
}
