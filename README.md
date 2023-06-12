Dheo Claveria - Test Interview - Test Automation Testing

Programming Language       : Java
Automation Tools           : Selenium WebDriver, Serenity BDD, Cucumber, Screenplay
IDE                        : IntelliJ (community edition)
Website Application tested : www.amaysim.com.au

========================================================================================================

You can test it locally using the following steps:

1. Install IntellJ community edition              : https://www.jetbrains.com/idea/download/#section=windows
2. Open command and clone the repo                : git clone https://github.com/dheybenclave/Dheo_Claveria_Test_Automation_Testing.git
3. Open the IntellJ and Open the Project as Maven
4. Make sure you install the java JDK 11 on your local machine and set in the enviroment variables : 
5. You can test via IntellJ config using the cmmnd > 
        
              * "mvn clean verify -Dtags="Amaysim"                 : for all test suite created for Amaysim including the validation of [Page and Refer a Friend]
              * "mvn clean verify -Dtags="Page"                    : for all testing of Page in the dashboard [Service, Account, Help] Page 
              * "mvn clean verify -Dtags="ReferAFriend_Scenario_1" : for all testing of Page in the dashboard [Service, Account, Help] Page 

 6. Or Using IntellJ :
     Go to src/test/resources/features/grid/gridtesting.feature and you will the green triangle(start) button and click for specific run
     ![image](https://github.com/dheybenclave/Dheo_Claveria_Test_Automation_Testing/assets/24590531/eac399d3-a2b7-4f49-9b7c-56238924af1f)
     Or using the Run.xml for global testing using tags: click the edit config > update the tags in Program Arguments > Save > run
     ![image](https://github.com/dheybenclave/Dheo_Claveria_Test_Automation_Testing/assets/24590531/0d13caf5-0e75-4b4c-8392-81ac40ebf7ac)
     ![image](https://github.com/dheybenclave/Dheo_Claveria_Test_Automation_Testing/assets/24590531/7afb9074-4db6-4c5e-b6a5-796d4d33624d)


**Test Challenge:**
The test automation URL is www.amaysim.com.au

Write a test automation script that exercises one of the most basic functions of MyAmaysim:
Refer A Friend.

Using the provided credentials (amaysim number: 0466134574, password: AWqasde321),
create a simple test that logs into MyAmaysim, picks a service (if you are presented with more
than one on logging in), goes to “Refer a Friend” and validates functionalities on this page.

Assume that these tests will eventually need to run against various test environments (each
environment has a different URL. The URL provided above is that of the Production
environment).

**Deliverables**
* An executable test suite that validates the functionality above is working correctly
* Full source code available online

**Technical Guidance / Hints**

* Prioritise Quality over Quantity in your tests. Your code submission will be assessed
more on how well written and how well structured the code is, rather than number of
tests. The most important functionality on the ‘Refer a friend’ page is the ability to
create personalised links.

* It’s important that other engineers in your team be able to run the tests on their
machine. Bear in mind they may not all use the same OS as you. Please make it easy
for them to do so (e.g., having a README with instructions, having dependency
management in place, etc)

* The code eventually must be able to execute on CI/CD agents. Please think about what
you can do to facilitate this (e.g. make it easy to run test from command line instead
of via an IDE or similar)

* Your next stage of the interview process may include a pair programming exercise
where you will extend/add more functionality to this automation suite

   
   
