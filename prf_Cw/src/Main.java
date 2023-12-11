import java.util.*;
class Main{
    private static Scanner input = new Scanner(System.in);
    private static String[]cred={"sithira","1234"};
    private static String[][] Addsuppliers = new String[0][2];
    private static String[] category = new String [0];
    private static String[][] AddItem = new String[0][6];


    public static boolean checkUserNameValidity(){
        System.out.print("User name :");
        String userName = input.next();

        L1 : if(cred[0].equals(userName)){
            return true;
        }else{
            System.out.print("User name is invalid. please try again! \n ");
            System.out.println("\n");

            return checkUserNameValidity();
        }
    }

    public static void checkPasswordValidity(){
        System.out.print("Password :");
        String pw = input.next();

        L1: if(pw.equals(cred[1])){
            return;
        }else{
            System.out.print("Password is incorrect. please try again!\n");
            checkPasswordValidity();
        }
    }
    public static void clearConsole(){
        final String os = System.getProperty("os.name");
        try {
            if (os.equals("Linux")) {
                System.out.print("\033\143");
            } else if (os.equals("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {

            System.err.println(e.getMessage());
        }
    }
    public static void mainMenu(){

        System.out.println("+---------------------------------------------------------------+");
        System.out.print("|\tWELCOME TO IJSE STOCK MANAGEMENT SYSTEM\t\t\t|\n");
        System.out.println("+---------------------------------------------------------------+\n\n");
        System.out.println("[1] Change the Credentials\t\t [2] Supplier Manage");
        System.out.println("[3] Stock Manage\t\t\t [4] Log Out");
        System.out.println("[5] Exit the System\n");

        System.out.print("Enter an option to continue > ");
        int num=input.nextInt();

        clearConsole();

        if(num==1){
            System.out.println("+-----------------------------------------------------------------------+");
            System.out.print("|\t\t\tCREDENTIAL MANAGE\t\t\t\t|\n");
            System.out.println("+-----------------------------------------------------------------------+\n");

            verifyYourUsername();
        }else if(num==2){
            supplierManageHome();
            clearConsole();
        }else if(num==3){
            StockManagement();
        }else if(num==4){
            System.out.println("+---------------------------------------------------------------+");
            System.out.print("|\t\t\tLOGOUT PAGE\t\t\t\t|\n");
            System.out.println("+---------------------------------------------------------------+\n");
            logoutSystem();
        }else if(num==5){
            System.exit(0);
        }

    }
    public static void verifyYourUsername(){

        System.out.print("Please enter the username to verify it's you : ");
        String userName = input.next();


        if (userName.equals(cred[0])){
            System.out.println("Hey "+cred[0]);
            verifyYourPassword();
        }else {
            System.out.print("Invalid username. please try again ! \n");
            verifyYourUsername();

        }

    }

    public static void verifyYourPassword(){

        System.out.print("Enter your current password : ");
        String passWord=input.next();

        if (passWord.equals(cred[1])){
            changeYourPassword();
        }
        else {
            System.out.println("Incorrect password. Try again!");
            verifyYourPassword();
        }

    }

    public static void changeYourPassword(){
        System.out.print("Enter your new password : ");
        String newPassword=input.next();
        cred[1]=newPassword;
        System.out.print("Password changed successfully! Do you want to go to home page (Y/N) : ");
        char yn=input.next().charAt(0);

        if (yn=='Y' || yn=='y'){
            clearConsole();
            mainMenu();

        }else{
            changeYourPassword();
        }

    }

    public static void logoutSystem(){
        System.out.print("Username : ");
        String userName=input.next();

        if(userName.equals(cred[0])){
            logoutYourPassword();

        } else{
            System.out.println("Incorrect username. Try again!\n");
            logoutSystem();
        }

    }
    public static void logoutYourPassword(){
        System.out.print("Password : ");
        String passWord=input.next();

        if (passWord.equals(cred[1])){
            clearConsole();
            mainMenu();

        } else {
            System.out.println("Incorrect password. Try again!\n");
            logoutYourPassword();
        }
    }
    public static void supplierManageHome(){

        System.out.println("+---------------------------------------------------------------+");
        System.out.print("|\t\t\tSUPPLIER MANAGE\t\t\t\t|\n");
        System.out.println("+---------------------------------------------------------------+\n\n");
        System.out.println("[1] Add Supplier\t\t\t [2] Update Supplier");
        System.out.println("[3] Delete Supplier\t\t\t [4] View Suppliers");
        System.out.println("[5] Search Supplier\t\t\t [6] Home Page\n");

        System.out.print("Enter an option to continue > ");
        int supplierManage=input.nextInt();

        if(supplierManage==1){
            clearConsole();
            AddSupplier();

        }else if(supplierManage==2){
            clearConsole();
            UpdateSupplier();

        }else if(supplierManage==3){
            clearConsole();
            DeleteSupplier();

        }else if(supplierManage==4){
            clearConsole();
            ViewSupplier();

        }else if(supplierManage==5){
            clearConsole();
            SearchSupplier();

        }else if(supplierManage==6){
            clearConsole();
            HomePage();

        }
    }
    public static  String[][] grow(){
        String[][]temp = new String[Addsuppliers.length+1][2];
        for (int i = 0; i < Addsuppliers.length; i++){
            for (int j = 0; j < Addsuppliers[i].length; j++){
                temp[i][j]=Addsuppliers[i][j];
            }
        }
        return temp;
    }

    public static void AddSupplier(){

        System.out.println("+---------------------------------------------------------------+");
        System.out.print("|\t\t\tADD SUPPLIER\t\t\t\t|\n");
        System.out.println("+---------------------------------------------------------------+\n\n");

        addingSupplier();


    }
    public static void addingSupplier(){

        Addsuppliers=grow();
        L1: while(true) {
            System.out.print("Suppier ID : ");
            String SupplierId= input.next();

            for (int i=0;i<Addsuppliers.length;i++){
                if (SupplierId.equals(Addsuppliers[i][0])){
                    System.out.println("Already exists. Try another supplier id.");
                    break L1;
                }
            }
            Addsuppliers[Addsuppliers.length-1][0]=SupplierId;
            System.out.print("Supplier Name : ");
            String suppliername= input.next();
            Addsuppliers[Addsuppliers.length-1][1]= suppliername;

            System.out.print("Added successfully! Do you want to add another supplier(Y/N)? : ");
            char yn= input.next().charAt(0);

            if (yn=='Y'||yn=='y'){
                clearConsole();
                AddSupplier();
            }
            else if (yn=='N'||yn=='n'){
                clearConsole();
                supplierManageHome();

            }

        }
    }

    public static void UpdateSupplier(){

        System.out.println("+---------------------------------------------------------------+");
        System.out.print("|\t\t\tUPDATE SUPPLIER\t\t\t\t|\n");
        System.out.println("+---------------------------------------------------------------+\n\n");

        updateing();
    }
    public static void updateing(){
        L1:	while(true){
            System.out.print("Supplier Id :");
            String Sp = input.next();

            for (int i = 0; i < Addsuppliers.length; i++){
                if(Sp.equals(Addsuppliers[i][0])){
                    System.out.print("Supplier name : "+Addsuppliers[i][1]+"\n");
                    System.out.print("Enter the new supplier name :");
                    String newName = input.next();

                    Addsuppliers[i][1]=newName;
                    System.out.print("Update Successfully! Do you want to update another supplier ?(Y/N)");
                    char yn = input.next().charAt(0);

                    if (yn=='Y'||yn=='y'){
                        clearConsole();
                        UpdateSupplier();
                        clearConsole();
                    }
                    else if (yn=='N'||yn=='n'){
                        clearConsole();
                        supplierManageHome();

                    }

                }
            }
            System.out.print("can't find supplier id. try again! \n");

            continue L1;

        }
    }
    public static void DeleteSupplier(){

        System.out.println("+---------------------------------------------------------------+");
        System.out.print("|\t\t\tDELETE SUPPLIER\t\t\t\t|\n");
        System.out.println("+---------------------------------------------------------------+\n\n");

        while(true){
            System.out.print("Supplier ID :");
            String supId = input.next();

            for (int i = 0; i < Addsuppliers.length; i++){
                if(supId.equals(Addsuppliers[i][0])){
                    Addsuppliers=deletingSupplier(i);
                    System.out.print("Delete successfully! Do you want to delete another supplier ?(Y/N)");
                    char yn = input.next().charAt(0);

                    if((yn=='Y') || (yn=='y')){
                        clearConsole();
                        DeleteSupplier();
                    }else if((yn=='N') || (yn=='n')){
                        clearConsole();
                        supplierManageHome();
                    }
                }
            }
            System.out.print("\nCan't find supplier id.");
        }
    }

    public static String[][] deletingSupplier(int i){

        String[][]temp = new String[Addsuppliers.length-1][2];

        for (int j = 0; j <temp.length ; j++){
            for (int k = 0; k < temp[j].length; k++){
                if(j<i){
                    temp[j][k]=Addsuppliers[j][k];
                }
                else{
                    temp[j][k]=Addsuppliers[j+1][k];
                }
            }

        }
        return temp;
    }


    public static void ViewSupplier(){

        System.out.println("+---------------------------------------------------------------+");
        System.out.print("|\t\t\tVIEW SUPPLIER\t\t\t\t|\n");
        System.out.println("+---------------------------------------------------------------+\n\n");


        System.out.println("+-----------------------+-----------------------+");
        System.out.println("|       SUPPLIER ID     |      SUPPLIER NAME    |");
        System.out.println("+-----------------------+-----------------------+");

        for (int i = 0; i < Addsuppliers.length; i++){
            System.out.println("|\t"+Addsuppliers[i][0]+"\t\t|\t"+Addsuppliers[i][1]+"\t\t|");
        }
        System.out.println("+-------------------------+---------------------+");

        System.out.print("Do you want to go supplier manage page ( Y/N ) : ");
        char viewop=input.next().charAt(0);

        if((viewop=='Y') || (viewop=='y')){
            clearConsole();
            supplierManageHome();
        }else if((viewop=='N') || (viewop=='n')){
            clearConsole();
            System.exit(0);
        }
    }

    public static void SearchSupplier(){

        System.out.println("+---------------------------------------------------------------+");
        System.out.print("|\t\t\tSEARCH SUPPLIER\t\t\t\t|\n");
        System.out.println("+---------------------------------------------------------------+\n\n");

        L1:	while(true){
            System.out.print("Supplier Id :");
            String Sp = input.next();

            for (int i = 0; i < Addsuppliers.length; i++){
                if(Sp.equals(Addsuppliers[i][0])){
                    System.out.print("Supplier name : "+Addsuppliers[i][1]+"\n");

                    System.out.print("\nadded Successfully! Do you want to search another supplier ?(Y/N)");
                    char yn = input.next().charAt(0);

                    if (yn=='Y'||yn=='y'){
                        clearConsole();
                        SearchSupplier();
                        clearConsole();
                    }
                    else if (yn=='N'||yn=='n'){
                        clearConsole();
                        supplierManageHome();

                    }

                }
            }
            System.out.print("can't find supplier id. try again! \n");

            continue L1;

        }


    }
    public static void HomePage(){
        mainMenu();
    }
    public static void StockManagement(){

        System.out.println("+-----------------------------------------------------------------------+");
        System.out.print("|\t\t\tSTOCK MANAGEMENT\t\t\t\t|\n");
        System.out.println("+-----------------------------------------------------------------------+\n\n");
        System.out.println("[1] Manage Item Categories\t\t\t [2] Add Item");
        System.out.println("[3] Get Item Supplier Wise\t\t\t [4] View Items");
        System.out.println("[5] Rank Item Per Unit Price\t\t\t [6] Home Page\n");

        System.out.print("Enter an option to continue >");
        int op = input.nextInt();

        if(op==1){
            clearConsole();
            manageItemCategories();

        }else if(op==2){
            clearConsole();
            addItem();

        }else if(op==3){
            clearConsole();
            getItemSupplierWise();

        }else if(op==4){
            clearConsole();
            viewItem();

        }else if(op==5){
            clearConsole();
            rankItemPerUnit();

        }else if(op==6){
            clearConsole();
            homePage();
        }


    }

    public static void manageItemCategories(){

        System.out.println("+-----------------------------------------------------------------------+");
        System.out.print("|\t\t\tMANAGE ITEM CATEGORIES\t\t\t\t|\n");
        System.out.println("+-----------------------------------------------------------------------+\n");
        System.out.println("[1] Add New Item Category\t\t\t [2] Delete Item Category");
        System.out.println("[3] Update Item Category\t\t\t [4] Stock Management");

        System.out.println();

        System.out.print("Enter an option to continue > ");
        int supplierManage=input.nextInt();

        if(supplierManage==1){
            clearConsole();
            AddNewItemCategory();

        }else if(supplierManage==2){
            clearConsole();
            DeleteItemCategory();

        }else if(supplierManage==3){
            clearConsole();
            UpdateItemCategory();
        }else if(supplierManage==4){
            clearConsole();
            StockManagement();
        }

    }

    public static void AddNewItemCategory(){

        System.out.println("+---------------------------------------------------------------+");
        System.out.print("|\t\t\tADD NEW ITEM CATEGORY\t\t\t\t|\n");
        System.out.println("+---------------------------------------------------------------+\n");

        addingNewItemCategory();
    }

    public static  String[] growItem(){
        String[]temp = new String[category.length+1];
        for (int i = 0; i < category.length; i++){
            temp[i]=category[i];
        }

        return temp;
    }


    public static void addingNewItemCategory(){
        category=growItem();

        L1: while(true){
            System.out.print("Item Category : ");
            String Icat= input.next();

            for (int i=0;i<category.length;i++){
                if (Icat.equals(category[i])){
                    System.out.println("Already exists. Try another item category.");
                    break L1;
                }
            }
            category[category.length-1]=Icat;

            System.out.print("\nAdded successfully! Do you want to add another item category(Y/N)? : ");
            char yn= input.next().charAt(0);

            if (yn=='Y'||yn=='y'){
                clearConsole();
                AddNewItemCategory();
            }
            else if (yn=='N'||yn=='n'){
                clearConsole();
                manageItemCategories();

            }

        }
    }

    public static void DeleteItemCategory(){
        System.out.println("+------------------------------------------------------------------------------+");
        System.out.println("|\t\t\t\tDELETE ITEM CATEGORY\t\t\t\t\t|");
        System.out.println("+------------------------------------------------------------------------------+");
        System.out.println();

        while(true){
            System.out.print("Item Category :");
            String Icat= input.next();

            for (int i = 0; i < category.length; i++){
                if(Icat.equals(category[i])){
                    category=deletingItemCategory(i);
                    System.out.print("Delete successfully! Do you want to delete another item category ?(Y/N)");
                    char yn = input.next().charAt(0);

                    if((yn=='Y') || (yn=='y')){
                        clearConsole();
                        deletingItemCategory(i);
                    }else if((yn=='N') || (yn=='n')){
                        clearConsole();
                        manageItemCategories();
                    }
                }
            }
            System.out.print("\nCan't find item category.");
        }
    }


    public static String[]deletingItemCategory(int i){

        String[]temp = new String[category.length-1];

        for (int j = 0; j < temp.length; j++){
            if(j<i){
                temp[i]=category[i];
            }
            else if(j>i){
                temp[i]=category[i+1];
            }
        }


        return temp;
    }


    public static void UpdateItemCategory(){
        System.out.println("+------------------------------------------------------------------------------+");
        System.out.println("|\t\t\t\tUPDATE ITEM CATEGORY\t\t\t\t\t|");
        System.out.println("+------------------------------------------------------------------------------+");
        System.out.println();

        updateingItemCategory();
    }

    public static void updateingItemCategory(){
        L1:
        while(true) {
            System.out.print("Item Category Name : ");
            String catName= input.next();

            for (int i = 0; i < category.length; i++){
                if(catName.equals(category[i])){
                    System.out.print("Enter the new category name :");
                    String newCatName = input.next();

                    category[i]=newCatName;
                    System.out.print("\nUpdate Successfully! Do you want to update another category ?(Y/N)");
                    char yn = input.next().charAt(0);

                    if (yn=='Y'||yn=='y'){
                        updateingItemCategory();
                        clearConsole();
                    }
                    else if (yn=='N'||yn=='n'){
                        clearConsole();
                        manageItemCategories();
                    }
                }
            }
            System.out.print("\ncan't find category. try again! ");

            continue L1;

        }
    }


    public static void addItem(){

        System.out.println("+---------------------------------------------------------------+");
        System.out.print("|\t\t\tADD ITEM\t\t\t\t|\n");
        System.out.println("+---------------------------------------------------------------+\n");

        if(category.length<1){
            System.out.print("OOPS! It seems that you don't have any item category in the system.\nDo you want to add a new item category?(Y/N) ");
            char yn = input.next().charAt(0);

            if((yn=='Y') || (yn=='y')){
                clearConsole();
                AddNewItemCategory();
            }else if((yn=='N') || (yn=='n')){
                clearConsole();
                StockManagement();
            }
        }else {
            if(Addsuppliers.length<1){
                System.out.print("OOPS! It seems that you don't have any supplier in the system.\nDo you want to add a supplier?(Y/N) ");
                char yn = input.next().charAt(0);

                if((yn=='Y') || (yn=='y')){
                    clearConsole();
                    AddSupplier();

                }else if((yn=='N') || (yn=='n')){
                    clearConsole();
                    StockManagement();
                }
            }
            else{
                addingItem();
            }
        }
    }

    public static void getItemSupplierWise(){
        System.out.println("+---------------------------------------------------------------+");
        System.out.print("|\t\t\tGET ITEM SUPPLIER WISE\t\t\t|\n");
        System.out.println("+---------------------------------------------------------------+\n");

        L1:	while(true){
            System.out.print("Supplier Id :");
            String supId = input.next();

            for (int i = 0; i < Addsuppliers.length; i++){
                if(supId.equals(Addsuppliers[i][0])){
                    System.out.print("Supplier Name :"+Addsuppliers[i][1]+"\n\n");
                    System.out.printf("+---------------------------------------------------------------+%n");
                    System.out.printf("| %8s | %10s | %8s | %8s | %8s |%n","ITEM CODE", "DESCRIPTION", "UNIT PRICE", "QTY ON HAND", "CATEGORY");
                    System.out.printf("+---------------------------------------------------------------+%n");

                    for (int j = 0; j < AddItem.length; j++){
                        if(supId.equals(AddItem[j][1])){
                            System.out.printf("| %9s | %11s | %10s | %11s | %8s |%n",AddItem[j][0],AddItem[j][3],AddItem[j][4],AddItem[j][5],AddItem[i][2]);
                        }
                    }
                    System.out.printf("+---------------------------------------------------------------+%n");

                    System.out.print("Search successfully. Do you want to search another supplier id.(Y/N)");
                    char yn = input.next().charAt(0);

                    if((yn=='Y') || (yn=='y')){
                        clearConsole();
                        getItemSupplierWise();
                    }else if((yn=='N') || (yn=='n')){
                        clearConsole();
                        StockManagement();
                    }
                }
            }

            System.out.print("Can't find supplier id . try again!");
            continue L1;

        }



    }

    public static void viewItem(){
        System.out.println("+--------------------------------------------------------------------+");
        System.out.print("|\t\t\tVIEW ITEM\t\t\t\t     |\n");
        System.out.println("+--------------------------------------------------------------------+\n");

        for (int i = 0; i < category.length; i++){
            System.out.print(category[i]+" :\n");

            System.out.printf("+-----------------------------------------+%n");
            System.out.printf("| %5s | %5s | %8s | %6s | %3s |%n","SID", "CODE", "DESC", "PRICE", "QTY");
            System.out.printf("+-----------------------------------------+%n");

            for (int j = 0; j < AddItem.length; j++){
                if(AddItem[j][2].equals(category[i])){
                    System.out.printf("| %5s | %5s | %8s | %6s | %3s |%n",AddItem[j][1],AddItem[j][0],AddItem[j][3],AddItem[j][4],AddItem[j][5]);
                }
            }
            System.out.printf("+-----------------------------------------+%n%n");
        }
        while(true){
            System.out.print("Do you want to go Stock management ? (Y/N)");
            char yn = input.next().charAt(0);

            if((yn=='Y') || (yn=='y')){
                clearConsole();
                StockManagement();
            }else if((yn=='N') || (yn=='n')){
                clearConsole();
                System.exit(0);
            }
        }

    }

    public static void rankItemPerUnit(){

        System.out.println("+--------------------------------------------------------------------------+");
        System.out.print("|\t\t\tRANK ITEM PER UNIT PRICE\t\t\t\t|\n");
        System.out.println("+--------------------------------------------------------------------------+\n");

        rankingUnit();


    }
    public static void rankingUnit(){

        String sr=null;
        for (int i = 0; i < AddItem.length-1; i++){
            for (int j = 0; j < AddItem[i].length; j++){
                if(Integer.parseInt(AddItem[i][4])>Integer.parseInt(AddItem[i+1][4])){
                    sr=AddItem[i+1][j];
                    AddItem[i+1][j]=AddItem[i][j];
                    AddItem[i][j]=sr;
                }
            }
        }
        System.out.printf("+----------------------------------------------------+%n");
        System.out.printf("| %5s | %5s | %8s | %6s | %3s | %8s |%n", "SID", "CODE", "DESC", "PRICE", "QTY", "CAT");
        System.out.printf("+----------------------------------------------------+%n");

        for (int k = 0; k < AddItem.length; k++){
            System.out.printf("| %5s | %5s | %8s | %6s | %3s | %8s |%n",AddItem[k][1],AddItem[k][0],AddItem[k][3],AddItem[k][4],AddItem[k][5],AddItem[k][2]);
        }
        System.out.printf("+----------------------------------------------------+%n");

        System.out.print("Do you want to go stock manage ? (Y/N)");
        char yn = input.next().charAt(0);

        if((yn=='Y') || (yn=='y')){
            clearConsole();
            StockManagement();
        }else if((yn=='N') || (yn=='n')){
            clearConsole();
            mainMenu();
        }

    }
    public static void homePage(){

        mainMenu();
    }
    public static String[][] growItemCode(){
        String[][]temp = new String[AddItem.length+1][6];
        for (int i = 0; i < AddItem.length; i++){
            for (int j = 0; j < AddItem[i].length; j++){
                temp[i][j]=AddItem[i][j];
            }

        }
        return temp;
    }


    public static void addingItem(){

        AddItem=growItemCode();

        L1:	while(true){
            System.out.print("Item code  :");
            String itemCode = input.next();

            for (int i = 0; i < AddItem.length; i++){
                if(itemCode.equals(AddItem[i][0])){
                    System.out.print("Item code already exsist! try again\n");
                    break L1;
                }

            }
            AddItem[AddItem.length-1][0]=itemCode;


            System.out.println("Supplier List : ");
            System.out.printf("+-------------------------------------+%n");
            System.out.printf("| %3s | %12s | %14s |%n","#","SUPPLIER ID","SUPPLIER NAME");
            System.out.printf("+-------------------------------------+%n");

            for (int j = 0; j < Addsuppliers.length; j++){
                System.out.printf("| %3s | %12s | %14s |%n",(j+1),Addsuppliers[j][0],Addsuppliers[j][1]);
            }
            System.out.printf("+-------------------------------------+%n");


            System.out.print("Enter the supplier number > ");
            int num = input.nextInt();

            for (int j = 0; j< Addsuppliers.length; j++){
                if((num>0) && (num<=Addsuppliers.length)){
                    AddItem[AddItem.length-1][1]=Addsuppliers[num-1][0];
                }
            }

            System.out.print("Item Categories :");
            System.out.println();
            System.out.printf("+-----------------------------+%n");
            System.out.printf("| %9s | %15s |%n","#","CATEGORY NAME");
            System.out.printf("+-----------------------------+%n");


            for (int k = 0; k < category.length; k++){
                System.out.printf("| %9s | %15s |%n",(k+1),category[k]);
            }
            System.out.printf("+-----------------------------+%n");


            System.out.println();

            System.out.print("Enter the category number >");
            int catNum = input.nextInt();


            System.out.println();

            System.out.print("Description  :");
            String desc = input.next();

            System.out.print("Unit price   :");
            String unitP = input.next();

            System.out.print("Qty on hand  :");
            String qty = input.next();

            AddItem[AddItem.length-1][2]=category[catNum-1];
            AddItem[AddItem.length-1][3]=desc;
            AddItem[AddItem.length-1][4]=unitP;
            AddItem[AddItem.length-1][5]=qty;

            System.out.print("added successfully . Do you want to add another item ? (Y/N)");
            char yn = input.next().charAt(0);

            if((yn=='Y') || (yn=='y')){
                clearConsole();
                addItem();
            }else if((yn=='N') || (yn=='n')){
                clearConsole();
                StockManagement();
            }
        }

    }

    public static void main(String args[]){


        System.out.println("+---------------------------------------------------------------+");
        System.out.print("|\t\t\tLOGIN PAGE\t\t\t\t|\n");
        System.out.println("+---------------------------------------------------------------+\n");

        boolean isMatched = checkUserNameValidity();
        checkPasswordValidity();

        clearConsole();

        mainMenu();
    }
}



