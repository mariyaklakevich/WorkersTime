import Entity.Confluence;
import Entity.WorkTime;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Worker {

    private static final String input = "C:\\Users\\marou\\Desktop\\WorkersTime\\src\\main\\java\\input.txt";

    public static void main(String args[]) throws IOException, ParseException {

        BufferedReader reader = new BufferedReader(new FileReader(input));

        String line;
        List<WorkTime> workTimes = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            String startWork = line.substring(0, line.indexOf(" "));
            String endWork = line.substring(line.indexOf(" ") + 1);
            workTimes.add(new WorkTime(startWork, endWork));
        }

        int count = getConfluencesCount(workTimes);

        System.out.println("Максимальное количество сотрудников, находящихся в офисе одновременно: " + count);
    }

    public static int getConfluencesCount(List<WorkTime> workTimes) {
        int confluenceCount = 0;
        int maxConfluenceCount = 0;

        for (int i=0; i<workTimes.size(); i++) {
            WorkTime selectedWorkTime = workTimes.get(i);
            for (WorkTime workTime : workTimes) {

                Confluence confluence = new Confluence(selectedWorkTime, workTime);

                if ((confluence.getFirstWorkTime().getStartWorkTime().before(confluence.getSecondWorkTime().getEndWorkTime()) ||
                        confluence.getFirstWorkTime().getStartWorkTime().equals(confluence.getSecondWorkTime().getEndWorkTime()))&&
                        (confluence.getSecondWorkTime().getStartWorkTime().before(confluence.getFirstWorkTime().getStartWorkTime())) ||
                        confluence.getSecondWorkTime().getStartWorkTime().equals(confluence.getFirstWorkTime().getStartWorkTime())) {
                    confluenceCount++;
                }

                if (confluenceCount > maxConfluenceCount) {
                    maxConfluenceCount = confluenceCount;
                }
            }
            confluenceCount = 0;
        }

        return maxConfluenceCount;
    }
}

