# GenericAdapterSample
This sample application describes how to use Generics in Android by implementing a generic Listview Adapter.
# Generic Introduction
Generics was first introduced in Java5. Now it is one of the most profound feature of java programming language.
Before Generics, we can store any type of objects in collection i.e. non-generic. Now generics, forces the java programmer to store specific type of objects.
Advantages of Generic:
1.Type-safety
2.Type casting is not required
3.Compile Time Checking 
Syntax to use Generic:
ClassOrInterface<Type>
Generic can be used in class ,method and interface.
#Usage of Generic in Adapter
Here we create a GenericCommonAdapter to which we make a <T> Type so that we can work for any type of data or any type of list.
It doesnt matter what type of list is as earlier we have to define type of list.
```groovy
public abstract class GenericCommonAdapter<T> extends BaseAdapter {

    private List<T> customList = new ArrayList<T>() ;
   
    //in below constructor List<T> we can pass any type of list

    public GenericCommonAdapter(List<T> list) {
        this.customList = list ;
    }
    }
```
This adapter is created to simplify the coding so that we don't have to write code again and again for using adapters method such as
getCount(),getItem(),getItemId() and many more. we make common methods in this GenericCommonAdapter and all other Adapters which 
will extend this can use adapter's methods. 

# Description of Methods Used in Adapter

```groovy
 public abstract View buildView(int position, View view, ViewGroup viewGroup);
```
we used above method to return view in adapter getView() method so that, according to need we can inflate different views in different adapters.
we define this method as abstract so that all the adapter who will extend this adapter can override this method and can inflate different views.
As we define an abstract method in this adapter so it must to define this class as abstract.
# Usage of this GenericCommonAdapter
As we make a new Adapter named as NameAdapter in this we extend this GenericCommonAdapter and get the buildView override method of that

```groovy
public class NameAdapter extends GenericCommonAdapter<PersonNameModel> {

    public NameAdapter(ArrayList<PersonNameModel> nameArr) {
        // this method is used to call Generic Common adapter where we are passing different arrayList data
        super(nameArr);
    }
    
    @Override
    public PersonNameModel getItem(int position) {
        return super.getItem(position);
    }
 }
```
Here  super(nameArr) method is used to call the GenericCommonAdapter constructor by which we pass the list of items.

