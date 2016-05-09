package pt.ulisboa.tecnico.neeti;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.view.ViewGroup.LayoutParams;
import java.util.Map;
import java.util.HashMap;

import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainMenu extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        private ViewPager _mViewPager;




        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            ImageView imageView = (ImageView) findViewById(R.id.menuIcon);
            switch (position) {
                case 0:
                    return FragmentNeeti.newInstance();
                case 1:
                    return FragmentCadeiras.newInstance();
                case 2:
                    return FragmentRequisitos.newInstance();
                case 3:
                    return FragmentEventos.newInstance();
                case 4:
                    return FragmentTagus.newInstance();
                case 5:
                    return FragmentContacto.newInstance();
            }
            return FragmentMenu.newInstance ();
        }

        @Override
        public int getCount() {
            return 6;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "NEETI";
                case 1:
                    return "CADEIRAS";
                case 2:
                    return "REQUESITOS";
                case 3:
                    return "EVENTOS";
                case 4:
                    return "TAGUS";
                case 5:
                    return "CONTACTO";
            }
            return null;
        }


    }









    // fraguementos

    public static class FragmentMenu extends Fragment {
        private static final String ARG_SECTION_TITLE = "section_title";
        private static final String ARG_SECTION_IMG = "menuIcon";
        private Bundle args;

        public FragmentMenu () {
            args = new Bundle();
            setArguments(args);
        }

        public void addTitle (CharSequence sectionTitle) {
            args.putCharSequence(ARG_SECTION_TITLE, sectionTitle);
        }

        public void setImage (int image) {
            args.putInt(ARG_SECTION_IMG, image);
        }

        public static FragmentMenu newInstance() {
            FragmentMenu fragment = new FragmentMenu();
            fragment.addTitle("Menus");
            return fragment;
        }

        private void startButtons (View v) {
            Button button= (Button) getActivity().findViewById(R.id.btn_neeti);
            //button.setOnClickListener(new View.OnClickListener() {
              //  @Override
               // public void onClick(View v) {
                //    System.out.println ("haro");
                //}
            //});
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main_menu, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.textViewRL);
            textView.setText(getArguments().getCharSequence(ARG_SECTION_TITLE));
            textView.setGravity(Gravity.CENTER_HORIZONTAL);
            ImageView imageView = (ImageView) rootView.findViewById(R.id.menuIcon);
            imageView.setImageResource(getArguments().getInt(ARG_SECTION_IMG));
            startButtons(rootView);
            return rootView;
        }
    }








    public static class FragmentNeeti extends FragmentMenu {
        public FragmentNeeti () {
            super();
        }

        public static FragmentNeeti newInstance() {
            FragmentNeeti fragment = new FragmentNeeti();
            fragment.addTitle("NEETI");
            fragment.setImage(R.drawable.neeti);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                                 final Bundle savedInstanceState) {
            View rootView = super.onCreateView(inflater, container, savedInstanceState);
            final ImageView switchact =(ImageView) rootView.findViewById(R.id.menuIcon);
            switchact.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    Intent act2 = new Intent(view.getContext(),ScrollingNEETI.class);
                    startActivity(act2);
                }
            });
            return rootView;
        }
    }

    public static class FragmentCadeiras extends FragmentMenu {
        public FragmentCadeiras() {
            super();
        }

        public static FragmentCadeiras newInstance() {
            FragmentCadeiras fragment = new FragmentCadeiras();
            fragment.addTitle("Cadeiras");
            fragment.setImage(R.drawable.cadeiras);
            return fragment;
        }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = super.onCreateView(inflater, container, savedInstanceState);
            final ImageView switchact =(ImageView) rootView.findViewById(R.id.menuIcon);
            switchact.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    Intent act2 = new Intent(view.getContext(),ScrollingCadeiras.class);
                    startActivity(act2);
                }
            });
            return rootView;
        }
    }

    public static class FragmentRequisitos extends FragmentMenu {
        public FragmentRequisitos() {
            super();
        }

        public static FragmentRequisitos newInstance() {
            FragmentRequisitos fragment = new FragmentRequisitos();
            fragment.addTitle("Requisitos");
            fragment.setImage(R.drawable.unknown);
            return fragment;
        }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = super.onCreateView(inflater, container, savedInstanceState);
            final ImageView switchact =(ImageView) rootView.findViewById(R.id.menuIcon);
            switchact.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    Intent act2 = new Intent(view.getContext(),ScrollingRequisitos.class);
                    startActivity(act2);
                }
            });
            return rootView;
        }
    }

    public static class FragmentEventos extends FragmentMenu {
        public FragmentEventos () {
            super();
        }

        public static FragmentEventos newInstance() {
            FragmentEventos fragment = new FragmentEventos();
            fragment.addTitle("Eventos");
            fragment.setImage(R.drawable.eventos);
            return fragment;
        }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = super.onCreateView(inflater, container, savedInstanceState);
            final ImageView switchact =(ImageView) rootView.findViewById(R.id.menuIcon);
            switchact.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    Intent act2 = new Intent(view.getContext(),ScrollingEventos.class);
                    startActivity(act2);
                }
            });
            return rootView;
        }
    }

    public static class FragmentTagus extends FragmentMenu {
        public FragmentTagus () {
            super();
        }

        public static FragmentTagus newInstance() {
            FragmentTagus fragment = new FragmentTagus();
            fragment.addTitle("Tagus");
            fragment.setImage(R.drawable.unknown);
            return fragment;
        }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = super.onCreateView(inflater, container, savedInstanceState);
            final ImageView switchact =(ImageView) rootView.findViewById(R.id.menuIcon);
            switchact.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    Intent act2 = new Intent(view.getContext(),ScrollingTagus.class);
                    startActivity(act2);
                }
            });
            return rootView;
        }
    }

    public static class FragmentContacto extends FragmentMenu {
        private ImageView _btn6;
        public FragmentContacto () {
            super();
        }

        public static FragmentContacto newInstance() {
            FragmentContacto fragment = new FragmentContacto();
            fragment.addTitle("Contacto");
            fragment.setImage(R.drawable.contacto);
            return fragment;
        }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = super.onCreateView(inflater, container, savedInstanceState);
            final ImageView switchact =(ImageView) rootView.findViewById(R.id.menuIcon);
            switchact.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    Intent act2 = new Intent(view.getContext(),ScrollingContacto.class);
                    startActivity(act2);
                }
            });
            return rootView;
        }
    }
}
