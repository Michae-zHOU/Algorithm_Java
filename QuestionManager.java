public class QuestionManager {
    Question question;
    public QuestionManager(String name){
        switch (name){
            case "AutoSortStack":
                question = new AutoSortStackQuestion();
                break;
            case "Other":
                break;
            default:
                System.out.println("No Question Selected.");
        }
    }

    public void setInput(String input) {
        question.setInput(input);
    }

    public Question getQuestion() {
        return question;
    }

    public String getQuestionName() {
        return question.getQuestionName();
    }

    public String getQuestionDescription() {
        return question.getQuestionDescription();
    }

    public String getQuestionFilePath() {
        return question.getFilePath();
    }

    public String getInput() {
        return question.getInput();
    }

    public String getOutput() {
        return question.getOutput();
    }

    public void runDefault(){
        question.executeDefault();
    }

    public void run(){
        question.execute();
    }
}
