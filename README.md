# Program 1

## App to toast your joining date and course selected for engineering using date picker and list view.

First create a array of Strings to populate the listview.
This string consists of all the subjects to be shown.

```
    String[] mobileArray = {
            "Biotechnology",
            "Civil Engineering",
            "Computer Science and Engineering",
            "Electronics & Communications Engineering",
            "Electrical & Electronics Engineering",
            "Information Science and Engineering",
            "Mechanical Engineering"
    };

``` 

Next, in `onCreate()` we need to create an adapter which acts as a "bridge" between the String[] and the ListView.  
We use an `ArrayAdapter` as we are just passing on simple strings. But if listview displays more complex stuff, we can create our own CustomAdapter class which  extends ArrayAdapter [REFERENCE](https://guides.codepath.com/android/Using-an-ArrayAdapter-with-ListView)

This adapter takes 2 parameters:  
 1 - context (this)  
 2 - Ref to a layout (this is the common layout of EACH item in listview).  
 3 - Stuff that needs to be populated in listview. (Can also be a class having diff data, but then it requires a CustomAdapter to translate them into ListView Layout elements)  
 ```
 adapter = new ArrayAdapter<String>(this, R.layout.course_item, mobileArray);
 ```
 
Then we attach this adapter to ListView object by:  
```
listView.setAdapter(adapter) 
```
Create a DatePicker object too.  

Now to set an onClickListner for each ITEM in listview:  
`listView.setOnItemClickListner(new Adap<press tab here to autocomplete>`


``` 
listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        
    }
});
```  

The onItemClick contins the index (`position`) of the item clicked.  
To retrieve the text @ that position, use the `getItem()` method of adapter:   
```
String course = (String)adapter.getItem(position);
```

Also retrieve the day,month(+1),year  from DatePicker objects' `getDayOfMonth() getMonth() getYear()` methods.

Display the course and date a Toast.

## Layout Elements
### activity_main.xml
This mainly has textviews for heading, a DatePicker and a ListView widget

###  course_item.xml
This contains the way EACH ITEM in the ListView is shown.  
You don't need any layout. The root element is just a TextView[Main Java files](https://github.com/DroidFreak32/MADLabApps/tree/a01_datepicker_listview/app/src/main/java/com/example/student/mad_labapp)  
[Main XML files](https://github.com/DroidFreak32/MADLabApps/tree/a01_datepicker_listview/app/src/main/res/layout)  
