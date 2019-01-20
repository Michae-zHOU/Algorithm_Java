import java.util.*;

public class AutoSortStackQuestion implements Question {
    AutoSortStack stack;
    String name;
    String description;
    String currCodeState;
    String filePath;
    String input;
    String output;

    @Override
    public void executeDefault(){
        try{
            Stack<Integer> oldStack = new Stack<>();
            oldStack.add(3);
            oldStack.add(5);
            oldStack.add(0);
            oldStack.add(3);
            input = "Input: "+oldStack.toString();
            System.out.println(input);
            stack = new AutoSortStack(oldStack);
            output = "Output: "+stack;
            System.out.println(output);
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void execute(){
        try{
            Stack<Integer> oldStack = new Stack<>();
            for(String s: input.split(",")){
                oldStack.add(Integer.parseInt(s));
            }
            System.out.println(input);
            stack = new AutoSortStack(oldStack);
            output = "Output: "+stack;
            System.out.println(output);

        }
        catch(Exception ex){
            ex.printStackTrace();;
        }
    }

    @Override
    public void setCurrentCode(String codeState) { this.currCodeState = codeState; }

    @Override
    public void setQuestionDescription(String description){
        this.description = description;
    }

    @Override
    public void setFilePath(String filePath) { this.filePath = filePath; }

    @Override
    public void setInput(String input) { this.input = input; }

    @Override
    public String getQuestionDescription(){ return description; }

    @Override
    public String getQuestionName(){ return this.name; }

    @Override
    public String getFilePath() { return this.filePath; }

    @Override
    public String getInput() { return this.input; }

    @Override
    public String getOutput() { return this.output; }

    public AutoSortStackQuestion(){
        //System.out.println("AutoSortStackQuestion Selected");
        this.name = "AutoSortStack";
        this.filePath = "AutoSortStack.java";
    }
}