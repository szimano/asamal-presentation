package pl.devcrowd.controller;

import pl.devcrowd.logic.Tweeter;
import pl.devcrowd.model.Tweet;
import pl.softwaremill.asamal.controller.AsamalContext;
import pl.softwaremill.asamal.controller.ControllerBean;
import pl.softwaremill.asamal.controller.annotation.Controller;
import pl.softwaremill.asamal.controller.annotation.Get;
import pl.softwaremill.asamal.controller.annotation.Json;
import pl.softwaremill.asamal.controller.annotation.Post;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Home page controller
 *
 * User: szimano
 */
@Controller("home")
public class Home extends ControllerBean implements Serializable {

    @Inject
    Tweeter twitter;

    private Tweet tweet = new Tweet();

    @Get
    public void index() {
        putInContext("tweets", twitter.getTweets());
    }

    @Post
    public void reload() {
        System.out.println("reloading");

        index();
    }

    @Post
    public void addTweet() {
        doAutoBinding("tweet.msg");

        tweet.setDate(new Date());

        if (validateBean("tweet", tweet)) {
            twitter.addTweet(tweet);

            redirect("index");
            addMessageToFlash("Tweet added", AsamalContext.MessageSeverity.SUCCESS);
        }
        else {
            addMessageToFlash("Validation errors", AsamalContext.MessageSeverity.ERR);

            index();

            includeView("index");
        }
    }

    public Tweet getTweet() {
        return tweet;
    }
}
