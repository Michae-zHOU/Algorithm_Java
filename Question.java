public interface Question {

    String getQuestionName();
    String getQuestionDescription();
    String getFilePath();
    String getInput();
    String getOutput();

    void setCurrentCode(String codeState);
    void setQuestionDescription(String description);
    void setFilePath(String filePath);
    void setInput(String string);

    void execute();
    void executeDefault();
}
