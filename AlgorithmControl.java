import java.lang.reflect.Method;

public class AlgorithmControl {

    public static void main(String[] args){
        try{
            QuestionManager questionManager = new QuestionManager("AutoSortStack");

            System.out.println("Question Name: "+questionManager.getQuestion().getQuestionName());
            //questionManager.runDefault();
            setQuestionDescription(questionManager);

            AlgorithmView view = new AlgorithmView();
            view.setQuestionTitle(questionManager.getQuestionName());
            view.setQtnDescriptionText(questionManager.getQuestionDescription());
            view.setQtnCurrentCodeState(questionManager.getQuestionFilePath());

            AlgorithmViewControl algorithmViewControl = new AlgorithmViewControl(view, questionManager);
            algorithmViewControl.addButtonAction();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }

    public static void setQuestionDescription(QuestionManager questionManager){
        String description = "Sort a stack without using extra data structure. (Variable is allow)";
        questionManager.getQuestion().setQuestionDescription(description);
    }
}

//        try{
//            Method m = questionManager.getClass().getMethod("runDefault", null);
//            m.invoke(questionManager);
//        } catch (Exception e){
//            System.err.println(e);
//        }
