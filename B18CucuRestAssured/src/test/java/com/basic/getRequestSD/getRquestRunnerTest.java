package com.basic.getRequestSD;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
	
		features ={"src/test/resources/com/basic/getRequestFF/"},
		glue={"com/basic/getRequestSD/"}
		
		
		)
public class getRquestRunnerTest {

}
