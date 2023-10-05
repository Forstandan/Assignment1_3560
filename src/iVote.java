import java.util.List;
import java.util.Map;

public class iVote {
    private final int[] studentAnswerStats;
    private final Map<Student, Boolean> studentStats;

    public iVote(int[] studentAnswerStats, Map<Student, Boolean> studentStats) {
        this.studentAnswerStats = studentAnswerStats;
        this.studentStats = studentStats;
    }

    public void inputAnswer(Student student, int[] studentAnswer, QuestionInterface question) {

        studentStats.put(student, true);
        int[] correctAnswers = question.getCorrectAnswers();

        for (int i = 0; i < studentAnswer.length; i++) {
            studentAnswerStats[i] += studentAnswer[i];

            if (studentAnswer[i] != correctAnswers[i]) {
                studentStats.put(student, false);
            }
        }
    }

    public void printStats(QuestionInterface question, int numOfStudents) {
        List<String> choices = question.getChoices();

        System.out.println("Number of students: " + numOfStudents);
        System.out.print("Question type: ");

        // print question type
        if (question instanceof singleAnswerQuestion) {
            System.out.print("Single Answer\n");
        } else {
            System.out.print("Multiple Answer\n");
        }

        // print each the overall statistics
        for (int i = 0; i < studentAnswerStats.length; i++) {
            System.out.println(choices.get(i) + " : " + studentAnswerStats[i]);
        }

        // print out the correct answers
        System.out.print("\nCorrect Answers: ");
        for (int i = 0; i < choices.size(); i++) {
            if (question.getCorrectAnswers()[i] == 1) {
                System.out.print(choices.get(i) + ' ');
            }
        }

        // print out each student's result
        System.out.printf("%n %22s %25s %20s %n", "Student ID", "Correct", "Student's Answer");

        // print out the student's ID and whether they got the questions right
        for (Student student : studentStats.keySet()) {
            System.out.printf("%s\t:\t%-5b\t:\t\t%-10s%n", student.getID(), studentStats.get(student), student.getStudentAnswer());
        }
    }
}
