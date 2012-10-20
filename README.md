## Calabash-Driver Demo

Project is based on the greenhouse and the greenhouse-android project. Steps to get started:

    git clone https://github.com/DominikDary/gdg-devfest-zrh.git
    git submodule init
    git submodule update

The project contains three projects:

* *greenhouse* 
    The server component of the greenhouse application.

* *greenhouse-android* 
    The Android client app to display details about the conference.

* *greenhouse-android-tests*
    The calabash-driver tests of the greenhouse-android app.


To get started with the greenhouse server app, please follow the instructions on my blog:
http://dary.de/2012/03/greenhouse-application/

Test automation of the greenhouse Android app is done using the Calabash-Android https://github.com/calabash/calabash-android and Calabash-Driver http://calabash-driver.github.com/ open source projects.
With Calabash-Driver you can write your Calabash-Android end-to-end tests in Java and use the Selenium Grid for scaling and parallel testing.
To execute the tests pls inmstall first on e.g. an emulator the following apps, that you can find in the download section:

* *[CalabashAndroid TestServer](https://github.com/DominikDary/gdg-devfest-zrh/TestServer_0.3.2.apk/)*


* *[Greenhouse Android app](https://github.com/DominikDary/gdg-devfest-zrh/greenhouse-android.apk/)*


An actual sample end-to-end test you can fine here: https://github.com/DominikDary/gdg-devfest-zrh/blob/master/greenhouse-android-tests/src/main/java/sh/calaba/calabashdriver/GreenhousAndroidTests.java