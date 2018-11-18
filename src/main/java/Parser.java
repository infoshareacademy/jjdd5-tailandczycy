import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Parser {
    public static void main(String[] args) throws FileNotFoundException {
        Gson gson = new GsonBuilder()
                .registerTypeHierarchyAdapter(LocalDate.class, new GsonLocalDateTypeAdapter())
                .create();
        //Read from a file
        InputStream resourceAsStream = Parser.class.getResourceAsStream("test.JSON");
        //Read Stream
        InputStreamReader reader = new InputStreamReader(resourceAsStream);

        //Reading from Json to Array
        Expenses[] expensesArray = gson.fromJson(reader, Expenses[].class);
        //Changing Array to List
        List<Expenses> listOfExpenses = Arrays.asList(expensesArray);
        //Printing full list
        for (Expenses expense : listOfExpenses
        ) {
            System.out.println(expense);
        }
    }
}
