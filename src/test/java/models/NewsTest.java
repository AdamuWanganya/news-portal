package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewsTest {

    @Test
    void instantiatedNewsCorrectly() {
        News testNews = setUpNews();
        assertTrue(testNews instanceof News);
    }

    @Test
    void gettersWorkCorrectly() {
        News testNews = setUpNews();
        assertEquals("Breaking News", testNews.getName());
    }

    @Test
    void equalsWorksCorrectly() {
        News testNews1 = setUpNews();
        News testNews2 = setUpNews();
        assertTrue(testNews1.equals(testNews2));
    }

    public News setUpNews() {
        News testNews = new News("Breaking News", "Our best hacker got promotted", 6);
        return testNews;
    }

}