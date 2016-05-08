package pt.ulisboa.tecnico.neeti;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ScrollingCadeiras extends ScrollingActivity {

    private ListView mainListView ;
    private ArrayAdapter<String> listAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling_cadeiras);

        mainListView = (ListView) findViewById( R.id.listview_cadeiras );

        // Create and populate a List of planet names.
        String[] planets1 = getResources().getStringArray(R.array.list_cadeiras_ciencEng);
        String[] planets2 = getResources().getStringArray(R.array.list_cadeiras_electro);
        String[] planets3 = getResources().getStringArray(R.array.list_cadeiras_electro_infor);
        String[] planets4 = getResources().getStringArray(R.array.list_cadeiras_infor);
        String[] planets5 = getResources().getStringArray(R.array.list_cadeiras_others);

        String[] planets = getResources().getStringArray(R.array.list_cadeiras_ciencEng);
        ArrayList<String> planetList = new ArrayList<String>();

        planetList.addAll( Arrays.asList(planets1) );
        planetList.addAll( Arrays.asList(planets2) );
        planetList.addAll( Arrays.asList(planets3) );
        planetList.addAll( Arrays.asList(planets4) );
        planetList.addAll( Arrays.asList(planets5) );

        // Create ArrayAdapter using the planet list.
        listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow, planetList);

        // Add more planets. If you passed a String[] instead of a List<String>
        // into the ArrayAdapter constructor, you must not add more items.
        // Otherwise an exception will occur.
        /*listAdapter.add( "Pluto" );
        listAdapter.add( "Haumea" );
        listAdapter.add( "Makemake" );
        listAdapter.add( "Eris" );
        listAdapter.add( "Eris" );
        listAdapter.add( "Eris" );
        listAdapter.add( "Eris" );
        listAdapter.add( "Eris" );
        listAdapter.add( "Eris" );
        listAdapter.add( "Eris" );*/

        // Set the ArrayAdapter as the ListView's adapter.
        mainListView.setAdapter( listAdapter );



    }
}
