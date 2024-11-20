package com.example.cse360;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ArticleManagerTest {

    @Test
    public void testAddArticle() throws Exception {
        ArticleManager manager = new ArticleManager();
        HelpArticle article = new HelpArticle(1, "Header", "Title", "Short Desc", "Body", List.of("keyword"), 1L);
        manager.addArticleToGroup("General", article);

        assertEquals(1, manager.getArticlesByGroup("General").size());
    }

    @Test
    public void testEncryptAndDecryptArticleBody() throws Exception {
        ArticleManager manager = new ArticleManager();
        HelpArticle article = new HelpArticle(1, "Header", "Title", "Short Desc", "Sensitive Body", List.of("keyword"), 1L);

        manager.encryptArticleBody(article);
        String encryptedBody = article.getBody();
        assertNotEquals("Sensitive Body", encryptedBody);

        manager.decryptArticleBody(article);
        String decryptedBody = article.getBody();
        assertEquals("Sensitive Body", decryptedBody);
    }
}
