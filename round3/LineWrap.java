import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class LineWrap {

  // The stream operations in the main function may cause an exception of type
  // IOException. Therefore we have added an exception specification
  // "throws IOException" to the end of its header.
  public static void main(String args[]) throws IOException {
    // Create a BufferedReader object "user" for reading System.in.
    // Note that, unlike with files, we should not use try-with-resources here
    // because the standard input stream should not be closed.
    BufferedReader user = new BufferedReader(new InputStreamReader(System.in));
    while(true) {  // An infinite loop that will be exited upon a "quit" command.
      System.out.print("Give input filename (or 'quit'): ");
      final String inputFilename = user.readLine();
      if("quit".equalsIgnoreCase(inputFilename)) {
        break;
      }
      System.out.print("Give line wrap length limit (or 'quit'): ");
      String lineLimStr = user.readLine();
      if("quit".equalsIgnoreCase(lineLimStr)) {
        break;
      }
      final int lineLim = Integer.parseInt(lineLimStr);
      System.out.print("Give output filename (or 'quit'): ");
      final String outputFilename = user.readLine();
      if("quit".equalsIgnoreCase(inputFilename)) {
        break;
      }

      // Also count statistics about input and output lines.
      int inputLines = 0;
      int outputLines = 0;

      // The form of try-with-resources:
      //   try(resource variable statements separated by semicolons) {
      //     the code block that uses the resources
      //   }
      // The resources listed by the resource variable statements will be closed
      // automatically when the program exits the following code block. The resources
      // must have a member function "close". In try-with-resources below we create
      // BufferedReader input for file reading and PrintStream output for file writing.
      // This is also an example where using the inferred var type might be ok: the
      // conrete type has a longish name and is anyway spelled out in the new operation.
      try(var input = new BufferedReader(new FileReader(inputFilename));
          var output = new PrintStream(outputFilename)) {
        String line = null;
        int lineLen = 0;
        while((line = input.readLine()) != null) {
          inputLines += 1;
          // Split interprets its parameter as a regular expression, where "\\s+"
          // means one or more space characters (space, tabulator, etc.).
          String[] words = line.split("\\s+");
          for(String word : words) {
            if(word.length() > 0) {
              if(lineLen > 0 && lineLen + 1 + word.length() > lineLim) {
                output.println();
                outputLines += 1;
                lineLen = 0;
              }
              if(lineLen > 0) {
                output.print(" ");
                lineLen += 1;
              }
              output.print(word);
              lineLen += word.length();
            }
          }
        }
        if(lineLen > 0) {
          output.println();
          outputLines += 1;
        }
      }
      // At this point input and output have been closed automatically.
      // Print out input and output line statistics. This time as an example to System.err.
      System.err.format("The input file %s had %d lines.%n", inputFilename, inputLines);
      System.err.format("The wrapped file %s has %d lines.%n", outputFilename, outputLines);
    }
  }
}