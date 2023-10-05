import java.awt.desktop.QuitEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SimulationDriver {

    private static QuestionInterface generateQuestion() {
        Random random = new Random();
        QuestionInterface question;
        List<String> choices = new ArrayList<>();

        // choose between singleAnswerQuestion or multiAnswerQuestion
        int randomNum = random.nextInt(2);

        if (randomNum == 0) {
            randomNum = random.nextInt(2);

            if (randomNum == 0) {
                choices.add("true");
                choices.add("false");
            }
            else {
                choices.add("A");
                choices.add("B");
                choices.add("C");
                choices.add("D");
            }

            question = new singleAnswerQuestion(choices);
        }
        else {
            choices.add("A");
            choices.add("B");
            choices.add("C");
            choices.add("D");

            question = new multiAnswerQuestion(choices);
        }

        return question;
    }

    public static void main(String[] args) {
        Random random = new Random();

        // configure question
        QuestionInterface question = generateQuestion();
        int numOfChoices = question.getChoices().size();

        // generate students and input into iVote
        int numOfStudents = random.nextInt(8) + 3;
        iVote iVote = new iVote(new int[numOfChoices]);

        for (int i = 0; i < numOfStudents; i++) {
            int[] studentAnswer = new Student(i).answerQuestion(question, new int[numOfChoices]);
            iVote.inputAnswer(studentAnswer);
        }

        iVote.printStats(question, numOfStudents);
    }
}