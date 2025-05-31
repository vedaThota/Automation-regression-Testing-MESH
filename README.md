# MESH_Automation
 This repository contains the source code for the MESH test automation scripts.

 The test automation project is built using Selenium, Java, TestNG, and generates reports with Extent Reports.

# Prerequisites
 To set up and use this project, ensure the following prerequisites are met:
  * **Java:** Install Java and set the necessary environment variables (JAVA_HOME).
  * **Maven:** Install Maven and configure the M2_HOME environment variable.
  * **Git:** Ensure Git is installed for version control.

 A working branch should be created by the lead for you to work on.

# Project Setup on Local Machine
 Follow these steps to set up the project locally:

 * Create an empty folder in your file explorer.
 * Open the Command Prompt (or terminal) in that folder.
 * Run the following commands one by one:
   * git init
   * git remote add origin URL   - Replace URL with the repository URL
   * git fetch --all
   * git checkout Your Branch Name   - Replace Your Branch Name with your actual branch name
 Once the above commands are executed, all the source code will be imported into your local folder.

# Execution Commands
 You can run the entire suite of tests for either CMCS or SDP using the following Maven commands:
 ## Global Execution

  ### To run tests from cmd:

    * mvn install test -PMESH_Test
    
# Internal Execution (Individual Test Cases)
 * Navigate to the src/test/java folder.
 * Open any test suite.
 * You will see two options for running tests:
   * **Run:** Executes a specific test case.
   * **Run All:** Executes all test cases in the selected suite.

# Test Reports
 The test reports will be generated after the execution using Extent Reports. You can find them under the **Reports** directory in your local machine. The reports provide detailed logs for each test, including screenshots for failed tests, making it easier to diagnose issues.

# Troubleshooting
 **Issue:** Maven command fails.

 **Solution:** Ensure that Maven and Java are properly installed and environment variables are correctly set.

 **Issue:** Unable to checkout a branch.

 **Solution:** Ensure you have the correct permissions and that the branch exists.

# Additional Notes
 * Make sure to commit and push your changes regularly to the repository.

 * Please follow the naming conventions for test cases and methods to maintain code consistency.

