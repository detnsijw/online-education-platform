public class SkillBasedStrategy implements RecommendationStrategy {
    @Override
    public List<Course> recommend(Student student, List<Course> catalog) {
        return catalog.stream()
                .filter(c -> c.getCategory().equalsIgnoreCase(student.getPreferredCategory()))
                .toList();
    }
}
