package com.searchmodule.tests;

import com.searchmodule.pages.SearchPage;
import com.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test
    @Parameters({"keyword"})
    public void search(String keyword) {
        SearchPage sp = new SearchPage(driver);
        sp.goTo();
        sp.enterText(keyword);
        sp.goToVideos();
        sp.getResult();
        int actualVideos = sp.getResult();
        Assert.assertTrue(actualVideos > 0);
    }




}
