import java.io.*;
import java.util.*;

public class BackupManager {
    private List<HelpArticle> articles;

    public BackupManager(List<HelpArticle> articles) {
        this.articles = articles;
    }

    // Backup method: Now it will also handle encrypted content
    public void backupArticles(String filename, List<Long> groupIds) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            List<HelpArticle> backupArticles = new ArrayList<>();
            for (HelpArticle article : articles) {
                if (groupIds.contains(article.getGroupId()) || groupIds.isEmpty()) {
                    backupArticles.add(article);
                }
            }
            oos.writeObject(backupArticles);
        }
    }

    // Restore method remains unchanged
    public void restoreArticles(String filename, boolean merge) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            List<HelpArticle> backupArticles = (List<HelpArticle>) ois.readObject();
            if (merge) {
                for (HelpArticle backupArticle : backupArticles) {
                    if (!articles.stream().anyMatch(article -> article.getId() == backupArticle.getId())) {
                        articles.add(backupArticle);
                    }
                }
            } else {
                articles.clear();
                articles.addAll(backupArticles);
            }
        }
    }
}
