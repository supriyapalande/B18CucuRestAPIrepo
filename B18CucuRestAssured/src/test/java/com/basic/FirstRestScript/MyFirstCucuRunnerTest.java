package com.basic.FirstRestScript;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
	
		features ={"src/test/resources/com/basic/FirstRestScript/"},
		glue={"com/basic/FirstRestScript/"}
		
		
		)
public class MyFirstCucuRunnerTest
{

}
