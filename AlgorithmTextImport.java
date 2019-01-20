import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AlgorithmTextImport {

    public List<String> textList;

    public AlgorithmTextImport() {
        this.textList = new ArrayList<>();
    }

    public void readInputAndOutput(String inputAndOutput) {
        textList.add(inputAndOutput);
    }

    public void writeSourceCode(String filePath) throws IOException {
        File sourceCode = new File(System.getProperty("user.dir")+"/"+filePath);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(sourceCode));

        for(String currLine: textList) {
            bufferedWriter.write(currLine);
            bufferedWriter.write("\n");
        }

        textList.clear();
        bufferedWriter.close();;
    }

    public void readSourceCode(String filePath) throws IOException {
        File sourceCode = new File(System.getProperty("user.dir")+"/"+filePath);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(sourceCode));

        String currLine;
        while((currLine = bufferedReader.readLine()) != null) {
            textList.add(currLine);
        }

        bufferedReader.close();
    }

    public void pale(JTextArea textArea) {
        try{
            for(String currLine : textArea.getText().split("\\n")) {
                textList.add(currLine);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public void flush(JTextArea textArea) {

        for(String row: textList){
            textArea.append(row);
            textArea.append("\n");
        }

        textList.clear();
    }
}
