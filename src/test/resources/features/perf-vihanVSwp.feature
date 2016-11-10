Feature: Perf Test

@Reg
Scenario: vihan1
	Given User Clear Database

@Reg
Scenario Outline: vihan
	Given User opens home page
	And User calculate loard time for vihan Public site "<round>"
	And User click on login button
	And User calculate loard time for vihan Public site to Login page
	And User enter "<userName>" and "<passwrd>" and click on login
	And User calcuate loard time for vihan Login page to VO Dashboard
	When User click on shop button
	Then User calculate loard time for VO Dashboard to products Page
	
	Examples:
	|userName|passwrd|round|
	|IN398868|testpw | 1   |
		|IN398868|testpw | 2  |
			|IN398868|testpw | 3   |
	
@Reg
	Scenario Outline: WorldPlan
	Given User opens home page WorldPlan
	And User calculate loard time for WorldPlan Public site "<round>"
	And User click on login button WorldPlan
	And User calculate loard time for WorldPlan Public site to Login page
	And User enter "<userName>" and "<passwrd>" and click on login WorldPlan
	And User calcuate loard time for WorldPlan Login page to VO Dashboard
	When User click on shop button WorldPlan
	Then User calculate loard time for VO Dashboard to products Page WorldPlan
	
	Examples:
	|userName|passwrd|round|
	|HZ097243|testpw | 1   |	
	|HZ097243|testpw | 2   |
	|HZ097243|testpw | 3   |
@Reg
Scenario: vihan11
	Given User Create the report