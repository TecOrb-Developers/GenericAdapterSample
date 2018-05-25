package akansha.tecorb.genericsampleapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tecorb on 18/5/18.
 */

// this adapter is created as of Generic Type where T stands for type

public abstract class GenericCommonAdapter<T> extends BaseAdapter {

    private List<T> customList = new ArrayList<T>() ;

    //in below constructor List<T> can be any type of list whether string type or int

    public GenericCommonAdapter(List<T> list) {
        this.customList = list ;
    }

    @Override
    public int getCount() {
        return customList.size();
    }

    @Override
    public T getItem(int position) {
        return customList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
     public View getView(int position, View view, ViewGroup viewGroup) {
        return buildView(position, view, viewGroup);

    }

    //this buildView method is used to inflate custom view and we make it abstract as it may be override anywhere

    public abstract View buildView(int position, View view, ViewGroup viewGroup);

}
