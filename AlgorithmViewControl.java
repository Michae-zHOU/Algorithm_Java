import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;

public class AlgorithmViewControl {

    private JButton confirmBtn;
    private JTextArea textArea;
    private JTextArea altTextArea;
    private QuestionManager questionManager;
    private boolean isResultVisible;

    public AlgorithmViewControl(AlgorithmView view, QuestionManager questionManager) {
        this.confirmBtn = view.getConfirmBtn();
        this.textArea = view.getCurrCodeField();

        this.questionManager = questionManager;
        this.isResultVisible = true;
    }

    public void AlgorithmViewAltControl(AlgorithmView view, QuestionManager questionManager) {
        this.altTextArea = view.getQuestionDescription();
        this.confirmBtn = view.getConfirmBtn();

        this.questionManager = questionManager;
    }

    public void addButtonAction() {
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    triggerTextAreaAction();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        };

        confirmBtn.addActionListener(actionListener);
    }

    private void triggerTextAreaAction() throws IOException {
        AlgorithmTextImport algorithmTextImport = new AlgorithmTextImport();

        if(isResultVisible){
            algorithmTextImport.pale(textArea);
            algorithmTextImport.writeSourceCode(questionManager.getQuestionFilePath());
            confirmBtn.setText("Back");
            textArea.setText("");
            questionManager.runDefault();
            algorithmTextImport.readInputAndOutput(questionManager.getInput());
            algorithmTextImport.readInputAndOutput(questionManager.getOutput());
            textArea.setEditable(false);
            textArea.setLineWrap(true);
        }
        else{
            confirmBtn.setText("Run");
            algorithmTextImport.readSourceCode(questionManager.getQuestionFilePath());
            textArea.setText("");
            textArea.setEditable(true);
            textArea.setLineWrap(true);
        }
        isResultVisible = !isResultVisible;
        algorithmTextImport.flush(textArea);
    }
}
