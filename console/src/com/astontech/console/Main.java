package com.astontech.console;


import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.*;
import java.util.Date;
import com.astontech.bo.*;
import com.astontech.bo.interfaces.*;
import com.astontech.dao.*;
import com.astontech.dao.mysql.*;
import common.helpers.MathHelper;
import common.helpers.StringHelper;
import org.apache.log4j.Logger;



public class Main {

    final static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        //notes:    private static method for the lesson
        Integer number1 = 5;
        Integer number2 = 5;
        Integer number3 = 128;
        Integer number4 = 128;

        System.out.println(number1.equals(number2));
        System.out.println(number3.equals(number4));
        System.out.println(new Integer(1).equals(new Integer(1)));


    }

    private static void LessonRecursionComplex(File dir){
        try {
            File[] files = dir.listFiles();
            for(File file : files) {
                if(file.isDirectory()){
                    //notes: recursion here
                    logger.info("directory: " + file.getCanonicalPath());
                    LessonRecursionComplex(file);
                }else {
                    logger.info("     file: " + file.getCanonicalPath());
                }
            }
        } catch (IOException ioEx){
            logger.error(ioEx);
        }
    }
    private static void LessonRecursion(int recursionCount){
        logger.info("Recursive count = " + recursionCount);
        if(recursionCount > 0)
            LessonRecursion(recursionCount - 1);
    }
    private static void LessonDeserialization(){
        Person person = null;
        try {
            FileInputStream fileIn = new FileInputStream("./ser_person.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            person = (Person) in.readObject();
            in.close();
            fileIn.close();

        } catch (FileNotFoundException fnfEx) {
            logger.error(fnfEx);
        } catch (IOException ioEx) {
            logger.error(ioEx);
        } catch (ClassNotFoundException cnfEx){
            logger.error(cnfEx);
        }

        logger.info("Deserialized Object: " + person.toString());
    }
    private static void LessonSerialization(){
        //notes: get an object from database
        PersonDAO personDAO = new PersonDAOImpl();
        Person person = personDAO.getPersonById(1);
        //notes: serialize to txt file
        try {
            FileOutputStream fileOut = new FileOutputStream("./ser_person.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(person);
            out.close();
            fileOut.close();
            logger.info("Object Serialized and Written to file: ./ser_person.txt");
            logger.info("Serialized Object: " + person.toString());
        } catch (IOException ioEx) {
            logger.error(ioEx);
        }

    }
    private static void LessonBoxUnboxCast(){
        //notes:  act of converting a value type to a reference type  -- boxing
        //notes:  act of converting a reference type to a value type  -- unboxing

        //notes: boxing
        int x = 10;
        Object o = x;
        LessonReflectionAndGenerics(o.getClass());

        //notes: unboxing
        int y = (int) o; //casting (explicit)
        logger.info(y);

        int i = 100;  //casting (Implicit)
        double d = i;

        double db = 1.92;
        int in = (int) db; //precision lost

        //notes:    explicit casting

    }
    private static <T> void LessonReflectionAndGenerics(Class<T> genericClass) {

        Class obj = genericClass;

        logger.info("Full Name: " + obj.getName());
        logger.info("Simple Name: " + obj.getSimpleName());
        for(Field field : obj.getDeclaredFields()) {
            logger.info("Field: " + field.getName() + " - Type: " + field.getType());
        }
        for(Method method : obj.getDeclaredMethods()) {
            logger.info("Method: " + method.getName());
        }
    }
    private static void LessonDAOCRUDLAB() {

        VehicleModelDAO vehicleModelDAO = new VehicleModelDAOImpl();

        //region INSERT VEHICLE MODEL
        /*
        VehicleModel vehicleModel = new VehicleModel();
        vehicleModel.setVehicleModelName("Charger");
        vehicleModel.setVehicleMakeId(5);
        int id = vehicleModelDAO.insertVehicleModel(vehicleModel);

        System.out.println("New Vehicle Model Added with ID = " + id);
        */
        //endregion

        //region UPDATE VEHICLE MODEL
        /*
        VehicleModel vehicleModel = vehicleModelDAO.getVehicleModelById(11);
        vehicleModel.setVehicleModelName("Mustang");
        if(vehicleModelDAO.updateVehicleModel(vehicleModel))
            logger.info("Vehicle Model Updated!");
        else
            logger.info("Vehicle Model Not Updated!");
        */
        //endregion

        //region DELETE VEHICLE MODEL
        /*
        if(vehicleModelDAO.deleteVehicleModel(11))
            logger.info("Vehicle Model Deleted!");
        else
            logger.info("Vehicle Model Not Deleted!");
        */

        //endregion

        VehicleMakeDAO vehicleMakeDAO = new VehicleMakeDAOImpl();

        //region INSERT VEHICLE MAKE
        /*
        VehicleMake vehicleMake = new VehicleMake();
        vehicleMake.setVehicleName("BMW");
        vehicleMake.setCreateDate(new Date());
        int id = vehicleMakeDAO.insertVehicleMake(vehicleMake);

        System.out.println("New Vehicle Make Added with ID = " + id);
        */
        //endregion

        //region UPDATE VEHICLE MAKE
        /*

        VehicleMake vehicleMake = vehicleMakeDAO.getVehicleMakeById(6);
        vehicleMake.setVehicleName("Dodge");
        if(vehicleMakeDAO.updateVehicleMake(vehicleMake))
            logger.info("Vehicle Updated!");
        else
            logger.info("Vehicle Not Updated!");

        */
        //endregion

        //region DELETE VEHICLE MAKE
        /*
        if(vehicleMakeDAO.deleteVehicleMake(5))
            logger.info("Vehicle Make Deleted!");
        else
            logger.info("Vehicle Make Not Deleted!");
        */
        //endregion

        EmailDAO emailDAO = new EmailDAOImpl();

        //region INSERT EMAIL
        /*

        Email email = new Email();
        email.setEmailAddress("email@email.com");
        email.setEmployeeId(4);
        email.setEntityTypeId(2);
        int id = emailDAO.insertEmail(email);
        System.out.println("New Email Added with ID = " + id);

        */
        //endregion

        //region UPDATE EMAIL
        /*

        Email email = emailDAO.getEmailById(5);
        email.setEmailAddress("Dmail@email.com");

        if(emailDAO.updateEmail(email))
            logger.info("Email Updated!");
        else
            logger.info("Email Not Updated");

        */
        //endregion

        //region DELETE EMAIL
        /*
        if(emailDAO.deleteEmail(5))
            logger.info("Email Deleted!");
        else
            logger.info("Email Not Deleted");
        */
        //endregion

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();

        //region INSERT EMPLOYEE

        /*
        Employee employee = new Employee();
        employee.setHireDate(new Date());
        employee.setTermDate(new Date());
        employee.setBirthDate(new Date());
        employee.setPersonId(13);
        employee.setCreateDate(new Date());
        int id = employeeDAO.insertEmployee(employee);
        System.out.println("New Employee Added with ID = " + id);
        */

        //endregion

        //region UPDATE EMPLOYEE

        /*
        Employee employee = employeeDAO.getEmployeeById(6);
        employee.setPersonId(10);
        if(employeeDAO.updateEmployee(employee))
            logger.info("Employee Updated");
        else
            logger.info("Employee Not Updated!");
        */

        //endregion

        //region DELETE EMPLOYEE
        /*

        if(employeeDAO.deleteEmployee(6))
            logger.info("Employee Deleted!");
        else
            logger.info("Employee Not Deleted");

        */
        //endregion

        PhoneDAO phoneDAO = new PhoneDAOImpl();

        //region INSERT PHONE
        /*
        Phone phone = new Phone();
        phone.setEntityTypeId(3);
        phone.setClientId(3);
        phone.setPersonId(5);
        phone.setAreaCode(123);
        phone.setPhoneNumber(1938293);
        phone.setPhoneNumberPost(1);

        int id = phoneDAO.insertPhone(phone);
        System.out.println("New Phone Added with ID = " + id);
        */
        //endregion

        //region UPDATE PHONE
        /*
        Phone phone = phoneDAO.getPhoneById(9);
        phone.setEntityTypeId(4);
        if(phoneDAO.updatePhone(phone))
            logger.info("Phone Updated!");
        else
            logger.info("Phone Not Updated!");
        */
        //endregion

        //region DELETE PHONE
        /*
        if(phoneDAO.deletePhone(9))
            logger.info("Phone Deleted!");
        else
            logger.info("Phone Not Deleted!");
        */
        //endregion

        VehicleDAO vehicleDAO = new VehicleDAOImpl();

        //region INSERT VEHICLE
        /*
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleId(11);
        vehicle.setYear(1234);
        vehicle.setLicensePlate("223PPO");
        vehicle.setVin("F775664837365");
        vehicle.setColor("Black");
        vehicle.setIsPurchase(true);
        vehicle.setPurchasePrice(32000);
        vehicle.setPurchaseDate(new Date());
        vehicle.setVehicleModelId(4);

        int id = vehicleDAO.insertVehicle(vehicle);
        logger.info("New Vehicle inserted with Id = " + id);
        */
        //endregion

        //region UPDATE VEHICLE
        /*
        Vehicle vehicle = vehicleDAO.getVehicleById(11);
        vehicle.setColor("Blue");
        if(vehicleDAO.updateVehicle(vehicle))
            logger.info("Vehicle Updated!");
        else
            logger.info("Vehicle Not Updated!");
        */
        //endregion

        //region DELETE VEHICLE
        /*
        if(vehicleDAO.deleteVehicle(11))
            logger.info("Vehicle Deleted!");
        else
            logger.info("Vehicle Not Deleted!");
        */
        //endregion
    }
    private static void LessonDAODelete(){
        PersonDAO personDAO = new PersonDAOImpl();
        if(personDAO.deletePerson(13))
            logger.info("Person Deleted!");
        else
            logger.info("Person Not Deleted!");
    }
    private static void LessonDAOUpdate(){
        PersonDAO personDAO = new PersonDAOImpl();

        Person person = personDAO.getPersonById(11);
        person.setMiddleName("Updated");

        if(personDAO.updatePerson(person))
            logger.info("Person Updated!");
        else
            logger.info("Person Not Updated!");

    }
    private static void LessonDAOInsert(){
        Person person = new Person();
        person.setTitle("Mr.");
        person.setFirstName("Tony");
        person.setMiddleName("IronMan");
        person.setLastName("Stark");
        person.setBirthDate(new Date());
        person.setCreateDate(new Date());
        person.setSSN("123-23-1234");
        person.setDisplayFirstName("Avenger");
        person.setIsDeleted(false);
        person.setGender("M");

        PersonDAO personDAO = new PersonDAOImpl();
        int id = personDAO.insertPerson(person);

        logger.info("New Person Record Created With ID = " + id);
    }
    private static void LessonDAOLAB(){
     //region CREATE MENU
        PhoneDAO phoneDAO = new PhoneDAOImpl();
        EmailDAO emailDAO = new EmailDAOImpl();
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        PersonDAO personDAO = new PersonDAOImpl();

        List<Employee> employeeList = employeeDAO.getEmployeeList();
        List<Phone> phoneList = phoneDAO.getPhoneList();
        List<Email> emailList = emailDAO.getEmailList();

        System.out.println("========================");
        for (Employee employee : employeeList){
            System.out.println(employee.getEmployeeId() + ") " + personDAO.getPersonById(employeeDAO.getEmployeeById(employee.getEmployeeId()).getPersonId()).getFirstName() + " " + personDAO.getPersonById(employeeDAO.getEmployeeById(employee.getEmployeeId()).getPersonId()).getLastName() );
        }
        System.out.println("========================");
     //endregion

     //region PROMPT USER
        Scanner reader = new Scanner(System.in);
        System.out.println("Please Select An Employee...");
        String employeeId = reader.nextLine();
     //endregion

     //region GET DATA

        Employee employeeDetail = employeeDAO.getEmployeeById( Integer.parseInt(employeeId) );
        Person personDetail = personDAO.getPersonById(employeeDetail.getPersonId());
        //Display Employee Info
        System.out.println("------ Employee Information ------");
        System.out.println("Name: " + personDetail.getTitle() + " " + personDetail.getFirstName() + " " + personDetail.getMiddleName() + " " + personDetail.getLastName());
        System.out.println("Hired: " + employeeDetail.getHireDate());
        //Display Phone Numbers
        List<Phone> phoneDetailList = new ArrayList<>();
        for(Phone phone : phoneList) {
            if(phone.getPersonId() == personDetail.getPersonId())
            {
                phoneDetailList.add(phoneDAO.getPhoneById( phone.getPhoneId() ));
            }
        }
        System.out.print("Phone Number(s): ");
        for(Phone phone : phoneDetailList) {
            System.out.print(phone.getFullPhoneNumber() + " | ");
        }
        //Display Email Addresses
        System.out.println();
        List<Email> emailDetailList = new ArrayList<>();
        for(Email email : emailList) {
            if(email.getEmployeeId() == employeeDetail.getEmployeeId())
            {
                emailDetailList.add(emailDAO.getEmailById( email.getEmailId()));
            }
        }
        System.out.print("Email Address(es): ");
        for(Email email : emailDetailList) {
            System.out.print(email.getEmailAddress() + " | ");
        }
        System.out.println();
        System.out.println();
     //endregion


        //region create menu

        VehicleDAO vehicleDAO = new VehicleDAOImpl();
        VehicleModelDAO vehicleModelDAO = new VehicleModelDAOImpl();
        VehicleMakeDAO vehicleMakeDAO = new VehicleMakeDAOImpl();

        List<Vehicle> vehicleList = vehicleDAO.getVehicleList();

        System.out.println("=======================");
        for (Vehicle vehicle : vehicleList){
            System.out.println(vehicle.getVehicleId() + ") License Plate: " + vehicle.getLicensePlate());
        }
        System.out.println("=======================");
        //endregion

        //region prompt user
        Scanner reader2 = new Scanner(System.in);
        System.out.println("Please Select A Vehicle From List...");
        String vehicleId = reader2.nextLine();
        //endregion

        //region output data
        Vehicle vehicleDetail = vehicleDAO.getVehicleById(Integer.parseInt(vehicleId));
        VehicleModel vehicleModelDetail = vehicleModelDAO.getVehicleModelById(vehicleDetail.getVehicleModelId());
        VehicleMake vehicleMakeDetail = vehicleMakeDAO.getVehicleMakeById(vehicleModelDetail.getVehicleMakeId());
        System.out.println("----- VEHICLE DETAILS -----");
        System.out.println("Year: " + vehicleDetail.getYear());
        System.out.println("Make: " + vehicleMakeDetail.getVehicleName());
        System.out.println("Model: " + vehicleModelDetail.getVehicleModelName());
        System.out.println("VIN: " + vehicleDetail.getVin());

        //endregion

    }
    private static void LessonDAO(){
        //region CREATE MENU
        PersonDAO personDAO = new PersonDAOImpl();  //amend later
        List<Person> personList = personDAO.getPersonList();

        System.out.println("======================");
        // 1| Butala, Bipin
        for (Person person : personList){
            System.out.println(person.getPersonId() + "| " + person.getLastName() + ", " + person.getFirstName());
        }

        System.out.println("======================");
        //endregion

        //region PROMPT USER
        Scanner reader = new Scanner(System.in);
        System.out.println("Please Select A Person From List: ");
        String personId = reader.nextLine();
        //endregion

        //region GET DATA
        Person personDetail = personDAO.getPersonById(Integer.parseInt(personId));
        System.out.println("----- PERSON DETAILS -----");
        System.out.println("Full Name: " + personDetail.getFullName());
        System.out.println("D.O.B.: " + personDetail.getBirthDate());
        System.out.println("S.S.N.: " + personDetail.getSSN());
        //endregion
    }
    private static void LessonExecuteMSSQLQuery(){
        Connection MSSQLSConn = LessonMSSQLConnection();
        try {
            Statement statement = MSSQLSConn.createStatement();
            String sql = "select\ta.Year,\n" +
                    "\t\tc.VehicleMakeName as [Make],\n" +
                    "\t\tb.VehicleModelName as [Model]\n" +
                    "\t\t\n" +
                    "from\t\tdbo.Vehicle a\n" +
                    "inner join\tdbo.VehicleModel b on a.VehicleModelId = b.VehicleModelId\n" +
                    "inner join\tdbo.VehicleMake c on b.VehicleMakeId = c.VehicleMakeId\n" +
                    "order by\ta.Year";

            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                int year = rs.getInt(1);
                String make = rs.getString(2);
                String model = rs.getString(3);

                logger.info(year + " " + make + " " + model);
            }
            MSSQLSConn.close();

        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }
    }
    private static Connection LessonMSSQLConnection(){
        String dbHost = "localhost";
        String intSec = "true";
        String dbName = "AstonEngineer";
        String dbPort = "1433";

        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            logger.error("MSQL Server Driver not found! " + ex);
            return null;
        }


        logger.info("MSSQL Server Driver Registered.");
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:sqlserver://" + dbHost + ":" + dbPort + ";databaseName=" + dbName + ";integratedSecurity=" + intSec);
        } catch (SQLException ex) {
            logger.error("Connection failed!" + ex);
            return null;
        }

        if(connection != null) {
            logger.info("Successfully connected to MSSQL Server database");
            return connection;
        } else {
            logger.info("Connection failed!");
            return null;
        }
    }
    private static void LessonGetStoredProcedure(){
        Connection conn = LessonDBConnection();
        try{
            String sp = "{call GetPerson(?,?)}";
            CallableStatement cStmt = conn.prepareCall(sp);

            cStmt.setInt(1, 20);
            cStmt.setInt(2, 1);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()){
                logger.info(rs.getString(1) + ": " + rs.getString(2) + ": " + rs.getString(3) + ": " + rs.getString(4) + ": " + rs.getString(5));
            }

        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }
    }
    private static void LessonExecuteQuery(){
        Connection conn = LessonDBConnection();
        try {
            Statement statement = conn.createStatement();
            String sql = "select PersonId, FirstName, LastName from person";

            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                int personId = rs.getInt(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);

                logger.info(personId + ": First Name: " + firstName + " - Last Name: " + lastName);
            }
            conn.close();

        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }
    }
    private static Connection LessonDBConnection(){

        String dbHost = "localhost";
        String dbName = "astonengineer";
        String dbUser = "consoleUser";
        String dbPass = "qwe123$!";
        String useSSL = "false";
        String procBod = "true";

        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            logger.error("MySQL Driver not found! " + ex);
            return null;
        }

        logger.info("MySQL Driver Registered.");
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://" + dbHost + ":3306/" + dbName + "?useSSL=" + useSSL + "&noAccessToProcedureBodies=" + procBod, dbUser, dbPass);
        } catch (SQLException ex) {
            logger.error("Connection failed!" + ex);
            return null;
        }

        if(connection != null) {
            logger.info("Successfully connected to MySQL database");
            return connection;
        } else {
            logger.info("Connection failed!");
            return null;
        }
    }
    private static void LessonInterfacesComparable2(){
        Person ThisGuy = new Person("Mr.", "This", "Guy", 3);
        Person ThatGuy = new Person("Mr.", "That", "Guy", 6);
        System.out.println(ThisGuy.compareTo(ThatGuy));
        if(ThisGuy.compareTo(ThatGuy) < 0)
            System.out.println("This Guy has been here longer than That Guy");
        else if(ThisGuy.compareTo(ThatGuy) > 0)
            System.out.println("This Guy has not been here longer than That Guy");
        else
            System.out.println("These Guys have been here the same amount of time");

        Vehicle ThisCar = new Vehicle(3, 1999, "F234295837485");
        Vehicle ThatCar = new Vehicle(4, 2001, "C293840274657");
        System.out.println(ThisCar.compareTo(ThatCar));
        if(ThisCar.compareTo(ThatCar) < 0)
            System.out.println("This Car is older than That Car");
        else if(ThisCar.compareTo(ThatCar) > 0)
            System.out.println("This Car is newer than That Car");
        else
            System.out.println("These Cars are the same age");

    }
    private static void LessonInterfacesChar2Lab(){
        Monologue Racecar = new Monologue("Racecar");
        LessonInterfacesCharLab(Racecar);

    }
    private static void LessonInterfacesCharLab(CharSequence Imono){
        System.out.println(
                ("This string returned backwards is: ") + Imono.subSequence(0, Imono.length())
        );
    }
    private static void LessonInterfacesLabHelper(){
        Car Fusion = new Car(4, 5, 35, "Ford Fusion Sedan");
        Truck Mack = new Truck(18, 2, 10, "Mack Truck");
        Bus Greyhound = new Bus(4, 24, 15, "Greyhound Bus");

        LessonInterfacesLab(Fusion);
        System.out.println();
        LessonInterfacesLab(Mack);
        System.out.println();
        LessonInterfacesLab(Greyhound);
    }
    private static void LessonInterfacesLab(IVehicle Ivehicle){
        System.out.println(("Does this vehicle get good mileage?: ") + Ivehicle.getsGoodGasMileage());
        System.out.println(("How many wheels does this vehicle have?: ") + Ivehicle.numberOfWheels());
        System.out.println(("How many passengers fit in this vehicle?: ") + Ivehicle.maxPassengers());
        System.out.println(("What is this vehicle called?: ") + Ivehicle.vehicleName());
    }
    private static void LessonTesting() {
        System.out.println(MathHelper.simpleroot(25));
        System.out.println(MathHelper.cube(5));
        System.out.println(MathHelper.absval(-5));

        System.out.println(StringHelper.wordCount("How many words are in this string?"));
        System.out.println(StringHelper.hyphenAllChars("AE83UY7EI7FJ94Z"));
        System.out.println(StringHelper.underscoreSpaces("This is text separated by underscores."));
    }
    private static void LessonLogging() {
        //notes:    levels of logging
        logger.debug("This is a DEBUG log message");
        logger.info("This is an INFO log message");
        logger.warn("This is a WARN log message");
        logger.error("This is an ERROR log message");
        logger.fatal("This is a FATAL log message");
    }
    private static void LessonInterfacesTest() {

        Site MN010 = new Site(1,6,8,36,2,"MN010");

        Home BipsHouse = new Home("1 Main St.", new Employee("Bipin", "Butala"));

        LessonInterfaces(MN010);

        LessonInterfaces(BipsHouse);

    }
    private static void LessonInterfaces(ILocation Ilocation){
        System.out.println("================");
        System.out.println("Location Name: " + Ilocation.getLocationName());
        System.out.println("Can Have Meetings: " + Ilocation.canHaveMeetings());
        System.out.println("Number of Workspaces: " + Ilocation.numberOfWorkspaces());
        System.out.println("Has Coffee: " + Ilocation.hasCoffee());

    }
    private static void LessonHashLAB(){
        // Static vs Instance:  Static and Instance are two qualities of methods, Static must be specified, where instance is implied without the keyword Instance
        //                      A static method will always be executed the same way, without having to create an instance of the method
        // EXAMPLE STATIC:      public static boolean isNullOrEmpty(String s) {return s == null || s.length() == 0;}
        //                      Here, "isNullOrEmpty" may be called without creating a new isNullOrEmpty instantiation
        // EXAMPLE INSTANCE:    public Vehicle(int vehicleId, int year, String vin){this.setVehicleId(vehicleId);this.setYear(year);this.setVin(vin);}
        //                      Here, in order to use the Vehicle() method, a unique instance of the Vehicle() method must be established, such as...
        //                      Vehicle veh1 = new Vehicle(5, 1992, "F123234234543");
        // Reference vs Value   Reference and Value are both data types.  Value types consist of only primitive data types (byte, boolean, char, int, long, short, float, and double)
        //                      A reference type is a pointer to another piece of data, therefore if the original piece of data is updated, the reference will update as well, unlike
        //                      value types.
        // EXAMPLE VALUE:       boolean hasASickRide = true;
        //                      boolean isAwesome = hasASickRide;
        //                      hasASickRide = false;
        //                      In the above example, printing the boolean "isAwesome" will always return "true" because "hasASickRide" was true when "isAwesome" received its value.
        // EXAMPLE REFERENCE:   Vehicle sickRide = new Vehicle();
        //                      sickRide.setYear("2010");
        //                      Vehicle notSoSickRide = sickRide;
        //                      notSoSickRide.setYear("1995");
        //                      In the above example, printing sickRide.GetYear() will return "1995" because they are referential, and the last value passed in to either object
        //                      was 1995
        // HashTable, HashMap, HashSet
        Hashtable<Integer, String> funnyHT = new Hashtable<>();
            funnyHT.put(1, "Whoopie Cushion");
            funnyHT.put(2, "Rubber Chicken");
            funnyHT.put(3, "Snake In A Can");
            funnyHT.put(4, "Aaron's Face");
            funnyHT.put(5, "Slack/Random");

        HashMap<Integer, String> funnyHM = new HashMap<>();
            funnyHM.put(1, "Whoopie Cushion");
            funnyHM.put(2, "Rubber Chicken");
            funnyHM.put(3, "Snake In A Can");
            funnyHM.put(4, "Aaron's Face");
            funnyHM.put(5, "Slack/Random");

        HashSet<String> funnyHS = new HashSet<>();
            funnyHS.add("Whoopie Cushion");
            funnyHS.add("Rubber Chicken");
            funnyHS.add("Snake In A Can");
            funnyHS.add("Aaron's Face");
            funnyHS.add("Slack/Random");

        for(Integer key : funnyHT.keySet()){
            System.out.println("key : " + key + " - value: " + funnyHT.get(key));
        }

        for(Integer key : funnyHM.keySet()){
            System.out.println("key : " + key + " - value: " + funnyHM.get(key));
        }

        for(String s : funnyHS){
            System.out.println("Value: " + s);
        }

    }
    private static void LessonValueVsRef() {
        //notes:    reference type
        Employee firstEmp = new Employee();
        firstEmp.setFirstName("Logan");

        Employee secondEmp = firstEmp;
        firstEmp.setFirstName("Dean");
        secondEmp.setFirstName("Bob");

        System.out.println(secondEmp.getFirstName());

        //notes:    value types

        int firstInt = 10;
        int secondInt = firstInt;

        firstInt = 20;

        System.out.println(secondInt);
    }
    private static void LessonHash() {
            //notes:    key-value pairs / value list

            //todo:     HashTable
            /*
                1) does NOT allow null for either key or value
                2) synchronized, thread safe, but performance is decreased
             */

            System.out.println("---HASH TABLE---");

            Hashtable<Integer, String> firstHashTable = new Hashtable<>();
            firstHashTable.put(1, "Inheritance");
            firstHashTable.put(2, "Polymorphism");
            firstHashTable.put(3, "Abstraction");
            firstHashTable.put(4, "Encapsulation");

            System.out.println("Value from given key: " + firstHashTable.get(3));

            for(Integer key : firstHashTable.keySet()){
                System.out.println("key : " + key + " - value: " + firstHashTable.get(key));
            }

            System.out.println("---------------");

            //todo      HashMap
            /*
                1) DOES allow null for either key or value
                2) un-synchronized, not thread safe, better performance
             */

            System.out.println("---HASH MAP----");

            HashMap<Integer, String> firstHashMap = new HashMap<>();
            firstHashMap.put(1, "Inheritance");
            firstHashMap.put(2, "Polymorphism");
            firstHashMap.put(3, "Abstraction");
            firstHashMap.put(4, "Encapsulation");
            firstHashMap.put(5, null);

            System.out.println("Value from given key: " + firstHashMap.get(3));

            for(Integer key : firstHashMap.keySet()){
                System.out.println("key : " + key + " - value: " + firstHashMap.get(key));
            }

            System.out.println("---------------");

            //todo:     HashSet
            /*
                1) built in mechanism for duplicates
                2) used for where you want to maintain a unique list
             */
            System.out.println("---HASH SET----");

            HashSet<String> oopPrinciples = new HashSet<>();
            oopPrinciples.add("Inheritance");
            oopPrinciples.add("Encapsulation");
            oopPrinciples.add("Polymorphism");
            oopPrinciples.add("Abstraction");
            oopPrinciples.add("Abstraction");

            if(oopPrinciples.contains("Encapsulation"))
                System.out.println("value exists");
            else
                System.out.println("value does not exist");

            for(String s : oopPrinciples) {
                System.out.println(s);
            }


        }
    private static void LessonPolymorphism(){
        //notes:    compile time polymorphism  - overloaded  many methods with same name, different forms

        //notes:    run-time polymorphism  - overrode
        BaseBO baseBO = new BaseBO();
        System.out.println(baseBO.test_method());

        EntityType entityType = new EntityType();
        System.out.println(entityType.test_method());
    }
    private static void LessonInstanceVsStatic(){
    //    Math instanceOfMathClass = new Math();   <-- unnecessary instantiation since they're static


        System.out.println(MathHelper.E);
        System.out.println(MathHelper.PI);
        System.out.println(MathHelper.square(4));
    }
    private static void LessonCollectionsLAB(){
        Person thisPerson = new Person();
        VehicleMake fordMake = new VehicleMake("Ford");
        VehicleMake chevyMake = new VehicleMake("Chevy");
        VehicleMake dodgeMake = new VehicleMake("Dodge");
        VehicleModel fusionModel = new VehicleModel("Fusion");
        VehicleModel cavalierModel = new VehicleModel("Cavalier");
        VehicleModel ramModel = new VehicleModel("Ram");
        Vehicle veh1 = new Vehicle(5, 1992, "F123234234543");
        Vehicle veh2 = new Vehicle(7, 1999, "F748463748376");
        Vehicle veh3 = new Vehicle(12, 2005, "T445282394009");

        veh1.setMake(fordMake);
        veh2.setMake(chevyMake);
        veh3.setMake(dodgeMake);
        veh1.setModel(fusionModel);
        veh2.setModel(cavalierModel);
        veh3.setModel(ramModel);

        thisPerson.getVehicles().add(veh1);
        thisPerson.getVehicles().add(veh2);
        thisPerson.getVehicles().add(veh3);


        for(Vehicle vehicle : thisPerson.getVehicles()){
            System.out.println(vehicle.getVehicleId() + " " + vehicle.getYear() + " " + vehicle.getVin() + " " + vehicle.getMake().getVehicleName() + " " + vehicle.getModel().getVehicleModelName() + " " + vehicle.getStatus().getNotes());
        }




    }
    private static void LessonComplexProperties(){
        //notes:    when to use inheritance (should answer the question: 'IS A?')
        //          when to use complex (nested) objects (should answer the question: 'HAS A?')

        EntityType emailWorkType = new EntityType("Work");
        Email myEmail = new Email("bipin@bip.com");
        myEmail.setEmailType(emailWorkType);

        System.out.println(myEmail.getEmailAddress() + " Type:" + myEmail.getEmailType().getEntityTypeName());

        //notes:    collection/list of complex(nested) objects as a property
        Employee myEmployee = new Employee();
        myEmployee.getEmails().add(new Email("test@test.com"));
        myEmployee.getEmails().add(new Email("dan@test.com"));
        myEmployee.getEmails().add(new Email("jason@test.com"));

        for(Email email : myEmployee.getEmails()){
            System.out.println(myEmail.getEmailAddress());
        }

    }
    private static void LessonCollections() {
        //notes:    List<T> - generic type 'T'
        List<Employee> employeeList = new ArrayList<Employee>();

        Employee emp1 = new Employee("Dan", "Simmer");  //index 0
        Employee emp2 = new Employee("James", "McRoberts");  // index 1
        Employee emp3 = new Employee("Sean", "Nilsen");  //  2
        Employee emp4 = new Employee("Adrian", "Ratanyake");  // 3

        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);
        employeeList.add(emp4);

        employeeList.add(new Employee("John", "Doe")); //Condensed the two commands  (4)

        System.out.println(employeeList.get(4).getFullName());

        for(Employee e : employeeList){
            System.out.println(e.getFullName());
        }
    }
    private static void LessonObjectsLAB() {
        Address address1 = new Address(123, "Fake Street", "Apartment #3", "Fake Town");
        Phone phone1 = new Phone(3, 321, 7890394, 5);
        Client client1 = new Client(2, "Awesome Client");
        ClientContact clientContact1 = new ClientContact(2, 4, 2);
        Email email1 = new Email(1, "abc@123.com", 3);
        Employee employee1 = new Employee(4, "Max");
        EmployeeProject employeeProject1 = new EmployeeProject(2, 4, 2, "A great project.");
        Entity entity1 = new Entity(2, "Vehicle");
        EntityType entityType1 = new EntityType("Personal");
        LoyaltyAccount loyaltyAccount1 = new LoyaltyAccount(3, 2, 3, 234535);
        LoyaltyCompany loyaltyCompany1 = new LoyaltyCompany(4, "Delta");
        Person person1 = new Person("Mr.", "Max", "Power");
        Project project1 = new Project(4, "$18/hr");
        ProjectStatus projectStatus1 = new ProjectStatus(4, 28, "It's going great!");
        Review review1 = new Review(3, "The Best Review", 4);
        ReviewData reviewData1 = new ReviewData(6, "This piece of data.");
        Training training1 = new Training(89, "Training in the Mountains");
        TrainingData trainingData1 = new TrainingData(9, "Throwing rocks down the mountain");
        Vehicle vehicle1 = new Vehicle(7, 1999, "F148895044838");
        VehicleMake vehicleMake1 = new VehicleMake(56, "Ford");
        VehicleModel vehicleModel1 = new VehicleModel(34, 56, "Fusion");
        VehicleStatus vehicleStatus1 = new VehicleStatus(22, "Piece of Junk");

        System.out.println(phone1.getFullPhoneNumber());
        System.out.println(address1.getFullAddress());
        System.out.println(vehicle1.getYearAndVin());
        System.out.println(client1.getClientWithId());
        System.out.println(projectStatus1.getProjectStatusWithPercent());
        System.out.println();
        System.out.println(address1.getAddressNumber());
        System.out.println(phone1.getPhoneNumber());
        System.out.println(client1.getClientName());
        System.out.println(clientContact1.getClientId());
        System.out.println(email1.getEmailAddress());
        System.out.println(employee1.getEmployeeId());
        System.out.println(employeeProject1.getEmployeeProjectId());
        System.out.println(entity1.getEntityId());
        System.out.println(entityType1.getEntityTypeName());
        System.out.println(loyaltyAccount1.getLoyaltyAccountId());
        System.out.println(loyaltyCompany1.getLoyaltyCompanyId());
        System.out.println(person1.getFirstName());
        System.out.println(project1.getRate());
        System.out.println(projectStatus1.getNotes());
        System.out.println(review1.getReviewName());
        System.out.println(reviewData1.getReviewDataValue());
        System.out.println(training1.getTrainingName());
        System.out.println(trainingData1.getTrainingDataValue());
        System.out.println(vehicle1.getVin());
        System.out.println(vehicleMake1.getVehicleName());
        System.out.println(vehicleModel1.getVehicleModelName());
        System.out.println(vehicleStatus1.getNotes());



    }
    private static void LessonMethods() {
        //notes:    (method signature/declaration)
        /*
            <access modifier> <instance/static> <return data type> <method name> (<data type> <param name>, <data type> <param name>, ...) {body}
            private             static              void            LessonMethods   (N/A)

            public              instance(blank)     int             getPersonId     (N/A)

            public              instance            void            setPersonId     (int personId)
         */

        //notes:    constructors are special methods with same name as class
        Employee constructorEmployee = new Employee("Logan", "Moen");
        System.out.println(constructorEmployee.getFirstName() + " " + constructorEmployee.getLastName());

        Employee const2Employee = new Employee("Simmer");
        System.out.println(const2Employee.getLastName());

        Employee employeeJames = new Employee("James", "McRoberts");
        System.out.println(employeeJames.getFullName());
    }
    private static void LessonInheritance(){
        //notes:    4 pillars of OOP (Tenets) Encapsulation, Abstraction, Inheritance, Polymorphism

        Employee employeeBip = new Employee();
        employeeBip.setFirstName("Bipin");
        employeeBip.setLastName("Butala");
        employeeBip.setId(3);

        System.out.print(employeeBip.getId() + ": " + employeeBip.getFirstName() + " " + employeeBip.getLastName());


    }
    private static void LessonClassObjects() {
        //notes:    instantiating a new object
        Person myFirstPerson = new Person();
        myFirstPerson.setFirstName("Logan");
        myFirstPerson.setLastName("Moen");
        myFirstPerson.setTitle("Mr.");

        Person mySecondPerson = new Person();
        mySecondPerson.setFirstName("Debbie");
        mySecondPerson.setLastName("Moen");
        mySecondPerson.setTitle("Mrs.");

        System.out.print(myFirstPerson.getTitle() + " ");
        System.out.print(myFirstPerson.getFirstName() + " ");
        System.out.println(myFirstPerson.getLastName());

        System.out.print(mySecondPerson.getTitle() + " ");
        System.out.print(mySecondPerson.getFirstName() + " ");
        System.out.println(mySecondPerson.getLastName());

        //notes:    setting value for inherited (Super) class
        myFirstPerson.setId(3);
        System.out.print(myFirstPerson.getId());

    }
    private static void LessonCalculatorLABInvalid(){
        System.out.println("INVALID");
        try {
            LessonCalculatorLAB();
        } catch (Exception intEx) {
            System.out.println(intEx.toString());
        }
    }
    private static void LessonCalculatorLAB()throws Exception {

            try {
                Scanner reader = new Scanner(System.in);
                System.out.print("Enter a number 0-9: ");

                int input1 = reader.nextInt();

                if (input1 > 9 || input1 < 0) {
                    LessonCalculatorLABInvalid();
                } else {
                    System.out.print("Enter a second number 0-9: ");
                    int input2 = reader.nextInt();
                    if (input2 > 9 || input2 < 0) {
                        LessonCalculatorLABInvalid();
                    } else {
                        System.out.print("Enter an operator (+|-|*|/): ");
                        String operatorInput = reader.next();
                        if (!(operatorInput.equals("+") || operatorInput.equals("-") || operatorInput.equals("*") || operatorInput.equals("/")))

                        {
                            LessonCalculatorLABInvalid();
                        } else {
                            switch (operatorInput) {
                                case "+":
                                    System.out.println(input1 + "+" + input2 + "=" + (input1 + input2));
                                    break;
                                case "-":
                                    System.out.println(input1 + "-" + input2 + "=" + (input1 - input2));
                                    break;
                                case "*":
                                    System.out.println(input1 + "*" + input2 + "=" + (input1 * input2));
                                    break;
                                case "/":
                                    System.out.println(input1 + "/" + input2 + "=" + (input1 / input2) + "&" + (input1 % input2) + "/" + (input2));
                                    break;
                            }
                            LessonCalculatorLAB();

                        }
                    }
                }
            } catch (Exception intEx) {
                throw new Exception("Value entered was not an Integer.", intEx);
            }
        }
    private static void LessonFizzBuzzLAB(){
        int val;
        for(int x = 0; x <= 100; x++){
            val = x;
            if((val % 3) == 0 && val !=0 && (val % 15) != 0)
            System.out.println("Fizz");
            if((val % 5) == 0 && val !=0 && (val % 15) != 0)
            System.out.println("Buzz");
            if((val % 15) == 0 && val !=0)
            System.out.println("FizzBuzz");
            if((val % 5) != 0 && (val % 3) != 0 && (val % 15) != 0)
            System.out.println(val);

        }
    }
    private static void LessonExceptions() throws Exception{
        //todo:     simple unhandled exception
//        String firstName = "Logan";
//        int x = Integer.parseInt(firstName);
//
//        System.out.print("Integer value: ");
//        System.out.println(x);

        //todo:     try - catch block
//        String firstName = "Logan";
//        try {
//            int x = Integer.parseInt(firstName);
//
//            System.out.print("Integer value: ");
//            System.out.println(x);
//        } catch(NumberFormatException ex) {
//            System.out.println("Exception: Invalid Number");
//
//        }
        //todo:     try - catch with multiple catch blocks
//        String firstName = null;
//        try {
//            int x = Integer.parseInt(firstName);
//
//            System.out.print("Integer Value: ");
//            System.out.println(x);
//        }
//        catch (NumberFormatException ex)
//        {
//            System.out.println("Exception: Number Format Error.");
//        }
//        catch (IllegalArgumentException ex)
//        {
//            System.out.println("Exception: String was null or empty");
//        }
//        catch (Exception ex)
//        {
//            System.out.println("Exception: Generic Exception");
//        }

        //todo:     try - catch with multiple catch and finally block

//        String firstName = null;
//        try {
//            int x = Integer.parseInt(firstName);
//
//            System.out.print("Integer Value: ");
//            System.out.println(x);
//        }
//        catch (NumberFormatException ex)
//        {
//            System.out.println("Exception: Number Format Error.");
//        }
//        catch (IllegalArgumentException ex)
//        {
//            System.out.println("Exception: String was null or empty");
//        }
//        catch (Exception ex)
//        {
//            System.out.println("Exception: Generic Exception");
//        }
//        finally
//        {
//            System.out.println("Program has been completed regardless of exceptions.");
//        }

        //todo:     exception object
        //notes:    base exception class

//        String firstName = null;
//        try {
//            int x = Integer.parseInt(firstName);
//
//            System.out.print("Integer Value: ");
//            System.out.println(x);
//        }
//        catch (NumberFormatException ex)
//        {
//            System.out.println("Exception: " + ex.toString());
//        }
//        catch (IllegalArgumentException ex)
//        {
//            System.out.println("Exception: " + ex.toString());
//        }
//        catch (Exception ex)
//        {
//            System.out.println("Exception: " + ex.toString());
//        }
//        finally
//        {
//            System.out.println("Program has been completed regardless of exceptions.");
//        }

        //todo:     throwing an exception
        String firstName = null;
        try {
            int x = Integer.parseInt(firstName);

            System.out.print("Integer value: ");
            System.out.println(x);
        }
        catch (Exception ex)
        {
            throw new Exception("A custom exception from LessonException method.", ex);
        }

    }
    private static void LessonFlowControl() {
        //notes: if-else
        String name = "logan";
        if (name.equals("dan")) {
            System.out.println("correct first name");
            System.out.println("another line");

        }
        else {
            System.out.println("incorrect first name");

            if (name.length() > 10) {
                System.out.println("very long first name.");
            } else if(name.length() > 5){
                System.out.println("long first name.");
            } else {
                System.out.println("short first name.");
            }

        }

        //notes:    CASE-SWITCH
        switch(name)
        {
            case "logan":
                System.out.println("cool first name");
                break;

            case "dan":
            case "danny":
            case "daniel":
                System.out.println("first name is dan, danny, or daniel");
                break;

            default:
                System.out.print("some other first name");
                break;

        }

    }
    private static void LessonOperators() {
        //notes:  plus / minus
        int val = 10;
        System.out.println(val + 10);
        System.out.println(val - 10);

        //notes:    modulus (%) the remainder
        int modVal = 10 % 3 ;  //the remainder of the 10/3 which is 1
        System.out.println(modVal);

        //notes:    increment (++) / decrement (--)
        System.out.println("Increment after: ");
        System.out.println(val++);  //10
        System.out.println(val++);  //11
        System.out.println(val++);  //12
        System.out.println(val++);  //13
        System.out.println(val);  //val = 14

        val = 10;

        System.out.println("Increment before: ");
        System.out.println(++val);  //11
        System.out.println(++val);  //12
        System.out.println(++val);  //13
        System.out.println(++val);  //14
        System.out.println(val);  //val = 14

        val = 10;

        System.out.println("Decrement after: ");
        System.out.println(val--);  //10
        System.out.println(val--);  //9
        System.out.println(val--);  //8
        System.out.println(val--);  //7
        System.out.println(val);  //val = 6

        val = 10;

        System.out.println("Decrement before: ");
        System.out.println(--val);  //9
        System.out.println(--val);  //8
        System.out.println(--val);  //7
        System.out.println(--val);  //6
        System.out.println(val);  //val = 6

        //notes:    logical equals (==) / logical not equal (!=)

        val = 10;
        int anotherVal = 20;

        if(val == anotherVal)
            System.out.println("Equals");
        else
            System.out.println("Not Equals");

        //notes:    logical AND (&&) / logical OR (||)

        if(val == 10 || anotherVal == 10)
            System.out.println("true");
        else
            System.out.println("false");

        //notes:    negation (!)

        if(!(val == 10))
            System.out.println("true");
        else
            System.out.println("false");


    }
    private static void LessonFundamentalsLAB() {
        boolean amIAwesome = true;
        boolean doIHaveASickRide = false;

        byte	TestByte1 = 0;
        byte	TestByte2 = 2;
        byte	TestByte3 = 8;

        byte    bytevalues[] = new byte[]{TestByte1, TestByte2, TestByte3};
        byte    bytemin = bytevalues[0];
        byte    bytemax = bytevalues[0];

        for(int i = 1; i < bytevalues.length; i++){
            if(bytevalues[i] > bytemax)bytemax = bytevalues[i];
            else if(bytevalues[i] < bytemin)bytemin = bytevalues[i];
        }

        System.out.println("Default Value is : " + TestByte1);
        System.out.println("Max Value is : " + bytemax);
        System.out.println("Min Value is : " + bytemin);

        char	TestChar1 = 'b';
        char	TestChar2 = 'a';
        char	TestChar3 = 'c';

        char    charvalues[] = new char[]{TestChar1, TestChar2, TestChar3};
        char    charmin = charvalues[0];
        char    charmax = charvalues[0];

        for(int i = 1; i < charvalues.length; i++){
            if(charvalues[i] > charmax)charmax = charvalues[i];
            else if(charvalues[i] < charmin)charmin = charvalues[i];
        }

        System.out.println("Default Value is : " + TestChar1);
        System.out.println("Max Value is : " + charmax);
        System.out.println("Min Value is : " + charmin);


        short	TestShort1 = 0;
        short	TestShort2 = 5;
        short	TestShort3 = 12;
        short	TestShort4 = 16;

        short    shortvalues[] = new short[]{TestShort1, TestShort2, TestShort3, TestShort4};
        short    shortmin = shortvalues[0];
        short    shortmax = shortvalues[0];

        for(int i = 1; i < shortvalues.length; i++){
            if(shortvalues[i] > shortmax)shortmax = shortvalues[i];
            else if(shortvalues[i] < shortmin)shortmin = shortvalues[i];
        }

        System.out.println("Default Value is : " + TestShort1);
        System.out.println("Max Value is : " + shortmax);
        System.out.println("Min Value is : " + shortmin);

        int		TestInt1 = 2;
        int		TestInt2 = 1;
        int		TestInt3 = 0;
        int		TestInt4 = 8;

        int    intvalues[] = new int[]{TestInt1, TestInt2, TestInt3, TestInt4};
        int    intmin = intvalues[0];
        int    intmax = intvalues[0];

        for(int i = 1; i < intvalues.length; i++){
            if(intvalues[i] > intmax)intmax = intvalues[i];
            else if(intvalues[i] < intmin)intmin = intvalues[i];
        }

        System.out.println("Default Value is : " + TestInt1);
        System.out.println("Max Value is : " + intmax);
        System.out.println("Min Value is : " + intmin);

        long	TestLong1 = 0;
        long	TestLong2 = 4;
        long	TestLong3 = 12;
        long	TestLong4 = 500000000;

        long    longvalues[] = new long[]{TestLong1, TestLong2, TestLong3, TestLong4};
        long    longmin = longvalues[0];
        long    longmax = longvalues[0];

        for(int i = 1; i < longvalues.length; i++){
            if(longvalues[i] > longmax)longmax = longvalues[i];
            else if(longvalues[i] < longmin)longmin = longvalues[i];
        }

        System.out.println("Default Value is : " + TestLong1);
        System.out.println("Max Value is : " + longmax);
        System.out.println("Min Value is : " + longmin);

        float	TestFloat1 = 3.14f;
        float	TestFloat2 = 1.6f;
        float	TestFloat3 = 2.5f;
        float	TestFloat4 = 4.0f;

        float    floatvalues[] = new float[]{TestFloat1, TestFloat2, TestFloat3, TestFloat4};
        float    floatmin = floatvalues[0];
        float    floatmax = floatvalues[0];

        for(int i = 1; i < floatvalues.length; i++){
            if(floatvalues[i] > floatmax)floatmax = floatvalues[i];
            else if(floatvalues[i] < floatmin)floatmin = floatvalues[i];
        }

        System.out.println("Default Value is : " + TestFloat1);
        System.out.println("Max Value is : " + floatmax);
        System.out.println("Min Value is : " + floatmin);

        double	TestDouble1 = 1.0;
        double	TestDouble2 = 2.5;
        double	TestDouble3 = 4.0;
        double	TestDouble4 = 50000.05;

        double    doublevalues[] = new double[]{TestDouble1, TestDouble2, TestDouble3, TestDouble4};
        double    doublemin = doublevalues[0];
        double    doublemax = doublevalues[0];

        for(int i = 1; i < doublevalues.length; i++){
            if(doublevalues[i] > doublemax)doublemax = doublevalues[i];
            else if(doublevalues[i] < doublemin)doublemin = doublevalues[i];
        }

        System.out.println("Default Value is : " + TestDouble1);
        System.out.println("Max Value is : " + doublemax);
        System.out.println("Min Value is : " + doublemin);



        Scanner reader = new Scanner(System.in);
        System.out.print("Enter a number 1-10: ");
        String input = reader.nextLine();
        float floatFromString = Float.parseFloat(input);
        System.out.println(floatFromString + 1.75);
//      Notes: Proof for question #4
        String stringIsJustCharsProof = "Strings Are Just Characters That Get Along";
        int indexOf = stringIsJustCharsProof.indexOf("r");
        System.out.println(indexOf);

        int lastIndexOf = stringIsJustCharsProof.lastIndexOf("t");
        System.out.println(lastIndexOf);
        List<Integer> testIntegerList = new ArrayList<Integer>();
        testIntegerList.add(21051992);
        testIntegerList.add(20021996);
        testIntegerList.add(21052004);
        testIntegerList.add(9051976);
        testIntegerList.add(17071974);

        for(Integer singleInt: testIntegerList){
            System.out.println(singleInt);
        }
        String gameName = "Gopher5";
        int winningNumber1 = 19;
        int winningNumber2 = 30;
        int winningNumber3 = 35;
        int winningNumber4 = 42;
        int winningNumber5 = 56;
        int multiplier = 3;
        int jackpot = 400000;
        String drawDate = "05/21/2017";
        System.out.println("Game : " + gameName);
        System.out.println("Date of Drawing : " + drawDate);
        System.out.println("Winning Numbers : " + winningNumber1 + "-" + winningNumber2 + "-" + winningNumber3 + "-" + winningNumber4 + "-" + winningNumber5 + " x" + multiplier);
        System.out.println("Jackpot : $" + jackpot);


    }
    private static void LessonLists() {
        //notes:    collections / lists
        List<String> myStringCollection = new ArrayList<String>();

        myStringCollection.add("1st String");
        myStringCollection.add("2nd String");
        myStringCollection.add("3rd String");
        myStringCollection.add("4th String");
        myStringCollection.add("5th String");

        System.out.println(myStringCollection);
        for(String singleString : myStringCollection) {
            System.out.println(singleString);
        }

        List<Integer> myIntCollection = new ArrayList<Integer>();

        myIntCollection.add(10);
        myIntCollection.add(20);
        myIntCollection.add(30);
        myIntCollection.add(40);
        myIntCollection.add(50);

        System.out.println(myIntCollection);

        for(int singleInt : myIntCollection) {
            System.out.println(singleInt);
        }

        //notes:    arrays
        String[] myStringArray = new String[6];

        myStringArray[0] = "1st";
        myStringArray[1] = "2nd";
        myStringArray[2] = "3rd";
        myStringArray[3] = "4th";
        myStringArray[4] = "5th";
        myStringArray[5] = "6th";

        System.out.println(myStringArray);

        for(String singleString : myStringArray) {
            System.out.println(singleString);

        }




    }
    private static void LessonStrings() {
        //notes:    strings have a value or not.
        String firstString = "";
        firstString = "something";
        firstString = null;

        if(firstString == null || firstString.isEmpty()) {
            System.out.println("String is empty");
        }
        else {
            System.out.println("String has a value");
        }

        //notes:    immutable - unable to be changed...
        firstString = "another value";  //this creates a new string and deletes the old one

        for(int x = 0; x <= 100; x++) {
            firstString = "new value: " + Integer.toString(x);
            System.out.println(firstString); // creating a new string for each iteration, very inefficient
        }

        StringBuilder myStringBuilder = new StringBuilder();

        for(int x = 0; x <= 100; x++) {
            myStringBuilder.append("new value with string builder: ")
                           .append(Integer.toString(x))
                           .append("\n");
        }

        System.out.println(myStringBuilder);

        //notes:    searching in strings (indexOf, lastIndexOf)
        String myName = "Bipin B";
        /*
            string can be visualized as an array of characters.
             B   i   p   i   n       B
            [0] [1] [2] [3] [4] [5] [6]

            note that the array is zero based (starts at zero)

            character at index 2 is "p"

         */

        int indexOf = myName.indexOf("i");
        System.out.println(indexOf);

        int lastIndexOf = myName.lastIndexOf("i");
        System.out.println(lastIndexOf);

        //notes:    enumerating a string/breaking it up into characters
        String largeString = "This is a longer string than before";
        for(char c : largeString.toCharArray()) {
            System.out.println(c);
        }

        //notes:    substring(beginning index) or substring(beginning index, end index)
        String partOfLargerString = largeString.substring(8, 16);
        System.out.println(partOfLargerString);
    }
    private static void LessonDataTypes() {
        //notes:    primitive data types
        //          int (number)
        //          float (decimal number)
        //          double (larger number)
        //          boolean (true / false)
        //          char (character)

        //notes:    common data types
        boolean myBool = false;
        int myInt = 4;
        String myString = "some words";
        Date myDate = new Date();

        System.out.println(myBool);
        System.out.println(myInt);
        System.out.println(myString);
        System.out.println(myDate);

        //note:     parsing/converting data types
        //note:     string -> int
        String numberString = "321";
        int intFromString = Integer.parseInt(numberString);


        System.out.println(intFromString);

        //note:     int -> string
        int i = 312;
        String stringFromInt = Integer.toString(i);

        System.out.println(stringFromInt);


        //note:     date -> string
        String stringFromDate = myDate.toString();

        System.out.println(stringFromDate);
    }
    private static void LessonVariables() {


        //notes:    declare multiple variables and set
        String lastName = "Butala", firstName = "Bipin";

        //notes:    output to the console
        System.out.println(firstName + " " + lastName);

        //notes:    create a Scanner object
        Scanner reader = new Scanner(System.in);

        //notes:    prompt the user
        System.out.print("Enter your name: ");

        //notes:    read the input from the user and store it in a variable
        String input = reader.nextLine();

        //notes:    print the value back to the screen
        System.out.println("Hello " + input);
    }
}
