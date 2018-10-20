# Program 2

## App to demonstrate the activity lifecycle by logging the activities in the LogCat or toast at every stage.

Super simple app.  

All you need to know are the activity lifecycles of an android app.  
They are:  

 1) `onCreate()` -> Where the layout in inflated.
 2) `onStart()` -> After inflation
 3) `onStop()` -> Pressing home
 4) `onPause()` -> Pressing home
 5) `onDestroy()` -> Clearing from recent / Pressing back
 6) `onResume()` -> Coming back from recent

And displaying log is done by:
```
Log.<level>(<tag>,<message>)
```
Where `<level>` can be i,v,d,e,wtf (info,verbose,debug,warning,what_a_terrible_failure)

