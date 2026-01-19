import java.io.File;
import java.util.List;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

public class RecommendationSystem {

    public static void main(String[] args) {
        try {
            // Load sample data
            DataModel model = new FileDataModel(new File("preferences.csv"));

            // Similarity algorithm
            UserSimilarity similarity = new PearsonCorrelationSimilarity(model);

            // Neighborhood
            UserNeighborhood neighborhood =
                    new NearestNUserNeighborhood(2, similarity, model);

            // Recommender
            GenericUserBasedRecommender recommender =
                    new GenericUserBasedRecommender(model, neighborhood, similarity);

            // Generate recommendations for user 1
            List<RecommendedItem> recommendations =
                    recommender.recommend(1, 2);

            System.out.println("Recommended items for User 1:");
            for (RecommendedItem recommendation : recommendations) {
                System.out.println("Item ID: " + recommendation.getItemID() +
                        " | Preference Score: " + recommendation.getValue());
            }

        } catch (Exception e) {
            System.out.println("Error generating recommendations");
        }
    }
}