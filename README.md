<!-- TABLE OF CONTENTS -->
<h2>
    <details open="open">
        <summary class="normal">Table of Contents</summary>
        <h5>
          <ol>
            <li>
              <a href="#about-the-project">About the Project</a>
              <ul>
                <li><a href="#built-with">Built With</a>
              </ul>
            </li>
            <li>
              <a href="#getting-started">Getting Started</a>
              <ul>
                <li><a href="#prerequisites">Prerequisites</a>
                <li><a href="#installation">Installation</a>
              </ul>
            </li>
            <li><a href="#usage">Usage</a></li>
            <li><a href="#reports">Reports</a></li>
          </ol>
        </h5>    
    </details>
</h2>

<!-- ABOUT THE PROJECT -->

## About the Project

Playwright Demo - This project is based on Microsoft Playwright which enables reliable end-to-end testing for modern web
apps.

Top Features:

- Easy to Configure.
- Auto-waits for all the relevant checks to pass and only then performs the requested action.
- Records the test script and every action on the target page is turned into generated script.
- Generates trace file on failure, which gives in-depth details of Test Case execution.
- Execution of test case is faster when compared with other competitive framework in market.
- Supports Headful/Headless mode execution for Firefox/Webkit/Google Chrome/Chromium/MS Edge on Windows/Linux/Mac
  machines.
- Rerun Failed Test cases
- Supports 'download' event monitoring, so there is no need for user to actually wait for downloads to finish.
- Supports Serial and Parallel execution.
- Spark PDF/HTML Reports are generated after execution with an option to capture screenshot/video/trace file on failure.
- Nonetheless Support from Microsoft so FREQUENT RELEASES and turn around time for any queries is 48 hours.

### Built With

- [Playwright](https://playwright.dev)
- [Cucumber](https://cucumber.io/)
- [JUnit](https://junit.org/junit5/)
- [Maven](https://maven.apache.org/)
- [OpenJDK](https://www.openlogic.com/openjdk-downloads)

## Getting Started

### Prerequisites

The following software are required:

- java : Download and Install java 1.8
  ```sh
  https://www.openlogic.com/openjdk-downloads
  ```
- Maven must be configured

### Installation

1. Clone the repo using below URL

```sh
https://github.com/akshayp7/playwright-typescipt-playwright-test.git
```

2. Navigate to folder and install dependencies using:

```sh
mvn clean install
```

<!-- USAGE EXAMPLES-->

## Usage

1. For Browser Configuration, change required value in browser and headless mode in `src/test/resources/config/config.properties`.
2. For executing test cases in parallel, navigate to pom.xml and in plugin in configuration section
   provide `<skipTests>false</skipTests>`
   Now if you want to run 4 features in parallel provide `<threadCount>4</threadCount>` in maven-failsafe-plugin section
   in pom.xml and execute below command
```JS
mvn verify
```
3. For executing test cases in sequence, provide a suitable tag `@smoke` at the start of your scenario and execute below
   command:
```JS
mvn test "-Dcucumber. options=--tags @smoke"
```
4. For recording test scripts execute below command with desired url:
```JS
mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="codegen https://demoqa.com/"
```
5. For HTML Report configuration navigate to `src/test/resources/extent.properties` and provide destination folder as
   value in `extent.reporter.spark.out`
6. For PDF Report configuration navigate to `src/test/resources/extent.properties` and provide destination folder as
   value in `extent.reporter.pdf.out`
7. Screenshots and Trace files will be generated in target folder on failure this configuration is provided
   in `src/test/java/hooks/Hooks.java` in `takeScreenshotAndTrace` method.
8. To change your username go to `src/test/resources/config/config.properties` and provide value against `adminUsername`
9. To change password, go to `src/main/java/utils/WebActions.java` in `encrypt()` and
   replace `yourPassword` with your password, execute the test case, Encrypted password will be printed on your
   console .
   Copy Encrypted password in `src/test/resources/config/config.properties` against `adminPassword` field.
10. You can even execute test cases by running `src/test/java/testrunner/TestRunner.java` file all the failed test cases
    are saved in `target/rerun.txt`
11. For rerunning failed test cases run `src/test/java/testrunner/ReRunner.java`
12. Reports will be generated in `target/HTMLReport` and `target/PdfReport` folders.

## Reports

- <b>Overall Report</b>
  ![Overall Report Screenshot][overall-report-screenshot]

- <b>Failure Report</b>
  ![Failure Report Screenshot][failure-report-screenshot]

- <b>PDF Report</b>
  ![PDF Report Screenshot][pdf-report-screenshot]

<!-- MARKDOWN LINKS & IMAGES -->

[overall-report-screenshot]: ReadMeImages/OverallReport.PNG

[failure-report-screenshot]: ReadMeImages/FailureReport.PNG

[pdf-report-screenshot]: ReadMeImages/PDFReport.PNG