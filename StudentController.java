package main.java.com.example.cse360;

import java.util.List;

public class StudentController {
    private ArticleManager articleManager;

    public StudentController(ArticleManager articleManager) {
        this.articleManager = articleManager;
    }

    public void searchArticles(String query, String group, String level) {
        // Searching logic for articles by query, group, and level
        List<HelpArticle> articles = articleManager.getArticlesByGroup(group); // Mock search functionality
        for (HelpArticle article : articles) {
            if (article.getTitle().contains(query)) {
                System.out.println(article); // Just an example of how to display the result
            }
        }
    }

    public void sendHelpRequest(String message) {
        // Logic to send help request
        System.out.println("Help request sent: " + message);
    }
}
