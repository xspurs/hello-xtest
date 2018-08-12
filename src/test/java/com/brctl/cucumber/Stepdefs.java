package com.brctl.cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

class IsItFriday {
    static String isItFriday(String today) {
        if ("Friday".equals(today)) {
            return "TGIF";
        }
        return "Nope";
    }
}

public class Stepdefs {

    private String today;
    private String actualAnswer;

    @Given("^today is \"([^\"]*)\"$")
    public void today_is(String today) throws Exception {
        this.today = today;
    }

    @When("^I ask whether it's Friday yet$")
    public void i_ask_whether_it_s_Friday_yet() throws Exception {
        this.actualAnswer = IsItFriday.isItFriday(today);
    }

    @Then("^I should be told \"([^\"]*)\"$")
    public void i_should_be_told(String expectedAnswer) throws Exception {
        assertEquals(expectedAnswer, actualAnswer);


    }


    @Test
    public void testConnection() throws SQLException {
        Connection c = DriverManager.getConnection("jdbc:hsqldb:mem:mymemdb", "SA", "");
        PreparedStatement p = c.prepareStatement("select * from user");
        p.execute();
    }

}