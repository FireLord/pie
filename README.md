# Pie
A small project to show firebase login and charts in android.

## Download / watch
You can download the app to test by pressing this [Download](https://github.com/FireLord/pie/raw/master/app-debug.apk) or check screenshots
- [LoginPage](https://raw.githubusercontent.com/FireLord/pie/master/screenshots/LoginPage.png)
- [SignUpPage](https://raw.githubusercontent.com/FireLord/pie/master/screenshots/SignUpPage.png)
- [BarChart](https://raw.githubusercontent.com/FireLord/pie/master/screenshots/BarChartPage.png)
- [PieChartGraph](https://raw.githubusercontent.com/FireLord/pie/master/screenshots/PieChartGraph.png)
- [LogoutPage](https://raw.githubusercontent.com/FireLord/pie/master/screenshots/LogoutPage.png)
- Or you can view the app demo [video](https://github.com/FireLord/pie/raw/master/screen-20220603-173424.mp4)

## Tech stack

The app went through multiple iterations to achieve what it is today, in coming days Ill move to material Design 3 and use jetpack compose.

The libraries used:

- [AppCompat](https://developer.android.com/jetpack/androidx/releases/appcompat)
- [Fragments](https://developer.android.com/jetpack/androidx/releases/fragment)
- [Material Components](https://material.io/develop/android)
- [Firebase](https://firebase.google.com/) for login to account from email, google, facebook
- [MPAndroidChart](https://github.com/PhilJay/MPAndroidChart) for all the charts
- [Bottom Navigation](https://material.io/components/bottom-navigation/android) for bottom navigation
- [AndroidX Navigation](https://developer.android.com/guide/navigation) for handling navigation events

In order, this is what happens in the app:

1. Log into the account from email, google
2. If no account then sign up
3. Home shows bar chart for no. of week days in selected month and year
4. Pie shows static given 40,30,20,10 value

# Unit testing
Unit testing is not performed, as of now I lack experience in that. Will be done in upcoming days.

# License

```
Copyright (c) 2022 Aman Kumar

Permission is hereby granted, free of charge, to any
person obtaining a copy of this software and associated
documentation files (the "Software"), to deal in the
Software without restriction, including without
limitation the rights to use, copy, modify, merge,
publish, distribute, sublicense, and/or sell copies of
the Software, and to permit persons to whom the Software
is furnished to do so, subject to the following
conditions:

The above copyright notice and this permission notice
shall be included in all copies or substantial portions
of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF
ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT
SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR
IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
DEALINGS IN THE SOFTWARE.
```