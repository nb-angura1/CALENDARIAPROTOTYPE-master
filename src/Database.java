import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Database {

    private String filename;
    private int rowWidth;
    private int recordCount = 0;

    public Database(String filename, int rowWidth) {
        this.filename = filename;
        this.rowWidth = rowWidth;
        //countRecords();
    }

    public void appendRecord(String data) {
        // TODO: Pad the data to the correct record width
        try (FileWriter fw = new FileWriter(filename, true);
             PrintWriter pw = new PrintWriter(fw);
        ) {
            int currentLength = data.length();
            int padLength = rowWidth - currentLength;
            // TODO: Report an error if the data is too long for the record
            if (currentLength > 101) {
                System.out.print("ERROR! the data is too long for the record");
            } else {
                //take in data and write to the file

                String paddedData = data;
                for (int i = 0; i < padLength; i++) {
                    paddedData = paddedData + "x";
                }
                System.out.println(paddedData);
                pw.println(paddedData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

     /*public void deleteRecord(int rowNumber) {
        try (FileWriter fw = new FileWriter(filename, true);
             RandomAccessFile raf = new RandomAccessFile(filename, "rws");
        ) {
            raf.seek(rowNumber);
            raf.write(getRecordCount(filename));
            fw.write("      ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //remember to decrement record count
        recordCount = recordCount - 1;
    }*/

    public void addRecord(String fileName, String input){

        FileHandler.appendLine(fileName,input);
    }

    public String getRecord(int rowNumber) {
        return FileHandler.readLineAt(filename, (rowNumber * 9));
    }

    public int getRecordCount(String fileName) {
        int count = 1;
        String record = " ";
        while (record!= null){
            record = getRecord(count);
            count++;
            record = getRecord(count);
            System.out.println(record);
        }
        return count-1;
    }

    //public boolean findRecord(String data) {
    // search for a record matching data
    // return true if found
    //int start = 0;

}
//}

