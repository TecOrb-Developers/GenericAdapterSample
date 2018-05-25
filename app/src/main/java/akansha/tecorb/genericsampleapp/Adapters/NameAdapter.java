package akansha.tecorb.genericsampleapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import akansha.tecorb.genericsampleapp.Model.PersonNameModel;
import akansha.tecorb.genericsampleapp.R;
import akansha.tecorb.genericsampleapp.databinding.CustomNameViewBinding;

/**
 * Created by tecorb on 24/5/18.
 */

public class NameAdapter extends GenericCommonAdapter {

    private List<PersonNameModel> itemModels=new ArrayList<>();
    private  Context context ;

    public NameAdapter(ArrayList<PersonNameModel> nameArr, Context context) {
        super(nameArr,context);// this method is used to call Generic Common adapter where we are passing diffrent arrayList data
        this.itemModels = nameArr ;
        this.context = context ;
    }


    // with below buildView method we are inflating the custom view of movie this method is overridden method
    // of Generic Common Adapter with the help of which we can create custom views according to our need

    @Override
    public View buildView(View view, LayoutInflater inflater, ViewGroup parent, int position) {
        CustomNameViewBinding customBinding ;
        if(view == null){
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_name_view, null);
        customBinding = DataBindingUtil.bind(view);
        view.setTag(customBinding);
    }else{
        customBinding = (CustomNameViewBinding) view.getTag();
    }

        customBinding.personName.setText(itemModels.get(position).getName());


        return customBinding.getRoot();

}
}
