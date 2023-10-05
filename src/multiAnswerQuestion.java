import java.util.List;

public class multiAnswerQuestion implements QuestionInterface {
    private final List<String> choices;

    public multiAnswerQuestion(List<String> choices) {
        this.choices = choices;
    }

    public List<String> getChoices() {
        return choices;
    }
}
