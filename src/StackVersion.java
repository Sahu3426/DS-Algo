//package com.cloudera.cpx.server.api.repositories;
//
//import org.apache.log4j.Logger;
//
//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.time.LocalDate;
//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReadWriteLock;
//import java.util.concurrent.locks.ReentrantReadWriteLock;
//
//public class LogParsingRepository {
//
//    private static final Logger LOGGER = Logger.getLogger(LogParsingRepository.class.getName());
//
//    private static LogParsingRepository instance;
//
//    public static LogParsingRepository getInstance() {
//        if (instance == null) {
//            synchronized (LogParsingRepository.class) {
//                if (instance == null) {
//                    instance = new LogParsingRepository();
//                }
//            }
//        }
//        return instance;
//    }
//
//    public Object getQuartzLogParsed(boolean successLog, boolean failureLog, String fromDate, String toDate) throws FileNotFoundException {
//        //String fromDate = "2022-01-13", toDate = "2022-01-13";
//        BufferedReader br = null;
//        String everything = null;
//        try {
//            if (Files.exists(Paths.get("/var/log/yarn/queuemanager/quartzEvent.log"))) {
//                LOGGER.info("Yesss.. quartzLOG found");
//            } else {
//                LOGGER.info("Yesss.. quartzLOG not found");
//            }
//            br = new BufferedReader(new FileReader("/var/log/yarn/queuemanager/quartzEvent.log"));
//            LocalDate dateStart = LocalDate.parse(fromDate);
//            LocalDate dateEnd = LocalDate.parse(toDate);
//            LOGGER.info(successLog + " " + failureLog);
//
//
//            StringBuilder sb = new StringBuilder();
//            String line = br.readLine();
//            if (successLog == true && failureLog == false){
//                while (line != null) {
//                    String[] splitStr = line.split("\\s+");
//                    LocalDate date = LocalDate.parse(splitStr[1]);
//                    if ((date.isAfter(dateStart) && date.isBefore(dateEnd) || (date.isEqual(dateStart)) || (date.isEqual(dateEnd)))) {
//                        boolean contains = Arrays.stream(splitStr).anyMatch("executed "::equals);
//                        boolean containsINFO = Arrays.stream(splitStr).anyMatch("INFO"::equals);
//                        for (int i = 0; i < splitStr.length; i++) {
//                            if (splitStr[i].equals("executed")) {
//                                contains = true;
//                            }
//                        }
//                        for (int i = 0; i < splitStr.length; i++) {
//                            if (splitStr[i].equals("INFO")) {
//                                containsINFO = true;
//                            }
//                        }
//                        LOGGER.info(contains);
//                        if (containsINFO == true && contains == true) {
//                            sb.append(line);
//                            sb.append(System.lineSeparator());
////                            LOGGER.info("If loop ke under : " + line);
////                        for(int i=0; i< splitStr.length; i++) {
////                            LOGGER.info("while loop ke under : " + splitStr[i]);
////                        }
//                        }
//                    }
//                    line = br.readLine();
////                for(int i=0; i< splitStr.length; i++) {
////                    LOGGER.info("while loop ke under : " + splitStr[i]);
////                }
//                }
//                everything = sb.toString();
//                return everything;
//            }
//
//            if(successLog == false && failureLog == true){
//                while (line != null) {
//                    String[] splitStr = line.split("\\s+");
//                    LocalDate date = LocalDate.parse(splitStr[1]);
//                    if ((date.isAfter(dateStart) && date.isBefore(dateEnd) || (date.isEqual(dateStart)) || (date.isEqual(dateEnd)))) {
//                        boolean containsFailed = Arrays.stream(splitStr).anyMatch("failed "::equals);
//                        boolean containsERROR = Arrays.stream(splitStr).anyMatch("ERROR"::equals);
//                        for (int i = 0; i < splitStr.length; i++) {
//                            if (splitStr[i].equals("failed")) {
//                                containsFailed = true;
//                            }
//                        }
//                        for (int i = 0; i < splitStr.length; i++) {
//                            if (splitStr[i].equals("ERROR")) {
//                                containsERROR = true;
//                            }
//                        }
//
//                        if (containsERROR == true && containsFailed == true) {
//                            sb.append(line);
//                            sb.append(System.lineSeparator());
////                            LOGGER.info("If loop ke under : " + line);
////                        for(int i=0; i< splitStr.length; i++) {
////                            LOGGER.info("while loop ke under : " + splitStr[i]);
////                        }
//                        }
//                    }
//                    line = br.readLine();
////                for(int i=0; i< splitStr.length; i++) {
////                    LOGGER.info("while loop ke under : " + splitStr[i]);
////                }
//                }
//                everything = sb.toString();
//                return everything;
//            }
//
//
//            while (line != null) {
//                String[] splitStr = line.split("\\s+");
//                LocalDate date = LocalDate.parse(splitStr[1]);
//                if ((date.isAfter(dateStart) && date.isBefore(dateEnd) || (date.isEqual(dateStart)) || (date.isEqual(dateEnd)))) {
////                    boolean contains = Arrays.stream(splitStr).anyMatch("executed "::equals);
////                    boolean containsERROR = Arrays.stream(splitStr).anyMatch("ERROR"::equals);
////                    for (int i = 0; i < splitStr.length; i++) {
////                        if (splitStr[i].equals("ERROR")) {
////                            contains = true;
////                        }
////                    }
//                    sb.append(line);
//                    sb.append(System.lineSeparator());
////                        LOGGER.info("If loop ke under : " + line);
////                        for(int i=0; i< splitStr.length; i++) {
////                            LOGGER.info("while loop ke under : " + splitStr[i]);
////                        }
//
//                }
//                line = br.readLine();
////                for(int i=0; i< splitStr.length; i++) {
////                    LOGGER.info("while loop ke under : " + splitStr[i]);
////                }
//            }
//            everything = sb.toString();
//            System.out.println(everything);
////            LOGGER.info("sb.toString : " + sb.toString());
////            LOGGER.info("LOG ITEM GENERATED : " + everything);
//            return everything;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return everything;
//    }
//}
//
//
//    @GET
//    @Path("/testingAPI")
//    @Produces(MediaType.APPLICATION_JSON)
//    @ApiOperation(value = "", notes = "Returns a list of partitions", tags={ "datacenter" })
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Successfully returned all scheduler partitions", response = SchedulerQueueEntity.class, responseContainer = "List")
//    })
//    public String gettestingAPI(String body, @Context HttpHeaders headers, @Context UriInfo ui) {
//        LOGGER.info("Received getSchedulerPartitions request: url = " + ui.getRequestUri().toString());
//        readLock.lock();
//        try {
//            return "ALL IS OK";
//        } finally {
//            readLock.unlock();
//        }
//    }
//
////    @GET
////    @Path("/quartzLogParsing")
////    @Produces(MediaType.APPLICATION_JSON)
////    @ApiResponses(value = {
////            @ApiResponse(code = 200, message = "Successfully returned parsed log.", response = RevalidationResponse.class)
////    })
////    public Response getQuartzLogParsed(String body, @Context HttpHeaders headers, @Context UriInfo ui) {
////        LOGGER.info("Received getQuartzLogParsed request: url = " + ui.getRequestUri().toString());
////        readLock.lock();
////        try {
////            return handleRequest(repository_log.getQuartzLogParsed());
////        } catch (FileNotFoundException e) {
////            return handleRequest(new ResponseStatus(400, e.getMessage()));
////        } finally {
////            readLock.unlock();
////        }
////    }
//
//
//
//
//
//
//
//
//
//
//
//
//package com.cloudera.cpx.server.api.services;
//
//        import com.cloudera.cpx.server.api.repositories.LogParsingRepository;
//        import com.cloudera.cpx.server.api.responses.RevalidationResponse;
//        import com.cloudera.cpx.server.api.utils.ResponseStatus;
//        import io.swagger.annotations.ApiResponse;
//        import io.swagger.annotations.ApiResponses;
//        import org.apache.log4j.Logger;
//
//        import javax.ws.rs.GET;
//        import javax.ws.rs.Path;
//        import javax.ws.rs.Produces;
//        import javax.ws.rs.QueryParam;
//        import javax.ws.rs.core.Context;
//        import javax.ws.rs.core.HttpHeaders;
//        import javax.ws.rs.core.MediaType;
//        import javax.ws.rs.core.Response;
//        import javax.ws.rs.core.UriInfo;
//        import java.io.FileNotFoundException;
//        import java.util.concurrent.locks.Lock;
//        import java.util.concurrent.locks.ReadWriteLock;
//        import java.util.concurrent.locks.ReentrantReadWriteLock;
//
//@Path("logs")
//public class LogService extends BaseService {
//
//    private static final Logger LOGGER = Logger.getLogger(LogService.class.getName());
//    private static final LogParsingRepository repository = LogParsingRepository.getInstance();
//    private static final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
//    private static final Lock readLock = readWriteLock.readLock();
//
//    /**
//     * API to get parsed quartz log
//     * @param body
//     * @param headers
//     * @param ui
//     * @return
//     */
//    @GET
//    @Path("/quartzLogParsing")
//    @Produces(MediaType.APPLICATION_JSON)
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Successfully returned parsed log.", response = RevalidationResponse.class)
//    })
//    public Response getQuartzLogParsed(String body, @Context HttpHeaders headers, @Context UriInfo ui,
//                                       @QueryParam("successLog") boolean successLog, @QueryParam("failureLog") boolean failureLog,
//                                       @QueryParam("fromDate") String fromDate, @QueryParam("toDate") String toDate) {
//        LOGGER.info("Received getQuartzLogParsed request: url = " + ui.getRequestUri().toString());
//        readLock.lock();
//        try {
//            return handleRequest(repository.getQuartzLogParsed(successLog, failureLog, fromDate, toDate));
//        } catch (FileNotFoundException e) {
//            return handleRequest(new ResponseStatus(400, e.getMessage()));
//        } finally {
//            readLock.unlock();
//        }
//    }
//}
//
//
//
//
//
//
//
//
//
//package com.cloudera.cpx.server.api.repositories;
//
//        import org.apache.log4j.Logger;
//
//        import java.io.BufferedReader;
//        import java.io.FileNotFoundException;
//        import java.io.FileReader;
//        import java.io.IOException;
//        import java.nio.file.Files;
//        import java.nio.file.Paths;
//        import java.time.LocalDate;
//        import java.util.Arrays;
//        import java.util.LinkedList;
//        import java.util.List;
//
//public class LogParsingRepository {
//
//    private static final String QUARTZ_EVENTS_LOGS_FILE_PATH = "/var/log/yarn/queuemanager/quartz-execution.log";
//    private static final Logger LOGGER = Logger.getLogger(LogParsingRepository.class.getName());
//    private static LogParsingRepository instance;
//
//    public static LogParsingRepository getInstance() {
//        if (instance == null) {
//            synchronized (LogParsingRepository.class) {
//                if (instance == null) {
//                    instance = new LogParsingRepository();
//                }
//            }
//        }
//        return instance;
//    }
//
//    public List<String> successQuartzEventsLog(LocalDate fromDate, LocalDate toDate, BufferedReader br) throws IOException {
//        String line = br.readLine();
//        List<String> parsedLog = new LinkedList<>();
//        while (line != null) {
//            String[] splitStr = line.split("\\s+");
//            LocalDate date = LocalDate.parse(splitStr[1]);
//            if ((date.isAfter(fromDate) && date.isBefore(toDate) || (date.isEqual(fromDate)) || (date.isEqual(toDate)))) {
//                boolean containsExecuted = Arrays.asList(splitStr).contains("executed");
//                boolean containsINFO = Arrays.asList(splitStr).contains("INFO");
//                if (containsINFO == true && containsExecuted == true) {
//                    parsedLog.add(line);
//                }
//            }
//            line = br.readLine();
//        }
//        return parsedLog;
//    }
//
//    public List<String> failQuartzEventsLog(LocalDate fromDate, LocalDate toDate, BufferedReader br) throws IOException {
//        String line = br.readLine();
//        List<String> parsedLog = new LinkedList<>();
//        while (line != null) {
//            String[] splitStr = line.split("\\s+");
//            LocalDate date = LocalDate.parse(splitStr[1]);
//            if ((date.isAfter(fromDate) && date.isBefore(toDate) || (date.isEqual(fromDate)) || (date.isEqual(toDate)))) {
//                boolean containsFailed = Arrays.asList(splitStr).contains("failed");
//                boolean containsERROR = Arrays.asList(splitStr).contains("ERROR");
//                if (containsERROR == true && containsFailed == true){
//                    parsedLog.add(line);
//                }
//            }
//            line = br.readLine();
//        }
//        return parsedLog;
//    }
//
//    public List<String> quartzEventsLog(LocalDate fromDate, LocalDate toDate, BufferedReader br) throws IOException {
//        String line = br.readLine();
//        List<String> parsedLog = new LinkedList<>();
//        while (line != null) {
//            String[] splitStr = line.split("\\s+");
//            LocalDate date = LocalDate.parse(splitStr[1]);
//            if ((date.isAfter(fromDate) && date.isBefore(toDate) || (date.isEqual(fromDate)) || (date.isEqual(toDate)))) {
//                parsedLog.add(line);
//            }
//            line = br.readLine();
//        }
//        return parsedLog;
//    }
//
//    public List<String> getQuartzLogParsed(boolean successLog, boolean failureLog, String fromDate, String toDate) throws FileNotFoundException {
//        BufferedReader br = null;
//        try {
//            if (Files.exists(Paths.get(QUARTZ_EVENTS_LOGS_FILE_PATH))) {
//                LOGGER.info("Quartz log file found.");
//            } else {
//                LOGGER.info("Quartz log file not found.");
//                return null;
//            }
//            br = new BufferedReader(new FileReader(QUARTZ_EVENTS_LOGS_FILE_PATH));
//            LocalDate startDate = LocalDate.parse(fromDate);
//            LocalDate endDate = LocalDate.parse(toDate);
//            LOGGER.info(successLog + " " + failureLog);
//            if(successLog == true && failureLog == false){
//                return successQuartzEventsLog(startDate, endDate, br);
//            } else if(successLog == false && failureLog == true){
//                return failQuartzEventsLog(startDate, endDate, br);
//            } else {
//                return quartzEventsLog(startDate, endDate, br);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//}
//
//
//
//
//
//
//
//
//
//package com.cloudera.cpx.server.api.repositories;
//
//        import org.junit.Assert;
//        import org.junit.Before;
//        import org.junit.Test;
//        import org.junit.runner.RunWith;
//        import org.powermock.core.classloader.annotations.PrepareForTest;
//        import org.powermock.modules.junit4.PowerMockRunner;
//
//        import java.io.BufferedReader;
//
//        import java.io.FileNotFoundException;
//        import java.io.FileReader;
//        import java.io.IOException;
//        import java.time.LocalDate;
//        import java.util.LinkedList;
//        import java.util.List;
//
//@RunWith(PowerMockRunner.class)
//@PrepareForTest({LogParsingRepository.class})
//
//public class LogParsingRepositoryTest {
//    private LogParsingRepository repository;
//
//    private static final String QUARTZ_EVENTS_LOG_FILE_TEST = "src/test/data/quartzEventTest.log";
//
//    @Before
//    public void setup() throws Exception {
//        repository = new LogParsingRepository();
//    }
//
//    @Test
//    public void testSuccessQuartzEventsLog() throws IOException {
//        LocalDate fromDate = LocalDate.of(2021, 10, 06);
//        LocalDate toDate = LocalDate.of(2021, 10, 07);
//        BufferedReader br = new BufferedReader(new FileReader(QUARTZ_EVENTS_LOG_FILE_TEST));
//        List<String> parsedLog = new LinkedList<>();
//        parsedLog.add("INFO    2021-10-06 16:06:19,690 [main] quartzEventLogger  - Scheduling rule 'test' executed successfully. Applied property configuration 'test'.");
//        parsedLog.add("INFO    2021-10-06 16:40:31,422 [main] quartzEventLogger  - Scheduling rule 'test' executed successfully. Applied property configuration 'test'.");
//        parsedLog.add("INFO    2021-10-07 17:04:17,631 [main] quartzEventLogger  - Scheduling rule 'test' executed successfully. Applied property configuration 'test'.");
//        List<String> expectedParsedLog = repository.successQuartzEventsLog(fromDate, toDate, br);
//        Assert.assertEquals(expectedParsedLog, parsedLog);
//    }
//
//    @Test
//    public void testSuccessQuartzEventsLogEmpty() throws IOException {
//        LocalDate fromDate = LocalDate.of(2021, 06, 06);
//        LocalDate toDate = LocalDate.of(2021, 07, 07);
//        BufferedReader br = new BufferedReader(new FileReader(QUARTZ_EVENTS_LOG_FILE_TEST));
//        List<String> expectedParsedLog = repository.successQuartzEventsLog(fromDate, toDate, br);
//        List<String> parsedLog = new LinkedList<>();
//        Assert.assertEquals(expectedParsedLog, parsedLog);
//    }
//
//    @Test
//    public void testFailedQuartzEventsLog() throws IOException {
//        LocalDate fromDate = LocalDate.of(2021, 10, 07);
//        LocalDate toDate = LocalDate.of(2021, 10, 10);
//        BufferedReader br = new BufferedReader(new FileReader(QUARTZ_EVENTS_LOG_FILE_TEST));
//        List<String> parsedLog = new LinkedList<>();
//        parsedLog.add("ERROR   2021-10-07 17:04:17,609 [main] quartzEventLogger  - Execution of scheduling rule failed for 'test'. Error: Error saving new config");
//        parsedLog.add("ERROR   2021-10-07 17:08:42,466 [main] quartzEventLogger  - Execution of scheduling rule failed for 'test'. Error: Property Config 'test' does not exist.");
//        parsedLog.add("ERROR   2021-10-07 17:08:42,470 [main] quartzEventLogger  - Execution of scheduling rule failed for 'test'. Error: CsConnector Error");
//        List<String> expectedParsedLog =  repository.failQuartzEventsLog(fromDate, toDate, br);
//        Assert.assertEquals(expectedParsedLog, parsedLog);
//    }
//
//    @Test
//    public void testFailedQuartzEventsLogEmpty() throws IOException {
//        LocalDate fromDate = LocalDate.of(2021, 07, 07);
//        LocalDate toDate = LocalDate.of(2021, 07, 10);
//        BufferedReader br = new BufferedReader(new FileReader(QUARTZ_EVENTS_LOG_FILE_TEST));
//        List<String> expectedParsedLog = repository.failQuartzEventsLog(fromDate, toDate, br);
//        List<String> parsedLog = new LinkedList<>();
//        Assert.assertEquals(expectedParsedLog, parsedLog);
//    }
//
//    @Test
//    public void testQuartzEventsLog() throws IOException {
//        LocalDate fromDate = LocalDate.of(2021, 10, 07);
//        LocalDate toDate = LocalDate.of(2021, 10, 10);
//        BufferedReader br = new BufferedReader(new FileReader(QUARTZ_EVENTS_LOG_FILE_TEST));
//        List<String> parsedLog = new LinkedList<>();
//        parsedLog.add("ERROR   2021-10-07 17:04:17,609 [main] quartzEventLogger  - Execution of scheduling rule failed for 'test'. Error: Error saving new config");
//        parsedLog.add("INFO    2021-10-07 17:04:17,631 [main] quartzEventLogger  - Scheduling rule 'test' executed successfully. Applied property configuration 'test'.");
//        parsedLog.add("ERROR   2021-10-07 17:08:42,466 [main] quartzEventLogger  - Execution of scheduling rule failed for 'test'. Error: Property Config 'test' does not exist.");
//        parsedLog.add("ERROR   2021-10-07 17:08:42,470 [main] quartzEventLogger  - Execution of scheduling rule failed for 'test'. Error: CsConnector Error");
//        List<String> expectedParsedLog = repository.quartzEventsLog(fromDate, toDate, br);
//        Assert.assertEquals(expectedParsedLog, parsedLog);
//    }
//
//    @Test
//    public void testQuartzEventsLogEmpty() throws IOException {
//        LocalDate fromDate = LocalDate.of(2021, 07, 07);
//        LocalDate toDate = LocalDate.of(2021, 07, 10);
//        BufferedReader br = new BufferedReader(new FileReader(QUARTZ_EVENTS_LOG_FILE_TEST));
//        List<String> expectedParsedLog = repository.quartzEventsLog(fromDate, toDate, br);
//        List<String> parsedLog = new LinkedList<>();
//        Assert.assertEquals(expectedParsedLog, parsedLog);
//    }
//
//    @Test
//    public void testGetQuartzLogParsed() throws FileNotFoundException {
//        List<String> logParsed = repository.getQuartzLogParsed(true, true, "2021-10-07", "2021-10-07");
//        Assert.assertEquals(logParsed, null);
//    }
//
//}
//
//
//
//
//package com.cloudera.cpx.server.api.services;
//
//        import com.cloudera.cpx.server.api.repositories.LogParsingRepository;
//        import com.cloudera.cpx.server.api.responses.RevalidationResponse;
//        import com.cloudera.cpx.server.api.utils.ResponseStatus;
//        import io.swagger.annotations.ApiResponse;
//        import io.swagger.annotations.ApiResponses;
//        import org.apache.log4j.Logger;
//
//        import javax.ws.rs.GET;
//        import javax.ws.rs.Path;
//        import javax.ws.rs.Produces;
//        import javax.ws.rs.QueryParam;
//        import javax.ws.rs.core.Context;
//        import javax.ws.rs.core.HttpHeaders;
//        import javax.ws.rs.core.MediaType;
//        import javax.ws.rs.core.Response;
//        import javax.ws.rs.core.UriInfo;
//        import java.io.FileNotFoundException;
//        import java.util.concurrent.locks.Lock;
//        import java.util.concurrent.locks.ReadWriteLock;
//        import java.util.concurrent.locks.ReentrantReadWriteLock;
//
//@Path("logs")
//public class LogService extends BaseService {
//
//    private static final Logger LOGGER = Logger.getLogger(LogService.class.getName());
//    private static final LogParsingRepository repository = LogParsingRepository.getInstance();
//    private static final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
//    private static final Lock readLock = readWriteLock.readLock();
//
//    /**
//     * API to get parsed quartz log
//     * @param body
//     * @param headers
//     * @param ui
//     * @return
//     */
//    @GET
//    @Path("/quartzLogParsing")
//    @Produces(MediaType.APPLICATION_JSON)
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Successfully returned parsed log.", response = RevalidationResponse.class)
//    })
//    public Response getQuartzLogParsed(String body, @Context HttpHeaders headers, @Context UriInfo ui,
//                                       @QueryParam("successLog") boolean successLog, @QueryParam("failureLog") boolean failureLog,
//                                       @QueryParam("fromDate") String fromDate, @QueryParam("toDate") String toDate) {
//        LOGGER.info("Received getQuartzLogParsed request: url = " + ui.getRequestUri().toString());
//        readLock.lock();
//        try {
//            return handleRequest(repository.getQuartzLogParsed(successLog, failureLog, fromDate, toDate));
//        } catch (FileNotFoundException e) {
//            return handleRequest(new ResponseStatus(400, e.getMessage()));
//        } finally {
//            readLock.unlock();
//        }
//    }
//}
//
//
//
//package com.cloudera.cpx.server.api.repositories;
//
//        import org.apache.log4j.Logger;
//
//        import java.io.BufferedReader;
//        import java.io.FileNotFoundException;
//        import java.io.FileReader;
//        import java.io.IOException;
//        import java.nio.file.Files;
//        import java.nio.file.Paths;
//        import java.time.LocalDate;
//        import java.util.Arrays;
//        import java.util.LinkedList;
//        import java.util.List;
//
//public class LogParsingRepository {
//
//    private static final String QUARTZ_EVENTS_LOGS_FILE_PATH = "/var/log/yarn/queuemanager/quartz-execution.log";
//    private static final Logger LOGGER = Logger.getLogger(LogParsingRepository.class.getName());
//    private static LogParsingRepository instance;
//
//    public static LogParsingRepository getInstance() {
//        if (instance == null) {
//            synchronized (LogParsingRepository.class) {
//                if (instance == null) {
//                    instance = new LogParsingRepository();
//                }
//            }
//        }
//        return instance;
//    }
//
//    public List<String> successQuartzEventsLog(LocalDate fromDate, LocalDate toDate, BufferedReader br) throws IOException {
//        String line = br.readLine();
//        List<String> parsedLog = new LinkedList<>();
//        LOGGER.info("Extracting success quartz events logs from " + fromDate.toString() + " to " + toDate.toString());
//        while (line != null) {
//            String[] splitStr = line.split("\\s+");
//            LocalDate date = LocalDate.parse(splitStr[1]);
//            if ((date.isAfter(fromDate) && date.isBefore(toDate) || (date.isEqual(fromDate)) || (date.isEqual(toDate)))) {
//                boolean containsExecuted = Arrays.asList(splitStr).contains("executed");
//                boolean containsINFO = Arrays.asList(splitStr).contains("INFO");
//                if (containsINFO == true && containsExecuted == true) {
//                    parsedLog.add(line);
//                }
//            }
//            line = br.readLine();
//        }
//        return parsedLog;
//    }
//
//    public List<String> failQuartzEventsLog(LocalDate fromDate, LocalDate toDate, BufferedReader br) throws IOException {
//        String line = br.readLine();
//        List<String> parsedLog = new LinkedList<>();
//        LOGGER.info("Extracting failed quartz events logs from " + fromDate.toString() + " to " + toDate.toString());
//        while (line != null) {
//            String[] splitStr = line.split("\\s+");
//            LocalDate date = LocalDate.parse(splitStr[1]);
//            if ((date.isAfter(fromDate) && date.isBefore(toDate) || (date.isEqual(fromDate)) || (date.isEqual(toDate)))) {
//                boolean containsFailed = Arrays.asList(splitStr).contains("failed");
//                boolean containsERROR = Arrays.asList(splitStr).contains("ERROR");
//                if (containsERROR == true && containsFailed == true){
//                    parsedLog.add(line);
//                }
//            }
//            line = br.readLine();
//        }
//        return parsedLog;
//    }
//
//    public List<String> quartzEventsLog(LocalDate fromDate, LocalDate toDate, BufferedReader br) throws IOException {
//        String line = br.readLine();
//        List<String> parsedLog = new LinkedList<>();
//        LOGGER.info("Extracting complete quartz events logs from " + fromDate.toString() + " to " + toDate.toString());
//        while (line != null) {
//            String[] splitStr = line.split("\\s+");
//            LocalDate date = LocalDate.parse(splitStr[1]);
//            if ((date.isAfter(fromDate) && date.isBefore(toDate) || (date.isEqual(fromDate)) || (date.isEqual(toDate)))) {
//                parsedLog.add(line);
//            }
//            line = br.readLine();
//        }
//        return parsedLog;
//    }
//
//    public List<String> getQuartzLogParsed(boolean successLog, boolean failureLog, String fromDate, String toDate) throws FileNotFoundException {
//        BufferedReader br = null;
//        try {
//            if (Files.exists(Paths.get(QUARTZ_EVENTS_LOGS_FILE_PATH))) {
//                LOGGER.info("Quartz event log file found : " + QUARTZ_EVENTS_LOGS_FILE_PATH);
//            } else {
//                LOGGER.warn("Quartz event log file not found : " + QUARTZ_EVENTS_LOGS_FILE_PATH);
//                return null;
//            }
//            br = new BufferedReader(new FileReader(QUARTZ_EVENTS_LOGS_FILE_PATH));
//            LocalDate startDate = LocalDate.parse(fromDate);
//            LocalDate endDate = LocalDate.parse(toDate);
//
//            if (successLog == true && failureLog == false) {
//                return successQuartzEventsLog(startDate, endDate, br);
//            } else if (successLog == false && failureLog == true) {
//                return failQuartzEventsLog(startDate, endDate, br);
//            } else {
//                return quartzEventsLog(startDate, endDate, br);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//}
//
//
//
