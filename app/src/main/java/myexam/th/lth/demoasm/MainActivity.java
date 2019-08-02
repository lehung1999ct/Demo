package myexam.th.lth.demoasm;

import android.app.ProgressDialog;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import myexam.th.lth.demoasm.Adapter.MyAdapter;
import myexam.th.lth.demoasm.Model.ListManga;
import myexam.th.lth.demoasm.Model.Manga;
import myexam.th.lth.demoasm.Network.InternetConnection;
import myexam.th.lth.demoasm.Network.NetworkAPI;
import myexam.th.lth.demoasm.Network.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ListView lvManga;
    private MyAdapter adapter;
    private View parentLayout;
    private ArrayList<Manga> mangaArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        lvManga = findViewById( R.id.lvManga );
        parentLayout = findViewById( R.id.parentLayout );
    }

    @Override
    protected void onResume() {
        super.onResume();

        //..LOAD
        Toast toast = Toast.makeText(getApplicationContext(), "Downloading... ", Toast.LENGTH_LONG);
        toast.setGravity( Gravity.CENTER, 0, 0);
        toast.show();

        //..get and hide list
        if (InternetConnection.checkConnection(getApplicationContext())) {
            final ProgressDialog dialog;
            dialog = new ProgressDialog( MainActivity.this );
            dialog.setTitle( "Info" );
            dialog.setMessage( "Nothing" );
            dialog.show();
            //Creating an object of our api interface
            NetworkAPI api = RetrofitClient.getApiService();
            // Calling JSON
            Call<ListManga> call = api.getAllData();

            // Enqueue Callback will be call when get response...
            call.enqueue(new Callback<ListManga>() {
                @Override

                public void onResponse(Call<ListManga> call, Response<ListManga> response)
                {
                    //Dismiss Dialog
                    dialog.dismiss();

                    if(response.isSuccessful()) {
                        // Got Successfully
                        mangaArrayList = response.body().getGetManga();
                        // Binding that List to Adapter
                        adapter = new MyAdapter(MainActivity.this, mangaArrayList);
                        lvManga.setAdapter(adapter);
                    } else {
                        Snackbar.make(parentLayout, "loading...", Snackbar.LENGTH_LONG).show();
                    }
                }
                @Override
                public void onFailure(Call<ListManga> call, Throwable t) {
                    dialog.dismiss();
                }
            });
        } else{
            Snackbar.make(parentLayout,"FAIL", Snackbar.LENGTH_LONG).show();
        }
    }



}
