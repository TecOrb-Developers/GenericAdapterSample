package akansha.tecorb.genericsampleapp.Adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

import akansha.tecorb.genericsampleapp.Model.MoviesModel;
import akansha.tecorb.genericsampleapp.R;
import akansha.tecorb.genericsampleapp.databinding.CustomMovieViewBinding;
import akansha.tecorb.genericsampleapp.databinding.CustomNameViewBinding;

/**
 * Created by tecorb on 24/5/18.
 */

public class MoviesAdapter extends GenericCommonAdapter<MoviesModel> {


    public MoviesAdapter(ArrayList<MoviesModel> movieItem) {
        super(movieItem); // this method is used to call Generic Common adapter where we are passing diffrent arrayList data
    }

    // with below buildView method we are inflating the custom view of movie this method is overridden method
    // of Generic Common Adapter with the help of which we can create custom views according to our need


    @Override
    public View buildView(int position, View view, ViewGroup parent) {
        CustomMovieViewBinding customBinding ;
        if(view == null){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_movie_view, null);
            customBinding = DataBindingUtil.bind(view);
            view.setTag(customBinding);
        }else{
            customBinding = (CustomMovieViewBinding) view.getTag();
        }

        customBinding.movieTitle.setText(getItem(position).getTitle());
        customBinding.movieDirector.setText(getItem(position).getSubTitle());
        customBinding.movieRating.setText(getItem(position).getRating());
        customBinding.movieImage.setImageResource(getItem(position).getImage());


        return customBinding.getRoot();
    }

    @Override
    public MoviesModel getItem(int position) {
        return super.getItem(position);
    }
}
