import java.util.List;
import java.util.Set;

public class multiAnswerQuestion implements QuestionInterface {
    private final List<String> choices;
    private final int[] correctAnswers;

    public multiAnswerQuestion(List<String> choices, int[] correctAnswers) {
        this.choices = choices;
        this.correctAnswers = correctAnswers;
    }

    public List<String> getChoices() {
        return choices;
    }

    public int[] getCorrectAnswers() { return correctAnswers; }
}
