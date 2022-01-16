import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class StackVersion {
    public static void main(String [] args) throws IOException {
//        String ans = parse();
        parseLog();
//        System.out.println(ans);
//        System.out.println("Hello");
//        List<LocalDate> dates = getDaysBetweenDates("2021-02-21", "2021-03-07");
        //System.out.println(dates);
    }

    public static List<LocalDate> getDaysBetweenDates(String startdate, String enddate)
    {
//        List<Date> dates = new ArrayList<Date>();
//        Calendar calendar = new GregorianCalendar();
//        calendar.setTime(startdate);
//
//        while (calendar.getTime().before(enddate))
//        {
//            Date result = calendar.getTime();
//            dates.add(result);
//            calendar.add(Calendar.DATE, 1);
//        }
//        return dates;

        LocalDate start = LocalDate.parse(startdate);
        LocalDate end = LocalDate.parse(enddate);
        List<LocalDate> totalDates = new ArrayList<>();
        while (!start.isAfter(end)) {
            totalDates.add(start);
            start = start.plusDays(1);
        }
        return totalDates;
    }

    public static void parseLog() throws IOException {
        String fromDate = "2021-10-21", toDate = "2021-10-22";
        //List<LocalDate> dates = getDaysBetweenDates("2021-02-21", "2021-03-07");
//        BufferedReader br = new BufferedReader(new FileReader("/Users/ssahu/Downloads/DS-Algo/src/quartzEvent_a.log"));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                String[] splitStr = line.split("\\s+");
                //System.out.println(splitStr[0] + " " + splitStr[1]);
                LocalDate dateStart = LocalDate.parse(fromDate);
                LocalDate dateEnd = LocalDate.parse(toDate);
                LocalDate date = LocalDate.parse(splitStr[1]);
//                System.out.println(dateStart);
//                System.out.println(dateEnd);
//                System.out.println(date);
                if ((date.isAfter(dateStart) && date.isBefore(dateEnd) || (date.isEqual(dateStart)) || (date.isEqual(dateEnd)))){
                    if(splitStr[0].equals("INFO") == true) {
                        sb.append(line);
                        sb.append(System.lineSeparator());
                    }
                    //System.out.println(splitStr[1]);
                }
                line = br.readLine();
            }
            String everything = sb.toString();
            System.out.println(everything);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            br.close();
        }
    }

    public static String parse(){
        String fileContent = "";
        BufferedReader br = null; ;
        try {
//            br = new BufferedReader (new FileReader("/Users/ssahu/Downloads/DS-Algo/src/nxyz.txt"));
            StringBuilder sb = new StringBuilder();
            String fileLine = "";
            while ((fileLine = br.readLine()) != null) {
                System.out.println(fileLine);
                sb.append(fileLine);
                sb.append(System.lineSeparator());
            }
            System.out.println("ll");
            fileContent = sb.toString();
            br.close();
        } catch (IOException ioe) {
            System.out.println("caught");
            ioe.getMessage();
        }
        return fileContent;
    }
}
