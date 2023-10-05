import java.util.List;

public class iVote {
    int[] studentAnswerStats;

    public iVote(int[] studentAnswerStats) {
        this.studentAnswerStats = studentAnswerStats;
    }

    public void inputAnswer(int[] studentAnswer) {
        for (int i = 0; i < studentAnswer.length; i++) {
            studentAnswerStats[i] += studentAnswer[i];
        }
    }

    public void printStats(QuestionInterface question, int numOfStudents) {
        List<String> choices = question.getChoices();

        System.out.println("Number of students: " + numOfStudents);
        System.out.print("Question type: ");

        if (question instanceof singleAnswerQuestion) {
            System.out.print("Single Answer\n");
        } else {
            System.out.print("Multiple Answer\n");
        }

        for (int i = 0; i < studentAnswerStats.length; i++) {
            System.out.println(choices.get(i) + " : " + studentAnswerStats[i]);
        }
    }
}
