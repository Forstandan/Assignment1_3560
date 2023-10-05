import java.util.*;

public class SimulationDriver {

    private static void twoChoices(List<String> choices) {
        choices.add("true");
        choices.add("false");
    }

    private static void fourChoices(List<String> choices) {
        choices.add("A");
        choices.add("B");
        choices.add("C");
        choices.add("D");
    }

    private static int[] generateCorrectAnswers(List<String> choices, int singleAnswerQuestion) {
        Random random = new Random();
        int randomNum = random.nextInt(2);
        int[] correctAnswers;

        if (singleAnswerQuestion == 0) {
            randomNum = random.nextInt();
            if (randomNum == 0) {
                twoChoices(choices);
            }
            else {
                fourChoices(choices);
            }
        }
        else {
            fourChoices(choices);
        }

        correctAnswers = new int[choices.size()];

        int correctAnswerCount = 0;
        for (int i = 0; i < correctAnswers.length; i++) {
            int nextInt = random.nextInt(2);
            correctAnswers[i] = nextInt;

            // keep track of the amount of correct answers
            if (nextInt == 1) {
                correctAnswerCount++;
            }

            // if it's a single answer question then break as soon as there is an answer selected
            if (singleAnswerQuestion == 0 && correctAnswerCount == 1) {
                break;
            }
        }
        // if no answer has been selected force one to be selected
        if (correctAnswerCount == 0)
            correctAnswers[random.nextInt(correctAnswers.length)] = 1;

        return correctAnswers;
    }

    private static QuestionInterface generateQuestion() {
        QuestionInterface question;
        int[] correctAnswers;

        Random random = new Random();
        List<String> choices = new ArrayList<>();

        // choose between singleAnswerQuestion or multiAnswerQuestion
        int randomNum = random.nextInt(2);

        correctAnswers = generateCorrectAnswers(choices, randomNum);

        if (randomNum == 0) {
            question = new singleAnswerQuestion(choices, correctAnswers);
        }
        else {
            question = new multiAnswerQuestion(choices, correctAnswers);
        }
        return question;
    }

    public static void main(String[] args) {
        Random random = new Random();
        Map<Student, Boolean> studentStats = new HashMap<>();

        // configure question
        QuestionInterface question = generateQuestion();
        int numOfChoices = question.getChoices().size();

        // generate students and input into iVote
        int numOfStudents = random.nextInt(41) + 10;
        iVote iVote = new iVote(new int[numOfChoices], studentStats);

        for (int i = 0; i < numOfStudents; i++) {
            List<String> studentAnswerList = new ArrayList<>();
            int[] studentAnswer = Student.answerQuestion(question, new int[numOfChoices]);

            Student student = new Student(UUID.randomUUID().toString(), studentAnswerList, studentAnswer, question);
            iVote.inputAnswer(student, studentAnswer, question);
        }

        iVote.printStats(question, numOfStudents);
    }
}
