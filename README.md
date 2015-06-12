# WifiTestPower

This is simple application which is used for testing the power consumption of the Wifi Direct APIs.

Latest results of the measurements are available at:https://github.com/DrJukka/WifiTestPower.git 

To use the App simply install and start it by clicking the icon. Start the app by clicking the Toggle button, and exit the ui app. Exiting UI app will re-start the background server.
 
While the app runs, it is logging information into "<phone root>Internal storage\Android\data\test.microsoft.com.wifitestpower\files\Documents\PowWithDelayXXXXXX.txt", where the XXXX is time value when the file was created.

The file is comma-separated file, thus you can open it excel, by simply choosing that the column separator is comma.

The fields in the file are:
* Os :  API level of the devices
* time :  time value indicating when the line was added (System time in milliseconds)
* battery : Batttery level 
* Started : Number of Service Discoveries started
* got : Number of Service Discoveries that were successfully ended (with full list of services discovered)
* No services : Number of Service Discovery ending into no Services found (timeouts not counted)
* Peer err :  Number if times Starting Peer discovery resulted error
* Service Err :  Number if times Starting Service discovery resulted error
* Add req Err :  Number if times adding service reqquest resulted error
* reset counter : :  Number if times reset timer was fired. This is fired when there are no services discovered in set time
* Peers changed : Number of timer Peers Changed even was received
* discovery stopped : Number of times Discovery state changed with Discovery_Stopped was received
* wait expired :  Not used currently (was used when checking doing wait time tests that did not result any better designs)
* wifi reset : Number of  times Wifi Off/On toggling has been done.

If the tests are done with only one device, then of course no Services will be found. Anyway that kind of test would measure the API power usage in situations where no Peers are in the vicinity.
Then additional tests with some peers ()I personally used 4-5) should be conducted to measure the power consumption in those situations, as well as to see whether there are time periods in which the discovery is not functioning right.

