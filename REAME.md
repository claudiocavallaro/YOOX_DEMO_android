#TEST YNAP

In every class i try to explain with comment every step that i did.

In Activity package i store all the activity that i need for all the requests steps, MainActivity
load FragmentHome and NavActivity load the other Fragment (package Fragment) handleds by a bottom
navigation bar.

Persistence package include the api for web request with retrofit.

The interface contains four method signature

```java
@GET("ynap/v1/{path}")
Call<Search> getItem(@Path("path") String path);

@GET("ynap/v1/latest")
Call<Search> getLatest();

@GET("ynap/v1/highest")
Call<Search> getHighest();

@GET("ynap/v1/lowest")
Call<Search> getLowest();

@GET("ynap/v1/item")
Call<Properties> getDet();
```

The first is used for Step1 and Step4, it's inconvenient to write three different method for similar
request, we can change only the path.

Usually I write activity for every macro-step of the application that i write and so Step2 require
to display details DetailActivity and Step3 require to perform different request based on
different sorting method.

In real situation if I tap on an item i have to receive the information about the tapped one, but
Step2 required the same request for every tapped item.
I fetch all the data and write the information in DetailActivity.

For Step3 I decided to write also three other fragment as well as three other
request method because i want an easy method to come back in the searchresult item request.
It you wanna just refresh the list you can use different button menu and reload the fragment
or hide the bottom navigation bar if you don't tap on "sort" and after the "sorting" activity
with another button.


Class Structure

Search
|-> Item -> Size
        |-> Color

Properties
|-> Brand
|-> Category
|-> Price
|-> ColorDetails
|-> SizeDetails
|-> ItemDetails -> ShippingDetail -> ShippingNotes
                                 |-> CostItem
