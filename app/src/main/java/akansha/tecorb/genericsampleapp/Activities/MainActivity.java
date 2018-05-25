package akansha.tecorb.genericsampleapp.Activities;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import java.util.ArrayList;
import akansha.tecorb.genericsampleapp.Adapters.MoviesAdapter;
import akansha.tecorb.genericsampleapp.Adapters.NameAdapter;
import akansha.tecorb.genericsampleapp.Adapters.ProgrammingAdapter;
import akansha.tecorb.genericsampleapp.Model.MoviesModel;
import akansha.tecorb.genericsampleapp.Model.PersonNameModel;
import akansha.tecorb.genericsampleapp.Model.ProgrammingModel;
import akansha.tecorb.genericsampleapp.R;
import akansha.tecorb.genericsampleapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

   private Context context ;
   private ActivityMainBinding activityMainBinding ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        context= this;
        setListners();
        setAdapter(1); // used to show list by default to user
    }

    //Here all the clicklistners are initialise
    private void setListners() {
        activityMainBinding.nameBtn.setOnClickListener(this);
        activityMainBinding.moviesBtn.setOnClickListener(this);
        activityMainBinding.programmingBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.nameBtn:  //click on first name button
                setAdapter(1);
                break;
            case R.id.moviesBtn: // click on second movie button
                setAdapter(2);
                break;
            case R.id.programmingBtn: //click on third programming button
                setAdapter(3);
                break;
        }
    }

    private void setAdapter(int pos) {

        switch (pos){

            case 1:
                // in first case we create custom data of names and filling name adapter with this data

                ArrayList<PersonNameModel> listItem = new ArrayList<>();
                String nameArr[] ={"Mark","John","Jackson","William","Henry","Luke","Jack","Adam",
                        "Parker","Daniel"};
                PersonNameModel nameModel ;

                for (String aNameArr : nameArr) {
                    nameModel = new PersonNameModel();
                    nameModel.setName(aNameArr);
                    listItem.add(nameModel);
                }

                NameAdapter nameAdapter = new NameAdapter(listItem,context);
                activityMainBinding.mainList.setAdapter(nameAdapter);
                break;

            case 2:
                // in second case we create custom data of movies and filling movie adapter with this data
                ArrayList<MoviesModel> movieItem = new ArrayList<>();
                String movieTitle[] ={"1921","Pad Man","Padmavat","Kaalakaandi","Mukkabaaz",
                        "Veerey Ki Wedding","Hate Story 4"};
                String movieDirector[] ={"Vikram Bhatt","R.Balki","Sanjay Leela Bhansali","Akshat Verma",
                        "Anurag Kashyap","Ashu Trikha","Vishal Pandya"};
                String rating[]={"5","4","5","4","5","4","3"};
                int image[]={R.color.green,R.color.red,R.color.orange,R.color.blue,R.color.orange,
                        R.color.green,R.color.colorAccent};

                MoviesModel moviesModel ;

                for (int i=0;i<movieTitle.length;i++) {
                    moviesModel = new MoviesModel();
                    moviesModel.setTitle(movieTitle[i]);
                    moviesModel.setSubTitle(movieDirector[i]);
                    moviesModel.setRating(rating[i]);
                    moviesModel.setImage(image[i]);
                    movieItem.add(moviesModel);
                }

                MoviesAdapter moviesAdapter = new MoviesAdapter(movieItem,context);
                activityMainBinding.mainList.setAdapter(moviesAdapter);
                break;
            case 3:
                // in second case we create custom data of programming language and filling programming
                // adapter with this data

                ArrayList<ProgrammingModel> programmingItem = new ArrayList<>();
                String programmingLangauage[] ={"ActionScript","C#","D","Scratch","Groovy",
                        "Scala","F#","PowerShell","Clojure","Go","Rust","Dart","Kotlin","Red","Elixir",
                        "Julia","Swift","Ring"};

                String languageYear[]={"2000","2001","2001","2002","2003","2003","2005","2006","2007","2009",
                        "2010","2011","2011","2011","2011","2012","2014","2016"};

                ProgrammingModel programmingModel ;

                for (int i=0;i<programmingLangauage.length;i++) {
                    programmingModel = new ProgrammingModel();
                    programmingModel.setLanguageName(programmingLangauage[i]);
                    programmingModel.setYear(languageYear[i]);
                    programmingItem.add(programmingModel);
                }

                ProgrammingAdapter programmingAdapter = new ProgrammingAdapter(programmingItem,context);
                activityMainBinding.mainList.setAdapter(programmingAdapter);
                break;
        }


    }
}
