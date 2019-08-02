package myexam.th.lth.demoasm.Network;//package network;

import myexam.th.lth.demoasm.Model.ListManga;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NetworkAPI {
    @GET("API_call_all.php")
    Call<ListManga> getAll(@Query("index") int index);
//    @GET("API_call_cate.php")
//    Call<List<ModelCategory>> getCate(@Query("index") int index);
//
//    @GET("API_call_popular.php")
//    Call<List<ModelPopular>> getPopular(@Query("index") int index);
//
//    @GET("API_search.php")
//    Call<List<ModelSearch>> getSearch(@Query("index") int index, @Query("input") String input);

    @GET("get_all.json")
    Call<ListManga> getAllData();
}
