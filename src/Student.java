import java.util.Random;

public class Student {
    private final int ID;

    public Student(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public int[] answerQuestion(QuestionInterface question, int[] answerArray) {
        Random rand = new Random();
        int numberOfChoices = question.getChoices().size();

        if (question instanceof singleAnswerQuestion) {
            answerArray[rand.nextInt(numberOfChoices)] = 1;
        }
        else {
            for (int i = 0; i < numberOfChoices; i++) {
                answerArray[i] = rand.nextInt(2);
            }
        }

        return answerArray;
    }
}
