import java.util.List;

public class singleAnswerQuestion implements QuestionInterface {
    private final List<String> choices;

    public singleAnswerQuestion(List<String> choices) {
        this.choices = choices;
    }

    public List<String> getChoices() {
        return choices;
    }
}
