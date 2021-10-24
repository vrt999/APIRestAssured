$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/Features/Sample.feature");
formatter.feature({
  "name": "",
  "description": "  Verify different GET operations using Rest Assured",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Verify one author of the post",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "I perform GET operation for \"/posts\"",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinitions.StepDefinition.i_perform_GET_operation_for(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I perform GET for the post number \"1\"",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.StepDefinition.i_perform_GET_for_the_post_number(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should see the author name as \"typicode\"",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.StepDefinition.i_should_see_the_author_name_as(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Verify collection of authors in the post",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "I perform GET operation for \"/posts\"",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinitions.StepDefinition.i_perform_GET_operation_for(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should see the author names",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.StepDefinition.i_should_see_the_author_names()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Verify the parameter of GET",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "I perform GET operation for \"/posts\"",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinitions.StepDefinition.i_perform_GET_operation_for(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should see verify GET parameter",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.StepDefinition.i_should_see_verify_GET_parameter()"
});
formatter.result({
  "status": "passed"
});
});