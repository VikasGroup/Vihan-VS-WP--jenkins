package com.test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		format = { 
				"pretty", 
				"html:target/cucumber-html-report",
				"json:target/cucumber-report.json" 
		},

		features = {
				"src/test/resources/features"
		},
		
		glue={
				"com.steps",
				"com.test"
				
		},
		tags={
				"@Reg"
		}
		
)

public class TestRunner { 

}
