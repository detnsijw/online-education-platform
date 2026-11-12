public class BudgetFriendlyStrategy implements RecommendationStrategy {
    @Override
    public List<Course> recommend(Student student, List<Course> catalog) {
        return catalog.stream()
                .filter(c -> c.getPrice() <= 50.0)
                .toList();
    }
}