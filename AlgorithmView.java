import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class AlgorithmView extends JFrame{
    private JButton confirmBtn;
    private JLabel questionTitle;
    private JPanel rootPanel;
    private JTextArea questionDescription;
    private JTextArea currCodeField;
    private JScrollPane LeftPane;
    private JScrollPane RightPane;
    private JPanel TopPane;
    private JSplitPane splitPane;
    private final int frameWidth = 1200;
    private final int frameHeight = 800;

    public AlgorithmView(){

        super("Algorithm Runner Application");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setContentPane(rootPanel);

        setLayout(new BorderLayout());
        add(TopPane, BorderLayout.NORTH);

        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, LeftPane, RightPane);
        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerLocation(frameWidth/2);

        add(splitPane, BorderLayout.CENTER);

        setVisible(true);
        setSize(frameWidth,frameHeight);
    }

    public JTextArea getQuestionDescription(){
        return questionDescription;
    }

    public JTextArea getCurrCodeField(){
        return currCodeField;
    }

    public JButton getConfirmBtn(){
        return confirmBtn;
    }

    public void textConvertTextField(String filePath, JTextArea textArea) throws IOException {
        AlgorithmTextImport textImport = new AlgorithmTextImport();
        textImport.readSourceCode(filePath);
        textImport.flush(textArea);
    }

    public void descriptionConvertTextField( String text, JTextArea textArea) throws IOException {
        AlgorithmTextImport textImport = new AlgorithmTextImport();
        textImport.readInputAndOutput(text);
        textImport.flush(textArea);
    }

    public void setQtnCurrentCodeState(String filePath) throws IOException {
        textConvertTextField(filePath, this.currCodeField);

        this.currCodeField.setEditable(true);
        this.currCodeField.setLineWrap(true);
    }

    public void setQtnDescriptionText(String text) throws IOException {
        descriptionConvertTextField(text, this.questionDescription);
        
        this.currCodeField.setEditable(false);
        this.questionDescription.setLineWrap(true);
    }

    public void setQuestionTitle(String title){
        questionTitle.setText(title);
    }

}
