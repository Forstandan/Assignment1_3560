import javax.swing.plaf.IconUIResource;
import java.util.List;
import java.util.Random;

public class Student {
    private final String ID;
    private final List<String> studentAnswer;

    public Student(String ID, List<String> studentAnswerList, int[] studentAnswerArr, QuestionInterface question) {
        this.ID = ID;
        this.studentAnswer = studentAnswerList;
        setStudentAnswer(studentAnswerArr, question);
    }

    public String getID() {
        return ID;
    }

    public static int[] answerQuestion(QuestionInterface question, int[] answerArray) {
        Random rand = new Random();
        int numberOfChoices = question.getChoices().size();
        int answerCount = 0;

        if (question instanceof singleAnswerQuestion) {
            answerArray[rand.nextInt(numberOfChoices)] = 1;
            answerCount++;
        }
        else {
            for (int i = 0; i < numberOfChoices; i++) {
                int nextInt = rand.nextInt(2);
                answerArray[i] = nextInt;

                if (nextInt == 1) {
                    answerCount++;
                }
            }
        }

        // if no answer is selected force one random index to be selected
        if (answerCount == 0) {
            answerArray[rand.nextInt(question.getChoices().size())] = 1;
        }

        return answerArray;
    }

    private void setStudentAnswer(int[] studentAnswerArr, QuestionInterface question) {
        List<String> choices = question.getChoices();

        for (int i = 0; i < studentAnswerArr.length; i++) {
            if (studentAnswerArr[i] == 1) {
                this.studentAnswer.add(choices.get(i));
            }
        }
    }

    public List<String> getStudentAnswer() {
        return studentAnswer;
    }
}
