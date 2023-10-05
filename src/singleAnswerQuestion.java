import java.util.List;

public class singleAnswerQuestion implements QuestionInterface {
    private final List<String> choices;
    private final int[] correctAnswers;

    public singleAnswerQuestion(List<String> choices, int[] correctAnswers) {
        this.choices = choices;
        this.correctAnswers = correctAnswers;
    }

    public List<String> getChoices() {
        return choices;
    }

    public int[] getCorrectAnswers() {
        return correctAnswers;
    }
}
