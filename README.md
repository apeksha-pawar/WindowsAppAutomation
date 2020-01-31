# examplify-ipad-automation

This repository contains Test Suite for Examplify iPad application.
The test framework uses Java, TestNG and Appium tool stack for framework and script development.
The scope of this framework to execute the Functional Tests like Smoke, Feature and Regression Test.
## Setup:
### Install JAVA [here](http://www.oracle.com/technetwork/java/javase/downloads/jdk9-downloads-3848520.html)
### Install Eclipse [here](https://www.eclipse.org/downloads/download.php?file=/oomph/epp/oxygen/R2/eclipse-inst-mac64.tar.gz)
##### - Install TestNG plugin from marketplace.
### Download Maven [here](https://maven.apache.org/download.cgi)
### Install APPIUM 1.12.1 (1.12.1.20190404.1) [here](https://github.com/appium/appium-desktop/releases/)
### Bashprofile file configuration:
- export JAVA_HOME=$(/usr/libexec/java_home)
- export PATH=${PATH}:$JAVA_HOME/bin
- export M2_HOME=/Users/username/apache-maven-3.3.9
- export M2=$M2_HOME/bin
- export NODE=/usr/local/bin/node
- export NPM=/usr/local/bin
- export PATH=$M2:$PATH
- export PATH=$NODE:$PATH
- export PATH=$NPM:$PATH
- export ANDROID_HOME=usr/local/bin/android
### Appium Setup on Mac Mini:
- Run all the below command in the terminal.
#### Install Homebrew
- ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)" 
#### get node.js   
- brew install node      
#### Steps to configure iDevicePair and add provisioning profile to WebDriverAgent:
- brew uninstall ios-webkit-debug-proxy (follow the instructions [here](https://github.com/google/ios-webkit-debug-proxy) for building from source)
-	brew install usbmuxd
-	brew install ideviceinstaller
-	brew install carthage (WDA project uses this)
-	[Link](https://github.com/appium/appium-xcuitest-driver#usage) to ensure deviceconsole is pulled down, compiled, and real Device Logger referenced in your appium capabilities
### Xcode Setup:
#### Download Xcode 10.3 [here](https://developer.apple.com/download/more/)
##### Necessary installed software
- libimobiledevice- install using brew install libimobiledevice –HEAD
- ios-deploy- install using npm install -g ios-deploy
##### Create a provisioning profile by opening Xcode and creating a new project: Select ‘Single View Application’
- The important part is to use a unique "Product Name" and "Organization Name". Also, at this point, specify your "Team"
  - eg.  
    - Product Name – WebDriverAgentRunner
    - Organization Name - Examsoft
    - Organization id - com.examsoft.Examplify
    - Team – ExamSoft Worldwide, Inc. (Enterprise)
- Add UDID of Real device/ Simulator in Basetest
  - BaseTest Path - /examsoftautoiOS/src/test/java/com/examsoft/auto/ios/core/base/BaseTest.java
- Connect device to iTunes for UDID
- Start Simulator and run command 
  - xcrun simctl list 
  - Select Booted UDID
- For any queries related to Xcode refer [link 1](https://github.com/appium/appium-xcuitest-driver/blob/master/docs/real-device-config.md) [link 2](https://github.com/facebook/WebDriverAgent/wiki/Common-Issues)

 ### Make sure you can run (without errors):
- idevicepair pair (Hit 'Trust' on device)
- idevicepair validate
- ios_webkit_debug_proxy --debug

### Launch the appium server from Terminal
- Launch the Appium by opening Appium app
- Click on Start Session. The appium server get launch on 0.0.0.0:4723 after few minute.

### Inspect Elements using Appium App
- Start 'simple' Appium Server
- Start the Inspector session while server is running
- Add Desire Capabilities in 'automatic server' and start session

# examplify-windows-automation
- Installation 
- Download and install WinAppDriver from: https://github.com/Microsoft/WinAppDriver/releases (you need to choose the file: WindowsApplicationDriver.msi). It’s a simple “next-next” installation.

- Enable “Developer Mode” in our operating system (Win10): Let’s open the Settings menu, go to Update & Settings and choose the option “For Developers” and then click on “Developer Mode”

- Inspect Elements
- We will use Inspect tool to identify UI Elements of the application under test. 